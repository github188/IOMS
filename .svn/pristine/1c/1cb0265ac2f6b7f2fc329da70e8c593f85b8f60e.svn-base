/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName ApplyTypeEnum.java
 * @PackageName:cn.com.atnc.pcsp.enums.business
 * @author ku
 * @date 2015年5月13日下午2:20:37
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.enums.business.baseinfo;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 附件上传来源枚举类
 *
 * @author WangLingbin
 * @date 2015年10月28日 下午1:21:12
 * @since 1.0.0
 */
public enum AttachSourceEnum {

	USER("用户"),AREA("地区");
	
	private String value;

	private AttachSourceEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static AttachSourceEnum getApplyTypeEnumByOrdinal(int value) {
		for (AttachSourceEnum type : AttachSourceEnum.values()) {
			if (type.ordinal() == value) {
				return type;
			}
		}
		return null;
	}
	
	public static AttachSourceEnum getApplyTypeEnumByValue(String value) {
		for (AttachSourceEnum type : AttachSourceEnum.values()) {
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
