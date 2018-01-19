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

/**
 * 十里河-PES-PES出境载波状态
 *
 * @author 段衍林
 * @2016年11月14日 上午10:55:13
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_SLH_CAR")
public class SatSlhPes extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	private String carrierPeak; // 峰值
	private String carrierNoise; // 底噪
	private Date checkTime; // 记录时间
	private Date updateTime; // 更新时间
	private User operator; // 操作人
	private SatelliteDayAutoType equipName; // 设备名称

	private transient String carrierPeakShow; // 峰值展示
	private transient String carrierNoiseShow; // 底噪

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Transient
	public String getCarrierPeakShow() {
		return carrierPeakShow;
	}

	public void setCarrierPeakShow(String carrierPeakShow) {
		this.carrierPeakShow = carrierPeakShow;
	}

	@Transient
	public String getCarrierNoiseShow() {
		return carrierNoiseShow;
	}

	public void setCarrierNoiseShow(String carrierNoiseShow) {
		this.carrierNoiseShow = carrierNoiseShow;
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

	@Column(name = "CARRIER_PEAK")
	public String getCarrierPeak() {
		return carrierPeak;
	}

	public void setCarrierPeak(String carrierPeak) {
		this.carrierPeak = carrierPeak;
	}

	@Column(name = "CARRIER_NOISE")
	public String getCarrierNoise() {
		return carrierNoise;
	}

	public void setCarrierNoise(String carrierNoise) {
		this.carrierNoise = carrierNoise;
	}
}
