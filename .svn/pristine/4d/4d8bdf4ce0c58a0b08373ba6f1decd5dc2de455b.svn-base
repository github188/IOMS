/* Copyright © 2010 BEIJING YiZhanHengTong Science & Technology Co.,Ltd.
 * All rights reserved
 *
 * created at 2010-12-2 上午11:57:35
 * author:huangyijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.enums.basedata;

/**
 * 告警等级
 * 
 * @author:huangyijie
 * @date:2010-12-2 上午11:57:35
 * @version:1.0
 */
public enum AlarmSeverity {
	CLEAR("清除"), MINOR("低"),
	// INDETERMINATE("未知"), WARNING("警告"), MAJOR("中"),
	// INFORMATIONAL("重要"),
	CRITICAL("CRITICAL");
	private String value;

	AlarmSeverity(String value) {
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

/*	public twaver.AlarmSeverity toTwaverAlarmSeverity() {
		if (value.equals("清除")) {
			return twaver.AlarmSeverity.getByName(SysFinals.SERVERITY_NORMAL);
		}
		if (value.equals("低")) {
			return twaver.AlarmSeverity.MINOR;
		}
		if (value.equals("中")) {
			return twaver.AlarmSeverity.MAJOR;
		}
		if (value.equals("高")) {
			return twaver.AlarmSeverity.CRITICAL;
		}
		if (value.equals("重要")) {
			return twaver.AlarmSeverity.WARNING;
		}
		return twaver.AlarmSeverity.CLEARED;
	}
*/
	public static AlarmSeverity getAlarmSeverity(int ordinal) {
		if (ordinal == CLEAR.ordinal()) {
			return CLEAR;
		}
		if (ordinal == CRITICAL.ordinal()) {
			return CRITICAL;
		}
		if (ordinal == MINOR.ordinal()) {
			return MINOR;
		}
		// if (ordinal == MAJOR.ordinal()) {
		// return MAJOR;
		// }
		//
		// if (ordinal == INFORMATIONAL.ordinal()) {
		// return INFORMATIONAL;
		// }
		return CLEAR;
	}
}
