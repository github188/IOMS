package cn.com.atnc.ioms.enums.turndutymng;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.duty.ReduncdancyStatus;
import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

public enum DutyPlaceEnum {
	
	COMMUNICATION("通信基地"),
	SHILIHE("十里河"),
	GENERALOFFICE("总局");
    
	private String value;
    public String getValue(){
        return this.value;
    }
    private DutyPlaceEnum(String value) {
        this.value = value;
    }
    
	public static DutyPlaceEnum getInstance(String value) {
		DutyPlaceEnum[] dutyPlaceEnum = DutyPlaceEnum.values();
		for(DutyPlaceEnum status : dutyPlaceEnum) {
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
