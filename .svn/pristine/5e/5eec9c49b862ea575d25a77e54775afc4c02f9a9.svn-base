package dao.tests.cn.com.atnc.ioms.dao.basedata.atm.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



import cn.com.atnc.ioms.dao.basedata.atm.service.IAtmServiceDao;
import cn.com.atnc.ioms.dao.basedata.satellite.ISatelliteSiteDao;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.model.basedata.atm.service.AtmServiceQueryModel;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

public class TestAtmServiceDao  extends MyBaseTransationalTest {
	@Autowired
	private ISatelliteSiteDao dao;
	@Autowired
	private IAtmServiceDao atmServiceDao;
	
		
	
	@Test
	public void testADMS() {
	//	echoList(oduDao.queryPage(new OduQueryModel()).getResult());
		echoList(atmServiceDao.queryList(new AtmServiceQueryModel()));
	}
	
}
