package cn.com.atnc.ioms.entity.duty.satelliteauto.day;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteDayAutoType;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteStatus;

/**
 * 通信基地-境外站-主站CDM570 实体
 *
 * @author 段衍林
 * @2016年11月11日 下午4:25:58
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_ABROAD_CDM")
public class SatTxjdOverseaCdm extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	private SatelliteStatus masterTxResult; // 主机tx结果
	private SatelliteStatus masterTxState; // 主机tx状态
	private SatelliteStatus masterRxResult; // 主机rx结果
	private SatelliteStatus masterRxState; // 主机rx状态
	private SatelliteStatus masterOnlineResult; // 主机Online结果
	private SatelliteStatus masterOnlineState; // 主机Online状态
	private String masterEbResult; // 主机Eb结果
	private SatelliteStatus masterEbState; // 主机eb状态

	private SatelliteStatus slaveTxResult; // 备机tx结果
	private SatelliteStatus slaveTxState; // 备机tx状态
	private SatelliteStatus slaveRxResult; // 备机rx结果
	private SatelliteStatus slaveRxState; // 备机rx状态
	private SatelliteStatus slaveOnlineResult; // 备机Online结果
	private SatelliteStatus slaveOnlineState; // 备机Online状态
	private String slaveEbResult; // 备机Eb结果
	private SatelliteStatus slaveEbState; // 备机eb状态

	private Date checkTime; // 记录时间
	private Date updateTime; // 记录时间
	private User operator; // 操作人
	private SatelliteDayAutoType equipName; // 设备名称

	@Enumerated(EnumType.STRING)
	@Column(name = "MASTER_TX_RESULT")
	public SatelliteStatus getMasterTxResult() {
		return masterTxResult;
	}

	public void setMasterTxResult(SatelliteStatus masterTxResult) {
		this.masterTxResult = masterTxResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "MASTER_TX_STATE")
	public SatelliteStatus getMasterTxState() {
		return masterTxState;
	}

	public void setMasterTxState(SatelliteStatus masterTxState) {
		this.masterTxState = masterTxState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "MASTER_RX_RESULT")
	public SatelliteStatus getMasterRxResult() {
		return masterRxResult;
	}

	public void setMasterRxResult(SatelliteStatus masterRxResult) {
		this.masterRxResult = masterRxResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "MASTER_RX_STATE")
	public SatelliteStatus getMasterRxState() {
		return masterRxState;
	}

	public void setMasterRxState(SatelliteStatus masterRxState) {
		this.masterRxState = masterRxState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "MASTER_ONLINE_RESULT")
	public SatelliteStatus getMasterOnlineResult() {
		return masterOnlineResult;
	}

	public void setMasterOnlineResult(SatelliteStatus masterOnlineResult) {
		this.masterOnlineResult = masterOnlineResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "MASTER_ONLINE_STATE")
	public SatelliteStatus getMasterOnlineState() {
		return masterOnlineState;
	}

	public void setMasterOnlineState(SatelliteStatus masterOnlineState) {
		this.masterOnlineState = masterOnlineState;
	}

	@Column(name = "MASTER_EB_RESULT")
	public String getMasterEbResult() {
		return masterEbResult;
	}

	public void setMasterEbResult(String masterEbResult) {
		this.masterEbResult = masterEbResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "MASTER_EB_STATE")
	public SatelliteStatus getMasterEbState() {
		return masterEbState;
	}

	public void setMasterEbState(SatelliteStatus masterEbState) {
		this.masterEbState = masterEbState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SLAVE_TX_RESULT")
	public SatelliteStatus getSlaveTxResult() {
		return slaveTxResult;
	}

	public void setSlaveTxResult(SatelliteStatus slaveTxResult) {
		this.slaveTxResult = slaveTxResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SLAVE_TX_STATE")
	public SatelliteStatus getSlaveTxState() {
		return slaveTxState;
	}

	public void setSlaveTxState(SatelliteStatus slaveTxState) {
		this.slaveTxState = slaveTxState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SLAVE_RX_RESULT")
	public SatelliteStatus getSlaveRxResult() {
		return slaveRxResult;
	}

	public void setSlaveRxResult(SatelliteStatus slaveRxResult) {
		this.slaveRxResult = slaveRxResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SLAVE_RX_STATE")
	public SatelliteStatus getSlaveRxState() {
		return slaveRxState;
	}

	public void setSlaveRxState(SatelliteStatus slaveRxState) {
		this.slaveRxState = slaveRxState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SLAVE_ONLINE_RESULT")
	public SatelliteStatus getSlaveOnlineResult() {
		return slaveOnlineResult;
	}

	public void setSlaveOnlineResult(SatelliteStatus slaveOnlineResult) {
		this.slaveOnlineResult = slaveOnlineResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SLAVE_ONLINE_STATE")
	public SatelliteStatus getSlaveOnlineState() {
		return slaveOnlineState;
	}

	public void setSlaveOnlineState(SatelliteStatus slaveOnlineState) {
		this.slaveOnlineState = slaveOnlineState;
	}

	@Column(name = "SLAVE_EB_RESULT")
	public String getSlaveEbResult() {
		return slaveEbResult;
	}

	public void setSlaveEbResult(String slaveEbResult) {
		this.slaveEbResult = slaveEbResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SLAVE_EB_STATE")
	public SatelliteStatus getSlaveEbState() {
		return slaveEbState;
	}

	public void setSlaveEbState(SatelliteStatus slaveEbState) {
		this.slaveEbState = slaveEbState;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "RECORD_TIME")
	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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
