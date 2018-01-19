package cn.com.atnc.ioms.entity.business.satellite;

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

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.enums.business.satellite.ApproveStatEnum;

/**
 * KU卫星网远端站入网申请信息实体
 *
 * @author ku
 * @date 2015年5月13日 下午3:33:32
 * @since 1.0.0
 */
@Entity
@Table(name="TB_OM_APPLY_KUSATELLITE")
public class KuSatellite extends StringUUIDEntity {

	private static final long serialVersionUID = -6784466240377490883L;

	private ApplyBaseInfo applyBaseInfo; //各种申请抽象信息
	private String applyFax;     //传真
	private String applyComSign; //公司签字
	private String txSiteName;   //本端站点名称
	private String rxSiteAddress; //对端站点地址
	private String longitudeDeg;  //维度-度
	private String longitudeMin;  //维度-分
	private String longitudeSec;  //维度-秒
	private String latitudeDeg;   //经度-度
	private String latitudeMin;   //经度-分
	private String latitudeSec;   //经度-秒
	private String height;        //海拔高度
	private String position;      //方位角
	private String pitching;      //俯仰角
	private String polarization;  //极化角
	private String antennaModel;  //天线厂家及型号
	private String antennaDiameter; //口径
	private String outdoorModel; //室外单元厂家及型号
	private String launchPower;  //放射功率
	private String vsatPlusllNum;  //室内单元信息
	private String vsatPluslleNum; //室内单元信息
	private String length;         //电缆长度
	private String initApproveCom; //初审公司
	private String initApproveSign;//负责人签字
	private String initApproveOpinion; //初审意见
	private String finalApproveCom; //终审单位
	private String finalApproveSign;//负责人签字
	private String finalApproveOpinion;//终审意见
	private ApproveStatEnum approveStat; //审批状态
	private String processInstanceId; //流程实例ID
	private String taskName;  //任务名
	// -- 附加属性 --//
	private transient Task task;// 流程任务
	private transient Map<String, Object> variables;// 流程变量
	private transient ProcessInstance processInstance;// 运行中的流程实例
	private transient HistoricProcessInstance historicProcessInstance;// 历史的流程实例
	private transient ProcessDefinition processDefinition;// 流程定义
	
	private Integer cachetApprove = 0;			//用印审批：1代表通过，0代表不通过
	
	@OneToOne
	@JoinColumn(name="apply_baseinfo")
	public ApplyBaseInfo getApplyBaseInfo() {
		return applyBaseInfo;
	}
	public void setApplyBaseInfo(ApplyBaseInfo applyBaseInfo) {
		this.applyBaseInfo = applyBaseInfo;
	}
	@Column(name="apply_fax")
	public String getApplyFax() {
		return applyFax;
	}
	public void setApplyFax(String applyFax) {
		this.applyFax = applyFax;
	}
	@Column(name="apply_com_sign")
	public String getApplyComSign() {
		return applyComSign;
	}
	public void setApplyComSign(String applyComSign) {
		this.applyComSign = applyComSign;
	}
	@Column(name="tx_site_name")
	public String getTxSiteName() {
		return txSiteName;
	}
	public void setTxSiteName(String txSiteName) {
		this.txSiteName = txSiteName;
	}
	@Column(name="rx_site_address")
	public String getRxSiteAddress() {
		return rxSiteAddress;
	}
	public void setRxSiteAddress(String rxSiteAddress) {
		this.rxSiteAddress = rxSiteAddress;
	}
	@Column(name="longitude_deg")
	public String getLongitudeDeg() {
		return longitudeDeg;
	}
	public void setLongitudeDeg(String longitudeDeg) {
		this.longitudeDeg = longitudeDeg;
	}
	@Column(name="longitude_min")
	public String getLongitudeMin() {
		return longitudeMin;
	}
	public void setLongitudeMin(String longitudeMin) {
		this.longitudeMin = longitudeMin;
	}
	@Column(name="longitude_sec")
	public String getLongitudeSec() {
		return longitudeSec;
	}
	public void setLongitudeSec(String longitudeSec) {
		this.longitudeSec = longitudeSec;
	}
	@Column(name="latitude_deg")
	public String getLatitudeDeg() {
		return latitudeDeg;
	}
	public void setLatitudeDeg(String latitudeDeg) {
		this.latitudeDeg = latitudeDeg;
	}
	@Column(name="latitude_min")
	public String getLatitudeMin() {
		return latitudeMin;
	}
	public void setLatitudeMin(String latitudeMin) {
		this.latitudeMin = latitudeMin;
	}
	@Column(name="latitude_sec")
	public String getLatitudeSec() {
		return latitudeSec;
	}
	public void setLatitudeSec(String latitudeSec) {
		this.latitudeSec = latitudeSec;
	}
	@Column(name="height")
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	@Column(name="position")
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Column(name="pitching")
	public String getPitching() {
		return pitching;
	}
	public void setPitching(String pitching) {
		this.pitching = pitching;
	}
	@Column(name="polarization")
	public String getPolarization() {
		return polarization;
	}
	public void setPolarization(String polarization) {
		this.polarization = polarization;
	}
	@Column(name="antenna_model")
	public String getAntennaModel() {
		return antennaModel;
	}
	public void setAntennaModel(String antennaModel) {
		this.antennaModel = antennaModel;
	}
	@Column(name="antenna_diameter")
	public String getAntennaDiameter() {
		return antennaDiameter;
	}
	public void setAntennaDiameter(String antennaDiameter) {
		this.antennaDiameter = antennaDiameter;
	}
	@Column(name="outdoor_model")
	public String getOutdoorModel() {
		return outdoorModel;
	}
	public void setOutdoorModel(String outdoorModel) {
		this.outdoorModel = outdoorModel;
	}
	@Column(name="launch_power")
	public String getLaunchPower() {
		return launchPower;
	}
	public void setLaunchPower(String launchPower) {
		this.launchPower = launchPower;
	}
	@Column(name="vsat_plusll_num")
	public String getVsatPlusllNum() {
		return vsatPlusllNum;
	}
	public void setVsatPlusllNum(String vsatPlusllNum) {
		this.vsatPlusllNum = vsatPlusllNum;
	}
	@Column(name="vsat_pluslle_num")
	public String getVsatPluslleNum() {
		return vsatPluslleNum;
	}
	public void setVsatPluslleNum(String vsatPluslleNum) {
		this.vsatPluslleNum = vsatPluslleNum;
	}
	@Column(name="length")
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
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
	@Enumerated(EnumType.STRING)
	@Column(name="approve_stat")
	public ApproveStatEnum getApproveStat() {
		return approveStat;
	}
	public void setApproveStat(ApproveStatEnum approveStat) {
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
