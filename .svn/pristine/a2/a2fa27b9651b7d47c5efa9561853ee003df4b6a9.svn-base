package cn.com.atnc.ioms.entity.business.telegraph;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.enums.business.telegraph.ConnectionConditionEnum;


/**
 * 民航转报网转报地址及路由配置信息表
 * @author WangLingbin
 * @date 2015年6月18日 上午9:11:08
 * @since 1.0.0
 */
@Entity
@Table(name = "TB_OM_APPLY_TELEGRAM_CONFIG")
public class TeleGraphConfig extends MyStringUUIDEntity {
	/**
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * TODO（基础信息）
	 * @since 1.0.0
	 */
	private TeleGraph teleGraph;
	
	/**
	 * TODO（序号）
	 * @since 1.0.0
	 */
	private String identifier;
	
	/**
	 * TODO（地区网络中心使用地点）
	 * @since 1.0.0
	 */
	private String areaUseAddr;
	
	
	/**
	 * TODO（地区网络中心路由地址）
	 * @since 1.0.0
	 */
	private String areaRouteAddr;
	
	/**
	 * TODO（地区网络中心配置时间）
	 * @since 1.0.0
	 */
	private Date areaConfigTime;
	
	/**
	 * TODO（地区网络中心配置人）
	 * @since 1.0.0
	 */
	private String areaConfigPeople;
	
	/**
	 * TODO（地区网络中心终端连接情况）
	 * @since 1.0.0
	 */
	private ConnectionConditionEnum areaConnectionCondition;
	
	/**
	 * TODO（天航信配置路由地址）
	 * @since 1.0.0
	 */
	private String atncRountAddr;

	/**
	 * TODO（天航信配置时间）
	 * @since 1.0.0
	 */
	private Date atncConfigTime;
	
	/**
	 * TODO（天航信配置人）
	 * @since 1.0.0
	 */
	private String atncConfigPeople;
	
	/**
	 * TODO（天航信终端连接情况）
	 * @since 1.0.0
	 */
	private ConnectionConditionEnum atncConnectionCondition;

	@OneToOne
	@JoinColumn(name = "baseinfo")
	public TeleGraph getTeleGraph() {
		return teleGraph;
	}

	public void setTeleGraph(TeleGraph teleGraph) {
		this.teleGraph = teleGraph;
	}

	@Column(name = "identifier")
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	@Column(name = "area_use_address")
	public String getAreaUseAddr() {
		return areaUseAddr;
	}

	public void setAreaUseAddr(String areaUseAddr) {
		this.areaUseAddr = areaUseAddr;
	}

	@Column(name = "area_route_address")
	public String getAreaRouteAddr() {
		return areaRouteAddr;
	}

	public void setAreaRouteAddr(String areaRouteAddr) {
		this.areaRouteAddr = areaRouteAddr;
	}
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "area_config_time")
	public Date getAreaConfigTime() {
		return areaConfigTime;
	}

	public void setAreaConfigTime(Date areaConfigTime) {
		this.areaConfigTime = areaConfigTime;
	}

	@Column(name = "area_config_people")
	public String getAreaConfigPeople() {
		return areaConfigPeople;
	}

	public void setAreaConfigPeople(String areaConfigPeople) {
		this.areaConfigPeople = areaConfigPeople;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "area_connect_condition")
	public ConnectionConditionEnum getAreaConnectionCondition() {
		return areaConnectionCondition;
	}

	public void setAreaConnectionCondition(
			ConnectionConditionEnum areaConnectionCondition) {
		this.areaConnectionCondition = areaConnectionCondition;
	}

	@Column(name = "atnc_route_address")
	public String getAtncRountAddr() {
		return atncRountAddr;
	}

	public void setAtncRountAddr(String atncRountAddr) {
		this.atncRountAddr = atncRountAddr;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "atnc_config_time")
	public Date getAtncConfigTime() {
		return atncConfigTime;
	}

	public void setAtncConfigTime(Date atncConfigTime) {
		this.atncConfigTime = atncConfigTime;
	}

	@Column(name = "atnc_config_people")
	public String getAtncConfigPeople() {
		return atncConfigPeople;
	}

	public void setAtncConfigPeople(String atncConfigPeople) {
		this.atncConfigPeople = atncConfigPeople;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "atnc_connect_condition")
	public ConnectionConditionEnum getAtncConnectionCondition() {
		return atncConnectionCondition;
	}

	public void setAtncConnectionCondition(
			ConnectionConditionEnum atncConnectionCondition) {
		this.atncConnectionCondition = atncConnectionCondition;
	}
	
}
