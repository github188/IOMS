package cn.com.atnc.ioms.web.duty.fax.day;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.atm.ATMDayRoute;
import cn.com.atnc.ioms.entity.duty.atm.ATMDaySon;
import cn.com.atnc.ioms.entity.duty.fax.day.FaxHardwareDay;
import cn.com.atnc.ioms.entity.duty.fax.day.FaxProcessDay;
import cn.com.atnc.ioms.enums.duty.atm.HaveNoEnum;
import cn.com.atnc.ioms.enums.duty.atm.StatusResultEnum;
import cn.com.atnc.ioms.mng.duty.fax.day.IFaxHardwareDayService;
import cn.com.atnc.ioms.mng.duty.fax.day.IFaxProcessDayService;
import cn.com.atnc.ioms.mng.duty.fax.day.IFaxSystemService;
import cn.com.atnc.ioms.model.duty.atm.AtmDayQueryModel;
import cn.com.atnc.ioms.model.duty.fax.day.FaxSystemModel;
import cn.com.atnc.ioms.model.duty.fax.day.FaxSystemQueryModel;
import cn.com.atnc.ioms.model.turndutymng.SignLeaveQueryModel;
import cn.com.atnc.ioms.model.turndutymng.TurnDutyQueryModel;
import cn.com.atnc.ioms.util.HqlStringTools;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 转报系统日检
 *
 * @author 韩天驭
 * @2017年2月8日 下午4:51:28
 */
@Controller
@RequestMapping("/duty/fax/day/faxsystem/")
public class FaxSystemController extends MyBaseController {

	@Autowired
	private IFaxSystemService ifaxSystemService;
	@Autowired
	private IFaxHardwareDayService ifaxHardwareDayService;
	@Autowired
	private IFaxProcessDayService ifaxProcessDayService;

	/**
	 * 转报系统日检
	 * 
	 * @author 韩天驭
	 * @2017年2月8日 下午4:53:26
	 * @param queryModel
	 * @param model
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") FaxSystemQueryModel queryModel,
			Model model, HttpServletRequest request) {
		try {

			super.pageInfo(model, request);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return "duty/fax/day/faxsystem/manage";
	}

	/**
	 * 
	 * @author 韩天驭
	 * @2017年2月8日 下午4:56:37
	 * @param queryModel
	 * @param optType
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 * @throws ServiceException
	 *             String
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") FaxSystemQueryModel queryModel,
			@RequestParam("optType") String optType,
			HttpServletRequest request, Model model) throws IOException,
			ServiceException {
		Pagination pagn = null;
		// 获取当前登陆用户
		User currentUser = (User) request.getSession().getAttribute(
				SessionNames.LOGIN_USER);
		model.addAttribute("currentUser", currentUser);
		switch (optType == null ? "" : optType) {
		case "PROCESS":
			try {
				// 转报系统进程
				model.addAttribute("pagn",
						ifaxProcessDayService.queryPage(queryModel));
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			return "duty/fax/day/faxsystem/process/queryResult";
		case "HARDWARE":
			// 转报系统硬件
			try {
				model.addAttribute("pagn",
						ifaxHardwareDayService.queryPage(queryModel));
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			return "duty/fax/day/faxsystem/hardware/queryResult";

		default:
			try {
				// 转报系统硬件
				model.addAttribute("pagn",
						ifaxHardwareDayService.queryPage(queryModel));
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			return "duty/fax/day/faxsystem/hardware/queryResult";
		}
	}

	/**
	 * 转报系统日检添加
	 * 
	 * @author 韩天驭
	 * @2017年2月10日 下午2:11:02
	 * @param queryModel
	 * @param model
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String add(@ModelAttribute("pageModel") FaxSystemModel pageModel,
			Model model, HttpServletRequest request) {
		try {
			System.err.println("get---转报系统日检+添加");
			super.pageInfo(model, request);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return "duty/fax/day/faxsystem/add";
	}

	/**
	 * 转报系统日检-添加（转报系统硬盘、专报系统进程）
	 * 
	 * @author 韩天驭
	 * @2017年2月8日 上午11:32:36
	 * @param pageModel
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 * @throws ServiceException
	 *             String
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String doAdd(@ModelAttribute("pageModel") FaxSystemModel pageModel,
			HttpServletRequest request, Model model) throws IOException,
			ServiceException {
		// 获取当前登录用户信息
		User user = (User) request.getSession().getAttribute(
				SessionNames.LOGIN_USER);
		// 调用添加函数
		ifaxSystemService.save(user, pageModel);
		addSuccess(model, "添加记录成功");
		// 记录日志
		super.addLog(request, "添加记录成功");
		model.addAttribute("returnStr", new ResultModel(true, "添加记录成功",
				pageModel).toJson());
		return "returnnote";
	}

	/**
	 * 转报硬件-删除记录
	 * 
	 * @author 韩天驭
	 * @2017年2月16日 下午4:34:37
	 * @param id
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String deleteHardware(
			@RequestParam(value = "id", required = true) String id,
			HttpServletRequest request, Model model) {
		// 调用删除操作
		ifaxHardwareDayService.delete(id);
		addSuccess(model, "删除记录成功");
		// 记录日志
		super.addLog(request, "删除记录成功");

		return "/duty/fax/day/faxsystem/hardware/result";
	}

	/**
	 * 转报系统硬件修改
	 * 
	 * @author 韩天驭
	 * @2017年2月17日 上午10:09:58
	 * @param pageModel
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "mod.do", method = RequestMethod.GET)
	public String modHardware(
			@ModelAttribute("pageModel") FaxSystemModel pageModel,
			@RequestParam(value = "id") String id, Model model) {

		// 根据主键ID查找实体
		FaxHardwareDay faxHardwareDay = ifaxHardwareDayService.findById(id);
		model.addAttribute("faxdata", faxHardwareDay);

		return "/duty/fax/day/faxsystem/hardware/mod";
	}

	/**
	 * 转报系统硬件修改
	 * 
	 * @author 韩天驭
	 * @2017年2月17日 上午10:23:38
	 * @param pageModel
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 */
	@RequestMapping(value = "mod.do", method = RequestMethod.POST)
	public String doModHardware(
			@ModelAttribute("pageModel") FaxSystemModel pageModel,
			HttpServletRequest request, Model model) throws IOException {
		// 根据主键ID查找实体
		FaxHardwareDay faxHardwareDay = new FaxHardwareDay();
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			faxHardwareDay = ifaxHardwareDayService.mod(pageModel, user);
			model.addAttribute("returnStr", new ResultModel(true, "更新记录成功",
					faxHardwareDay).toJson());
		} catch (Exception e) {
			logger.error("更新记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(true, "更新记录失败",
					faxHardwareDay).toJson());
			return "returnnote";
		}
		return "returnnote";
	}

	/**
	 * 查看详情
	 * 
	 * @author 韩天驭
	 * @2017年2月17日 上午10:49:02
	 * @param pageModel
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public String viewHardware(
			@ModelAttribute("pageModel") FaxSystemModel pageModel,
			@RequestParam(value = "id") String id, Model model) {

		// 根据主键ID查找实体
		FaxHardwareDay faxHardwareDay = ifaxHardwareDayService.findById(id);
		model.addAttribute("faxdata", faxHardwareDay);

		return "/duty/fax/day/faxsystem/hardware/view";
	}

	/**
	 * 审核
	 * 
	 * @author 韩天驭
	 * @2017年2月17日 上午10:38:36
	 * @param pageModel
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "judge.do", method = RequestMethod.GET)
	public String judgeHardware(
			@ModelAttribute("pageModel") FaxSystemModel pageModel,
			@RequestParam(value = "id") String id, Model model) {

		// 根据主键ID查找实体
		FaxHardwareDay faxHardwareDay = ifaxHardwareDayService.findById(id);
		model.addAttribute("faxdata", faxHardwareDay);

		return "/duty/fax/day/faxsystem/hardware/judge";
	}

	/**
	 * 审核操作
	 * 
	 * @author 韩天驭
	 * @2017年2月17日 上午10:58:32
	 * @param pageModel
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 */
	@RequestMapping(value = "judge.do", method = RequestMethod.POST)
	public String doJudgeHardware(
			@ModelAttribute("pageModel") FaxSystemModel pageModel,
			HttpServletRequest request, Model model) throws IOException {
		// 根据主键ID查找实体
		FaxHardwareDay faxHardwareDay = new FaxHardwareDay();
		System.err.println("---------" + pageModel.getHardwareId());
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			faxHardwareDay = ifaxHardwareDayService.judge(pageModel, user);
			model.addAttribute("returnStr", new ResultModel(true, "审核成功",
					faxHardwareDay).toJson());
		} catch (Exception e) {
			logger.error("更新记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(true, "审核失败",
					faxHardwareDay).toJson());
			return "returnnote";
		}
		return "returnnote";
	}

	/**
	 * 系统进程 删除
	 * 
	 * @author 韩天驭
	 * @2017年2月17日 上午11:42:08
	 * @param id
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "process/delete.do", method = RequestMethod.POST)
	public String deleteProcess(
			@RequestParam(value = "id", required = true) String id,
			HttpServletRequest request, Model model) {
		// 调用删除操作

		ifaxProcessDayService.delete(id);
		addSuccess(model, "删除记录成功");
		// 记录日志
		super.addLog(request, "删除记录成功");

		return "/duty/fax/day/faxsystem/process/result";
	}
    /**
     * 系统进程修改
     * @author 韩天驭
     * @2017年2月17日 下午12:58:14
     * @param pageModel
     * @param id
     * @param model
     * @return
     * String
     */
	@RequestMapping(value = "process/mod.do", method = RequestMethod.GET)
	public String modProcess(
			@ModelAttribute("pageModel") FaxSystemModel pageModel,
			@RequestParam(value = "id") String id, Model model) {

		// 根据主键ID查找实体
		FaxProcessDay faxProcessDay = ifaxProcessDayService.findById(id);
		model.addAttribute("faxdata", faxProcessDay);

		return "/duty/fax/day/faxsystem/process/mod";
	}

	/**
	 * 系统进程修改
	 * 
	 * @author 韩天驭
	 * @2017年2月17日 下午12:57:59
	 * @param pageModel
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 */
	@RequestMapping(value = "process/mod.do", method = RequestMethod.POST)
	public String doModProcess(
			@ModelAttribute("pageModel") FaxSystemModel pageModel,
			HttpServletRequest request, Model model) throws IOException {
		// 根据主键ID查找实体
		FaxProcessDay faxProcessDay = new FaxProcessDay();
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);

			faxProcessDay = ifaxProcessDayService.mod(pageModel, user);
			model.addAttribute("returnStr", new ResultModel(true, "更新记录成功",
					faxProcessDay).toJson());
		} catch (Exception e) {
			logger.error("更新记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(true, "更新记录失败",
					faxProcessDay).toJson());
			return "returnnote";
		}
		return "returnnote";
	}
	
	@RequestMapping(value = "process/judge.do", method = RequestMethod.GET)
	public String judgeProcess(
			@ModelAttribute("pageModel") FaxSystemModel pageModel,
			@RequestParam(value = "id") String id, Model model) {

		// 根据主键ID查找实体
		FaxProcessDay faxProcessDay = ifaxProcessDayService.findById(id);
		model.addAttribute("faxdata", faxProcessDay);

		return "/duty/fax/day/faxsystem/process/judge";
	}
	
	@RequestMapping(value = "process/judge.do", method = RequestMethod.POST)
	public String doJudgeProcess(
			@ModelAttribute("pageModel") FaxSystemModel pageModel,
			HttpServletRequest request, Model model) throws IOException {
		// 根据主键ID查找实体
		FaxProcessDay faxProcessDay = new FaxProcessDay();
		System.err.println("---------" + pageModel.getHardwareId());
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			faxProcessDay = ifaxProcessDayService.judge(pageModel, user);
			model.addAttribute("returnStr", new ResultModel(true, "审核成功",
					faxProcessDay).toJson());
		} catch (Exception e) {
			logger.error("更新记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(true, "审核失败",
					faxProcessDay).toJson());
			return "returnnote";
		}
		return "returnnote";
	}
	
	@RequestMapping(value = "process/view.do", method = RequestMethod.GET)
	public String viewProcess(
			@ModelAttribute("pageModel") FaxSystemModel pageModel,
			@RequestParam(value = "id") String id, Model model) {

		// 根据主键ID查找实体
		FaxProcessDay faxProcessDay = ifaxProcessDayService.findById(id);
		model.addAttribute("faxdata", faxProcessDay);

		return "/duty/fax/day/faxsystem/process/view";
	}
}
