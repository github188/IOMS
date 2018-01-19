package cn.com.atnc.ioms.web.basedata.satellite.site;

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
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.file.ProjectFilePath;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.mng.basedata.satellite.site.ISiteManager;
import cn.com.atnc.ioms.model.basedata.satellite.site.SiteQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;
/**
 * 
 * @author lizhisheng
 *
 */
@Controller
@RequestMapping("/basedata/satellite/site")
public class SiteController extends MyBaseController {
	@Autowired
	private ISiteManager SiteManager;
	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") SiteQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		model.addAttribute("bureauList", Bureau.values());
		return "basedata/satellite/site/manage";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") SiteQueryModel queryModel,
			Model model, HttpSession session) {
		model.addAttribute("pagn", this.SiteManager.queryPage(queryModel));
		session.setAttribute("siteQueryModel", queryModel);
		return "basedata/satellite/site/queryResult";
	}
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String setupAddForm(@ModelAttribute("pageModel") SatelliteSite node,
			Model model) {
		model.addAttribute("bureaus", Bureau.values());
		return "basedata/satellite/site/add";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String processAddForm(@ModelAttribute("pageModel") SatelliteSite node,
			HttpServletRequest request, Model model) {
		try {
			model.addAttribute("vo", SiteManager.add(node));
			addSuccess(model, "添加卫星站点(" + node.getSiteName() + ")成功");
			 super.addLog(request, "添加卫星站点(" + node.getSiteName() + ")成功");
		} catch (ServiceException e) {
			addError(model, "添加卫星站点失败:" + e.getMessage());
		}
		return "basedata/satellite/site/result";
	}
	@RequestMapping(value = "/checkSiteCode.dox")
		public String checkSiteCode(Model model,SiteQueryModel queryModel) {
		if (SiteManager.querySizeCodeCheck(queryModel) > 0) {
			model.addAttribute("returnStr", false);
		} else {
			model.addAttribute("returnStr", true);
		}
		return "returnnote";
	}
	@RequestMapping(value = "/del.do", method = RequestMethod.POST)
	public String processDelSubmit(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		try {
			
			String name = SiteManager.delete(id);
			addSuccess(model, "删除卫星站点(" + name + ")成功");
			 super.addLog(request,"删除卫星站点(" + name + ")成功");
		} catch (ServiceException e) {
			addError(model, "删除卫星站点失败:" + e.getMessage());
		}
		return "basedata/satellite/site/result";
	}
	@RequestMapping(value = "/mod.do", method = RequestMethod.GET)
	public String setupModForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		model.addAttribute("pageModel", SiteManager.findById(id));
		model.addAttribute("bureaus", Bureau.values());
		return "basedata/satellite/site/mod";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	public String porcessModForm(@ModelAttribute("pageModel") SatelliteSite node,
			HttpServletRequest request, Model model) {
		try {
			model.addAttribute("vo", SiteManager.update(node));
			addSuccess(model, "修改卫星站点(" + node.getSiteName() + ")成功");
			 super.addLog(request,  "修改卫星站点(" + node.getSiteName() + ")成功");
		} catch (Exception e) {
			e.printStackTrace();
			addError(model, "修改卫星站点失败:" + e.getMessage());
		}
		return "basedata/satellite/site/result";
	}
	//导出
	@RequestMapping(value = "/expexcel.do")
	public void doExpExcel(Model model, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		SiteQueryModel queryModel =  (SiteQueryModel) WebUtils.getSessionAttribute(request,
				"siteQueryModel");
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition", "attachment;filename=SatelliteSite.xls");

		File template = null;
		File dir = new File(ProjectFilePath.getProjectPath() + "template");
		if (dir != null && !ObjectUtils.isEmpty(dir.listFiles())) {
			for (File file : dir.listFiles()) {
				if (file.getName().toLowerCase().contains("satellitesite")) {
					template = file;
					break;
				}
			}
		}

		Workbook wb = null;
		OutputStream os = null;
		try {
			wb = this.SiteManager.exportExcel(queryModel,template);
			os = response.getOutputStream();
			wb.write(os);
			os.flush();
			response.flushBuffer();
			super.addLog(request, "导出卫星节点成功!");
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
	//导入
	@RequestMapping(value = "/impexcel.do", method = RequestMethod.GET)
	public String impexcel(Model model,
			@ModelAttribute("fileModel") FileUploadModel fileModel) {
		return "basedata/satellite/site/import";
	}

	/**
	 * Excel导入实现
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
			Vector<?> failedData = SiteManager.doExcelImport(fileModel,
					super.getCurrentUser(request));
			if (CollectionUtils.isEmpty(failedData) || failedData.size() == 1) {
				addSuccess(model, "导入卫星站点成功!");
				 super.addLog(request,"导入卫星站点成功!");
			} else {
				addError(model, "导入卫星站点，部分记录导入失败!");
				model.addAttribute("failedData", failedData);
			}
		} catch (ServiceException e) {
			addError(model, "导入失败：" + e.getMessage());
		}
		return "basedata/satellite/site/import";
	}
}
