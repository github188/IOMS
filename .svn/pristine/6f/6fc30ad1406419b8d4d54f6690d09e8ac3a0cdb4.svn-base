package cn.com.atnc.ioms.web.duty.statellite.info;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.Info;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.duty.statellitemqy.InfoService;
import cn.com.atnc.ioms.mng.turndutymng.ISignLeaveService;
import cn.com.atnc.ioms.model.SysFinals;
import cn.com.atnc.ioms.model.duty.satelliteinfo.SatelliteInfoModel;
import cn.com.atnc.ioms.model.duty.satelliteinfo.SatelliteInfoQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 卫星备件信息库控制类
 *
 * @author 段衍林
 * @2016年11月28日 下午3:42:10
 */
@Controller
@RequestMapping("/duty/satelliteinfo/")
public class InfoController extends MyBaseController {
	@Autowired
	private InfoService infoService;
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
			@ModelAttribute("queryModel") SatelliteInfoQueryModel queryModel,
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
		return "duty/satelliteinfo/manage";
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
			@ModelAttribute("queryModel") SatelliteInfoQueryModel queryModel,
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
		model.addAttribute("pagn", infoService.queryPageByModel(queryModel));
		return "duty/satelliteinfo/queryResult";
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
			@ModelAttribute("pageModel") SatelliteInfoModel pageModel,
			Model model) {
		// 查询网控城市列表
		List<User> users = userManager.getUserByRole(RoleEnum.engineer.name());
		model.addAttribute("users", users);
		// 检查结果枚举类
		return "duty/satelliteinfo/add";
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
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String add(
			@ModelAttribute("pageModel") SatelliteInfoModel pageModel,
			HttpServletRequest request, Model model) throws IOException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		try {
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
			// 设置当前用户为操作人
			pageModel.setOperator(user);
			// 将记录保存至数据库
			Info info = infoService.saveOrUpdate(pageModel);
			model.addAttribute("vo", info);
			addSuccess(model, "添加成功");
			super.addLog(request, "添加成功");
		} catch (Exception e) {
			addError(model, "添加失败");
		}
		return "duty/satelliteinfo/result";
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
			@ModelAttribute("pageModel") SatelliteInfoModel pageModel,
			HttpServletRequest request, Model model) {
		// 根据id查询
		Info info = infoService.findById(pageModel.getId());
		// 页面展示
		model.addAttribute("vo", info);
		return "/duty/satelliteinfo/view";
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
			@ModelAttribute("pageModel") SatelliteInfoModel pageModel,
			HttpServletRequest request, Model model) {
		// 查询网控城市列表
		List<User> users = userManager.getUserByRole(RoleEnum.engineer.name());
		model.addAttribute("users", users);
		// 原数据展示
		Info info = infoService.findById(pageModel.getId());
		model.addAttribute("vo", info);
		return "/duty/satelliteinfo/update";
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
			@ModelAttribute("pageModel") SatelliteInfoModel pageModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
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
			// 设置当前用户为操作人
			pageModel.setOperator(user);
			// 将记录保存至数据库
			Info info = infoService.saveOrUpdate(pageModel);
			model.addAttribute("vo", info);
			addSuccess(model, "修改成功");
			super.addLog(request, "修改成功");
		} catch (Exception e) {
			addError(model, "修改失败");
		}
		return "duty/satelliteinfo/result";
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
			@ModelAttribute("pageModel") SatelliteInfoModel pageModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 删除
			infoService.delete(pageModel);
			// 返回
			addSuccess(model, "删除记录成功");
			// 记录操作日志
			super.addLog(request, "删除记录成功");
		} catch (RuntimeException e) {
			addError(model, "删除记录失败");
			super.addLog(request, "删除记录失败");
		}
		return "duty/satelliteinfo/result";
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
			@ModelAttribute("queryModel") SatelliteInfoQueryModel queryModel,
			HttpServletRequest request, Model model) throws IOException {
		// 结果查询
		Pagination pagn = infoService
				.queryPageByModel(new SatelliteInfoQueryModel());
		// 取值
		model.addAttribute("returnStr", pagn.getTotalCount());
		model.addAttribute("returnStr", pagn.getTotalCount());
		return "returnnote";
	}

	/**
	 * sn检测
	 * 
	 * @author 段衍林
	 * @2016年12月7日 下午7:10:34
	 * @param model
	 * @param queryModel
	 * @return String
	 */
	@RequestMapping("/checkSn.dox")
	public String checkSn(Model model, SatelliteInfoQueryModel queryModel) {
		model.addAttribute("returnStr", infoService.checkSn(queryModel));
		return "returnnote";
	}
}
