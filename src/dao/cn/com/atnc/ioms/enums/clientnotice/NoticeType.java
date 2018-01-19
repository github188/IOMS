package cn.com.atnc.ioms.enums.clientnotice;
/**
 *类说明:客户通知枚举类
 *@author lizhisheng
 *@date 2014-4-16	下午6:20:20
 */
public enum NoticeType {
	SMS("短信"), MAIL("邮件"), ALL("短信和邮件");

	private String value;


	public String getValue() {
		return value;
	}


	private NoticeType(String value) {
		this.value = value;
	}
}
