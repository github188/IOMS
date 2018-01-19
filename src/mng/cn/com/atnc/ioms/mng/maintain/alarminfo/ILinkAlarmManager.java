/**
 * @ProjectName IOMS
 * @FileName ILinkAlarmManager.java
 * @PackageName:cn.com.atnc.ioms.mng.basedata.alarm
 * @author KuYonggang
 * @date 2015年3月27日下午5:17:04
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.maintain.alarminfo;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.maintain.alarminfo.LinkAlarm;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

/**
 * 此处添加类ILinkAlarmManager的描述信息
 *
 * @author KuYonggang
 * @date 2015年3月27日 下午5:17:04
 * @since 1.0.0
 */
public interface ILinkAlarmManager {

	/**
	 * 通过事务控制查询所有实体集合
	 *
	 * @return List<LinkAlarm> 所有实体集合
	 * @author ku
	 * @date  2015年4月28日上午11:45:59
	 * @since 1.0.0
	 */
	List<LinkAlarm> getAll();

	/**
	 * 查询符合条件数据返回页面
	 *
	 * @param queryModel
	 * @return
	 * @throws ServiceException 
	 * @date  2015-5-4下午2:57:27
	 * @since 1.0.0
	*/
	public Pagination queryPage(AlarmInfoQueryModel queryModel) throws ServiceException;

	/**
	 * 查询所有LinkAlarmMonitor状态正常的设备MaintainEquip实体的List
	 *
	 * @return 
	 * @date  2015-5-4下午2:58:03
	 * @since 1.0.0
	*/
	public List<MaintainEquip> getAllME();

	/**
	 * 根据ID查找单个实体
	 *
	 * @param id
	 * @return 
	 * @date  2015-5-6下午3:33:41
	 * @since 1.0.0
	*/
	public LinkAlarm findById(String id);

	/**
	 * 处理数据返回List
	 *
	 * @param lali
	 * @param queryModel 
	 * @return 
	 * @date  2015-5-7上午10:03:56
	 * @since 1.0.0
	*/
	public List<AlarmInfoQueryModel> dealAIQList(List<LinkAlarm> lali, AlarmInfoQueryModel queryModel);

	/**
	 * 根据MaintainEquipId查找LinkAlarm实体
	 *
	 * @param id
	 * @return 
	 * @author XuTongYang
	 * @date  2015年6月10日上午10:51:48
	 * @since 1.0.0
	 */
	public LinkAlarm findByMaintainEquipId(String id);
}
