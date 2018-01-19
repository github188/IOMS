package cn.com.atnc.ioms.enums.faultmng;

/**
 * 故障级别
 * @author duanyanlin
 * 2016年6月28日 下午3:19:28
 */
public enum SubmitType {
	
	temporary("暂存"),

	engineersubmit("技术工程师提交"),

	submit("提交");

	private String value;

	private SubmitType(String value) {
		this.value = value;
	}
	public String getName() {
		return name();
	}

	public String getValue() {
		return this.value;
	}
}