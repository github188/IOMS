package cn.com.atnc.ioms.enums.turndutymng;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;
/**
 * 
 * @author hantianyu
 *
 */
public enum SignLeaveStatusEnum {
	
	LATE("迟到"),
	EARLY("早退"),
	NORMAL("正常"),
	UNNORMAL("不正常");
    
	private String value;
    public String getValue(){
        return this.value;
    }
    private SignLeaveStatusEnum(String value) {
        this.value = value;
    }
    
	public static SignLeaveStatusEnum getInstance(String value) {
		SignLeaveStatusEnum[] signLeaveStatusEnum = SignLeaveStatusEnum.values();
		for(SignLeaveStatusEnum status : signLeaveStatusEnum) {
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
