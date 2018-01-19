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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.maintain.alarminfo.IStatusAlarmHistoryDao;
import cn.com.atnc.ioms.mng.maintain.alarminfo.IStatusAlarmHistoryManager;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

 /**
 * 此处添加类StatusAlarmHistoryManagerImpl的描述信息
 *
 * @author wangzhicheng
 * @date 2015-5-6 下午3:59:48
 * @since 1.0.0
 */
@Service
@Transactional
public class StatusAlarmHistoryManagerImpl extends AbstractService implements
		IStatusAlarmHistoryManager {

	@Autowired
	private IStatusAlarmHistoryDao statusAlarmHistoryDao;

	@Override
	public Pagination queryPage(AlarmInfoQueryModel queryModel) {
		return statusAlarmHistoryDao.queryPage(queryModel);
	}
	

}
