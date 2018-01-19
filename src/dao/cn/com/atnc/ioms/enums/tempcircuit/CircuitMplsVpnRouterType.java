package cn.com.atnc.ioms.enums.tempcircuit;

/**
 * 类说明：电路类型
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月26日下午6:03:32
 * @version:1.0
 */
public enum CircuitMplsVpnRouterType {
	DIRECT("直连"), STATIC("静态"), RIP("RIP"), EIGRP(
			"EIGRP"), OSPF("OSPF");
	private String name;

	public String getName() {
		return name;
	}

	private CircuitMplsVpnRouterType(String name) {
		this.name = name;
	}

}
