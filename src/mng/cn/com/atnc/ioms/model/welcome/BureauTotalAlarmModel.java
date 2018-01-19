/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-5-7 下午6:56:38
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.model.welcome;

import cn.com.atnc.ioms.enums.basedata.Bureau;

/**
 * @author:HuangYijie
 * @date:2014-5-7 下午6:56:38
 * @version:1.0
 */

public class BureauTotalAlarmModel {

	private Bureau bureau;
	private Long count = 0L;

	public BureauTotalAlarmModel() {

	}

	public BureauTotalAlarmModel(Bureau bureau, Long count) {
		this.bureau = bureau;
		this.count = count;
	}

	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
