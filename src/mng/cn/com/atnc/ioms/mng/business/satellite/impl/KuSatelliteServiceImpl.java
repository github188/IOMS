/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName KuSatelliteServiceImpl.java
 * @PackageName:cn.com.atnc.pcsp.mng.business.satellite.impl
 * @author ku
 * @date 2015年5月13日下午4:04:00
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.business.satellite.impl;

import java.util.ArrayList;
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
import cn.com.atnc.ioms.dao.business.satellite.IKuSatelliteDao;
import cn.com.atnc.ioms.entity.BaseUserInfo;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.approveinfo.ApproveInfo;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.satellite.KuSatellite;
import cn.com.atnc.ioms.entity.business.satellite.KuSatelliteAttach;
import cn.com.atnc.ioms.entity.business.satellite.KuSatelliteConfig;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveStatusEnum;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveTypeEnum;
import cn.com.atnc.ioms.enums.business.satellite.ApproveStatEnum;
import cn.com.atnc.ioms.enums.business.serial.SerialNameEnum;
import cn.com.atnc.ioms.enums.business.serial.SerialTypeEnum;
import cn.com.atnc.ioms.enums.reports.ImageNameEnum;
import cn.com.atnc.ioms.enums.reports.JasperReportsEnum;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.acl.IUserRoleManager;
import cn.com.atnc.ioms.mng.business.approveinfo.IApproveInfoService;
import cn.com.atnc.ioms.mng.business.baseinfo.IApplyBaseInfoService;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteAttachService;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteConfigService;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteService;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteWorkflowService;
import cn.com.atnc.ioms.mng.business.serial.IApplySerialService;
import cn.com.atnc.ioms.mng.clientnotice.IClientNoticeManager;
import cn.com.atnc.ioms.mng.reports.JasperReportService;
import cn.com.atnc.ioms.model.business.satellite.KuSatelliteQueryModel;
import cn.com.atnc.ioms.model.business.satellite.KuSatelliteReortModel;
import cn.com.atnc.ioms.util.JasperReportUtils;

/**
 * Ku卫星网远端站入网申请附件信息Service实现类
 *
 * @author ku
 * @date 2015年5月13日 下午4:04:00
 * @since 1.0.0
 */
@Service
@Transactional
public class KuSatelliteServiceImpl extends BaseService implements
		IKuSatelliteService {

	@Autowired
	private IKuSatelliteDao kuSatelliteDao;
	@Autowired
	private IKuSatelliteConfigService kuSatelliteConfigService;
	@Autowired
	private IApproveInfoService approveInfoService;
	@Autowired
	private IApplyBaseInfoService applyBaseInfoService;
	@Autowired
	private IKuSatelliteWorkflowService workflowService;
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
	@Autowired
	private IKuSatelliteAttachService kuSatelliteAttachService;

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteService#queryPageByModel(cn.com.atnc.ioms.model.business.satellite.KuSatelliteQueryModel)
	 */
	@Override
	public Pagination queryPageByModel(KuSatelliteQueryModel queryModel) {
		return kuSatelliteDao.queryPageByModel(queryModel);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteService#findById(java.lang.String)
	 */
	@Override
	public Object findById(String id) {
		return kuSatelliteDao.findById(id);
	}

	@Override
	public void update(KuSatellite kuSatellite) {
		kuSatelliteDao.update(kuSatellite);
	}

	@Override
	public void delete(KuSatellite kuSatellite) {
		kuSatelliteDao.delete(kuSatellite);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @return
	 * @see cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteService#dealForm(cn.com.atnc.ioms.model.business.satellite.KuSatelliteQueryModel)
	 */
	@Override
	public KuSatellite dealForm(HttpServletRequest request, KuSatelliteQueryModel queryModel, User user) {
		try {
			Task task = workflowService.getTaskByProcessInstaceId(queryModel
					.getPid());
			Map<String, Object> taskVariables = new HashMap<String, Object>();
			// 根据ID获取KU卫星网远端站入网申请记录对象
			KuSatellite kuSatellite = kuSatelliteDao.findById(queryModel
					.getId());
			ApplyBaseInfo applyBaseInfo = kuSatellite.getApplyBaseInfo();
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

			ApproveStatEnum approveStat = kuSatellite.getApproveStat();
			if (roleNames.toString().contains(
					"|" + RoleEnum.csLeader.name() + "|")) { // 客服领导
				if (ObjectUtils.equals(approveStat,
						ApproveStatEnum.csleader_review)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.csLeader.name());
					status = ApproveStatusEnum.csleader_approve;
					if (queryModel.isApproveStat()) { // 审批通过
						taskVariables.put("csLeaderReviewPass", "3"); // 工作流（客服领导通过）
						kuSatellite
								.setTaskName(ApproveStatEnum.marketmanager_approve
										.getValue());
						kuSatellite
								.setApproveStat(ApproveStatEnum.marketmanager_approve);
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
							kuSatellite
									.setTaskName(ApproveStatEnum.csstaff_audit
											.getValue());
							kuSatellite
									.setApproveStat(ApproveStatEnum.csstaff_audit);
							rolestr = "csStaff";
						}  else if(backUser.equals("退回网控")) {
							taskVariables.put("csLeaderReviewPass", "2"); // 工作流（退回网控）
							kuSatellite
									.setTaskName(ApproveStatEnum.atncleader_firstdeal
											.getValue());
							kuSatellite
									.setApproveStat(ApproveStatEnum.atncleader_firstdeal);
							rolestr = "atncLeader";
						} else if(backUser.equals("用印审批")) {
							taskVariables.put("csLeaderReviewPass", "4"); // 工作流（退回申请用户）
							kuSatellite
									.setTaskName(ApproveStatEnum.fundmanager_confirm
											.getValue());
							kuSatellite
									.setApproveStat(ApproveStatEnum.fundmanager_confirm);
							rolestr = "fundmanager";
							applyBaseInfo.setLeaderCheckFlag(false);
						}
						mss = "reject";
					}
				}
				kuSatellite.setFinalApproveCom("天航信网络公司");
				kuSatellite.setFinalApproveOpinion(queryModel
						.getApproveRemark());
				kuSatellite.setFinalApproveSign(user.getName());
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.csStaff.name() + "|")) { // 客服专员
				if (ObjectUtils.equals(approveStat,
						ApproveStatEnum.csstaff_audit)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.csStaff.name());
					status = ApproveStatusEnum.csstaff_firstdeal;
					taskVariables.put("csStaffReviewComplete", true); // 工作流（客服专员审核）
					kuSatellite.setTaskName(ApproveStatEnum.csleader_review
							.getValue());
					kuSatellite.setApproveStat(ApproveStatEnum.csleader_review);
					// 记录审核该条转报申请的客服专员
					String csStaff = user.getId();
					applyBaseInfo.setAuditUser(csStaff);
					rolestr = "csLeader";
				} else if (ObjectUtils.equals(approveStat,
						ApproveStatEnum.csstaff_deal)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.csStaff.name());
					status = ApproveStatusEnum.csstaff_deal;
					taskVariables.put("csStaffPass", true); // 工作流（客服专员办理）
					kuSatellite.setTaskName(ApproveStatEnum.atncleader_approve
							.getValue());
					kuSatellite
							.setApproveStat(ApproveStatEnum.atncleader_approve);
					rolestr = "atncLeader";
				}
				mss = "agree";
				// 保存联系人和联系电话
				applyBaseInfo.setFinalLinkman(user.getName());
				applyBaseInfo.setFinalLinkphone(user.getMobilephone());
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.atncLeader.name() + "|")) { // 网控领导
				if (queryModel.isApproveStat()) { // 审批通过
					if (ObjectUtils.equals(approveStat,
							ApproveStatEnum.atncleader_firstdeal)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_firstdeal;
						taskVariables.put("atncLeaderDistribute", true);// 工作流（网控领导交办审核）
						kuSatellite
								.setTaskName(ApproveStatEnum.engineer_firstaudit
										.getValue());
						// 记录选择的审核工程师，工程师审核时使用
						String auditEngineer = queryModel.getAuditEngineer();
						applyBaseInfo.setNextUser(auditEngineer);
						kuSatellite
								.setApproveStat(ApproveStatEnum.engineer_firstaudit);
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
							ApproveStatEnum.atncleader_review)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_approve;
						taskVariables.put("atncLeaderReviewPass", true); // 工作流（网控领导审核）
						kuSatellite
								.setTaskName(ApproveStatEnum.netmanager_approve
										.getValue());
						kuSatellite
								.setApproveStat(ApproveStatEnum.netmanager_approve);
						if (!ObjectUtils.equals(queryModel.isAgreeStat(), null)) {
							if (queryModel.isAgreeStat()) {
								mss = "consent";
							} else {
								mss = "disconsent";
							}
						} else {
							mss = "agree";
						}
						rolestr = "netmanager";
					} else if (ObjectUtils.equals(approveStat,
							ApproveStatEnum.atncleader_approve)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_seconddeal;
						taskVariables.put("atncLeaderDistribute", true);// 工作流（网控领导交办配置）
						kuSatellite.setTaskName(ApproveStatEnum.engineer_config
								.getValue());
						// 记录选择的配置工程师
						String engineerId = queryModel.getEngineer();
						applyBaseInfo.setNextUser(engineerId);
						kuSatellite
								.setApproveStat(ApproveStatEnum.engineer_config);
						// 设置下一步操作信息（审批记录使用）
						User nextuser = userManager.findById(engineerId);
						nextusername = nextuser.getName();
						nextusertel = nextuser.getMobilephone();
						mss = "agree";
						msgn = "尊敬的用户:"
								+ userManager.findById(engineerId).getName()
								+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					} else if(ObjectUtils.equals(approveStat,
							ApproveStatEnum.atncleader_audit)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_thirddeal;
						taskVariables.put("atncLeaderDistribute", true);// 工作流（网控领导交办配置）
						kuSatellite.setTaskName(ApproveStatEnum.engineer_audit
								.getValue());
						// 设置下一步操作人：审核工程师
						String auditEngineer = queryModel.getAuditEngineer();
						applyBaseInfo.setNextUser(auditEngineer);
						kuSatellite
								.setApproveStat(ApproveStatEnum.engineer_audit);
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
							ApproveStatEnum.atncleader_review)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_approve;
						taskVariables.put("atncLeaderReviewPass", false); // 工作流（网控领导审核）
						kuSatellite
								.setTaskName(ApproveStatEnum.engineer_firstaudit
										.getValue());
						applyBaseInfo.setNextUser(applyBaseInfo.getLastUser());
						kuSatellite
								.setApproveStat(ApproveStatEnum.engineer_firstaudit);
						msgn = "尊敬的用户:"
								+ userManager.findById(
										applyBaseInfo.getLastUser()).getName()
								+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					}
					mss = "reject";
				}
				if (!ObjectUtils.equals(approveStat,
						ApproveStatEnum.atncleader_approve)) {
					kuSatellite.setFinalApproveCom("天航信网络公司");
					kuSatellite.setFinalApproveOpinion(queryModel
							.getApproveRemark());
					kuSatellite.setFinalApproveSign(user.getName());
				}
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.netmanager.name() + "|")) { // 网络运营事业部经理审批
				if (ObjectUtils.equals(approveStat,
						ApproveStatEnum.netmanager_approve)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.netmanager.name());
					status = ApproveStatusEnum.netmanager_approve;
					taskVariables.put("netManagerPass", true); // 工作流（运营事业部总经理通过）
					kuSatellite.setTaskName(ApproveStatEnum.csstaff_audit
							.getValue());
					kuSatellite.setApproveStat(ApproveStatEnum.csstaff_audit);
					if (!ObjectUtils.equals(queryModel.isAgreeStat(), null)) {
						if (queryModel.isAgreeStat()) {
							mss = "consent";
						} else {
							mss = "disconsent";
						}
					} else {
						mss = "agree";
					}
					kuSatellite.setFinalApproveCom("天航信网络公司");
					kuSatellite.setFinalApproveOpinion(queryModel
							.getApproveRemark());
					kuSatellite.setFinalApproveSign(user.getName());
					rolestr = "csStaff";
				}
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.manager.name() + "|")) { // 网络运营事业部经理审批
				if (ObjectUtils.equals(approveStat,
						ApproveStatEnum.marketmanager_approve)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.manager.name());
					status = ApproveStatusEnum.generalmanager_approve;
					taskVariables.put("marketManagerPass", true); // 工作流（运营事业部总经理通过）
					kuSatellite.setTaskName(ApproveStatEnum.leader_approve
							.getValue());
					kuSatellite.setApproveStat(ApproveStatEnum.leader_approve);
					if (!ObjectUtils.equals(queryModel.isAgreeStat(), null)) {
						if (queryModel.isAgreeStat()) {
							mss = "consent";
						} else {
							mss = "disconsent";
						}
					} else {
						mss = "agree";
					}
					kuSatellite.setFinalApproveCom("天航信网络公司");
					kuSatellite.setFinalApproveOpinion(queryModel
							.getApproveRemark());
					kuSatellite.setFinalApproveSign(user.getName());
					rolestr = "leader";
				}
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.leader.name() + "|")) {
				if (ObjectUtils.equals(approveStat,
						ApproveStatEnum.leader_approve)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.leader.name());
					status = ApproveStatusEnum.compenyleader_approve;
					// 保存领导审批结果
					applyBaseInfo
							.setLeaderCheckFlag(queryModel.isApproveStat());
					if (queryModel.isApproveStat()) { // 审批通过 —— 生成正式编号
						// 生成正式的申请编号
						applyBaseInfo.setSerialNumber(applySerialService
								.createSerialNumber(SerialNameEnum.RW,
										SerialTypeEnum.WX));
						mss = "consent";
					} else {
						mss = "disconsent";
					}
					rolestr = "fundmanager";
					taskVariables.put("leaderPass", true); // 工作流（事业部总经理通过）
					kuSatellite.setTaskName(ApproveStatEnum.fundmanager_confirm
							.getValue());
					kuSatellite
							.setApproveStat(ApproveStatEnum.fundmanager_confirm);

					kuSatellite.setFinalApproveCom("天航信网络公司");
					kuSatellite.setFinalApproveOpinion(queryModel
							.getApproveRemark());
					kuSatellite.setFinalApproveSign(user.getName());
				}
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.fundmanager.name() + "|")) { // 财务部总经理
				if (ObjectUtils.equals(approveStat,
						ApproveStatEnum.fundmanager_confirm)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.fundmanager.name());
					status = ApproveStatusEnum.fundmanager_approve;
					kuSatellite.setCachetApprove(1); // 用印确认
					// 判断了领导审批是否通过，通过继续，否则退回给用户
					if (applyBaseInfo.getLeaderCheckFlag()) {
						// 通过
						taskVariables.put("fundManagerConfirm", true); // 工作流（用印确认）
						kuSatellite.setTaskName(ApproveStatEnum.csstaff_deal
								.getValue());
						kuSatellite
								.setApproveStat(ApproveStatEnum.csstaff_deal);
						mss = "confirm";
						rolestr = "csStaff";
					} else {
						// 未通过
						taskVariables.put("fundManagerConfirm", false); // 工作流（事业部总经理退回）
						// 申请人所在管局
						Bureau bureau = kuSatellite.getApplyBaseInfo()
								.getApplyUser().getBureau();
						if (!ObjectUtils.equals(bureau, null)) {
							bureau = Bureau.isBelong7Bureau(bureau.getValue());
						}
						if (!ObjectUtils.equals(bureau, null)) { // 申请人属于7大管局
							kuSatellite
									.setTaskName(ApproveStatEnum.areaexaminer_confirm
											.getValue());
							taskVariables.put("needAreaExaminerConfirm", true);
							kuSatellite
									.setApproveStat(ApproveStatEnum.areaexaminer_confirm);
							msg = "尊敬的用户:"
									+ kuSatellite.getApplyBaseInfo()
											.getInitLinkman()
									+ ",您好！您有一条["
									+ applyBaseInfo.getApplyType()
									+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
						} else {
							kuSatellite
									.setTaskName(ApproveStatEnum.returned
											.getValue());
							taskVariables.put("needAreaExaminerConfirm", false);
							kuSatellite
									.setApproveStat(ApproveStatEnum.returned);
							msg = "尊敬的用户:"
									+ kuSatellite.getApplyBaseInfo()
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
						this.getReportParams(request, kuSatellite.getId(),
								JasperReportsEnum.kusatellite.toString());
						absoluteAddress = JasperReportUtils
								.saveReturedApplyList(number,
										applyBaseInfo.getId(), request,
										JasperReportsEnum.kusatellite.name());
					}
				}
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.engineer.name() + "|")) { // 工程师
				if (queryModel.isApproveStat()) {// 配置
					if (ObjectUtils.equals(approveStat,
							ApproveStatEnum.engineer_firstaudit)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_firstaudit;
						taskVariables.put("engineerAuditComplete", true); // 工作流（工程师初审）
						kuSatellite
								.setTaskName(ApproveStatEnum.atncleader_review
										.getValue());
						applyBaseInfo.setLastUser(user.getId());
						kuSatellite
								.setApproveStat(ApproveStatEnum.atncleader_review);
						rolestr = "atncLeader";
					} else if (ObjectUtils.equals(approveStat,
							ApproveStatEnum.engineer_config)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_config;
						taskVariables.put("transfer", false); // 工作流（工程师配置）
						kuSatellite.setTaskName(ApproveStatEnum.atncleader_audit
								.getValue());
						applyBaseInfo.setLastUser(user.getId());
						applyBaseInfo
								.setLastStatusEnum(ApproveStatEnum.engineer_config
										.name());
						kuSatellite
								.setApproveStat(ApproveStatEnum.atncleader_audit);
						// 若之前审核工程师退回了，删除之前的配置信息
						KuSatelliteConfig kuSatelliteConfig = kuSatelliteConfigService
								.findByKuSateId(kuSatellite.getId());
						if (!ObjectUtils.equals(kuSatelliteConfig, null)) {
							kuSatelliteConfigService.delete(kuSatelliteConfig);
						}
						rolestr = "atncLeader";
					} else if (ObjectUtils.equals(approveStat,
							ApproveStatEnum.assist_config)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_transfer;
						taskVariables.put("assistConfig", true); // 工作流（工程师协助配置）
						kuSatellite.setTaskName(ApproveStatEnum.atncleader_audit
								.getValue());
						applyBaseInfo.setLastUser(user.getId());
						applyBaseInfo
								.setLastStatusEnum(ApproveStatEnum.assist_config
										.name());
						kuSatellite
								.setApproveStat(ApproveStatEnum.atncleader_audit);
						// 若之前审核工程师退回了，删除之前的配置信息
						KuSatelliteConfig kuSatelliteConfig = kuSatelliteConfigService
								.findByKuSateId(kuSatellite.getId());
						if (!ObjectUtils.equals(kuSatelliteConfig, null)) {
							kuSatelliteConfigService.delete(kuSatelliteConfig);
						}
						rolestr = "atncLeader";
					} else if (ObjectUtils.equals(approveStat,
							ApproveStatEnum.engineer_audit)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_secondaudit;
						taskVariables.put("engineerAuditPass", 3); // 工作流（工程师审核）
						kuSatellite.setTaskName(ApproveStatEnum.local_evaluate
								.getValue());
						applyBaseInfo.setNextUser(applyBaseInfo.getLastUser()); // 设置下一步操作人
						kuSatellite
								.setApproveStat(ApproveStatEnum.local_evaluate);
						msg = "尊敬的用户:"
								+ kuSatellite.getApplyBaseInfo()
										.getApplyLinkman() + ",您好！您有一条["
								+ applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					}
					mss = "agree";
				} else {// 移交其他工程师
					if (ObjectUtils.equals(approveStat,
							ApproveStatEnum.engineer_config)) { // 移交其他工程师
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_config;
						taskVariables.put("transfer", true); // 工作流（工程师移交）
						kuSatellite.setTaskName(ApproveStatEnum.assist_config
								.getValue());
						String engineerId = queryModel.getEngineer();
						taskVariables.put("engineer", engineerId);
						kuSatellite
								.setApproveStat(ApproveStatEnum.assist_config);
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
							ApproveStatEnum.engineer_audit)) { // 审核工程师退回
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_secondaudit;
						String lastUserId = applyBaseInfo.getLastUser();
						String lastStatus = applyBaseInfo.getLastStatusEnum();
						if (StringUtils.equalsIgnoreCase(lastStatus,
								ApproveStatEnum.engineer_config.name())) {
							// 如果是正常工程师配置的，则退回给正常工程师
							taskVariables.put("engineerAuditPass", 1); // 工作流（工程师审核未通过）
							kuSatellite
									.setApproveStat(ApproveStatEnum.engineer_config);
							kuSatellite
									.setTaskName(ApproveStatEnum.engineer_config
											.getValue());
						} else if (StringUtils.equalsIgnoreCase(lastStatus,
								ApproveStatEnum.assist_config.name())) {
							// 如果是移交工程师配置的，则退回给移交工程师
							taskVariables.put("engineerAuditPass", 2); // 工作流（工程师审核未通过）
							kuSatellite
									.setApproveStat(ApproveStatEnum.assist_config);
							kuSatellite
									.setTaskName(ApproveStatEnum.assist_config
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
			//添加审核人
			applyBaseInfo.setApproveUsers(applyBaseInfo.getApproveUsers() == null ? user.getName() 
					: applyBaseInfo.getApproveUsers() + "," + user.getName());
			applyBaseInfoService.update(applyBaseInfo); // 更新申请基础信息表
			this.update(kuSatellite); // 更新转报地址申请表
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
			approveInfoService.save(approveInfo);
			// 发送短信
			if (!StringUtils.isEmpty(msg)
					&& !StringUtils.isEmpty(kuSatellite.getApplyBaseInfo()
							.getApplyPhone())) {
				BaseUserInfo baseUserInfo = new BaseUserInfo();
				if (kuSatellite.getApproveStat().equals(
						ApproveStatEnum.areaexaminer_confirm)) {
					baseUserInfo.setLoginName(kuSatellite.getApplyBaseInfo()
							.getInitLinkman());
					baseUserInfo.setMobilephone(kuSatellite.getApplyBaseInfo()
							.getInitLinkphone());
				} else {
					baseUserInfo.setLoginName(kuSatellite.getApplyBaseInfo()
							.getApplyLinkman());
					baseUserInfo.setMobilephone(kuSatellite.getApplyBaseInfo()
							.getApplyPhone());
				}
				clientNoticeManager.sendMessage(baseUserInfo, msg);
			}
			// 发送短信给指定用户
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
			return kuSatellite;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("处理表单信息出错，原因是：" + e.getMessage());
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteService#findByApplyBaseInfoId(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true, timeout = 2)
	public Object findByApplyBaseInfoId(String id) {
		return kuSatelliteDao.findByParam("applyBaseInfo.id", id);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteService#add(cn.com.atnc.ioms.entity.business.satellite.KuSatellite)
	 */
	@Override
	public void add(KuSatellite entity) {
		// TODO Auto-generated method stub
		kuSatelliteDao.save(entity);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteService#getKuSatelliteById(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true, timeout = 2)
	public KuSatellite getKuSatelliteById(String id) {
		return kuSatelliteDao.findById(id);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteService#getReportDateSource(java.lang.String)
	 */
	@Override
	public List<KuSatelliteReortModel> getReportDateSource(String id) {
		KuSatellite kuSatellite = kuSatelliteDao.findById(id);
		KuSatelliteReortModel kuSatelliteReortModel = new KuSatelliteReortModel(
				kuSatellite);
		// 加载配置信息
		KuSatelliteConfig kuSatelliteConfig = kuSatelliteConfigService
				.findByKuSateId(id);
		if (!ObjectUtils.equals(kuSatelliteConfig, null)) {
			kuSatelliteReortModel.setNode(kuSatelliteConfig.getNode());
			kuSatelliteReortModel.setMediumFrequency(kuSatelliteConfig
					.getMediumFrequency());
			kuSatelliteReortModel.setEmissionFrequency(kuSatelliteConfig
					.getEmissionFrequency());
			kuSatelliteReortModel.setReceiveFrequency(kuSatelliteConfig
					.getReceiveFrequency());
		}
		List<KuSatelliteReortModel> list = new ArrayList<KuSatelliteReortModel>();
		list.add(kuSatelliteReortModel);
		return list;
	}

	@Override
	public Map<String, Object> getReportParams(HttpServletRequest request,
			String id, String reportName) {
		// 1.主报表数据源
		List<KuSatelliteReortModel> datasource = this.getReportDateSource(id);
		// 3.获取报表相关参数，供预览使用
		Map<String, Object> param = null;
		KuSatellite kuSatellite = this.getKuSatelliteById(id);
		// 判断用印审批为是否为true，如果是，则显示公章，否则不显示。
		if (kuSatellite.getCachetApprove() == 0) {
			param = jasperReportService
					.preView(request, datasource, reportName);
		} else {
			param = jasperReportService.preView(request, datasource,
					ImageNameEnum.atncCachet.getValue(), reportName);
		}
		// 判断上传了哪些附件
		List<KuSatelliteAttach> kuSatelliteAttachs = kuSatelliteAttachService
				.queryListByKuSateId(id);
		if (!CollectionUtils.isEmpty(kuSatelliteAttachs)) {
			for (KuSatelliteAttach kuSatelliteAttach : kuSatelliteAttachs) {
				switch (kuSatelliteAttach.getAttachType()) {
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
				case five:
					param.put("MATERIAL5", "1");
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
	 * @see cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteService#getListSendMessage()
	 */
	@Override
	public List<KuSatellite> getListSendMessage() {
		return kuSatelliteDao.getListSendMessage();
	}
}
