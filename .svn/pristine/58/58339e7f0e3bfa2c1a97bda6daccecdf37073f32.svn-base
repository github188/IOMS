package cn.com.atnc.ioms.entity.duty.satellite;

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
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteDayAutoType;

/**
 * 通信基地雷达广播TES-TES链路工作状态
 *
 * @author 段衍林
 * @2016年11月16日 上午9:40:42
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_TXJD_RADAR_LINK")
public class TxjdRadarLink extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	private CheckResult linkStateSHA; // 上海链路状态
	private CheckResult linkStatePEK; // 北京链路状态
	private CheckResult linkStateSHE; // 沈阳链路状态
	private CheckResult linkStateSIA; // 西安链路状态
	private CheckResult linkStateCAN; // 广州链路状态
	private CheckResult linkStateURC; // 乌鲁木齐链路状态
	private CheckResult linkStateHAK; // 海口链路状态
	private CheckResult linkStateCTU; // 成都链路状态

	private Date checkTime; // 记录时间
	private Date updateTime; // 更新时间
	private User operator; // 操作人
	private User updater; // 更新人
	private SatelliteDayAutoType equipName; // 设备名称

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@ManyToOne
	@JoinColumn(name = "UPDATER")
	public User getUpdater() {
		return updater;
	}

	public void setUpdater(User updater) {
		this.updater = updater;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "LINK_100C_SHA")
	public CheckResult getLinkStateSHA() {
		return linkStateSHA;
	}

	public void setLinkStateSHA(CheckResult linkStateSHA) {
		this.linkStateSHA = linkStateSHA;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "LINK_100D_PEK")
	public CheckResult getLinkStatePEK() {
		return linkStatePEK;
	}

	public void setLinkStatePEK(CheckResult linkStatePEK) {
		this.linkStatePEK = linkStatePEK;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "LINK_100D_SHE")
	public CheckResult getLinkStateSHE() {
		return linkStateSHE;
	}

	public void setLinkStateSHE(CheckResult linkStateSHE) {
		this.linkStateSHE = linkStateSHE;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "LINK_100D_SIA")
	public CheckResult getLinkStateSIA() {
		return linkStateSIA;
	}

	public void setLinkStateSIA(CheckResult linkStateSIA) {
		this.linkStateSIA = linkStateSIA;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "LINK_100E_CAN")
	public CheckResult getLinkStateCAN() {
		return linkStateCAN;
	}

	public void setLinkStateCAN(CheckResult linkStateCAN) {
		this.linkStateCAN = linkStateCAN;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "LINK_100E_URC")
	public CheckResult getLinkStateURC() {
		return linkStateURC;
	}

	public void setLinkStateURC(CheckResult linkStateURC) {
		this.linkStateURC = linkStateURC;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "LINK_100E_HAK")
	public CheckResult getLinkStateHAK() {
		return linkStateHAK;
	}

	public void setLinkStateHAK(CheckResult linkStateHAK) {
		this.linkStateHAK = linkStateHAK;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "LINK_1010_CTU")
	public CheckResult getLinkStateCTU() {
		return linkStateCTU;
	}

	public void setLinkStateCTU(CheckResult linkStateCTU) {
		this.linkStateCTU = linkStateCTU;
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
