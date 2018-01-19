package cn.com.atnc.ioms.dao.basedata.atm.type.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.atm.type.IAtmTypeDao;
import cn.com.atnc.ioms.entity.basedata.atm.type.AtmType;
import cn.com.atnc.ioms.model.basedata.atm.type.AtmTypeQueryModel;

/**
 *类说明
 *@author 潘涛
 *@date 2014-8-27	上午10:03:05
 *@version:1.0
 */
@Repository("atmTypeDao")
public class AtmTypeDaoImpl extends MyBaseDao<AtmType> implements
IAtmTypeDao {
	
	@Override
	public Pagination queryPage(AtmTypeQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from AtmType where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (queryModel.getId() != null) {
			hql.append(" and id =:id");
			params.put("id", queryModel.getId());
		}
		if (StringUtils.hasText(queryModel.getServiceTypeLike())) {
			hql.append(" and serviceType like:serviceTypeLike");
			params.put("serviceTypeLike", "%" + queryModel.getServiceTypeLike() + "%");
		}
		if (queryModel.getServiceType() != null) {//类型
			hql.append(" and serviceType =:serviceType");
			params.put("serviceType", queryModel.getServiceType());
		}
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by serviceType asc");
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}
	
	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao#queryList(cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AtmType> queryList(AtmTypeQueryModel queryModel) {
		System.out.println("test");

		StringBuilder hql = new StringBuilder("from AtmType where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (queryModel.getId() != null) {
			hql.append(" and id =:id");
			params.put("id", queryModel.getId());
		}
		if (queryModel.getServiceType() != null) {//类型
			hql.append(" and serviceType =:serviceType");
			params.put("serviceType", queryModel.getServiceType());
		}
		if (StringUtils.hasText(queryModel.getServiceTypeLike())) {
			hql.append(" and serviceType like:serviceTypeLike");
			params.put("serviceTypeLike", "%" + queryModel.getServiceTypeLike() + "%");
		}
		hql.append(" order by serviceType asc");
		return (List<AtmType>) super.queryList(hql.toString(), params);		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<AtmType> serviceTypeList(AtmTypeQueryModel am) {
		//System.out.println("test2");

		StringBuilder hql = new StringBuilder("from AtmType where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		return (List<AtmType>) super.queryList(hql.toString(), params);	
	}
}
