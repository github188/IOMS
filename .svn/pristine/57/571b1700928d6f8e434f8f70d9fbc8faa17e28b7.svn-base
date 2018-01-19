package cn.com.atnc.ioms.enums.duty.environment;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 检查结果枚举类
 * @author renyujuan
 * @date 2016年7月6日上午9:22:44
 */
public enum CheckResult {

	NORMAL("正常"),INNORMAL("异常");
	private String value;
	public String getValue(){
		return value;
	}
	
	private CheckResult(String value){
		this.value=value;
	}
	
	public static CheckResult getInstance(String value){
		CheckResult[] checkResult=CheckResult.values();
		for(CheckResult result : checkResult ){
			if(StringUtils.equalsIgnoreCase(result.getValue(), value)) {
				return result;
			}
		}
		throw new IllegalArgumentException("value值非法，没有符合冗余状态的枚举对象");
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
