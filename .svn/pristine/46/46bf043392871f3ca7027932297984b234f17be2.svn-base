package cn.com.atnc.ioms.enums.duty.environment;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * ups设备巡检分类枚举类
 * @author renyujuan
 * @date 2016年8月3日下午1:26:44
 */
public enum CheckCatagory {

	MONTH("月检"),
	QUARTER("季检"),
	YEAR("年检");
	
	private String value;
	public String getValue(){
		return value;
	}
	
	private CheckCatagory(String value){
		this.value=value;
	}
	
	public static CheckCatagory getInstance(String value){
		CheckCatagory[] ccs=CheckCatagory.values();
		for(CheckCatagory result : ccs){
			if(StringUtils.equalsIgnoreCase(result.getValue(), value)){
				return result;
			}
		}
		throw new IllegalArgumentException("value值非法，没有符合工作状态的枚举对象");
	}
	
	@Override
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
