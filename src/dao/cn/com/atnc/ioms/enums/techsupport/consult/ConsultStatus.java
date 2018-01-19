/**
 * 
 */
package cn.com.atnc.ioms.enums.techsupport.consult;

/**
 * 类说明：技术咨询enum类
 * 
 * @author：KuYonggang
 * @date：2014-4-29上午8:50:20
 * @version：1.0
 */
public enum ConsultStatus {
	
	SUBMITTED("已提交"), 
	REPLIED("已回复"),
	CHANGED("已转咨询"),
	ADDED("已追加"),
	CLOSED("已关闭");
	
	private String name;
	/**
	 * @param name
	 */
	private ConsultStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
