package cn.com.atnc.ioms.web.basedata.ku;

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
import cn.com.atnc.ioms.entity.basedata.ku.KuNode;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.EquipType;
import cn.com.atnc.ioms.enums.basedata.SubnetType;
import cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager;
import cn.com.atnc.ioms.mng.basedata.ku.IKuServiceManager;
import cn.com.atnc.ioms.mng.clientmng.IClientEquipService;
import cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;
import cn.com.atnc.ioms.model.clientmng.query.ClientEquipQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

@Controller
@RequestMapping("/basedata/ku/node")
public class KuNodeController extends MyBaseController {
	@Autowired
	private IKuNodeManager kuNodeManager;
	@Autowired
	private IKuServiceManager kuServiceManager;
	@Autowired
	private IClientEquipService clientEquipService;

	private String kuNodeQueryModelName = "kuNodeQueryModel";

	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") KuNodeQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		model.addAttribute("subnetTypes", SubnetType.values());
		model.addAttribute("bureauList", Bureau.values());
		model.addAttribute("equipTypes", EquipType.values());
		return "basedata/ku/node/manage";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") KuNodeQueryModel queryModel,
			Model model, HttpSession session) {
		session.setAttribute(kuNodeQueryModelName, queryModel);
		model.addAttribute("pagn", this.kuNodeManager.queryPage(queryModel));
		return "basedata/ku/node/queryResult";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String setupAddForm(@ModelAttribute("pageModel") KuNode node,
			Model model) {
		model.addAttribute("bureaus", Bureau.values());
		model.addAttribute("subnetTypes", SubnetType.values());
		model.addAttribute("equipTypes", EquipType.values());
		return "basedata/ku/node/add";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String processAddForm(@ModelAttribute("pageModel") KuNode node,
			HttpServletRequest request, Model model) {
		try {
			node.setOptUser((User) WebUtils.getSessionAttribute(request,
					SessionNames.LOGIN_USER));
			model.addAttribute("vo", kuNodeManager.add(node));
			addSuccess(model, "添加KU节点(" + node.getKuNodeNo() + ")成功");
			super.addLog(request, "添加KU节点(" + node.getKuNodeNo() + ")成功");
		} catch (ServiceException e) {
			addError(model, "添加KU节点失败:" + e.getMessage());
		}
		return "basedata/ku/node/result";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.GET)
	public String setupModForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		model.addAttribute("pageModel", kuNodeManager.findById(id));
		model.addAttribute("bureaus", Bureau.values());
		model.addAttribute("equipTypes", EquipType.values());
		return "basedata/ku/node/mod";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	public String porcessModForm(@ModelAttribute("pageModel") KuNode node,
			HttpServletRequest request, Model model) {
		try {
			node.setOptUser((User) WebUtils.getSessionAttribute(request,
					SessionNames.LOGIN_USER));
			model.addAttribute("vo", kuNodeManager.update(node));
			addSuccess(model, "修改KU节点(" + node.getKuNodeNo() + ")成功");
			super.addLog(request, "修改KU节点(" + node.getKuNodeNo() + ")成功");
		} catch (Exception e) {
			e.printStackTrace();
			addError(model, "修改KU节点失败:" + e.getMessage());
		}
		return "basedata/ku/node/result";
	}

	@RequestMapping(value = "/del.do", method = RequestMethod.POST)
	public String processDelSubmit(@RequestParam("id") String id,
			 HttpServletRequest request,
			Model model) {
		try {
			String name = kuNodeManager.delete(id);
			addSuccess(model, "删除KU节点(" + name + ")成功");
			super.addLog(request, "删除KU节点(" + name + ")成功");
		} catch (ServiceException e) {
			addError(model, "删除KU节点失败:" + e.getMessage());
		}
		return "basedata/ku/node/result";
	}

	@RequestMapping(value = "/view.do")
	public String view(@RequestParam("id") String id, Model model) {
		model.addAttribute("pageModel", kuNodeManager.findById(id));
		KuStatQueryModel kuQm = new KuStatQueryModel();
		kuQm.setNodeId(id);
		model.addAttribute("serviceList", kuServiceManager.queryList(kuQm));
		KuNode node = kuNodeManager.findById(id);
		if (node != null && node.getEquip() != null) {
			ClientEquipQueryModel clientEquipQueryModel = new ClientEquipQueryModel();
			clientEquipQueryModel.setEquipID(node.getEquip().getId());
			model.addAttribute("clientList", clientEquipService
					.queryClientByEquipID(clientEquipQueryModel));
		}
		return "basedata/ku/node/view";
	}

	@RequestMapping(value = "/impexcel.do", method = RequestMethod.GET)
	public String impexcel(Model model,
			@ModelAttribute("fileModel") FileUploadModel fileModel) {
		return "basedata/ku/node/import";
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
			Vector<?> failedData = kuNodeManager.doExcelImport(fileModel,
					super.getCurrentUser(request));
			if (CollectionUtils.isEmpty(failedData) || failedData.size() == 1) {
				addSuccess(model, "导入Ku节点成功!");
				super.addLog(request, "导入Ku节点成功!");
			} else {
				super.addLog(request, "导入Ku节点，部分记录导入失败!");
				model.addAttribute("failedData", failedData);
			}
		} catch (ServiceException e) {
			addError(model, "导入Ku节点失败：" + e.getMessage());
		}
		return "basedata/ku/node/import";
	}

	@RequestMapping(value = "/expexcel.do")
	public void doExpExcel(Model model, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		KuNodeQueryModel queryModel = (KuNodeQueryModel) WebUtils
				.getSessionAttribute(request, kuNodeQueryModelName);// 获取session对象
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
		response.addHeader("Content-Disposition",
				"attachment;filename=KuNode.xls");

		File template = null;
		File dir = new File(ProjectFilePath.getProjectPath() + "template");
		if (dir != null && !ObjectUtils.isEmpty(dir.listFiles())) {
			for (File file : dir.listFiles()) {
				if (file.getName().contains("kunode")) {
					template = file;
					break;
				}
			}
		}

		Workbook wb = null;
		OutputStream os = null;
		try {
			wb = this.kuNodeManager.exportExcel(template, queryModel);
			os = response.getOutputStream();
			wb.write(os);
			os.flush();
			response.flushBuffer();
			super.addLog(request, "导出Ku节点成功!");
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
