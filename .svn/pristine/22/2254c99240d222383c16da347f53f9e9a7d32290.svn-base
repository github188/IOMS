/**
 * @Title:AtmType.java
 * @author shijiyong
 * @data 2016年9月26日下午3:54:05
 * @version v1.0
 */
package cn.com.atnc.ioms.enums.duty.atm;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * ATM日检TAB页枚举类
 * @author 王凌斌 
 * @2017年2月9日 下午1:51:25
 */
public enum AtmDayTabEnum {

	WKZX("北京网控中心"),
	KGJ("民航局空管局");
	
	private String value;
	public String getValue(){
		return value;
	}
	
	private AtmDayTabEnum(String value){
		this.value=value;
	}
	
	public static AtmDayTabEnum getInstance(String value){
		AtmDayTabEnum[] ccs=AtmDayTabEnum.values();
		for(AtmDayTabEnum result : ccs){
			if(StringUtils.equalsIgnoreCase(result.getValue(), value)){
				return result;
			}
		}
		throw new IllegalArgumentException("value值非法，没有符合工作状态的枚举对象");
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
