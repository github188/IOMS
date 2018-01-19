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
 * ATM日检交换机TAB页枚举类
 * @author 王志鹏 
 * @2017年2月9日 下午1:51:25
 */
public enum AtmDayMgxTabEnum {

	TXJD_8850("通信基地 8850"),
	TXJD_8830("通信基地 8830"),
	SLH_8850("十里河8850"),
	SLH_8830("十里河8830"),
	MHJ_8850("民航局8850"),
    KGJ_8850("民航局空管局8850"),
    CFZX_8830("财富中心8830");
    
	
	private String value;
	public String getValue(){
		return value;
	}
	
	private AtmDayMgxTabEnum(String value){
		this.value=value;
	}
	
	public static AtmDayMgxTabEnum getInstance(String value){
		AtmDayMgxTabEnum[] ccs=AtmDayMgxTabEnum.values();
		for(AtmDayMgxTabEnum result : ccs){
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
