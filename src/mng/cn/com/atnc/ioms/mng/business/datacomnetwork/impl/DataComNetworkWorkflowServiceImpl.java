package cn.com.atnc.ioms.mng.business.datacomnetwork.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetwork;
import cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkManager;
import cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkWorkflowService;

/**
 * 流程图实现类
 *
 * @author Wang Zhicheng
 * @date 2015年10月20日 上午10:24:27
 * @since 1.0.0
 */
@Transactional
@Service
public class DataComNetworkWorkflowServiceImpl implements
             IDataComNetworkWorkflowService {

	private static Logger logger = LoggerFactory.getLogger(DataComNetworkWorkflowServiceImpl.class);
	@Autowired
	private IDataComNetworkManager dataComNetworkManager;
	@Resource(name = "runtimeService")
	private RuntimeService runtimeService;
	@Resource(name = "taskService")
	protected TaskService taskService;
	@Resource(name = "historyService")
	protected HistoryService historyService;
	@Resource(name = "repositoryService")
	protected RepositoryService repositoryService;
	@Resource(name = "identityService")
	private IdentityService identityService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.atnc.pcsp.mng.KuSatellite.ITempCircuitWorkflowService#startWorkflow
	 * (cn.com.atnc.pcsp.entity.KuSatellite.KuSatellite, java.util.Map)
	 */
	@Override
	public ProcessInstance startWorkflow(DataComNetwork entity,
			Map<String, Object> variables) {
		String businessKey = entity.getId().toString();
		ProcessInstance processInstance = null;
		try {
			// 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
			identityService.setAuthenticatedUserId(entity.getApplyBaseInfo().getApplyUser().getId());
			processInstance = runtimeService.startProcessInstanceByKey(
					"DataComNetworkProcess", businessKey, variables);
			String processInstanceId = processInstance.getId();
			entity.setProcessInstanceId(processInstanceId);
			Task task = this.getTaskByProcessInstaceId(processInstanceId);
			entity.setTaskName(task.getName());
			logger.debug("task.getAssignee():" + task.getAssignee());
			// entity.setCurrentAuditer(clientService.findByID(task.getAssignee())
			// .getRealName());
			dataComNetworkManager.save(entity);
			logger.debug(
					"start process of {key={}, bkey={}, pid={}, variables={}}",
					new Object[] { "DataComNetworkProcess", businessKey,
							processInstanceId, variables });
		} finally {
			identityService.setAuthenticatedUserId(null);
		}
		return processInstance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.atnc.pcsp.mng.KuSatellite.ITempCircuitWorkflowService#findTodoTasks
	 * (java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DataComNetwork> findTodoTasks(String userId) {
		List<DataComNetwork> results = new ArrayList<DataComNetwork>();
		List<Task> tasks = new ArrayList<Task>();

		// 根据当前人的ID查询活动任务
		TaskQuery todoQuery = taskService.createTaskQuery()
				.processDefinitionKey("DataComNetworkProcess").taskAssignee(userId)
				.active().orderByTaskCreateTime().asc().orderByTaskCreateTime()
				.desc();
		List<Task> todoList = todoQuery.list();

		// 根据当前人的ID查询暂停（系统内用户申请撤销后置为暂停）任务
		TaskQuery suspendQuery = taskService.createTaskQuery()
				.processDefinitionKey("DataComNetworkProcess").taskAssignee(userId)
				.suspended().orderByTaskCreateTime().asc()
				.orderByTaskCreateTime().desc();
		List<Task> suspendList = suspendQuery.list();

		// 根据当前人未签收的任务
		TaskQuery claimQuery = taskService.createTaskQuery()
				.processDefinitionKey("DataComNetworkProcess").taskCandidateUser(userId)
				.active().orderByTaskCreateTime().asc().orderByTaskCreateTime()
				.desc();
		List<Task> unsignedTasks = claimQuery.list();

		// 合并
		tasks.addAll(todoList);
		tasks.addAll(unsignedTasks);
		tasks.removeAll(suspendList);
		logger.debug("todoList:" + todoList.size());
		logger.debug("unsignedTasks:" + unsignedTasks.size());

		// 根据流程的业务ID查询实体并关联
		if (tasks.size() > 0) {
			for (Task task : tasks) {
				String processInstanceId = task.getProcessInstanceId();
				ProcessInstance processInstance = runtimeService
						.createProcessInstanceQuery()
						.processInstanceId(processInstanceId).active()
						.singleResult();
				String businessKey = processInstance.getBusinessKey();
				if (businessKey == null) {
					continue;
				}
				logger.debug("new String(businessKey):"
						+ new String(businessKey));
				DataComNetwork DataComNetwork = dataComNetworkManager.findById(new String(businessKey));
				if (DataComNetwork != null) {
					DataComNetwork.setTask(task);
					DataComNetwork.setProcessDefinition(getProcessDefinition(processInstance.getProcessDefinitionId()));
					DataComNetwork.setProcessInstance(processInstance);
					results.add(DataComNetwork);
				}
			}
		}
		logger.debug("results:" + results.size());
		return results;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DataComNetwork> findRunningProcessInstaces() {
		List<DataComNetwork> results = new ArrayList<DataComNetwork>();
		ProcessInstanceQuery query = runtimeService
				.createProcessInstanceQuery()
				.processDefinitionKey("DataComNetworkProcess").active()
				.orderByProcessInstanceId().desc();
		List<ProcessInstance> list = query.list();

		// 关联业务实体
		for (ProcessInstance processInstance : list) {
			String businessKey = processInstance.getBusinessKey();
			if (businessKey == null) {
				continue;
			}
			DataComNetwork DataComNetwork = dataComNetworkManager.findById(new String(businessKey));
			DataComNetwork.setProcessInstance(processInstance);
			DataComNetwork.setProcessDefinition(getProcessDefinition(processInstance
							.getProcessDefinitionId()));
			results.add(DataComNetwork);

			// 设置当前任务信息
			List<Task> tasks = taskService.createTaskQuery()
					.processInstanceId(processInstance.getId()).active()
					.orderByTaskCreateTime().desc().listPage(0, 1);
			DataComNetwork.setTask(tasks.get(0));
		}
		return results;
	}

	@Override
	public List<DataComNetwork> findRunningProcessInstaces(String userId) {
		// TODO Auto-generated method stub
		List<DataComNetwork> results = new ArrayList<DataComNetwork>();
		ProcessInstanceQuery query = runtimeService
				.createProcessInstanceQuery()
				.processDefinitionKey("DataComNetworkProcess").active()
				.orderByProcessInstanceId().desc();
		query.variableValueEquals("applyUserId", userId);
		List<ProcessInstance> list = query.list();

		// 关联业务实体
		for (ProcessInstance processInstance : list) {
			String businessKey = processInstance.getBusinessKey();
			if (businessKey == null) {
				continue;
			}
			DataComNetwork DataComNetwork = dataComNetworkManager.findById(new String(businessKey));
			DataComNetwork.setProcessInstance(processInstance);
			DataComNetwork.setProcessDefinition(getProcessDefinition(processInstance
							.getProcessDefinitionId()));
			results.add(DataComNetwork);

			// 设置当前任务信息
			List<Task> tasks = taskService.createTaskQuery()
					.processInstanceId(processInstance.getId()).active()
					.orderByTaskCreateTime().desc().listPage(0, 1);
			DataComNetwork.setTask(tasks.get(0));
		}
		return results;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.mng.KuSatellite.ITempCircuitWorkflowService#
	 * findFinishedProcessInstaces()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DataComNetwork> findFinishedProcessInstaces() {
		List<DataComNetwork> results = new ArrayList<DataComNetwork>();
		HistoricProcessInstanceQuery query = historyService
				.createHistoricProcessInstanceQuery()
				.processDefinitionKey("DataComNetworkProcess").finished()
				.orderByProcessInstanceEndTime().asc();
		List<HistoricProcessInstance> list = query.list();

		// 关联业务实体
		for (HistoricProcessInstance historicProcessInstance : list) {
			String businessKey = historicProcessInstance.getBusinessKey();
			DataComNetwork DataComNetwork = dataComNetworkManager.findById(new String(businessKey));
			DataComNetwork.setProcessDefinition(getProcessDefinition(historicProcessInstance
							.getProcessDefinitionId()));
			DataComNetwork.setHistoricProcessInstance(historicProcessInstance);
			results.add(DataComNetwork);
		}
		return results;
	}

	@Override
	public List<DataComNetwork> findFinishedProcessInstaces(String userId) {
		// TODO Auto-generated method stub
		List<DataComNetwork> results = new ArrayList<DataComNetwork>();
		HistoricProcessInstanceQuery query = historyService
				.createHistoricProcessInstanceQuery()
				.processDefinitionKey("DataComNetworkProcess").finished()
				.orderByProcessInstanceEndTime().asc();
		query.variableValueEquals("applyUserId", userId);
		List<HistoricProcessInstance> list = query.list();

		// 关联业务实体
		for (HistoricProcessInstance historicProcessInstance : list) {
			String businessKey = historicProcessInstance.getBusinessKey();
			DataComNetwork DataComNetwork = dataComNetworkManager.findById(new String(businessKey));
			DataComNetwork.setProcessDefinition(getProcessDefinition(historicProcessInstance
							.getProcessDefinitionId()));
			DataComNetwork.setHistoricProcessInstance(historicProcessInstance);
			results.add(DataComNetwork);
		}
		return results;
	}

	protected ProcessDefinition getProcessDefinition(String processDefinitionId) {
		ProcessDefinition processDefinition = repositoryService
				.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
		return processDefinition;
	}

	@Override
	public void complete(String taskID, Map<String, Object> taskVariables) {
		taskService.complete(taskID, taskVariables);
	}

	@Override
	public void claim(String taskId, String userId) {
		taskService.claim(taskId, userId);
	}

	@Override
	public Task getTaskByProcessInstaceId(String processInstanceId) {
		List<Task> list = taskService.createTaskQuery()
				.processInstanceId(processInstanceId).list();
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public void delete(String taskId) {
		taskService.deleteTask(taskId);
	}
}
