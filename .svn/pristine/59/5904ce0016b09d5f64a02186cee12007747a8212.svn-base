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
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.SlhEquState;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.enums.duty.satellite.LR;
import cn.com.atnc.ioms.enums.duty.satellite.OnOff;
import cn.com.atnc.ioms.mng.duty.environment.EnvironmentEquipCheckService;
import cn.com.atnc.ioms.mng.duty.statellite.SlhEquStateService;
import cn.com.atnc.ioms.model.duty.statellite.day.SlhEquStateModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 十里河-PES-PES网管设备状态
 * 
 * @author shijiyong
 * @date 2016年10月31日 上午9:13:02
 * @version 1.0, 2016年10月14日 上午9:13:02
 */
@Controller
@RequestMapping("/duty/statelliteday/slhequstate/")
public class SlhEquStateCheckController extends MyBaseController {

	@Autowired
	private SlhEquStateService equstateservice;
	@Autowired
	private EnvironmentEquipCheckService envirEquipCheckService;

	/**
	 * 网控中心添加记录跳转
	 * 
	 * @author shijiyong
	 * @time:2016年9月28日
	 * @param queryModel
	 *            查询条件
	 * @param optType
	 *            tab窗口名称
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String addJump(@ModelAttribute("pageModel") SlhEquState queryModel,
			@RequestParam("optType") String optType, Model model) {
		// 检查结果枚举类
		List<LR> lr = Arrays.asList(LR.values());
		List<OnOff> onoff = Arrays.asList(OnOff.values());
		List<CheckResult> checkResult = Arrays.asList(CheckResult.values());
		model.addAttribute("lr", lr);
		model.addAttribute("onoff", onoff);
		model.addAttribute("checkresult", checkResult);
		model.addAttribute("optType", optType);
		return "duty/statelliteday/slhequstate/add";
	}

	/**
	 * 添加巡检记录
	 * 
	 * @author shijiyong
	 * @time:2016年9月28日
	 * @param atmday
	 *            pageModel
	 * @param request
	 *            HttpServletRequest
	 * @param model
	 *            查询条件
	 * @param optType
	 *            tab窗口名称
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String add(
			@ModelAttribute("pageModel") SlhEquStateModel slhequstate,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			slhequstate.setOperator(user);
			model.addAttribute("currentUser", user);
			// 将记录保存至数据库
			equstateservice.save(slhequstate);
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
	 * @author shijiyong
	 * @time:2016年10月24日
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
	public String delete(
			@ModelAttribute("pageModel") SlhEquStateModel querymodel,
			@RequestParam("id") String id, HttpServletRequest request,
			Model model) {
		try {
			SlhEquState equstate = equstateservice.findById(id);
			String checkid = equstate.getId();
			EnvironmentEquipCheck equipcheck = envirEquipCheckService
					.findById(checkid);
			// 删除
			equstateservice.delete(equstate, equipcheck);
			// 返回
			addSuccess(model, "删除记录成功");
			// 记录操作日志
			super.addLog(request, "删除记录成功");
		} catch (RuntimeException e) {
			addError(model, "删除记录失败");
			super.addLog(request, "删除记录失败");
		}
		return "/duty/statelliteday/slhequstate/result";
	}

	/**
	 * 查看
	 * 
	 * @author shijiyong
	 * @time:2016年10月24日
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
	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public String view(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		SlhEquState mainstate = equstateservice.findById(id);
		model.addAttribute("vo", mainstate);
		return "/duty/statelliteday/slhequstate/view";
	}

	/**
	 * 更新跳转
	 * 
	 * @author shijiyong
	 * @time:2016年9月28日
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
			@RequestParam(value = "id", required = true) String id,
			@ModelAttribute("pageModel") SlhEquState slhdatestate,
			HttpServletRequest request, Model model) {
		SlhEquState slhequstate = equstateservice.findById(id);
		model.addAttribute("slhequstate", slhequstate);
		return "/duty/statelliteday/slhequstate/update";
	}

	/**
	 * 更新
	 * 
	 * @author shijiyong
	 * @time:2016年10月20日
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
	public String update(
			@ModelAttribute("pageModel") SlhEquStateModel slhdatastatemodel,
			HttpServletRequest request, Model model,
			@RequestParam("id") String id) throws IOException {
		try {
			SlhEquState slhdatastate = equstateservice.findById(id);
			String checkid = slhdatastate.getCheckid().getId();
			EnvironmentEquipCheck enviroment = equstateservice
					.findByIden(checkid);
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			slhdatastatemodel.setOperator(user);
			equstateservice.update(slhdatastate, enviroment, slhdatastatemodel);
			model.addAttribute("returnStr", new ResultModel(true, "修改记录成功",
					null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr", new ResultModel(false, "修改记录失败",
					null).toJson());
		}
		return "returnnote";
	}

}
