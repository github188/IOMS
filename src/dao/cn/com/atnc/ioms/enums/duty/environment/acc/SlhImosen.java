package cn.com.atnc.ioms.enums.duty.environment.acc;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 十里河网控中心艾默生精密空调名称枚举类
 * @author renyujuan
 * @date 2016年8月10日下午4:02:19
 */
public enum SlhImosen {

	SLHWEST("十里河网控中心西侧艾默生精密空调"),
	SLHEAST("十里河网控中心东侧艾默生精密空调"),
	SLHNORTH("十里河网控中心北侧艾默生精密空调");
	
	private String value;
	public String getValue(){
		return value;
	}
	
	private SlhImosen(String value){
		this.value = value;
	}
	
	public static SlhImosen getInstance(String value){
		SlhImosen[] slhImosens = SlhImosen.values();
		for(SlhImosen result : slhImosens){
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
