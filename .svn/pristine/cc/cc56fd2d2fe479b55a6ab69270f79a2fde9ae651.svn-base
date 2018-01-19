package cn.com.atnc.ioms.enums.business.datacomnetwork;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 数据通信网审批状态
 *
 * @author Wang zhicheng
 * @date 2015年5月21日 上午10:55:24
 * @since 1.0.0
 */
public enum NetWorkStatEnum {

	unsubmitted("待客户提交"), returned("已退回"), areaexaminer_approve("地区网络中心审批"), areaexaminer_affirm(
			"地区网络中心确认"), atncleader_firstdeal("天航信审核阶段_技术工程部领导安排审核工程师"), atncleader_approve(
			"天航信审核阶段_技术工程部领导验收工程师审核工作"), atncleader_seconddeal(
			"天航信配置阶段_技术工程部领导安排配置工程师"), atncleader_thirddeal(
			"天航信配置阶段_技术工程部领导安排审核工程师"), engineer_firstaudit(
			"天航信审核阶段_工程师审核用户提交材料"), engineer_config("天航信配置阶段_配置工程师配置"), engineer_secondaudit(
			"天航信配置阶段_审核工程师审核配置信息"), engineer_transfer("天航信配置阶段_工程师协助配置"), csstaff_firstdeal(
			"天航信审核阶段_客服专员审核"), csstaff_deal("天航信配置阶段_客服专员办理"), csleader_approve(
			"天航信审核阶段_客服领导审核"), netmanager_approve("天航信审核阶段_网络运营事业部总经理审批"), compenyleader_approve(
			"天航信审核阶段_公司领导审批"), fundmanager_approve("天航信审核阶段_用印确认"), generalmanager_approve(
			"天航信审核阶段_市场营销事业部总经理审批"), atnc_test("天航信配置阶段_天航信协调测试"), unevaluate(
			"待客户评价"), deal("客户已评价");

	private String value;

	private NetWorkStatEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static NetWorkStatEnum getApproveStatEnumByOrdinal(int value) {
		for (NetWorkStatEnum type : NetWorkStatEnum.values()) {
			if (type.ordinal() == value) {
				return type;
			}
		}
		return null;
	}

	public static NetWorkStatEnum getApproveStatEnumByValue(String value) {
		for (NetWorkStatEnum type : NetWorkStatEnum.values()) {
			if (StringUtils.equals(type.value, value)) {
				return type;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return value;
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
