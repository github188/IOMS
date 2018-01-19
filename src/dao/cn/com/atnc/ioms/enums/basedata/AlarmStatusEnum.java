/**
 * @ProjectName IOMS
 * @FileName AlarmStatusEnum.java
 * @PackageName:cn.com.atnc.ioms.enums.basedata
 * @author KuYonggang
 * @date 2015年4月22日上午9:15:22
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.enums.basedata;

/**
 * 告警状态枚举类
 *
 * @author KuYonggang
 * @date 2015年4月22日 上午9:15:22
 * @since 1.0.0
 */
public enum AlarmStatusEnum {

	normal("正常"),unnormal("异常");
	
	private String value;

	private AlarmStatusEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}	
}
