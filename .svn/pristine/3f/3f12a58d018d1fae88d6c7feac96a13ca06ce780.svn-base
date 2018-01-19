package cn.com.atnc.ioms.enums.clientmng;

import org.apache.commons.lang.StringUtils;

/**
 *类说明：性别枚举
 *@author 潘涛
 *@date 2014-3-19	上午9:43:35
 *@version:1.0
 */
public enum SexEnum {
	FEMALE("女"),MALE("男");
	
	private String name;

	private SexEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public static SexEnum getSexEnumByOrdinal(int value) {
		for (SexEnum type : SexEnum.values()) {
			if (type.ordinal() == value) {
				return type;
			}
		}
		return null;
	}

	public static SexEnum getSexEnumByValue(String value) {
		for (SexEnum type : SexEnum.values()) {
			if (StringUtils.equals(type.name(), value)) {
				return type;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(SexEnum.FEMALE.name);
	}
}
