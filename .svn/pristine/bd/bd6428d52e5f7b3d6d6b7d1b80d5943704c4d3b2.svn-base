package cn.com.atnc.ioms.web.duty.satellitedayauto;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatDsOdu;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdKuDay;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdOverseaCdm;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdOverseaHW;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdOverseaMain;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdTesOCC;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdTesODU;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteDayAutoType;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatDsOduService;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatSlhPesService;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatTxjdKuDayService;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatTxjdOverseaCDMService;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatTxjdOverseaHWService;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatTxjdOverseaMainService;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatTxjdTesOCCService;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatTxjdTesODUService;
import cn.com.atnc.ioms.mng.turndutymng.ISignLeaveService;
import cn.com.atnc.ioms.model.SysFinals;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 卫星日检--自动巡检
 *
 * @author 段衍林
 * @2016年11月10日 上午10:45:27
 */
@Controller
@RequestMapping("/duty/satellitedayauto/")
public class SatelliteDayAutoController extends MyBaseController {
	@Autowired
	private SatTxjdTesOCCService txjdTesOCCService;
	@Autowired
	private SatTxjdTesODUService txjdTesODUService;
	@Autowired
	private SatTxjdKuDayService txjdKuDayService;
	@Autowired
	private SatTxjdOverseaMainService satTxjdOverseaMainService;
	@Autowired
	private SatTxjdOverseaCDMService satTxjdOverseaCDMService;
	@Autowired
	private SatTxjdOverseaHWService satTxjdOverseaHWService;
	@Autowired
	private SatSlhPesService satSlhPesService;
	@Autowired
	private SatDsOduService satDsOduService;
	@Autowired
	private ISignLeaveService signLeaveService;

	/**
	 * 卫星自检（日检）页面控制
	 * 
	 * @author 段衍林
	 * @2016年11月10日 上午10:56:51
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") SatelliteAutoModel queryModel,
			HttpServletRequest request, Model model) {
		// 当前操作人
		User user = getCurrentUser(request);
		model.addAttribute("currentUser", user);
		// 是否签到
		if (signLeaveService.isOndutyByUser(user)) {
			// 签到
			model.addAttribute("isflag", SysFinals.YES);
		} else {
			// 未签到
			model.addAttribute("isflag", SysFinals.NO);
		}
		// 返回页面信息
		super.pageInfo(model, request);
		return "duty/satellitedayauto/manage";
	}

	/**
	 * 卫星日检自检tab页控制
	 * 
	 * @author 段衍林
	 * @2016年11月10日 上午11:14:19
	 * @param queryModel
	 * @param request
	 * @param model
	 * @param equipType
	 * @param checkType
	 * @param optType
	 * @return String
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") SatelliteAutoModel queryModel,
			HttpServletRequest request, Model model) {
		// 当前操作人
		User user = getCurrentUser(request);
		model.addAttribute("currentUser", user);
		// 是否签到
		if (signLeaveService.isOndutyByUser(user)) {
			// 签到
			model.addAttribute("isflag", SysFinals.YES);
		} else {
			// 未签到
			model.addAttribute("isflag", SysFinals.NO);
		}
		// 取得tab标签页
		String optType = queryModel.getOptType();
		// 返回tab标签
		model.addAttribute("optType", optType);
		switch (optType == null ? "" : optType) {

		case "txjdTesOCC":
			/**
			 * 通信基地-TES-TES OCC状态
			 */
			model.addAttribute("pagn",
					txjdTesOCCService.queryPageByModel(queryModel));
			return "duty/satellitedayauto/txjdtesocc/queryResult";

		case "txjdTesODU":
			/**
			 * 通信基地-TES-TES ODU
			 */
			queryModel.setEquipName(SatelliteDayAutoType.txjdTesODU);
			model.addAttribute("pagn",
					txjdTesODUService.queryPageByModel(queryModel));
			return "duty/satellitedayauto/txjdtesodu/queryResult";

		case "txjdKu":
			/**
			 * 通信基地-KU卫星专业日检
			 */
			model.addAttribute("pagn",
					txjdKuDayService.queryPageByModel(queryModel));
			return "duty/satellitedayauto/txjdku/queryResult";

		case "txjdOverseaMain":
			/**
			 * 通信基地-境外站-境外站主站载波
			 */
			model.addAttribute("pagn",
					satTxjdOverseaMainService.queryPageByModel(queryModel));
			return "duty/satellitedayauto/txjdoverseamain/queryResult";

		case "txjdOverseaCDM":
			/**
			 * 通信基地-境外站-主站CDM570
			 */
			model.addAttribute("pagn",
					satTxjdOverseaCDMService.queryPageByModel(queryModel));
			return "duty/satellitedayauto/txjdoverseacdm/queryResult";

		case "txjdOverseaHW":
			/**
			 * 通信基地-境外站-主站华为路由器
			 */
			model.addAttribute("pagn",
					satTxjdOverseaHWService.queryPageByModel(queryModel));
			return "duty/satellitedayauto/txjdoverseahw/queryResult";

		case "slhPES":
			/**
			 * 十里河-PES-PES出境载波状态
			 */
			model.addAttribute("pagn",
					satSlhPesService.queryPageByModel(queryModel));
			return "duty/satellitedayauto/slhpes/queryResult";

		case "dsODU":
			/**
			 * 东四-PES-TES民航局ODU
			 */
			// 查询设备名称绑定为dsODU("东四-PES-TES民航局ODU")，与十里河相区别
			queryModel.setEquipName(SatelliteDayAutoType.dsODU);
			model.addAttribute("pagn",
					satDsOduService.queryPageByModel(queryModel));
			return "duty/satellitedayauto/dsodu/queryResult";

		default:
			model.addAttribute("pagn",
					txjdTesOCCService.queryPageByModel(queryModel));
			return "duty/satellitedayauto/txjdtesocc/queryResult";
		}
	}

	/**
	 * 冒泡显示
	 * 
	 * @author 段衍林
	 * @2016年11月11日 上午9:02:59
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping(value = "ajaxLoad.dox", method = RequestMethod.GET)
	public String ajaxLoad(
			@ModelAttribute("queryModel") SatelliteAutoModel queryModel,
			HttpServletRequest request, Model model) throws IOException {
		// 取得tab标签页
		String optType = queryModel.getOptType();
		// 返回tab标签
		model.addAttribute("optType", optType);
		// 声明全局变量
		int ajaxLoads = 0;
		// 分tab查询冒泡数据
		switch (optType == null ? "" : optType) {

		case "txjdTesOCC":
			/**
			 * 通信基地-TES-TES OCC
			 */
			ajaxLoads = txjdTesOCCService.getAjaxLoad();
			break;

		case "txjdTesODU":
			/**
			 * 通信基地-TES-TES ODU
			 */
			ajaxLoads = txjdTesODUService.getAjaxLoad();
			break;

		case "txjdKu":
			/**
			 * 通信基地-KU卫星专业日检
			 */
			ajaxLoads = txjdKuDayService.getAjaxLoad();
			break;

		case "txjdOverseaMain":
			/**
			 * 通信基地-境外站-境外站主站载波
			 */
			ajaxLoads = satTxjdOverseaMainService.getAjaxLoad();
			break;

		case "txjdOverseaCDM":
			/**
			 * 通信基地-境外站-主站CDM570
			 */
			ajaxLoads = satTxjdOverseaCDMService.getAjaxLoad();
			break;

		case "txjdOverseaHW":
			/**
			 * 通信基地-境外站-主站华为路由器
			 */
			ajaxLoads = satTxjdOverseaHWService.getAjaxLoad();
			break;

		case "slhPES":
			/**
			 * 十里河-PES-PES出境载波状态
			 */
			ajaxLoads = satSlhPesService.getAjaxLoad();
			break;

		case "dsODU":
			/**
			 * 东四-PES-TES民航局ODU
			 */
			// 绑定设备名称dsODU("东四-PES-TES民航局ODU")
			SatelliteAutoModel autoModel = new SatelliteAutoModel();
			autoModel.setEquipName(SatelliteDayAutoType.dsODU);
			// 根据设备名称查询数据
			ajaxLoads = satDsOduService.getAjaxLoad(autoModel);
			break;

		default:
			/**
			 * 通信基地-TES-TES OCC
			 */
			ajaxLoads = txjdTesOCCService.getAjaxLoad();
			break;

		}
		model.addAttribute("returnStr", ajaxLoads);
		return "returnnote";
	}

	/**
	 * 查看自动巡检的具体内容
	 * 
	 * @author 段衍林
	 * @2016年11月10日 下午3:29:48
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public String view(
			@ModelAttribute("queryModel") SatelliteAutoModel queryModel,
			HttpServletRequest request, Model model) {
		// 取得tab标签页
		String optType = queryModel.getOptType();
		switch (optType == null ? "" : optType) {

		case "txjdTesOCC":
			/**
			 * 通信基地-TES-TES OCC
			 */
			// 现根据id条件查询有关数据
			Pagination pagnOCC = txjdTesOCCService.queryPageByModel(queryModel);
			// 取出列表
			List<SatTxjdTesOCC> satTxjdTesOCCs = (List<SatTxjdTesOCC>) pagnOCC
					.getResult();
			// 不为空的话，将第一条作为结果传递给前台
			if (CollectionUtils.isNotEmpty(satTxjdTesOCCs)) {
				model.addAttribute("checkData", satTxjdTesOCCs.get(0));
			}
			// 跳转view页面
			return "duty/satellitedayauto/txjdtesocc/view";

		case "txjdTesODU":
			/**
			 * 通信基地-TES-TES ODU
			 */
			// 现根据id条件查询有关数据
			Pagination pagnODU = txjdTesODUService.queryPageByModel(queryModel);
			// 取出列表
			List<SatTxjdTesODU> satTxjdTesODUs = (List<SatTxjdTesODU>) pagnODU
					.getResult();
			// 不为空的话，将第一条作为结果传递给前台
			if (CollectionUtils.isNotEmpty(satTxjdTesODUs)) {
				model.addAttribute("checkData", satTxjdTesODUs.get(0));
			}
			// 跳转view页面
			return "duty/satellitedayauto/txjdtesodu/view";

		case "txjdKu":
			/**
			 * 通信基地-KU卫星专业日检
			 */
			// 现根据id条件查询有关数据
			Pagination pagnKu = txjdKuDayService.queryPageByModel(queryModel);
			// 取出列表
			List<SatTxjdKuDay> satTxjdKuDays = (List<SatTxjdKuDay>) pagnKu
					.getResult();
			// 不为空的话，将第一条作为结果传递给前台
			if (CollectionUtils.isNotEmpty(satTxjdKuDays)) {
				model.addAttribute("checkData", satTxjdKuDays.get(0));
			}
			// 跳转view页面
			return "duty/satellitedayauto/txjdku/view";

		case "txjdOverseaMain":
			/**
			 * 通信基地-境外站-主站main
			 */
			// 现根据id条件查询有关数据
			Pagination pagnMain = satTxjdOverseaMainService
					.queryPageByModel(queryModel);
			// 取出列表
			List<SatTxjdOverseaMain> satTxjdOverseaMains = (List<SatTxjdOverseaMain>) pagnMain
					.getResult();
			// 不为空的话，将第一条作为结果传递给前台
			if (CollectionUtils.isNotEmpty(satTxjdOverseaMains)) {
				model.addAttribute("checkData", satTxjdOverseaMains.get(0));
			}
			// 跳转view页面
			return "duty/satellitedayauto/txjdoverseamain/view";

		case "txjdOverseaCDM":
			/**
			 * 通信基地-境外站-主站CDM570
			 */
			// 现根据id条件查询有关数据
			Pagination pagnCDM = satTxjdOverseaCDMService
					.queryPageByModel(queryModel);
			// 取出列表
			List<SatTxjdOverseaCdm> satTxjdOverseaCdms = (List<SatTxjdOverseaCdm>) pagnCDM
					.getResult();
			// 不为空的话，将第一条作为结果传递给前台
			if (CollectionUtils.isNotEmpty(satTxjdOverseaCdms)) {
				model.addAttribute("checkData", satTxjdOverseaCdms.get(0));
			}
			// 跳转view页面
			return "duty/satellitedayauto/txjdoverseacdm/view";

		case "txjdOverseaHW":
			/**
			 * 通信基地-境外站-主站华为路由器状态
			 */
			// 现根据id条件查询有关数据
			Pagination pagnHW = satTxjdOverseaHWService
					.queryPageByModel(queryModel);
			// 取出列表
			List<SatTxjdOverseaHW> satTxjdOverseaHWs = (List<SatTxjdOverseaHW>) pagnHW
					.getResult();
			// 不为空的话，将第一条作为结果传递给前台
			if (CollectionUtils.isNotEmpty(satTxjdOverseaHWs)) {
				model.addAttribute("checkData", satTxjdOverseaHWs.get(0));
			}
			// 跳转view页面
			return "duty/satellitedayauto/txjdoverseahw/view";

		case "dsODU":
			/**
			 * 东四-PES-TES民航局ODU
			 */
			// 现根据id条件查询有关数据
			Pagination pagnDS = satDsOduService.queryPageByModel(queryModel);
			// 取出列表
			List<SatDsOdu> satDsOdus = (List<SatDsOdu>) pagnDS.getResult();
			// 不为空的话，将第一条作为结果传递给前台
			if (CollectionUtils.isNotEmpty(satDsOdus)) {
				model.addAttribute("checkData", satDsOdus.get(0));
			}
			// 跳转view页面
			return "duty/satellitedayauto/dsodu/view";

		default:
			/**
			 * 通信基地-TES-TES OCC
			 */
			// 现根据id条件查询有关数据
			Pagination pagnOCC1 = txjdTesOCCService
					.queryPageByModel(queryModel);
			// 取出列表
			List<SatTxjdTesOCC> satTxjdTesOCCs1 = (List<SatTxjdTesOCC>) pagnOCC1
					.getResult();
			// 不为空的话，将第一条作为结果传递给前台
			if (CollectionUtils.isNotEmpty(satTxjdTesOCCs1)) {
				model.addAttribute("checkData", satTxjdTesOCCs1.get(0));
			}
			// 跳转view页面
			return "duty/satellitedayauto/txjdtesocc/view";
		}
	}
}
