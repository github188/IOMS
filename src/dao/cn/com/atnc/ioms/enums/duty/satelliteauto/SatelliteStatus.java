package cn.com.atnc.ioms.enums.duty.satelliteauto;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.duty.atm.HaveNoEnum;
import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 卫星自检状态枚举类
 *
 * @author 段衍林
 * @2016年11月11日 上午11:25:08
 */
public enum SatelliteStatus {
	
	normal("正常"), 
	unnormal("异常"), 
	
	OK("正常"), 
	FLT("异常"), 
	
	
	Failed("Failed"),
	Alarm("Alarm"),
	Alm("异常"),
	
	on("长亮"),
	off("不亮"),
	
	up("正常"),
	down("异常"),
	
	online("正常存在"),
	offline("TCP连接消失"),
	
	GOOD("GOOD"),
	FAULT("FAULT"), 
	;

	private String value;

	public String getValue() {
		return value;
	}

	private SatelliteStatus(String value) {
		this.value = value;
	}

	public static HaveNoEnum getInstance(String value) {
		HaveNoEnum[] hn = HaveNoEnum.values();
		for (HaveNoEnum status : hn) {
			if (StringUtils.equalsIgnoreCase(status.getValue(), value)) {
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
