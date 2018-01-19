/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName ApproveInfo.java
 * @PackageName:cn.com.atnc.pcsp.entity.business.approveinfo
 * @author ku
 * @date 2015年5月15日下午4:09:29
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.entity.business.approveinfo;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveStatusEnum;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveTypeEnum;
import cn.com.atnc.ioms.enums.clientmng.SexEnum;

/**
 *  申请审批信息实体
 *
 * @author ku
 * @date 2015年5月15日 下午4:09:29
 * @since 1.0.0
 */
@Entity
@Table(name="TB_OM_APPLY_APPROVE")
public class ApproveInfo extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	private ApplyBaseInfo applyBaseInfo;
	private User user;
	private Client client;
	private String username;
	private SexEnum gender;
	private Bureau bureau;
	private String company;
	private String mobilephone;
	private String email;
	private String approveRemark;
	private Calendar approveTime;
	private ApproveTypeEnum approveType;
	private ApproveStatusEnum approveStatus;
	private String nextUserName;  //下一步人员姓名
	private String nextUserTel;   //下一步人员联系方式

	private String reportAddress;		//绝对路径
	private String outlineAddress;		//网络路径
	
	public ApproveInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApproveInfo(Client client, ApplyBaseInfo applyBaseInfo, String remark,boolean approveStat) {
		// TODO Auto-generated constructor stub
		this.setApplyBaseInfo(applyBaseInfo);
		this.setClient(client);
		this.setBureau(client.getBureau());
		this.setCompany(client.getNewCompany().getCompany());
		this.setEmail(client.getEmail());
		this.setGender(client.getSex());
		this.setMobilephone(client.getMobilephone());
		this.setUsername(client.getName());
		this.setApproveTime(Calendar.getInstance());
		this.setApproveRemark(remark);
		if(approveStat){
			this.setApproveType(ApproveTypeEnum.agree);
		}else{
			this.setApproveType(ApproveTypeEnum.reject);
		}
	}
	
	public ApproveInfo(User user, ApplyBaseInfo applyBaseInfo, String remark, ApproveTypeEnum typeEnum) {
		this.setApplyBaseInfo(applyBaseInfo);
		this.setUser(user);
		this.setCompany("北京网控中心/"+user.getDept());
		this.setEmail(user.getEmail());
		this.setMobilephone(user.getMobilephone());
		this.setUsername(user.getName());
		this.setApproveTime(Calendar.getInstance());
		this.setApproveRemark(remark);
		this.setApproveType(typeEnum);
	}
	
	public ApproveInfo(User user, ApplyBaseInfo applyBaseInfo, String remark,boolean approveStat) {
		this.setApplyBaseInfo(applyBaseInfo);
		this.setUser(user);
		this.setCompany("北京网控中心/"+user.getDept());
		this.setEmail(user.getEmail());
		this.setMobilephone(user.getMobilephone());
		this.setUsername(user.getName());
		this.setApproveTime(Calendar.getInstance());
		this.setApproveRemark(remark);
		if(approveStat){
			this.setApproveType(ApproveTypeEnum.agree);
		}else{
			this.setApproveType(ApproveTypeEnum.reject);
		}
	}
	
	@ManyToOne
	@JoinColumn(name="apply_baseinfo")
	public ApplyBaseInfo getApplyBaseInfo() {
		return applyBaseInfo;
	}
	public void setApplyBaseInfo(ApplyBaseInfo applyBaseInfo) {
		this.applyBaseInfo = applyBaseInfo;
	}
	
	@ManyToOne
	@JoinColumn(name="approve_user")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne
	@JoinColumn(name="approve_client")
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	@Column(name = "username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	public SexEnum getGender() {
		return gender;
	}
	public void setGender(SexEnum gender) {
		this.gender = gender;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "bureau")
	public Bureau getBureau() {
		return bureau;
	}
	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}
	
	@Column(name = "company")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name = "mobilephone")
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="approve_remark")
	public String getApproveRemark() {
		return approveRemark;
	}
	public void setApproveRemark(String approveRemark) {
		this.approveRemark = approveRemark;
	}
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="approve_time")
	public Calendar getApproveTime() {
		return approveTime;
	}
	public void setApproveTime(Calendar approveTime) {
		this.approveTime = approveTime;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="approve_type")
	public ApproveTypeEnum getApproveType() {
		return approveType;
	}
	public void setApproveType(ApproveTypeEnum approveType) {
		this.approveType = approveType;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="approve_status")
	public ApproveStatusEnum getApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(ApproveStatusEnum approveStatus) {
		this.approveStatus = approveStatus;
	}
	@Column(name = "report_address")
	public String getReportAddress() {
		return reportAddress;
	}
	public void setReportAddress(String reportAddress) {
		this.reportAddress = reportAddress;
	}
	@Column(name = "outline_address")
	public String getOutlineAddress() {
		return outlineAddress;
	}
	public void setOutlineAddress(String outlineAddress) {
		this.outlineAddress = outlineAddress;
	}
	@Column(name = "nextuser_name")
	public String getNextUserName() {
		return nextUserName;
	}
	public void setNextUserName(String nextUserName) {
		this.nextUserName = nextUserName;
	}
	@Column(name = "nextuser_tel")
	public String getNextUserTel() {
		return nextUserTel;
	}
	public void setNextUserTel(String nextUserTel) {
		this.nextUserTel = nextUserTel;
	}
	
	
}
