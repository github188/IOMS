package cn.com.atnc.ioms.mng.news;

import java.util.List;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import cn.com.atnc.ioms.entity.news.News;

/**
 * 类说明:通知公告工作流方法
 * @author WhiteYj
 * @date 2014-05-08 1650
 */
public interface INewsWorkflowService {

    /**
     * 
     * 方法说明：启动流程
     * 
     * @author WhiteYj
     * @date 2014-05-08 1650
     * @param entity
     * @param variables
     * @return ProcessInstance
     * 
     */
    public abstract ProcessInstance startWorkflow(News entity, Map<String, Object> variables);

    /**
     * 
     * 方法说明：根据用户查询该用户的待办任务
     * 
     * @author WhiteYj
     * @date 2014-05-08 1650
     * @param userId
     * @return List<TempCircuit>
     * 
     */
    public abstract List<News> findTodoTasks(String userId);

    /**
     * 
     * 方法说明：根据用户查询该用户的待办任务数量
     * 
     * @author WhiteYj
     * @date 2014-05-08 1650
     * @param userId
     * @return Integer
     * public Integer findTodoTasksSize(String userId);
     */
    
    /**
     * 
     * 方法说明：读取所有运行中的流程
     * 
     * @author WhiteYj
     * @date 2014-05-08 1650
     * @return List
     * 
     */
    public abstract List<News> findRunningProcessInstaces();

    /**
     * 
     * 方法说明：读取特定申请用户所有运行中的流程
     * 
     * @author WhiteYj
     * @date 2014-05-08 1650
     * @return List
     * 
     */
    public abstract List<News> findRunningProcessInstaces(String userId);

    /**
     * 
     * 方法说明：读取所有已结束中的流程
     * 
     * @author WhiteYj
     * @date 2014-05-08 1650
     * @return List
     * 
     */
    public abstract List<News> findFinishedProcessInstaces();

    /**
     * 
     * 方法说明：读取特定申请用户所有已结束中的流程
     * 
     * @author WhiteYj
     * @date 2014-05-08 1650
     * @return List
     * 
     */
    public abstract List<News> findFinishedProcessInstaces(String userId);

    /**
     * 
     * 方法说明：完成流程或流程中的一步
     * 
     * @author WhiteYj
     * @date 2014-05-08 1650
     * @param taskID
     * @param taskVariables
     */
    public abstract void complete(String taskID, Map<String, Object> taskVariables);

    /**
     * 方法说明：委派用户
     * @param taskID
     * @param loginName
     */
    public void delegateTask(String taskID, String loginName);

    /**
     * 方法说明：查询委派的任务
     * @param loginName
     * @return
     */
    public abstract List<News> findDelegationProcessInstaces(String loginName);
    
    
    /**
     * 方法说明：被指派人完成任务
     * @param taskId
     * @param userId
     */
    public void resolve(String taskId, Map<String, Object> taskVariables);
    /**
     * 
     * 方法说明：签收
     * 
     * @author WhiteYj
     * @date 2014-05-08 1650
     */
    public abstract void claim(String taskId, String userId);

    /**
     * 
     * 方法说明：删除task
     * 
     * @author WhiteYj
     * @date 2014-05-08 1650
     * @param taskId
     */
    public abstract void delete(String taskId);

    /**
     * 
     * 方法说明：根据processInstanceId获取当前Task
     * 
     * @author WhiteYj
     * @date 2014-05-08 1650
     * @param id
     * @return Task
     */
    public Task getTaskByProcessInstaceId(String processInstanceId);
}
