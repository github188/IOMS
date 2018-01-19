package cn.com.atnc.ioms.web.maintain.equipmobile;

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

import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.ioms.entity.maintain.equipmobile.KuMobile;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.EquipType;
import cn.com.atnc.ioms.mng.basedata.equip.IEquipService;
import cn.com.atnc.ioms.mng.maintain.equipmobile.IKuMobileManager;
import cn.com.atnc.ioms.model.basedata.EquipQueryModel;
import cn.com.atnc.ioms.model.maintain.equipmobile.KuMobileModel;
import cn.com.atnc.ioms.model.maintain.equipmobile.KuMobileQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 设备绑定发短信手机号 控制类
 *
 * @author 段衍林
 * @2016年11月22日 上午10:18:31
 */
@Controller
@RequestMapping("/maintain/equipmobile/")
public class KuMoblieController extends MyBaseController {
	@Autowired
	private IKuMobileManager kuMobileManager;
	@Autowired
	private IEquipService equipService;

	/**
	 * 页面控制
	 * 
	 * @author 段衍林
	 * @2016年11月22日 上午10:31:51
	 * @param queryModel
	 * @param model
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") KuMobileQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		model.addAttribute("bureauList", Bureau.values());
		model.addAttribute("equipTypes", EquipType.values());
		return "maintain/equipmobile/manage";
	}

	/**
	 * 页面控制
	 * 
	 * @author 段衍林
	 * @2016年11月22日 上午10:32:00
	 * @param queryModel
	 * @param model
	 * @param session
	 * @return String
	 */
	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") KuMobileQueryModel queryModel,
			Model model, HttpSession session) {
		
		//封装查询条件
		EquipQueryModel qm = new EquipQueryModel();
		qm.setBureau(queryModel.getBureau());
		qm.setName(queryModel.getEquipName());
		model.addAttribute("equips",
				equipService.queryListGroup(qm));
		session.setAttribute("equipMobileQueryModel", queryModel);
		return "maintain/equipmobile/queryResult";
	}

	/**
	 * 配置
	 * 
	 * @author 段衍林
	 * @2016年11月22日 上午10:32:28
	 * @param kuMobileModel
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/config.do", method = RequestMethod.GET)
	public String setupAddForm(
			@ModelAttribute("pageModel") KuMobileQueryModel queryModel,
			Model model) {
		//查询列表
		List<KuMobile> kuMobiles = kuMobileManager.queryList(queryModel);
		//前台展示
		model.addAttribute("equipId", queryModel.getEquipId());
		model.addAttribute("kuMobiles", kuMobiles);
		return "maintain/equipmobile/config";
	}

	@RequestMapping(value = "/config.do", method = RequestMethod.POST)
	public String processAddForm(
			@ModelAttribute("pageModel") KuMobileModel kuMobileModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 保存新数据
			kuMobileManager.save(kuMobileModel);
			// 添加成功
			model.addAttribute("returnStr", new ResultModel(true, "记录添加成功",
					null).toJson());
		} catch (Exception e) {
			// 记录错误原因
			logger.error("添加记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(false, "记录添加失败",
					null).toJson());
		}
		return "returnnote";
	}
}
