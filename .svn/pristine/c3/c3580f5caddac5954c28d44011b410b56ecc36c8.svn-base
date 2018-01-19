package cn.com.atnc.ioms.enums.reports;

import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 退回申请表名称枚举
 * @author WangLingbin
 * @date 2015年11月10日 下午3:50:44
 * @since 1.0.0
 */
public enum ReturnedReportsEnum {

	apply("转报网路由地址申请表.pdf"),
	telegraph_circuit("转报网电路申请表.pdf"),
	kusatellite("卫星通信网地球站申请表.pdf"),
	ATM("ATM数据网正式电路申请表.pdf"),
	TES("TES数据网正式电路申请表.pdf"),
	KU("Ku数据网正式电路申请表.pdf"),
	formalcircuit("数据网正式电路申请表.pdf"),
	datacom_apply("数据通信网节点申请表.pdf"),
	autotelegraph("自动转报网节点申请表.pdf"),
	
	auditFile("地区网络中心审批表");
	private String value;
	private ReturnedReportsEnum(String value){
		this.value = value;
	}
	public String getValue() {
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
