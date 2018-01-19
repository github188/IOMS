package cn.com.atnc.ioms.mng.business.transfernet;

import java.util.List;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import cn.com.atnc.ioms.entity.business.transfernet.TransferNet;

/**
 * 自动转报网申请工作流服务接口 类
 *
 * @author Wang Zhicheng
 * @date 2015年10月20日 上午10:19:11
 * @since 1.0.0
 */
public interface ITransferNetWorkflowService {

	/**
	 * 启动流程
	 *
	 * @param entity
	 * @param variables
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月20日上午10:19:30
	 * @since 1.0.0
	 */
	public abstract ProcessInstance startWorkflow(TransferNet entity,
			Map<String, Object> variables);

	/**
	 * 根据用户查询该用户的待办任务
	 *
	 * @param userId
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月20日上午10:19:51
	 * @since 1.0.0
	 */
	public abstract List<TransferNet> findTodoTasks(String userId);

	/**
	 * 读取所有运行中的流程
	 *
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月20日上午10:20:19
	 * @since 1.0.0
	 */
	public abstract List<TransferNet> findRunningProcessInstaces();

	/**
	 * 读取特定申请用户所有运行中的流程
	 *
	 * @param userId
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月20日上午10:20:43
	 * @since 1.0.0
	 */
	public abstract List<TransferNet> findRunningProcessInstaces(String userId);

	/**
	 * 读取所有已结束中的流程
	 *
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月20日上午10:21:00
	 * @since 1.0.0
	 */
	public abstract List<TransferNet> findFinishedProcessInstaces();

	/**
	 * 读取特定申请用户所有已结束中的流程
	 *
	 * @param userId
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月20日上午10:21:20
	 * @since 1.0.0
	 */
	public abstract List<TransferNet> findFinishedProcessInstaces(String userId);

	/**
	 * 完成流程或流程中的一步
	 *
	 * @param taskID
	 * @param taskVariables 
	 * @author Wang Zhicheng
	 * @date  2015年10月20日上午10:21:32
	 * @since 1.0.0
	 */
	public abstract void complete(String taskID,
			Map<String, Object> taskVariables);

	/**
	 * 签收
	 *
	 * @param taskId
	 * @param userId 
	 * @author Wang Zhicheng
	 * @date  2015年10月20日上午10:21:51
	 * @since 1.0.0
	 */
	public abstract void claim(String taskId, String userId);

	/**
	 * 删除task
	 *
	 * @param taskId 
	 * @author Wang Zhicheng
	 * @date  2015年10月20日上午10:22:03
	 * @since 1.0.0
	 */
	public abstract void delete(String taskId);

	/**
	 * 根据processInstanceId获取当前Task
	 *
	 * @param processInstanceId
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月20日上午10:22:19
	 * @since 1.0.0
	 */
	public Task getTaskByProcessInstaceId(String processInstanceId);

}