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
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdDecCon;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.ITxjdDecConService;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TxjdDecConModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * TES-网管DEC连通性
 *
 * @author 段衍林
 * @2017年2月15日 上午10:08:25
 */
@Controller
@RequestMapping("/duty/satellite/day/tes/tesdeccon/")
public class TesDecConCheckController extends MyBaseController {

	@Autowired
	private ITxjdDecConService txjdDecConService;

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

		TxjdDecCon txjdDecCon = txjdDecConService.findById(id);
		model.addAttribute("vo", txjdDecCon);
		return "/duty/satellite/day/tes/tesdeccon/update";
	}

	/**
	 * 更新操作
	 * 
	 * @author 段衍林
	 * @2017年2月14日 上午8:38:31
	 * @param txjdProStateModel
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
			@ModelAttribute("pageModel") TxjdDecConModel txjdDecConModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 设置当前用户为操作人
			User user = super.getCurrentUser(request);
			// 设置当前系统时间为巡检时间
			txjdDecConService.update(txjdDecConModel, user);
			model.addAttribute("returnStr",
					new ResultModel(true, "操作成功", null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "操作失败", null).toJson());
		}
		return "returnnote";
	}
}
