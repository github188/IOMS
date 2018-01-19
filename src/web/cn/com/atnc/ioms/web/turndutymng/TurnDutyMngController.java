package cn.com.atnc.ioms.web.turndutymng;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.news.News;
import cn.com.atnc.ioms.entity.phonemng.AgentInformation;
import cn.com.atnc.ioms.entity.turndutymng.ShiftDutyRecord;
import cn.com.atnc.ioms.entity.turndutymng.SignLeaveRecord;
import cn.com.atnc.ioms.enums.news.NewsColumnsEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyRoleEnum;
import cn.com.atnc.ioms.mng.phonemng.IAgentInfoService;
import cn.com.atnc.ioms.mng.phonemng.ICallInfoService;
import cn.com.atnc.ioms.mng.turndutymng.IShiftDutyRecordService;
import cn.com.atnc.ioms.mng.turndutymng.ISignLeaveService;
import cn.com.atnc.ioms.model.turndutymng.ShiftDutyQueryModel;
import cn.com.atnc.ioms.model.turndutymng.SignLeaveQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 *
 * @author hantianyu
 * @desc 交接班管理-controller
 *
 */
@Controller("TurnDutyMngController")
@RequestMapping("turndutymng/change/")
public class TurnDutyMngController extends MyBaseController {

	@Autowired
	private ISignLeaveService signLeaveService;
	@Autowired
	private IShiftDutyRecordService shiftDutyService;
	@Autowired
	private IAgentInfoService agentService;
	@Autowired
	private ICallInfoService callInfoService;

	@RequestMapping(value = "viewrecord.do", method = RequestMethod.GET)
	public String getViewRecord(
			@ModelAttribute("queryModel") SignLeaveQueryModel queryModel,
			Model model, HttpServletRequest request) {
		try {

			super.pageInfo(model, request);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "turndutymng/change/viewrecord";
	}

	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") SignLeaveQueryModel queryModel,
			Model model, HttpServletRequest request) {
		try {

			User name = getCurrentUser(request);
			model.addAttribute("startdate",
					signLeaveService.getNextDay(new Date()));// 开始日期
			model.addAttribute("enddate", new Date());// 结束日期

			AgentInformation agentInfo = agentService.viewAgentInfoByName(name
					.getName());
			if (agentInfo != null) {
				model.addAttribute("agent", agentInfo.getAgentinfo());
			} else {
				model.addAttribute("agent", "0");
			}

			// 获取是否签到
			if (signLeaveService.isOndutyByUser(name)) {
				// 在岗
				model.addAttribute("isflag", "ON");
			} else {
				// 不在岗
				model.addAttribute("isflag", "NO");
			}
			// 判断当前用户是否为值班经理
			if (signLeaveService.isMangerByUser(name)) {
				// 是
				model.addAttribute("isManager", "yes");
			} else {
				model.addAttribute("isManager", "no");
			}
			if (signLeaveService.isActiveByUser(name)) {
				model.addAttribute("dutyStatu", "Agent");
			} else {
				model.addAttribute("dutyStatu", "noAgent");
			}
			// 获取值班地点
			model.addAttribute("dutyPlace",
					signLeaveService.getDutyPlaceByUser(name));

			super.pageInfo(model, request);
			// 获取当前登陆用户姓名
			User user = getCurrentUser(request);
			model.addAttribute("username", user.getName());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "turndutymng/change/manage";
	}

	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") SignLeaveQueryModel queryModel,
			Model model, HttpServletRequest request) throws IOException {
		try {

			User name = getCurrentUser(request);
			model.addAttribute("startdate",
					signLeaveService.getNextDay(DateUtilTools.getNowDate()));// 开始日期
			model.addAttribute("enddate", new Date());// 结束日期
			// 获取是否签到
			if (signLeaveService.isOndutyByUser(name)) {
				// 在岗
				model.addAttribute("isflag", "ON");
			} else {
				// 不在岗
				model.addAttribute("isflag", "NO");
			}
			// 判断当前用户是否为值班经理
			if (signLeaveService.isMangerByUser(name)) {
				// 是
				model.addAttribute("isManager", "yes");
			} else {
				model.addAttribute("isManager", "no");
			}
			// 获取值班地点
			model.addAttribute("dutyPlace",
					signLeaveService.getDutyPlaceByUser(name));
			List<SignLeaveRecord> signList = signLeaveService
					.getSignRecordListByDate(DateUtilTools.getNowDate(), name);
			ShiftDutyQueryModel queryModelShift = new ShiftDutyQueryModel();
			queryModelShift.setCreatime(DateUtilTools.getNowDate());
			List<ShiftDutyRecord> shiftList = shiftDutyService.getRecordList(
					queryModelShift, name);
			model.addAttribute("lists", signList);
			model.addAttribute("listshift", shiftList);
			// 获取当前登陆人姓名
			User user = getCurrentUser(request);
			model.addAttribute("username", user.getName());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "turndutymng/change/queryResult";
	}

	/**
	 *
	 * @Auther hantianyu
	 * @creatime 2016-5-26下午3:49:04
	 * @param pageModel
	 * @param model
	 * @param request
	 * @return String TODO 添加交接班日志
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String addUrl(
			@ModelAttribute("pageModel") ShiftDutyRecord pageModel,
			Model model, HttpServletRequest request) {

		User user = getCurrentUser(request);

		if (signLeaveService.isOndutyByUser(user)) {
			try {

				// 在岗
				model.addAttribute("isflag", "ON");

				SignLeaveRecord sign = signLeaveService.findViewByUser(user);
				// 赋值
				String userRole = "";
				String userPlace = "";
				if (sign != null) {
					userRole = sign.getDutyRole().getValue();
					userPlace = sign.getDutyPlace().getValue();
				}
				model.addAttribute("username", user.getName());
				model.addAttribute("userrole", userRole);
				model.addAttribute("userplace", userPlace);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			return "turndutymng/change/add";
		} else {
			// 不在岗
			model.addAttribute("isflag", "NO");
			return "turndutymng/change/manage";
		}

	}

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String processAddNews(
			@ModelAttribute("pageModel") ShiftDutyRecord pageModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			User user = getCurrentUser(request);
			// 判断当前用户是否为值班经理
			if (signLeaveService.isMangerByUser(user)) {
				// 是
				model.addAttribute("isManager", "yes");
			} else {
				model.addAttribute("isManager", "no");
			}

			model.addAttribute("username", user.getName());
			try {
				pageModel.setCreater(user);
				shiftDutyService.save(pageModel);
				model.addAttribute("svo", pageModel);
				addSuccess(model, "提交成功");
			} catch (Exception e) {
				addError(model, "提交失败");
				e.printStackTrace();

			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "turndutymng/change/shift/result";
	}

	/**
	 *
	 * @Auther hantianyu
	 * @creatime 2016-5-19下午2:48:36
	 * @param queryModel
	 * @param model
	 * @param request
	 * @return String TODO 签到
	 */
	@RequestMapping(value = "signin.do", method = RequestMethod.GET)
	public String signinUrl(
			@ModelAttribute("pageModel") SignLeaveRecord pageModel,
			Model model, HttpServletRequest request) {
		try {

			// 获取角色枚举类
			List<DutyRoleEnum> roles = Arrays.asList(DutyRoleEnum.values());
			model.addAttribute("roles", roles);
			// 获取值班地点枚举类
			List<DutyPlaceEnum> places = Arrays.asList(DutyPlaceEnum.values());
			model.addAttribute("places", places);
			// 获取当前用户
			User name = (User) WebUtils.getSessionAttribute(request,
					SessionNames.LOGIN_USER);
			model.addAttribute("loginUser", name.getName());

			ShiftDutyQueryModel shiftDutyQueryModel = new ShiftDutyQueryModel();
			shiftDutyQueryModel.setCreatime(DateUtilTools.getNowDate());
			shiftDutyQueryModel.setDutyPlaces(pageModel.getDutyPlace());
			// ;
			model.addAttribute("shiftRecordList",
					shiftDutyService.getRecordListBySign(shiftDutyQueryModel));
			System.err.println(shiftDutyService
					.getRecordListBySign(shiftDutyQueryModel));
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "turndutymng/change/signin";
	}

	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-8-21下午5:20:11
	 * @param pageModel
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String TODO
	 */
	@RequestMapping(value = "signin.do", method = RequestMethod.POST)
	public String signinUrlPost(
			@ModelAttribute("pageModel") SignLeaveRecord pageModel,
			HttpServletRequest request, Model model) throws IOException,
			ServiceException {
		try {

			User user = getCurrentUser(request);
			pageModel.setUserinfo(user);
			System.err.println("--post signin--");
			model.addAttribute("username", user.getName());

			// 获取是否签到
			if (signLeaveService.isOndutyByUser(user)) {
				// 在岗
				model.addAttribute("isflag", "ON");

				model.addAttribute("returnStr", new ResultModel(false, "签到失败",
						null).toJson());
			} else {
				// 不在岗
				model.addAttribute("isflag", "NO");

				signLeaveService.save(pageModel);
				model.addAttribute("vo", pageModel);

				model.addAttribute("returnStr", new ResultModel(true, "签到成功",
						null).toJson());
			}
			// 判断当前用户是否为值班经理
			if (signLeaveService.isMangerByUser(user)) {
				// 是
				model.addAttribute("isManager", "yes");
			} else {
				model.addAttribute("isManager", "no");
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getShiftRecord
	 * @Description:动态select
	 * @Param:@param dutyplace
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年10月18日 下午4:14:26
	 */
	@RequestMapping(value = "getShiftRecord.dox", method = RequestMethod.GET)
	public String getShiftRecord(@RequestParam("dutyplace") String dutyplace,
			HttpServletRequest request, Model model,
			@ModelAttribute("pageModel") SignLeaveRecord pageModel) {
		try {

			// 获取角色枚举类
			List<DutyRoleEnum> roles = Arrays.asList(DutyRoleEnum.values());
			model.addAttribute("roles", roles);
			// 获取值班地点枚举类
			List<DutyPlaceEnum> places = Arrays.asList(DutyPlaceEnum.values());
			model.addAttribute("places", places);
			// 获取当前用户
			User name = (User) WebUtils.getSessionAttribute(request,
					SessionNames.LOGIN_USER);
			model.addAttribute("loginUser", name.getName());

			ShiftDutyQueryModel shiftDutyQueryModel = new ShiftDutyQueryModel();
			shiftDutyQueryModel.setCreatime(DateUtilTools.getNowDate());
			shiftDutyQueryModel.setDutyPlaces(DutyPlaceEnum.valueOf(dutyplace));

			// ;
			// model.addAttribute("shiftRecordList",shiftDutyService.getRecordListBySign(shiftDutyQueryModel));

			// System.err.println(dutyplace);

			try {
				model.addAttribute("returnStr", JacksonTools
						.toJsonStr(shiftDutyService
								.getRecordListBySign(shiftDutyQueryModel)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 *
	 * @Auther hantianyu
	 * @creatime 2016-5-30上午9:07:18
	 * @param id
	 * @param request
	 * @param model
	 * @return String TODO 修改函数
	 */
	@RequestMapping(value = "mod.do", method = RequestMethod.GET)
	public String setupModForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		try {

			ShiftDutyRecord shiftduty = shiftDutyService.findViewById(id);
			// News news = newsMngService.findById(id);
			// User user = getCurrentUser(request);

			model.addAttribute("pageModel", shiftduty);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "turndutymng/change/mod";
	}

	/**
	 *
	 * @Auther hantianyu
	 * @creatime 2016-5-30上午10:30:25
	 * @param id
	 * @param shiftduty
	 * @param request
	 * @param model
	 * @return String TODO 修改提交
	 */
	@RequestMapping(value = "mod.do", method = RequestMethod.POST)
	public String processModifyShift(@RequestParam("id") String id,
			@ModelAttribute("pageModel") ShiftDutyRecord shiftduty,
			HttpServletRequest request, Model model) throws IOException {

		User user = getCurrentUser(request);
		try {

			model.addAttribute("username", user.getName());
			// 判断当前用户是否为值班经理
			if (signLeaveService.isMangerByUser(user)) {
				// 是
				model.addAttribute("isManager", "yes");
			} else {
				model.addAttribute("isManager", "no");
			}

			ShiftDutyRecord shift = shiftDutyService.findViewById(id);
			shift.setOperator(user);
			shift.setOperatime(new Date());
			shift.setRemark(shiftduty.getRemark());
			shiftDutyService.Update(shift);
			/* model.addAttribute("vo",shiftDutyService.Update(shift)); */

			/* addSuccess(model, "修改交接班日志成功！"); */
			super.addLog(request, "修改交接班日志成功！");
			model.addAttribute("returnStr",
					new ResultModel(true, "修改成功", null).toJson());

		} catch (Exception e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "修改失败", null).toJson());
			logger.info(e.getMessage());
			/* e.printStackTrace(); */
		}
		return "returnnote";
	}

	/**
	 *
	 * @Author:hantianyu
	 * @Title:processDeleteShift
	 * @Description:TODO
	 * @Param:@param id
	 * @Param:@param session
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年6月1日 下午3:23:36
	 */
	@RequestMapping(value = "/del.do", method = RequestMethod.POST)
	public String processDeleteNews(@RequestParam("id") String id,
			HttpSession session, HttpServletRequest request, Model model) {

		try {

			ShiftDutyRecord shift = shiftDutyService.findViewById(id);
			shiftDutyService.Del(shift);
			addSuccess(model, "删除成功");
			super.addLog(request, "删除成功");

		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return "turndutymng/change/shift/result";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:processLeave
	 * @Description:离岗
	 * @Param:@param id
	 * @Param:@param session
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Param:@throws IOException
	 * @Return:String
	 * @Creatime:2016年10月8日 上午10:04:48
	 */
	@RequestMapping(value = "/leave.do", method = RequestMethod.POST)
	public String processLeave(@RequestParam("id") String id,
			HttpSession session, HttpServletRequest request, Model model)
			throws IOException {
		try {

			User name = getCurrentUser(request);
			// 获取是否签到
			if (signLeaveService.isOndutyByUser(name)) {
				// 在岗
				model.addAttribute("isflag", "ON");
			} else {
				// 不在岗
				model.addAttribute("isflag", "NO");
			}
			// 判断当前用户是否为值班经理
			if (signLeaveService.isMangerByUser(name)) {
				// 是
				model.addAttribute("isManager", "yes");
			} else {
				model.addAttribute("isManager", "no");
			}
			if (signLeaveService.isActiveByUser(name)) {
				model.addAttribute("dutyStatu", "Agent");
			} else {
				model.addAttribute("dutyStatu", "noAgent");
			}
			try {
				SignLeaveRecord sign = signLeaveService.findById(id);
				String flag = signLeaveService.dutyLeave(sign);
				model.addAttribute("vo", signLeaveService.findById(id));

				if (flag.equals("MANAGE2")) {
					model.addAttribute("returnStr",
							"{\"result\":false,\"msg\":\""
									+ "当前下一班值班经理未签到，不能离岗!" + "\"}");
					super.addLog(request, "当前下一班值班经理未签到，不能离岗!");
				} else if (flag.equals("LESS2")) {
					model.addAttribute("returnStr",
							"{\"result\":false,\"msg\":\"" + "当前无其他工程师在岗，不能离岗!"
									+ "\"}");
					super.addLog(request, "当前无其他工程师在岗，不能离岗!");
				} else if (flag.equals("SUCCESS")) {
					model.addAttribute("returnStr",
							"{\"result\":true,\"msg\":\"" + "离岗成功！" + "\"}");
					super.addLog(request, "离岗成功！");
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.info(e.getMessage());
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getMngLeave
	 * @Description:代离岗页面加载
	 * @Param:@param id
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年9月26日 下午2:17:36
	 */
	@RequestMapping(value = "mngleave.do", method = RequestMethod.GET)
	public String getMngLeave(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		try {

			SignLeaveRecord signLeaveRecord = signLeaveService.findById(id);

			model.addAttribute("pageModel", signLeaveRecord);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "turndutymng/signleavemng/mngleave";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:postMngLeave
	 * @Description:代离岗提交
	 * @Param:@param id
	 * @Param:@param session
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Param:@throws IOException
	 * @Return:String
	 * @Creatime:2016年9月26日 下午3:32:12
	 */
	@RequestMapping(value = "mngleave.do", method = RequestMethod.POST)
	public String postMngLeave(@RequestParam("id") String id,
			@ModelAttribute("pageModel") SignLeaveRecord signLeaveRecord,
			HttpSession session, HttpServletRequest request, Model model)
			throws IOException {
		try {

			User name = getCurrentUser(request);

			System.err.println("mngleave-post");

			// 获取是否签到---------------------
			if (signLeaveService.isOndutyByUser(name)) {
				// 在岗
				model.addAttribute("isflag", "ON");
			} else {
				// 不在岗
				model.addAttribute("isflag", "NO");
			}
			// ////////////////////-----------END

			// 判断当前用户是否为值班经理----------
			if (signLeaveService.isMangerByUser(name)) {
				// 是
				model.addAttribute("isManager", "yes");
			} else {
				model.addAttribute("isManager", "no");
			}
			// ////////////////////------------END

			// 是否有坐席------------
			if (signLeaveService.isActiveByUser(name)) {
				model.addAttribute("dutyStatu", "Agent");
			} else {
				model.addAttribute("dutyStatu", "noAgent");
			}
			// ///////////////////--------------END
			try {
				// 赋值
				SignLeaveRecord sign = signLeaveService.findById(id);
				sign.setLeaveTime(signLeaveRecord.getLeaveTime());
				sign.setSpare1(signLeaveRecord.getSpare1());
				sign.setSpare2(name.getName());
				sign.setCreateTime(new Date());
				//
				System.err.println("LeaveTime:" + sign.getLeaveTime());
				System.err.println("Spare1:" + sign.getSpare1());

				String flag = signLeaveService.dutyMngLeave(sign);
				model.addAttribute("vo", signLeaveService.findById(id));

				if (flag.equals("SUCCESS")) {
					model.addAttribute("returnStr",
							"{\"result\":true,\"msg\":\"" + "代离岗成功！" + "\"}");
					super.addLog(request, "代离岗成功！");
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.info(e.getMessage());
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:inCallCenter
	 * @Description:通信基地用户进入呼叫中心
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Param:@throws IOException
	 * @Return:String
	 * @Creatime:2016年10月11日 下午3:22:16
	 */
	@RequestMapping(value = "inphone.do", method = RequestMethod.POST)
	public String inCallCenter(HttpServletRequest request, Model model)
			throws IOException {
		try {

			System.err.println("inphone======get");
			User name = getCurrentUser(request);

			String result = callInfoService.modDutyStatus(name, "in");
			if (result.equals("FAIL")) {
				model.addAttribute("returnStr", "{\"result\":true,\"msg\":\""
						+ "坐席已满！" + "\"}");
				super.addLog(request, "坐席已满！");
			} else {
				model.addAttribute("returnStr", "{\"result\":true,\"msg\":\""
						+ "已签入坐席，状态已变更！" + "\"}");
				super.addLog(request, "已签入坐席！");
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";

	}
}
