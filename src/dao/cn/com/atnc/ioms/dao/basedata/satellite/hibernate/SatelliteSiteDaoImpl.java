/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午8:04:49
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.basedata.satellite.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.satellite.ISatelliteSiteDao;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.model.basedata.satellite.site.SiteQueryModel;

/**
 * @author:HuangYijie
 * @date:2014-3-19 下午8:04:49
 * @version:1.0
 */
@Repository("SatelliteSiteDao")
public class SatelliteSiteDaoImpl extends MyBaseDao<SatelliteSite> implements
		ISatelliteSiteDao {

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao#queryPage(cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SatelliteSite> queryList(SiteQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from SatelliteSite where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getSiteLike())) {
			hql.append(" and (siteName like:siteNameAs or siteCode like:siteCodeAs)");
			params.put("siteNameAs", "%" + queryModel.getSiteLike() + "%");
			params.put("siteCodeAs", "%"
					+ queryModel.getSiteLike().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getNameLike())) {
			hql.append(" and siteName like:siteNameLike");
			params.put("siteNameLike", "%"
					+ queryModel.getNameLike().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getName())) {
			hql.append(" and siteName =:name");
			params.put("name", queryModel.getName());
		}
		if (StringUtils.hasText(queryModel.getCodeLike())) {
			hql.append(" and siteCode like:siteCodeLike");
			params.put("siteCodeLike", "%"
					+ queryModel.getCodeLike().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getCode())) {
			hql.append(" and siteCode =:siteCode");
			params.put("siteCode", queryModel.getCode());
		}
		if (StringUtils.hasText(queryModel.getType())) {
			hql.append(" and type =:type");
			params.put("type", queryModel.getType());
		}
		if (null != queryModel.getBureau()) {
			hql.append(" and bureau = :bureau");
			params.put("bureau", queryModel.getBureau());
		}
		/*
		 * if (StringUtils.hasText(queryModel.getEquipId())) {
		 * hql.append(" and equipId.id =:equipId"); params.put("equipId",
		 * queryModel.getEquipId()); }
		 */
		if (StringUtils.hasText(queryModel.getSiteId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getSiteId());
		}
		hql.append(" order by bureau,siteCode asc");
		return (List<SatelliteSite>) super.queryList(hql.toString(), params);

	}

	@Override
	public Pagination queryPage(SiteQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from SatelliteSite where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getNameLike())) {
			hql.append(" and siteName like:siteNameLike");
			params.put("siteNameLike", "%" + queryModel.getNameLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getCodeLike())) {
			hql.append(" and siteCode like:siteCodeLike");
			params.put("siteCodeLike", "%"
					+ queryModel.getCodeLike().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getType())) {
			hql.append(" and type =:type");
			params.put("type", queryModel.getType());
		}
		if (null != queryModel.getBureau()) {
			hql.append(" and bureau = :bureau");
			params.put("bureau", queryModel.getBureau());
		}

		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by bureau,siteCode asc");

		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public Long querySize(SiteQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from Equip where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getEquipId())) {
			hql.append(" and satellite_id =:equipId");
			params.put("equipId", queryModel.getEquipId());
		}
		if (StringUtils.hasText(queryModel.getType())) {
			hql.append(" and type =:type");
			params.put("type", queryModel.getType());
		}
		if (StringUtils.hasText(queryModel.getCode())) {
			hql.append(" and siteCode =:siteCode");
			params.put("siteCode", queryModel.getCode());
		}
		if (StringUtils.hasText(queryModel.getSiteId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getSiteId());
		}
		return super.querySize(hql.toString(), params);
	}

	@Override
	public Long querySizeCodeCheck(SiteQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from SatelliteSite where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getSiteCode())) {
			hql.append(" and siteCode =:siteCode");
			params.put("siteCode", queryModel.getSiteCode());
		}
		if (StringUtils.hasText(queryModel.getSiteId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getSiteId());
		}
		return super.querySize(hql.toString(), params);
	}
}