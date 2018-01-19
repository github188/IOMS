package cn.com.atnc.ioms.web.duty.statellite.lib;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.ToolLib;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.enums.duty.satellite.ToolStatus;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.duty.statellitemqy.ToolLibService;
import cn.com.atnc.ioms.mng.turndutymng.ISignLeaveService;
import cn.com.atnc.ioms.model.SysFinals;
import cn.com.atnc.ioms.model.duty.satellitetool.SatelliteToolModel;
import cn.com.atnc.ioms.model.duty.satellitetool.SatelliteToolQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 卫星工具库控制类
 *
 * @author 段衍林
 * @2016年11月29日 下午12:15:33
 */
@Controller
@RequestMapping("/duty/satellitetool/")
public class ToolLibController extends MyBaseController {
	@Autowired
	private ToolLibService toolLibService;
	@Autowired
	private IUserManager userManager;
	@Autowired
	private ISignLeaveService signLeaveService;

	/**
	 * 页面初始化
	 * 
	 * @author 段衍林
	 * @2016年11月29日 上午11:11:04
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") SatelliteToolQueryModel queryModel,
			HttpServletRequest request, Model model) {
		super.pageInfo(model, request);
		// 设置当前用户为操作人
		User user = (User) request.getSession().getAttribute(
				SessionNames.LOGIN_USER);
		model.addAttribute("currentUser", user);
		// 是否签到
		if (signLeaveService.isOndutyByUser(user)) {
			// 签到
			model.addAttribute("isflag", SysFinals.YES);
		} else {
			// 未签到
			model.addAttribute("isflag", SysFinals.NO);
		}
		return "duty/satellitetool/manage";
	}

	/**
	 * 加载数据
	 * 
	 * @author 段衍林
	 * @2016年11月29日 上午11:11:10
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") SatelliteToolQueryModel queryModel,
			HttpServletRequest request, Model model) {
		// 设置当前用户为操作人
		User user = (User) request.getSession().getAttribute(
				SessionNames.LOGIN_USER);
		model.addAttribute("currentUser", user);
		// 是否签到
		if (signLeaveService.isOndutyByUser(user)) {
			// 签到
			model.addAttribute("isflag", SysFinals.YES);
		} else {
			// 未签到
			model.addAttribute("isflag", SysFinals.NO);
		}
		// tab页
		model.addAttribute("optType", queryModel.getOptType());
		// 分页
		model.addAttribute("pagn", toolLibService.queryPageByModel(queryModel));
		return "duty/satellitetool/queryResult";
	}

	/**
	 * 添加记录跳转
	 * 
	 * @author 段衍林
	 * @2016年11月29日 上午11:11:17
	 * @param pageModel
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String addJump(
			@ModelAttribute("pageModel") SatelliteToolModel pageModel,
			Model model) {
		// 查询网控值班员
		List<User> users = userManager.getUserByRole(RoleEnum.engineer.name());
		System.err.println(users.size());
		// 前台控制
		model.addAttribute("engineers", users);
		// 工具状态
		model.addAttribute("lendStatuss", ToolStatus.values());
		// 检查结果枚举类
		return "duty/satellitetool/add";
	}

	/**
	 * 添加巡检记录
	 * 
	 * @author 段衍林
	 * @2016年11月29日 上午11:11:23
	 * @param pageModel
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String add(
			@ModelAttribute("pageModel") SatelliteToolModel pageModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			pageModel.setOperator(user);
			// 将记录保存至数据库
			toolLibService.saveOrUpdate(pageModel);
			model.addAttribute("returnStr",
					new ResultModel(true, "操作成功", null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "操作失败", null).toJson());
		}
		return "returnnote";
	}

	/**
	 * 显示
	 * 
	 * @author 段衍林
	 * @2016年11月29日 上午11:11:29
	 * @param pageModel
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public String view(
			@ModelAttribute("pageModel") SatelliteToolModel pageModel,
			HttpServletRequest request, Model model) {
		// 根据id查询
		ToolLib toolLib = toolLibService.findById(pageModel.getId());
		// 页面展示
		model.addAttribute("vo", toolLib);
		return "/duty/satellitetool/view";
	}

	/**
	 * 更新跳转
	 * 
	 * @author 段衍林
	 * @2016年11月29日 上午11:11:34
	 * @param pageModel
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	public String updateJump(
			@ModelAttribute("pageModel") SatelliteToolModel pageModel,
			HttpServletRequest request, Model model) {
		// 查询网控值班员
		List<User> users = userManager.getUserByRole(RoleEnum.engineer.name());
		// 前台控制
		model.addAttribute("engineers", users);
		// 工具状态
		model.addAttribute("lendStatuss", ToolStatus.values());
		// 原数据展示
		ToolLib toolLib = toolLibService.findById(pageModel.getId());
		model.addAttribute("vo", toolLib);
		return "/duty/satellitetool/update";
	}

	/**
	 * 更新
	 * 
	 * @author 段衍林
	 * @2016年11月29日 上午11:11:40
	 * @param pageModel
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(
			@ModelAttribute("pageModel") SatelliteToolModel pageModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			pageModel.setOperator(user);
			// 将记录保存至数据库
			toolLibService.saveOrUpdate(pageModel);
			model.addAttribute("returnStr",
					new ResultModel(true, "操作成功", null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "操作失败", null).toJson());
		}
		return "returnnote";
	}

	/**
	 * 删除
	 * 
	 * @author 段衍林
	 * @2016年11月29日 上午11:11:47
	 * @param pageModel
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 */
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String delete(
			@ModelAttribute("pageModel") SatelliteToolModel pageModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 删除
			toolLibService.delete(pageModel);
			// 返回
			addSuccess(model, "删除记录成功");
			// 记录操作日志
			super.addLog(request, "删除记录成功");
		} catch (RuntimeException e) {
			addError(model, "删除记录失败");
			super.addLog(request, "删除记录失败");
		}
		return "duty/satellitetool/result";
	}

	/**
	 * 冒泡显示
	 * 
	 * @author 段衍林
	 * @2016年11月29日 下午12:10:02
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 */
	@RequestMapping(value = "ajaxLoad.dox", method = RequestMethod.GET)
	public String ajaxLodad(
			@ModelAttribute("queryModel") SatelliteToolQueryModel queryModel,
			HttpServletRequest request, Model model) throws IOException {
		// 结果查询
		Pagination pagn = toolLibService
				.queryPageByModel(new SatelliteToolQueryModel());
		// 取值
		model.addAttribute("returnStr", pagn.getTotalCount());
		return "returnnote";
	}
}
