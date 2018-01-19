package cn.com.atnc.ioms.web.maintain.equipnode;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.maintain.equip.EquipNode;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.NetworkType;
import cn.com.atnc.ioms.enums.basedata.SubnetType;
import cn.com.atnc.ioms.mng.basedata.equip.IEquipService;
import cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager;
import cn.com.atnc.ioms.mng.maintain.equip.IEquipNodeManager;
import cn.com.atnc.ioms.mng.maintain.equip.IMaintainEquipManager;
import cn.com.atnc.ioms.model.basedata.EquipQueryModel;
import cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel;
import cn.com.atnc.ioms.model.maintain.equipnode.EquipNodeQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 节点配置控制器
 *
 * @author wangzhicheng
 * @date 2015-4-27 下午2:30:48
 * @since 1.0.0
 */
@Controller
@RequestMapping("/maintain/equipnode")
public class EquipNodeController extends MyBaseController {

	@Autowired
	private IEquipNodeManager equipNodeManager;
	@Autowired
	private IMaintainEquipManager maintainEquipManager;
	@Autowired
	private IEquipService equipService;
	@Autowired
	private IKuNodeManager kuNodeManager;

	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") EquipNodeQueryModel queryModel,
			HttpServletRequest request, Model model) {

		model.addAttribute("bureauList", Bureau.values());
		super.pageInfo(model, request);
		return "maintain/equipnode/manage";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") EquipNodeQueryModel queryModel,
			Model model, HttpSession session) {

		model.addAttribute("pagn", equipNodeManager.queryPage(queryModel));
		session.setAttribute("equipNodeQueryModel", queryModel);
		return "maintain/equipnode/queryResult";
	}

	/**
	 * 进入添加页面
	 *
	 * @param queryModel
	 * @param model
	 * @return
	 * @date 2015-5-6下午3:20:39
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String setupAddForm(
			@ModelAttribute("pageModel") EquipNodeQueryModel queryModel,
			Model model) {
		List<MaintainEquip> meli = maintainEquipManager.findAll();
		model.addAttribute("maintainEquips", meli);
		EquipQueryModel queryModel2 = new EquipQueryModel();
		// queryModel2.setBureau(Bureau.ZLXY);
		queryModel2.setType(NetworkType.KU);
		List<Equip> equipList = equipService.queryList(queryModel2);
		model.addAttribute("equips", equipList);
		// 子网类型
		model.addAttribute("subnetTypes", SubnetType.values());
		return "maintain/equipnode/add";
	}

	/**
	 * 执行添加
	 *
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return
	 * @date 2015-5-6下午3:20:53
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String processAddForm(
			@ModelAttribute("pageModel") EquipNodeQueryModel queryModel,
			HttpServletRequest request, Model model,
			@RequestParam("equipId") String equipId) {
		Equip equip = equipService.findById(equipId);
		queryModel.setEquip(equip);
		try {
			EquipNode equipNode = equipNodeManager.add(queryModel);
			model.addAttribute("vo", equipNode);
			addSuccess(model, "添加设备节点("
					+ equipNode.getMaintainEquip().getName() + ")成功");
			super.addLog(request, "添加设备节点("
					+ equipNode.getMaintainEquip().getName() + ")成功");
		} catch (ServiceException e) {
			addError(model, "添加设备节点:" + e.getMessage());
		}

		return "maintain/equipnode/result";
	}

	/**
	 * 执行删除
	 *
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 * @date 2015-5-6下午3:21:05
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/del.do", method = RequestMethod.POST)
	public String processDelSubmit(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {

		EquipNode equipNode = equipNodeManager.findById(id);
		MaintainEquip maintainEquip = maintainEquipManager.findById(equipNode
				.getMaintainEquip().getId());
		try {
			maintainEquip.setEquip(null);

			equipNodeManager.delete(equipNode);
			maintainEquipManager.update(maintainEquip);
			addSuccess(model, "删除设备节点("
					+ equipNode.getMaintainEquip().getName() + ")成功");
			super.addLog(request, "删除设备节点("
					+ equipNode.getMaintainEquip().getName() + ")成功");
		} catch (ServiceException e) {
			addError(model, "删除设备节点:" + e.getMessage());
		}

		return "maintain/equipnode/result";
	}

	/**
	 * 根据子网类型查询绑定节点
	 * 
	 * @author 段衍林
	 * @2017年1月4日 上午11:26:11
	 * @param model
	 *            model
	 * @param request
	 *            请求
	 * @param subnetType
	 *            子网类型
	 * @return String 返回地址
	 */
	@RequestMapping(value = "/ajaxEquip.dox", method = RequestMethod.GET)
	public String nodeStatChart(Model model, HttpServletRequest request,
			@ModelAttribute("queryModel") KuNodeQueryModel queryModel) {
		try {
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(kuNodeManager.queryList(queryModel)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			model.addAttribute("returnStr", "");
		}
		return "returnnote";
	}

	/**
	 * 根据id查询设备
	 * 
	 * @author 段衍林
	 * @2017年1月4日 上午11:26:11
	 * @param model
	 *            model
	 * @param request
	 *            请求
	 * @param equipId
	 *            设备id
	 * @return String 返回地址
	 */
	@RequestMapping(value = "/ajaxEquipName.dox", method = RequestMethod.GET)
	public String nodeStatChart(Model model, HttpServletRequest request,
			@RequestParam("equipId") String equipId) {
		try {
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(equipService.findById(equipId)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			model.addAttribute("returnStr", "");
		}
		return "returnnote";
	}

}
