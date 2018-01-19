package cn.com.atnc.ioms.dao.basedata.attenuator.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.attenuator.IAttenuatorDao;
import cn.com.atnc.ioms.entity.basedata.attenuator.Attenuator;
import cn.com.atnc.ioms.model.basedata.satellite.AttenuatorQueryModel;

@Repository("AttenuatorDao")
public class AttenuatorDaoImpl extends MyBaseDao<Attenuator> implements
		IAttenuatorDao {

	@Override
	public Pagination queryPage(AttenuatorQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from Attenuator   where 1=1");
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
		if (StringUtils.hasText(queryModel.getSolidLanchLike())) {
			hql.append(" and solidLanch like:solidLanch");
			params.put("solidLanch", "%" + queryModel.getSolidLanchLike() + "%");
		}

		if (StringUtils.hasText(queryModel.getSolidReceiveLike())) {
			hql.append(" and solidReceive like:solidReceive");
			params.put("solidReceive", "%" + queryModel.getSolidReceiveLike()
					+ "%");
		}

		if (StringUtils.hasText(queryModel.getSolidLanch())) {
			hql.append(" and solidLanch:solidLanch");
			params.put("solidLanch", queryModel.getSolidLanch());
		}
		if (StringUtils.hasText(queryModel.getSolidReceive())) {
			hql.append(" and solidReceive:solidReceive");
			params.put("solidReceive", queryModel.getSolidReceive());
		}

		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by  site.bureau, site.siteCode asc");
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public Long querySize(AttenuatorQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from Attenuator  where 1=1");
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
		if (queryModel.getBureau() != null) {
			hql.append(" and site.bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}
		if (StringUtils.hasText(queryModel.getSolidLanchLike())) {
			hql.append(" and solidLanch like:solidLanch");
			params.put("solidLanch", "%" + queryModel.getSolidLanchLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getSolidReceiveLike())) {
			hql.append(" and solidReceive like:solidReceive");
			params.put("solidReceive", "%" + queryModel.getSolidReceiveLike()
					+ "%");
		}

		if (StringUtils.hasText(queryModel.getSolidLanch())) {
			hql.append(" and solidLanch=:solidLanch");
			params.put("solidLanch", queryModel.getSolidLanch());
		}
		if (StringUtils.hasText(queryModel.getSolidReceive())) {
			hql.append(" and solidReceive=:solidReceive");
			params.put("solidReceive", queryModel.getSolidReceive());
		}

		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}
		return super.querySize(hql.toString(), params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attenuator> queryList(AttenuatorQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from Attenuator where 1=1");
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
		if (queryModel.getBureau() != null) {
			hql.append(" and site.bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}
		if (queryModel.getSiteId() != null) {
			hql.append(" and site.id =:siteid");
			params.put("siteid", queryModel.getSiteId());
		}
		if (StringUtils.hasText(queryModel.getSolidLanchLike())) {
			hql.append(" and solidLanch like:solidLanch");
			params.put("solidLanch", "%" + queryModel.getSolidLanchLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getSolidReceiveLike())) {
			hql.append(" and solidReceive like:solidReceive");
			params.put("solidReceive", "%" + queryModel.getSolidReceiveLike()
					+ "%");
		}

		if (StringUtils.hasText(queryModel.getSolidLanch())) {
			hql.append(" and solidLanch=:solidLanch");
			params.put("solidLanch", queryModel.getSolidLanch());
		}
		if (StringUtils.hasText(queryModel.getSolidReceive())) {
			hql.append(" and solidReceive=:solidReceive");
			params.put("solidReceive", queryModel.getSolidReceive());
		}
		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}
		hql.append(" order by site.bureau, site.siteCode asc");
		return (List<Attenuator>) super.queryList(hql.toString(), params);
	}
}
