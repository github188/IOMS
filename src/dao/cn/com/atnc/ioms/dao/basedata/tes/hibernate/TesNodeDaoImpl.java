package cn.com.atnc.ioms.dao.basedata.tes.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesNodeDao;
import cn.com.atnc.ioms.entity.basedata.tes.TesNode;
import cn.com.atnc.ioms.model.basedata.tes.TesNodeQueryModel;

@Repository("tesNodeDao")
public class TesNodeDaoImpl extends MyBaseDao<TesNode> implements ITesNodeDao {

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao#queryPage(cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel)
	 */
	@Override
	public Pagination queryPage(TesNodeQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from TesNode where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();

		if (StringUtils.hasText(queryModel.getTesNodeInfoLike())) {
			// tes节点管理 备注 模糊查询
			String tesNodeInfoLike = queryModel.getTesNodeInfoLike();
			hql.append(" and upper(info) like:tesNodeInfoLikeUpper  escape '/' ");
			params.put("tesNodeInfoLikeUpper", "%"
					+ tesNodeInfoLike.trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getTesNodeCode())) {
			hql.append(" and tesNodeCode =:tesNodeCode");
			params.put("tesNodeCode", queryModel.getTesNodeCode());
		}
		if (StringUtils.hasText(queryModel.getTesNodeCodeLike())) {
			hql.append(" and tesNodeCode like:tesNodeCodeLike   escape '/' ");
			params.put("tesNodeCodeLike", "%"
					+ queryModel.getTesNodeCodeLike().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getSiteNameLike())) {
			hql.append(" and upper( equip.satellite.siteName) like:siteName   escape '/' ");
			params.put("siteName", "%"
					+ queryModel.getSiteNameLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getSiteCodeLike())) {
			hql.append(" and upper( equip.satellite.siteCode) like:siteCode   escape '/' ");
			params.put("siteCode", "%"
					+ queryModel.getSiteCodeLike().trim().toUpperCase() + "%");
		}
		if (queryModel.getBureau() != null) {
			hql.append(" and equip.satellite.bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}
		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}

		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by equip.bureau,tesNodeCode asc");
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public Long querySize(TesNodeQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from TesNode where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getTesNodeCode())) {
			hql.append(" and tesNodeCode =:tesNodeCode");
			params.put("tesNodeCode", queryModel.getTesNodeCode());
		}

		if (StringUtils.hasText(queryModel.getTesNodeCodeLike())) {
			hql.append(" and tesNodeCode like:tesNodeCodeLike escape '/' ");
			params.put("tesNodeCodeLike", "%"
					+ queryModel.getTesNodeCodeLike().toUpperCase() + "%");
		}

		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}
		if (StringUtils.hasText(queryModel.getSiteNameLike())) {
			hql.append(" and upper( equip.satellite.siteName) like:siteName   escape '/' ");
			params.put("siteName", "%"
					+ queryModel.getSiteNameLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getSiteCodeLike())) {
			hql.append(" and upper( equip.satellite.siteCode) like:siteCode   escape '/' ");
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
	public List<TesNode> queryList(TesNodeQueryModel queryModel) {

		StringBuilder hql = new StringBuilder("from TesNode where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getTesNodeCode())) {
			hql.append(" and tesNodeCode =:tesNodeCode");
			params.put("tesNodeCode", queryModel.getTesNodeCode());
		}
		if (StringUtils.hasText(queryModel.getTesNodeCodeLike())) {
			hql.append(" and tesNodeCode like:tesNodeCodeLike  escape '/' ");
			params.put("tesNodeCodeLike", "%"
					+ queryModel.getTesNodeCodeLike().toUpperCase() + "%");
		}

		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}

		if (StringTools.hasText(queryModel.getEquipId())) {
			hql.append(" and equip.id =:equipId");
			params.put("equipId", queryModel.getEquipId());
		}
		if (StringUtils.hasText(queryModel.getSiteNameLike())) {
			hql.append(" and upper( equip.satellite.siteName) like:siteName  escape '/' ");
			params.put("siteName", "%"
					+ queryModel.getSiteNameLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getSiteCodeLike())) {
			hql.append(" and upper( equip.satellite.siteCode) like:siteCode  escape '/' ");
			params.put("siteCode", "%"
					+ queryModel.getSiteCodeLike().trim().toUpperCase() + "%");
		}
		if (queryModel.getBureau() != null) {
			hql.append(" and equip.satellite.bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}
		// hql.append(" order by cast(tesNodeCode as integer) asc");

		return (List<TesNode>) super.queryList(hql.toString(), params);
	}
}
