package cn.com.atnc.ioms.model.faultmng;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.common.model.BaseModel;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.faultmng.FaultEventType;
import cn.com.atnc.ioms.enums.faultmng.FaultLevelType;

/**
 * 故障单信息model
 * @author duanyanlin 
 * 2016年6月17日 下午2:15:13
 */
public class FaultInformationModel extends BaseModel {
	
	private String faultNumber; 				// 故障单编号
	private String telephoneNumber; 			// 申告电话
	private String contactsName; 				// 申告联系人
	private String faultTime; 					// 故障发生时间
	private String pickUpPhoneTime; 			// 申告时间
	private String faultArea; 					// 故障发生区域
	private FaultEventType eventType; 			// 故障类别
	private Integer stationNumber; 				// 坐席号
	private String remark; 						// 备注
	private FaultLevelType faultLevel; 			// 故障级别
	private String stationPhone; 				// 坐席电话
	private String faultCompany; 				// 故障单位
	private User currentUser;					// 当前用户
	private String faultId;						// 故障编码
	private String backups;						// 是否备份
	private String renew;						// 是否立即恢复
	private String serviceType;					// 业务类型
	
	/** 冗余字段 */
	private String firstOrNot;					// 是否首次咨询
	private String isRight;						// 是否正常咨询
	
	private String faultParentId;				//父级故障单id
	
	//dyl add 20170120
	private Date alarmTime;						//告警时间
	
	//hty add 20160808
	private String callSheetId;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getAlarmTime() {
		return alarmTime;
	}
	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}
	public String getBackups() {
		return backups;
	}
	public void setBackups(String backups) {
		this.backups = backups;
	}
	public String getRenew() {
		return renew;
	}
	public void setRenew(String renew) {
		this.renew = renew;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getFaultParentId() {
		return faultParentId;
	}
	public void setFaultParentId(String faultParentId) {
		this.faultParentId = faultParentId;
	}
	public String getFaultId() {
		return faultId;
	}
	public void setFaultId(String faultId) {
		this.faultId = faultId;
	}
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	public String getFirstOrNot() {
		return firstOrNot;
	}
	public void setFirstOrNot(String firstOrNot) {
		this.firstOrNot = firstOrNot;
	}
	public String getFaultNumber() {
		return faultNumber;
	}
	public void setFaultNumber(String faultNumber) {
		this.faultNumber = faultNumber;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getContactsName() {
		return contactsName;
	}
	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}
	public String getFaultTime() {
		return faultTime;
	}
	public void setFaultTime(String faultTime) {
		this.faultTime = faultTime;
	}
	public String getPickUpPhoneTime() {
		return pickUpPhoneTime;
	}
	public void setPickUpPhoneTime(String pickUpPhoneTime) {
		this.pickUpPhoneTime = pickUpPhoneTime;
	}
	public String getFaultArea() {
		return faultArea;
	}
	public void setFaultArea(String faultArea) {
		this.faultArea = faultArea;
	}
	public FaultEventType getEventType() {
		return eventType;
	}
	public void setEventType(FaultEventType eventType) {
		this.eventType = eventType;
	}
	public Integer getStationNumber() {
		return stationNumber;
	}
	public void setStationNumber(Integer stationNumber) {
		this.stationNumber = stationNumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public FaultLevelType getFaultLevel() {
		return faultLevel;
	}
	public void setFaultLevel(FaultLevelType faultLevel) {
		this.faultLevel = faultLevel;
	}
	public String getStationPhone() {
		return stationPhone;
	}
	public void setStationPhone(String stationPhone) {
		this.stationPhone = stationPhone;
	}
	public String getFaultCompany() {
		return faultCompany;
	}
	public void setFaultCompany(String faultCompany) {
		this.faultCompany = faultCompany;
	}
	public String getIsRight() {
		return isRight;
	}
	public void setIsRight(String isRight) {
		this.isRight = isRight;
	}
	public String getCallSheetId() {
		return callSheetId;
	}
	public void setCallSheetId(String callSheetId) {
		this.callSheetId = callSheetId;
	}
	
	
}