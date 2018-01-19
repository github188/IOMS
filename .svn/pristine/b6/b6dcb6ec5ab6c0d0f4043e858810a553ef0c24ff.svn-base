/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:27:52
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.acl;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.acl.Resource;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.RoleResource;

/**
 * 角色资源项关系dao接口
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:27:52
 */
public interface IRoleResourceDao extends IBaseDao<RoleResource> {

	/**
	 * 根据角色id查询对应资源
	 * 
	 * @param roleIds
	 * @return
	 * @author 付韶兴
	 * @update 2012-12-21 上午9:13:20
	 */
	public List<Resource> listResourceByRoles(String[] roleIds);

	/**
	 * 查找拥有某资源权限的角色列表
	 * 
	 * @author:huangyijie
	 * @date:2013-9-4 上午9:05:19
	 * @param resourceId
	 *            资源id
	 * @return List<Role> 角色列表
	 */
	public List<Role> listRole(String resourceId);

	/**
	 * 根据角色id，资源id，找到对应的角色-资源关系记录
	 * 
	 * @author:huangyijie
	 * @date:2013-9-4 上午9:07:45
	 * @param roleId
	 *            角色id
	 * @param resourceId
	 *            资源id
	 * @return RoleResource
	 */
	public RoleResource findByRoleResource(String roleId, String resourceId);

	/**
	 * 删除指定角色分配的所有权限
	 * 
	 * @author:huangyijie
	 * @date:2013-9-4 上午9:08:43
	 * @param roleId
	 *            角色id
	 * @return int
	 */
	public int deleteByRole(String roleId);

	/**
	 * 取得指定resourceID的记录数量
	 * 
	 * @param resourceId
	 * @return
	 */
	public long listCount(String resourceId);

}
