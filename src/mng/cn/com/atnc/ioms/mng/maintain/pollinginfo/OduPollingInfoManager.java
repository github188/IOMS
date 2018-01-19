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

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.OduPolling;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;

/**
 * odu
 *
 * @author wangzhicheng
 * @date 2015-4-27 下午2:41:08
 * @since 1.0.0
 */
public interface OduPollingInfoManager {

	/**
	 * 查询符合条件的数据返回页面
	 *
	 * @param queryModel
	 * @return
	 * @throws ServiceException
	 * @date 2015-5-4下午3:03:31
	 * @since 1.0.0
	 */
	public Pagination queryPage(PollingInfoQueryModel queryModel)
			throws ServiceException;

	/**
	 * 根据ID查询实体
	 *
	 * @param id
	 * @return
	 * @date 2015-5-4下午3:04:01
	 * @since 1.0.0
	 */
	public OduPolling findById(String id);

	/**
	 * 根据维保设备查找实体集合
	 * 
	 * @author 王凌斌
	 * @2017年1月23日 上午10:28:51
	 * @param modems
	 * @return List<OduPolling>
	 */
	public List<OduPolling> findByMaintainEquip(List<MaintainEquip> modems);

}
