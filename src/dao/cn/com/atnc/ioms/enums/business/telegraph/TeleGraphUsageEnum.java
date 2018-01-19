/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName ApproveStatEnum.java
 * @PackageName:cn.com.atnc.pcsp.enums.business.satellite
 * @author ku
 * @date 2015年5月13日下午3:04:19
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.enums.business.telegraph;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;


/**
 * 转报及路由地址入网申请审批状态枚举类
 * @author WangLingbin
 * @date 2015年5月29日 下午2:04:41
 * @since 1.0.0
 */
public enum TeleGraphUsageEnum {

	ZhanDiao("站调"),TaTai("塔台"),ZhiJi("值机"),XingLi("行李查询"),
	PeiZai("配载"),HuoYun("货运"),GongWu("公务机"),QianPai("签派"),
	QiXiang("气象"),ZhuanBao("转报"),QingBao("情报"),Other("其他");
	
	private String value;

	private TeleGraphUsageEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static TeleGraphUsageEnum getApproveStatEnumByOrdinal(int value) {
		for (TeleGraphUsageEnum type : TeleGraphUsageEnum.values()) {
			if (type.ordinal() == value) {
				return type;
			}
		}
		return null;
	}
	
	public static TeleGraphUsageEnum getApproveStatEnumByValue(String value) {
		for (TeleGraphUsageEnum type : TeleGraphUsageEnum.values()) {
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
