package cn.com.atnc.ioms.entity.clientmng;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.BaseUserInfo;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.clientmng.CsUserStatusEnum;
import cn.com.atnc.ioms.enums.clientmng.SexEnum;

/**
 * 类说明:客服平台用户
 * 
 * @author 潘涛
 * @date 2014-3-18 下午3:16:23
 * @version:1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TB_CS_ACL_CLIENT")
public class Client extends BaseUserInfo {
	private Client pClient;// 上级
	private SexEnum sex;// 性别
	private Integer age;// 年龄
	private String company;// 公司
	private Bureau bureau;// 管局
	private String address;// 地址
	private String postcode;// 右边
	private String info;// 备注
	private CsUserStatusEnum status;// 状态
	private Boolean equipValid = false;// 设备是否启动
	private Calendar lastLoginTime;// 最近登录时间
	private Integer succLogin = 0;// 成功登录次数，如果是第一次登录，提醒修改密码
	private Integer failLogin = 0;// 失败登录次数，连续3次登录失败后禁止用户5分钟内登录
	private CsRole role;// 角色
	private String auditReason;// 审核不通过原因
	private Boolean blocking = false; //是否冻结
	private String pswRandom;
	private ClientCompany newCompany;
	private String job;    //职务
	private String fax;    //传真
	private String branch;    //部门
	
	
	@Column(name = "PSWRANDOM")
	public String getPswRandom() {
		return pswRandom;
	}

	public void setPswRandom(String pswRandom) {
		this.pswRandom = pswRandom;
	}
	@Column(name = "BLOCKING")
	public Boolean getBlocking() {
		return blocking;
	}

	public void setBlocking(Boolean blocking) {
		this.blocking = blocking;
	}

	@Column(name = "AUDIT_REASON")
	public String getAuditReason() {
		return auditReason;
	}

	public void setAuditReason(String auditReason) {
		this.auditReason = auditReason;
	}

	@ManyToOne
	@JoinColumn(name = "PID")
	public Client getpClient() {
		return pClient;
	}

	public void setpClient(Client pClient) {
		this.pClient = pClient;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "MALE")
	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
	}

	@Column(name = "AGE")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Column(name = "COMPANY")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "BUREAU")
	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "POSTCODE")
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Column(name = "INFO")
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	public CsUserStatusEnum getStatus() {
		return status;
	}

	public void setStatus(CsUserStatusEnum status) {
		this.status = status;
	}

	@Column(name = "EQUIP_VALID")
	public Boolean getEquipValid() {
		return equipValid;
	}

	public void setEquipValid(Boolean equipValid) {
		this.equipValid = equipValid;
	}

	@Column(name = "LAST_LOGIN_TIME")
	public Calendar getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Calendar lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name = "SUCC_LOGIN")
	public Integer getSuccLogin() {
		return succLogin;
	}

	public void setSuccLogin(Integer succLogin) {
		this.succLogin = succLogin;
	}

	@Column(name = "FAIL_LOGIN")
	public Integer getFailLogin() {
		return failLogin;
	}

	public void setFailLogin(Integer failLogin) {
		this.failLogin = failLogin;
	}

	@ManyToOne
	@JoinColumn(name = "ROLE_NAME")
	public CsRole getRole() {
		return role;
	}

	public void setRole(CsRole role) {
		this.role = role;
	}
	@ManyToOne
	@JoinColumn(name = "NEW_COMPANY")
	public ClientCompany getNewCompany() {
		return newCompany;
	}

	public void setNewCompany(ClientCompany newCompany) {
		this.newCompany = newCompany;
	}

	@Column(name = "JOB")
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	@Column(name = "FAX")
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "BRANCH")
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	
}
