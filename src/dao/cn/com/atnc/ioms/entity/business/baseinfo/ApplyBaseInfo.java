
package cn.com.atnc.ioms.entity.business.baseinfo;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.enums.business.baseinfo.ApplyTypeEnum;

/**
 * 各种申请的抽象信息
 *
 * @author ku
 * @date 2015年5月13日 下午2:12:40
 * @since 1.0.0
 */
@Entity
@Table(name="TB_OM_APPLY_BASEINFO")
public class ApplyBaseInfo extends MyStringUUIDEntity {

	private static final long serialVersionUID = 6862612312435099195L;
	
	private Client applyUser;     //申请人
	private String applyCom;      //申请单位
	private String applyLinkman;  //联系人
	private String applyPhone;          //联系电话
	private String applyTelephone;		//座机
	private String applyFax;			//传真
	private String applyEmail;			//Email
	private ApplyTypeEnum applyType;	//申请类型
	//----------------记录操作人或状态--------------------
	private String nextUser;      //下一步操作人ID
	private String auditUser;	  //审核工程师ID
	private String lastUser;	  //上一步操作人ID
	private String lastStatusEnum;	  //上一个任务状态
	private Boolean leaderCheckFlag;	  //领导审批标识
	private Boolean sendmessageFlag;	  //发送短信标识
	//--------------------------------------------
	private Calendar applyDate;	  //申请日期
	private Calendar applyTime;   //申请时间
	private Client updateUser;  //修改人
	private Calendar updateTime;  //修改时间
	
	private String candidate;		//协同阅知的管局
	//----------联系人和联系方式
	private String initLinkman;				//初审联系人
	private String initLinkphone;			//初审联系电话
	private String finalLinkman;			//复审联系
	private String finalLinkphone;			//复审联系电话
	//申请序号
	private String serialNumber;			//申请信息序号
	private String approveUsers;			//记录所有审核人
	
	
	@ManyToOne
	@JoinColumn(name="apply_user")
	public Client getApplyUser() {
		return applyUser;
	}
	public void setApplyUser(Client applyUser) {
		this.applyUser = applyUser;
	}
	@Column(name="apply_com")
	public String getApplyCom() {
		return applyCom;
	}
	public void setApplyCom(String applyCom) {
		this.applyCom = applyCom;
	}
	@Column(name="apply_linkman")
	public String getApplyLinkman() {
		return applyLinkman;
	}
	public void setApplyLinkman(String applyLinkman) {
		this.applyLinkman = applyLinkman;
	}
	@Column(name="apply_phone")
	public String getApplyPhone() {
		return applyPhone;
	}
	public void setApplyPhone(String applyPhone) {
		this.applyPhone = applyPhone;
	}
	@Column(name="apply_telephone")
	public String getApplyTelephone() {
		return applyTelephone;
	}
	public void setApplyTelephone(String applyTelephone) {
		this.applyTelephone = applyTelephone;
	}
	@Column(name="apply_fax")
	public String getApplyFax() {
		return applyFax;
	}
	public void setApplyFax(String applyFax) {
		this.applyFax = applyFax;
	}
	@Column(name="apply_email")
	public String getApplyEmail() {
		return applyEmail;
	}
	public void setApplyEmail(String applyEmail) {
		this.applyEmail = applyEmail;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="apply_type")
	public ApplyTypeEnum getApplyType() {
		return applyType;
	}
	public void setApplyType(ApplyTypeEnum applyType) {
		this.applyType = applyType;
	}
	@Column(name="apply_date")
	public Calendar getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Calendar applyDate) {
		this.applyDate = applyDate;
	}
	@Column(name="apply_time")
	public Calendar getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Calendar applyTime) {
		this.applyTime = applyTime;
	}
	@ManyToOne
	@JoinColumn(name="update_user")
	public Client getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(Client updateUser) {
		this.updateUser = updateUser;
	}
	@Column(name="update_time")
	public Calendar getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Calendar updateTime) {
		this.updateTime = updateTime;
	}
	@Column(name="next_user")
	public String getNextUser() {
		return nextUser;
	}
	public void setNextUser(String nextUser) {
		this.nextUser = nextUser;
	}
	@Column(name="audit_user")
	public String getAuditUser() {
		return auditUser;
	}
	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}
	@Column(name="last_user")
	public String getLastUser() {
		return lastUser;
	}
	public void setLastUser(String lastUser) {
		this.lastUser = lastUser;
	}
	@Column(name="last_status")
	public String getLastStatusEnum() {
		return lastStatusEnum;
	}
	public void setLastStatusEnum(String lastStatusEnum) {
		this.lastStatusEnum = lastStatusEnum;
	}
	@Column(name = "candidate_bureau")
	public String getCandidate() {
		return candidate;
	}
	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}
	@Column(name = "init_linkman")
	public String getInitLinkman() {
		return initLinkman;
	}
	public void setInitLinkman(String initLinkman) {
		this.initLinkman = initLinkman;
	}
	@Column(name = "init_linkphone")
	public String getInitLinkphone() {
		return initLinkphone;
	}
	public void setInitLinkphone(String initLinkphone) {
		this.initLinkphone = initLinkphone;
	}
	@Column(name = "final_linkman")
	public String getFinalLinkman() {
		return finalLinkman;
	}
	public void setFinalLinkman(String finalLinkman) {
		this.finalLinkman = finalLinkman;
	}
	@Column(name = "final_linkphone")
	public String getFinalLinkphone() {
		return finalLinkphone;
	}
	public void setFinalLinkphone(String finalLinkphone) {
		this.finalLinkphone = finalLinkphone;
	}
	@Column(name = "serial_number")
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	@Column(name = "leader_checkflag")
	public Boolean getLeaderCheckFlag() {
		return leaderCheckFlag;
	}
	public void setLeaderCheckFlag(Boolean leaderCheckFlag) {
		this.leaderCheckFlag = leaderCheckFlag;
	}
	@Column(name = "sendmessage_flag")
	public Boolean getSendmessageFlag() {
		return sendmessageFlag;
	}
	public void setSendmessageFlag(Boolean sendmessageFlag) {
		this.sendmessageFlag = sendmessageFlag;
	}
	@Column(name = "approve_users")
	public String getApproveUsers() {
		return approveUsers;
	}
	public void setApproveUsers(String approveUsers) {
		this.approveUsers = approveUsers;
	}
	
}
