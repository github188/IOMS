/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName ILinkAlarmMonitorDao.java
 * @PackageName:cn.com.atnc.ioms.dao.maintain.alarminfo
 * @author ku
 * @date 2015年4月27日下午3:52:31
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.alarminfo;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.maintain.alarminfo.LinkAlarmMonitor;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

/**
 * 链路告警监控Dao接口
 *
 * @author ku
 * @date 2015年4月27日 下午3:52:31
 * @since 1.0.0
 */
public interface ILinkAlarmMonitorDao extends IBaseDao<LinkAlarmMonitor> {
	public Pagination queryPage(AlarmInfoQueryModel queryModel);
}
