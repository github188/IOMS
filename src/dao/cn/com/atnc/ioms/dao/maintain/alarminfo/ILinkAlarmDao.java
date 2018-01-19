/**
 * @ProjectName IOMS
 * @FileName ILinkAlarmDao.java
 * @PackageName:cn.com.atnc.ioms.dao.basedata.alarm
 * @author KuYonggang
 * @date 2015年3月27日下午5:21:00
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.alarminfo;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.maintain.alarminfo.LinkAlarm;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

/**
 * @author KuYonggang
 * @date 2015年3月27日 下午5:21:00
 * @since 1.0.0
 */
public interface ILinkAlarmDao extends IBaseDao<LinkAlarm> {

	public Pagination queryPage(AlarmInfoQueryModel queryModel);

	/**
	 * 根据EquipId查询链路告警对象
	 *
	 * @param equipId
	 * @return 
	 * @author ku
	 * @date  2015年6月8日下午4:53:25
	 * @since 1.0.0
	 */
	public LinkAlarm findByEquipId(String equipId);

}
