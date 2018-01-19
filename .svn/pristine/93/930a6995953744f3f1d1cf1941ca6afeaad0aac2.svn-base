/**
 * @ProjectName IOMS
 * @FileName IStatusAlarmManager.java
 * @PackageName:cn.com.atnc.ioms.mng.basedata.alarm
 * @author KuYonggang
 * @date 2015年3月27日下午5:18:58
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.maintain.alarminfo;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.maintain.alarminfo.LinkAlarm;
import cn.com.atnc.ioms.entity.maintain.alarminfo.StatusAlarm;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

/**
 * 状态告警service 接口
 *
 * @author KuYonggang
 * @date 2015年3月27日 下午5:18:58
 * @since 1.0.0
 */
public interface IStatusAlarmManager {

	/**
	 * 通过事务控制查询所有实体对象
	 *
	 * @return List<StatusAlarm> 查询所有实体对象
	 * @author ku
	 * @date  2015年4月28日上午11:22:35
	 * @since 1.0.0
	 */
	List<StatusAlarm> getAll();

	/**
	 * 查询所有StatusAlarmMonitor状态正常的设备返回MaintainEquip实体的List
	 *
	 * @return 
	 * @date  2015-5-4下午3:00:07
	 * @since 1.0.0
	*/
	public List<MaintainEquip> getAllME();

	/**
	 * 查询所有符合条件的数据返回页面
	 *
	 * @param queryModel
	 * @return 
	 * @date  2015-5-4下午2:59:45
	 * @since 1.0.0
	*/
	public Pagination queryPage(AlarmInfoQueryModel queryModel);

	/**
	 * 很据ID查找单个实体
	 *
	 * @param id
	 * @return 
	 * @date  2015-5-6下午3:33:11
	 * @since 1.0.0
	*/
	public StatusAlarm findById(String id);

	/**
	 * 处理显示的数据返回List
	 *
	 * @param sali
	 * @param queryModel
	 * @return 
	 * @date  2015-5-7上午10:14:10
	 * @since 1.0.0
	*/
	public List<AlarmInfoQueryModel> dealAIQList(List<StatusAlarm> sali,
			AlarmInfoQueryModel queryModel);

	/**
	 * 根据MaintainEquipId查找StatusAlarm实体
	 *
	 * @param id
	 * @return 
	 * @author XuTongYang
	 * @date  2015年6月10日上午10:51:48
	 * @since 1.0.0
	 */
	public StatusAlarm findByMaintainEquipId(String id);
	
	/**
	 * 根据MaintainEquipId查找StatusAlarm实体List
	 *
	 * @param id
	 * @return 
	 * @author XuTongYang
	 * @date  2015年6月10日上午10:51:48
	 * @since 1.0.0
	 */
	public List<StatusAlarm> findListByMaintainEquipId(String id);
}
