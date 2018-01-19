/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName EquipCircuitDaoImpl.java
 * @PackageName:cn.com.atnc.ioms.dao.maintain.circuit.hibernate
 * @author ku
 * @date 2015年4月30日下午1:51:57
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.circuit.hibernate;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.maintain.circuit.IEquipCircuitDao;
import cn.com.atnc.ioms.entity.maintain.circuit.EquipCircuit;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;

/**
 * 设备电路配置Dao实现类
 *
 * @author ku
 * @date 2015年4月30日 下午1:51:57
 * @since 1.0.0
 */
@Repository
public class EquipCircuitDaoImpl extends MyBaseDao<EquipCircuit> implements
		IEquipCircuitDao {

	@Override
	public Pagination queryPage(KuStatQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from EquipCircuit where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getMemoLike())) {
			// 模糊查询
			hql.append(" and upper(kuService.memo) like:serviceMemoLike");
			params.put("serviceMemoLike", "%"
					+ queryModel.getMemoLike().trim().toUpperCase() + "%");
		}
		if (StringUtils.hasText(queryModel.getCode())) {
			hql.append(" and kuService.code =:code");
			params.put("code", queryModel.getCode());
		}
		if (StringUtils.hasText(queryModel.getCodeLike())) {
			hql.append(" and kuService.code like:codeLike");
			params.put("codeLike", "%" + queryModel.getCodeLike().toUpperCase()
					+ "%");
		}
		if (StringUtils.hasText(queryModel.getRxNodeId())) {
			hql.append(" and kuService.rxNode.id =:rxNodeId");
			params.put("rxNodeId", queryModel.getRxNodeId());
		}
		if (StringUtils.hasText(queryModel.getRxNodeNo())) {
			hql.append(" and kuService.rxNode.kuNodeNo =:rxNodeNo");
			params.put("rxNodeNo", queryModel.getRxNodeNo());
		}

		if (StringUtils.hasText(queryModel.getRxNodeNoLike())) {
			hql.append(" and kuService.rxNode.kuNodeNo like:rxNodeNoLike");
			params.put("rxNodeNoLike", "%" + queryModel.getRxNodeNoLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getRxChan())) {
			hql.append(" and kuService.rxChan =:rxChan");
			params.put("rxChan", queryModel.getRxChan());
		}
		if (StringUtils.hasText(queryModel.getRxGib())) {
			hql.append(" and kuService.rxGib =:rxGib");
			params.put("rxGib", queryModel.getRxGib());
		}

		if (StringUtils.hasText(queryModel.getTxNodeId())) {
			hql.append(" and kuService.txNode.id =:txNodeId");
			params.put("txNodeId", queryModel.getTxNodeId());
		}
		if (StringUtils.hasText(queryModel.getTxNodeNo())) {
			hql.append(" and kuService.txNode.kuNodeNo =:txNodeNo");
			params.put("txNodeNo", queryModel.getTxNodeNo());
		}
		if (StringUtils.hasText(queryModel.getTxNodeNoLike())) {
			hql.append(" and kuService.txNode.kuNodeNo like:txNodeNoLike");
			params.put("txNodeNoLike", "%" + queryModel.getTxNodeNoLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getTxChan())) {
			hql.append(" and kuService.txChan =:txChan");
			params.put("txChan", queryModel.getTxChan());
		}
		if (StringUtils.hasText(queryModel.getTxGib())) {
			hql.append(" and kuService.txGib =:txGib");
			params.put("txGib", queryModel.getTxGib());
		}
		if (queryModel.getComplete() != null) {
			hql.append(" and kuService.complete =:complete");
			params.put("complete", queryModel.getComplete());
		}
		if (queryModel.getRateType() != null) {
			hql.append(" and kuService.rateType =:rateType");
			params.put("rateType", queryModel.getRateType());
		}

		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by kuService.serviceChangeType asc,kuService.bureau asc,kuService.code asc,kuService.id asc");
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

}
