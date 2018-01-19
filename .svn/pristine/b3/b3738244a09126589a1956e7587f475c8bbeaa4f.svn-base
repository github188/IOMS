/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName ApplyTypeEnum.java
 * @PackageName:cn.com.atnc.pcsp.enums.business
 * @author ku
 * @date 2015年5月13日下午2:20:37
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.enums.business.serial;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;



/**
 * 申请表序号枚举
 * @author WangLingbin
 * @date 2015年10月27日 上午10:37:01
 * @since 1.0.0
 */
public enum SerialTypeEnum {

	WX("卫星"),SJ("数据"),ZB("转报"),KU("卫星"),ATM("ATM节点"),
	ADD("新增"),DEL("取消"),MOD("变更");
	
	private String value;

	private SerialTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static SerialTypeEnum getApplyTypeEnumByOrdinal(int value) {
		for (SerialTypeEnum type : SerialTypeEnum.values()) {
			if (type.ordinal() == value) {
				return type;
			}
		}
		return null;
	}
	
	public static SerialTypeEnum getApplyTypeEnumByValue(String value) {
		for (SerialTypeEnum type : SerialTypeEnum.values()) {
			if (StringUtils.equals(type.value,value)) {
				return type;
			}
		}
		return null;
	}
	 
	public String toString() {
		return value;
	}
	
	@JsonValue
	public EnumModel toEnumModel(){
		EnumModel em = new EnumModel();
		em.setName(this.name());
		em.setOrdinal(this.ordinal());
		em.setValue(this.getValue());
		
		return em;
	}
	
}
