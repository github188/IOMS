/**
 * 
 */
package cn.com.atnc.ioms.enums.acl;

import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 一级菜单枚举类
 * 
 * @author：KuYonggang
 * @date：2014-6-4上午11:20:43
 * @version：1.0
 */
public enum MenuEnum {
	Register("注册"),
	Login("登录"),
	LogOut("登出"),
	RunStatus("运行状态"),
	TechSupport("技术支持"),
	DoBusiness("业务办理"),
	ClientIm("个人信息");
	
	private String value;
	
	MenuEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static MenuEnum getMenuEnumByValue(String name) {
		for (MenuEnum menuEnum : MenuEnum.values()) {
			if (name.endsWith(menuEnum.name())) {
				return menuEnum;
			}
		}
		return null;
	}

	@JsonValue
	public EnumModel toEnumModel() {
		EnumModel em = new EnumModel();
		em.setName(this.name());
		em.setOrdinal(this.ordinal());
		em.setValue(this.getValue());

		return em;
	}
}

