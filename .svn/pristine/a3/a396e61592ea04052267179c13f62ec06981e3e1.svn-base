package cn.com.atnc.ioms.enums.basedata;

import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;


/**
 * 角色枚举类
 * @author WangLingbin
 * @date 2015年11月5日 下午1:53:31
 * @since 1.0.0
 */
public enum RoleEnum {

	csuser("客服部添加客户信息角色"),
	zhibanyuan("值班员"),
	zhibanzuzhang("值班经理"),
	engineer("工程师"),
	//ku维保需发送短信的工程师--dyl
	kuengineer("KU维保工程师"),
	secondLeader("事业部领导"),
	atncLeader("网控部门经理"),
	admin("系统管理员"),
	firstLeader("部门经理"),
	fby("发布员"),
	manager("市场营销事业部总经理"),
	netmanager("网络运营事业部总经理"),
	leader("公司领导"),
	csLeader("客服领导"),
	csStaff("客服专员"),
	fundmanager("财务部总经理"),
	audituser("用户审核"),
	aaTempUser("临时用户");;
	
	private String value;
	private RoleEnum(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
	@JsonValue
	public EnumModel toEnumModel(){
		EnumModel em = new EnumModel();
		em.setName(this.name());
		em.setOrdinal(this.ordinal());
		em.setValue(this.getValue());
		
		return em;
	}
}
