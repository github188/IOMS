/**
 * 
 */
package cn.com.atnc.ioms.enums.acl;

import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 二级菜单枚举类
 * 
 * @author：KuYonggang
 * @date：2014-6-4上午11:20:43
 * @version：1.0
 */
public enum SubMenuEnum {
	Register("注册"), Login("登录"), Logout("登出"), AtmRunStat("ATM运行统计"), NodeDetail(
			"节点详情"), KuRunStat("KU运行统计"), CircuitConfig("电路配置"), FaultDeclareDeal(
			"故障申报处理"), FaultDeclareRecord("故障申报记录"), TechConsultDeal("技术咨询处理"), TechConsultRecord(
			"技术咨询记录"), TempCircuitDeal("临时电路处理"), TempCircuitRecord("临时电路记录"), FormalCircuitDeal(
			"正式电路办理"), FormalCircuitRecord("正式电路记录"), FormalCircuitCandidate(
			"正式电路协同配置记录"), KuSatelliteDeal("卫星地球站入网办理"), KuSatelliteRecord(
			"卫星地球站入网记录"), TelegraphDeal("转报地址办理"), TelegraphRecord("转报地址记录"), TelegraphCandidate(
			"转报地址协同配置记录"), TelegraphCircuitDeal("转报电路办理"), TelegraphCircuitRecord(
			"转报电路记录"), TelegraphCircuitCandidate("转报电路协同配置记录"), DataComNetworkDeal(
			"数据通信网入网处理"), DataComNetworkRecord("数据通信网入网记录"), TransferNetDeal(
			"自动转报网入网处理"), TransferNetRecord("自动转报网入网记录"), TesRunStat("TES运行状态"), ClientDeal(
			"用户信息管理"), EmployeeDeal("员工管理");

	private String value;

	SubMenuEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static SubMenuEnum getSubMenuEnumByValue(String name) {
		for (SubMenuEnum subMenuEnum : SubMenuEnum.values()) {
			if (name.endsWith(subMenuEnum.name())) {
				return subMenuEnum;
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
