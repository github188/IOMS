/**
 * @ProjectName IOMS
 * @FileName IKuNodeParameterDao.java
 * @PackageName:cn.com.atnc.ioms.dao.operstat.ku
 * @author KuYonggang
 * @date 2015年4月1日下午1:23:34
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.month;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.maintain.month.KuReportData;
import cn.com.atnc.ioms.model.maintain.satellite.SatelliteQueryModel;

/**
 * KU报表数据DAO
 * 
 * @author 王凌斌
 * @2017年2月23日 下午1:23:38
 */
public interface IKuReportDataDao extends IBaseDao<KuReportData> {

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

}
