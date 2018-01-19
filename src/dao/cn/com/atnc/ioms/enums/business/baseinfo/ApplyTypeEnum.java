package cn.com.atnc.ioms.enums.business.baseinfo;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 申请类型枚举类
 *
 * @author ku
 * @date 2015年5月13日 下午2:20:37
 * @since 1.0.0
 */
public enum ApplyTypeEnum {

	satellite_ku("卫星通信网地球站"), datacomnetwork("数据通信网"), telegraph("转报地址"), telegraph_circuit(
			"转报电路"), formalcircuit_ku("KU正式电路"), formalcircuit_atm("ATM正式电路"), formalcircuit_tes(
			"TES正式电路"), formalcircuit_pes("PES正式电路"),transfernet("自动转报网"),signoutnet_atm("ATM退网"),
			signoutnet_pes("PES系统退网"),signoutnet_tes("TES系统退网"),signoutnet_ku("ku系统退网");

	private String value;

	private ApplyTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static ApplyTypeEnum getApplyTypeEnumByOrdinal(int value) {
		for (ApplyTypeEnum type : ApplyTypeEnum.values()) {
			if (type.ordinal() == value) {
				return type;
			}
		}
		return null;
	}

	public static ApplyTypeEnum getApplyTypeEnumByValue(String value) {
		for (ApplyTypeEnum type : ApplyTypeEnum.values()) {
			if (StringUtils.equals(type.value, value)) {
				return type;
			}
		}
		return null;
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
