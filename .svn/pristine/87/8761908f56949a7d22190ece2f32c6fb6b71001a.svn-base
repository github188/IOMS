package cn.com.atnc.ioms.enums.basedata;

import org.apache.commons.lang.StringUtils;

/**
 *类说明
 *@author 潘涛
 *@date 2014-8-21	上午10:39:06
 *@version:1.0
 */
public enum ServiceChangeType {
	ADELETE("删除"),
	BNEW("新增"),
	CCHANGE("变化"),
	DNORMAL("正常");
	
	private String value;
	private ServiceChangeType(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value){
		this.value = value;
	}
	public String toString() {
		return value;
	}
	public static ServiceChangeType getServiceChangeTypeByOrdinal(int value) {
		for (ServiceChangeType type : ServiceChangeType.values()) {
			if (type.ordinal() == value) {
				return type;
			}
		}
		return null;
	}
	
	public static ServiceChangeType getServiceChangeTypeByValue(String value) {
		for (ServiceChangeType type : ServiceChangeType.values()) {
			if (StringUtils.equals(type.value, value)) {
				return type;
			}
		}
		return null;
	}


}
