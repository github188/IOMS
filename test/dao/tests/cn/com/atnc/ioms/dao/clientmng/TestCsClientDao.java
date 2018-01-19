package dao.tests.cn.com.atnc.ioms.dao.clientmng;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.common.util.AssertUtil;
import cn.com.atnc.ioms.dao.clientmng.IClientDao;
import cn.com.atnc.ioms.model.clientmng.query.ClientQueryModel;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 *类说明
 *@author 潘涛
 *@date 2014-3-19	下午4:48:59
 *@version:1.0
 */
public class TestCsClientDao extends MyBaseTransationalTest {
	@Autowired
	private IClientDao dao;
	@Test
	public void testQueryPageCsClientQueryModel() {
		AssertUtil.notNull(dao);
		ClientQueryModel qm=new ClientQueryModel(); 
		this.dao.queryPage(qm);
	}

	@Test
	public void testQueryListCsClientQueryModel() {
		ClientQueryModel qm=new ClientQueryModel();
		qm.setLoginName("admin");
		AssertUtil.notEmpty(this.dao.queryList(qm));
	}

}
