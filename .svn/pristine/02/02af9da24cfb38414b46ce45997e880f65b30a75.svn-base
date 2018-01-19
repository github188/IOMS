/**
 * @ProjectName PCSP
 * @FileName TeleGraphDaoImpl.java
 * @PackageName:cn.com.atnc.pcsp.dao.business.telegraph.impl
 * @author WangLingbin
 * @date 2015年6月18日上午10:01:53
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.business.telegraph.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.business.telegraph.TeleGraphApplyDao;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphApply;
import cn.com.atnc.ioms.enums.business.telegraph.TeleGraphApproveStatEnum;
import cn.com.atnc.ioms.model.business.telegraph.TeleGraphQueryModel;

/**
 * 申请信息DAO实现类
 * @author WangLingbin
 * @date 2015年6月18日 上午10:01:53
 * @since 1.0.0
 */
@Repository
public class TeleGraphAppLyDaoImpl extends MyBaseDao<TeleGraphApply> implements
		TeleGraphApplyDao {

	@Override
	public Pagination queryPageByModel(TeleGraphQueryModel queryModel) {
		StringBuilder hql = new StringBuilder();
		hql.append("from TeleGraphApply t where 1=1");
		List<Object> queryParams = new ArrayList<Object>();
		// 申请人员
		if (!ObjectUtils.equals(queryModel.getClient(),null)) {
			hql.append(" and t.teleGraph.applyBaseInfo.applyUser.id = ?");
			queryParams.add(queryModel.getClient().getId());
		}
		//上级领导及其下属人员ID查询条件
		if (!CollectionUtils.isEmpty(queryModel.getpIdList())) {
			hql.append(" and t.teleGraph.applyBaseInfo.applyUser.id in ( ");
			List<String> idList = queryModel.getpIdList();
			for (String id : idList) {
				hql.append("?,");
				queryParams.add(id);
			}
			hql.deleteCharAt(hql.length()-1);
			hql.append(")");
		}
		//上上级领导及其下属所有人员ID集合查询条件
		if (!CollectionUtils.isEmpty(queryModel.getPpIdList())) {
			hql.append(" and t.teleGraph.applyBaseInfo.applyUser.id in ( ");
			List<String> idList = queryModel.getPpIdList();
			for (String id : idList) {
				hql.append("?,");
				queryParams.add(id);
			}
			hql.deleteCharAt(hql.length()-1);
			hql.append(")");
		}
		//审批状态查询条件
		if(!CollectionUtils.isEmpty(queryModel.getStatusList())){
			hql.append(" and t.teleGraph.approveStat in (");
			List<TeleGraphApproveStatEnum> allStatus = queryModel.getStatusList();
			for (TeleGraphApproveStatEnum status : allStatus) {
				hql.append("?,");
				queryParams.add(status);
			}
			hql.deleteCharAt(hql.length()-1);
			hql.append(")");
		}
		hql.append(" order by applyBaseInfo.applyTime desc ");
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), queryParams.toArray(),countHql,  
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public List<TeleGraphApply> getApplysByParentId(String id) {
		
		@SuppressWarnings("unchecked")
		List<TeleGraphApply> teleGraphApplys = (List<TeleGraphApply>) queryList("from TeleGraphApply where teleGraph.id = ?", id);
		return teleGraphApplys;
	}


}
