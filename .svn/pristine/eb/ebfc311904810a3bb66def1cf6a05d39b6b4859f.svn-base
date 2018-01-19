package cn.com.atnc.ioms.dao.clientmng.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.clientmng.IClientCompanyDao;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.clientmng.ClientCompany;
import cn.com.atnc.ioms.entity.clientmng.ClientEquip;
import cn.com.atnc.ioms.model.clientmng.query.ClientEquipQueryModel;
import cn.com.atnc.ioms.model.clientmng.query.ClientQueryModel;
import cn.com.atnc.ioms.model.systemmng.clientcompany.ClientCompanyQueryModel;

/**
 * 类说明
 * 
 * @author 潘涛
 * @date 2014-3-19 下午3:48:59
 * @version:1.0
 */
@Repository("clientCompanyDao")
public class ClientCompanyDaoImpl extends MyBaseDao<ClientCompany> implements
		IClientCompanyDao {

	@Override
	public Pagination queryPage(ClientCompanyQueryModel qm) {
		StringBuffer hql=new StringBuffer(" from ClientCompany where 1=1 ");
		List<Object> params=new ArrayList<Object>();
		if(null!=qm.getBureau()){
			hql.append(" and bureau = ?");
			params.add(qm.getBureau());
		}if(!StringUtils.isEmpty(qm.getCompany())){
			hql.append(" and company like ?");
			params.add("%"+qm.getCompany()+"%");
		}if(null!=qm.getAddress()){
			hql.append(" and address = ?");
			params.add(qm.getAddress());
		}if(null!=qm.getPostcode()){
			hql.append(" and postcode = ?");
			params.add(qm.getPostcode());
		}
		//System.out.println("3");
		String countHql=super.COUNT_ID+hql.toString();
		hql.append(" order by bureau desc");
		//System.out.println("hql="+hql);
		return super.pageQuery(hql.toString(), params.toArray(), countHql, qm.getPageNo(), qm.getPageSize());
	}
	
	@Override
	public List<ClientCompany> queryList(ClientCompanyQueryModel qm) {
		StringBuilder hql = new StringBuilder(" from ClientCompany where 1=1");
		List<Object> params = new ArrayList<Object>();
		if (null!=qm.getBureau()) {
			hql.append(" and bureau = ?");
			params.add(qm.getBureau());
		}
		if (!StringUtils.isEmpty(qm.getCompany())) {
			hql.append(" and company = ?");
			params.add(qm.getCompany());
		}
		//System.out.println("test");
		return (List<ClientCompany>) super.queryList(hql.toString(), params.toArray());
		
	}
}
