/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:35:17
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.acl.hibernate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.dao.acl.IUserRoleDao;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.systemmng.deptinfomng.DeptInfomationMng;
import cn.com.atnc.ioms.model.acl.UserQueryModel;

/**
 * 用户Dao接口实现
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:35:17
 */
@Repository("UserDao")
public class UseDaoImpl extends MyBaseDao<User> implements IUserDao {

	@Autowired
	private IUserRoleDao userRoleDao;
	
	@Override
	public User findByLoginName(String loginName) {
		return findByProperty("loginName", loginName);
	}

	// @Override
	public Pagination pagnQuery(String name, Boolean valid, int pageNo,
			int pageSize) {
		StringBuilder hql = new StringBuilder("from User where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (StringUtils.hasText(name)) {
			hql.append(" and (name like ? or loginName like ?)");
			params.add("%" + name + "%");
			params.add("%" + name + "%");
		}
		if (valid != null) {
			hql.append(" and valid=?");
			params.add(valid);
		}
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by  system desc,valid desc,name asc");
		return super.pageQuery(hql.toString(), params.toArray(), countHql,
				pageNo, pageSize);
	}

	public Pagination pagnQuery(UserQueryModel queryModel) {

		StringBuilder hql = new StringBuilder("from User where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (StringUtils.hasText(queryModel.getUserName())) {
			hql.append(" and (name like ? or loginName like ?)");
			params.add("%" + queryModel.getUserName() + "%");
			params.add("%" + queryModel.getUserName() + "%");
		}
		if (queryModel.getValid() != null) {
			hql.append(" and valid=?");
			params.add(queryModel.getValid());
		}
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by  system desc,valid desc,name asc");
		return super.pageQuery(hql.toString(), params.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());

	}

	@Override
	public long listCount(String roleId) {
		StringBuilder hql = new StringBuilder("from User where 1=1");
		List<Object> params = new ArrayList<Object>();
		if (StringUtils.hasText(roleId)) {
			hql.append(" and role.id=?");
			params.add(roleId);
		}
		return super.querySize(hql.toString(), params.toArray());
	}

	public void updateLastLoginTime(String loginName) {
		String hql = "update User set lastLoginTime=? where loginName = ? ";
		super.executeHql(hql,
				new Object[] { Calendar.getInstance(), loginName });
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUserByRoleName(String roleName) {
		String hql = "select a.user from UserRole a where a.role.name=? order by a.user.dept";
		return (List<User>) queryList(hql, roleName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsersOrderbyDep(User currentUser) {
		String hql = "from User where valid = true and id != ? order by dept desc";
		List<User> users = (List<User>) queryList(hql, currentUser.getId());
		if(CollectionUtils.isEmpty(users)) {
			return null;
		}
		//去除工程师
		List<User> results = new ArrayList<User>();
		Iterator<User> its = users.iterator();
		boolean flag = false;
		while(its.hasNext()) {
			User user = its.next();
			user.setRoles(userRoleDao.listRole(user.getId()));
			List<Role> roles = user.getRoles();
			if(CollectionUtils.isEmpty(roles)) {
				continue;
			}
			for(Role role : roles) {
				if(role.getName().equalsIgnoreCase("engineer")) {
					flag = true;
					break;
				}
			}
			if(flag) {
				flag = false;
				continue;
			}
			results.add(user);
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllOrderByDep() {
		String hql = "from User where valid = true order by dept desc";
		return (List<User>) queryList(hql);
	}
	
	/**
	 * 根据部门名称获取人员列表
	 * @author duanyanlin
	 * @date 2016年6月24日下午1:16:43
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllByDept(DeptInfomationMng dept)  {
		StringBuilder hql = new StringBuilder("from User where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if(dept != null){
			hql.append(" and deptinfo=?");
			params.add(dept);
		}
		return (List<User>) queryList(hql.toString(),params.toArray());
	}
}
