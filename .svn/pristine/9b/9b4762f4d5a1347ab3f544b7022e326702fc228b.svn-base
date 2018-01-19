package cn.com.atnc.ioms.mng.maintain.alarminfo;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.maintain.alarminfo.LinkAlarmMonitor;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

/**
 * 链路告警监控service接口
 *
 * @author ku
 * @date 2015年4月27日 下午3:31:26
 * @since 1.0.0
 */
public interface ILinkAlarmMonitorManager {

	/**
	 * 更新链路告警的告警状态
	 * 
	 * @author ku
	 * @date  2015年4月28日上午10:56:08
	 * @since 1.0.0
	 */
	public void updateLinkAlarmState();

	/**
	 * 通过事务控制查询所有实体集合
	 *
	 * @return List<LinkAlarm> 所有实体集合
	 * @author ku
	 * @date  2015年4月28日上午11:45:59
	 * @since 1.0.0
	 */
	List<LinkAlarmMonitor> getAll();
	
	/**
	 * 获取alramMonitor所有实体分页
	 *
	 * @param queryModel
	 * @return 
	 * @author XuTongYang
	 * @date  2015年6月10日上午10:22:57
	 * @since 1.0.0
	 */
	public Pagination queryPage(AlarmInfoQueryModel queryModel);
}
