package cn.com.atnc.ioms.web.duty.statellite.day;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.DsPesTesLink;
import cn.com.atnc.ioms.mng.duty.statellite.DsPesTesLinkService;
import cn.com.atnc.ioms.model.duty.statellite.day.DsPesTesLinkModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 东四-PES-TES链路工作状态
 *
 * @author 段衍林
 * @2016年11月16日 下午3:07:21
 */
@Controller
@RequestMapping("/duty/statelliteday/dsPesTesLink/")
public class DsPesTesLinkController extends MyBaseController {

	@Autowired
	private DsPesTesLinkService dsPesTesLinkService;

	/**
	 * 添加新数据
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:33:12
	 * @param txjdRadarLink
	 *            实体
	 * @param optType
	 *            tab页
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String addJump(
			@ModelAttribute("pageModel") DsPesTesLinkModel dsPesTesLinkModel,
			@RequestParam("optType") String optType, Model model) {
		// 检查结果枚举类
		model.addAttribute("optType", optType);
		// 跳转添加页面
		return "duty/statelliteday/dspesteslink/add";
	}

	/**
	 * 添加记录
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:55:09
	 * @param txjdRadarLink
	 *            实体
	 * @param request
	 *            请求
	 * @param model
	 *            model
	 * @return
	 * @throws IOException
	 *             String
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String add(
			@ModelAttribute("pageModel") DsPesTesLinkModel dsPesTesLinkModel,
			HttpServletRequest request, Model model) throws IOException {
		// 设置当前用户为操作人
		User user = (User) request.getSession().getAttribute(
				SessionNames.LOGIN_USER);
		// 前端展示
		model.addAttribute("currentUser", user);
		try {
			// 存储创建人
			dsPesTesLinkModel.setOperator(user);
			// 保存新数据
			dsPesTesLinkService.saveOrUpdate(dsPesTesLinkModel);
			model.addAttribute("returnStr", new ResultModel(true, "添加记录成功",
					null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr", new ResultModel(false, "添加记录失败",
					null).toJson());
		}
		return "returnnote";
	}

	/**
	 * 删除
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:59:47
	 * @param txjdRadarLink
	 * @param id
	 * @param request
	 * @param model
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String delete(
			@ModelAttribute("pageModel") DsPesTesLinkModel dsPesTesLinkModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 删除
			this.dsPesTesLinkService.delete(dsPesTesLinkModel);
			// 返回
			addSuccess(model, "删除记录成功");
			// 记录操作日志
			super.addLog(request, "删除记录成功");
		} catch (RuntimeException e) {
			addError(model, "删除记录失败");
			super.addLog(request, "删除记录失败");
		}
		return "duty/statelliteday/dspesteslink/result";
	}

	/**
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午11:07:52
	 * @param id
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public String view(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		// 实体查询
		DsPesTesLink dsPesTesLink = dsPesTesLinkService.findById(id);
		model.addAttribute("vo", dsPesTesLink);
		return "/duty/statelliteday/dspesteslink/view";
	}

	/**
	 * 更新跳转
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午11:08:58
	 * @param id
	 * @param slhequstate
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	public String updateJump(
			@ModelAttribute("pageModel") DsPesTesLinkModel dsPesTesLinkModel,
			HttpServletRequest request, Model model) {
		// 检查结果枚举类
		DsPesTesLink dsPesTesLink = dsPesTesLinkService
				.findById(dsPesTesLinkModel.getId());
		model.addAttribute("vo", dsPesTesLink);
		return "/duty/statelliteday/dspesteslink/update";
	}

	/**
	 * 更新
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午11:19:56
	 * @param txjdRadarLinkModel
	 * @param request
	 * @param model
	 * @param id
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(
			@ModelAttribute("pageModel") DsPesTesLinkModel dsPesTesLinkModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			dsPesTesLinkModel.setOperator(user);
			// 更新新数据
			dsPesTesLinkService.saveOrUpdate(dsPesTesLinkModel);
			model.addAttribute("returnStr", new ResultModel(true, "修改记录成功",
					null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr", new ResultModel(false, "修改记录失败",
					null).toJson());
		}
		return "returnnote";
	}

}
