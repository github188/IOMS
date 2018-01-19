/* Copyright © 2010 BEIJING YiZhanHengTong Science & Technology Co.,Ltd.
 * All rights reserved
 *
 * created at 2010-11-16 上午11:39:00
 * author:huangyijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.enums.basedata;

import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 子网类型
 *
 * @author 段衍林
 * @2016年11月24日 下午2:37:08
 */
public enum SubnetType {

	subnet1("子网1"), subnet2("子网2"), subnet3("子网3"), subnet4("子网4"), FRNET(
			"子网FR"), ;
	private String value;

	public static SubnetType string2Enum(String value) {
		switch (value) {
		case "子网1":
			return subnet1;
		case "子网2":
			return subnet2;
		case "子网3":
			return subnet3;
		case "子网4":
			return subnet4;
		case "子网FR":
			return FRNET;
		default:
			return subnet1;
		}
	}

	private SubnetType(String value) {
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
	@JsonValue
	public EnumModel toEnumModel() {
		EnumModel em = new EnumModel();
		em.setName(this.name());
		em.setOrdinal(this.ordinal());
		em.setValue(this.getValue());
		return em;
	}
}
