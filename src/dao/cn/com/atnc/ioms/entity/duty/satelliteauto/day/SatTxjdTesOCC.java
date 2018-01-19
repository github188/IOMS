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
 * 通信基地-TES-TES OCC状态实体
 *
 * @author 段衍林
 * @2016年11月10日 下午1:18:30
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_TESOCC")
public class SatTxjdTesOCC extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	private String occ1Noise; // occ1底噪
	private String occ1Peak; // occ1峰值
	private String occ2Noise; // occ2底噪
	private String occ2Peak; // occ2峰值
	private String occ3Noise; // occ3底噪
	private String occ3Peak; // occ3峰值
	private String occ4Noise; // occ4底噪
	private String occ4Peak; // occ4峰值
	private Date checkTime; // 记录时间
	private Date updateTime; // 更新时间
	private User operator; // 操作人
	private SatelliteDayAutoType equipName; // 设备名称
	/**
	 * 冗余字段，页面显示使用
	 */
	private transient String noise1; // occ1底噪
	private transient String noise2; // occ2底噪
	private transient String noise3; // occ3底噪
	private transient String noise4; // occ4底噪
	private transient String peak1; // occ1峰值
	private transient String peak2; // occ2峰值
	private transient String peak3; // occ3峰值
	private transient String peak4; // occ4峰值

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Transient
	public String getNoise1() {
		return noise1;
	}

	public void setNoise1(String noise1) {
		this.noise1 = noise1;
	}

	@Transient
	public String getNoise2() {
		return noise2;
	}

	public void setNoise2(String noise2) {
		this.noise2 = noise2;
	}

	@Transient
	public String getNoise3() {
		return noise3;
	}

	public void setNoise3(String noise3) {
		this.noise3 = noise3;
	}

	@Transient
	public String getNoise4() {
		return noise4;
	}

	public void setNoise4(String noise4) {
		this.noise4 = noise4;
	}

	@Transient
	public String getPeak1() {
		return peak1;
	}

	public void setPeak1(String peak1) {
		this.peak1 = peak1;
	}

	@Transient
	public String getPeak2() {
		return peak2;
	}

	public void setPeak2(String peak2) {
		this.peak2 = peak2;
	}

	@Transient
	public String getPeak3() {
		return peak3;
	}

	public void setPeak3(String peak3) {
		this.peak3 = peak3;
	}

	@Transient
	public String getPeak4() {
		return peak4;
	}

	public void setPeak4(String peak4) {
		this.peak4 = peak4;
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

	@Column(name = "OCC1_NOISE")
	public String getOcc1Noise() {
		return occ1Noise;
	}

	public void setOcc1Noise(String occ1Noise) {
		this.occ1Noise = occ1Noise;
	}

	@Column(name = "OCC1_Peak")
	public String getOcc1Peak() {
		return occ1Peak;
	}

	public void setOcc1Peak(String occ1Peak) {
		this.occ1Peak = occ1Peak;
	}

	@Column(name = "OCC2_NOISE")
	public String getOcc2Noise() {
		return occ2Noise;
	}

	public void setOcc2Noise(String occ2Noise) {
		this.occ2Noise = occ2Noise;
	}

	@Column(name = "OCC2_Peak")
	public String getOcc2Peak() {
		return occ2Peak;
	}

	public void setOcc2Peak(String occ2Peak) {
		this.occ2Peak = occ2Peak;
	}

	@Column(name = "OCC3_NOISE")
	public String getOcc3Noise() {
		return occ3Noise;
	}

	public void setOcc3Noise(String occ3Noise) {
		this.occ3Noise = occ3Noise;
	}

	@Column(name = "OCC3_Peak")
	public String getOcc3Peak() {
		return occ3Peak;
	}

	public void setOcc3Peak(String occ3Peak) {
		this.occ3Peak = occ3Peak;
	}

	@Column(name = "OCC4_NOISE")
	public String getOcc4Noise() {
		return occ4Noise;
	}

	public void setOcc4Noise(String occ4Noise) {
		this.occ4Noise = occ4Noise;
	}

	@Column(name = "OCC4_Peak")
	public String getOcc4Peak() {
		return occ4Peak;
	}

	public void setOcc4Peak(String occ4Peak) {
		this.occ4Peak = occ4Peak;
	}
}
