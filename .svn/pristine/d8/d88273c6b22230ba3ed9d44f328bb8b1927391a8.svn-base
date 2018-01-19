/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName GradeEnum.java
 * @PackageName:cn.com.atnc.pcsp.enums.business.evaluate
 * @author ku
 * @date 2015年5月26日下午3:28:46
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.enums.business.evaluate;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 评价等级枚举类
 *
 * @author ku
 * @date 2015年5月26日 下午3:28:46
 * @since 1.0.0
 */
public enum GradeEnum {
	
	very_satisfied("非常满意"),satisfied("满意"),soso("一般"),very_soso("不满意");
	
	private String value;

	private GradeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static GradeEnum getGradeEnumByOrdinal(int value) {
		for (GradeEnum type : GradeEnum.values()) {
			if (type.ordinal() == value) {
				return type;
			}
		}
		return null;
	}
	
	public static GradeEnum getGradeEnumByValue(String value) {
		for (GradeEnum type : GradeEnum.values()) {
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
