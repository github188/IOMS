package cn.com.atnc.ioms.model.phonemng;

import java.util.Date;

import cn.com.atnc.ioms.model.MyPaginModel;
/**
 * 
 * @author hantianyu
 * @creatime 2016-8-19上午11:08:31
 * TODO
 */
public class CallAgentMngQueryModel extends MyPaginModel{

	private int index;
	
	private String eventType;//事件类型
	private String exten;//坐席号-工号
	private String extenType;//坐席登录方式
	private String eventState;//事件状态
	private String agent;//坐席号
	private String nowTime;//发生时间
	private String busyType;//置忙类型
	private String userName;//坐席工程师姓名
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getExten() {
		return exten;
	}
	public void setExten(String exten) {
		this.exten = exten;
	}
	public String getExtenType() {
		return extenType;
	}
	public void setExtenType(String extenType) {
		this.extenType = extenType;
	}
	public String getEventState() {
		return eventState;
	}
	public void setEventState(String eventState) {
		this.eventState = eventState;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getNowTime() {
		return nowTime;
	}
	public void setNowTime(String nowTime) {
		this.nowTime = nowTime;
	}
	public String getBusyType() {
		return busyType;
	}
	public void setBusyType(String busyType) {
		this.busyType = busyType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
