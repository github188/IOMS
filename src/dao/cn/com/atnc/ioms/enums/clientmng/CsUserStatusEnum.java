package cn.com.atnc.ioms.enums.clientmng;
/**
 *类说明
 *@author 潘涛
 *@date 2014-3-19	下午2:17:46
 *@version:1.0
 */
public enum CsUserStatusEnum {
	REGISTED("已注册"){},
	PASSED("审核通过"){},
	DENIED("审核不通过"){},
	APPLYOFF("申请注销"){},
	DISABLED("失效"){},;
	private String value;

	private CsUserStatusEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	
}
