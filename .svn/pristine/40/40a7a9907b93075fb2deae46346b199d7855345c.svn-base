package cn.com.atnc.ioms.mng.acl.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.acl.IResourceDao;
import cn.com.atnc.ioms.dao.acl.IRoleDao;
import cn.com.atnc.ioms.dao.acl.IRoleResourceDao;
import cn.com.atnc.ioms.dao.acl.IUserRoleDao;
import cn.com.atnc.ioms.entity.acl.Resource;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.RoleResource;
import cn.com.atnc.ioms.entity.acl.UserRole;
import cn.com.atnc.ioms.enums.acl.ResourceType;
import cn.com.atnc.ioms.enums.acl.RoleType;
import cn.com.atnc.ioms.mng.acl.IRoleManager;
import cn.com.atnc.ioms.mng.security.IRoleResourceLoader;
import cn.com.atnc.ioms.mng.security.MyInvocationSecurityMetadataSourceService;
import cn.com.atnc.ioms.model.acl.ColumnMenu;
import cn.com.atnc.ioms.model.acl.ConfRoleModel;
import cn.com.atnc.ioms.model.acl.RoleQueryModel;

/**
 * 角色管理业务逻辑实现
 * 
 * @author:HuangYijie
 * @date:2011-8-8 下午01:15:31
 * @version:1.0
 */
@Service("roleManager")
public class RoleManagerImpl extends AbstractService implements IRoleManager {
	@Autowired
	private IRoleDao roleDao;
	@Autowired
	private IRoleResourceDao roleResourceDao;
	@Autowired
	private IResourceDao resourceDao;
	@Autowired
	private IUserRoleDao userRoleDao;
	@Autowired
	private IRoleResourceLoader roleResourceLoader;

	@Override
	@Transactional
	public String add(Role role) throws ServiceException {
		Assert.notNull(role);
		if (this.isNameExist(null, role.getName()))
			throw new ServiceException("不能添加重复的名称");
		role.setSystem(RoleType.NORMAL);
		return roleDao.save(role).toString();
	}

	@Override
	public Role findById(String id) {
		return roleDao.findById(id);
	}

	@Override
	@Transactional
	public String delete(String roleId) throws ServiceException {
		Role role = roleDao.findById(roleId);
		if (role == null) {
			throw new ServiceException("角色不存在");
		}
		// 系统角色不能删除
		if (!role.getSystem().equals(RoleType.NORMAL)) {
			throw new ServiceException("非自定义角色不能删除");
		}
		List<UserRole> userRoleList = userRoleDao.listUserRole(roleId);
		// 存在关联用户不能删除
		if (!CollectionUtils.isEmpty(userRoleList)) {
			StringBuilder errorMsg = new StringBuilder("该角色存在"+userRoleList.size()+"个关联用户");
			throw new ServiceException(errorMsg.toString());
		}
		// 删除关联的资源配置
		String roleName = role.getName();
		roleResourceDao.deleteByRole(roleId);
		roleDao.delete(role);
		return roleName;
	}

	@Override
	@Transactional
	public void update(Role role) throws ServiceException {
		Assert.notNull(role);
		if (!role.getSystem().equals(RoleType.NORMAL)) {
			throw new ServiceException("非自定义角色不能修改");
		}
		if (this.isNameExist(role.getId(), role.getName())) {
			throw new ServiceException("指定名称的角色已经存在:" + role.getName());
		}
		roleDao.update(role);
	}

	@Override
	public Map<Resource, List<ColumnMenu>> getCurrentConf(String roleId) {
		Map<Resource, List<ColumnMenu>> rs = new LinkedHashMap<Resource, List<ColumnMenu>>();
		List<Resource> menuResources = resourceDao.listResource(null,
				new ResourceType[] { ResourceType.MENU });
		for (Resource resource : menuResources) {

			List<ColumnMenu> colMenus = new ArrayList<ColumnMenu>();
			List<Resource> colResources = resourceDao.listResource(
					resource.getId(), null);
			if (CollectionUtils.isEmpty(colResources)) {
				resource.setHasChild(false);
			} else {
				resource.setHasChild(true);
			}
			resource.setHasResource(roleResourceDao.findByRoleResource(roleId,
					resource.getId()) != null);
			for (Resource colResource : colResources) {
				String colResourceId = colResource.getId();
				ColumnMenu menu = new ColumnMenu();
				menu.setColumnResource(colResource);
				menu.setHasColumnResource(roleResourceDao.findByRoleResource(
						roleId, colResourceId) != null);
				menu.setHasTabMenu(false);
				List<Resource> tabResources = resourceDao.listResource(
						colResourceId, new ResourceType[] { ResourceType.URL,
								ResourceType.DOM });
				if (!CollectionUtils.isEmpty(tabResources))// 标签菜单不为空
				{
					menu.setHasTabMenu(true);
					handleResources(tabResources, roleId);
				}
				menu.setTabResources(tabResources);
				colMenus.add(menu);
			}
			rs.put(resource, colMenus);

		}
		return rs;
	}

	private void handleResources(List<Resource> resources, String roleId) {
		for (Resource resource : resources) {
			RoleResource rr = roleResourceDao.findByRoleResource(roleId,
					resource.getId());
			if (rr != null)
				resource.setHasResource(true);
		}
	}

	@Override
	@Transactional(rollbackFor = { ServiceException.class })
	public void confRole(ConfRoleModel conf) throws ServiceException {
		Assert.notNull(conf);
		Role role = roleDao.findById(conf.getRoleId());
		if (role == null) {
			throw new ServiceException("角色不存在,可能已经被其他用户删除");
		}
		// if (role.isSystem())
		// throw new ServiceException("不能配置系统内置角色的权限");
		roleResourceDao.deleteByRole(conf.getRoleId());
		if (!ObjectUtils.isEmpty(conf.getMenuResourceIds())) {
			for (String resourceId : conf.getMenuResourceIds())// 配置主菜单
			{
				Resource resource = resourceDao.findById(resourceId);
				if (resource == null)
					throw new ServiceException("该资源不存在,请检查页面与数据库的配置是否一致");
				// 传进来的resourceIds可能重复
				if (roleResourceDao
						.findByRoleResource(role.getId(), resourceId) != null) {
					logger.debug(resourceId + "已存在RoleResource中");
					continue;
				}
				roleResourceDao.save(new RoleResource(role, resource));
				// // 增加底下的子资源
				// if (resource.getResourceType() == ResourceType.MENU)
				// addColumnUrlResources(resource.getId(), role);
				// else
				// logger.error("该资源的菜单类型不是主菜单：{}" , resource);

			}
		}
		if (!ObjectUtils.isEmpty(conf.getColResourceIds())) {
			for (String resourceId : conf.getColResourceIds())// 配置栏目菜单
			{
				Resource resource = resourceDao.findById(resourceId);
				if (resource == null)
					throw new ServiceException("该资源不存在,请检查页面与数据库的配置是否一致");
				// 传进来的resourceIds可能重复
				if (roleResourceDao
						.findByRoleResource(role.getId(), resourceId) != null) {
					logger.debug(resourceId + "已存在RoleResource中");
					continue;
				}
				roleResourceDao.save(new RoleResource(role, resource));
				// // 增加底下的子资源
				// if (resource.getResourceType() == ResourceType.COLUMN)
				// addUrlResources(resource.getId(), role);
				// else
				// logger.error("该资源的菜单类型不是栏目菜单：{}" , resource);

			}
		}
		if (!ObjectUtils.isEmpty(conf.getTabResourceIds())) {
			if (!ObjectUtils.isEmpty(conf.getTabResourceIds())) {
				for (String resourceId : conf.getTabResourceIds()) // 配置标签菜单
				{
					Resource resource = resourceDao.findById(resourceId);
					if (resource == null)
						throw new ServiceException("该资源不存在,请检查页面与数据库的配置是否一致");
					// 传进来的resourceIds可能重复
					if (roleResourceDao.findByRoleResource(role.getId(),
							resourceId) != null) {
						logger.debug(resourceId + "已存在RoleResource中");
						continue;
					}
					checkTabResource(resource, conf.getColResourceIds());
					roleResourceDao.save(new RoleResource(role, resource));
					// // 增加底下的子资源
					// if (resource.getResourceType() == ResourceType.URL)
					// addUrlResources(resource.getId(), role);
					// else
					// logger.error("该资源的菜单类型不是标签菜单：{}" , resource);
				}
			}
		}
		MyInvocationSecurityMetadataSourceService.urlMap.clear();
		MyInvocationSecurityMetadataSourceService.urlMap = roleResourceLoader
				.loadResourceDefine();
	}

	private void checkTabResource(Resource tabResource, String[] colResourceIds)
			throws ServiceException {
		boolean has = false;
		for (String colResourceId : colResourceIds) {
			if (colResourceId.equals(tabResource.getPid())) {
				has = true;
				break;
			}
		}
		if (!has)
			throw new ServiceException("没有选择该标签菜单对应的栏目菜单:"
					+ tabResource.getName() + "(" + tabResource.getUrl() + ")");
	}

	@Override
	public List<Role> getAll() {
		return roleDao.getAllInOrder(" order by list asc");
	}

	@Override
	public Pagination queryPage(RoleQueryModel model) {
		Assert.notNull(model);
		return roleDao.queryPage(model.getName(), model.getPageNo(), model.getPageSize());
	}

	@Override
	public boolean isNameExist(String id, String name) {
		Assert.notNull(name);
		List<Role> rs = roleDao.listByNameExcludeId(id, name);
		return rs.size() > 0;
	}

	@Override
	public List<Role> getRoleByUser(String userId) {
		return roleDao.listRoleByUserId(userId);
	}

}
