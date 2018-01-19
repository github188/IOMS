package cn.com.atnc.ioms.entity.phonemng;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;

/**
 * 
 * @author hantianyu
 *
 */
@Entity
@Table(name = "TB_TEL_CALL_AGENT_MNG")
public class CallAgentMng  extends MyStringUUIDEntity{

	private static final long serialVersionUID = -6739376065386900888L;
	
	private String eventType;//事件类型
	private String exten;//坐席号-工号
	private String extenType;//坐席登录方式
	private String eventState;//事件状态
	private String agent;//坐席号
	private Date nowTime;//发生时间
	private String busyType;//置忙类型
	private String userName;//坐席工程师姓名
	
	@Column(name = "EVENT_TYPE")
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	@Column(name = "EXTEN")
	public String getExten() {
		return exten;
	}
	public void setExten(String exten) {
		this.exten = exten;
	}
	@Column(name = "EXTEN_TYPE")
	public String getExtenType() {
		return extenType;
	}
	public void setExtenType(String extenType) {
		this.extenType = extenType;
	}
	@Column(name = "EVENT_STATE")
	public String getEventState() {
		return eventState;
	}
	public void setEventState(String eventState) {
		this.eventState = eventState;
	}
	@Column(name = "AGENT")
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	
	@Column(name = "TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getNowTime() {
		return nowTime;
	}
	public void setNowTime(Date nowTime) {
		this.nowTime = nowTime;
	}
	@Column(name = "BUSY_TYPE")
	public String getBusyType() {
		return busyType;
	}
	public void setBusyType(String busyType) {
		this.busyType = busyType;
	}
	@Column(name = "USERNAME")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
}
