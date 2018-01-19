package cn.com.atnc.ioms.mng.business.datacomnetwork.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jodd.util.StringUtil;

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
import cn.com.atnc.ioms.dao.business.datacomnetwork.IDataComNetworkDao;
import cn.com.atnc.ioms.dao.clientmng.IClientDao;
import cn.com.atnc.ioms.entity.BaseUserInfo;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.approveinfo.ApproveInfo;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetwork;
import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetworkAttach;
import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetworkConfig;
import cn.com.atnc.ioms.entity.reports.DataComNetworkEntity;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveStatusEnum;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveTypeEnum;
import cn.com.atnc.ioms.enums.business.datacomnetwork.NetWorkStatEnum;
import cn.com.atnc.ioms.enums.business.serial.SerialNameEnum;
import cn.com.atnc.ioms.enums.business.serial.SerialTypeEnum;
import cn.com.atnc.ioms.enums.reports.ImageNameEnum;
import cn.com.atnc.ioms.enums.reports.JasperReportsEnum;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.acl.IUserRoleManager;
import cn.com.atnc.ioms.mng.business.approveinfo.IApproveInfoService;
import cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkAttachService;
import cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkConfManager;
import cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkManager;
import cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkWorkflowService;
import cn.com.atnc.ioms.mng.business.serial.IApplySerialService;
import cn.com.atnc.ioms.mng.clientnotice.IClientNoticeManager;
import cn.com.atnc.ioms.mng.reports.JasperReportService;
import cn.com.atnc.ioms.model.business.datacomnetwork.DataComNetworkQueryModel;
import cn.com.atnc.ioms.util.DataSourceFactory;
import cn.com.atnc.ioms.util.JasperReportUtils;

/**
 * 数据通信网Service方法实现
 *
 * @author Wang Zhicheng
 * @date 2015年10月19日 下午2:05:12
 * @since 1.0.0
 */
@Service
@Transactional
public class DataComNetworkManagerImpl extends BaseService implements
		IDataComNetworkManager {

	@Autowired
	private IDataComNetworkDao dataComNetworkDao;
	@Autowired
	private IApplyBaseInfoDao applyBaseInfoDao;
	@Autowired
	private IClientDao clientDao;
	@Autowired
	private IDataComNetworkConfManager dataComNetworkConfManager;
	@Autowired
	private IDataComNetworkWorkflowService workflowService;
	@Autowired
	private IDataComNetworkAttachService dataComNetworkAttachService;
	@Autowired
	private IApproveInfoDao approveInfoDao;
	@Autowired
	private IClientNoticeManager clientNoticeManager;
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

	@Override
	public Pagination queryPage(DataComNetworkQueryModel queryModel) {
		return dataComNetworkDao.queryPage(queryModel);
	}

	@Override
	public List<DataComNetwork> queryList(DataComNetworkQueryModel queryModel) {
		return dataComNetworkDao.queryList(queryModel);
	}

	@Override
	public void save(DataComNetwork dataComNetwork) {
		dataComNetworkDao.save(dataComNetwork);
	}

	@Override
	public void update(DataComNetwork dataComNetwork) {
		dataComNetworkDao.update(dataComNetwork);
	}

	@Override
	public DataComNetwork findById(String id) {
		return dataComNetworkDao.findById(id);
	}

	@Override
	public DataComNetworkQueryModel getCheckModel(String id) {

		DataComNetworkQueryModel queryModel = new DataComNetworkQueryModel();
		DataComNetwork dataComNetwork = this.findById(id);
		queryModel.setDataComNetwork(dataComNetwork);
		// 设置用户评价信息
		// ApplyEvaluate applyEvaluate =
		// evalueteManager.findByABI(dataComNetwork.getApplyBaseInfo());
		// queryModel.setApplyEvaluate(applyEvaluate);
		return queryModel;
	}

	@Override
	public DataComNetwork doCheck(HttpServletRequest request, String id,
			DataComNetworkQueryModel queryModel, User user) {
		try {
			// 工作流相关
			Task task = workflowService.getTaskByProcessInstaceId(queryModel
					.getPid());
			Map<String, Object> taskVariables = new HashMap<String, Object>();
			// 获取数据通信网实体
			DataComNetwork dataComNetwork = this.findById(id);
			DataComNetworkConfig config = dataComNetwork
					.getDataComNetworkConfig();
			ApplyBaseInfo applyBaseInfo = dataComNetwork.getApplyBaseInfo();
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

			NetWorkStatEnum approveStat = dataComNetwork.getApproveStat();// 测试提交
			if (roleNames.toString().contains(
					"|" + RoleEnum.csLeader.name() + "|")) { // 客服领导
				if (ObjectUtils.equals(approveStat,
						NetWorkStatEnum.csleader_approve)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.csLeader.name());
					status = ApproveStatusEnum.csleader_approve;
					if (queryModel.isApproveStat()) { // 审批通过
						taskVariables.put("csLeaderReviewPass", "3");// 工作流（客服领导通过）
						dataComNetwork
								.setTaskName(NetWorkStatEnum.generalmanager_approve
										.getValue());
						dataComNetwork
								.setApproveStat(NetWorkStatEnum.generalmanager_approve);
						dataComNetwork.setAtncOpinion(queryModel
								.getApproveRemark());
						dataComNetwork.setAtncSign(user.getName());
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
							dataComNetwork
									.setTaskName(NetWorkStatEnum.csstaff_firstdeal
											.getValue());
							dataComNetwork
									.setApproveStat(NetWorkStatEnum.csstaff_firstdeal);
							rolestr = "csStaff";
						} else if (reason.equals("退回网控")){
							taskVariables.put("csLeaderReviewPass", "2"); // 工作流（退回网控）
							dataComNetwork
									.setTaskName(NetWorkStatEnum.atncleader_firstdeal
											.getValue());
							dataComNetwork
									.setApproveStat(NetWorkStatEnum.atncleader_firstdeal);
							rolestr = "atncLeader";
						}else if(reason.equals("用印审批")) {
							taskVariables.put("csLeaderReviewPass", "4"); // 工作流（退回申请用户）
							dataComNetwork
									.setTaskName(NetWorkStatEnum.fundmanager_approve
											.getValue());
							dataComNetwork
									.setApproveStat(NetWorkStatEnum.fundmanager_approve);
							rolestr = "fundmanager";
							applyBaseInfo.setLeaderCheckFlag(false);
						}
						mss = "reject";
					}

				}
				dataComNetwork.setFinalApproveOpinion(queryModel
						.getApproveRemark());
				dataComNetwork.setAtncSign(user.getName());
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.csStaff.name() + "|")) { // 客服专员
				if (ObjectUtils.equals(approveStat,
						NetWorkStatEnum.csstaff_firstdeal)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.csStaff.name());
					status = ApproveStatusEnum.csstaff_firstdeal;
					taskVariables.put("csStaffReviewComplete", "true"); // 工作流（客服专员审核）
					dataComNetwork.setTaskName(NetWorkStatEnum.csleader_approve
							.getValue());
					dataComNetwork
							.setApproveStat(NetWorkStatEnum.csleader_approve);
					rolestr = "csLeader";
				}
				if (ObjectUtils.equals(approveStat,
						NetWorkStatEnum.csstaff_deal)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.csStaff.name());
					status = ApproveStatusEnum.csstaff_deal;
					taskVariables.put("csStaffPass", "true"); // 工作流（客服专员办理）
					dataComNetwork
							.setTaskName(NetWorkStatEnum.atncleader_seconddeal
									.getValue());
					dataComNetwork
							.setApproveStat(NetWorkStatEnum.atncleader_seconddeal);
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
							NetWorkStatEnum.atncleader_firstdeal)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_firstdeal;
						taskVariables.put("atncLeaderDistribute", "true");// 工作流（网控领导交办审核）
						dataComNetwork
								.setTaskName(NetWorkStatEnum.engineer_firstaudit
										.getValue());
						// 记录选择的审核工程师，工程师审核时使用
						String auditEngineer = queryModel.getAuditEngineer();
						applyBaseInfo.setNextUser(auditEngineer);
						dataComNetwork
								.setApproveStat(NetWorkStatEnum.engineer_firstaudit);
						// --------------------------更新配置实体------------------------
						config.setAtncLeader(user.getName());
						dataComNetworkConfManager.update(config);
						// 设置下一步操作信息（审批记录使用）
						User nextuser = userManager.findById(queryModel
								.getAuditEngineer());
						nextusername = nextuser.getName();
						nextusertel = nextuser.getMobilephone();
						mss = "agree";
						msgn = "尊敬的用户:" + nextusername + ",您好！您有一条["
								+ applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
						// ------------------------------------------------------------
					} else if (ObjectUtils.equals(approveStat,
							NetWorkStatEnum.atncleader_approve)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_approve;
						taskVariables.put("atncLeaderReviewPass", "true"); // 工作流（网控领导审核）
						dataComNetwork
								.setTaskName(NetWorkStatEnum.netmanager_approve
										.getValue());
						dataComNetwork
								.setApproveStat(NetWorkStatEnum.netmanager_approve);
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
							NetWorkStatEnum.atncleader_seconddeal)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_seconddeal;
						taskVariables.put("atncLeaderDistribute", "true");// 工作流（网控领导交办配置）
						dataComNetwork
								.setTaskName(NetWorkStatEnum.engineer_config
										.getValue());
						// 记录选择的配置工程师
						String engineerId = queryModel.getEngineer();
						applyBaseInfo.setNextUser(engineerId);
						dataComNetwork
								.setApproveStat(NetWorkStatEnum.engineer_config);
						// --------------------------更新配置实体------------------------
						config.setAtncLeader(user.getName());
						dataComNetworkConfManager.update(config);
						// 设置下一步操作信息（审批记录使用）
						User nextuser = userManager.findById(engineerId);
						nextusername = nextuser.getName();
						nextusertel = nextuser.getMobilephone();
						mss = "agree";
						msgn = "尊敬的用户:"
								+ userManager.findById(engineerId).getName()
								+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
						// ------------------------------------------------------------
					} else if (ObjectUtils.equals(approveStat,
							NetWorkStatEnum.atncleader_thirddeal)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_thirddeal;
						taskVariables.put("atncLeaderDistribute", "true");// 工作流（网控领导交办配置）
						dataComNetwork
								.setTaskName(NetWorkStatEnum.engineer_secondaudit
										.getValue());
						// 记录选择的审核工程师
						String auditEngineer = queryModel.getAuditEngineer();
						applyBaseInfo.setNextUser(auditEngineer);
						dataComNetwork
								.setApproveStat(NetWorkStatEnum.engineer_secondaudit);
						// --------------------------更新配置实体------------------------
						config.setAtncLeader(user.getName());
						dataComNetworkConfManager.update(config);
						// 设置下一步操作信息（审批记录使用）
						User nextuser = userManager.findById(auditEngineer);
						nextusername = nextuser.getName();
						nextusertel = nextuser.getMobilephone();
						mss = "agree";
						msgn = "尊敬的用户:"
								+ userManager.findById(auditEngineer).getName()
								+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
						// ------------------------------------------------------------
					} 
				} else { // 审批退回
					if (ObjectUtils.equals(approveStat,
							NetWorkStatEnum.atncleader_approve)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.atncLeader.name());
						status = ApproveStatusEnum.atncleader_approve;
						taskVariables.put("atncLeaderReviewPass", "false"); // 工作流（网控领导审核）
						dataComNetwork
								.setTaskName(NetWorkStatEnum.engineer_firstaudit
										.getValue());
						applyBaseInfo.setNextUser(applyBaseInfo.getLastUser());
						dataComNetwork
								.setApproveStat(NetWorkStatEnum.engineer_firstaudit);
						msgn = "尊敬的用户:"
								+ userManager.findById(
										applyBaseInfo.getLastUser()).getName()
								+ ",您好！您有一条[" + applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					}
					mss = "reject";
				}
				if (!ObjectUtils.equals(approveStat,
						NetWorkStatEnum.atncleader_seconddeal)) {
					dataComNetwork
							.setAtncOpinion(queryModel.getApproveRemark());
					dataComNetwork.setFinalApproveOpinion(queryModel
							.getApproveRemark());
					dataComNetwork.setAtncSign(user.getName());
				}
				dataComNetwork.setFinalApproveCom("北京天航信民航通信网络发展有限公司");
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.engineer.name() + "|")) { // 工程师

				if (queryModel.isApproveStat()) {// 配置
					// 获取配置实体
					if (ObjectUtils.equals(approveStat,
							NetWorkStatEnum.engineer_firstaudit)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_firstaudit;
						taskVariables.put("engineerAuditComplete", "true"); // 工作流（工程师初审）
						applyBaseInfo.setLastUser(user.getId());
						dataComNetwork
								.setTaskName(NetWorkStatEnum.atncleader_approve
										.getValue());
						dataComNetwork
								.setApproveStat(NetWorkStatEnum.atncleader_approve);
						mss = "agree";
						rolestr = "atncLeader";
					} else if (ObjectUtils.equals(approveStat,
							NetWorkStatEnum.engineer_config)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_config;
						taskVariables.put("transfer", "false"); // 工作流（工程师配置）
						dataComNetwork
								.setTaskName(NetWorkStatEnum.atncleader_thirddeal
										.getValue());
						applyBaseInfo.setLastUser(user.getId());
						applyBaseInfo
								.setLastStatusEnum(NetWorkStatEnum.engineer_config
										.name());
						dataComNetwork
								.setApproveStat(NetWorkStatEnum.atncleader_thirddeal);
						// --------------------------更新操作人------------------------
						config.setOperateUser(user.getName());
						queryModel.setApproveRemark(config.getRemark());
						rolestr = "atncLeader";
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
							NetWorkStatEnum.engineer_transfer)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_transfer;
						taskVariables.put("assistConfig", "true"); // 工作流（工程师协助配置）
						dataComNetwork
								.setTaskName(NetWorkStatEnum.atncleader_thirddeal
										.getValue());
						applyBaseInfo.setLastUser(user.getId());
						applyBaseInfo
								.setLastStatusEnum(NetWorkStatEnum.engineer_transfer
										.name());
						dataComNetwork
								.setApproveStat(NetWorkStatEnum.atncleader_thirddeal);
						// --------------------------更新操作人------------------------
						config.setOperateUser(user.getName());
						queryModel.setApproveRemark(config.getRemark());
						rolestr = "atncLeader";
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
							NetWorkStatEnum.engineer_secondaudit)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_secondaudit;
						taskVariables.put("engineerAuditPass", "3"); // 工作流（工程师二次审核）
						dataComNetwork
								.setTaskName(ApproveStatusEnum.unevaluate.getValue());
						dataComNetwork
								.setApproveStat(NetWorkStatEnum.unevaluate);
						// --------------------------更新配置实体------------------------
						config.setOperateTime(Calendar.getInstance());
						config.setOperateUser(user.getName());
						msg = "尊敬的用户:"
								+ dataComNetwork.getApplyBaseInfo()
										.getApplyLinkman() + ",您好！您有一条["
								+ applyBaseInfo.getApplyType()
								+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
					}
					dataComNetworkConfManager.update(config);
					mss = "agree";
				} else {
					if (ObjectUtils.equals(approveStat,
							NetWorkStatEnum.engineer_config)) { // 移交其他工程师
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_config;
						taskVariables.put("transfer", "true"); // 工作流（工程师移交）
						dataComNetwork
								.setTaskName(NetWorkStatEnum.engineer_transfer
										.getValue());
						String engineerId = queryModel.getEngineer();
						dataComNetwork
								.setApproveStat(NetWorkStatEnum.engineer_transfer);
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
							NetWorkStatEnum.engineer_secondaudit)) { // 审核工程师退回
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.engineer.name());
						status = ApproveStatusEnum.engineer_secondaudit;
						String lastUserId = applyBaseInfo.getLastUser();
						String lastStatus = applyBaseInfo.getLastStatusEnum();
						if (StringUtils.equalsIgnoreCase(lastStatus,
								NetWorkStatEnum.engineer_config.name())) {
							// 如果是正常工程师配置的，则退回给正常工程师
							taskVariables.put("engineerAuditPass", "1"); // 工作流（工程师审核未通过）
							dataComNetwork
									.setApproveStat(NetWorkStatEnum.engineer_config);
							dataComNetwork
									.setTaskName(NetWorkStatEnum.engineer_config
											.getValue());
						} else if (StringUtils.equalsIgnoreCase(lastStatus,
								NetWorkStatEnum.engineer_transfer.name())) {
							// 如果是移交工程师配置的，则退回给移交工程师
							taskVariables.put("engineerAuditPass", "2"); // 工作流（工程师审核未通过）
							dataComNetwork
									.setApproveStat(NetWorkStatEnum.engineer_transfer);
							dataComNetwork
									.setTaskName(NetWorkStatEnum.engineer_transfer
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
						NetWorkStatEnum.generalmanager_approve)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.manager.name());
					status = ApproveStatusEnum.generalmanager_approve;
					taskVariables.put("generalManagerPass", "true"); // 工作流（网控总经理审核）
					dataComNetwork
							.setTaskName(NetWorkStatEnum.compenyleader_approve
									.getValue());
					dataComNetwork
							.setApproveStat(NetWorkStatEnum.compenyleader_approve);
					if (queryModel.getApply() != null) {
						if (queryModel.getApply()) {
							mss = "consent";
						} else {
							mss = "disconsent";
						}
					} else {
						mss = "agree";
					}
					dataComNetwork.setFinalApproveOpinion(queryModel
							.getApproveRemark());
					dataComNetwork.setAtncSign(user.getName());
					rolestr = "leader";
				}
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.netmanager.name() + "|")) { // 网控总经理
				if (ObjectUtils.equals(approveStat,
						NetWorkStatEnum.netmanager_approve)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.netmanager.name());
					status = ApproveStatusEnum.netmanager_approve;
					taskVariables.put("netManagerPass", "true"); // 工作流（网控总经理审核）
					dataComNetwork
							.setTaskName(NetWorkStatEnum.csstaff_firstdeal
									.getValue());
					dataComNetwork
							.setApproveStat(NetWorkStatEnum.csstaff_firstdeal);
					if (queryModel.getApply() != null) {
						if (queryModel.getApply()) {
							mss = "consent";
						} else {
							mss = "disconsent";
						}
					} else {
						mss = "agree";
					}
					dataComNetwork.setFinalApproveOpinion(queryModel
							.getApproveRemark());
					dataComNetwork.setAtncSign(user.getName());
					rolestr = "csStaff";
				}
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.leader.name() + "|")) { // 公司领导
				if (queryModel.isApproveStat()) { // 审批通过
					if (ObjectUtils.equals(approveStat,
							NetWorkStatEnum.compenyleader_approve)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.leader.name());
						status = ApproveStatusEnum.compenyleader_approve;
						taskVariables.put("leaderPass", "true"); // 工作流（公司领导审核）
						dataComNetwork
								.setTaskName(NetWorkStatEnum.fundmanager_approve
										.getValue());
						dataComNetwork
								.setApproveStat(NetWorkStatEnum.fundmanager_approve);
						// 生成正式的申请编号
						applyBaseInfo.setSerialNumber(applySerialService
								.createSerialNumber(SerialNameEnum.RW,
										SerialTypeEnum.SJ));
						// 设置审批字段
						applyBaseInfo.setLeaderCheckFlag(true);
						mss = "consent";
						rolestr = "fundmanager";
					}
				} else {
					if (ObjectUtils.equals(approveStat,
							NetWorkStatEnum.compenyleader_approve)) {
						// 判断是否为代理人
						isTransfer = userRoleManager.judgeIsTransfer(user,
								RoleEnum.leader.name());
						status = ApproveStatusEnum.compenyleader_approve;
						taskVariables.put("leaderPass", "true"); // 工作流（公司领导审核）
						dataComNetwork
								.setTaskName(NetWorkStatEnum.fundmanager_approve
										.getValue());
						dataComNetwork
								.setApproveStat(NetWorkStatEnum.fundmanager_approve);
						// 设置审批字段
						applyBaseInfo.setLeaderCheckFlag(false);
						rolestr = "fundmanager";
						mss = "disconsent";
					}
				}
				dataComNetwork.setFinalApproveOpinion(queryModel
						.getApproveRemark());
				dataComNetwork.setAtncSign(user.getName());
			}
			if (roleNames.toString().contains(
					"|" + RoleEnum.fundmanager.name() + "|")) { // 财务部经理
				if (ObjectUtils.equals(approveStat,
						NetWorkStatEnum.fundmanager_approve)) {
					// 判断是否为代理人
					isTransfer = userRoleManager.judgeIsTransfer(user,
							RoleEnum.fundmanager.name());
					status = ApproveStatusEnum.fundmanager_approve;
					dataComNetwork.setCachetApprove(Integer.valueOf(1));
					if (applyBaseInfo.getLeaderCheckFlag()) { // 公司领导是否通过
						taskVariables.put("fundManagerConfirm", "true"); // 工作流（网控总经理审核）
						dataComNetwork.setTaskName(NetWorkStatEnum.csstaff_deal
								.getValue());
						dataComNetwork
								.setApproveStat(NetWorkStatEnum.csstaff_deal);
						if (queryModel.getApply() != null) {
							if (queryModel.getApply()) {
								mss = "consent";
							} else {
								mss = "disconsent";
							}
						} else {
							mss = "confirm";
						}
						rolestr = "csStaff";
					} else {
						// 退回流程
						taskVariables.put("fundManagerConfirm", "false"); // 工作流（公司领导审核）
						queryModel.setApproveStat(false);
						// 申请人所在管局
						Bureau bureau = dataComNetwork.getApplyBaseInfo()
								.getApplyUser().getBureau();
						if (!ObjectUtils.equals(bureau, null)) {
							bureau = Bureau.isBelong7Bureau(bureau.getValue());
						}
						if (!ObjectUtils.equals(bureau, null)) { // 申请人属于7大管局
							taskVariables
									.put("needAreaExaminerConfirm", "true");
							dataComNetwork
									.setTaskName(NetWorkStatEnum.areaexaminer_affirm
											.getValue());
							dataComNetwork
									.setApproveStat(NetWorkStatEnum.areaexaminer_affirm);
							msg = "尊敬的用户:"
									+ dataComNetwork.getApplyBaseInfo()
											.getInitLinkman()
									+ ",您好！您有一条["
									+ applyBaseInfo.getApplyType()
									+ "]业务待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
						} else {
							taskVariables.put("needAreaExaminerConfirm",
									"false");
							dataComNetwork.setTaskName(NetWorkStatEnum.returned
									.getValue());
							dataComNetwork
									.setApproveStat(NetWorkStatEnum.returned);
							msg = "尊敬的用户:"
									+ dataComNetwork.getApplyBaseInfo()
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
						this.getReportParams(request, dataComNetwork.getId(),
								JasperReportsEnum.datacom_apply.toString());
						absoluteAddress = JasperReportUtils
								.saveReturedApplyList(number,
										applyBaseInfo.getId(), request,
										JasperReportsEnum.datacom_apply.name());
					}
				}
			}
			//添加审核人
			applyBaseInfo.setApproveUsers(applyBaseInfo.getApproveUsers() == null ? user.getName() 
					: applyBaseInfo.getApproveUsers() + "," + user.getName());
			applyBaseInfoDao.update(applyBaseInfo); // 更新申请基础信息表
			dataComNetworkDao.update(dataComNetwork); // 更新转报地址申请表
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
			approveInfo.setApproveStatus(status);
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
			approveInfoDao.save(approveInfo);
			// 发送短信给客户
			if (!StringUtils.isEmpty(msg)
					&& !StringUtils.isEmpty(dataComNetwork.getApplyBaseInfo()
							.getApplyPhone())) {
				BaseUserInfo baseUserInfo = new BaseUserInfo();
				// 若是退回状态发给区管，若不是发给申请人
				if (dataComNetwork.getApproveStat().equals(
						NetWorkStatEnum.areaexaminer_affirm)) {
					baseUserInfo.setLoginName(dataComNetwork.getApplyBaseInfo()
							.getInitLinkman());
					baseUserInfo.setMobilephone(dataComNetwork
							.getApplyBaseInfo().getInitLinkphone());
				} else {
					baseUserInfo.setLoginName(dataComNetwork.getApplyBaseInfo()
							.getApplyLinkman());
					baseUserInfo.setMobilephone(dataComNetwork
							.getApplyBaseInfo().getApplyPhone());
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
			return dataComNetwork;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("处理表单信息出错，原因是：" + e.getMessage());
		}
	}

	@Override
	public DataComNetworkQueryModel setModel(DataComNetworkQueryModel queryModel) {

		queryModel.setFlag(true);
		queryModel.setApplyDate(queryModel.getDataComNetwork()
				.getApplyBaseInfo().getApplyDate());
		return queryModel;
	}

	@Override
	public DataComNetworkQueryModel getViewModel(ApplyBaseInfo applyBaseInfo) {
		DataComNetwork dataComNetwork = this.findByApplyBaseInfo(applyBaseInfo);
		DataComNetworkQueryModel FCModel = this.getCheckModel(dataComNetwork
				.getId());
		return FCModel;
	}

	private DataComNetwork findByApplyBaseInfo(ApplyBaseInfo applyBaseInfo) {
		return dataComNetworkDao.findByApplyBaseInfo(applyBaseInfo).get(0);
	}

	@Override
	public DataComNetwork findByApplyBaseInfo(String id) {
		ApplyBaseInfo applyBaseInfo = applyBaseInfoDao.findById(id);
		DataComNetwork dataComNetwork = this.findByApplyBaseInfo(applyBaseInfo);
		return dataComNetwork;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkManager#getDCNConfig(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void getDCNConfig(String id, String placeATM, String placeATMO,
			String connectivity, String nodemng, String confRemark) {

		DataComNetworkConfig dataComNetworkConfig = this.findById(id)
				.getDataComNetworkConfig();
		if (StringUtil.isNotEmpty(confRemark)) {
			dataComNetworkConfig.setPlaceATM(placeATM);
			dataComNetworkConfig.setPlaceATMO(placeATMO);
			if (connectivity.equals("1")) {
				dataComNetworkConfig.setConnectivity(true);
			} else {
				dataComNetworkConfig.setConnectivity(false);
			}
			if (nodemng.equals("1")) {
				dataComNetworkConfig.setNodemng(true);
			} else {
				dataComNetworkConfig.setNodemng(false);
			}
			dataComNetworkConfig.setRemark(confRemark);
		}
		dataComNetworkConfManager.update(dataComNetworkConfig);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getReportParams(HttpServletRequest request,
			String id, String reportName) {
		// 1.主报表数据源
		List<DataComNetworkEntity> entity = null;
		List<DataComNetwork> datasource = null;
		if (StringUtils.equalsIgnoreCase(reportName,
				JasperReportsEnum.datacom_apply.name())) {
			entity = jasperReportService.getDataComNetworkDatasource(id);
			datasource = (List<DataComNetwork>) DataSourceFactory
					.getBeanCollection(entity);
		} else if (StringUtils.equalsIgnoreCase(reportName,
				JasperReportsEnum.datacom_record.name())) {
			entity = jasperReportService.getDataComNetworkConfigsource(id);
			datasource = (List<DataComNetwork>) DataSourceFactory
					.getBeanCollection(entity);
		}
		// 2.获取报表相关参数，供预览使用
		Map<String, Object> param = null;
		DataComNetwork dataComNetwork = this.findById(id);
		// 判断用印审批为是否为true，如果是，则显示公章，否则不显示。
		if (dataComNetwork.getCachetApprove() == 0) {
			param = jasperReportService
					.preView(request, datasource, reportName);
		} else {
			param = jasperReportService.preView(request, datasource,
					ImageNameEnum.atncCachet.getValue(), reportName);
		}
		// 判断上传了哪些附件（申请表）
		if (StringUtils.equalsIgnoreCase(reportName,
				JasperReportsEnum.datacom_apply.name())) {
			List<DataComNetworkAttach> comNetworkAttachs = dataComNetworkAttachService
					.queryListByDCNId(id);
			if (!CollectionUtils.isEmpty(comNetworkAttachs)) {
				for (DataComNetworkAttach comNetworkAttach : comNetworkAttachs) {
					switch (comNetworkAttach.getAttachType()) {
					case one:
						param.put("MATERIAL1", "1");
						break;
					case two:
						param.put("MATERIAL2", "1");
						break;
					case three:
						param.put("MATERIAL3", "1");
						break;
					default:
						break;
					}
				}
			}
		}
		return param;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkManager#getListSendMessage()
	 */
	@Override
	public List<DataComNetwork> getListSendMessage() {
		return dataComNetworkDao.getListSendMessage();
	}
}
