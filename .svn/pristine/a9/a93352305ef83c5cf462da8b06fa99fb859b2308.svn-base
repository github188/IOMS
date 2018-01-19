package cn.com.atnc.ioms.enums.duty.atm;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 城市枚举
 * 
 * @author 王凌斌
 * @2017年2月9日 下午3:18:44
 */
public enum CityEnum {

	CHENGDU("成都"), GUANGZHOU("广州"), SHOUDU("首都机场"), SHANGHAI("上海"), SHENYANG(
			"沈阳"), XIAN("西安"), WULUMUQI("乌鲁木齐"), SANYA("三亚") ;

	private String value;

	public String getValue() {
		return value;
	}

	private CityEnum(String value) {
		this.value = value;
	}

	public static CityEnum getInstance(String value) {
		CityEnum[] hn = CityEnum.values();
		for (CityEnum status : hn) {
			if (StringUtils.equalsIgnoreCase(status.getValue(), value)) {
				return status;
			}
		}
		throw new IllegalArgumentException("value值非法，没有符合工作状态的枚举对象");
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
