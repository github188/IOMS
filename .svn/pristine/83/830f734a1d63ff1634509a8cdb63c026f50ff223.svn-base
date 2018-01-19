package cn.com.atnc.ioms.enums.business.telegraph;

import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;


/**
 * 地址类型枚举类
 * @author WangLingbin
 * @date 2016年2月3日 上午10:44:51
 * @since 1.0.0
 */
public enum AddressTypeEnum {
	
	AFTN("AFTN"),
	SITA("SITA"),
	E8X("8X"); 
	private String value;
	private AddressTypeEnum(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
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
