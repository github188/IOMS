package cn.com.atnc.ioms.enums.duty.satelliteauto;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.duty.atm.HaveNoEnum;
import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 卫星自检数据解析参数类型
 *
 * @author 段衍林
 * @2016年11月29日 下午3:32:46
 */
public enum SatelliteCheckType {

	TxPower("TxPower"), LinkParas("LinkParas"), VitacomOdu("VitacomOdu"), KuEfdataRju(
			"KuEfdataRju"), CAgilisRcu("CAgilisRcu"), ;

	private String value;

	public String getValue() {
		return value;
	}

	private SatelliteCheckType(String value) {
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
