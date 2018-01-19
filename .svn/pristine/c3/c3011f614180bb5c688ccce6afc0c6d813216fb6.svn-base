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

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.Wafr08Port0Stat;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;

/**
 * odu
 *
 * @author wangzhicheng
 * @date 2015-4-27 下午2:41:08
 * @since 1.0.0
 */
public interface Wafr08Port0StatManager {

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
	public Wafr08Port0Stat findById(String id);

	/**
	 * 查询所有实体返回List
	 *
	 * @return
	 * @date 2015-5-6下午3:27:28
	 * @since 1.0.0
	 */
	public List<Wafr08Port0Stat> findAll();

	/**
	 * 根据维保设备和记录时间获取最新一条记录
	 * 
	 * @author 王凌斌
	 * @2017年1月24日 上午10:39:26
	 * @param maintainEquip
	 * @param currentDate
	 * @return Wafr08Port0Stat
	 */
	public Wafr08Port0Stat findByEquipAndDate(MaintainEquip maintainEquip,
			Date currentDate);

}
