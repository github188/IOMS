/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName EquipAlarmDaoImpl.java
 * @PackageName:cn.com.atnc.ioms.dao.maintain.alarminfo.hibernate
 * @author ku
 * @date 2015年4月28日下午4:10:33
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.alarminfo.hibernate;

import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.maintain.alarminfo.IEquipAlarmDao;
import cn.com.atnc.ioms.entity.maintain.alarminfo.EquipAlarm;

/**
 * 设备告警Dao接口实现类
 *
 * @author ku
 * @date 2015年4月28日 下午4:10:33
 * @since 1.0.0
 */
@Repository
public class EquipAlarmDaoImpl extends MyBaseDao<EquipAlarm> implements IEquipAlarmDao {

}
