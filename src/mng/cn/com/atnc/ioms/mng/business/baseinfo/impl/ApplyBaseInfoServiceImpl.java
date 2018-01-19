/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName ApplyBaseInfoServiceImpl.java
 * @PackageName:cn.com.atnc.pcsp.mng.business.baseinfo.impl
 * @author ku
 * @date 2015年5月14日下午5:25:35
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.business.baseinfo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.baseinfo.IApplyBaseInfoDao;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetwork;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.satellite.KuSatellite;
import cn.com.atnc.ioms.entity.business.signoutnet.SignoutNet;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraph;
import cn.com.atnc.ioms.entity.business.transfernet.TransferNet;
import cn.com.atnc.ioms.enums.business.satellite.ApproveStatEnum;
import cn.com.atnc.ioms.enums.business.telegraph.TeleGraphApproveStatEnum;
import cn.com.atnc.ioms.mng.business.approveinfo.IApproveInfoService;
import cn.com.atnc.ioms.mng.business.baseinfo.IApplyBaseInfoService;
import cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkManager;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitManager;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteService;
import cn.com.atnc.ioms.mng.business.signoutnet.ISignoutNetManager;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphService;
import cn.com.atnc.ioms.mng.business.transfernet.ITransferNetManager;
import cn.com.atnc.ioms.model.business.taskrecord.TaskRecordQueryModel;

/**
 * 申请基础信息service接口实现类
 *
 * @author ku
 * @date 2015年5月14日 下午5:25:35
 * @since 1.0.0
 */
@Service
@Transactional
public class ApplyBaseInfoServiceImpl extends BaseService implements
		IApplyBaseInfoService {

	@Autowired
	private IApplyBaseInfoDao applyBaseInfoDao;
	@Autowired
	private IKuSatelliteService kuSatelliteService;
	@Autowired
	private TeleGraphService teleGraphService;
	@Autowired
	private IFormalCircuitManager formalCircuitManager;
	@Autowired
	private IDataComNetworkManager dataComNetworkManager;
	@Autowired
	private ITransferNetManager transferNetManager;
	@Autowired
	private IApproveInfoService approveInfoService;
	@Autowired
	private ISignoutNetManager signoutNetManager;

	@Override
	@Transactional(readOnly = true, timeout = 5)
	public Pagination queryPageByModel(TaskRecordQueryModel queryModel) {
		return applyBaseInfoDao.queryPageByModel(queryModel);
	}

	@Override
	public ApplyBaseInfo findById(String id) {
		return applyBaseInfoDao.findById(id);
	}

	@Override
	public void update(ApplyBaseInfo applyBaseInfo) {
		applyBaseInfoDao.update(applyBaseInfo);
	}

	@Override
	public Pagination getPageByModel(TaskRecordQueryModel queryModel) {
		Pagination pagn = this.queryPageByModel(queryModel);
		List<TaskRecordQueryModel> trqmli = new ArrayList<TaskRecordQueryModel>();
		@SuppressWarnings("unchecked")
		List<ApplyBaseInfo> abili = (List<ApplyBaseInfo>) pagn.getResult();
		for (int i = 0; i < abili.size(); i++) {
			ApplyBaseInfo applyBaseInfo = abili.get(i);
			TaskRecordQueryModel queryModel2 = new TaskRecordQueryModel();
			queryModel2.setApplyBaseInfo(applyBaseInfo);
			if (applyBaseInfo.getApplyType().getValue().equals("卫星通信网地球站")) {
				KuSatellite ku = (KuSatellite) kuSatelliteService
						.findByApplyBaseInfoId(applyBaseInfo.getId());
				if (ku != null) {
					queryModel2.setApproveStatus(ku.getApproveStat());
					queryModel2.setId(ku.getId());
					queryModel2.setTaskName(ku.getTaskName());
					queryModel2.setProcessInstanceId(ku.getProcessInstanceId());
				} else {
					queryModel2.setApproveStatus(ApproveStatEnum.unsubmitted);
				}
			} else if (applyBaseInfo.getApplyType().getValue().equals("转报地址")
					|| applyBaseInfo.getApplyType().getValue().equals("转报电路")) {
				TeleGraph teleGraph = teleGraphService
						.getTeleGraphByBaseInfo(applyBaseInfo.getId());
				if (teleGraph != null) {
					queryModel2.setId(teleGraph.getId());
					queryModel2.setTgasStat(teleGraph.getApproveStat());
					queryModel2.setTaskName(teleGraph.getTaskName());
					queryModel2.setProcessInstanceId(teleGraph.getProcessInstanceId());
				} else {
					queryModel2.setTgasStat(TeleGraphApproveStatEnum.unsubmitted);
				}
			} else if (applyBaseInfo.getApplyType().getValue().equals("ATM正式电路")
					|| applyBaseInfo.getApplyType().getValue().equals("KU正式电路")
					|| applyBaseInfo.getApplyType().getValue().equals("TES正式电路")
					|| applyBaseInfo.getApplyType().getValue().equals("PES正式电路")) {
				FormalCircuit formalCircuit = formalCircuitManager.findByApplyBaseInfo(applyBaseInfo.getId());
				if (formalCircuit != null) {
					queryModel2.setId(formalCircuit.getId());
					queryModel2.setTaskName(formalCircuit.getTaskName());
					queryModel2.setProcessInstanceId(formalCircuit.getProcessInstanceId());
				}
				queryModel2.setFormalStatEnum(formalCircuit.getApproveStat());
			} else if (applyBaseInfo.getApplyType().getValue().equals("数据通信网")) {
				DataComNetwork dataComNetwork = dataComNetworkManager
						.findByApplyBaseInfo(applyBaseInfo.getId());
				if (dataComNetwork != null) {
					queryModel2.setId(dataComNetwork.getId());
					queryModel2.setTaskName(dataComNetwork.getTaskName());
					queryModel2.setProcessInstanceId(dataComNetwork.getProcessInstanceId());
				}
				queryModel2.setApproveStatNWS(dataComNetwork.getApproveStat());
			} else if (applyBaseInfo.getApplyType().getValue().equals("自动转报网")) {
				TransferNet transferNet = transferNetManager
						.findByApplyBaseInfo(applyBaseInfo.getId());
				if (transferNet != null) {
					queryModel2.setId(transferNet.getId());
					queryModel2.setTaskName(transferNet.getTaskName());
					queryModel2.setProcessInstanceId(transferNet.getProcessInstanceId());
				}
				queryModel2.setApproveStatTNS(transferNet.getApproveStat());
			} else if (applyBaseInfo.getApplyType().getValue().equals("ATM退网")
					|| applyBaseInfo.getApplyType().getValue().equals("PES系统退网")
					|| applyBaseInfo.getApplyType().getValue().equals("TES系统退网")
					|| applyBaseInfo.getApplyType().getValue().equals("ku系统退网")) {
				SignoutNet signOutNet = signoutNetManager
						.findByApplyBaseInfoId(applyBaseInfo.getId());
				if (signOutNet != null) {
					queryModel2.setId(signOutNet.getId());
					queryModel2.setTaskName(signOutNet.getTaskName());
					queryModel2.setProcessInstanceId(signOutNet.getProcessInstanceId());
				}
				queryModel2.setApproveStatus(signOutNet.getApproveStat());
			}
			trqmli.add(queryModel2);
		}
		pagn.setResult(trqmli);
		return pagn;
	}

	@Override
	public List<ApplyBaseInfo> getAll() {
		return applyBaseInfoDao.getAll();
	}
	
	@Override
	public List<ApplyBaseInfo> getListSendMessage() {
		return applyBaseInfoDao.getListSendMessage();
	}

}
