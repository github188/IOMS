package cn.com.atnc.ioms.dao.basedata.antenna.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.antenna.IAntennaDao;
import cn.com.atnc.ioms.entity.basedata.antenna.Antenna;
import cn.com.atnc.ioms.model.basedata.satellite.AntennaQueryModel;

@Repository("AntennaDao")
public class AntennaDaoImpl extends MyBaseDao<Antenna> implements IAntennaDao {

	@Override
	public Pagination queryPage(AntennaQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from Antenna   where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();

		if (StringUtils.hasText(queryModel.getSiteNameLike())) {
			hql.append(" and upper(site.siteName) like:siteName");
			params.put("siteName", "%"
					+ queryModel.getSiteNameLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getSiteCodeLike())) {
			hql.append(" and upper(site.siteCode) like:siteCode");
			params.put("siteCode", "%"
					+ queryModel.getSiteCodeLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getNetworkType())) {
			hql.append(" and site.type =:networkType");
			params.put("networkType", queryModel.getNetworkType());
		}
		if (queryModel.getBureau() != null) {
			hql.append(" and site.bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}

		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by site.bureau, site.siteCode asc");
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public Long querySize(AntennaQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from Antenna  where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();

		if (StringUtils.hasText(queryModel.getSiteNameLike())) {
			hql.append(" and upper(site.siteName) like:siteName");
			params.put("siteName", "%"
					+ queryModel.getSiteNameLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getSiteCodeLike())) {
			hql.append(" and upper(site.siteCode) like:siteCode");
			params.put("siteCode", "%"
					+ queryModel.getSiteCodeLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getNetworkType())) {
			hql.append(" and site.type =:networkType");
			params.put("networkType", queryModel.getNetworkType());
		}
		if (queryModel.getBureau() != null) {
			hql.append(" and site.bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}

		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}

		return super.querySize(hql.toString(), params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Antenna> queryList(AntennaQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from Antenna where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();

		if (StringUtils.hasText(queryModel.getSiteNameLike())) {
			hql.append(" and upper(site.siteName) like:siteName");
			params.put("siteName", "%"
					+ queryModel.getSiteNameLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getSiteCodeLike())) {
			hql.append(" and upper(site.siteCode) like:siteCode");
			params.put("siteCode", "%"
					+ queryModel.getSiteCodeLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getNetworkType())) {
			hql.append(" and site.type =:networkType");
			params.put("networkType", queryModel.getNetworkType());
		}
		if (queryModel.getBureau() != null) {
			hql.append(" and site.bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}
		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}
		hql.append(" order by site.bureau, site.siteCode asc");
		return (List<Antenna>) super.queryList(hql.toString(), params);
	}

}
