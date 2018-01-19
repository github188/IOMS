/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:43:52
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package dao.tests.cn.com.atnc.ioms.dao.basedata.ku.node;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.cn.com.atnc.common.MyBaseTransationalTest;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao;
import cn.com.atnc.ioms.entity.basedata.ku.KuNode;
import cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel;

/**
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:43:52
 */

public class TestKuNodeDao extends MyBaseTransationalTest {

	@Autowired
	private IKuNodeDao kuNodeDao;

	/**
	 * 测试增删改查FD
	 * 
	 * @author:huangyijie
	 * @date:2013-9-2 下午3:38:55 void
	 */
	@Test
	public void testADMS() {
		// 增加
		KuNodeQueryModel qm = new KuNodeQueryModel();
		qm.setKuNodeNo("1");
		List<KuNode> txNodes = kuNodeDao.queryList(qm);
		for (KuNode node : txNodes) {
			System.out.println(node.getKuNodeNo());
		}
	}
}
