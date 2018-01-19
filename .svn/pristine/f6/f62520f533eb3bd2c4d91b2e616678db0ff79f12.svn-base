package cn.com.atnc.ioms.dao.business.formalcircuit.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitATMDao;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitATM;


 /**
 * ATM正式电路申请表Dao接口实现类
 *
 * @author Wang zhicheng
 * @date 2015年5月18日 上午8:48:42
 * @since 1.0.0
 */
@Repository
public class FormalCircuitATMDaoImpl extends MyBaseDao<FormalCircuitATM> implements IFormalCircuitATMDao {

	@Override
	public List<FormalCircuitATM> findByFC(FormalCircuit formalCircuit) {
		StringBuffer hql = new StringBuffer(" from FormalCircuitATM where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (!StringUtils.isEmpty(formalCircuit.getId())) {
			hql.append(" and formalCircuit.id = ?");
			params.add(formalCircuit.getId());
		}
		hql.append(" order by num asc ");
		return (List<FormalCircuitATM>) super.queryList(hql.toString(),
				params.toArray());
	}

}
