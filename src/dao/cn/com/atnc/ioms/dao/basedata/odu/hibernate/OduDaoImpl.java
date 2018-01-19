package cn.com.atnc.ioms.dao.basedata.odu.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.odu.IOduDao;
import cn.com.atnc.ioms.entity.basedata.odu.Odu;
import cn.com.atnc.ioms.model.basedata.satellite.OduQueryModel;

@Repository("OduDao")
public class OduDaoImpl extends MyBaseDao<Odu> implements IOduDao {

	@Override
	public Pagination queryPage(OduQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from Odu   where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getSiteNameLike())) {
			hql.append(" and upper( site.siteName) like:siteName");
			params.put("siteName", "%"
					+ queryModel.getSiteNameLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getSiteCodeLike())) {
			hql.append(" and upper( site.siteCode) like:siteCode");
			params.put("siteCode", "%"
					+ queryModel.getSiteCodeLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getNetworkType())) {
			hql.append(" and  site.type =:networkType");
			params.put("networkType", queryModel.getNetworkType());
		}
		if (StringUtils.hasText(queryModel.getOduTypeLike())) {
			hql.append(" and upper(oduType) like:oduTypeLike");
			params.put("oduTypeLike", 
					"%" + queryModel.getOduTypeLike().toUpperCase() + "%");
		}
		if (queryModel.getBureau() != null) {
			hql.append(" and site.bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}
		if (StringUtils.hasText(queryModel.getOduType())) {
			hql.append(" and oduType =:oduType");
			params.put("oduType", queryModel.getOduType());
		}
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by site.bureau, site.siteCode asc");
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public Long querySize(OduQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from Odu  where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getSiteNameLike())) {
			hql.append(" and upper( site.siteName) like:siteName");
			params.put("siteName", "%"
					+ queryModel.getSiteNameLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getSiteCodeLike())) {
			hql.append(" and upper( site.siteCode) like:siteCode");
			params.put("siteCode", "%"
					+ queryModel.getSiteCodeLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getNetworkType())) {
			hql.append(" and  site.type =:networkType");
			params.put("networkType", queryModel.getNetworkType());
		}
		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}
		if (StringUtils.hasText(queryModel.getOduTypeLike())) {
			hql.append(" and upper(oduType) like:oduTypeLike");
			params.put("oduTypeLike", 
					"%" + queryModel.getOduTypeLike().toUpperCase() + "%");
		}
		if (queryModel.getBureau() != null) {
			hql.append(" and site.bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}
		if (StringUtils.hasText(queryModel.getOduType())) {
			hql.append(" and oduType =:oduType");
			params.put("oduType", queryModel.getOduType());
		}
		return super.querySize(hql.toString(), params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Odu> queryList(OduQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from Odu where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getSiteNameLike())) {
			hql.append(" and upper( site.siteName) like:siteName");
			params.put("siteName", "%"
					+ queryModel.getSiteNameLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getSiteCodeLike())) {
			hql.append(" and upper( site.siteCode) like:siteCode");
			params.put("siteCode", "%"
					+ queryModel.getSiteCodeLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getNetworkType())) {
			hql.append(" and  site.type =:networkType");
			params.put("networkType", queryModel.getNetworkType());
		}
		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}
		if (StringUtils.hasText(queryModel.getOduTypeLike())) {
			hql.append(" and upper(oduType) like:oduTypeLike");
			params.put("oduTypeLike", 
					"%" + queryModel.getOduTypeLike().toUpperCase() + "%");
		}
		if (queryModel.getBureau() != null) {
			hql.append(" and site.bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}
		if (StringUtils.hasText(queryModel.getOduType())) {
			hql.append(" and oduType =:oduType");
			params.put("oduType", queryModel.getOduType());
		}
		hql.append(" order by site.bureau, site.siteCode asc");
		return (List<Odu>) super.queryList(hql.toString(), params);
	}
	public List<Odu> findODUBySite(OduQueryModel queryModel) {
		//System.out.println(queryModel.getSiteId());
		StringBuilder hql = new StringBuilder("from Odu where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		hql.append(" and site.id =:sid");
		params.put("sid", queryModel.getSiteId());
		return (List<Odu>) super.queryList(hql.toString(), params);
	}
}
