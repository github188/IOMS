package cn.com.atnc.ioms.web.basedata.atm.service;
 
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

import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.file.ProjectFilePath;
import cn.com.atnc.ioms.entity.basedata.atm.service.AtmService;
import cn.com.atnc.ioms.entity.basedata.atm.type.AtmType;
import cn.com.atnc.ioms.enums.basedata.ServiceChangeType;
import cn.com.atnc.ioms.mng.basedata.atm.service.IAtmServiceManager;
import cn.com.atnc.ioms.mng.basedata.atm.type.IAtmTypeManager;
import cn.com.atnc.ioms.model.basedata.atm.service.AtmServiceQueryModel;
import cn.com.atnc.ioms.model.basedata.atm.type.AtmTypeQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;
/**
 * 
 * @author:xiongzhikang
 * @date:2014-4-22 上午10:00:21
 * @version:1.0
 */
@Controller
@RequestMapping("/basedata/atm/service")
public class AtmServiceController extends MyBaseController {
	@Autowired
	private IAtmServiceManager atmServiceManager;
	@Autowired
	private IAtmTypeManager atmTypeManager;
	
	private String atmServiceQueryModelName = "atmServiceQueryModel";
	
	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") AtmServiceQueryModel queryModel,
			Model model, HttpServletRequest request) {
		AtmTypeQueryModel qm = new AtmTypeQueryModel();
		model.addAttribute("serviceTypes", atmTypeManager.queryList(qm));
		super.pageInfo(model, request);
		
		return "basedata/atm/service/manage";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") AtmServiceQueryModel queryModel,
			@RequestParam("atmType.serviceType") String atmTypeId,
			Model model,HttpSession session) {
		queryModel.setTypeId(atmTypeId);
        model.addAttribute("serviceChangeTypes", ServiceChangeType.values());
		session.setAttribute(atmServiceQueryModelName, queryModel);
		model.addAttribute("pagn",atmServiceManager.queryPage(queryModel));
		return "basedata/atm/service/queryResult";
	}

	@RequestMapping(value = "/view.do")
	public String view(@RequestParam("id") String id, Model model) {
		model.addAttribute("pageModel", atmServiceManager.findById(id));
		return "basedata/atm/service/view";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.GET)
	public String setupModForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		AtmTypeQueryModel queryModel = new AtmTypeQueryModel();
		model.addAttribute("pageModel", atmServiceManager.findById(id));
		model.addAttribute("serviceTypes", atmTypeManager.queryList(queryModel));
		return "basedata/atm/service/mod";
	}
	
	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	public String mod(Model model, HttpServletRequest request,
			@RequestParam("id")String id,
			@RequestParam("serviceName")String serviceName,
			@RequestParam("localConnEquip")String localConnEquip,
			@RequestParam("remoteConnEquip")String remoteConnEquip,
			@RequestParam("serviceStandbyInfo")String serviceStandbyInfo,
			@RequestParam("atmType")String atmType,
			@RequestParam("serviceRemark")String serviceRemark) throws IOException {
		AtmService service = atmServiceManager.findById(id);
		AtmType atmType1 = new AtmType();
		atmType1.setId(atmType);
		System.out.println(atmType);
		service.setServiceName(serviceName);
		service.setLocalConnEquip(localConnEquip);
		service.setRemoteConnEquip(remoteConnEquip);
		service.setServiceStandbyInfo(serviceStandbyInfo);
		service.setAtmType(atmType1);
		service.setServiceRemark(serviceRemark);
		service.setServiceChangeType(service.getServiceChangeType());
		/*model.addAttribute("vo", atmServiceManager.updateService(service));
		//添加操作日志
		super.addLog(request, "更新业务名称");
		addSuccess(model, "更新成功！");
		return "basedata/atm/service/result";*/
		try {
			this.atmServiceManager.updateService(service);
			model.addAttribute("returnStr",
					new ResultModel(true, "事件单添加成功", null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "事件单添加失败", null).toJson());
		}
		return "returnnote";
	}
	
	@RequestMapping(value = "/expexcel.dox")
	public void doExpExcel(
			 HttpServletResponse response, Model model,HttpServletRequest request)
			throws IOException, ServiceException {
		
		AtmServiceQueryModel queryModel=(AtmServiceQueryModel) WebUtils.
				getSessionAttribute(request,atmServiceQueryModelName);//获取session对象
		
		String ua = request.getHeader("user-agent"); // 获取终端类型
		if (ua == null)
			ua = " User-Agent: Mozilla/4.0 (compatible; MSIE 6.0;) ";
		boolean isIE = ua.toLowerCase().indexOf(" msie ") != -1;

		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("application/octet-stream;charset=ISO8859-1");
		if (isIE)
			response.setContentType("application/x-download");// 设置为下载application/x-download
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition", "attachment;filename=AtmService.xls");
		
		/*
		
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition", "attachment;filename=AtmService.xls");*/

		File template = null;
		File dir = new File(ProjectFilePath.getProjectPath() + "template");
		if (dir != null && !ObjectUtils.isEmpty(dir.listFiles())) {
			for (File file : dir.listFiles()) {
				if (file.getName().toLowerCase().contains("atmservice")) {
					template = file;
					break;
				}
			}
		}		
		

		Workbook wb = null;
		OutputStream os = null;
		try {
			//queryModel.setExpList(explist);
			wb = atmServiceManager.exportExcel(queryModel,template);
			os = response.getOutputStream();
			wb.write(os);
			os.flush();
			response.flushBuffer();
			super.addLog(request, "导出ATM业务成功!");	
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
