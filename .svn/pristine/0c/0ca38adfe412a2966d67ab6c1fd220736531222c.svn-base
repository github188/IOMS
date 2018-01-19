/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-7-24 下午7:57:53
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package mng.tests.cn.com.atnc.ioms.mng.acl.user;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.BaseUserInfo;
import cn.com.atnc.ioms.mng.acl.IDiscuzUserService;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;



/**
 * @author:HuangYijie
 * @date:2014-7-24 下午7:57:53
 * @version:1.0
 */

public class TestDiscuzService extends MyBaseTransationalTest{

	
	@Autowired
	private IDiscuzUserService discuzUserService;
	
	//@Test
	public void testDel() throws ServiceException{
		BaseUserInfo user=new BaseUserInfo();
		user.setLoginName("hhh");
		discuzUserService.deleteDiscuzMember(user);
	}

	@Test
	public void testAdd() throws ServiceException{
		BaseUserInfo user=new BaseUserInfo();
		user.setLoginName("hhh");
		user.setPswOrigin("123456");
		user.setEmail("hhh@test.com");
		discuzUserService.registerDiscuzMember(user);
	}
	//@Test
	public void testUpdate() throws ServiceException{
		BaseUserInfo user=new BaseUserInfo();
		user.setLoginName("hhh");
		user.setPswOrigin("111111");
		user.setEmail("hhh@test.com");
		discuzUserService.updateDiscuzMember(user);
	}
}
