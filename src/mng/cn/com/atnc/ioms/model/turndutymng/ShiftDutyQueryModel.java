package cn.com.atnc.ioms.model.turndutymng;

import java.util.Date;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.turndutymng.SignLeaveRecord;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyRoleEnum;
import cn.com.atnc.ioms.model.MyPaginModel;

public class ShiftDutyQueryModel extends MyPaginModel{
	private int index;
	private DutyRoleEnum dutyRoles;
    private DutyPlaceEnum dutyPlaces;
    private SignLeaveRecord signRecord;
    private String remark;
    private User creater;
    private Date creatime;
    private User operator;
    private Date operatime;
    private String spare1;
    private String spare2;
    private String spare3;
    private Date signTime;		//查询开始日期
    private Date leaveTime;		//查询结束日期
    
	public Date getSignTime() {
		return signTime;
	}
	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public DutyRoleEnum getDutyRoles() {
		return dutyRoles;
	}
	public void setDutyRoles(DutyRoleEnum dutyRoles) {
		this.dutyRoles = dutyRoles;
	}
	public DutyPlaceEnum getDutyPlaces() {
		return dutyPlaces;
	}
	public void setDutyPlaces(DutyPlaceEnum dutyPlaces) {
		this.dutyPlaces = dutyPlaces;
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
	public User getCreater() {
		return creater;
	}
	public void setCreater(User creater) {
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
	public String getSpare1() {
		return spare1;
	}
	public void setSpare1(String spare1) {
		this.spare1 = spare1;
	}
	public String getSpare2() {
		return spare2;
	}
	public void setSpare2(String spare2) {
		this.spare2 = spare2;
	}
	public String getSpare3() {
		return spare3;
	}
	public void setSpare3(String spare3) {
		this.spare3 = spare3;
	}
    
    
}
