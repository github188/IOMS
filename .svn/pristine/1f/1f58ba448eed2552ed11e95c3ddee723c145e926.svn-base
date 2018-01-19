/**
 * @ProjectName IOMS
 * @FileName IStatusAlarmDao.java
 * @PackageName:cn.com.atnc.ioms.dao.basedata.alarm
 * @author KuYonggang
 * @date 2015年3月27日下午5:21:41
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.alarminfo;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.maintain.alarminfo.StatusAlarm;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.enums.basedata.EquipAlarmType;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

/**
 * 状态告警Dao接口
 *
 * @author KuYonggang
 * @date 2015年3月27日 下午5:21:41
 * @since 1.0.0
 */
public interface IStatusAlarmDao extends IBaseDao<StatusAlarm> {

	public Pagination queryPage(AlarmInfoQueryModel queryModel);

	/**
	 * 根据运维设备ID和设备告警类别查询状态告警对象
	 *
	 * @param id
	 * @param thresholdwarning
	 * @return 
	 * @author ku
	 * @date  2015年6月10日下午4:17:57
	 * @since 1.0.0
	 */
	public StatusAlarm getStatusAlarm(String id, EquipAlarmType thresholdwarning);
	
	public List<StatusAlarm> findStatusAlarmByEquip(String id);
}
