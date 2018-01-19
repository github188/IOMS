/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName MaintainEquipManagerImpl.java
 * @PackageName:cn.com.atnc.ioms.mng.maintain.equip.impl
 * @author ku
 * @date 2015年4月30日上午11:10:20
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.maintain.equip.impl;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.maintain.equip.IEquipNodeDao;
import cn.com.atnc.ioms.dao.maintain.equip.IMaintainEquipDao;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.maintain.equip.EquipNode;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.mng.basedata.equip.IEquipService;
import cn.com.atnc.ioms.mng.maintain.equip.IEquipNodeManager;
import cn.com.atnc.ioms.mng.maintain.equip.IMaintainEquipManager;
import cn.com.atnc.ioms.model.maintain.equipnode.EquipNodeQueryModel;

 /**
 * 此处添加类MaintainEquipManagerImpl的描述信息
 *
 * @author wangzhicheng
 * @date 2015-5-4 下午4:32:24
 * @since 1.0.0
 */
@Service
@Repository
public class EquipNodeManagerImpl implements IEquipNodeManager {

	@Autowired
	private IEquipNodeDao equipNodeDao;
	@Autowired
	private IMaintainEquipManager maintainEquipManager;
	@Autowired
	private IMaintainEquipDao maintainEquipDao;
	@Autowired
	private IEquipService equipService;
	
	@Override
	public Pagination queryPage(EquipNodeQueryModel queryModel) {
		String eqname = queryModel.getEqnameLike();
		if(StringUtils.contains(eqname, "%")){
			eqname = eqname.replace("%", "\\%");
		}
		if (StringUtils.contains(eqname, "_")) {
			eqname = eqname.replace("_", "\\_");
		}
		queryModel.setEqnameLike(eqname);
		String mename = queryModel.getMenameLike();
		if(StringUtils.contains(mename, "%")){
			mename = mename.replace("%", "\\%");
		}
		if (StringUtils.contains(mename, "_")) {
			mename = mename.replace("_", "\\_");
		}
		queryModel.setMenameLike(mename);
		return equipNodeDao.queryPage(queryModel);
	}

	@Override
	public EquipNode add(EquipNodeQueryModel queryModel) {
		EquipNode equipNode = new EquipNode();
		MaintainEquip maintainEquip = maintainEquipManager.findById(queryModel.getMaintainEquip().getId());
		Equip equip = equipService.findById(queryModel.getEquip().getId());
		maintainEquip.setEquip(equip);
				
				
		equipNode.setMaintainEquip(maintainEquip);
		equipNode.setEquip(equip);
		equipNode.setCreateTime(Calendar.getInstance());
		maintainEquipDao.update(maintainEquip);
		equipNodeDao.save(equipNode);
		return equipNode;
	}

	@Override
	public EquipNode findById(String id) {
		return equipNodeDao.findById(id);
	}

	@Override
	public void delete(EquipNode equipNode) {
		equipNodeDao.delete(equipNode);
	}

	@Override
	public EquipNode findByMaintainEquip(MaintainEquip maintainEquip) {
		return equipNodeDao.findByMaintainEquip(maintainEquip);
	}


}
