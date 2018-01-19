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

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuServiceDao;
import cn.com.atnc.ioms.entity.basedata.ku.KuService;
import cn.com.atnc.ioms.enums.basedata.ServiceChangeType;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;

/**
 * @author:HuangYijie
 * @date:2014-3-19 下午8:04:49
 * @version:1.0
 */
@Repository("kuServiceDao")
public class KuServiceDaoImpl extends MyBaseDao<KuService> implements
		IKuServiceDao {

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao#queryPage(cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel)
	 */
	@Override
	public Pagination queryPage(KuStatQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from KuService where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getMemoLike())) {
			// 模糊查询
			hql.append(" and upper(memo) like:serviceMemoLike");
			params.put("serviceMemoLike", "%"
					+ queryModel.getMemoLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getCode())) {
			hql.append(" and code =:code");
			params.put("code", queryModel.getCode());
		}
		if (StringUtils.hasText(queryModel.getCodeLike())) {
			hql.append(" and code like:codeLike");
			params.put("codeLike", "%" + queryModel.getCodeLike().toUpperCase()
					+ "%");
		}
		if (StringUtils.hasText(queryModel.getUsageLike())) {
			// 模糊查询
			hql.append(" and upper(usage) like:usageLike");
			params.put("usageLike", "%"
					+ queryModel.getUsageLike().trim().toUpperCase() + "%");
		}

		/**
		 * 子网查询
		 * 段衍林添加
		 */
		if (!org.apache.commons.lang.ObjectUtils.equals(
				queryModel.getSubnetTypeRx(), null)) {
			// 收端
			hql.append(" and rxNode.subnetType =:subnetTypeRx");
			params.put("subnetTypeRx", queryModel.getSubnetTypeRx());
		}
		if (!org.apache.commons.lang.ObjectUtils.equals(
				queryModel.getSubnetTypeTx(), null)) {
			// 发端
			hql.append(" and txNode.subnetType =:subnetTypeTx");
			params.put("subnetTypeTx", queryModel.getSubnetTypeTx());
		}
		
		if (StringUtils.hasText(queryModel.getRxNodeId())) {
			hql.append(" and rxNode.id =:rxNodeId");
			params.put("rxNodeId", queryModel.getRxNodeId());
		}
		if (StringUtils.hasText(queryModel.getRxNodeNo())) {
			hql.append(" and rxNode.kuNodeNo =:rxNodeNo");
			params.put("rxNodeNo", queryModel.getRxNodeNo());
		}

		if (StringUtils.hasText(queryModel.getRxNodeNoLike())) {
			hql.append(" and rxNode.kuNodeNo like:rxNodeNoLike");
			params.put("rxNodeNoLike", "%" + queryModel.getRxNodeNoLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getRxChan())) {
			hql.append(" and rxChan =:rxChan");
			params.put("rxChan", queryModel.getRxChan());
		}
		if (StringUtils.hasText(queryModel.getRxGib())) {
			hql.append(" and rxGib =:rxGib");
			params.put("rxGib", queryModel.getRxGib());
		}

		if (StringUtils.hasText(queryModel.getTxNodeId())) {
			hql.append(" and txNode.id =:txNodeId");
			params.put("txNodeId", queryModel.getTxNodeId());
		}
		if (StringUtils.hasText(queryModel.getTxNodeNo())) {
			hql.append(" and txNode.kuNodeNo =:txNodeNo");
			params.put("txNodeNo", queryModel.getTxNodeNo());
		}
		if (StringUtils.hasText(queryModel.getTxNodeNoLike())) {
			hql.append(" and txNode.kuNodeNo like:txNodeNoLike");
			params.put("txNodeNoLike", "%" + queryModel.getTxNodeNoLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getTxChan())) {
			hql.append(" and txChan =:txChan");
			params.put("txChan", queryModel.getTxChan());
		}
		if (StringUtils.hasText(queryModel.getTxGib())) {
			hql.append(" and txGib =:txGib");
			params.put("txGib", queryModel.getTxGib());
		}
		if (queryModel.getComplete() != null) {
			hql.append(" and complete =:complete");
			params.put("complete", queryModel.getComplete());
		}
		if (queryModel.getRateType() != null) {
			hql.append(" and rateType =:rateType");
			params.put("rateType", queryModel.getRateType());
		}

		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by serviceChangeType asc,bureau asc,code asc,id asc");
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public Long querySize(KuStatQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from KuService where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getMemoLike())) {
			// 模糊查询
			hql.append(" and upper(memo) like:serviceMemoLike  escape '/' ");
			params.put("serviceMemoLike", "%"
					+ queryModel.getMemoLike().trim().toUpperCase() + "%");
		}

		/**
		 * 子网查询
		 * 段衍林添加
		 */
		if (!org.apache.commons.lang.ObjectUtils.equals(
				queryModel.getSubnetTypeRx(), null)) {
			// 收端
			hql.append(" and rxNode.subnetType =:subnetTypeRx");
			params.put("subnetTypeRx", queryModel.getSubnetTypeRx());
		}
		if (!org.apache.commons.lang.ObjectUtils.equals(
				queryModel.getSubnetTypeTx(), null)) {
			// 发端
			hql.append(" and txNode.subnetType =:subnetTypeTx");
			params.put("subnetTypeTx", queryModel.getSubnetTypeTx());
		}
		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:excludeId");
			params.put("excludeId", queryModel.getExcludeId());
		}
		if (StringUtils.hasText(queryModel.getCode())) {
			hql.append(" and code =:code");
			params.put("code", queryModel.getCode());
		}
		if (StringUtils.hasText(queryModel.getCodeLike())) {
			hql.append(" and code like:codeLike");
			params.put("codeLike", "%" + queryModel.getCodeLike().toUpperCase()
					+ "%");
		}
		if (StringUtils.hasText(queryModel.getRxNodeId())) {
			hql.append(" and rxNode.id =:rxNodeId");
			params.put("rxNodeId", queryModel.getRxNodeId());
		}
		if (StringUtils.hasText(queryModel.getRxNodeNo())) {
			hql.append(" and rxNode.kuNodeNo =:rxNodeNo");
			params.put("rxNodeNo", queryModel.getRxNodeNo());
		}

		if (StringUtils.hasText(queryModel.getRxNodeNoLike())) {
			hql.append(" and rxNode.kuNodeNo like:rxNodeNoLike");
			params.put("rxNodeNoLike", "%" + queryModel.getRxNodeNoLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getRxChan())) {
			hql.append(" and rxChan =:rxChan");
			params.put("rxChan", queryModel.getRxChan());
		}
		if (StringUtils.hasText(queryModel.getRxGib())) {
			hql.append(" and rxGib =:rxGib");
			params.put("rxGib", queryModel.getRxGib());
		}

		if (StringUtils.hasText(queryModel.getTxNodeId())) {
			hql.append(" and txNode.id =:txNodeId");
			params.put("txNodeId", queryModel.getTxNodeId());
		}
		if (StringUtils.hasText(queryModel.getTxNodeNo())) {
			hql.append(" and txNode.kuNodeNo =:txNodeNo");
			params.put("txNodeNo", queryModel.getTxNodeNo());
		}
		if (StringUtils.hasText(queryModel.getTxNodeNoLike())) {
			hql.append(" and txNode.kuNodeNo like:txNodeNoLike");
			params.put("txNodeNoLike", "%" + queryModel.getTxNodeNoLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getTxChan())) {
			hql.append(" and txChan =:txChan");
			params.put("txChan", queryModel.getTxChan());
		}
		if (StringUtils.hasText(queryModel.getTxGib())) {
			hql.append(" and txGib =:txGib");
			params.put("txGib", queryModel.getTxGib());
		}
		if (queryModel.getRateType() != null) {
			hql.append(" and rateType =:rateType");
			params.put("rateType", queryModel.getRateType());
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
	public List<KuService> queryList(KuStatQueryModel queryModel) {

		StringBuilder hql = new StringBuilder("from KuService where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getMemoLike())) {
			// 模糊查询
			hql.append(" and upper(memo) like:serviceMemoLike  escape '/' ");
			params.put("serviceMemoLike", "%"
					+ queryModel.getMemoLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getCode())) {
			hql.append(" and code =:code");
			params.put("code", queryModel.getCode());
		}
		if (StringUtils.hasText(queryModel.getCodeLike())) {
			hql.append(" and code like:codeLike");
			params.put("codeLike", "%" + queryModel.getCodeLike().toUpperCase()
					+ "%");
		}
		if (StringUtils.hasText(queryModel.getRxNodeId())) {
			hql.append(" and rxNode.id =:rxNodeId");
			params.put("rxNodeId", queryModel.getRxNodeId());
		}
		if (StringUtils.hasText(queryModel.getRxNodeNo())) {
			hql.append(" and rxNode.kuNodeNo =:rxNodeNo");
			params.put("rxNodeNo", queryModel.getRxNodeNo());
		}

		/**
		 * 子网查询
		 * 段衍林添加
		 */
		if (!org.apache.commons.lang.ObjectUtils.equals(
				queryModel.getSubnetTypeRx(), null)) {
			// 收端
			hql.append(" and rxNode.subnetType =:subnetTypeRx");
			params.put("subnetTypeRx", queryModel.getSubnetTypeRx());
		}
		if (!org.apache.commons.lang.ObjectUtils.equals(
				queryModel.getSubnetTypeTx(), null)) {
			// 发端
			hql.append(" and txNode.subnetType =:subnetTypeTx");
			params.put("subnetTypeTx", queryModel.getSubnetTypeTx());
		}

		if (StringUtils.hasText(queryModel.getRxNodeNoLike())) {
			hql.append(" and rxNode.kuNodeNo like:rxNodeNoLike");
			params.put("rxNodeNoLike", "%" + queryModel.getRxNodeNoLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getRxChan())) {
			hql.append(" and rxChan =:rxChan");
			params.put("rxChan", queryModel.getRxChan());
		}
		if (StringUtils.hasText(queryModel.getRxGib())) {
			hql.append(" and rxGib =:rxGib");
			params.put("rxGib", queryModel.getRxGib());
		}

		if (StringUtils.hasText(queryModel.getTxNodeId())) {
			hql.append(" and txNode.id =:txNodeId");
			params.put("txNodeId", queryModel.getTxNodeId());
		}
		if (StringUtils.hasText(queryModel.getTxNodeNo())) {
			hql.append(" and txNode.kuNodeNo =:txNodeNo");
			params.put("txNodeNo", queryModel.getTxNodeNo());
		}
		if (StringUtils.hasText(queryModel.getTxNodeNoLike())) {
			hql.append(" and txNode.kuNodeNo like:txNodeNoLike");
			params.put("txNodeNoLike", "%" + queryModel.getTxNodeNoLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getTxChan())) {
			hql.append(" and txChan =:txChan");
			params.put("txChan", queryModel.getTxChan());
		}
		if (StringUtils.hasText(queryModel.getTxGib())) {
			hql.append(" and txGib =:txGib");
			params.put("txGib", queryModel.getTxGib());
		}
		if (queryModel.getRateType() != null) {
			hql.append(" and rateType =:rateType");
			params.put("rateType", queryModel.getRateType());
		}
		if (!ObjectUtils.isEmpty(queryModel.getIds())) {
			hql.append(" and id in(:ids)");
			params.put("ids", queryModel.getIds());
		}
		if (StringUtils.hasText(queryModel.getNodeId())) {
			hql.append(" and (txNode.id =:ttxNodeId or rxNode.id=:rrxNodeId)");
			params.put("ttxNodeId", queryModel.getNodeId());
			params.put("rrxNodeId", queryModel.getNodeId());
		}
		hql.append(" order by bureau asc,code asc");
		return (List<KuService>) super.queryList(hql.toString(), params);

	}

	@Override
	public int deleteByNodeId(String nodeId) {
		String hql = "delete from KuService where txNode.id=? or rxNode.id=?";
		return super.executeHql(hql, new Object[] { nodeId, nodeId });
	}

	@Override
	public int updateServiceChangeType(ServiceChangeType dest) {
		// TODO Auto-generated method stub
		String hql = "update KuService set serviceChangeType = ?";
		return super.executeHql(hql, new Object[] { dest });
	}
}
