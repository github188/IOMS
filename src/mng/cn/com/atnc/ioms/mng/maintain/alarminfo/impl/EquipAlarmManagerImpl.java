/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName EquipAlarmManagerImpl.java
 * @PackageName:cn.com.atnc.ioms.mng.maintain.alarminfo.impl
 * @author ku
 * @date 2015年4月28日下午4:13:19
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.maintain.alarminfo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.maintain.alarminfo.IEquipAlarmDao;
import cn.com.atnc.ioms.entity.maintain.alarminfo.EquipAlarm;
import cn.com.atnc.ioms.mng.maintain.alarminfo.IEquipAlarmManager;

/**
 * 设备告警service接口实现类
 *
 * @author ku
 * @date 2015年4月28日 下午4:13:19
 * @since 1.0.0
 */
@Service
@Transactional
public class EquipAlarmManagerImpl extends AbstractService implements
		IEquipAlarmManager {

	@Autowired
	private IEquipAlarmDao equipAlarmDao;
	
	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.mng.maintain.alarminfo.IEquipAlarmManager#findEquipAlarmByEquipId(java.lang.String)
	 */
	@Override
	@Transactional(readOnly=true)
	public EquipAlarm findEquipAlarmByEquipId(String id) {
		// TODO Auto-generated method stub
		return equipAlarmDao.findByParam("equipId.id", id);
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.mng.maintain.alarminfo.IEquipAlarmManager#saveEquipAlarm(cn.com.atnc.ioms.entity.maintain.alarminfo.EquipAlarm)
	 */
	@Override
	public void saveEquipAlarm(EquipAlarm temp) {
		// TODO Auto-generated method stub
		equipAlarmDao.save(temp);
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.mng.maintain.alarminfo.IEquipAlarmManager#updateEquipAlarm(cn.com.atnc.ioms.entity.maintain.alarminfo.EquipAlarm)
	 */
	@Override
	public void updateEquipAlarm(EquipAlarm equipAlarm) {
		equipAlarmDao.update(equipAlarm);
	}

}
