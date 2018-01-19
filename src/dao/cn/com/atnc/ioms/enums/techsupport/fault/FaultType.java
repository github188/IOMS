/**
 * 
 */
package cn.com.atnc.ioms.enums.techsupport.fault;

/**
 * TODO:故障类别枚举类
 * @author KuYonggang
 * @date 2014-4-2下午8:16:55
 * @version 1.0
 */
public enum FaultType {
	
	ATM("ATM"), 
	KU("KU"),
	TES("TES"), 
	TRANSIT("转报"),
	OTHER("其他");
	
	private String name;
	/**
	 * @param name
	 */
	private FaultType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public static void main(String[] args) {
		System.out.println(FaultType.KU.name());
	}
	
}
