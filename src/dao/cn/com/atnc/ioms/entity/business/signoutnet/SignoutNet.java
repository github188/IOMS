package cn.com.atnc.ioms.entity.business.signoutnet;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.enums.basedata.SubnetType;
import cn.com.atnc.ioms.enums.business.satellite.ApproveStatEnum;
import cn.com.atnc.ioms.enums.business.signoutnet.SignoutNetTypeEnum;
import cn.com.atnc.ioms.enums.business.signoutnet.SiteSystemEnum;

/**
 * 通信网退网基础信息类
 *
 * @author 段衍林
 * @2017年1月10日 上午10:09:35
 */
@Entity
@Table(name = "TB_OM_APPLY_SIGNOUTNET")
public class SignoutNet extends MyStringUUIDEntity {

	private static final long serialVersionUID = -6784466240377490883L;

	private ApplyBaseInfo applyBaseInfo; // 各种申请抽象信息
	private String applyComSign; // 公司签字
	private String siteName; // 站点名称
	private String siteCode; // 站点代码
	private String nodeCodes; // 节点代码（可能多个）
	private SubnetType subnetType;// 子网类型
	private String caseNum;// 机箱号（可能多个）
	private String nodeNum;// 节点号（可能多个）
	private SiteSystemEnum siteSystem; // 站点所属系统
	private SignoutNetTypeEnum dealType; // 退网操作类型
	private String reason; // 退网原因
	private String equip; // 退网设备

	private String initApproveCom; // 初审公司
	private String initApproveSign;// 负责人签字
	private String initApproveOpinion; // 初审意见
	private String finalApproveCom; // 终审单位
	private String finalApproveSign;// 负责人签字
	private String finalApproveOpinion;// 终审意见
	private ApproveStatEnum approveStat; // 审批状态
	private String processInstanceId; // 流程实例ID
	private String taskName; // 任务名
	// -- 附加属性 --//
	private transient Task task;// 流程任务
	private transient Map<String, Object> variables;// 流程变量
	private transient ProcessInstance processInstance;// 运行中的流程实例
	private transient HistoricProcessInstance historicProcessInstance;// 历史的流程实例
	private transient ProcessDefinition processDefinition;// 流程定义

	private Integer cachetApprove = 0; // 用印审批：1代表通过，0代表不通过

	@Column(name = "SITE_NAME")
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	@Column(name = "SITE_CODE")
	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SUBNET_TYPE")
	public SubnetType getSubnetType() {
		return subnetType;
	}

	public void setSubnetType(SubnetType subnetType) {
		this.subnetType = subnetType;
	}

	@Column(name = "CASE_NUM")
	public String getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(String caseNum) {
		this.caseNum = caseNum;
	}

	@Column(name = "NODE_NUM")
	public String getNodeNum() {
		return nodeNum;
	}

	public void setNodeNum(String nodeNum) {
		this.nodeNum = nodeNum;
	}

	@Column(name = "NODE_CODES")
	public String getNodeCodes() {
		return nodeCodes;
	}

	public void setNodeCodes(String nodeCodes) {
		this.nodeCodes = nodeCodes;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SITE_SYSTEM")
	public SiteSystemEnum getSiteSystem() {
		return siteSystem;
	}

	public void setSiteSystem(SiteSystemEnum siteSystem) {
		this.siteSystem = siteSystem;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE")
	public SignoutNetTypeEnum getDealType() {
		return dealType;
	}

	public void setDealType(SignoutNetTypeEnum dealType) {
		this.dealType = dealType;
	}

	@Column(name = "REASON")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name = "EQUIP")
	public String getEquip() {
		return equip;
	}

	public void setEquip(String equip) {
		this.equip = equip;
	}

	@OneToOne
	@JoinColumn(name = "apply_baseinfo")
	public ApplyBaseInfo getApplyBaseInfo() {
		return applyBaseInfo;
	}

	public void setApplyBaseInfo(ApplyBaseInfo applyBaseInfo) {
		this.applyBaseInfo = applyBaseInfo;
	}

	@Column(name = "apply_com_sign")
	public String getApplyComSign() {
		return applyComSign;
	}

	public void setApplyComSign(String applyComSign) {
		this.applyComSign = applyComSign;
	}

	@Column(name = "init_approve_com")
	public String getInitApproveCom() {
		return initApproveCom;
	}

	public void setInitApproveCom(String initApproveCom) {
		this.initApproveCom = initApproveCom;
	}

	@Column(name = "init_approve_sign")
	public String getInitApproveSign() {
		return initApproveSign;
	}

	public void setInitApproveSign(String initApproveSign) {
		this.initApproveSign = initApproveSign;
	}

	@Column(name = "init_approve_opinion")
	public String getInitApproveOpinion() {
		return initApproveOpinion;
	}

	public void setInitApproveOpinion(String initApproveOpinion) {
		this.initApproveOpinion = initApproveOpinion;
	}

	@Column(name = "final_approve_com")
	public String getFinalApproveCom() {
		return finalApproveCom;
	}

	public void setFinalApproveCom(String finalApproveCom) {
		this.finalApproveCom = finalApproveCom;
	}

	@Column(name = "final_approve_sign")
	public String getFinalApproveSign() {
		return finalApproveSign;
	}

	public void setFinalApproveSign(String finalApproveSign) {
		this.finalApproveSign = finalApproveSign;
	}

	@Column(name = "final_approve_opinion")
	public String getFinalApproveOpinion() {
		return finalApproveOpinion;
	}

	public void setFinalApproveOpinion(String finalApproveOpinion) {
		this.finalApproveOpinion = finalApproveOpinion;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "approve_stat")
	public ApproveStatEnum getApproveStat() {
		return approveStat;
	}

	public void setApproveStat(ApproveStatEnum approveStat) {
		this.approveStat = approveStat;
	}

	@Column(name = "process_instance_id")
	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	@Column(name = "task_name")
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

	@Column(name = "cachet_approve")
	public Integer getCachetApprove() {
		return cachetApprove;
	}

	public void setCachetApprove(Integer cachetApprove) {
		this.cachetApprove = cachetApprove;
	}
}
