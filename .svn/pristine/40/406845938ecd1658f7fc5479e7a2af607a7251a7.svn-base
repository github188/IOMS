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

import java.util.Date;
import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.maintain.month.KuMonthReport;
import cn.com.atnc.ioms.enums.maintain.month.KuMonthReportLegendEnum;

/**
 * KU月度报告DAO接口
 * 
 * @author 王凌斌
 * @2017年1月24日 上午10:41:39
 */
public interface IKuMonthReportDao extends IBaseDao<KuMonthReport> {

	/**
	 * 根据日期和统计纬度获取数据
	 * 
	 * @author 王凌斌
	 * @2017年1月24日 上午11:13:11
	 * @param currentDate
	 * @param legends
	 * @return List<KuMonthReport>
	 */
	List<KuMonthReport> findByDateAndLegend(String currentDate,
			List<KuMonthReportLegendEnum> legends, SatelliteSite satelliteSite);

	/**
	 * 查找是否存在
	 * 
	 * @author 王凌斌
	 * @2017年1月23日 下午4:03:08
	 * @param legend
	 * @param recordDate
	 * @param equip
	 * @param satelliteSite
	 * @return KuMonthReport
	 */
	KuMonthReport findExist(KuMonthReportLegendEnum legend, Date recordDate,
			Equip equip, SatelliteSite satelliteSite);

}
