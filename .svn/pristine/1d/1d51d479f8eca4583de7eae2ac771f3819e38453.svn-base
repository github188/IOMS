package cn.com.atnc.ioms.enums.duty.environment.ups;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 十里河，双井，财富ups设备名称
 * @author renyujuan
 * @date 2016年7月29日下午1:07:53
 */
public enum SlhUpsName {

	SLHKVAF("十里河120KVA UPS 1号机"),
	SLHKVAS("十里河120KVA UPS 2号机"),
	SLHJH("十里河军航20KVA UPS"),
	SJKVAE("双井80KVA UPS"),
	SJKVAN("双井90KVA UPS"),
	CFKVA("财富中心40KVA UPS");
	private String value;
	public String getValue(){
		return value;
	}
	private SlhUpsName(String value){
		this.value=value;
	}
	
	public static SlhUpsName getInstance(String value){
		SlhUpsName[] slhUpsName=SlhUpsName.values();
		for(SlhUpsName result : slhUpsName ){
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
