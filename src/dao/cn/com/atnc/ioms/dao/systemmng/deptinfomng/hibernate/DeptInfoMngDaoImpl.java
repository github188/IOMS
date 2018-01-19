package cn.com.atnc.ioms.dao.systemmng.deptinfomng.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.systemmng.deptinfomng.IDeptInfoMngDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.systemmng.deptinfomng.DeptInfomationMng;
import cn.com.atnc.ioms.model.acl.UserQueryModel;
import cn.com.atnc.ioms.model.systemmng.deptinfomng.DeptInfoQueryModel;

@Repository("IDeptInfoMngDao")
public class DeptInfoMngDaoImpl extends MyBaseDao<DeptInfomationMng> implements IDeptInfoMngDao{

	@Override
	public Pagination queryPage(DeptInfoQueryModel queryModel) {
		
		StringBuilder hql = new StringBuilder();
		hql.append(" from DeptInfomationMng where  1=1");
		
		Map<String, Object> queryParams = new HashMap<String, Object>();
		if(!StringUtils.isEmpty(queryModel.getDeptName())){
			hql.append(" and deptName like:name");
			queryParams.put("name", "%"+queryModel.getDeptName()+"%");
		}
		
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		hql.append(" order by creatime desc");
		
		return super.pageQuery(hql.toString(), queryParams, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public List<DeptInfomationMng> getDeptByType(DeptInfoQueryModel queryModel) {
		
		StringBuilder hql = new StringBuilder();
		hql.append(" from DeptInfomationMng where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
	    hql.append("and deptType='BU' and parentInfo='0' ");

		return (List<DeptInfomationMng>) super.queryList(hql.toString(),params);
		
	}

	public List<DeptInfomationMng> getDeptByParentInfo(DeptInfoQueryModel queryModel) {
		
		StringBuilder hql = new StringBuilder();
		hql.append(" from DeptInfomationMng where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();

	    if(queryModel.getParentInfo()!=null)
	    {
	    	hql.append("and parentInfo=:parentInfo");
	    	params.put("parentInfo",queryModel.getParentInfo()); 
	    }

	    hql.append(" order by creatime desc");

		return (List<DeptInfomationMng>) super.queryList(hql.toString(),params);
		
	}
	public List<User> getUserListByDept(UserQueryModel queryModel){
		StringBuilder hql = new StringBuilder();
		hql.append(" from User where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();

	    if(queryModel.getDeptinfo()!=null)
	    {
	    	hql.append("and deptinfo=:deptInfo");
	    	params.put("deptInfo",queryModel.getDeptinfo()); 
	    }

	    hql.append(" order by name asc");

		return (List<User>) super.queryList(hql.toString(),params);
	}

}
