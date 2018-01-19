/**
 * @Title:AtmdayCheckDaoImpl.java
 * @author shijiyong
 * @data 2016年9月26日上午11:06:08
 * @version v1.0
 */
package cn.com.atnc.ioms.dao.duty.atm.day.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.atm.day.AtmDayMgxDao;
import cn.com.atnc.ioms.entity.duty.atm.ATMDayMgx;
import cn.com.atnc.ioms.model.duty.atm.AtmDayQueryModelMgx;
import cn.com.atnc.sample.dao.MyBaseDao;

/**
 * ATM日检路由器DAO实现类
 * 
 * @author 王凌斌
 * @2017年2月9日 下午2:08:15
 */
@Repository("atmDayMgxDao")
public class AtmDayMgxDaoImpl extends MyBaseDao<ATMDayMgx> implements
		AtmDayMgxDao {

	@Override
	public Pagination queryPageByModel(AtmDayQueryModelMgx queryModelMgx) {
		// 查询语句
		StringBuilder hql = new StringBuilder("from ATMDayMgx a where 1=1");
		// 定义一个集合，存储参数信息
		List<Object> queryParams = new ArrayList<Object>();
		// 区域：北京网控中心/民航局空管局
		if (!ObjectUtils.equals(queryModelMgx.getTabType(), null)) {
			hql.append(" and a.area = ?");
			queryParams.add(queryModelMgx.getTabType());
		}
		// 操作人
		if (StringUtils.isNotEmpty(queryModelMgx.getOperator())) {
			hql.append(" and a.creater.name like ? escape '\\' ");
			queryParams.add("%" + queryModelMgx.getOperator() + "%");
		}
		// 审核人
		if(StringUtils.isNotEmpty(queryModelMgx.getAuditor())) {
			hql.append(" and a.auditer.name like ? escape '\\' ");
			queryParams.add("%" + queryModelMgx.getAuditor() + "%");
		}
		// 起始时间
		if (!ObjectUtils.equals(queryModelMgx.getStartTime(), null)) {
			hql.append(" and a.recordTime >= ? ");
			queryParams.add(queryModelMgx.getStartTime());
		}
		// 结束时间
		if (!ObjectUtils.equals(queryModelMgx.getEndTime(), null)) {
			hql.append(" and a.recordTime <= ? ");
			queryParams.add(queryModelMgx.getEndTime());
		}
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModelMgx.getPageNo(), queryModelMgx.getPageSize());
	}

}
