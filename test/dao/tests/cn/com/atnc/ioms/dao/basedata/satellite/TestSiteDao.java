/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:43:52
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package dao.tests.cn.com.atnc.ioms.dao.basedata.satellite;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.NotTransactional;
import org.springframework.test.annotation.Rollback;

import cn.com.atnc.ioms.dao.basedata.atm.node.IAtmNodeDao;
import cn.com.atnc.ioms.dao.basedata.equip.IEquipDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao;
import cn.com.atnc.ioms.dao.basedata.satellite.ISatelliteSiteDao;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.enums.basedata.NetworkType;
import cn.com.atnc.ioms.model.basedata.satellite.site.SiteQueryModel;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:43:52
 */

public class TestSiteDao extends MyBaseTransationalTest {
	@Autowired
	private ISatelliteSiteDao dao;

	@Autowired
	private IKuNodeDao nodeDao;

	// @Test
	public void del() {
		nodeDao.deleteAll();
	}

	/**
	 * 测试增删改查FD
	 * 
	 * @author:huangyijie
	 * @date:2013-9-2 下午3:38:55 void
	 */
	@Test
	public void testADMS() {
		// 增加
		SiteQueryModel queryModel = new SiteQueryModel();
		queryModel.setCodeLike("B");
		echoList(dao.queryList(queryModel));
	}

	@Autowired
	private IEquipDao equipDao;
	@Autowired
	private IAtmNodeDao atmNodeDao;
	
	@Test
	@Rollback(value = false)
	public void test() {
		
		List<AtmNode> atmNodeList=new ArrayList<>();
		for(AtmNode node:atmNodeList){
			Equip equip=new Equip();
			equip.setId(node.getEquipId());
			equip.setCode(node.getAtmNodeCode());
			equip.setType(NetworkType.ATM);
			equip.setModel(node.getAtmNodeChassisType());
			equip.setName(node.getAtmNodeNameCn());
			System.out.println("-------");
			equipDao.save(equip);
		}
	}
}
