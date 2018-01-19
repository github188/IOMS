/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName EquipAlarm.java
 * @PackageName:cn.com.atnc.ioms.entity.maintain.alarminfo
 * @author ku
 * @date 2015年4月28日下午4:06:34
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.entity.maintain.alarminfo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;

/**
 * 设备告警实体类
 *
 * @author ku
 * @date 2015年4月28日 下午4:06:34
 * @since 1.0.0
 */
@Entity
@Table(name="TB_BD_ALARM_EQUIP")
public class EquipAlarm extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;
	
	private MaintainEquip equipId;
	private Date lastFileTime;
	
	@ManyToOne
	@JoinColumn(name = "equip_id")
	public MaintainEquip getEquipId() {
		return equipId;
	}
	public void setEquipId(MaintainEquip equipId) {
		this.equipId = equipId;
	}
	/**
	 * 返回成员变量 lastFileTime
	 *
	 * @return lastFileTime
	 * @since  1.0.0
	 */
	public Date getLastFileTime() {
		return lastFileTime;
	}
	/**
	 * 赋值给成员变量lastFileTime
	 *
	 * @param lastFileTime 
	 * @since  1.0.0
	 */
	public void setLastFileTime(Date lastFileTime) {
		this.lastFileTime = lastFileTime;
	}
	
}
