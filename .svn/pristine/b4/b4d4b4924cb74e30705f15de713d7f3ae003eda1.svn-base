package cn.com.atnc.ioms.entity.duty.fax.day;

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
import cn.com.atnc.ioms.enums.duty.fax.FaxHXTProjectName;
import cn.com.atnc.ioms.enums.duty.fax.FaxStatus;
import cn.com.atnc.ioms.enums.duty.fax.FaxStatusHXT;

/**
 * 航信通日检表-日检
 *
 * @author 韩天驭
 * @2017年2月3日 上午9:47:38
 */
@Entity
@Table(name = "TB_OM_DUTY_FAX_DAY_HXT")
public class FaxHXTDay extends MyStringUUIDEntity {
	private static final long serialversionUID = 1L;
	// 项目名称-枚举：Messages Enqueued、Messages Dequeued
	private FaxHXTProjectName projectName;
	private String cjdata;
	private String predata;
	private String serialPortInfo;
	private String webService;

	private String cjMonitorNum;
	private FaxStatusHXT cjMonitor;
	private String preMonitorNum;
	private FaxStatusHXT preMonitor;
	private String portMonitorNum;
	private FaxStatusHXT portMonitor;
	private String wsMonitorNum;
	private FaxStatusHXT wsMonitor;

	// 巡检时间
	private Date checkTime;
	// 创建日期
	private Date createTime;
	// 创建人
	private User creater;
	// 修改时间
	private Date updateTime;
	// 修改人
	private User updter;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "PROJECT_NAME")
	public FaxHXTProjectName getProjectName() {
		return projectName;
	}
	public void setProjectName(FaxHXTProjectName projectName) {
		this.projectName = projectName;
	}
	
	@Column(name = "CJDATA")
	public String getCjdata() {
		return cjdata;
	}
	public void setCjdata(String cjdata) {
		this.cjdata = cjdata;
	}
	
	@Column(name = "PREDATA")
	public String getPredata() {
		return predata;
	}
	public void setPredata(String predata) {
		this.predata = predata;
	}
	
	@Column(name = "SERIALPORTINFO")
	public String getSerialPortInfo() {
		return serialPortInfo;
	}
	public void setSerialPortInfo(String serialPortInfo) {
		this.serialPortInfo = serialPortInfo;
	}
	
	@Column(name = "WEBSERVICE")
	public String getWebService() {
		return webService;
	}
	public void setWebService(String webService) {
		this.webService = webService;
	}
	
	@Column(name = "CJDATA_MONITOR_NUM")
	public String getCjMonitorNum() {
		return cjMonitorNum;
	}
	public void setCjMonitorNum(String cjMonitorNum) {
		this.cjMonitorNum = cjMonitorNum;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "CJDATA_MONITOR")
	public FaxStatusHXT getCjMonitor() {
		return cjMonitor;
	}
	public void setCjMonitor(FaxStatusHXT cjMonitor) {
		this.cjMonitor = cjMonitor;
	}
	
	@Column(name = "PREDATA_MONITOR_NUM")
	public String getPreMonitorNum() {
		return preMonitorNum;
	}
	public void setPreMonitorNum(String preMonitorNum) {
		this.preMonitorNum = preMonitorNum;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "PREDATA_MONITOR")
	public FaxStatusHXT getPreMonitor() {
		return preMonitor;
	}
	public void setPreMonitor(FaxStatusHXT preMonitor) {
		this.preMonitor = preMonitor;
	}
	
	@Column(name = "SERIALPORTINFO_MONITOR_NUM")
	public String getPortMonitorNum() {
		return portMonitorNum;
	}
	public void setPortMonitorNum(String portMonitorNum) {
		this.portMonitorNum = portMonitorNum;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SERIALPORTINFO_MONITOR")
	public FaxStatusHXT getPortMonitor() {
		return portMonitor;
	}
	public void setPortMonitor(FaxStatusHXT portMonitor) {
		this.portMonitor = portMonitor;
	}
	
	@Column(name = "WEBSERVICE_MONITOR_NUM")
	public String getWsMonitorNum() {
		return wsMonitorNum;
	}
	public void setWsMonitorNum(String wsMonitorNum) {
		this.wsMonitorNum = wsMonitorNum;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "WEBSERVICE_MONITOR")
	public FaxStatusHXT getWsMonitor() {
		return wsMonitor;
	}
	public void setWsMonitor(FaxStatusHXT wsMonitor) {
		this.wsMonitor = wsMonitor;
	}
	
	@Column(name = "CHECK_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
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
	@JoinColumn(name="CREATER")
	public User getCreater() {
		return creater;
	}
	public void setCreater(User creater) {
		this.creater = creater;
	}
	
	@Column(name = "UPDATE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	@ManyToOne
	@JoinColumn(name="UPDTER")
	public User getUpdter() {
		return updter;
	}
	public void setUpdter(User updter) {
		this.updter = updter;
	}
	
	

}
