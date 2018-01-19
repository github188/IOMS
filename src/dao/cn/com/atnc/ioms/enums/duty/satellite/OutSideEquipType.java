package cn.com.atnc.ioms.enums.duty.satellite;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.duty.atm.HaveNoEnum;
import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 室外设备种类
 *
 * @author 段衍林
 * @2016年11月17日 下午3:01:55
 */
public enum OutSideEquipType {
	
	TxjdOutTesEquip("通信基地-TES-室外设备"), 
	TxjdOutKuEquip("通信基地-KU-室外设备"), 
	MhjOutTesEquip("民航局-TES-室外设备"), 
	SlhOutKuEquip("十里河-KU-室外设备"), 
	;

	private String value;

	public String getValue() {
		return value;
	}

	private OutSideEquipType(String value) {
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
