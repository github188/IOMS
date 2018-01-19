package cn.com.atnc.ioms.enums.duty;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;


/**
 * 冗余状态枚举类
 * @author WangLingbin
 * @date 2016年1月8日 上午10:18:33
 * @since 1.0.0
 */
public enum ReduncdancyStatus {

	MAIN("主用"),SPARE("备用");
	
	private String value;
	public String getValue() {
		return value;
	}
	private ReduncdancyStatus(String value) {
		this.value = value;
	}
	
	public static ReduncdancyStatus getInstance(String value) {
		ReduncdancyStatus[] reduncdancyStatus = ReduncdancyStatus.values();
		for(ReduncdancyStatus status : reduncdancyStatus) {
			if(StringUtils.equalsIgnoreCase(status.getValue(), value)) {
				return status;
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
