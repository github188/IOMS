package cn.com.atnc.ioms.entity.duty.satelliteauto.day;

import java.util.Date;

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
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteDayAutoType;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteStatus;

/**
 * 东四-PES-TES民航局ODU状态
 *
 * @author 段衍林
 * @2016年11月15日 下午1:23:43
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_ODU_DS")
public class SatDsOdu extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	private String masterAbResult; // 主用侧结果
	private SatelliteStatus masterAbState; // 主用侧结果
	private String receiveResult; // receive
	private SatelliteStatus receiveState;
	private String transmitResult; // transmit
	private SatelliteStatus transmitState;
	private String attendownResult; // attendown
	private SatelliteStatus attendownState;
	private String attenupResult; // attenup
	private SatelliteStatus attenupState;
	private SatelliteStatus fixedResult; // fixed
	private SatelliteStatus fixedState;
	private SatelliteStatus varResult; // var
	private SatelliteStatus varState;
	private SatelliteStatus extpowerResult; // extpower
	private SatelliteStatus extpowerState;
	private SatelliteStatus exttempResult; // exttemp
	private SatelliteStatus exttempState;
	private SatelliteStatus lanResult; // lan
	private SatelliteStatus lanState;
	private SatelliteStatus summaryResult; // summary
	private SatelliteStatus summaryState;
	private SatelliteStatus extResult; // ext
	private SatelliteStatus extState;
	private SatelliteStatus redundantResult; // redundant
	private SatelliteStatus redundantState;

	private Date checkTime; // 记录时间
	private Date updateTime; // 更新时间
	private User operator; // 操作人
	private SatelliteDayAutoType equipName; // 设备名称

	/**
	 * 冗余,页面展示
	 */
	private transient String receiveResultShow;
	private transient String transmitResultShow;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "MASTER_AB_RESULT")
	public String getMasterAbResult() {
		return masterAbResult;
	}

	public void setMasterAbResult(String masterAbResult) {
		this.masterAbResult = masterAbResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "MASTER_AB_STATE")
	public SatelliteStatus getMasterAbState() {
		return masterAbState;
	}

	public void setMasterAbState(SatelliteStatus masterAbState) {
		this.masterAbState = masterAbState;
	}

	@Column(name = "RECEIVE_RESULT")
	public String getReceiveResult() {
		return receiveResult;
	}

	public void setReceiveResult(String receiveResult) {
		this.receiveResult = receiveResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "RECEIVE_STATE")
	public SatelliteStatus getReceiveState() {
		return receiveState;
	}

	public void setReceiveState(SatelliteStatus receiveState) {
		this.receiveState = receiveState;
	}

	@Column(name = "TRANSMIT_RESULT")
	public String getTransmitResult() {
		return transmitResult;
	}

	public void setTransmitResult(String transmitResult) {
		this.transmitResult = transmitResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TRANSMIT_STATE")
	public SatelliteStatus getTransmitState() {
		return transmitState;
	}

	public void setTransmitState(SatelliteStatus transmitState) {
		this.transmitState = transmitState;
	}

	@Column(name = "ATTENDOWN_RESULT")
	public String getAttendownResult() {
		return attendownResult;
	}

	public void setAttendownResult(String attendownResult) {
		this.attendownResult = attendownResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ATTENDOWN_STATE")
	public SatelliteStatus getAttendownState() {
		return attendownState;
	}

	public void setAttendownState(SatelliteStatus attendownState) {
		this.attendownState = attendownState;
	}

	@Column(name = "ATTENUP_RESULT")
	public String getAttenupResult() {
		return attenupResult;
	}

	public void setAttenupResult(String attenupResult) {
		this.attenupResult = attenupResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ATTENUP_STATE")
	public SatelliteStatus getAttenupState() {
		return attenupState;
	}

	public void setAttenupState(SatelliteStatus attenupState) {
		this.attenupState = attenupState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "FIXED_RESULT")
	public SatelliteStatus getFixedResult() {
		return fixedResult;
	}

	public void setFixedResult(SatelliteStatus fixedResult) {
		this.fixedResult = fixedResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "FIXED_STATE")
	public SatelliteStatus getFixedState() {
		return fixedState;
	}

	public void setFixedState(SatelliteStatus fixedState) {
		this.fixedState = fixedState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "VAR_RESULT")
	public SatelliteStatus getVarResult() {
		return varResult;
	}

	public void setVarResult(SatelliteStatus varResult) {
		this.varResult = varResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "VAR_STATE")
	public SatelliteStatus getVarState() {
		return varState;
	}

	public void setVarState(SatelliteStatus varState) {
		this.varState = varState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "EXTPOWER_RESULT")
	public SatelliteStatus getExtpowerResult() {
		return extpowerResult;
	}

	public void setExtpowerResult(SatelliteStatus extpowerResult) {
		this.extpowerResult = extpowerResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "EXTPOWER_STATE")
	public SatelliteStatus getExtpowerState() {
		return extpowerState;
	}

	public void setExtpowerState(SatelliteStatus extpowerState) {
		this.extpowerState = extpowerState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "EXTTEMP_RESULT")
	public SatelliteStatus getExttempResult() {
		return exttempResult;
	}

	public void setExttempResult(SatelliteStatus exttempResult) {
		this.exttempResult = exttempResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "EXTTEMP_STATE")
	public SatelliteStatus getExttempState() {
		return exttempState;
	}

	public void setExttempState(SatelliteStatus exttempState) {
		this.exttempState = exttempState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "LAN_RESULT")
	public SatelliteStatus getLanResult() {
		return lanResult;
	}

	public void setLanResult(SatelliteStatus lanResult) {
		this.lanResult = lanResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "LAN_STATE")
	public SatelliteStatus getLanState() {
		return lanState;
	}

	public void setLanState(SatelliteStatus lanState) {
		this.lanState = lanState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SUMMARY_RESULT")
	public SatelliteStatus getSummaryResult() {
		return summaryResult;
	}

	public void setSummaryResult(SatelliteStatus summaryResult) {
		this.summaryResult = summaryResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SUMMARY_STATE")
	public SatelliteStatus getSummaryState() {
		return summaryState;
	}

	public void setSummaryState(SatelliteStatus summaryState) {
		this.summaryState = summaryState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "EXT_RESULT")
	public SatelliteStatus getExtResult() {
		return extResult;
	}

	public void setExtResult(SatelliteStatus extResult) {
		this.extResult = extResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "EXT_STATE")
	public SatelliteStatus getExtState() {
		return extState;
	}

	public void setExtState(SatelliteStatus extState) {
		this.extState = extState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "REDUNDANT_RESULT")
	public SatelliteStatus getRedundantResult() {
		return redundantResult;
	}

	public void setRedundantResult(SatelliteStatus redundantResult) {
		this.redundantResult = redundantResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "REDUNDANT_STATE")
	public SatelliteStatus getRedundantState() {
		return redundantState;
	}

	public void setRedundantState(SatelliteStatus redundantState) {
		this.redundantState = redundantState;
	}

	@Transient
	public String getReceiveResultShow() {
		return receiveResultShow;
	}

	public void setReceiveResultShow(String receiveResultShow) {
		this.receiveResultShow = receiveResultShow;
	}

	@Transient
	public String getTransmitResultShow() {
		return transmitResultShow;
	}

	public void setTransmitResultShow(String transmitResultShow) {
		this.transmitResultShow = transmitResultShow;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "RECORD_TIME")
	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	@ManyToOne
	@JoinColumn(name = "OPERATOR")
	public User getOperator() {
		return operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "EQUIP_NAME")
	public SatelliteDayAutoType getEquipName() {
		return equipName;
	}

	public void setEquipName(SatelliteDayAutoType equipName) {
		this.equipName = equipName;
	}
}
