/* Copyright @2017 Beijing ATNC Co.,Ltd. All rights reserved
 *
 * 创建人：王凌斌
 * 创建时间：@2017年1月19日 上午11:20:37
 * 
 * 修改人：
 * 修改时间：
 * 修改内容：
 */
package cn.com.atnc.ioms.entity.reports;

import java.util.List;

/**
 * KU维保月度报表实体
 * 
 * @author 王凌斌
 * @2017年1月19日 上午11:20:37
 */
public class KuMaintenceEntity {

	// 标题
	private String title;
	// 站点名
	private String site;
	// 基本情况
	private String baseInfo;
	// 故障处理情况
	private String faultInfo;
	// 运行情况总结
	private String operSummary;
	// 运行维护建议
	private String operAdvice;
	// MODEM参数集合
	private List<KuMaintenceNodeInfoEntity> nodeInfos;
	// ODU参数集合
	private List<KuMaintenceODUEntity> odus;
	// 告警总次数
	private String alarmTime;
	// 卫星链路参数
	private List<KuMaintenceOperEntity> links;
	// 设备故障情况
	private List<KuMaintenceOperEntity> faults;
	// 电路运行情况
	private List<KuMaintenceOperEntity> opers;
	// 告警情况
	private List<KuMaintenceAlarmEntity> alarms;

	public KuMaintenceEntity() {
		super();
	}

	public KuMaintenceEntity(String title, String site, String baseInfo,
			String faultInfo, String operSummary, String operAdvice,
			List<KuMaintenceNodeInfoEntity> nodeInfos,
			List<KuMaintenceODUEntity> odus, String alarmTime,
			List<KuMaintenceOperEntity> links,
			List<KuMaintenceOperEntity> faults,
			List<KuMaintenceOperEntity> opers,
			List<KuMaintenceAlarmEntity> alarms) {
		super();
		this.title = title;
		this.site = site;
		this.baseInfo = baseInfo;
		this.faultInfo = faultInfo;
		this.operSummary = operSummary;
		this.operAdvice = operAdvice;
		this.nodeInfos = nodeInfos;
		this.odus = odus;
		this.alarmTime = alarmTime;
		this.links = links;
		this.faults = faults;
		this.opers = opers;
		this.alarms = alarms;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public List<KuMaintenceNodeInfoEntity> getNodeInfos() {
		return nodeInfos;
	}

	public void setNodeInfos(List<KuMaintenceNodeInfoEntity> nodeInfos) {
		this.nodeInfos = nodeInfos;
	}

	public List<KuMaintenceODUEntity> getOdus() {
		return odus;
	}

	public void setOdus(List<KuMaintenceODUEntity> odus) {
		this.odus = odus;
	}

	public String getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}

	public List<KuMaintenceOperEntity> getLinks() {
		return links;
	}

	public void setLinks(List<KuMaintenceOperEntity> links) {
		this.links = links;
	}

	public List<KuMaintenceOperEntity> getFaults() {
		return faults;
	}

	public void setFaults(List<KuMaintenceOperEntity> faults) {
		this.faults = faults;
	}

	public List<KuMaintenceOperEntity> getOpers() {
		return opers;
	}

	public void setOpers(List<KuMaintenceOperEntity> opers) {
		this.opers = opers;
	}

	public List<KuMaintenceAlarmEntity> getAlarms() {
		return alarms;
	}

	public void setAlarms(List<KuMaintenceAlarmEntity> alarms) {
		this.alarms = alarms;
	}

	public String getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(String baseInfo) {
		this.baseInfo = baseInfo;
	}

	public String getFaultInfo() {
		return faultInfo;
	}

	public void setFaultInfo(String faultInfo) {
		this.faultInfo = faultInfo;
	}

	public String getOperSummary() {
		return operSummary;
	}

	public void setOperSummary(String operSummary) {
		this.operSummary = operSummary;
	}

	public String getOperAdvice() {
		return operAdvice;
	}

	public void setOperAdvice(String operAdvice) {
		this.operAdvice = operAdvice;
	}

}
