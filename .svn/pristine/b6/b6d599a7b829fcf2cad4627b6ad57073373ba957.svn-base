package cn.com.atnc.ioms.mng.publicnotice;

import java.util.List;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import cn.com.atnc.ioms.entity.publicnotice.PnNotice;


/**
 * @author:lizhisheng
 * @date:2014-4-28 下午3:44:41
 * 通知公告申请工作流服务接口 类说明：
 * @version:1.0
 */
public interface IPublicNoticeWorkflowService {

	/**
	 * 
	 * 方法说明：启动流程
	 * 
	 * @author:lizhisheng
	 * @date:2014-4-28 下午3:44:41
	 * @param entity
	 * @param variables
	 * @return ProcessInstance
	 * 
	 */
	public abstract ProcessInstance startWorkflow(PnNotice entity,
			Map<String, Object> variables);
	public int getcounts(String userId);
	/**
	 * 
	 * 方法说明：根据用户查询该用户的待办任务
	 * 
	 * @author:lizhisheng
	 * @date:2014-4-28 下午3:44:41
	 * @param userId
	 * @return List<TempCircuit>
	 * 
	 */
	public abstract List<PnNotice> findTodoTasks(String userId);

	/**
	 * 
	 * 方法说明：读取所有运行中的流程
	 * 
	 * @author:lizhisheng
	 * @date:2014-4-28 下午3:44:41
	 * @return List<TempCircuit>
	 * 
	 */
	public abstract List<PnNotice> findRunningProcessInstaces();

	/**
	 * 
	 * 方法说明：读取特定申请用户所有运行中的流程
	 * 
	 * @author:lizhisheng
	 * @date:2014-4-28 下午3:44:41
	 * @return List<TempCircuit>
	 * 
	 */
	public abstract List<PnNotice> findRunningProcessInstaces(String userId);

	/**
	 * 
	 * 方法说明：读取所有已结束中的流程
	 * 
	 * @author:lizhisheng
	 * @date:2014-4-28 下午3:44:41
	 * @return List<TempCircuit>
	 * 
	 */
	public abstract List<PnNotice> findFinishedProcessInstaces();

	/**
	 * 
	 * 方法说明：读取特定申请用户所有已结束中的流程
	 * 
	 * @author:lizhisheng
	 * @date:2014-4-28 下午3:44:41
	 * @return List<TempCircuit>
	 * 
	 */
	public abstract List<PnNotice> findFinishedProcessInstaces(String userId);

	/**
	 * 
	 * 方法说明：完成流程或流程中的一步
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月1日下午2:53:18
	 * @param taskID
	 * @param taskVariables
	 *            void
	 * 
	 */
	public abstract void complete(String taskID,
			Map<String, Object> taskVariables);

	/**
	 * 
	 * 方法说明：签收
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月1日下午4:19:32 void
	 * 
	 */
	public abstract void claim(String taskId, String userId);

	/**
	 * 
	 * 方法说明：删除task
	 * 
	 * @author:lizhisheng
	 * @date:2014-4-28 下午3:44:41
	 * @param taskId
	 *            void
	 * 
	 */
	public abstract void delete(String taskId);

	/**
	 * 
	 * 方法说明：根据processInstanceId获取当前Task
	 * 
	 * @author:lizhisheng
	 * @date:2014-4-28 下午3:44:41
	 * @param id
	 * @return Task
	 * 
	 */
	public Task getTaskByProcessInstaceId(String processInstanceId);

}