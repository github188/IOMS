package cn.com.atnc.ioms.entity.duty.satellite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;

/**
 * 卫星备件信息库 实体
 *
 * @author 段衍林
 * @2016年11月28日 下午4:26:57
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_INFODATA")
public class Info extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;
	private String system;
	private String equipName;
	private String sn;
	private String address;;
	private String result;
	private Date checkTime;
	private Date updateTime;
	private String remark;
	private User operator;
	private User tester;
	private Date testTime;

	@ManyToOne
	@JoinColumn(name = "TESTER")
	public User getTester() {
		return tester;
	}

	public void setTester(User tester) {
		this.tester = tester;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "TEST_TIME")
	public Date getTestTime() {
		return testTime;
	}

	public void setTestTime(Date testTime) {
		this.testTime = testTime;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "SYSTEM")
	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	@Column(name = "EQUIP_NAME")
	public String getEquipName() {
		return equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	@Column(name = "SN")
	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "RESULT")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "RECORD_TIME")
	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@ManyToOne
	@JoinColumn(name = "OPERATOR")
	public User getOperator() {
		return operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}
}