/**
 * @ProjectName IOMS
 * @FileName ILinkAlarmManager.java
 * @PackageName:cn.com.atnc.ioms.mng.basedata.alarm
 * @author KuYonggang
 * @date 2015年3月27日下午5:17:04
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.maintain.pollinginfo;

import java.util.Date;
import java.util.List;

import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.KuNodeInfo;

/**
 * 节点信息业务类
 * 
 * @author 王凌斌
 * @2017年1月22日 下午1:06:27
 */
public interface KuNodeInfoManager {

	/**
	 * 根据维保设备获取最新一条的节点信息集合
	 * 
	 * @author 王凌斌
	 * @2017年1月22日 下午1:09:24
	 * @param maintainEquips
	 * @return List<KuNodeInfo>
	 */
	public List<KuNodeInfo> findByMaintainEquip(
			List<MaintainEquip> maintainEquips);

	/**
	 * 根据维保设备和时间查找节点信息集合
	 * 
	 * @author 王凌斌
	 * @2017年1月24日 下午3:03:05
	 * @param maintainEquips
	 * @param date
	 * @return List<KuNodeInfo>
	 */
	public List<KuNodeInfo> findByMaintainEquip(MaintainEquip maintainEquip,
			Date date);

}
