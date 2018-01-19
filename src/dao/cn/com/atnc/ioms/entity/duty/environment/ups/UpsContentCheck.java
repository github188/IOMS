package cn.com.atnc.ioms.entity.duty.environment.ups;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.enums.duty.environment.ContentCheckResult;
/**
 * ups设备巡检内容检查
 * @author renyujuan
 * @date 2016年7月6日下午12:43:13
 */
@Entity
@Table(name="TB_OM_DUTY_UPS_CON_CHECK")
public class UpsContentCheck extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;
	
	//----环境----//
	private CheckResult atIsAdjustable;                 //环境温度是否可调
	private String temperature;							//环境温度
	private String humidity;							//环境湿度
	//----设备及外观-----//
	private CheckResult eaIsIntact;						//设备外观是否完好
	private CheckResult radiateIsNormal;				//ups及电池散热柜是否正常
	private CheckResult esGroundVoltage;				//设备外壳对地是否有电压
	private CheckResult upsRvIsNormal;					//ups运行声音是否正常
	private CheckResult upsUidisIsNormal;				//ups界面显示是否正常
	private CheckResult raIsFlow;						//房间内空气是否流通
	private CheckResult batLeakage;						//电池无漏液现象
	private CheckResult upsOutletIsClean;				//ups出风口是否干净
	private CheckResult batSurfaceIsClean;				//电池表面是否干净
	private CheckResult connCo;							//连接端子无腐蚀氧化
	//-----告警-----//
	private CheckResult upsCurFAlarm;					//ups当前故障告警
	private CheckResult upsHisFAlarm;					//ups历史故障告警
	//-----输入系统-----//
	private String inputVLN;							//输入电压L-N
	private String inputVLD;							//输入电压L-D
	private String inputVND;							//输入电压N-D
	private String inputCurrent;						//输入电流
	private String loadCapacity;						//负载量
	private String inputAirTemperature;					//输入系统空开温度
	private String inputCableTemperature;				//输入系统线缆温度
	//-----输入系统-----//
	private String outputVLN;							//输出电压L-N
	private String outputVLD;							//输出电压L-D
	private String outputVND;							//输出电压N-D
	private String outputCurrent;						//输出电流
	private String outputAirTemperature;				//输出系统空开温度
	
	private ContentCheckResult equipDustRemoval;		//设备除尘
	
	//-----其他信息------//
	private EnvironmentEquipCheck upsCheck;							//ups巡检表实体id
	
	@Enumerated(EnumType.STRING)
	@Column(name="equip_dust_removal")
	public ContentCheckResult getEquipDustRemoval() {
		return equipDustRemoval;
	}
	public void setEquipDustRemoval(ContentCheckResult equipDustRemoval) {
		this.equipDustRemoval = equipDustRemoval;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="at_is_adjustable")
	public CheckResult getAtIsAdjustable() {
		return atIsAdjustable;
	}
	public void setAtIsAdjustable(CheckResult atIsAdjustable) {
		this.atIsAdjustable = atIsAdjustable;
	}
	
	@Column(name="temperature")
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	@Column(name="humidity")
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="ea_is_intact")
	public CheckResult getEaIsIntact() {
		return eaIsIntact;
	}
	public void setEaIsIntact(CheckResult eaIsIntact) {
		this.eaIsIntact = eaIsIntact;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="radiate_is_normal")
	public CheckResult getRadiateIsNormal() {
		return radiateIsNormal;
	}
	public void setRadiateIsNormal(CheckResult radiateIsNormal) {
		this.radiateIsNormal = radiateIsNormal;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="es_ground_voltage")
	public CheckResult getEsGroundVoltage() {
		return esGroundVoltage;
	}
	public void setEsGroundVoltage(CheckResult esGroundVoltage) {
		this.esGroundVoltage = esGroundVoltage;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="ups_rv_is_normal")
	public CheckResult getUpsRvIsNormal() {
		return upsRvIsNormal;
	}
	public void setUpsRvIsNormal(CheckResult upsRvIsNormal) {
		this.upsRvIsNormal = upsRvIsNormal;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="ups_uidis_is_normal")
	public CheckResult getUpsUidisIsNormal() {
		return upsUidisIsNormal;
	}
	public void setUpsUidisIsNormal(CheckResult upsUidisIsNormal) {
		this.upsUidisIsNormal = upsUidisIsNormal;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="ra_is_flow")
	public CheckResult getRaIsFlow() {
		return raIsFlow;
	}
	public void setRaIsFlow(CheckResult raIsFlow) {
		this.raIsFlow = raIsFlow;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="bat_leakage")
	public CheckResult getBatLeakage() {
		return batLeakage;
	}
	public void setBatLeakage(CheckResult batLeakage) {
		this.batLeakage = batLeakage;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="ups_outlet_is_clean")
	public CheckResult getUpsOutletIsClean() {
		return upsOutletIsClean;
	}
	public void setUpsOutletIsClean(CheckResult upsOutletIsClean) {
		this.upsOutletIsClean = upsOutletIsClean;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="bat_surface_is_clean")
	public CheckResult getBatSurfaceIsClean() {
		return batSurfaceIsClean;
	}
	public void setBatSurfaceIsClean(CheckResult batSurfaceIsClean) {
		this.batSurfaceIsClean = batSurfaceIsClean;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="conn_co")
	public CheckResult getConnCo() {
		return connCo;
	}
	public void setConnCo(CheckResult connCo) {
		this.connCo = connCo;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="ups_cur_f_alarm")
	public CheckResult getUpsCurFAlarm() {
		return upsCurFAlarm;
	}
	public void setUpsCurFAlarm(CheckResult upsCurFAlarm) {
		this.upsCurFAlarm = upsCurFAlarm;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="ups_his_f_alarm")
	public CheckResult getUpsHisFAlarm() {
		return upsHisFAlarm;
	}
	public void setUpsHisFAlarm(CheckResult upsHisFAlarm) {
		this.upsHisFAlarm = upsHisFAlarm;
	}
	@Column(name="input_v_l_n")
	public String getInputVLN() {
		return inputVLN;
	}
	public void setInputVLN(String inputVLN) {
		this.inputVLN = inputVLN;
	}
	@Column(name="input_v_l_d")
	public String getInputVLD() {
		return inputVLD;
	}
	public void setInputVLD(String inputVLD) {
		this.inputVLD = inputVLD;
	}
	@Column(name="input_v_n_d")
	public String getInputVND() {
		return inputVND;
	}
	public void setInputVND(String inputVND) {
		this.inputVND = inputVND;
	}
	@Column(name="input_current")
	public String getInputCurrent() {
		return inputCurrent;
	}
	public void setInputCurrent(String inputCurrent) {
		this.inputCurrent = inputCurrent;
	}
	@Column(name="load_capacity")
	public String getLoadCapacity() {
		return loadCapacity;
	}
	public void setLoadCapacity(String loadCapacity) {
		this.loadCapacity = loadCapacity;
	}
	@Column(name="input_air_temperature")
	public String getInputAirTemperature() {
		return inputAirTemperature;
	}
	public void setInputAirTemperature(String inputAirTemperature) {
		this.inputAirTemperature = inputAirTemperature;
	}
	@Column(name="input_cable_temperature")
	public String getInputCableTemperature() {
		return inputCableTemperature;
	}
	public void setInputCableTemperature(String inputCableTemperature) {
		this.inputCableTemperature = inputCableTemperature;
	}
	@Column(name="output_v_l_n")
	public String getOutputVLN() {
		return outputVLN;
	}
	public void setOutputVLN(String outputVLN) {
		this.outputVLN = outputVLN;
	}
	@Column(name="output_v_l_d")
	public String getOutputVLD() {
		return outputVLD;
	}
	public void setOutputVLD(String outputVLD) {
		this.outputVLD = outputVLD;
	}
	@Column(name="output_v_n_d")
	public String getOutputVND() {
		return outputVND;
	}
	public void setOutputVND(String outputVND) {
		this.outputVND = outputVND;
	}
	@Column(name="output_current")
	public String getOutputCurrent() {
		return outputCurrent;
	}
	public void setOutputCurrent(String outputCurrent) {
		this.outputCurrent = outputCurrent;
	}
	@Column(name="output_air_temperature")
	public String getOutputAirTemperature() {
		return outputAirTemperature;
	}
	public void setOutputAirTemperature(String outputAirTemperature) {
		this.outputAirTemperature = outputAirTemperature;
	}
	@ManyToOne
	@JoinColumn(name="ups_check_id")
	public EnvironmentEquipCheck getUpsCheck() {
		return upsCheck;
	}
	public void setUpsCheck(EnvironmentEquipCheck upsCheck) {
		this.upsCheck = upsCheck;
	}
	

}
