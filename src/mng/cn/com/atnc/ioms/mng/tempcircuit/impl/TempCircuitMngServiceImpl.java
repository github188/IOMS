/* Copyright © 2008 BEIJING ATNC CO,.LTD yanfashengchan department
 * All rights reserved
 *
 * create on 2008-11-12 上午11:51:59
 * author:huangyijie E-mail:aroon2008@gmail.com
 */
package cn.com.atnc.ioms.mng.tempcircuit.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.mail.MessagingException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.tempcircuit.ITempCircuitDao;
import cn.com.atnc.ioms.entity.BaseUserInfo;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuit;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuitOptLog;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitCancelType;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitExpireType;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitOptType;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitStatus;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitType;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.clientmng.IClientManager;
import cn.com.atnc.ioms.mng.clientnotice.IClientNoticeManager;
import cn.com.atnc.ioms.mng.systemmng.param.ISystemConfigManager;
import cn.com.atnc.ioms.mng.tempcircuit.ITempCircuitMngService;
import cn.com.atnc.ioms.mng.tempcircuit.ITempCircuitOptLogMngService;
import cn.com.atnc.ioms.mng.tempcircuit.ITempCircuitWorkflowService;
import cn.com.atnc.ioms.model.SysFinals;
import cn.com.atnc.ioms.model.tempcircuit.TempCircuitQueryModel;
import cn.com.atnc.ioms.util.CalendarTools;

/**
 * 
 * 类说明：临时电路服务接口实现
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月27日上午9:38:48
 * @version:1.0
 */
@Service("tempCircuitService")
public class TempCircuitMngServiceImpl extends AbstractService implements
		ITempCircuitMngService {
	@Autowired
	private ITempCircuitDao tempCircuitDao;
	@Autowired
	private ITempCircuitWorkflowService tempCircuitWorkflowService;
	@Autowired
	private ITempCircuitOptLogMngService tempCircuitOptLogMngService;
	@Autowired
	private ITempCircuitWorkflowService workflowService;
	@Autowired
	private IClientNoticeManager clientNoticeManager;
	@Autowired
	private IClientManager clientManager;
	@Autowired
	private IUserManager userManager;
	@Autowired
	@Qualifier(value = "SystemConfigDBManagerImpl")
	private ISystemConfigManager sysConfigManager;

	@Override
	public String add(TempCircuit obj) {
		// TODO Auto-generated method stub
		return tempCircuitDao.save(obj).toString();
	}

	@Override
	public TempCircuit getTempCircuitByID(String id) {
		// TODO Auto-generated method stub
		return tempCircuitDao.findById(id);
	}

	@Override
	public void update(TempCircuit obj) {
		// TODO Auto-generated method stub
		tempCircuitDao.update(obj);
	}

	@Override
	public List<TempCircuit> getTempCircuitByApplyUserID(String id) {
		// TODO Auto-generated method stub
		return tempCircuitDao.getTempCircuitByApplyUserID(id);
	}

	@Override
	public void forceCancleTempCircuitByID(String id) {
		// TODO Auto-generated method stub
		TempCircuit tempCircuit = tempCircuitDao.findById(id);
		tempCircuit.setCircuitStatus(CircuitStatus.ACKDELETED);
		tempCircuit.setCircuitCancelType(CircuitCancelType.FORCEDELETE);
		tempCircuit.setCircuitExpireType(CircuitExpireType.NORMAL);
		tempCircuit.setUpdateTime(Calendar.getInstance());
		tempCircuitDao.saveOrUpdate(tempCircuit);
	}

	@Override
	public void applyTempCircuitDelayByID(String id) {
		// TODO Auto-generated method stub
		TempCircuit tempCircuit = tempCircuitDao.findById(id);
		Calendar calendar = tempCircuit.getPlanEndTime();
		calendar.add(Calendar.DATE, 15);
		tempCircuit.setPlanEndTime(calendar);
		tempCircuit.setCircuitExpireType(CircuitExpireType.NORMAL);
		tempCircuit.setApplyDelay(true);
		tempCircuit.setUpdateTime(Calendar.getInstance());
		tempCircuitDao.saveOrUpdate(tempCircuit);
	}

	@Override
	public Pagination queryPage(TempCircuitQueryModel qm) {
		// TODO Auto-generated method stub
		return tempCircuitDao.queryPage(qm);
	}

	@Override
	public List<TempCircuit> queryList(TempCircuitQueryModel qm) {
		// TODO Auto-generated method stub
		return tempCircuitDao.queryList(qm);
	}

	@Override
	public void ackDeleteTempCircuitByID(String id) {
		// TODO Auto-generated method stub
		TempCircuit tempCircuit = tempCircuitDao.findById(id);
		tempCircuit.setCircuitStatus(CircuitStatus.ACKDELETED);
		tempCircuit.setCircuitExpireType(CircuitExpireType.NORMAL);
		tempCircuit.setAckDelete(true);
		tempCircuit.setUpdateTime(Calendar.getInstance());
		tempCircuitDao.saveOrUpdate(tempCircuit);
	}

	@Scheduled(cron = "0 0 9 * * ?")
	public void checkTempCircuitExpire() throws NumberFormatException,
			ServiceException, MessagingException {
		// TODO Auto-generated method stub
		logger.info("tempCircuitDao.getAllValidTempCircuit():"
				+ tempCircuitDao.getAllValidTempCircuit().size());
		logger.info("定时检测临时电路是否到期！");
		Calendar today = Calendar.getInstance();
		// Client client = new Client();
		// User applyUser = new User();
		String msg = "";
		int diff = 0;
		for (TempCircuit tempCircuit : tempCircuitDao.getAllValidTempCircuit()) {
			diff = CalendarTools.daysBetween(today,
					tempCircuit.getPlanEndTime());
			logger.info(tempCircuit.getNumber() + " " + diff);
			if (diff == Integer.valueOf(sysConfigManager
					.getParam(SysFinals.tempCircuitNotice))) {
				tempCircuit.setCircuitExpireType(CircuitExpireType.UPCOMING);
				// client =
				// clientManager.findByID(tempCircuit.getApplyUserId());
				/*
				 * if (client == null) { applyUser =
				 * userManager.findById(tempCircuit .getApplyUserId()); msg =
				 * "尊敬的用户:" + applyUser.getName() + ",您好！您申请的电路:" +
				 * tempCircuit.getNumber() + ",即将到期！请登录客服平台查询";
				 * clientNoticeManager.sendMessage(applyUser, msg); } else { msg
				 * = "尊敬的用户:" + client.getName() + ",您好！您申请的电路:" +
				 * tempCircuit.getNumber() + ",即将到期！请登录客服平台查询";
				 * clientNoticeManager.sendMessage(client, msg); }
				 */
				msg = "尊敬的用户:" + tempCircuit.getLinkMan() + ",您好！您申请的电路:"
						+ tempCircuit.getNumber() + ",即将到期！请登录客服平台查询";
				if (!StringUtils.isEmpty(tempCircuit.getLinkPhone())) {
					BaseUserInfo baseUserInfo = new BaseUserInfo();
					baseUserInfo.setLoginName(tempCircuit.getLinkMan());
					baseUserInfo.setEmail(tempCircuit.getLinkEmail());
					baseUserInfo.setMobilephone(tempCircuit.getLinkPhone());
					clientNoticeManager.sendMessage(baseUserInfo, msg);
				}
			}
			if (diff == SysFinals.tempcircuitExpire) {
				tempCircuit.setCircuitExpireType(CircuitExpireType.EXPIRE);
				// client =
				// clientManager.findByID(tempCircuit.getApplyUserId());
				TempCircuitOptLog tempCircuitOptLog = new TempCircuitOptLog();
				// if (client == null) {
				// applyUser = userManager.findById(tempCircuit
				// .getApplyUserId());
				// tempCircuitOptLog.setOptUser(applyUser.getName());
				// msg = "尊敬的用户:" + applyUser.getName() + ",您好！您申请的电路:"
				// + tempCircuit.getNumber() + ",已经到期！请登录客服平台查询";
				// clientNoticeManager.sendMessage(applyUser, msg);
				// } else {
				// tempCircuitOptLog.setOptUser(client.getName());
				// msg = "尊敬的用户:" + client.getName() + ",您好！您申请的电路:"
				// + tempCircuit.getNumber() + ",已经到期！请登录客服平台查询";
				// clientNoticeManager.sendMessage(client, msg);
				// }
				msg = "尊敬的用户:" + tempCircuit.getLinkMan() + ",您好！您申请的电路:"
						+ tempCircuit.getNumber() + ",已经到期！请登录客服平台查询";
				if (!StringUtils.isEmpty(tempCircuit.getLinkPhone())) {
					BaseUserInfo baseUserInfo = new BaseUserInfo();
					baseUserInfo.setLoginName(tempCircuit.getLinkMan());
					baseUserInfo.setEmail(tempCircuit.getLinkEmail());
					baseUserInfo.setMobilephone(tempCircuit.getLinkPhone());
					clientNoticeManager.sendMessage(baseUserInfo, msg);
				}
				tempCircuitOptLog.setTempCircuit(tempCircuit);
				tempCircuitOptLog
						.setcircuitOptType(CircuitOptType.APPLYDELETED);
				tempCircuitOptLog.setFromStatus(tempCircuitOptLogMngService
						.findLatestByTempcircuitID(tempCircuit.getId())
						.getToStatus());
				tempCircuitOptLog.setToStatus(CircuitStatus.EXPIRE);
				tempCircuitOptLog.setOptTime(Calendar.getInstance());
				tempCircuitOptLogMngService.add(tempCircuitOptLog);

			}
			tempCircuitDao.update(tempCircuit);
		}
	}

	@Override
	public Pagination queryPageAudit(TempCircuitQueryModel qm) {
		// TODO Auto-generated method stub
		return tempCircuitDao.queryPageAudit(qm);
	}

	@Override
	public String getCircuitNumByType(CircuitType circuitType) {
		// TODO Auto-generated method stub
		TempCircuit tempCircuit = null;
		String num = "";
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");

		tempCircuit = tempCircuitDao.findTempCircuitByRecordTime(circuitType);
		if (tempCircuit != null) {
			if (!StringUtils.isEmpty(tempCircuit.getNumber())) {
				logger.debug("tempCircuit.getNumber():"
						+ tempCircuit.getNumber());
				String[] str = tempCircuit.getNumber().split("-");
				num = str[0] + "-"
						+ sdFormat.format(Calendar.getInstance().getTime())
						+ "-" + (Integer.valueOf(str[2]) + 1);
			} else {
				num = circuitType.name() + "-"
						+ sdFormat.format(Calendar.getInstance().getTime())
						+ "-" + 1;
			}
		} else {
			num = circuitType.name() + "-"
					+ sdFormat.format(Calendar.getInstance().getTime()) + "-"
					+ 1;
		}
		return num;
	}

	@Override
	public void cancleTempCircuitByID(String id) {
		// TODO Auto-generated method stub
		TempCircuit tempCircuit = tempCircuitDao.findById(id);
		tempCircuit.setCircuitStatus(CircuitStatus.DELETED);
		tempCircuit.setCircuitCancelType(CircuitCancelType.APPLYDELETE);
		tempCircuit.setCircuitExpireType(CircuitExpireType.NORMAL);
		tempCircuit.setUpdateTime(Calendar.getInstance());
		tempCircuit.setCurrentTaskName(CircuitStatus.DELETED.getName());
		tempCircuitDao.saveOrUpdate(tempCircuit);
	}

	@Override
	public int getCurrentUserUndoTaskNum(String userID) {
		// TODO Auto-generated method stub
		return workflowService.findTodoTasks(userID).size();
	}

	@Override
	public Pagination queryPageExpire(TempCircuitQueryModel qm) {
		// TODO Auto-generated method stub
		return tempCircuitDao.queryPageExpire(qm);
	}

	@Override
	public Pagination queryPageOver(TempCircuitQueryModel qm) {
		// TODO Auto-generated method stub
		return tempCircuitDao.queryPageOver(qm);
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.mng.tempcircuit.ITempCircuitMngService#getTempCircuitSend()
	 */
	@Override
	public List<TempCircuit> getTempCircuitSend() {
		TempCircuitQueryModel qm = new TempCircuitQueryModel();
		qm.setTaskName("网控领导审批");
		qm.setSend(false);
		return tempCircuitDao.queryList(qm);
	}
}
