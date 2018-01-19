package cn.com.atnc.ioms.entity.tempcircuit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitMplsVpnRouterType;

/**
 * 
 * 类说明：临时电路ATM-MPLS-VPN
 * 
 * @author: 局域网_王鹏
 * @time: 2014年4月23日下午6:10:58
 * @version:1.0
 */
@Entity
@Table(name = "TB_OM_CIRCUITTYPE_ATM_MPLS_VPN")
public class TempCircuitAtmMplsVpn extends StringUUIDEntity {
	private static final long serialVersionUID = -4863953347324886311L;
	private TempCircuit tempCircuit;
	private String businessName;
	private String name;
	private String vrfName;
	private String rdValue;
	private String rtValue;
	private String port;
	private String vlan;
	private String ip;
	private CircuitMplsVpnRouterType routeType;
	private String remark;

	@ManyToOne
	@JoinColumn(name = "TEMP_CIRCUIT_ID")
	public TempCircuit getTempCircuit() {
		return tempCircuit;
	}

	public void setTempCircuit(TempCircuit tempCircuit) {
		this.tempCircuit = tempCircuit;
	}

	@Column(name = "BUSINESS_NAME")
	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@Column(name = "NODE_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "VRF_NAME")
	public String getVrfName() {
		return vrfName;
	}

	public void setVrfName(String vrfName) {
		this.vrfName = vrfName;
	}

	@Column(name = "RD_VALUE")
	public String getRdValue() {
		return rdValue;
	}

	public void setRdValue(String rdValue) {
		this.rdValue = rdValue;
	}

	@Column(name = "RT_VALUE")
	public String getRtValue() {
		return rtValue;
	}

	public void setRtValue(String rtValue) {
		this.rtValue = rtValue;
	}

	@Column(name = "PORT")
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Column(name = "VLAN")
	public String getVlan() {
		return vlan;
	}

	public void setVlan(String vlan) {
		this.vlan = vlan;
	}

	@Column(name = "IP_ADDRESS")
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ROUTER_TYPE")
	public CircuitMplsVpnRouterType getRouteType() {
		return routeType;
	}

	public void setRouteType(CircuitMplsVpnRouterType routeType) {
		this.routeType = routeType;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
