/* Copyright © 2010 BEIJING YiZhanHengTong Science & Technology Co.,Ltd.
 * All rights reserved
 *
 * created at 2010-11-16 上午11:39:00
 * author:huangyijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.enums.basedata;

/**
 * 设备告警类型
 * @author:huangyijie
 * @date:2010-11-16 上午11:39:00
 * @version:1.0
 */

public enum EquipAlarmType {

	StatusWarning("状态告警"), ThresholdWarning("超出阈值告警"), ValueChangeWarning(
			"值改变告警");
	
	private String value;

	EquipAlarmType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String toString() {
		return this.name();
	}
}
