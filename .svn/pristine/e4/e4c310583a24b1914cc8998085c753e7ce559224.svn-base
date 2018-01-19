package cn.com.atnc.ioms.dao.business.formalcircuit.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitPESDao;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitPES;

/**
 * PES正式电路申请表Dao接口实现类
 *
 * @author 段衍林
 * @2017年1月5日 上午10:41:35
 */
@Repository
public class FormalCircuitPESDaoImpl extends MyBaseDao<FormalCircuitPES>
		implements IFormalCircuitPESDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<FormalCircuitPES> findByFC(FormalCircuit formalCircuit) {
		StringBuffer hql = new StringBuffer(" from FormalCircuitPES where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (!StringUtils.isEmpty(formalCircuit.getId())) {
			hql.append(" and formalCircuit.id = ?");
			params.add(formalCircuit.getId());
		}
		hql.append(" order by num asc ");
		return (List<FormalCircuitPES>) super.queryList(hql.toString(),
				params.toArray());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FormalCircuitPES> findBySiteAndCaseNum(
			List<String> PEStxSiteNames, List<String> PEStxCaseNums,
			List<String> PESrxSiteNames, List<String> PESrxCaseNums) {
		List<Object> queryParams = new ArrayList<Object>();
		StringBuilder hql = new StringBuilder(
				"from FormalCircuitPES where txSiteName in (");
		for (String PEStxSiteName : PEStxSiteNames) {
			hql.append("?,");
			queryParams.add(PEStxSiteName);
		}
		hql.deleteCharAt(hql.length() - 1);
		hql.append(") and txCaseNum in (");
		for (String PEStxCaseNum : PEStxCaseNums) {
			hql.append("?,");
			queryParams.add(PEStxCaseNum);
		}
		hql.deleteCharAt(hql.length() - 1);
		hql.append(") and rxSiteName in (");
		for (String PESrxSiteName : PESrxSiteNames) {
			hql.append("?,");
			queryParams.add(PESrxSiteName);
		}
		hql.deleteCharAt(hql.length() - 1);
		hql.append(") and rxCaseNum in (");
		for (String PESrxCaseNum : PESrxCaseNums) {
			hql.append("?,");
			queryParams.add(PESrxCaseNum);
		}
		hql.deleteCharAt(hql.length() - 1);
		hql.append(") ");
		hql.append(" order by num asc ");
		return (List<FormalCircuitPES>) super.queryList(hql.toString(),
				queryParams.toArray());
	}
}
