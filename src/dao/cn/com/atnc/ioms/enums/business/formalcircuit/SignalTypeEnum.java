package cn.com.atnc.ioms.enums.business.formalcircuit;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;



/**
 * 信令类型枚举
 * @author WangLingbin
 * @date 2015年8月3日 上午9:40:23
 * @since 1.0.0
 */
public enum SignalTypeEnum {

	Q933a("Q933a"),UNI("UNI"),
	NNI("NNI"),ZTC("帧透传");

	private String value;

	private SignalTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static SignalTypeEnum getApproveStatEnumByOrdinal(int value) {
		for (SignalTypeEnum type : SignalTypeEnum.values()) {
			if (type.ordinal() == value) {
				return type;
			}
		}
		return null;
	}
	
	public static SignalTypeEnum getApproveStatEnumByValue(String value) {
		for (SignalTypeEnum type : SignalTypeEnum.values()) {
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
