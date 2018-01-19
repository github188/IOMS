package cn.com.atnc.ioms.enums.faultmng;

/**
 * 故障单来源
 * 
 * @author duanyanlin 2016年6月17日 下午2:04:42
 */
public enum FaultOriginType {
	OFFPOPUP("摘机弹窗"),

	YUZHIALARM("阈值告警"),

	MANUALADD("手动添加"),

	KUALARM("KU维保告警");

	private String value;

	private FaultOriginType(String value) {
		this.value = value;
	}

	public String getName() {
		return name();
	}

	public String getValue() {
		return this.value;
	}
}