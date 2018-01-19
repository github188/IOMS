/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:34:25
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.acl.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.acl.IRoleResourceDao;
import cn.com.atnc.ioms.entity.acl.Resource;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.RoleResource;

/**
 * 角色资源项关系Dao实现
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:34:25
 */
@Repository("RoleResourceDao")
public class RoleResourceDaoImpl extends MyBaseDao<RoleResource> implements
		IRoleResourceDao {

	@SuppressWarnings("unchecked")
	public List<Role> listRole(String resourceId) {

		Assert.hasText(resourceId);
		String hql = "select a.role from RoleResource a where a.resource.id =?";
		return (List<Role>) super.queryList(hql, resourceId);
	}

	@Override
	public RoleResource findByRoleResource(String roleId, String resourceId) {
		String hql = "from RoleResource where role.id=? and resource.id=?";
		List<?> list = super.pageList(hql, new Object[] { roleId, resourceId },
				1, 1);
		return (RoleResource) (list.size() > 0 ? list.get(0) : null);
	}

	@Override
	public int deleteByRole(String roleId) {
		String hql = "delete from RoleResource where role.id=?";
		return super.executeHql(hql, roleId);
	}

	@Override
	public long listCount(String resourceId) {
		String hql = "select count(id) from RoleResource where 1=1";
		List<Object> params = new ArrayList<Object>();
		if (StringUtils.hasText(resourceId)) {
			hql += " and resource.id=?";
			params.add(resourceId);
		}
		return super.querySize(hql, params.toArray());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> listResourceByRoles(String[] roleIds) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = "select distinct a.resource from " + clazz.getName()
				+ " a where a.role.id in :roleIds";
		params.put("roleIds", roleIds);
		return (List<Resource>) queryList(hql, params);
	}


}
