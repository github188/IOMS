package cn.com.atnc.ioms.enums.tempcircuit;

/**
 * 类说明：电路类型
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月26日下午6:03:32
 * @version:1.0
 */
public enum CircuitType {
	FRATM("FR/ATM"), MPLSVPN("MPLS/VPN"), TESDATA("TES双向数据"), TESBROADCAST(
			"TES广播"), TESVOICE("TES话音"), KUDATA("KU双向数据"), KUBROADCAST("KU广播");
	private String name;

	public String getName() {
		return name;
	}

	private CircuitType(String name) {
		this.name = name;
	}

}
