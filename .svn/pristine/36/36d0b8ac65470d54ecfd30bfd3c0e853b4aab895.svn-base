/**
 * @ProjectName IOMS
 * @FileName ILinkAlarmManager.java
 * @PackageName:cn.com.atnc.ioms.mng.basedata.alarm
 * @author KuYonggang
 * @date 2015年3月27日下午5:17:04
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.maintain.month;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.maintain.month.KuReportData;
import cn.com.atnc.ioms.model.maintain.satellite.SatelliteQueryModel;

/**
 * KU报表数据Service
 * 
 * @author 王凌斌
 * @2017年2月23日 下午1:24:04
 */
public interface KuReportDataManager {

	/**
	 * 分页查询
	 * 
	 * @author 王凌斌
	 * @2017年2月23日 下午1:21:58
	 * @param queryModel
	 * @return Pagination
	 */
	Pagination queryPage(SatelliteQueryModel queryModel);

	/**
	 * 根据日期和站点查找记录
	 * 
	 * @author 王凌斌
	 * @2017年2月23日 下午1:19:22
	 * @param date
	 * @param satelliteSite
	 * @return Boolean
	 */
	Boolean findByDateAndSatellite(String date, SatelliteSite satelliteSite);

	/**
	 * 根据主键ID获取实体
	 * 
	 * @author 王凌斌
	 * @2017年2月23日 下午2:57:37
	 * @param id
	 * @return KuReportData
	 */
	KuReportData findById(String id);

	/**
	 * 补全记录
	 * 
	 * @author 王凌斌
	 * @2017年2月23日 下午3:14:41
	 * @param kuReportData
	 * @param queryModel
	 * @return KuReportData
	 */
	KuReportData write(KuReportData kuReportData, SatelliteQueryModel queryModel);
}
