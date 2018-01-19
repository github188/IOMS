package cn.com.atnc.ioms.enums.duty.fax;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.duty.ReduncdancyStatus;
import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;
/**
 * 状态枚举：正常、不正常
 *
 * @author 韩天驭
 * @2017年1月22日 下午3:51:23
 */
public enum FaxStatus {
	
	NORMAL("正常"),
	ABNORMAL("不正常");
	private String value;
	public String getValue() {
		return value;
	}
	
	private FaxStatus(String value) {
		this.value = value;
	}
	
	public static FaxStatus getInstance(String value) {
		FaxStatus[] faxStatus = FaxStatus.values();
		for(FaxStatus status : faxStatus) {
			if(StringUtils.equalsIgnoreCase(status.getValue(), value)) {
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
