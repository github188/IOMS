package cn.com.atnc.ioms.enums.phonemng;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

public enum CallIsDel {
	DEL("已删除"),
	NOTDEL("未删除");

	private String value;
    public String getValue(){
        return this.value;
    }
    private CallIsDel(String value) {
        this.value = value;
    }
    
	public static CallIsDel getInstance(String value) {
		CallIsDel[] callIsDel = CallIsDel.values();
		for(CallIsDel status : callIsDel) {
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
