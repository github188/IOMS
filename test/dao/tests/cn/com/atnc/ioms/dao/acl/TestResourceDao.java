/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:41:34
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package dao.tests.cn.com.atnc.ioms.dao.acl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.cn.com.atnc.common.MyBaseTransationalTest;
import cn.com.atnc.ioms.dao.acl.IResourceDao;
import cn.com.atnc.ioms.entity.acl.Resource;
import cn.com.atnc.ioms.enums.acl.ResourceType;

/**
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:41:34
 */
public class TestResourceDao extends MyBaseTransationalTest {
	@Autowired
	private IResourceDao resourceDao;

	/**
	 * 测试增删改查
	 * 
	 * @author:huangyijie
	 * @date:2013-9-2 下午2:47:12 void
	 */
	@Test
	public void testADUQ() {
		//增加
		Resource resource = new Resource();
		resource.setId("Index");
		resource.setName("首页");
		resource.setList(1);
		resource.setType(ResourceType.MENU);
		resource.setUrl("/index.do");
		resourceDao.save(resource);
		echo(resourceDao.findById("Index"));
		//修改
		resource.setList(2);
		echo(resourceDao.findById("Index"));
		//删除
		resourceDao.delete(resource);
		echo(resourceDao.findById("Index"));
	}
}
