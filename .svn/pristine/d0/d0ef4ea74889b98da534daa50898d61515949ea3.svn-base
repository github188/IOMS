package cn.com.atnc.ioms.entity.business.telegraph;

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
import cn.com.atnc.ioms.enums.business.telegraph.AddressTypeEnum;
import cn.com.atnc.ioms.enums.business.telegraph.ConnectionConditionEnum;
import cn.com.atnc.ioms.enums.business.telegraph.TeleApplyTypeEnum;
import cn.com.atnc.ioms.enums.business.telegraph.TeleGraphApproveStatEnum;
import cn.com.atnc.ioms.enums.business.telegraph.UsingAreaEnum;
import cn.com.atnc.ioms.enums.business.telegraph.UsingPeriodEnum;

/**
 * 民航转报网转报地址及路由基础信息表
 * @author WangLingbin
 * @date 2015年6月18日 上午9:11:08
 * @since 1.0.0
 */
@Entity
@Table(name = "TB_OM_APPLY_TELEGRAM")
public class TeleGraph extends MyStringUUIDEntity{

	/**
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * TODO（申请信息父类）
	 * @since 1.0.0
	 */
	private ApplyBaseInfo applyBaseInfo;
	
	/**
	 * TODO（申请类型）
	 * @since 1.0.0
	 */
	private TeleApplyTypeEnum teleApplyType;
	
	/**
	 * TODO（申请单位签字）
	 * @since 1.0.0
	 */
	private String applyComSign;
	
	
	/**
	 * TODO（使用时限）
	 * @since 1.0.0
	 */
	private UsingPeriodEnum usingPeriod;
	
	/**
	 * TODO（使用地区）
	 * @since 1.0.0
	 */
	private UsingAreaEnum usingArea;
	
	/**
	 * TODO（备注/其它要求）
	 * @since 1.0.0
	 */
	private String remark;
	
	/**
	 * TODO（地区网络公司意见）
	 * @since 1.0.0
	 */
	private String areaOpition;
	
	/**
	 * TODO（地区网络公司负责人签字）
	 * @since 1.0.0
	 */
	private String areaSign;
	
	/**
	 * TODO（北京网控公司意见）
	 * @since 1.0.0
	 */
	private String atncOpition;
	
	/**
	 * TODO（北京网控公司负责人签字）
	 * @since 1.0.0
	 */
	private String atncSign;
	
	/**
	 * TODO（审批状态）
	 * @since 1.0.0
	 */
	private TeleGraphApproveStatEnum approveStat; 
	
	/**
	 * TODO（流程实例ID）
	 * @since 1.0.0
	 */
	private String processInstanceId;
	
	/**
	 * TODO（任务名）
	 * @since 1.0.0
	 */
	private String taskName;
	// -- 附加属性 --//
	private transient Task task;// 流程任务
	private transient Map<String, Object> variables;// 流程变量
	private transient ProcessInstance processInstance;// 运行中的流程实例
	private transient HistoricProcessInstance historicProcessInstance;// 历史的流程实例
	private transient ProcessDefinition processDefinition;// 流程定义

	private Integer cachetApprove = 0;			//用印审批：1代表通过，0代表不通过
	
	private AddressTypeEnum addressType;		//地址类型
	
	@OneToOne
	@JoinColumn(name = "apply_baseinfo")
	public ApplyBaseInfo getApplyBaseInfo() {
		return applyBaseInfo;
	}

	public void setApplyBaseInfo(ApplyBaseInfo applyBaseInfo) {
		this.applyBaseInfo = applyBaseInfo;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "apply_type")
	public TeleApplyTypeEnum getTeleApplyType() {
		return teleApplyType;
	}

	public void setTeleApplyType(TeleApplyTypeEnum teleApplyType) {
		this.teleApplyType = teleApplyType;
	}

	@Column(name = "apply_com_sign")
	public String getApplyComSign() {
		return applyComSign;
	}

	public void setApplyComSign(String applyComSign) {
		this.applyComSign = applyComSign;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "use_period")
	public UsingPeriodEnum getUsingPeriod() {
		return usingPeriod;
	}

	public void setUsingPeriod(UsingPeriodEnum usingPeriod) {
		this.usingPeriod = usingPeriod;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "use_area")
	public UsingAreaEnum getUsingArea() {
		return usingArea;
	}

	public void setUsingArea(UsingAreaEnum usingArea) {
		this.usingArea = usingArea;
	}

	@Column(name = "apply_remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "area_opinion")
	public String getAreaOpition() {
		return areaOpition;
	}

	public void setAreaOpition(String areaOpition) {
		this.areaOpition = areaOpition;
	}

	@Column(name = "area_sign")
	public String getAreaSign() {
		return areaSign;
	}

	public void setAreaSign(String areaSign) {
		this.areaSign = areaSign;
	}

	@Column(name = "atnc_opinion")
	public String getAtncOpition() {
		return atncOpition;
	}

	public void setAtncOpition(String atncOpition) {
		this.atncOpition = atncOpition;
	}

	@Column(name = "atnc_sign")
	public String getAtncSign() {
		return atncSign;
	}

	public void setAtncSign(String atncSign) {
		this.atncSign = atncSign;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="approve_stat")
	public TeleGraphApproveStatEnum getApproveStat() {
		return approveStat;
	}

	public void setApproveStat(TeleGraphApproveStatEnum approveStat) {
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
	@Enumerated(EnumType.STRING)
	@Column(name = "address_type")
	public AddressTypeEnum getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressTypeEnum addressType) {
		this.addressType = addressType;
	}
	
}
