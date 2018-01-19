package cn.com.atnc.ioms.mng.business.transfernet.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.task.Task;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.approveinfo.IApproveInfoDao;
import cn.com.atnc.ioms.dao.business.baseinfo.IApplyBaseInfoDao;
import cn.com.atnc.ioms.dao.business.evaluate.IApplyEvaluateDao;
import cn.com.atnc.ioms.dao.business.transfernet.ITransferNetDao;
import cn.com.atnc.ioms.dao.clientmng.IClientDao;
import cn.com.atnc.ioms.entity.BaseUserInfo;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.approveinfo.ApproveInfo;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.transfernet.TransferNet;
import cn.com.atnc.ioms.entity.business.transfernet.TransferNetAttach;
import cn.com.atnc.ioms.entity.reports.AutoTelegraphEntity;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveStatusEnum;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveTypeEnum;
import cn.com.atnc.ioms.enums.business.serial.SerialNameEnum;
import cn.com.atnc.ioms.enums.business.serial.SerialTypeEnum;
import cn.com.atnc.ioms.enums.business.transfernet.TransferNetStatEnum;
import cn.com.atnc.ioms.enums.reports.ImageNameEnum;
import cn.com.atnc.ioms.enums.reports.JasperReportsEnum;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.acl.IUserRoleManager;
import cn.com.atnc.ioms.mng.business.approveinfo.IApproveInfoService;
import cn.com.atnc.ioms.mng.business.evaluete.IEvalueteManager;
import cn.com.atnc.ioms.mng.business.serial.IApplySerialService;
import cn.com.atnc.ioms.mng.business.transfernet.ITransferNetAttachService;
import cn.com.atnc.ioms.mng.business.transfernet.ITransferNetManager;
import cn.com.atnc.ioms.mng.business.transfernet.ITransferNetWorkflowService;
import cn.com.atnc.ioms.mng.clientnotice.IClientNoticeManager;
import cn.com.atnc.ioms.mng.reports.JasperReportService;
import cn.com.atnc.ioms.model.business.transfernet.TransferNetQueryModel;
import cn.com.atnc.ioms.util.DataSourceFactory;
import cn.com.atnc.ioms.util.JasperReportUtils;

/**
 * 自动转报网Service方法实现
 *
 * @author Wang Zhicheng
 * @date 2015年10月19日 下午2:05:12
 * @since 1.0.0
 */
@Service
@Transactional
public class TransferNetManagerImpl extends BaseService implements
		ITransferNetManager {

	@Autowired
	private ITransferNetDao transferNetDao;
	@Autowired
	private IApplyBaseInfoDao applyBaseInfoDao;
	@Autowired
	private IClientDao clientDao;
	@Autowired
	private ITransferNetWorkflowService workflowService;
	@Autowired
	private ITransferNetAttachService transferNetAttachService;
	@Autowired
	private IEvalueteManager evalueteManager;
	@Autowired
	private IApplyEvaluateDao applyEvaluateDao;
	@Autowired
	private IApproveInfoDao approveInfoDao;
	@Autowired
	private IApproveInfoService approveInfoService;
	@Autowired
	private IClientNoticeManager clientNoticeManager;
	@Autowired
	private IApplySerialService applySerialService;
	@Autowired
	private IUserManager userManager;
	@Autowired
	private IUserRoleManager userRoleManager;
	@Autowired
	private JasperReportService jasperReportService;

	@Override
	public TransferNet findById(String id) {
		return transferNetDao.findById(id);
	}

	@Override
	public void save(TransferNet transferNet) {
		transferNetDao.save(transferNet);
	}

	@Override
	public Pagination queryPage(TransferNetQueryModel queryModel) {
		return transferNetDao.queryPage(queryModel);
	}

	@Override
	public List<TransferNet> queryList(TransferNetQueryModel queryModel) {
		return transferNetDao.queryList(queryModel);
	}

	@Override
	public void update(TransferNet transferNet) {
		transferNetDao.update(transferNet);
	}

	@Override
	public TransferNetQueryModel getCheckModel(String id) {

		TransferNetQueryModel queryModel = new TransferNetQueryModel();
		TransferNet transferNet = this.findById(id);
		queryModel.setTransferNet(transferNet);
		// 设置用户评价信息
		// ApplyEvaluate applyEvaluate =
		// evalueteManager.findByABI(transferNet.getApplyBaseInfo());
		// queryModel.setApplyEvaluate(applyEvaluate);
		return queryModel;
	}

	@Override
	public TransferNet doCheck(HttpServletRequest request,String id, TransferNetQueryModel queryModel,
			User user) {
		try {
			// 工作流相关
			Task task = workflowService.getTaskByProcessInstaceId(queryModel
					.getPid());
			Map<String, Object> taskVariables = new HashMap<String, Object>();
			// 获取正式电路实体
			TransferNet transferNet = this.findById(id);
			ApplyBaseInfo applyBaseInfo = transferNet.getApplyBaseInfo();
			// 根据角色名称来更新申请审批状态
			userRoleManager.reSetRoles(user);
			// 根据角色名称来更新申请审批状态
			StringBuffer roleNames = new StringBuffer("|");
			List<Role> roles = user.getRoles();
			if (!CollectionUtils.isEmpty(roles)) {
				for (Role role : roles) {
					roleNames.append(role.getName());
					roleNames.append("|");
				}
			}
			String msg = "";// 客户短信内容
			String msgn = "";// atnc指定用户短信内容
			String msg_q = "";// atnc不指定短信内容前半部分
			String msg_h = "";// atnc不指定短信内容后半部分
			String rolestr = "";// 短信需要发送给的角色
			String mss = "";// 操作类型

			String nextusername = "";// 下一步人员名字
			String nextusertel = "";// 下一步人员联系方式

			Map<String, String> absoluteAddress = null; // 退回申请表的网络地址和绝对地址
			// 审批记录状态
			ApproveStatusEnum status = null;
			// 设置是否为代理
			boolean isTransfer = false;

			TransferNetStatEnum approveStat = transferNet.getApproveStat();// 测试提交
			if (roleNames.toString().contains(
					"|" + RoleEnum.csLeader.name() + "|")) { // 客服领导
				if (ObjectUtils.equals(approveStat,
						TransferNetStatEnum.csleader_approve)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.csLeader.name());
					status = ApproveStatusEnum.csleader_approve;
					if (queryModel.isApproveStat()) { // 审批通过
						taskVariables.put("csLeaderReviewPass", "3");// 工作流（客服领导通过）
						transferNet
								.setTaskName(TransferNetStatEnum.generalmanager_approve
										.getValue());
						transferNet
								.setApproveStat(TransferNetStatEnum.generalmanager_approve);
						transferNet.setAtncOpinion(queryModel
								.getApproveRemark());
						transferNet.setAtncSign(user.getName());
						if (queryModel.getApply() != null) {
							if (queryModel.getApply()) {
								mss = "consent";
							} else {
								mss = "disconsent";
							}
						} else {
							mss = "agree";
						}
						rolestr = "manager";
					} else {
						String reason = queryModel.getReason();
						if (reason.equals("退回客服")) {
							taskVariables.put("csLeaderReviewPass", "1"); // 工作流（退回客服）
							// 取出分配的客服专员ID做为下一步的操作人ID
							String csStaff = queryModel.getCsStaff();
							applyBaseInfo.setNextUser(csStaff);
							transferNet
									.setTaskName(TransferNetStatEnum.csstaff_firstdeal
											.getValue());
							transferNet
									.setApproveStat(TransferNetStatEnum.csstaff_firstdeal);
							rolestr = "csStaff";
						} else if (reason.equals("退回网控")) {
							taskVariables.put("csLeaderReviewPass", "2"); // 工作流（退回网控）
							transferNet
									.setTaskName(TransferNetStatEnum.atncleader_firstdeal
											.getValue());
							transferNet
									.setApproveStat(TransferNetStatEnum.atncleader_firstdeal);
							rolestr = "atncLeader";
						} else if(reason.equals("用印审批")) {
							taskVariables.put("csLeaderReviewPass", "4"); // 工作流（退回申请用户）
							transferNet
									.setTaskName(TransferNetStatEnum.fundmanager_approve
											.getValue());
							transferNet
									.setApproveStat(TransferNetStatEnum.fundmanager_approve);
							rolestr = "fundmanager";
							applyBaseInfo.setLeaderCheckFlag(false);
						}
						mss = "reject";
					}
				}
				transferNet.setFinalApproveOpinion(queryModel
						.getApproveRemark());
				transferNet.setAtncSign(user.getName());
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.csStaff.name() + "|")) { // 客服专员
				if (ObjectUtils.equals(approveStat,
						TransferNetStatEnum.csstaff_firstdeal)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.csStaff.name());
					status = ApproveStatusEnum.csstaff_firstdeal;
					taskVariables.put("csStaffReviewComplete", "true"); // 工作流（客服专员审核）
					transferNet
							.setTaskName(TransferNetStatEnum.csleader_approve
									.getValue());
					transferNet
							.setApproveStat(TransferNetStatEnum.csleader_approve);
					rolestr = "csLeader";
				}
				if (ObjectUtils.equals(approveStat,
						TransferNetStatEnum.csstaff_deal)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.csStaff.name());
					status = ApproveStatusEnum.csstaff_deal;
					taskVariables.put("csStaffPass", "true"); // 工作流（客服专员办理）
					transferNet
							.setTaskName(TransferNetStatEnum.atncleader_seconddeal
									.getValue());
					transferNet
							.setApproveStat(TransferNetStatEnum.atncleader_seconddeal);
					transferNet.setFinalApproveSign(user.getRoleNames());
					// 保存客服专员选择的协同阅知的管局
					String bureau = queryModel.getBureau();
					if (StringUtils.isNotEmpty(bureau)) {
						applyBaseInfo.setCandidate(bureau);
					}
					rolestr = "atncLeader";
				}
				mss = "confirm";
				// 保存联系人和联系电话
				applyBaseInfo.setFinalLinkman(user.getName());
				applyBaseInfo.setFinalLinkphone(user.getMobilephone());
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.atncLeader.name() + "|")) { // 网控领导

				if (queryModel.isApproveStat()) { // 审批通过

					if (ObjectUtils.equals(approveStat,
							TransferNetStatEnum.atncleader_firstdeal)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_firstdeal;
						taskVariables.put("atncLeaderFirstDistribute", "true");// 工作流（网控领导交办审核）
						transferNet
								.setTaskName(TransferNetStatEnum.engineer_firstaudit
										.getValue());
						// 记录选择的审核工程师，工程师审核时使用
						String auditEngineer = queryModel.getAuditEngineer();
						applyBaseInfo.setNextUser(auditEngineer);
						transferNet
								.setApproveStat(TransferNetStatEnum.engineer_firstaudit);
						// 设置下一步操作信息（审批记录使用）
						User nextuser = userManager.findById(auditEngineer);
						nextusername = nextuser.getName();
						nextusertel = nextuser.getMobilephone();
						// --------------------------更新配置实体------------------------
						mss = "agree";
						msgn = "尊敬的用户:"
								+ userManager.findById(
										queryModel.getAuditEngineer())
										.getName() + ",您好！您有一条["
								+ applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
						// ------------------------------------------------------------
					} else if (ObjectUtils.equals(approveStat,
							TransferNetStatEnum.atncleader_approve)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_approve;
						taskVariables.put("atncLeaderReviewPass", "true"); // 工作流（网控领导审核）
						transferNet
								.setTaskName(TransferNetStatEnum.netmanager_approve
										.getValue());
						transferNet
								.setApproveStat(TransferNetStatEnum.netmanager_approve);
						if (queryModel.getApply() != null) {
							if (queryModel.getApply()) {
								mss = "consent";
							} else {
								mss = "disconsent";
							}
						} else {
							mss = "agree";
						}
						rolestr = "netmanager";
					} else if (ObjectUtils.equals(approveStat,
							TransferNetStatEnum.atncleader_seconddeal)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_seconddeal;
						taskVariables.put("atncLeaderDistribute", "true");// 工作流（网控领导交办配置）
						transferNet
								.setTaskName(TransferNetStatEnum.engineer_config
										.getValue());
						// 记录选择的配置工程师
						String engineerId = queryModel.getEngineer();
						applyBaseInfo.setNextUser(engineerId);
						transferNet
								.setApproveStat(TransferNetStatEnum.engineer_config);
						// 设置下一步操作信息（审批记录使用）
						User nextuser = userManager.findById(engineerId);
						nextusername = nextuser.getName();
						nextusertel = nextuser.getMobilephone();
						// --------------------------更新配置实体------------------------
						mss = "agree";
						msgn = "尊敬的用户:"
								+ userManager.findById(engineerId).getName()
								+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
						// ------------------------------------------------------------
					} else if (ObjectUtils.equals(approveStat,
							TransferNetStatEnum.atncleader_thirddeal)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_thirddeal;
						taskVariables.put("atncLeaderDistribute", "true");// 工作流（网控领导交办配置）
						transferNet
								.setTaskName(TransferNetStatEnum.engineer_secondaudit
										.getValue());
						// 记录选择的审核工程师
						String auditEngineer = queryModel.getAuditEngineer();
						applyBaseInfo.setNextUser(auditEngineer);
						transferNet
								.setApproveStat(TransferNetStatEnum.engineer_secondaudit);
						// 设置下一步操作信息（审批记录使用）
						User nextuser = userManager.findById(auditEngineer);
						nextusername = nextuser.getName();
						nextusertel = nextuser.getMobilephone();
						// --------------------------更新配置实体------------------------
						mss = "agree";
						msgn = "尊敬的用户:"
								+ userManager.findById(auditEngineer).getName()
								+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
						// ------------------------------------------------------------
					} 
				} else { // 审批退回
					if (ObjectUtils.equals(approveStat,
							TransferNetStatEnum.atncleader_approve)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_approve;
						taskVariables.put("atncLeaderReviewPass", "false"); // 工作流（网控领导审核）
						transferNet
								.setTaskName(TransferNetStatEnum.engineer_firstaudit
										.getValue());
						applyBaseInfo.setNextUser(applyBaseInfo.getLastUser());
						transferNet
								.setApproveStat(TransferNetStatEnum.engineer_firstaudit);
						msgn = "尊敬的用户:"
								+ userManager.findById(
										applyBaseInfo.getLastUser()).getName()
								+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					}
					mss = "reject";
				}
				if (!ObjectUtils.equals(approveStat,
						TransferNetStatEnum.atncleader_seconddeal)) {
					transferNet.setAtncOpinion(queryModel.getApproveRemark());
					transferNet.setFinalApproveOpinion(queryModel
							.getApproveRemark());
					transferNet.setAtncSign(user.getName());
				}
				transferNet.setFinalApproveCom("北京天航信民航通信网络发展有限公司");
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.engineer.name() + "|")) { // 工程师

				if (queryModel.isApproveStat()) {// 配置
					// 获取配置实体
					if (ObjectUtils.equals(approveStat,
							TransferNetStatEnum.engineer_firstaudit)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_firstaudit;
						taskVariables.put("engineerAuditComplete", "true"); // 工作流（工程师初审）
						applyBaseInfo.setLastUser(user.getId());
						transferNet
								.setTaskName(TransferNetStatEnum.atncleader_approve
										.getValue());
						transferNet
								.setApproveStat(TransferNetStatEnum.atncleader_approve);
						mss = "agree";
						rolestr = "atncLeader";
					} else if (ObjectUtils.equals(approveStat,
							TransferNetStatEnum.engineer_config)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_config;
						taskVariables.put("transfer", "false"); // 工作流（工程师配置）
						transferNet
								.setTaskName(TransferNetStatEnum.atncleader_thirddeal
										.getValue());
						applyBaseInfo.setLastUser(user.getId());
						applyBaseInfo
								.setLastStatusEnum(TransferNetStatEnum.engineer_config
										.name());
						transferNet
								.setApproveStat(TransferNetStatEnum.atncleader_thirddeal);
						rolestr = "atncLeader";
						// --------------------------更新操作人------------------------
						// ------------------------------------------------------------
						// 若之前审核工程师退回了，删除之前的配置信息
						/*
						 * List<TeleGraphConfig> configs =
						 * teleGraphConfigDao.getConfigsByTeleGraphId
						 * (teleGraph.getId());
						 * if(!CollectionUtils.isEmpty(configs)) {
						 * teleGraphConfigDao.deleteList(configs); }
						 */

					} else if (ObjectUtils.equals(approveStat,
							TransferNetStatEnum.engineer_transfer)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_transfer;
						taskVariables.put("assistConfig", "true"); // 工作流（工程师协助配置）
						transferNet
								.setTaskName(TransferNetStatEnum.atncleader_thirddeal
										.getValue());
						applyBaseInfo.setLastUser(user.getId());
						applyBaseInfo
								.setLastStatusEnum(TransferNetStatEnum.engineer_transfer
										.name());
						transferNet
								.setApproveStat(TransferNetStatEnum.atncleader_thirddeal);
						rolestr = "atncLeader";
					} else if (ObjectUtils.equals(approveStat,
							TransferNetStatEnum.engineer_secondaudit)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_secondaudit;
						taskVariables.put("engineerAuditPass", "3"); // 工作流（工程师二次审核）
						transferNet.setTaskName(TransferNetStatEnum.unevaluate
								.getValue());
						transferNet
								.setApproveStat(TransferNetStatEnum.unevaluate);
						msg = "尊敬的用户:"
								+ transferNet.getApplyBaseInfo()
										.getApplyLinkman() + ",您好！您有一条["
								+ applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					}
					mss = "agree";
				} else {
					if (ObjectUtils.equals(approveStat,
							TransferNetStatEnum.engineer_config)) { // 移交其他工程师
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_config;
						taskVariables.put("transfer", "true"); // 工作流（工程师移交）
						transferNet
								.setTaskName(TransferNetStatEnum.engineer_transfer
										.getValue());
						String engineerId = queryModel.getEngineer();
						transferNet
								.setApproveStat(TransferNetStatEnum.engineer_transfer);
						applyBaseInfo.setNextUser(engineerId);
						// 设置下一步操作信息（审批记录使用）
						User nextuser = userManager.findById(engineerId);
						nextusername = nextuser.getName();
						nextusertel = nextuser.getMobilephone();
						mss = "transfer";
						msgn = "尊敬的用户:"
								+ userManager.findById(engineerId).getName()
								+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					} else if (ObjectUtils.equals(approveStat,
							TransferNetStatEnum.engineer_secondaudit)) { // 审核工程师退回
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_secondaudit;
						String lastUserId = applyBaseInfo.getLastUser();
						String lastStatus = applyBaseInfo.getLastStatusEnum();
						if (StringUtils.equalsIgnoreCase(lastStatus,
								TransferNetStatEnum.engineer_config.name())) {
							// 如果是正常工程师配置的，则退回给正常工程师
							taskVariables.put("engineerAuditPass", "1"); // 工作流（工程师审核未通过）
							transferNet
									.setApproveStat(TransferNetStatEnum.engineer_config);
							transferNet
									.setTaskName(TransferNetStatEnum.engineer_config
											.getValue());
						} else if (StringUtils.equalsIgnoreCase(lastStatus,
								TransferNetStatEnum.engineer_transfer.name())) {
							// 如果是移交工程师配置的，则退回给移交工程师
							taskVariables.put("engineerAuditPass", "2"); // 工作流（工程师审核未通过）
							transferNet
									.setApproveStat(TransferNetStatEnum.engineer_transfer);
							transferNet
									.setTaskName(TransferNetStatEnum.engineer_transfer
											.getValue());
						}
						applyBaseInfo.setNextUser(lastUserId);
						mss = "reject";
						msgn = "尊敬的用户:"
								+ userManager.findById(lastUserId).getName()
								+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					}
				}
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.manager.name() + "|")) { // 事业部经理
				if (ObjectUtils.equals(approveStat,
						TransferNetStatEnum.generalmanager_approve)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.manager.name());
					status = ApproveStatusEnum.generalmanager_approve;
					taskVariables.put("generalManagerPass", "true"); // 工作流（网控总经理审核）
					transferNet
							.setTaskName(TransferNetStatEnum.compenyleader_approve
									.getValue());
					transferNet
							.setApproveStat(TransferNetStatEnum.compenyleader_approve);
					if (queryModel.getApply() != null) {
						if (queryModel.getApply()) {
							mss = "consent";
						} else {
							mss = "disconsent";
						}
					} else {
						mss = "agree";
					}
					transferNet.setFinalApproveOpinion(queryModel
							.getApproveRemark());
					transferNet.setAtncSign(user.getName());
					rolestr = "leader";
				}
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.netmanager.name() + "|")) { // 网控总经理
				if (ObjectUtils.equals(approveStat,
						TransferNetStatEnum.netmanager_approve)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.netmanager.name());
					status = ApproveStatusEnum.netmanager_approve;
					taskVariables.put("netManagerPass", "true"); // 工作流（网控总经理审核）
					transferNet
							.setTaskName(TransferNetStatEnum.csstaff_firstdeal
									.getValue());
					transferNet
							.setApproveStat(TransferNetStatEnum.csstaff_firstdeal);
					if (queryModel.getApply() != null) {
						if (queryModel.getApply()) {
							mss = "consent";
						} else {
							mss = "disconsent";
						}
					} else {
						mss = "agree";
					}
					transferNet.setFinalApproveOpinion(queryModel
							.getApproveRemark());
					transferNet.setAtncSign(user.getName());
					rolestr = "csStaff";
				}
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.leader.name() + "|")) { // 公司领导
				if (queryModel.isApproveStat()) { // 审批通过
					if (ObjectUtils.equals(approveStat,
							TransferNetStatEnum.compenyleader_approve)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.leader.name());
						status = ApproveStatusEnum.compenyleader_approve;
						taskVariables.put("leaderPass", "true"); // 工作流（公司领导审核）
						transferNet
								.setTaskName(TransferNetStatEnum.fundmanager_approve
										.getValue());
						transferNet
								.setApproveStat(TransferNetStatEnum.fundmanager_approve);
						// 生成正式的申请编号
						applyBaseInfo.setSerialNumber(applySerialService
								.createSerialNumber(SerialNameEnum.RW,
										SerialTypeEnum.ZB));
						// 设置审批字段
						applyBaseInfo.setLeaderCheckFlag(true);
						mss = "consent";
						rolestr = "fundmanager";
					}
				} else {
					if (ObjectUtils.equals(approveStat,
							TransferNetStatEnum.compenyleader_approve)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.leader.name());
						status = ApproveStatusEnum.compenyleader_approve;
						taskVariables.put("leaderPass", "true"); // 工作流（公司领导审核）
						transferNet
								.setTaskName(TransferNetStatEnum.fundmanager_approve
										.getValue());
						transferNet
								.setApproveStat(TransferNetStatEnum.fundmanager_approve);
						// 设置审批字段
						applyBaseInfo.setLeaderCheckFlag(false);
						rolestr = "fundmanager";
						mss = "disconsent";
					}
				}
				transferNet.setFinalApproveOpinion(queryModel
						.getApproveRemark());
				transferNet.setAtncSign(user.getName());
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.fundmanager.name() + "|")) { // 财务部经理
				if (ObjectUtils.equals(approveStat,
						TransferNetStatEnum.fundmanager_approve)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.fundmanager.name());
					status = ApproveStatusEnum.fundmanager_approve;
					transferNet.setCachetApprove(Integer.valueOf(1));
					if (applyBaseInfo.getLeaderCheckFlag()) {
						taskVariables.put("fundManagerConfirm", "true"); // 工作流（网控总经理审核）
						transferNet
								.setTaskName(TransferNetStatEnum.csstaff_deal
										.getValue());
						transferNet
								.setApproveStat(TransferNetStatEnum.csstaff_deal);
						mss = "confirm";
						rolestr = "csStaff";
					} else {
						// 退回流程
						taskVariables.put("fundManagerConfirm", "false"); // 工作流（公司领导审核）
						transferNet.setTaskName("公司领导退回");
						queryModel.setApproveStat(false);
						// 申请人所在管局
						Bureau bureau = transferNet.getApplyBaseInfo()
								.getApplyUser().getBureau();
						if (!ObjectUtils.equals(bureau, null)) {
							bureau = Bureau.isBelong7Bureau(bureau.getValue());
						}
						if (!ObjectUtils.equals(bureau, null)) { // 申请人属于7大管局
							taskVariables
									.put("needAreaExaminerConfirm", "true");
							transferNet
									.setTaskName(TransferNetStatEnum.areaexaminer_affirm
											.getValue());
							transferNet
									.setApproveStat(TransferNetStatEnum.areaexaminer_affirm);
							msg = "尊敬的用户:"
									+ transferNet.getApplyBaseInfo()
											.getInitLinkman()
									+ ",您好！您有一条["
									+ applyBaseInfo.getApplyType()
									+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
						} else {
							taskVariables.put("needAreaExaminerConfirm",
									"false");
							transferNet
									.setTaskName(TransferNetStatEnum.returned
											.getValue());
							transferNet
									.setApproveStat(TransferNetStatEnum.returned);
							msg = "尊敬的用户:"
									+ transferNet.getApplyBaseInfo()
											.getApplyLinkman()
									+ ",您好！您有一条["
									+ applyBaseInfo.getApplyType()
									+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
						}
						//审批退回后，重置发送短信标识，下次前台提交时，可以给后台发送短信
						applyBaseInfo.setSendmessageFlag(false);
						mss = "confirm";
						// 保存申请表
						int number = approveInfoService
								.getReturnedApplyNumber(applyBaseInfo.getId());
						this.getReportParams(request, transferNet.getId(),
								JasperReportsEnum.autotelegraph.toString());
						absoluteAddress = JasperReportUtils
								.saveReturedApplyList(number,
										applyBaseInfo.getId(), request,
										JasperReportsEnum.autotelegraph.name());
					}
				}
			}
			//添加审核人
			applyBaseInfo.setApproveUsers(applyBaseInfo.getApproveUsers() == null ? user.getName() 
					: applyBaseInfo.getApproveUsers() + "," + user.getName());
			applyBaseInfoDao.update(applyBaseInfo); // 更新申请基础信息表
			transferNetDao.update(transferNet); // 更新转报地址申请表
			// 添加审批记录
			ApproveInfo approveInfo = new ApproveInfo(user, applyBaseInfo,
					queryModel.getApproveRemark(), queryModel.isApproveStat());
			approveInfo.setNextUserName(nextusername);
			approveInfo.setNextUserTel(nextusertel);
			// 设置代理信息
			if (isTransfer) {
				approveInfo.setUsername(user.getName()
						+ userRoleManager.getTransferInfos(user));
			}
			// 保存退回的申请表路径
			if (!CollectionUtils.isEmpty(absoluteAddress)) {
				approveInfo.setOutlineAddress(absoluteAddress
						.get(JasperReportUtils.OUTLINE_ADDRESS));
				approveInfo.setReportAddress(absoluteAddress
						.get(JasperReportUtils.REPORT_ADDRESS));
			}
			switch (mss) {
			case "agree":
				approveInfo.setApproveType(ApproveTypeEnum.agree);
				break;
			case "reject":
				approveInfo.setApproveType(ApproveTypeEnum.reject);
				break;
			case "confirm":
				approveInfo.setApproveType(ApproveTypeEnum.confirm);
				break;
			case "disconsent":
				approveInfo.setApproveType(ApproveTypeEnum.disconsent);
				break;
			case "consent":
				approveInfo.setApproveType(ApproveTypeEnum.consent);
				break;
			case "transfer":
				approveInfo.setApproveType(ApproveTypeEnum.transfer);
				break;
			default:
				break;
			}
			approveInfo.setApproveStatus(status);
			approveInfoDao.save(approveInfo);
			// 发送短信
			if (!StringUtils.isEmpty(msg)
					&& !StringUtils.isEmpty(transferNet.getApplyBaseInfo()
							.getApplyPhone())) {
				BaseUserInfo baseUserInfo = new BaseUserInfo();
				if (transferNet.getApproveStat().equals(
						TransferNetStatEnum.areaexaminer_affirm)) {
					baseUserInfo.setLoginName(transferNet.getApplyBaseInfo()
							.getInitLinkman());
					baseUserInfo.setMobilephone(transferNet.getApplyBaseInfo()
							.getInitLinkphone());
				} else {
					baseUserInfo.setLoginName(transferNet.getApplyBaseInfo()
							.getApplyLinkman());
					baseUserInfo.setMobilephone(transferNet.getApplyBaseInfo()
							.getApplyPhone());
				}
				clientNoticeManager.sendMessage(baseUserInfo, msg);
			}
			// 发送短信给指定人
			if (!StringUtils.isEmpty(msgn)
					&& !StringUtils.isEmpty(userManager.findById(
							applyBaseInfo.getNextUser()).getMobilephone())) {
				BaseUserInfo baseUserInfo = new BaseUserInfo();
				baseUserInfo.setLoginName(userManager.findById(
						applyBaseInfo.getNextUser()).getLoginName());
				baseUserInfo.setMobilephone(userManager.findById(
						applyBaseInfo.getNextUser()).getMobilephone());
				clientNoticeManager.sendMessage(baseUserInfo, msgn);
			}
			// 发送短信给指定角色
			if (!StringUtils.isEmpty(rolestr)) {
				List<User> userli = userManager.getUserByRole(rolestr);
				msg_q = "尊敬的用户:";
				msg_h = ",您好！您有一条[" + applyBaseInfo.getApplyType()
						+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
				if (userli.size() > 0) {
					for (int i = 0; i < userli.size(); i++) {
						if (!StringUtils
								.isEmpty(userli.get(i).getMobilephone())) {
							BaseUserInfo baseUserInfo = new BaseUserInfo();
							baseUserInfo.setLoginName(userli.get(i)
									.getLoginName());
							baseUserInfo.setMobilephone(userli.get(i)
									.getMobilephone());
							clientNoticeManager.sendMessage(baseUserInfo, msg_q
									+ userli.get(i).getName() + msg_h);
						}
					}
				}
			}
			workflowService.complete(task.getId(), taskVariables);
			return transferNet;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("处理表单信息出错，原因是：" + e.getMessage());
		}
	}

	@Override
	public TransferNetQueryModel setModel(TransferNetQueryModel queryModel) {

		queryModel.setFlag(true);
		queryModel.setApplyDate(queryModel.getTransferNet().getApplyBaseInfo()
				.getApplyDate());
		return queryModel;
	}

	@Override
	public TransferNetQueryModel getViewModel(ApplyBaseInfo applyBaseInfo) {
		TransferNet transferNet = this.findByApplyBaseInfo(applyBaseInfo);
		TransferNetQueryModel FCModel = this.getCheckModel(transferNet.getId());
		return FCModel;
	}

	private TransferNet findByApplyBaseInfo(ApplyBaseInfo applyBaseInfo) {
		return transferNetDao.findByApplyBaseInfo(applyBaseInfo).get(0);
	}

	@Override
	public TransferNet findByApplyBaseInfo(String id) {
		ApplyBaseInfo applyBaseInfo = applyBaseInfoDao.findById(id);
		TransferNet transferNet = this.findByApplyBaseInfo(applyBaseInfo);
		return transferNet;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getReportParams(HttpServletRequest request,
			String id, String reportName) {
		// 1.主报表数据源
		List<AutoTelegraphEntity> entity = jasperReportService
				.getTransferNetDatasource(id);
		List<TransferNet> datasource = (List<TransferNet>) DataSourceFactory
				.getBeanCollection(entity);
		// 2.获取报表相关参数，供预览使用
		Map<String, Object> param = null;
		TransferNet transferNet = this.findById(id);
		// 判断用印审批为是否为true，如果是，则显示公章，否则不显示。
		if (transferNet.getCachetApprove() == 0) {
			param = jasperReportService
					.preView(request, datasource, reportName);
		} else {
			param = jasperReportService.preView(request, datasource,
					ImageNameEnum.atncCachet.getValue(), reportName);
		}
		// 判断上传了哪些附件
		List<TransferNetAttach> transferNetAttachs = transferNetAttachService
				.queryListByTNId(id);
		if (!CollectionUtils.isEmpty(transferNetAttachs)) {
			for (TransferNetAttach transferNetAttach : transferNetAttachs) {
				switch (transferNetAttach.getAttachType()) {
				case one:
					param.put("MATERIAL1", "1");
					break;
				case two:
					param.put("MATERIAL2", "1");
					break;
				case three:
					param.put("MATERIAL3", "1");
					break;
				case four:
					param.put("MATERIAL4", "1");
					break;
				default:
					break;
				}
			}
		}
		return param;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.business.transfernet.ITransferNetManager#getListSendMessage()
	 */
	@Override
	public List<TransferNet> getListSendMessage() {
		return transferNetDao.getListSendMessage();
	}
}
