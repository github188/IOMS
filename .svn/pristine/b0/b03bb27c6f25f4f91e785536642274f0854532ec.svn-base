/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName ApproveStatEnum.java
 * @PackageName:cn.com.atnc.pcsp.enums.business.satellite
 * @author ku
 * @date 2015年5月13日下午3:04:19
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.enums.business.satellite;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * ku卫星网远端站入网申请审批状态枚举类
 *
 * @author ku
 * @date 2015年5月13日 下午3:04:19
 * @since 1.0.0
 */
public enum KuSatelliteAttachEnum {

	one("《民航局台址批复》"),two("《无线电台执照》"),
	three("《设备安装竣工验收材料》"),four("《卫星地球站天线入网验证证明》"),
	five("《无线电发射设备型号核准证》"),six("《地区网络中心审批表》"),seven("《用户补充信息》");
	private String value;

	private KuSatelliteAttachEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static KuSatelliteAttachEnum getApproveStatEnumByOrdinal(int value) {
		for (KuSatelliteAttachEnum type : KuSatelliteAttachEnum.values()) {
			if (type.ordinal() == value) {
				return type;
			}
		}
		return null;
	}
	
	public static KuSatelliteAttachEnum getApproveStatEnumByValue(String value) {
		for (KuSatelliteAttachEnum type : KuSatelliteAttachEnum.values()) {
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
