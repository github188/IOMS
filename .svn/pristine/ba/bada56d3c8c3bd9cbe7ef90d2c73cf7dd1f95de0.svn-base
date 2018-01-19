package cn.com.atnc.ioms.entity.clientnotice;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.enums.clientnotice.NoticeState;
import cn.com.atnc.ioms.enums.clientnotice.NoticeType;

/**
 * 用户通知信息表
 * 
 * @author lizhisheng
 * @date 2014-4-16 下午2:56:01
 */
@Entity
@Table(name = "TB_OM_CN_SEND_LOG")
public class SendLog extends MyStringUUIDEntity {

	private static final long serialVersionUID = -7766377390374701715L;

	private String phoneNo;
	private String email;
	private NoticeState noticeState;
	private NoticeType noticeType;
	private String info;
	private Calendar sendTime;

	private Integer failedTimes = 0;

	private String loginName;
	private String name;
	private String userId;

	public SendLog() {
		super();
	}

	public SendLog(String phoneNo, String email, NoticeState noticeState,
			NoticeType noticeType, String info, Calendar sendTime,
			Integer failedTimes, String loginName, String name, String userId) {
		super();
		this.phoneNo = phoneNo;
		this.email = email;
		this.noticeState = noticeState;
		this.noticeType = noticeType;
		this.info = info;
		this.sendTime = sendTime;
		this.failedTimes = failedTimes;
		this.loginName = loginName;
		this.name = name;
		this.userId = userId;
	}

	@Column(name = "LOGIN_NAME")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "USER_Id")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "FAILED_TIMES")
	public Integer getFailedTimes() {
		return failedTimes;
	}

	public void setFailedTimes(Integer failedTimes) {
		this.failedTimes = failedTimes;
	}

	@Column(name = "PHONENO")
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "STATE")
	public NoticeState getNoticeState() {
		return noticeState;
	}

	public void setNoticeState(NoticeState noticeState) {
		this.noticeState = noticeState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE")
	public NoticeType getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(NoticeType noticeType) {
		this.noticeType = noticeType;
	}

	@Column(name = "INFO")
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "SEND_TIME")
	public Calendar getSendTime() {
		return sendTime;
	}

	public void setSendTime(Calendar sendTime) {
		this.sendTime = sendTime;
	}

}
