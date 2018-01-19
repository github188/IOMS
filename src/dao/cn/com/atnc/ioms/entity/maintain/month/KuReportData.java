package cn.com.atnc.ioms.entity.maintain.month;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;

/**
 * KU月度报表数据
 * 
 * @author 王凌斌
 * @2017年1月24日 上午10:36:35
 */
@Entity
@Table(name = "TB_BD_KU_REPORT_DATA")
public class KuReportData extends MyStringUUIDEntity {

	private static final long serialVersionUID = 7120253450531730192L;
	// 基本情况
	private String baseInfo;
	// 故障处理情况
	private String faultInfo;
	// 运行情况总结
	private String operSummary;
	// 运行维护建议
	private String operAdvice;
	// 站点ID
	private SatelliteSite satelliteSite;
	// 日期
	private String reportDate;

	@Column(name = "BASE_INFO")
	public String getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(String baseInfo) {
		this.baseInfo = baseInfo;
	}

	@Column(name = "FAULT_INFO")
	public String getFaultInfo() {
		return faultInfo;
	}

	public void setFaultInfo(String faultInfo) {
		this.faultInfo = faultInfo;
	}

	@Column(name = "OPER_SUMMARY")
	public String getOperSummary() {
		return operSummary;
	}

	public void setOperSummary(String operSummary) {
		this.operSummary = operSummary;
	}

	@Column(name = "OPER_ADVICE")
	public String getOperAdvice() {
		return operAdvice;
	}

	public void setOperAdvice(String operAdvice) {
		this.operAdvice = operAdvice;
	}

	@ManyToOne
	@JoinColumn(name = "SATELLITE_ID")
	public SatelliteSite getSatelliteSite() {
		return satelliteSite;
	}

	public void setSatelliteSite(SatelliteSite satelliteSite) {
		this.satelliteSite = satelliteSite;
	}

	@Column(name = "REPORT_DATE")
	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

}
