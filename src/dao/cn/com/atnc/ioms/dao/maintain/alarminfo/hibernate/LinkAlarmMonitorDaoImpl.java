/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName LinkAlarmMonitorDaoImpl.java
 * @PackageName:cn.com.atnc.ioms.dao.maintain.alarminfo.hibernate
 * @author ku
 * @date 2015年4月27日下午3:54:08
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.alarminfo.hibernate;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.maintain.alarminfo.ILinkAlarmMonitorDao;
import cn.com.atnc.ioms.entity.maintain.alarminfo.LinkAlarmMonitor;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

/**
 * 链路告警监控Dao接口实现类
 *
 * @author ku
 * @date 2015年4月27日 下午3:54:08
 * @since 1.0.0
 */
@Repository
public class LinkAlarmMonitorDaoImpl extends MyBaseDao<LinkAlarmMonitor> implements ILinkAlarmMonitorDao{
	@Override
	public Pagination queryPage(AlarmInfoQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from LinkAlarmMonitor where 1=1");
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
		hql.append(" order by alarmStatus desc , recordTime desc");
		String countHql = COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}
}
