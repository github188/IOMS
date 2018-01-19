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
public enum SerialNameEnum {

	RW("入网"),DB("电报"),TW("退网"),
	DLPZ_ATM("ATM电路"),DLPZ_C("TES电路"),DLPZ_KU("KU电路"),DLPZ_PES("PES电路"),DLPZ_ZJDL("转报中继电路"),;
	
	private String value;

	private SerialNameEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static SerialNameEnum getApplyTypeEnumByOrdinal(int value) {
		for (SerialNameEnum type : SerialNameEnum.values()) {
			if (type.ordinal() == value) {
				return type;
			}
		}
		return null;
	}
	
	public static SerialNameEnum getApplyTypeEnumByValue(String value) {
		for (SerialNameEnum type : SerialNameEnum.values()) {
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
