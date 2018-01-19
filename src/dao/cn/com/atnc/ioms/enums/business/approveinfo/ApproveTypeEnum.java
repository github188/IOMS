package cn.com.atnc.ioms.enums.business.approveinfo;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 审批类型枚举类
 *
 * @author ku
 * @date 2015年5月15日 下午4:12:56
 * @since 1.0.0
 */
public enum ApproveTypeEnum {
	
	agree("确认"),reject("退回重审"),confirm("确认"),transfer("移交"),draft("暂存"),submit("提交"),
	atncCheck("天航信公司审核完成"),atncDeploy("天航信公司配置完成"),atncTest("天航信公司测试完成"),consent("同意用户申请"),disconsent("不同意用户申请");
	
	private String value;

	private ApproveTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static ApproveTypeEnum getApproveTypeEnumByOrdinal(int value) {
		for (ApproveTypeEnum type : ApproveTypeEnum.values()) {
			if (type.ordinal() == value) {
				return type;
			}
		}
		return null;
	}
	
	public static ApproveTypeEnum getApproveTypeEnumByValue(String value) {
		for (ApproveTypeEnum type : ApproveTypeEnum.values()) {
			if (StringUtils.equals(type.value,value)) {
				return type;
			}
		}
		return null;
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
