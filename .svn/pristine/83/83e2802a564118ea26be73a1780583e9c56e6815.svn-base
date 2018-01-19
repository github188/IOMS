package cn.com.atnc.ioms.entity.business.satellite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;

/**
 * 卫星通信网入网配置表信息
 *
 * @author WangLingbin
 * @date 2015年10月22日 上午11:29:22
 * @since 1.0.0
 */
@Entity
@Table(name="TB_OM_APPLY_KUSATELLITE_CONFIG")
public class KuSatelliteConfig extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;
	
	private KuSatellite kuSatellite;
	private String node;
	private String mediumFrequency;
	private String emissionFrequency;
	private String receiveFrequency;
	private String operEngineer;
	private Date operDate;
	
	public KuSatelliteConfig() {
		super();
	}
	
	public KuSatelliteConfig(KuSatellite kuSatellite, String node,
			String mediumFrequency, String emissionFrequency,
			String receiveFrequency, String operEngineer, Date operDate) {
		super();
		this.kuSatellite = kuSatellite;
		this.node = node;
		this.mediumFrequency = mediumFrequency;
		this.emissionFrequency = emissionFrequency;
		this.receiveFrequency = receiveFrequency;
		this.operEngineer = operEngineer;
		this.operDate = operDate;
	}
	@ManyToOne
	@JoinColumn(name="baseinfo")
	public KuSatellite getKuSatellite() {
		return kuSatellite;
	}
	public void setKuSatellite(KuSatellite kuSatellite) {
		this.kuSatellite = kuSatellite;
	}
	@Column(name = "node")
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	@Column(name = "medinum_frequency")
	public String getMediumFrequency() {
		return mediumFrequency;
	}
	public void setMediumFrequency(String mediumFrequency) {
		this.mediumFrequency = mediumFrequency;
	}
	@Column(name = "emission_frequency")
	public String getEmissionFrequency() {
		return emissionFrequency;
	}
	public void setEmissionFrequency(String emissionFrequency) {
		this.emissionFrequency = emissionFrequency;
	}
	@Column(name = "receive_frequency")
	public String getReceiveFrequency() {
		return receiveFrequency;
	}
	public void setReceiveFrequency(String receiveFrequency) {
		this.receiveFrequency = receiveFrequency;
	}
	@Column(name="oper_engineer")
	public String getOperEngineer() {
		return operEngineer;
	}
	public void setOperEngineer(String operEngineer) {
		this.operEngineer = operEngineer;
	}
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name="oper_date")
	public Date getOperDate() {
		return operDate;
	}
	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}
	
}
