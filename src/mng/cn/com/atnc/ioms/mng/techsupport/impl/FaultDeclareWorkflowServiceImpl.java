package cn.com.atnc.ioms.mng.techsupport.impl;

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

import cn.com.atnc.ioms.entity.techsupport.fault.FaultDeclare;
import cn.com.atnc.ioms.mng.techsupport.IFaultDeclareService;
import cn.com.atnc.ioms.mng.techsupport.IFaultDeclareWorkflowService;

/**
 * 类说明：故障申报工作流服务接口实现 
 * 
 * @author：KuYonggang
 * @date：2014-4-19上午11:28:17
 * @version：1.0
 */
@Transactional
@Service("faultDeclareWorkflowService")
public class FaultDeclareWorkflowServiceImpl implements
		IFaultDeclareWorkflowService {

	private static Logger logger = LoggerFactory
			.getLogger(FaultDeclareWorkflowServiceImpl.class);
	@Autowired
	private IFaultDeclareService faultDeclareService;
	
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
	 * cn.com.atnc.pcsp.mng.tempcircuit.ITempCircuitWorkflowService#startWorkflow
	 * (cn.com.atnc.pcsp.entity.tempcircuit.TempCircuit, java.util.Map)
	 */
	@Override
	public ProcessInstance startWorkflow(FaultDeclare entity,
			Map<String, Object> variables) {
		String businessKey = entity.getId().toString();
		ProcessInstance processInstance = null;
		try {
			// 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
			identityService.setAuthenticatedUserId(entity.getClient()
					.getId());
			processInstance = runtimeService.startProcessInstanceByKey(
					"faultdeclare", businessKey, variables);
			String processInstanceId = processInstance.getId();
			entity.setProcessInstanceId(processInstanceId);
			entity.setCurrentTaskName(this.getTaskByProcessInstaceId(
					processInstanceId).getName());

			faultDeclareService.update(entity);
			logger.debug(
					"start process of {key={}, bkey={}, pid={}, variables={}}",
					new Object[] { "faultdeclare", businessKey,
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
	 * cn.com.atnc.pcsp.mng.tempcircuit.ITempCircuitWorkflowService#findTodoTasks
	 * (java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<FaultDeclare> findTodoTasks(String userId) {
		List<FaultDeclare> results = new ArrayList<FaultDeclare>();
		List<Task> tasks = new ArrayList<Task>();

		// 根据当前人的ID查询
		TaskQuery todoQuery = taskService.createTaskQuery()
				.processDefinitionKey("faultdeclare").taskAssignee(userId)
				.active().orderByTaskCreateTime().asc().orderByTaskCreateTime()
				.desc();
		List<Task> todoList = todoQuery.list();

		// 根据当前人未签收的任务
		TaskQuery claimQuery = taskService.createTaskQuery()
				.processDefinitionKey("faultdeclare").taskCandidateUser(userId)
				.active().orderByTaskCreateTime().asc().orderByTaskCreateTime()
				.desc();
		List<Task> unsignedTasks = claimQuery.list();

		// 合并
		tasks.addAll(todoList);
		tasks.addAll(unsignedTasks);
		logger.debug("todoList:" + todoList.size());
		logger.debug("unsignedTasks:" + unsignedTasks.size());

		// 根据流程的业务ID查询实体并关联
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
			logger.debug("new String(businessKey):" + new String(businessKey));
			System.err.println(new String(businessKey));
			FaultDeclare faultDeclare = faultDeclareService
					.getFaultDeclareByID(new String(businessKey));
			if(faultDeclare==null){
				continue;
			}
			faultDeclare.setTask(task);
			faultDeclare
					.setProcessDefinition(getProcessDefinition(processInstance
							.getProcessDefinitionId()));
			faultDeclare.setProcessInstance(processInstance);
			results.add(faultDeclare);
		}
		logger.debug("results:" + results.size());
		return results;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.mng.tempcircuit.ITempCircuitWorkflowService#
	 * findRunningProcessInstaces()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<FaultDeclare> findRunningProcessInstaces() {
		List<FaultDeclare> results = new ArrayList<FaultDeclare>();
		ProcessInstanceQuery query = runtimeService
				.createProcessInstanceQuery()
				.processDefinitionKey("faultdeclare").active()
				.orderByProcessInstanceId().desc();
		List<ProcessInstance> list = query.list();

		// 关联业务实体
		for (ProcessInstance processInstance : list) {
			String businessKey = processInstance.getBusinessKey();
			if (businessKey == null) {
				continue;
			}
			FaultDeclare faultDeclare = faultDeclareService
					.getFaultDeclareByID(new String(businessKey));
			faultDeclare.setProcessInstance(processInstance);
			faultDeclare
					.setProcessDefinition(getProcessDefinition(processInstance
							.getProcessDefinitionId()));
			results.add(faultDeclare);

			// 设置当前任务信息
			List<Task> tasks = taskService.createTaskQuery()
					.processInstanceId(processInstance.getId()).active()
					.orderByTaskCreateTime().desc().listPage(0, 1);
			faultDeclare.setTask(tasks.get(0));
		}
		return results;
	}

	@Override
	public List<FaultDeclare> findRunningProcessInstaces(String userId) {
		// TODO Auto-generated method stub
		List<FaultDeclare> results = new ArrayList<FaultDeclare>();
		ProcessInstanceQuery query = runtimeService
				.createProcessInstanceQuery()
				.processDefinitionKey("faultdeclare").active()
				.orderByProcessInstanceId().desc();
		query.variableValueEquals("applyUserId", userId);
		List<ProcessInstance> list = query.list();

		// 关联业务实体
		for (ProcessInstance processInstance : list) {
			String businessKey = processInstance.getBusinessKey();
			if (businessKey == null) {
				continue;
			}
			FaultDeclare faultDeclare = faultDeclareService
					.getFaultDeclareByID(new String(businessKey));
			faultDeclare.setProcessInstance(processInstance);
			faultDeclare
					.setProcessDefinition(getProcessDefinition(processInstance
							.getProcessDefinitionId()));
			results.add(faultDeclare);

			// 设置当前任务信息
			List<Task> tasks = taskService.createTaskQuery()
					.processInstanceId(processInstance.getId()).active()
					.orderByTaskCreateTime().desc().listPage(0, 1);
			faultDeclare.setTask(tasks.get(0));
		}
		return results;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.mng.tempcircuit.ITempCircuitWorkflowService#
	 * findFinishedProcessInstaces()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<FaultDeclare> findFinishedProcessInstaces() {
		List<FaultDeclare> results = new ArrayList<FaultDeclare>();
		HistoricProcessInstanceQuery query = historyService
				.createHistoricProcessInstanceQuery()
				.processDefinitionKey("faultdeclare").finished()
				.orderByProcessInstanceEndTime().asc();
		List<HistoricProcessInstance> list = query.list();

		// 关联业务实体
		for (HistoricProcessInstance historicProcessInstance : list) {
			String businessKey = historicProcessInstance.getBusinessKey();
			FaultDeclare faultDeclare = faultDeclareService
					.getFaultDeclareByID(new String(businessKey));
			faultDeclare
					.setProcessDefinition(getProcessDefinition(historicProcessInstance
							.getProcessDefinitionId()));
			faultDeclare.setHistoricProcessInstance(historicProcessInstance);
			results.add(faultDeclare);
		}
		return results;
	}

	@Override
	public List<FaultDeclare> findFinishedProcessInstaces(String userId) {
		// TODO Auto-generated method stub
		List<FaultDeclare> results = new ArrayList<FaultDeclare>();
		HistoricProcessInstanceQuery query = historyService
				.createHistoricProcessInstanceQuery()
				.processDefinitionKey("faultdeclare").finished()
				.orderByProcessInstanceEndTime().asc();
		query.variableValueEquals("applyUserId", userId);
		List<HistoricProcessInstance> list = query.list();

		// 关联业务实体
		for (HistoricProcessInstance historicProcessInstance : list) {
			String businessKey = historicProcessInstance.getBusinessKey();
			FaultDeclare faultDeclare = faultDeclareService
					.getFaultDeclareByID(new String(businessKey));
			faultDeclare
					.setProcessDefinition(getProcessDefinition(historicProcessInstance
							.getProcessDefinitionId()));
			faultDeclare.setHistoricProcessInstance(historicProcessInstance);
			results.add(faultDeclare);
		}
		return results;
	}

	/**
	 * 方法说明：查询流程定义对象
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-19上午11:31:11
	 * @param：方法说明：查询流程定义对象
	 * @return：ProcessDefinition
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
		return taskService.createTaskQuery()
				.processInstanceId(processInstanceId).list().get(0);
	}

	@Override
	public void delete(String taskId) {
		// TODO Auto-generated method stub
		taskService.deleteTask(taskId);
	}
}
