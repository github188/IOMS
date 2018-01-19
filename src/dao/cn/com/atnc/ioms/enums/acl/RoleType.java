/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-8-19 下午2:21:34
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.enums.acl;

/**
 * @author:HuangYijie
 * @date:2013-8-19 下午2:21:34
 * @version:1.0
 */

public enum RoleType {
	NORMAL("自定义") {
	},
	SYSTEM("系统") {
	},
	ADMIN("管理") {
	};
	private String value;

	private RoleType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
