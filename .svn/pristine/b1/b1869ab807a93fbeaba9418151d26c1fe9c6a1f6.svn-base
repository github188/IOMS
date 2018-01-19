package cn.com.atnc.ioms.enums.duty.satellite;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.duty.atm.HaveNoEnum;
import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 通信基地-TES-查看网管同步状态巡检内容
 *
 * @author 段衍林
 * @2016年11月10日 下午12:57:27
 */
public enum TxjdSynEquip {
	TES081("TES081"), TES281("TES281"), TES381("TES381"), TES481("TES481");

	private String value;

	public String getValue() {
		return value;
	}

	private TxjdSynEquip(String value) {
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
