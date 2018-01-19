/**
 * @ProjectName IOMS
 * @FileName LinkAlarmManagerImpl.java
 * @PackageName:cn.com.atnc.ioms.mng.basedata.alarm
 * @author KuYonggang
 * @date 2015年3月27日下午5:17:45
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.maintain.pollinginfo.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.mng.maintain.pollinginfo.Wafr08Port0StatManager;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;
import cn.com.atnc.ioms.dao.maintain.pollinginfo.IWafr08Port0StatDao;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.Wafr08Port0Stat;

 /**
 * 此处添加类KuCarrierFreqManagerImpl的描述信息
 *
 * @author wangzhicheng
 * @date 2015-4-27 下午3:03:24
 * @since 1.0.0
 */
@Service("wafr08Port0StatManager")
public class Wafr08Port0StatManagerImpl extends AbstractService implements
        Wafr08Port0StatManager {
	
	@Autowired
    private IWafr08Port0StatDao wafr08Port0StatDao;

	@Override
	public Pagination queryPage(PollingInfoQueryModel queryModel) {
		return wafr08Port0StatDao.queryPage(queryModel);
	}

	@Override
	public Wafr08Port0Stat findById(String id) {
		return wafr08Port0StatDao.findById(id);
	}

	@Override
	public List<Wafr08Port0Stat> findAll() {
		return wafr08Port0StatDao.getAll();
	}

	@Override
	public Wafr08Port0Stat findByEquipAndDate(MaintainEquip maintainEquip,
			Date currentDate) {
		return wafr08Port0StatDao.findByEquipAndDate(maintainEquip, currentDate);
	}

}
