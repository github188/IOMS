/**
 * 
 */
package cn.com.atnc.ioms.web.operstat.atm.networkstat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService;
import cn.com.atnc.ioms.model.operstat.atm.AtmAlarmDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmAlarmModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareDealQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * Atm网络统计跳转控制类
 * @author：KuYonggang
 * @date：2014-5-20下午7:27:21
 * @version：1.0
 */
@Controller("networkStatController")
@RequestMapping("/networkstat/")
public class NetworkStatController extends MyBaseController {
	
	@Autowired
	private INetworkStatService networkStatService;

	/**
	 * Atm网络统计页面初始化
	 * @author：KuYonggang
	 * @date：2014-6-19下午6:02:32
	 * @param：
	 * @return：String
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") FaultDeclareDealQueryModel queryModel,
			HttpServletRequest request, Model model) {
		super.pageInfo(model, request);
		return "operstat/atm/networkstat/manage";
	}

	/**
	 * ATM数据网全网告警统计
	 * @author：KuYonggang
	 * @date：2014-5-21下午6:29:33
	 * @return：String
	 */
	@RequestMapping(value = "atmAlarm.dox", method = RequestMethod.GET)
	public String resultAtmAlarm(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
		model.addAttribute("pagn",
				networkStatService.queryAtmAlarmDBTbModelsByModel(queryModel));
		return "operstat/atm/networkstat/atmalarm/queryResult";
	}

	@RequestMapping(value = "initAtmAlarm.dox")
	public String initAtmAlarm(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
		try {
			List<AtmAlarmModel> alarmModels = new ArrayList<AtmAlarmModel>();
			List<AtmAlarmDBModel> list = networkStatService
					.queryListByModel(queryModel);
			for (AtmAlarmDBModel atmAlarmBaseModel : list) {
				// System.out.println(atmAlarmBaseModel.getBureau()+"->"+atmAlarmBaseModel.getCritical()+"->"+atmAlarmBaseModel.getMajor()+"->"+atmAlarmBaseModel.getMinor());
				AtmAlarmModel alarmModel = new AtmAlarmModel();
				Bureau bureau = atmAlarmBaseModel.getBureau();
				String bureauName = bureau.getName(); // ZWWW
				String bureauValue = bureau.getValue(); // 新疆
				alarmModel.setValue(bureauName);
				alarmModel.setName(bureauValue); // 前台饼状图中显示的名字为json字符串中的name的值，例如：新疆
				alarmModel.setCritical(atmAlarmBaseModel.getCritical());
				alarmModel.setMajor(atmAlarmBaseModel.getMajor());
				alarmModel.setMinor(atmAlarmBaseModel.getMinor());
				alarmModel.setY(atmAlarmBaseModel.getCritical()
						+ atmAlarmBaseModel.getMajor()
						+ atmAlarmBaseModel.getMinor());
				alarmModels.add(alarmModel);
			}
			// System.out.println(JacksonTools.toJsonStr(alarmModels));
			model.addAttribute("returnStr", JacksonTools.toJsonStr(alarmModels));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "returnnote";
	}

	@RequestMapping(value = "atmAlarmDetail.dox", method = RequestMethod.GET)
	public String atmAlarmDetail(
			@ModelAttribute("pageModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
		//queryModel.setAlarmFlag(true);
		model.addAttribute("atmpagn",
				networkStatService.queryAtmAlarmListByModel(queryModel));
		model.addAttribute("envpagn",
				networkStatService.queryEnvAlarmListByModel(queryModel));
		model.addAttribute("cardpagn",
				networkStatService.queryCardAlarmListByModel(queryModel));
		model.addAttribute("servicepagn",
				networkStatService.queryServiceAlarmListByModel(queryModel));

		return "operstat/atm/networkstat/atmalarm/atmAlarmDetail";
	}

	@RequestMapping(value = "atmAlarmDetail.dox", method = RequestMethod.POST)
	public String atmAlarmPartDetail(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) throws IOException {
		model.addAttribute("returnStr", JacksonTools
				.toJsonStr(networkStatService
						.queryAtmAlarmListByModel(queryModel)));
		// System.out.println(JacksonTools.toJsonStr(networkStatService.queryAtmAlarmPageByModel(queryModel)));
		return "returnnote";
	}
	
	@RequestMapping(value="getAtmCardAlarmDetail.dox",method=RequestMethod.GET)
	public String atmCardAlarmDetailMain(@ModelAttribute("queryModel")NetworkStatQueryModel queryModel,Model model,HttpServletRequest request) throws IOException{
		return "operstat/atm/networkstat/atmalarm/atmCardAlarmDetailManage";
	}
	@RequestMapping(value="getAtmCardAlarmDetail.dox",method=RequestMethod.POST)
	public String getAtmCardAlarmDetail(@ModelAttribute("queryModel")NetworkStatQueryModel queryModel,Model model,HttpServletRequest request) throws IOException{
		queryModel.setAlarmFlag(true);
		model.addAttribute("pagn", networkStatService.queryAtmCardAlarmDetailPage(queryModel));
		return "operstat/atm/networkstat/atmalarm/detailQueryResult";
	}
	/**
	 * ATM数据网全网业务统计
	 * @author：KuYonggang
	 * @date：2014-5-21下午6:29:33
	 * @return：String
	 */
	@RequestMapping(value = "initAtmService.dox")
	public String initAtmService(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
		try {
		//	System.out.println("------------------------"+queryModel.getBureau());
			model.addAttribute("returnStr", JacksonTools
					.toJsonStr(networkStatService
							.queryAtmServiceDBListByModel(queryModel)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "returnnote";
	}
	
	@RequestMapping(value = "atmService.dox")
	public String atmService(@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
		model.addAttribute("pagn",
				networkStatService.queryAtmServiceDBListByModel(queryModel));
		return "operstat/atm/networkstat/atmservice/queryResult";
	}
	
	@RequestMapping(value = "detail.dox", method = RequestMethod.GET)
	public String setupAtmService(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
		return "operstat/atm/networkstat/atmservice/detailManage";
	}

	@RequestMapping(value = "detail.dox", method = RequestMethod.POST)
	public String viewAtmService(@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model)throws IOException {
		String serviceTypeStr = new String(queryModel.getServiceType().getBytes(this.ISO8859),
				"UTF-8");
		queryModel.setServiceType(serviceTypeStr);
		String localNodeName = queryModel.getLocalNodeName();
		if(StringUtils.contains(localNodeName, "%")){
			localNodeName = localNodeName.replace("%", "\\%");
		}
		if (StringUtils.contains(localNodeName, "_")) {
			localNodeName = localNodeName.replace("_", "\\_");
		}
		queryModel.setLocalNodeName(localNodeName);
		String remoteNodeName = queryModel.getRemoteNodeName();
		if(StringUtils.contains(remoteNodeName, "%")){
			remoteNodeName = remoteNodeName.replace("%", "\\%");
		}
		if (StringUtils.contains(remoteNodeName, "_")) {
			remoteNodeName = remoteNodeName.replace("_", "\\_");
		}
		queryModel.setRemoteNodeName(remoteNodeName);
		queryModel.setPageSize(15);
		model.addAttribute("pagn",
				networkStatService.queryServiceDetailPageByModel(queryModel));
		return "operstat/atm/networkstat/atmservice/detailQueryResult";
	}

	/**
	 * ATM全网设备统计功能
	 * @author：KuYonggang
	 * @date：2014-6-17下午3:46:20
	 * @return：String
	 */
	@RequestMapping(value = "initAtmEquip.dox")
	public String initAtmEquip(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
		try {
			model.addAttribute("returnStr", JacksonTools
					.toJsonStr(networkStatService
							.queryAtmEquipListByModel(queryModel)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "returnnote";
	}

	@RequestMapping(value = "atmEquip.dox", method = RequestMethod.GET)
	public String resultAtmEquip(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
		model.addAttribute("pagn",
				networkStatService.queryAtmNodeListByModel(queryModel));
		return "operstat/atm/networkstat/atmequip/queryResult";
	}

	@RequestMapping(value = "equipDetail.dox", method = RequestMethod.GET)
	public String detailAtmEquip(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
		model.addAttribute("vo",queryModel);
		return "operstat/atm/networkstat/atmequip/detailManage";
	}

	@RequestMapping(value = "equipDetail.dox", method = RequestMethod.POST)
	public String viewAtmEquip(HttpServletRequest request, Model model,
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel)
			throws IOException {
		queryModel.setPageSize(15);
		model.addAttribute("pagn",
				networkStatService.queryEquipDetailPageByModel(queryModel));
		return "operstat/atm/networkstat/atmequip/detailQueryResult";
	}
	
	/**
	 * Atm全网端口统计
	 * @author：KuYonggang
	 * @date：2014-6-20上午9:40:34
	 * @param：
	 * @return：String
	 */
	@RequestMapping(value = "initAtmPort.dox")
	public String initAtmPort(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
		try {
			model.addAttribute("returnStr", JacksonTools
					.toJsonStr(networkStatService.queryAtmPortPageByModel(queryModel)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "returnnote";
	}
	
	@RequestMapping(value = "atmPort.dox")
	public String resultAtmPort(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
			//System.out.println("resultAtmPort()方法执行了......");
			//System.out.println("resultAtmPort----------"+queryModel.getBureau());
			model.addAttribute("pagn",networkStatService.queryAtmPortPageByModel(queryModel));
		return "operstat/atm/networkstat/atmpnni/queryResult";
	}
	
	@RequestMapping(value = "portDetail.dox",method=RequestMethod.GET)
	public String detailAtmPort(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
		model.addAttribute("vo", queryModel);
		return "operstat/atm/networkstat/atmport/detailManage";
	}
	
	@RequestMapping(value = "portDetail.dox",method=RequestMethod.POST)
	public String viewAtmPort(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
			String portType = queryModel.getPortType();
			queryModel.setPageSize(15);
			switch (portType){
			case "AXSM":
				model.addAttribute("pagn",networkStatService.queryAXSMPortDetailPageByModel(queryModel));
				return "operstat/atm/networkstat/atmport/axsmQueryResult";
			case "AXSME":
				model.addAttribute("pagn",networkStatService.queryAXSMEPortDetailPageByModel(queryModel));
				return "operstat/atm/networkstat/atmport/axsmeQueryResult";
			case "AXSMXG":
				model.addAttribute("pagn",networkStatService.queryAXSMXGPortPageByModel(queryModel));
				return "operstat/atm/networkstat/atmport/axsmxgQueryResult";
			case "CESM":
				model.addAttribute("pagn",networkStatService.queryCESMPortPageByModel(queryModel));
				return "operstat/atm/networkstat/atmport/cesmQueryResult";
			case "MPSMATM":
				model.addAttribute("pagn",networkStatService.queryMPSMPortPageByModel(queryModel));
				return "operstat/atm/networkstat/atmport/mpsmatmQueryResult";
			case "MPSMFR":
				model.addAttribute("pagn",networkStatService.queryMPSMFRPortPageByModel(queryModel));
				return "operstat/atm/networkstat/atmport/mpsmfrQueryResult";
			case "PXM":
				model.addAttribute("pagn",networkStatService.queryPXMPortPageByModel(queryModel));
				return "operstat/atm/networkstat/atmport/pxmQueryResult";
			case "FRSM":
				model.addAttribute("pagn",networkStatService.queryFRSMPortPageByModel(queryModel));
				return "operstat/atm/networkstat/atmport/frsmQueryResult";
			default:
				model.addAttribute("pagn",networkStatService.queryAtmPortPageByModel(queryModel));
				return "operstat/atm/networkstat/atmport/axsmQueryResult";
		}
	}
	@RequestMapping(value = "initAtmPnni.dox")
	public String initAtmPnni(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
		try {
			//System.out.println(JacksonTools.toJsonStr(networkStatService.queryAtmPnniPageByModel(queryModel)));
			model.addAttribute("returnStr", JacksonTools
					.toJsonStr(networkStatService.queryAtmPnniPageByModel(queryModel)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "returnnote";
	}
	@RequestMapping(value = "atmPnni.dox")
	public String resultAtmPnni(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
		//System.out.println(networkStatService.queryAtmPnniDetailListByModel(queryModel).size());
			model.addAttribute("pagn",networkStatService.queryAtmPnniDetailListByModel(queryModel));
		return "operstat/atm/networkstat/atmpnni/queryResult";
	}
	@RequestMapping(value = "pnniLnsDetail.dox",method=RequestMethod.GET)
	public String managePnniLns(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
		return "operstat/atm/networkstat/atmpnni/detailManage";
	}
	@RequestMapping(value = "pnniLnsDetail.dox",method=RequestMethod.POST)
	public String viewPnniLns(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
			String nodeCode = queryModel.getNodeCode();
			if(StringUtils.contains(nodeCode, "%")){
				nodeCode = nodeCode.replace("%", "\\%");
			}
			if (StringUtils.contains(nodeCode, "_")) {
				nodeCode = nodeCode.replace("_", "\\_");
			}
			queryModel.setNodeCode(nodeCode);
			queryModel.setPageSize(15);
			String portType = queryModel.getPortType();
			switch (portType){
			case "AXSM-32-T1E1-E":
				model.addAttribute("pagn",networkStatService.queryPnniLnsAxsmT1E1PageByModel(queryModel));
				return "operstat/atm/networkstat/atmpnni/pnniLnsAxsmT1E1QueryResult";
			case "AXSM_16OC3_B":
				model.addAttribute("pagn",networkStatService.queryPnniLnsAxsmOC3PageByModel(queryModel));
				return "operstat/atm/networkstat/atmpnni/pnniLnsAxsmOC3QueryResult";
			case "AXSM-16-155-XG":
				model.addAttribute("pagn",networkStatService.queryPnniLnsAxsmXGPageByModel(queryModel));
				return "operstat/atm/networkstat/atmpnni/pnniLnsAxsmXGQueryResult";
			case "AXSME_16T3E3":
				model.addAttribute("pagn",networkStatService.queryPnniLnsAxsmT3E3PageByModel(queryModel));
				return "operstat/atm/networkstat/atmpnni/pnniLnsAxsmT3E3QueryResult";
			case "PXM1E-8-155":
				model.addAttribute("pagn",networkStatService.queryPnniLnsPxm155PageByModel(queryModel));
				return "operstat/atm/networkstat/atmpnni/pnniLnsPxm155QueryResult";
			case "PXM1E-16-T1E1":
				model.addAttribute("pagn",networkStatService.queryPnniLnsPxmT1E1PageByModel(queryModel));
				return "operstat/atm/networkstat/atmpnni/pnniLnsPxmT1E1QueryResult";
			case "FRSM_HS2/B_12IN1":
				model.addAttribute("pagn",networkStatService.queryPnniLnsFrsmPageByModel(queryModel));
				return "operstat/atm/networkstat/atmpnni/pnniLnsFrsmQueryResult";
			case "FRSM_HS2/B_12INNONE":
				model.addAttribute("pagn",networkStatService.queryPnniLnsFrsmPageByModel(queryModel));
				return "operstat/atm/networkstat/atmpnni/pnniLnsFrsmQueryResult";
			case "FRSM_HS2/B_HSSI":
				model.addAttribute("pagn",networkStatService.queryPnniLnsFrsmPageByModel(queryModel));
				return "operstat/atm/networkstat/atmpnni/pnniLnsFrsmQueryResult";
			case "CESM_8E1":
				model.addAttribute("pagn",networkStatService.queryPnniLnsCesmPageByModel(queryModel));
				return "operstat/atm/networkstat/atmpnni/pnniLnsCesmQueryResult";
			case "MPSM_8E1_FRM":
				model.addAttribute("pagn",networkStatService.queryPnniLnsMpsmFrmPageByModel(queryModel));
				return "operstat/atm/networkstat/atmpnni/pnniLnsCesmQueryResult";
			case "MPSM-16-T1E1":
				model.addAttribute("pagn",networkStatService.queryPnniLnsMpsmPageByModel(queryModel));
				return "operstat/atm/networkstat/atmpnni/pnniLnsMpsmQueryResult";
			case "MPSM_8E1_CES":
				model.addAttribute("pagn",networkStatService.queryPnniLnsMpsmPageByModel(queryModel));
				return "operstat/atm/networkstat/atmpnni/pnniLnsMpsmQueryResult";
			case "MPSM_8E1_ATM":
				model.addAttribute("pagn",networkStatService.queryPnniLnsMpsmPageByModel(queryModel));
				return "operstat/atm/networkstat/atmpnni/pnniLnsMpsmQueryResult";
			default:
				model.addAttribute("pagn",networkStatService.queryPnniLnsMpsmFrmPageByModel(queryModel));
				return "operstat/atm/networkstat/atmpnni/pnniLnsMpsmFrmQueryResult";
		}
	}
	
	/**
	 * Atm全网带宽统计
	 * @author：KuYonggang
	 * @date：2014-6-20下午1:15:49
	 * @param：
	 * @return：Stringband
	 */
	@RequestMapping(value = "atmBand.dox")
	public String resultAtmBand(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
			//System.out.println("resultAtmBand()方法执行了......");
			model.addAttribute("pagn",networkStatService.queryAtmBandListByModel(queryModel));
			return "operstat/atm/networkstat/atmband/queryResult";
	}
	
	@RequestMapping(value = "bandDetail.dox",method=RequestMethod.GET)
	public String detailAtmBand(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
			//System.out.println("detailAtmBand()方法执行了......");
			return "operstat/atm/networkstat/atmband/detailManage";
	}
	
	@RequestMapping(value = "bandDetail.dox",method=RequestMethod.POST)
	public String viewAtmBand(
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) {
			//System.out.println("viewAtmBand()方法执行了......");
			String localNodeCode = queryModel.getLocalNodeCode();
			if(StringUtils.contains(localNodeCode, "%")){
				localNodeCode = localNodeCode.replace("%", "\\%");
			}
			if (StringUtils.contains(localNodeCode, "_")) {
				localNodeCode = localNodeCode.replace("_", "\\_");
			}
			queryModel.setLocalNodeCode(localNodeCode);
			String remoteNodeCode = queryModel.getRemoteNodeCode();
			if(StringUtils.contains(remoteNodeCode, "%")){
				remoteNodeCode = remoteNodeCode.replace("%", "\\%");
			}
			if (StringUtils.contains(remoteNodeCode, "_")) {
				remoteNodeCode = remoteNodeCode.replace("_", "\\_");
			}
			queryModel.setRemoteNodeCode(remoteNodeCode);
			queryModel.setPageSize(100);
			model.addAttribute("pagn",networkStatService.queryBandDetailPageByModel(queryModel));
			return "operstat/atm/networkstat/atmband/detailQueryResult";
	}
}
