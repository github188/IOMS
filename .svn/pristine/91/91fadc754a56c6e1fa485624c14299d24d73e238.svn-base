/**
 * @ProjectName IOMS
 * @FileName KuNodeParameterDaoImpl.java
 * @PackageName:cn.com.atnc.ioms.dao.operstat.ku.hibernate
 * @author KuYonggang
 * @date 2015年4月1日下午1:25:23
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.month.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.maintain.month.IKuMonthReportDao;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.maintain.month.KuMonthReport;
import cn.com.atnc.ioms.enums.maintain.month.KuMonthReportLegendEnum;

/**
 * Ku月度报告DAO实现类
 * 
 * @author 王凌斌
 * @2017年1月24日 上午10:44:51
 */
@Repository
public class KuMonthReportDaoImpl extends MyBaseDao<KuMonthReport> implements
		IKuMonthReportDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<KuMonthReport> findByDateAndLegend(String currentDate,
			List<KuMonthReportLegendEnum> legends, SatelliteSite satelliteSite) {
		// HQL语句
		StringBuilder hql = new StringBuilder("from KuMonthReport where 1=1");
		// 查询参数
		List<Object> params = new ArrayList<Object>();
		// 统计日期
		hql.append(" and recordTime = ?");
		params.add(currentDate);
		// 统计纬度
		hql.append(" and legend in ( ");
		for (KuMonthReportLegendEnum legend : legends) {
			hql.append("?,");
			params.add(legend);
		}
		hql.deleteCharAt(hql.length() - 1);
		hql.append(")");
		// 站点ID
		hql.append(" and satellite = ?");
		params.add(satelliteSite);
		// 按照legend和时间排序
		hql.append(" order by legend asc,recordDate asc");
		return (List<KuMonthReport>) this.queryList(hql.toString(),
				params.toArray());
	}

	@SuppressWarnings("unchecked")
	@Override
	public KuMonthReport findExist(KuMonthReportLegendEnum legend, Date recordDate,
			Equip equip, SatelliteSite satelliteSite) {
		// HQL语句
		StringBuilder hql = new StringBuilder("from KuMonthReport where 1=1");
		// 查询参数
		List<Object> params = new ArrayList<Object>();
		// 统计纬度
		hql.append(" and legend = ?");
		params.add(legend);
		// 统计日期
		hql.append(" and recordDate = ?");
		params.add(recordDate);
		// 节点
		hql.append(" and equip = ?");
		params.add(equip);
		// 站点
		hql.append(" and satellite = ?");
		params.add(satelliteSite);
		List<KuMonthReport> kuMonthReports = (List<KuMonthReport>) this
				.queryList(hql.toString(), params.toArray());
		return CollectionUtils.isEmpty(kuMonthReports) ? null
				: kuMonthReports.get(0);
	}

}
