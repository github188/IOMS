package cn.com.atnc.ioms.model.turndutymng;

import java.util.Date;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.turndutymng.SignLeaveRecord;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyRoleEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyStatusEnum;
import cn.com.atnc.ioms.model.MyPaginModel;

public class TurnDutyQueryModel extends MyPaginModel{
	private int index;
	private User userinfo;
	private Date signTime;
	private DutyRoleEnum dutyRole;
	private DutyPlaceEnum dutyPlace;
	private Date leaveTime;
	private DutyStatusEnum dutyStatus;
	private double totalTimes;
	
    private SignLeaveRecord signRecord;
    private String remark;
    private String creater;
    private Date creatime;
    private User operator;
    private Date operatime;
    private String optType;
    private String startOptTime; //操作时间
    private String endOptTime; //操作时间
    
    
    public String getStartOptTime() {
		return startOptTime;
	}
	public void setStartOptTime(String startOptTime) {
		this.startOptTime = startOptTime;
	}
	public String getEndOptTime() {
		return endOptTime;
	}
	public void setEndOptTime(String endOptTime) {
		this.endOptTime = endOptTime;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public User getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}
	public Date getSignTime() {
		return signTime;
	}
	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}
	public DutyRoleEnum getDutyRole() {
		return dutyRole;
	}
	public void setDutyRole(DutyRoleEnum dutyRole) {
		this.dutyRole = dutyRole;
	}
	public DutyPlaceEnum getDutyPlace() {
		return dutyPlace;
	}
	public void setDutyPlace(DutyPlaceEnum dutyPlace) {
		this.dutyPlace = dutyPlace;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public DutyStatusEnum getDutyStatus() {
		return dutyStatus;
	}
	public void setDutyStatus(DutyStatusEnum dutyStatus) {
		this.dutyStatus = dutyStatus;
	}
	public double getTotalTimes() {
		return totalTimes;
	}
	public void setTotalTimes(double totalTimes) {
		this.totalTimes = totalTimes;
	}
	public SignLeaveRecord getSignRecord() {
		return signRecord;
	}
	public void setSignRecord(SignLeaveRecord signRecord) {
		this.signRecord = signRecord;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public Date getCreatime() {
		return creatime;
	}
	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}
	public User getOperator() {
		return operator;
	}
	public void setOperator(User operator) {
		this.operator = operator;
	}
	public Date getOperatime() {
		return operatime;
	}
	public void setOperatime(Date operatime) {
		this.operatime = operatime;
	}
	public String getOptType() {
		return optType;
	}
	public void setOptType(String optType) {
		this.optType = optType;
	}
    
}
