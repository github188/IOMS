/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午8:04:49
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.basedata.ku.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao;
import cn.com.atnc.ioms.entity.basedata.ku.KuNode;
import cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel;

/**
 * @author:HuangYijie
 * @date:2014-3-19 下午8:04:49
 * @version:1.0
 */
@Repository("kuNodeDao")
public class KuNodeDaoImpl extends MyBaseDao<KuNode> implements IKuNodeDao {

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao#queryPage(cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel)
	 */
	@Override
	public Pagination queryPage(KuNodeQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from KuNode where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();

		if (StringUtils.hasText(queryModel.getKuNodeCode())) {
			hql.append(" and kuNodeCode =:kuNodeCode");
			params.put("kuNodeCode", queryModel.getKuNodeCode());
		}
		if (StringUtils.hasText(queryModel.getKuNodeCodeLike())) {
			hql.append(" and kuNodeCode like:kuNodeCodeLike");
			params.put("kuNodeCodeLike", "%"
					+ queryModel.getKuNodeCodeLike().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getKuNodeName())) {
			hql.append(" and kuNodeName =:kuNodeName");
			params.put("kuNodeName", queryModel.getKuNodeName());
		}
		if (StringUtils.hasText(queryModel.getKuNodeNameLike())) {
			hql.append(" and kuNodeName like:kuNodeNameLike");
			params.put("kuNodeNameLike", "%" + queryModel.getKuNodeNameLike()
					+ "%");
		}
		if(!ObjectUtils.equals(queryModel.getSubnetType(), null)){
			hql.append(" and subnetType =:subnetType");
			params.put("subnetType", queryModel.getSubnetType());
		}
		if (StringUtils.hasText(queryModel.getKuNodeNo())) {
			hql.append(" and kuNodeNo =:kuNodeNo");
			params.put("kuNodeNo", queryModel.getKuNodeNo());
		}
		if (StringUtils.hasText(queryModel.getKuNodeNoLike())) {
			hql.append(" and kuNodeNo like:kuNodeNoLike");
			params.put("kuNodeNoLike", "%" + queryModel.getKuNodeNoLike() + "%");
		}
		if (queryModel.getEquipType() != null) {
			hql.append(" and type =:type");
			params.put("type", queryModel.getEquipType());
		}
		if (StringUtils.hasText(queryModel.getSiteNameLike())) {
			hql.append(" and upper( equip.satellite.siteName) like:siteName");
			params.put("siteName", "%"
					+ queryModel.getSiteNameLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getSiteCodeLike())) {
			hql.append(" and upper( equip.satellite.siteCode) like:siteCode");
			params.put("siteCode", "%"
					+ queryModel.getSiteCodeLike().trim().toUpperCase() + "%");
		}
		if (queryModel.getBureau() != null) {
			hql.append(" and equip.satellite.bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by subnetType, cast(kuNodeNo as integer) asc");
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	public Long querySize(KuNodeQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from KuNode where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:excludeId");
			params.put("excludeId", queryModel.getExcludeId());
		}
		if (StringUtils.hasText(queryModel.getKuNodeCode())) {
			hql.append(" and kuNodeCode =:kuNodeCode");
			params.put("kuNodeCode", queryModel.getKuNodeCode());
		}
		if (StringUtils.hasText(queryModel.getKuNodeCodeLike())) {
			hql.append(" and kuNodeCode like:kuNodeCodeLike");
			params.put("kuNodeCodeLike", "%"
					+ queryModel.getKuNodeCodeLike().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getKuNodeName())) {
			hql.append(" and kuNodeName =:kuNodeName");
			params.put("kuNodeName", queryModel.getKuNodeName());
		}
		if (StringUtils.hasText(queryModel.getKuNodeNameLike())) {
			hql.append(" and kuNodeName like:kuNodeNameLike");
			params.put("kuNodeNameLike", "%" + queryModel.getKuNodeNameLike()
					+ "%");
		}
		if (!ObjectUtils.equals(queryModel.getSubnetType(),null)) {
			hql.append(" and subnetType =:subnetType");
			params.put("subnetType", queryModel.getSubnetType());
		}
		System.err.println(queryModel.getSubnetType());
		if (StringUtils.hasText(queryModel.getKuNodeNo())) {
			hql.append(" and kuNodeNo =:kuNodeNo");
			params.put("kuNodeNo", queryModel.getKuNodeNo());
		}
		if (StringUtils.hasText(queryModel.getKuNodeNoLike())) {
			hql.append(" and kuNodeNo like:kuNodeNoLike");
			params.put("kuNodeNoLike", "%" + queryModel.getKuNodeNoLike() + "%");
		}
		if (queryModel.getEquipType() != null) {
			hql.append(" and type =:type");
			params.put("type", queryModel.getEquipType());
		}
		if (StringUtils.hasText(queryModel.getSiteNameLike())) {
			hql.append(" and upper( equip.satellite.siteName) like:siteName");
			params.put("siteName", "%"
					+ queryModel.getSiteNameLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getSiteCodeLike())) {
			hql.append(" and upper( equip.satellite.siteCode) like:siteCode");
			params.put("siteCode", "%"
					+ queryModel.getSiteCodeLike().trim().toUpperCase() + "%");
		}
		if (queryModel.getBureau() != null) {
			hql.append(" and equip.satellite.bureau =:bureau");
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
	public List<KuNode> queryList(KuNodeQueryModel queryModel) {

		StringBuilder hql = new StringBuilder("from KuNode where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();

		if (StringUtils.hasText(queryModel.getKuNodeCode())) {
			hql.append(" and kuNodeCode =:kuNodeCode");
			params.put("kuNodeCode", queryModel.getKuNodeCode());
		}
		if (StringUtils.hasText(queryModel.getKuNodeCodeLike())) {
			hql.append(" and kuNodeCode like:kuNodeCodeLike");
			params.put("kuNodeCodeLike", "%"
					+ queryModel.getKuNodeCodeLike().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getKuNodeName())) {
			hql.append(" and kuNodeName =:kuNodeName");
			params.put("kuNodeName", queryModel.getKuNodeName());
		}
		if (StringUtils.hasText(queryModel.getKuNodeNameLike())) {
			hql.append(" and kuNodeName like:kuNodeNameLike");
			params.put("kuNodeNameLike", "%" + queryModel.getKuNodeNameLike()
					+ "%");
		}
		if (StringUtils.hasText(queryModel.getKuNodeNo())) {
			hql.append(" and kuNodeNo =:kuNodeNo");
			params.put("kuNodeNo", queryModel.getKuNodeNo());
		}
		if (StringUtils.hasText(queryModel.getKuNodeNoLike())) {
			hql.append(" and kuNodeNo like:kuNodeNoLike");
			params.put("kuNodeNoLike", "%" + queryModel.getKuNodeNoLike() + "%");
		}
		if (queryModel.getEquipType() != null) {
			hql.append(" and type =:type");
			params.put("type", queryModel.getEquipType());
		}
		if (!ObjectUtils.equals(queryModel.getSubnetType(),null)) {
			hql.append(" and subnetType =:subnetType");
			params.put("subnetType", queryModel.getSubnetType());
		}
		if (StringUtils.hasText(queryModel.getSiteNameLike())) {
			hql.append(" and upper( equip.satellite.siteName) like:siteName");
			params.put("siteName", "%"
					+ queryModel.getSiteNameLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getSiteCodeLike())) {
			hql.append(" and upper( equip.satellite.siteCode) like:siteCode");
			params.put("siteCode", "%"
					+ queryModel.getSiteCodeLike().trim().toUpperCase() + "%");
		}
		if (queryModel.getBureau() != null) {
			hql.append(" and equip.satellite.bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}
		hql.append(" order by cast(kuNodeNo as integer) asc");
		return (List<KuNode>) super.queryList(hql.toString(), params);

	}
}
