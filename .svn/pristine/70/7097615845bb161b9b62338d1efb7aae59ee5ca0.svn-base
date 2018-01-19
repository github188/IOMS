package cn.com.atnc.ioms.enums.business.signoutnet;

import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 退网操作类型
 *
 * @author 段衍林
 * @2017年1月10日 上午10:31:30
 */
public enum SignoutNetTypeEnum {

	signoutnet_atm("民航ATM数据通信网节点"), signoutnet_pes("民航卫星通信网_PES系统"), signoutnet_tes(
			"民航卫星通信网_TES系统"), signoutnet_ku("民航卫星通信网_KU系统");
	private String value;

	private SignoutNetTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

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
