/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:43:52
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package dao.tests.cn.com.atnc.ioms.dao.acl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.ioms.dao.acl.IRoleDao;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.enums.acl.RoleType;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:43:52
 */

public class TestRoleDao extends MyBaseTransationalTest {
	@Autowired
	private IRoleDao dao;

	/**
	 * 测试增删改查FD
	 * 
	 * @author:huangyijie
	 * @date:2013-9-2 下午3:38:55 void
	 */
//	@Test
	public void testADMS() {
		// 增加
		Role role = new Role();
		role.setId("user");
		role.setInfo("用户角色");
		role.setName("user");
		role.setSystem(RoleType.NORMAL);
		dao.saveOrUpdate(role);
		echo(dao.findById("user"));
		// 修改
		echo(dao.findById("user"));
		// 删除
		dao.delete(role);
		echo(dao.findById("user"));
	}
	@Test
	public void testQuery(){
		echoList(dao.queryPage("", 1, 10).getResult());
		echoList(dao.queryPage("", 2, 10).getResult());
	}
}
