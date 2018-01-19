package cn.com.atnc.ioms.dao.faultmng.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultEvaluateDao;
import cn.com.atnc.ioms.entity.faultmng.FaultEvaluate;
import cn.com.atnc.ioms.model.faultmng.FaultEvaluateModel;

/**
 * 事件单评价实现类
 *
 * @author 段衍林
 * @2016年11月9日 下午4:34:33
 */
@Repository("faultEvaluateDao")
public class FaultEvaluateDaoImpl extends MyBaseDao<FaultEvaluate> implements
		IFaultEvaluateDao {

	/**
	 * 事件单查询
	 * @author 段衍林
	 * @2016年11月9日 下午4:35:19
	 * @param qm
	 * @return
	 * List<FaultEvaluate>
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<FaultEvaluate> queryList(FaultEvaluateModel qm) {
		StringBuilder hql = new StringBuilder(" from FaultEvaluate where 1=1 ");
		List<Object> params = new ArrayList<>();
		//故障单编号
		if (!StringUtils.isEmpty(qm.getFaultId())) {
			hql.append(" and faultId = ? ");
			params.add(qm.getFaultId());
		}
		//操作时间倒序排列
		hql.append(" order by operatTime desc ");
		return (List<FaultEvaluate>) super.queryList(hql.toString(),
				params.toArray());
	}
}