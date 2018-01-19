package cn.com.atnc.ioms.entity.publicnotice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.publicnotice.PnNoticeOptType;
import cn.com.atnc.ioms.enums.publicnotice.PnNoticeStatusEnum;

/**
 * @author:lizhisheng
 * @date:2014-5-5 下午1:32:34
 * @version:1.0
 */
@Entity
@Table(name = "TB_OM_PN_NOTICE_OPTLOG")
public class PnNoticeOptLog extends StringUUIDEntity {

	private static final long serialVersionUID = -7736232749717254275L;

	private PnNotice pnNotice;//客户通报记录ID
	private PnNoticeOptType pnNoticeOptType;//操作类型
	private User optUser;//操作人员
	private PnNoticeStatusEnum  fromPnNoticeStatusEnum;//变更前状态
	private PnNoticeStatusEnum  toPnNoticeStatusEnum;//变更后状态
	private Date optTime;//操作时间
	private String info;//描述信息
	@ManyToOne
	@JoinColumn(name="PN_NOTICE_ID")
	public PnNotice getPnNotice() {
		return pnNotice;
	}
	public void setPnNotice(PnNotice pnNotice) {
		this.pnNotice = pnNotice;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="OPT")
	public PnNoticeOptType getPnNoticeOptType() {
		return pnNoticeOptType;
	}
	public void setPnNoticeOptType(PnNoticeOptType pnNoticeOptType) {
		this.pnNoticeOptType = pnNoticeOptType;
	}
	@ManyToOne
	@JoinColumn(name="OPT_USER")
	public User getOptUser() {
		return optUser;
	}
	public void setOptUser(User optUser) {
		this.optUser = optUser;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="FROM_STATUS")
	public PnNoticeStatusEnum getFromPnNoticeStatusEnum() {
		return fromPnNoticeStatusEnum;
	}
	public void setFromPnNoticeStatusEnum(PnNoticeStatusEnum fromPnNoticeStatusEnum) {
		this.fromPnNoticeStatusEnum = fromPnNoticeStatusEnum;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="TO_STATUS")
	public PnNoticeStatusEnum getToPnNoticeStatusEnum() {
		return toPnNoticeStatusEnum;
	}
	public void setToPnNoticeStatusEnum(PnNoticeStatusEnum toPnNoticeStatusEnum) {
		this.toPnNoticeStatusEnum = toPnNoticeStatusEnum;
	}
	@Column(name="OPT_TIME")
	public Date getOptTime() {
		return optTime;
	}
	public void setOptTime(Date optTime) {
		this.optTime = optTime;
	}
	@Column(name="INFO")
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
}
