package cn.com.atnc.ioms.enums.duty;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;
/**
 * 审核状态：待审核wait、通过pass、退回back
 *
 * @author 韩天驭
 * @2017年2月6日 上午11:17:49
 */
public enum JudgeStatus {
    
	WAIT("待审核"),
	PASS("通过"),
	BACK("退回");
	
	private String value;
	public String getValue() {
		return value;
	}
	
	private JudgeStatus(String value) {
		this.value = value;
	}
	
	public static JudgeStatus getInstance(String value) {
		JudgeStatus[] judgeStatus = JudgeStatus.values();
		for(JudgeStatus status : judgeStatus) {
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
