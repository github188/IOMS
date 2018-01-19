/**
 * @ProjectName IOMS
 * @FileName LinkAlarmMonitor.java
 * @PackageName:cn.com.atnc.ioms.entity.basedata.alarm
 * @author KuYonggang
 * @date 2015年4月22日上午9:06:13
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.entity.maintain.alarminfo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.enums.basedata.AlarmStatusEnum;

/**
 *  状态告警监控实体
 *
 * @author KuYonggang
 * @date 2015年4月22日 上午9:06:13
 * @since 1.0.0
 */
@Entity
@Table(name="TB_BD_ALARM_STATUS_MONITOR")
public class StatusAlarmMonitor extends MyStringUUIDEntity {

	private static final long serialVersionUID = -8485871888952908295L;
	
	private MaintainEquip equipId; //告警关联设备id
	private Date recordTime; //告警采集时间
	private AlarmStatusEnum alarmStatus; //告警状态
	
	@OneToOne
	@JoinColumn(name = "equip_id")
	public MaintainEquip getEquipId() {
		return equipId;
	}
	public void setEquipId(MaintainEquip equipId) {
		this.equipId = equipId;
	}
	@Column(name = "record_time")
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "alarm_status")
	public AlarmStatusEnum getAlarmStatus() {
		return alarmStatus;
	}
	public void setAlarmStatus(AlarmStatusEnum alarmStatus) {
		this.alarmStatus = alarmStatus;
	}
}
