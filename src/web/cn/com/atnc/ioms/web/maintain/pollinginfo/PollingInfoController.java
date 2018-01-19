package cn.com.atnc.ioms.web.maintain.pollinginfo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.maintain.circuit.EquipCircuit;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.Wafr08Port0Stat;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.mng.basedata.equip.IEquipService;
import cn.com.atnc.ioms.mng.maintain.circuit.IMaintainCircuitManager;
import cn.com.atnc.ioms.mng.maintain.pollinginfo.KuCarrierFreqManager;
import cn.com.atnc.ioms.mng.maintain.pollinginfo.KuNodeParameterManager;
import cn.com.atnc.ioms.mng.maintain.pollinginfo.OduPollingInfoManager;
import cn.com.atnc.ioms.mng.maintain.pollinginfo.PollingInfoManager;
import cn.com.atnc.ioms.mng.maintain.pollinginfo.Wafr08Port0StatManager;
import cn.com.atnc.ioms.mng.systemmng.param.ISystemConfigManager;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

 /**
 * 告警信息控制器
 *
 * @author wangzhicheng
 * @date 2015-4-27 下午2:30:48
 * @since 1.0.0
 */
@Controller("pollingInfoController")
@RequestMapping("/maintain/pollinginfo/")
public class PollingInfoController extends MyBaseController{
	
	@Autowired
	private KuCarrierFreqManager kuCarrierFreqManager;
	@Autowired
	private PollingInfoManager pollingInfoManager;
	@Autowired
	private OduPollingInfoManager oduPollingInfoManager;
	@Autowired
	private KuNodeParameterManager kuNodeParameterManager;
	@Autowired
	private Wafr08Port0StatManager wafr08Port0StatManager;
	@Autowired
	private IMaintainCircuitManager maintainCircuitManager;
	@Autowired
	private IEquipService equipService;
	@Autowired
	@Qualifier(value = "SystemConfigDBManagerImpl")
	private ISystemConfigManager systemConfigManager;
	
	
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") PollingInfoQueryModel queryModel,
			HttpServletRequest request, Model model) {
		model.addAttribute("bureauList", Bureau.values());
		super.pageInfo(model, request);
		return "maintain/pollinginfo/manage";
	}

	/**
	 * 操作tab页
	 *
	 * @param queryModel
	 * @param optType
	 * @param request
	 * @param model
	 * @param session
	 * @return
	 * @throws ServiceException 
	 * @date  2015-5-4下午2:53:02
	 * @since 1.0.0
	*/
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(@ModelAttribute("queryModel") PollingInfoQueryModel queryModel,
			@RequestParam("optType")String optType,HttpServletRequest request, Model model, HttpSession session) throws ServiceException {

		String stname = queryModel.getStname();
		if(StringUtils.contains(stname, "%")){
			stname = stname.replace("%", "\\%");
		}
		if (StringUtils.contains(stname, "_")) {
			stname = stname.replace("_", "\\_");
		}
		queryModel.setStname(stname);
		switch (optType==null?"":optType) {
		
		case "KCFM":
			//KU节点载波频率
			model.addAttribute("message","KCFM");
			Pagination p = kuCarrierFreqManager.queryPage(queryModel);
			model.addAttribute("pagn", p);
			return "maintain/pollinginfo/kucarrierfreq/queryResult";

		case "KUST":
			//KU节点运行状态
			model.addAttribute("message","KUST");
			model.addAttribute("pagn", pollingInfoManager.queryPage(queryModel));
			//存放卫星采集参数，用于比较rxlevel和ebnb
			model.addAttribute("satelparam", systemConfigManager.getModel());
			session.setAttribute("pollingQueryModel", queryModel);
			return "maintain/pollinginfo/kurunningstatus/queryResult";

		case "ODU":
			//ODU
			model.addAttribute("message","ODU");
			model.addAttribute("pagn", oduPollingInfoManager.queryPage(queryModel));
			session.setAttribute("pollingQueryModel", queryModel);
			return "maintain/pollinginfo/odupolling/queryResult";

		case "KUNC":
			//KU节点参数
			model.addAttribute("message","KUNC");
			model.addAttribute("pagn", kuNodeParameterManager.queryPage(queryModel));
			session.setAttribute("pollingQueryModel", queryModel);
			return "maintain/pollinginfo/kunodeparameter/queryResult";

		case "KUTS":
			//KU电路配置
			model.addAttribute("message","KUTS");
			List<Wafr08Port0Stat> wpsli = (List<Wafr08Port0Stat>) wafr08Port0StatManager.queryPage(queryModel).getResult();
			List<EquipCircuit> ecli = maintainCircuitManager.findAll();
			List<PollingInfoQueryModel> pqmli = new ArrayList<>();
			for(int i=0;i<wpsli.size();i++){
				int flag = 0; 
				PollingInfoQueryModel pollingInfoQueryModel = new PollingInfoQueryModel();
				
				for(int j=0;j<ecli.size();j++){
					
					String equipid = wpsli.get(i).getEquipId().getId();
					pollingInfoQueryModel.setWafr08Port0Stat(wpsli.get(i));
					
					if(equipid.equals(ecli.get(j).getEquip().getId())){
						pollingInfoQueryModel.setEquipCircuit(ecli.get(j));
						pqmli.add(pollingInfoQueryModel);
						flag++;
					}
				}
				if(flag == 0){
					EquipCircuit equipCircuit = new EquipCircuit();
					pollingInfoQueryModel.setEquipCircuit(equipCircuit);
					pqmli.add(pollingInfoQueryModel);
				}
			}
			Pagination wpspage = wafr08Port0StatManager.queryPage(queryModel);
			wpspage.setResult(pqmli);
			model.addAttribute("pagn", wpspage);
			session.setAttribute("pollingQueryModel", queryModel);
			return "maintain/pollinginfo/circuitpolling/queryResult";

		default:
			//KU节点载波频率
			model.addAttribute("message","KCFM");
			Pagination p2 = kuCarrierFreqManager.queryPage(queryModel);
			model.addAttribute("pagn", p2);
			return "maintain/pollinginfo/kucarrierfreq/queryResult";
		}
	}
	
	/**
	 * KU节点载波频率详情
	 *
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return 
	 * @date  2015-4-30上午11:35:56
	 * @since 1.0.0
	*/
	@RequestMapping(value = "/kucarrierfreqview.do", method = RequestMethod.GET)
	public String kucarrierfreqview(@RequestParam("equipId") String equipId,
			@ModelAttribute("queryModel") PollingInfoQueryModel queryModel,
			HttpServletRequest request, Model model) {
		return "maintain/pollinginfo/kucarrierfreq/view";
	}
	
	@RequestMapping(value = "/kucarrierfreqview.do",method=RequestMethod.POST)
	public String kucarrierfreqview2(
			@ModelAttribute("queryModel") PollingInfoQueryModel queryModel,
			HttpServletRequest request, Model model) throws ServiceException {
		model.addAttribute("pagn", kuCarrierFreqManager.queryViewPage(queryModel));
		return "maintain/pollinginfo/kucarrierfreq/viewResult";
	}
	
	/**
	 * KU节点参数详情
	 *
	 * @param id
	 * @param model
	 * @param session
	 * @return
	 * @throws ServiceException 
	 * @date  2015-5-4下午2:52:29
	 * @since 1.0.0
	*/
	@RequestMapping(value = "/kunodeparameterview.do")
	public String kunodeparameterview(@RequestParam("id") String id, Model model, HttpSession session) throws ServiceException {
		
		model.addAttribute("pageModel", kuNodeParameterManager.findById(id));
		
		return "maintain/pollinginfo/kunodeparameter/view";
	}
	
	/**
	 * ODU详情
	 *
	 * @param id
	 * @param model
	 * @param session
	 * @return
	 * @throws ServiceException 
	 * @date  2015-5-4下午2:52:44
	 * @since 1.0.0
	*/
	@RequestMapping(value = "/oduview.do")
	public String oduview(@RequestParam("id") String id, Model model, HttpSession session) throws ServiceException {
		
		model.addAttribute("pageModel", oduPollingInfoManager.findById(id));
		
		return "maintain/pollinginfo/odupolling/view";
	}
}
