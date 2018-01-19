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

import java.util.List;

import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.maintain.month.KuMonthReport;
import cn.com.atnc.ioms.enums.maintain.month.KuMonthReportLegendEnum;

/**
 * KU月度报告业务类
 * 
 * @author 王凌斌
 * @2017年1月24日 上午10:46:59
 */
public interface KuMonthReportManager {

	/**
	 * 根据日期和统计纬度获取数据
	 * 
	 * @author 王凌斌
	 * @2017年1月24日 上午11:10:41
	 * @param currentDate
	 * @param legends
	 * @return List<KuMonthReport>
	 */
	List<KuMonthReport> findByDateAndLegend(String currentDate,
			List<KuMonthReportLegendEnum> legends, SatelliteSite satelliteSite);

	/**
	 * 计算当天的统计参数值
	 * 
	 * @author 王凌斌
	 * @2017年1月24日 下午2:29:21 void
	 */
	public void calLegendValueByDay();

}
