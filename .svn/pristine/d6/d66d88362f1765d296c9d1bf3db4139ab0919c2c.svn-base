package cn.com.atnc.ioms.web.basedata.atm.node;



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
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.enums.basedata.AtmBureau;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.mng.basedata.atm.node.IAtmNodeManager;
import cn.com.atnc.ioms.model.basedata.atm.node.AtmNodeQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

@Controller
@RequestMapping("/basedata/atm/node")
public class AtmNodeController extends MyBaseController {
	@Autowired
	private IAtmNodeManager atmNodeManager;

	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") AtmNodeQueryModel queryModel,
			Model model, HttpServletRequest request) {
		//model.addAttribute("bureaus",Bureau.ZBAA.toATMBureau());//
		model.addAttribute("bureaus", AtmBureau.values());
		super.pageInfo(model, request);
		return "basedata/atm/node/manage";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") AtmNodeQueryModel queryModel,
			Model model, HttpSession session) {
		model.addAttribute("pagn", this.atmNodeManager.queryPage(queryModel));
		session.setAttribute("atmNodeQueryModel", queryModel);
		return "basedata/atm/node/queryResult";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String setupAddForm(@ModelAttribute("pageModel") AtmNode node,
			Model model) {
		model.addAttribute("bureaus", Bureau.values());
		//model.addAttribute("equipTypes", EquipType.values());
		return "basedata/atm/node/add";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String processAddForm(@ModelAttribute("pageModel") AtmNode node,
			HttpServletRequest request, Model model) {
		try {
			model.addAttribute("vo", atmNodeManager.add(node));
			addSuccess(model, "添加ATM节点(" + node.getAtmNodeCode() + ")成功");
			super.addLog(request, "添加ATM节点(" + node.getAtmNodeCode() + ")成功");
		} catch (ServiceException e) {
			addError(model, "添加ATM节点失败:" + e.getMessage());
		}
		return "basedata/atm/node/result";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.GET)
	public String setupModForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		model.addAttribute("pageModel", atmNodeManager.findById(id));
		model.addAttribute("bureaus", Bureau.values());
		return "basedata/atm/node/mod";
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	public String porcessModForm(@ModelAttribute("pageModel") AtmNode node,
			HttpServletRequest request, Model model) {
		try {
			model.addAttribute("vo", atmNodeManager.update(node));
			addSuccess(model, "修改ATM节点(" + node.getAtmNodeCode() + ")成功");
			super.addLog(request, "修改ATM节点(" + node.getAtmNodeCode() + ")成功");
		} catch (Exception e) {
			e.printStackTrace();
			addError(model, "修改ATM节点失败:" + e.getMessage());
		}
		return "basedata/atm/node/result";
	}

	@RequestMapping(value = "/del.do", method = RequestMethod.POST)
	public String processDelSubmit(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		try {
			String name = atmNodeManager.delete(id);
			addSuccess(model, "删除ATM节点(" + name + ")成功");
			super.addLog(request, "删除ATM节点(" + name + ")成功");
		} catch (ServiceException e) {
			addError(model, "删除ATM节点失败:" + e.getMessage());
		}
		return "basedata/atm/node/result";
	}

	@RequestMapping(value = "/view.do")
	public String view(@RequestParam("id") String id, Model model) {
		model.addAttribute("pageModel", atmNodeManager.findById(id));
		return "basedata/atm/node/view";
	}

	@RequestMapping(value = "/impexcel.do", method = RequestMethod.GET)
	public String impexcel(Model model,
			@ModelAttribute("fileModel") FileUploadModel fileModel) {
		return "basedata/atm/node/import";
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
			Vector<?> failedData = atmNodeManager.doExcelImport(fileModel,
					super.getCurrentUser(request));
			if (CollectionUtils.isEmpty(failedData) || failedData.size() == 1) {
				addSuccess(model, "导入ATM节点成功!");
				super.addLog(request, "导入ATM节点成功!");
			} else {
				super.addLog(request, "导入部分ATM节点!");
				model.addAttribute("failedData", failedData);
			}
		} catch (ServiceException e) {
			addError(model, "导入失败：" + e.getMessage());
		}
		return "basedata/atm/node/import";
	}

	@RequestMapping(value = "/expexcel.do")
	public void doExpExcel(Model model, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		AtmNodeQueryModel queryModel=(AtmNodeQueryModel) WebUtils.getSessionAttribute(request,
				"atmNodeQueryModel");//获取session对象
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition", "attachment;filename=AtmNode.xls");

		File template = null;
		File dir = new File(ProjectFilePath.getProjectPath() + "template");
		if (dir != null && !ObjectUtils.isEmpty(dir.listFiles())) {
			for (File file : dir.listFiles()) {
				if (file.getName().contains("atmnode")) {
					template = file;
					break;
				}
			}
		}

		Workbook wb = null;
		OutputStream os = null;
		try {
			wb = this.atmNodeManager.exportExcel(queryModel,template);
			os = response.getOutputStream();
			wb.write(os);
			os.flush();
			response.flushBuffer();
			super.addLog(request, "导出ATM节点成功!");
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
