package cn.com.atnc.ioms.enums.turndutymng;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

public enum TimeAmHourEnum {
	eight("8"),
	nine("9"),
	ten("10"),
	eleven("11"),
	twelve("12");
    
	private String value;
    public String getValue(){
        return this.value;
    }
    private TimeAmHourEnum(String value) {
        this.value = value;
    }
    
	public static TimeAmHourEnum getInstance(String value) {
		TimeAmHourEnum[] timeAmHourEnum = TimeAmHourEnum.values();
		for(TimeAmHourEnum status : timeAmHourEnum) {
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
