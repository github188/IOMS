package cn.com.atnc.ioms.enums.business.formalcircuit;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * ATM电路业务类型枚举类
 *
 * @author Wang Zhicheng
 * @date 2015年10月22日 下午1:01:21
 * @since 1.0.0
 */
public enum AtmCircuitTypeEnum {

	UBR("UBR"),CBR("CBR"),RTVBR("RT-VBR"),NRTVBR("NRT-VBR"),ABR("ABR"),OTHERS("其他");

	private String value;

	private AtmCircuitTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static AtmCircuitTypeEnum getApproveStatEnumByOrdinal(int value) {
		for (AtmCircuitTypeEnum type : AtmCircuitTypeEnum.values()) {
			if (type.ordinal() == value) {
				return type;
			}
		}
		return null;
	}
	
	public static AtmCircuitTypeEnum getApproveStatEnumByValue(String value) {
		for (AtmCircuitTypeEnum type : AtmCircuitTypeEnum.values()) {
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
