package cn.com.atnc.ioms.enums.welcome;

/**
 * 通知菜单类型
 *
 * @author Wang Zhicheng
 * @date 2015年11月4日 下午4:12:10
 * @since 1.0.0
 */
public enum SonMenuType {

	tempcircuit("临时电路"), formalcircuit("数据通信网正式电路"), telegraph("转报网路由地址"), telegraphcircuit(
			"转报网电路"), kusatellite("卫星通信网地球站入网"), datacomnetwork("数据通信网节点入网"), transfernet(
			"自动转报网节点入网"), tempUserRegister("临时用户注册审核"),signoutnet("退网申请");

	private String name;

	public String getName() {
		return name;
	}

	private SonMenuType(String name) {
		this.name = name;
	}

}
