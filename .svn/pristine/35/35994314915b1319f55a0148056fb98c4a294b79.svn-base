package cn.com.atnc.ioms.enums.duty.satelliteauto;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.duty.atm.HaveNoEnum;
import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 卫星巡检设备列表
 *
 * @author 段衍林
 * @2016年11月10日 下午12:57:27
 */
public enum SatelliteDayAutoType {
	txjdTesOCC("通信基地TES OCC"), txjdTesODU("通信基地TES ODU"),
	txjdKu("通信基地KU卫星"), txjdOverseaMain("通信基地境外站主站载波"),
	txjdOverseaCDM("通信基地境外站主站CDM570"), txjdOverseaHW("通信基地境外站主站华为路由器"),
	txjdTesLink("通信基地TES链路"), txjdRadarLink("通信基地雷达广播TES链路"),
	slhPES("十里河PES出境载波"), slhODU("十里河PES主站ODU"),
	dsPES("东四民航局TES链路状态"), dsODU("东四民航局TES ODU状态"),
	;

	private String value;

	public String getValue() {
		return value;
	}

	private SatelliteDayAutoType(String value) {
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
