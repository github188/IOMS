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
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.business.telegraph.TeleGraphCircuitDao;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphCircuit;
import cn.com.atnc.ioms.enums.business.formalcircuit.FormalStatEnum;
import cn.com.atnc.ioms.enums.business.telegraph.TeleGraphApproveStatEnum;
import cn.com.atnc.ioms.model.business.telegraph.TeleGraphQueryModel;

/**
 * 民航转报网转报电路申请信息DAO实现类
 * 
 * @author WangLingbin
 * @date 2015年10月19日 上午8:44:40
 * @since 1.0.0
 */
@Repository
public class TeleGraphCircuitDaoImpl extends MyBaseDao<TeleGraphCircuit>
		implements TeleGraphCircuitDao {

	@Override
	public Pagination queryPageByModel(TeleGraphQueryModel queryModel) {
		StringBuilder hql = new StringBuilder();
		hql.append("from TeleGraph where 1=1");
		List<Object> queryParams = new ArrayList<Object>();
		// 申请人员
		if (!ObjectUtils.equals(queryModel.getClient(), null)) {
			hql.append(" and applyBaseInfo.applyUser.id = ?");
			queryParams.add(queryModel.getClient().getId());
		}
		// 上一步移交的操作人员
		if (!StringUtils.isEmpty(queryModel.getNextUser())) {
			hql.append(" and applyBaseInfo.nextUser = ?");
			queryParams.add(queryModel.getNextUser());
		}
		// 筛选转报电路申请信息,为了区分转报地址
		if (CollectionUtils.isEmpty(queryModel.getTeleGraphCircuits())) {
			return new Pagination();
		} else {
			hql.append(" and id in ( ");
			List<TeleGraphCircuit> teleGraphCircuits = queryModel
					.getTeleGraphCircuits();
			for (TeleGraphCircuit teleGraphCircuit : teleGraphCircuits) {
				hql.append("?,");
				System.err.println(teleGraphCircuit.getTeleGraph().getId());
				queryParams.add(teleGraphCircuit.getTeleGraph().getId());
			}
			hql.deleteCharAt(hql.length() - 1);
			hql.append(") ");
		}
		// 上级领导及其下属人员ID查询条件
		if (!CollectionUtils.isEmpty(queryModel.getpIdList())) {
			hql.append(" and applyBaseInfo.applyUser.id in ( ");
			List<String> idList = queryModel.getpIdList();
			for (String id : idList) {
				hql.append("?,");
				queryParams.add(id);
			}
			hql.deleteCharAt(hql.length() - 1);
			hql.append(")");
		}
		// 上上级领导及其下属所有人员ID集合查询条件
		if (!CollectionUtils.isEmpty(queryModel.getPpIdList())) {
			hql.append(" and applyBaseInfo.applyUser.id in ( ");
			List<String> idList = queryModel.getPpIdList();
			for (String id : idList) {
				hql.append("?,");
				queryParams.add(id);
			}
			hql.deleteCharAt(hql.length() - 1);
			hql.append(")");
		}
		// 审批状态查询条件
		if (!CollectionUtils.isEmpty(queryModel.getStatusList())) {
			hql.append(" and approveStat in (");
			List<TeleGraphApproveStatEnum> allStatus = queryModel
					.getStatusList();
			for (TeleGraphApproveStatEnum status : allStatus) {
				hql.append("?,");
				queryParams.add(status);
			}
			hql.deleteCharAt(hql.length() - 1);
			hql.append(")");
		}
		hql.append(" order by applyBaseInfo.applyTime desc ");
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());

	}

	@Override
	public List<TeleGraphCircuit> getCircuitsByParentId(String id) {

		@SuppressWarnings("unchecked")
		List<TeleGraphCircuit> teleGraphCircuits = (List<TeleGraphCircuit>) queryList(
				"from TeleGraphCircuit where teleGraph.id = ?", id);
		return teleGraphCircuits;
	}

	@Override
	public List<TeleGraphCircuit> getListSendMessage() {
		// TODO Auto-generated method stub
		StringBuffer hql = new StringBuffer(" from TeleGraphCircuit where 1=1 ");
		List<Object> params = new ArrayList<Object>();

		hql.append(" and teleGraph.approveStat = ?");
		params.add(FormalStatEnum.atncleader_firstdeal);
		hql.append(" and (teleGraph.applyBaseInfo.sendmessageFlag is null or teleGraph.applyBaseInfo.sendmessageFlag = false)");

		return (List<TeleGraphCircuit>) super.queryList(hql.toString(),
				params.toArray());
	}

}
