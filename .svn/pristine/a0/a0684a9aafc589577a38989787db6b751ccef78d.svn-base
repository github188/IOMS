package cn.com.atnc.ioms.enums.duty.environment.dg;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;
import jodd.util.StringUtil;

/**
 * 柴油发电机设备名称枚举类
 * 
 * @author renyujuan
 * @date 2016年8月9日下午1:09:38
 */
public enum DgName {

	NUMONE("一号机"), NUMTWO("二号机");

	private String value;

	public String getValue() {
		return value;
	}

	private DgName(String value) {
		this.value = value;

	}
	
	public static DgName getInstance(String value){
		DgName[] dgNames = DgName.values();
		for(DgName result : dgNames) {
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
