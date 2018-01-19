package cn.com.atnc.ioms.enums.phonemng;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 
 * @author hantianyu
 *
 */
public enum AgentStateEnum {
	SIGNOUT("签出"),
	LOGIN("已登录"),
	NOTLOGIN("未登录");

	private String value;
    public String getValue(){
        return this.value;
    }
    private AgentStateEnum(String value) {
        this.value = value;
    }
    
	public static AgentStateEnum getInstance(String value) {
		AgentStateEnum[] agentStateEnum = AgentStateEnum.values();
		for(AgentStateEnum status : agentStateEnum) {
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
