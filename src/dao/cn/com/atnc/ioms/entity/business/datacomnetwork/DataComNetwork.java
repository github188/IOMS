package cn.com.atnc.ioms.entity.business.datacomnetwork;

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
import cn.com.atnc.ioms.enums.business.datacomnetwork.NetWorkStatEnum;


/**
 * 数据通信网实体
 *
 * @author Wang Zhicheng
 * @date 2015年10月19日 下午1:25:06
 * @since 1.0.0
 */
@Entity
@Table(name="TB_OM_APPLY_DATACOMNETWORK")
public class DataComNetwork extends MyStringUUIDEntity {

	private static final long serialVersionUID = -230402317666975182L;
	
	// -- 基础属性 --//
	private ApplyBaseInfo applyBaseInfo;  //申请信息
	private String applySign;  //申请单位签字
	private String applyRemark;  //备注\其他要求
	private String areaOpinion;  //地区网络中心意见
	private String areaSign;  //地区网络中心负责人签字
	private String atncOpinion;  //天航信网络中心意见
	private String atncSign;  //天航信网络中心负责人签字
	private NetWorkStatEnum approveStat;  //审批状态
	private String processInstanceId;  //流程ID
	private String taskName;  //任务名
	private DataComNetworkConfig dataComNetworkConfig;	//配置表
	private String num;  //第一次提交标识
	private Integer cachetApprove = 0;			//用印审批：1代表通过，0代表不通过
	
	private String initApproveCom; //初审公司
	private String initApproveSign;//负责人签字
	private String initApproveOpinion; //初审意见
	private String finalApproveCom; //终审单位
	private String finalApproveSign;//负责人签字
	private String finalApproveOpinion;//终审意见
	
	// -- 主要属性 --//
	private String node;  //节点名
	private String placeName;  //安装地点
	
	private String equipfactory1;  //设备厂家
	private String equipType1;  //设备型号
	private String equipNum1;  //设备数量
	
	private String equipfactory2;  //设备厂家
	private String equipType2;  //设备型号
	private String equipNum2;  //设备数量
	
	private String equipfactory3;  //设备厂家
	private String equipType3;  //设备型号
	private String equipNum3;  //设备数量
	
	private String remark;  //设备数量
	
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
	public NetWorkStatEnum getApproveStat() {
		return approveStat;
	}
	public void setApproveStat(NetWorkStatEnum approveStat) {
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
	
	@Column(name="node_name")
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	@Column(name="place_name")
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	@Column(name="equip_factory1")
	public String getEquipfactory1() {
		return equipfactory1;
	}
	public void setEquipfactory1(String equipfactory1) {
		this.equipfactory1 = equipfactory1;
	}
	@Column(name="equip_type1")
	public String getEquipType1() {
		return equipType1;
	}
	public void setEquipType1(String equipType1) {
		this.equipType1 = equipType1;
	}
	@Column(name="equip_num1")
	public String getEquipNum1() {
		return equipNum1;
	}
	public void setEquipNum1(String equipNum1) {
		this.equipNum1 = equipNum1;
	}
	@Column(name="equip_factory2")
	public String getEquipfactory2() {
		return equipfactory2;
	}
	public void setEquipfactory2(String equipfactory2) {
		this.equipfactory2 = equipfactory2;
	}
	@Column(name="equip_type2")
	public String getEquipType2() {
		return equipType2;
	}
	public void setEquipType2(String equipType2) {
		this.equipType2 = equipType2;
	}
	@Column(name="equip_num2")
	public String getEquipNum2() {
		return equipNum2; 
	}
	public void setEquipNum2(String equipNum2) {
		this.equipNum2 = equipNum2;
	}
	@Column(name="equip_factory3")
	public String getEquipfactory3() {
		return equipfactory3;
	}
	public void setEquipfactory3(String equipfactory3) {
		this.equipfactory3 = equipfactory3;
	}
	@Column(name="equip_type3")
	public String getEquipType3() {
		return equipType3;
	}
	public void setEquipType3(String equipType3) {
		this.equipType3 = equipType3;
	}
	@Column(name="equip_num3")
	public String getEquipNum3() {
		return equipNum3;
	}
	public void setEquipNum3(String equipNum3) {
		this.equipNum3 = equipNum3;
	}
	@OneToOne
	@JoinColumn(name = "config")
	@Cascade(value = CascadeType.DELETE)
	public DataComNetworkConfig getDataComNetworkConfig() {
		return dataComNetworkConfig;
	}
	public void setDataComNetworkConfig(DataComNetworkConfig dataComNetworkConfig) {
		this.dataComNetworkConfig = dataComNetworkConfig;
	}
	@Column(name="num")
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	@Column(name="remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name="init_approve_com")
	public String getInitApproveCom() {
		return initApproveCom;
	}
	public void setInitApproveCom(String initApproveCom) {
		this.initApproveCom = initApproveCom;
	}
	@Column(name="init_approve_sign")
	public String getInitApproveSign() {
		return initApproveSign;
	}
	public void setInitApproveSign(String initApproveSign) {
		this.initApproveSign = initApproveSign;
	}
	@Column(name="init_approve_opinion")
	public String getInitApproveOpinion() {
		return initApproveOpinion;
	}
	public void setInitApproveOpinion(String initApproveOpinion) {
		this.initApproveOpinion = initApproveOpinion;
	}
	@Column(name="final_approve_com")
	public String getFinalApproveCom() {
		return finalApproveCom;
	}
	public void setFinalApproveCom(String finalApproveCom) {
		this.finalApproveCom = finalApproveCom;
	}
	@Column(name="final_approve_sign")
	public String getFinalApproveSign() {
		return finalApproveSign;
	}
	public void setFinalApproveSign(String finalApproveSign) {
		this.finalApproveSign = finalApproveSign;
	}
	@Column(name="final_approve_opinion")
	public String getFinalApproveOpinion() {
		return finalApproveOpinion;
	}
	public void setFinalApproveOpinion(String finalApproveOpinion) {
		this.finalApproveOpinion = finalApproveOpinion;
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
	@Column(name="cachet_approve")
	public Integer getCachetApprove() {
		return cachetApprove;
	}
	public void setCachetApprove(Integer cachetApprove) {
		this.cachetApprove = cachetApprove;
	}
}
