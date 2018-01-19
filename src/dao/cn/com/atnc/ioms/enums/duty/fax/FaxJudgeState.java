package cn.com.atnc.ioms.enums.duty.fax;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

public enum FaxJudgeState {

	PASS("通过"),
	WAIT("待审核"),
	BACK("退回");
	private String value;
	public String getValue() {
		return value;
	}
	
	private FaxJudgeState(String value) {
		this.value = value;
	}
	
	public static FaxJudgeState getInstance(String value) {
		FaxJudgeState[] faxJudgeState = FaxJudgeState.values();
		for(FaxJudgeState status : faxJudgeState) {
			if(StringUtils.equalsIgnoreCase(status.getValue(), value)) {
				return status;
			}
		}
		throw new IllegalArgumentException("value值非法，没有符合工作状态的枚举对象");
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
