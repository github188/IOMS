/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName KuSatelliteServiceImpl.java
 * @PackageName:cn.com.atnc.pcsp.mng.business.satellite.impl
 * @author ku
 * @date 2015年5月13日下午4:04:00
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.business.telegraph.impl;

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
import cn.com.atnc.ioms.dao.business.telegraph.TeleGraphCircuitDao;
import cn.com.atnc.ioms.entity.BaseUserInfo;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.approveinfo.ApproveInfo;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraph;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphCircuit;
import cn.com.atnc.ioms.entity.reports.TeleGraphBaseInfoEntity;
import cn.com.atnc.ioms.entity.reports.TeleGraphCircuitEntity;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveStatusEnum;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveTypeEnum;
import cn.com.atnc.ioms.enums.business.serial.SerialNameEnum;
import cn.com.atnc.ioms.enums.business.serial.SerialTypeEnum;
import cn.com.atnc.ioms.enums.business.telegraph.TeleGraphApproveStatEnum;
import cn.com.atnc.ioms.enums.reports.ImageNameEnum;
import cn.com.atnc.ioms.enums.reports.JasperReportsEnum;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.acl.IUserRoleManager;
import cn.com.atnc.ioms.mng.business.approveinfo.IApproveInfoService;
import cn.com.atnc.ioms.mng.business.baseinfo.IApplyBaseInfoService;
import cn.com.atnc.ioms.mng.business.evaluete.IEvalueteManager;
import cn.com.atnc.ioms.mng.business.serial.IApplySerialService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphCircuitService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphCircuitWorkflowService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphService;
import cn.com.atnc.ioms.mng.clientnotice.IClientNoticeManager;
import cn.com.atnc.ioms.mng.reports.JasperReportService;
import cn.com.atnc.ioms.model.business.telegraph.TeleGraphQueryModel;
import cn.com.atnc.ioms.util.DataSourceFactory;
import cn.com.atnc.ioms.util.JasperReportUtils;

/**
 * 民航转报网转报电路申请Service接口
 * 
 * @author WangLingbin
 * @date 2015年10月19日 上午8:51:06
 * @since 1.0.0
 */
@Service
@Transactional
public class TeleGraphCircuitServiceImpl extends BaseService implements
		TeleGraphCircuitService {

	@Autowired
	private TeleGraphCircuitDao teleGraphCircuitDao;
	@Autowired
	private IApproveInfoService approveInfoService;
	@Autowired
	private IEvalueteManager applyEvaluateService;
	@Autowired
	private IApplyBaseInfoService applyBaseInfoService;
	@Autowired
	private TeleGraphService teleGraphService;
	@Autowired
	private TeleGraphCircuitWorkflowService workflowService;
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
	public Pagination queryPageByModel(TeleGraphQueryModel queryModel) {
		return teleGraphCircuitDao.queryPageByModel(queryModel);
	}

	@Override
	public List<TeleGraphCircuit> getAll() {
		return teleGraphCircuitDao.getAll();
	}

	@Override
	public void save(TeleGraphCircuit teleGraphCircuit) {
		teleGraphCircuitDao.save(teleGraphCircuit);
	}

	@Override
	public TeleGraphCircuit getTeleGraphCircuitById(String id) {
		return teleGraphCircuitDao.findById(id);
	}

	@Override
	public void update(TeleGraphCircuit teleGraphApply) {
		teleGraphCircuitDao.update(teleGraphApply);
	}

	@Override
	public void delete(TeleGraphCircuit teleGraphCircuit) {
		teleGraphCircuitDao.delete(teleGraphCircuit);
	}

	@Override
	public List<TeleGraphCircuit> getCircuitsByParentId(String id) {
		return teleGraphCircuitDao.getCircuitsByParentId(id);
	}

	@Override
	public TeleGraph dealForm(HttpServletRequest request,TeleGraphQueryModel queryModel, User user) {
		try {
			// 工作流相关
			Task task = workflowService.getTaskByProcessInstaceId(queryModel
					.getPid());
			Map<String, Object> taskVariables = new HashMap<String, Object>();
			// 根据ID获取转报地址对象
			TeleGraph teleGraph = teleGraphService.getTeleGraphById(queryModel
					.getId());
			ApplyBaseInfo applyBaseInfo = teleGraph.getApplyBaseInfo();
			// 根据角色名称来更新申请审批状态
			userRoleManager.reSetRoles(user);
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
			// 工作流流程
			TeleGraphApproveStatEnum approveStat = teleGraph.getApproveStat(); // 任务状态
			if (roleNames.toString().contains(
					"|" + RoleEnum.csLeader.name() + "|")) { // 客服领导
				if (ObjectUtils.equals(approveStat,
						TeleGraphApproveStatEnum.csleader_review)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.csLeader.name());
					status = ApproveStatusEnum.csleader_approve;
					if (queryModel.isApproveStat()) { // 审批通过
						taskVariables.put("csLeaderReviewPass", "3"); // 工作流（客服领导通过）
						teleGraph
								.setTaskName(TeleGraphApproveStatEnum.generalmanager_approve
										.getValue());
						teleGraph
								.setApproveStat(TeleGraphApproveStatEnum.generalmanager_approve);
						if (!ObjectUtils.equals(queryModel.isAgreeStat(), null)) {
							if (queryModel.isAgreeStat()) {
								mss = "consent";
							} else {
								mss = "disconsent";
							}
						} else {
							mss = "agree";
						}
						rolestr = "manager";
					} else { // 审批退回
						String backUser = queryModel.getBackUser();
						if (StringUtils.equalsIgnoreCase(backUser, "退回客服")) {
							taskVariables.put("csLeaderReviewPass", "1"); // 工作流（退回客服）
							// 取出分配的客服专员ID做为下一步的操作人ID
							applyBaseInfo.setNextUser(applyBaseInfo
									.getAuditUser());
							teleGraph
									.setTaskName(TeleGraphApproveStatEnum.csstaff_audit
											.getValue());
							teleGraph
									.setApproveStat(TeleGraphApproveStatEnum.csstaff_audit);
							rolestr = "csStaff";
						} else if (StringUtils.equalsIgnoreCase(backUser, "退回网控")){
							taskVariables.put("csLeaderReviewPass", "2"); // 工作流（退回网控）
							teleGraph
									.setTaskName(TeleGraphApproveStatEnum.atncleader_firstdeal
											.getValue());
							teleGraph
									.setApproveStat(TeleGraphApproveStatEnum.atncleader_firstdeal);
							rolestr = "atncLeader";
						}else if (StringUtils.equalsIgnoreCase(backUser, "用印审批")){
							taskVariables.put("csLeaderReviewPass", "4"); // 工作流（退回申请用户）
							teleGraph
									.setTaskName(TeleGraphApproveStatEnum.fundmanager_confirm
											.getValue());
							teleGraph
									.setApproveStat(TeleGraphApproveStatEnum.fundmanager_confirm);
							rolestr = "fundmanager";
							applyBaseInfo.setLeaderCheckFlag(false);
						}
						mss = "reject";
					}
					teleGraph.setAtncOpition(queryModel.getApproveRemark());
					teleGraph.setAtncSign(user.getName());
				}
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.csStaff.name() + "|")) { // 客服专员
				if (ObjectUtils.equals(approveStat,
						TeleGraphApproveStatEnum.csstaff_audit)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.csStaff.name());
					status = ApproveStatusEnum.csstaff_firstdeal;
					taskVariables.put("csStaffReviewComplete", true); // 工作流（客服专员审核）
					teleGraph
							.setTaskName(TeleGraphApproveStatEnum.csleader_review
									.getValue());
					teleGraph
							.setApproveStat(TeleGraphApproveStatEnum.csleader_review);
					// 记录审核该条转报申请的客服专员
					String csStaff = user.getId();
					applyBaseInfo.setAuditUser(csStaff);
					rolestr = "csLeader";
				} else if (ObjectUtils.equals(approveStat,
						TeleGraphApproveStatEnum.csstaff_deal)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.csStaff.name());
					status = ApproveStatusEnum.csstaff_deal;
					taskVariables.put("csStaffPass", true); // 工作流（客服专员办理）
					teleGraph
							.setTaskName(TeleGraphApproveStatEnum.atncleader_approve
									.getValue());
					teleGraph
							.setApproveStat(TeleGraphApproveStatEnum.atncleader_approve);
					// 保存客服专员选择的协同阅知的管局
					String bureau = queryModel.getBureau();
					if (StringUtils.isNotEmpty(bureau)) {
						applyBaseInfo.setCandidate(bureau);
					}
					rolestr = "atncLeader";
				}
				// 保存联系人和联系电话
				applyBaseInfo.setFinalLinkman(user.getName());
				applyBaseInfo.setFinalLinkphone(user.getMobilephone());
				mss = "agree";
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.manager.name() + "|")) {
				if (ObjectUtils.equals(approveStat,
						TeleGraphApproveStatEnum.generalmanager_approve)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.manager.name());
					status = ApproveStatusEnum.generalmanager_approve;
					// 保存领导审批结果
					applyBaseInfo
							.setLeaderCheckFlag(queryModel.isApproveStat());
					if (queryModel.isApproveStat()) { // 审批通过 —— 生成正式申请编号
						// 生成正式的申请编号
						SerialTypeEnum type = null;
						switch (teleGraph.getTeleApplyType()) {
						case create:
							type = SerialTypeEnum.ADD;
							break;
						case cancel:
							type = SerialTypeEnum.DEL;
							break;
						case modify:
							type = SerialTypeEnum.MOD;
							break;
						}
						applyBaseInfo.setSerialNumber(applySerialService
								.createSerialNumber(SerialNameEnum.DLPZ_ZJDL,
										type));
						mss = "consent";
					} else {
						mss = "disconsent";
					}
					rolestr = "fundmanager";
					taskVariables.put("generalManagerPass", true); // 工作流（事业部总经理通过）
					teleGraph
							.setTaskName(TeleGraphApproveStatEnum.fundmanager_confirm
									.getValue());
					teleGraph
							.setApproveStat(TeleGraphApproveStatEnum.fundmanager_confirm);

					teleGraph.setAtncOpition(queryModel.getApproveRemark());
					teleGraph.setAtncSign(user.getName());
				}
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.fundmanager.name() + "|")) {
				if (ObjectUtils.equals(approveStat,
						TeleGraphApproveStatEnum.fundmanager_confirm)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.fundmanager.name());
					status = ApproveStatusEnum.fundmanager_approve;
					teleGraph.setCachetApprove(1); // 用印通过
					// 判断了领导审批是否通过，通过继续，否则退回给用户
					if (applyBaseInfo.getLeaderCheckFlag()) {
						// 通过
						taskVariables.put("fundManagerConfirm", true); // 工作流（事业部总经理通过）
						teleGraph
								.setTaskName(TeleGraphApproveStatEnum.csstaff_deal
										.getValue());
						teleGraph
								.setApproveStat(TeleGraphApproveStatEnum.csstaff_deal);
						rolestr = "csStaff";
					} else {
						taskVariables.put("fundManagerConfirm", false); // 工作流（事业部总经理退回）
						// 申请人所在管局
						Bureau bureau = teleGraph.getApplyBaseInfo()
								.getApplyUser().getBureau();
						if (!ObjectUtils.equals(bureau, null)) {
							bureau = Bureau.isBelong7Bureau(bureau.getValue());
						}
						if (!ObjectUtils.equals(bureau, null)) { // 申请人属于7大管局
							teleGraph
									.setTaskName(TeleGraphApproveStatEnum.areaexaminer_confirm
											.getValue());
							taskVariables.put("needAreaExaminerConfirm", true);
							teleGraph
									.setApproveStat(TeleGraphApproveStatEnum.areaexaminer_confirm);
							msg = "尊敬的用户:"
									+ teleGraph.getApplyBaseInfo()
											.getInitLinkman()
									+ ",您好！您有一条["
									+ applyBaseInfo.getApplyType()
									+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
						} else {
							teleGraph
									.setTaskName(TeleGraphApproveStatEnum.returned
											.getValue());
							taskVariables.put("needAreaExaminerConfirm", false);
							teleGraph
									.setApproveStat(TeleGraphApproveStatEnum.returned);
							msg = "尊敬的用户:"
									+ teleGraph.getApplyBaseInfo()
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
						this.getReportParams(request, teleGraph.getId(),
								JasperReportsEnum.telegraph_circuit.toString());
						absoluteAddress = JasperReportUtils
								.saveReturedApplyList(number, applyBaseInfo
										.getId(), request,
										JasperReportsEnum.telegraph_circuit
												.name());
					}
				}
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.atncLeader.name() + "|")) { // 网控领导
				if (queryModel.isApproveStat()) { // 审批通过 —— 选择移交的工程师
					if (ObjectUtils.equals(approveStat,
							TeleGraphApproveStatEnum.atncleader_firstdeal)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_firstdeal;
						taskVariables.put("atncLeaderDistribute", "true");// 工作流（网控领导交办审核）
						teleGraph
								.setTaskName(TeleGraphApproveStatEnum.engineer_firstaudit
										.getValue());
						// 记录选择的审核工程师，工程师审核时使用
						String auditEngineer = queryModel.getAuditEngineer();
						applyBaseInfo.setNextUser(auditEngineer);
						teleGraph
								.setApproveStat(TeleGraphApproveStatEnum.engineer_firstaudit);
						// 设置下一步操作信息（审批记录使用）
						User nextuser = userManager.findById(auditEngineer);
						nextusername = nextuser.getName();
						nextusertel = nextuser.getMobilephone();
						mss = "agree";
						msgn = "尊敬的用户:"
								+ userManager.findById(
										queryModel.getAuditEngineer())
										.getName() + ",您好！您有一条["
								+ applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					} else if (ObjectUtils.equals(approveStat,
							TeleGraphApproveStatEnum.atncleader_review)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_approve;
						taskVariables.put("atncLeaderReviewPass", true); // 工作流（网控领导审核）
						teleGraph
								.setTaskName(TeleGraphApproveStatEnum.csstaff_audit
										.getValue());
						teleGraph
								.setApproveStat(TeleGraphApproveStatEnum.csstaff_audit);
						if (!ObjectUtils.equals(queryModel.isAgreeStat(), null)) {
							if (queryModel.isAgreeStat()) {
								mss = "consent";
							} else {
								mss = "disconsent";
							}
						} else {
							mss = "agree";
						}
						rolestr = "csStaff";
					} else if (ObjectUtils.equals(approveStat,
							TeleGraphApproveStatEnum.atncleader_approve)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_seconddeal;
						taskVariables.put("atncLeaderDistribute", true);// 工作流（网控领导交办配置）
						teleGraph
								.setTaskName(TeleGraphApproveStatEnum.engineer_config
										.getValue());
						// 记录选择的配置工程师
						String engineerId = queryModel.getEngineer();
						applyBaseInfo.setNextUser(engineerId);
						teleGraph
								.setApproveStat(TeleGraphApproveStatEnum.engineer_config);
						// 设置下一步操作信息（审批记录使用）
						User nextuser = userManager.findById(engineerId);
						nextusername = nextuser.getName();
						nextusertel = nextuser.getMobilephone();
						mss = "agree";
						msgn = "尊敬的用户:"
								+ userManager.findById(engineerId).getName()
								+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					} else if (ObjectUtils.equals(approveStat,
							TeleGraphApproveStatEnum.atncleader_audit)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_thirddeal;
						taskVariables.put("atncLeaderDistribute", true);// 工作流（网控领导交办配置）
						teleGraph
								.setTaskName(TeleGraphApproveStatEnum.engineer_audit
										.getValue());
						// 记录选择的审核工程师
						String auditEngineer = queryModel.getAuditEngineer();
						applyBaseInfo.setNextUser(auditEngineer);
						teleGraph
								.setApproveStat(TeleGraphApproveStatEnum.engineer_audit);
						// 设置下一步操作信息（审批记录使用）
						User nextuser = userManager.findById(auditEngineer);
						nextusername = nextuser.getName();
						nextusertel = nextuser.getMobilephone();
						mss = "agree";
						msgn = "尊敬的用户:"
								+ userManager.findById(auditEngineer).getName()
								+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					}
				} else { // 审批退回
					if (ObjectUtils.equals(approveStat,
							TeleGraphApproveStatEnum.atncleader_review)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_approve;
						taskVariables.put("atncLeaderReviewPass", false); // 工作流（网控领导审核）
						teleGraph
								.setTaskName(TeleGraphApproveStatEnum.engineer_firstaudit
										.getValue());
						applyBaseInfo.setNextUser(applyBaseInfo.getLastUser());
						teleGraph
								.setApproveStat(TeleGraphApproveStatEnum.engineer_firstaudit);
						msgn = "尊敬的用户:"
								+ userManager.findById(
										applyBaseInfo.getLastUser()).getName()
								+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					}
					mss = "reject";
				}
				teleGraph.setAtncOpition(queryModel.getApproveRemark());
				teleGraph.setAtncSign(user.getName());
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.engineer.name() + "|")) { // 工程师
				if (queryModel.isApproveStat()) {// 配置
					if (ObjectUtils.equals(approveStat,
							TeleGraphApproveStatEnum.engineer_firstaudit)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_firstaudit;
						taskVariables.put("engineerAuditComplete", true); // 工作流（工程师初审）
						teleGraph
								.setTaskName(TeleGraphApproveStatEnum.atncleader_review
										.getValue());
						applyBaseInfo.setLastUser(user.getId());
						teleGraph
								.setApproveStat(TeleGraphApproveStatEnum.atncleader_review);
						rolestr = "atncLeader";
					} else if (ObjectUtils.equals(approveStat,
							TeleGraphApproveStatEnum.engineer_config)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_config;
						taskVariables.put("transfer", false); // 工作流（工程师配置）
						teleGraph
								.setTaskName(TeleGraphApproveStatEnum.atncleader_audit
										.getValue());
						applyBaseInfo.setLastUser(user.getId());
						applyBaseInfo
								.setLastStatusEnum(TeleGraphApproveStatEnum.engineer_config
										.name());
						teleGraph
								.setApproveStat(TeleGraphApproveStatEnum.atncleader_audit);
						// 设置下一步操作信息
						rolestr = "atncLeader";
					} else if (ObjectUtils.equals(approveStat,
							TeleGraphApproveStatEnum.assist_config)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_transfer;
						taskVariables.put("assistConfig", true); // 工作流（工程师协助配置）
						teleGraph
								.setTaskName(TeleGraphApproveStatEnum.atncleader_audit
										.getValue());
						applyBaseInfo.setLastUser(user.getId());
						applyBaseInfo
								.setLastStatusEnum(TeleGraphApproveStatEnum.assist_config
										.name());
						teleGraph
								.setApproveStat(TeleGraphApproveStatEnum.atncleader_audit);
						// 设置下一步操作信息（审批记录使用）
						rolestr = "atncLeader";
					} else if (ObjectUtils.equals(approveStat,
							TeleGraphApproveStatEnum.engineer_audit)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_secondaudit;
						taskVariables.put("engineerAuditPass", 3); // 工作流（工程师审核）
						teleGraph
								.setTaskName(TeleGraphApproveStatEnum.local_evaluate
										.getValue());
						applyBaseInfo.setNextUser(applyBaseInfo.getLastUser()); // 设置下一步操作人
						teleGraph
								.setApproveStat(TeleGraphApproveStatEnum.local_evaluate);
						msg = "尊敬的用户:"
								+ teleGraph.getApplyBaseInfo()
										.getApplyLinkman() + ",您好！您有一条["
								+ applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					}
					mss = "agree";
				} else {
					if (ObjectUtils.equals(approveStat,
							TeleGraphApproveStatEnum.engineer_config)) { // 移交其他工程师
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_config;
						taskVariables.put("transfer", true); // 工作流（工程师移交）
						teleGraph
								.setTaskName(TeleGraphApproveStatEnum.assist_config
										.getValue());
						String engineerId = queryModel.getEngineer();
						teleGraph
								.setApproveStat(TeleGraphApproveStatEnum.assist_config);
						applyBaseInfo.setNextUser(engineerId);
						// 设置下一步操作信息（审批记录使用）
						User nextuser = userManager.findById(engineerId);
						nextusername = nextuser.getName();
						nextusertel = nextuser.getMobilephone();
						msgn = "尊敬的用户:"
								+ userManager.findById(engineerId).getName()
								+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					} else if (ObjectUtils.equals(approveStat,
							TeleGraphApproveStatEnum.engineer_audit)) { // 审核工程师退回
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_secondaudit;
						String lastUserId = applyBaseInfo.getLastUser();
						String lastStatus = applyBaseInfo.getLastStatusEnum();
						if (StringUtils
								.equalsIgnoreCase(
										lastStatus,
										TeleGraphApproveStatEnum.engineer_config
												.name())) {
							// 如果是正常工程师配置的，则退回给正常工程师
							taskVariables.put("engineerAuditPass", 1); // 工作流（工程师审核未通过）
							teleGraph
									.setApproveStat(TeleGraphApproveStatEnum.engineer_config);
							teleGraph
									.setTaskName(TeleGraphApproveStatEnum.engineer_config
											.getValue());
						} else if (StringUtils.equalsIgnoreCase(lastStatus,
								TeleGraphApproveStatEnum.assist_config.name())) {
							// 如果是移交工程师配置的，则退回给移交工程师
							taskVariables.put("engineerAuditPass", 2); // 工作流（工程师审核未通过）
							teleGraph
									.setApproveStat(TeleGraphApproveStatEnum.assist_config);
							teleGraph
									.setTaskName(TeleGraphApproveStatEnum.assist_config
											.getValue());
						}
						applyBaseInfo.setNextUser(lastUserId);
						msgn = "尊敬的用户:"
								+ userManager.findById(lastUserId).getName()
								+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					}
				}
			}
			//添加审核人
			applyBaseInfo.setApproveUsers(applyBaseInfo.getApproveUsers() == null ? user.getName() 
					: applyBaseInfo.getApproveUsers() + "," + user.getName());
			applyBaseInfoService.update(applyBaseInfo); // 更新申请基础信息表
			teleGraphService.update(teleGraph); // 更新转报地址申请表
			// 添加审批记录
			ApproveInfo approveInfo = new ApproveInfo(user, applyBaseInfo,
					queryModel.getApproveRemark(), queryModel.isApproveStat());
			approveInfo.setNextUserName(nextusername);
			approveInfo.setNextUserTel(nextusertel);
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
			approveInfo.setApproveStatus(status);
			approveInfoService.save(approveInfo);
			// 发送短信
			if (!StringUtils.isEmpty(msg)
					&& !StringUtils.isEmpty(teleGraph.getApplyBaseInfo()
							.getApplyPhone())) {
				BaseUserInfo baseUserInfo = new BaseUserInfo();
				if (teleGraph.getApproveStat().equals(
						TeleGraphApproveStatEnum.areaexaminer_confirm)) {
					baseUserInfo.setLoginName(teleGraph.getApplyBaseInfo()
							.getInitLinkman());
					baseUserInfo.setMobilephone(teleGraph.getApplyBaseInfo()
							.getInitLinkphone());
				} else {
					baseUserInfo.setLoginName(teleGraph.getApplyBaseInfo()
							.getApplyLinkman());
					baseUserInfo.setMobilephone(teleGraph.getApplyBaseInfo()
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
			return teleGraph;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("处理表单信息出错，原因是：" + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getReportParams(HttpServletRequest request,
			String id, String reportName) {
		// 1.主报表数据源
		List<TeleGraphBaseInfoEntity> entity = jasperReportService
				.getCircuitsDatasource(id);//
		List<TeleGraph> datasource = (List<TeleGraph>) DataSourceFactory
				.getBeanCollection(entity);//
		// 2.子报表数据源
		List<TeleGraphCircuitEntity> subreportDatasource = entity.get(0)
				.getCircuits();//
		if (subreportDatasource.size() < 4) {
			for (int i = subreportDatasource.size(); i < 4; i++) {
				subreportDatasource.add(new TeleGraphCircuitEntity());
			}
		}
		// 3.获取报表相关参数，供预览使用
		Map<String, Object> param = null;
		TeleGraph teleGraph = teleGraphService.getTeleGraphById(id);
		// 判断用印审批为是否为true，如果是，则显示公章，否则不显示。
		if (teleGraph.getCachetApprove() == 0) {
			param = jasperReportService.preView(request, datasource,
					subreportDatasource, reportName);//
		} else {
			param = jasperReportService.preView(request, datasource,
					subreportDatasource, ImageNameEnum.atncCachet.getValue(),
					reportName);
		}
		return param;
	}

	@Override
	public List<TeleGraphCircuit> getListSendMessage() {
		// TODO Auto-generated method stub
		return teleGraphCircuitDao.getListSendMessage();
	}
}
