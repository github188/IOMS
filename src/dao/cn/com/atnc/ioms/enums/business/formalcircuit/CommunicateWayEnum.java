package cn.com.atnc.ioms.enums.business.formalcircuit;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

 /**
 * 通信方式枚举
 *
 * @author Wang zhicheng
 * @date 2015年5月15日 下午3:31:47
 * @since 1.0.0
 */
public enum CommunicateWayEnum {

	synchronization("同步"),asynchronous("异步"),bothway("双向"),broadcast("广播");

	private String value;

	private CommunicateWayEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static CommunicateWayEnum getApproveStatEnumByOrdinal(int value) {
		for (CommunicateWayEnum type : CommunicateWayEnum.values()) {
			if (type.ordinal() == value) {
				return type;
			}
		}
		return null;
	}
	
	public static CommunicateWayEnum getApproveStatEnumByValue(String value) {
		for (CommunicateWayEnum type : CommunicateWayEnum.values()) {
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
