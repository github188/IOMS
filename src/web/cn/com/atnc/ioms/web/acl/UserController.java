package cn.com.atnc.ioms.web.acl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.mng.acl.IRoleManager;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.systemmng.deptinfomng.IDeptInfoMngService;
import cn.com.atnc.ioms.model.acl.RoleQueryModel;
import cn.com.atnc.ioms.model.acl.UserQueryModel;
import cn.com.atnc.ioms.model.systemmng.deptinfomng.DeptInfoQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 
 * @author:HuangYijie
 * @date:2011-8-8 下午01:13:34
 * @version:1.0
 */
@Controller
@RequestMapping("/acl/user")
public class UserController extends MyBaseController {
	@Autowired
	private IUserManager userManager;
	@Autowired
	private IRoleManager roleManager;
	@Autowired
	private IDeptInfoMngService deptService;

	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") UserQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		return "acl/user/manage";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") UserQueryModel queryModel, Model model)
			throws IOException {
		Pagination pagn = this.userManager.queryPage(queryModel);
		model.addAttribute("pagn", pagn);
		return "acl/user/queryResult";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String setupAddForm(@ModelAttribute("pageModel") User user,
			Model model) {
		DeptInfoQueryModel qm=new DeptInfoQueryModel();
		qm.setParentInfo("0");
		model.addAttribute("parents", deptService.getDeptByParentInfo(qm));
		return "acl/user/add";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String processAddForm(@ModelAttribute("pageModel") User user,
			HttpServletRequest request, Model model) {
		try {
			String id = userManager.add(user);
			addSuccess(model, "添加用户(" + user.getLoginName() + ")成功");
			model.addAttribute("vo", userManager.findById(id));
			super.addLog(request, 
					"添加用户(" + user.getLoginName() + ")成功");
		} catch (ServiceException e) {
			addError(model, "添加用户失败:" + e.getMessage());
		}
		return "acl/user/result";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.GET)
	public String setupModForm(@RequestParam("id") String id, Model model) {
		model.addAttribute("pageModel", userManager.findById(id));
		DeptInfoQueryModel qm=new DeptInfoQueryModel();
		qm.setParentInfo("0");
		model.addAttribute("parents", deptService.getDeptByParentInfo(qm));
		return "acl/user/mod";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	public String porcessModForm(@ModelAttribute("pageModel") User user,
			HttpServletRequest request, Model model) {
		try {
			User po = userManager.update(user);
			addSuccess(model, "修改用户(" + user.getLoginName() + ")成功");
			model.addAttribute("vo", po);
			super.addLog(request, 
					"修改用户(" + user.getLoginName() + ")成功");
		} catch (ServiceException e) {
			addError(model, "修改用户失败:" + e.getMessage());
		}
		return "acl/user/result";
	}

	@RequestMapping(value = "/status.do")
	public String changeStatus(@RequestParam("id") String id,
			HttpServletRequest request, @RequestParam("status") Boolean status,
			Model model) {
		try {
			User user = userManager.updateStatus(id, status);
			model.addAttribute("vo", user);
			super.addLog(request, 
					"删除用户(" + user.getLoginName() + ")成功,状态改为"
							+ (status == false ? "失效" : "有效"));
			addSuccess(model, "删除用户(" + user.getLoginName() + ")成功,状态改为"
					+ (status == false ? "失效" : "有效"));
		} catch (ServiceException e) {
			addError(model, "删除用户失败:" + e.getMessage());
		}
		return "acl/user/result";
	}

	@RequestMapping(value = "/view.do")
	public String view(@RequestParam("id") String id, Model model) {
		model.addAttribute("pageModel", userManager.findById(id));
		return "acl/user/view";
	}

	@RequestMapping(value = "/roleSelect.dox", method = RequestMethod.GET)
	public String manage(Model model,
			@ModelAttribute("queryModel") RoleQueryModel queryModel) {
		return "acl/user/roleSelect/roleSelect";
	}

	@RequestMapping(value = "/roleSelect.dox", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") RoleQueryModel queryModel, Model model) {
		queryModel.setPageSize(5);
		model.addAttribute("pagn", this.roleManager.queryPage(queryModel));
		return "acl/user/roleSelect/queryResult";
	}

	@RequestMapping(value = "/checkUserName.dox")
	public String checkUserName(Model model,
			@RequestParam("loginName") String loginName) {
		if (userManager.findByLoginName(loginName) == null) {
			model.addAttribute("returnStr", true);
		} else {
			model.addAttribute("returnStr", false);
		}
		return "returnnote";
	}

	@RequestMapping(value = "/del.do")
	public String processDelSubmit(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		try {
			String name = userManager.deleteById(id);
			addSuccess(model, "删除用户(" + name + ")成功");
			super.addLog(request, "删除用户(" + name + ")成功");
		} catch (ServiceException e) {
			addError(model, "删除失败:" + e.getMessage());
		}
		return "acl/user/result";
	}
}
