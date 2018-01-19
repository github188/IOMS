package cn.com.atnc.ioms.enums.duty.satellite;

import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 卫星工具状态
 *
 * @author 段衍林
 * @2016年11月29日 上午9:50:39
 */
public enum ToolStatus {
	STORE("入库"), LEND("借出");

	private String value;

	public String getValue() {
		return value;
	}

	private ToolStatus(String value) {
		this.value = value;
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
