package cn.com.atnc.ioms.enums.business.satellite;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * ku卫星网远端站入网申请审批状态枚举类
 *
 * @author ku
 * @date 2015年5月13日 下午3:04:19
 * @since 1.0.0
 */
public enum ApproveStatEnum {
	unsubmitted("待客户提交"), returned("已退回"), areaexaminer_confirm("地区网络中心确认"), applyuser_update(
			"客户调整申请"), localmanager_approve("申请单位领导审批"), areaexaminer_approve(
			"地区网络中心审批"), atncleader_firstdeal("天航信审核阶段_技术工程部领导安排审核/配置工程师"), engineer_firstaudit(
			"天航信审核阶段_工程师审核用户提交材料"), atncleader_review(
			"天航信审核阶段_技术工程部领导验收工程师审核工作"), netmanager_approve(
			"天航信审核阶段_网络运营事业部总经理审批"), csstaff_audit("天航信审核阶段_客服专员审核"), csleader_review(
			"天航信审核阶段_客服领导审核"), marketmanager_approve("天航信审核阶段_市场营销事业部总经理审批"), leader_approve(
			"天航信审核阶段_公司领导审批"), fundmanager_confirm("天航信审核阶段_用印确认"), csstaff_deal(
			"天航信配置阶段_客服专员办理"), atncleader_approve("天航信配置阶段_技术工程部领导安排配置工程师"), engineer_config(
			"天航信配置阶段_配置工程师配置"), assist_config("天航信配置阶段_工程师协助测试"), atncleader_audit(
			"天航信配置阶段_技术工程部领导安排审核工程师"), engineer_audit("天航信配置阶段_审核工程师审核配置信息"), local_evaluate(
			"待客户评价"), evaluated("客户已评价");

	private String value;

	private ApproveStatEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static ApproveStatEnum getApproveStatEnumByOrdinal(int value) {
		for (ApproveStatEnum type : ApproveStatEnum.values()) {
			if (type.ordinal() == value) {
				return type;
			}
		}
		return null;
	}

	public static ApproveStatEnum getApproveStatEnumByValue(String value) {
		for (ApproveStatEnum type : ApproveStatEnum.values()) {
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
