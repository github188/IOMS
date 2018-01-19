package cn.com.atnc.ioms.enums.turndutymng;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

public enum TimePmHourEnum {
	
	sixteen("16"),
	seventeen("17"),
	eighteen("18"),
	nineteen("19"),
	twenty("20");
    
	private String value;
    public String getValue(){
        return this.value;
    }
    private TimePmHourEnum(String value) {
        this.value = value;
    }
    
	public static TimePmHourEnum getInstance(String value) {
		TimePmHourEnum[] timePmHourEnum = TimePmHourEnum.values();
		for(TimePmHourEnum status : timePmHourEnum) {
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
