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
import cn.com.atnc.ioms.dao.business.telegraph.TeleGraphDao;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraph;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphApply;
import cn.com.atnc.ioms.enums.business.baseinfo.ApplyTypeEnum;
import cn.com.atnc.ioms.enums.business.telegraph.ConnectionConditionEnum;
import cn.com.atnc.ioms.enums.business.telegraph.TeleGraphApproveStatEnum;
import cn.com.atnc.ioms.model.business.telegraph.TeleGraphQueryModel;

/**
 * 基础信息DAO实现类
 * 
 * @author WangLingbin
 * @date 2015年6月18日 上午10:01:53
 * @since 1.0.0
 */
@Repository
public class TeleGraphDaoImpl extends MyBaseDao<TeleGraph> implements
		TeleGraphDao {

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
		// 筛选转报地址申请信息,为了区分转报电路
		if (CollectionUtils.isEmpty(queryModel.getTeleGraphApplys())) {
			return new Pagination();
		} else {
			hql.append(" and id in (");
			List<TeleGraphApply> teleGraphApplys = queryModel
					.getTeleGraphApplys();
			for (TeleGraphApply teleGraphApply : teleGraphApplys) {
				hql.append("?,");
				System.err.println(teleGraphApply.getTeleGraph().getId());
				queryParams.add(teleGraphApply.getTeleGraph().getId());
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

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.business.telegraph.TeleGraphDao#getTeleGraphByBaseInfo(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public TeleGraph getTeleGraphByBaseInfo(String id) {
		List<TeleGraph> teleGraphs = (List<TeleGraph>) queryList(
				"from TeleGraph t where t.applyBaseInfo.id = ?", id);
		if (CollectionUtils.isNotEmpty(teleGraphs)) {
			return teleGraphs.get(0);
		} else {
			return null;
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.business.telegraph.TeleGraphDao#getListSendMessage()
	 */
	@Override
	public List<TeleGraph> getListSendMessage() {

		StringBuilder hql = new StringBuilder();
		hql.append("from TeleGraph where 1=1");
		List<Object> params = new ArrayList<Object>();

		hql.append(" and approveStat = ?");
		params.add(TeleGraphApproveStatEnum.atncleader_firstdeal);
		
		hql.append(" and applyBaseInfo.applyType = ?");
		params.add(ApplyTypeEnum.telegraph_circuit);

		hql.append(" and (applyBaseInfo.sendmessageFlag is null or applyBaseInfo.sendmessageFlag = false)");

		return (List<TeleGraph>) super.queryList(hql.toString(),
				params.toArray());
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.business.telegraph.TeleGraphDao#getListSendMessageEng()
	 */
	@Override
	public List<TeleGraph> getListSendMessageEng() {
		StringBuilder hql = new StringBuilder();
		hql.append("from TeleGraph where 1=1");
		List<Object> params = new ArrayList<Object>();

		hql.append(" and approveStat = ?");
		params.add(TeleGraphApproveStatEnum.atnc_test);
		hql.append(" and applyBaseInfo.applyType = ?");
		params.add(ApplyTypeEnum.telegraph);
		
		hql.append(" and (applyBaseInfo.sendmessageFlag is null or applyBaseInfo.sendmessageFlag = false)");

		return (List<TeleGraph>) super.queryList(hql.toString(),
				params.toArray());
	}

	@Override
	public List<TeleGraph> getListSendMessageFirstCommit() {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder();
		hql.append("from TeleGraph where 1=1");
		List<Object> params = new ArrayList<Object>();

		hql.append(" and approveStat = ?");
		params.add(TeleGraphApproveStatEnum.csstaff_audit);
		
		hql.append(" and applyBaseInfo.applyType = ?");
		params.add(ApplyTypeEnum.telegraph);

		hql.append(" and (applyBaseInfo.sendmessageFlag is null or applyBaseInfo.sendmessageFlag = false)");

		return (List<TeleGraph>) super.queryList(hql.toString(),
				params.toArray());
	}
}
