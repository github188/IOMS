package cn.com.atnc.ioms.enums.phonemng;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

public enum CallAgentStateEnum {
	NOTLINE("离线"),
	ONLINE("上线"),
	SETBUSY("忙碌"),
	SETREST("小休"),
	FREE("空闲"),
	PHONE("通话中");

	private String value;
    public String getValue(){
        return this.value;
    }
    private CallAgentStateEnum(String value) {
        this.value = value;
    }
    
	public static CallAgentStateEnum getInstance(String value) {
		CallAgentStateEnum[] callAgentStateEnum = CallAgentStateEnum.values();
		for(CallAgentStateEnum status : callAgentStateEnum) {
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
