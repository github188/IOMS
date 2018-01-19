package mng.tests.cn.com.atnc.ioms.mng.operstat.ku;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.ioms.mng.operstat.ku.IKuStatusStatManager;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * 
 * @author:HuangYijie
 * @date:2014-5-28 上午9:06:04
 * @version:1.0
 */
public class TestKuStatusStatManager extends MyBaseTransationalTest {

	@Autowired
	private IKuStatusStatManager manager;

	@Test
	public void testGetLatestStat() {
		echoList(manager.getLatestStat());
	}
}
