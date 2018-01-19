/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-5-26 下午2:46:06
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.model.operstat.ku;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.common.util.TimeTools;
import cn.com.atnc.ioms.model.MyPaginModel;

/**
 * @author:HuangYijie
 * @date:2014-5-26 下午2:46:06
 * @version:1.0
 */

public class KuStatusStatQueryModel extends MyPaginModel {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar endTime;

	public Calendar getStartTime() {
		if (startTime != null) {
			startTime.set(Calendar.HOUR, 0);
			startTime.set(Calendar.MINUTE, 0);
			startTime.set(Calendar.SECOND, 0);
		}
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		if (endTime != null) {
			endTime.set(Calendar.HOUR_OF_DAY, 23);
			endTime.set(Calendar.MINUTE, 59);
			endTime.set(Calendar.SECOND, 59);
		}
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

}
