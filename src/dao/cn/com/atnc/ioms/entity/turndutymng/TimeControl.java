package cn.com.atnc.ioms.entity.turndutymng;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
/**
 * 
 * @author hantianyu
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TB_OD_TIME_CONTROL")
public class TimeControl extends StringUUIDEntity{

	private String amHour;
	private String amMin;
	private String pmHour;
	private String pmMin;
	private String limitTime;
	
	private User creater;
    private Date creatime;
    private User operator;
    private Date operatime;
    
    private String spare1;
    private String spare2;
    private String spare3;
    
    @Column(name="AM_HOUR")
	public String getAmHour() {
		return amHour;
	}
	public void setAmHour(String amHour) {
		this.amHour = amHour;
	}
	
	@Column(name="AM_MIN")
	public String getAmMin() {
		return amMin;
	}
	public void setAmMin(String amMin) {
		this.amMin = amMin;
	}
	
	@Column(name="PM_HOUR")
	public String getPmHour() {
		return pmHour;
	}
	public void setPmHour(String pmHour) {
		this.pmHour = pmHour;
	}
	
	@Column(name="PM_MIN")
	public String getPmMin() {
		return pmMin;
	}
	public void setPmMin(String pmMin) {
		this.pmMin = pmMin;
	}
	
	@Column(name="LIMIT")
	public String getLimitTime() {
		return limitTime;
	}
	public void setLimitTime(String limitTime) {
		this.limitTime = limitTime;
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
