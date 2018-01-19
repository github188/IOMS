package cn.com.atnc.ioms.enums.business.telegraph;

import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 使用区域枚举
 * @author WangLingbin
 * @date 2015年6月18日 上午9:10:31
 * @since 1.0.0
 */
public enum UsingAreaEnum {
	
	domestic("国内"),
	abroad("国外");
	private String value;
	private UsingAreaEnum(String value){
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
