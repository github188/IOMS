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

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.atnc.sample.dao.MyBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.maintain.alarminfo.IStatusAlarmHistoryDao;
import cn.com.atnc.ioms.entity.maintain.alarminfo.StatusAlarmHistory;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

/**
 * @author KuYonggang
 * @date 2015年3月27日 下午5:41:27
 * @since 1.0.0
 */
@Repository
public class StatusAlarmHistoryDaoImpl extends MyBaseDao<StatusAlarmHistory> implements IStatusAlarmHistoryDao {
	
	@Override
	public Pagination queryPage(AlarmInfoQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from StatusAlarmHistory where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (queryModel.getEquipId() != null) {
			hql.append(" and equipId =:equipId");
			params.put("equipId", queryModel.getEquipId());
		}
		hql.append(" order by recordTime desc , id desc");
		String countHql = COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

}
