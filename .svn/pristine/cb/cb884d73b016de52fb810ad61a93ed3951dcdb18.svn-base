package cn.com.atnc.ioms.enums.phonemng;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;


public enum PhoneTypeEnum {
	
	YES("正常咨询"),
	ANNOY("骚扰电话");
    
	private String value;
    public String getValue(){
        return this.value;
    }
    private PhoneTypeEnum(String value) {
        this.value = value;
    }
    
	public static PhoneTypeEnum getInstance(String value) {
		PhoneTypeEnum[] contactStatusEnum = PhoneTypeEnum.values();
		for(PhoneTypeEnum status : contactStatusEnum) {
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
