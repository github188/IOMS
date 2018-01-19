package cn.com.atnc.ioms.entity.news;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.news.NewsColumnsEnum;
import cn.com.atnc.ioms.enums.news.NewsStatusEnum;
/**
 * 通知公告
 * @author WhiteYj
 * @time 2014-5-7 14:00
 * @version 1.0
 */
@Entity
@Table(name = "TB_OM_PN_NOTICE")
public class News extends StringUUIDEntity {

    /*ID  主键ID    VARCHAR2(32)
    COLUMN  栏目，枚举字段：对应客服平台发布静态信息的栏目 VARCHAR2(20)
    TITLE   标题  VARCHAR2(20)
    CONTENT 内容。 CLOB
    CREATE_USER 创建者 VARCHAR2(32)
    CREATE_TIME 创建时间    DATE
    STATUS  状态，枚举字段。    VARCHAR2(30)
    PUBLISH_USER    发布人 VARCHAR2(32)
    PUBLISH_TIME    发布时间    DATE*/

    /**
     * 
     */
    private static final long serialVersionUID = -2249162453482873628L;
    // 基本属性
    private NewsColumnsEnum columns;  //栏目
    private String title;   //标题 
    private String content; //内容
    private User createUser;  //创建者
    private Date createTime;    //创建时间
    private NewsStatusEnum status;      //状态，枚举字段
    private String publishUser; //发布人
    private Date publishTime; //发布时间
    // 扩展属性
    private String processInstanceId;// 关联ACTIVITI工作流的流程实例id
    private String currentTaskName;// 当前任务名称
    private String currentAuditer;// 当前审批人员
    private String auditerList;// 参与审批人员列表
    
    private transient Task task;// 流程任务
    private transient Map<String, Object> variables;// 流程变量
    private transient ProcessInstance processInstance;// 运行中的流程实例
    private transient HistoricProcessInstance historicProcessInstance;// 历史的流程实例
    private transient ProcessDefinition processDefinition;// 流程定义
    
    // get/set
    @Enumerated(EnumType.STRING)
    @Column
    public NewsColumnsEnum getColumns() {
        return columns;
    }
    public void setColumns(NewsColumnsEnum columns) {
        this.columns = columns;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    @ManyToOne
    @JoinColumn(name="CREATE_USER")
    public User getCreateUser() {
        return createUser;
    }
    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }
    @Column(name = "CREATE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Enumerated(EnumType.STRING)
    @Column
    public NewsStatusEnum getStatus() {
        return status;
    }
    public void setStatus(NewsStatusEnum status) {
        this.status = status;
    }
    @Column(name = "PUBLISH_USER")
    public String getPublishUser() {
        return publishUser;
    }
    public void setPublishUser(String publishUser) {
        this.publishUser = publishUser;
    }
    @Column(name = "PUBLISH_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getPublishTime() {
        return publishTime;
    }
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
    /**
     * 扩展属性方法
     */
    @Column(name = "PROCESS_INSTANCE_ID")
    public String getProcessInstanceId() {
        return processInstanceId;
    }
    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }
    
    @Column(name = "TASKNAME")
    public String getCurrentTaskName() {
        return currentTaskName;
    }
    public void setCurrentTaskName(String currentTaskName) {
        this.currentTaskName = currentTaskName;
    }
    
    @Column(name = "CURRENT_AUDIT_CLIENT")
    public String getCurrentAuditer() {
        return currentAuditer;
    }
    public void setCurrentAuditer(String currentAuditer) {
        this.currentAuditer = currentAuditer;
    }

    @Column(name = "AUDIT_LIST")
    public String getAuditerList() {
        return auditerList;
    }
    public void setAuditerList(String auditerList) {
        this.auditerList = auditerList;
    }
    
    @Transient
    public Task getTask() {
        return task;
    }
    public void setTask(Task task) {
        this.task = task;
    }
    
    @Transient
    public Map<String, Object> getVariables() {
        return variables;
    }
    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }

    @Transient
    public ProcessInstance getProcessInstance() {
        return processInstance;
    }
    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }

    @Transient
    public HistoricProcessInstance getHistoricProcessInstance() {
        return historicProcessInstance;
    }
    public void setHistoricProcessInstance(HistoricProcessInstance historicProcessInstance) {
        this.historicProcessInstance = historicProcessInstance;
    }

    @Transient
    public ProcessDefinition getProcessDefinition() {
        return processDefinition;
    }
    public void setProcessDefinition(ProcessDefinition processDefinition) {
        this.processDefinition = processDefinition;
    }
}
