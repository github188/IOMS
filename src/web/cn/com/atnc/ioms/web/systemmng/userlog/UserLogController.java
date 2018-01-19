package cn.com.atnc.ioms.web.systemmng.userlog;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.enums.acl.ResourceType;
import cn.com.atnc.ioms.mng.acl.IResourceManager;
import cn.com.atnc.ioms.mng.systemmng.userlog.IUserLogManager;
import cn.com.atnc.ioms.model.acl.ResourceQueryModel;
import cn.com.atnc.ioms.model.systemmng.userlog.UserLogQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * @author lizhisheng
 * @date:2014-4-3上午10:55:34
 */
@Controller
@RequestMapping("/systemmng/userlog")
public class UserLogController extends MyBaseController {

	@Autowired
	private IUserLogManager userLogManager;
	@Autowired
	private IResourceManager resourceService;

	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") UserLogQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		ResourceQueryModel qm = new ResourceQueryModel();
		qm.setType(ResourceType.MENU);
		model.addAttribute("menus", resourceService.queryMenu(qm));
		return "systemmng/userlog/manage";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") UserLogQueryModel queryModel,
			Model model) {
		Pagination pagn = this.userLogManager.queryPage(queryModel);
		model.addAttribute("pagn", pagn);
		return "systemmng/userlog/queryResult";
	}
}
