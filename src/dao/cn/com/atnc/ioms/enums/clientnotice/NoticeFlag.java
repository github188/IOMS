package cn.com.atnc.ioms.enums.clientnotice;

/**
 * 类说明:短信发送控制
 *
 * @author 段衍林
 * @2016年11月23日 上午10:22:48
 */
public enum NoticeFlag {
	yes("发送"), no("不发送");

	private String value;


	public String getValue() {
		return value;
	}


	private NoticeFlag(String value) {
		this.value = value;
	}
}
