
package cn.com.atnc.ioms.entity.business.transfernet;

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
import cn.com.atnc.ioms.enums.business.transfernet.TransferAttachTypeEnum;

/**
 * 自动转报网申请附件信息
 *
 * @author Wang Zhicheng
 * @date 2015年10月15日 上午9:58:52
 * @since 1.0.0
 */
@Entity
@Table(name="TB_OM_APPLY_TRANSFERNET_ATT")
public class TransferNetAttach extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;
	
	private TransferNet transferNet;
	private String attachName;
	private String attachAddress;
	private String absoluteAddress;
	private String outlineAddress;
	private String attachExt;
	private Long attachSize;
	private Client uploadUser;
	private Calendar uploadTime;
	private TransferAttachTypeEnum attachType;
	
	@ManyToOne
	@JoinColumn(name="baseinfo")
	public TransferNet getTransferNet() {
		return transferNet;
	}
	public void setTransferNet(TransferNet transferNet) {
		this.transferNet = transferNet;
	}
	
	@Column(name="attach_name")
	public String getAttachName() {
		return attachName;
	}
	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}
	@Column(name="attach_address")
	public String getAttachAddress() {
		return attachAddress;
	}
	public void setAttachAddress(String attachAddress) {
		this.attachAddress = attachAddress;
	}
	@Column(name="absolute_address")
	public String getAbsoluteAddress() {
		return absoluteAddress;
	}
	public void setAbsoluteAddress(String absoluteAddress) {
		this.absoluteAddress = absoluteAddress;
	}
	@Column(name="attach_size")
	public Long getAttachSize() {
		return attachSize;
	}
	public void setAttachSize(Long attachSize) {
		this.attachSize = attachSize;
	}
	@Column(name="outline_address")
	public String getOutlineAddress() {
		return outlineAddress;
	}
	public void setOutlineAddress(String outlineAddress) {
		this.outlineAddress = outlineAddress;
	}
	@Column(name="attach_ext")
	public String getAttachExt() {
		return attachExt;
	}
	public void setAttachExt(String attachExt) {
		this.attachExt = attachExt;
	}
	@ManyToOne
	@JoinColumn(name="upload_user")
	public Client getUploadUser() {
		return uploadUser;
	}
	public void setUploadUser(Client uploadUser) {
		this.uploadUser = uploadUser;
	}
	@Column(name="upload_time")
	public Calendar getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Calendar uploadTime) {
		this.uploadTime = uploadTime;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="attach_type")
	public TransferAttachTypeEnum getAttachType() {
		return attachType;
	}
	public void setAttachType(TransferAttachTypeEnum attachType) {
		this.attachType = attachType;
	}
}
