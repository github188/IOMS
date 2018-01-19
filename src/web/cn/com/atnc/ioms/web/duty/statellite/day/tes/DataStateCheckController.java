package cn.com.atnc.ioms.web.duty.statellite.day.tes;

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
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.DataState;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.IDataStateService;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.DataStateModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 卫星日检控制类
 *
 * @author 段衍林
 * @2017年2月13日 下午1:31:00
 */
@Controller
@RequestMapping("/duty/satellite/day/tes/datastate/")
public class DataStateCheckController extends MyBaseController {

	@Autowired
	private IDataStateService dataService;

	/**
	 * 更新跳转
	 * 
	 * @author 段衍林
	 * @2017年2月13日 下午1:48:33
	 * @param id
	 *            实体id
	 * @param request
	 *            请求
	 * @param model
	 *            视图model
	 * @param optType
	 *            tab页
	 * @return String 返回地址
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	public String updateJump(
			@RequestParam(value = "id", required = true) String id,
			@RequestParam("optType") String optType,
			HttpServletRequest request, Model model) {
		model.addAttribute("optType", optType);
		// 实体
		DataState dataState = dataService.findById(id);
		model.addAttribute("vo", dataState);
		return "/duty/satellite/day/tes/datastate/update";
	}

	/**
	 * 更新操作
	 * 
	 * @author 段衍林
	 * @2017年2月14日 上午9:00:17
	 * @param dataStateModel
	 *            数据model
	 * @param request
	 *            请求
	 * @param model
	 *            视图model
	 * @return String 返回地址
	 * @throws IOException
	 *             异常
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(
			@ModelAttribute("pageModel") DataStateModel dataStateModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 设置当前用户为操作人
			User user = super.getCurrentUser(request);
			dataService.update(dataStateModel, user);
			model.addAttribute("returnStr",
					new ResultModel(true, "操作成功", null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "操作失败", null).toJson());
		}
		return "returnnote";
	}
}
