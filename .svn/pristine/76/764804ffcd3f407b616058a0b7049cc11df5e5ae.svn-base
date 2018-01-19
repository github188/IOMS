package cn.com.atnc.ioms.entity.basedata.atm.service;




import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.entity.basedata.atm.type.AtmType;
import cn.com.atnc.ioms.enums.basedata.ServiceChangeType;

/**
 * @author:xiongzhikang
 * @date:2014-4-1 下午3:53:25
 * @version:1.0
 */
@Entity
@Table(name = "TB_BD_ATM_SERVICE")
public class AtmService extends MyStringUUIDEntity {

	private static final long serialVersionUID = 428760460877268973L;
	//private String localConnId;//LOCAL端对应的ATM网内业务原始端口信息 暂时未使用
	//private String remoteConnId;//REMOTE端对应的ATM网内业务原始端口信息 暂时未使用
	private String serviceName;// 业务名称
	private Integer serviceSeq;//序号
	
	private AtmNode localNode;//本端节点对象 
	private String localNodeNameCn;//本端节点名称
	private String localPort;//本端节点端口号
	private String localPortCir;//本端节点端口速率
	private String localPortClockType;//本端节点端口时钟类型
	private String localPortDLCIVPIVCI;//本端节点端口DLCI或VPI.VCI
	private String localConnEquip;//本端节点接入设备
	private String localCardSlot;//本端节点板卡槽号
	private String localPortSlot;//本端节点端口槽号
	
	private AtmNode remoteNode;//远端节点对象 
	private String remoteNodeNameCn;//远端节点名称
	private String remotePort;//远端节点端口号
	private String remotePortCir;//远端节点端口速率
	private String remotePortClockType;//远端节点端口时钟类型
	private String remotePortDLCIVPIVCI;//远端节点端口DLCI或VPI.VCI
	private String remoteConnEquip;//远端节点接入设备
	private String remoteCardSlot;//对端节点板卡槽号
	private String remotePortSlot;//对端节点端口槽号
	
	private String  serviceCir;//业务电路速率
	private String  serviceClass;//业务电路服务级别
	private String  serviceStandbyInfo;//业务电路备用信息
	private String serviceMsInfo;//业务电路主备关系说明
	private String serviceRemark;//业务电路备注信息
	private Integer  serviceIsUse;//业务电路是否在用
	private Calendar RecordTime;//记录时间
	private String localTransferPort;//记录“LOCAL_PORT”列对应在ATM交换机内的时间端口号
	private String remoteTransferPort;//"记录“REMOTE_PORT”列对应在ATM交换机内的时间端口号"
	private Integer routAlarmType = 0;//记录业务对应的路由路径发生的变化类型，其中：0-正常；1-连接未建立；2-路由变化
	private ServiceChangeType serviceChangeType;
	private String localNsap;
	private String remoteNsap;
	
	private AtmType atmType;
	
	@Column(name = "LOCAL_CARD_SLOT")
	public String getLocalCardSlot() {
		return localCardSlot;
	}

	public void setLocalCardSlot(String localCardSlot) {
		this.localCardSlot = localCardSlot;
	}
	@Column(name = "LOCAL_PORT_SLOT")
	public String getLocalPortSlot() {
		return localPortSlot;
	}

	public void setLocalPortSlot(String localPortSlot) {
		this.localPortSlot = localPortSlot;
	}
	@Column(name = "REMOTE_CARD_SLOT")
	public String getRemoteCardSlot() {
		return remoteCardSlot;
	}

	public void setRemoteCardSlot(String remoteCardSlot) {
		this.remoteCardSlot = remoteCardSlot;
	}
	@Column(name = "REMOTE_PORT_SLOT")
	public String getRemotePortSlot() {
		return remotePortSlot;
	}

	public void setRemotePortSlot(String remotePortSlot) {
		this.remotePortSlot = remotePortSlot;
	}
	
	@Column(name = "SERVICE_NAME")
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Column(name = "SERVICE_SEQ")
	public Integer getServiceSeq() {
		return serviceSeq;
	}

	public void setServiceSeq(Integer serviceSeq) {
		this.serviceSeq = serviceSeq;
	}

	@ManyToOne
	@JoinColumn(name = "LOCAL_NODE")
	public AtmNode getLocalNode() {
		return localNode;
	}

	public void setLocalNode(AtmNode localNode) {
		this.localNode = localNode;
	}

	@Column(name = "LOCAL_NODE_NAME_CN")
	public String getLocalNodeNameCn() {
		return localNodeNameCn;
	}

	public void setLocalNodeNameCn(String localNodeNameCn) {
		this.localNodeNameCn = localNodeNameCn;
	}

	@Column(name = "LOCAL_PORT")
	public String getLocalPort() {
		return localPort;
	}

	public void setLocalPort(String localPort) {
		this.localPort = localPort;
	}

	@Column(name = "LOCAL_PORT_CIR")
	public String getLocalPortCir() {
		return localPortCir;
	}

	public void setLocalPortCir(String localPortCir) {
		this.localPortCir = localPortCir;
	}
	
	/*@Enumerated(EnumType.STRING)
	@Column(name = "LOCAL_PORT_CLOCKTYPE")*/
	
	
	//@Enumerated(EnumType.STRING)
	@Column(name = "LOCAL_PORT_CLOCKTYPE")
	public String getLocalPortClockType() {
		return localPortClockType;
	}

	public void setLocalPortClockType(String localPortClockType) {
		this.localPortClockType = localPortClockType;
	}

	@Column(name = "LOCAL_PORT_DLCIVPIVCI")
	public String getLocalPortDLCIVPIVCI() {
		return localPortDLCIVPIVCI;
	}

	public void setLocalPortDLCIVPIVCI(String localPortDLCIVPIVCI) {
		this.localPortDLCIVPIVCI = localPortDLCIVPIVCI;
	}

	@Column(name = "LOCAL_CONNECT_EQUIP")
	public String getLocalConnEquip() {
		return localConnEquip;
	}

	public void setLocalConnEquip(String localConnEquip) {
		this.localConnEquip = localConnEquip;
	}

	@ManyToOne
	@JoinColumn(name = "REMOTE_NODE")
	public AtmNode getRemoteNode() {
		return remoteNode;
	}

	public void setRemoteNode(AtmNode remoteNode) {
		this.remoteNode = remoteNode;
	}

	@Column(name = "REMOTE_NODE_NAME_CN")
	public String getRemoteNodeNameCn() {
		return remoteNodeNameCn;
	}

	public void setRemoteNodeNameCn(String remoteNodeNameCn) {
		this.remoteNodeNameCn = remoteNodeNameCn;
	}

	@Column(name = "REMOTE_PORT")
	public String getRemotePort() {
		return remotePort;
	}

	public void setRemotePort(String remotePort) {
		this.remotePort = remotePort;
	}

	@Column(name = "REMOTE_PORT_CIR")
	public String getRemotePortCir() {
		return remotePortCir;
	}

	public void setRemotePortCir(String remotePortCir) {
		this.remotePortCir = remotePortCir;
	}
	
	//@Enumerated(EnumType.STRING)
	@Column(name = "REMOTE_PORT_CLOCKTYPE")
	public String getRemotePortClockType() {
		return remotePortClockType;
	}

	public void setRemotePortClockType(String remotePortClockType) {
		this.remotePortClockType = remotePortClockType;
	}

	@Column(name = "REMOTE_PORT_DLCIVPIVCI")
	public String getRemotePortDLCIVPIVCI() {
		return remotePortDLCIVPIVCI;
	}

	public void setRemotePortDLCIVPIVCI(String remotePortDLCIVPIVCI) {
		this.remotePortDLCIVPIVCI = remotePortDLCIVPIVCI;
	}

	@Column(name = "REMOTE_CONNECT_EQUIP")
	public String getRemoteConnEquip() {
		return remoteConnEquip;
	}

	public void setRemoteConnEquip(String remoteConnEquip) {
		this.remoteConnEquip = remoteConnEquip;
	}

	@Column(name = "SERVICE_CIR")
	public String getServiceCir() {
		return serviceCir;
	}

	public void setServiceCir(String serviceCir) {
		this.serviceCir = serviceCir;
	}

	@Column(name = "SERVICE_CLASS")
	public String getServiceClass() {
		return serviceClass;
	}

	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}

	@Column(name = "SERVICE_STANDBY_INFO")
	public String getServiceStandbyInfo() {
		return serviceStandbyInfo;
	}

	public void setServiceStandbyInfo(String serviceStandbyInfo) {
		this.serviceStandbyInfo = serviceStandbyInfo;
	}

	@Column(name = "SERVICE_MS_INFO")
	public String getServiceMsInfo() {
		return serviceMsInfo;
	}

	public void setServiceMsInfo(String serviceMsInfo) {
		this.serviceMsInfo = serviceMsInfo;
	}

	@Column(name = "SERVICE_REMARK")
	public String getServiceRemark() {
		return serviceRemark;
	}

	public void setServiceRemark(String serviceRemark) {
		this.serviceRemark = serviceRemark;
	}

	@Column(name = "SERVICE_IS_USE")
	public Integer getServiceIsUse() {
		return serviceIsUse;
	}

	public void setServiceIsUse(Integer serviceIsUse) {
		this.serviceIsUse = serviceIsUse;
	}
	
	@Column(name = "RECORDTIME")
	public Calendar getRecordTime() {
		return RecordTime;
	}

	public void setRecordTime(Calendar recordTime) {
		RecordTime = recordTime;
	}

	@Column(name = "LOCAL_TRANSFOR_PORT")
	public String getLocalTransferPort() {
		return localTransferPort;
	}

	public void setLocalTransferPort(String localTransferPort) {
		this.localTransferPort = localTransferPort;
	}

	@Column(name = "REMOTE_TRANSFOR_PORT")
	public String getRemoteTransferPort() {
		return remoteTransferPort;
	}

	public void setRemoteTransferPort(String remoteTransferPort) {
		this.remoteTransferPort = remoteTransferPort;
	}

	@Column(name = "ROUTE_ALARM_TYPE")
	public Integer getRoutAlarmType() {
		return routAlarmType;
	}

	public void setRoutAlarmType(Integer routAlarmType) {
		this.routAlarmType = routAlarmType;
	}
	
	@Column(name = "LOCAL_NSAP")
	public String getLocalNsap() {
		return localNsap;
	}

	public void setLocalNsap(String localNsap) {
		this.localNsap = localNsap;
	}

	@Column(name = "REMOTE_NSAP")
	public String getRemoteNsap() {
		return remoteNsap;
	}

	public void setRemoteNsap(String remoteNsap) {
		this.remoteNsap = remoteNsap;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "SERVICE_CHANGE_TYPE")
	public ServiceChangeType getServiceChangeType() {
		return serviceChangeType;
	}

	public void setServiceChangeType(ServiceChangeType serviceChangeType) {
		this.serviceChangeType = serviceChangeType;
	}
	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name = "TB_SERVICE_TYPE")
	public AtmType getAtmType() {
		return atmType;
	}

	public void setAtmType(AtmType atmType) {
		this.atmType = atmType;
	}
}
