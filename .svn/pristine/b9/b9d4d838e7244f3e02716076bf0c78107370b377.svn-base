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
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.satellite.OutSideEquipType;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteStatus;

/**
 * 室外设备巡检 实体
 *
 * @author 段衍林
 * @2016年11月17日 下午2:56:01
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_OUTSIDE_EQUIP")
public class OutsideEquipCheck extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	private String oduOnSide; // 主用侧结果
	private String oduLevel; // 电平
	private String occCarrNoise; // occ载噪比
	private SatelliteStatus blowerState; // ODU风扇状态(normal,unnormal)
	private SatelliteStatus linkState; // 电缆连接与接头防水(normal,unnormal)
	private String temperatureA; // A路温度
	private String temperatureB; // B路温度
	private CheckCatagory checkType; // 巡检类型（月、季、年）

	private Date checkTime; // 记录时间
	private User operator; // 操作人
	private Date updateTime; // 记录时间
	private User updater; // 操作人
	private OutSideEquipType checkEquip; // 设备名称

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

	@ManyToOne
	@JoinColumn(name = "OPERATOR")
	public User getOperator() {
		return operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "CHECK_EQUIP")
	public OutSideEquipType getCheckEquip() {
		return checkEquip;
	}

	public void setCheckEquip(OutSideEquipType checkEquip) {
		this.checkEquip = checkEquip;
	}

	@Column(name = "ODU_SIDE")
	public String getOduOnSide() {
		return oduOnSide;
	}

	public void setOduOnSide(String oduOnSide) {
		this.oduOnSide = oduOnSide;
	}

	@Column(name = "ODU_LEVEL")
	public String getOduLevel() {
		return oduLevel;
	}

	public void setOduLevel(String oduLevel) {
		this.oduLevel = oduLevel;
	}

	@Column(name = "OCC_CARRNOISE")
	public String getOccCarrNoise() {
		return occCarrNoise;
	}

	public void setOccCarrNoise(String occCarrNoise) {
		this.occCarrNoise = occCarrNoise;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "BLOWER_STATE")
	public SatelliteStatus getBlowerState() {
		return blowerState;
	}

	public void setBlowerState(SatelliteStatus blowerState) {
		this.blowerState = blowerState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "lINK_STATE")
	public SatelliteStatus getLinkState() {
		return linkState;
	}

	public void setLinkState(SatelliteStatus linkState) {
		this.linkState = linkState;
	}

	@Column(name = "TEMPERATURE_A")
	public String getTemperatureA() {
		return temperatureA;
	}

	public void setTemperatureA(String temperatureA) {
		this.temperatureA = temperatureA;
	}

	@Column(name = "TEMPERATURE_B")
	public String getTemperatureB() {
		return temperatureB;
	}

	public void setTemperatureB(String temperatureB) {
		this.temperatureB = temperatureB;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "CHECK_TYPE")
	public CheckCatagory getCheckType() {
		return checkType;
	}

	public void setCheckType(CheckCatagory checkType) {
		this.checkType = checkType;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "RECORD_TIME")
	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
}
