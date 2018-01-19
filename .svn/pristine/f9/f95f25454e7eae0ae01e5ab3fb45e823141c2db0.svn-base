package cn.com.atnc.ioms.model.clientmng.query;

import cn.com.atnc.common.model.TimePaginModel;
import cn.com.atnc.ioms.entity.clientmng.ClientCompany;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.clientmng.CsUserStatusEnum;

/**
 *类说明:客户查询条件封装类
 *@author 潘涛
 *@date 2014-3-19	下午4:01:49
 *@version:1.0
 */
public class ClientQueryModel extends TimePaginModel {
	private Bureau bureau;//管局,默认为华北
	private String pid;//上级领导ID。
	private String name;//姓名
	private String company;//公司
	private String companyLike;//公司
	private String nameLike;
	private String sort;//排序：ASC/DESC
	private String column;//列
	private String loginName;//登录名
	private String email;//邮箱
	private CsUserStatusEnum status;
	private String [] roleNames;//角色
	private String roleName;
	private Boolean blocking;
	private ClientCompany newCompany;
	
	
	public Boolean getBlocking() {
		return blocking;
	}
	public void setBlocking(Boolean blocking) {
		this.blocking = blocking;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public CsUserStatusEnum getStatus() {
		return status;
	}
	public void setStatus(CsUserStatusEnum status) {
		this.status = status;
	}
	public String[] getRoleNames() {
		return roleNames;
	}
	public void setRoleNames(String[] roleNames) {
		this.roleNames = roleNames;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	
	public Bureau getBureau() {
		return bureau;
	}
	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompanyLike() {
		return companyLike;
	}
	public void setCompanyLike(String companyLike) {
		this.companyLike = companyLike;
	}
	public String getNameLike() {
		return nameLike;
	}
	public void setNameLike(String nameLike) {
		this.nameLike = nameLike;
	}
	public ClientCompany getNewCompany() {
		return newCompany;
	}
	public void setNewCompany(ClientCompany newCompany) {
		this.newCompany = newCompany;
	}
}
