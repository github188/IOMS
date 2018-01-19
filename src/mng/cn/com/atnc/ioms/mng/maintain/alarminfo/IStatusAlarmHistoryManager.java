/**
 * @ProjectName IOMS
 * @FileName IStatusAlarmManager.java
 * @PackageName:cn.com.atnc.ioms.mng.basedata.alarm
 * @author KuYonggang
 * @date 2015年3月27日下午5:18:58
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.maintain.alarminfo;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

 /**
 * 此处添加类IStatusAlarmHistoryManager的描述信息
 *
 * @author wangzhicheng
 * @date 2015-5-6 下午3:57:08
 * @since 1.0.0
 */
public interface IStatusAlarmHistoryManager {

	public Pagination queryPage(AlarmInfoQueryModel queryModel);


}
