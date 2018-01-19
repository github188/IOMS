package cn.com.atnc.ioms.entity.turndutymng;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyRoleEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyStatusEnum;
import cn.com.atnc.ioms.enums.turndutymng.SignLeaveStatusEnum;
/**
 * 
 * @author hantianyu
 * @creatime 2016-5-17下午3:33:54
 * TODO 签到离岗记录表
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TB_OD_SIGN_LEAVE_RECORD")
public class SignLeaveRecord extends StringUUIDEntity{
	
	private User userinfo;
	private Date signTime;
	private DutyRoleEnum dutyRole;
	private DutyPlaceEnum dutyPlace;
	private Date leaveTime;
	private DutyStatusEnum dutyStatus;
	private double totalTimes;
	private String spare1;//待离岗的备注
	private String spare2;//代离岗用户名
	private SignLeaveStatusEnum spare3;
	
	private String agentNumber;//坐席号
	
	private Date createTime;//待离岗实际操作时间
	
	private String lateTime;//迟到时间
	private String earlyTime;//早退时间
	
	
	
	
	@Column(name="LATE_TIME")
	public String getLateTime() {
		return lateTime;
	}
	public void setLateTime(String lateTime) {
		this.lateTime = lateTime;
	}
	@Column(name="EARLY_TIME")
	public String getEarlyTime() {
		return earlyTime;
	}
	public void setEarlyTime(String earlyTime) {
		this.earlyTime = earlyTime;
	}
	
	@Column(name = "AGENT")
	public String getAgentNumber() {
		return agentNumber;
	}
	public void setAgentNumber(String agentNumber) {
		this.agentNumber = agentNumber;
	}
	@ManyToOne
	@JoinColumn(name="USER_ID")
	public User getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}
	@Column(name = "SIGNS_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSignTime() {
		return signTime;
	}
	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}
	@Enumerated(EnumType.STRING)
    @Column(name="ROLE_ID")
	public DutyRoleEnum getDutyRole() {
		return dutyRole;
	}
	public void setDutyRole(DutyRoleEnum dutyRole) {
		this.dutyRole = dutyRole;
	}
	@Enumerated(EnumType.STRING)
    @Column(name="DUTY_PLACE")
	public DutyPlaceEnum getDutyPlace() {
		return dutyPlace;
	}
	public void setDutyPlace(DutyPlaceEnum dutyPlace) {
		this.dutyPlace = dutyPlace;
	}
	@Column(name = "LEAVE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	@Enumerated(EnumType.STRING)
    @Column(name="DUTY_STATUS")
	public DutyStatusEnum getDutyStatus() {
		return dutyStatus;
	}
	public void setDutyStatus(DutyStatusEnum dutyStatus) {
		this.dutyStatus = dutyStatus;
	}
	@Column(name="TOTAL_TIME")
	public double getTotalTimes() {
		return totalTimes;
	}
	public void setTotalTimes(double totalTimes) {
		this.totalTimes = totalTimes;
	}
	@Column
	public String getSpare1() {
		return spare1;
	}
	public void setSpare1(String spare1) {
		this.spare1 = spare1;
	}
	@Column
	public String getSpare2() {
		return spare2;
	}
	public void setSpare2(String spare2) {
		this.spare2 = spare2;
	}
	
	
	@Enumerated(EnumType.STRING)
    @Column(name="SPARE3")
	public SignLeaveStatusEnum getSpare3() {
		return spare3;
	}
	public void setSpare3(SignLeaveStatusEnum spare3) {
		this.spare3 = spare3;
	}
	
	@Column(name = "CREATE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
	
}
