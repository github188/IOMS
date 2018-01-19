package cn.com.atnc.ioms.entity.faultmng;

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
import cn.com.atnc.ioms.entity.basedata.resource.Proxy;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.enums.faultmng.FaultAlarmStatus;

/**
 * 告警事件单绑定实体
 *
 * @author 段衍林
 * @2017年1月19日 下午1:14:04
 */
@Entity
@Table(name = "TB_FM_FAULT_ALARM")
public class FaultAlarm extends MyStringUUIDEntity {
	private static final long serialVersionUID = -6739376065386900888L;
	private FaultInformation fault; // 绑定事件单
	private MaintainEquip equip; // 告警设备
	private Proxy proxy;// 节点信息
	private String alarmInfo; // 告警描述
	private FaultAlarmStatus status;// 告警事件处置状态--生成告警，生成事件单，解除告警
	private Date alarmTime; // 告警时间
	private Date createTime; // 创建时间
	private User updater; // 更新操作人
	private Date updateTime; // 更新时间
	private String updateInfo;// 告警更新信息
	private Date updateAlarmDate; // 告警更新时间
	private transient SatelliteSite satelliteSite;// 卫星站点数据--冗余字段

	@Column(name = "UPDATE_INFO")
	public String getUpdateInfo() {
		return updateInfo;
	}

	public void setUpdateInfo(String updateInfo) {
		this.updateInfo = updateInfo;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "ALARM_UPDATE_TIME")
	public Date getUpdateAlarmDate() {
		return updateAlarmDate;
	}

	public void setUpdateAlarmDate(Date updateAlarmDate) {
		this.updateAlarmDate = updateAlarmDate;
	}

	@Transient
	public SatelliteSite getSatelliteSite() {
		return satelliteSite;
	}

	public void setSatelliteSite(SatelliteSite satelliteSite) {
		this.satelliteSite = satelliteSite;
	}

	@ManyToOne
	@JoinColumn(name = "PROXY_ID")
	public Proxy getProxy() {
		return proxy;
	}

	public void setProxy(Proxy proxy) {
		this.proxy = proxy;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "ALARM_TIME")
	public Date getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}

	@ManyToOne
	@JoinColumn(name = "FAULT_ID")
	public FaultInformation getFault() {
		return fault;
	}

	public void setFault(FaultInformation fault) {
		this.fault = fault;
	}

	@ManyToOne
	@JoinColumn(name = "EQUIP_ID")
	public MaintainEquip getEquip() {
		return equip;
	}

	public void setEquip(MaintainEquip equip) {
		this.equip = equip;
	}

	@Column(name = "ALARM_INFO")
	public String getAlarmInfo() {
		return alarmInfo;
	}

	public void setAlarmInfo(String alarmInfo) {
		this.alarmInfo = alarmInfo;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@ManyToOne
	@JoinColumn(name = "UPDATER")
	public User getUpdater() {
		return updater;
	}

	public void setUpdater(User updater) {
		this.updater = updater;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	public FaultAlarmStatus getStatus() {
		return status;
	}

	public void setStatus(FaultAlarmStatus status) {
		this.status = status;
	}
}