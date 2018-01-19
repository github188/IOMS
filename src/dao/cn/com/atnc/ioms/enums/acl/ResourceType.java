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

public enum ResourceType {
	ROOT("根目录") {
	},
	MENU("菜单") {
	},
	COLUMN("子菜单") {
	},
	URL("操作") {
	},
	DOM("页面元素") {
	},
	TAB("标签页") {
	},
	;
	private String value;

	private ResourceType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
