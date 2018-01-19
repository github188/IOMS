package cn.com.atnc.ioms.dao.business.formalcircuit.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitKUDao;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitKU;

 /**
 * KU正式电路申请表Dao接口实现类
 *
 * @author Wang zhicheng
 * @date 2015年5月18日 上午8:48:08
 * @since 1.0.0
 */
@Repository
public class FormalCircuitKUDaoImpl extends MyBaseDao<FormalCircuitKU> implements IFormalCircuitKUDao {

	@Override
	public List<FormalCircuitKU> findByFC(FormalCircuit formalCircuit) {
		StringBuffer hql = new StringBuffer(" from FormalCircuitKU where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (!StringUtils.isEmpty(formalCircuit.getId())) {
			hql.append(" and formalCircuit.id = ?");
			params.add(formalCircuit.getId());
		}
		hql.append(" order by num asc ");
		return (List<FormalCircuitKU>) super.queryList(hql.toString(),
				params.toArray());
	}
}
