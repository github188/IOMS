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
import cn.com.atnc.ioms.entity.faultmng.FaultAlarm;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.enums.basedata.AlarmSeverity;
import cn.com.atnc.ioms.enums.basedata.EquipAlarmType;

/**
 * 设备实时告警实体类
 *
 * @author KuYonggang
 * @date 2015年3月31日 上午10:36:33
 * @since 1.0.0
 */
@Entity
@Table(name = "TB_BD_ALARM_STATUS")
public class StatusAlarm extends MyStringUUIDEntity {

	private static final long serialVersionUID = 5038374683281359289L;

	private MaintainEquip equipId;// 告警关联设备id
	private EquipAlarmType type;// 告警类型
	private AlarmSeverity severity;// 告警等级
	private Calendar startTime;// 开始时间
	private Calendar endTime;// 结束时间
	private Integer repTimes;// 告警重复次数
	private Date recordTime;// 告警上传时间
	private String info;// 告警信息

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

	@ManyToOne
	@JoinColumn(name = "equip_id")
	public MaintainEquip getEquipId() {
		return equipId;
	}

	public void setEquipId(MaintainEquip equipId) {
		this.equipId = equipId;
	}

	@Column(name = "info")
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
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

	@Column(name = "severity")
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

	@Column(name = "type")
	@Enumerated(value = EnumType.STRING)
	public EquipAlarmType getType() {
		return this.type;
	}

	public void setType(EquipAlarmType type) {
		this.type = type;
	}

}