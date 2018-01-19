package cn.com.atnc.ioms.mng.faultmng;

import java.util.List;
import java.util.Map;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import cn.com.atnc.ioms.entity.faultmng.FaultInformation;

/**
 * 故障处置工作流service类
 * @author duanyanlin
 *  2016年6月20日 下午12:57:07
 */
public interface IFaultMngWorkflowService {
	
	/**
	 * 启动工作流(创建故障单时)
	 * @author duanyanlin
	 * @date 2016年6月21日下午4:48:16
	 * @param entity 事件单实体
	 * @param variables 条件集合
	 * @return ProcessInstance 工作流实例
	 */
	public abstract ProcessInstance startWorkflow(FaultInformation entity,
			Map<String, Object> variables);

	/**
	 * 根据当前登录用户的userId查询所有待处理任务
	 * @author duanyanlin
	 * @date 2016年6月21日下午4:48:56
	 * @param userId 用户id
	 * @return List 任务列表
	 */
	public abstract List<Task> findTodoTasks(String userId);
	
	/**
	 * 根据角色查询待处理任务
	 * @author duanyanlin
	 * @date 2016年6月22日上午10:25:22
	 * @param userRole 用户角色
	 * @return List 任务列表
	 */
	public List<Task> findTodoTasksHangup(String userRole);
	
	/**
	 * 根据任务查询实体
	 * @author duanyanlin
	 * @date 2016年6月22日上午10:51:52
	 * @param task 任务实体
	 * @return FaultInformation 事件单
	 */
	public FaultInformation findEntity(Task task);

	/**
	 * 读取所有运行中的流程
	 * @author duanyanlin
	 * @date 2016年6月21日下午4:50:17
	 * @return List 实例列表 
	 */
	public abstract List<ProcessInstance> findRunningProcessInstaces();

	/**
	 * 方法说明：读取所有已结束中的流程
	 * @author duanyanlin
	 * @date 2016年6月21日下午4:52:53
	 * @return List 历史实例列表 
	 */
	public abstract List<HistoricProcessInstance> findFinishedProcessInstaces();
	
	/**
	 * 方法说明：查询流程定义对象
	 * @author duanyanlin
	 * @date 2016年6月21日下午5:28:48
	 * @param processDefinitionId 实例id
	 * @return ProcessDefinition
	 */
	public ProcessDefinition getProcessDefinition(String processDefinitionId);
	
	/**
	 * 
	 * 方法说明：完成流程或流程中的一步
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月1日下午2:53:18
	 * @param taskID 任务id
	 * @param taskVariables 条件集合
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
	 * @param taskId 任务id
	 * @param userId 用户id
	 * 
	 */
	public abstract void claim(String taskId, String userId);

	/**
	 * 
	 * 方法说明：删除task
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月17日下午6:06:04
	 * @param taskId 任务id
	 *            void
	 * 
	 */
	public abstract void delete(String taskId);
	
	/**
	 * 方法说明：逻辑删除task
	 * @author duanyanlin
	 * @date 2016年7月4日下午12:09:43
	 * @param processInstanceId 实例id
	 */
	public abstract void removeTask(String processInstanceId);
	
	/**
	 * 
	 * 方法说明：根据processInstanceId获取当前Task
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月17日下午5:41:22
	 * @param processInstanceId 实例id
	 * @return Task 任务
	 * 
	 */
	public Task getTaskByProcessInstaceId(String processInstanceId);
}