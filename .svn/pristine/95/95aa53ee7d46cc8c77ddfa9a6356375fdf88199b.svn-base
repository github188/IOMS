package cn.com.atnc.ioms.entity.turndutymng;

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
@SuppressWarnings("serial")
@Entity
@Table(name = "TB_OD_SHIFT_DUTY_RECORD")
public class ShiftDutyRecord extends StringUUIDEntity{
    
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
    
    @Enumerated(EnumType.STRING)
    @Column(name="ROLE_ID")
	public DutyRoleEnum getDutyRoles() {
		return dutyRoles;
	}
	public void setDutyRoles(DutyRoleEnum dutyRoles) {
		this.dutyRoles = dutyRoles;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="DUTY_PLACE")
	public DutyPlaceEnum getDutyPlaces() {
		return dutyPlaces;
	}
	public void setDutyPlaces(DutyPlaceEnum dutyPlaces) {
		this.dutyPlaces = dutyPlaces;
	}
	@ManyToOne
	@JoinColumn(name="SIGN_RECORD_ID")
	public SignLeaveRecord getSignRecord() {
		return signRecord;
	}
	public void setSignRecord(SignLeaveRecord signRecord) {
		this.signRecord = signRecord;
	}
	@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@ManyToOne
	@JoinColumn(name="CREATER")
	public User getCreater() {
		return creater;
	}
	public void setCreater(User creater) {
		this.creater = creater;
	}
	@Column(name = "CREATE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatime() {
		return creatime;
	}
	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}
	@ManyToOne
	@JoinColumn(name="OPERATOR")
	public User getOperator() {
		return operator;
	}
	public void setOperator(User operator) {
		this.operator = operator;
	}
	@Column(name = "OPERAT_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getOperatime() {
		return operatime;
	}
	public void setOperatime(Date operatime) {
		this.operatime = operatime;
	}
	@Column(name="SPARE1")
	public String getSpare1() {
		return spare1;
	}
	public void setSpare1(String spare1) {
		this.spare1 = spare1;
	}
	@Column(name="SPARE2")
	public String getSpare2() {
		return spare2;
	}
	public void setSpare2(String spare2) {
		this.spare2 = spare2;
	}
	@Column(name="SPARE3")
	public String getSpare3() {
		return spare3;
	}
	public void setSpare3(String spare3) {
		this.spare3 = spare3;
	}
    
    
}
