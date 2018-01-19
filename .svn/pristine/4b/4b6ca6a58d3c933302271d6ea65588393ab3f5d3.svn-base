package cn.com.atnc.ioms.web.maintain.kucircuit;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.ku.KuService;
import cn.com.atnc.ioms.entity.maintain.circuit.EquipCircuit;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.KuServiceRateType;
import cn.com.atnc.ioms.mng.basedata.ku.IKuServiceManager;
import cn.com.atnc.ioms.mng.maintain.circuit.IMaintainCircuitManager;
import cn.com.atnc.ioms.mng.maintain.equip.IMaintainEquipManager;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

 /**
 * 此处添加类KuCircuitController的描述信息
 *
 * @author wangzhicheng
 * @date 2015-4-30 下午2:38:23
 * @since 1.0.0
 */
@Controller
@RequestMapping("/maintain/kucircuit")
public class KuCircuitController extends MyBaseController{
	@Autowired
	private IKuServiceManager kuServiceManager;
	@Autowired
	private IMaintainEquipManager maintainEquipManager;
	@Autowired
	private IMaintainCircuitManager maintainCircuitManager;

	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") KuStatQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		model.addAttribute("kuServiceRateTypes", KuServiceRateType.values());
		return "maintain/kucircuit/manage";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") KuStatQueryModel queryModel,
			Model model, HttpSession session) {
		model.addAttribute("pagn", maintainCircuitManager.queryPage(queryModel));
		session.setAttribute("kuServiceQueryModel", queryModel);
		return "maintain/kucircuit/queryResult";
	}

	/**
	 * 添加页面,获取指定维保设备下的KU参数
	 * @param equipCircuit
	 * @param model
	 * @author WangLingbin
	 * @date  2016年5月4日下午2:55:05
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String setupAddForm(@ModelAttribute("pageModel") EquipCircuit equipCircuit,
			Model model) {
		model.addAttribute("bureaus", Bureau.values());
		List<MaintainEquip> maintainEquips = maintainEquipManager.queryWAFList();
		List<EquipCircuit> equipCircuits = maintainCircuitManager.findAll();
		for(int i = 0;i < equipCircuits.size();i++){
			for(int j = 0;j < maintainEquips.size();j++){
				if(maintainEquips.get(j).getId().equals(equipCircuits.get(i).getEquip().getId())){
					maintainEquips.remove(j);
					break;
				}
			}
		}
		//如果维保设备列表不为空
		if(!CollectionUtils.isEmpty(maintainEquips)) {
			model.addAttribute("equips", maintainEquips);
			//根据维保设备获取KU相关参数
			Map<String, Object> map = kuServiceManager.getKuParams(maintainEquips.get(0));
			if(!CollectionUtils.isEmpty(map)) {
				for(Entry<String, Object> entry : map.entrySet()) {
					model.addAttribute(entry.getKey(), entry.getValue());
				}
			}
		}
		model.addAttribute("kuServiceRateTypes", KuServiceRateType.values());
		return "maintain/kucircuit/add";
	}

	/**
	 * 维保设备下拉框改变时出发的事件
	 * @param model
	 * @param id
	 * @author WangLingbin
	 * @date  2016年5月4日下午2:59:55
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/changeMaintainEquip.dox", method = RequestMethod.GET)
	public String changeMaintainEquip(Model model,
			@RequestParam(value = "id", required = true) String id) {
		//根据ID查找维保设备实体
		MaintainEquip maintainEquip = maintainEquipManager.findById(id);
		//根据维保设备获取KU相关参数
		Map<String, Object> map = kuServiceManager.getKuParams(maintainEquip);
		//model.addAttribute("returnStr", map);
		model.addAttribute("returnStr", JSONArray.fromObject(map));
		return "returnnote";
	}
	
	/**
	 * 读取数据
	 * @author WangLingbin
	 * @date  2016年5月3日下午3:28:42
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/readData.dox", method = RequestMethod.GET)
	public String readData(Model model,
			@RequestParam(value = "txNodeNo",required = false) String txNodeNo,
			@RequestParam(value = "rxNodeNo",required = false) String rxNodeNo,
			@RequestParam(value = "txGib",required = false) String txGib,
			@RequestParam(value = "rxGib",required = false) String rxGib,
			@RequestParam(value = "txChan",required = false) String txChan,
			@RequestParam(value = "rxChan",required = false) String rxChan) {
		//保存错误的信息提示
		StringBuilder msg = new StringBuilder();
		//查询对象
		KuStatQueryModel kuStatQueryModel = new KuStatQueryModel();
		if(StringUtils.isEmpty(txNodeNo)) {
			msg.append("发端节点号,");
		} else {
			kuStatQueryModel.setTxNodeNo(txNodeNo);
		}
		if(StringUtils.isEmpty(rxNodeNo)) {
			msg.append("收端节点号,");
		} else {
			kuStatQueryModel.setRxNodeNo(rxNodeNo);
		}
		if(StringUtils.isEmpty(txGib)) {
			msg.append("发端槽号,");
		} else {
			kuStatQueryModel.setTxGib(txGib);
		}
		if(StringUtils.isEmpty(txChan)) {
			msg.append("发端端口号,");
		} else {
			kuStatQueryModel.setTxChan(txChan);
		}
		if(StringUtils.isEmpty(rxGib)) {
			msg.append("收端槽号,");
		} else {
			kuStatQueryModel.setRxGib(rxGib);
		}
		if(StringUtils.isEmpty(rxChan)) {
			msg.append("收端端口号,");
		} else {
			kuStatQueryModel.setRxChan(rxChan);
		}
		//若参数为空，则返回错误信息
		if(StringUtils.isNotEmpty(msg.toString())) {
			model.addAttribute("returnStr", msg.substring(0, msg.lastIndexOf(",")) + "不能为空。");
			return "returnnote";
		}
		//返回查询到的实体
		List<KuService> kuServices = kuServiceManager.queryList(kuStatQueryModel);
		if(!CollectionUtils.isEmpty(kuServices)) {
			//System.err.println(kuServices.size());
			model.addAttribute("returnStr", kuServices.get(0));
		} else {
			model.addAttribute("returnStr", "");
		}
		return "returnnote";
	}
	
	
	/**
	 * 执行添加方法（此处只进行设备的绑定，不执行新增）
	 * @param equipCircuit
	 * @param request
	 * @param model
	 * @author WangLingbin
	 * @date  2016年5月4日下午1:40:29
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String processAddForm(
			@ModelAttribute("pageModel") EquipCircuit equipCircuit,
			HttpServletRequest request, Model model) {
		MaintainEquip maintainEquip = maintainEquipManager.findById(equipCircuit.getEquip().getId());
		try {
			equipCircuit.getKuService().setOptUser((User) WebUtils.getSessionAttribute(request,
					SessionNames.LOGIN_USER));
			//kuServiceManager.add(equipCircuit.getKuService());
			//通过页面读取出来的KuService的参数，去数据库中查找对应实体
			KuService kuService = equipCircuit.getKuService();
			KuStatQueryModel kuStatQueryModel = new KuStatQueryModel();
			kuStatQueryModel.setRxNodeNo(kuService.getRxNodeNo());
			kuStatQueryModel.setRxGib(kuService.getRxGib());
			kuStatQueryModel.setRxChan(kuService.getRxChan());
			kuStatQueryModel.setTxNodeNo(kuService.getTxNodeNo());
			kuStatQueryModel.setTxGib(kuService.getTxGib());
			kuStatQueryModel.setTxChan(kuService.getTxChan());
			List<KuService> kuServices = kuServiceManager.queryList(kuStatQueryModel);
			if(!CollectionUtils.isEmpty(kuServices)) {
				//更新用途和配置时间
				String usage = kuService.getUsage();
				String configTime = kuService.getConfigTime();
				//绑定到设备电路中
				kuService = kuServices.get(0);
				kuService.setUsage(usage);
				kuService.setConfigTime(configTime);
				equipCircuit.setKuService(kuService);
			}
			equipCircuit.setEquip(maintainEquip);
			maintainCircuitManager.add(equipCircuit);
			model.addAttribute("vo", equipCircuit);
			addSuccess(model, "添加设备节点配置(" + equipCircuit.getKuService().getCode() + ")成功");
			super.addLog(request, "添加设备节点配置(" + equipCircuit.getKuService().getCode() + ")成功");
		} catch (ServiceException e) {
			addError(model, "添加设备节点配置失败:" + e.getMessage());
		}
		return "maintain/kucircuit/result";
	}

	/**
	 * 进入修改页面
	 *
	 * @param id
	 * @param request
	 * @param model
	 * @return 
	 * @date  2015-5-6下午3:26:12
	 * @since 1.0.0
	*/
	@RequestMapping(value = "/mod.do", method = RequestMethod.GET)
	public String setupModForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		EquipCircuit EquipCircuit = maintainCircuitManager.findById(id);
		KuService kuService = kuServiceManager.findById(EquipCircuit.getKuService().getId());
		EquipCircuit.setKuService(kuService);
		model.addAttribute("pageModel", EquipCircuit);
		List<MaintainEquip> meli = maintainEquipManager.queryWAFList();
		List<EquipCircuit> ecli = maintainCircuitManager.findAll();
		for(int i=0;i<ecli.size();i++){
			for(int j=0;j<meli.size();j++){
				if(meli.get(j).getId().equals(ecli.get(i).getEquip().getId())){
					meli.remove(j);
					break;
				}
			}
		}
		model.addAttribute("equips", meli);
		model.addAttribute("equips", maintainEquipManager.queryWAFList());
		model.addAttribute("kuServiceRateTypes", KuServiceRateType.values());
		return "maintain/kucircuit/mod";
	}

	/**
	 * 执行修改方法
	 *
	 * @param equipCircuit
	 * @param request
	 * @param model
	 * @return 
	 * @date  2015-5-6下午3:26:28
	 * @since 1.0.0
	*/
	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	public String porcessModForm(
			@ModelAttribute("pageModel") EquipCircuit equipCircuit,
			HttpServletRequest request, Model model) {
		try {
			equipCircuit.getKuService().setOptUser((User) WebUtils.getSessionAttribute(request,
					SessionNames.LOGIN_USER));
			KuService kuService = kuServiceManager.update(equipCircuit.getKuService());
			equipCircuit.setKuService(kuService);
			maintainCircuitManager.update(equipCircuit);
			addSuccess(model, "修改设备节点配置(" + equipCircuit.getKuService().getCode() + ")成功");
			super.addLog(request, "修改设备节点配置(" + equipCircuit.getKuService().getCode() + ")成功");
			model.addAttribute("vo", equipCircuit);
		} catch (Exception e) {
			addError(model, "修改设备节点配置失败:" + e.getMessage());
		}
		return "maintain/kucircuit/result";
	}

	/**
	 * 删除操作
	 *
	 * @param id
	 * @param request
	 * @param model
	 * @return 
	 * @date  2015-5-6下午3:26:38
	 * @since 1.0.0
	*/
	@RequestMapping(value = "/del.do", method = RequestMethod.POST)
	public String processDelSubmit(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		EquipCircuit equipCircuit = maintainCircuitManager.findById(id);
		try {
			String ksid = equipCircuit.getKuService().getId();
			KuService kuService = kuServiceManager.findById(ksid);
			maintainCircuitManager.delete(equipCircuit);
			String name = kuService.getCode();
			addSuccess(model, "删除设备节点配置(" + name + ")成功");
			super.addLog(request, "删除设备节点配置(" + name + ")成功");
		} catch (Exception e) {
			addError(model, "删除设备节点配置失败:" + e.getMessage());
		}
		return "maintain/kucircuit/result";
	}

	/**
	 * 进入详情页面
	 *
	 * @param id
	 * @param model
	 * @return 
	 * @date  2015-5-6下午3:26:54
	 * @since 1.0.0
	*/
	@RequestMapping(value = "/view.do")
	public String view(@RequestParam("id") String id, Model model) {
		model.addAttribute("pageModel", maintainCircuitManager.findById(id));
		return "maintain/kucircuit/view";
	}
}
