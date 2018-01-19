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
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatDsOdu;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteDayAutoType;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatDsOduService;
import cn.com.atnc.ioms.model.duty.statellite.day.OduStateModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * odu状态检测
 *
 * @author 段衍林
 * @2016年11月16日 下午4:36:20
 */
@Controller
@RequestMapping("/duty/statelliteday/odustate/")
public class OduStateController extends MyBaseController {

	@Autowired
	private SatDsOduService satDsOduService;

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
			@ModelAttribute("pageModel") OduStateModel oduStateModel,
			@RequestParam("optType") String optType, Model model) {
		// 检查结果枚举类
		model.addAttribute("optType", optType);
		// 跳转添加页面
		return "duty/statelliteday/slhodustate/add";
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
	public String add(@ModelAttribute("pageModel") OduStateModel oduStateModel,
			HttpServletRequest request, Model model) throws IOException {
		// 设置当前用户为操作人
		User user = (User) request.getSession().getAttribute(
				SessionNames.LOGIN_USER);
		// 前端展示
		model.addAttribute("currentUser", user);
		try {
			// 存储创建人
			oduStateModel.setOperator(user);
			oduStateModel.setEquipName(SatelliteDayAutoType.slhODU);
			// 保存新数据
			satDsOduService.saveOrUpdate(oduStateModel);
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
			@ModelAttribute("pageModel") OduStateModel oduStateModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 删除
			this.satDsOduService.delete(oduStateModel);
			// 返回
			addSuccess(model, "删除记录成功");
			// 记录操作日志
			super.addLog(request, "删除记录成功");
		} catch (RuntimeException e) {
			addError(model, "删除记录失败");
			super.addLog(request, "删除记录失败");
		}
		return "duty/statelliteday/slhodustate/result";
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
		SatDsOdu satDsOdu = satDsOduService.findByIdPagn(id);
		model.addAttribute("vo", satDsOdu);
		return "/duty/statelliteday/slhodustate/view";
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
			@ModelAttribute("pageModel") OduStateModel oduStateModel,
			HttpServletRequest request, Model model) {
		// 检查结果枚举类
		SatDsOdu satDsOdu = satDsOduService.findById(oduStateModel.getId());
		model.addAttribute("vo", satDsOdu);
		return "/duty/statelliteday/slhodustate/update";
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
			@ModelAttribute("pageModel") OduStateModel oduStateModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			oduStateModel.setOperator(user);
			oduStateModel.setEquipName(SatelliteDayAutoType.slhODU);
			// 保存新数据
			satDsOduService.saveOrUpdate(oduStateModel);
			model.addAttribute("returnStr", new ResultModel(true, "修改记录成功",
					null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr", new ResultModel(false, "修改记录失败",
					null).toJson());
		}
		return "returnnote";
	}
}
