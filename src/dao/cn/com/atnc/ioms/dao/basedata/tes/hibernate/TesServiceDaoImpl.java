/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午8:04:49
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.basedata.tes.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesServiceDao;
import cn.com.atnc.ioms.entity.basedata.tes.TesService;
import cn.com.atnc.ioms.model.basedata.tes.TesServiceQueryModel;
import cn.com.atnc.ioms.model.operstat.tes.TesStatQueryModel;

@Repository("tesServiceDao")
public class TesServiceDaoImpl extends MyBaseDao<TesService> implements
		ITesServiceDao {

	@Override
	public Pagination queryPage(TesServiceQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from TesService where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();

		if (StringUtils.hasText(queryModel.getBandWidthPoolLike())) {
			// 模糊查询
			hql.append(" and upper(bandWidthPool) like:bandWidthPoolLike  escape '/' ");
			params.put("bandWidthPoolLike", "%"
					+ queryModel.getBandWidthPoolLike().trim().toUpperCase()
					+ "%");
		}
		if (StringUtils.hasText(queryModel.getServiceMemoLike())) {
			// 模糊查询
			hql.append(" and upper(serviceMemo) like:serviceMemoLike  ");
			params.put("serviceMemoLike", "%"
					+ queryModel.getServiceMemoLike().trim().toUpperCase()
					+ "%");
		}
		if (StringUtils.hasText(queryModel.getActiveNodeCode())) {
			hql.append(" and activeNode.tesNodeCode =:activeNodeCode");
			params.put("activeNodeCode", queryModel.getActiveNodeCode());
		}
		if (StringUtils.hasText(queryModel.getActiveNodeCodeLike())) {
			hql.append(" and activeNode.tesNodeCode like:activeNodeCodeLike");
			params.put("activeNodeCodeLike", "%"
					+ queryModel.getActiveNodeCodeLike().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getPassiveNodeCode())) {
			hql.append(" and passiveNode.tesNodeCode =:passiveNodeCode");
			params.put("passiveNodeCode", queryModel.getPassiveNodeCode());
		}
		if (StringUtils.hasText(queryModel.getPassiveNodeCodeLike())) {
			hql.append(" and passiveNode.tesNodeCode like:passiveNodeCodeLike");
			params.put("passiveNodeCodeLike", "%"
					+ queryModel.getPassiveNodeCodeLike().toUpperCase() + "%");
		}

		if (StringUtils.hasText(queryModel.getActiveNodeId())) {
			hql.append(" and activeNode.id =:activeNodeId");
			params.put("activeNodeId", queryModel.getActiveNodeId());
		}

		if (StringUtils.hasText(queryModel.getPassiveNodeId())) {
			hql.append(" and passiveNode.id =:passiveNodeId");
			params.put("passiveNodeId", queryModel.getPassiveNodeId());
		}

		if (StringUtils.hasText(queryModel.getActiveNodeSlot())) {
			hql.append(" and activeSlot =:activeSlot");
			params.put("activeSlot", queryModel.getActiveNodeSlot());
		}
		if (StringUtils.hasText(queryModel.getPassiveNodeSlot())) {
			hql.append(" and passiveSlot =:passiveSlot");
			params.put("passiveSlot", queryModel.getPassiveNodeSlot());
		}

		if (StringUtils.hasText(queryModel.getCircuitName())) {
			hql.append(" and circuitName =:circuitName");
			params.put("circuitName", queryModel.getCircuitName());
		}
		if (StringUtils.hasText(queryModel.getCircuitNameLike())) {
			hql.append(" and circuitName like:circuitNameLike");
			params.put("circuitNameLike", "%"
					+ queryModel.getCircuitNameLike().toUpperCase() + "%");
		}

		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}

		if (StringUtils.hasText(queryModel.getTesServiceInfoLike())) {
			// tes业务管理 备注 模糊查询
			String tesServiceInfoLike = queryModel.getTesServiceInfoLike();
			if (tesServiceInfoLike.contains("[_]")) {
				tesServiceInfoLike = tesServiceInfoLike.replace("[_]", "\\_");
			}
			if (tesServiceInfoLike.contains("[%]")) {
				tesServiceInfoLike = tesServiceInfoLike.replace("[%]", "\\%");
			}
			if (tesServiceInfoLike.contains("[^]")) {
				tesServiceInfoLike = tesServiceInfoLike.replace("[^]", "");
			}
			hql.append(" and (info like:tesServiceInfoLikeUpper escape '\\' or info like:tesServiceInfoLikeLower escape '\\') ");
			params.put("tesServiceInfoLikeUpper", "%"
					+ tesServiceInfoLike.trim().toUpperCase() + "%");
			params.put("tesServiceInfoLikeLower", "%"
					+ tesServiceInfoLike.trim().toLowerCase() + "%");
		}
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by activeNode.equip.satellite.siteName,activeNode.tesNodeCode,activeSlot asc");
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public Pagination queryPage(TesStatQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from TesService where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getActiveNodeCode())) {
			hql.append(" and activeNode.tesNodeCode =:activeNodeCode");
			params.put("activeNodeCode", queryModel.getActiveNodeCode());
		}
		if (StringUtils.hasText(queryModel.getActiveNodeCodeLike())) {
			hql.append(" and activeNode.tesNodeCode like:activeNodeCodeLike");
			params.put("activeNodeCodeLike", "%"
					+ queryModel.getActiveNodeCodeLike().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getPassiveNodeCode())) {
			hql.append(" and passiveNode.tesNodeCode =:passiveNodeCode");
			params.put("passiveNodeCode", queryModel.getPassiveNodeCode());
		}
		if (StringUtils.hasText(queryModel.getPassiveNodeCodeLike())) {
			hql.append(" and passiveNode.tesNodeCode like:passiveNodeCodeLike");
			params.put("passiveNodeCodeLike", "%"
					+ queryModel.getPassiveNodeCodeLike().toUpperCase() + "%");
		}

		if (StringUtils.hasText(queryModel.getActiveNodeId())) {
			hql.append(" and activeNode.id =:activeNodeId");
			params.put("activeNodeId", queryModel.getActiveNodeId());
		}

		if (StringUtils.hasText(queryModel.getPassiveNodeId())) {
			hql.append(" and passiveNode.id =:passiveNodeId");
			params.put("passiveNodeId", queryModel.getPassiveNodeId());
		}

		if (StringUtils.hasText(queryModel.getActiveNodeSlot())) {
			hql.append(" and activeSlot =:activeSlot");
			params.put("activeSlot", queryModel.getActiveNodeSlot());
		}
		if (StringUtils.hasText(queryModel.getPassiveNodeSlot())) {
			hql.append(" and passiveSlot =:passiveSlot");
			params.put("passiveSlot", queryModel.getPassiveNodeSlot());
		}

		if (StringUtils.hasText(queryModel.getCircuitName())) {
			hql.append(" and circuitName =:circuitName");
			params.put("circuitName", queryModel.getCircuitName());
		}
		if (StringUtils.hasText(queryModel.getCircuitNameLike())) {
			hql.append(" and circuitName like:circuitNameLike");
			params.put("circuitNameLike", "%"
					+ queryModel.getCircuitNameLike().toUpperCase() + "%");
		}

		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}
		String countHql = COUNT_ID + hql.toString();
		// hql.append(" order by code asc");
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	public Long querySize(TesServiceQueryModel queryModel) {
		/*
		 * StringBuilder hql = new StringBuilder("from TesService where 1=1");
		 * Map<String, Object> params = new HashMap<String, Object>(); if
		 * (StringUtils.hasText(queryModel.getActiveNodeCode())) {
		 * hql.append(" and activeNode.tesNodeCode =:ActiveNodeCode");
		 * params.put("ActiveNodeCode", queryModel.getActiveNodeCode()); }
		 * 
		 * if (StringUtils.hasText(queryModel.getActiveNodeCodeLike())) {
		 * hql.append(" and activeNode.tesNodeCode like:codeLike");
		 * params.put("codeLike", "%" + queryModel.getActiveNodeCodeLike() +
		 * "%"); }
		 * 
		 * if (StringUtils.hasText(queryModel.getPassiveNodeCode())) {
		 * hql.append(" and passiveNode.tesNodeCode =:NodeCode");
		 * params.put("NodeCode", queryModel.getPassiveNodeCode()); } if
		 * (StringUtils.hasText(queryModel.getPassiveNodeCodeLike())) {
		 * hql.append(" and passiveNode.tesNodeCode like:codeLike");
		 * params.put("codeLike", "%" + queryModel.getPassiveNodeCodeLike() +
		 * "%"); }
		 * 
		 * if (StringUtils.hasText(queryModel.getActiveNodeId())) {
		 * hql.append(" and activeNode.id =:nodeId"); params.put("nodeId",
		 * queryModel.getActiveNodeId()); }
		 * 
		 * if (StringUtils.hasText(queryModel.getPassiveNodeId())) {
		 * hql.append(" and passiveNode.id =:nodeId"); params.put("nodeId",
		 * queryModel.getPassiveNodeId()); }
		 * 
		 * if (StringUtils.hasText(queryModel.getActiveNodeSlot())) {
		 * hql.append(" and activeSlot =:activeSlot"); params.put("activeSlot",
		 * queryModel.getActiveNodeSlot()); } if
		 * (StringUtils.hasText(queryModel.getPassiveNodeSlot())) {
		 * hql.append(" and passiveSlot =:passiveSlot");
		 * params.put("passiveSlot", queryModel.getPassiveNodeSlot()); }
		 * 
		 * if (StringUtils.hasText(queryModel.getCircuitName())) {
		 * hql.append(" and circuitName =:passiveSlot");
		 * params.put("passiveSlot", queryModel.getCircuitName()); } if
		 * (StringUtils.hasText(queryModel.getCircuitNameLike())) {
		 * hql.append(" and circuitName like:circuitName");
		 * params.put("circuitName", "%" + queryModel.getCircuitNameLike() +
		 * "%"); }
		 * 
		 * if (StringUtils.hasText(queryModel.getExcludeId())) {
		 * hql.append(" and id <>:id"); params.put("id",
		 * queryModel.getExcludeId()); }
		 */
		StringBuilder hql = new StringBuilder("from TesService where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getServiceMemoLike())) {
			// 模糊查询
			hql.append(" and upper(serviceMemo) like:serviceMemoLike  escape '/' ");
			params.put("serviceMemoLike", "%"
					+ queryModel.getServiceMemoLike().trim().toUpperCase()
					+ "%");
		}
		if (StringUtils.hasText(queryModel.getActiveNodeCode())) {
			hql.append(" and activeNode.tesNodeCode =:activeNodeCode");
			params.put("activeNodeCode", queryModel.getActiveNodeCode());
		}
		if (StringUtils.hasText(queryModel.getActiveNodeCodeLike())) {
			hql.append(" and activeNode.tesNodeCode like:activeNodeCodeLike");
			params.put("activeNodeCodeLike", "%"
					+ queryModel.getActiveNodeCodeLike().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getPassiveNodeCode())) {
			hql.append(" and passiveNode.tesNodeCode =:passiveNodeCode");
			params.put("passiveNodeCode", queryModel.getPassiveNodeCode());
		}
		if (StringUtils.hasText(queryModel.getPassiveNodeCodeLike())) {
			hql.append(" and passiveNode.tesNodeCode like:passiveNodeCodeLike");
			params.put("passiveNodeCodeLike", "%"
					+ queryModel.getPassiveNodeCodeLike().toUpperCase() + "%");
		}

		if (StringUtils.hasText(queryModel.getActiveNodeId())) {
			hql.append(" and activeNode.id =:activeNodeId");
			params.put("activeNodeId", queryModel.getActiveNodeId());
		}

		if (StringUtils.hasText(queryModel.getPassiveNodeId())) {
			hql.append(" and passiveNode.id =:passiveNodeId");
			params.put("passiveNodeId", queryModel.getPassiveNodeId());
		}

		if (StringUtils.hasText(queryModel.getActiveNodeSlot())) {
			hql.append(" and activeSlot =:activeSlot");
			params.put("activeSlot", queryModel.getActiveNodeSlot());
		}
		if (StringUtils.hasText(queryModel.getPassiveNodeSlot())) {
			hql.append(" and passiveSlot =:passiveSlot");
			params.put("passiveSlot", queryModel.getPassiveNodeSlot());
		}

		if (StringUtils.hasText(queryModel.getCircuitName())) {
			hql.append(" and circuitName =:circuitName");
			params.put("circuitName", queryModel.getCircuitName());
		}
		if (StringUtils.hasText(queryModel.getCircuitNameLike())) {
			hql.append(" and circuitName like:circuitNameLike");
			params.put("circuitNameLike", "%"
					+ queryModel.getCircuitNameLike().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}
		return super.querySize(hql.toString(), params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TesService> queryList(TesServiceQueryModel queryModel) {

		StringBuilder hql = new StringBuilder("from TesService where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getServiceMemoLike())) {
			// 模糊查询
			hql.append(" and upper(serviceMemo) like:serviceMemoLike  escape '/' ");
			params.put("serviceMemoLike", "%"
					+ queryModel.getServiceMemoLike().trim().toUpperCase()
					+ "%");
		}
		if (StringUtils.hasText(queryModel.getActiveNodeCode())) {
			hql.append(" and activeNode.tesNodeCode =:activeNodeCode");
			params.put("activeNodeCode", queryModel.getActiveNodeCode());
		}
		if (StringUtils.hasText(queryModel.getActiveNodeCodeLike())) {
			hql.append(" and activeNode.tesNodeCode like:activeNodeCodeLike");
			params.put("activeNodeCodeLike", "%"
					+ queryModel.getActiveNodeCodeLike().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getPassiveNodeCode())) {
			hql.append(" and passiveNode.tesNodeCode =:passiveNodeCode");
			params.put("passiveNodeCode", queryModel.getPassiveNodeCode());
		}
		if (StringUtils.hasText(queryModel.getPassiveNodeCodeLike())) {
			hql.append(" and passiveNode.tesNodeCode like:passiveNodeCodeLike");
			params.put("passiveNodeCodeLike", "%"
					+ queryModel.getPassiveNodeCodeLike().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getNodeId())) {
			hql.append(" and (activeNode.id =:activeNodeIdd  or passiveNode.id =:passiveNodeIdd)");
			params.put("activeNodeIdd", queryModel.getNodeId());
			params.put("passiveNodeIdd", queryModel.getNodeId());
		}
		if (StringUtils.hasText(queryModel.getActiveNodeId())) {
			hql.append(" and activeNode.id =:activeNodeId");
			params.put("activeNodeId", queryModel.getActiveNodeId());
		}

		if (StringUtils.hasText(queryModel.getPassiveNodeId())) {
			hql.append(" and passiveNode.id =:passiveNodeId");
			params.put("passiveNodeId", queryModel.getPassiveNodeId());
		}

		if (StringUtils.hasText(queryModel.getActiveNodeSlot())) {
			hql.append(" and activeSlot =:activeSlot");
			params.put("activeSlot", queryModel.getActiveNodeSlot());
		}
		if (StringUtils.hasText(queryModel.getPassiveNodeSlot())) {
			hql.append(" and passiveSlot =:passiveSlot");
			params.put("passiveSlot", queryModel.getPassiveNodeSlot());
		}

		if (StringUtils.hasText(queryModel.getCircuitName())) {
			hql.append(" and circuitName =:circuitName");
			params.put("circuitName", queryModel.getCircuitName());
		}
		if (StringUtils.hasText(queryModel.getCircuitNameLike())) {
			hql.append(" and circuitName like:circuitNameLike");
			params.put("circuitNameLike", "%"
					+ queryModel.getCircuitNameLike().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}
		return (List<TesService>) super.queryList(hql.toString(), params);
	}

	public int deleteByNodeId(String nodeId) {
		String hql = "delete from TesService where activeNode.id=? or passiveSlot.id=?";
		return super.executeHql(hql, new Object[] { nodeId, nodeId });
	}

}
