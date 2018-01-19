package cn.com.atnc.ioms.web.duty.atm;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.atm.ATMDayRoute;
import cn.com.atnc.ioms.entity.duty.atm.ATMDaySon;
import cn.com.atnc.ioms.enums.duty.atm.AtmDayTabEnum;
import cn.com.atnc.ioms.enums.duty.atm.AtmDayTypeEnum;
import cn.com.atnc.ioms.enums.duty.atm.HaveNoEnum;
import cn.com.atnc.ioms.enums.duty.atm.StatusResultEnum;
import cn.com.atnc.ioms.mng.duty.atm.day.AtmDayRouteService;
import cn.com.atnc.ioms.mng.duty.atm.day.AtmDaySonService;
import cn.com.atnc.ioms.model.duty.atm.AtmDayQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 业务路由器控制层
 * 
 * @author 王凌斌
 * @2017年2月9日 下午1:42:37
 */
@Controller
@RequestMapping("/duty/atmday/router/")
public class RouterController extends MyBaseController {

	@Autowired
	private AtmDayRouteService atmDayRouteService;
	@Autowired
	private AtmDaySonService atmDaySonService;

	/**
	 * 页面初始化
	 * 
	 * @author 王凌斌
	 * @2017年2月9日 下午1:42:50
	 * @param queryModel
	 * @param atmType
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") AtmDayQueryModel queryModel,
			@RequestParam("atmType") AtmDayTypeEnum atmType,
			HttpServletRequest request, Model model) {
		model.addAttribute("atmType", atmType);
		super.pageInfo(model, request);
		return "duty/atmday/router/manage";
	}

	/**
	 * 加载数据
	 * 
	 * @author 王凌斌
	 * @2017年2月9日 下午1:46:47
	 * @param queryModel
	 * @param tabType
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") AtmDayQueryModel queryModel,
			@RequestParam("tabType") AtmDayTabEnum tabType,
			HttpServletRequest request, Model model) {
		// 获取当前登陆用户
		User currentUser = (User) request.getSession().getAttribute(
				SessionNames.LOGIN_USER);
		model.addAttribute("currentUser", currentUser);
		// 默认访问网控中心
		if (ObjectUtils.equals(tabType, null)) {
			tabType = AtmDayTabEnum.WKZX;
		}
		// 得到TAB页类型
		model.addAttribute("tabType", tabType);
		queryModel.setTabType(tabType);
		switch (tabType) {
		case WKZX:
		case KGJ:
			model.addAttribute("pagn",
					atmDayRouteService.queryPageByModel(queryModel));
			break;
		default:
			break;
		}
		return "duty/atmday/router/queryResult";

	}

	/**
	 * 冒泡显示记录
	 * 
	 * @author 王凌斌
	 * @2017年2月10日 上午9:20:50
	 * @param queryModel
	 * @param tabType
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 */
	@RequestMapping(value = "ajaxLoad.dox", method = RequestMethod.GET)
	public String ajaxLoad(
			@ModelAttribute("queryModel") AtmDayQueryModel queryModel,
			@RequestParam("tabType") AtmDayTabEnum tabType,
			HttpServletRequest request, Model model) throws IOException {
		System.err.println(tabType);
		// 默认访问网控中心
		if (ObjectUtils.equals(tabType, null)) {
			tabType = AtmDayTabEnum.WKZX;
		}
		// 设置设备类别和巡检类型
		queryModel.setTabType(tabType);
		switch (tabType) {
		case WKZX:
		case KGJ:
			model.addAttribute("returnStr", JacksonTools
					.toJsonStr(atmDayRouteService.queryPageByModel(queryModel)));
			break;
		default:
			break;
		}
		return "returnnote";
	}

	/**
	 * 添加页面跳转
	 * 
	 * @author 王凌斌
	 * @2017年2月9日 下午2:37:18
	 * @param pageModel
	 * @param tabType
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String addJump(
			@ModelAttribute("pageModel") AtmDayQueryModel pageModel, Model model) {
		// 状态结果枚举类
		List<StatusResultEnum> statusResults = Arrays.asList(StatusResultEnum
				.values());
		model.addAttribute("statusResults", statusResults);
		// 有无枚举类
		List<HaveNoEnum> haveNoStatus = Arrays.asList(HaveNoEnum.values());
		model.addAttribute("haveNoStatus", haveNoStatus);
		return "duty/atmday/router/add";
	}

	/**
	 * 添加保存页面
	 * 
	 * @author 王凌斌
	 * @2017年2月9日 下午2:40:22
	 * @param pageModel
	 * @param tabType
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String add(@ModelAttribute("pageModel") AtmDayQueryModel pageModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			model.addAttribute("currentUser", user);
			atmDayRouteService.save(user, pageModel);
			model.addAttribute("returnStr", new ResultModel(true,
					"添加ATM设备巡检记录成功", null).toJson());
		} catch (Exception e) {
			logger.error("添加记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(false,
					"添加ATM设备巡检记录成功", null).toJson());
			return "returnnote";
		}
		return "returnnote";
	}

	/**
	 * 更新跳转
	 * 
	 * @author 王凌斌
	 * @2017年2月13日 上午10:53:27
	 * @param querymodel
	 * @param id
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	public String updateJump(
			@ModelAttribute("pageModel") AtmDayQueryModel pageModel,
			@RequestParam(value = "id") String id, Model model) {
		// 状态结果枚举类
		List<StatusResultEnum> statusResults = Arrays.asList(StatusResultEnum
				.values());
		model.addAttribute("statusResults", statusResults);
		// 有无枚举类
		List<HaveNoEnum> haveNoStatus = Arrays.asList(HaveNoEnum.values());
		model.addAttribute("haveNoStatus", haveNoStatus);
		// 根据主键ID查找实体
		ATMDayRoute atmDayRoute = atmDayRouteService.findById(id);
		// 根据父类查找子类集合
		List<ATMDaySon> atmDaySons = atmDaySonService
				.findByRouteOrderBySerial(atmDayRoute);
		atmDayRoute.setAtmDaySons(atmDaySons);
		model.addAttribute("atmDayRoute", atmDayRoute);
		// 修改操作
		model.addAttribute("view", "0");
		return "/duty/atmday/router/update";
	}

	/**
	 * 更新
	 * 
	 * @author 王凌斌
	 * @2017年2月13日 上午11:34:46
	 * @param pageModel
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(
			@ModelAttribute("pageModel") AtmDayQueryModel pageModel,
			@RequestParam("id") String id, HttpServletRequest request,
			Model model) throws IOException {
		// 根据主键ID查找实体
		ATMDayRoute atmDayRoute = atmDayRouteService.findById(id);
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			atmDayRoute = atmDayRouteService.update(user, atmDayRoute,
					pageModel);
			model.addAttribute("returnStr", new ResultModel(true, "更新记录成功",
					atmDayRoute).toJson());
		} catch (Exception e) {
			logger.error("更新记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(true, "更新记录失败",
					atmDayRoute).toJson());
			return "returnnote";
		}
		return "returnnote";
	}

	/**
	 * 审核页面跳转
	 * @author 王凌斌 
	 * @2017年2月15日 上午10:41:44
	 * @param pageModel
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 * String
	 */
	@RequestMapping(value = "audit.do", method = RequestMethod.GET)
	public String auditJump(
			@ModelAttribute("pageModel") AtmDayQueryModel pageModel,
			@RequestParam(value = "id") String id, Model model,
			HttpServletRequest request) {
		// 设置当前用户为操作人
		User user = (User) request.getSession().getAttribute(
				SessionNames.LOGIN_USER);
		model.addAttribute("currentUser", user);
		// 根据主键ID查找实体
		ATMDayRoute atmDayRoute = atmDayRouteService.findById(id);
		// 根据父类查找子类集合
		List<ATMDaySon> atmDaySons = atmDaySonService
				.findByRouteOrderBySerial(atmDayRoute);
		atmDayRoute.setAtmDaySons(atmDaySons);
		model.addAttribute("atmDayRoute", atmDayRoute);
		// 审核操作
		model.addAttribute("audit", "1");
		return "/duty/atmday/router/audit";
	}

	/**
	 * 审核
	 * @author 王凌斌 
	 * @2017年2月15日 上午10:54:16
	 * @param pageModel
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 * String
	 */
	@RequestMapping(value = "audit.do", method = RequestMethod.POST)
	public String audit(
			@ModelAttribute("pageModel") AtmDayQueryModel pageModel,
			@RequestParam("id") String id, HttpServletRequest request,
			Model model) throws IOException {
		// 根据主键ID查找实体
		ATMDayRoute atmDayRoute = atmDayRouteService.findById(id);
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			atmDayRoute = atmDayRouteService.audit(user, atmDayRoute,
					pageModel);
			model.addAttribute("returnStr", new ResultModel(true, "审核记录成功",
					atmDayRoute).toJson());
		} catch (Exception e) {
			logger.error("审核记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(true, "审核记录失败",
					atmDayRoute).toJson());
			return "returnnote";
		}
		return "returnnote";
	}
	
	
	/**
	 * 查看信息
	 * 
	 * @author 王凌斌
	 * @2017年2月10日 下午4:00:48
	 * @param atmDayRoute
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public String view(@RequestParam("id") String id, Model model) {
		// 根据主键ID查找实体
		ATMDayRoute atmDayRoute = atmDayRouteService.findById(id);
		model.addAttribute("atmDayRoute", atmDayRoute);
		// 根据父类查找子类集合
		List<ATMDaySon> atmDaySons = atmDaySonService
				.findByRouteOrderBySerial(atmDayRoute);
		atmDayRoute.setAtmDaySons(atmDaySons);
		model.addAttribute("atmDayRoute", atmDayRoute);
		// 查看操作
		model.addAttribute("view", "1");
		return "/duty/atmday/router/view";
	}

	/**
	 * 删除记录
	 * 
	 * @author 王凌斌
	 * @2017年2月13日 上午9:49:19
	 * @param id
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String delete(
			@RequestParam(value = "id", required = true) String id,
			HttpServletRequest request, Model model) {
		// 根据主键ID查找实体
		ATMDayRoute atmDayRoute = atmDayRouteService.findById(id);
		// 级联删除
		atmDayRouteService.delete(atmDayRoute);
		addSuccess(model, "删除记录成功");
		// 记录日志
		super.addLog(request, "删除记录成功");
		return "/duty/atmday/router/result";
	}

}
