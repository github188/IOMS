package cn.com.atnc.ioms.mng.business.satellite.impl;

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

import cn.com.atnc.ioms.entity.business.satellite.KuSatellite;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteService;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteWorkflowService;

/**
 * 
 * 类说明：
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月27日下午7:34:47
 * @version:1.0
 */
@Transactional
@Service
public class KuSatelliteWorkflowServiceImpl implements
		IKuSatelliteWorkflowService {

	private static Logger logger = LoggerFactory
			.getLogger(KuSatelliteWorkflowServiceImpl.class);
	@Autowired
	private IKuSatelliteService kuSatelliteService;
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
	public ProcessInstance startWorkflow(KuSatellite entity,
			Map<String, Object> variables) {
		String businessKey = entity.getId().toString();
		ProcessInstance processInstance = null;
		try {
			// 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
			identityService.setAuthenticatedUserId(entity.getApplyBaseInfo().getApplyUser().getId());
			processInstance = runtimeService.startProcessInstanceByKey(
					"KuSatellite", businessKey, variables);
			String processInstanceId = processInstance.getId();
			entity.setProcessInstanceId(processInstanceId);
			Task task = this.getTaskByProcessInstaceId(processInstanceId);
			entity.setTaskName(task.getName());
			logger.debug("task.getAssignee():" + task.getAssignee());
			// entity.setCurrentAuditer(clientService.findByID(task.getAssignee())
			// .getRealName());
			kuSatelliteService.add(entity);
			logger.debug(
					"start process of {key={}, bkey={}, pid={}, variables={}}",
					new Object[] { "KuSatellite", businessKey,
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
	public List<KuSatellite> findTodoTasks(String userId) {
		List<KuSatellite> results = new ArrayList<KuSatellite>();
		List<Task> tasks = new ArrayList<Task>();

		// 根据当前人的ID查询活动任务
		TaskQuery todoQuery = taskService.createTaskQuery()
				.processDefinitionKey("KuSatellite").taskAssignee(userId)
				.active().orderByTaskCreateTime().asc().orderByTaskCreateTime()
				.desc();
		List<Task> todoList = todoQuery.list();

		// 根据当前人的ID查询暂停（系统内用户申请撤销后置为暂停）任务
		TaskQuery suspendQuery = taskService.createTaskQuery()
				.processDefinitionKey("KuSatellite").taskAssignee(userId)
				.suspended().orderByTaskCreateTime().asc()
				.orderByTaskCreateTime().desc();
		List<Task> suspendList = suspendQuery.list();

		// 根据当前人未签收的任务
		TaskQuery claimQuery = taskService.createTaskQuery()
				.processDefinitionKey("KuSatellite").taskCandidateUser(userId)
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
				KuSatellite KuSatellite = kuSatelliteService
						.getKuSatelliteById(new String(businessKey));
				if (KuSatellite != null) {
					KuSatellite.setTask(task);
					KuSatellite
							.setProcessDefinition(getProcessDefinition(processInstance
									.getProcessDefinitionId()));
					KuSatellite.setProcessInstance(processInstance);
					results.add(KuSatellite);
				}
			}
		}
		logger.debug("results:" + results.size());
		return results;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.mng.KuSatellite.ITempCircuitWorkflowService#
	 * findRunningProcessInstaces()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<KuSatellite> findRunningProcessInstaces() {
		List<KuSatellite> results = new ArrayList<KuSatellite>();
		ProcessInstanceQuery query = runtimeService
				.createProcessInstanceQuery()
				.processDefinitionKey("KuSatellite").active()
				.orderByProcessInstanceId().desc();
		List<ProcessInstance> list = query.list();

		// 关联业务实体
		for (ProcessInstance processInstance : list) {
			String businessKey = processInstance.getBusinessKey();
			if (businessKey == null) {
				continue;
			}
			KuSatellite KuSatellite = kuSatelliteService
					.getKuSatelliteById(new String(businessKey));
			KuSatellite.setProcessInstance(processInstance);
			KuSatellite
					.setProcessDefinition(getProcessDefinition(processInstance
							.getProcessDefinitionId()));
			results.add(KuSatellite);

			// 设置当前任务信息
			List<Task> tasks = taskService.createTaskQuery()
					.processInstanceId(processInstance.getId()).active()
					.orderByTaskCreateTime().desc().listPage(0, 1);
			KuSatellite.setTask(tasks.get(0));
		}
		return results;
	}

	@Override
	public List<KuSatellite> findRunningProcessInstaces(String userId) {
		// TODO Auto-generated method stub
		List<KuSatellite> results = new ArrayList<KuSatellite>();
		ProcessInstanceQuery query = runtimeService
				.createProcessInstanceQuery()
				.processDefinitionKey("KuSatellite").active()
				.orderByProcessInstanceId().desc();
		query.variableValueEquals("applyUserId", userId);
		List<ProcessInstance> list = query.list();

		// 关联业务实体
		for (ProcessInstance processInstance : list) {
			String businessKey = processInstance.getBusinessKey();
			if (businessKey == null) {
				continue;
			}
			KuSatellite KuSatellite = kuSatelliteService
					.getKuSatelliteById(new String(businessKey));
			KuSatellite.setProcessInstance(processInstance);
			KuSatellite
					.setProcessDefinition(getProcessDefinition(processInstance
							.getProcessDefinitionId()));
			results.add(KuSatellite);

			// 设置当前任务信息
			List<Task> tasks = taskService.createTaskQuery()
					.processInstanceId(processInstance.getId()).active()
					.orderByTaskCreateTime().desc().listPage(0, 1);
			KuSatellite.setTask(tasks.get(0));
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
	public List<KuSatellite> findFinishedProcessInstaces() {
		List<KuSatellite> results = new ArrayList<KuSatellite>();
		HistoricProcessInstanceQuery query = historyService
				.createHistoricProcessInstanceQuery()
				.processDefinitionKey("KuSatellite").finished()
				.orderByProcessInstanceEndTime().asc();
		List<HistoricProcessInstance> list = query.list();

		// 关联业务实体
		for (HistoricProcessInstance historicProcessInstance : list) {
			String businessKey = historicProcessInstance.getBusinessKey();
			KuSatellite KuSatellite = kuSatelliteService
					.getKuSatelliteById(new String(businessKey));
			KuSatellite
					.setProcessDefinition(getProcessDefinition(historicProcessInstance
							.getProcessDefinitionId()));
			KuSatellite.setHistoricProcessInstance(historicProcessInstance);
			results.add(KuSatellite);
		}
		return results;
	}

	@Override
	public List<KuSatellite> findFinishedProcessInstaces(String userId) {
		// TODO Auto-generated method stub
		List<KuSatellite> results = new ArrayList<KuSatellite>();
		HistoricProcessInstanceQuery query = historyService
				.createHistoricProcessInstanceQuery()
				.processDefinitionKey("KuSatellite").finished()
				.orderByProcessInstanceEndTime().asc();
		query.variableValueEquals("applyUserId", userId);
		List<HistoricProcessInstance> list = query.list();

		// 关联业务实体
		for (HistoricProcessInstance historicProcessInstance : list) {
			String businessKey = historicProcessInstance.getBusinessKey();
			KuSatellite kuSatellite = kuSatelliteService
					.getKuSatelliteById(new String(businessKey));
			kuSatellite
					.setProcessDefinition(getProcessDefinition(historicProcessInstance
							.getProcessDefinitionId()));
			kuSatellite.setHistoricProcessInstance(historicProcessInstance);
			results.add(kuSatellite);
		}
		return results;
	}

	/**
	 * 
	 * 方法说明：查询流程定义对象
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月1日下午2:45:15
	 * @param processDefinitionId
	 * @return ProcessDefinition
	 * 
	 */
	protected ProcessDefinition getProcessDefinition(String processDefinitionId) {
		ProcessDefinition processDefinition = repositoryService
				.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
		return processDefinition;
	}

	@Override
	public void complete(String taskID, Map<String, Object> taskVariables) {
		// TODO Auto-generated method stub
		taskService.complete(taskID, taskVariables);
	}

	@Override
	public void claim(String taskId, String userId) {
		// TODO Auto-generated method stub
		taskService.claim(taskId, userId);
	}

	@Override
	public Task getTaskByProcessInstaceId(String processInstanceId) {
		// TODO Auto-generated method stub
		List<Task> list = taskService.createTaskQuery()
				.processInstanceId(processInstanceId).list();
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public void delete(String taskId) {
		// TODO Auto-generated method stub
		taskService.deleteTask(taskId);
	}
}
