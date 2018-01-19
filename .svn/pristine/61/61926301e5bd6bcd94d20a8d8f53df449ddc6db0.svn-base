package cn.com.atnc.ioms.web.duty.statellite.mqy;

import java.io.IOException;
import java.util.ArrayList;
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
import cn.com.atnc.ioms.entity.duty.satellite.Check;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.mng.duty.statellitemqy.CheckService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.CheckModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 仪器仪表清查
 * 
 * @author shijiyong
 * @date 2016年11月3日 上午9:11:02
 * @version 1.0, 2016年11月3日 上午9:11:02
 */
@Controller
@RequestMapping("/duty/statellite/check/")
public class CheckController extends MyBaseController {
	@Autowired
	private CheckService checkService;

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
	public String addJump(
			@ModelAttribute("pageModel") EnvironmentCheckQueryModel queryModel,
			@RequestParam("checkType") CheckCatagory checkType, Model model) {
		model.addAttribute("optType", queryModel.getOptType());
		model.addAttribute("checkType", checkType);
		return "duty/statellite/check/add";
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
	public String add(@ModelAttribute("pageModel") CheckModel checkModel,
			HttpServletRequest request,
			@RequestParam("checkType") CheckCatagory checkType, Model model)
			throws IOException {
		try {
			// 前台取值封装
			List<String> nums = new ArrayList<String>();
			// 循环取值，暂时写死
			for (int i = 1; i <= 26; i++) {
				// 取值变量名
				String param = "num" + i;
				// 取值
				String num = request.getParameter(param);
				// 封装列表
				nums.add(num);
			}
			checkModel.setNums(nums);
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			checkModel.setOperator(user);
			// 设置当前卫星【季检】【年检】类型
			checkModel.setCheckType(checkType);
			// 前台数据控制
			model.addAttribute("checkType", checkType);
			// 将记录保存至数据库
			checkService.save(checkModel);
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
		// 根据id查询实体
		Check check = checkService.findById(id);
		model.addAttribute("vo", check);
		return "/duty/statellite/check/view";
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
			@ModelAttribute("pageModel") CheckModel checkmodel,
			HttpServletRequest request, Model model) {

		// 页面显示
		Check check = checkService.findById(id);
		model.addAttribute("vo", check);
		return "/duty/statellite/check/update";
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
	public String update(@ModelAttribute("pageModel") CheckModel checkModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 前台取值封装
			List<String> nums = new ArrayList<String>();
			// 循环取值，暂时写死
			for (int i = 1; i <= 26; i++) {
				// 取值变量名
				String param = "num" + i;
				// 取值
				String num = request.getParameter(param);
				// 封装列表
				nums.add(num);
			}
			checkModel.setNums(nums);
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			checkModel.setOperator(user);
			// 更新
			checkService.update(checkModel);
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
	 * @throws IOException
	 */

	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String delete(@ModelAttribute("pageModel") CheckModel checkModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 删除
			checkService.delete(checkModel.getId());
			// 返回
			addSuccess(model, "删除记录成功");
			// 记录操作日志
			super.addLog(request, "删除记录成功");
		} catch (RuntimeException e) {
			addError(model, "删除记录失败");
			super.addLog(request, "删除记录失败");
		}
		return "duty/statellite/check/result";
	}

}
