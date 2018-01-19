package cn.com.atnc.ioms.enums.duty.satellite;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.duty.atm.HaveNoEnum;
import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 十里河-PES-PES网管设备状态枚举
 * 
 * @author shijiyong
 * @date 2016年10月13日 下午2:13:39
 * @version 1.0, 2016年10月13日 下午2:13:39
 */
public enum LR {
	L("L(主用)"), R("R(备用)");

	private String value;

	public String getValue() {
		return value;
	}

	private LR(String value) {
		this.value = value;
	}

	public static LR getInstance(String value) {
		LR[] hn = LR.values();
		for (LR status : hn) {
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
