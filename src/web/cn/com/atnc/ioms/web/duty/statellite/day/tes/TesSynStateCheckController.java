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
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdSynState;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.ITxjdSynStateService;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TxjdSynStateModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * TES-网管主备状态
 * 
 * @author shijiyong
 * @date 2016年10月25日 上午9:13:02
 * @version 1.0, 2016年10月14日 上午9:13:02
 */
@Controller
@RequestMapping("/duty/satellite/day/tes/tessynstate/")
public class TesSynStateCheckController extends MyBaseController {

	@Autowired
	private ITxjdSynStateService txjdSynStateService;

	/**
	 * 
	 * @author 段衍林
	 * @2017年2月16日 上午10:41:14
	 * @param id
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	public String updateJump(
			@RequestParam(value = "id", required = true) String id,
			HttpServletRequest request, Model model) {
		TxjdSynState synstate = txjdSynStateService.findById(id);
		model.addAttribute("vo", synstate);
		return "/duty/satellite/day/tes/tessynstate/update";
	}

	/**
	 * 
	 * @author 段衍林
	 * @2017年2月16日 上午10:41:21
	 * @param txjdSynStateModel
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(
			@ModelAttribute("pageModel") TxjdSynStateModel txjdSynStateModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 设置当前用户为操作人
			User user = super.getCurrentUser(request);
			txjdSynStateService.update(txjdSynStateModel, user);
			model.addAttribute("returnStr",
					new ResultModel(true, "操作成功", null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "操作失败", null).toJson());
		}
		return "returnnote";
	}

}
