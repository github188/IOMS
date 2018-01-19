/**
 * 
 */
package cn.com.atnc.ioms.web.techsupport.fault.deal;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.activiti.engine.task.Task;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.acl.UserRole;
import cn.com.atnc.ioms.entity.techsupport.fault.FaultDeclare;
import cn.com.atnc.ioms.entity.techsupport.fault.FaultDeclareOptLog;
import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.enums.techsupport.fault.DeclareType;
import cn.com.atnc.ioms.enums.techsupport.fault.AllStatus;
import cn.com.atnc.ioms.enums.techsupport.fault.OptType;
import cn.com.atnc.ioms.mng.techsupport.IFaultDeclareOptLogService;
import cn.com.atnc.ioms.mng.techsupport.IFaultDeclareService;
import cn.com.atnc.ioms.mng.techsupport.IFaultDeclareWorkflowService;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareDealQueryModel;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * TODO：故障申报跳转控制类
 * 
 * @author KuYonggang
 * @date 2014-4-3下午4:44:07
 * @version 1.0
 */
@Controller("dealController")
@RequestMapping("/techsupport/fault/deal/")
public class DealController extends MyBaseController {

	@Autowired
	private IFaultDeclareService faultDeclareService;
	@Autowired
	private IFaultDeclareOptLogService faultDeclareOptLogService;
	@Autowired
	private IFaultDeclareWorkflowService workflowService;
	@Autowired
	private IUserDao userDao;

	// 页面初始化
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(@ModelAttribute("queryModel") FaultDeclareDealQueryModel queryModel,
			HttpServletRequest request, Model model) {
		super.pageInfo(model, request);
		return "techsupport/fault/deal/manage";
	}

	// 操作Tab
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(@ModelAttribute("queryModel") FaultDeclareDealQueryModel queryModel,
			@RequestParam("optType") String optType,HttpServletRequest request, Model model) {

		User user = (User) request.getSession().getAttribute(
				SessionNames.LOGIN_USER);
		StringBuffer roleNames = new StringBuffer("|");
		List<Role> roles = user.getRoles();
		//logger.info("当前用户拥有角色个数：" + roles.size());
		if(roles!=null && roles.size()>0){
			for (Role role : roles) {
				roleNames.append(role.getName());
				roleNames.append("|");
			}
		}
		logger.info("当前用户名："+user.getName() + " 拥有的角色名称：" + roleNames.toString()+" 操作类别："+optType);
		List<AllStatus> statusList = new ArrayList<AllStatus>();
		switch (optType==null?"":optType) {
		
		case "TAKE":
			//接单 
			statusList.add(AllStatus.SUBMITTED);
			queryModel.setStatusList(statusList);
			queryModel.setDeclareType(DeclareType.FAULTDECLARE);
			model.addAttribute("message","TAKE");
			model.addAttribute("pagn",
					faultDeclareService.queryPageForDeal(queryModel));
			return "techsupport/fault/deal/queryResult";

		case "DUTY_SOLVE":
			//值班员解决
			statusList.add(AllStatus.OPEN);//该状态下的记录可以移交、分配、转咨询和解决
			statusList.add(AllStatus.SOLVED_OPEN);//该状态下的记录只能移交或分配
			queryModel.setStatusList(statusList);
			queryModel.setUpdateUser(user.getName());//该条件指定接单人员为当前登录用户
			queryModel.setDeclareType(DeclareType.FAULTDECLARE);
			model.addAttribute("message","DUTY_SOLVE");
			model.addAttribute("pagn",
					faultDeclareService.queryPageForDeal(queryModel));
			return "techsupport/fault/deal/queryResult";

		case "MANAGER_SOLVE":
			//值班经理解决
			System.out.println("值班经理解决。。。。");
			statusList.add(AllStatus.TRANSFERRED);//已移交状态的记录可供值班经理移交或分配
			statusList.add(AllStatus.OPEN);//该状态下的记录可以移交、分配、转咨询和解决
			statusList.add(AllStatus.SOLVED_OPEN);//该状态下的记录只能移交或分配
			queryModel.setStatusList(statusList);
			queryModel.setUpdateUser(user.getName());//上一步指定的下一步操作人为当前登录的用户
			queryModel.setDeclareType(DeclareType.FAULTDECLARE);
			model.addAttribute("message","MANAGER_SOLVE");
			model.addAttribute("pagn",
					faultDeclareService.queryPageForDeal(queryModel));
			return "techsupport/fault/deal/queryResult";

		case "ENGINEER_SOLVE":
			//工程师解决
			statusList.add(AllStatus.ASSIGNED);//该状态工程师解决无需选择协助人
			statusList.add(AllStatus.RESOLVED_OPEN);//该状态工程师解决需要选择协助人
			queryModel.setStatusList(statusList);
			queryModel.setUpdateUser(user.getName());//上一步指定的下一步操作人为当前登录的用户
			queryModel.setDeclareType(DeclareType.FAULTDECLARE);
			model.addAttribute("message","ENGINEER_SOLVE");
			model.addAttribute("pagn",
					faultDeclareService.queryPageForDeal(queryModel));
			return "techsupport/fault/deal/queryResult";

		case "CONFIRMWARN":
			//确认提醒
			statusList.add(AllStatus.SOLVED);
			statusList.add(AllStatus.RESOLVED);
			queryModel.setStatusList(statusList);
			queryModel.setNowDate(new Date());
			queryModel.setDeclareType(DeclareType.FAULTDECLARE);
			model.addAttribute("message","CONFIRMWARN");
			model.addAttribute("pagn",
					faultDeclareService.queryPageForDeal(queryModel));
			return "techsupport/fault/deal/queryResult";

		default:
			if (roleNames.toString().contains("|admin|") || roleNames.toString().contains("|atncLeader|")){
				//所拥有的角色中包含admin角色或atncLeader角色，则点开故障申报处理看到的第一个tab页是“接单”
				statusList.add(AllStatus.SUBMITTED);
				queryModel.setStatusList(statusList);
				queryModel.setDeclareType(DeclareType.FAULTDECLARE);
				model.addAttribute("message","TAKE");
				model.addAttribute("pagn",
						faultDeclareService.queryPageForDeal(queryModel));
			}else if(roleNames.toString().contains("|zhibanzuzhang|")){
				if(roleNames.toString().contains("|zhibanyuan|")){
					//同时拥有值班经理角色和值班员角色，则点开故障申报处理看到的第一个tab页是“接单”
					statusList.add(AllStatus.SUBMITTED);
					queryModel.setStatusList(statusList);
					queryModel.setDeclareType(DeclareType.FAULTDECLARE);
					model.addAttribute("message","TAKE");
					model.addAttribute("pagn",
							faultDeclareService.queryPageForDeal(queryModel));
				}else {
					//仅拥有值班经理角色，则点开故障申报处理看到的第一个tab页是“值班经理解决”
/*					statusList.add(AllStatus.TRANSFERRED);
					queryModel.setStatusList(statusList);
					queryModel.setUpdateUser(user.getName());
					queryModel.setDeclareType(DeclareType.FAULTDECLARE);
					model.addAttribute("message","MANAGER_SOLVE");
					model.addAttribute("pagn",
							faultDeclareService.queryPageForDeal(queryModel));
					return "techsupport/fault/deal/queryResult";*/
					//目前值班经理角色和值班员角色所拥有的资源是一样的，所以看到的第一个tab页是"接单"
					statusList.add(AllStatus.SUBMITTED);
					queryModel.setStatusList(statusList);
					queryModel.setDeclareType(DeclareType.FAULTDECLARE);
					model.addAttribute("message","TAKE");
					model.addAttribute("pagn",
							faultDeclareService.queryPageForDeal(queryModel));
				}
			}else if (roleNames.toString().contains("|zhibanyuan|")) {
				//仅拥有值班员角色，则点开故障申报处理看到的第一个tab页是“接单”
				statusList.add(AllStatus.SUBMITTED);
				queryModel.setStatusList(statusList);
				queryModel.setDeclareType(DeclareType.FAULTDECLARE);
				model.addAttribute("message","TAKE");
				model.addAttribute("pagn",
						faultDeclareService.queryPageForDeal(queryModel));
			}else if (roleNames.toString().contains("|engineer|")) {
				//仅拥有工程师角色，则点开故障申报处理看到的第一个tab页是“工程师解决”
				statusList.add(AllStatus.ASSIGNED);
				statusList.add(AllStatus.RESOLVED_OPEN);
				queryModel.setStatusList(statusList);
				queryModel.setUpdateUser(user.getName());
				queryModel.setDeclareType(DeclareType.FAULTDECLARE);
				model.addAttribute("message","ENGINEER_SOLVE");
				model.addAttribute("pagn",
						faultDeclareService.queryPageForDeal(queryModel));
			}
			return "techsupport/fault/deal/queryResult";
		}
	}
	/**
	 * 加载待处理条数
	 * @throws IOException 
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-25下午2:00:03
	 * @param：
	 * @return：String
	 */
	@RequestMapping(value = "ajaxLoad.dox",method = RequestMethod.GET)
	public String ajaxLoad(@ModelAttribute("queryModel") FaultDeclareDealQueryModel queryModel,
			@RequestParam("type")String type,HttpServletRequest request, Model model) throws IOException {
		
		User user = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
		List<AllStatus> statusList = new ArrayList<AllStatus>();
		
		switch (type==null?"":type) {
		
		case "TAKE":
			//接单
			statusList.add(AllStatus.SUBMITTED);
			queryModel.setStatusList(statusList);
			queryModel.setDeclareType(DeclareType.FAULTDECLARE);
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(faultDeclareService.queryPageForDeal(queryModel)));
			return "returnnote";

		case "DUTY_SOLVE":
			//值班员解决
			statusList.add(AllStatus.OPEN);//该状态下的记录可以移交、分配、转咨询和解决
			statusList.add(AllStatus.SOLVED_OPEN);//该状态下的记录只能移交或分配
			queryModel.setStatusList(statusList);
			queryModel.setUpdateUser(user.getName());//该条件指定接单人员为当前登录用户
			queryModel.setDeclareType(DeclareType.FAULTDECLARE);
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(faultDeclareService.queryPageForDeal(queryModel)));
			return "returnnote";

		case "MANAGER_SOLVE":
			//值班经理解决（包含值班员的所有权限）
			statusList.add(AllStatus.TRANSFERRED);//只有值班经理角色可以用到此状态
			statusList.add(AllStatus.OPEN);//该状态下的记录可以移交、分配、转咨询和解决
			statusList.add(AllStatus.SOLVED_OPEN);//该状态下的记录只能移交或分配
			queryModel.setStatusList(statusList);
			queryModel.setUpdateUser(user.getName());//上一步指定的下一步操作人为当前登录的用户
			queryModel.setDeclareType(DeclareType.FAULTDECLARE);
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(faultDeclareService.queryPageForDeal(queryModel)));
			return "returnnote";

		case "ENGINEER_SOLVE":
			//工程师解决
			statusList.add(AllStatus.ASSIGNED);//该状态工程师解决无需选择协助人
			statusList.add(AllStatus.RESOLVED_OPEN);//该状态工程师解决需要选择协助人
			queryModel.setStatusList(statusList);
			queryModel.setUpdateUser(user.getName());//上一步指定的下一步操作人为当前登录的用户
			queryModel.setDeclareType(DeclareType.FAULTDECLARE);
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(faultDeclareService.queryPageForDeal(queryModel)));
			return "returnnote";

		case "CONFIRMWARN":
			//确认提醒   所有值班员都可以操作
			statusList.add(AllStatus.SOLVED);
			statusList.add(AllStatus.RESOLVED);
			queryModel.setStatusList(statusList);
			queryModel.setNowDate(new Date());
			queryModel.setDeclareType(DeclareType.FAULTDECLARE);
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(faultDeclareService.queryPageForDeal(queryModel)));
			return "returnnote";

		default:
			return "returnnote";
		}
	}
	/**
	 * 查看详情操作
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-25下午2:00:03
	 * @param：
	 * @return：String
	 */
	@RequestMapping(value = "detail.do",method = RequestMethod.GET)
	public String setupDetailForm(@RequestParam("id")String id,HttpServletRequest request, Model model) {
		List<FaultDeclareOptLog> faultDeclareOptLogs = faultDeclareOptLogService.findByFaultDeclareId(id);
		model.addAttribute("faultDeclareOptLogs",faultDeclareOptLogs);
		model.addAttribute("pageModel",faultDeclareService.getFaultDeclareByID(id));
		return "techsupport/fault/deal/detail";
	}

	/**
	 * 接单操作（值班员或值班经理接单）
	 * @author：KuYonggang
	 * @date：2014-4-25下午1:59:44
	 * @param：
	 * @return：String
	 */
	@RequestMapping(value = "take.do",method = RequestMethod.GET)
	public String setupTakeForm(@ModelAttribute("pageModel")FaultDeclareQueryModel queryModel,
			HttpServletRequest request, Model model) {
		return "techsupport/fault/deal/take";
	}

	@RequestMapping(value = "take.do",method = RequestMethod.POST)
	public String processTakeForm(HttpServletRequest request, Model model,
			@RequestParam("id")String id,
			@RequestParam("faultdeclarepi")String faultdeclarepi,
			@RequestParam("descInfo")String descInfo) {
		try {
			Task task = workflowService.getTaskByProcessInstaceId(faultdeclarepi);
			User user = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
			FaultDeclare faultDeclare = faultDeclareService.getFaultDeclareByID(id);

			//保存操作日志信息
			FaultDeclareOptLog faultDeclareOptLog = new FaultDeclareOptLog();
			faultDeclareOptLog.setFromStatus(faultDeclare.getFaultStatus());
			faultDeclareOptLog.setToStatus(AllStatus.OPEN);
			faultDeclareOptLog.setFaultDeclare(faultDeclare);
			faultDeclareOptLog.setOptUser(user);
			faultDeclareOptLog.setOptType(OptType.TAKE);
			faultDeclareOptLog.setOptTime(new Date());
			faultDeclareOptLog.setOptUserName(user.getName());
			faultDeclareOptLog.setOptUserDepartment(user.getDept());
			faultDeclareOptLog.setDescInfo(descInfo);
			faultDeclareOptLogService.save(faultDeclareOptLog);

			//更新故障申报处理记录
			faultDeclare.setFaultStatus(AllStatus.OPEN);
			faultDeclare.setCurrentTaskName("值班操作");
			faultDeclare.setUpdateUser(user.getName());
			faultDeclare.setOperUser(user.getName());
			faultDeclare.setUpdateTime(new Date());
			faultDeclare.setUser(user);
			faultDeclareService.update(faultDeclare);

			workflowService.claim(task.getId(), ((User)request.getSession().getAttribute(SessionNames.LOGIN_USER)).getId());
			addSuccess(model, "接单成功！");
			//添加操作日志
			super.addLog(request, "值班接单成功(故障摘要:"+faultDeclare.getFaultKey()+")");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addSuccess(model, "接单失败！原因是："+e.getMessage());
		}
		return "techsupport/fault/deal/result";
	}

	/**
	 * 解决操作（值班员或值班经理解决）
	 * @author：KuYonggang
	 * @date：2014-4-25下午2:00:21
	 * @param：
	 * @return：String
	 */
	@RequestMapping(value = "solve.do",method = RequestMethod.GET)
	public String setupSolveForm(@ModelAttribute("pageModel")FaultDeclareQueryModel queryModel,
			HttpServletRequest request, Model model) {
		//解决上方展示详情内容
		List<FaultDeclareOptLog> faultDeclareOptLogs = faultDeclareOptLogService.findByFaultDeclareId(queryModel.getId());
		model.addAttribute("faultDeclareOptLogs",faultDeclareOptLogs);
		model.addAttribute("faultDeclare",faultDeclareService.getFaultDeclareByID(queryModel.getId()));
		
		return "techsupport/fault/deal/solve";
	}

	@RequestMapping(value = "solve.do",method = RequestMethod.POST)
	public String peocessSolveForm(HttpServletRequest request, Model model,
			@RequestParam("id")String id,
			@RequestParam("faultdeclarepi")String faultdeclarepi,
			@RequestParam("descInfo")String descInfo,
			@RequestParam("confirmTime")Date confirmTime) {
		try {
			FaultDeclare faultDeclare = faultDeclareService.getFaultDeclareByID(id);
			//获取当前登录用户实例
			User user = (User)request.getSession().getAttribute(SessionNames.LOGIN_USER);

			Task task = workflowService.getTaskByProcessInstaceId(faultdeclarepi);

			//保存操作日志信息
			FaultDeclareOptLog faultDeclareOptLog = new FaultDeclareOptLog();
			faultDeclareOptLog.setFromStatus(faultDeclare.getFaultStatus());
			faultDeclareOptLog.setToStatus(AllStatus.SOLVED);
			faultDeclareOptLog.setFaultDeclare(faultDeclare);
			faultDeclareOptLog.setOptUser(user);
			faultDeclareOptLog.setOptType(OptType.SOLVE);
			faultDeclareOptLog.setOptTime(new Date());
			faultDeclareOptLog.setOptUserName(user.getName());
			faultDeclareOptLog.setOptUserDepartment(user.getDept());
			faultDeclareOptLog.setDescInfo(descInfo);
			faultDeclareOptLogService.save(faultDeclareOptLog);

			//更新故障申报处理记录
			faultDeclare.setFaultStatus(AllStatus.SOLVED);
			faultDeclare.setUpdateUser(faultDeclare.getClient().getName());
			faultDeclare.setOperUser(user.getName());
			faultDeclare.setUser(user);
			faultDeclare.setUpdateTime(new Date());
			faultDeclare.setConfirmTime(confirmTime);
			faultDeclare.setCurrentTaskName("用户操作");
			faultDeclareService.update(faultDeclare);

			Map<String, Object> taskVariables = new HashMap<String, Object>();
			taskVariables.put("oper", "solved");
			taskVariables.put("applyUserId", faultDeclare.getClient().getId());
			workflowService.complete(task.getId(), taskVariables);

			addSuccess(model, "解决成功！");
			//添加操作日志
			super.addLog(request, "值班员解决成功(故障摘要:"+faultDeclare.getFaultKey()+")");
		} catch (Exception e) {
			e.printStackTrace();
			addSuccess(model, "解决失败！原因是："+e.getMessage());
		}
		return "techsupport/fault/deal/result";
	}

	/**
	 * 工程师解决操作
	 * @author：KuYonggang
	 * @date：2014-4-25下午2:00:21
	 * @param：
	 * @return：String
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "resolve.do",method = RequestMethod.GET)
	public String setupResolveForm(@ModelAttribute("pageModel")FaultDeclareQueryModel queryModel,
			HttpServletRequest request, Model model) {
		
		//解决上方展示详情内容
		List<FaultDeclareOptLog> faultDeclareOptLogs = faultDeclareOptLogService.findByFaultDeclareId(queryModel.getId());
		model.addAttribute("faultDeclareOptLogs",faultDeclareOptLogs);
		model.addAttribute("faultDeclare",faultDeclareService.getFaultDeclareByID(queryModel.getId()));
		
		//获取当前登录用户实例
		User user = (User)request.getSession().getAttribute(SessionNames.LOGIN_USER);
		//获取角色为"工程师"的用户集合
		List<UserRole> userRoles = new ArrayList<UserRole>();
		userRoles = (List<UserRole>) userDao.queryList("from UserRole where role.name=?", "engineer");
		List<User> engineers = new ArrayList<User>();
		for (UserRole userRole : userRoles) {
			if(!StringUtils.equals(userRole.getUser().getName(), user.getName())){
				engineers.add(userRole.getUser());
			}
		}

		FaultDeclare faultDeclare = faultDeclareService.getFaultDeclareByID(queryModel.getId());

		model.addAttribute("faultDeclare", faultDeclare);
		model.addAttribute("engineers",engineers);

		return "techsupport/fault/deal/resolve";
	}
	@RequestMapping(value = "resolve.do",method = RequestMethod.POST)
	public String peocessResolveForm(HttpServletRequest request, Model model,
			@RequestParam("id")String id,
			@RequestParam("faultdeclarepi")String faultdeclarepi,
			@RequestParam("descInfo")String descInfo,
			@RequestParam("confirmTime")Date confirmTime) {
		try {
			FaultDeclare faultDeclare = faultDeclareService.getFaultDeclareByID(id);
			//获取当前登录用户实例
			User user = (User)request.getSession().getAttribute(SessionNames.LOGIN_USER);

			Task task = workflowService.getTaskByProcessInstaceId(faultdeclarepi);

			//保存操作日志信息
			FaultDeclareOptLog faultDeclareOptLog = new FaultDeclareOptLog();
			faultDeclareOptLog.setFromStatus(faultDeclare.getFaultStatus());
			faultDeclareOptLog.setToStatus(AllStatus.RESOLVED);
			faultDeclareOptLog.setFaultDeclare(faultDeclare);
			faultDeclareOptLog.setOptUser(user);
			faultDeclareOptLog.setOptType(OptType.RESOLVE);
			faultDeclareOptLog.setOptTime(new Date());
			faultDeclareOptLog.setOptUserName(user.getName());
			faultDeclareOptLog.setOptUserDepartment(user.getDept());
			//获取协助人ID，如果为空则说明非工程师解决重启
			String engineer = request.getParameter("engineer");
			if(!StringUtils.isEmpty(engineer)){
				faultDeclareOptLog.setAssistUser(userDao.findById(engineer).getName());
				faultDeclareOptLog.setAssistUserDepartment(userDao.findById(engineer).getDept());
			}
			faultDeclareOptLog.setDescInfo(descInfo);
			faultDeclareOptLogService.save(faultDeclareOptLog);

			//更新故障申报处理记录
			faultDeclare.setFaultStatus(AllStatus.RESOLVED);
			faultDeclare.setUpdateUser(faultDeclare.getClient().getName());
			faultDeclare.setOperUser(user.getName());
			faultDeclare.setUser(user);
			faultDeclare.setUpdateTime(new Date());
			faultDeclare.setConfirmTime(confirmTime);
			faultDeclare.setCurrentTaskName("用户操作");
			faultDeclareService.update(faultDeclare);

			Map<String, Object> taskVariables = new HashMap<String, Object>();
			taskVariables.put("oper", "resolved");
			taskVariables.put("applyUserId", faultDeclare.getClient().getId());

			workflowService.complete(task.getId(), taskVariables);

			addSuccess(model, "解决成功！");
			//添加操作日志
			super.addLog(request, "工程师解决成功(故障摘要:"+faultDeclare.getFaultKey()+")");
		} catch (Exception e) {
			e.printStackTrace();
			addSuccess(model, "解决成功！原因是："+e.getMessage());
		}
		return "techsupport/fault/deal/result";
	}

	/**
	 * 移交操作(值班员移交值班经理)
	 * @author：KuYonggang
	 * @date：2014-4-25下午2:00:21
	 * @param：
	 * @return：String
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "dutytransfer.do",method = RequestMethod.GET)
	public String setupTransferForm(@ModelAttribute("pageModel")FaultDeclareQueryModel queryModel,
			HttpServletRequest request, Model model) {
		//获取角色为"值班组长"的用户集合
		List<UserRole> userRoles = new ArrayList<UserRole>();
		userRoles = (List<UserRole>) userDao.queryList("from UserRole where role.name=?", "zhibanzuzhang");
		List<User> dutyManagerList = new ArrayList<User>();
		for (UserRole userRole : userRoles) {
			dutyManagerList.add(userRole.getUser());
		}
		model.addAttribute("dutyManagerList",dutyManagerList);

		return "techsupport/fault/deal/dutytransfer";
	}

	@RequestMapping(value = "dutytransfer.do",method = RequestMethod.POST)
	public String peocessTransferForm(HttpServletRequest request, Model model,
			@RequestParam("id")String id,
			@RequestParam("faultdeclarepi")String faultdeclarepi,
			@RequestParam("descInfo")String descInfo,
			@RequestParam("dutyManager")String dutyManager,
			@RequestParam("role")String role) {
		try {
			FaultDeclare faultDeclare = faultDeclareService.getFaultDeclareByID(id);
			//获取当前登录用户实例
			User user = (User)request.getSession().getAttribute(SessionNames.LOGIN_USER);
			
			Task task = workflowService.getTaskByProcessInstaceId(faultdeclarepi);
			
			//保存操作日志信息
			FaultDeclareOptLog faultDeclareOptLog = new FaultDeclareOptLog();
			faultDeclareOptLog.setFromStatus(faultDeclare.getFaultStatus());
			faultDeclareOptLog.setToStatus(AllStatus.TRANSFERRED);
			faultDeclareOptLog.setFaultDeclare(faultDeclare);
			faultDeclareOptLog.setOptUser(user);
			faultDeclareOptLog.setOptType(OptType.TRANSFER);
			faultDeclareOptLog.setOptTime(new Date());
			faultDeclareOptLog.setOptUserName(user.getName());
			faultDeclareOptLog.setOptUserDepartment(user.getDept());
			faultDeclareOptLog.setDescInfo(descInfo);
			faultDeclareOptLogService.save(faultDeclareOptLog);

			//获取值班经理ID
			String zhibanzuzhang = request.getParameter("dutyManager");

			//更新故障申报处理记录
			faultDeclare.setFaultStatus(AllStatus.TRANSFERRED);
			faultDeclare.setUpdateUser(userDao.findById(zhibanzuzhang).getName());
			faultDeclare.setOperUser(user.getName());
			faultDeclare.setUpdateTime(new Date());
			faultDeclare.setUser(user);
			faultDeclare.setCurrentTaskName("值班经理操作");
			faultDeclareService.update(faultDeclare);
			Map<String, Object> taskVariables = new HashMap<String, Object>();
			taskVariables.put("oper", "transfer");
			workflowService.complete(task.getId(), taskVariables);
/*		if("duty".equals(role)){
				Map<String, Object> taskVariables = new HashMap<String, Object>();
				taskVariables.put("oper", "transfer");
				taskVariables.put("zhibanzuzhang", zhibanzuzhang);
				workflowService.complete(task.getId(), taskVariables);
			}*/
			addSuccess(model, "移交成功！");
			//添加操作日志
			super.addLog(request, "移交成功(故障摘要:"+faultDeclare.getFaultKey()+")");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addSuccess(model, "移交失败！原因是："+e.getMessage());
		}
		return "techsupport/fault/deal/result";
	}

	/**
	 * 移交操作(值班经理移交除自己以外的值班经理)
	 * @author：KuYonggang
	 * @date：2014-4-25下午2:00:21
	 * @param：
	 * @return：String
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "managertransfer.do",method = RequestMethod.GET)
	public String setupManagerTransferForm(@ModelAttribute("pageModel")FaultDeclareQueryModel queryModel,
			HttpServletRequest request, Model model) {
		
		//获取当前登录用户实例
		User user = (User)request.getSession().getAttribute(SessionNames.LOGIN_USER);
		
		//获取角色为"工程师"的用户集合
		List<UserRole> userRoles = new ArrayList<UserRole>();
		userRoles = (List<UserRole>) userDao.queryList("from UserRole where role.name=?", "zhibanzuzhang");
		List<User> dutyManagerList = new ArrayList<User>();
		for (UserRole userRole : userRoles) {
			//不能移交给自己
			if(!StringUtils.equals(userRole.getUser().getName(),user.getName())){
				dutyManagerList.add(userRole.getUser());
			}
		}
		model.addAttribute("dutyManagerList",dutyManagerList);

		return "techsupport/fault/deal/managertransfer";
	}

	@RequestMapping(value = "managertransfer.do",method = RequestMethod.POST)
	public String peocessManagerTransferForm(HttpServletRequest request, Model model,
			@RequestParam("id")String id,
			@RequestParam("faultdeclarepi")String faultdeclarepi,
			@RequestParam("descInfo")String descInfo,
			@RequestParam("dutyManager")String dutyManager,
			@RequestParam("role")String role) {

		try {
			FaultDeclare faultDeclare = faultDeclareService.getFaultDeclareByID(id);
			//获取当前登录用户实例
			User user = (User)request.getSession().getAttribute(SessionNames.LOGIN_USER);

			Task task = workflowService.getTaskByProcessInstaceId(faultdeclarepi);

			//保存操作日志信息
			FaultDeclareOptLog faultDeclareOptLog = new FaultDeclareOptLog();
			faultDeclareOptLog.setFromStatus(faultDeclare.getFaultStatus());
			faultDeclareOptLog.setToStatus(AllStatus.TRANSFERRED);
			faultDeclareOptLog.setFaultDeclare(faultDeclare);
			faultDeclareOptLog.setOptUser(user);
			faultDeclareOptLog.setOptType(OptType.TRANSFER);
			faultDeclareOptLog.setOptTime(new Date());
			faultDeclareOptLog.setOptUserName(user.getName());
			faultDeclareOptLog.setOptUserDepartment(user.getDept());
			faultDeclareOptLog.setDescInfo(descInfo);
			faultDeclareOptLogService.save(faultDeclareOptLog);

			//获取值班经理ID
			String zhibanzuzhang = request.getParameter("dutyManager");

			//更新故障申报处理记录
			faultDeclare.setFaultStatus(AllStatus.TRANSFERRED);
			faultDeclare.setUpdateUser(userDao.findById(zhibanzuzhang).getName());
			faultDeclare.setOperUser(user.getName());
			faultDeclare.setUpdateTime(new Date());
			faultDeclare.setUser(user);
			faultDeclare.setCurrentTaskName("值班经理操作");
			faultDeclareService.update(faultDeclare);
			
			Map<String, Object> taskVariables = new HashMap<String, Object>();
			taskVariables.put("oper", "transfer");
			workflowService.complete(task.getId(), taskVariables);
/*			if("duty".equals(role)){
				Map<String, Object> taskVariables = new HashMap<String, Object>();
				taskVariables.put("oper", "transfer");
				taskVariables.put("zhibanzuzhang", zhibanzuzhang);
				workflowService.complete(task.getId(), taskVariables);
			}*/
			addSuccess(model, "移交成功！");
			//添加操作日志
			super.addLog(request, "移交成功(故障摘要:"+faultDeclare.getFaultKey()+")");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addSuccess(model, "移交失败！原因是："+e.getMessage());
		}
		return "techsupport/fault/deal/result";
	}
	
	/**
	 * 分配操作(值班员分配工程师)
	 * @author：KuYonggang
	 * @date：2014-4-25下午2:00:21
	 * @param：
	 * @return：String
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "dutyassign.do",method = RequestMethod.GET)
	public String setupAssignForm(@ModelAttribute("pageModel")FaultDeclareQueryModel queryModel,
			HttpServletRequest request, Model model) {

		//获取角色为"工程师"的用户集合
		List<UserRole> userRoles = new ArrayList<UserRole>();
		userRoles = (List<UserRole>) userDao.queryList("from UserRole where role.name=?", "engineer");
		List<User> engineers = new ArrayList<User>();
		for (UserRole userRole : userRoles) {
			engineers.add(userRole.getUser());
		}

		model.addAttribute("engineers",engineers);

		return "techsupport/fault/deal/dutyassign";
	}

	@RequestMapping(value = "dutyassign.do",method = RequestMethod.POST)
	public String peocessAssignForm(HttpServletRequest request, Model model,
			@RequestParam("id")String id,
			@RequestParam("faultdeclarepi")String faultdeclarepi,
			@RequestParam("descInfo")String descInfo) {

		try {
			FaultDeclare faultDeclare = faultDeclareService.getFaultDeclareByID(id);
			//获取当前登录用户实例
			User user = (User)request.getSession().getAttribute(SessionNames.LOGIN_USER);

			Task task = workflowService.getTaskByProcessInstaceId(faultdeclarepi);

			//保存操作日志信息
			FaultDeclareOptLog faultDeclareOptLog = new FaultDeclareOptLog();
			faultDeclareOptLog.setFromStatus(faultDeclare.getFaultStatus());
			faultDeclareOptLog.setToStatus(AllStatus.ASSIGNED);
			faultDeclareOptLog.setFaultDeclare(faultDeclare);
			faultDeclareOptLog.setOptUser(user);
			faultDeclareOptLog.setOptType(OptType.ASSIGN);
			faultDeclareOptLog.setOptTime(new Date());
			faultDeclareOptLog.setOptUserName(user.getName());
			faultDeclareOptLog.setOptUserDepartment(user.getDept());
			faultDeclareOptLog.setDescInfo(descInfo);
			faultDeclareOptLogService.save(faultDeclareOptLog);


			//获取工程师ID
			String engineer = request.getParameter("engineer");
			//更新故障申报处理记录
			faultDeclare.setFaultStatus(AllStatus.ASSIGNED);
			faultDeclare.setUpdateUser(userDao.findById(engineer).getName());
			faultDeclare.setOperUser(user.getName());
			faultDeclare.setUpdateTime(new Date());
			faultDeclare.setUser(user);
			faultDeclare.setCurrentTaskName("工程师操作");
			faultDeclareService.update(faultDeclare);

			Map<String, Object> taskVariables = new HashMap<String, Object>();
			taskVariables.put("oper", "assign");
			taskVariables.put("engineer", engineer);

			workflowService.complete(task.getId(), taskVariables);

			addSuccess(model, "分配成功！");
			//添加操作日志
			super.addLog(request, "分配成功(故障摘要:"+faultDeclare.getFaultKey()+")");
		} catch (Exception e) {
			e.printStackTrace();
			addSuccess(model, "分配失败！原因是："+e.getMessage());
		}
		return "techsupport/fault/deal/result";
	}

	/**
	 * 分配操作(值班经理分配工程师)
	 * @author：KuYonggang
	 * @date：2014-4-25下午2:00:21
	 * @param：
	 * @return：String
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "managerassign.do",method = RequestMethod.GET)
	public String setupManagerAssignForm(@ModelAttribute("pageModel")FaultDeclareQueryModel queryModel,
			HttpServletRequest request, Model model) {

		//获取角色为"工程师"的用户集合
		List<UserRole> userRoles = new ArrayList<UserRole>();
		userRoles = (List<UserRole>) userDao.queryList("from UserRole where role.name=?", "engineer");
		List<User> engineers = new ArrayList<User>();
		for (UserRole userRole : userRoles) {
			engineers.add(userRole.getUser());
		}

		model.addAttribute("engineers",engineers);

		return "techsupport/fault/deal/managerassign";
	}

	@RequestMapping(value = "managerassign.do",method = RequestMethod.POST)
	public String peocessManagerAssignForm(HttpServletRequest request, Model model,
			@RequestParam("id")String id,
			@RequestParam("faultdeclarepi")String faultdeclarepi,
			@RequestParam("descInfo")String descInfo) {

		try {
			FaultDeclare faultDeclare = faultDeclareService.getFaultDeclareByID(id);
			//获取当前登录用户实例
			User user = (User)request.getSession().getAttribute(SessionNames.LOGIN_USER);

			Task task = workflowService.getTaskByProcessInstaceId(faultdeclarepi);

			//保存操作日志信息
			FaultDeclareOptLog faultDeclareOptLog = new FaultDeclareOptLog();
			faultDeclareOptLog.setFromStatus(faultDeclare.getFaultStatus());
			faultDeclareOptLog.setToStatus(AllStatus.ASSIGNED);
			faultDeclareOptLog.setFaultDeclare(faultDeclare);
			faultDeclareOptLog.setOptUser(user);
			faultDeclareOptLog.setOptType(OptType.ASSIGN);
			faultDeclareOptLog.setOptTime(new Date());
			faultDeclareOptLog.setOptUserName(user.getName());
			faultDeclareOptLog.setOptUserDepartment(user.getDept());
			faultDeclareOptLog.setDescInfo(descInfo);
			faultDeclareOptLogService.save(faultDeclareOptLog);


			//获取工程师ID
			String engineer = request.getParameter("engineer");
			//更新故障申报处理记录
			faultDeclare.setFaultStatus(AllStatus.ASSIGNED);
			faultDeclare.setUpdateUser(userDao.findById(engineer).getName());
			faultDeclare.setOperUser(user.getName());
			faultDeclare.setUpdateTime(new Date());
			faultDeclare.setUser(user);
			faultDeclare.setCurrentTaskName("工程师操作");
			faultDeclareService.update(faultDeclare);

			Map<String, Object> taskVariables = new HashMap<String, Object>();
			taskVariables.put("oper", "assign");
			taskVariables.put("engineer", engineer);

			workflowService.complete(task.getId(), taskVariables);

			addSuccess(model, "分配成功！");
			//添加操作日志
			super.addLog(request, "分配成功(故障摘要:"+faultDeclare.getFaultKey()+")");
		} catch (Exception e) {
			e.printStackTrace();
			addSuccess(model, "分配失败！原因是："+e.getMessage());
		}
		return "techsupport/fault/deal/result";
	}
	
	/**
	 *  转咨询操作
	 * @author：KuYonggang
	 * @date：2014-4-24下午6:29:05
	 * @param：
	 * @return：String
	 */
	@RequestMapping(value = "change.do", method = RequestMethod.GET)
	public String setupChangeForm(@ModelAttribute("pageModel")FaultDeclareQueryModel queryModel,
			HttpServletRequest request, Model model){
		//解决上方展示详情内容
		List<FaultDeclareOptLog> faultDeclareOptLogs = faultDeclareOptLogService.findByFaultDeclareId(queryModel.getId());
		model.addAttribute("faultDeclareOptLogs",faultDeclareOptLogs);
		model.addAttribute("faultDeclare",faultDeclareService.getFaultDeclareByID(queryModel.getId()));
		
		return "techsupport/fault/deal/change";
	}

	@RequestMapping(value = "change.do", method = RequestMethod.POST)
	public String processChangeForm(HttpServletRequest request, Model model,
			@RequestParam("id")String id,
			@RequestParam("faultdeclarepi")String faultdeclarepi,
			@RequestParam("descInfo")String descInfo) {
		try {
			Map<String, Object> taskVariables = new HashMap<String, Object>();
			Task task = workflowService.getTaskByProcessInstaceId(faultdeclarepi);
			//当前登录用户
			User user = (User)request.getSession().getAttribute(SessionNames.LOGIN_USER);
			//通过id得到故障申报记录对象
			FaultDeclare faultDeclare = faultDeclareService.getFaultDeclareByID(id);

			//保存该条记录日志信息
			FaultDeclareOptLog faultDeclareOptLog = new FaultDeclareOptLog();
			faultDeclareOptLog.setFaultDeclare(faultDeclare);
			faultDeclareOptLog.setFromStatus(faultDeclare.getFaultStatus());
			faultDeclareOptLog.setToStatus(AllStatus.CHANGED);
			faultDeclareOptLog.setOptUser(user);
			faultDeclareOptLog.setOptUserName(user.getName());
			faultDeclareOptLog.setOptUserDepartment(user.getDept());
			faultDeclareOptLog.setOptTime(new Date());
			faultDeclareOptLog.setOptType(OptType.CHANGE);
			faultDeclareOptLog.setDescInfo(descInfo);
			faultDeclareOptLogService.save(faultDeclareOptLog);

			//将原有故障申报记录更新为技术咨询记录
			faultDeclare.setDeclareType(DeclareType.TECHCONSULT);
			faultDeclare.setFaultStatus(AllStatus.CHANGED);
			faultDeclare.setUpdateUser(user.getName());
			faultDeclare.setOperUser(user.getName());
			faultDeclare.setUser(user);
			faultDeclare.setUpdateTime(new Date());
			faultDeclare.setCurrentTaskName("转咨询");
			faultDeclareService.update(faultDeclare);

			//完成工作流
			taskVariables.put("oper", "change");
			workflowService.complete(task.getId(), taskVariables);
			addSuccess(model, "转咨询成功！");
			//添加操作日志
			super.addLog(request, "转咨询成功(故障摘要:"+faultDeclare.getFaultKey()+")");
		} catch (Exception e) {
			e.printStackTrace();
			addSuccess(model, "转咨询失败！原因是："+e.getMessage());
		}
		return "techsupport/fault/deal/result";
	}

	/**
	 *  确认提醒操作
	 *  
	 * @author：KuYonggang
	 * @date：2014-4-25下午4:23:56
	 * @param：
	 * @return：String
	 */
	@RequestMapping(value = "confirmwarn.do", method = RequestMethod.GET)
	public String setupConfirmAlarmForm(@ModelAttribute("pageModel")FaultDeclareQueryModel queryModel,
			HttpServletRequest request, Model model) {
		return "techsupport/fault/deal/confirmwarn";
	}

	@RequestMapping(value = "confirmwarn.do", method = RequestMethod.POST)
	public String processConfirmAlarmForm(HttpServletRequest request, Model model,
			@RequestParam("id") String id,
			@RequestParam("descInfo") String descInfo,
			@RequestParam("confirmTime")Date confirmTime,
			@RequestParam("userConfirm") boolean userConfirm,
			@RequestParam("faultdeclarepi") String processInstanceId) {
		try {
			//当前登录用户
			User user = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
			Map<String, Object> variables = new HashMap<String, Object>();
			Task task = workflowService.getTaskByProcessInstaceId(processInstanceId);
			//通过ID获取故障申报记录对象
			FaultDeclare faultDeclare = faultDeclareService.getFaultDeclareByID(id);
			//组合操作日志对象
			FaultDeclareOptLog faultDeclareOptLog = new FaultDeclareOptLog();
			faultDeclareOptLog.setFromStatus(faultDeclare.getFaultStatus());

			//用户结单
			if(userConfirm){
				variables.put("userConfirm", userConfirm);
				faultDeclare.setFaultStatus(AllStatus.FINISHED);
				faultDeclare.setUpdateUser(user.getName());
				faultDeclare.setOperUser(user.getName());
				faultDeclare.setConfirmTime(new Date());
				faultDeclare.setCurrentTaskName("值班结单");
				faultDeclareOptLog.setOptType(OptType.CONFIRMWARN);
				faultDeclareOptLog.setToStatus(AllStatus.FINISHED);
				//结束该步流程
				workflowService.complete(task.getId(), variables);
				
				//添加值班员结单操作日志
				super.addLog(request, "确认提醒成功，值班结单(故障摘要:"+faultDeclare.getFaultKey()+")");
			}else {
				faultDeclare.setUpdateUser(user.getName());
				faultDeclare.setOperUser(user.getName());
				faultDeclare.setConfirmTime(confirmTime);
				faultDeclareOptLog.setOptType(OptType.CONFIRMWARN);
				faultDeclareOptLog.setToStatus(faultDeclare.getFaultStatus());
				//添加值班员未结单操作日志
				super.addLog(request, "确认提醒成功，值班未结单(故障摘要:"+faultDeclare.getFaultKey()+")");
			}
			faultDeclare.setUpdateTime(new Date());
			faultDeclare.setUser(user);
			//将故障申报对象更新数据库
			faultDeclareService.update(faultDeclare);

			faultDeclareOptLog.setOptUserName(user.getName());
			faultDeclareOptLog.setOptUserDepartment(user.getDept());
			faultDeclareOptLog.setOptUser(user);
			faultDeclareOptLog.setFaultDeclare(faultDeclare);
			faultDeclareOptLog.setDescInfo(descInfo);
			faultDeclareOptLog.setOptTime(new Date());
			//将操作日志对象保存进数据库中
			faultDeclareOptLogService.save(faultDeclareOptLog);
			
			addSuccess(model, "提醒成功！");
		} catch (Exception e) {
			e.printStackTrace();
			addSuccess(model, "提醒失败！原因是："+e.getMessage());
		}
		
		return "techsupport/fault/deal/result";
	}
	/**
	 * 
	 * 方法说明：当前用户任务列表
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年3月28日上午9:17:28
	 * @param session
	 * @param request
	 * @param model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "taskList.do", method = RequestMethod.GET)
	public String taskList(HttpSession session, HttpServletRequest request,
			Model model) {
		String userId = ((User) request.getSession().getAttribute(
				SessionNames.LOGIN_USER)).getId();
		logger.debug("userId:" + userId);
		model.addAttribute("taskList", workflowService.findTodoTasks(userId));
		return "techsupport/fault/deal/manage";
	}

	/**
	 * 读取运行中的流程实例
	 * 
	 * @return
	 */
	@RequestMapping(value = "runningList.do")
	public String runningList(HttpServletRequest request, Model model) {
		model.addAttribute("runningList",
				workflowService.findRunningProcessInstaces());
		return "tempcircuit/running";
	}

	/**
	 * 读取已完成的流程实例
	 * 
	 * @return
	 */
	@RequestMapping(value = "finished.do")
	public String finishedList(HttpServletRequest request, Model model) {
		model.addAttribute("finishedList",
				workflowService.findFinishedProcessInstaces());
		return "tempcircuit/finished";
	}

	/**
	 * 签收任务
	 */
	@RequestMapping(value = "claim.do")
	public String claim(@RequestParam("id") String taskId, Model model,
			HttpServletRequest request) {
		String userId = ((User) request.getSession().getAttribute(
				SessionNames.LOGIN_USER)).getId();
		workflowService.claim(taskId, userId);
		model.addAttribute("taskList", workflowService.findTodoTasks(userId));
		return "tempcircuit/taskList";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdFormat, true));
	}
}
