package cn.com.atnc.ioms.enums.duty.satellite;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.duty.atm.HaveNoEnum;
import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 通信基地-TES-TES网管工作站主备状态结果
 *
 * @author 段衍林
 * @2016年11月10日 下午12:57:27
 */
public enum TxjdMainResult {
	ACT_PRI("ACT PRI"), ACT_SEC("ACT SEC"), STA_PRI("STA PRI"), STA_SEC(
			"STA SEC");

	private String value;

	public String getValue() {
		return value;
	}

	private TxjdMainResult(String value) {
		this.value = value;
	}

	public static HaveNoEnum getInstance(String value) {
		HaveNoEnum[] hn = HaveNoEnum.values();
		for (HaveNoEnum status : hn) {
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
