/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-1 下午3:53:25
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.basedata.ku;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.KuServiceRateType;
import cn.com.atnc.ioms.enums.basedata.ServiceChangeType;
import cn.com.atnc.ioms.enums.basedata.SubnetType;

/**
 * @author:HuangYijie
 * @date:2014-4-1 下午3:53:25
 * @version:1.0
 */
@Entity
@Table(name = "TB_BD_KU_SERVICE")
public class KuService extends MyStringUUIDEntity {

	private static final long serialVersionUID = 428760460877268773L;
	private String code;// 电路名称
	private KuNode txNode;// 发端节点号
	private String txGib;// 发端槽号
	private String txChan;// 发端端口号
	private KuNode rxNode;// 收端节点号
	private String rxGib;// 收端槽号
	private String rxChan;// 收端端口号
	private String memo;// 其他接收端
	private Integer cxr;// 载波
	private KuServiceRateType rateType;// 速率类型
	private Integer rateTypeSize;// 速率类型长度
	private String fec;// 前向纠错
	private Integer start;// 起点
	private String circuitType;// 电路类型 pama，dama
	private String circuitTypeDetail;// 具体类型 Duplex Multi Simplex
	private Bureau bureau;// 管局
	private String info;// 备注
	private String serviceName;//业务名称
	private String serviceType;// 业务类型
	private Calendar recordTime;// 记录时间
	private Boolean complete = true;// 是否完整，用于采集上传
	private User optUser;// 更新人
	private Calendar optTime;// 更新时间
	private String usage;// 电路使用情况
	private String crm;// crm
	private String clientInfo;// 客户备注
	private String configTime;// 配置时间
	private String circuitInfo;// 电路情况
	private ServiceChangeType serviceChangeType;// 业务采集变化

	// 非持久化对象
	private transient String rxNodeId;
	private transient String txNodeId;
	private transient String rxNodeNo;
	private transient String txNodeNo;
	private transient SubnetType subnetTypeTx;
	private transient SubnetType subnetTypeRx;

	@Transient
	public SubnetType getSubnetTypeTx() {
		return subnetTypeTx;
	}

	public void setSubnetTypeTx(SubnetType subnetTypeTx) {
		this.subnetTypeTx = subnetTypeTx;
	}

	@Transient
	public SubnetType getSubnetTypeRx() {
		return subnetTypeRx;
	}

	public void setSubnetTypeRx(SubnetType subnetTypeRx) {
		this.subnetTypeRx = subnetTypeRx;
	}

	@Column(name = "MEMO")
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Transient
	public String getRxNodeNo() {
		return rxNodeNo;
	}

	public void setRxNodeNo(String rxNodeNo) {
		this.rxNodeNo = rxNodeNo;
	}

	@Transient
	public String getTxNodeNo() {
		return txNodeNo;
	}

	public void setTxNodeNo(String txNodeNo) {
		this.txNodeNo = txNodeNo;
	}

	@Transient
	public String getRxNodeId() {
		return rxNodeId;
	}

	public void setRxNodeId(String rxNodeId) {
		this.rxNodeId = rxNodeId;
	}

	@Transient
	public String getTxNodeId() {
		return txNodeId;
	}

	public void setTxNodeId(String txNodeId) {
		this.txNodeId = txNodeId;
	}

	@Column(name = "RATE_TYPE_SIZE")
	public Integer getRateTypeSize() {
		return rateTypeSize;
	}

	public void setRateTypeSize(Integer rateTypeSize) {
		this.rateTypeSize = rateTypeSize;
	}

	@Column(name = "CIRCUIT_INFO")
	public String getCircuitInfo() {
		return circuitInfo;
	}

	public void setCircuitInfo(String circuitInfo) {
		this.circuitInfo = circuitInfo;
	}

	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@ManyToOne
	@JoinColumn(name = "TX_NODE")
	public KuNode getTxNode() {
		return txNode;
	}

	public void setTxNode(KuNode txNode) {
		this.txNode = txNode;
	}

	@Column(name = "TX_GIB")
	public String getTxGib() {
		return txGib;
	}

	public void setTxGib(String txGib) {
		this.txGib = txGib;
	}

	@Column(name = "TX_CHAN")
	public String getTxChan() {
		return txChan;
	}

	public void setTxChan(String txChan) {
		this.txChan = txChan;
	}

	@ManyToOne
	@JoinColumn(name = "RX_NODE")
	public KuNode getRxNode() {
		return rxNode;
	}

	public void setRxNode(KuNode rxNode) {
		this.rxNode = rxNode;
	}

	@Column(name = "RX_GIB")
	public String getRxGib() {
		return rxGib;
	}

	public void setRxGib(String rxGib) {
		this.rxGib = rxGib;
	}

	@Column(name = "RX_CHAN")
	public String getRxChan() {
		return rxChan;
	}

	public void setRxChan(String rxChan) {
		this.rxChan = rxChan;
	}

	@Column(name = "CXR")
	public Integer getCxr() {
		return cxr;
	}

	public void setCxr(Integer cxr) {
		this.cxr = cxr;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "RATE_TYPE")
	public KuServiceRateType getRateType() {
		return rateType;
	}

	public void setRateType(KuServiceRateType rateType) {
		this.rateType = rateType;
	}

	@Column(name = "FEC")
	public String getFec() {
		return fec;
	}

	public void setFec(String fec) {
		this.fec = fec;
	}

	@Column(name = "FREQ_START")
	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	@Column(name = "CIRCUIT_TYPE")
	public String getCircuitType() {
		return circuitType;
	}

	public void setCircuitType(String circuitType) {
		this.circuitType = circuitType;
	}

	@Column(name = "CIRCUIT_TYPE_DETAIL")
	public String getCircuitTypeDetail() {
		return circuitTypeDetail;
	}

	public void setCircuitTypeDetail(String circuitTypeDetail) {
		this.circuitTypeDetail = circuitTypeDetail;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "BUREAU")
	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	@Column(name = "INFO")
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "SERVICETYPE")
	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	@Column(name = "RECORD_TIME")
	public Calendar getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Calendar recordTime) {
		this.recordTime = recordTime;
	}

	@Column(name = "COMPLETE")
	public Boolean getComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	@ManyToOne
	@JoinColumn(name = "OPT_USER")
	public User getOptUser() {
		return optUser;
	}

	public void setOptUser(User optUser) {
		this.optUser = optUser;
	}

	@Column(name = "OPT_TIME")
	public Calendar getOptTime() {
		return optTime;
	}

	public void setOptTime(Calendar optTime) {
		this.optTime = optTime;
	}

	@Column(name = "CIRCUIT_USAGE")
	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	@Column(name = "CRM")
	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	@Column(name = "CLIENT_INFO")
	public String getClientInfo() {
		return clientInfo;
	}

	public void setClientInfo(String clientInfo) {
		this.clientInfo = clientInfo;
	}

	@Column(name = "CONFIG_TIME")
	public String getConfigTime() {
		return configTime;
	}

	public void setConfigTime(String configTime) {
		this.configTime = configTime;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SERVICE_CHANGE_TYPE")
	public ServiceChangeType getServiceChangeType() {
		return serviceChangeType;
	}

	public void setServiceChangeType(ServiceChangeType serviceChangeType) {
		this.serviceChangeType = serviceChangeType;
	}

	@Column(name = "SERVICENAME")
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}
