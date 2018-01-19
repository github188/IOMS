package cn.com.atnc.ioms.web.basedata.atm.cardruninfo;

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
import org.springframework.web.util.WebUtils;

import cn.com.atnc.common.util.file.ProjectFilePath;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.mng.operstat.atm.IAtmCardRunInfoService;
import cn.com.atnc.ioms.model.operstat.atm.AtmCardRunInfoModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * @author Chenwei
 * @date 2014-8-26 下午1:03:34
 * @version 1.0
 */
@Controller("atmCardRunInfoController")
@RequestMapping("basedata/atm/cardruninfo/")
public class AtmCardRunInfoController extends MyBaseController {

	@Autowired
	private IAtmCardRunInfoService atmCardRunInfoService;

	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") AtmCardRunInfoModel queryModel,
			HttpServletRequest request, Model model) {
		model.addAttribute("bureaus", Bureau.values());
		super.pageInfo(model, request);
		return "basedata/atm/cardruninfo/manage";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") AtmCardRunInfoModel queryModel,
			Model model, HttpSession session) {
		model.addAttribute("pagn", atmCardRunInfoService.queryPage(queryModel));
		session.setAttribute("atmCardRunInfoModel", queryModel);
		return "basedata/atm/cardruninfo/queryResult";
	}
	
	@RequestMapping(value = "/expexcel.do")
	public void doExpExcel(Model model, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		AtmCardRunInfoModel queryModel = (AtmCardRunInfoModel) WebUtils
				.getSessionAttribute(request, "atmCardRunInfoModel");// 获取session对象
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition",
				"attachment;filename=atmcardruninfo.xls");

		File template = null;
		File dir = new File(ProjectFilePath.getProjectPath() + "template");
		if (dir != null && !ObjectUtils.isEmpty(dir.listFiles())) {
			for (File file : dir.listFiles()) {
				if (file.getName().contains("atmcardruninfo")) {
					template = file;
					break;
				}
			}
		}

		Workbook wb = null;
		OutputStream os = null;
		try {
			wb = atmCardRunInfoService.exportExcel(queryModel, template);
			os = response.getOutputStream();
			wb.write(os);
			os.flush();
			response.flushBuffer();
			super.addLog(request, "导出ATM板卡运行信息成功!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			response.sendError(404, e.getMessage());
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			response.sendError(404, e.getMessage());
		}

		finally {
			os.close();
		}

	}

}
