package cn.com.atnc.ioms.web.publicnotice;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.publicnotice.PnNotice;
import cn.com.atnc.ioms.entity.publicnotice.PnNoticeOptLog;
import cn.com.atnc.ioms.enums.publicnotice.PnNoticeColumnEnum;
import cn.com.atnc.ioms.enums.publicnotice.PnNoticeOptType;
import cn.com.atnc.ioms.enums.publicnotice.PnNoticeStatusEnum;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.publicnotice.IPnNoticeOptLogManager;
import cn.com.atnc.ioms.mng.publicnotice.IPublicNoticeManager;
import cn.com.atnc.ioms.mng.publicnotice.IPublicNoticeWorkflowService;
import cn.com.atnc.ioms.model.publicnotice.PublicNoticeQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * @author:lizhisheng
 * @date:2014-4-24 下午6:46:09
 * @version:1.0
 */
@Controller
@RequestMapping("/publicnotice/pn")
public class PublicNoticeController extends MyBaseController {
	@Autowired
	private IPublicNoticeManager publicNoticeManager;
	@Autowired
	private IPnNoticeOptLogManager pnNoticeOptLogManager;
	@Autowired
	private IPublicNoticeWorkflowService workflowService;
	@Autowired
	private RuntimeService runtimeService;
	 @Autowired
	    private IUserManager userManager;
	@Autowired
	protected HistoryService historyService;
	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") PublicNoticeQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		model.addAttribute("pnNoticeColumnEnum", PnNoticeColumnEnum.values());
		model.addAttribute("pnNoticeStatusEnum",PnNoticeStatusEnum.values());
		return "publicnotice/manage";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(HttpServletRequest request,
			@ModelAttribute("queryModel") PublicNoticeQueryModel queryModel,
			Model model) {
		User user = getCurrentUser(request);
		queryModel.setUser(user);
		model.addAttribute("pagn", this.publicNoticeManager.queryPage(queryModel));
		return "publicnotice/queryResult";
	}
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String setupAddForm(@ModelAttribute("pageModel") PnNotice node,
			Model model,HttpServletRequest request) {
		User user = userManager.findById(getCurrentUser(request).getId());
        model.addAttribute("createUser", user.getLoginName());
		model.addAttribute("pnNoticeColumnEnum", PnNoticeColumnEnum.values());
		model.addAttribute("loginUser", WebUtils.getSessionAttribute(request,SessionNames.LOGIN_USER));
		return "publicnotice/add";
	}
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String processAddForm(@ModelAttribute("pageModel") PnNotice node,
			HttpServletRequest request, Model model) {
		try {
//			PnNotice pnNotice = node;
			User user = getCurrentUser(request);
			node.setCreateUser(user);
			Map<String, Object> variables = new HashMap<String, Object>();
			node.setCreateTime(new Date());
			node.setStatus(PnNoticeStatusEnum.SUBMITTED);
			model.addAttribute("vo", publicNoticeManager.update(node));
			addSuccess(model, "公告申请(" + node.getTitle() + ")");
			 super.addLog(request, "添加通知公告");
			workflowService.startWorkflow(node, variables);
			//保存日志
			PnNoticeOptLog pnNoticeOptLog = new PnNoticeOptLog();
			pnNoticeOptLog.setPnNotice(node);
			pnNoticeOptLog.setOptUser(user);
			pnNoticeOptLog.setOptTime(new Date());
			pnNoticeOptLog.setPnNoticeOptType(PnNoticeOptType.NEW);
			pnNoticeOptLog.setFromPnNoticeStatusEnum(PnNoticeStatusEnum.NEW);
			pnNoticeOptLog.setToPnNoticeStatusEnum(PnNoticeStatusEnum.SUBMITTED);
			try {
				pnNoticeOptLogManager.add(pnNoticeOptLog);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ActivitiException | ServiceException e) {
			if (e.getMessage().indexOf("no processes deployed with key") != -1) {
				logger.warn("没有部署流程!", e);
				try {
					model.addAttribute("returnStr", new ResultModel(false,
							"没有部署流程!", node).toJson());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return "publicnotice/result";
			} else {
				logger.error("启动流程失败!", e);
				try {
					model.addAttribute("returnStr", new ResultModel(false,
							"启动流程失败!", node).toJson());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return "publicnotice/result";
			}
		}
		try {
			model.addAttribute("returnStr",
					new ResultModel(true, "", node).toJson());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "publicnotice/result";
	}
	/**
	 * 
	 * 方法说明：审批manage主页
	 * 
	 * @param tempcircuitid
	 * @param tempcircuitpi
	 * @param circuitStatus
	 * @param model
	 * @param request
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/approval.do", method = RequestMethod.GET)
	public String publicnoticeApp(
//			@RequestParam("pnnoticeid") String pnnoticeid,
//			@RequestParam("pnnoticepi") String pnnoticepi,
//			@RequestParam("pnnoticeStatus") String pnnoticeStatus,
			@ModelAttribute("queryModel") PublicNoticeQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		return "publicnotice/approval/approval";
	}
	/**
	 * 
	 * 方法说明：发布manage主页
	 * 
	 * @param model
	 * @param request
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/press.do", method = RequestMethod.GET)
	public String publicnoticePress(
			@ModelAttribute("queryModel") PublicNoticeQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		return "publicnotice/press/press";
	}
	@RequestMapping(value = "/approval.do", method = RequestMethod.POST)
	public String publicnoticeAppList(
			@ModelAttribute("queryModel") PublicNoticeQueryModel queryModel,
			HttpSession session, 
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		User user = getCurrentUser(request);
		String userId = getCurrentUser(request).getId();
		queryModel.setUser(user);
		model.addAttribute("pnnoticelist", workflowService.findTodoTasks(userId));
//		model.addAttribute("pagn", this.publicNoticeManager.queryPage(queryModel));
		return "publicnotice/approval/appQueryResult";
	}
	@RequestMapping(value = "/press.do", method = RequestMethod.POST)
	public String publicnoticePressList(
			@ModelAttribute("queryModel") PublicNoticeQueryModel queryModel,
			HttpSession session, 
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		String userId = getCurrentUser(request).getId();
		model.addAttribute("pnnoticelist", workflowService.findTodoTasks(userId));
		model.addAttribute("pagn", this.publicNoticeManager.queryPage(queryModel));
		return "publicnotice/press/pressQueryResult";
	}
	/**
	 * 
	 * 方法说明：单个审批页面
	 * 
	 * @param model
	 * @param request
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/apply.do", method = RequestMethod.GET)
	public String tempCircuitAudit(
			@RequestParam("id") String id,
			@RequestParam("processInstanceId") String processInstanceId,
//			@RequestParam("status") String status,
			Model model,
			HttpServletRequest request) {
		model.addAttribute("pnnoticeid", id);
//		model.addAttribute("status", status);
//		model.addAttribute("circuitTypeList", CircuitType.values());
//		model.addAttribute("circuitType", tempCircuitMngService
//				.getTempCircuitByID(tempcircuitid).getCircuitType());
//		PnNotice pn = publicNoticeManager.findById(id);
//		pn.setProcessInstanceId(processInstanceId);
		model.addAttribute("pageModel", publicNoticeManager.findById(id));
//		model.addAttribute("processInstanceId", processInstanceId);
			return "publicnotice/approval/audit";
		
	}
	/**
	 * 
	 * 方法说明：单个发布页面
	 * 
	 * @param model
	 * @param request
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/applyPress.do", method = RequestMethod.GET)
	public String tempCircuitAuditPress(
			@RequestParam("id") String id,
			@RequestParam("processInstanceId") String processInstanceId,
//			@RequestParam("status") String status,
			Model model,
			HttpServletRequest request) {
		model.addAttribute("pnnoticeid", id);
//		model.addAttribute("status", status);
//		model.addAttribute("circuitTypeList", CircuitType.values());
//		model.addAttribute("circuitType", tempCircuitMngService
//				.getTempCircuitByID(tempcircuitid).getCircuitType());
//		PnNotice pn = publicNoticeManager.findById(id);
//		pn.setProcessInstanceId(processInstanceId);
		model.addAttribute("pageModel", publicNoticeManager.findById(id));
//		model.addAttribute("processInstanceId", processInstanceId);
			return "publicnotice/press/auditPress";
		
	}
	/**
	 * 
	 * 方法说明：单个审批
	 * @param pass
	 * @param remark
	 * @param request
	 * @param model
	 * @return String
	 * @throws IOException
	 * 
	 */
	@RequestMapping(value = "/apply.do", method = RequestMethod.POST)
	public String auditApply(@RequestParam("pass") boolean pass,
			@RequestParam("remark") String remark,
			@RequestParam("id") String id,
			@RequestParam("processInstanceId") String processInstanceId,
			HttpServletRequest request, Model model) throws IOException {
		try {
			Map<String, Object> taskVariables = new HashMap<String, Object>();
			PnNotice pnNotice = publicNoticeManager.findById(id);
			User user = getCurrentUser(request);
			PnNoticeOptLog pnNoticeOptLog = new PnNoticeOptLog();
			Task task1 = workflowService.getTaskByProcessInstaceId(pnNotice
					.getProcessInstanceId());
			switch (pnNotice.getStatus()) {
			case SUBMITTED:
				taskVariables.put("firstLeaderPass", pass);
				pnNoticeOptLog.setFromPnNoticeStatusEnum(PnNoticeStatusEnum.SUBMITTED);
				pnNoticeOptLog.setPnNoticeOptType(PnNoticeOptType.FIRSTPASSED);
				if (pass) {
					pnNotice.setStatus(PnNoticeStatusEnum.FIRSTPASSED);
					pnNoticeOptLog.setToPnNoticeStatusEnum(PnNoticeStatusEnum.FIRSTPASSED);
					
				} else {
					pnNotice.setStatus(PnNoticeStatusEnum.MODIFIED);
					pnNoticeOptLog.setToPnNoticeStatusEnum(PnNoticeStatusEnum.MODIFIED);
				}
				break;
			case FIRSTPASSED:
				taskVariables.put("secondLeaderPass", pass);
				pnNoticeOptLog.setFromPnNoticeStatusEnum(PnNoticeStatusEnum.FIRSTPASSED);
				pnNoticeOptLog.setPnNoticeOptType(PnNoticeOptType.SECONDPASSED);
				if (pass) {
					pnNotice.setStatus(PnNoticeStatusEnum.SECONDPASSED);
					pnNoticeOptLog.setToPnNoticeStatusEnum(PnNoticeStatusEnum.SECONDPASSED);
				} else {
					pnNotice.setStatus(PnNoticeStatusEnum.MODIFIED);
					pnNoticeOptLog.setToPnNoticeStatusEnum(PnNoticeStatusEnum.MODIFIED);
				}
				break;
			
			}
			workflowService.complete(task1.getId(), taskVariables);
			if(pnNotice.getStatus()!=PnNoticeStatusEnum.PUBLISHED){
			Task task = workflowService.getTaskByProcessInstaceId(pnNotice
					.getProcessInstanceId());
			pnNotice.setCurrentTaskName(task.getName());
			pnNotice.setCurrentAuditer(task.getAssignee());
			pnNotice.setAuditerList(pnNotice.getAuditerList()
					+ task.getAssignee() + "|");
			}
			//pnNotice.setUpdateTime(Calendar.getInstance());
			
			model.addAttribute("vo", publicNoticeManager.update(pnNotice));
			addSuccess(model, "审批通知公告(" + pnNotice.getTitle() + ")");
			 super.addLog(request, "审批通知公告");
			//保存日志
			pnNoticeOptLog.setPnNotice(pnNotice);
			pnNoticeOptLog.setOptUser(user);
			pnNoticeOptLog.setOptTime(new Date());
			String str = remark.length()>0?remark:"";
			pnNoticeOptLog.setInfo(str);
			try {
				pnNoticeOptLogManager.add(pnNoticeOptLog);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ActivitiException e) {
			if (e.getMessage().indexOf("no processes deployed with key") != -1) {
				logger.warn("没有部署流程!", e);
				// redirectAttributes.addFlashAttribute("error",
				// "没有部署流程，请在[工作流]->[流程管理]页面点击<重新部署流程>");
			} else {
				logger.error("启动请假流程失败：", e);
				// redirectAttributes.addFlashAttribute("error", "系统内部错误！");
			}
		} catch (Exception e) {
			logger.error("启动请假流程失败：", e);
			// redirectAttributes.addFlashAttribute("error", "系统内部错误！");
		}
		model.addAttribute("returnStr",
				new ResultModel(true, "", null).toJson());
		return "publicnotice/approval/result";
	}
	/**
	 * 
	 * 方法说明：单个发布
	 * @param pass
	 * @param remark
	 * @param request
	 * @param model
	 * @return String
	 * @throws IOException
	 * 
	 */
	@RequestMapping(value = "/applyPress.do", method = RequestMethod.POST)
	public String auditApplyPress(
			@RequestParam("id") String id,
			@RequestParam("processInstanceId") String processInstanceId,
			HttpServletRequest request, Model model) throws IOException {
		try {
			Map<String, Object> taskVariables = new HashMap<String, Object>();
			PnNotice pnNotice = publicNoticeManager.findById(id);
			User user = getCurrentUser(request);
			PnNoticeOptLog pnNoticeOptLog = new PnNoticeOptLog();
			Task task1 = workflowService.getTaskByProcessInstaceId(pnNotice
					.getProcessInstanceId());
			switch (pnNotice.getStatus()) {
			case SECONDPASSED:
				taskVariables.put("IsDone", true);
				pnNoticeOptLog.setFromPnNoticeStatusEnum(PnNoticeStatusEnum.SECONDPASSED);
					pnNotice.setStatus(PnNoticeStatusEnum.PUBLISHED);
					pnNoticeOptLog.setPnNoticeOptType(PnNoticeOptType.PUBLISHED);
					pnNoticeOptLog.setToPnNoticeStatusEnum(PnNoticeStatusEnum.PUBLISHED);
				
				break;
			
			}
			
			workflowService.complete(task1.getId(), taskVariables);
			if(pnNotice.getStatus()!=PnNoticeStatusEnum.PUBLISHED){
			Task task = workflowService.getTaskByProcessInstaceId(pnNotice
					.getProcessInstanceId());
			pnNotice.setCurrentTaskName(task.getName());
			pnNotice.setCurrentAuditer(task.getAssignee());
			pnNotice.setAuditerList(pnNotice.getAuditerList()
					+ task.getAssignee() + "|");
			}
			//pnNotice.setUpdateTime(Calendar.getInstance());
			publicNoticeManager.update(pnNotice);
			//保存日志
			pnNoticeOptLog.setPnNotice(pnNotice);
			pnNoticeOptLog.setOptUser(user);
			pnNoticeOptLog.setOptTime(new Date());
			try {
				pnNoticeOptLogManager.add(pnNoticeOptLog);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String name = pnNotice.getTitle();
			addSuccess(model, "发布通知公告(" + name + ")");
			 super.addLog(request, "发布通知公告");
		} catch (ActivitiException e) {
			if (e.getMessage().indexOf("no processes deployed with key") != -1) {
				logger.warn("没有部署流程!", e);
				// redirectAttributes.addFlashAttribute("error",
				// "没有部署流程，请在[工作流]->[流程管理]页面点击<重新部署流程>");
			} else {
				logger.error("启动请假流程失败：", e);
				// redirectAttributes.addFlashAttribute("error", "系统内部错误！");
			}
		} catch (Exception e) {
			logger.error("启动请假流程失败：", e);
			// redirectAttributes.addFlashAttribute("error", "系统内部错误！");
		}
		model.addAttribute("returnStr",
				new ResultModel(true, "", null).toJson());
		return "publicnotice/press/result";
	}
	@RequestMapping(value = "/del.do", method = RequestMethod.POST)
	public String processDelSubmit(@RequestParam("id") String id,
			HttpSession session, HttpServletRequest request, Model model) {
		
			publicNoticeManager.canclePnnoticeByID(id);
			PnNotice pnNotice = publicNoticeManager.findById(id);
			User user = getCurrentUser(request);
			if(null!=pnNotice.getProcessInstanceId()){
			runtimeService.suspendProcessInstanceById(pnNotice.getProcessInstanceId());
			//historyService.deleteHistoricProcessInstance(pnNotice.getProcessInstanceId());
			PnNoticeOptLog pnNoticeOptLog = new PnNoticeOptLog();
			pnNoticeOptLog.setPnNotice(pnNotice);
			pnNoticeOptLog.setPnNoticeOptType(PnNoticeOptType.DELETED);
			pnNoticeOptLog.setFromPnNoticeStatusEnum(pnNoticeOptLogManager
					.findLatestByPnNoticeOptLogID(id).getToPnNoticeStatusEnum());
			pnNoticeOptLog.setToPnNoticeStatusEnum(PnNoticeStatusEnum.DELETED);
			pnNoticeOptLog.setOptUser(user);
			pnNoticeOptLog.setOptTime(new Date());
			try {
				pnNoticeOptLogManager.add(pnNoticeOptLog);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String name = pnNotice.getTitle();
			addSuccess(model, "删除通知公告(" + name + ")成功");
			 super.addLog(request, "撤销通知公告");
			}else{
				try {
					
					String name = publicNoticeManager.delete(id);
					addSuccess(model, "删除公告(" + name + ")成功");
					 super.addLog(request, "删除公告");
				} catch (ServiceException e) {
					addError(model, "删除公告失败:" + e.getMessage());
				}
			}
		return "publicnotice/result";
	}
	/**
	 * 
	 * 方法说明：审批日志
	 * 
	 * @param session
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 * 
	 */
	@RequestMapping(value = "log.dox")
	public String log(@RequestParam("id") String id,
			HttpSession session, HttpServletRequest request, Model model)
			throws IOException {
		model.addAttribute("pnnoticeOptLogs",
				pnNoticeOptLogManager.findByPnNoticeOptLogId(id));
		model.addAttribute("pnnotice",
				publicNoticeManager.findById(id));
		return "publicnotice/pnnoticelog/log";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.GET)
	public String setupModForm(@RequestParam("id") String id,
//			@RequestParam("pid") String pid,
			HttpServletRequest request, Model model) {
//		model.addAttribute("pid", pid);
		model.addAttribute("pnNoticeColumnEnum", PnNoticeColumnEnum.values());
		model.addAttribute("pageModel", publicNoticeManager.findById(id));
		return "publicnotice/mod";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	public String porcessModForm(
			@RequestParam("pass") boolean pass,
//			@RequestParam("remark") String remark,
			@RequestParam("id") String id,
//			@RequestParam("pid") String pid,
			@ModelAttribute("pageModel") PnNotice node,
			HttpServletRequest request, Model model) {
		try {
			Map<String, Object> taskVariables = new HashMap<String, Object>();
			PnNotice pnNotice = publicNoticeManager.findById(id);
			User user = getCurrentUser(request);
			PnNoticeOptLog pnNoticeOptLog = new PnNoticeOptLog();
			Task task1 = workflowService.getTaskByProcessInstaceId(pnNotice
					.getProcessInstanceId());
			switch (pnNotice.getStatus()) {
			
			case MODIFIED:
				taskVariables.put("reApply", pass);
				pnNoticeOptLog.setFromPnNoticeStatusEnum(PnNoticeStatusEnum.MODIFIED);
				pnNoticeOptLog.setPnNoticeOptType(PnNoticeOptType.MODIFIED);
				if (pass) {
					pnNotice.setStatus(PnNoticeStatusEnum.SUBMITTED);
					pnNoticeOptLog.setToPnNoticeStatusEnum(PnNoticeStatusEnum.SUBMITTED);
				} else {
					pnNotice.setStatus(PnNoticeStatusEnum.MODIFIED);
					pnNoticeOptLog.setToPnNoticeStatusEnum(PnNoticeStatusEnum.PUBLISHED);
				}
				break;
			}
			workflowService.complete(task1.getId(), taskVariables);
			if(pnNotice.getStatus()!=PnNoticeStatusEnum.PUBLISHED){
			Task task = workflowService.getTaskByProcessInstaceId(pnNotice
					.getProcessInstanceId());
			pnNotice.setCurrentTaskName(task.getName());
			pnNotice.setCurrentAuditer(task.getAssignee());
			pnNotice.setAuditerList(pnNotice.getAuditerList()
					+ task.getAssignee() + "|");
			}
			//pnNotice.setUpdateTime(Calendar.getInstance());
			publicNoticeManager.update(pnNotice);
			//保存日志
			pnNoticeOptLog.setPnNotice(pnNotice);
			pnNoticeOptLog.setOptUser(user);
			pnNoticeOptLog.setOptTime(new Date());
			try {
				pnNoticeOptLogManager.add(pnNoticeOptLog);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("vo", node);
			addSuccess(model, "修改后申请(" + node.getTitle() + ")");
			 super.addLog(request, "修改通知公告");
		} catch (Exception e) {
			e.printStackTrace();
			addError(model, "修改通知公告失败:" + e.getMessage());
		}
		return "publicnotice/result";
	}
	//缓存
	@RequestMapping(value = "/delay.dox")
	public String porcessDelayForm(
			@ModelAttribute("pageModel") PnNotice node,
			HttpServletRequest request, Model model) {
		try {
			node.setCreateTime(new Date());
			User user = getCurrentUser(request);
			node.setCreateUser(user);
			node.setStatus(PnNoticeStatusEnum.ZANCUN);
			model.addAttribute("vo", publicNoticeManager.update(node));
			addSuccess(model, "暂存(" + node.getTitle() + ")");
			 super.addLog(request, "暂存公告");
		} catch (ServiceException e) {
			addError(model, "暂存失败:" + e.getMessage());
		}
		return "publicnotice/result";
	}
	@RequestMapping(value = "/delay.do", method = RequestMethod.GET)
	public String delayForm(@RequestParam("id") String id,
//			@RequestParam("pid") String pid,
			HttpServletRequest request, Model model) {
//		model.addAttribute("pid", pid);
		model.addAttribute("pnNoticeColumnEnum", PnNoticeColumnEnum.values());
		model.addAttribute("pageModel", publicNoticeManager.findById(id));
		return "publicnotice/delay";
	}
	@RequestMapping(value = "/delay.do", method = RequestMethod.POST)
	public String processDelay(
			@RequestParam("id") String id,
			@ModelAttribute("pageModel") PnNotice node,
			HttpServletRequest request, Model model) {
		try {
			//PnNotice pnNotice = new PnNotice();
			User user = getCurrentUser(request);
			node.setCreateUser(user);
			Map<String, Object> variables = new HashMap<String, Object>();
			node.setCreateTime(new Date());
			node.setStatus(PnNoticeStatusEnum.SUBMITTED);
			node.setContent(node.getContent());
			try {
				publicNoticeManager.update(node);
			} catch (ServiceException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			workflowService.startWorkflow(node, variables);
			//保存日志
			System.out.println("标题是"+node.getTitle());
			PnNoticeOptLog pnNoticeOptLog = new PnNoticeOptLog();
			pnNoticeOptLog.setPnNotice(node);
			pnNoticeOptLog.setOptUser(user);
			pnNoticeOptLog.setOptTime(new Date());
			pnNoticeOptLog.setPnNoticeOptType(PnNoticeOptType.NEW);
			pnNoticeOptLog.setFromPnNoticeStatusEnum(PnNoticeStatusEnum.NEW);
			pnNoticeOptLog.setToPnNoticeStatusEnum(PnNoticeStatusEnum.SUBMITTED);
			try {
				pnNoticeOptLogManager.add(pnNoticeOptLog);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("vo", node);
			addSuccess(model, "公告申请(" + node.getTitle() + ")");
			 super.addLog(request, "添加通知公告");
		} catch (ActivitiException e) {
			if (e.getMessage().indexOf("no processes deployed with key") != -1) {
				logger.warn("没有部署流程!", e);
				return "publicnotice/result";
			} else {
				logger.error("启动流程失败!", e);
				return "publicnotice/queryResult";
			}
		}
		return "publicnotice/queryResult";
	}
	
}
