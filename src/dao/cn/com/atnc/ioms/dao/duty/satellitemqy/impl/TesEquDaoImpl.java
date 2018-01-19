package cn.com.atnc.ioms.dao.duty.satellitemqy.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satellitemqy.TesEquDao;
import cn.com.atnc.ioms.entity.duty.satellite.TesEqu;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;

/**
 * 
 * @author shijiyong
 * @date 2016年10月31日 上午10:37:09
 * @version 1.0, 2016年10月18日 上午10:37:09
 */
@Repository("TesEquDao")
public class TesEquDaoImpl extends MyBaseDao<TesEqu> implements TesEquDao {
	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {

		StringBuilder hql = new StringBuilder(
				"from TesEqu a where 1=1 ");

		List<Object> params = new ArrayList<Object>();

		// id
		if (StringUtils.isNotEmpty(queryModel.getId())) {
			hql.append(" and a.id = ? ");
			params.add(queryModel.getId());
		}
		// tab页
		if (StringUtils.isNotEmpty(queryModel.getOptType())) {
			hql.append(" and a.optType = ? ");
			params.add(queryModel.getOptType());
		}
		// 巡檢類型
		if (!ObjectUtils.equals(queryModel.getCheckType(), null)) {
			hql.append(" and a.checkType = ? ");
			params.add(queryModel.getCheckType());
		}
		// 起始时间
		if (!ObjectUtils.equals(queryModel.getStartTime(), null)) {
			hql.append(" and a.checkTime >= ? ");
			params.add(queryModel.getStartTime());
		}
		// 结束时间
		if (!ObjectUtils.equals(queryModel.getEndTime(), null)) {
			hql.append(" and a.checkTime <= ? ");
			params.add(queryModel.getEndTime());
		}
		// 按时间倒序排序
		hql.append(" order by a.checkTime desc ");
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();

		return super.pageQuery(hql.toString(), params.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}
}
