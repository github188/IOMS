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
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.QEqu;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.mng.duty.statellitemqy.QEquService;
import cn.com.atnc.ioms.model.duty.statellite.mqy.QEquModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 运行设备检查
 * 
 * @author shijiyong
 * @date 2016年11月3日 上午9:11:02
 * @version 1.0, 2016年11月3日 上午9:11:02
 */
@Controller
@RequestMapping("/duty/statellite/qequ/")
public class QEquController extends MyBaseController {
	@Autowired
	private QEquService qequservice;

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
	public String addJump(@ModelAttribute("pageModel") QEqu queryModel,
			@RequestParam("checkType") CheckCatagory checkType, Model model) {
		// 检查结果枚举类
		List<CheckResult> checkResult = Arrays.asList(CheckResult.values());
		model.addAttribute("checkresult", checkResult);
		model.addAttribute("checkType", checkType);
		return "duty/statellite/qequ/add";
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
	public String add(@ModelAttribute("pageModel") QEquModel toolmodel,
			HttpServletRequest request,
			@RequestParam("checkType") CheckCatagory checkType, Model model)
			throws IOException {
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			toolmodel.setOperator(user);
			// 设置当前卫星【月检】【季检】【年检】类型
			toolmodel.setCheckType(checkType);
			model.addAttribute("currentUser", user);
			// 将记录保存至数据库
			qequservice.save(toolmodel);
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
		QEqu tool = qequservice.findById(id);
		model.addAttribute("vo", tool);
		return "/duty/statellite/qequ/view";
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
			@RequestParam(value = "id", required = true) String id,
			@ModelAttribute("pageModel") QEqu pagemodel,
			HttpServletRequest request, Model model) {

		QEqu tool = qequservice.findById(id);
		model.addAttribute("vo", tool);
		return "/duty/statellite/qequ/update";
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
	public String update(@ModelAttribute("pageModel") QEquModel toolmodel,
			HttpServletRequest request, Model model,
			@RequestParam("id") String id) throws IOException {
		try {
			QEqu tool = qequservice.findById(id);
			String checkid = tool.getCheckid().getId();
			EnvironmentEquipCheck enviroment = qequservice.findByIden(checkid);
			System.err.println("enviroment---->" + enviroment);
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			toolmodel.setOperator(user);
			qequservice.update(tool, enviroment, toolmodel);
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
	public String delete(@ModelAttribute("pageModel") QEquModel toolmodel,
			HttpServletRequest request, Model model,
			@RequestParam("id") String id) {
		try {
			// 删除
			QEqu tool = qequservice.findById(id);
			String checkid = tool.getCheckid().getId();
			EnvironmentEquipCheck enviroment = qequservice.findByIden(checkid);
			qequservice.delete(tool, enviroment);
			// 返回
			addSuccess(model, "删除记录成功");
			// 记录操作日志
			super.addLog(request, "删除记录成功");
		} catch (RuntimeException e) {
			addError(model, "删除记录失败");
			super.addLog(request, "删除记录失败");
		}

		return "duty/statellite/qequ/result";
	}

}
