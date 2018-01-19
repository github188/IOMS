package cn.com.atnc.ioms.entity.business.formalcircuit;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.enums.business.formalcircuit.ApplyOptTypeEnum;
import cn.com.atnc.ioms.enums.business.formalcircuit.FormalStatEnum;


 /**
 * 正式电路申请表基础信息
 *
 * @author Wang zhicheng
 * @date 2015年5月15日 下午3:13:41
 * @since 1.0.0
 */
@Entity
@Table(name="TB_OM_APPLY_FORMALCIRCUIT")
public class FormalCircuit extends MyStringUUIDEntity {

	private static final long serialVersionUID = -230402317666975182L;
	
	private ApplyBaseInfo applyBaseInfo;  //申请信息
	private ApplyOptTypeEnum applyOpttype;  //申请操作类型
	private String applySign;  //申请单位签字
	private String applyRemark;  //备注\其他要求
	private String areaOpinion;  //地区网络中心意见
	private String areaSign;  //地区网络中心负责人签字
	private String atncOpinion;  //天航信网络中心意见
	private String atncSign;  //天航信网络中心负责人签字
	private FormalStatEnum approveStat;  //审批状态
	private String processInstanceId;  //流程ID
	private String taskName;  //任务名
	private FormalCircuitConfig formalCircuitConfig;	//配置表
	private String num;  //第一次提交标识
	private Integer cachetApprove = 0;			//用印审批：1代表通过，0代表不通过
	
	// -- 附加属性 --//
	private transient Task task;// 流程任务
	private transient Map<String, Object> variables;// 流程变量
	private transient ProcessInstance processInstance;// 运行中的流程实例
	private transient HistoricProcessInstance historicProcessInstance;// 历史的流程实例
	private transient ProcessDefinition processDefinition;// 流程定义
	
	@ManyToOne
	@JoinColumn(name="apply_baseinfo")
	public ApplyBaseInfo getApplyBaseInfo() {
		return applyBaseInfo;
	}
	public void setApplyBaseInfo(ApplyBaseInfo applyBaseInfo) {
		this.applyBaseInfo = applyBaseInfo;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="apply_opttype")
	public ApplyOptTypeEnum getApplyOpttype() {
		return applyOpttype;
	}
	public void setApplyOpttype(ApplyOptTypeEnum applyOpttype) {
		this.applyOpttype = applyOpttype;
	}
	@Column(name="apply_sign")
	public String getApplySign() {
		return applySign;
	}
	public void setApplySign(String applySign) {
		this.applySign = applySign;
	}
	@Column(name="apply_remark")
	public String getApplyRemark() {
		return applyRemark;
	}
	public void setApplyRemark(String applyRemark) {
		this.applyRemark = applyRemark;
	}
	@Column(name="area_opinion")
	public String getAreaOpinion() {
		return areaOpinion;
	}
	public void setAreaOpinion(String areaOpinion) {
		this.areaOpinion = areaOpinion;
	}
	@Column(name="area_sign")
	public String getAreaSign() {
		return areaSign;
	}
	public void setAreaSign(String areaSign) {
		this.areaSign = areaSign;
	}
	@Column(name="atnc_opinion")
	public String getAtncOpinion() {
		return atncOpinion;
	}
	public void setAtncOpinion(String atncOpinion) {
		this.atncOpinion = atncOpinion;
	}
	@Column(name="atnc_sign")
	public String getAtncSign() {
		return atncSign;
	}
	public void setAtncSign(String atncSign) {
		this.atncSign = atncSign;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="approve_stat")
	public FormalStatEnum getApproveStat() {
		return approveStat;
	}
	public void setApproveStat(FormalStatEnum approveStat) {
		this.approveStat = approveStat;
	}
	@Column(name="process_instance_id")
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	@Column(name="task_name")
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	@Column(name="cachet_approve")
	public Integer getCachetApprove() {
		return cachetApprove;
	}
	public void setCachetApprove(Integer cachetApprove) {
		this.cachetApprove = cachetApprove;
	}
	@OneToOne
	@JoinColumn(name = "config")
	@Cascade(value = CascadeType.DELETE)
	public FormalCircuitConfig getFormalCircuitConfig() {
		return formalCircuitConfig;
	}
	public void setFormalCircuitConfig(FormalCircuitConfig formalCircuitConfig) {
		this.formalCircuitConfig = formalCircuitConfig;
	}
	@Column(name="num")
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
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
