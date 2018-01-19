package mng.tests.cn.com.atnc.ioms.mng.basedata;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.ioms.dao.basedata.atm.node.IAtmNodeDao;
import cn.com.atnc.ioms.dao.basedata.equip.IEquipDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesNodeDao;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.entity.basedata.ku.KuNode;
import cn.com.atnc.ioms.entity.basedata.tes.TesNode;
import cn.com.atnc.ioms.enums.basedata.NetworkType;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * 类说明
 * 
 * @author 潘涛
 * @date 2014-5-22 下午3:50:13
 * @version:1.0
 */
public class TestEquipService extends MyBaseTransationalTest {

	@Autowired
	private IEquipDao equipDao;
	@Autowired
	private ITesNodeDao tesNodeDao;
	@Autowired
	private IKuNodeDao kuNodeDao;
	@Autowired
	private IAtmNodeDao atmNodeDao;

	@Test
	@Rollback(value = false)
	public void updateATM() {
		List<Equip> list = (List<Equip>) equipDao.queryList(
				"from Equip where type=?", NetworkType.ATM);
		if (CollectionUtils.isEmpty(list)) {
			System.out.println("list is null");
			return;
		}
		for (Equip equip : list) {
			List<AtmNode> atmNodelist = (List<AtmNode>) atmNodeDao.queryList(
					"from AtmNode where equip.id=?", equip.getId());
			if (CollectionUtils.isEmpty(atmNodelist)) {
				equipDao.delete(equip);
				continue;
			}
			if (atmNodelist.size() > 1) {
				System.err.println(equip.getId());
			}
			String update = "update Equip set code=?,name=? where id=?";
			equipDao.executeHql(update, new Object[] {
					atmNodelist.get(0).getAtmNodeCode(),
					atmNodelist.get(0).getAtmNodeNameCn(), equip.getId() });
		}

	}

	@Test
	@Rollback(value = false)
	public void updateTES() {
		List<Equip> list = (List<Equip>) equipDao.queryList(
				"from Equip where type=?", NetworkType.TES);
		if (CollectionUtils.isEmpty(list)) {
			System.out.println("list is null");
			return;
		}
		for (Equip equip : list) {
			List<TesNode> tesNodeList = (List<TesNode>) tesNodeDao.queryList(
					"from TesNode where equip.id=?", equip.getId());
			if (CollectionUtils.isEmpty(tesNodeList)) {
				equipDao.delete(equip);
				continue;
			}
			if (tesNodeList.size() > 1) {
				System.err.println(equip.getId());
			}
			String update = "update Equip set code=?,name=? where id=?";
			equipDao.executeHql(update, new Object[] {
					tesNodeList.get(0).getTesNodeCode(),
					tesNodeList.get(0).getTesNodeCode(), equip.getId() });
		}

	}

	@Test
	@Rollback(value = false)
	public void updateKU() {
		List<Equip> list = (List<Equip>) equipDao.queryList(
				"from Equip where type=?", NetworkType.KU);
		if (CollectionUtils.isEmpty(list)) {
			System.out.println("list is null");
			return;
		}
		for (Equip equip : list) {
			List<KuNode> kuNodelist = (List<KuNode>) kuNodeDao.queryList(
					"from KuNode where equip.id=?", equip.getId());
			if (CollectionUtils.isEmpty(kuNodelist)) {
				equipDao.delete(equip);
				continue;
			}
			if (kuNodelist.size() > 1) {
				System.err.println(equip.getId());
			}
			String update = "update Equip set code=?,name=? where id=?";
			equipDao.executeHql(update, new Object[] {
					kuNodelist.get(0).getKuNodeCode(),
					kuNodelist.get(0).getKuNodeNo(), equip.getId() });
		}

	}
}
