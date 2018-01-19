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
import cn.com.atnc.ioms.enums.duty.fax.FaxStatus;

/**
 * 路由器设备巡检（自动）
 *
 * @author 韩天驭
 * @2017年2月6日 上午10:38:23
 */
@Entity
@Table(name = "TB_OM_DUTY_FAX_DAY_ROUTER")
public class FaxRouterDay extends MyStringUUIDEntity {
	private static final long serialversionUID = 1L;
	
	// 转报应急路由器能否正常登陆
	private FaxStatus emeRouterIsLogin;
	// 转报应急路由器业务端口是否正常
	private FaxStatus emeRouterServicePort;
	// 外蒙路由器能否正常登陆
	private FaxStatus outerRouterIsLogin;
	// 外蒙路由器业务端口是否正常
	private FaxStatus outerRouterServicePort;
	// SLH_MASTER路由器能否正常登陆
	private FaxStatus slhMasterIsLogin;
	// SLH_MASTER路由器业务端口是否正常
	private FaxStatus slhMasterServicePort;
	// SITA_MASTER路由器能否正常登陆
	private FaxStatus sitaMasterIsLogin;
	// SITA_MASTER路由器业务端口是否正常
	private FaxStatus sitaMasterServicePort;
	// SITA_SLAVE路由器能否正常登陆
	private FaxStatus sitaSlaveIsLogin;
	// SITA_SLAVE路由器业务端口是否正常
	private FaxStatus sitaSlaveServicePort;
	// ACARS路由器2能否正常登陆
	private FaxStatus Acars2IsLogin;
	// ACARS路由器2业务端口是否正常
	private FaxStatus Acars2ServicePort;
	// 雷达路由器2能否正常登陆
	private FaxStatus radar2IsLogin;
	// 雷达路由器2业务端口是否正常
	private FaxStatus radar2ServicePort;
	// 气象路由器2能否正常登陆
	private FaxStatus met2IsLogin;
	// 气象路由器2业务端口是否正常
	private FaxStatus met2ServicePort;
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
	@Column(name = "EMERGENCY_ROUTER_IS_LOGIN")
	public FaxStatus getEmeRouterIsLogin() {
		return emeRouterIsLogin;
	}
	public void setEmeRouterIsLogin(FaxStatus emeRouterIsLogin) {
		this.emeRouterIsLogin = emeRouterIsLogin;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "EMERGENCY_ROUTER_SERVICE_PORT")
	public FaxStatus getEmeRouterServicePort() {
		return emeRouterServicePort;
	}
	public void setEmeRouterServicePort(FaxStatus emeRouterServicePort) {
		this.emeRouterServicePort = emeRouterServicePort;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "OUTER_ROUTER_IS_LOGIN")
	public FaxStatus getOuterRouterIsLogin() {
		return outerRouterIsLogin;
	}
	public void setOuterRouterIsLogin(FaxStatus outerRouterIsLogin) {
		this.outerRouterIsLogin = outerRouterIsLogin;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "OUTER_ROUTER_SERVICE_PORT")
	public FaxStatus getOuterRouterServicePort() {
		return outerRouterServicePort;
	}
	public void setOuterRouterServicePort(FaxStatus outerRouterServicePort) {
		this.outerRouterServicePort = outerRouterServicePort;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SLH_MASTER_ROUTER_IS_LOGIN")
	public FaxStatus getSlhMasterIsLogin() {
		return slhMasterIsLogin;
	}
	public void setSlhMasterIsLogin(FaxStatus slhMasterIsLogin) {
		this.slhMasterIsLogin = slhMasterIsLogin;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SLH_MASTER_ROUTER_SERVICE_PORT")
	public FaxStatus getSlhMasterServicePort() {
		return slhMasterServicePort;
	}
	public void setSlhMasterServicePort(FaxStatus slhMasterServicePort) {
		this.slhMasterServicePort = slhMasterServicePort;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SITA_M_ROUTER_IS_LOGIN")
	public FaxStatus getSitaMasterIsLogin() {
		return sitaMasterIsLogin;
	}
	public void setSitaMasterIsLogin(FaxStatus sitaMasterIsLogin) {
		this.sitaMasterIsLogin = sitaMasterIsLogin;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SITA_M_ROUTER_SERVICE_PORT")
	public FaxStatus getSitaMasterServicePort() {
		return sitaMasterServicePort;
	}
	public void setSitaMasterServicePort(FaxStatus sitaMasterServicePort) {
		this.sitaMasterServicePort = sitaMasterServicePort;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SITA_SLAVE_ROUTER_IS_LOGIN")
	public FaxStatus getSitaSlaveIsLogin() {
		return sitaSlaveIsLogin;
	}
	public void setSitaSlaveIsLogin(FaxStatus sitaSlaveIsLogin) {
		this.sitaSlaveIsLogin = sitaSlaveIsLogin;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SITA_SLAVE_ROUTER_SERVICE_PORT")
	public FaxStatus getSitaSlaveServicePort() {
		return sitaSlaveServicePort;
	}
	public void setSitaSlaveServicePort(FaxStatus sitaSlaveServicePort) {
		this.sitaSlaveServicePort = sitaSlaveServicePort;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ACARS_ROUTER_2_IS_LOGIN")
	public FaxStatus getAcars2IsLogin() {
		return Acars2IsLogin;
	}
	public void setAcars2IsLogin(FaxStatus acars2IsLogin) {
		Acars2IsLogin = acars2IsLogin;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ACARS_ROUTER_2_SERVICE_PORT")
	public FaxStatus getAcars2ServicePort() {
		return Acars2ServicePort;
	}
	public void setAcars2ServicePort(FaxStatus acars2ServicePort) {
		Acars2ServicePort = acars2ServicePort;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "RADAR_ROUTER_2_IS_LOGIN")
	public FaxStatus getRadar2IsLogin() {
		return radar2IsLogin;
	}
	public void setRadar2IsLogin(FaxStatus radar2IsLogin) {
		this.radar2IsLogin = radar2IsLogin;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "RADAR_ROUTER_2_SERVICE_PORT")
	public FaxStatus getRadar2ServicePort() {
		return radar2ServicePort;
	}
	public void setRadar2ServicePort(FaxStatus radar2ServicePort) {
		this.radar2ServicePort = radar2ServicePort;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "MET_ROUTER_2_IS_LOGIN")
	public FaxStatus getMet2IsLogin() {
		return met2IsLogin;
	}
	public void setMet2IsLogin(FaxStatus met2IsLogin) {
		this.met2IsLogin = met2IsLogin;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "MET_ROUTER_2_SERVICE_PORT")
	public FaxStatus getMet2ServicePort() {
		return met2ServicePort;
	}
	public void setMet2ServicePort(FaxStatus met2ServicePort) {
		this.met2ServicePort = met2ServicePort;
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
