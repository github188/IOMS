package dao.tests.cn.com.atnc.ioms.dao.basedata;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.ioms.dao.basedata.atm.node.IAtmNodeDao;
import cn.com.atnc.ioms.dao.basedata.equip.IEquipDao;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.enums.basedata.NetworkType;
import cn.com.atnc.ioms.model.basedata.EquipQueryModel;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * 类说明
 * 
 * @author 潘涛
 * @date 2014-4-10 下午5:49:03
 * @version:1.0
 */
public class TestEquipDao extends MyBaseTransationalTest {
	@Autowired
	private IEquipDao equipDao;
	@Autowired
	private IAtmNodeDao atmNodeDao;

	@Test
	@Rollback(value = false)
	public void test() {

		List<AtmNode> atmNodeList = atmNodeDao.getAll();
		for (AtmNode node : atmNodeList) {
			Equip equipInDb=equipDao.findById(node.getEquipId());
			
			if (equipInDb==null) {
				Equip equip = new Equip();
				equip.setId(node.getEquipId());
				equip.setCode(node.getAtmNodeCode());
				equip.setType(NetworkType.ATM);
				equip.setModel(node.getAtmNodeChassisType());
				equip.setName(node.getAtmNodeNameCn());
				System.out.println("-------"+equip.getCode());
				equipDao.saveOrUpdate(equip);
			}
		}

	}

}
