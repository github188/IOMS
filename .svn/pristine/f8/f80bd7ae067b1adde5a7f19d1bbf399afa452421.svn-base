package cn.com.atnc.ioms.web.tempcircuit;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.task.Task;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.ioms.entity.BaseUserInfo;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuit;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuitOptLog;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuitTesKuBroad;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitCancelType;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitExpireType;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitOptType;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitStatus;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitType;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.basedata.equip.IEquipService;
import cn.com.atnc.ioms.mng.clientmng.IClientManager;
import cn.com.atnc.ioms.mng.clientnotice.IClientNoticeManager;
import cn.com.atnc.ioms.mng.tempcircuit.ITempCircuitMngService;
import cn.com.atnc.ioms.mng.tempcircuit.ITempCircuitOptLogMngService;
import cn.com.atnc.ioms.mng.tempcircuit.ITempCircuitTesKuBroadService;
import cn.com.atnc.ioms.mng.tempcircuit.ITempCircuitWorkflowService;
import cn.com.atnc.ioms.model.tempcircuit.TempCircuitQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 
 * 类说明：临时电路控制器
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月27日下午2:50:32
 * @version:1.0
 */

@Controller("tempCircuitController")
@RequestMapping("/tempcircuit/")
public class TempCircuitController extends MyBaseController {
	@Autowired
	private ITempCircuitMngService tempCircuitMngService;
	@Autowired
	private ITempCircuitOptLogMngService tempCircuitOptLogMngService;
	@Autowired
	private IUserManager userManager;
	@Autowired
	private ITempCircuitWorkflowService workflowService;
	@Autowired
	private IEquipService equipService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private IdentityService identityService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private IClientManager clientManager;
	@Autowired
	private IClientNoticeManager clientNoticeManager;
	@Autowired
	private ITempCircuitTesKuBroadService tempCircuitTesKuBroadService;

	/**
	 * 
	 * 方法说明：临时电路开通页面GET
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月2日上午9:06:18
	 * @param model
	 * @param request
	 * @return String
	 * 
	 */
	@RequestMapping(value = "tempCircuitApply.do", method = RequestMethod.GET)
	public String tempCircuitApply(
			@ModelAttribute("pageModel") TempCircuit tempCircuit, Model model,
			HttpServletRequest request) {
		User user = getCurrentUser(request);
		model.addAttribute("user", user);
		model.addAttribute("circuitTypes", CircuitType.values());
		model.addAttribute("pageModel", tempCircuit);
		return "tempcircuit/apply";
	}

	/**
	 * 
	 * 方法说明：临时电路开通页面POST
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年3月28日上午9:04:09
	 * @param tempCircuit
	 * @param request
	 * @param model
	 * @return String
	 * @throws IOException
	 * 
	 */
	@RequestMapping(value = "addApply.do", method = RequestMethod.POST)
	public String addApply(HttpServletRequest request, Model model,
			@ModelAttribute("pageModel") TempCircuit tempCircuit)
			throws IOException {
		logger.debug("tempCircuit.getPlanOpenTime()"
				+ tempCircuit.getPlanOpenTime().getTime());
		try {
			User client = getCurrentUser(request);
			tempCircuit.setNumber(tempCircuitMngService
					.getCircuitNumByType(tempCircuit.getCircuitType()));
			tempCircuit.setApplyUserId(client.getId());
			tempCircuit.setApplyUserName(client.getName());
			tempCircuit.setAuditerList("|" + client.getLoginName() + "|");
			tempCircuit.setaEquip(equipService.findById(tempCircuit
					.getaEquipID()));
			tempCircuit.setzEquip(equipService.findById(tempCircuit
					.getzEquipID()));
			Calendar calendar = (Calendar) tempCircuit.getPlanOpenTime()
					.clone();
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DATE, 1);
			tempCircuit.setPlanEndTime(calendar);
			tempCircuit.setCircuitCancelType(CircuitCancelType.NOTDELETE);
			tempCircuit.setCircuitExpireType(CircuitExpireType.NORMAL);
			tempCircuit.setCircuitStatus(CircuitStatus.ATNCSUBMITTED);
			tempCircuit.setRecordTime(Calendar.getInstance());
			tempCircuit.setUpdateTime(Calendar.getInstance());
			tempCircuit.setCircuitApplyType(CircuitStatus.ATNCSUBMITTED);
			tempCircuit.setAtncaudit(true);
			Map<String, Object> variables = new HashMap<String, Object>();
			workflowService.startWorkflow(tempCircuit, variables);
			// 添加TempCircuitTesKuBroad
			String[] equipIDs = request.getParameterValues("zEquipIdSelect");
			for (int i = 0; i < equipIDs.length / 2; i++) {
				TempCircuitTesKuBroad tempCircuitTesKuBroad = new TempCircuitTesKuBroad();
				tempCircuitTesKuBroad.setTempCircuit(tempCircuit);
				tempCircuitTesKuBroad.setCircuitType(tempCircuit
						.getCircuitType());
				tempCircuitTesKuBroad.setNode(equipIDs[i]);
				tempCircuitTesKuBroadService.add(tempCircuitTesKuBroad);
			}
			super.addLog(request, "网控工程师提交电路申请 " + tempCircuit.getNumber());

			TempCircuitOptLog tempCircuitOptLog = new TempCircuitOptLog();
			tempCircuitOptLog.setTempCircuit(tempCircuit);
			tempCircuitOptLog.setOptUser(tempCircuit.getApplyUserName());
			tempCircuitOptLog.setToStatus(CircuitStatus.ATNCSUBMITTED);
			tempCircuitOptLog.setcircuitOptType(CircuitOptType.ATNCSUBMITTED);
			tempCircuitOptLog.setCircuitInfo(tempCircuit.getCircuitInfo());
			tempCircuitOptLog.setOptTime(tempCircuit.getUpdateTime());
			tempCircuitOptLogMngService.add(tempCircuitOptLog);

		} catch (ActivitiException e) {
			if (e.getMessage().indexOf("no processes deployed with key") != -1) {
				logger.warn("没有部署流程!", e);
				model.addAttribute("returnStr", new ResultModel(false,
						"没有部署流程!", tempCircuit).toJson());
				return "returnnote";
			} else {
				logger.error("启动流程失败!", e);
				model.addAttribute("returnStr", new ResultModel(false,
						"启动流程失败!", tempCircuit).toJson());
				return "returnnote";
			}
		} catch (Exception e) {
			logger.error("启动流程失败!", e);
			model.addAttribute("returnStr", new ResultModel(false, "启动流程失败",
					tempCircuit).toJson());
			return "returnnote";
		}
		model.addAttribute("returnStr",
				new ResultModel(true, "", tempCircuit).toJson());
		return "returnnote";
	}

	/**
	 * 
	 * 方法说明：修改临时电路申请页面GET
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年5月21日下午4:08:08
	 * @param tempcircuitid
	 * @param tempCircuit
	 * @param model
	 * @param request
	 * @return String
	 * 
	 */
	@RequestMapping(value = "modApply.do", method = RequestMethod.GET)
	public String modApply(@RequestParam("tempcircuitid") String tempcircuitid,
			@ModelAttribute("pageModel") TempCircuit tempCircuit, Model model,
			HttpServletRequest request) {
		model.addAttribute("pageModel",
				tempCircuitMngService.getTempCircuitByID(tempcircuitid));
		model.addAttribute("tempCircuitTesKuBroad",
				tempCircuitTesKuBroadService
						.findListByTempcircuitID(tempcircuitid));
		return "tempcircuit/applyMod";
	}

	/**
	 * 
	 * 方法说明：修改临时电路申请页面POST
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年5月13日下午3:46:13
	 * @param request
	 * @param model
	 * @param tempCircuit
	 * @return
	 * @throws IOException
	 *             String
	 * 
	 */
	@RequestMapping(value = "modApply.do", method = RequestMethod.POST)
	public String modApply(HttpServletRequest request, Model model,
			@ModelAttribute("pageModel") TempCircuit tempCircuit)
			throws IOException {
		TempCircuit tempCircitDB = tempCircuitMngService
				.getTempCircuitByID(tempCircuit.getId());
		tempCircitDB.setApplyCompany(tempCircuit.getApplyCompany());
		tempCircitDB.setLinkMan(tempCircuit.getLinkMan());
		tempCircitDB.setLinkEmail(tempCircuit.getLinkEmail());
		tempCircitDB.setLinkPhone(tempCircuit.getLinkPhone());
		tempCircitDB.setUpdateTime(Calendar.getInstance());
		tempCircitDB.setCircuitType(tempCircuit.getCircuitType());
		tempCircitDB
				.setaEquip(equipService.findById(tempCircuit.getaEquipID()));
		tempCircitDB
				.setzEquip(equipService.findById(tempCircuit.getzEquipID()));
		tempCircitDB.setCircuitInfo(tempCircuit.getCircuitInfo());
		tempCircitDB.setNumber(tempCircuitMngService
				.getCircuitNumByType(tempCircuit.getCircuitType()));
		tempCircitDB.setPlanOpenTime(tempCircuit.getPlanOpenTime());
		Calendar calendar = (Calendar) tempCircuit.getPlanOpenTime().clone();
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DATE, 1);
		tempCircitDB.setPlanEndTime(calendar);
		tempCircuitMngService.update(tempCircitDB);
		// 添加TempCircuitTesKuBroad
		String[] equipIDs = request.getParameterValues("zEquipIdSelect");
		List<TempCircuitTesKuBroad> listTesKuBroad = tempCircuitTesKuBroadService
				.findListByTempcircuitID(tempCircuit.getId());
		if (listTesKuBroad.size() > 0)
			tempCircuitTesKuBroadService
					.CancleTempCircuitTesKuBroadList(listTesKuBroad);

		for (int i = 0; i < equipIDs.length / 2; i++) {
			TempCircuitTesKuBroad tempCircuitTesKuBroad = new TempCircuitTesKuBroad();
			tempCircuitTesKuBroad.setTempCircuit(tempCircitDB);
			tempCircuitTesKuBroad.setCircuitType(tempCircitDB.getCircuitType());
			tempCircuitTesKuBroad.setNode(equipIDs[i]);
			tempCircuitTesKuBroadService.add(tempCircuitTesKuBroad);
		}
		model.addAttribute("returnStr",
				new ResultModel(true, "", tempCircitDB).toJson());
		return "returnnote";
	}

	/**
	 * 
	 * 方法说明：临时电路审批页面
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月17日下午2:35:33
	 * @param tempcircuitid
	 * @param tempcircuitpi
	 * @param circuitStatus
	 * @param model
	 * @param request
	 * @return String
	 * 
	 */
	@RequestMapping(value = "audit.do", method = RequestMethod.GET)
	public String tempCircuitAudit(
			@RequestParam("tempcircuitid") String tempcircuitid,
			@RequestParam("tempcircuitpi") String tempcircuitpi,
			@RequestParam("circuitStatus") String circuitStatus, Model model,
			HttpServletRequest request) {
		model.addAttribute("tempCircuitOptLogs", tempCircuitOptLogMngService
				.findByTempcircuitID(tempCircuitMngService.getTempCircuitByID(
						tempcircuitid).getId()));
		model.addAttribute("engineers", userManager.getUserByRole("engineer"));
		model.addAttribute("tempcircuitid", tempcircuitid);
		model.addAttribute("tempcircuitpi", tempcircuitpi);
		model.addAttribute("circuitStatus", circuitStatus);
		model.addAttribute("circuitTypeList", CircuitType.values());
		model.addAttribute("circuitType", tempCircuitMngService
				.getTempCircuitByID(tempcircuitid).getCircuitType());
		if (StringUtils.equals(circuitStatus, CircuitStatus.LOCALPASSED.name())
				|| StringUtils.equals(circuitStatus,
						CircuitStatus.ATNCSUBMITTED.name())) {
			return "tempcircuit/leaderaudit";
		} else if (StringUtils.equals(circuitStatus,
				CircuitStatus.ATNCPASSED.name())) {
			model.addAttribute("engineers", userManager.getUserByRoleDelSpeci(
					"engineer", getCurrentUser(request).getId()));
			return "tempcircuit/engineeraudit";
		} else if (StringUtils.equals(circuitStatus,
				CircuitStatus.MODIFIED.name())) {
			model.addAttribute("pageModel",
					tempCircuitMngService.getTempCircuitByID(tempcircuitid));
			return "tempcircuit/engineermod";
		} else {
			return "tempcircuit/engineertransaudit";
		}
	}

	/**
	 * 
	 * 方法说明：临时电路审批
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月17日下午2:35:48
	 * @param pass
	 * @param remark
	 * @param tempCircuitid
	 * @param tempcircuitpi
	 * @param request
	 * @param model
	 * @return String
	 * @throws IOException
	 * 
	 */
	@RequestMapping(value = "auditApply.do", method = RequestMethod.POST)
	public String auditApply(@RequestParam("pass") boolean pass,
			@RequestParam("remark") String remark,
			@RequestParam("tempcircuitid") String tempCircuitid,
			@RequestParam("tempcircuitpi") String tempcircuitpi,
			HttpServletRequest request, Model model) throws IOException {
		try {
			Map<String, Object> taskVariables = new HashMap<String, Object>();
			TempCircuitOptLog tempCircuitOptLog = new TempCircuitOptLog();
			TempCircuit tempCircuit = tempCircuitMngService
					.getTempCircuitByID(tempCircuitid);
			User user = getCurrentUser(request);
			// client和applyUser主要分别对应地方工程师和网控工程师申请电路
			// Client client = new Client();
			// User applyUser = new User();
			String log = "";
			String msg = "";
			
			String msg_1 = "尊敬的用户:";
			String msg_2 = ",您好！您有一条[";
			String msg_3 = "]类型的临时电路待办理，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
			String msg_4 = "]类型的临时电路已退回，请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]";
			
			logger.debug("getCircuitStatus:" + tempCircuit.getCircuitStatus());
			logger.debug("pass:" + pass);
			switch (tempCircuit.getCircuitStatus()) {
			// 网控工程师提交的临时电路开通申请，网控领导的处理过程
			case ATNCSUBMITTED:
				String engineer = request.getParameter("engineer");
				logger.debug("engineer:" + engineer);
				taskVariables.put("atncLeaderPass", pass);
				taskVariables.put("engineer", engineer);
				tempCircuitOptLog.setcircuitOptType(CircuitOptType.ATNCOPT);
				tempCircuitOptLog.setFromStatus(CircuitStatus.ATNCSUBMITTED);
				tempCircuitOptLog.setCircuitInfo(remark);
				if (pass) {
					// 网控领导审批通过
					tempCircuitOptLog.setToStatus(CircuitStatus.ATNCPASSED);
					tempCircuit.setCircuitStatus(CircuitStatus.ATNCPASSED);
					log = "网控经理审批电路申请 " + tempCircuit.getNumber()
							+ " 通过！指定工程师："
							+ userManager.findById(engineer).getName();
					if (!StringUtils.isEmpty(userManager.findById(engineer).getMobilephone())) {
						BaseUserInfo baseUserInfo = new BaseUserInfo();
						baseUserInfo.setLoginName(userManager.findById(engineer).getLoginName());
						baseUserInfo.setMobilephone(userManager.findById(engineer).getMobilephone());
						clientNoticeManager.sendMessage(baseUserInfo,
								msg_1 + userManager.findById(engineer).getName() + msg_2
										+ tempCircuit.getCircuitType() + msg_3);
					}
				} else {
					// 网控领导审批拒绝
					tempCircuitOptLog.setToStatus(CircuitStatus.ATNCDENIED);
					tempCircuit.setCircuitStatus(CircuitStatus.MODIFIED);
					log = "网控经理审批电路申请" + tempCircuit.getNumber() + " 不通过！";
					if (!StringUtils.isEmpty(tempCircuit.getLinkPhone())) {
						BaseUserInfo baseUserInfo = new BaseUserInfo();
						baseUserInfo.setLoginName(tempCircuit.getLinkMan());
						baseUserInfo.setMobilephone(tempCircuit.getLinkPhone());
						clientNoticeManager.sendMessage(baseUserInfo,
								msg_1 + tempCircuit.getLinkMan() + msg_2
										+ tempCircuit.getCircuitType() + msg_4);
					}
				}
				break;
			// 地方工程师提交的临时电路开通申请，且地方区管领导审批通过后，网控领导的处理过程
			case LOCALPASSED:
				engineer = request.getParameter("engineer");
				logger.debug("engineer:" + engineer);
				taskVariables.put("atncLeaderPass", pass);
				taskVariables.put("engineer", engineer);
				tempCircuitOptLog.setcircuitOptType(CircuitOptType.ATNCOPT);
				tempCircuitOptLog.setFromStatus(CircuitStatus.LOCALPASSED);
				tempCircuitOptLog.setCircuitInfo(remark);
				if (pass) {
					// 网控领导审批通过
					tempCircuitOptLog.setToStatus(CircuitStatus.ATNCPASSED);
					tempCircuit.setCircuitStatus(CircuitStatus.ATNCPASSED);
					log = "网控经理审批电路申请 " + tempCircuit.getNumber()
							+ " 通过！指定工程师："
							+ userManager.findById(engineer).getName();
					if (!StringUtils.isEmpty(userManager.findById(engineer).getMobilephone())) {
						BaseUserInfo baseUserInfo = new BaseUserInfo();
						baseUserInfo.setLoginName(userManager.findById(engineer).getLoginName());
						baseUserInfo.setMobilephone(userManager.findById(engineer).getMobilephone());
						clientNoticeManager.sendMessage(baseUserInfo,
								msg_1 + userManager.findById(engineer).getName() + msg_2
										+ tempCircuit.getCircuitType() + msg_3);
					}
				} else {
					// 网控领导审批拒绝
					tempCircuitOptLog.setToStatus(CircuitStatus.ATNCDENIED);
					tempCircuit.setCircuitStatus(CircuitStatus.MODIFIED);
					log = "网控经理审批电路申请" + tempCircuit.getNumber() + " 不通过！";
					if (!StringUtils.isEmpty(tempCircuit.getLinkPhone())) {
						BaseUserInfo baseUserInfo = new BaseUserInfo();
						baseUserInfo.setLoginName(tempCircuit.getLinkMan());
						baseUserInfo.setMobilephone(tempCircuit.getLinkPhone());
						clientNoticeManager.sendMessage(baseUserInfo,
								msg_1 + tempCircuit.getLinkMan() + msg_2
										+ tempCircuit.getCircuitType() + msg_4);
					}
				}
				break;
			// 地方工程师/网控工程师提交的临时电路开通申请，且网控领导审批通过后，网控工程师的处理过程
			case ATNCPASSED:
				tempCircuitOptLog.setFromStatus(CircuitStatus.ATNCPASSED);
				tempCircuitOptLog.setCircuitInfo(remark);
				if (pass) {
					// 网控工程师移交处理
					engineer = request.getParameter("engineer");
					logger.debug("engineer:" + engineer);
					taskVariables.put("engieerIsTrans", pass);
					taskVariables.put("engineerIsDone", false);
					taskVariables.put("engineerTrans", engineer);
					tempCircuitOptLog
							.setcircuitOptType(CircuitOptType.ENGINEERTRA);
					tempCircuitOptLog.setToStatus(CircuitStatus.TRANSFERRED);
					tempCircuit.setCircuitStatus(CircuitStatus.TRANSFERRED);
					log = "网控工程师移交电路申请 " + tempCircuit.getNumber() + " 至工程师："
							+ userManager.findById(engineer).getName();
					if (!StringUtils.isEmpty(userManager.findById(engineer).getMobilephone())) {
						BaseUserInfo baseUserInfo = new BaseUserInfo();
						baseUserInfo.setLoginName(userManager.findById(engineer).getLoginName());
						baseUserInfo.setMobilephone(userManager.findById(engineer).getMobilephone());
						clientNoticeManager.sendMessage(baseUserInfo,
								msg_1 + userManager.findById(engineer).getName() + msg_2
										+ tempCircuit.getCircuitType() + msg_3);
					}
				} else {
					// 网控工程师自行处理
					taskVariables.put("engieerIsTrans", pass);
					taskVariables.put("engineerIsDone", true);
					tempCircuitOptLog
							.setcircuitOptType(CircuitOptType.ENGINEERACP);
					tempCircuitOptLog.setToStatus(CircuitStatus.DONE);
					tempCircuit.setCircuitStatus(CircuitStatus.DONE);
					tempCircuit.setEngineerName(user.getLoginName());
					log = "网控工程师开通电路申请 " + tempCircuit.getNumber();
					if (!StringUtils.isEmpty(tempCircuit.getLinkPhone())) {
						BaseUserInfo baseUserInfo = new BaseUserInfo();
						baseUserInfo.setLoginName(tempCircuit.getLinkMan());
						baseUserInfo.setMobilephone(tempCircuit.getLinkPhone());
						clientNoticeManager.sendMessage(baseUserInfo,
								msg_1 + tempCircuit.getLinkMan() + ",您好！您申请的["+ tempCircuit.getCircuitType()
								+"]类型的临时电路:"
								+ tempCircuit.getNumber() + ",已经开通！请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]");
					}
				}
				break;
			case TRANSFERRED:
				// 网控工程师移交后的电路处理过程
				tempCircuitOptLog.setFromStatus(CircuitStatus.TRANSFERRED);
				taskVariables.put("engineerTransIsDone", true);
				tempCircuitOptLog.setcircuitOptType(CircuitOptType.ENGINEERACP);
				tempCircuitOptLog.setToStatus(CircuitStatus.DONE);
				tempCircuitOptLog.setCircuitInfo(remark);
				tempCircuit.setCircuitStatus(CircuitStatus.DONE);
				tempCircuit.setEngineerName(user.getLoginName());
				log = "网控工程师开通电路申请 " + tempCircuit.getNumber();

				if (!StringUtils.isEmpty(tempCircuit.getLinkPhone())) {
					BaseUserInfo baseUserInfo = new BaseUserInfo();
					baseUserInfo.setLoginName(tempCircuit.getLinkMan());
					baseUserInfo.setMobilephone(tempCircuit.getLinkPhone());
					clientNoticeManager.sendMessage(baseUserInfo,
							msg_1 + tempCircuit.getLinkMan() + ",您好！您申请的["+ tempCircuit.getCircuitType()
							+"]类型的临时电路:"
							+ tempCircuit.getNumber() + ",已经开通！请您登录“空管网络网控运维平台”查看！----[北京天航信网络公司]");
				}
				break;
			case MODIFIED:
				// 网控工程师提交的临时电路开通申请被网控领导拒绝后需要修改的处理过程
				taskVariables.put("reApply", pass);
				tempCircuitOptLog.setFromStatus(CircuitStatus.MODIFIED);
				if (pass) {
					tempCircuitOptLog
							.setcircuitOptType(CircuitOptType.LOCALOPT);
					tempCircuitOptLog.setToStatus(CircuitStatus.ATNCSUBMITTED);
					tempCircuitOptLog.setCircuitInfo(tempCircuit
							.getCircuitInfo());
					tempCircuit.setCircuitStatus(CircuitStatus.ATNCSUBMITTED);
					log = "修改电路申请 " + tempCircuit.getNumber();
				} else {
					tempCircuitOptLog
							.setcircuitOptType(CircuitOptType.APPLYDELETED);
					tempCircuitOptLog.setToStatus(CircuitStatus.DONE);
					tempCircuit.setCircuitStatus(CircuitStatus.DONE);
					log = "撤销电路申请 " + tempCircuit.getNumber();
				}
				break;
			default:
				break;
			}
			workflowService.complete(tempcircuitpi, taskVariables);
			super.addLog(request, log);

			if (!StringUtils.isEmpty(msg)
					&& !StringUtils.isEmpty(tempCircuit.getLinkPhone())) {
				BaseUserInfo baseUserInfo = new BaseUserInfo();
				baseUserInfo.setLoginName(tempCircuit.getLinkMan());
				baseUserInfo.setEmail(tempCircuit.getLinkEmail());
				baseUserInfo.setMobilephone(tempCircuit.getLinkPhone());
				clientNoticeManager.sendMessage(baseUserInfo, msg);
			}

			if (tempCircuit.getCircuitStatus() != CircuitStatus.DONE) {
				// 如果当前电路状态不为DONE，即当前电路还在审批中，获取电路审批任务
				Task task = workflowService
						.getTaskByProcessInstaceId(tempCircuit
								.getProcessInstanceId());
				logger.debug("task id:" + task.getId());
				// 获取当前电路审批任务节点名称
				tempCircuit.setCurrentTaskName(task.getName());
				if (task.getAssignee() != null) {
					// 获取当前电路审批任务经办人
					logger.debug("task.getAssignee():" + task.getAssignee());
					User assignee = userManager.findById(task.getAssignee());
					if (assignee != null) {
						tempCircuit.setCurrentAuditer(userManager.findById(
								task.getAssignee()).getName());
					} else {
						tempCircuit.setCurrentAuditer(clientManager.findByID(
								task.getAssignee()).getName());
					}
					// 当前电路审批人员列表新增
					tempCircuit.setAuditerList(tempCircuit.getAuditerList()
							+ task.getAssignee() + "|");
				}
			}
			tempCircuit.setUpdateTime(Calendar.getInstance());
			tempCircuitMngService.update(tempCircuit);

			tempCircuitOptLog.setTempCircuit(tempCircuit);
			tempCircuitOptLog.setOptUser(getCurrentUser(request).getName());
			tempCircuitOptLog.setOptTime(tempCircuit.getUpdateTime());
			tempCircuitOptLogMngService.add(tempCircuitOptLog);

			model.addAttribute("returnStr",
					new ResultModel(true, "", null).toJson());

		} catch (ActivitiException e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "", null).toJson());
			if (e.getMessage().indexOf("no processes deployed with key") != -1) {
				logger.debug("没有部署流程!", e);
				// redirectAttributes.addFlashAttribute("error",
				// "没有部署流程，请在[工作流]->[流程管理]页面点击<重新部署流程>");
			} else {
				logger.debug("启动流程失败：", e);
				// redirectAttributes.addFlashAttribute("error", "系统内部错误！");
			}
		} catch (Exception e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "", null).toJson());
			logger.debug("启动流程失败：", e);
			// redirectAttributes.addFlashAttribute("error", "系统内部错误！");
		}
		return "returnnote";
	}

	/**
	 * 
	 * 方法说明：当前用户任务
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年3月28日上午9:17:28
	 * @param session
	 * @param request
	 * @param model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "tasklist.do", method = RequestMethod.GET)
	public String taskList(
			@ModelAttribute("queryModel") TempCircuitQueryModel queryModel,
			HttpSession session, HttpServletRequest request, Model model) {
		super.pageInfo(model, request);
		model.addAttribute("circuitType", CircuitType.values());
		return "tempcircuit/tab/tasklist";
	}

	/**
	 * 
	 * 方法说明：当前用户任务
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年5月16日上午8:56:16
	 * @param session
	 * @param request
	 * @param model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "tasklist.do", method = RequestMethod.POST)
	public String taskListData(
			@ModelAttribute("queryModel") TempCircuitQueryModel queryModel,
			@ModelAttribute("pageModel") TempCircuit tempCircuit,
			@RequestParam("optType") String optType, HttpSession session,
			HttpServletRequest request, Model model) {
		User user = getCurrentUser(request);
		Pagination pagn = null;
		String userId = user.getId();
		switch (optType == null ? "" : optType) {
		case "TASKAUDIT":
			// 审批任务
			logger.debug("userId:" + userId);
			model.addAttribute("taskList",
					workflowService.findTodoTasks(userId));
			return "tempcircuit/task/taskList";
		case "TASKUNSIGN":
			// 未签收审批任务
			logger.debug("userId:" + userId);
			model.addAttribute("unSignTaskList",
					workflowService.findUnSingTasks(userId));
			return "tempcircuit/task/taskUnsignList";
		case "TASKNEW":
			// 电路申请页面
			model.addAttribute("user", user);
			return "tempcircuit/apply";
		case "TASKDELAY":
			// 申请电路延期
			queryModel.setApplyUserID(userId);
			queryModel.setApplyDelay("false");
			queryModel.setCircuitStatus(CircuitStatus.DONE);
			queryModel.setCircuitExpireTypeNotExist(CircuitExpireType.EXPIRE);
			pagn = this.tempCircuitMngService.queryPage(queryModel);
			model.addAttribute("pagn", pagn);
			return "tempcircuit/taskdelay/queryResult";
		case "TASKCANCEL":
			// 申请电路撤销
			queryModel.setApplyUserID(userId);
			queryModel.setCircuitCancelType(CircuitCancelType.NOTDELETE);
			pagn = this.tempCircuitMngService.queryPage(queryModel);
			model.addAttribute("pagn", pagn);
			return "tempcircuit/taskcancel/queryResult";
		case "TASKACKDELETE":
			// 电路撤销申请确认
			queryModel.setCircuitCancelType(CircuitCancelType.APPLYDELETE);
			queryModel.setAckDelete("false");
			pagn = this.tempCircuitMngService.queryPage(queryModel);
			model.addAttribute("currentUser", user.getLoginName());
			model.addAttribute("pagn", pagn);
			return "tempcircuit/taskdelete/queryResult";
		case "TASKFORCEDELETE":
			// 电路到期管理
			queryModel.setCircuitExpireType(CircuitExpireType.EXPIRE);
			queryModel.setCircuitCancelType(CircuitCancelType.NOTDELETE);
			pagn = this.tempCircuitMngService.queryPage(queryModel);
			model.addAttribute("currentUser", user.getLoginName());
			model.addAttribute("pagn", pagn);
			return "tempcircuit/taskontime/queryResult";
		case "TASKCONFIG":
			// 电路配置管理
			queryModel.setEngineerName(user.getLoginName());
			pagn = this.tempCircuitMngService.queryPage(queryModel);
			model.addAttribute("pagn", pagn);
			return "tempcircuit/taskconfig/queryResult";
		default:
			logger.debug("userId:" + userId);
			model.addAttribute("taskList",
					workflowService.findTodoTasks(userId));
			return "tempcircuit/task/taskList";
		}
	}

	/**
	 * 
	 * 方法说明：电路管理
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年5月14日下午7:14:12
	 * @param queryModel
	 * @param model
	 * @param request
	 * @return String
	 * 
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String tabmanage(
			@ModelAttribute("queryModel") TempCircuitQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		model.addAttribute("circuitType", CircuitType.values());
		model.addAttribute("circuitStatus", CircuitStatus.values());
		model.addAttribute("circuitOptType", CircuitOptType.values());
		model.addAttribute("circuitCancelType", CircuitCancelType.values());
		model.addAttribute("engineers", userManager.getUserByRole("engineer"));
		return "tempcircuit/tab/manage";
	}

	/**
	 * 
	 * 方法说明：电路管理
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年5月22日上午9:21:06
	 * @param session
	 * @param queryModel
	 * @param optType
	 * @param model
	 * @param request
	 * @return
	 * @throws IOException
	 *             String
	 * 
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String tabData(HttpSession session,
			@ModelAttribute("queryModel") TempCircuitQueryModel queryModel,
			@RequestParam("optType") String optType, Model model,
			HttpServletRequest request) throws IOException {
		queryModel.setColumn("updateTime");
		Pagination pagn = null;
		switch (optType == null ? "" : optType) {
		case "MNGALL":
			// 全部电路查询
			pagn = this.tempCircuitMngService.queryPage(queryModel);
			model.addAttribute("pagn", pagn);
			return "tempcircuit/mngall/queryResult";
		case "MNGAUDIT":
			// 审批中电路查询
			pagn = this.tempCircuitMngService.queryPageAudit(queryModel);
			model.addAttribute("pagn", pagn);
			return "tempcircuit/mngaudit/queryResult";
		case "MNGUPCOMING":
			// 即将到期电路查询
			queryModel.setCircuitExpireType(CircuitExpireType.UPCOMING);
			pagn = this.tempCircuitMngService.queryPage(queryModel);
			model.addAttribute("pagn", pagn);
			return "tempcircuit/mngall/queryResult";
		case "MNGEXPIRE":
			// 已到期电路查询
			pagn = this.tempCircuitMngService.queryPageExpire(queryModel);
			model.addAttribute("pagn", pagn);
			return "tempcircuit/mngall/queryResult";
		case "MNGACKDELETE":
			// 完结电路查询
			pagn = this.tempCircuitMngService.queryPageOver(queryModel);
			model.addAttribute("pagn", pagn);
			return "tempcircuit/mngall/queryResult";
		default:
			pagn = this.tempCircuitMngService.queryPage(queryModel);
			model.addAttribute("pagn", pagn);
			return "tempcircuit/mngall/queryResult";
		}
	}

	/**
	 * 
	 * 方法说明：电路数量统计
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年5月14日下午7:14:12
	 * @param queryModel
	 * @param model
	 * @param request
	 * @return String
	 * 
	 */
	@RequestMapping(value = "count.dox", method = RequestMethod.GET)
	public String manageCount(@RequestParam("optType") String optType,
			Model model, HttpServletRequest request) {
		long size = 0;
		User user = getCurrentUser(request);
		String userId = user.getId();
		TempCircuitQueryModel queryModel = new TempCircuitQueryModel();
		switch (optType == null ? "" : optType) {
		case "MNGALL":
			// 全系统内电路
			size = this.tempCircuitMngService.queryList(queryModel).size();
			break;
		case "MNGAUDIT":
			// 全系统内审批中电路
			size = this.tempCircuitMngService.queryPageAudit(queryModel)
					.getTotalCount();
			break;
		case "MNGUPCOMING":
			// 全系统内即将到期电路
			queryModel.setCircuitExpireType(CircuitExpireType.UPCOMING);
			size = this.tempCircuitMngService.queryList(queryModel).size();
			break;
		case "MNGEXPIRE":
			// 全系统内已到期电路
			size = this.tempCircuitMngService.queryPageExpire(queryModel)
					.getTotalCount();
			break;
		case "MNGACKDELETE":
			// 全系统内完结电路
			size = this.tempCircuitMngService.queryPageOver(queryModel)
					.getTotalCount();
			break;
		case "TASKAUDIT":
			// 当前用户的审批任务
			size = workflowService.findTodoTasks(userId).size();
			break;
		case "TASKUNSIGN":
			// 当前用户的审批任务
			size = workflowService.findUnSingTasks(userId).size();
			break;
		case "TASKDELAY":
			// 当前用户的可申请延期电路
			queryModel.setApplyUserID(userId);
			queryModel.setApplyDelay("false");
			queryModel.setCircuitStatus(CircuitStatus.DONE);
			queryModel.setCircuitExpireTypeNotExist(CircuitExpireType.EXPIRE);
			size = this.tempCircuitMngService.queryList(queryModel).size();
			break;
		case "TASKCANCEL":
			// 当前用户的可申请撤销电路
			queryModel.setApplyUserID(userId);
			queryModel.setCircuitCancelType(CircuitCancelType.NOTDELETE);
			size = this.tempCircuitMngService.queryList(queryModel).size();
			break;
		case "TASKACKDELETE":
			// 全系统内的需要确认撤销的电路申请
			queryModel.setCircuitCancelType(CircuitCancelType.APPLYDELETE);
			queryModel.setAckDelete("false");
			size = this.tempCircuitMngService.queryList(queryModel).size();
			break;
		case "TASKFORCEDELETE":
			// 全系统内的需要强制撤销的电路申请
			queryModel.setCircuitExpireType(CircuitExpireType.EXPIRE);
			queryModel.setCircuitCancelType(CircuitCancelType.NOTDELETE);
			size = this.tempCircuitMngService.queryList(queryModel).size();
			break;
		case "TASKCONFIG":
			// 当前用户配置过的电路
			queryModel.setEngineerName(user.getLoginName());
			size = this.tempCircuitMngService.queryList(queryModel).size();
			break;
		default:
			size = this.tempCircuitMngService.queryList(queryModel).size();
			break;
		}
		model.addAttribute("returnStr", size);
		return "returnnote";
	}

	/**
	 * 
	 * 方法说明：电路审批日志管理
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月17日下午1:35:22
	 * @param session
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 * 
	 */
	@RequestMapping(value = "log.do", method = RequestMethod.GET)
	public String log(@RequestParam("tempcircuitid") String tempcircuitid,
			HttpSession session, HttpServletRequest request, Model model)
			throws IOException {
		model.addAttribute("tempCircuitOptLogs",
				tempCircuitOptLogMngService.findByTempcircuitID(tempcircuitid));
		return "tempcircuit/log";
	}

	/**
	 * 
	 * 方法说明：到期临时电路强制删除
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月17日下午3:18:50
	 * @param tempcircuitid
	 * @param session
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 * 
	 */
	@RequestMapping(value = "forcedelete.do", method = RequestMethod.GET)
	public String forcedelete(@RequestParam("id") String tempcircuitid,
			HttpSession session, HttpServletRequest request, Model model)
			throws IOException {
		tempCircuitMngService.forceCancleTempCircuitByID(tempcircuitid);

		TempCircuit tempCircuit = tempCircuitMngService
				.getTempCircuitByID(tempcircuitid);
		// 清除工作流引擎内的历史记录
		historyService.deleteHistoricProcessInstance(tempCircuit
				.getProcessInstanceId());
		super.addLog(request, "强制删除电路" + tempCircuit.getNumber());

		TempCircuitOptLog tempCircuitOptLog = new TempCircuitOptLog();
		tempCircuitOptLog.setTempCircuit(tempCircuit);
		tempCircuitOptLog.setcircuitOptType(CircuitOptType.APPLYDELAY);
		tempCircuitOptLog.setFromStatus(tempCircuitOptLogMngService
				.findLatestByTempcircuitID(tempcircuitid).getToStatus());
		tempCircuitOptLog.setToStatus(CircuitStatus.FORCEDELETED);
		tempCircuitOptLog.setOptTime(Calendar.getInstance());
		tempCircuitOptLog.setOptUser(getCurrentUser(request).getName());
		tempCircuitOptLogMngService.add(tempCircuitOptLog);

		model.addAttribute("returnStr",
				new ResultModel(true, "", null).toJson());
		return "returnnote";
	}

	/**
	 * 
	 * 方法说明：确认用户的临时电路删除请求
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年5月15日下午4:05:02
	 * @param tempcircuitid
	 * @param session
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 * 
	 */
	@RequestMapping(value = "ackdelete.do", method = RequestMethod.GET)
	public String ackcancel(@RequestParam("id") String tempcircuitid,
			HttpSession session, HttpServletRequest request, Model model)
			throws IOException {
		tempCircuitMngService.ackDeleteTempCircuitByID(tempcircuitid);
		TempCircuit tempCircuit = tempCircuitMngService
				.getTempCircuitByID(tempcircuitid);
		super.addLog(request, "确认电路删除" + tempCircuit.getNumber());
		TempCircuitOptLog tempCircuitOptLog = new TempCircuitOptLog();
		tempCircuitOptLog.setTempCircuit(tempCircuit);
		tempCircuitOptLog.setcircuitOptType(CircuitOptType.ACKDELETE);
		tempCircuitOptLog.setFromStatus(tempCircuitOptLogMngService
				.findLatestByTempcircuitID(tempcircuitid).getToStatus());
		tempCircuitOptLog.setToStatus(CircuitStatus.ACKDELETED);
		tempCircuitOptLog.setOptTime(Calendar.getInstance());
		tempCircuitOptLog.setOptUser(getCurrentUser(request).getName());
		tempCircuitOptLogMngService.add(tempCircuitOptLog);

		model.addAttribute("returnStr",
				new ResultModel(true, "", null).toJson());
		return "returnnote";
	}

	/**
	 * 签收任务
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "claim.do", method = RequestMethod.GET)
	public String claim(@RequestParam("id") String taskId,
			@RequestParam("tempcircuitid") String tempCircuitid, Model model,
			HttpServletRequest request) throws IOException {
		TempCircuit tempCircuit = tempCircuitMngService
				.getTempCircuitByID(tempCircuitid);
		User user = getCurrentUser(request);

		tempCircuit.setCurrentAuditer(user.getName());
		tempCircuit.setAuditerList(tempCircuit.getAuditerList() + user.getId()
				+ "|");
		tempCircuit.setUpdateTime(Calendar.getInstance());
		tempCircuitMngService.update(tempCircuit);

		workflowService.claim(taskId, user.getId());
		super.addLog(request, "签收电路申请" + tempCircuit.getNumber());
		model.addAttribute("returnStr",
				new ResultModel(true, "", null).toJson());
		return "returnnote";
	}

	/**
	 * 
	 * 方法说明：请求删除临时电路
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年5月22日下午1:17:36
	 * @param tempcircuitid
	 * @param session
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 * 
	 */
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String delete(@RequestParam("id") String tempcircuitid,
			HttpSession session, HttpServletRequest request, Model model)
			throws IOException {
		User user = getCurrentUser(request);
		TempCircuit tempCircuit = tempCircuitMngService
				.getTempCircuitByID(tempcircuitid);
		if (tempCircuit.getCircuitStatus() != CircuitStatus.DONE) {
			// 清除工作流引擎内的正在运行的审批记录
			runtimeService.deleteProcessInstance(
					tempCircuit.getProcessInstanceId(), "");
		}
		historyService.deleteHistoricProcessInstance(tempCircuit
				.getProcessInstanceId());
		tempCircuitMngService.cancleTempCircuitByID(tempcircuitid);
		super.addLog(request, "撤销电路申请" + tempCircuit.getNumber());

		TempCircuitOptLog tempCircuitOptLog = new TempCircuitOptLog();
		tempCircuitOptLog.setTempCircuit(tempCircuit);
		tempCircuitOptLog.setcircuitOptType(CircuitOptType.APPLYDELETED);
		tempCircuitOptLog.setFromStatus(tempCircuitOptLogMngService
				.findLatestByTempcircuitID(tempcircuitid).getToStatus());
		tempCircuitOptLog.setToStatus(CircuitStatus.DELETED);
		tempCircuitOptLog.setOptTime(Calendar.getInstance());
		tempCircuitOptLog.setOptUser(user.getName());
		tempCircuitOptLogMngService.add(tempCircuitOptLog);

		model.addAttribute("returnStr",
				new ResultModel(true, "", null).toJson());
		return "returnnote";
	}

	/**
	 * 
	 * 方法说明：临时电路延期
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年6月5日上午10:01:27
	 * @param tempcircuitid
	 * @param session
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 * 
	 */
	@RequestMapping(value = "delay.do", method = RequestMethod.POST)
	public String delay(@RequestParam("id") String tempcircuitid,
			HttpSession session, HttpServletRequest request, Model model)
			throws IOException {
		User user = getCurrentUser(request);
		TempCircuit tempCircuit = tempCircuitMngService
				.getTempCircuitByID(tempcircuitid);
		tempCircuitMngService.applyTempCircuitDelayByID(tempcircuitid);
		super.addLog(request, "申请电路延期" + tempCircuit.getNumber());

		TempCircuitOptLog tempCircuitOptLog = new TempCircuitOptLog();
		tempCircuitOptLog.setTempCircuit(tempCircuit);
		tempCircuitOptLog.setcircuitOptType(CircuitOptType.APPLYDELAY);
		tempCircuitOptLog.setToStatus(CircuitStatus.DELAY);
		tempCircuitOptLog.setOptTime(Calendar.getInstance());
		tempCircuitOptLog.setOptUser(user.getName());
		tempCircuitOptLogMngService.add(tempCircuitOptLog);

		model.addAttribute("returnStr",
				new ResultModel(true, "", null).toJson());
		return "returnnote";
	}
}
