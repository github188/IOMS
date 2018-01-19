package cn.com.atnc.ioms.entity.duty.satellite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;

/**
 * 通信基地-TES-室内设备 民航局-TES-室内设备
 * 
 * @author shijiyong
 * @date 2016年11月1日 下午1:53:06
 * @version 1.0, 2016年11月1日 下午1:53:06
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_TESEQU")
public class TesEqu extends MyStringUUIDEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String n1001;
	private String n1002;
	private String n1003;
	private String n1004;
	private String n1007;
	private String n1008;
	private String n1009;
	private String n100a;
	private String n100b;
	private String n100c;
	private String n100d;
	private String n100e;
	private String n100f;
	private String n1010;
	private String n1011;
	private String n1012;

	private CheckResult s1001;
	private CheckResult s1002;
	private CheckResult s1003;
	private CheckResult s1004;
	private CheckResult s1007;
	private CheckResult s1008;
	private CheckResult s1009;
	private CheckResult s100a;
	private CheckResult s100b;
	private CheckResult s100c;
	private CheckResult s100d;
	private CheckResult s100e;
	private CheckResult s100f;
	private CheckResult s1010;
	private CheckResult s1011;
	private CheckResult s1012;

	private User operator; // 操作人
	private Date checkTime; // 检查时间
	private Date checkDate; // 检查日期
	private User updater; // 更新操作人
	private Date UpdateTime; // 更新时间
	private CheckCatagory checkType;
	private String optType;

	@ManyToOne
	@JoinColumn(name = "UPDATER")
	public User getUpdater() {
		return updater;
	}

	public void setUpdater(User updater) {
		this.updater = updater;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return UpdateTime;
	}

	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}

	@ManyToOne
	@JoinColumn(name = "operator")
	public User getOperator() {
		return operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "check_time")
	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "check_date")
	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "check_type")
	public CheckCatagory getCheckType() {
		return checkType;
	}

	public void setCheckType(CheckCatagory checkType) {
		this.checkType = checkType;
	}

	@Column(name = "optType")
	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	@Column(name = "n1001")
	public String getN1001() {
		return n1001;
	}

	public void setN1001(String n1001) {
		this.n1001 = n1001;
	}

	@Column(name = "n1002")
	public String getN1002() {
		return n1002;
	}

	public void setN1002(String n1002) {
		this.n1002 = n1002;
	}

	@Column(name = "n1003")
	public String getN1003() {
		return n1003;
	}

	public void setN1003(String n1003) {
		this.n1003 = n1003;
	}

	@Column(name = "n1004")
	public String getN1004() {
		return n1004;
	}

	public void setN1004(String n1004) {
		this.n1004 = n1004;
	}

	@Column(name = "n1007")
	public String getN1007() {
		return n1007;
	}

	public void setN1007(String n1007) {
		this.n1007 = n1007;
	}

	@Column(name = "n1008")
	public String getN1008() {
		return n1008;
	}

	public void setN1008(String n1008) {
		this.n1008 = n1008;
	}

	@Column(name = "n1009")
	public String getN1009() {
		return n1009;
	}

	public void setN1009(String n1009) {
		this.n1009 = n1009;
	}

	@Column(name = "n100a")
	public String getN100a() {
		return n100a;
	}

	public void setN100a(String n100a) {
		this.n100a = n100a;
	}

	@Column(name = "n100b")
	public String getN100b() {
		return n100b;
	}

	public void setN100b(String n100b) {
		this.n100b = n100b;
	}

	@Column(name = "n100c")
	public String getN100c() {
		return n100c;
	}

	public void setN100c(String n100c) {
		this.n100c = n100c;
	}

	@Column(name = "n100d")
	public String getN100d() {
		return n100d;
	}

	public void setN100d(String n100d) {
		this.n100d = n100d;
	}

	@Column(name = "n100e")
	public String getN100e() {
		return n100e;
	}

	public void setN100e(String n100e) {
		this.n100e = n100e;
	}

	@Column(name = "n100f")
	public String getN100f() {
		return n100f;
	}

	public void setN100f(String n100f) {
		this.n100f = n100f;
	}

	@Column(name = "n1010")
	public String getN1010() {
		return n1010;
	}

	public void setN1010(String n1010) {
		this.n1010 = n1010;
	}

	@Column(name = "n1011")
	public String getN1011() {
		return n1011;
	}

	public void setN1011(String n1011) {
		this.n1011 = n1011;
	}

	@Column(name = "n1012")
	public String getN1012() {
		return n1012;
	}

	public void setN1012(String n1012) {
		this.n1012 = n1012;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "s1001")
	public CheckResult getS1001() {
		return s1001;
	}

	public void setS1001(CheckResult s1001) {
		this.s1001 = s1001;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "s1002")
	public CheckResult getS1002() {
		return s1002;
	}

	public void setS1002(CheckResult s1002) {
		this.s1002 = s1002;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "s1003")
	public CheckResult getS1003() {
		return s1003;
	}

	public void setS1003(CheckResult s1003) {
		this.s1003 = s1003;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "s1004")
	public CheckResult getS1004() {
		return s1004;
	}

	public void setS1004(CheckResult s1004) {
		this.s1004 = s1004;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "s1007")
	public CheckResult getS1007() {
		return s1007;
	}

	public void setS1007(CheckResult s1007) {
		this.s1007 = s1007;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "s1008")
	public CheckResult getS1008() {
		return s1008;
	}

	public void setS1008(CheckResult s1008) {
		this.s1008 = s1008;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "s1009")
	public CheckResult getS1009() {
		return s1009;
	}

	public void setS1009(CheckResult s1009) {
		this.s1009 = s1009;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "s100a")
	public CheckResult getS100a() {
		return s100a;
	}

	public void setS100a(CheckResult s100a) {
		this.s100a = s100a;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "s100b")
	public CheckResult getS100b() {
		return s100b;
	}

	public void setS100b(CheckResult s100b) {
		this.s100b = s100b;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "s100c")
	public CheckResult getS100c() {
		return s100c;
	}

	public void setS100c(CheckResult s100c) {
		this.s100c = s100c;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "s100d")
	public CheckResult getS100d() {
		return s100d;
	}

	public void setS100d(CheckResult s100d) {
		this.s100d = s100d;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "s100e")
	public CheckResult getS100e() {
		return s100e;
	}

	public void setS100e(CheckResult s100e) {
		this.s100e = s100e;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "s100f")
	public CheckResult getS100f() {
		return s100f;
	}

	public void setS100f(CheckResult s100f) {
		this.s100f = s100f;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "s1010")
	public CheckResult getS1010() {
		return s1010;
	}

	public void setS1010(CheckResult s1010) {
		this.s1010 = s1010;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "s1011")
	public CheckResult getS1011() {
		return s1011;
	}

	public void setS1011(CheckResult s1011) {
		this.s1011 = s1011;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "s1012")
	public CheckResult getS1012() {
		return s1012;
	}

	public void setS1012(CheckResult s1012) {
		this.s1012 = s1012;
	}

}
