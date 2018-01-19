/**
 * 
 */
package cn.com.atnc.ioms.web.operstat.atm.nodedetail;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.enums.operstat.atm.EnumCollections.LnsTypeDetail;
import cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService;
import cn.com.atnc.ioms.mng.operstat.atm.INodeDetailService;
import cn.com.atnc.ioms.model.basedata.atm.node.AtmNodeQueryModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * @author：KuYonggang
 * @date：2014-5-20下午7:28:44
 * @version：1.0
 */
@Controller("nodeDetailController")
@RequestMapping("/atmnodedetail/")
public class NodeDetailController extends MyBaseController {

	@Autowired
	private INodeDetailService nodeDetailService;
	@Autowired
	private INetworkStatService networkStatService;

	// 页面初始化
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) throws IOException {
		super.pageInfo(model, request);
		model.addAttribute("atmNode", nodeDetailService.getAtmNodes().get(0));
		model.addAttribute("cardTypeDetail", LnsTypeDetail.values());
		return "operstat/atm/nodedetail/manage";
	}

	@RequestMapping(value = "nodeCodeSelect.dox")
	public String nodeCodeSelect(@ModelAttribute("queryModel") AtmNodeQueryModel queryModel,
			HttpServletRequest request, Model model) throws IOException {
		model.addAttribute("returnStr", nodeDetailService.queryList(queryModel));
		return "returnnote";
	}

	@RequestMapping(value = "queryNodeDetail.dox", method = RequestMethod.GET)
	public String queryNodeDetail(@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) throws IOException {
		model.addAttribute("returnStr", JacksonTools.toJsonStr(nodeDetailService.getAtmNodeByNodeCode(queryModel.getNodeCode())));
		return "returnnote";
	}

	@RequestMapping(value = "queryDetailType.dox", method = RequestMethod.POST)
	public String queryDetailType(HttpServletRequest request, Model model,
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel) throws IOException {
		queryModel.setPageSize(10);
		//System.out.println("optType:"+queryModel.getOptType()+" portType:"+queryModel.getPortType()+" nodeCode:"+queryModel.getNodeCode());
		switch (queryModel.getOptType()==null?"":queryModel.getOptType()) {
		case "CARD":
			//板卡
			model.addAttribute("message","CARD");
			model.addAttribute("pagn",
					nodeDetailService.queryPageForCard(queryModel));
			return "operstat/atm/nodedetail/queryResult";

		case "BUSINESS":
			//业务
			model.addAttribute("message","BUSINESS");
			model.addAttribute("pagn",
					nodeDetailService.queryPageForService(queryModel));
			return "operstat/atm/nodedetail/queryResult";

		case "BANDWIDTH":
			//宽带
			model.addAttribute("message","BANDWIDTH");
			model.addAttribute("pagn",
					nodeDetailService.queryPageForBandWidth(queryModel));
			return "operstat/atm/nodedetail/queryResult";

		case "ALARM":
			//告警
			queryModel.setAlarmFlag(true);
			model.addAttribute("message","ALARM");
			model.addAttribute("atmpagn",
					networkStatService.queryAtmAlarmListByModel(queryModel));
			model.addAttribute("envpagn",
					networkStatService.queryEnvAlarmListByModel(queryModel));
			model.addAttribute("cardpagn",
					networkStatService.queryCardAlarmListByModel(queryModel));
			model.addAttribute("servicepagn",
					networkStatService.queryServiceAlarmListByModel(queryModel));
			return "operstat/atm/nodedetail/alarm";

		case "PORT":
			//端口
			model.addAttribute("message","PORT");
			String portType = queryModel.getPortType();
			switch (portType){
			case "AXSM-32-T1E1-E":
				model.addAttribute("pagn",networkStatService.queryPnniLnsAxsmT1E1PageByModel(queryModel));
				return "operstat/atm/nodedetail/queryResult";
			case "AXSM_16OC3_B":
				model.addAttribute("pagn",networkStatService.queryPnniLnsAxsmOC3PageByModel(queryModel));
				return "operstat/atm/nodedetail/queryResult";
			case "AXSM-16-155-XG":
				model.addAttribute("pagn",networkStatService.queryPnniLnsAxsmXGPageByModel(queryModel));
				return "operstat/atm/nodedetail/queryResult";
			case "AXSME_16T3E3":
				model.addAttribute("pagn",networkStatService.queryPnniLnsAxsmT3E3PageByModel(queryModel));
				return "operstat/atm/nodedetail/queryResult";
			case "PXM1E-8-155":
				model.addAttribute("pagn",networkStatService.queryPnniLnsPxm155PageByModel(queryModel));
				return "operstat/atm/nodedetail/queryResult";
			case "PXM1E-16-T1E1":
				model.addAttribute("pagn",networkStatService.queryPnniLnsPxmT1E1PageByModel(queryModel));
				return "operstat/atm/nodedetail/queryResult";
			case "FRSM_HS2/B_12IN1":
				model.addAttribute("pagn",networkStatService.queryPnniLnsFrsmPageByModel(queryModel));
				return "operstat/atm/nodedetail/queryResult";
			case "FRSM_HS2/B_12INNONE":
				model.addAttribute("pagn",networkStatService.queryPnniLnsFrsmPageByModel(queryModel));
				return "operstat/atm/nodedetail/queryResult";
			case "FRSM_HS2/B_HSSI":
				model.addAttribute("pagn",networkStatService.queryPnniLnsFrsmPageByModel(queryModel));
				return "operstat/atm/nodedetail/queryResult";
			case "CESM_8E1":
				model.addAttribute("pagn",networkStatService.queryPnniLnsCesmPageByModel(queryModel));
				return "operstat/atm/nodedetail/queryResult";
			case "MPSM_8E1_FRM":
				model.addAttribute("pagn",networkStatService.queryPnniLnsMpsmFrmPageByModel(queryModel));
				return "operstat/atm/nodedetail/queryResult";
			case "MPSM-16-T1E1":
				model.addAttribute("pagn",networkStatService.queryPnniLnsMpsmPageByModel(queryModel));
				return "operstat/atm/nodedetail/queryResult";
			case "MPSM_8E1_CES":
				model.addAttribute("pagn",networkStatService.queryPnniLnsMpsmPageByModel(queryModel));
				return "operstat/atm/nodedetail/queryResult";
			case "MPSM_8E1_ATM":
				model.addAttribute("pagn",networkStatService.queryPnniLnsMpsmPageByModel(queryModel));
				return "operstat/atm/nodedetail/queryResult";
			default:
				model.addAttribute("pagn",networkStatService.queryPnniLnsMpsmFrmPageByModel(queryModel));
				return "operstat/atm/nodedetail/queryResult";
			}
		default:
			System.out.println("执行default......");
			model.addAttribute("message","CARD");
			model.addAttribute("pagn",
					nodeDetailService.queryPageForCard(queryModel));
			return "operstat/atm/nodedetail/queryResult";
		}
	}

	/**
	 * 通过板卡id查询板卡详情
	 * @author：KuYonggang
	 * @date：2014-7-21下午1:44:36
	 * @param：
	 * @return：String
	 */
	@RequestMapping(value="cardDetailQueryResult.dox",method = RequestMethod.GET)
	public String initQueryCardDetailQueryResult(HttpServletRequest request, Model model,
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel){
		return "operstat/atm/nodedetail/cardDetailManage";
	}
	@RequestMapping(value="cardDetailQueryResult.dox",method = RequestMethod.POST)
	public String queryCardDetailQueryResult(HttpServletRequest request, Model model,
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel){
		model.addAttribute("pagn",
				nodeDetailService.queryPageForCardDetail(queryModel));
		return "operstat/atm/nodedetail/cardDetailQueryResult";
	}
	/**
	 * 最初通过Ports表查询端口信息的方法（用不上，但暂时保留）
	 * @author：KuYonggang
	 * @date：2014-9-2上午11:21:01
	 * @param：
	 * @return：String
	 */
	@RequestMapping(value = "queryRunInfo.dox", method = RequestMethod.GET)
	public String queryRunInfo(HttpServletRequest request, Model model,
			@ModelAttribute("queryModel") NetworkStatQueryModel queryModel) throws IOException {

		//	System.out.println("nodeCode:"+queryModel.getNodeCode()+" cardType:"+queryModel.getCardType());

		switch (queryModel.getCardType()==null?"":queryModel.getCardType()) {
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

	/**
	 * 加载图片区域所需数值
	 * @author：KuYonggang
	 * @date：2014-6-26上午11:40:52
	 * @param：
	 * @return：String
	 */
	@RequestMapping(value = "queryEnvRuninfo.dox", method = RequestMethod.GET)
	public String queryEnvRuninfo(@ModelAttribute("queryModel") NetworkStatQueryModel queryModel,
			HttpServletRequest request, Model model) throws IOException {
		model.addAttribute("returnStr", JacksonTools.toJsonStr(nodeDetailService.getEnvRuninfoByNodeCode(queryModel)));
		return "returnnote";
	}
}
