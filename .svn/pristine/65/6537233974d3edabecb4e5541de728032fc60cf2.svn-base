package cn.com.atnc.ioms.web.duty.statellite.mqy;

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
import cn.com.atnc.ioms.entity.duty.satellite.TesEqu;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.mng.duty.statellitemqy.TesEquService;
import cn.com.atnc.ioms.model.duty.statellite.mqy.TesEquModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 室内设备
 * 
 * @author shijiyong
 * @date 2016年11月3日 上午9:11:02
 * @version 1.0, 2016年11月3日 上午9:11:02
 */
@Controller
@RequestMapping("/duty/statellite/tesequ/")
public class TesEquController extends MyBaseController {
	@Autowired
	private TesEquService tesequservice;

	/**
	 * 添加记录跳转
	 * 
	 * @author shijiyong
	 * @time:2016年11月3日
	 * @param queryModel
	 *            查询条件
	 * @param optType
	 *            tab窗口名称
	 * @param checkType
	 *            巡检类型
	 * @param model
	 *            Model
	 * @return
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String addJump(@ModelAttribute("pageModel") TesEqu queryModel,
			@RequestParam("checkType") CheckCatagory checkType,
			@RequestParam("optType") String optType, Model model) {
		// 检查结果枚举类
		List<CheckResult> checkResult = Arrays.asList(CheckResult.values());
		model.addAttribute("checkresult", checkResult);
		model.addAttribute("optType", optType);
		model.addAttribute("checkType", checkType);
		return "duty/statellite/tesequ/add";
	}

	/**
	 * 添加巡检记录
	 * 
	 * @author shijiyong
	 * @time:2016年11月3日
	 * @param toolmodel
	 *            pageModel
	 * @param request
	 *            HttpServletRequest
	 * @param model
	 *            查询条件
	 * @param optType
	 *            tab窗口名称
	 * @param checkType
	 *            巡检类型
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String add(@ModelAttribute("pageModel") TesEquModel tesEquModel,
			HttpServletRequest request,
			@RequestParam("checkType") CheckCatagory checkType,
			@RequestParam("optType") String optType, Model model)
			throws IOException {
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			tesEquModel.setOperator(user);
			model.addAttribute("currentUser", user);
			// tab页控制
			model.addAttribute("optType", optType);
			// 巡检类型控制
			model.addAttribute("checkType", checkType);
			// 设置当前卫星【月检】【季检】【年检】类型
			tesEquModel.setCheckType(checkType);
			tesEquModel.setOptType(optType);
			// 将记录保存至数据库
			tesequservice.save(tesEquModel);
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
	 * @author shijiyong
	 * @time:2016年11月3日
	 * @param id
	 *            ID
	 * @param request
	 *            HttpServletRequest
	 * @param model
	 *            Model
	 * @return String
	 */
	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public String view(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		TesEqu tool = tesequservice.findById(id);
		model.addAttribute("vo", tool);
		return "/duty/statellite/tesequ/view";
	}

	/**
	 * 更新跳转
	 * 
	 * @author shijiyong
	 * @time:2016年11月3日
	 * @param id
	 *            ID
	 * @param request
	 *            HttpServletRequest
	 * @param model
	 *            查询条件
	 * @param txjddatestate
	 *            pageModel
	 * @return String
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	public String updateJump(
			@ModelAttribute("pageModel") TesEquModel tesEquModel,
			@RequestParam(value = "id", required = true) String id,
			@RequestParam("optType") String optType,
			HttpServletRequest request, Model model) {
		// tab页
		model.addAttribute("optType", optType);
		// 实体查询
		TesEqu tesEqu = tesequservice.findById(id);
		model.addAttribute("vo", tesEqu);
		return "/duty/statellite/tesequ/update";
	}

	/**
	 * 更新
	 * 
	 * @author shijiyong
	 * @time:2016年11月3日
	 * @param id
	 *            ID
	 * @param request
	 *            HttpServletRequest
	 * @param model
	 *            查询条件
	 * @param txjddatestate
	 *            pageModel
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(@ModelAttribute("pageModel") TesEquModel tesEquModel,
			HttpServletRequest request, Model model,
			@RequestParam("optType") String optType,
			@RequestParam("id") String id) throws IOException {
		try {
			TesEqu tool = tesequservice.findById(id);
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			tesEquModel.setOperator(user);
			tesequservice.update(tool, tesEquModel);
			// tab页
			model.addAttribute("optType", optType);
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
	 * @author shijiyong
	 * @time:2016年10月21日
	 * @param id
	 *            ID
	 * @param request
	 *            HttpServletRequest
	 * @param model
	 *            查询条件
	 * @param txjddatestate
	 *            pageModel
	 * @return String
	 */

	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String delete(@ModelAttribute("pageModel") TesEquModel toolmodel,
			HttpServletRequest request, Model model,
			@RequestParam("id") String id) {
		try {
			// 删除
			TesEqu tesequ = tesequservice.findById(id);
			tesequservice.delete(tesequ);
			// 返回
			addSuccess(model, "删除记录成功");
			// 记录操作日志
			super.addLog(request, "删除记录成功");
		} catch (RuntimeException e) {
			addError(model, "删除记录失败");
			super.addLog(request, "删除记录失败");
		}
		return "duty/statellite/tesequ/result";
	}

}
