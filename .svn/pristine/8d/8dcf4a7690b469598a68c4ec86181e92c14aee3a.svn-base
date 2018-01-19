package cn.com.atnc.ioms.entity.duty.environment;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.environment.acc.AccCheckContent;
import cn.com.atnc.ioms.entity.duty.environment.acc.AccDataRecord;
import cn.com.atnc.ioms.entity.duty.environment.dg.DgCheckContent;
import cn.com.atnc.ioms.entity.duty.environment.psot.PsOtCheckContent;
import cn.com.atnc.ioms.entity.duty.environment.ups.BatteryMeasure;
import cn.com.atnc.ioms.entity.duty.environment.ups.DischargeTest;
import cn.com.atnc.ioms.entity.duty.environment.ups.SystemConnMeasure;
import cn.com.atnc.ioms.entity.duty.environment.ups.SystemMeasure;
import cn.com.atnc.ioms.entity.duty.environment.ups.UpsContentCheck;
import cn.com.atnc.ioms.entity.duty.environment.ups.ZgvZlcMeasure;
import cn.com.atnc.ioms.entity.duty.satellite.SlhDataState;
import cn.com.atnc.ioms.entity.duty.satellite.SlhEquState;
import cn.com.atnc.ioms.entity.duty.satellite.SlhJdjj;
import cn.com.atnc.ioms.entity.duty.satellite.SlhNetCon;
import cn.com.atnc.ioms.entity.duty.satellite.SlhProState;
import cn.com.atnc.ioms.entity.duty.satellite.TxjdConWork;
import cn.com.atnc.ioms.entity.duty.satellite.TxjdLinkState;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.DataState;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdDecCon;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdMainState;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdProState;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdSynState;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdWorkCon;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;

/**
 * 环境设备检查
 * 
 * @author renyujuan
 * @date 2016年7月6日上午10:34:07
 */
@Entity
@Table(name = "TB_OM_DUTY_CHECK")
public class EnvironmentEquipCheck extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	private String name; // ups设备名称
	private User operator; // 操作人
	private User updater; // 操作人
	private String problem; // 存在问题
	private String suggestion; // 建议
	private String result; // 检查结果
	private Date checkTime; // 检查时间
	private Date updateTime; // 更新时间
	private Date checkDate; // 检查日期
	private CheckCatagory checkType;
	private EquipType equipType;

	private transient List<UpsContentCheck> upsContentCheck;
	private transient List<SystemMeasure> systemMeasure;
	private transient List<ZgvZlcMeasure> zgvZlcMeasure;
	private transient List<BatteryMeasure> batteryMeasure;
	private transient List<SystemConnMeasure> systemConnMeasure;
	// ups季检需要添加的放电测试
	private transient List<DischargeTest> dischargeTest;
	private transient List<DgCheckContent> dgCheckContent;
	private transient List<AccCheckContent> accCheckContent;
	private transient List<AccDataRecord> accDataRecord;
	private transient List<PsOtCheckContent> psOtCheckContent;
	// 卫星巡检
	private transient List<SlhDataState> slhdatestate;
	private transient List<SlhEquState> slhequstate;
	private transient List<SlhJdjj> slhjdjj;
	private transient List<SlhNetCon> slhnetcon;
	private transient List<SlhProState> slhprostate;
	private transient List<TxjdConWork> txjdconwork;
	private transient List<DataState> txjddatastate;
	private transient List<TxjdDecCon> txjddeccon;
	private transient List<TxjdLinkState> txjdlinkstate;
	private transient List<TxjdMainState> txjdmainstate;
	private transient List<TxjdProState> txjdprostate;
	private transient List<TxjdSynState> txjdsynstate;
	private transient List<TxjdWorkCon> txjdworlkcon;

	@Transient
	public List<SlhDataState> getSlhdatestate() {
		return slhdatestate;
	}

	public void setSlhdatestate(List<SlhDataState> slhdatestate) {
		this.slhdatestate = slhdatestate;
	}

	@Transient
	public List<SlhEquState> getSlhequstate() {
		return slhequstate;
	}

	public void setSlhequstate(List<SlhEquState> slhequstate) {
		this.slhequstate = slhequstate;
	}

	@Transient
	public List<SlhJdjj> getSlhjdjj() {
		return slhjdjj;
	}

	public void setSlhjdjj(List<SlhJdjj> slhjdjj) {
		this.slhjdjj = slhjdjj;
	}

	@Transient
	public List<SlhNetCon> getSlhnetcon() {
		return slhnetcon;
	}

	public void setSlhnetcon(List<SlhNetCon> slhnetcon) {
		this.slhnetcon = slhnetcon;
	}

	@Transient
	public List<SlhProState> getSlhprostate() {
		return slhprostate;
	}

	public void setSlhprostate(List<SlhProState> slhprostate) {
		this.slhprostate = slhprostate;
	}

	@Transient
	public List<TxjdConWork> getTxjdconwork() {
		return txjdconwork;
	}

	public void setTxjdconwork(List<TxjdConWork> txjdconwork) {
		this.txjdconwork = txjdconwork;
	}

	@Transient
	public List<DataState> getTxjddatastate() {
		return txjddatastate;
	}

	public void setTxjddatastate(List<DataState> txjddatastate) {
		this.txjddatastate = txjddatastate;
	}

	@Transient
	public List<TxjdDecCon> getTxjddeccon() {
		return txjddeccon;
	}

	public void setTxjddeccon(List<TxjdDecCon> txjddeccon) {
		this.txjddeccon = txjddeccon;
	}

	@Transient
	public List<TxjdLinkState> getTxjdlinkstate() {
		return txjdlinkstate;
	}

	public void setTxjdlinkstate(List<TxjdLinkState> txjdlinkstate) {
		this.txjdlinkstate = txjdlinkstate;
	}

	@Transient
	public List<TxjdMainState> getTxjdmainstate() {
		return txjdmainstate;
	}

	public void setTxjdmainstate(List<TxjdMainState> txjdmainstate) {
		this.txjdmainstate = txjdmainstate;
	}

	@Transient
	public List<TxjdProState> getTxjdprostate() {
		return txjdprostate;
	}

	public void setTxjdprostate(List<TxjdProState> txjdprostate) {
		this.txjdprostate = txjdprostate;
	}

	@Transient
	public List<TxjdSynState> getTxjdsynstate() {
		return txjdsynstate;
	}

	public void setTxjdsynstate(List<TxjdSynState> txjdsynstate) {
		this.txjdsynstate = txjdsynstate;
	}

	@Transient
	public List<TxjdWorkCon> getTxjdworlkcon() {
		return txjdworlkcon;
	}

	public void setTxjdworlkcon(List<TxjdWorkCon> txjdworlkcon) {
		this.txjdworlkcon = txjdworlkcon;
	}

	@Transient
	public List<PsOtCheckContent> getPsOtCheckContent() {
		return psOtCheckContent;
	}

	public void setPsOtCheckContent(List<PsOtCheckContent> psOtCheckContent) {
		this.psOtCheckContent = psOtCheckContent;
	}

	@Transient
	public List<AccCheckContent> getAccCheckContent() {
		return accCheckContent;
	}

	public void setAccCheckContent(List<AccCheckContent> accCheckContent) {
		this.accCheckContent = accCheckContent;
	}

	@Transient
	public List<AccDataRecord> getAccDataRecord() {
		return accDataRecord;
	}

	public void setAccDataRecord(List<AccDataRecord> accDataRecord) {
		this.accDataRecord = accDataRecord;
	}

	@Transient
	public List<DgCheckContent> getDgCheckContent() {
		return dgCheckContent;
	}

	public void setDgCheckContent(List<DgCheckContent> dgCheckContent) {
		this.dgCheckContent = dgCheckContent;
	}

	@Transient
	public List<DischargeTest> getDischargeTest() {
		return dischargeTest;
	}

	public void setDischargeTest(List<DischargeTest> dischargeTest) {
		this.dischargeTest = dischargeTest;
	}

	@Transient
	public List<ZgvZlcMeasure> getZgvZlcMeasure() {
		return zgvZlcMeasure;
	}

	public void setZgvZlcMeasure(List<ZgvZlcMeasure> zgvZlcMeasure) {
		this.zgvZlcMeasure = zgvZlcMeasure;
	}

	@Transient
	public List<BatteryMeasure> getBatteryMeasure() {
		return batteryMeasure;
	}

	public void setBatteryMeasure(List<BatteryMeasure> batteryMeasure) {
		this.batteryMeasure = batteryMeasure;
	}

	@Transient
	public List<SystemConnMeasure> getSystemConnMeasure() {
		return systemConnMeasure;
	}

	public void setSystemConnMeasure(List<SystemConnMeasure> systemConnMeasure) {
		this.systemConnMeasure = systemConnMeasure;
	}

	@Transient
	public List<SystemMeasure> getSystemMeasure() {
		return systemMeasure;
	}

	public void setSystemMeasure(List<SystemMeasure> systemMeasure) {
		this.systemMeasure = systemMeasure;
	}

	@Transient
	public List<UpsContentCheck> getUpsContentCheck() {
		return upsContentCheck;
	}

	public void setUpsContentCheck(List<UpsContentCheck> upsContentCheck) {
		this.upsContentCheck = upsContentCheck;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "check_type")
	public CheckCatagory getCheckType() {
		return checkType;
	}

	public void setCheckType(CheckCatagory checkType) {
		this.checkType = checkType;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "equip_type")
	public EquipType getEquipType() {
		return equipType;
	}

	public void setEquipType(EquipType equipType) {
		this.equipType = equipType;
	}

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "check_date")
	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "operator")
	public User getOperator() {
		return operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}
	@ManyToOne
	@JoinColumn(name = "UPDATER")
	public User getUpdater() {
		return updater;
	}
	
	public void setUpdater(User updater) {
		this.updater = updater;
	}

	@Column(name = "problem")
	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	@Column(name = "suggestion")
	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	@Column(name = "result")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "check_time")
	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

}
