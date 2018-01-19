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
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.tes.TesTele;
import cn.com.atnc.ioms.mng.basedata.tes.ITesTeleManager;
import cn.com.atnc.ioms.model.basedata.tes.TesTeleQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

@Controller
@RequestMapping("/basedata/tes/tele")
public class TesTeleController extends MyBaseController {

	@Autowired
	private ITesTeleManager tesTeleManager;
	private String tesTeleQueryModelName = "tesTeleQueryModel";
	
	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") TesTeleQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		return "basedata/tes/tele/manage";
	}


	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") TesTeleQueryModel queryModel,
			Model model, HttpSession session) 
	{
		model.addAttribute("pagn", tesTeleManager.queryPage(queryModel));
		session.setAttribute(tesTeleQueryModelName, queryModel);
		return "basedata/tes/tele/queryResult";
	}
	
	
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String setupAddForm(@ModelAttribute("pageModel") TesTele tele,
			Model model) {		
		return "basedata/tes/tele/add";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String processAddForm(@ModelAttribute("pageModel") TesTele tele,
			HttpServletRequest request, Model model) {
		try {
			tele.setOptUser((User) WebUtils.getSessionAttribute(request,
					SessionNames.LOGIN_USER));		
			model.addAttribute("vo", tesTeleManager.add(tele));
			addSuccess(model, "添加TES卫星电话(电话号码" + tele.getPhoneNum()+"-机箱号"+tele.getTesNode().getTesNodeCode()+"-槽位号"+ tele.getCu() + ")成功");
			super.addLog(request, "添加TES卫星电话(电话号码" + tele.getPhoneNum()+"-机箱号"+tele.getTesNode().getTesNodeCode()+"-槽位号"+ tele.getCu() + ")成功");
		} catch (ServiceException e) {
			addError(model, "添加TES卫星电话:" + e.getMessage());
		}
		return "basedata/tes/tele/result";
	}
	
	@RequestMapping(value = "/mod.do", method = RequestMethod.GET)
	public String setupModForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		model.addAttribute("pageModel", tesTeleManager.findById(id));	
		return "basedata/tes/tele/mod";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	public String porcessModForm(@ModelAttribute("pageModel") TesTele tele,
			HttpServletRequest request, Model model) {
		try {
			tele.setOptUser((User) WebUtils.getSessionAttribute(request,
					SessionNames.LOGIN_USER));
			model.addAttribute("vo", tesTeleManager.update(tele));
			addSuccess(model, "修改TES卫星电话(电话号码" + tele.getPhoneNum()+"-机箱号"+tele.getTesNode().getTesNodeCode()+"-槽位号"+ tele.getCu() + ")成功");
			super.addLog(request,"修改TES卫星电话(电话号码" + tele.getPhoneNum()+"-机箱号"+tele.getTesNode().getTesNodeCode()+"-槽位号"+ tele.getCu() + ")成功");
		
		} catch (Exception e) {
			addError(model, "修改TES卫星电话:" + e.getMessage());
		}
		return "basedata/tes/tele/result";
	}
	

	@RequestMapping(value = "/del.do", method = RequestMethod.POST)
	public String processDelSubmit(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		try {
			String name = tesTeleManager.delete(id);
			addSuccess(model, "删除TES卫星电话(" + name + ")成功");
			super.addLog(request,  "删除TES卫星电话(" + name + ")成功");
		} catch (ServiceException e) {
			addError(model, "删除TES卫星电话失败:" + e.getMessage());
		}
		return "basedata/tes/tele/result";
	}

	@RequestMapping(value = "/view.do")
	public String view(@RequestParam("id") String id, Model model) {
		model.addAttribute("pageModel", tesTeleManager.findById(id));		
		return "basedata/tes/tele/view";
	}
	
	@RequestMapping(value = "/impexcel.do", method = RequestMethod.GET)
	public String impexcel(Model model,
			@ModelAttribute("fileModel") FileUploadModel fileModel) {		
		return "basedata/tes/tele/import";
	}
	
	
	@RequestMapping(value = "/impexcel.do", method = RequestMethod.POST)
	public String doImpExcelPost(Model model, HttpServletRequest request,
			@ModelAttribute("fileModel") FileUploadModel fileModel) {
		try {
			Vector<?> failedData = tesTeleManager.doExcelImport(fileModel,
					super.getCurrentUser(request));
			
			if (CollectionUtils.isEmpty(failedData) || failedData.size() == 1) {
				addSuccess(model, "导入TES卫星电话成功!");
				super.addLog(request, "导入TES卫星电话成功!");
			} else {	
				super.addLog(request, "导入TES卫星电话，部分记录导入失败!");
				//addError(model, "导入TES卫星电话，部分记录导入失败!");
				model.addAttribute("failedData", failedData);				
			}
		} catch (ServiceException e) {
			addError(model, "导入TES卫星电话失败：" + e.getMessage());
		}
		return "basedata/tes/tele/import";
	}
	
	
	
	@RequestMapping(value = "/expexcel.do")
	public void doExpExcel(Model model, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		 TesTeleQueryModel queryModel=(TesTeleQueryModel) WebUtils.getSessionAttribute(request,
					tesTeleQueryModelName);//获取session对象
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition", "attachment;filename=TesTele.xls");

		File template = null;
		File dir = new File(ProjectFilePath.getProjectPath() + "template");
		if (dir != null && !ObjectUtils.isEmpty(dir.listFiles())) {
			for (File file : dir.listFiles()) {
				if (file.getName().toLowerCase().contains("testele")) {
					template = file;
					break;
				}
			}
		}

		Workbook wb = null;
		OutputStream os = null;
		try {
			
			wb = this.tesTeleManager.exportExcel(template,queryModel);		
			os = response.getOutputStream();
			wb.write(os);
			os.flush();
			response.flushBuffer();
			super.addLog(request, "导出TES卫星电话成功!");
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
