package cn.com.atnc.ioms.entity.maintain.month;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.enums.maintain.month.KuMonthReportLegendEnum;

/**
 * KU月度报表数据
 * 
 * @author 王凌斌
 * @2017年1月24日 上午10:36:35
 */
@Entity
@Table(name = "TB_BD_KU_MONTH_REPORT")
public class KuMonthReport extends MyStringUUIDEntity {

	private static final long serialVersionUID = 8244295831096378164L;

	// 统计纬度
	private KuMonthReportLegendEnum legend;
	// 数据值
	private String data;
	// 统计日期：yyyy-MM-dd
	private Date recordDate;
	// 统计日期：yyyy-MM
	private String recordTime;
	//节点ID
	private Equip equip;
	// 站点ID
	private SatelliteSite satellite;

	public KuMonthReport() {
		super();
	}

	public KuMonthReport(KuMonthReportLegendEnum legend, String data,
			Date recordDate, String recordTime, Equip equip,
			SatelliteSite satellite) {
		super();
		this.legend = legend;
		this.data = data;
		this.recordDate = recordDate;
		this.recordTime = recordTime;
		this.equip = equip;
		this.satellite = satellite;
	}

	@Enumerated(value = EnumType.STRING)
	@Column(name = "LEGEND")
	public KuMonthReportLegendEnum getLegend() {
		return legend;
	}

	public void setLegend(KuMonthReportLegendEnum legend) {
		this.legend = legend;
	}

	@Column(name = "DATA")
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "RECORD_DATE")
	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	@Column(name = "RECORD_TIME")
	public String getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}

	@ManyToOne
	@JoinColumn(name = "EQUIP_ID")
	public Equip getEquip() {
		return equip;
	}

	public void setEquip(Equip equip) {
		this.equip = equip;
	}

	@ManyToOne
	@JoinColumn(name = "SATELLITE_ID")
	public SatelliteSite getSatellite() {
		return satellite;
	}

	public void setSatellite(SatelliteSite satellite) {
		this.satellite = satellite;
	}

}
