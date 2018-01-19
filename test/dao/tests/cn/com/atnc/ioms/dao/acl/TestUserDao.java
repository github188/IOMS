/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:44:16
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package dao.tests.cn.com.atnc.ioms.dao.acl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.dao.acl.IUserRoleDao;
import cn.com.atnc.ioms.entity.acl.User;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:44:16
 */

public class TestUserDao extends MyBaseTransationalTest {
	@Autowired
	private IUserDao dao;
	@Autowired
	private IUserRoleDao userRoleDao;

//	@Test
	public void testADUQ() {
		//增加
		User user = new User();
		user.setName("用户员");
		user.setLoginName("admin");
		user.setId("admin");
		user.setSystem(true);
		PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		user.setPassword(passwordEncoder.encodePassword("admin", null));
		dao.saveOrUpdate(user);
		echo(dao.findById(user.getId()));
		//修改
		user.setName("系统管理员");
		dao.saveOrUpdate(user);
		echo(dao.findById(user.getId()));
		//删除
		dao.delete(user);
		echo(dao.findById(user.getId()));
	}
	
	@Test
	public void testQueryPage(){
//		UserQueryModel model=new UserQueryModel();
//		model.setExcludeSetted(true);
//		model.setExcludeUserId("admin");
//		model.setStatus(false);
//		echoList(dao.pagnQuery(model).getResult());
		echo(dao.findByLoginName("hyj"));
	}
}
