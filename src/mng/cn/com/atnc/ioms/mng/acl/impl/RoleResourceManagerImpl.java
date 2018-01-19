package cn.com.atnc.ioms.mng.acl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.acl.IRoleResourceDao;
import cn.com.atnc.ioms.entity.acl.Resource;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.mng.acl.IRoleResourceManager;

/**
 * 角色与资源项关系业务逻辑实现
 * 
 * @author:HuangYijie
 * @date:2011-8-8 下午01:15:39
 * @version:1.0
 */
@Service("roleResourceManager")
public class RoleResourceManagerImpl extends AbstractService implements
		IRoleResourceManager {
	@Autowired
	private IRoleResourceDao roleResourceDao;


	@Override
	public List<Resource> listResourceByRoles(List<Role> roles) {
		String[] ids = new String[roles.size()];
		Role r;
		for (int i = 0; i < roles.size(); i++) {
			r = roles.get(i);
			ids[i] = r.getId();
		}
		return roleResourceDao.listResourceByRoles(ids);
	}

}
