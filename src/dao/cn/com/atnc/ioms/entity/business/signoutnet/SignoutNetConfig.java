package cn.com.atnc.ioms.entity.business.signoutnet;

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
 * 卫星通信网退网配置表信息
 *
 * @author 段衍林
 * @2017年1月13日 下午3:58:52
 */
@Entity
@Table(name = "TB_OM_APPLY_SIGNOUTNET_CONFIG")
public class SignoutNetConfig extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	private SignoutNet signoutNet;
	/** ku卫星配置 */
	private String node;
	private String mediumFrequency;
	private String emissionFrequency;
	private String receiveFrequency;
	/** ku卫星配置 */
	/** atm配置 */
	private String placeATM;
	private String placeATMO; // ATMO地址/Loopback地址
	private Boolean connectivity; // 连通性
	private Boolean nodemng; // 节点管理
	private String confRemark; // 入网意见
	/** atm配置 */
	private String operEngineer;
	private Date operDate;

	public SignoutNetConfig() {
		super();
	}

	public SignoutNetConfig(SignoutNet signoutNet, String node,
			String mediumFrequency, String emissionFrequency,
			String receiveFrequency, String operEngineer, Date operDate) {
		super();
		this.signoutNet = signoutNet;
		this.node = node;
		this.mediumFrequency = mediumFrequency;
		this.emissionFrequency = emissionFrequency;
		this.receiveFrequency = receiveFrequency;
		this.operEngineer = operEngineer;
		this.operDate = operDate;
	}

	public SignoutNetConfig(SignoutNet signoutNet, String placeATM,
			String placeATMO, Boolean connectivity, Boolean nodemng,
			String confRemark, String operEngineer, Date operDate) {
		super();
		this.signoutNet = signoutNet;
		this.placeATM = placeATM;
		this.placeATMO = placeATMO;
		this.connectivity = connectivity;
		this.nodemng = nodemng;
		this.confRemark = confRemark;
		this.operEngineer = operEngineer;
		this.operDate = operDate;
	}

	@Column(name = "PLACE_ATM")
	public String getPlaceATM() {
		return placeATM;
	}

	public void setPlaceATM(String placeATM) {
		this.placeATM = placeATM;
	}
	@Column(name = "PLACE_ATMO")
	public String getPlaceATMO() {
		return placeATMO;
	}

	public void setPlaceATMO(String placeATMO) {
		this.placeATMO = placeATMO;
	}

	@Column(name = "CONNECTIVITY")
	public Boolean getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(Boolean connectivity) {
		this.connectivity = connectivity;
	}

	@Column(name = "NODEMNG")
	public Boolean getNodemng() {
		return nodemng;
	}

	public void setNodemng(Boolean nodemng) {
		this.nodemng = nodemng;
	}

	@Column(name = "CONF_REMARK")
	public String getConfRemark() {
		return confRemark;
	}

	public void setConfRemark(String confRemark) {
		this.confRemark = confRemark;
	}

	@ManyToOne
	@JoinColumn(name = "baseinfo")
	public SignoutNet getSignoutNet() {
		return signoutNet;
	}

	public void setSignoutNet(SignoutNet signoutNet) {
		this.signoutNet = signoutNet;
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

	@Column(name = "oper_engineer")
	public String getOperEngineer() {
		return operEngineer;
	}

	public void setOperEngineer(String operEngineer) {
		this.operEngineer = operEngineer;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "oper_date")
	public Date getOperDate() {
		return operDate;
	}

	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}

}
