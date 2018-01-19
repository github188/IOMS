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
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.maintain.month.IKuReportDataDao;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.maintain.month.KuReportData;
import cn.com.atnc.ioms.model.maintain.satellite.SatelliteQueryModel;

/**
 * KU报表数据DAO实现类
 * 
 * @author 王凌斌
 * @2017年2月23日 下午1:25:50
 */
@Repository
public class KuReportDataDaoImpl extends MyBaseDao<KuReportData> implements
		IKuReportDataDao {

	@Override
	public Pagination queryPage(SatelliteQueryModel queryModel) {
		// hql语句
		StringBuilder hql = new StringBuilder("from KuReportData where 1=1");
		// 查询条件集合
		List<Object> params = new ArrayList<Object>();
		// 站点名称
		if (StringUtils.isNotEmpty(queryModel.getSiteNameLike())) {
			hql.append(" and satelliteSite.siteName like '%"
					+ queryModel.getSiteNameLike() + "%'  escape '\\' ");
		}
		// 时间
		if (StringUtils.isNotEmpty(queryModel.getReportDate())) {
			hql.append("and reportDate like '%" + queryModel.getReportDate()
					+ "%'  escape '\\' ");
		}
		// 记录总数
		String countHql = COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), params.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public Boolean findByDateAndSatellite(String date,
			SatelliteSite satelliteSite) {
		// 根据日期和站点查询符合条件的记录
		@SuppressWarnings("unchecked")
		List<KuReportData> kuReportDatas = (List<KuReportData>) super
				.queryList(
						"from KuReportData where reportDate = ? and satelliteSite = ?",
						new Object[] { date, satelliteSite });
		return CollectionUtils.isEmpty(kuReportDatas) ? Boolean.FALSE
				: Boolean.TRUE;
	}

}
