package cn.com.atnc.ioms.mng.basedata.equip.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.basedata.equip.IEquipDao;
import cn.com.atnc.ioms.dao.maintain.equip.IEquipNodeDao;
import cn.com.atnc.ioms.dao.maintain.equipmobile.IKuMobileDao;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.maintain.equip.EquipNode;
import cn.com.atnc.ioms.entity.maintain.equipmobile.KuMobile;
import cn.com.atnc.ioms.mng.basedata.equip.IEquipService;
import cn.com.atnc.ioms.model.basedata.EquipQueryModel;
import cn.com.atnc.ioms.model.maintain.equipmobile.KuMobileQueryModel;
import cn.com.atnc.ioms.model.maintain.equipnode.EquipNodeQueryModel;

/**
 *类说明
 *@author 潘涛
 *@date 2014-4-10	下午5:33:05
 *@version:1.0
 */
@Service("equipService")
public class EquipServiceImpl extends BaseService implements IEquipService {
	
	@Autowired
	private IEquipDao equipDao;
	@Autowired
	private IEquipNodeDao equipNodeDao;
	@Autowired
	private IKuMobileDao kuMobileDao;
	
	@Override
	public List<Equip> queryList(EquipQueryModel qm) {
		return this.equipDao.queryList(qm);
	}
	
	@SuppressWarnings("unchecked")
	public List<Equip> queryListGroup(EquipQueryModel qm) {
		EquipNodeQueryModel queryModel = new EquipNodeQueryModel();
		queryModel.setBureau(qm.getBureau());
		queryModel.setEqnameLike(qm.getName());
		//分页查询数据
		List<EquipNode> equipNodes = (List<EquipNode>) equipNodeDao.queryPage(
				queryModel).getResult();
		Set<Equip> equips = new HashSet<Equip>();
		if (CollectionUtils.isNotEmpty(equipNodes)) {
			for(EquipNode equipNode : equipNodes){
				equips.add(equipNode.getEquip());
			}
		}
		List<Equip> equip = new ArrayList<Equip>(equips);
		for(Equip eq : equip){
			//封装查询条件
			KuMobileQueryModel queryModel2 = new KuMobileQueryModel();
			queryModel2.setEquipId(eq.getId());
			//封装冗余条件
			List<KuMobile> kuMobiles = kuMobileDao.queryList(queryModel2);
			eq.setKuMobiles(kuMobiles);
		}
		return equip;
	}
	@Override
	public Pagination queryPage(EquipQueryModel qm) {
		return equipDao.queryPage(qm);
	}
	@Override
	public List<Equip> atmNoteList(EquipQueryModel qm) {
		return this.equipDao.atmNoteList(qm);
	}

	@Override
	public Equip findById(Serializable id) {
		return this.equipDao.findById(id);
	}
	
}
