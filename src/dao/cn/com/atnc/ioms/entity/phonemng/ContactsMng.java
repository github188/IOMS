package cn.com.atnc.ioms.entity.phonemng;

import java.util.Date;

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
import cn.com.atnc.ioms.enums.phonemng.ContactStatusEnum;
import cn.com.atnc.ioms.enums.phonemng.ContactsIsDelEnum;
import cn.com.atnc.ioms.enums.phonemng.PhoneTypeEnum;
/**
 * @Desc 呼叫中心-联系人实体
 * @author hantianyu
 *
 */
@Entity
@Table(name = "TB_TEL_CONTACTS_MNG")
public class ContactsMng extends MyStringUUIDEntity{
	private static final long serialVersionUID = -6739376065386900888L;
	private String contactName;//联系人姓名
	private String contactPlace;//所属地区
	private String telNumber;//联系电话
	private String companyInfo;//所属公司
	private User creater;//创建人
	private Date createTime;//创建时间
	private User operator;			//操作人
	private Date operatTime;
	
	private ContactStatusEnum contactStatus;
	private PhoneTypeEnum phoneType;
	private String remark;
	private ContactsIsDelEnum isDel;
	private String spare3;

	
	@Enumerated(EnumType.STRING)
    @Column(name="PHONE_TYPE")
	public PhoneTypeEnum getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(PhoneTypeEnum phoneType) {
		this.phoneType = phoneType;
	}
	@Enumerated(EnumType.STRING)
    @Column(name="ISDEL")
	public ContactsIsDelEnum getIsDel() {
		return isDel;
	}
	public void setIsDel(ContactsIsDelEnum isDel) {
		this.isDel = isDel;
	}
	@Column(name = "CONTACT_NAME")
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	@Column(name = "CONTACT_PLACE")
	public String getContactPlace() {
		return contactPlace;
	}
	public void setContactPlace(String contactPlace) {
		this.contactPlace = contactPlace;
	}
	
	@Column(name="TELEPHONE_NUMBER")
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	
	@Column(name="COMPANY_INFO")
	public String getCompanyInfo() {
		return companyInfo;
	}
	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	public Date getOperatTime() {
		return operatTime;
	}
	public void setOperatTime(Date operatTime) {
		this.operatTime = operatTime;
	}
	@Enumerated(EnumType.STRING)
    @Column(name="CONTACT_STATUS")
	public ContactStatusEnum getContactStatus() {
		return contactStatus;
	}
	public void setContactStatus(ContactStatusEnum contactStatus) {
		this.contactStatus = contactStatus;
	}
	@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name="SPARE3")
	public String getSpare3() {
		return spare3;
	}
	public void setSpare3(String spare3) {
		this.spare3 = spare3;
	}
	
	
}
