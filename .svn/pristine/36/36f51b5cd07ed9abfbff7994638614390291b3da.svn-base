/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:36:07
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.acl.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.acl.IUserRoleDao;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.acl.UserRole;
import cn.com.atnc.ioms.enums.acl.RoleSourceEnum;
import cn.com.atnc.ioms.model.acl.UserQueryModel;
import cn.com.atnc.ioms.model.acl.UserRoleQueryModel;

/**
 * 用户角色关系Dao接口实现
 * @author WangLingbin
 * @date 2015年11月4日 下午1:24:08
 * @since 1.0.0
 */
@Repository("UserRoleDao")
public class UserRoleDaoImpl extends MyBaseDao<UserRole> implements IUserRoleDao {


	@SuppressWarnings("unchecked")
	@Override
	public List<Role> listRole(String userId) {
		Assert.hasText(userId);
		String hql = "select a.role from UserRole a where a.user.id=?";
		return (List<Role>) super.queryList(hql, userId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> listRolesByRoleSource(String userId, RoleSourceEnum roleSource) {
		Assert.hasText(userId);
		StringBuilder hql = new StringBuilder("select a.role from UserRole a where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if(StringUtils.hasText(userId)) {
			hql.append(" and a.user.id = ?");
			params.add(userId);
		}
		if(!ObjectUtils.equals(roleSource, null)) {
			hql.append(" and a.roleSource = ?");
			params.add(roleSource);
		}
		return (List<Role>) super.queryList(hql.toString(), params.toArray());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findTransferByRoleSource(String userId, RoleSourceEnum roleSource) {
		StringBuilder hql = new StringBuilder("select a.transfer from UserRole a where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if(StringUtils.hasText(userId)) {
			hql.append(" and a.user.id = ?");
			params.add(userId);
		}
		if(!ObjectUtils.equals(roleSource, null)) {
			hql.append(" and a.roleSource = ?");
			params.add(roleSource);
		}
		return (List<User>) super.queryList(hql.toString(), params.toArray());
	}
	
	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ptms.dao.acl.IUserRoleDao#deleteByUserId(java.lang.String)
	 */
	@Override
	public int deleteByUserId(String userId) {
		String hql = "delete from UserRole where user.id=?";
		return super.executeHql(hql, userId);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> listUserRole(String roleId) {
		StringBuilder hql = new StringBuilder("from UserRole where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(roleId)) {
			hql.append(" and role.id =:roleId");
			params.put("roleId", roleId);
		}
		return (List<UserRole>) super.queryList(hql.toString(), params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> findByRoleName(String roleName) {
		List<UserRole> userRoles = (List<UserRole>) queryList("from UserRole where role.name=?", roleName);
		return userRoles;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> findByMulti(User user, RoleSourceEnum roleSource, User transfer) {
		StringBuilder hql = new StringBuilder("from UserRole where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if(!ObjectUtils.equals(user, null)) {
			hql.append(" and user = ?");
			params.add(user);
		}
		if(!ObjectUtils.equals(roleSource, null)) {
			hql.append(" and roleSource = ?");
			params.add(roleSource);
		}
		if(!ObjectUtils.equals(transfer, null)) {
			hql.append(" and transfer = ?");
			params.add(transfer);
		}
		hql.append(" order by user desc");
		return (List<UserRole>) queryList(hql.toString(), params.toArray());
	}

	@Override
	public Pagination pageQuery(UserQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from UserRole where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (StringUtils.hasText(queryModel.getUserName())) {
			hql.append(" and (user.name like ? or user.loginName like ?)");
			params.add("%" + queryModel.getUserName() + "%");
			params.add("%" + queryModel.getUserName() + "%");
		}
		if (queryModel.getValid() != null) {
			hql.append(" and user.valid=?");
			params.add(queryModel.getValid());
		}
		if(queryModel.getCurrentUser() != null) {
			hql.append("and transfer = ? and roleSource = ?");
			params.add(queryModel.getCurrentUser());
			params.add(RoleSourceEnum.TRANSFER);
		}
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by user.system desc,user.valid desc,user.name asc");
		return super.pageQuery(hql.toString(), params.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> findByMulti(User user, List<Role> roles) {
		StringBuilder hql = new StringBuilder("from UserRole where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if(!ObjectUtils.equals(user, null)) {
			hql.append(" and user = ?");
			params.add(user);
		}
		if(CollectionUtils.isNotEmpty(roles)) {
			hql.append(" and role in ( ");
			for(Role role : roles) {
				hql.append("?,");
				params.add(role);
			}
			hql.deleteCharAt(hql.length()-1);
			hql.append(")");
		}
		return (List<UserRole>) super.queryList(hql.toString(), params.toArray());
	}

	@Override
	public String getTransferInfos(User user) {
		String transferInfo = null;
		List<Role> transferRoles = user.getTransferRoles();
		if(CollectionUtils.isNotEmpty(transferRoles)) {
			List<UserRole> userRoles = this.findByMulti(user, transferRoles);
			if(CollectionUtils.isNotEmpty(userRoles)) {
				User transfer = userRoles.get(0).getTransfer();
				transferInfo = "<代" + transfer.getName() + ">";
			}
		}
		return transferInfo;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> queryList(UserRoleQueryModel qm){
		
		StringBuilder hql = new StringBuilder("from UserRole where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if(!org.apache.commons.lang.StringUtils.isEmpty(qm.getUserId())) {
			hql.append(" and user.id = ?");
			params.add(qm.getUserId());
		}
		if(!org.apache.commons.lang.StringUtils.isEmpty(qm.getRoleId())) {
			hql.append(" and role.id = ?");
			params.add(qm.getRoleId());
		}
		if(!ObjectUtils.equals(qm.getRoleSource(),null)) {
			hql.append(" and roleSource = ?");
			params.add(qm.getRoleSource());
		}
		if(!org.apache.commons.lang.StringUtils.isEmpty(qm.getTransfer())) {
			hql.append(" and transfer.id = ?");
			params.add(qm.getTransfer());
		}
		return (List<UserRole>) super.queryList(hql.toString(), params.toArray());
	}
}
