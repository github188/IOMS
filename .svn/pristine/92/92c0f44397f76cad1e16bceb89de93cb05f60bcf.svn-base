/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:32:06
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.acl.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.acl.IRoleDao;
import cn.com.atnc.ioms.entity.acl.Role;

/**
 * 用户角色Dao hibernate 实现
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:32:06
 */
@Repository("RoleDao")
public class RoleDaoImpl extends MyBaseDao<Role> implements IRoleDao {

	@Override
	public Pagination queryPage(String name, int pageNo, int pageSize)
	{
		StringBuilder hql = new StringBuilder("from Role where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringTools.hasText(name))
		{
			hql.append(" and name like:nameLike");
			params.put("nameLike","%"+name+"%");
		}
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by system desc,name asc");
		return super.pageQuery(hql.toString(), params, countHql,
				pageNo, pageSize);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Role> listByNameExcludeId(String id, String name)
	{
		StringBuilder hql = new StringBuilder("from Role where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (StringUtils.hasText(id))
		{
			hql.append(" and id<>?");
			params.add(id);
		}
		if (StringUtils.hasText(name))
		{
			hql.append(" and name=?");
			params.add(name);
		}
		return (List<Role>) super.queryList(hql.toString(), params.toArray());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> listRoleByUserId(String userId)
	{
		String hql = "select a.role from UserRole a where a.user.id=? order by a.role.id";
		return (List<Role>) queryList(hql, userId);
	}

}
