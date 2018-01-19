package cn.com.atnc.ioms.entity.tempcircuit;

import java.util.Calendar;
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
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitCancelType;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitExpireType;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitStatus;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitType;

/**
 * 类说明：临时电路申请表
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月26日下午5:52:59
 * @version:1.0
 */
@Entity
@Table(name = "TB_OM_TEMP_CIRCUIT")
public class TempCircuit extends StringUUIDEntity {
	private static final long serialVersionUID = -4208601207797418627L;
	/**
	 * 电路申请编号
	 */
	private String number;
	/**
	 * 临时电路类型
	 */
	private CircuitType circuitType;
	/**
	 * 临时电路状态
	 */
	private CircuitStatus circuitStatus;
	/**
	 * 临时电路本端节点
	 */
	private Equip aEquip;
	/**
	 * 临时电路对端节点
	 */
	private Equip zEquip;
	/**
	 * 为了保证前后台统一，该字段记录临时电路申请用户ID
	 */
	private String applyUserId;
	/**
	 * 为了保证前后台统一，该字段记录临时电路申请用户longinName
	 */
	private String applyUserName;
	/**
	 * 电路申请单位
	 */
	private String applyCompany;
	/**
	 * 联系人
	 */
	private String linkMan;
	/**
	 * 联系人电话
	 */
	private String linkPhone;
	/**
	 * 联系人Email
	 */
	private String linkEmail;
	/**
	 * 临时电路开通日期
	 */
	private Calendar planOpenTime;
	/**
	 * 临时电路到期日期
	 */
	private Calendar planEndTime;
	/**
	 * 临时电路备注信息
	 */
	private String circuitInfo;
	/**
	 * 电路申请编号
	 */
	private Calendar recordTime;//
	/**
	 * 临时电路申请时间
	 */
	private Calendar updateTime;//
	/**
	 * 关联ACTIVITI工作流的流程实例id
	 */
	private String processInstanceId;
	/**
	 * 关联ACTIVITI工作流的当前任务名称
	 */
	private String currentTaskName;
	/**
	 * 是否申请延期标志
	 */
	private boolean applyDelay;
	/**
	 * 电路撤单申请是否已经确认标志，用户发起撤单请求并且该申请网控已经分配了工程师来处理时，该撤单请求必须网控工程师本人确认
	 */
	private boolean ackDelete;
	/**
	 * 电路到期状态
	 */
	private CircuitExpireType circuitExpireType;
	/**
	 * 电路撤销方式
	 */
	private CircuitCancelType circuitCancelType;
	/**
	 * 当前审批人员的longinName
	 */
	private String currentAuditer;
	/**
	 * 参与审批人员ID列表，以“|”分割
	 */
	private String auditerList;
	/**
	 * 分配负责该电路开通的工程师的longinName
	 */
	private String engineerName;
	/**
	 * 临时电路申请类型状态，SUBMITTED("地方工程师提交申请"),ATNCSUBMITTED("网控工程师提交申请"),
	 */
	private CircuitStatus circuitApplyType;

	private boolean atncaudit;// 电路申请是否到达网控
	// -- 附加属性 --//
	/**
	 * 流程任务
	 */
	private transient Task task;
	/**
	 * 流程变量
	 */
	private transient Map<String, Object> variables;
	/**
	 * 运行中的流程实例
	 */
	private transient ProcessInstance processInstance;
	/**
	 * 历史的流程实例
	 */
	private transient HistoricProcessInstance historicProcessInstance;
	/**
	 * 流程定义
	 */
	private transient ProcessDefinition processDefinition;
	/**
	 * 临时电路本端节点ID
	 */
	private transient String aEquipID;

	private transient String aNodeView;
	/**
	 * 临时电路对端节点ID
	 */
	private transient String zEquipID;

	private transient String zNodeView;
	/**
	 * 临时电路开通日期字符串
	 */
	private transient String planOpenTimeStr;
	
	private boolean send;

	@Column(name = "PROCESS_INSTANCE_ID")
	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	@Column(name = "CIRCUIT_NUM")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "CIRCUIT_TYPE")
	public CircuitType getCircuitType() {
		return circuitType;
	}

	public void setCircuitType(CircuitType circuitType) {
		this.circuitType = circuitType;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "CIRCUIT_APPLY_TYPE")
	public CircuitStatus getCircuitApplyType() {
		return circuitApplyType;
	}

	public void setCircuitApplyType(CircuitStatus circuitApplyType) {
		this.circuitApplyType = circuitApplyType;
	}

	@Column(name = "CLIENT_ID")
	public String getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(String applyUserId) {
		this.applyUserId = applyUserId;
	}

	@Column(name = "CLIENT_LOGINNAME")
	public String getApplyUserName() {
		return applyUserName;
	}

	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "CURRENT_STATUS")
	public CircuitStatus getCircuitStatus() {
		return circuitStatus;
	}

	public void setCircuitStatus(CircuitStatus circuitStatus) {
		this.circuitStatus = circuitStatus;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "CIRCUIT_EXPIRE_TYPE")
	public CircuitExpireType getCircuitExpireType() {
		return circuitExpireType;
	}

	public void setCircuitExpireType(CircuitExpireType circuitExpireType) {
		this.circuitExpireType = circuitExpireType;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "CIRCUIT_CANCEL_TYPE")
	public CircuitCancelType getCircuitCancelType() {
		return circuitCancelType;
	}

	public void setCircuitCancelType(CircuitCancelType circuitCancelType) {
		this.circuitCancelType = circuitCancelType;
	}

	@Column(name = "REMARK")
	public String getCircuitInfo() {
		return circuitInfo;
	}

	public void setCircuitInfo(String circuitInfo) {
		this.circuitInfo = circuitInfo;
	}

	@ManyToOne
	@JoinColumn(name = "A_EQUIP")
	public Equip getaEquip() {
		return aEquip;
	}

	public void setaEquip(Equip aEquip) {
		this.aEquip = aEquip;
	}

	@ManyToOne
	@JoinColumn(name = "Z_EQUIP")
	public Equip getzEquip() {
		return zEquip;
	}

	public void setzEquip(Equip zEquip) {
		this.zEquip = zEquip;
	}

	@Column(name = "APPLY_COMPANY")
	public String getApplyCompany() {
		return applyCompany;
	}

	public void setApplyCompany(String applyCompany) {
		this.applyCompany = applyCompany;
	}

	@Column(name = "LINKMAN")
	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	@Column(name = "LINKMAN_PHONE")
	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	@Column(name = "LINKMAN_EMAIL")
	public String getLinkEmail() {
		return linkEmail;
	}

	public void setLinkEmail(String linkEmail) {
		this.linkEmail = linkEmail;
	}

	@Column(name = "PREDICT_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Calendar getPlanOpenTime() {
		return planOpenTime;
	}

	public void setPlanOpenTime(Calendar planOpenTime) {
		this.planOpenTime = planOpenTime;
	}

	@Column(name = "END_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Calendar getPlanEndTime() {
		return planEndTime;
	}

	public void setPlanEndTime(Calendar planEndTime) {
		this.planEndTime = planEndTime;
	}

	@Column(name = "TASKNAME")
	public String getCurrentTaskName() {
		return currentTaskName;
	}

	public void setCurrentTaskName(String currentTaskName) {
		this.currentTaskName = currentTaskName;
	}

	@Column(name = "APPLYDELAY")
	public boolean isApplyDelay() {
		return applyDelay;
	}

	public void setApplyDelay(boolean applyDelay) {
		this.applyDelay = applyDelay;
	}

	@Column(name = "ACK_DELETE")
	public boolean isAckDelete() {
		return ackDelete;
	}

	public void setAckDelete(boolean ackDelete) {
		this.ackDelete = ackDelete;
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

	@Column(name = "ENGINEER_NAME")
	public String getEngineerName() {
		return engineerName;
	}

	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}

	@Column(name = "RECORD_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Calendar getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Calendar recordTime) {
		this.recordTime = recordTime;
	}

	@Column(name = "UPDATE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Calendar getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Calendar updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "ATNC_AUDIT")
	public boolean isAtncaudit() {
		return atncaudit;
	}

	public void setAtncaudit(boolean atncaudit) {
		this.atncaudit = atncaudit;
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

	@Transient
	public String getaEquipID() {
		return aEquipID;
	}

	public void setaEquipID(String aEquipID) {
		this.aEquipID = aEquipID;
	}

	@Transient
	public String getzEquipID() {
		return zEquipID;
	}

	public void setzEquipID(String zEquipID) {
		this.zEquipID = zEquipID;
	}

	@Transient
	public String getPlanOpenTimeStr() {
		return planOpenTimeStr;
	}

	public void setPlanOpenTimeStr(String planOpenTimeStr) {
		this.planOpenTimeStr = planOpenTimeStr;
	}

	@Transient
	public String getaNodeView() {
		return aNodeView;
	}

	public void setaNodeView(String aNodeView) {
		this.aNodeView = aNodeView;
	}

	@Transient
	public String getzNodeView() {
		return zNodeView;
	}

	public void setzNodeView(String zNodeView) {
		this.zNodeView = zNodeView;
	}

	@Column(name = "SEND")
	public boolean getSend() {
		return send;
	}

	public void setSend(boolean send) {
		this.send = send;
	}

}
