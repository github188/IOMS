package cn.com.atnc.ioms.web.basedata.tes;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import cn.com.atnc.common.model.FileUploadModel;
import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.file.ProjectFilePath;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.tes.TesService;
import cn.com.atnc.ioms.mng.basedata.tes.ITesServiceManager;
import cn.com.atnc.ioms.model.basedata.tes.TesServiceQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

@Controller
@RequestMapping("/basedata/tes/service")
public class TesServiceController extends MyBaseController {
	@Autowired
	private ITesServiceManager tesServiceManager;
	private String tesServiceQueryModelName = "tesServiceQueryModel";

	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") TesServiceQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		return "basedata/tes/service/manage";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") TesServiceQueryModel queryModel,
			Model model, HttpSession session) {
		model.addAttribute("pagn", tesServiceManager.queryPage(queryModel));
		session.setAttribute(tesServiceQueryModelName, queryModel);
		return "basedata/tes/service/queryResult";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String setupAddForm(@ModelAttribute("pageModel") TesService service,
			Model model) {
		// model.addAttribute("bureaus", Bureau.values());
		return "basedata/tes/service/add";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String processAddForm(
			@ModelAttribute("pageModel") TesService service,
			HttpServletRequest request, Model model) {
		try {
			service.setOptUser((User) WebUtils.getSessionAttribute(request,
					SessionNames.LOGIN_USER));
			model.addAttribute("vo", tesServiceManager.add(service));
			addSuccess(model, "添加TES业务(" + service.getCircuitName() + ")成功");
			super.addLog(request, "添加TES业务(" + service.getCircuitName() + ")成功");
		} catch (ServiceException e) {
			addError(model, "添加TES业务失败:" + e.getMessage());
		}
		return "basedata/tes/service/result";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.GET)
	public String setupModForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		model.addAttribute("pageModel", tesServiceManager.findById(id));
		return "basedata/tes/service/mod";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	public String porcessModForm(
			@ModelAttribute("pageModel") TesService service,
			HttpServletRequest request, Model model) {
		try {
			service.setOptUser((User) WebUtils.getSessionAttribute(request,
					SessionNames.LOGIN_USER));
			model.addAttribute("vo", tesServiceManager.update(service));
			addSuccess(model, "修改TES业务(" + service.getCircuitName() + ")成功");
			super.addLog(request, "修改TES业务(" + service.getCircuitName() + ")成功");
		} catch (Exception e) {
			addError(model, "修改TES业务失败:" + e.getMessage());
		}
		return "basedata/tes/service/result";
	}

	@RequestMapping(value = "/del.do", method = RequestMethod.POST)
	public String processDelSubmit(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		try {
			String name = tesServiceManager.delete(id);
			addSuccess(model, "删除TES业务(" + name + ")成功");
			super.addLog(request, "删除TES业务(" + name + ")成功");
		} catch (ServiceException e) {
			addError(model, "删除TES业务失败:" + e.getMessage());
		}
		return "basedata/tes/service/result";
	}

	@RequestMapping(value = "/view.do")
	public String view(@RequestParam("id") String id, Model model) {
		model.addAttribute("pageModel", tesServiceManager.findById(id));

		return "basedata/tes/service/view";
	}

	@RequestMapping(value = "/impexcel.do", method = RequestMethod.GET)
	public String impexcel(Model model,
			@ModelAttribute("fileModel") FileUploadModel fileModel) {

		return "basedata/tes/service/import";
	}

	@RequestMapping(value = "/impexcel.do", method = RequestMethod.POST)
	public String doImpExcelPost(Model model, HttpServletRequest request,
			@ModelAttribute("fileModel") FileUploadModel fileModel) {
		try {
			Vector<?> failedData = tesServiceManager.doExcelImport(fileModel,
					super.getCurrentUser(request));

			if (CollectionUtils.isEmpty(failedData) || failedData.size() == 1) {
				addSuccess(model, "导入TES业务成功!");
				super.addLog(request, "导入TES业务成功!");
			} else {
				super.addLog(request, "导入TES业务，部分记录导入失败!");
				// addError(model, "导入TES业务，部分记录导入失败!");
				model.addAttribute("failedData", failedData);
			}
		} catch (ServiceException e) {
			addError(model, "导入Tes业务失败：" + e.getMessage());
		}
		return "basedata/tes/service/import";
	}

	@RequestMapping(value = "/expexcel.do")
	public void doExpExcel(Model model, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		TesServiceQueryModel queryModel = (TesServiceQueryModel) WebUtils
				.getSessionAttribute(request, tesServiceQueryModelName);// 获取session对象
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition",
				"attachment;filename=TesService.xls");

		File template = null;
		File dir = new File(ProjectFilePath.getProjectPath() + "template");
		if (dir != null && !ObjectUtils.isEmpty(dir.listFiles())) {
			for (File file : dir.listFiles()) {
				if (file.getName().toLowerCase().contains("tesservice")) {
					template = file;
					break;
				}
			}
		}

		Workbook wb = null;
		OutputStream os = null;
		try {

			wb = this.tesServiceManager.exportExcel(template, queryModel);
			os = response.getOutputStream();
			wb.write(os);
			os.flush();
			response.flushBuffer();
			super.addLog(request, "导出TES业务成功!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			response.sendError(404, e.getMessage());
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			response.sendError(404, e.getMessage());
		} finally {
			os.close();
		}
	}

}
