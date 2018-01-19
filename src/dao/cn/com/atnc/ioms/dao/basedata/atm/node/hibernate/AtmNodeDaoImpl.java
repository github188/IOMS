package cn.com.atnc.ioms.dao.basedata.atm.node.hibernate;

/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午8:04:49
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.atm.node.IAtmNodeDao;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.model.basedata.atm.node.AtmNodeQueryModel;

/**
 * @author:xiongzhikang
 * @date:2014-4-11 下午8:04:49
 * @version:1.0
 */
@Repository("atmNodeDao")
public class AtmNodeDaoImpl extends MyBaseDao<AtmNode> implements IAtmNodeDao {

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao#queryPage(cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel)
	 */
	@Override
	public Pagination queryPage(AtmNodeQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from AtmNode where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getAtmNodeCodeLike())) {//名称
			hql.append(" and atmNodeCode like:atmNodeCode");
			params.put("atmNodeCode", "%"
					+ queryModel.getAtmNodeCodeLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getAtmNodeNameCnLike())) {//节点地点
			hql.append(" and atmNodeNameCn like:atmNodeNameCn");
			params.put("atmNodeNameCn", "%" + queryModel.getAtmNodeNameCnLike() + "%");
		}
		
		if (StringUtils.hasText(queryModel.getAtmNodeSeqLike())) {//序号
			hql.append(" and atmNodeSeq like:atmNodeSeq");
			params.put("atmNodeSeq", "%" + queryModel.getAtmNodeSeqLike() + "%");
		}
		if (queryModel.getBureau() != null) {//区域
			hql.append(" and bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by bureau,cast(atmNodeSeq as integer) asc");
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}
 
	public Long querySize(AtmNodeQueryModel queryModel) throws UnsupportedEncodingException {
		StringBuilder hql = new StringBuilder("from AtmNode where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getAtmNodeCode())) {//名称
			hql.append(" and atmNodeCode=:atmNodeCode");
			params.put("atmNodeCode", 
					 queryModel.getAtmNodeCode());
		}
		if (StringUtils.hasText(queryModel.getAtmNodeIp())) {//ATM0地址
			hql.append(" and atmNodeIp=:atmNodeIp");
			params.put("atmNodeIp", 
					 queryModel.getAtmNodeIp());
		}
		if (StringUtils.hasText(queryModel.getAtmNodeNameCn())) {//节点地点
			hql.append(" and atmNodeNameCn=:atmNodeNameCn");
			params.put("atmNodeNameCn", new String(queryModel.getAtmNodeNameCn().getBytes("ISO-8859-1"),"UTF-8"));
		}
		
		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}
		
		/*if (StringUtils.hasText(queryModel.getExcludeAtmNodeCode())) {
			hql.append(" and atmNodeCode <>:atmNodeCode");
			params.put("atmNodeCode", queryModel.getExcludeAtmNodeCode());
		}
		
		if (StringUtils.hasText(queryModel.getExcludeAtmNodeIp())) {
			hql.append(" and atmNodeIp <>:atmNodeIp");
			params.put("atmNodeIp", queryModel.getExcludeAtmNodeIp());
		}
		
		if (StringUtils.hasText(queryModel.getExcludeAtmNodeNameCn())) {
			hql.append(" and atmNodeNameCn <>:atmNodeNameCn");
			params.put("atmNodeNameCn", queryModel.getExcludeAtmNodeNameCn());
		}*/
		
		if (StringUtils.hasText(queryModel.getAtmNodeSeq())) {//序号
			hql.append(" and tmNodeSeqa=:atmNodeSeq");
			params.put("atmNodeSeq", queryModel.getAtmNodeSeq());
		}
		if (queryModel.getBureau() != null) {//区域
			hql.append(" and bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}
		return super.querySize(hql.toString(), params);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao#queryList(cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AtmNode> queryList(AtmNodeQueryModel queryModel) {

		StringBuilder hql = new StringBuilder("from AtmNode where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getAtmNodeCodeLike())) {//名称
			hql.append(" and atmNodeCode like:atmNodeCode");
			params.put("atmNodeCode", "%"
					+ queryModel.getAtmNodeCodeLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getAtmNodeNameCnLike())) {//节点地点
			hql.append(" and atmNodeNameCn like:atmNodeNameCn");
			params.put("atmNodeNameCn", "%" + queryModel.getAtmNodeNameCnLike() + "%");
		}
		
		if (StringUtils.hasText(queryModel.getAtmNodeSeqLike())) {//序号
			hql.append(" and atmNodeSeq like:atmNodeSeq");
			params.put("atmNodeSeq", "%" + queryModel.getAtmNodeSeqLike() + "%");
		}
		if (queryModel.getBureau() != null) {//区域
			hql.append(" and bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}
		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}
		if (StringTools.hasText(queryModel.getEquipId())) {
			hql.append(" and equip.id =:equipId");
			params.put("equipId", queryModel.getEquipId());
		}
		hql.append(" order by  id asc");
		return (List<AtmNode>) super.queryList(hql.toString(), params);
	}

	/**
	 * @see cn.com.atnc.ioms.dao.basedata.atm.node.IAtmNodeDao#getAtmNodeByNodeCode(java.lang.String)
	 * AtmNodeDaoImpl.java
	 */
	@Override
	public AtmNode getAtmNodeByNodeCode(String nodeCode) {
		if(!StringUtils.hasText(nodeCode)){
			return null;
		}
		return this.findByProperty("atmNodeCode", nodeCode);
	}
}
