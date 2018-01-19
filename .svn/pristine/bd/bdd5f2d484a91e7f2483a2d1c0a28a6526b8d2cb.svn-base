package cn.com.atnc.ioms.enums.duty.environment;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 设备类型枚举类
 * @author renyujuan
 * @date 2016年8月3日下午1:54:46
 */
public enum SatelliteEquip {

	SateInstruments("仪器仪表清查")
	;
	private String value;
	public String getValue(){
		return value;
	}
	
	private SatelliteEquip(String value){
		this.value=value;
	}
	
	public static SatelliteEquip getInstance(String value){
		SatelliteEquip[] ets=SatelliteEquip.values();
		for(SatelliteEquip result : ets){
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
