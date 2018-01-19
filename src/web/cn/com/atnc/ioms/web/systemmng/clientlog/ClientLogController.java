package cn.com.atnc.ioms.web.systemmng.clientlog;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.atnc.ioms.enums.acl.MenuEnum;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.mng.systemmng.clientlog.IClientLogManager;
import cn.com.atnc.ioms.model.systemmng.clientlog.ClientLogQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;


@Controller
@RequestMapping("/systemmng/clientlog")
public class ClientLogController extends MyBaseController {
	@Autowired
	private IClientLogManager clientLogManager;

	/**
	 * 客户日志引导
	 * @param queryModel
	 * @param model
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") ClientLogQueryModel queryModel,
			Model model, HttpServletRequest request) throws IOException {
		super.pageInfo(model, request);
		model.addAttribute("bureaus", Bureau.values());
		model.addAttribute("logTypes", clientLogManager.queryOptType());
		model.addAttribute("menus",MenuEnum.values());
		return "systemmng/clientlog/manage";
	}

	/**
	 * 客户日志分页查看
	 * @param queryModel
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") ClientLogQueryModel queryModel,
			Model model) throws IOException {
		model.addAttribute("pagn", this.clientLogManager.queryPage(queryModel));
		return "systemmng/clientlog/queryResult";
	}
}
