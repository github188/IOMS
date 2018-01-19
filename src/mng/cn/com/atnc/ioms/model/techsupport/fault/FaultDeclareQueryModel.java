/**
 * 
 */
package cn.com.atnc.ioms.model.techsupport.fault;

import cn.com.atnc.common.model.TimePaginModel;

/**
 * TODO：故障申报查询条件封装
 * @author KuYonggang
 * @date 2014-4-3下午4:48:42
 * @version 1.0
 */
public class FaultDeclareQueryModel extends TimePaginModel {
	
	private String id;
	private String faultType;//咨询类型
	private String updateUser;//处理人员
	private String status;//状态
	private String clientName;//咨询人员姓名
	private String faultdeclarepi;
	private String descInfo;
	private String confirmTime;
	private String dutyManager;
	private String engineer;
	private String role;
	private boolean userConfirm;
	
	public String getFaultType() {
		return faultType;
	}
	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFaultdeclarepi() {
		return faultdeclarepi;
	}
	public void setFaultdeclarepi(String faultdeclarepi) {
		this.faultdeclarepi = faultdeclarepi;
	}
	public String getDescInfo() {
		return descInfo;
	}
	public void setDescInfo(String descInfo) {
		this.descInfo = descInfo;
	}
	public String getConfirmTime() {
		return confirmTime;
	}
	public void setConfirmTime(String confirmTime) {
		this.confirmTime = confirmTime;
	}
	public String getDutyManager() {
		return dutyManager;
	}
	public void setDutyManager(String dutyManager) {
		this.dutyManager = dutyManager;
	}
	public String getEngineer() {
		return engineer;
	}
	public void setEngineer(String engineer) {
		this.engineer = engineer;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isUserConfirm() {
		return userConfirm;
	}
	public void setUserConfirm(boolean userConfirm) {
		this.userConfirm = userConfirm;
	}
	
	
}
