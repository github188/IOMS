/**
 * @ProjectName IOMS
 * @FileName LinkAlarmManagerImpl.java
 * @PackageName:cn.com.atnc.ioms.mng.basedata.alarm
 * @author KuYonggang
 * @date 2015年3月27日下午5:17:45
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.maintain.alarminfo.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.maintain.alarminfo.ILinkAlarmDao;
import cn.com.atnc.ioms.dao.maintain.alarminfo.ILinkAlarmMonitorDao;
import cn.com.atnc.ioms.entity.maintain.alarminfo.LinkAlarm;
import cn.com.atnc.ioms.entity.maintain.alarminfo.LinkAlarmMonitor;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.mng.maintain.alarminfo.ILinkAlarmManager;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

/**
 *
 * @author KuYonggang
 * @date 2015年3月27日 下午5:17:45
 * @since 1.0.0
 */
@Service
@Transactional
public class LinkAlarmManagerImpl extends AbstractService implements
		ILinkAlarmManager {

	@Autowired
	private ILinkAlarmDao linkAlarmDao;
	@Autowired
	private ILinkAlarmMonitorDao linkAlarmMonitorDao;
	
	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.mng.maintain.alarminfo.ILinkAlarmManager#getAll()
	 */
	@Transactional(readOnly=true)
	@Override
	public List<LinkAlarm> getAll() {
		return linkAlarmDao.getAll();
	}

	@Override
	public Pagination queryPage(AlarmInfoQueryModel queryModel) {
		String eqname = queryModel.getEqname();
		if(StringUtils.contains(eqname, "%")){
			eqname = eqname.replace("%", "\\%");
		}
		if (StringUtils.contains(eqname, "_")) {
			eqname = eqname.replace("_", "\\_");
		}
		queryModel.setEqname(eqname);
		String stname = queryModel.getStname();
		if(StringUtils.contains(stname, "%")){
			stname = stname.replace("%", "\\%");
		}
		if (StringUtils.contains(stname, "_")) {
			stname = stname.replace("_", "\\_");
		}
		queryModel.setStname(stname);
		return linkAlarmDao.queryPage(queryModel);
	}

	@Override
	public List<MaintainEquip> getAllME() {
		List<LinkAlarmMonitor> lamli =  linkAlarmMonitorDao.getAll();
		List<MaintainEquip> meli = new ArrayList<>();
		for(int i=0;i<lamli.size();i++){
			if(lamli.get(i).getAlarmStatus().getValue().equals("正常")){
				MaintainEquip maintainEquip = lamli.get(i).getEquipId();
				meli.add(maintainEquip);
			}
		}
		return meli;
	}

	@Override
	public LinkAlarm findById(String id) {
		return linkAlarmDao.findById(id);
	}

	@Override
	public List<AlarmInfoQueryModel> dealAIQList(List<LinkAlarm> lali, AlarmInfoQueryModel queryModel) {
		List<AlarmInfoQueryModel> alqmli = new ArrayList<>();
		//得到状态正常的设备List
		List<MaintainEquip> meli =  this.getAllME();
		for(int i=0;i<lali.size();i++){
			AlarmInfoQueryModel queryModel2 = new AlarmInfoQueryModel();
			queryModel2.setLinkAlarm(lali.get(i));
			int flag = 0;
			for(int j=0;j<meli.size();j++){
				if(meli.get(j).getId() == lali.get(i).getEquipId().getId()){
					flag++;
				}
			}
			if(flag==0){
				queryModel2.setStatus("异常");
			}else{
				queryModel2.setStatus("正常");
			}
			if(queryModel.getStatus().isEmpty()){
				alqmli.add(queryModel2);
			}else{
				if(flag==0&&queryModel.getStatus().equals("0")){
					alqmli.add(queryModel2);
				}
				if(flag==1&&queryModel.getStatus().equals("1")){
					alqmli.add(queryModel2);
				}
			}
		}
		return alqmli;
	}
	
	/**
	 * 根据MaintainEquipId查找LinkAlarm实体
	 *
	 * @param id
	 * @return 
	 * @author XuTongYang
	 * @date  2015年6月10日上午10:51:48
	 * @since 1.0.0
	 */
	public LinkAlarm findByMaintainEquipId(String id){
		LinkAlarm linkAlarm = linkAlarmDao.findByEquipId(id);
		return linkAlarm;
	}
}
