package cn.com.atnc.ioms.enums.duty.fax;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

public enum FaxHXTProjectName {
	Enqueued("Messages Enqueued"),Dequeued("Messages Dequeued");
	private String value;
	public String getValue() {
		return value;
	}
	
	private FaxHXTProjectName(String value) {
		this.value = value;
	}
	
	public static FaxHXTProjectName getInstance(String value) {
		FaxHXTProjectName[] faxHXTProjectName = FaxHXTProjectName.values();
		for(FaxHXTProjectName status : faxHXTProjectName) {
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
