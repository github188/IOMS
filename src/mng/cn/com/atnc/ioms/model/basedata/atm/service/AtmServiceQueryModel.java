package cn.com.atnc.ioms.model.basedata.atm.service;

import cn.com.atnc.ioms.entity.basedata.atm.type.AtmType;
import cn.com.atnc.ioms.enums.basedata.ServiceChangeType;
import cn.com.atnc.ioms.model.MyPaginModel;
import cn.com.atnc.ioms.util.HqlStringTools;

/**
 * @author:HuangYijie
 * @date:2014-3-19 下午8:03:06
 * @version:1.0
 */

public class AtmServiceQueryModel extends MyPaginModel {
	private String id;
	private String serviceName;
	private String serviceNameLike;

	private String localNode;
	private String localNodeLike;

	private String remoteNode;
	private String remoteNodeLike;
	

	private String excludeId;
	private String localNodeId;
	private String remoteNodeId;
	
	private String expList;
	private Boolean isAlarm;
	private ServiceChangeType serviceChangeType;
	private AtmType atmType;
	private String typeId;
	
	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExcludeId() {
		return excludeId;
	}

	public void setExcludeId(String excludeId) {
		this.excludeId = excludeId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceNameLike() {
		return HqlStringTools.replaceSpecialChar(serviceNameLike);
	}

	public void setServiceNameLike(String serviceNameLike) {
		this.serviceNameLike = serviceNameLike;
	}

	public String getLocalNode() {
		return localNode;
	}

	public void setLocalNode(String localNode) {
		this.localNode = localNode;
	}

	public String getLocalNodeLike() {
		return HqlStringTools.replaceSpecialChar(localNodeLike);
	}

	public void setLocalNodeLike(String localNodeLike) {
		this.localNodeLike = localNodeLike;
	}

	public String getRemoteNode() {
		return remoteNode;
	}

	public void setRemoteNode(String remoteNode) {
		this.remoteNode = remoteNode;
	}

	public String getRemoteNodeLike() {
		return HqlStringTools.replaceSpecialChar(remoteNodeLike);
	}

	public void setRemoteNodeLike(String remoteNodeLike) {
		this.remoteNodeLike = remoteNodeLike;
	}

	public String getLocalNodeId() {
		return localNodeId;
	}

	public void setLocalNodeId(String localNodeId) {
		this.localNodeId = localNodeId;
	}

	public String getRemoteNodeId() {
		return remoteNodeId;
	}

	public void setRemoteNodeId(String remoteNodeId) {
		this.remoteNodeId = remoteNodeId;
	}

	public String getExpList() {
		return expList;
	}
	public void setExpList(String expList) {
		this.expList = expList;
	}

	public Boolean getIsAlarm() {
		return isAlarm;
	}

	public void setIsAlarm(Boolean isAlarm) {
		this.isAlarm = isAlarm;
	}

	public ServiceChangeType getServiceChangeType() {
		return serviceChangeType;
	}

	public void setServiceChangeType(ServiceChangeType serviceChangeType) {
		this.serviceChangeType = serviceChangeType;
	}

	public AtmType getAtmType() {
		return atmType;
	}

	public void setAtmType(AtmType atmType) {
		this.atmType = atmType;
	}
}
