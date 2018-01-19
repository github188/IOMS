/**
 * @ProjectName IOMS
 * @FileName StatusAlarmManagerImpl.java
 * @PackageName:cn.com.atnc.ioms.mng.basedata.alarm
 * @author KuYonggang
 * @date 2015年3月27日下午5:19:23
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
import cn.com.atnc.ioms.dao.maintain.alarminfo.IStatusAlarmDao;
import cn.com.atnc.ioms.dao.maintain.alarminfo.IStatusAlarmMonitorDao;
import cn.com.atnc.ioms.entity.maintain.alarminfo.StatusAlarm;
import cn.com.atnc.ioms.entity.maintain.alarminfo.StatusAlarmMonitor;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.mng.maintain.alarminfo.IStatusAlarmManager;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

/**
 *
 * @author KuYonggang
 * @date 2015年3月27日 下午5:19:23
 * @since 1.0.0
 */
@Service
@Transactional
public class StatusAlarmManagerImpl extends AbstractService implements
		IStatusAlarmManager {

	@Autowired
	private IStatusAlarmDao statusAlarmDao;
	@Autowired
	private IStatusAlarmMonitorDao statusAlarmMonitorDao;
	
	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.mng.maintain.alarminfo.IStatusAlarmManager#getAll()
	 */
	@Override
	@Transactional(readOnly=true)
	public List<StatusAlarm> getAll() {
		// TODO Auto-generated method stub
		return statusAlarmDao.getAll();
	}

	@Override
	public List<MaintainEquip> getAllME() {
		List<StatusAlarmMonitor> lamli =  statusAlarmMonitorDao.getAll();
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
		return statusAlarmDao.queryPage(queryModel);
	}

	@Override
	public StatusAlarm findById(String id) {
		return statusAlarmDao.findById(id);
	}

	@Override
	public List<AlarmInfoQueryModel> dealAIQList(List<StatusAlarm> sali,
			AlarmInfoQueryModel queryModel) {
		List<AlarmInfoQueryModel> amlqm = new ArrayList<AlarmInfoQueryModel>();
		//得到状态正常的设备List
		List<MaintainEquip> mte =  this.getAllME();
		for(int i=0;i<sali.size();i++){
			AlarmInfoQueryModel queryModel2 = new AlarmInfoQueryModel();
			queryModel2.setStatusAlarm(sali.get(i));
			int flag = 0;
			for(int j=0;j<mte.size();j++){
				if(mte.get(j).getId().equals(sali.get(i).getEquipId().getId())){
					flag++;
				}
			}
			if(flag==0){
				queryModel2.setStatus("异常");
			}else{
				queryModel2.setStatus("正常");
			}
			if(queryModel.getStatus().isEmpty()){
				amlqm.add(queryModel2);
			}else{
				if(flag==0&&queryModel.getStatus().equals("0")){
					amlqm.add(queryModel2);
				}
				if(flag==1&&queryModel.getStatus().equals("1")){
					amlqm.add(queryModel2);
				}
			}
		}
		return amlqm;
	}
	/**
	 * 根据MaintainEquipId查找StatusAlarm实体
	 *
	 * @param id
	 * @return 
	 * @author XuTongYang
	 * @date  2015年6月10日上午10:51:48
	 * @since 1.0.0
	 */
	public StatusAlarm findByMaintainEquipId(String id){
		StatusAlarm statusAlarm = statusAlarmDao.findByParam("equipId.id", id);
		return statusAlarm;
	}
	/**
	 * 根据MaintainEquipId查找StatusAlarm实体List
	 *
	 * @param id
	 * @return 
	 * @author XuTongYang
	 * @date  2015年6月10日上午10:51:48
	 * @since 1.0.0
	 */
	public List<StatusAlarm> findListByMaintainEquipId(String id){
		List<StatusAlarm> list = statusAlarmDao.findStatusAlarmByEquip(id);
		return list;
	}
}
