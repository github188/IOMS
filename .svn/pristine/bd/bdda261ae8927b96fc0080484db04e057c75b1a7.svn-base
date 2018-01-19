/**
 * @ProjectName IOMS
 * @FileName IKuNodeParameterDao.java
 * @PackageName:cn.com.atnc.ioms.dao.operstat.ku
 * @author KuYonggang
 * @date 2015年4月1日下午1:23:34
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.pollinginfo;

import java.util.Date;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.Wafr08Port0Stat;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;

/**
 * wafr08端口统计DAO接口
 *
 * @author KuYonggang
 * @date 2015年4月1日 下午1:23:34
 * @since 1.0.0
 */
public interface IWafr08Port0StatDao extends IBaseDao<Wafr08Port0Stat> {

	public Pagination queryPage(PollingInfoQueryModel queryModel);

	/**
	 * 根据维保设备和记录时间获取最新一条记录
	 * 
	 * @author 王凌斌
	 * @2017年1月24日 上午10:40:20
	 * @param maintainEquip
	 * @param currentDate
	 * @return Wafr08Port0Stat
	 */
	public Wafr08Port0Stat findByEquipAndDate(MaintainEquip maintainEquip,
			Date currentDate);

}
