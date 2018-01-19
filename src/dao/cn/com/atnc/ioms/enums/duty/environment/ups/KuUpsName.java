package cn.com.atnc.ioms.enums.duty.environment.ups;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

public enum KuUpsName {
	
	KU("KU实验室6KVA UPS"),
	ATM("ATM实验室6KVA UPS"),
	KUATM("KU/ATM实验室6KVA UPS"),
	JH("军航6KVA UPS"),
	WKYJZM("网控应急照明6KVA UPS"),
	JF("UPS机房6KVA UPS");
	
	private String value;
	public String getValue(){
		return value;
	}
	
	private KuUpsName(String value){
		this.value=value;
	}
	
	public static KuUpsName getInstance(String value){
		KuUpsName[] kuUpsName=KuUpsName.values();
		for(KuUpsName result : kuUpsName ){
			if(StringUtils.equalsIgnoreCase(result.getValue(), value)) {
				return result;
			}
		}
		throw new IllegalArgumentException("value值非法，没有符合冗余状态的枚举对象");
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
