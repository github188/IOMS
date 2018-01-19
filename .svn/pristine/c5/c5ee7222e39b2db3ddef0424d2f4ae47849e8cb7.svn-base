package cn.com.atnc.ioms.web.turndutymng;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.phonemng.AgentInformation;
import cn.com.atnc.ioms.entity.turndutymng.ShiftDutyRecord;
import cn.com.atnc.ioms.entity.turndutymng.SignLeaveRecord;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyRoleEnum;
import cn.com.atnc.ioms.mng.phonemng.IAgentInfoService;
import cn.com.atnc.ioms.mng.phonemng.ICallAgentMngService;
import cn.com.atnc.ioms.mng.turndutymng.IShiftDutyRecordService;
import cn.com.atnc.ioms.mng.turndutymng.ISignLeaveService;
import cn.com.atnc.ioms.model.turndutymng.ShiftDutyQueryModel;
import cn.com.atnc.ioms.model.turndutymng.SignLeaveQueryModel;
import cn.com.atnc.ioms.model.turndutymng.TurnDutyQueryModel;
import cn.com.atnc.ioms.util.HqlStringTools;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 
 * @author hantianyu
 * @desc 值班管理-Controller
 *
 */

@Controller("OnDutyMngController")
@RequestMapping("turndutymng/")
public class OnDutyMngController extends MyBaseController {

	//
	@Autowired
	private ISignLeaveService signLeaveService;
	@Autowired
	private IShiftDutyRecordService shiftDutyService;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IAgentInfoService agentService;

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:manage
	 * @Description:TODO
	 * @Param:@param queryModel
	 * @Param:@param model
	 * @Param:@param request
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年8月31日 下午3:29:16
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") TurnDutyQueryModel queryModel,
			Model model, HttpServletRequest request) {
		try {

			// 获取角色枚举类
			List<DutyRoleEnum> roles = Arrays.asList(DutyRoleEnum.values());
			model.addAttribute("roles", roles);
			// 获取值班地点枚举类
			List<DutyPlaceEnum> places = Arrays.asList(DutyPlaceEnum.values());
			model.addAttribute("places", places);

			User user = getCurrentUser(request);
			// 获取当前登录人值班信息 start
			model.addAttribute("userid", user.getId());

			AgentInformation agentInfo = agentService.viewAgentInfoByName(user
					.getName());
			if (agentInfo != null) {
				model.addAttribute("agent", agentInfo.getAgentinfo());
			} else {
				model.addAttribute("agent", "0");
			}

			// 获取是否签到
			if (signLeaveService.isOndutyByUser(user)) {
				// 在岗
				model.addAttribute("isflag", "ON");
			} else {
				// 不在岗
				model.addAttribute("isflag", "NO");
			}
			SignLeaveQueryModel qm = new SignLeaveQueryModel();
			qm.setUserinfo(user);
			qm.setSpare1("1");
			SignLeaveRecord sign = signLeaveService.getViewByUser(qm);
			String signtime = "";
			String leavetime = "";
			String engstatus = "";
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss");

			try {
				if (sign != null) {
					signtime = format.format(sign.getSignTime());
					if (sign.getLeaveTime() != null)
						leavetime = format.format(sign.getLeaveTime());
					engstatus = sign.getDutyStatus().getValue();
				}

				model.addAttribute("signtime", signtime);
				model.addAttribute("leavetime", leavetime);
				model.addAttribute("engstatus", engstatus);
			} catch (Exception e) {
				e.printStackTrace();
				logger.info(e.getMessage());
			}
			// /////////--end

			super.pageInfo(model, request);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return "turndutymng/tab/manage";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:manageList
	 * @Description:TODO
	 * @Param:@param queryModel
	 * @Param:@param optType
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Param:@throws IOException
	 * @Param:@throws ServiceException
	 * @Return:String
	 * @Creatime:2016年8月31日 下午3:03:43
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") TurnDutyQueryModel queryModel,
			@RequestParam("optType") String optType,
			HttpServletRequest request, Model model) throws IOException,
			ServiceException {
		Pagination pagn = null;
		try {

			User user = getCurrentUser(request);
			model.addAttribute("username", user.getName());

			// 通配符转换字符串
			if (!StringUtils.isEmpty(queryModel.getCreater())) {
				// 将被查询人中的_下划线转换成字符_
				// queryModel.setCreater(StringUtils.replace(queryModel.getCreater(),
				// "_", "/_"));
				queryModel.setCreater(HqlStringTools
						.replaceSpecialChar(queryModel.getCreater()));
			}
			String dutyplace = shiftDutyService.getDutyPlaceByUser(user);
			model.addAttribute("dutyplace", dutyplace);

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
		switch (optType == null ? "" : optType) {
		case "ONDUTYMNG":
			try {

				// 交接班记录
				pagn = shiftDutyService.queryPage(queryModel);
				model.addAttribute("pagn", pagn);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			return "turndutymng/onduty/queryResult";
		case "CHANGEMNG":
			// 签到/离岗记录
			try {

				pagn = signLeaveService.queryPage(queryModel);
				model.addAttribute("pagn", pagn);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			return "turndutymng/signleavemng/queryResult";
		case "DUTYCOUNTMNG":
			// 值班时长统计
			try {

				pagn = signLeaveService.getCountTimes(queryModel);
				model.addAttribute("pagn", pagn);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			return "turndutymng/dutycount/queryResult";

		default:
			try {

				pagn = shiftDutyService.queryPage(queryModel);
				model.addAttribute("pagn", pagn);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			return "turndutymng/onduty/queryResult";
		}
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:setupModForm
	 * @Description:TODO
	 * @Param:@param id
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年6月1日 下午3:20:59
	 */
	@RequestMapping(value = "onduty/mod.do", method = RequestMethod.GET)
	public String setupModForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		try {

			ShiftDutyRecord shiftduty = shiftDutyService.findViewById(id);

			model.addAttribute("pageModel", shiftduty);
			System.out.println("-------====get==========--------");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "turndutymng/onduty/mod";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:processModifyShift
	 * @Description:TODO
	 * @Param:@param id
	 * @Param:@param shiftduty
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年6月1日 下午3:21:03
	 */
	@RequestMapping(value = "onduty/mod.do", method = RequestMethod.POST)
	public String processModifyShift(@RequestParam("id") String id,
			@ModelAttribute("pageModel") ShiftDutyRecord shiftduty,
			HttpServletRequest request, Model model) throws IOException {
		try {

			User user = getCurrentUser(request);
			try {
				ShiftDutyRecord shift = shiftDutyService.findViewById(id);
				shift.setOperator(user);
				shift.setOperatime(new Date());
				shift.setRemark(shiftduty.getRemark());

				model.addAttribute("username", user.getName());
				// 判断当前用户是否为值班经理
				if (signLeaveService.isMangerByUser(user)) {
					// 是
					model.addAttribute("isManager", "yes");
				} else {
					model.addAttribute("isManager", "no");
				}
				model.addAttribute("vo", shiftDutyService.Update(shift));
				// shiftDutyService.Update(shift);
				// String result = newsMngService.approve(id, remark,
				// processInstanceId, pass, user);

				addSuccess(model, "修改交接班日志成功！");
				super.addLog(request, "修改交接班日志成功！");

			} catch (Exception e) {
				e.printStackTrace();
				logger.info(e.getMessage());
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "turndutymng/onduty/result";
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
	 * @Creatime:2016年6月1日 下午3:22:54
	 */
	@RequestMapping(value = "onduty/del.do", method = RequestMethod.POST)
	public String processDeleteShift(@RequestParam("id") String id,
			HttpSession session, HttpServletRequest request, Model model) {
		try {
			User user = getCurrentUser(request);
			ShiftDutyRecord shift = shiftDutyService.findViewById(id);
			shift.setOperatime(new Date());
			shift.setOperator(user);
			shiftDutyService.Del(shift);
			addSuccess(model, "删除成功");
			super.addLog(request, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return "turndutymng/onduty/result";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:processLeave
	 * @Description:TODO
	 * @Param:@param id
	 * @Param:@param session
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Param:@throws IOException
	 * @Return:String
	 * @Creatime:2016年8月31日 下午5:03:50
	 */
	@RequestMapping(value = "signleavemng/leave.do", method = RequestMethod.POST)
	public String processLeave(@RequestParam("id") String id,
			HttpSession session, HttpServletRequest request, Model model)
			throws IOException {
		try {

			SignLeaveRecord sign = signLeaveService.findById(id);
			String flag = signLeaveService.dutyLeave(sign);
			model.addAttribute("vo", signLeaveService.findById(id));

			if (flag.equals("MANAGE2")) {
				model.addAttribute("returnStr", "{\"result\":false,\"msg\":\""
						+ "当前下一班值班经理未签到，不能离岗!" + "\"}");
				super.addLog(request, "当前下一班值班经理未签到，不能离岗!");
			} else if (flag.equals("LESS2")) {
				model.addAttribute("returnStr", "{\"result\":false,\"msg\":\""
						+ "当前在岗值班工程师少于2人，不能离岗!" + "\"}");
				super.addLog(request, "当前在岗值班工程师少于2人，不能离岗!");
			} else if (flag.equals("SUCCESS")) {
				model.addAttribute("returnStr", "{\"result\":true,\"msg\":\""
						+ "离岗成功！" + "\"}");
				super.addLog(request, "离岗成功！");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:setupViewForm
	 * @Description:TODO
	 * @Param:@param id
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年8月31日 下午5:03:44
	 */
	@RequestMapping(value = "signleavemng/viewrecord.do", method = RequestMethod.GET)
	public String setupViewForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		try {

			SignLeaveRecord sign = signLeaveService.findById(id);
			ShiftDutyQueryModel qm = new ShiftDutyQueryModel();
			qm.setSignRecord(sign);
			List<ShiftDutyRecord> lists = shiftDutyService
					.getRecordBySignId(qm);

			model.addAttribute("listshift", lists);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "turndutymng/signleavemng/viewrecord";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:ajaxSignOut
	 * @Description:TODO
	 * @Param:@param name
	 * @Param:@param model
	 * @Param:@param request
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年10月12日 下午4:59:18
	 */
	@RequestMapping(value = "leave.dox", method = RequestMethod.GET)
	public String ajaxSignOut(@RequestParam("name") String name, Model model,
			HttpServletRequest request) {
		try {

			User user = userDao.findById(name);
			SignLeaveQueryModel qm = new SignLeaveQueryModel();
			qm.setUserinfo(user);
			qm.setSpare1("1");
			SignLeaveRecord sign = signLeaveService.getViewByUser(qm);
			try {
				SignLeaveRecord signleave = signLeaveService.findById(sign
						.getId());
				String flag = signLeaveService.dutyLeave(signleave);
				model.addAttribute("vo",
						signLeaveService.findById(signleave.getId()));

				if (flag.equals("MANAGE2")) {
					model.addAttribute("returnStr",
							"{\"result\":false,\"msg\":\""
									+ "当前下一班值班经理未签到，不能离岗!" + "\"}");
					super.addLog(request, "当前下一班值班经理未签到，不能离岗!");
				} else if (flag.equals("LESS2")) {
					model.addAttribute("returnStr",
							"{\"result\":false,\"msg\":\""
									+ "当前在岗值班工程师少于2人，不能离岗!" + "\"}");
					super.addLog(request, "当前在岗值班工程师少于2人，不能离岗!");
				} else if (flag.equals("SUCCESS")) {
					model.addAttribute("returnStr",
							"{\"result\":true,\"msg\":\"" + "离岗成功！" + "\"}");
					super.addLog(request, "离岗成功！");
				}

			} catch (Exception e) {
				// logger.error("数据异常！");
				e.printStackTrace();
				logger.info(e.getMessage());
				throw new RuntimeException(e);

			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getRecycle
	 * @Description:回收站
	 * @Param:@param queryModel
	 * @Param:@param model
	 * @Param:@param request
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年10月12日 下午5:10:55
	 */
	@RequestMapping(value = "recycle.do", method = RequestMethod.GET)
	public String getRecycle(
			@ModelAttribute("queryModel") TurnDutyQueryModel queryModel,
			Model model, HttpServletRequest request) {
		try {

			super.pageInfo(model, request);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "turndutymng/recycle/manage";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:postRecycle
	 * @Description:回收站
	 * @Param:@param queryModel
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Param:@throws IOException
	 * @Param:@throws ServiceException
	 * @Return:String
	 * @Creatime:2016年10月12日 下午5:11:04
	 */
	@RequestMapping(value = "recycle.do", method = RequestMethod.POST)
	public String postRecycle(
			@ModelAttribute("queryModel") TurnDutyQueryModel queryModel,
			HttpServletRequest request, Model model) throws IOException,
			ServiceException {
		try {

			Pagination pagn = null;
			User user = getCurrentUser(request);

			pagn = shiftDutyService.queryRecyclePage(queryModel);
			model.addAttribute("pagn", pagn);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "turndutymng/recycle/queryResult";

	}

}
