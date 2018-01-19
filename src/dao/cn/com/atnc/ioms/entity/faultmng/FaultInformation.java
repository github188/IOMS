package cn.com.atnc.ioms.entity.faultmng;

import java.util.Date;
import java.util.List;
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
import cn.com.atnc.ioms.enums.faultmng.FaultEvaluateStatus;
import cn.com.atnc.ioms.enums.faultmng.FaultEventType;
import cn.com.atnc.ioms.enums.faultmng.FaultLevelType;
import cn.com.atnc.ioms.enums.faultmng.FaultOriginType;
import cn.com.atnc.ioms.enums.faultmng.FaultStatus;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;

/**
 * 故障单信息
 * 
 * @author duanyanlin 2016年6月17日 下午2:07:30
 */
@Entity
@Table(name = "TB_FM_FAULT_INFORMATION")
public class FaultInformation extends MyStringUUIDEntity {
	private static final long serialVersionUID = -6739376065386900888L;
	private String faultNumber; // 故障单编号
	private Integer faultChildNumber; // 子级故障单编号
	private String telephoneNumber; // 申告电话
	private String contactsName; // 申告联系人
	private Date faultTime; // 故障发生时间
	private Date pickUpPhoneTime; // 摘机时间
	private String faultArea; // 故障发生区域
	private FaultEventType eventType; // 故障类别
	private Integer stationNumber; // 坐席号
	private String remark; // 备注
	private String stepInfo; // 当前步骤
	private User firstHandelUser; // 第一处理人
	private Date createTime; // 故障单创建时间
	private String callingId; // 拨打电话信息表的ID
	private String currentHandleUser; // 当前处理人
	private FaultInformation faultParentId; // 父级故障单ID
	private FaultOriginType source; // 故障单来源
	private FaultStatus faultStatus; // 故障单当前状态
	private FaultTypeParent faultTypeId; // 故障单类型父类ID
	private FaultTypeSon faultTypeChildId; // 故障单类型子类ID
	private Integer faultDeviceNumber; // 故障设备数量
	private Integer effectProfessionNumber; // 影响业务数量
	private DutyPlaceEnum dutyPlace; // 当前添加故障单时，第一处理人的值班地点
	private FaultLevelType faultLevel; // 故障级别
	private String stationPhone; // 坐席电话
	private String faultCompany; // 故障单位
	private Date updateTime; // 故障单修改更新时间
	private String updateUser;	//故障单更新处理人
	private String processInstanceId;  //流程ID
	private String taskName;  //任务名
	private String backups;	//是否备份
	private String renew;  //是否立即恢复
	private String serviceType;  //业务类型
	private FaultEvaluateStatus faultEvaluateStatus;  //事件单评价状态

	// -- 附加属性 --//
	private transient Task task;// 流程任务
	private transient Map<String, Object> variables;// 流程变量
	private transient ProcessInstance processInstance;// 运行中的流程实例
	private transient HistoricProcessInstance historicProcessInstance;// 历史的流程实例
	private transient ProcessDefinition processDefinition;// 流程定义
	
	/** 冗余属性 */
	private transient List<FaultInformation> faultInformations;	//该故障单的所有子故障单
	private transient List<FaultHandle> faultHandles;				//该故障单的所有处理记录
	
	private transient boolean hasHandleUser = true;				//任务单的当前处理人是否包含当前登录用户
	
	@Enumerated(EnumType.STRING)
	@Column(name = "FAULT_EVALUATE")
	public FaultEvaluateStatus getFaultEvaluateStatus() {
		return faultEvaluateStatus;
	}

	public void setFaultEvaluateStatus(FaultEvaluateStatus faultEvaluateStatus) {
		this.faultEvaluateStatus = faultEvaluateStatus;
	}

	@Column(name = "BACKUPS")
	public String getBackups() {
		return backups;
	}

	public void setBackups(String backups) {
		this.backups = backups;
	}

	@Column(name = "RENEW")
	public String getRenew() {
		return renew;
	}

	public void setRenew(String renew) {
		this.renew = renew;
	}

	@Column(name = "SERVICETYPE")
	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	@Transient
	public boolean isHasHandleUser() {
		return hasHandleUser;
	}

	public void setHasHandleUser(boolean hasHandleUser) {
		this.hasHandleUser = hasHandleUser;
	}

	@Column(name = "UPDATE_USER")
	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Transient
	public List<FaultInformation> getFaultInformations() {
		return faultInformations;
	}

	public void setFaultInformations(List<FaultInformation> faultInformations) {
		this.faultInformations = faultInformations;
	}

	@Transient
	public List<FaultHandle> getFaultHandles() {
		return faultHandles;
	}

	public void setFaultHandles(List<FaultHandle> faultHandles) {
		this.faultHandles = faultHandles;
	}

	@Column(name = "PROCESS_INSTANCE_ID")
	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	@Column(name = "TASK_NAME")
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
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

	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "STATION_PHONE")
	public String getStationPhone() {
		return this.stationPhone;
	}

	public void setStationPhone(String stationPhone) {
		this.stationPhone = stationPhone;
	}

	@Column(name = "FAULT_COMPANY")
	public String getFaultCompany() {
		return this.faultCompany;
	}

	public void setFaultCompany(String faultCompany) {
		this.faultCompany = faultCompany;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "FAULT_LEVEL")
	public FaultLevelType getFaultLevel() {
		return this.faultLevel;
	}

	public void setFaultLevel(FaultLevelType faultLevel) {
		this.faultLevel = faultLevel;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "DUTY_PLACE")
	public DutyPlaceEnum getDutyPlace() {
		return this.dutyPlace;
	}

	public void setDutyPlace(DutyPlaceEnum dutyPlace) {
		this.dutyPlace = dutyPlace;
	}

	@Column(name = "FAULT_NUMBER")
	public String getFaultNumber() {
		return this.faultNumber;
	}

	public void setFaultNumber(String faultNumber) {
		this.faultNumber = faultNumber;
	}

	@Column(name = "FAULT_CHILD_NUMBER")
	public Integer getFaultChildNumber() {
		return this.faultChildNumber;
	}

	public void setFaultChildNumber(Integer faultChildNumber) {
		this.faultChildNumber = faultChildNumber;
	}

	@Column(name = "TELEPHONE_NUMBER")
	public String getTelephoneNumber() {
		return this.telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	@Column(name = "CONTACTS_NAME")
	public String getContactsName() {
		return this.contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	@Column(name = "FAULT_TIME")
	public Date getFaultTime() {
		return this.faultTime;
	}

	public void setFaultTime(Date faultTime) {
		this.faultTime = faultTime;
	}

	@Column(name = "PICK_UP_PHONE_TIME")
	public Date getPickUpPhoneTime() {
		return this.pickUpPhoneTime;
	}

	public void setPickUpPhoneTime(Date pickUpPhoneTime) {
		this.pickUpPhoneTime = pickUpPhoneTime;
	}

	@Column(name = "FAULT_AREA")
	public String getFaultArea() {
		return this.faultArea;
	}

	public void setFaultArea(String faultArea) {
		this.faultArea = faultArea;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "EVENT_TYPE")
	public FaultEventType getEventType() {
		return this.eventType;
	}

	public void setEventType(FaultEventType eventType) {
		this.eventType = eventType;
	}

	@Column(name = "STATION_NUMBER")
	public Integer getStationNumber() {
		return this.stationNumber;
	}

	public void setStationNumber(Integer stationNumber) {
		this.stationNumber = stationNumber;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "STEP_INFO")
	public String getStepInfo() {
		return this.stepInfo;
	}

	public void setStepInfo(String stepInfo) {
		this.stepInfo = stepInfo;
	}

	@ManyToOne
	@JoinColumn(name = "FIRST_HANDLE_USER_ID")
	public User getFirstHandelUser() {
		return this.firstHandelUser;
	}

	public void setFirstHandelUser(User firstHandelUser) {
		this.firstHandelUser = firstHandelUser;
	}

	@Column(name = "CREATE_TIME")
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "CALLING_ID")
	public String getCallingId() {
		return this.callingId;
	}

	public void setCallingId(String callingId) {
		this.callingId = callingId;
	}

	@Column(name = "CURRENT_HANDLE_USER_ID")
	public String getCurrentHandleUser() {
		return this.currentHandleUser;
	}

	public void setCurrentHandleUser(String currentHandleUser) {
		this.currentHandleUser = currentHandleUser;
	}

	@ManyToOne
	@JoinColumn(name = "FAULT_PARENT_ID")
	public FaultInformation getFaultParentId() {
		return this.faultParentId;
	}

	public void setFaultParentId(FaultInformation faultParentId) {
		this.faultParentId = faultParentId;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SOURCE")
	public FaultOriginType getSource() {
		return this.source;
	}

	public void setSource(FaultOriginType source) {
		this.source = source;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "FAULT_STATUS")
	public FaultStatus getFaultStatus() {
		return this.faultStatus;
	}

	public void setFaultStatus(FaultStatus faultStatus) {
		this.faultStatus = faultStatus;
	}
	
	@ManyToOne
	@JoinColumn(name = "FAULT_TYPE_ID")
	public FaultTypeParent getFaultTypeId() {
		return this.faultTypeId;
	}

	public void setFaultTypeId(FaultTypeParent faultTypeId) {
		this.faultTypeId = faultTypeId;
	}
	
	@ManyToOne
	@JoinColumn(name = "FAULT_TYPE_CHILD_ID")
	public FaultTypeSon getFaultTypeChildId() {
		return this.faultTypeChildId;
	}

	public void setFaultTypeChildId(FaultTypeSon faultTypeChildId) {
		this.faultTypeChildId = faultTypeChildId;
	}

	@Column(name = "FAULT_DEVICE_NUMBER")
	public Integer getFaultDeviceNumber() {
		return this.faultDeviceNumber;
	}

	public void setFaultDeviceNumber(Integer faultDeviceNumber) {
		this.faultDeviceNumber = faultDeviceNumber;
	}

	@Column(name = "EFFECT_PROFESSION_NUMBER")
	public Integer getEffectProfessionNumber() {
		return this.effectProfessionNumber;
	}

	public void setEffectProfessionNumber(Integer effectProfessionNumber) {
		this.effectProfessionNumber = effectProfessionNumber;
	}
}