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
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.SlhNetCon;
import cn.com.atnc.ioms.mng.duty.environment.EnvironmentEquipCheckService;
import cn.com.atnc.ioms.mng.duty.statellite.SlhNetConService;
import cn.com.atnc.ioms.model.duty.statellite.day.SlhNetConModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 十里河-PES-PES网管连通性
 * 
 * @author shijiyong
 * @date 2016年10月31日 上午9:13:02
 * @version 1.0, 2016年10月14日 上午9:13:02
 */
@Controller
@RequestMapping("/duty/statelliteday/slhnetconstate/")
public class SlhNetConCheckController extends MyBaseController {

	@Autowired
	private SlhNetConService slhnetconservice;
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
	public String addJump(@ModelAttribute("pageModel") SlhNetCon queryModel,
			@RequestParam("optType") String optType, Model model) {
		// 检查结果枚举类
		model.addAttribute("optType", optType);
		return "duty/statelliteday/slhnetconstate/add";
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
			@ModelAttribute("pageModel") SlhNetConModel slhnetconmodel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			slhnetconmodel.setOperator(user);
			model.addAttribute("currentUser", user);
			// 将记录保存至数据库
			slhnetconservice.save(slhnetconmodel);
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
			@ModelAttribute("pageModel") SlhNetConModel querymodel,
			@RequestParam("id") String id, HttpServletRequest request,
			Model model) {
		try {
			// 删除
			SlhNetCon netcon = slhnetconservice.findById(id);
			String checkid = netcon.getId();
			EnvironmentEquipCheck equipcheck = envirEquipCheckService
					.findById(checkid);
			slhnetconservice.delete(netcon, equipcheck);
			// 返回
			addSuccess(model, "删除记录成功");
			// 记录操作日志
			super.addLog(request, "删除记录成功");
		} catch (RuntimeException e) {
			addError(model, "删除记录失败");
			super.addLog(request, "删除记录失败");
		}
		return "/duty/statelliteday/slhnetconstate/result";
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
		SlhNetCon netcon = slhnetconservice.findById(id);
		model.addAttribute("vo", netcon);
		return "/duty/statelliteday/slhnetconstate/view";
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
			@ModelAttribute("pageModel") SlhNetCon slhequstate,
			HttpServletRequest request, Model model) {
		SlhNetCon netcon = slhnetconservice.findById(id);
		model.addAttribute("netcon", netcon);
		return "/duty/statelliteday/slhnetconstate/update";
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
			@ModelAttribute("pageModel") SlhNetConModel slhnetconmodel,
			HttpServletRequest request, Model model,
			@RequestParam("id") String id) throws IOException {
		try {
			SlhNetCon slhequstate = slhnetconservice.findById(id);
			String checkid = slhequstate.getCheckid().getId();
			EnvironmentEquipCheck enviroment = slhnetconservice
					.findByIden(checkid);
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			slhnetconmodel.setOperator(user);
			slhnetconservice.update(slhequstate, enviroment, slhnetconmodel);
			model.addAttribute("returnStr", new ResultModel(true, "修改记录成功",
					null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr", new ResultModel(false, "修改记录失败",
					null).toJson());
		}
		return "returnnote";
	}

}
