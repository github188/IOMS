/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:43:52
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package dao.tests.cn.com.atnc.ioms.dao.basedata.satellite;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.NotTransactional;


import cn.com.atnc.ioms.dao.basedata.antenna.IAntennaDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao;
import cn.com.atnc.ioms.dao.basedata.satellite.ISatelliteSiteDao;
import cn.com.atnc.ioms.model.basedata.satellite.AntennaQueryModel;
import cn.com.atnc.ioms.model.basedata.satellite.site.SiteQueryModel;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:43:52
 */

public class TestAntennaDao extends MyBaseTransationalTest {
	@Autowired
	private ISatelliteSiteDao dao;
	@Autowired
	private IAntennaDao antennaDao;
	
	

	/**
	 * 测试增删改查FD
	 * 
	 * @author:huangyijie
	 * @date:2013-9-2 下午3:38:55 void
	 */
	@Test
	public void testADMS() {
		//echoList(antennaDao.queryPage(new AntennaQueryModel()).getResult());
		echoList(antennaDao.getAll());
	}
}
