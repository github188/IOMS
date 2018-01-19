package cn.com.atnc.ioms.enums.maintain.month;

/**
 * KU月度报告统计纬度枚举类
 * 
 * @author 王凌斌
 * @2017年1月24日 上午11:00:53
 */
public enum KuMonthReportLegendEnum {

	RXLEVEL("接收电平"), EBNO("EB/NO"), WAFR08("WA-FR08故障"), MODEM("MODEM故障"), ERRORRATE(
			"误码率");
	private String value;

	public String getValue() {
		return value;
	}

	private KuMonthReportLegendEnum(String value) {
		this.value = value;
	}
}
