package cn.com.atnc.ioms.enums.business.telegraph;

import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 使用时限枚举
 * @author WangLingbin
 * @date 2015年6月18日 上午9:10:45
 * @since 1.0.0
 */
public enum UsingPeriodEnum {
	
	temp("临时"),
	permanent("永久");
	private String value;
	private UsingPeriodEnum(String value){
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
