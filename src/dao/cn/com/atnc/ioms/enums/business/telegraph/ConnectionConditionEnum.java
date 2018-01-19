package cn.com.atnc.ioms.enums.business.telegraph;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;


/**
 * 终端连接情况枚举
 * @author WangLingbin
 * @date 2015年6月18日 上午9:10:31
 * @since 1.0.0
 */
public enum ConnectionConditionEnum {
	
	local("本地空管"),
	sita("SITA"),
	other("其他");
	private String value;
	private ConnectionConditionEnum(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
	
	/**
	 * 根据枚举值获取枚举对象
	 * @param value
	 * @author WangLingbin
	 * @date  2016年2月3日下午1:36:58
	 * @since 1.0.0
	 */
	public static ConnectionConditionEnum getConnectionConditionEnumByValue(String value) {
		List<ConnectionConditionEnum> connectionConditionEnums = Arrays.asList(ConnectionConditionEnum.values());
		ConnectionConditionEnum connectionConditionEnum = null;
		for(ConnectionConditionEnum conditionEnum : connectionConditionEnums) {
			if(StringUtils.equalsIgnoreCase(conditionEnum.getValue(), value)) {
				connectionConditionEnum = conditionEnum;
				break;
			}
		}
		return connectionConditionEnum;
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
