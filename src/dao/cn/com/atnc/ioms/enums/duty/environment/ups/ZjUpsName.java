package cn.com.atnc.ioms.enums.duty.environment.ups;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 总局ups设备名称枚举类
 * @author renyujuan
 * @date 2016年8月2日下午12:13:53
 */
public enum ZjUpsName {

	ZJUPS("总局30KVA UPS");
	
	private String value;
	public String getValue(){
		return value;
	}
	
	private ZjUpsName(String value){
		this.value=value;
	}
	
	public static ZjUpsName getInstance(String value){
		ZjUpsName[] zjUpsNames=ZjUpsName.values();
		for(ZjUpsName result : zjUpsNames){
			if(StringUtils.equalsIgnoreCase(result.getValue(), value)){
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
