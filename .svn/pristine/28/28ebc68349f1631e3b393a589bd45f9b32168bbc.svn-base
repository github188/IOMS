package cn.com.atnc.ioms.mng.business.approveinfo;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.ioms.entity.BaseUserInfo;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetwork;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.satellite.KuSatellite;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraph;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphCircuit;
import cn.com.atnc.ioms.entity.business.transfernet.TransferNet;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuit;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.business.baseinfo.IApplyBaseInfoService;
import cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkManager;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitManager;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphCircuitService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphService;
import cn.com.atnc.ioms.mng.business.transfernet.ITransferNetManager;
import cn.com.atnc.ioms.mng.clientnotice.IClientNoticeManager;
import cn.com.atnc.ioms.mng.tempcircuit.ITempCircuitMngService;

@Service
@Transactional
public class AutoSendMessages {

	@Autowired
	private IApplyBaseInfoService applyBaseInfoService;
	@Autowired
	private IUserManager userManager;
	@Autowired
	private IDataComNetworkManager dataComNetworkManager;
	@Autowired
	private IFormalCircuitManager formalCircuitManager;
	@Autowired
	private ITransferNetManager transferNetManager;
	@Autowired
	private IKuSatelliteService kuSatelliteService;
	@Autowired
	private TeleGraphService teleGraphService;
	@Autowired
	private TeleGraphCircuitService teleGraphCircuitService;
	@Autowired
	private IClientNoticeManager clientNoticeManager;
	@Autowired
	private ITempCircuitMngService tempCircuitMngService;

	/**
	 * 每隔10分钟检查并发送短信
	 * 
	 * @author Wang Zhicheng
	 * @date 2015年11月16日上午11:26:15
	 * @since 1.0.0
	 */
	@Scheduled(cron = "0 0/1 * * * ?")
	public void sendMessages() {

		//临时电路
		List<TempCircuit> tcli = tempCircuitMngService.getTempCircuitSend();
		if(tcli.size() > 0){
			for(int i=0; i<tcli.size(); i++){
				TempCircuit tempCircuit = tcli.get(i);
				this.sendMessagesByTempCircuit(tempCircuit);
				tempCircuit.setSend(true);
				tempCircuitMngService.update(tempCircuit);
			}
		}
		
		// 数据通信网
		List<DataComNetwork> dcli = dataComNetworkManager.getListSendMessage();
		if (dcli.size() > 0) {
			for (int i = 0; i < dcli.size(); i++) {
				ApplyBaseInfo applyBaseInfo = dcli.get(i).getApplyBaseInfo();
				// 发送短信
				this.sendMessagesByBaseInfo(applyBaseInfo);
				// 更新实体
				applyBaseInfo.setSendmessageFlag(true);
				applyBaseInfoService.update(applyBaseInfo);
			}
		}
		// 正式电路
		List<FormalCircuit> fcli = formalCircuitManager.getListSendMessage();
		if (fcli.size() > 0) {
			for (int i = 0; i < fcli.size(); i++) {
				ApplyBaseInfo applyBaseInfo = fcli.get(i).getApplyBaseInfo();
				// 发送短信
				this.sendMessagesByBaseInfo(applyBaseInfo);
				// 更新实体
				applyBaseInfo.setSendmessageFlag(true);
				applyBaseInfoService.update(applyBaseInfo);
			}
		}
		// 自动转报网
		List<TransferNet> tnli = transferNetManager.getListSendMessage();
		if (tnli.size() > 0) {
			for (int i = 0; i < tnli.size(); i++) {
				ApplyBaseInfo applyBaseInfo = tnli.get(i).getApplyBaseInfo();
				// 发送短信
				this.sendMessagesByBaseInfo(applyBaseInfo);
				// 更新实体
				applyBaseInfo.setSendmessageFlag(true);
				applyBaseInfoService.update(applyBaseInfo);
			}
		}
		// 卫星通信网
		List<KuSatellite> kuli = kuSatelliteService.getListSendMessage();
		if (kuli.size() > 0) {
			for (int i = 0; i < kuli.size(); i++) {
				ApplyBaseInfo applyBaseInfo = kuli.get(i).getApplyBaseInfo();
				// 发送短信
				this.sendMessagesByBaseInfo(applyBaseInfo);
				// 更新实体
				applyBaseInfo.setSendmessageFlag(true);
				applyBaseInfoService.update(applyBaseInfo);
			}
		}

		// 转报路由地址
		List<TeleGraph> tgxli = teleGraphService.getListSendMessageFirstCommit();
		if (tgxli.size() > 0) {
			for (int i = 0; i < tgxli.size(); i++) {
				ApplyBaseInfo applyBaseInfo = tgxli.get(i).getApplyBaseInfo();
				// 发送短信
				this.sendMessagesByBaseInfo2(applyBaseInfo);
				// 更新实体
				applyBaseInfo.setSendmessageFlag(true);
				applyBaseInfoService.update(applyBaseInfo);
			}
		}
		// 转报电路
		List<TeleGraph> tghli = teleGraphService.getListSendMessage();
		if (tghli.size() > 0) {
			for (int i = 0; i < tghli.size(); i++) {
				ApplyBaseInfo applyBaseInfo = tghli.get(i).getApplyBaseInfo();
				// 发送短信
				this.sendMessagesByBaseInfo(applyBaseInfo);
				// 更新实体
				applyBaseInfo.setSendmessageFlag(true);
				applyBaseInfoService.update(applyBaseInfo);
			}
		}
		// 转报路由地址发送给工程师测试
		List<TeleGraph> tgli = teleGraphService.getListSendMessageEng();
		if (tgli.size() > 0) {
			for (int i = 0; i < tgli.size(); i++) {
				ApplyBaseInfo applyBaseInfo = tgli.get(i).getApplyBaseInfo();
				// 发送短信
				this.sendMessagesByBaseInfoRole(applyBaseInfo);
				// 更新实体
				applyBaseInfo.setSendmessageFlag(true);
				applyBaseInfoService.update(applyBaseInfo);
			}
		}
	}

	/**
	 * 发送短信给网控领导
	 *
	 * @param tempCircuit 
	 * @author Wang Zhicheng
	 * @date  2016年2月2日下午2:33:39
	 * @since 1.0.0
	 */
	private void sendMessagesByTempCircuit(TempCircuit tempCircuit) {
		String msg_1 = "尊敬的用户:";
		String msg_2 = ",您好！您有一条[";
		String msg_3 = "]类型的临时电路待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";

		// 发送短信给指定角色
		List<User> userli = userManager.getUserByRole(RoleEnum.atncLeader.name());
		if (userli.size() > 0) {
			for (int i = 0; i < userli.size(); i++) {
				if (!StringUtils.isEmpty(userli.get(i).getMobilephone())) {
					BaseUserInfo baseUserInfo = new BaseUserInfo();
					baseUserInfo.setLoginName(userli.get(i).getLoginName());
					baseUserInfo.setMobilephone(userli.get(i).getMobilephone());
					clientNoticeManager.sendMessage(baseUserInfo,
							msg_1 + userli.get(i).getName() + msg_2
									+ tempCircuit.getCircuitType() + msg_3);
				}
			}
		}
	}

	/**
	 * 发送给指定工程师
	 *
	 * @param applyBaseInfo
	 * @author Wang Zhicheng
	 * @date 2015年11月16日下午4:39:01
	 * @since 1.0.0
	 */
	private void sendMessagesByBaseInfoRole(ApplyBaseInfo applyBaseInfo) {

		String msgn = "尊敬的用户:"
				+ userManager.findById(applyBaseInfo.getNextUser()).getName()
				+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
				+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
		BaseUserInfo baseUserInfo = new BaseUserInfo();
		baseUserInfo.setLoginName(userManager.findById(
				applyBaseInfo.getNextUser()).getLoginName());
		baseUserInfo.setMobilephone(userManager.findById(
				applyBaseInfo.getNextUser()).getMobilephone());
		clientNoticeManager.sendMessage(baseUserInfo, msgn);
	}

	/**
	 * 根据基础信息发送短信
	 *
	 * @param applyBaseInfo
	 * @author Wang Zhicheng
	 * @date 2015年11月16日下午2:04:40
	 * @since 1.0.0
	 */
	private void sendMessagesByBaseInfo(ApplyBaseInfo applyBaseInfo) {

		String msg_1 = "尊敬的用户:";
		String msg_2 = ",您好！您有一条[";
		String msg_3 = "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";

		// 发送短信给指定角色
		List<User> userli = userManager.getUserByRole("atncLeader");
		if (userli.size() > 0) {
			for (int i = 0; i < userli.size(); i++) {
				if (!StringUtils.isEmpty(userli.get(i).getMobilephone())) {
					BaseUserInfo baseUserInfo = new BaseUserInfo();
					baseUserInfo.setLoginName(userli.get(i).getLoginName());
					baseUserInfo.setMobilephone(userli.get(i).getMobilephone());
					clientNoticeManager.sendMessage(baseUserInfo,
							msg_1 + userli.get(i).getName() + msg_2
									+ applyBaseInfo.getApplyType() + msg_3);
				}
			}
		}
	}

	/**
	 * 根据基础信息发送短信
	 *
	 * @param applyBaseInfo
	 * @author Wang Zhicheng
	 * @date 2015年11月16日下午2:04:40
	 * @since 1.0.0
	 */
	private void sendMessagesByBaseInfo2(ApplyBaseInfo applyBaseInfo) {

		String msg_1 = "尊敬的用户:";
		String msg_2 = ",您好！您有一条[";
		String msg_3 = "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";

		// 发送短信给指定角色
		List<User> userli = userManager.getUserByRole(RoleEnum.csStaff.name());
		if (userli.size() > 0) {
			for (int i = 0; i < userli.size(); i++) {
				if (!StringUtils.isEmpty(userli.get(i).getMobilephone())) {
					BaseUserInfo baseUserInfo = new BaseUserInfo();
					baseUserInfo.setLoginName(userli.get(i).getLoginName());
					baseUserInfo.setMobilephone(userli.get(i).getMobilephone());
					clientNoticeManager.sendMessage(baseUserInfo,
							msg_1 + userli.get(i).getName() + msg_2
									+ applyBaseInfo.getApplyType() + msg_3);
					System.err.println(msg_1 + userli.get(i).getName() + msg_2
							+ applyBaseInfo.getApplyType() + msg_3);
				}
			}
		}
	}
}
