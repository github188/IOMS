/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:44:31
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package dao.tests.cn.com.atnc.ioms.dao.acl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import cn.com.atnc.ioms.dao.acl.IRoleDao;
import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.dao.acl.IUserRoleDao;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.acl.UserRole;
import cn.com.atnc.ioms.enums.acl.RoleType;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:44:31
 */
public class TestUserRoleDao extends MyBaseTransationalTest {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IRoleDao roleDao;
	@Autowired
	private IUserRoleDao userRoleDao;

	@Test
	public void testADUQ() {
		//增加用户
		User user = new User();
		user.setName("管理员");
		user.setLoginName("admin");
		user.setSystem(true);
		user.setId("admin");
		PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		user.setPassword(passwordEncoder.encodePassword("admin", null));
		userDao.saveOrUpdate(user);
		//增加角色
		Role role = new Role();
		role.setId("admin");
		role.setInfo("系统管理员");
		role.setSystem(RoleType.ADMIN);
		role.setName("admin");
		roleDao.saveOrUpdate(role);
		//增加用户角色
		UserRole ur = new UserRole();
		ur.setId("1");
		ur.setRole(role);
		ur.setUser(user);
		userRoleDao.saveOrUpdate(ur);
		//查找
		echo(userRoleDao.findById(ur.getId()));
		//删除
		userRoleDao.delete(ur);
		echo("删后查询userRole："+userRoleDao.findById(ur.getId()));
	}
}
