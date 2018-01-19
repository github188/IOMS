/**
 * @ProjectName IOMS
 * @FileName Wafr08Port0StatDaoImpl.java
 * @PackageName:cn.com.atnc.ioms.dao.operstat.wafr08.hibernate
 * @author KuYonggang
 * @date 2015年4月1日下午2:18:58
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.pollinginfo.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.maintain.pollinginfo.IWafr08Port0StatDao;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.Wafr08Port0Stat;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;

/**
 * wafr08端口统计DAO实现
 *
 * @author KuYonggang
 * @date 2015年4月1日 下午2:18:58
 * @since 1.0.0
 */
@Repository
public class Wafr08Port0StatDaoImpl extends MyBaseDao<Wafr08Port0Stat>
		implements IWafr08Port0StatDao {

	@Override
	public Pagination queryPage(PollingInfoQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from Wafr08Port0Stat where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (queryModel.getBureau() != null) {
			hql.append(" and equipId.satelliteSite.bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}
		if (StringUtils.isEmpty(queryModel.getStname()) == false) {
			hql.append(" and equipId.satelliteSite.siteName like:stname  escape '\\' ");
			params.put("stname", "%" + queryModel.getStname() + "%");
		}
		if (queryModel.getStartRecordTime() != null) {
			hql.append(" and recordTime>=:startRecordTime");
			params.put("startRecordTime", queryModel.getStartRecordTime());
		}
		if (queryModel.getStartRecordTime() != null) {
			hql.append(" and recordTime<=:endRecordTime");
			params.put("endRecordTime", queryModel.getEndRecordTime());
		}
		hql.append(" order by recordTime desc");
		String countHql = COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Wafr08Port0Stat findByEquipAndDate(MaintainEquip maintainEquip,
			Date currentDate) {
		// Hql语句
		StringBuilder hql = new StringBuilder("from Wafr08Port0Stat where 1=1");
		// 查询参数
		List<Object> params = new ArrayList<Object>();
		// 维保设备
		hql.append(" and equipId = ?");
		params.add(maintainEquip);
		// 记录时间
		hql.append(" and recordTime between ? and ?");
		params.add(currentDate);
		params.add(DateUtils.addDays(currentDate, 1));
		// 按照记录时间倒叙排列
		hql.append(" order by recordTime desc");
		List<Wafr08Port0Stat> wafr08Port0Stats = (List<Wafr08Port0Stat>) super
				.queryList(hql.toString(), params.toArray());
		return CollectionUtils.isEmpty(wafr08Port0Stats) ? null
				: wafr08Port0Stats.get(0);
	}

}
