package cn.com.atnc.ioms.web.acl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.entity.acl.Resource;
import cn.com.atnc.ioms.enums.acl.ResourceType;
import cn.com.atnc.ioms.mng.acl.IResourceManager;
import cn.com.atnc.ioms.model.acl.ResourceQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

@Controller
@RequestMapping("/acl/resource")
public class ResourceController extends MyBaseController {

	@Autowired
	private IResourceManager resourceManager;

	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") ResourceQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		queryModel.setType(ResourceType.MENU);
		model.addAttribute("menuList", resourceManager.listByParent(queryModel));
		return "acl/resource/manage";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String queryPage(
			@ModelAttribute("queryModel") ResourceQueryModel queryModel,
			Model model) {
		Pagination pagn = resourceManager.queryPage(queryModel);
		model.addAttribute("pagn", pagn);
		return "acl/resource/queryResult";
	}

	@RequestMapping(value = "/getByParent.dox")
	public String getByParent(
			@ModelAttribute("queryModel") ResourceQueryModel queryModel,
			Model model) {
		List<Resource> list = resourceManager.listByParent(queryModel);
		model.addAttribute("list", list);
		return "acl/resource/treeItem";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String setupAddForm(
			@ModelAttribute("pageModel") Resource appResource, Model model) {
		model.addAttribute("pid", appResource.getPid());
		model.addAttribute("type", appResource.getType());
		return "acl/resource/add";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String add(@ModelAttribute("pageModel") Resource resource,
			HttpServletRequest request, Model model) {
		try {
			resourceManager.add(resource);
			model.addAttribute("model", resource);
			addSuccess(model, "添加资源项(" + resource.getType().getValue() + ","
					+ resource.getId() + "," + resource.getName() + ")");
			super.addLog(request,
					"添加资源项(" + resource.getType().getValue() + ","+ resource.getId() + "," + resource.getName()
							+ ")");
		} catch (ServiceException e) {
			addError(model, "添加失败:" + e.getMessage());
			e.printStackTrace();
		}
		return "acl/resource/result";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.GET)
	public String setupModifyForm(@RequestParam("id") String id, Model model) {
		Resource appResource = resourceManager.findById(id);
		model.addAttribute("pageModel", appResource);
		return "acl/resource/modify";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	public String modify(@ModelAttribute("pageModel") Resource resource,
			HttpServletRequest request, Model model) throws IOException {
		try {
			resourceManager.update(resource);
			model.addAttribute("model", resource);
			addSuccess(model,
					"修改资源项("+ resource.getType().getValue() + "," + resource.getId() + "," + resource.getName()
							+ ")");
			super.addLog(request,
					"修改资源项("+ resource.getType().getValue() + "," + resource.getId() + "," + resource.getName()
							+ ")");
		} catch (ServiceException e) {
			addError(model, "修改失败:" + e.getMessage());
			e.printStackTrace();
		}
		return "acl/resource/result";
	}

	@RequestMapping(value = "/del.do")
	public String delete(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		try {
			Resource resource = resourceManager.findById(id);
			model.addAttribute("model", resource);
			resourceManager.delete(id);
			super.addLog(request,
					"删除资源项("+ resource.getType().getValue() + "," + resource.getId() + "," + resource.getName()
							+ ")");
			addSuccess(model,
					"删除资源项("+ resource.getType().getValue() + "," + resource.getId() + "," + resource.getName()
							+ ")");
		} catch (ServiceException e) {
			addError(model, "删除失败:" + e.getMessage());
			e.printStackTrace();
		}
		return "acl/resource/result";
	}

	@RequestMapping(value = "/check.do")
	public void check(@RequestParam(value = "parentId") String parentId,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam("name") String name, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		boolean exist = false;
		response.getWriter().print(!exist);
	}

	@RequestMapping(value = "/checkId.dox")
	public String checkId(@RequestParam(value = "id") String id,
			HttpServletResponse response, HttpServletRequest request,
			Model model) {
		if (resourceManager.findById(id) == null) {
			model.addAttribute("returnStr", true);
		} else {
			model.addAttribute("returnStr", false);
		}
		return "returnnote";
	}

	@RequestMapping(value = "/getSubMenubyPid.dox")
	public String getSubMenu(Model model, @RequestParam("pid") String pid)
			throws UnsupportedEncodingException {
		ResourceQueryModel qm = new ResourceQueryModel();
		qm.setPid(pid);
		qm.setType(ResourceType.COLUMN);
		try {
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(resourceManager.querySubMenu(qm)));
		} catch (IOException e) {
			model.addAttribute("returnStr", "[]");
		}
		return "returnnote";

	}
}
