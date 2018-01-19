package mng.tests.cn.com.atnc.ioms.mng.clientmng;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.common.util.AssertUtil;
import cn.com.atnc.ioms.mng.clientmng.IClientManager;
import cn.com.atnc.ioms.model.clientmng.query.ClientQueryModel;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;


/**
 *类说明
 *@author 潘涛
 *@date 2014-5-30	上午10:13:29
 *@version:1.0
 */
public class TestClientService extends MyBaseTransationalTest {
	@Autowired
	private IClientManager clientManager;
	@Test
	public void testQueryList(){
		ClientQueryModel qm=new ClientQueryModel();
		qm.setLoginName("admin");
		AssertUtil.notEmpty(this.clientManager.queryList(qm));
				
	}
}
