/**
 * @ProjectName PCSP
 * @FileName TeleGraphConfigEntity.java
 * @PackageName:cn.com.atnc.pcsp.entity.reports
 * @author WangLingbin
 * @date 2015年6月1日上午9:14:10
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.entity.reports;

import java.util.Date;

/**
 * 转报地址配置报表实体
 * @author WangLingbin
 * @date 2015年6月1日 上午9:14:10
 * @since 1.0.0
 */
public class TeleGraphConfigEntity {

	private String identifier;						//序号
	private String areaUseAddr;						//地区网络中心使用地点
	private String areaRouteAddr;					//地区网络中心路由地址
	private Date areaConfigTime;					//地区网络中心配置时间
	private String areaConfigPeople;				//地区网络中心配置人
	private String areaConnectionCondition;			//地区网络中心终端连接情况
	private String atncRountAddr;					//天航信配置路由地址
	private Date atncConfigTime;					//天航信配置时间
	private String atncConfigPeople;				//天航信配置人
	private String atncConnectionCondition;			//天航信终端连接情况
	public TeleGraphConfigEntity() {
		super();
	}
	public TeleGraphConfigEntity(String identifier, String areaUseAddr,
			String areaRouteAddr, Date areaConfigTime, String areaConfigPeople,
			String areaConnectionCondition, String atncRountAddr,
			Date atncConfigTime, String atncConfigPeople,
			String atncConnectionCondition) {
		super();
		this.identifier = identifier;
		this.areaUseAddr = areaUseAddr;
		this.areaRouteAddr = areaRouteAddr;
		this.areaConfigTime = areaConfigTime;
		this.areaConfigPeople = areaConfigPeople;
		this.areaConnectionCondition = areaConnectionCondition;
		this.atncRountAddr = atncRountAddr;
		this.atncConfigTime = atncConfigTime;
		this.atncConfigPeople = atncConfigPeople;
		this.atncConnectionCondition = atncConnectionCondition;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getAreaUseAddr() {
		return areaUseAddr;
	}
	public void setAreaUseAddr(String areaUseAddr) {
		this.areaUseAddr = areaUseAddr;
	}
	public String getAreaRouteAddr() {
		return areaRouteAddr;
	}
	public void setAreaRouteAddr(String areaRouteAddr) {
		this.areaRouteAddr = areaRouteAddr;
	}
	public Date getAreaConfigTime() {
		return areaConfigTime;
	}
	public void setAreaConfigTime(Date areaConfigTime) {
		this.areaConfigTime = areaConfigTime;
	}
	public String getAreaConfigPeople() {
		return areaConfigPeople;
	}
	public void setAreaConfigPeople(String areaConfigPeople) {
		this.areaConfigPeople = areaConfigPeople;
	}
	public String getAreaConnectionCondition() {
		return areaConnectionCondition;
	}
	public void setAreaConnectionCondition(String areaConnectionCondition) {
		this.areaConnectionCondition = areaConnectionCondition;
	}
	public String getAtncRountAddr() {
		return atncRountAddr;
	}
	public void setAtncRountAddr(String atncRountAddr) {
		this.atncRountAddr = atncRountAddr;
	}
	public Date getAtncConfigTime() {
		return atncConfigTime;
	}
	public void setAtncConfigTime(Date atncConfigTime) {
		this.atncConfigTime = atncConfigTime;
	}
	public String getAtncConfigPeople() {
		return atncConfigPeople;
	}
	public void setAtncConfigPeople(String atncConfigPeople) {
		this.atncConfigPeople = atncConfigPeople;
	}
	public String getAtncConnectionCondition() {
		return atncConnectionCondition;
	}
	public void setAtncConnectionCondition(String atncConnectionCondition) {
		this.atncConnectionCondition = atncConnectionCondition;
	}
}
