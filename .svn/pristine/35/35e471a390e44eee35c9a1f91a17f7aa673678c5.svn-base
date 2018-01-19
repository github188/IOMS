package cn.com.atnc.ioms.mng.acl;

import java.util.List;
import java.util.Map;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.Resource;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.model.acl.ColumnMenu;
import cn.com.atnc.ioms.model.acl.ConfRoleModel;
import cn.com.atnc.ioms.model.acl.RoleQueryModel;

/**
 * 
 * @author:HuangYijie
 * @date:2011-8-8 下午01:16:07
 * @version:1.0
 */
public interface IRoleManager {
	/**
	 * 添加一个角色
	 * 
	 * @param role
	 * @return
	 */
	public String add(Role role) throws ServiceException;

	/**
	 * 更新角色信息
	 * 
	 * @param role
	 */
	public void update(Role role) throws ServiceException;

	/**
	 * 根据id查找对应的记录
	 * 
	 * @param id
	 * @return
	 */
	public Role findById(String id);

	/**
	 * 获取所有角色
	 * 
	 * @author:huangyijie
	 * @date:2013-9-4 上午9:13:39
	 * @return List<Role>
	 */
	public List<Role> getAll();

	/**
	 * 删除角色，需要符合一定约束，否则异常
	 * 
	 * @param roleId
	 * @throws ManagerException
	 */
	public String delete(String roleId) throws ServiceException;

	/**
	 * 取得当前角色的权限配置(只返回是菜单的资源)
	 * 
	 * @param roleId
	 * @return
	 */
	public Map<Resource, List<ColumnMenu>> getCurrentConf(String roleId);

	/**
	 * 配置角色权限
	 * 
	 * @param conf
	 * @throws ManagerException
	 * @see {@link RoleResourceHolder#removeRoleMenus(String)}
	 */
	public void confRole(ConfRoleModel conf) throws ServiceException;

	/**
	 * 分页查询
	 * 
	 * @author:HuangYijie
	 * @Date:2013-8-21 下午3:28:55
	 * 
	 * @param model
	 * @return Pagination
	 */
	public Pagination queryPage(RoleQueryModel model);

	/**
	 * 检查名字是否重复
	 * 
	 * @author:HuangYijie
	 * @Date:2013-8-21 下午3:29:08
	 * 
	 * @param id
	 * @param name
	 * @return boolean
	 */
	public boolean isNameExist(String id, String name);

	/**
	 * 根据用户获取用户角色
	 * 
	 * @param user
	 * @return
	 * @author 付韶兴
	 * @update 2012-12-20 下午4:32:50
	 */
	public List<Role> getRoleByUser(String userId);

}
