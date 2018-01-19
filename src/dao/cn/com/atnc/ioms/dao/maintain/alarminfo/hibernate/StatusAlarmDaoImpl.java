/**
 * @ProjectName IOMS
 * @FileName StatusAlarmDaoImpl.java
 * @PackageName:cn.com.atnc.ioms.dao.basedata.alarm.hibernate
 * @author KuYonggang
 * @date 2015年3月27日下午5:41:27
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.alarminfo.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.maintain.alarminfo.IStatusAlarmDao;
import cn.com.atnc.ioms.entity.maintain.alarminfo.StatusAlarm;
import cn.com.atnc.ioms.enums.basedata.EquipAlarmType;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;

/**
 * 此处添加类StatusAlarmDaoImpl的描述信息
 *
 * @author KuYonggang
 * @date 2015年3月27日 下午5:41:27
 * @since 1.0.0
 */
@Repository
public class StatusAlarmDaoImpl extends MyBaseDao<StatusAlarm> implements IStatusAlarmDao {

	@Override
	public Pagination queryPage(AlarmInfoQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from StatusAlarm where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (queryModel.getBureau() != null) {
			hql.append(" and equipId.satelliteSite.bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}
		if (StringUtils.isEmpty(queryModel.getStname()) == false) {
			hql.append(" and equipId.satelliteSite.siteName like:stname  escape '\\' ");
			params.put("stname", "%" + queryModel.getStname() + "%");
		}
		if (StringUtils.isEmpty(queryModel.getEqname()) == false) {
			hql.append(" and equipId.name like:eqname  escape '\\' ");
			params.put("eqname", "%" + queryModel.getEqname() + "%");
		}
		if(queryModel.getStartRecordTime() != null){
            hql.append(" and recordTime>=:startRecordTime");
            params.put("startRecordTime",queryModel.getStartRecordTime().getTime());
        }
        if(queryModel.getStartRecordTime() != null){
            hql.append(" and recordTime<=:endRecordTime");
            params.put("endRecordTime",queryModel.getEndRecordTime().getTime());
        }
		hql.append(" order by recordTime desc");
		String countHql = COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}
	
	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.dao.maintain.alarminfo.IStatusAlarmDao#getStatusAlarm(java.lang.String, cn.com.atnc.ioms.enums.basedata.EquipAlarmType)
	 */
	@Override
	public StatusAlarm getStatusAlarm(String id, EquipAlarmType thresholdwarning) {
		StringBuilder hql = new StringBuilder("from StatusAlarm where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		hql.append(" and equipId.id =:equipId and type =:alarmType ");
		params.put("equipId",id);
		params.put("alarmType", thresholdwarning);
		@SuppressWarnings("unchecked")
		List<StatusAlarm> statusAlarms = (List<StatusAlarm>) this.queryList(hql.toString(), params);
		if(!CollectionUtils.isEmpty(statusAlarms)){
			return statusAlarms.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.dao.basedata.equip.IEquipDao#findAlarmMonitorByEquip()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StatusAlarm> findStatusAlarmByEquip(String id) {
		StringBuilder hql = new StringBuilder(" from StatusAlarm e where e.equipId.id in (?)");
		List<Object> params = new ArrayList<Object>();
		params.add(id); 
		hql.append(" order by recordTime desc");
		return (List<StatusAlarm>) this.queryList(hql.toString(), params.toArray());
	}
}
