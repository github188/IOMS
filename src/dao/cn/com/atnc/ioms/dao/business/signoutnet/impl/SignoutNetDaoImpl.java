/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName KuSatelliteDaoImpl.java
 * @PackageName:cn.com.atnc.pcsp.dao.business.satellite.hibernate
 * @author ku
 * @date 2015年5月13日下午3:52:29
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.business.signoutnet.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.business.signoutnet.ISignoutNetDao;
import cn.com.atnc.ioms.entity.business.signoutnet.SignoutNet;
import cn.com.atnc.ioms.enums.business.satellite.ApproveStatEnum;
import cn.com.atnc.ioms.model.business.signoutnet.SignoutNetQueryModel;

/**
 * 通信网退网接口dao实现类
 *
 * @author 段衍林
 * @2017年1月10日 上午11:29:15
 */
@Repository
public class SignoutNetDaoImpl extends MyBaseDao<SignoutNet> implements
		ISignoutNetDao {

	@Override
	public Pagination queryPageByModel(SignoutNetQueryModel queryModel) {
		StringBuilder hql = new StringBuilder();
		hql.append("from SignoutNet where 1=1");
		List<Object> queryParams = new ArrayList<Object>();
		// 申请人员
		if (!ObjectUtils.equals(queryModel.getClient(),null)) {
			hql.append(" and applyBaseInfo.applyUser.id = ?");
			queryParams.add(queryModel.getClient().getId());
		}
		// 上一步移交的操作人员
		if (!StringUtils.isEmpty(queryModel.getNextUser())) {
			hql.append(" and applyBaseInfo.nextUser = ?");
			queryParams.add(queryModel.getNextUser());
		}
		//上级领导及其下属人员ID查询条件
		if (!CollectionUtils.isEmpty(queryModel.getpIdList())) {
			hql.append(" and applyBaseInfo.applyUser.id in ( ");
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
			hql.append(" and applyBaseInfo.applyUser.id in ( ");
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
			hql.append(" and approveStat in (");
			List<ApproveStatEnum> allStatus = queryModel.getStatusList();
			for (ApproveStatEnum status : allStatus) {
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
}
