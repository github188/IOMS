/**
 * 
 */
package cn.com.atnc.ioms.entity.techsupport.fault;

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

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.enums.techsupport.fault.AllStatus;
import cn.com.atnc.ioms.enums.techsupport.fault.DeclareType;
import cn.com.atnc.ioms.enums.techsupport.fault.FaultType;

/**
 * 类说明：故障申报实体类
 * 
 * @author KuYonggang
 * @date 2014-4-2下午8:06:35
 * @version 1.0
 */
@Entity
@Table(name = "tb_om_fault_declare")
public class FaultDeclare extends StringUUIDEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6418446832208748777L;
	
	private DeclareType declareType; //故障类别
	private Client client;	//客户ID
	private String contactPerson;//联系人
	private String contactNumber;//联系方式
	private FaultType faultType; //故障类型
	private String faultTypeSecond; //二级故障类型
	private Date faultTime; //故障申报时间
	private String faultKey;//故障关键字
	private String faultDesc;//故障描述
	private AllStatus faultStatus;//状态
	private Date updateTime;//更新时间
	private String updateUser;//下一步操作人姓名
	private String operUser;//当前操作人姓名
	private User user; //当前操作人ID
	private Date confirmTime;//预估用户确认时间
	private Date recordTime;//记录时间
	private String processInstanceId;// 关联ACTIVITI工作流的流程实例id
	private String currentTaskName;// 当前任务名称
	
	// -- 附加属性 --//
	private Task task;// 流程任务
	private Map<String, Object> variables;// 流程变量
	private ProcessInstance processInstance;// 运行中的流程实例
	private HistoricProcessInstance historicProcessInstance;// 历史的流程实例
	private ProcessDefinition processDefinition;// 流程定义
	
	@Enumerated(EnumType.STRING)
	@Column(name="DECLARE_TYPE")
	public DeclareType getDeclareType() {
		return declareType;
	}
	public void setDeclareType(DeclareType declareType) {
		this.declareType = declareType;
	}
	@ManyToOne
	@JoinColumn(name="CLIENTID")
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Column(name="CONTACT_PERSON")
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	@Column(name="CONTACT_NUMBER")
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="FAULT_TYPE")
	public FaultType getFaultType() {
		return faultType;
	}
	public void setFaultType(FaultType faultType) {
		this.faultType = faultType;
	}
	@Column(name="FAULT_TYPE_SECOND")
	public String getFaultTypeSecond() {
		return faultTypeSecond;
	}
	public void setFaultTypeSecond(String faultTypeSecond) {
		this.faultTypeSecond = faultTypeSecond;
	}
	@Column(name="FAULT_TIME",columnDefinition="date")
	public Date getFaultTime() {
		return faultTime;
	}
	public void setFaultTime(Date faultTime) {
		this.faultTime = faultTime;
	}
	@Column(name="FAULT_KEY")
	public String getFaultKey() {
		return faultKey;
	}
	public void setFaultKey(String faultKey) {
		this.faultKey = faultKey;
	}
	@Column(name="FAULT_DESC",columnDefinition="clob")
	public String getFaultDesc() {
		return faultDesc;
	}
	public void setFaultDesc(String faultDesc) {
		this.faultDesc = faultDesc;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	public AllStatus getFaultStatus() {
		return faultStatus;
	}
	public void setFaultStatus(AllStatus faultStatus) {
		this.faultStatus = faultStatus;
	}
	
	@Column(name="UPDATE_TIME",columnDefinition="date")
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	@ManyToOne
	@JoinColumn(name="USERID")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name="UPDATE_USER")
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	@Column(name="CONFIRM_TIME",columnDefinition="date")
	public Date getConfirmTime() {
		return confirmTime;
	}
	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}
	@Column(name="RECORD_TIME",columnDefinition="date")
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Column(name="PROCESS_INSTANCE_ID")
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	@Column(name="TASKNAME")
	public String getCurrentTaskName() {
		return currentTaskName;
	}
	public void setCurrentTaskName(String currentTaskName) {
		this.currentTaskName = currentTaskName;
	}
	@Column(name="OPER_USER")
	public String getOperUser() {
		return operUser;
	}
	public void setOperUser(String operUser) {
		this.operUser = operUser;
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
