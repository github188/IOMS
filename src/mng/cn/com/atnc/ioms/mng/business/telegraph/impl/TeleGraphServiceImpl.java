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
import cn.com.atnc.ioms.dao.business.approveinfo.IApproveInfoDao;
import cn.com.atnc.ioms.dao.business.baseinfo.IApplyBaseInfoDao;
import cn.com.atnc.ioms.dao.business.telegraph.TeleGraphApplyDao;
import cn.com.atnc.ioms.dao.business.telegraph.TeleGraphConfigDao;
import cn.com.atnc.ioms.dao.business.telegraph.TeleGraphDao;
import cn.com.atnc.ioms.entity.BaseUserInfo;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.approveinfo.ApproveInfo;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraph;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphApply;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphConfig;
import cn.com.atnc.ioms.entity.reports.TeleGraphApplyEntity;
import cn.com.atnc.ioms.entity.reports.TeleGraphBaseInfoEntity;
import cn.com.atnc.ioms.entity.reports.TeleGraphConfigEntity;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveStatusEnum;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveTypeEnum;
import cn.com.atnc.ioms.enums.business.serial.SerialNameEnum;
import cn.com.atnc.ioms.enums.business.serial.SerialTypeEnum;
import cn.com.atnc.ioms.enums.business.telegraph.AddressTypeEnum;
import cn.com.atnc.ioms.enums.business.telegraph.TeleApplyTypeEnum;
import cn.com.atnc.ioms.enums.business.telegraph.TeleGraphApproveStatEnum;
import cn.com.atnc.ioms.enums.reports.ImageNameEnum;
import cn.com.atnc.ioms.enums.reports.JasperReportsEnum;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.acl.IUserRoleManager;
import cn.com.atnc.ioms.mng.business.approveinfo.IApproveInfoService;
import cn.com.atnc.ioms.mng.business.serial.IApplySerialService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphWorkflowService;
import cn.com.atnc.ioms.mng.clientnotice.IClientNoticeManager;
import cn.com.atnc.ioms.mng.reports.JasperReportService;
import cn.com.atnc.ioms.model.business.telegraph.TeleGraphQueryModel;
import cn.com.atnc.ioms.util.DataSourceFactory;
import cn.com.atnc.ioms.util.JasperReportUtils;

/**
 * 转报地址Service实现类
 *
 * @author WangLingbin
 * @date 2015年5月20日 下午3:18:27
 * @since 1.0.0
 */
@Service
@Transactional
public class TeleGraphServiceImpl extends BaseService implements
		TeleGraphService {

	@Autowired
	private TeleGraphDao teleGraphDao;
	@Autowired
	private IApproveInfoDao approveInfoDao;
	@Autowired
	private TeleGraphWorkflowService workflowService;
	@Autowired
	private IApplyBaseInfoDao applyBaseInfoDao;
	@Autowired
	private IClientNoticeManager clientNoticeManager;
	@Autowired
	private TeleGraphApplyDao teleGraphApplyDao;
	@Autowired
	private TeleGraphConfigDao teleGraphConfigDao;
	@Autowired
	private IApplySerialService applySerialService;
	@Autowired
	private IUserManager userManager;
	@Autowired
	private IUserRoleManager userRoleManager;
	@Autowired
	private IApproveInfoService approveInfoService;
	@Autowired
	private JasperReportService jasperReportService;

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.mng.business.satellite.IKuSatelliteService#queryPageByModel(cn.com.atnc.pcsp.model.business.satellite.KuSatelliteQueryModel)
	 */
	@Override
	public Pagination queryPageByModel(TeleGraphQueryModel queryModel) {
		return teleGraphDao.queryPageByModel(queryModel);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @return
	 * @see cn.com.atnc.pcsp.mng.business.satellite.IKuSatelliteService#save(cn.com.atnc.pcsp.entity.business.satellite.KuSatellite)
	 */
	@Override
	public void save(TeleGraph teleGraph) {
		teleGraphDao.save(teleGraph);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.mng.business.satellite.IKuSatelliteService#getKuSatelliteById(java.lang.String)
	 */
	@Override
	public TeleGraph getTeleGraphById(String id) {
		return teleGraphDao.findById(id);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.mng.business.satellite.IKuSatelliteService#update(cn.com.atnc.pcsp.entity.business.satellite.KuSatellite)
	 */
	@Override
	public void update(TeleGraph teleGraph) {
		teleGraphDao.update(teleGraph);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.mng.business.satellite.IKuSatelliteService#delete(cn.com.atnc.pcsp.entity.business.satellite.KuSatellite)
	 */
	@Override
	public void delete(TeleGraph teleGraph) {
		teleGraphDao.delete(teleGraph);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.business.telegraph.TeleGraphService#dealForm(cn.com.atnc.ioms.model.business.telegraph.TeleGraphQueryModel,
	 *      cn.com.atnc.ioms.entity.acl.User)
	 */
	@Override
	public TeleGraph dealForm(HttpServletRequest request, TeleGraphQueryModel queryModel, User user,
			List<String> originalAddrs) {
		try {
			// 工作流相关
			Task task = workflowService.getTaskByProcessInstaceId(queryModel
					.getPid());
			Map<String, Object> taskVariables = new HashMap<String, Object>();
			// 根据ID获取转报地址对象
			TeleGraph teleGraph = teleGraphDao.findById(queryModel.getId());
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
						taskVariables.put("csLeaderReviewPass", "true"); // 工作流（客服领导通过）
						teleGraph
								.setTaskName(TeleGraphApproveStatEnum.generalmanager_approve
										.getValue());
						teleGraph
								.setApproveStat(TeleGraphApproveStatEnum.generalmanager_approve);
						rolestr = "manager";
						if (queryModel.isAgreeStat()) {
							mss = "consent";
						} else {
							mss = "disconsent";
						}
					} else { // 审批退回
						String backUser = queryModel.getBackUser();
						if (StringUtils.equalsIgnoreCase(backUser, "退回客服")) {
							taskVariables.put("csLeaderReviewPass", "false"); // 工作流（退回客服）
							// 取出分配的客服专员ID做为下一步的操作人ID
							applyBaseInfo.setNextUser(applyBaseInfo
									.getAuditUser());
							teleGraph
									.setTaskName(TeleGraphApproveStatEnum.csstaff_audit
											.getValue());
							teleGraph
									.setApproveStat(TeleGraphApproveStatEnum.csstaff_audit);
							applyBaseInfo.setNextUser(applyBaseInfo.getAuditUser());
							rolestr = "csStaff";
						} else if (StringUtils.equalsIgnoreCase(backUser, "用印审批")){
							taskVariables.put("csLeaderReviewPass", "back"); // 工作流（退回申请用户）
							teleGraph
									.setTaskName(TeleGraphApproveStatEnum.fundmanager_confirm
											.getValue());
							teleGraph
									.setApproveStat(TeleGraphApproveStatEnum.fundmanager_confirm);
							rolestr = "fundmanager";
							applyBaseInfo.setLeaderCheckFlag(false);
							teleGraph.setAtncOpition(queryModel.getApproveRemark());
							teleGraph.setAtncSign(user.getName());
						}
						mss = "reject";
					}
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
					taskVariables.put("csStaffAuditComplete", true); // 工作流（客服专员审核）
					teleGraph
							.setTaskName(TeleGraphApproveStatEnum.csleader_review
									.getValue());
					teleGraph
							.setApproveStat(TeleGraphApproveStatEnum.csleader_review);
					// 记录审核该条转报申请的客服专员
					String csStaff = user.getId();
					applyBaseInfo.setAuditUser(csStaff);
					// 当客户申请的地址类型为8X且未新增时，需要客服专员对地址进行配置
					int index = 0;
					if (ObjectUtils.equals(teleGraph.getAddressType(),AddressTypeEnum.E8X) 
							&& ObjectUtils.equals(teleGraph.getTeleApplyType(),TeleApplyTypeEnum.create) ) {
						List<TeleGraphApply> teleGraphApplys = teleGraphApplyDao
								.getApplysByParentId(queryModel.getId());
						if (!CollectionUtils.isEmpty(teleGraphApplys)) {
							for (TeleGraphApply teleGraphApply : teleGraphApplys) {
								teleGraphApply.setAllocatedAddr(originalAddrs.get(index++));// 将目前"原地址（变更/注销时填写）"内的地址挪到"分配的路由地址"内
								teleGraphApplyDao.update(teleGraphApply);
							}
						}
					}
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
				mss = "confirm";
				// 保存联系人和联系电话
				applyBaseInfo.setFinalLinkman(user.getName());
				applyBaseInfo.setFinalLinkphone(user.getMobilephone());
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
					if (queryModel.isApproveStat()) { // 审批通过 —— 生成正式电路编号
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
								.createSerialNumber(SerialNameEnum.DB, type));
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
						taskVariables.put("fundManagerConfirm", true); // 工作流（财务部总经理通过）
						teleGraph
								.setTaskName(TeleGraphApproveStatEnum.csstaff_deal
										.getValue());
						teleGraph
								.setApproveStat(TeleGraphApproveStatEnum.csstaff_deal);
						rolestr = "csStaff";
					} else {
						// 未通过
						taskVariables.put("fundManagerConfirm", false); // 工作流（事业部总经理退回）
						// 申请人所在管局
						Bureau bureau = teleGraph.getApplyBaseInfo()
								.getApplyUser().getBureau();
						if (!ObjectUtils.equals(bureau, null)) {
							bureau = Bureau.isBelong7Bureau(bureau.getValue());
						}
						// 若申请人不属于7大管局或为8X地址类型，则不经过地区确认
						if (ObjectUtils.equals(bureau, null)
								|| ObjectUtils.equals(
										teleGraph.getAddressType(),
										AddressTypeEnum.E8X)) {
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
						} else { // 申请人属于7大管局
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
						}
						//审批退回后，重置发送短信标识，下次前台提交时，可以给后台发送短信
						applyBaseInfo.setSendmessageFlag(false);
						// 保存申请表
						int number = approveInfoService
								.getReturnedApplyNumber(applyBaseInfo.getId());
						this.getReportParams(request, teleGraph.getId(),
								JasperReportsEnum.apply.toString());
						absoluteAddress = JasperReportUtils
								.saveReturedApplyList(number,
										applyBaseInfo.getId(), request,
										JasperReportsEnum.apply.name());
					}
					mss = "confirm";
				}
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.atncLeader.name() + "|")) { // 网控领导
				if (ObjectUtils.equals(approveStat,
						TeleGraphApproveStatEnum.atncleader_approve)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.atncLeader.name());
					status = ApproveStatusEnum.atncleader_seconddeal;
					taskVariables.put("atncLeaderDistribute", true); // 工作流（网控领导交办）
					teleGraph
							.setTaskName(TeleGraphApproveStatEnum.engineer_config
									.getValue());
					// 记录选择的配置工程师
					String engineerId = queryModel.getEngineer();
					applyBaseInfo.setNextUser(engineerId);
					applyBaseInfo.setSendmessageFlag(false);
					teleGraph
							.setApproveStat(TeleGraphApproveStatEnum.engineer_config);
					// 设置下一步操作信息（审批记录使用）
					User nextuser = userManager.findById(engineerId);
					nextusername = nextuser.getName();
					nextusertel = nextuser.getMobilephone();
					msgn = "尊敬的用户:"
							+ userManager.findById(engineerId).getName()
							+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
							+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					mss = "agree";
				} else if(ObjectUtils.equals(approveStat,
						TeleGraphApproveStatEnum.atncleader_audit)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.atncLeader.name());
					status = ApproveStatusEnum.atncleader_thirddeal;
					taskVariables.put("atncLeaderDistribute", true); // 工作流（网控领导交办）
					teleGraph
							.setTaskName(TeleGraphApproveStatEnum.engineer_audit
									.getValue());
					// 设置下一步操作人：审核工程师
					String auditEngineer = queryModel.getAuditEngineer();
					applyBaseInfo.setNextUser(auditEngineer);
					applyBaseInfo.setSendmessageFlag(false);
					teleGraph
							.setApproveStat(TeleGraphApproveStatEnum.engineer_audit);
					// 设置下一步操作信息（审批记录使用）
					User nextuser = userManager.findById(auditEngineer);
					nextusername = nextuser.getName();
					nextusertel = nextuser.getMobilephone();
					msgn = "尊敬的用户:"
							+ userManager.findById(auditEngineer).getName()
							+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
							+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					mss = "agree";
				}
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.engineer.name() + "|")) { // 工程师
				if (queryModel.isApproveStat()) {// 配置
					if (ObjectUtils.equals(approveStat,
							TeleGraphApproveStatEnum.engineer_config)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
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
						// 若之前审核工程师退回了，删除之前的配置信息
						List<TeleGraphConfig> configs = teleGraphConfigDao
								.getConfigsByTeleGraphId(teleGraph.getId());
						if (!CollectionUtils.isEmpty(configs)) {
							teleGraphConfigDao.deleteList(configs);
						}
						status = ApproveStatusEnum.engineer_config;
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
						// 若之前审核工程师退回了，删除之前的配置信息
						List<TeleGraphConfig> configs = teleGraphConfigDao
								.getConfigsByTeleGraphId(teleGraph.getId());
						if (!CollectionUtils.isEmpty(configs)) {
							teleGraphConfigDao.deleteList(configs);
						}
						rolestr = "atncLeader";
					} else if (ObjectUtils.equals(approveStat,
							TeleGraphApproveStatEnum.engineer_audit)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_secondaudit;
						// 判断是否需要地区配置
						// 申请人所在管局
						Bureau bureau = teleGraph.getApplyBaseInfo()
								.getApplyUser().getBureau();
						if (!ObjectUtils.equals(bureau, null)) {
							bureau = Bureau.isBelong7Bureau(bureau.getValue());
						}
						// 若申请人不属于7大管局或为8X地址类型，则不经过地区配置
						if (ObjectUtils.equals(bureau, null)
								|| ObjectUtils.equals(
										teleGraph.getAddressType(),
										AddressTypeEnum.E8X)) {
							teleGraph
									.setTaskName(TeleGraphApproveStatEnum.atnc_test
											.getValue());
							taskVariables.put("engineerAuditPass", 4); // 工作流（工程师审核,无需地区配置）
							teleGraph
									.setApproveStat(TeleGraphApproveStatEnum.atnc_test);
							msgn = "尊敬的用户:"
									+ userManager.findById(
											applyBaseInfo.getLastUser())
											.getName()
									+ ",您好！您有一条["
									+ applyBaseInfo.getApplyType()
									+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
						} else { // 申请人属于7大管局
							taskVariables.put("engineerAuditPass", 3); // 工作流（工程师审核，需要地区配置）
							teleGraph
									.setTaskName(TeleGraphApproveStatEnum.area_config
											.getValue());
							teleGraph
									.setApproveStat(TeleGraphApproveStatEnum.area_config);
							msg = "尊敬的用户:"
									+ teleGraph.getApplyBaseInfo()
											.getInitLinkman()
									+ ",您好！您有一条["
									+ applyBaseInfo.getApplyType()
									+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
						}
						applyBaseInfo.setNextUser(applyBaseInfo.getLastUser()); // 设置下一步操作人
					} else if (ObjectUtils.equals(approveStat,
							TeleGraphApproveStatEnum.atnc_test)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.atnc_test;
						taskVariables.put("engineerTest", true); // 工作流（工程师协调测试）
						teleGraph
								.setTaskName(TeleGraphApproveStatEnum.local_evaluate
										.getValue());
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
						mss = "transfer";
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
						mss = "reject";
					}
				}
			}
			//添加审核人
			applyBaseInfo.setApproveUsers(applyBaseInfo.getApproveUsers() == null ? user.getName() 
					: applyBaseInfo.getApproveUsers() + "," + user.getName());
			applyBaseInfoDao.update(applyBaseInfo); // 更新申请基础信息表
			teleGraphDao.update(teleGraph); // 更新转报地址申请表
			// 添加审批记录
			ApproveInfo approveInfo = new ApproveInfo(user, applyBaseInfo,
					queryModel.getApproveRemark(), queryModel.isApproveStat());
			approveInfo.setNextUserName(nextusername);
			approveInfo.setNextUserTel(nextusertel);
			/*if (ObjectUtils.equals(teleGraph.getApproveStat(),
					TeleGraphApproveStatEnum.area_config)) {
				approveInfo.setApproveType(ApproveTypeEnum.confirm);
			} else if (ObjectUtils.equals(teleGraph.getApproveStat(),
					TeleGraphApproveStatEnum.assist_config)) {
				approveInfo.setApproveType(ApproveTypeEnum.transfer);
			} else if (ObjectUtils.equals(teleGraph.getApproveStat(),
					TeleGraphApproveStatEnum.generalmanager_approve)) {
				// 客服领导对客服专员审批通过，提出自己对用户申请的意见
				if (queryModel.isAgreeStat()) { // 是否同意用户申请
					approveInfo.setApproveType(ApproveTypeEnum.consent);
				} else {
					approveInfo.setApproveType(ApproveTypeEnum.disconsent);
				}
			} else if (teleGraph.getCachetApprove() == 1) {
				approveInfo.setApproveType(ApproveTypeEnum.confirm);
			}
			if(ObjectUtils.equals(teleGraph.getApproveStat(),
					TeleGraphApproveStatEnum.generalmanager_approve)){
				if (queryModel.isAgreeStat()) { // 是否同意用户申请
					approveInfo.setApproveType(ApproveTypeEnum.consent);
				} else {
					approveInfo.setApproveType(ApproveTypeEnum.disconsent);
				}
			}
			if(ObjectUtils.equals(teleGraph.getApproveStat(),
					TeleGraphApproveStatEnum.fundmanager_confirm)){
				if (queryModel.isApproveStat()){
					approveInfo.setApproveType(ApproveTypeEnum.consent);
				} else {
					approveInfo.setApproveType(ApproveTypeEnum.disconsent);
				}
			}*/
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
			approveInfoDao.save(approveInfo);
			// 发送短信
			if (!StringUtils.isEmpty(msg)
					&& !StringUtils.isEmpty(teleGraph.getApplyBaseInfo()
							.getApplyPhone())) {
				BaseUserInfo baseUserInfo = new BaseUserInfo();
				if (teleGraph.getApproveStat().equals(
						TeleGraphApproveStatEnum.areaexaminer_confirm)
						|| teleGraph.getApproveStat().equals(
								TeleGraphApproveStatEnum.area_config)) {
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
			return teleGraph;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("处理表单信息出错，原因是：" + e.getMessage());
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.business.telegraph.TeleGraphService#getTeleGraphByBaseInfo(java.lang.String)
	 */
	@Override
	public TeleGraph getTeleGraphByBaseInfo(String id) {
		return teleGraphDao.getTeleGraphByBaseInfo(id);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map<String, Object> getReportParams(HttpServletRequest request,
			String id, String reportName) {
		// 1.主报表数据源
		List<TeleGraphBaseInfoEntity> entity = null;
		List<TeleGraph> datasource = null;
		// 2.子报表数据源
		List subreportDatasource = null;
		if (StringUtils.equalsIgnoreCase(reportName,
				JasperReportsEnum.apply.name())) {
			// 申请表
			entity = jasperReportService.getApplyDatasource(id);//
			datasource = (List<TeleGraph>) DataSourceFactory
					.getBeanCollection(entity);//
			subreportDatasource = entity.get(0).getApply();//
			if (subreportDatasource.size() < 4) {
				for (int i = subreportDatasource.size(); i < 4; i++) {
					subreportDatasource.add(new TeleGraphApplyEntity());
				}
			}
		} else if (StringUtils.equalsIgnoreCase(reportName,
				JasperReportsEnum.config.name())) {
			// 配置表
			entity = jasperReportService.getConfigDatasource(id); //
			datasource = (List<TeleGraph>) DataSourceFactory
					.getBeanCollection(entity);//
			subreportDatasource = entity.get(0).getConfig();
			if (subreportDatasource.size() < 4) {
				for (int i = subreportDatasource.size(); i < 4; i++) {
					subreportDatasource.add(new TeleGraphConfigEntity());
				}
			}
		}
		// 3.获取报表相关参数，供预览使用
		Map<String, Object> param = null;
		TeleGraph teleGraph = this.getTeleGraphById(id);
		// 判断用印审批为是否为true，如果是，则显示公章，否则不显示。
		if (teleGraph.getCachetApprove() == 0) {
			param = jasperReportService.preView(request, datasource,
					subreportDatasource, reportName);
		} else {
			param = jasperReportService.preView(request, datasource,
					subreportDatasource, ImageNameEnum.atncCachet.getValue(),
					reportName);
		}
		return param;
	}

	@Override
	public List<TeleGraph> getListSendMessage() {
		return teleGraphDao.getListSendMessage();
	}

	@Override
	public List<TeleGraph> getListSendMessageEng() {
		return teleGraphDao.getListSendMessageEng();
	}

	@Override
	public List<TeleGraph> getListSendMessageFirstCommit() {
		// TODO Auto-generated method stub
		return teleGraphDao.getListSendMessageFirstCommit();
	}
}
