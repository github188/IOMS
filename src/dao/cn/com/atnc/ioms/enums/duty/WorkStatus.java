package cn.com.atnc.ioms.enums.duty;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 工作状态
 * @author WangLingbin
 * @date 2016年1月8日 上午10:20:53
 * @since 1.0.0
 */
public enum WorkStatus {

	OK("OK"),NA("NA");
	
	private String value;
	public String getValue() {
		return value;
	}
	
	private WorkStatus(String value) {
		this.value = value;
	}
	
	public static WorkStatus getInstance(String value) {
		WorkStatus[] workStatus = WorkStatus.values();
		for(WorkStatus status : workStatus) {
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
