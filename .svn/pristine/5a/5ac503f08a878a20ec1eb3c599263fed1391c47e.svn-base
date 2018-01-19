package cn.com.atnc.ioms.mng.news.impl;

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
import org.activiti.engine.task.DelegationState;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.news.INewsDao;
import cn.com.atnc.ioms.entity.news.News;
import cn.com.atnc.ioms.mng.news.INewsMngService;
import cn.com.atnc.ioms.mng.news.INewsWorkflowService;

/**
 * 类说明:通知公告工作流方法
 * @author WhtieYj
 * @date 2014-05-08 1640
 */
@Transactional
@Service("newsWorkflowServiceImpl")
public class NewsWorkflowServiceImpl implements INewsWorkflowService {

    private static Logger logger = LoggerFactory.getLogger(NewsWorkflowServiceImpl.class);
    @Autowired
    private INewsMngService newsMngService;
    @Autowired
    private INewsDao newsDao;
    
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
    @Override
    public ProcessInstance startWorkflow(News entity, Map<String, Object> variables) {
        String businessKey = entity.getId().toString();
        ProcessInstance processInstance = null;
        try {
            // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
            identityService.setAuthenticatedUserId(entity.getCreateUser().getId());
            
            processInstance = runtimeService.startProcessInstanceByKey("noticenews", businessKey, variables);
            String processInstanceId = processInstance.getId();
            entity.setProcessInstanceId(processInstanceId);
            Task task = this.getTaskByProcessInstaceId(processInstanceId);
            entity.setCurrentTaskName(task.getName());
            entity.setCurrentAuditer(task.getAssignee());
            //System.out.println("-------------------task.getAssignee():"+task.getAssignee());
            entity.setAuditerList(entity.getAuditerList() + task.getAssignee() + ",");
            // 因为有草稿直接提交所以用save or update方法执行
            newsMngService.update(entity);
            logger.debug("start process of {key={}, bkey={}, pid={}, variables={}}", new Object[] { "noticenews", businessKey, processInstanceId, variables });
            
//            for (ProcessDefinition processDefinition : repositoryService.createProcessDefinitionQuery().list()) {
//                System.out.println("num:"+processDefinition.getKey()+"    "+processDefinition.getName());
//                
//            }
            
        } catch (ServiceException e) {
            e.printStackTrace();
        } finally {
            identityService.setAuthenticatedUserId(null);
        }
        return processInstance;
    }
    /**
     * 
     * 方法说明：查询流程定义对象
     * 
     * @author WhiteYj
     * @date 2014-5-8 1640
     * @param processDefinitionId
     * @return ProcessDefinition
     * 
     */
    protected ProcessDefinition getProcessDefinition(String processDefinitionId) {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
        return processDefinition;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<News> findTodoTasks(String userId) {
        List<News> results = new ArrayList<News>();
        List<Task> tasks = new ArrayList<Task>();

        // 根据当前人的ID查询活动任务
        TaskQuery todoQuery = taskService.createTaskQuery().processDefinitionKey("noticenews").taskAssignee(userId).active().orderByTaskCreateTime().asc().orderByTaskCreateTime().desc();
        List<Task> todoList = todoQuery.list();
        
//        System.out.println("todolist:"+todoList.size());
        
        // 根据当前人的ID查询暂停（系统内用户申请撤销后置为暂停）任务
        TaskQuery suspendQuery = taskService.createTaskQuery().processDefinitionKey("noticenews").taskAssignee(userId).suspended().orderByTaskCreateTime().asc().orderByTaskCreateTime().desc();
        List<Task> suspendList = suspendQuery.list();

//        System.out.println("suspendList:"+suspendList.size());
        
        // 根据当前人未签收的任务
        //System.out.println(userId);
        TaskQuery claimQuery = taskService.createTaskQuery().processDefinitionKey("noticenews").taskCandidateUser(userId).active().orderByTaskCreateTime().asc().orderByTaskCreateTime().desc();
        List<Task> unsignedTasks = claimQuery.list();
        
//        System.out.println("unsignedTasks:"+unsignedTasks.size());
//        
//
//        TaskQuery query = taskService.createTaskQuery().processDefinitionKey("noticenews").taskAssignee(userId).taskCandidateUser(userId).taskAssignee(userId).active().orderByTaskCreateTime().asc().orderByTaskCreateTime().desc();
//        List<Task> qtasks = query.list();
//        
//        System.out.println("qtasks:"+qtasks.size());
        
        // 合并
        tasks.addAll(todoList);
        tasks.addAll(unsignedTasks);
        tasks.removeAll(suspendList);
        logger.debug("todoList:" + todoList.size());
        logger.debug("unsignedTasks:" + unsignedTasks.size());

        // 根据流程的业务ID查询实体并关联
        for (Task task : tasks) {
            String processInstanceId = task.getProcessInstanceId();
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
            String businessKey = processInstance.getBusinessKey();
            if (businessKey == null) {
                continue;
            }
            logger.debug("new String(businessKey):" + new String(businessKey));
            if(null==newsDao.findById(new String(businessKey))){
                break;
            }
            News news = newsDao.findById(new String(businessKey));
            news.setTask(task);
            news.setProcessDefinition(getProcessDefinition(processInstance.getProcessDefinitionId()));
            news.setProcessInstance(processInstance);
            results.add(news);
        }
        logger.debug("results:" + results.size());
        return results;
    }
    
    /*@Override
    @Transactional(readOnly = true)
    public Integer findTodoTasksSize(String userId) {
        List<News> listt = findTodoTasks(userId);
        int i=0;
        for(News temp:listt){
            if(temp.getStatus()==NewsStatusEnum.FIRSTED //部门经理审批
                    || temp.getStatus()==NewsStatusEnum.SECONDED 
                    || temp.getStatus()==NewsStatusEnum.PUBLISH){// 事业部领导审批
                i++;
            }
        }
        return i;
    }*/
    
    @Override
    @Transactional(readOnly = true)
    public List<News> findRunningProcessInstaces() {
        List<News> results = new ArrayList<News>();
        ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery().processDefinitionKey("noticenews").active().orderByProcessInstanceId().desc();
        List<ProcessInstance> list = query.list();

        // 关联业务实体
        for (ProcessInstance processInstance : list) {
            String businessKey = processInstance.getBusinessKey();
            if (businessKey == null) {
                continue;
            }
            News news = newsDao.findById(new String(businessKey));
            news.setProcessInstance(processInstance);
            news.setProcessDefinition(getProcessDefinition(processInstance.getProcessDefinitionId()));
            results.add(news);

            // 设置当前任务信息
            List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstance.getId()).active().orderByTaskCreateTime().desc().listPage(0, 1);
            news.setTask(tasks.get(0));
        }
        return results;
    }

    @Override
    @Transactional(readOnly = true)
    public List<News> findRunningProcessInstaces(String userId) {
        List<News> results = new ArrayList<News>();
        ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery().processDefinitionKey("noticenews").active().orderByProcessInstanceId().desc();
        query.variableValueEquals("addUserId", userId);
        List<ProcessInstance> list = query.list();

        // 关联业务实体
        for (ProcessInstance processInstance : list) {
            String businessKey = processInstance.getBusinessKey();
            if (businessKey == null) {
                continue;
            }
            News news = newsDao.findById(new String(businessKey));
            news.setProcessInstance(processInstance);
            news.setProcessDefinition(getProcessDefinition(processInstance.getProcessDefinitionId()));
            results.add(news);

            // 设置当前任务信息
            List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstance.getId()).active().orderByTaskCreateTime().desc().listPage(0, 1);
            news.setTask(tasks.get(0));
        }
        return results;
    }

    @Override
    @Transactional(readOnly = true)
    public List<News> findFinishedProcessInstaces() {
        List<News> results = new ArrayList<News>();
        HistoricProcessInstanceQuery query = historyService.createHistoricProcessInstanceQuery().processDefinitionKey("noticenews").finished().orderByProcessInstanceEndTime().asc();
        List<HistoricProcessInstance> list = query.list();

        // 关联业务实体
        for (HistoricProcessInstance historicProcessInstance : list) {
            String businessKey = historicProcessInstance.getBusinessKey();
            News news = newsDao.findById(new String(businessKey));
            news.setProcessDefinition(getProcessDefinition(historicProcessInstance.getProcessDefinitionId()));
            news.setHistoricProcessInstance(historicProcessInstance);
            results.add(news);
        }
        return results;
    }

    @Override
    public List<News> findFinishedProcessInstaces(String userId) {
        List<News> results = new ArrayList<News>();
        HistoricProcessInstanceQuery query = historyService.createHistoricProcessInstanceQuery().processDefinitionKey("noticenews").finished().orderByProcessInstanceEndTime().asc();
        query.variableValueEquals("addUserId", userId);
        List<HistoricProcessInstance> list = query.list();

        // 关联业务实体
        for (HistoricProcessInstance historicProcessInstance : list) {
            String businessKey = historicProcessInstance.getBusinessKey();
            News news = newsDao.findById(new String(businessKey));
            news.setProcessDefinition(getProcessDefinition(historicProcessInstance.getProcessDefinitionId()));
            news.setHistoricProcessInstance(historicProcessInstance);
            results.add(news);
        }
        return results;
    }

    @Override
    public void complete(String taskID, Map<String, Object> taskVariables) {
        taskService.complete(taskID, taskVariables);
    }

    // 委派代签收人
    @Override
    public void delegateTask(String taskID, String userId){
        taskService.delegateTask(taskID, userId);
    }
    // 查询委派的任务
    @Override
    public List<News> findDelegationProcessInstaces(String userId){
        List<News> results = new ArrayList<>();
        TaskQuery query = taskService.createTaskQuery().processDefinitionKey("noticenews").taskAssignee(userId).taskDelegationState(DelegationState.PENDING).orderByTaskCreateTime().asc().orderByTaskCreateTime().desc();
        List<Task> tasks = query.list();
        
        for (Task task : tasks) {
            String processInstanceId = task.getProcessInstanceId();
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
            String businessKey = processInstance.getBusinessKey();
            if (businessKey == null) {
                continue;
            }
            logger.debug("new String(businessKey):" + new String(businessKey));
            if(null==newsDao.findById(new String(businessKey))){
                break;
            }
            News news = newsDao.findById(new String(businessKey));
            news.setTask(task);
            news.setProcessDefinition(getProcessDefinition(processInstance.getProcessDefinitionId()));
            news.setProcessInstance(processInstance);
            results.add(news);
        }
        return results;
    }
    
    // 委派人完成任务
    @Override
    public void resolve(String taskId, Map<String, Object> taskVariables){
        taskService.resolveTask(taskId, taskVariables);
    }
    
    @Override
    public void claim(String taskId, String userId) {
        taskService.claim(taskId, userId);
    }

    @Override
    public void delete(String taskId) {
        taskService.deleteTask(taskId);
    }

    @Override
    public Task getTaskByProcessInstaceId(String processInstanceId) {
        return taskService.createTaskQuery().processInstanceId(processInstanceId).list().get(0);
    }

}
