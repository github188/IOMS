package cn.com.atnc.ioms.enums.basedata;
/**
 *类说明:网络类型枚举类
 *@author 潘涛
 *@date 2014-3-19	下午2:50:59
 *@version:1.0
 */
public enum NetworkType {
	
	ATM("ATM"),
	KU("KU"),
	TES("TES"),
	wafr08("wafr08"),
	kuplus2echassis("kuplus2echassis"),
	kuplus2chassis("kuplus2chassis"),
	kumodemcard("kumodemcard"),
	kuanacomodu("kuanacomodu");
	
	private String name;
	private NetworkType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
