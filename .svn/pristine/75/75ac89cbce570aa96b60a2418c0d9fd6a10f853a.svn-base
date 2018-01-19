package cn.com.atnc.ioms.model.maintain.alarminfo;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.basedata.resource.Proxy;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.maintain.alarminfo.FtpLink;
import cn.com.atnc.ioms.entity.maintain.alarminfo.LinkAlarm;
import cn.com.atnc.ioms.entity.maintain.alarminfo.LinkAlarmHistory;
import cn.com.atnc.ioms.entity.maintain.alarminfo.LinkAlarmMonitor;
import cn.com.atnc.ioms.entity.maintain.alarminfo.StatusAlarm;
import cn.com.atnc.ioms.entity.maintain.alarminfo.StatusAlarmHistory;
import cn.com.atnc.ioms.entity.maintain.alarminfo.StatusAlarmMonitor;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.model.MyPaginModel;

 /**
 * 此处添加类AlarmInfoQueryModel的描述信息
 *
 * @author wangzhicheng
 * @date 2015-5-4 上午8:57:10
 * @since 1.0.0
 */
/**
 * 此处添加类AlarmInfoQueryModel的描述信息
 *
 * @author XuTongYang
 * @date 2015年6月10日 上午10:34:40
 * @since 1.0.0
 */
public class AlarmInfoQueryModel extends MyPaginModel {
	
	private MaintainEquip equipId;// 告警关联设备id
	private Bureau bureau;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Calendar startRecordTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Calendar endRecordTime;
	
    private String stname;
    private String eqname;
    private String optType;
    private int index;
    
    private LinkAlarm linkAlarm;
    private StatusAlarm statusAlarm;
    private LinkAlarmMonitor linkAlarmMonitor;
    private StatusAlarmMonitor statusAlarmMonitor;
    private LinkAlarmHistory linkAlarmHistory;
    private StatusAlarmHistory statusAlarmHistory;
    private String status;
    
    private FtpLink ftpLink;
    private Proxy proxy;
    private SatelliteSite satelliteSite;
    
	public MaintainEquip getEquipId() {
		return equipId;
	}
	public void setEquipId(MaintainEquip equipId) {
		this.equipId = equipId;
	}
	public Bureau getBureau() {
		return bureau;
	}
	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}
	public Calendar getStartRecordTime() {
		return startRecordTime;
	}
	public void setStartRecordTime(Calendar startRecordTime) {
		this.startRecordTime = startRecordTime;
	}
	public Calendar getEndRecordTime() {
		return endRecordTime;
	}
	public void setEndRecordTime(Calendar endRecordTime) {
		this.endRecordTime = endRecordTime;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getOptType() {
		return optType;
	}
	public void setOptType(String optType) {
		this.optType = optType;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public StatusAlarm getStatusAlarm() {
		return statusAlarm;
	}
	public void setStatusAlarm(StatusAlarm statusAlarm) {
		this.statusAlarm = statusAlarm;
	}
	public LinkAlarm getLinkAlarm() {
		return linkAlarm;
	}
	public void setLinkAlarm(LinkAlarm linkAlarm) {
		this.linkAlarm = linkAlarm;
	}
	
	public LinkAlarmMonitor getLinkAlarmMonitor() {
		return linkAlarmMonitor;
	}
	public void setLinkAlarmMonitor(LinkAlarmMonitor linkAlarmMonitor) {
		this.linkAlarmMonitor = linkAlarmMonitor;
	}
	public StatusAlarmMonitor getStatusAlarmMonitor() {
		return statusAlarmMonitor;
	}
	public void setStatusAlarmMonitor(StatusAlarmMonitor statusAlarmMonitor) {
		this.statusAlarmMonitor = statusAlarmMonitor;
	}
	public LinkAlarmHistory getLinkAlarmHistory() {
		return linkAlarmHistory;
	}
	public void setLinkAlarmHistory(LinkAlarmHistory linkAlarmHistory) {
		this.linkAlarmHistory = linkAlarmHistory;
	}
	public StatusAlarmHistory getStatusAlarmHistory() {
		return statusAlarmHistory;
	}
	public void setStatusAlarmHistory(StatusAlarmHistory statusAlarmHistory) {
		this.statusAlarmHistory = statusAlarmHistory;
	}
	public String getEqname() {
		return eqname;
	}
	public void setEqname(String eqname) {
		this.eqname = eqname;
	}
	public FtpLink getFtpLink() {
		return ftpLink;
	}
	public void setFtpLink(FtpLink ftpLink) {
		this.ftpLink = ftpLink;
	}
	public Proxy getProxy() {
		return proxy;
	}
	public void setProxy(Proxy proxy) {
		this.proxy = proxy;
	}
	public SatelliteSite getSatelliteSite() {
		return satelliteSite;
	}
	public void setSatelliteSite(SatelliteSite satelliteSite) {
		this.satelliteSite = satelliteSite;
	}
    
    
}
