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
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdWorkCon;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.ITxjdWorkConService;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TxjdWorkConModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 通信基地-TES-TES网管工作站连通性页面控制类
 *
 * @author 段衍林
 * @2017年2月14日 上午11:10:00
 */
@Controller
@RequestMapping("/duty/satellite/day/tes/tesworkcon/")
public class TesWorkConCheckController extends MyBaseController {

	@Autowired
	private ITxjdWorkConService txjdWorkConService;

	/**
	 * 更新跳转
	 * 
	 * @author 段衍林
	 * @2017年2月14日 上午11:13:58
	 * @param id
	 *            实体id
	 * @param request
	 *            请求
	 * @param model
	 *            视图
	 * @return String 返回地址
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	public String updateJump(
			@RequestParam(value = "id", required = true) String id,
			HttpServletRequest request, Model model) {
		// 实体查询
		TxjdWorkCon txjdWorkCon = txjdWorkConService.findById(id);
		model.addAttribute("vo", txjdWorkCon);
		return "/duty/satellite/day/tes/tesworkcon/update";
	}

	/**
	 * 更新操作
	 * 
	 * @author 段衍林
	 * @2017年2月14日 上午11:14:57
	 * @param txjdworkconmodel
	 *            实体model
	 * @param request
	 *            请求
	 * @param model
	 *            视图
	 * @return String 返回地址
	 * @throws IOException
	 *             异常
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(
			@ModelAttribute("pageModel") TxjdWorkConModel txjdWorkConModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 设置当前用户为操作人
			User user = super.getCurrentUser(request);
			// 更新操作
			txjdWorkConService.update(txjdWorkConModel, user);
			model.addAttribute("returnStr",
					new ResultModel(true, "操作成功", null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "操作失败", null).toJson());
		}
		return "returnnote";
	}

}
