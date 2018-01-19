/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-6-5 下午3:08:56
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.model.welcome;

import java.util.List;

/**
 * @author:HuangYijie
 * @date:2014-6-5 下午3:08:56
 * @version:1.0
 */

public class AlarmStatResultModel {

	private List<AlarmTotalStatModel> cityAlarmStatList;
	private List<AlarmTotalStatModel> bureauAlarmStatList;

	public List<AlarmTotalStatModel> getCityAlarmStatList() {
		return cityAlarmStatList;
	}

	public void setCityAlarmStatList(List<AlarmTotalStatModel> cityAlarmStatList) {
		this.cityAlarmStatList = cityAlarmStatList;
	}

	public List<AlarmTotalStatModel> getBureauAlarmStatList() {
		return bureauAlarmStatList;
	}

	public void setBureauAlarmStatList(
			List<AlarmTotalStatModel> bureauAlarmStatList) {
		this.bureauAlarmStatList = bureauAlarmStatList;
	}

}
