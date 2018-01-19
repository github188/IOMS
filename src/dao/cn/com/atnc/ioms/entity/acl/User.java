/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:04:13
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */
package cn.com.atnc.ioms.entity.acl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

import cn.com.atnc.ioms.entity.BaseUserInfo;
import cn.com.atnc.ioms.entity.systemmng.deptinfomng.DeptInfomationMng;

/**
 * 系统用户
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:04:13
 */
@Entity
@Table(name = "TB_OM_ACL_USER")
public class User extends BaseUserInfo {
	/**
	 * 
	 */
	public User() {

	}

	public User(String id) {
		this.id = id;
	}

	private static final long serialVersionUID = -4389399512060857480L;
	// private Boolean male = true;// 性别，true-男，false-女，默认为true
	private String dept;// 部门  hty mod
  
	private Boolean valid = true;// true-有效账户，false-无效账户

	private Boolean system = false; // 系统保留 ，true-系统保留角色，false-用户自定义。默认为false

	private Calendar lastLoginTime;

	private transient String[] roleId;// 所关联的角色id数组
	private transient String roleIds;
	private transient String roleNames;
	private transient String baseRoleNames;
	private transient List<Role> roles;				//所有角色
	private transient List<Role> baseRoles;			//原有角色
	private transient List<Role> transferRoles;		//授权角色
	private transient List<User> transfer;				//授权人
	private transient String oldPasswd;// 老密码

	//hantianyu add ---start
	private String emplno;
	private DeptInfomationMng deptinfo;
	private DeptInfomationMng deptinfoPar;//父类
	private String deptinfoStr;// 座机
    private String deptinfoParStr;// 传真
	private transient double managetimes;     //值班经理角色的总工作时长
	private transient double engineertimes;   //值班工程师角色的总工作时长
	private transient double sumtimes;        //总和
	//hantianyu add ---end
	
	//hantianyu add start
	@Column(name = "EMPLNO")
	public String getEmplno() {
		return emplno;
	}

	

	public void setEmplno(String emplno) {
		this.emplno = emplno;
	}
	@Column(name = "FAX")
	public String getDeptinfoStr() {
		return deptinfoStr;
	}

	public void setDeptinfoStr(String deptinfoStr) {
		this.deptinfoStr = deptinfoStr;
	}
	@Column(name = "TEL")
	public String getDeptinfoParStr() {
		return deptinfoParStr;
	}

	public void setDeptinfoParStr(String deptinfoParStr) {
		this.deptinfoParStr = deptinfoParStr;
	}
	
    @ManyToOne
    @JoinColumn(name="DEPTINFO")
	public DeptInfomationMng getDeptinfo() {
		return deptinfo;
	}

	public void setDeptinfo(DeptInfomationMng deptinfo) {
		this.deptinfo = deptinfo;
	}
	@ManyToOne
    @JoinColumn(name="dept")
	public DeptInfomationMng getDeptinfoPar() {
		return deptinfoPar;
	}

	public void setDeptinfoPar(DeptInfomationMng deptinfoPar) {
		this.deptinfoPar = deptinfoPar;
	}

	@Column(name = "department")
	public String getDept() {
		return dept;
	}
	
	
	@Transient
	public double getManagetimes() {
		return managetimes;
	}

	public void setManagetimes(double managetimes) {
		this.managetimes = managetimes;
	}
	@Transient
	public double getEngineertimes() {
		return engineertimes;
	}

	public void setEngineertimes(double engineertimes) {
		this.engineertimes = engineertimes;
	}
	@Transient
	public double getSumtimes() {
		return sumtimes;
	}

	public void setSumtimes(double sumtimes) {
		this.sumtimes = sumtimes;
	}
	
	//hantianyu add end
	public void setDept(String dept) {
		this.dept = dept;
	}

	@Column
	public Boolean getSystem() {
		return system;
	}

	public void setSystem(Boolean system) {
		this.system = system;
	}

	// @Column
	// public boolean getMale() {
	// return male;
	// }
	//
	// public void setMale(Boolean male) {
	// this.male = male;
	// }

	// @Column
	// public String getTel() {
	// return tel;
	// }
	//
	// public void setTel(String tel) {
	// this.tel = tel;
	// }
	//
	// @Column
	// public String getFax() {
	// return fax;
	// }
	//
	// public void setFax(String fax) {
	// this.fax = fax;
	// }

	@Column
	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	@Column(name = "last_login_time")
	public Calendar getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Calendar lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Transient
	public String getOldPasswd() {
		return oldPasswd;
	}

	public void setOldPasswd(String oldPasswd) {
		this.oldPasswd = oldPasswd;
	}

	@JsonIgnore
	@Transient
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@JsonIgnore
	@Transient
	public String[] getRoleId() {
		return roleId;
	}

	public void setRoleId(String[] roleId) {
		this.roleId = roleId;
	}

	@JsonIgnore
	@Transient
	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	@JsonIgnore
	@Transient
	public String getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}
	
	@JsonIgnore
	@Transient
	public List<Role> getBaseRoles() {
		return baseRoles;
	}

	public void setBaseRoles(List<Role> baseRoles) {
		this.baseRoles = baseRoles;
	}

	@JsonIgnore
	@Transient
	public List<Role> getTransferRoles() {
		return transferRoles;
	}

	public void setTransferRoles(List<Role> transferRoles) {
		this.transferRoles = transferRoles;
	}
	
	@JsonIgnore
	@Transient
	public List<User> getTransfer() {
		return transfer;
	}

	public void setTransfer(List<User> transfer) {
		this.transfer = transfer;
	}
	
	@JsonIgnore
	@Transient
	public String getBaseRoleNames() {
		return baseRoleNames;
	}

	public void setBaseRoleNames(String baseRoleNames) {
		this.baseRoleNames = baseRoleNames;
	}


	
}
