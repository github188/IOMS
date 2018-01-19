package cn.com.atnc.ioms.enums.faultmng;

/**
 * 事件单评价状态
 *
 * @author 段衍林
 * @2016年11月9日 下午2:31:01
 */
public enum FaultEvaluateStatus {

	UNEVALUATE("待评价"),
	
	EVALUATE("已评价")
	;

	private String value;

	private FaultEvaluateStatus(String value) {
		this.value = value;
	}

	public String getName() {
		return name();
	}

	public String getValue() {
		return this.value;
	}
}