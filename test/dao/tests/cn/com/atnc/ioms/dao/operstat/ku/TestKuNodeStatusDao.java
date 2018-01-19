package dao.tests.cn.com.atnc.ioms.dao.operstat.ku;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeStatusDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeStatusStatDao;
import cn.com.atnc.ioms.model.operstat.ku.KuBureauStatQueryModel;
import cn.com.atnc.ioms.model.operstat.ku.KuStatusQueryModel;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * 
 * @author:HuangYijie
 * @date:2014-5-28 上午9:06:04
 * @version:1.0
 */
public class TestKuNodeStatusDao extends MyBaseTransationalTest {

	@Autowired
	private IKuNodeStatusStatDao dao;

	@Autowired
	private IKuNodeStatusDao statusDao;

	private String latestStatId = "3988f379620d4ff5b6eca2996eb468b4";
	private String clientId = "ce40721996884199a45fae63bb3f585a";

	// @Test
	public void testPageQuery() throws ServiceException {
		KuStatusQueryModel qm = new KuStatusQueryModel();
		qm.setKuNodeStatusStatId(latestStatId);
		qm.setClientId(clientId);
		echo(statusDao.queryPage(qm));
	}

	@Test
	public void testGetLatestStat() {
		KuBureauStatQueryModel qm = new KuBureauStatQueryModel();
		qm.setKuStatusStatId(latestStatId);
		qm.setKuRxLevelLowerLimit(-3D);
		qm.setKuRxLevelTopLimit(3D);
		echoList(statusDao.getLatestStat(qm));
	}
}
