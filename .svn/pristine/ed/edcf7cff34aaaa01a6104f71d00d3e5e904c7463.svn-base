package cn.com.atnc.ioms.mng.faultmng.impl;

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
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.ioms.dao.faultmng.IFaultInformationDao;
import cn.com.atnc.ioms.entity.faultmng.FaultInformation;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.faultmng.IFaultMngWorkflowService;

/**
 * 故障处置工作流services类
 * @author duanyanlin 
 * 2016年6月20日 下午12:57:07
 */
@Transactional
@Service
public class FaultMngWorkflowServiceImpl implements IFaultMngWorkflowService {

	private static Logger logger = LoggerFactory
			.getLogger(FaultMngWorkflowServiceImpl.class);
	@Autowired
	private IFaultInformationDao faultInformationDao;
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
	
	/**
	 * 方法说明：启动故障处置工作流
	 * @author duanyanlin
	 * @date 2016年6月20日下午1:01:58
	 * @param entity 事件单实体
	 * @param variables 条件集合
	 * @return ProcessInstance 工作流实例
	 */
	@Override
	public ProcessInstance startWorkflow(FaultInformation entity,
			Map<String, Object> variables) {
		String businessKey = "";
		if(!ObjectUtils.equals(entity, null)){
			businessKey = entity.getId();
		}
		ProcessInstance processInstance = null;
		try {
			//创建新的群组
			// 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
			identityService.setAuthenticatedUserId(entity.getFirstHandelUser()
					.getId());
			processInstance = runtimeService.startProcessInstanceByKey(
					"FaultMngProcess", businessKey, variables);
			String processInstanceId = processInstance.getId();
			entity.setProcessInstanceId(processInstanceId);
			Task task = this.getTaskByProcessInstaceId(processInstanceId);
			entity.setTaskName(task.getName());
			logger.debug("task.getAssignee():" + task.getAssignee());
			faultInformationDao.update(entity);
			logger.debug(
					"start process of {key={}, bkey={}, pid={}, variables={}}",
					new Object[] { "FaultMngProcess", businessKey,
							processInstanceId, variables });
		} finally {
			identityService.setAuthenticatedUserId(null);
		}
		return processInstance;
	}

	/**
	 * 根据userId发现待处理任务
	 * @author duanyanlin
	 * @date 2016年6月20日下午1:38:36
	 * @param userId 用户id
	 * @return List 任务列表
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Task> findTodoTasks(String userId) {
		List<Task> tasks = new ArrayList<Task>();
		// 根据当前人的ID查询活动任务
		TaskQuery todoQuery = taskService.createTaskQuery()
				.processDefinitionKey("FaultMngProcess").taskAssignee(userId)
				.active().orderByTaskCreateTime().desc();
		List<Task> todoList = todoQuery.list();
		// 合并
		tasks.addAll(todoList);
		logger.debug("todoList:" + todoList.size());
		return tasks;
	}
	
	/**
	 * 根据值班经理的角色发现待处理任务
	 * @author duanyanlin
	 * @date 2016年6月20日下午1:38:36
	 * @param userRole 用户角色
	 * @return List 任务列表
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Task> findTodoTasksHangup(String userRole) {
		List<Task> tasks = new ArrayList<Task>();
		// 根据当前人的ID查询活动任务
		TaskQuery todoQuery = taskService.createTaskQuery()
				.processDefinitionKey("FaultMngProcess").taskCandidateGroup(userRole)
				.active().orderByTaskCreateTime().desc();
		List<Task> todoList = todoQuery.list();
		// 合并
		tasks.addAll(todoList);
		logger.debug("todoList:" + todoList.size());
		return tasks;
	}
	
	/**
	 * 根据业务查询故障单实体
	 * @author duanyanlin
	 * @date 2016年6月22日上午10:54:14
	 * @param task 任务实体
	 * @return FaultInformation 事件单
	 */
	@Override
	public FaultInformation findEntity(Task task){
		String processInstanceId = task.getProcessInstanceId();
		ProcessInstance processInstance = this.runtimeService
				.createProcessInstanceQuery()
				.processInstanceId(processInstanceId).active()
				.singleResult();
		String businessKey = processInstance.getBusinessKey();
		FaultInformation faultInformation = null;
		if (!StringUtils.isEmpty(businessKey)) {
			//根据故障单ID查询故障单
			faultInformation = this.faultInformationDao.findById(businessKey);
			if (faultInformation != null) {
				faultInformation.setTask(task);
				faultInformation
				.setProcessDefinition(this.getProcessDefinition(processInstance
						.getProcessDefinitionId()));
				faultInformation.setProcessInstance(processInstance);
			}
		}
		return faultInformation;
	}

	/**
	 * 方法说明：读取所有运行中的流程
	 * @author duanyanlin
	 * @date 2016年6月20日下午2:23:59
	 * @return List 实例列表 
	 */
	@Override
	@Transactional(readOnly = true)
	public List<ProcessInstance> findRunningProcessInstaces() {
		ProcessInstanceQuery query = runtimeService
				.createProcessInstanceQuery()
				.processDefinitionKey("FaultMngProcess").active()
				.orderByProcessInstanceId().desc();
		List<ProcessInstance> list = query.list();
		return list;
	}

	/**
	 * 
	 * @author duanyanlin
	 * @date 2016年6月20日下午2:29:02
	 * @return List 历史实例列表 
	 */
	@Override
	@Transactional(readOnly = true)
	public List<HistoricProcessInstance> findFinishedProcessInstaces() {
		HistoricProcessInstanceQuery query = historyService
				.createHistoricProcessInstanceQuery()
				.processDefinitionKey("FaultMngProcess").finished()
				.orderByProcessInstanceEndTime().asc();
		List<HistoricProcessInstance> list = query.list();
		return list;
	}

	/**
	 * 
	 * 方法说明：查询流程定义对象
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月1日下午2:45:15
	 * @param processDefinitionId 实例id
	 * @return ProcessDefinition
	 * 
	 */
	@Override
	public ProcessDefinition getProcessDefinition(String processDefinitionId) {
		ProcessDefinition processDefinition = repositoryService
				.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
		return processDefinition;
	}

	/**
	 * 流程控制
	 * @author duanyanlin
	 * @date 2016年6月22日下午12:21:18
	 * @param taskID 任务id
	 * @param taskVariables 条件集合
	 */
	@Override
	public void complete(String taskID, Map<String, Object> taskVariables) {
		taskService.complete(taskID, taskVariables);
	}

	/**
	 * 工作流声明
	 * @author duanyanlin
	 * @date 2016年6月22日下午12:21:18
	 * @param taskId 任务id
	 * @param userId 用户id
	 */
	@Override
	public void claim(String taskId, String userId) {
		taskService.claim(taskId, userId);
	}

	/**
	 * 根据processInstanceId查询task业务
	 * @author duanyanlin
	 * @date 2016年6月22日下午12:21:41
	 * @param processInstanceId 实例id
	 * @param taskId 任务id
	 */
	@Override
	public Task getTaskByProcessInstaceId(String processInstanceId) {
		List<Task> list = taskService.createTaskQuery()
				.processInstanceId(processInstanceId).list();
		//根据列表选择相应的返回值
		if(CollectionUtils.isNotEmpty(list)){
			return list.get(0);
		}else{
			return null;
		}
	}

	/**
	 * 删除工作流
	 * @author duanyanlin
	 * @date 2016年6月22日下午12:21:41
	 * @param taskId 任务id
	 */
	@Override
	public void delete(String taskId) {
		taskService.deleteTask(taskId);
	}
	
	/**
	 * 删除任务(逻辑移除)
	 * @author duanyanlin
	 * @date 2016年7月4日下午1:41:33
	 * @param processInstanceId 实例id
	 */
	@Override
	public void removeTask(String processInstanceId) {
		Task task = getTaskByProcessInstaceId(processInstanceId);
		if(task != null){
			taskService.resolveTask(task.getId());
		}
	}
}
