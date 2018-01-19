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

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.maintain.alarminfo.ILinkAlarmMonitorDao;
import cn.com.atnc.ioms.dao.maintain.alarminfo.IStatusAlarmMonitorDao;
import cn.com.atnc.ioms.dao.maintain.equip.IMaintainEquipDao;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.maintain.alarminfo.LinkAlarmMonitor;
import cn.com.atnc.ioms.entity.maintain.alarminfo.StatusAlarmMonitor;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.enums.basedata.AlarmStatusEnum;
import cn.com.atnc.ioms.enums.basedata.NetworkType;
import cn.com.atnc.ioms.mng.maintain.equip.IMaintainEquipManager;
import cn.com.atnc.ioms.model.maintain.satellite.SatelliteQueryModel;

/**
 * 此处添加类MaintainEquipManagerImpl的描述信息
 *
 * @author wangzhicheng
 * @date 2015-5-4 下午4:32:24
 * @since 1.0.0
 */
@Service
@Repository
public class MaintainEquipManagerImpl implements IMaintainEquipManager {

	@Autowired
	private IMaintainEquipDao maintainEquipDao;
	@Autowired
	private ILinkAlarmMonitorDao linkAlarmMonitorDao;
	@Autowired
	private IStatusAlarmMonitorDao statusAlarmMonitorDao;

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.mng.maintain.equip.IMaintainEquipManager#findById(java.lang.String)
	 */
	@Override
	@Transactional(readOnly=true)
	public MaintainEquip findById(String id) {
		// TODO Auto-generated method stub
		return maintainEquipDao.findById(id);
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.mng.basedata.equip.IEquipService#initAlarmMonitor()
	 */
	@Override
	public void initAlarmMonitor() {
		// TODO Auto-generated method stub
		List<MaintainEquip> equips = maintainEquipDao.findAlarmMonitorByEquip();
		for (MaintainEquip equip : equips) {
			//初始链路告警监控
			LinkAlarmMonitor linkAlarmMonitor = linkAlarmMonitorDao.findByParam("equipId.id", equip.getId());
			if(ObjectUtils.equals(linkAlarmMonitor, null)){
				LinkAlarmMonitor temp = new LinkAlarmMonitor();
				temp.setEquipId(equip);
				temp.setAlarmStatus(AlarmStatusEnum.normal);
				temp.setRecordTime(new Date());
				linkAlarmMonitorDao.save(temp);
			}
			//初始状态告警监控
			StatusAlarmMonitor statusAlarmMonitor = statusAlarmMonitorDao.findByParam("equipId.id", equip.getId());
			if(ObjectUtils.equals(statusAlarmMonitor, null)){
				StatusAlarmMonitor temp = new StatusAlarmMonitor();
				temp.setEquipId(equip);
				temp.setAlarmStatus(AlarmStatusEnum.normal);
				temp.setRecordTime(new Date());
				statusAlarmMonitorDao.save(temp);
			}
		}
	}

	@Override
	public List<MaintainEquip> queryWAFList() {
		return maintainEquipDao.queryWAFList();
	}

	@Override
	public List<MaintainEquip> findAll() {
		return maintainEquipDao.getAll();
	}

	@Override
	public void update(MaintainEquip equipNode) {
		maintainEquipDao.update(equipNode);
	}
	
	@Override
	public Pagination findBySatellite(SatelliteQueryModel queryModel) {
		//节点名称
		String siteName = queryModel.getSiteNameLike();
		if(StringUtils.contains(siteName, "%")){
			siteName = siteName.replace("%", "\\%");
		}
		if (StringUtils.contains(siteName, "_")) {
			siteName = siteName.replace("_", "\\_");
		}
		queryModel.setSiteNameLike(siteName);
		return maintainEquipDao.findBySatellite(queryModel);
	}

	@Override
	public List<MaintainEquip> findBySiteAndType(NetworkType type,
			SatelliteSite satelliteSite) {
		return maintainEquipDao.findBySiteAndType(type, satelliteSite);
	}

	@Override
	public List<MaintainEquip> findAllOrderBy() {
		return maintainEquipDao.findAllOrderBy();
	}
}
