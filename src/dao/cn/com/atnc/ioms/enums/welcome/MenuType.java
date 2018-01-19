package cn.com.atnc.ioms.enums.welcome;

/**
 * 通知菜单类型
 *
 * @author Wang Zhicheng
 * @date 2015年11月4日 下午4:12:10
 * @since 1.0.0
 */
public enum MenuType {
	
	business("业务开通"), declaredeal("故障申报"), consultdeal("技术支持"),
	newsdeal("通知公告"), clientmng("客户管理");
	
	private String name;

	public String getName() {
		return name;
	}

	private MenuType(String name) {
		this.name = name;
	}

}
