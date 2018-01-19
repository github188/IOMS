package cn.com.atnc.ioms.web.duty.statellite.day;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
import cn.com.atnc.ioms.entity.duty.satellite.TxjdRadarLink;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.mng.duty.statellite.TxjdRadarLinkService;
import cn.com.atnc.ioms.model.duty.statellite.day.TxjdRadarLinkModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 通信基地雷达广播TES-TES链路工作状态
 *
 * @author 段衍林
 * @2016年11月16日 上午10:30:03
 */
@Controller
@RequestMapping("/duty/statelliteday/txjdradarlink/")
public class TxjdRadarLinkController extends MyBaseController {

	@Autowired
	private TxjdRadarLinkService txjdRadarLinkService;

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
			@ModelAttribute("pageModel") TxjdRadarLinkModel txjdRadarLinkModel,
			@RequestParam("optType") String optType, Model model) {
		// 检查结果枚举类
		List<CheckResult> checkResult = Arrays.asList(CheckResult.values());
		model.addAttribute("checkresult", checkResult);
		model.addAttribute("optType", optType);
		return "duty/statelliteday/txjdradarlink/add";
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
			@ModelAttribute("pageModel") TxjdRadarLinkModel txjdRadarLinkModel,
			HttpServletRequest request, Model model) throws IOException {
		// 设置当前用户为操作人
		User user = (User) request.getSession().getAttribute(
				SessionNames.LOGIN_USER);
		// 前端展示
		model.addAttribute("currentUser", user);
		try {
			// 存储创建人
			txjdRadarLinkModel.setOperator(user);
			// 保存新数据
			txjdRadarLinkService.saveOrUpdate(txjdRadarLinkModel);
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
			@ModelAttribute("pageModel") TxjdRadarLinkModel txjdRadarLinkModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 逻辑删除事件单
			this.txjdRadarLinkService.delete(txjdRadarLinkModel);
			// 返回
			addSuccess(model, "删除记录成功");
			// 记录操作日志
			super.addLog(request, "删除记录成功");
		} catch (RuntimeException e) {
			addError(model, "删除记录失败");
			super.addLog(request, "删除记录失败");
		}
		return "duty/statelliteday/txjdradarlink/result";
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
		TxjdRadarLink txjdRadarLink = txjdRadarLinkService.findById(id);
		model.addAttribute("vo", txjdRadarLink);
		return "/duty/statelliteday/txjdradarlink/view";
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
			@RequestParam(value = "id", required = true) String id,
			@ModelAttribute("pageModel") TxjdRadarLinkModel txjdRadarLinkModel,
			HttpServletRequest request, Model model) {
		// 检查结果枚举类
		List<CheckResult> checkResult = Arrays.asList(CheckResult.values());
		TxjdRadarLink txjdRadarLink = txjdRadarLinkService.findById(id);
		model.addAttribute("checkResult", checkResult);
		model.addAttribute("vo", txjdRadarLink);
		return "/duty/statelliteday/txjdradarlink/update";
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
			@ModelAttribute("pageModel") TxjdRadarLinkModel txjdRadarLinkModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			txjdRadarLinkModel.setOperator(user);
			// 更新数据
			txjdRadarLinkService.saveOrUpdate(txjdRadarLinkModel);
			model.addAttribute("returnStr",
					new ResultModel(true, "操作成功", null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "操作失败", null).toJson());
		}
		return "returnnote";
	}

}
