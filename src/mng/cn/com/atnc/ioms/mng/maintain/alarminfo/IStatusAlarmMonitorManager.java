/**
 * @ProjectName IOMS
 * @FileName IStatusAlarmMonitorManager.java
 * @PackageName:cn.com.atnc.ioms.mng.basedata.alarm
 * @author KuYonggang
 * @date 2015年4月22日下午5:04:08
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.maintain.alarminfo;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.maintain.alarminfo.StatusAlarmMonitor;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

/**
 * 状态告警监控服务类接口
 *
 * @author KuYonggang
 * @date 2015年4月22日 下午5:04:08
 * @since 1.0.0
 */
public interface IStatusAlarmMonitorManager {

	/**
	 * 更新状态告警的告警状态
	 * 
	 * @author ku
	 * @date  2015年4月28日上午10:55:42
	 * @since 1.0.0
	 */
	void updateStatusAlarmState();
	
	/**
	 * 在事务中查询所有实体的方法
	 *
	 * @return List<StatusAlarmMonitor> 所有实体对象集合
	 * @author ku
	 * @date  2015年4月28日上午11:07:09
	 * @since 1.0.0
	 */
	List<StatusAlarmMonitor> getAll();
	/**
	 * 获取statusMonitor所有实体分页
	 *
	 * @param queryModel
	 * @return 
	 * @author XuTongYang
	 * @date  2015年6月10日上午10:22:57
	 * @since 1.0.0
	 */
	public Pagination queryPage(AlarmInfoQueryModel queryModel);
}
