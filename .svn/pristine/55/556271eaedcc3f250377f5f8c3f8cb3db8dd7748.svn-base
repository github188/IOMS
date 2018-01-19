/* Copyright ? 2011 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2011-10-15 上午10:33:05
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */
package cn.com.atnc.ioms.mng.acl.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.common.util.file.ProjectFilePath;
import cn.com.atnc.ioms.dao.acl.IResourceDao;
import cn.com.atnc.ioms.dao.acl.IRoleResourceDao;
import cn.com.atnc.ioms.entity.acl.Resource;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.acl.ResourceType;
import cn.com.atnc.ioms.mng.acl.IResourceManager;
import cn.com.atnc.ioms.mng.acl.IRoleManager;
import cn.com.atnc.ioms.mng.acl.IRoleResourceManager;
import cn.com.atnc.ioms.model.acl.ResourceQueryModel;

/**
 * 资源项管理业务逻辑实现
 * 
 * @author:HuangYijie
 * @date:2011-10-15 上午10:35:05
 * @version:1.0
 */
@Service("resourceManager")
public class ResourceManagerImpl extends AbstractService implements
		IResourceManager {
	private Map<String, Resource> resources = new ConcurrentHashMap<String, Resource>();
	@Autowired
	private IResourceDao resourceDao;
	@Autowired
	private IRoleResourceDao roleResourceDao;
	@Autowired
	private IRoleManager roleManager;
	@Autowired
	private IRoleResourceManager roleResourceManager;

	@PostConstruct
	public void init() {
		List<Resource> list = resourceDao.getAll();
		for (Resource r : list) {
			logger.debug("url:{},id:{},pid:{}",
					new Object[] { r.getUrl(), r.getId(), r.getPid() });
			if (StringUtils.hasText(r.getUrl())) {
				resources.put(r.getUrl(), r);
			} else {
				resources.put(r.getId(), r);
			}
		}
		logger.info("资源URL成功加载至内存:" + resources.size());
	}

	private void reInit() {
		resources.clear();
		init();
	}

	@Override
	public Resource getResourceByUrl(String url) {
		return resources.get(url);
	}

	public Resource getColumnResourceByUrl(String url) {

		Set<String> keys = resources.keySet();
		for (String key : keys) {
			if (!StringUtils.hasText(key)) {
				continue;
			}
			if (key.indexOf(".do") < 0) {
				continue;
			}

			if (url.contains(key)) {
				return resources.get(key);
			}
		}
		return null;
	}

	public Resource getParentByUrl(String url) {
		Resource child = getColumnResourceByUrl(url);
		if (child == null) {
			return null;
		}
		if (!StringTools.hasText(child.getPid())) {
			return null;
		}
		Set<String> keys = resources.keySet();
		for (String key : keys) {
			if (!StringUtils.hasText(key)) {
				continue;
			}
			if (resources.get(key).getId().equals(child.getPid())) {
				return resources.get(key);
			}
		}
		return null;
	}

	public Resource getGrandpaByUrl(String url) {
		Resource parent = getParentByUrl(url);
		if (parent == null) {
			return null;
		}
		if (!StringTools.hasText(parent.getPid())) {
			return null;
		}
		Set<String> keys = resources.keySet();
		for (String key : keys) {
			if (!StringUtils.hasText(key)) {
				continue;
			}
			if (resources.get(key).getId().equals(parent.getPid())) {
				return resources.get(key);
			}
		}
		return null;
	}

	@Override
	@Transactional
	public String add(Resource resource) throws ServiceException {
		Assert.notNull(resource);
		if (StringTools.hasText(resource.getUrl())
				&& getResourceByUrl(resource.getUrl()) != null) {
			throw new ServiceException("该URI的资源已经存在:" + resource.getUrl());
		}
		String pid = resource.getPid();
		if (StringUtils.hasText(pid) && resourceDao.findById(pid) == null) {
			throw new ServiceException("指定的父资源不存在.");
		}
		String id = resourceDao.save(resource).toString();
		reInit();
		return id;
	}

	@Override
	@Transactional
	public void update(Resource resource) throws ServiceException {
		Assert.notNull(resource);
		Resource po = resourceDao.findById(resource.getId());
		if (po == null) {
			throw new ServiceException("指定的资源不存在:" + resource.getUrl());
		}
		po.setName(resource.getName());
		po.setList(resource.getList());
		// po.setUrl(resource.getUrl());//默认不可修改url
		resourceDao.update(po);
		reInit();
	}

	@Override
	@Transactional
	public void delete(String id) throws ServiceException {
		Resource resource = resourceDao.findById(id);
		if (resource == null)
			return;
		ResourceQueryModel queryModel = new ResourceQueryModel();
		queryModel.setPid(id);
		queryModel.setpType(resource.getType());
		List<Resource> columnList = this.listByParent(queryModel);
		if (!CollectionUtils.isEmpty(columnList) && columnList.size() > 0) {
			throw new ServiceException("该资源下存在子资源，请先删除！");
		}
		if (roleResourceDao.listCount(id) > 0) {
			throw new ServiceException("该资源已经被角色引用，请先修改角色的权限配置.");
		}
		int count = resourceDao.deleteNotMenu(id, ResourceType.DOM);
		logger.debug("删除该资源下的页面元素资源,共计" + count);

		int urlCount = resourceDao.deleteNotMenu(id, ResourceType.URL);
		logger.debug("删除该资源下的操作菜单,共计" + urlCount);

		resourceDao.delete(resource);
		File file = new File(ProjectFilePath.getProjectPath() + "/images/menu/"
				+ id + ".png");
		if (file.exists() && !file.delete()) {
			logger.error("delete file error:" + file.getAbsolutePath());
		}
		reInit();
	}

	@Override
	public Pagination queryPage(ResourceQueryModel queryModel) {

		if (queryModel.getpType() != null) {
			switch (queryModel.getpType()) {
			case ROOT:
				queryModel.setTypes(new ResourceType[] { ResourceType.MENU });
				return resourceDao.queryPage(queryModel);
			case MENU:
				queryModel.setTypes(new ResourceType[] { ResourceType.COLUMN });
				return resourceDao.queryPage(queryModel);
			case COLUMN:
				queryModel.setTypes(new ResourceType[] { ResourceType.URL,
						ResourceType.DOM });
				return resourceDao.queryPage(queryModel);
			default:
				return resourceDao.queryPage(queryModel);
			}
		}
		return resourceDao.queryPage(queryModel);
	}

	@Override
	public List<Resource> listByParent(ResourceQueryModel queryModel) {
		// 指定pid查找子菜单项
		if (StringUtils.hasText(queryModel.getPid())) {
			List<Resource> childResourceList = new ArrayList<Resource>();
			if (queryModel.getType() == null) {
				childResourceList = resourceDao.listResource(
						queryModel.getPid(), null);
			}
			if (queryModel.getpType().equals(ResourceType.MENU)) {
				childResourceList = resourceDao.listResource(
						queryModel.getPid(),
						new ResourceType[] { ResourceType.COLUMN });
				for (Resource col : childResourceList) {
					if (resourceDao.querySize(col.getId(), new ResourceType[] {
							ResourceType.URL, ResourceType.DOM }) > 0) {
						col.setHasChild(true);

					}
				}
			}
			if (queryModel.getpType().equals(ResourceType.COLUMN)) {
				childResourceList = resourceDao.listResource(
						queryModel.getPid(), new ResourceType[] {
								ResourceType.URL, ResourceType.DOM });
			}
			return childResourceList;
		}
		// 初始化资源树
		List<Resource> colMenuResourceList = resourceDao
				.listColMenuResource(queryModel.getType());
		for (Resource col : colMenuResourceList) {
			if (resourceDao.querySize(col.getId(),
					new ResourceType[] { ResourceType.COLUMN }) > 0) {
				col.setHasChild(true);
			}
		}
		return colMenuResourceList;
	}

	@Override
	public Resource findById(String id) {
		return resourceDao.findById(id);
	}

	@Override
	public Set<Resource> getResourceByUser(User user) {
		Set<Resource> res = new HashSet<Resource>();
		if (user == null) {
			return res;
		}
		List<Role> roles = roleManager.getRoleByUser(user.getId());
		res.addAll(roleResourceManager.listResourceByRoles(roles));
		return res;
	}

	@Override
	public List<Resource> queryMenu(ResourceQueryModel queryModel) {
		// TODO Auto-generated method stub
		return resourceDao.queryMenu(queryModel);
	}

	@Override
	public List<Resource> querySubMenu(ResourceQueryModel queryModel) {
		// TODO Auto-generated method stub
		return resourceDao.querySubMenu(queryModel);
	}

}
