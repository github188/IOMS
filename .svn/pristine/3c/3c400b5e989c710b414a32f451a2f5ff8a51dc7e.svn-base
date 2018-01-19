package cn.com.atnc.ioms.mng.business.formalcircuit.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.task.Task;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.approveinfo.IApproveInfoDao;
import cn.com.atnc.ioms.dao.business.baseinfo.IApplyBaseInfoDao;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitDao;
import cn.com.atnc.ioms.entity.BaseUserInfo;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.approveinfo.ApproveInfo;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitATM;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitConfig;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitKU;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitPES;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitTES;
import cn.com.atnc.ioms.entity.reports.ATMFormalCircuitEntity;
import cn.com.atnc.ioms.entity.reports.FormalCircuitBaseInfoEntity;
import cn.com.atnc.ioms.entity.reports.KUFormalCircuitEntity;
import cn.com.atnc.ioms.entity.reports.PESFormalCircuitEntity;
import cn.com.atnc.ioms.entity.reports.TESFormalCircuitEntity;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveStatusEnum;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveTypeEnum;
import cn.com.atnc.ioms.enums.business.baseinfo.ApplyTypeEnum;
import cn.com.atnc.ioms.enums.business.formalcircuit.FormalStatEnum;
import cn.com.atnc.ioms.enums.business.serial.SerialNameEnum;
import cn.com.atnc.ioms.enums.business.serial.SerialTypeEnum;
import cn.com.atnc.ioms.enums.reports.ImageNameEnum;
import cn.com.atnc.ioms.enums.reports.JasperReportsEnum;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.acl.IUserRoleManager;
import cn.com.atnc.ioms.mng.business.approveinfo.IApproveInfoService;
import cn.com.atnc.ioms.mng.business.formalcircuit.FormalCircuitWorkflowService;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitATMManager;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitConfManager;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitKUManager;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitManager;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitPESManager;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitTESManager;
import cn.com.atnc.ioms.mng.business.serial.IApplySerialService;
import cn.com.atnc.ioms.mng.clientnotice.IClientNoticeManager;
import cn.com.atnc.ioms.mng.reports.JasperReportService;
import cn.com.atnc.ioms.model.business.formalcircuit.FormalCircuitQueryModel;
import cn.com.atnc.ioms.util.DataSourceFactory;
import cn.com.atnc.ioms.util.JasperReportUtils;

/**
 * 正式电路申请表基础信息Service接口实现类
 *
 * @author WangLingbin
 * @date 2015年7月28日 上午11:36:14
 * @since 1.0.0
 */
@Service
@Transactional
public class FormalCircuitManagerImpl extends BaseService implements
		IFormalCircuitManager {

	@Autowired
	private IFormalCircuitDao formalCircuitDao;
	@Autowired
	private IApplyBaseInfoDao applyBaseInfoDao;
	@Autowired
	private IApproveInfoDao approveInfoDao;
	@Autowired
	private IFormalCircuitATMManager formalCircuitATMManager;
	@Autowired
	private IFormalCircuitKUManager formalCircuitKUManager;
	@Autowired
	private IFormalCircuitTESManager formalCircuitTESManager;
	@Autowired
	private IFormalCircuitPESManager formalCircuitPESManager;
	// @Autowired
	// private IEvalueteManager evalueteManager;
	@Autowired
	private IApproveInfoService approveInfoService;
	@Autowired
	private FormalCircuitWorkflowService workflowService;
	@Autowired
	private IClientNoticeManager clientNoticeManager;
	@Autowired
	IFormalCircuitConfManager formalCircuitConfManager;
	@Autowired
	private IApplySerialService applySerialService;
	@Autowired
	private IUserManager userManager;
	@Autowired
	private IUserRoleManager userRoleManager;
	@Autowired
	private JasperReportService jasperReportService;

	@Override
	public Pagination queryPage(FormalCircuitQueryModel queryModel) {
		return formalCircuitDao.queryPage(queryModel);
	}

	@Override
	public List<FormalCircuit> queryList(FormalCircuitQueryModel queryModel) {
		return formalCircuitDao.queryList(queryModel);
	}

	@Override
	public void save(FormalCircuit formalCircuit) {
		formalCircuitDao.save(formalCircuit);
	}

	@Override
	public void update(FormalCircuit formalCircuit) {
		formalCircuitDao.update(formalCircuit);
	}

	@Override
	public FormalCircuit findById(String id) {
		return formalCircuitDao.findById(id);
	}

	@Override
	public FormalCircuitQueryModel getCheckModel(String id) {

		FormalCircuitQueryModel queryModel = new FormalCircuitQueryModel();
		FormalCircuit formalCircuit = this.findById(id);
		queryModel.setFormalCircuit(formalCircuit);
		// 设置用户评价信息
		// ApplyEvaluate applyEvaluate =
		// evalueteManager.findByABI(formalCircuit.getApplyBaseInfo());
		// queryModel.setApplyEvaluate(applyEvaluate);
		// ATM正式电路
		List<FormalCircuitATM> FCATMli = formalCircuitATMManager
				.findByFC(formalCircuit);
		queryModel.setFormalCircuitATMli(FCATMli);
		// KU正式电路
		List<FormalCircuitKU> FCKUli = formalCircuitKUManager
				.findByFC(formalCircuit);
		queryModel.setFormalCircuitKUli(FCKUli);
		// TES正式电路
		List<FormalCircuitTES> FCTESli = formalCircuitTESManager
				.findByFC(formalCircuit);
		queryModel.setFormalCircuitTESli(FCTESli);
		// PES正式电路
		List<FormalCircuitPES> FCPESli = formalCircuitPESManager
				.findByFC(formalCircuit);
		queryModel.setFormalCircuitPESli(FCPESli);
		return queryModel;
	}

	@Override
	public FormalCircuit doCheck(HttpServletRequest request, String id, FormalCircuitQueryModel queryModel,
			User user) {
		try {
			// 工作流相关
			Task task = workflowService.getTaskByProcessInstaceId(queryModel
					.getPid());
			Map<String, Object> taskVariables = new HashMap<String, Object>();
			// 获取正式电路实体
			FormalCircuit formalCircuit = this.findById(id);
			FormalCircuitConfig config = formalCircuit.getFormalCircuitConfig();
			ApplyBaseInfo applyBaseInfo = formalCircuit.getApplyBaseInfo();
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
			String msgn = "";// atnc指定短信内容
			String msg_q = "";// atnc不指定人短信内容前半部分
			String msg_h = "";// atnc不指定人短信内容后半部分
			String rolestr = "";// 短信需要发送给的角色
			String mss = "";// 操作类型

			String nextusername = "";// 下一步人员名字
			String nextusertel = "";// 下一步人员联系方式

			Map<String, String> absoluteAddress = null; // 退回申请表的网络地址和绝对地址
			// 审批记录状态
			ApproveStatusEnum status = null;
			// 设置是否为代理
			boolean isTransfer = false;

			FormalStatEnum approveStat = formalCircuit.getApproveStat();// 测试提交
			if (roleNames.toString().contains(
					"|" + RoleEnum.csLeader.name() + "|")) { // 客服领导
				if (ObjectUtils.equals(approveStat,
						FormalStatEnum.csleader_approve)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.csLeader.name());
					status = ApproveStatusEnum.csleader_approve;
					if (queryModel.isApproveStat()) { // 审批通过
						taskVariables.put("csLeaderReviewPass", "3");// 工作流（客服领导通过）
						formalCircuit
								.setTaskName(FormalStatEnum.generalmanager_approve
										.getValue());
						formalCircuit
								.setApproveStat(FormalStatEnum.generalmanager_approve);
						formalCircuit.setAtncOpinion(queryModel
								.getApproveRemark());
						formalCircuit.setAtncSign(user.getName());
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
					} else { // 审批退回
						String reason = queryModel.getReason();
						if (reason.equals("退回客服")) {
							taskVariables.put("csLeaderReviewPass", "1"); // 工作流（退回客服）
							// 取出分配的客服专员ID做为下一步的操作人ID
							String csStaff = queryModel.getCsStaff();
							applyBaseInfo.setNextUser(csStaff);
							formalCircuit
									.setTaskName(FormalStatEnum.csstaff_firstdeal
											.getValue());
							formalCircuit
									.setApproveStat(FormalStatEnum.csstaff_firstdeal);
							rolestr = "csStaff";
						} else if (reason.equals("退回网控")) {
							taskVariables.put("csLeaderReviewPass", "2"); // 工作流（退回网控）
							formalCircuit
									.setTaskName(FormalStatEnum.atncleader_firstdeal
											.getValue());
							formalCircuit
									.setApproveStat(FormalStatEnum.atncleader_firstdeal);
							rolestr = "atncLeader";
						} else if (reason.equals("用印审批")) {
							taskVariables.put("csLeaderReviewPass", "4"); // 工作流（退回申请用户）
							formalCircuit
									.setTaskName(FormalStatEnum.fundmanager_approve
											.getValue());
							formalCircuit
									.setApproveStat(FormalStatEnum.fundmanager_approve);
							rolestr = "fundmanager";
							applyBaseInfo.setLeaderCheckFlag(false);
							formalCircuit.setAtncOpinion(queryModel
									.getApproveRemark());
							formalCircuit.setAtncSign(user.getName());
						}
						mss = "reject";
					}
				}
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.csStaff.name() + "|")) { // 客服专员
				if (ObjectUtils.equals(approveStat,
						FormalStatEnum.csstaff_firstdeal)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.csStaff.name());
					status = ApproveStatusEnum.csstaff_firstdeal;
					taskVariables.put("csStaffReviewComplete", "true"); // 工作流（客服专员审核）
					formalCircuit.setTaskName(FormalStatEnum.csleader_approve
							.getValue());
					formalCircuit
							.setApproveStat(FormalStatEnum.csleader_approve);
					rolestr = "csLeader";
				}
				if (ObjectUtils
						.equals(approveStat, FormalStatEnum.csstaff_deal)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.csStaff.name());
					status = ApproveStatusEnum.csstaff_deal;
					taskVariables.put("csStaffPass", "true"); // 工作流（客服专员办理）
					formalCircuit
							.setTaskName(FormalStatEnum.atncleader_seconddeal
									.getValue());
					formalCircuit
							.setApproveStat(FormalStatEnum.atncleader_seconddeal);
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
							FormalStatEnum.atncleader_firstdeal)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_firstdeal;
						taskVariables.put("atncLeaderDistribute", "true");// 工作流（网控领导交办审核）
						formalCircuit
								.setTaskName(FormalStatEnum.engineer_firstaudit
										.getValue());
						// 记录选择的审核工程师，工程师审核时使用
						String auditEngineer = queryModel.getAuditEngineer();
						applyBaseInfo.setNextUser(auditEngineer);
						formalCircuit
								.setApproveStat(FormalStatEnum.engineer_firstaudit);
						// 设置下一步操作信息（审批记录使用）
						User nextuser = userManager.findById(auditEngineer);
						nextusername = nextuser.getName();
						nextusertel = nextuser.getMobilephone();
						// --------------------------更新配置实体------------------------
						config.setAtncLeader(user.getName());
						formalCircuitConfManager.update(config);
						mss = "agree";
						formalCircuit.setAtncOpinion(queryModel
								.getApproveRemark());
						formalCircuit.setAtncSign(user.getName());
						msgn = "尊敬的工程师:"
								+ userManager.findById(
										queryModel.getAuditEngineer())
										.getName() + ",您好！您有一条["
								+ applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
						// ------------------------------------------------------------
					} else if (ObjectUtils.equals(approveStat,
							FormalStatEnum.atncleader_approve)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_approve;
						taskVariables.put("atncLeaderReviewPass", "true"); // 工作流（网控领导审核）
						formalCircuit
								.setTaskName(FormalStatEnum.csstaff_firstdeal
										.getValue());
						formalCircuit
								.setApproveStat(FormalStatEnum.csstaff_firstdeal);
						if (queryModel.getApply() != null) {
							if (queryModel.getApply()) {
								mss = "consent";
							} else {
								mss = "disconsent";
							}
						} else {
							mss = "agree";
						}
						rolestr = "csStaff";
					} else if (ObjectUtils.equals(approveStat,
							FormalStatEnum.atncleader_seconddeal)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_seconddeal;
						taskVariables.put("atncLeaderDistribute", "true");// 工作流（网控领导交办配置）
						formalCircuit
								.setTaskName(FormalStatEnum.engineer_config
										.getValue());
						// 记录选择的配置工程师
						String engineerId = queryModel.getEngineer();
						applyBaseInfo.setNextUser(engineerId);
						formalCircuit
								.setApproveStat(FormalStatEnum.engineer_config);
						// 设置下一步操作信息（审批记录使用）
						User nextuser = userManager.findById(engineerId);
						nextusername = nextuser.getName();
						nextusertel = nextuser.getMobilephone();
						// --------------------------更新配置实体------------------------
						config.setAtncLeader(user.getName());
						formalCircuitConfManager.update(config);
						mss = "agree";
						msgn = "尊敬的用户:"
								+ userManager.findById(engineerId).getName()
								+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
						// ------------------------------------------------------------
					} else if (ObjectUtils.equals(approveStat,
							FormalStatEnum.atncleader_thirddeal)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_thirddeal;
						taskVariables.put("atncLeaderDistribute", "true");// 工作流（网控领导交办配置）
						formalCircuit
								.setTaskName(FormalStatEnum.engineer_secondaudit
										.getValue());
						// 记录选择的审核工程师
						String auditEngineer = queryModel.getAuditEngineer();
						applyBaseInfo.setNextUser(auditEngineer);
						formalCircuit
								.setApproveStat(FormalStatEnum.engineer_secondaudit);
						// 设置下一步操作信息（审批记录使用）
						User nextuser = userManager.findById(auditEngineer);
						nextusername = nextuser.getName();
						nextusertel = nextuser.getMobilephone();
						// --------------------------更新配置实体------------------------
						config.setAtncLeader(user.getName());
						formalCircuitConfManager.update(config);
						mss = "agree";
						msgn = "尊敬的用户:"
								+ userManager.findById(auditEngineer).getName()
								+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
						// ------------------------------------------------------------
					}
				} else { // 审批退回
					if (ObjectUtils.equals(approveStat,
							FormalStatEnum.atncleader_approve)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_approve;
						taskVariables.put("atncLeaderReviewPass", "false"); // 工作流（网控领导审核）
						formalCircuit
								.setTaskName(FormalStatEnum.engineer_firstaudit
										.getValue());
						applyBaseInfo.setNextUser(applyBaseInfo.getLastUser());
						formalCircuit
								.setApproveStat(FormalStatEnum.engineer_firstaudit);
						msgn = "尊敬的用户:"
								+ userManager.findById(
										applyBaseInfo.getLastUser()).getName()
								+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					}
					mss = "reject";
				}
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.engineer.name() + "|")) { // 工程师
				if (queryModel.isApproveStat()) {// 配置
					// 获取配置实体
					if (ObjectUtils.equals(approveStat,
							FormalStatEnum.engineer_firstaudit)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_firstaudit;
						taskVariables.put("engineerAuditComplete", "true"); // 工作流（工程师初审）
						applyBaseInfo.setLastUser(user.getId());
						formalCircuit
								.setTaskName(FormalStatEnum.atncleader_approve
										.getValue());
						formalCircuit
								.setApproveStat(FormalStatEnum.atncleader_approve);
						mss = "agree";
						rolestr = "atncLeader";
					} else if (ObjectUtils.equals(approveStat,
							FormalStatEnum.engineer_config)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_config;
						taskVariables.put("transfer", "false"); // 工作流（工程师配置）
						formalCircuit
								.setTaskName(FormalStatEnum.atncleader_thirddeal
										.getValue());
						applyBaseInfo.setLastUser(user.getId());
						applyBaseInfo
								.setLastStatusEnum(FormalStatEnum.engineer_config
										.name());
						formalCircuit
								.setApproveStat(FormalStatEnum.atncleader_thirddeal);
						// 设置下一步操作信息
						rolestr = "atncLeader";
						// --------------------------更新操作人------------------------
						config.setOperateUser(user.getName());
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
							FormalStatEnum.engineer_transfer)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_transfer;
						taskVariables.put("assistConfig", "true"); // 工作流（工程师协助配置）
						formalCircuit
								.setTaskName(FormalStatEnum.atncleader_thirddeal
										.getValue());
						applyBaseInfo.setLastUser(user.getId());
						applyBaseInfo
								.setLastStatusEnum(FormalStatEnum.engineer_transfer
										.name());
						formalCircuit
								.setApproveStat(FormalStatEnum.atncleader_thirddeal);
						// 设置下一步操作信息
						rolestr = "atncLeader";
						// --------------------------更新操作人------------------------
						config.setOperateUser(user.getName());
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
							FormalStatEnum.engineer_secondaudit)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_secondaudit;
						taskVariables.put("engineerAuditPass", "3"); // 工作流（工程师二次审核）
						formalCircuit.setTaskName(FormalStatEnum.unevaluate
								.getValue());
						formalCircuit.setApproveStat(FormalStatEnum.unevaluate);
						// --------------------------更新配置实体------------------------
						config.setConfigTime(Calendar.getInstance());
						config.setAuditUser(user.getName());
						msg = "尊敬的用户:"
								+ formalCircuit.getApplyBaseInfo()
										.getApplyLinkman() + ",您好！您有一条["
								+ applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					}
					formalCircuitConfManager.update(config);
					mss = "agree";
				} else {
					if (ObjectUtils.equals(approveStat,
							FormalStatEnum.engineer_config)) { // 移交其他工程师
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_config;
						taskVariables.put("transfer", "true"); // 工作流（工程师移交）
						formalCircuit
								.setTaskName(FormalStatEnum.engineer_transfer
										.getValue());
						String engineerId = queryModel.getEngineer();
						formalCircuit
								.setApproveStat(FormalStatEnum.engineer_transfer);
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
							FormalStatEnum.engineer_secondaudit)) { // 审核工程师退回
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_secondaudit;
						String lastUserId = applyBaseInfo.getLastUser();
						String lastStatus = applyBaseInfo.getLastStatusEnum();
						if (StringUtils.equalsIgnoreCase(lastStatus,
								FormalStatEnum.engineer_config.name())) {
							// 如果是正常工程师配置的，则退回给正常工程师
							taskVariables.put("engineerAuditPass", "1"); // 工作流（工程师审核未通过）
							formalCircuit
									.setApproveStat(FormalStatEnum.engineer_config);
							formalCircuit
									.setTaskName(FormalStatEnum.engineer_config
											.getValue());
						} else if (StringUtils.equalsIgnoreCase(lastStatus,
								FormalStatEnum.engineer_transfer.name())) {
							// 如果是移交工程师配置的，则退回给移交工程师
							taskVariables.put("engineerAuditPass", "2"); // 工作流（工程师审核未通过）
							formalCircuit
									.setApproveStat(FormalStatEnum.engineer_transfer);
							formalCircuit
									.setTaskName(FormalStatEnum.engineer_transfer
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
				if (queryModel.isApproveStat()) { // 审批通过
					if (ObjectUtils.equals(approveStat,
							FormalStatEnum.generalmanager_approve)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.manager.name());
						status = ApproveStatusEnum.generalmanager_approve;
						taskVariables.put("generalManagerPass", "true"); // 工作流（事业部经理审核）
						formalCircuit
								.setTaskName(FormalStatEnum.fundmanager_approve
										.getValue());
						formalCircuit
								.setApproveStat(FormalStatEnum.fundmanager_approve);
						// 生成正式的申请编号
						SerialNameEnum name = null;
						switch (formalCircuit.getApplyBaseInfo().getApplyType()) {
						case formalcircuit_atm:
							name = SerialNameEnum.DLPZ_ATM;
							break;
						case formalcircuit_tes:
							name = SerialNameEnum.DLPZ_C;
							break;
						case formalcircuit_ku:
							name = SerialNameEnum.DLPZ_KU;
							break;
						case formalcircuit_pes:
							name = SerialNameEnum.DLPZ_PES;
							break;
						default:
							break;
						}
						;
						SerialTypeEnum type = null;
						switch (formalCircuit.getApplyOpttype()) {
						case add:
							type = SerialTypeEnum.ADD;
							break;
						case del:
							type = SerialTypeEnum.DEL;
							break;
						case mod:
							type = SerialTypeEnum.MOD;
							break;
						default:
							break;
						}
						;
						applyBaseInfo.setSerialNumber(applySerialService
								.createSerialNumber(name, type));
						applyBaseInfo.setLeaderCheckFlag(true);
						mss = "consent";
						rolestr = "fundmanager";
					}
				} else {
					if (ObjectUtils.equals(approveStat,
							FormalStatEnum.generalmanager_approve)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.manager.name());
						status = ApproveStatusEnum.generalmanager_approve;
						taskVariables.put("generalManagerPass", "true"); // 工作流（事业部经理审核）
						formalCircuit
								.setTaskName(FormalStatEnum.fundmanager_approve
										.getValue());
						formalCircuit
								.setApproveStat(FormalStatEnum.fundmanager_approve);
						applyBaseInfo.setLeaderCheckFlag(false);
						mss = "disconsent";
						rolestr = "fundmanager";
					}
				}
				formalCircuit.setAtncOpinion(queryModel.getApproveRemark());
				formalCircuit.setAtncSign(user.getName());
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.fundmanager.name() + "|")) {// 财务部经理
				if (ObjectUtils.equals(approveStat,
						FormalStatEnum.fundmanager_approve)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.fundmanager.name());
					status = ApproveStatusEnum.fundmanager_approve;
					formalCircuit.setCachetApprove(Integer.valueOf(1));
					if (applyBaseInfo.getLeaderCheckFlag()) {
						taskVariables.put("fundManagerConfirm", "true"); // 工作流（财务部经理审核）
						formalCircuit.setTaskName(FormalStatEnum.csstaff_deal
								.getValue());
						formalCircuit
								.setApproveStat(FormalStatEnum.csstaff_deal);
						mss = "confirm";
						rolestr = "csStaff";
					} else {
						taskVariables.put("fundManagerConfirm", "false"); // 工作流（事业部经理审核）
						queryModel.setApproveStat(false);
						// formalCircuit.setTaskName("事业部总经理退回");
						// 申请人所在管局
						Bureau bureau = formalCircuit.getApplyBaseInfo()
								.getApplyUser().getBureau();
						if (!ObjectUtils.equals(bureau, null)) {
							bureau = Bureau.isBelong7Bureau(bureau.getValue());
						}
						if (!ObjectUtils.equals(bureau, null)) { // 申请人属于7大管局
							taskVariables
									.put("needAreaExaminerConfirm", "true");
							formalCircuit
									.setTaskName(FormalStatEnum.areaexaminer_affirm
											.getValue());
							formalCircuit
									.setApproveStat(FormalStatEnum.areaexaminer_affirm);
							msg = "尊敬的用户:"
									+ formalCircuit.getApplyBaseInfo()
											.getInitLinkman()
									+ ",您好！您有一条["
									+ applyBaseInfo.getApplyType()
									+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
						} else {
							taskVariables.put("needAreaExaminerConfirm",
									"false");
							formalCircuit.setTaskName(FormalStatEnum.returned
									.getValue());
							formalCircuit
									.setApproveStat(FormalStatEnum.returned);
							msg = "尊敬的用户:"
									+ formalCircuit.getApplyBaseInfo()
											.getApplyLinkman()
									+ ",您好！您有一条["
									+ applyBaseInfo.getApplyType()
									+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
						}
						// 审批退回后，重置发送短信标识，下次前台提交时，可以给后台发送短信
						applyBaseInfo.setSendmessageFlag(false);
						mss = "confirm";
						// 保存申请表
						int number = approveInfoService
								.getReturnedApplyNumber(applyBaseInfo.getId());
						if (ObjectUtils.equals(formalCircuit.getApplyBaseInfo()
								.getApplyType(),
								ApplyTypeEnum.formalcircuit_atm)) {
							this.getReportParams(request,
									formalCircuit.getId(),
									JasperReportsEnum.ATM.toString());
							absoluteAddress = JasperReportUtils
									.saveReturedApplyList(number,
											applyBaseInfo.getId(), request,
											JasperReportsEnum.ATM.name());
						} else if (ObjectUtils.equals(formalCircuit
								.getApplyBaseInfo().getApplyType(),
								ApplyTypeEnum.formalcircuit_ku)) {
							this.getReportParams(request,
									formalCircuit.getId(),
									JasperReportsEnum.KU.toString());
							absoluteAddress = JasperReportUtils
									.saveReturedApplyList(number,
											applyBaseInfo.getId(), request,
											JasperReportsEnum.KU.name());
						} else if (ObjectUtils.equals(formalCircuit
								.getApplyBaseInfo().getApplyType(),
								ApplyTypeEnum.formalcircuit_tes)) {
							this.getReportParams(request,
									formalCircuit.getId(),
									JasperReportsEnum.TES.toString());
							absoluteAddress = JasperReportUtils
									.saveReturedApplyList(number,
											applyBaseInfo.getId(), request,
											JasperReportsEnum.TES.name());
						} else if (ObjectUtils.equals(formalCircuit
								.getApplyBaseInfo().getApplyType(),
								ApplyTypeEnum.formalcircuit_pes)) {
							this.getReportParams(request,
									formalCircuit.getId(),
									JasperReportsEnum.PES.toString());
							absoluteAddress = JasperReportUtils
									.saveReturedApplyList(number,
											applyBaseInfo.getId(), request,
											JasperReportsEnum.PES.name());
						}
					}
				}
			}
			// 添加审核人
			applyBaseInfo
					.setApproveUsers(applyBaseInfo.getApproveUsers() == null ? user
							.getName() : applyBaseInfo.getApproveUsers() + ","
							+ user.getName());
			applyBaseInfoDao.update(applyBaseInfo); // 更新申请基础信息表
			formalCircuitDao.update(formalCircuit); // 更新转报地址申请表
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
					&& !StringUtils.isEmpty(formalCircuit.getApplyBaseInfo()
							.getApplyPhone())) {
				BaseUserInfo baseUserInfo = new BaseUserInfo();
				if (formalCircuit.getApproveStat().equals(
						FormalStatEnum.areaexaminer_affirm)) {
					baseUserInfo.setLoginName(formalCircuit.getApplyBaseInfo()
							.getInitLinkman());
					baseUserInfo.setMobilephone(formalCircuit
							.getApplyBaseInfo().getInitLinkphone());
				} else {
					baseUserInfo.setLoginName(formalCircuit.getApplyBaseInfo()
							.getApplyLinkman());
					baseUserInfo.setMobilephone(formalCircuit
							.getApplyBaseInfo().getApplyPhone());
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
			return formalCircuit;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("处理表单信息出错，原因是：" + e.getMessage());
		}
	}

	@Override
	public FormalCircuitQueryModel setModel(FormalCircuitQueryModel queryModel) {

		queryModel.setFlag(true);
		queryModel.setApplyDate(queryModel.getFormalCircuit()
				.getApplyBaseInfo().getApplyDate());
		return queryModel;
	}

	@Override
	public FormalCircuitQueryModel getViewModel(ApplyBaseInfo applyBaseInfo) {
		FormalCircuit formalCircuit = this.findByApplyBaseInfo(applyBaseInfo);
		FormalCircuitQueryModel FCModel = this.getCheckModel(formalCircuit
				.getId());
		return FCModel;
	}

	private FormalCircuit findByApplyBaseInfo(ApplyBaseInfo applyBaseInfo) {
		return formalCircuitDao.findByApplyBaseInfo(applyBaseInfo).get(0);
	}

	@Override
	public FormalCircuit findByApplyBaseInfo(String id) {
		ApplyBaseInfo applyBaseInfo = applyBaseInfoDao.findById(id);
		FormalCircuit formalCircuit = this.findByApplyBaseInfo(applyBaseInfo);
		return formalCircuit;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map<String, Object> getReportParams(HttpServletRequest request,
			String id, String reportName) {
		// 获取报表相关参数
		Map<String, Object> param = null;
		FormalCircuit formalCircuit = this.findById(id);
		// 数据源
		List<FormalCircuitBaseInfoEntity> entity = null;
		List<FormalCircuitBaseInfoEntity> datasource = null;
		List subreportDatasource = null;
		if (StringUtils.equalsIgnoreCase(reportName,
				JasperReportsEnum.TES.toString())
				|| StringUtils.equalsIgnoreCase(reportName,
						JasperReportsEnum.TES_config.toString())) {
			// 1.主报表数据源
			if (StringUtils.equalsIgnoreCase(reportName,
					JasperReportsEnum.TES.toString())) {
				entity = jasperReportService.getTESDatasource(id);
			} else {
				entity = jasperReportService.getTESConfigDatasource(id);
			}
			datasource = (List<FormalCircuitBaseInfoEntity>) DataSourceFactory
					.getBeanCollection(entity);
			// 2.子报表数据源
			subreportDatasource = entity.get(0).getTes();
			if (subreportDatasource.size() < 4) {
				for (int i = subreportDatasource.size(); i < 4; i++) {
					subreportDatasource.add(new TESFormalCircuitEntity());
				}
			}
		} else if (StringUtils.equalsIgnoreCase(reportName,
				JasperReportsEnum.PES.toString())
				|| StringUtils.equalsIgnoreCase(reportName,
						JasperReportsEnum.PES_config.toString())) {
			// 1.主报表数据源
			if (StringUtils.equalsIgnoreCase(reportName,
					JasperReportsEnum.PES.toString())) {
				entity = jasperReportService.getPESDatasource(id);
			} else {
				entity = jasperReportService.getPESConfigDatasource(id);
			}
			datasource = (List<FormalCircuitBaseInfoEntity>) DataSourceFactory
					.getBeanCollection(entity);
			// 2.子报表数据源
			subreportDatasource = entity.get(0).getPes();
			if (subreportDatasource.size() < 4) {
				for (int i = subreportDatasource.size(); i < 4; i++) {
					subreportDatasource.add(new PESFormalCircuitEntity());
				}
			}
		} else if (StringUtils.equalsIgnoreCase(reportName,
				JasperReportsEnum.ATM.toString())
				|| StringUtils.equalsIgnoreCase(reportName,
						JasperReportsEnum.ATM_config.toString())) {
			// 1.主报表数据源
			if (StringUtils.equalsIgnoreCase(reportName,
					JasperReportsEnum.ATM.toString())) {
				entity = jasperReportService.getATMDatasource(id);
			} else {
				entity = jasperReportService.getATMConfigDatasource(id);
			}
			datasource = (List<FormalCircuitBaseInfoEntity>) DataSourceFactory
					.getBeanCollection(entity);
			// 2.子报表数据源
			subreportDatasource = entity.get(0).getAtm();
			if (subreportDatasource.size() < 4) {
				for (int i = subreportDatasource.size(); i < 4; i++) {
					subreportDatasource.add(new ATMFormalCircuitEntity());
				}
			}
		} else if (StringUtils.equalsIgnoreCase(reportName,
				JasperReportsEnum.KU.toString())
				|| StringUtils.equalsIgnoreCase(reportName,
						JasperReportsEnum.KU_config.toString())) {
			// 1.主报表数据源
			if (StringUtils.equalsIgnoreCase(reportName,
					JasperReportsEnum.KU.toString())) {
				entity = jasperReportService.getKUDatasource(id);
			} else {
				entity = jasperReportService.getKUConfigDatasource(id);
			}
			datasource = (List<FormalCircuitBaseInfoEntity>) DataSourceFactory
					.getBeanCollection(entity);
			// 2.子报表数据源
			subreportDatasource = entity.get(0).getKu();
			if (subreportDatasource.size() < 4) {
				for (int i = subreportDatasource.size(); i < 4; i++) {
					subreportDatasource.add(new KUFormalCircuitEntity());
				}
			}
		}
		// 判断用印审批为是否为true，如果是，则显示公章，否则不显示。
		if (formalCircuit.getCachetApprove() == 0) {
			param = jasperReportService.preView(request, datasource,
					subreportDatasource, reportName);
		} else {
			param = jasperReportService.preView(request, datasource,
					subreportDatasource, ImageNameEnum.atncCachet.getValue(),
					reportName);
		}
		return param;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitManager#getListSendMessage()
	 */
	@Override
	public List<FormalCircuit> getListSendMessage() {
		return formalCircuitDao.getListSendMessage();
	}
}
