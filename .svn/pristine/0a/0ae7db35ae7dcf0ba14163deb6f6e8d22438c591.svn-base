package cn.com.atnc.ioms.enums.phonemng;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;


public enum ContactStatusEnum {
	
	WHITE("白名单"),
	BLACK("黑名单");
    
	private String value;
    public String getValue(){
        return this.value;
    }
    private ContactStatusEnum(String value) {
        this.value = value;
    }
    
	public static ContactStatusEnum getInstance(String value) {
		ContactStatusEnum[] contactStatusEnum = ContactStatusEnum.values();
		for(ContactStatusEnum status : contactStatusEnum) {
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
