package cn.com.atnc.ioms.enums.business.formalcircuit;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;


/**
 * 卡类型枚举
 * @author WangLingbin
 * @date 2015年8月3日 上午9:40:23
 * @since 1.0.0
 */
public enum CardEnum {

	HD("高速数据板"),FR("帧中继板"),
	E1("E1"),DLM("DLM"),VOICE("VOICE");

	private String value;

	private CardEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static CardEnum getApproveStatEnumByOrdinal(int value) {
		for (CardEnum type : CardEnum.values()) {
			if (type.ordinal() == value) {
				return type;
			}
		}
		return null;
	}
	
	public static CardEnum getApproveStatEnumByValue(String value) {
		for (CardEnum type : CardEnum.values()) {
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
