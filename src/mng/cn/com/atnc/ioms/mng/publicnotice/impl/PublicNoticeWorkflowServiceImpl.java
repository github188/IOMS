package cn.com.atnc.ioms.mng.publicnotice.impl;

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

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.publicnotice.IPublicNoticeDao;
import cn.com.atnc.ioms.entity.publicnotice.PnNotice;
import cn.com.atnc.ioms.mng.publicnotice.IPublicNoticeManager;
import cn.com.atnc.ioms.mng.publicnotice.IPublicNoticeWorkflowService;

/**
 * @author:lizhisheng
 * @date:2014-4-28 下午4:37:35
 * @version:1.0
 */
@Transactional
@Service("publicNoticeWorkflowService")
public class PublicNoticeWorkflowServiceImpl implements
		IPublicNoticeWorkflowService {

	private static Logger logger = LoggerFactory
			.getLogger(PublicNoticeWorkflowServiceImpl.class);
	@Autowired
	private IPublicNoticeManager publicNoticeManager;
	@Autowired
	private IPublicNoticeDao publicNoticeDao;
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
	public ProcessInstance startWorkflow(PnNotice entity,
			Map<String, Object> variables) {
		String businessKey = entity.getId().toString();
		ProcessInstance processInstance = null;
		try {
			// 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
			identityService.setAuthenticatedUserId(entity.getCreateUser()
					.getId());
			processInstance = runtimeService.startProcessInstanceByKey(
					"pnnotice", businessKey, variables);
			String processInstanceId = processInstance.getId();
			entity.setProcessInstanceId(processInstanceId);
			Task task = this.getTaskByProcessInstaceId(processInstanceId);
			entity.setCurrentTaskName(task.getName());
			entity.setCurrentAuditer(task.getAssignee());
			entity.setAuditerList(entity.getAuditerList() + task.getAssignee()
					+ ",");

			publicNoticeManager.update(entity);
			logger.debug(
					"start process of {key={}, bkey={}, pid={}, variables={}}",
					new Object[] { "pnnotice", businessKey,
							processInstanceId, variables });
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			identityService.setAuthenticatedUserId(null);
		}
		return processInstance;
	}
	@Override
public int getcounts(String userId){
	List<PnNotice> results = findTodoTasks(userId);
	return results!=null?results.size():0;
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
	public List<PnNotice> findTodoTasks(String userId) {
		List<PnNotice> results = new ArrayList<PnNotice>();
		List<Task> tasks = new ArrayList<Task>();

		// 根据当前人的ID查询活动任务
		TaskQuery todoQuery = taskService.createTaskQuery()
				.processDefinitionKey("pnnotice").taskAssignee(userId)
				.active().orderByTaskCreateTime().asc().orderByTaskCreateTime()
				.desc();
		List<Task> todoList = todoQuery.list();

		// 根据当前人的ID查询暂停（系统内用户申请撤销后置为暂停）任务
		TaskQuery suspendQuery = taskService.createTaskQuery()
				.processDefinitionKey("pnnotice").taskAssignee(userId)
				.suspended().orderByTaskCreateTime().asc()
				.orderByTaskCreateTime().desc();
		List<Task> suspendList = suspendQuery.list();

		// 根据当前人未签收的任务
		System.out.println(userId);
		TaskQuery claimQuery = taskService.createTaskQuery()
				.processDefinitionKey("pnnotice").taskCandidateUser(userId)
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
			if(null==publicNoticeDao.findById(new String(businessKey))){
				break;
			}
			PnNotice pnNotice = publicNoticeDao.findById(new String(businessKey));
//					.getTempCircuitByID(new String(businessKey));
			pnNotice.setTask(task);
			pnNotice
					.setProcessDefinition(getProcessDefinition(processInstance
							.getProcessDefinitionId()));
			pnNotice.setProcessInstance(processInstance);
			results.add(pnNotice);
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
	public List<PnNotice> findRunningProcessInstaces() {
		List<PnNotice> results = new ArrayList<PnNotice>();
		ProcessInstanceQuery query = runtimeService
				.createProcessInstanceQuery()
				.processDefinitionKey("pnnotice").active()
				.orderByProcessInstanceId().desc();
		List<ProcessInstance> list = query.list();

		// 关联业务实体
		for (ProcessInstance processInstance : list) {
			String businessKey = processInstance.getBusinessKey();
			if (businessKey == null) {
				continue;
			}
			PnNotice pnNotice = publicNoticeDao.findById(new String(businessKey));
//					.getTempCircuitByID(new String(businessKey));
			pnNotice.setProcessInstance(processInstance);
			pnNotice
					.setProcessDefinition(getProcessDefinition(processInstance
							.getProcessDefinitionId()));
			results.add(pnNotice);

			// 设置当前任务信息
			List<Task> tasks = taskService.createTaskQuery()
					.processInstanceId(processInstance.getId()).active()
					.orderByTaskCreateTime().desc().listPage(0, 1);
			pnNotice.setTask(tasks.get(0));
		}
		return results;
	}

	@Override
	public List<PnNotice> findRunningProcessInstaces(String userId) {
		// TODO Auto-generated method stub
		List<PnNotice> results = new ArrayList<PnNotice>();
		ProcessInstanceQuery query = runtimeService
				.createProcessInstanceQuery()
				.processDefinitionKey("pnnotice").active()
				.orderByProcessInstanceId().desc();
		query.variableValueEquals("applyUserId", userId);
		List<ProcessInstance> list = query.list();

		// 关联业务实体
		for (ProcessInstance processInstance : list) {
			String businessKey = processInstance.getBusinessKey();
			if (businessKey == null) {
				continue;
			}
			PnNotice pnNotice = publicNoticeDao.findById(new String(businessKey));
//					.getTempCircuitByID(new String(businessKey));
			pnNotice.setProcessInstance(processInstance);
			pnNotice
					.setProcessDefinition(getProcessDefinition(processInstance
							.getProcessDefinitionId()));
			results.add(pnNotice);

			// 设置当前任务信息
			List<Task> tasks = taskService.createTaskQuery()
					.processInstanceId(processInstance.getId()).active()
					.orderByTaskCreateTime().desc().listPage(0, 1);
			pnNotice.setTask(tasks.get(0));
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
	public List<PnNotice> findFinishedProcessInstaces() {
		List<PnNotice> results = new ArrayList<PnNotice>();
		HistoricProcessInstanceQuery query = historyService
				.createHistoricProcessInstanceQuery()
				.processDefinitionKey("pnnotice").finished()
				.orderByProcessInstanceEndTime().asc();
		List<HistoricProcessInstance> list = query.list();

		// 关联业务实体
		for (HistoricProcessInstance historicProcessInstance : list) {
			String businessKey = historicProcessInstance.getBusinessKey();
			PnNotice pnNotice = publicNoticeDao.findById(new String(businessKey));
//					.getTempCircuitByID(new String(businessKey));
			pnNotice
					.setProcessDefinition(getProcessDefinition(historicProcessInstance
							.getProcessDefinitionId()));
			pnNotice.setHistoricProcessInstance(historicProcessInstance);
			results.add(pnNotice);
		}
		return results;
	}

	@Override
	public List<PnNotice> findFinishedProcessInstaces(String userId) {
		// TODO Auto-generated method stub
		List<PnNotice> results = new ArrayList<PnNotice>();
		HistoricProcessInstanceQuery query = historyService
				.createHistoricProcessInstanceQuery()
				.processDefinitionKey("pnnotice").finished()
				.orderByProcessInstanceEndTime().asc();
		query.variableValueEquals("applyUserId", userId);
		List<HistoricProcessInstance> list = query.list();

		// 关联业务实体
		for (HistoricProcessInstance historicProcessInstance : list) {
			String businessKey = historicProcessInstance.getBusinessKey();
			PnNotice pnNotice = publicNoticeDao.findById(new String(businessKey));
//					.getTempCircuitByID(new String(businessKey));
			pnNotice
					.setProcessDefinition(getProcessDefinition(historicProcessInstance
							.getProcessDefinitionId()));
			pnNotice.setHistoricProcessInstance(historicProcessInstance);
			results.add(pnNotice);
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
		return taskService.createTaskQuery()
				.processInstanceId(processInstanceId).list().get(0);
	}

	@Override
	public void delete(String taskId) {
		// TODO Auto-generated method stub
		taskService.deleteTask(taskId);
	}
}
