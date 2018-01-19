package cn.com.atnc.ioms.entity.maintain.alarminfo;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.resource.Proxy;
import cn.com.atnc.ioms.entity.faultmng.FaultAlarm;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.enums.basedata.AlarmSeverity;
import cn.com.atnc.ioms.enums.basedata.ClearSource;
import cn.com.atnc.ioms.enums.basedata.LinkAlarmType;

/**
 * 链路历史告警记录
 * 
 * @author:HuangYijie
 * @date:2011-6-8 下午01:22:49
 * @version:1.0
 */
@Entity
@Table(name = "TB_BD_ALARM_LINK_HISTORY")
public class LinkAlarmHistory extends MyStringUUIDEntity {

	public LinkAlarmHistory() {
	}

	public LinkAlarmHistory(LinkAlarm alarm) {
		this.setId(alarm.getId());
		this.setProxyId(alarm.getProxyId());
		this.setEquipId(alarm.getEquipId());
		this.setType(alarm.getType());
		this.setSeverity(alarm.getSeverity());
		this.setStartTime(alarm.getStartTime());
		this.setEndTime(alarm.getEndTime());
		this.setRepTimes(alarm.getRepTimes());
		this.setRecordTime(alarm.getRecordTime());
		this.setInfo(alarm.getInfo());
		this.setFaultAlarm(alarm.getFaultAlarm());
	}

	private static final long serialVersionUID = 8379892469224432057L;

	private Proxy proxyId;// 告警关联远端站id
	private MaintainEquip equipId;// 告警关联设备id
	private LinkAlarmType type;// 告警类型
	private AlarmSeverity severity;// 告警等级
	private Calendar startTime;// 告警开始时间
	private Calendar endTime;// 结束时间
	private Integer repTimes;// 告警重复时间
	private Date recordTime;// 告警上传时间
	private String info;// 告警描述信息
	private ClearSource clear;// 清除状态0-未清除，1-清除
	private Date clearTime;// 清除时间
	private String clearUser;// 清除者
	private FaultAlarm faultAlarm;// 告警事件单

	@ManyToOne
	@JoinColumn(name = "FAULTALARM_ID")
	public FaultAlarm getFaultAlarm() {
		return faultAlarm;
	}

	public void setFaultAlarm(FaultAlarm faultAlarm) {
		this.faultAlarm = faultAlarm;
	}

	@Column(name = "end_time")
	public Calendar getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@ManyToOne
	@JoinColumn(name = "equip_id")
	public MaintainEquip getEquipId() {
		return equipId;
	}

	public void setEquipId(MaintainEquip equipId) {
		this.equipId = equipId;
	}

	@ManyToOne
	@JoinColumn(name = "proxy_id")
	public Proxy getProxyId() {
		return proxyId;
	}

	public void setProxyId(Proxy proxyId) {
		this.proxyId = proxyId;
	}

	@Column(name = "record_time")
	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	@Column(name = "rep_times")
	public Integer getRepTimes() {
		return this.repTimes;
	}

	public void setRepTimes(Integer repTimes) {
		this.repTimes = repTimes;
	}

	@Enumerated(value = EnumType.STRING)
	public AlarmSeverity getSeverity() {
		return this.severity;
	}

	public void setSeverity(AlarmSeverity severity) {
		this.severity = severity;
	}

	@Column(name = "start_time")
	public Calendar getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	@Enumerated(value = EnumType.STRING)
	public LinkAlarmType getType() {
		return this.type;
	}

	public void setType(LinkAlarmType type) {
		this.type = type;
	}

	@Enumerated(value = EnumType.STRING)
	public ClearSource getClear() {
		return this.clear;
	}

	public void setClear(ClearSource clear) {
		this.clear = clear;
	}

	@Column(name = "clear_time")
	public Date getClearTime() {
		return clearTime;
	}

	public void setClearTime(Date clearTime) {
		this.clearTime = clearTime;
	}

	@Column(name = "clear_user")
	public String getClearUser() {
		return this.clearUser;
	}

	public void setClearUser(String clearUser) {
		this.clearUser = clearUser;
	}

}