package cn.com.atnc.ioms.dao.clientmng.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.clientmng.IClientDao;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.entity.clientmng.ClientCompany;
import cn.com.atnc.ioms.entity.clientmng.CsRole;
import cn.com.atnc.ioms.enums.clientmng.CsUserStatusEnum;
import cn.com.atnc.ioms.model.clientmng.query.ClientQueryModel;

/**
 * 类说明
 * 
 * @author 潘涛
 * @date 2014-3-19 下午3:48:59
 * @version:1.0
 */
@Repository("clientDao")
public class ClientDaoImpl extends MyBaseDao<Client> implements IClientDao {

	@Override
	public Pagination queryPage(ClientQueryModel qm) {
		StringBuffer hql = new StringBuffer(" from " + super.clazz.getName()
				+ " where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (!StringUtils.isEmpty(qm.getCompany())) {
			hql.append(" and newCompany.company like ?");
			params.add("%" + qm.getCompany() + "%");
		}
		if (!StringUtils.isEmpty(qm.getName())) {
			hql.append(" and name like ?");
			params.add("%" + qm.getName() + "%");
		}
		if (null != qm.getBureau()) {
			hql.append(" and bureau = ?");
			params.add(qm.getBureau());
		}
		if (!StringUtils.isEmpty(qm.getLoginName())) {
			hql.append(" and loginName = ?");
			params.add(qm.getLoginName());
		}
		if (!StringUtils.isEmpty(qm.getRoleName())) {
			hql.append(" and role.name =?");
			params.add(qm.getRoleName());
		}

		if (!ArrayUtils.isEmpty(qm.getRoleNames())) {
			StringBuffer roleName = new StringBuffer();
			for (String o : qm.getRoleNames()) {
				if (!StringUtils.isEmpty(o)) {
					roleName.append("'" + o.trim() + "',");
				}
			}
			if (roleName.length() > 0) {
				String param = roleName.toString().substring(0,
						roleName.length() - 1);
				hql.append(" and role.name in (" + param + ")");
			}
		}
		if (!StringUtils.isEmpty(qm.getPid())) {
			hql.append(" and pClient.id =? ");
			params.add(qm.getPid());
		}
		if (null != qm.getStatus()) {
			hql.append(" and status = ?");
			params.add(qm.getStatus());
		}
		String column = StringUtils.isEmpty(qm.getColumn()) ? "status" : qm
				.getColumn();
		String sort = StringUtils.isEmpty(qm.getSort()) ? "DESC" : qm.getSort();
		String countHql = super.COUNT_ID + hql.toString();
		hql.append(" order by role.name asc, status desc, bureau asc");
		return super.pageQuery(hql.toString(), params.toArray(), countHql,
				qm.getPageNo(), qm.getPageSize());
	}

	@Override
	public List<Client> queryList(ClientQueryModel qm) {
		StringBuffer hql = new StringBuffer(" from " + super.clazz.getName()
				+ " where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (null != qm.getNewCompany()) {
			hql.append(" and newCompany.company like ?");
			params.add("%" + qm.getNewCompany().getCompany() + "%");
		}
		if (!StringUtils.isEmpty(qm.getName())) {
			hql.append(" and name like ?");
			params.add("%" + qm.getName() + "%");
		}
		if (null != qm.getBureau()) {
			hql.append(" and bureau = ?");
			params.add(qm.getBureau());
		}
		if(!StringUtils.isEmpty(qm.getRoleName())){
			hql.append(" and role.name =?");
			params.add(qm.getRoleName());
		}
		if (!StringUtils.isEmpty(qm.getLoginName())) {
			hql.append(" and loginName = ?");
			params.add(qm.getLoginName());
		}
		if (!StringUtils.isEmpty(qm.getEmail())) {
			hql.append(" and email = ?");
			params.add(qm.getEmail());
		}
		if (!ArrayUtils.isEmpty(qm.getRoleNames())) {
			StringBuffer roleName = new StringBuffer();
			for (String o : qm.getRoleNames()) {
				if (!StringUtils.isEmpty(o)) {
					roleName.append("'" + o.trim() + "',");
				}
			}
			if (roleName.length() > 0) {
				String param = roleName.toString().substring(0,
						roleName.length() - 1);
				hql.append(" and role.name in (" + param + ")");
			}
		}
		if (!StringUtils.isEmpty(qm.getPid())) {
			hql.append(" and pClient.id =? ");
			params.add(qm.getPid());
		}
		if (null != qm.getStatus()) {
			hql.append(" and status = ?");
			params.add(qm.getStatus());
		}
		if (null != qm.getBlocking()) {
			hql.append(" and blocking = ?");
			params.add(qm.getBlocking());
		}

		return (List<Client>) super.queryList(hql.toString(), params.toArray());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClientCompany> queryCompanyList(ClientQueryModel qm) {
		StringBuffer hql = new StringBuffer(" from ClientCompany where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (null != qm.getBureau()) {
			hql.append(" and bureau = ?");
			params.add(qm.getBureau());
		}

		return (List<ClientCompany>) super.queryList(hql.toString(),
				params.toArray());
	}
	
	/**
	 * 查询注册用户列表
	 * @author duanyanlin
	 * @date 2016年4月19日 下午2:37:48
	 */
	@SuppressWarnings("unchecked")
	public List<Client> getTimeUserRegistedList(CsRole role, CsUserStatusEnum status){
		StringBuilder hql = new StringBuilder(" from Client where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if(role != null){
			hql.append(" and role.name = ?");
			params.add(role.getName());
		}
		if(status != null){
			hql.append(" and status = ?");
			params.add(status);
		}
		return (List<Client>) super.queryList(hql.toString(),
				params.toArray());
	}

}
