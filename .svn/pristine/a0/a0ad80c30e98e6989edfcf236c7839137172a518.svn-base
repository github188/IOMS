/**
 * @Title:AtmType.java
 * @author shijiyong
 * @data 2016年9月26日下午3:54:05
 * @version v1.0
 */
package cn.com.atnc.ioms.enums.duty.atm;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**   
 *  ATM巡检设备  
 * @author shijiyong
 * @date 2016年9月26日 下午3:54:05
 * @version   
 *       1.0, 2016年9月26日 下午3:54:05   
 */
public enum AtmDayTypeEnum {

	ROUTER("业务路由器"),
	MGX("MGX交换机");
	
	private String value;
	public String getValue(){
		return value;
	}
	
	private AtmDayTypeEnum(String value){
		this.value=value;
	}
	
	public static AtmDayTypeEnum getInstance(String value){
		AtmDayTypeEnum[] ccs=AtmDayTypeEnum.values();
		for(AtmDayTypeEnum result : ccs){
			if(StringUtils.equalsIgnoreCase(result.getValue(), value)){
				return result;
			}
		}
		throw new IllegalArgumentException("value值非法，没有符合工作状态的枚举对象");
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
