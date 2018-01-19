/**
 * @ProjectName IOMS
 * @FileName TeleGraphSystemDaoImpl.java
 * @PackageName:cn.com.atnc.ioms.dao.duty.telegraphduty.impl
 * @author WangLingbin
 * @date 2016年1月8日上午10:52:07
 * @since 1.0.0
 * @Copyright (c) 2016,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.duty.telegraphduty.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.telegraphduty.TeleGraphSystemDao;
import cn.com.atnc.ioms.entity.duty.telegraphduty.TeleGraphSystem;
import cn.com.atnc.ioms.model.duty.telegraphduty.TeleGraphSystemQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;

/**
 * 转报系统检查DAO实现类
 * @author WangLingbin
 * @date 2016年1月8日 上午10:52:07
 * @since 1.0.0
 */
@Repository("teleGraphSystemDao")
public class TeleGraphSystemDaoImpl extends MyBaseDao<TeleGraphSystem> implements
		TeleGraphSystemDao {

	@Override
	public Pagination queryPageByModel(TeleGraphSystemQueryModel queryModel) {
		//查询语句
		StringBuilder hql = new StringBuilder("from TeleGraphSystem t where 1=1");
		//查询参数值
		List<Object> queryParams = new ArrayList<Object>();
		//创建人
		if(StringUtils.isNotEmpty(queryModel.getCreater())) {
			hql.append(" and t.creater.name like ? escape '\\' ");
			queryParams.add(queryModel.getCreater());
		}
		//审核人
		if(StringUtils.isNotEmpty(queryModel.getAuditer())) {
			hql.append(" and t.auditer.name like ? escape '\\' ");
			queryParams.add(queryModel.getAuditer());
		}
		//记录查询条件-填写时间起
		if(!ObjectUtils.equals(queryModel.getFromCreateTime(), null)){
			hql.append(" and t.createTime >= ? ");
			queryParams.add(queryModel.getFromCreateTime());
		}
		//记录查询条件-填写时间至
		if(!ObjectUtils.equals(queryModel.getToCreateTime(), null)){
			hql.append(" and t.createTime <= ? ");
			queryParams.add(queryModel.getToCreateTime());
		}
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), queryParams.toArray(),countHql,  
				queryModel.getPageNo(), queryModel.getPageSize());
	}

}
