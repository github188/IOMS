package cn.com.atnc.ioms.enums.duty.satellite;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.duty.atm.HaveNoEnum;
import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 十里河-PES-PES网管设备状态枚举
 * 
 * @author shijiyong
 * @date 2016年10月13日 下午2:12:20
 * @version 1.0, 2016年10月13日 下午2:12:20
 */
public enum OnOff {
	Online("Online"), Offline("Offline");

	private String value;

	public String getValue() {
		return value;
	}

	private OnOff(String value) {
		this.value = value;
	}

	public static OnOff getInstance(String value) {
		OnOff[] hn = OnOff.values();
		for (OnOff status : hn) {
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
