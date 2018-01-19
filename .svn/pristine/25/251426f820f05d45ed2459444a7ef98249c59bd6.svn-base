package cn.com.atnc.ioms.mng.techsupport;

import java.util.List;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import cn.com.atnc.ioms.entity.techsupport.fault.FaultDeclare;


/**
 * 说明：故障申报工作流服务接口 
 * 
 * @author：KuYonggang
 * @date：2014-4-19上午11:21:48
 * @version：1.0
 */
public interface IFaultDeclareWorkflowService {

	/**
	 * 方法说明：启动流程
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-19上午11:22:20
	 * @param entity
	 * @param variables
	 * @return：ProcessInstance
	 */
	public abstract ProcessInstance startWorkflow(FaultDeclare entity,
			Map<String, Object> variables);

	/**
	 * 方法说明：根据用户查询该用户的待办任务
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-19上午11:23:06
	 * @param：userId
	 * @return：List<FaultDeclare>
	 */
	public abstract List<FaultDeclare> findTodoTasks(String userId);

	/**
	 * 方法说明：读取所有运行中的流程
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-19上午11:23:32
	 * @return：List<TempCircuit>
	 */
	public abstract List<FaultDeclare> findRunningProcessInstaces();

	/**
	 * 方法说明：读取特定申请用户所有运行中的流程
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-19上午11:24:04
	 * @param：userId
	 * @return：List<TempCircuit>
	 */
	public abstract List<FaultDeclare> findRunningProcessInstaces(String userId);

	/**
	 * 方法说明：读取所有已结束中的流程
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-19上午11:24:35
	 * @return：List<TempCircuit>
	 */
	public abstract List<FaultDeclare> findFinishedProcessInstaces();

	/**
	 * 方法说明：读取特定申请用户所有已结束中的流程
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-19上午11:25:03
	 * @param：userId
	 * @return：List<FaultDeclare>
	 */
	public abstract List<FaultDeclare> findFinishedProcessInstaces(String userId);

	/**
	 * 方法说明：完成流程或流程中的一步
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-19上午11:25:26
	 * @param taskID
	 * @param taskVariables
	 * @return： void
	 */
	public abstract void complete(String taskID,
			Map<String, Object> taskVariables);

	/**
	 * 方法说明：签收
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-19上午11:26:08
	 * @param：taskId 
	 * @param：userId
	 * @return：void
	 */
	public abstract void claim(String taskId, String userId);

	/**
	 * 方法说明：删除task
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-19上午11:27:11
	 * @param：taskId 任务ID
	 * @return：void
	 */
	public abstract void delete(String taskId);

	/**
	 * 方法说明：根据processInstanceId获取当前Task
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-19上午11:27:42
	 * @param：id
	 * @return：Task
	 */
	public Task getTaskByProcessInstaceId(String processInstanceId);

}