package cn.com.atnc.ioms.web.basedata.ku;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

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
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.ku.KuService;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.KuServiceRateType;
import cn.com.atnc.ioms.enums.basedata.SubnetType;
import cn.com.atnc.ioms.mng.basedata.ku.IKuServiceManager;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

@Controller
@RequestMapping("/basedata/ku/service")
public class KuServiceController extends MyBaseController {
	@Autowired
	private IKuServiceManager kuServiceManager;

	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") KuStatQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		model.addAttribute("subnetTypes", SubnetType.values());
		model.addAttribute("kuServiceRateTypes", KuServiceRateType.values());
		return "basedata/ku/service/manage";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") KuStatQueryModel queryModel,
			Model model, HttpSession session) {
		model.addAttribute("pagn", this.kuServiceManager.queryPage(queryModel));
		session.setAttribute("kuServiceQueryModel", queryModel);
		return "basedata/ku/service/queryResult";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String setupAddForm(@ModelAttribute("pageModel") KuService service,
			Model model) {
		model.addAttribute("bureaus", Bureau.values());
		model.addAttribute("subnetTypes", SubnetType.values());
		model.addAttribute("kuServiceRateTypes", KuServiceRateType.values());
		return "basedata/ku/service/add";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String processAddForm(
			@ModelAttribute("pageModel") KuService service,
			HttpServletRequest request, Model model) {
		try {
			service.setOptUser((User) WebUtils.getSessionAttribute(request,
					SessionNames.LOGIN_USER));
			model.addAttribute("vo", kuServiceManager.add(service));
			addSuccess(model, "添加KU业务(" + service.getCode() + ")成功");
			super.addLog(request, "添加KU业务(" + service.getCode() + ")成功");
		} catch (ServiceException e) {
			addError(model, "添加KU业务失败:" + e.getMessage());
		}
		return "basedata/ku/service/result";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.GET)
	public String setupModForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		model.addAttribute("subnetTypes", SubnetType.values());
		model.addAttribute("pageModel", kuServiceManager.findById(id));
		model.addAttribute("bureaus", Bureau.values());
		model.addAttribute("kuServiceRateTypes", KuServiceRateType.values());
		return "basedata/ku/service/mod";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	public String porcessModForm(
			@ModelAttribute("pageModel") KuService service,
			HttpServletRequest request, Model model) {
		try {
			service.setOptUser((User) WebUtils.getSessionAttribute(request,
					SessionNames.LOGIN_USER));
			model.addAttribute("vo", kuServiceManager.update(service));
			addSuccess(model, "修改KU业务(" + service.getCode() + ")成功");
			super.addLog(request, "修改KU业务(" + service.getCode() + ")成功");
		} catch (Exception e) {
			addError(model, "修改KU业务失败:" + e.getMessage());
		}
		return "basedata/ku/service/result";
	}

	@RequestMapping(value = "/del.do", method = RequestMethod.POST)
	public String processDelSubmit(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		try {
			String name = kuServiceManager.delete(id);
			addSuccess(model, "删除KU业务(" + name + ")成功");
			super.addLog(request, "删除KU业务(" + name + ")成功");
		} catch (ServiceException e) {
			addError(model, "删除KU业务失败:" + e.getMessage());
		}
		return "basedata/ku/service/result";
	}

	@RequestMapping(value = "/view.do")
	public String view(@RequestParam("id") String id, Model model) {
		model.addAttribute("pageModel", kuServiceManager.findById(id));
		return "basedata/ku/service/view";
	}

	@RequestMapping(value = "/impexcel.do", method = RequestMethod.GET)
	public String impexcel(Model model,
			@ModelAttribute("fileModel") FileUploadModel fileModel) {
		return "basedata/ku/service/import";
	}

	/**
	 * 物料Excel导入实现
	 * 
	 * @param model
	 * @param request
	 * @param fileModel
	 * @return
	 */
	@RequestMapping(value = "/impexcel.do", method = RequestMethod.POST)
	public String doImpExcelPost(Model model, HttpServletRequest request,
			@ModelAttribute("fileModel") FileUploadModel fileModel) {
		try {
			List<?> failedData = kuServiceManager.doExcelImport(fileModel,
					super.getCurrentUser(request));
			if (CollectionUtils.isEmpty(failedData) || failedData.size() == 1) {
				addSuccess(model, "导入Ku业务成功!");
				super.addLog(request, "导入Ku业务成功!");

			} else {
				super.addLog(request, "导入Ku业务，部分记录导入失败!");
				model.addAttribute("failedData", failedData);
			}
		} catch (ServiceException e) {
			addError(model, "导入Ku业务失败：" + e.getMessage());
		}
		return "basedata/ku/service/import";
	}

	@RequestMapping(value = "/expexcel.do")
	public void doExpExcel(Model model, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		KuStatQueryModel queryModel = (KuStatQueryModel) WebUtils
				.getSessionAttribute(request, "kuServiceQueryModel");// 获取session对象
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition",
				"attachment;filename=KuService.xls");

		File template = null;
		File dir = new File(ProjectFilePath.getProjectPath() + "template");
		if (dir != null && !ObjectUtils.isEmpty(dir.listFiles())) {
			for (File file : dir.listFiles()) {
				if (file.getName().toLowerCase().contains("kuservice")) {
					template = file;
					break;
				}
			}
		}

		Workbook wb = null;
		OutputStream os = null;
		try {
			wb = this.kuServiceManager.exportExcel(template, queryModel);
			os = response.getOutputStream();
			wb.write(os);
			os.flush();
			response.flushBuffer();
			super.addLog(request, "导出Ku业务成功!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			response.sendError(404, e.getMessage());
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			response.sendError(404, e.getMessage());
		} finally {
			if (os != null) {
				os.close();
			}
		}

	}

}
