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
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdMainState;
import cn.com.atnc.ioms.enums.duty.satellite.TxjdMainResult;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.ITxjdMainStateService;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TxjdMainStateModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * TES-网管主备状态
 *
 * @author 段衍林
 * @2017年2月17日 上午11:16:20
 */
@Controller
@RequestMapping("/duty/satellite/day/tes/tesmainstate/")
public class TesMainStateCheckController extends MyBaseController {

	@Autowired
	private ITxjdMainStateService txjdMainStateService;

	/**
	 * 更新跳转
	 * 
	 * @author 段衍林
	 * @2017年2月14日 上午8:35:45
	 * @param id
	 *            查询id
	 * @param request
	 *            请求控制器
	 * @param model
	 *            前端控制model
	 * @return String 返回地址
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	public String updateJump(
			@RequestParam(value = "id", required = true) String id,
			HttpServletRequest request, Model model) {
		TxjdMainState txjdMainState = txjdMainStateService.findById(id);
		model.addAttribute("vo", txjdMainState);
		model.addAttribute("txjdMainResults", TxjdMainResult.values());
		return "/duty/satellite/day/tes/tesmainstate/update";
	}

	/**
	 * 更新操作
	 * 
	 * @author 段衍林
	 * @2017年2月14日 上午8:38:31
	 * @param txjdMainStateModel
	 *            修改数据存储model
	 * @param request
	 *            请求
	 * @param model
	 *            控制model
	 * @return String 返回地址
	 * @throws IOException
	 *             异常
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(
			@ModelAttribute("pageModel") TxjdMainStateModel txjdMainStateModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 设置当前用户为操作人
			User user = super.getCurrentUser(request);
			// 更新
			txjdMainStateService.update(txjdMainStateModel, user);
			model.addAttribute("returnStr",
					new ResultModel(true, "操作成功", null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "操作失败", null).toJson());
		}
		return "returnnote";
	}
}
