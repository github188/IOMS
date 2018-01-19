package cn.com.atnc.ioms.web.basedata.satellite.odu;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import cn.com.atnc.common.util.file.ProjectFilePath;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.mng.basedata.satellite.odu.IOduManager;
import cn.com.atnc.ioms.model.basedata.satellite.OduQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

@Controller
@RequestMapping("/basedata/satellite/odu")
public class OduController extends MyBaseController {

	@Autowired
	private IOduManager oduManager;
	private String oduQueryModelName = "oduQueryModel";

	@RequestMapping(value = "/view.do")
	public String view(@RequestParam("id") String id, Model model) {
		model.addAttribute("pageModel", oduManager.findById(id));
		return "basedata/satellite/odu/view";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") OduQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		model.addAttribute("bureauList", Bureau.values());
		return "basedata/satellite/odu/manage";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") OduQueryModel queryModel,
			Model model, HttpSession session) {
		model.addAttribute("pagn", oduManager.queryPage(queryModel));
		session.setAttribute(oduQueryModelName, queryModel);
		return "basedata/satellite/odu/queryResult";
	}

	@RequestMapping(value = "/expexcel.do")
	public void doExpExcel(Model model, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		OduQueryModel queryModel = (OduQueryModel) WebUtils
				.getSessionAttribute(request, oduQueryModelName);// 获取session对象

		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition", "attachment;filename=ODU.xls");

		File template = null;
		File dir = new File(ProjectFilePath.getProjectPath() + "template");
		if (dir != null && !ObjectUtils.isEmpty(dir.listFiles())) {
			for (File file : dir.listFiles()) {
				if (file.getName().contains("odu")) {
					template = file;
					break;
				}
			}
		}
		Workbook wb = null;
		OutputStream os = null;
		try {
			wb = this.oduManager.exportExcel(template, queryModel);
			os = response.getOutputStream();
			wb.write(os);
			os.flush();
			response.flushBuffer();
			super.addLog(request, "导出ODU成功!");
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
