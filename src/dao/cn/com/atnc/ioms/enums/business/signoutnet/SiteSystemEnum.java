package cn.com.atnc.ioms.enums.business.signoutnet;

import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 站点所属系统
 *
 * @author 段衍林
 * @2017年1月10日 上午10:31:30
 */
public enum SiteSystemEnum {

	PES("PES系统"), TES("TES系统"), KU("KU系统");
	private String value;

	private SiteSystemEnum(String value) {
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
