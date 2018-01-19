package cn.com.atnc.ioms.dao.basedata.atm.service.hibernate;

/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午8:04:49
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.atm.service.IAtmServiceDao;
import cn.com.atnc.ioms.entity.basedata.atm.service.AtmService;
import cn.com.atnc.ioms.model.basedata.atm.service.AtmServiceQueryModel;

/**
 * 
 * @author:xiongzhikang
 * @date:2014-4-22 上午10:05:02
 * @version:1.0
 */
@Repository("atmServiceDao")
public class AtmServiceDaoImpl extends MyBaseDao<AtmService> implements
		IAtmServiceDao {

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao#queryPage(cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel)
	 */
	@Override
	public Pagination queryPage(AtmServiceQueryModel queryModel) {
		StringBuilder hql = new StringBuilder(
				"from AtmServiceRunInfo where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		System.out.println(queryModel.getTypeId());
		if (StringUtils.hasText(queryModel.getServiceName())) {
			hql.append(" and service.serviceName =:serviceName");
			params.put("serviceName", queryModel.getServiceName());
		}
		if (StringUtils.hasText(queryModel.getServiceNameLike())) {
			hql.append(" and service.serviceName like:serviceNameLike");
			params.put("serviceNameLike", "%" + queryModel.getServiceNameLike()
					+ "%");
		}
		if (StringUtils.hasText(queryModel.getLocalNode())) {
			hql.append(" and service.localNodeNameCn =:localAtmNodeCn");
			params.put("localAtmNodeCn", queryModel.getLocalNode());
		}
		if (StringUtils.hasText(queryModel.getLocalNodeLike())) {
			hql.append(" and service.localNode.atmNodeCode like:localAtmNodeLike");
			params.put("localAtmNodeLike", "%"
					+ queryModel.getLocalNodeLike().trim().toUpperCase() + "%");
		}

		if (StringUtils.hasText(queryModel.getRemoteNode())) {
			hql.append(" and service.remoteNodeNameCn =:remoteAtmNodeCn");
			params.put("remoteAtmNodeCn", queryModel.getRemoteNode());
		}
		if (StringUtils.hasText(queryModel.getRemoteNodeLike())) {
			hql.append(" and service.remoteNode.atmNodeCode like:remoteAtmNodeLike");
			params.put("remoteAtmNodeLike", "%"
					+ queryModel.getRemoteNodeLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getAtmType().getServiceType())) {
			hql.append(" and service.atmType.id =:atmType");
			params.put("atmType", queryModel.getTypeId());

		}
		if (null != queryModel.getServiceChangeType()) {
			hql.append(" and service.serviceChangeType =:serviceChangeType");
			params.put("serviceChangeType", queryModel.getServiceChangeType());
		}
		if (null != queryModel.getIsAlarm()) {
			hql.append(" and isAlarm =:isAlarm");
			params.put("isAlarm", queryModel.getIsAlarm());
		}

		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by service.serviceChangeType asc,isAlarm desc,service.localNode.atmNodeCode asc,cast(service.localCardSlot as float) asc,cast(service.localPortSlot as float) asc,cast(service.localPortDLCIVPIVCI as float) asc,cast(service.remoteCardSlot as float) asc,cast(service.remotePortSlot as float) asc,cast(service.remotePortDLCIVPIVCI as float) asc,id asc");
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public Long querySize(AtmServiceQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from AtmService where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getServiceName())) {
			hql.append(" and serviceName =:serviceName");
			params.put("serviceName", queryModel.getServiceName());
		}
		if (StringUtils.hasText(queryModel.getServiceNameLike())) {
			hql.append(" and serviceName like:serviceNameLike");
			params.put("serviceNameLike", "%" + queryModel.getServiceNameLike()
					+ "%");
		}
		if (StringUtils.hasText(queryModel.getLocalNode())) {
			hql.append(" and localNodeNameCn =:localAtmNodeCn");
			params.put("localAtmNodeCn", queryModel.getLocalNode());
		}
		if (StringUtils.hasText(queryModel.getLocalNodeLike())) {
			hql.append(" and localNodeNameCn like:localAtmNodeCnLike");
			params.put("localAtmNodeCnLike",
					"%" + queryModel.getLocalNodeLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getRemoteNode())) {
			hql.append(" and remoteNodeNameCn =:remoteAtmNodeCn");
			params.put("remoteAtmNodeCn", queryModel.getRemoteNode());
		}
		if (StringUtils.hasText(queryModel.getRemoteNodeLike())) {
			hql.append(" and remoteNodeNameCn like:remoteAtmNodeCnLike");
			params.put("remoteAtmNodeCnLike",
					"%" + queryModel.getRemoteNodeLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}
		if (StringUtils.hasText(queryModel.getLocalNodeId())) {
			hql.append(" or localNode.id =:localNodeId");
			params.put("localNodeId", queryModel.getLocalNodeId());
		}
		if (StringUtils.hasText(queryModel.getRemoteNodeId())) {
			hql.append(" or remoteNode.id =:remoteNodeId");
			params.put("remoteNodeId", queryModel.getRemoteNodeId());
		}

		return super.querySize(hql.toString(), params);
	}

	@Override
	public Long queryDeleteNodeSize(AtmServiceQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from AtmService where 1=0");
		Map<String, Object> params = new HashMap<String, Object>();
		String local = queryModel.getLocalNodeId();
		String remote = queryModel.getRemoteNodeId();
		if (StringUtils.hasText(local)) {
			hql.append(" or localNode.id =:localNodeId");
			params.put("localNodeId", local);
		}
		if (StringUtils.hasText(remote)) {
			hql.append(" or remoteNode.id =:remoteNodeId");
			params.put("remoteNodeId", remote);
		}

		return super.querySize(hql.toString(), params);
	}

	/*
	 * @Override public List<AtmServiceRunInfo> find(AtmServiceQueryModel
	 * queryModel) {
	 * 
	 * StringBuilder hql = new
	 * StringBuilder("from AtmServiceRunInfo where 1=1"); Map<String, Object>
	 * params = new HashMap<String, Object>(); if
	 * (StringUtils.hasText(queryModel.getId())) {
	 * hql.append(" and serivce.id =:id"); params.put("id", queryModel.getId());
	 * } //System.out.println("hql:"+hql.toString()); return
	 * (List<AtmServiceRunInfo>) super.queryList(hql.toString(), params); }
	 */

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao#queryList(cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AtmService> queryList(AtmServiceQueryModel queryModel) {

		StringBuilder hql = new StringBuilder("from AtmService where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getServiceName())) {
			hql.append(" and serviceName =:serviceName");
			params.put("serviceName", queryModel.getServiceName());
		}
		if (StringUtils.hasText(queryModel.getServiceNameLike())) {
			hql.append(" and serviceName like:serviceNameLike");
			params.put("serviceNameLike", "%" + queryModel.getServiceNameLike()
					+ "%");
		}
		if (StringUtils.hasText(queryModel.getLocalNode())) {
			hql.append(" and localNodeNameCn =:localAtmNodeCn");
			params.put("localAtmNodeCn", queryModel.getLocalNode());
		}
		if (StringUtils.hasText(queryModel.getLocalNodeLike())) {
			hql.append(" and localNodeNameCn like:localAtmNodeCnLike");
			params.put("localAtmNodeCnLike",
					"%" + queryModel.getLocalNodeLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getRemoteNode())) {
			hql.append(" and remoteNodeNameCn =:remoteAtmNodeCn");
			params.put("remoteAtmNodeCn", queryModel.getRemoteNode());
		}
		if (StringUtils.hasText(queryModel.getRemoteNodeLike())) {
			hql.append(" and remoteNodeNameCn like:remoteAtmNodeCnLike");
			params.put("remoteAtmNodeCnLike",
					"%" + queryModel.getRemoteNodeLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getTypeId())) {
			hql.append(" and atmType.id =:typeid");
			params.put("typeid", queryModel.getTypeId());
		}
		if (StringUtils.hasText(queryModel.getLocalNodeId())) {
			hql.append(" or localNode.id =:localNodeId");
			params.put("localNodeId", queryModel.getLocalNodeId());
		}
		if (StringUtils.hasText(queryModel.getRemoteNodeId())) {
			hql.append(" or remoteNode.id =:remoteNodeId");
			params.put("remoteNodeId", queryModel.getRemoteNodeId());
		}				
		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}
		hql.append(" order by id asc");
		logger.info("hql" + hql.toString());
		return (List<AtmService>) super.queryList(hql.toString(), params);
	}

	@Override
	public Pagination queryServiceDetailPageByModel(
			AtmServiceQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from AtmServiceRunInfo where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		// 管局查询条件
		if (!StringUtils.hasText(queryModel.getId())) {
			hql.append("and service.id = ? ");
			queryParams.add(queryModel.getId());
		}
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}
}
