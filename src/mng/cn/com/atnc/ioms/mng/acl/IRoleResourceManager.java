package cn.com.atnc.ioms.mng.acl;

import java.util.List;

import cn.com.atnc.ioms.entity.acl.Resource;
import cn.com.atnc.ioms.entity.acl.Role;

/**
 * 
 * @author:HuangYijie
 * @date:2011-8-8 下午01:16:03
 * @version:1.0
 */
public interface IRoleResourceManager
{

	/**
	 * 根据角色id数组查找对应的资源
	 * 
	 * @param roleIds
	 * @return
	 * @author 付韶兴
	 * @update 2012-12-21 上午9:03:10
	 */
	public List<Resource> listResourceByRoles(List<Role> roles);
}
