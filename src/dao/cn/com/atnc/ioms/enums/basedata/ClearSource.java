/* Copyright © 2010 BEIJING YiZhanHengTong Science & Technology Co.,Ltd.
 * All rights reserved
 *
 * created at 2010-11-8 上午11:51:19
 * author:huangyijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.enums.basedata;

/**
 * 清除执行对象
 * @author:huangyijie
 * @date:2010-11-8 上午11:51:19
 * @version:1.0
 */

public enum ClearSource {
	UNCLEAR("未清除"), SERVER("中心平台"), PROXY("采集前端"), USER("用户手工");
	private String value;

	ClearSource(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}
}
