package cn.com.atnc.ioms.enums.duty.satellite;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.duty.atm.HaveNoEnum;
import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

public enum Dec {
	ACTPRI("ACT PRI"), ACTSEC("ACT SEC"), STAPRI("STA PRI"), STASEC("STASEC");

	private String value;

	public String getValue() {
		return value;
	}

	private Dec(String value) {
		this.value = value;
	}

	public static Dec getInstance(String value) {
		Dec[] hn = Dec.values();
		for (Dec status : hn) {
			if (StringUtils.equalsIgnoreCase(status.getValue(), value)) {
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
