package cn.com.atnc.ioms.web.tempcircuit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuit;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuitAtmMplsVpn;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitMplsVpnRouterType;
import cn.com.atnc.ioms.mng.tempcircuit.ITempCircuitAtmMplsVpnMngService;
import cn.com.atnc.ioms.mng.tempcircuit.ITempCircuitMngService;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 
 * 类说明：atmmplsvpn类型电路明细Controller
 * 
 * @author: 局域网_王鹏
 * @time: 2014年4月25日下午12:54:07
 * @version:1.0
 */
@Controller("tempCircuitAtmMplsVpnController")
@RequestMapping("/tempcircuit/atmmplsvpn/")
public class TempCircuitAtmMplsVpnController extends MyBaseController {
	@Autowired
	private ITempCircuitMngService tempCircuitMngService;
	@Autowired
	private ITempCircuitAtmMplsVpnMngService tempCircuitAtmMplsVpnMngService;

	/**
	 * 
	 * 方法说明：增加atmmplsvpn类型电路明细GET
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月25日下午12:54:17
	 * @param node
	 * @param model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String setupAddForm(
			@RequestParam("tempcircuitid") String tempcircuitid,
			@ModelAttribute("pageModel") TempCircuitAtmMplsVpn node, Model model) {
		logger.debug("tempcircuitid:" + tempcircuitid);
		TempCircuit tempcircuit = tempCircuitMngService
				.getTempCircuitByID(tempcircuitid);
		node.setTempCircuit(tempcircuit);
		node.setName(tempcircuit.getaEquip().getCode());
		model.addAttribute("routerTypes", CircuitMplsVpnRouterType.values());
		return "tempcircuit/atmmplsvpn/add";
	}

	/**
	 * 
	 * 方法说明：增加atmmplsvpn类型电路明细POST
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月25日下午12:54:20
	 * @param node
	 * @param request
	 * @param model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String processAddForm(
			@ModelAttribute("pageModel") TempCircuitAtmMplsVpn node,
			HttpServletRequest request, Model model) {
		TempCircuit tempCircuit = tempCircuitMngService.getTempCircuitByID(node
				.getTempCircuit().getId());
		try {
			model.addAttribute("returnStr", new ResultModel(true, "",
					tempCircuitAtmMplsVpnMngService.add(node)));
			addSuccess(model, "添加业务电路明细(" + node.getBusinessName() + ")成功");
			super.addLog(request, "网控工程师配置电路明细 " + tempCircuit.getNumber()
					+ " 成功！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			model.addAttribute("returnStr", new ResultModel(false, "", node));
			addError(model, "添加业务电路明细失败:" + e.getMessage());
			super.addLog(request, "网控工程师配置电路明细 " + tempCircuit.getNumber()
					+ " 失败！");
		}
		return "returnnote";
	}

	/**
	 * 
	 * 方法说明：修改atmmplsvpn类型电路明细GET
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月25日下午12:54:23
	 * @param id
	 * @param request
	 * @param model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/mod.do", method = RequestMethod.GET)
	public String setupModForm(
			@RequestParam("tempcircuitid") String tempcircuitid,
			@ModelAttribute("pageModel") TempCircuitAtmMplsVpn node,
			HttpServletRequest request, Model model) {
		try {
			model.addAttribute("pageModel", tempCircuitAtmMplsVpnMngService
					.getTempCircuitAtmMplsVpnByTempcircuitID(tempcircuitid));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			addError(model, "获取业务电路明细失败:" + e.getMessage());
		}
		return "tempcircuit/atmmplsvpn/mod";
	}

	/**
	 * 
	 * 方法说明：修改atmmplsvpn类型电路明细POST
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月25日下午12:54:26
	 * @param node
	 * @param request
	 * @param model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	public String porcessModForm(
			@ModelAttribute("pageModel") TempCircuitAtmMplsVpn node,
			HttpServletRequest request, Model model) {
		TempCircuit tempCircuit = tempCircuitMngService.getTempCircuitByID(node
				.getTempCircuit().getId());
		try {
			model.addAttribute("returnStr", new ResultModel(true, "",
					tempCircuitAtmMplsVpnMngService.update(node)));
			addSuccess(model, "修改业务电路明细(" + node.getBusinessName() + ")成功");
			super.addLog(request, "网控工程师修改电路明细 " + tempCircuit.getNumber()
					+ " 成功！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			model.addAttribute("returnStr", new ResultModel(false, "", node));
			addError(model, "修改业务电路明细失败:" + e.getMessage());
			super.addLog(request, "网控工程师修改电路明细 " + tempCircuit.getNumber()
					+ " 失败！");
		}
		return "returnnote";
	}

	/**
	 * 
	 * 方法说明：查看atmmplsvpn类型电路明细
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月25日下午12:54:30
	 * @param id
	 * @param model
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/view.do")
	public String view(HttpServletRequest request,
			@RequestParam("tempcircuitid") String tempcircuitid, Model model) {
		try {
			TempCircuit tempCircuit = tempCircuitMngService
					.getTempCircuitByID(tempcircuitid);
			model.addAttribute("tempCircuit", tempCircuit);
			model.addAttribute(
					"tempcircuitDetail",
					tempCircuitAtmMplsVpnMngService
							.getTempCircuitAtmMplsVpnByTempcircuitID(tempcircuitid));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			addError(model, "获取业务电路明细失败:" + e.getMessage());
		}
		return "tempcircuit/atmmplsvpn/view";
	}

}
