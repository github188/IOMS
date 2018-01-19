/* Copyright ? 2011 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2011-8-9 上午10:29:00
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.ioms.dao.acl.IResourceDao;
import cn.com.atnc.ioms.dao.acl.IRoleResourceDao;
import cn.com.atnc.ioms.entity.acl.Resource;
import cn.com.atnc.ioms.entity.acl.Role;

/**
 * 加载资源所需的角色信息
 * 
 * @author:HuangYijie
 * @date:2011-8-9 上午10:29:00
 * @version:1.0
 */
@Service("roleResourceLoader")
public class RoleResourceLoaderImpl extends AbstractService implements
		IRoleResourceLoader {
	@Autowired
	private IRoleResourceDao roleResourceDao;
	@Autowired
	private IResourceDao resourceDao;

	public Map<String, Collection<ConfigAttribute>> loadResourceDefine() {
		List<Resource> resources = resourceDao.getAll();
		Map<String, Collection<ConfigAttribute>> urlMap = new ConcurrentHashMap<String, Collection<ConfigAttribute>>();
		for (Resource resource : resources) {
			// 查询某资源可访问的角色
			List<Role> roles = roleResourceDao.listRole(resource.getId());
			if (CollectionUtils.isEmpty(roles)) {
				continue;
			}
			Collection<ConfigAttribute> value = new ArrayList<ConfigAttribute>();
			for (Role role : roles) {
				ConfigAttribute ca = new SecurityConfig(role.getName());// 资源对应的角色
				value.add(ca);

			}
			if (StringTools.hasText(resource.getUrl())) {
				urlMap.put(resource.getUrl(), value);
			}
			urlMap.put(resource.getId(), value);
		}
		return urlMap;
	}

	public Map<String, String> loadJSPElementIDAuthorities() {
		// TODO Auto-generated method stub

		logger.debug("************初始化jspAuthorities*************");
		Map<String, String> jspAuthorities = new ConcurrentHashMap<String, String>();
		List<Resource> resources = resourceDao.getAll();

		for (Resource resource : resources) {
			List<Role> roles = roleResourceDao.listRole(resource.getId());
			if (CollectionUtils.isEmpty(roles)) {
				continue;
			}

			List<String> roleAuthorities = new ArrayList<String>();
			for (Role role : roles) {
				roleAuthorities.add(role.getName());
			}
			jspAuthorities.put(resource.getId(),
					StringUtils.join(roleAuthorities.toArray(), ","));
		}

		return jspAuthorities;
	}
}
