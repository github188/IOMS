package cn.com.atnc.ioms.enums.duty.fax;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;
/**
 * 枚举：正常、异常
 *
 * @author 韩天驭
 * @2017年2月3日 下午4:11:57
 */
public enum FaxStatusHXT {
	
	NORMAL("正常"),
	ABNORMAL("异常");
	private String value;
	public String getValue() {
		return value;
	}
	
	private FaxStatusHXT(String value) {
		this.value = value;
	}
	
	public static FaxStatusHXT getInstance(String value) {
		FaxStatusHXT[] faxStatusHXT = FaxStatusHXT.values();
		for(FaxStatusHXT status : faxStatusHXT) {
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
