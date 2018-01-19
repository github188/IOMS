package cn.com.atnc.ioms.entity.publicnotice;

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

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.publicnotice.PnNoticeColumnEnum;
import cn.com.atnc.ioms.enums.publicnotice.PnNoticeStatusEnum;

/**
 * 通知公告实体类
 * @author:lizhisheng
 * @date:2014-4-25 上午10:28:38
 * @version:1.0
 */
@Entity
@Table(name = "TB_OM_PN_NOTICE")
public class PnNotice extends MyStringUUIDEntity{

	private static final long serialVersionUID = -5090193849161519091L;
	private PnNoticeColumnEnum columns;//栏目，枚举类型
	private String title;//标题
	private String content;//内容
	private User createUser;//创建者
	private Date createTime;//创建时间
	private PnNoticeStatusEnum status;//状态，枚举类型
	//private User publishUser;//发布者
	//private Date publishTime;//发布时间
	private String processInstanceId;// 关联ACTIVITI工作流的流程实例id
	private String currentTaskName;// 当前任务名称
	private String currentAuditer;// 当前审批人员
	private String auditerList;// 参与审批人员列表
	// -- 附加属性 --//
	private transient Task task;// 流程任务
	private transient Map<String, Object> variables;// 流程变量
	private transient ProcessInstance processInstance;// 运行中的流程实例
	private transient HistoricProcessInstance historicProcessInstance;// 历史的流程实例
	private transient ProcessDefinition processDefinition;// 流程定义
		
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

	@Column(name = "PROCESS_INSTANCE_ID")
	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}		
	@Enumerated(EnumType.STRING)
	@Column(name="COLUMNS")
	public PnNoticeColumnEnum getColumns() {
		return columns;
	}
	public void setColumns(PnNoticeColumnEnum columns) {
		this.columns = columns;
	}
	
	@Column(name="TITLE")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="CONTENT",columnDefinition="clob")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	//	@Column(name="CONTENT")
//	public Clob getContent() {
//		return content;
//	}
//	public void setContent(Clob content) {
//		this.content = content;
//	}
//	public String getContent() {
//		return content;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
//	
	@ManyToOne
	@JoinColumn(name="CREATE_USER")
	public User getCreateUser() {
		return createUser;
	}
	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
	@Column(name="CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Enumerated(EnumType.STRING)
	@Column
	public PnNoticeStatusEnum getStatus() {
		return status;
	}
	public void setStatus(PnNoticeStatusEnum status) {
		this.status = status;
	}
//	@ManyToOne
//	@JoinColumn(name="PUBLISH_USER")
//	public User getPublishUser() {
//		return publishUser;
//	}
//	public void setPublishUser(User publishUser) {
//		this.publishUser = publishUser;
//	}
//	@Column(name="PUBLISH_TIME")
//	public Date getPublishTime() {
//		return publishTime;
//	}
//	public void setPublishTime(Date publishTime) {
//		this.publishTime = publishTime;
//	}
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
	public void setHistoricProcessInstance(
			HistoricProcessInstance historicProcessInstance) {
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
