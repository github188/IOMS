package cn.com.atnc.ioms.web.basedata.satellite.antenna;

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

import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.common.util.file.ProjectFilePath;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.antenna.Antenna;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.mng.basedata.satellite.antenna.IAntennaManager;
import cn.com.atnc.ioms.model.basedata.satellite.AntennaQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

@Controller
@RequestMapping("/basedata/satellite/antenna")
public class AntennaController extends MyBaseController {
	@Autowired
	private IAntennaManager antennaManager;
	private String antennaQueryModelName = "antennaQueryModel";

	@RequestMapping(value = "/view.do")
	public String view(@RequestParam("id") String id, Model model) {
		model.addAttribute("pageModel", antennaManager.findById(id));

		return "basedata/satellite/antenna/view";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") AntennaQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		model.addAttribute("bureauList", Bureau.values());
		return "basedata/satellite/antenna/manage";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") AntennaQueryModel queryModel,
			Model model, HttpSession session) {
		model.addAttribute("pagn", antennaManager.queryPage(queryModel));
		session.setAttribute(antennaQueryModelName, queryModel);
		return "basedata/satellite/antenna/queryResult";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.GET)
	public String setupModForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		model.addAttribute("pageModel", antennaManager.findById(id));

		// model.addAttribute("pageModel", antennaManager.findById(id));
		// model.addAttribute("bureaus", Bureau.values());
		return "basedata/satellite/antenna/mod";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	public String porcessModForm(@ModelAttribute("pageModel") Antenna antenna,
			HttpServletRequest request, Model model) {
		try {
			antenna.setOptUser((User) WebUtils.getSessionAttribute(request,
					SessionNames.LOGIN_USER));
			model.addAttribute("vo", antennaManager.update(antenna));
			addSuccess(model, "修改卫星天线(" + antenna.getId() + ")成功");
			super.addLog(request, "修改卫星天线(" + antenna.getId() + ")成功");// getAntennaCode
		} catch (Exception e) {
			addError(model, "修改卫星天线失败:" + e.getMessage());
		}
		return "basedata/satellite/antenna/result";
	}

	@RequestMapping(value = "/expexcel.do")
	public void doExpExcel(Model model, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		AntennaQueryModel queryModel = (AntennaQueryModel) WebUtils
				.getSessionAttribute(request, antennaQueryModelName);// 获取session对象

		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition",
				"attachment;filename=Antenna.xls");

		File template = null;
		File dir = new File(ProjectFilePath.getProjectPath() + "template");
		if (dir != null && !ObjectUtils.isEmpty(dir.listFiles())) {
			for (File file : dir.listFiles()) {
				if (file.getName().contains("antenna")) {
					template = file;
					break;
				}
			}
		}
		Workbook wb = null;
		OutputStream os = null;
		try {
			wb = antennaManager.exportExcel(template, queryModel);
			os = response.getOutputStream();
			wb.write(os);
			os.flush();
			response.flushBuffer();
			super.addLog(request, "导出卫星天线成功!");
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
