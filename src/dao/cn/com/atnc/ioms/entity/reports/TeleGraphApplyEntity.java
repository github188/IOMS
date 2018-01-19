/**
 * @ProjectName PCSP
 * @FileName TeleGraphApplyEntity.java
 * @PackageName:cn.com.atnc.pcsp.entity.reports
 * @author WangLingbin
 * @date 2015年5月28日下午3:48:27
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.entity.reports;

import java.util.Date;

/**
 * 转报地址申请报表实体
 * @author WangLingbin
 * @date 2015年5月28日 下午3:48:27
 * @since 1.0.0
 */
public class TeleGraphApplyEntity {

	private String num;						//序号
	private String applyUserArea;			//使用地点
	private String applyUsage;				//申请用途
	private Date applyTime;					//使用时间
	private Date useTime;					//要求启用时间
	private String connectionCondition;		//终端连接情况
	private String originalAddr;			//原地址
	private String allocatedAddr;			//分配的通信路由地址
	private String operPeople;				//经办人
	private Date operTime;					//经办时间
	public TeleGraphApplyEntity() {
		super();
	}
	public TeleGraphApplyEntity(String num, String applyUserArea,
			String applyUsage, Date applyTime, Date useTime,
			String connectionCondition, String originalAddr,
			String allocatedAddr, String operPeople, Date operTime) {
		super();
		this.num = num;
		this.applyUserArea = applyUserArea;
		this.applyUsage = applyUsage;
		this.applyTime = applyTime;
		this.useTime = useTime;
		this.connectionCondition = connectionCondition;
		this.originalAddr = originalAddr;
		this.allocatedAddr = allocatedAddr;
		this.operPeople = operPeople;
		this.operTime = operTime;
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getApplyUserArea() {
		return applyUserArea;
	}
	public void setApplyUserArea(String applyUserArea) {
		this.applyUserArea = applyUserArea;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public Date getUseTime() {
		return useTime;
	}
	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}
	public String getConnectionCondition() {
		return connectionCondition;
	}
	public void setConnectionCondition(String connectionCondition) {
		this.connectionCondition = connectionCondition;
	}
	public String getOriginalAddr() {
		return originalAddr;
	}
	public void setOriginalAddr(String originalAddr) {
		this.originalAddr = originalAddr;
	}
	public String getAllocatedAddr() {
		return allocatedAddr;
	}
	public void setAllocatedAddr(String allocatedAddr) {
		this.allocatedAddr = allocatedAddr;
	}
	public String getOperPeople() {
		return operPeople;
	}
	public void setOperPeople(String operPeople) {
		this.operPeople = operPeople;
	}
	public Date getOperTime() {
		return operTime;
	}
	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}
	public String getApplyUsage() {
		return applyUsage;
	}
	public void setApplyUsage(String applyUsage) {
		this.applyUsage = applyUsage;
	}
	
}
