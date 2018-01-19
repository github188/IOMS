/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:41:34
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package dao.tests.cn.com.atnc.ioms.dao.acl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.ioms.dao.acl.IResourceDao;
import cn.com.atnc.ioms.dao.acl.IRoleDao;
import cn.com.atnc.ioms.dao.acl.IRoleResourceDao;
import cn.com.atnc.ioms.entity.acl.Resource;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.RoleResource;
import cn.com.atnc.ioms.enums.acl.ResourceType;
import cn.com.atnc.ioms.enums.acl.RoleType;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:41:34
 */
public class TestRoleResourceDao extends MyBaseTransationalTest {
	@Autowired
	private IResourceDao resourceDao;
	@Autowired
	private IRoleDao roleDao;

	@Autowired
	private IRoleResourceDao roleResourceDao;

	/**
	 * 测试增删改查
	 * 
	 * @author:huangyijie
	 * @date:2013-9-2 下午2:47:12 void
	 */
	// @Test
	public void testADUQ() {
		// 增加资源项
		Resource resource = new Resource();
		resource.setId("Index");
		resource.setName("首页");
		resource.setList(1);
		resource.setType(ResourceType.MENU);
		resource.setUrl("/index.do");
		resourceDao.saveOrUpdate(resource);
		// 增加角色项
		Role role = new Role();
		role.setId("user");
		role.setInfo("用户角色");
		role.setName("user");
		role.setSystem(RoleType.NORMAL);
		roleDao.saveOrUpdate(role);
		// 增加角色资源关系
		RoleResource rr = new RoleResource();
		rr.setResource(resource);
		rr.setRole(role);
		roleResourceDao.save(rr);
		echo(roleResourceDao.findById(rr.getId()));
		// 修改角色
		Role userRole = new Role();
		userRole.setId("use");
		userRole.setInfo("用户角色");
		userRole.setName("use");
		roleDao.saveOrUpdate(userRole);
		// 修改
		rr.setRole(userRole);
		roleResourceDao.saveOrUpdate(rr);
		echo(roleResourceDao.findById(rr.getId()));
		// 删除
		roleResourceDao.delete(rr);
		echo(roleResourceDao.findById(rr.getId()));

	}

	@Test
	public void testListRole() {
		echoList(roleResourceDao.listRole("index"));
		echoList(roleResourceDao.listResourceByRoles(new String[] { "admin" }));
		echoList(roleResourceDao.getAll());
	}
}
