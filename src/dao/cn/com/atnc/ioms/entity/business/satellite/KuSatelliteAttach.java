package cn.com.atnc.ioms.entity.business.satellite;

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
import cn.com.atnc.ioms.enums.business.baseinfo.AttachSourceEnum;
import cn.com.atnc.ioms.enums.business.satellite.KuSatelliteAttachEnum;

/**
 * KU卫星网远端站入网申请附件信息
 *
 * @author ku
 * @date 2015年5月13日 下午3:33:25
 * @since 1.0.0
 */
@Entity
@Table(name="TB_OM_APPLY_KUSATELLITE_ATTACH")
public class KuSatelliteAttach extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;
	
	private KuSatellite kuSatellite;
	private String attachName;
	private String attachAddress;
	private String absoluteAddress;
	private String outlineAddress;
	private String attachExt;
	private Long attachSize;
	private Client uploadUser;
	private Calendar uploadTime;
	private AttachSourceEnum attachSourceEnum;	//附件上传来源枚举类
	private KuSatelliteAttachEnum attachType;
	
	@ManyToOne
	@JoinColumn(name="baseinfo")
	public KuSatellite getKuSatellite() {
		return kuSatellite;
	}
	public void setKuSatellite(KuSatellite kuSatellite) {
		this.kuSatellite = kuSatellite;
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
	@Column(name = "attach_source")
	public AttachSourceEnum getAttachSourceEnum() {
		return attachSourceEnum;
	}
	public void setAttachSourceEnum(AttachSourceEnum attachSourceEnum) {
		this.attachSourceEnum = attachSourceEnum;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="attach_type")
	public KuSatelliteAttachEnum getAttachType() {
		return attachType;
	}
	public void setAttachType(KuSatelliteAttachEnum attachType) {
		this.attachType = attachType;
	}
}
