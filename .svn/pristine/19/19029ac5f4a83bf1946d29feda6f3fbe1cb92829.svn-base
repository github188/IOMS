package dao.tests.cn.com.atnc.ioms.dao.operstat.ku;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.common.util.TimeTools;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeStatusStatDao;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * 
 * @author:HuangYijie
 * @date:2014-5-28 上午9:06:04
 * @version:1.0
 */
public class TestKuNodeStatusStatDao extends MyBaseTransationalTest {

	@Autowired
	private IKuNodeStatusStatDao dao;

	@Test
	public void testPageQuery() {
		KuStatQueryModel qm = new KuStatQueryModel();
		qm.setStartTime(TimeTools.getCalendar(TimeTools.NORMAL_FORMAT,
				"2014-5-21 00:00:00"));
		echo(dao.queryPage(qm));
	}
}
