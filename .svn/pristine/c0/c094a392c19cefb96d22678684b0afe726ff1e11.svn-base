package cn.com.atnc.ioms.mng.tempcircuit.impl;

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

import cn.com.atnc.ioms.entity.tempcircuit.TempCircuit;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.tempcircuit.ITempCircuitMngService;
import cn.com.atnc.ioms.mng.tempcircuit.ITempCircuitWorkflowService;

/**
 * 
 * 类说明：
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月27日下午7:34:47
 * @version:1.0
 */
@Transactional
@Service("tempCircuitWorkflowService")
public class TempCircuitWorkflowServiceImpl implements
		ITempCircuitWorkflowService {

	private static Logger logger = LoggerFactory
			.getLogger(TempCircuitWorkflowServiceImpl.class);
	@Autowired
	private ITempCircuitMngService tempCircuitService;
	@Autowired
	private IUserManager userManager;
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
	public ProcessInstance startWorkflow(TempCircuit entity,
			Map<String, Object> variables) {
		String businessKey = entity.getId().toString();
		ProcessInstance processInstance = null;
		try {
			// 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
			identityService.setAuthenticatedUserId(entity.getApplyUserId());
			processInstance = runtimeService.startProcessInstanceByKey(
					"tempcircuitmng", businessKey, variables);
			String processInstanceId = processInstance.getId();
			entity.setProcessInstanceId(processInstanceId);
			Task task = this.getTaskByProcessInstaceId(processInstanceId);
			entity.setCurrentTaskName(task.getName());
			// entity.setCurrentAuditer(userManager.findById(task.getAssignee())
			// .getLoginName());
			entity.setAuditerList(entity.getAuditerList() + task.getAssignee()
					+ ",");

			tempCircuitService.add(entity);
			logger.debug(
					"start process of {key={}, bkey={}, pid={}, variables={}}",
					new Object[] { "tempcircuit", businessKey,
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
	public List<TempCircuit> findTodoTasks(String userId) {
		List<TempCircuit> results = new ArrayList<TempCircuit>();
		List<Task> tasks = new ArrayList<Task>();

		// 根据当前人的ID查询活动任务
		TaskQuery todoQuery = taskService.createTaskQuery()
				.processDefinitionKeyLike("tempcircuit%").taskAssignee(userId)
				.active().orderByTaskCreateTime().asc().orderByTaskCreateTime()
				.desc();
		List<Task> todoList = todoQuery.list();

		// 合并
		tasks.addAll(todoList);

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
				TempCircuit tempCircuit = tempCircuitService
						.getTempCircuitByID(new String(businessKey));
				if (tempCircuit != null) {
					tempCircuit.setTask(task);
					tempCircuit
							.setProcessDefinition(getProcessDefinition(processInstance
									.getProcessDefinitionId()));
					tempCircuit.setProcessInstance(processInstance);
					results.add(tempCircuit);
				}
			}
		}
		logger.debug("results:" + results.size());
		return results;
	}

	@Override
	public List<TempCircuit> findUnSingTasks(String userId) {
		// TODO Auto-generated method stub
		List<TempCircuit> results = new ArrayList<TempCircuit>();
		List<Task> tasks = new ArrayList<Task>();

		// 根据当前人未签收的任务
		TaskQuery claimQuery = taskService.createTaskQuery()
				.processDefinitionKeyLike("tempcircuit%")
				.taskCandidateUser(userId).active().orderByTaskCreateTime()
				.asc();
		List<Task> unsignedTasks = claimQuery.list();

		tasks.addAll(unsignedTasks);

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
				TempCircuit tempCircuit = tempCircuitService
						.getTempCircuitByID(new String(businessKey));
				if (tempCircuit != null) {
					tempCircuit.setTask(task);
					tempCircuit
							.setProcessDefinition(getProcessDefinition(processInstance
									.getProcessDefinitionId()));
					tempCircuit.setProcessInstance(processInstance);
					results.add(tempCircuit);
				}
			}
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
	public List<TempCircuit> findRunningProcessInstaces() {
		List<TempCircuit> results = new ArrayList<TempCircuit>();
		ProcessInstanceQuery query = runtimeService
				.createProcessInstanceQuery()
				.processDefinitionKey("tempcircuit").active()
				.orderByProcessInstanceId().desc();
		List<ProcessInstance> list = query.list();

		// 关联业务实体
		for (ProcessInstance processInstance : list) {
			String businessKey = processInstance.getBusinessKey();
			if (businessKey == null) {
				continue;
			}
			TempCircuit tempCircuit = tempCircuitService
					.getTempCircuitByID(new String(businessKey));
			tempCircuit.setProcessInstance(processInstance);
			tempCircuit
					.setProcessDefinition(getProcessDefinition(processInstance
							.getProcessDefinitionId()));
			results.add(tempCircuit);

			// 设置当前任务信息
			List<Task> tasks = taskService.createTaskQuery()
					.processInstanceId(processInstance.getId()).active()
					.orderByTaskCreateTime().desc().listPage(0, 1);
			tempCircuit.setTask(tasks.get(0));
		}
		return results;
	}

	@Override
	public List<TempCircuit> findRunningProcessInstaces(String userId) {
		// TODO Auto-generated method stub
		List<TempCircuit> results = new ArrayList<TempCircuit>();
		ProcessInstanceQuery query = runtimeService
				.createProcessInstanceQuery()
				.processDefinitionKey("tempcircuit").active()
				.orderByProcessInstanceId().desc();
		query.variableValueEquals("applyUserId", userId);
		List<ProcessInstance> list = query.list();

		// 关联业务实体
		for (ProcessInstance processInstance : list) {
			String businessKey = processInstance.getBusinessKey();
			if (businessKey == null) {
				continue;
			}
			TempCircuit tempCircuit = tempCircuitService
					.getTempCircuitByID(new String(businessKey));
			tempCircuit.setProcessInstance(processInstance);
			tempCircuit
					.setProcessDefinition(getProcessDefinition(processInstance
							.getProcessDefinitionId()));
			results.add(tempCircuit);

			// 设置当前任务信息
			List<Task> tasks = taskService.createTaskQuery()
					.processInstanceId(processInstance.getId()).active()
					.orderByTaskCreateTime().desc().listPage(0, 1);
			tempCircuit.setTask(tasks.get(0));
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
	public List<TempCircuit> findFinishedProcessInstaces() {
		List<TempCircuit> results = new ArrayList<TempCircuit>();
		HistoricProcessInstanceQuery query = historyService
				.createHistoricProcessInstanceQuery()
				.processDefinitionKey("tempcircuit").finished()
				.orderByProcessInstanceEndTime().asc();
		List<HistoricProcessInstance> list = query.list();

		// 关联业务实体
		for (HistoricProcessInstance historicProcessInstance : list) {
			String businessKey = historicProcessInstance.getBusinessKey();
			TempCircuit tempCircuit = tempCircuitService
					.getTempCircuitByID(new String(businessKey));
			tempCircuit
					.setProcessDefinition(getProcessDefinition(historicProcessInstance
							.getProcessDefinitionId()));
			tempCircuit.setHistoricProcessInstance(historicProcessInstance);
			results.add(tempCircuit);
		}
		return results;
	}

	@Override
	public List<TempCircuit> findFinishedProcessInstaces(String userId) {
		// TODO Auto-generated method stub
		List<TempCircuit> results = new ArrayList<TempCircuit>();
		HistoricProcessInstanceQuery query = historyService
				.createHistoricProcessInstanceQuery()
				.processDefinitionKey("tempcircuit").finished()
				.orderByProcessInstanceEndTime().asc();
		query.variableValueEquals("applyUserId", userId);
		List<HistoricProcessInstance> list = query.list();

		// 关联业务实体
		for (HistoricProcessInstance historicProcessInstance : list) {
			String businessKey = historicProcessInstance.getBusinessKey();
			TempCircuit tempCircuit = tempCircuitService
					.getTempCircuitByID(new String(businessKey));
			tempCircuit
					.setProcessDefinition(getProcessDefinition(historicProcessInstance
							.getProcessDefinitionId()));
			tempCircuit.setHistoricProcessInstance(historicProcessInstance);
			results.add(tempCircuit);
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
		logger.debug("claim taskId:" + taskId);
		logger.debug("claim userId:" + userId);
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
