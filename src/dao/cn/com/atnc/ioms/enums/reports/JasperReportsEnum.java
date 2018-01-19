package cn.com.atnc.ioms.enums.reports;

import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

 /**
 * 报表枚举类
 *
 * @author Wang zhicheng
 * @date 2015年7月8日 上午9:56:10
 * @since 1.0.0
 */
public enum JasperReportsEnum {

	apply("转报地址申请"),
	config("转报地址配置"),
	telegraph_circuit("转报电路申请"),
	kusatellite("ku远端站入网申请"),
	ATM("ATM数据网正式电路申请"),
	ATM_config("ATM数据网正式电路配置"),
	TES("TES卫星网正式电路申请"),
	TES_config("TES卫星网正式电路配置"),
	PES("PES卫星网正式电路申请"),
	PES_config("PES卫星网正式电路配置"),
	KU("Ku波段卫星网正式电路申请"),
	KU_config("Ku波段卫星网正式电路配置"),
	datacom_apply("数据通信网入网申请"),
	datacom_record("数据通信网记录"),
	autotelegraph("自动转报网入网申请"),
	signoutnet_atm("民航ATM数据通信网节点退网申请"),
	signoutnet_ku("民航卫星通信网站点退网申请"),
	ku_maintence("ku卫星站运行情况月度报告")
	;
	
	private String value;
	private JasperReportsEnum(String value){
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
