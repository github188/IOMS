package cn.com.atnc.ioms.enums.business.formalcircuit;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

 /**
 * 申请操作类型枚举
 *
 * @author Wang zhicheng
 * @date 2015年5月15日 下午3:31:47
 * @since 1.0.0
 */
public enum ApplyOptTypeEnum {

	add("新增"),del("取消"),mod("变更");

	private String value;

	private ApplyOptTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static ApplyOptTypeEnum getApproveStatEnumByOrdinal(int value) {
		for (ApplyOptTypeEnum type : ApplyOptTypeEnum.values()) {
			if (type.ordinal() == value) {
				return type;
			}
		}
		return null;
	}
	
	public static ApplyOptTypeEnum getApproveStatEnumByValue(String value) {
		for (ApplyOptTypeEnum type : ApplyOptTypeEnum.values()) {
			if (StringUtils.equals(type.value,value)) {
				return type;
			}
		}
		return null;
	}
	 
	public String toString() {
		return value;
	}
	
	@JsonValue
	public EnumModel toEnumModel(){
		EnumModel em = new EnumModel();
		em.setName(this.name());
		em.setOrdinal(this.ordinal());
		em.setValue(this.getValue());
		
		return em;
	}
	
}
