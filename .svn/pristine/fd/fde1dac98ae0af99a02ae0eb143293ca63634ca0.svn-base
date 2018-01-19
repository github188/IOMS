package cn.com.atnc.ioms.enums.duty.satelliteauto;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.duty.atm.HaveNoEnum;
import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 卫星自检参数评价标准
 *
 * @author 段衍林
 * @2016年11月14日 下午12:58:19
 */
public enum SatelliteAlarmType {
	
	TesOccTop("15"), 
	TesOduState("OK"), 
	TXFreqATop("6205"), 
	RXFreqATop("3980"), 
	TXFreqBTop("6205"), 
	RXFreqBTop("3980"), 
	KuOduTempLower("64"), 
	KuRxLevelTop("3"), 
	KuRxLevelLower("-3"), 
	KuEbNoLower("9"), 
	KuNoisePeakLower("10"), 
	OverSeaMainLower("10"), 
	SlhPesLower("15"), 
	DsRecieve("3990"), 
	DsTransmit("6215"), 
	;

	private String value;

	public String getValue() {
		return value;
	}

	private SatelliteAlarmType(String value) {
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
