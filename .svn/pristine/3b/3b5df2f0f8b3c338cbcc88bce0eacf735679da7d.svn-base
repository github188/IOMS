package cn.com.atnc.ioms.enums.phonemng;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;
/**
 * 
 * @author hantianyu
 *
 */
public enum CallStateEnum {
	DEALING("接听"),
	NOTDEAL("振铃未接听"),
	LEAK("ivr放弃"),
	QUEUELEAK("排队放弃"),
	BLACKLIST("黑名单"),
	VOICEMAIL("留言"),
	UNLINK("挂机");
    
	private String value;
    public String getValue(){
        return this.value;
    }
    private CallStateEnum(String value) {
        this.value = value;
    }
    
	public static CallStateEnum getInstance(String value) {
		CallStateEnum[] callStateEnum = CallStateEnum.values();
		for(CallStateEnum status : callStateEnum) {
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
