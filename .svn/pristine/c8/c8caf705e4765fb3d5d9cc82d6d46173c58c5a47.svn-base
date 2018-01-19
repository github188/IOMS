package cn.com.atnc.ioms.web.acl;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.mng.acl.IRoleManager;
import cn.com.atnc.ioms.mng.security.IRoleResourceLoader;
import cn.com.atnc.ioms.model.acl.ConfRoleModel;
import cn.com.atnc.ioms.model.acl.RoleQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

@Controller
@RequestMapping("/acl/role")
public class RoleController extends MyBaseController implements
		ServletContextAware {
	@Autowired
	private IRoleManager roleManager;

	@Autowired
	private IRoleResourceLoader roleResourceLoader;

	private ServletContext servletContext;

	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		this.servletContext = servletContext;
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") RoleQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		return "acl/role/manage";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") RoleQueryModel queryModel, Model model) {
		model.addAttribute("roles", this.roleManager.queryPage(queryModel));
		return "acl/role/queryResult";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String setupAddForm(@ModelAttribute("pageModel") Role role) {
		return "acl/role/add";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String processAddForm(@ModelAttribute("pageModel") Role role,
			HttpServletRequest request, Model model) {
		try {
			roleManager.add(role);
			addSuccess(model, "添加角色(" + role.getName() + ")成功");
			model.addAttribute("vo", role);
			super.addLog(request, "添加角色(" + role.getName() + ")成功");
		} catch (ServiceException e) {
			addError(model, "添加角色失败:" + e.getMessage());
		}
		return "acl/role/result";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.GET)
	public String setupModForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		model.addAttribute("pageModel", roleManager.findById(id));
		return "acl/role/mod";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	public String porcessModForm(@ModelAttribute("pageModel") Role role,
			HttpServletRequest request, Model model) {
		try {
			roleManager.update(role);
			addSuccess(model, "修改角色(" + role.getName() + ")成功");
			model.addAttribute("vo", role);
			super.addLog(request, "修改角色(" + role.getName() + ")成功");
		} catch (Exception e) {
			addError(model, "修改角色失败:" + e.getMessage());
		}
		return "acl/role/result";
	}

	@RequestMapping(value = "/conf.do", method = RequestMethod.GET)
	public String processConfSubmit(@RequestParam("id") String id, Model model) {
		model.addAttribute("confMap", roleManager.getCurrentConf(id));
		model.addAttribute("role", roleManager.findById(id));
		return "acl/role/conf";
	}

	@RequestMapping(value = "/conf.do", method = RequestMethod.POST)
	public String processSaveSubit(
			@ModelAttribute("pageModel") ConfRoleModel confRoleModel,
			HttpServletRequest request, Model model) {
		try {
			this.roleManager.confRole(confRoleModel);
			Role role = this.roleManager.findById(confRoleModel.getRoleId());
			model.addAttribute("vo", role);

			servletContext.removeAttribute("jspAuthorities");
			servletContext.setAttribute("jspAuthorities",
					roleResourceLoader.loadJSPElementIDAuthorities());
			addSuccess(model, "配置角色权限(" + role.getName() + ")成功");
			super.addLog(request, "配置角色权限(" + role.getName() + ")成功");
		} catch (ServiceException e) {
			addError(model, e.getMessage());
		}
		return "acl/role/result";
	}

	@RequestMapping(value = "/del.do", method = RequestMethod.POST)
	public String processDelSubmit(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		try {
			String roleName = roleManager.delete(id);
			addSuccess(model, "删除角色(" + roleName + ")成功");
			super.addLog(request, "删除角色(" + roleName + ")成功");
		} catch (ServiceException e) {
			addError(model, "删除失败:" + e.getMessage());
		}
		return "acl/role/result";
	}

	@RequestMapping(value = "/checkName.dox")
	public String checkUserName(Model model, @RequestParam("name") String name) {
		model.addAttribute("returnStr", !(roleManager.isNameExist(null, name)));
		return "returnnote";
	}
}
