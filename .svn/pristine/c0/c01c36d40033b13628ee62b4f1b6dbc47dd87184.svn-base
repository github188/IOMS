/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-5-26 下午2:46:06
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.model.operstat.ku;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.model.MyPaginModel;

/**
 * @author:HuangYijie
 * @date:2014-5-26 下午2:46:06
 * @version:1.0
 */

public class KuStatusLogQueryModel extends MyPaginModel {
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Calendar startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Calendar endTime;
	
	private String kuNodeId;
	

	public String getKuNodeId() {
		return kuNodeId;
	}

	public void setKuNodeId(String kuNodeId) {
		this.kuNodeId = kuNodeId;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

}
