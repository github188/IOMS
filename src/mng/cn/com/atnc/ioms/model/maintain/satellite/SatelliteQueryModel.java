/* Copyright @2017 Beijing ATNC Co.,Ltd. All rights reserved
 *
 * 创建人：王凌斌
 * 创建时间：@2017年1月22日 下午2:22:12
 * 
 * 修改人：
 * 修改时间：
 * 修改内容：
 */
package cn.com.atnc.ioms.model.maintain.satellite;

import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.model.MyPaginModel;

/**
 *
 * @author 王凌斌
 * @2017年1月22日 下午2:22:12
 */
public class SatelliteQueryModel extends MyPaginModel {

	// 设备对应的卫星站信息
	private SatelliteSite satelliteSite;
	// 站点名称
	private String siteNameLike;
	// 日期
	private String reportDate;
	// 基本情况
	private String baseInfo;
	// 故障处理情况
	private String faultInfo;
	// 运行情况总结
	private String operSummary;
	// 运行维护建议
	private String operAdvice;

	public SatelliteQueryModel(SatelliteSite satelliteSite) {
		super();
		this.satelliteSite = satelliteSite;
	}

	public SatelliteQueryModel() {
		super();
	}

	public SatelliteSite getSatelliteSite() {
		return satelliteSite;
	}

	public void setSatelliteSite(SatelliteSite satelliteSite) {
		this.satelliteSite = satelliteSite;
	}

	public String getSiteNameLike() {
		return siteNameLike;
	}

	public void setSiteNameLike(String siteNameLike) {
		this.siteNameLike = siteNameLike;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
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
