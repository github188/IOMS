package cn.com.atnc.ioms.web.basedata.tes;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
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
import cn.com.atnc.ioms.entity.basedata.tes.TesNode;
import cn.com.atnc.ioms.entity.basedata.tes.TesSlot;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.mng.basedata.tes.ITesNodeManager;
import cn.com.atnc.ioms.mng.basedata.tes.ITesServiceManager;
import cn.com.atnc.ioms.mng.basedata.tes.ITesSlotManager;
import cn.com.atnc.ioms.mng.clientmng.IClientEquipService;
import cn.com.atnc.ioms.model.basedata.tes.TesNodeQueryModel;
import cn.com.atnc.ioms.model.basedata.tes.TesServiceQueryModel;
import cn.com.atnc.ioms.model.clientmng.query.ClientEquipQueryModel;
import cn.com.atnc.ioms.model.operstat.tes.TesStatQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

@Controller
@RequestMapping("/basedata/tes/node")
public class TesNodeController extends MyBaseController {
	@Autowired
	private ITesNodeManager tesNodeManager;

	@Autowired
	private ITesServiceManager tesServiceManager;

	@Autowired
	private ITesSlotManager tesSlotManager;
	@Autowired
	private IClientEquipService clientEquipService;
	private String tesNodeQueryModelName = "tesNodeQueryModel";

	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") TesNodeQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		model.addAttribute("bureauList", Bureau.values());
		return "basedata/tes/node/manage";
	}

	/*
	 * @RequestMapping(value = "/manage.do", method = RequestMethod.POST) public
	 * String manageList(
	 * 
	 * @ModelAttribute("queryModel") TesNodeQueryModel queryModel, Model model)
	 * {
	 */

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") TesNodeQueryModel queryModel,
			Model model, HttpSession session) {
		model.addAttribute("pagn", tesNodeManager.queryPage(queryModel));
		session.setAttribute(tesNodeQueryModelName, queryModel);
		return "basedata/tes/node/queryResult";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String setupAddForm(@ModelAttribute("pageModel") TesNode node,
			Model model) {
		model.addAttribute("bureaus", Bureau.values());
		return "basedata/tes/node/add";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String processAddForm(@ModelAttribute("pageModel") TesNode node,
			HttpServletRequest request, Model model) {
		try {

			String[] cus = request.getParameterValues("slotCU");
			String[] occs = request.getParameterValues("slotOCC");
			String[] infos = request.getParameterValues("slotInfo");

			// tesSlotManager.deleteByTesNode(node);
			List<TesSlot> tesSlotList = new ArrayList<TesSlot>();

			if (cus != null) {
				for (int i = 0; i < cus.length; i++) {
					TesSlot tesSlot = new TesSlot();
					if (cus[i] != null && cus[i].trim() != "") {
						tesSlot.setCu(cus[i].trim());
						if (occs[i] != null && occs[i].trim() != "")
							tesSlot.setOcc(Integer.parseInt(occs[i].trim()));
						if (infos[i] != null && infos[i].trim() != "")
							tesSlot.setInfo(infos[i]);

						tesSlot.setTesNodeId(node.getId());
						tesSlot.setOptUser((User) WebUtils.getSessionAttribute(
								request, SessionNames.LOGIN_USER));
						tesSlot.setTesNode(node);
						tesSlotList.add(tesSlot);
					}
				}
				node.setTesSlotList(tesSlotList);
			}
			node.setOptUser((User) WebUtils.getSessionAttribute(request,
					SessionNames.LOGIN_USER));

			model.addAttribute("vo", tesNodeManager.add(node));
			addSuccess(model, "添加TES节点(" + node.getTesNodeCode() + ")成功");
			super.addLog(request, "添加TES节点(" + node.getTesNodeCode() + ")成功");
		} catch (ServiceException e) {
			addError(model, "添加TES节点失败:" + e.getMessage());
		}
		return "basedata/tes/node/result";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.GET)
	public String setupModForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		model.addAttribute("pageModel", tesNodeManager.findById(id));
		model.addAttribute("bureaus", Bureau.values());

		return "basedata/tes/node/mod";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	public String porcessModForm(@ModelAttribute("pageModel") TesNode node,
			HttpServletRequest request, Model model) {
		try {
			String[] cus = request.getParameterValues("slotCU");
			String[] occs = request.getParameterValues("slotOCC");
			String[] infos = request.getParameterValues("slotInfo");

			tesSlotManager.deleteByTesNode(node);
			List<TesSlot> tesSlotList = new ArrayList<TesSlot>();

			if (cus != null)
				for (int i = 0; i < cus.length; i++) {
					TesSlot tesSlot = new TesSlot();
					if (cus[i] != null && cus[i].trim() != "") {
						tesSlot.setCu(cus[i].trim());

						if (occs[i] != null && occs[i].trim() != "")
							tesSlot.setOcc(Integer.parseInt(occs[i].trim()));
						if (infos[i] != null && infos[i].trim() != "")
							tesSlot.setInfo(infos[i]);
						tesSlot.setTesNodeId(node.getId());
						tesSlot.setOptUser((User) WebUtils.getSessionAttribute(
								request, SessionNames.LOGIN_USER));
						tesSlot.setTesNode(node);
						tesSlotList.add(tesSlot);
						tesSlotManager.add(tesSlot);
					}
				}
			node.setTesSlotList(tesSlotList);
			node.setOptUser((User) WebUtils.getSessionAttribute(request,
					SessionNames.LOGIN_USER));

			model.addAttribute("vo", tesNodeManager.update(node));
			addSuccess(model, "修改TES节点(" + node.getTesNodeCode() + ")成功");
			super.addLog(request, "修改TES节点(" + node.getTesNodeCode() + ")成功");

		} catch (Exception e) {
			e.printStackTrace();
			addError(model, "修改TES节点失败:" + e.getMessage());
		}
		return "basedata/tes/node/result";
	}

	@RequestMapping(value = "/del.do", method = RequestMethod.POST)
	public String processDelSubmit(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		try {
			String name = tesNodeManager.delete(id);
			addSuccess(model, "删除TES节点(" + name + ")成功");
			super.addLog(request, "删除TES节点(" + name + ")成功");
			// super.addLog(request, LogType.ROLEMNG, "删除角色(" + roleName +
			// ")成功");
		} catch (ServiceException e) {
			addError(model, "删除TES节点失败:" + e.getMessage());
		}
		return "basedata/tes/node/result";
	}

	@RequestMapping(value = "/view.do")
	public String view(@RequestParam("id") String id, Model model) {
		TesNode node = tesNodeManager.findById(id);
		// 业务信息
		TesServiceQueryModel qm = new TesServiceQueryModel();
		qm.setNodeId(id);
		model.addAttribute("serviceList", tesServiceManager.queryList(qm));
		// 用户定制
		if (node != null && node.getEquip() != null) {
			ClientEquipQueryModel clientEquipQueryModel = new ClientEquipQueryModel();
			clientEquipQueryModel.setEquipID(node.getEquip().getId());
			model.addAttribute("clientList", clientEquipService
					.queryClientByEquipID(clientEquipQueryModel));
		}
		model.addAttribute("pageModel", node);
		return "basedata/tes/node/view";
	}

	@RequestMapping(value = "/impexcel.do", method = RequestMethod.GET)
	public String impexcel(Model model,
			@ModelAttribute("fileModel") FileUploadModel fileModel) {
		return "basedata/tes/node/import";
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
			Vector<?> failedData = tesNodeManager.doExcelImport(fileModel,
					super.getCurrentUser(request));
			if (CollectionUtils.isEmpty(failedData) || failedData.size() == 1) {
				addSuccess(model, "导入TES节点成功!");
				super.addLog(request, "导入TES节点成功!");
			} else {
				super.addLog(request, "导入TES节点，部分记录导入失败!");
				model.addAttribute("failedData", failedData);
			}
			String regexCode = "^[A-Z0-9\\-]{3,10}$";
		} catch (ServiceException e) {
			addError(model, "导入失败：" + e.getMessage());
		}
		return "basedata/tes/node/import";
	}

	@RequestMapping(value = "/slot/impexcel.do", method = RequestMethod.GET)
	public String impexcelSlot(Model model,
			@ModelAttribute("fileModel") FileUploadModel fileModel) {
		return "basedata/tes/node/importSlot";
	}

	@RequestMapping(value = "/slot/impexcel.do", method = RequestMethod.POST)
	public String doImpExcelSlotPost(Model model, HttpServletRequest request,
			@ModelAttribute("fileModel") FileUploadModel fileModel) {
		try {
			Vector<?> failedData = tesSlotManager.doExcelImport(fileModel,
					super.getCurrentUser(request));
			if (CollectionUtils.isEmpty(failedData) || failedData.size() == 1) {
				addSuccess(model, "导入TESSlot成功!");
				super.addLog(request, "导入TESSlot成功!");
			} else {
				super.addLog(request, "导入TESSlot节点，部分记录导入失败!");
				// addError(model, "导入TESSlot，部分记录导入失败!");
				model.addAttribute("failedData", failedData);
			}
		} catch (ServiceException e) {
			addError(model, "导入失败：" + e.getMessage());
		}
		return "basedata/tes/node/importSlot";
	}

	@RequestMapping(value = "/expexcel.do")
	public void doExpExcel(Model model, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		TesNodeQueryModel queryModel = (TesNodeQueryModel) WebUtils
				.getSessionAttribute(request, tesNodeQueryModelName);// 获取session对象

		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition",
				"attachment;filename=TesNode.xls");

		File template = null;
		File dir = new File(ProjectFilePath.getProjectPath() + "template");
		if (dir != null && !ObjectUtils.isEmpty(dir.listFiles())) {
			for (File file : dir.listFiles()) {
				if (file.getName().contains("tesnode")) {
					template = file;
					break;
				}
			}
		}

		Workbook wb = null;
		OutputStream os = null;
		try {
			wb = tesNodeManager.exportExcel(template, queryModel);

			os = response.getOutputStream();
			wb.write(os);
			os.flush();
			response.flushBuffer();
			super.addLog(request, "导出TES节点成功!");
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