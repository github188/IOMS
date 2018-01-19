package cn.com.atnc.ioms.web.duty.statellite.day.tes;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.DataState;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdDecCon;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdMainState;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdProState;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdSynState;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdWorkCon;
import cn.com.atnc.ioms.enums.duty.satellite.SatelliteCheckContent;
import cn.com.atnc.ioms.enums.duty.satellite.TxjdMainResult;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.IDataStateService;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.IDayTesCheckService;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.ITxjdDecConService;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.ITxjdMainStateService;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.ITxjdProStateService;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.ITxjdSynStateService;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.ITxjdWorkConService;
import cn.com.atnc.ioms.mng.turndutymng.ISignLeaveService;
import cn.com.atnc.ioms.model.duty.statellite.day.SatelliteBaseQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.AuditDataModel;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TesBaseDataModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 卫星tes日检控制类--通用类
 *
 * @author 段衍林
 * @2017年2月13日 下午1:31:00
 */
@Controller
@RequestMapping("/duty/satellite/day/tes/")
public class DayTesCheckController extends MyBaseController {

	@Autowired
	private ISignLeaveService signLeaveService;
	@Autowired
	private IDataStateService dataService;
	@Autowired
	private ITxjdProStateService txjdProStateService;
	@Autowired
	private ITxjdWorkConService txjdWorkConService;
	@Autowired
	private ITxjdDecConService txjdDecConService;
	@Autowired
	private ITxjdSynStateService txjdSynStateService;
	@Autowired
	private IDayTesCheckService dayTesCheckService;
	@Autowired
	private ITxjdMainStateService txjdMainStateService;

	/**
	 * 页面初始化
	 * 
	 * @author 段衍林
	 * @2017年2月13日 下午1:32:59
	 * @param queryModel
	 *            查询model
	 * @param request
	 *            请求
	 * @param model
	 *            控制model
	 * @return String 返回地址
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") SatelliteBaseQueryModel queryModel,
			HttpServletRequest request, Model model) {
		// 记录填写人
		User currentUser = super.getCurrentUser(request);
		model.addAttribute("currentUser", currentUser);
		super.pageInfo(model, request);
		return "duty/satellite/day/tes/manage";
	}

	/**
	 * 加载数据
	 * 
	 * @author 段衍林
	 * @2017年2月14日 上午8:57:07
	 * @param queryModel
	 *            查詢model
	 * @param optType
	 *            tab页
	 * @param request
	 *            请求
	 * @param model
	 *            控制类model
	 * @return String 返回地址
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") SatelliteBaseQueryModel queryModel,
			@RequestParam("optType") String optType,
			HttpServletRequest request, Model model) {
		// 记录填写人
		User currentUser = super.getCurrentUser(request);
		model.addAttribute("optType", optType);
		model.addAttribute("currentUser", currentUser);
		switch (optType == null ? "" : optType) {
		case "txjddatastate":
			/**
			 * 通信基地-TES-TES网管数据库状态
			 */
			queryModel.setContent(SatelliteCheckContent.TxjdDataState);
			model.addAttribute("pagn", dataService.queryPage(queryModel));
			return "duty/satellite/day/tes/datastate/queryResult";
		case "txjdprostate":
			/**
			 * 通信基地-TES-TES网管进程状态
			 */
			model.addAttribute("pagn",
					txjdProStateService.queryPage(queryModel));
			return "duty/satellite/day/tes/tesprostate/queryResult";
		case "txjdworkcon":
			/**
			 * 通信基地-TES-TES网管工作站连通性
			 */
			model.addAttribute("pagn", txjdWorkConService.queryPage(queryModel));
			return "duty/satellite/day/tes/tesworkcon/queryResult";
		case "txjddeccon":
			/**
			 * 通信基地-TES-DecServer 连通性
			 */
			model.addAttribute("pagn", txjdDecConService.queryPage(queryModel));
			return "duty/satellite/day/tes/tesdeccon/queryResult";
		case "txjdsynstate":
			/**
			 * 通信基地-TES-查看网管同步状态
			 */
			model.addAttribute("pagn",
					txjdSynStateService.queryPage(queryModel));
			return "duty/satellite/day/tes/tessynstate/queryResult";
		case "txjdmainstate":
			/**
			 * 通信基地-TES-TES网管工作站主备状态
			 */
			model.addAttribute("pagn",
					txjdMainStateService.queryPage(queryModel));
			return "duty/satellite/day/tes/tesmainstate/queryResult";
		default:
			/**
			 * 通信基地-TES-TES网管数据库状态
			 */
			model.addAttribute("pagn", dataService.queryPage(queryModel));
			return "duty/satellite/day/tes/datastate/queryResult";
		}

	}

	/**
	 * 添加
	 * 
	 * @author 段衍林
	 * @2017年2月14日 上午8:57:55
	 * @param model
	 *            控制类model
	 * @return String 返回地址
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String addJump(Model model) {
		model.addAttribute("txjdMainResults", TxjdMainResult.values());
		return "duty/satellite/day/tes/add";
	}

	/**
	 * 添加操作
	 * 
	 * @author 段衍林
	 * @2017年2月14日 上午8:58:35
	 * @param dataStateModel
	 *            保存model
	 * @param request
	 *            请求
	 * @param model
	 *            视图model
	 * @return String 返回
	 * @throws IOException
	 *             异常
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String add(
			@ModelAttribute("pageModel") TesBaseDataModel tesBaseDataModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 设置当前用户为操作人
			User user = super.getCurrentUser(request);
			// 将记录保存至数据库
			dayTesCheckService.save(tesBaseDataModel, user);
			model.addAttribute("returnStr",
					new ResultModel(true, "操作成功", null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "操作失败", null).toJson());
		}
		return "returnnote";
	}

	/**
	 * 查看详情
	 * 
	 * @author 段衍林
	 * @2017年2月14日 上午9:00:52
	 * @param id
	 *            实体id
	 * @param optType
	 *            tab页
	 * @param request
	 *            请求
	 * @param model
	 *            视图model
	 * @return String 返回地址
	 */
	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public String view(@RequestParam("id") String id,
			@RequestParam("optType") String optType,
			HttpServletRequest request, Model model) {
		model.addAttribute("view", "1");
		switch (optType == null ? "" : optType) {
		case "txjddatastate":
			// 网管数据库状态
			DataState dataState = dataService.findById(id);
			model.addAttribute("vo", dataState);
			return "/duty/satellite/day/tes/datastate/view";
		case "txjdprostate":
			// 网管数据库状态
			TxjdProState proState = txjdProStateService.findById(id);
			model.addAttribute("vo", proState);
			return "/duty/satellite/day/tes/tesprostate/view";
		case "txjdworkcon":
			// 通信基地-TES-TES网管工作站连通性
			TxjdWorkCon txjdWorkCon = txjdWorkConService.findById(id);
			model.addAttribute("vo", txjdWorkCon);
			return "/duty/satellite/day/tes/tesworkcon/view";
		case "txjddeccon":
			// 通信基地-TES-DecServer 连通性
			TxjdDecCon txjdDecCon = txjdDecConService.findById(id);
			model.addAttribute("vo", txjdDecCon);
			return "duty/satellite/day/tes/tesdeccon/view";
		case "txjdsynstate":
			// 通信基地-TES-查看网管同步状态
			TxjdSynState txjdSynState = txjdSynStateService.findById(id);
			model.addAttribute("vo", txjdSynState);
			return "duty/satellite/day/tes/tessynstate/view";
		case "txjdmainstate":
			// 通信基地-TES-TES网管工作站主备状态
			TxjdMainState txjdMainState = txjdMainStateService.findById(id);
			model.addAttribute("vo", txjdMainState);
			return "duty/satellite/day/tes/tesmainstate/view";
		default:
			// 网管数据库状态
			DataState dataStateFefault = dataService.findById(id);
			model.addAttribute("vo", dataStateFefault);
			return "/duty/satellite/day/tes/datastate/view";
		}
	}

	/**
	 * 删除操作
	 * 
	 * @author 段衍林
	 * @2017年2月14日 上午9:01:31
	 * @param request
	 *            请求
	 * @param model
	 *            视图model
	 * @param optType
	 *            tab页
	 * @param id
	 *            实体id
	 * @return String 返回
	 */
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String delete(HttpServletRequest request, Model model,
			@RequestParam("optType") String optType,
			@RequestParam("id") String id) {
		// 地址初始化
		String url = "duty/satellite/day/tes/datastate/result";
		try {
			switch (optType == null ? "" : optType) {
			case "txjddatastate":
				// 网管数据库状态
				dataService.delete(id);
				break;
			case "txjdprostate":
				// 网管数据库状态
				txjdProStateService.delete(id);
				url = "duty/satellite/day/tes/tesprostate/result";
				break;
			case "txjdworkcon":
				// 通信基地-TES-TES网管工作站连通性
				txjdWorkConService.delete(id);
				url = "duty/satellite/day/tes/tesworkcon/result";
				break;
			case "txjddeccon":
				// 通信基地-TES-DecServer 连通性
				txjdDecConService.delete(id);
				url = "duty/satellite/day/tes/tesdeccon/result";
				break;
			case "txjdsynstate":
				// 通信基地-TES-查看网管同步状态
				txjdSynStateService.delete(id);
				url = "duty/satellite/day/tes/tessynstate/result";
				break;
			case "txjdmainstate":
				// 通信基地-TES-TES网管工作站主备状态
				txjdMainStateService.delete(id);
				return "duty/satellite/day/tes/tesmainstate/result";
			default:
				// 网管数据库状态
				dataService.delete(id);
			}
			// 返回
			addSuccess(model, "删除记录成功");
			// 记录操作日志
			super.addLog(request, "删除记录成功");
		} catch (RuntimeException e) {
			addError(model, "删除记录失败");
			super.addLog(request, "删除记录失败");
		}
		return url;
	}

	/**
	 * 审核页面跳转
	 * 
	 * @author 段衍林
	 * @2017年2月17日 上午8:52:57
	 * @param id
	 *            实体id
	 * @param model
	 *            视图控制
	 * @param optType
	 *            tab页
	 * @param request
	 *            请求
	 * @return String 返回地址
	 */
	@RequestMapping(value = "audit.do", method = RequestMethod.GET)
	public String auditJump(@RequestParam(value = "id") String id, Model model,
			@RequestParam("optType") String optType, HttpServletRequest request) {
		// 设置当前用户为操作人
		User user = super.getCurrentUser(request);
		model.addAttribute("currentUser", user);
		model.addAttribute("optType", optType);
		model.addAttribute("audit", "1");
		switch (optType == null ? "" : optType) {
		case "txjddatastate":
			// 网管数据库状态
			DataState dataState = dataService.findById(id);
			model.addAttribute("vo", dataState);
			return "/duty/satellite/day/tes/datastate/audit";
		case "txjdprostate":
			// 网管数据库状态
			TxjdProState proState = txjdProStateService.findById(id);
			model.addAttribute("vo", proState);
			return "/duty/satellite/day/tes/tesprostate/audit";
		case "txjdworkcon":
			// 通信基地-TES-TES网管工作站连通性
			TxjdWorkCon txjdWorkCon = txjdWorkConService.findById(id);
			model.addAttribute("vo", txjdWorkCon);
			return "/duty/satellite/day/tes/tesworkcon/audit";
		case "txjddeccon":
			// 通信基地-TES-DecServer 连通性
			TxjdDecCon txjdDecCon = txjdDecConService.findById(id);
			model.addAttribute("vo", txjdDecCon);
			return "/duty/satellite/day/tes/tesdeccon/audit";
		case "txjdsynstate":
			// 通信基地-TES-查看网管同步状态
			TxjdSynState txjdSynState = txjdSynStateService.findById(id);
			model.addAttribute("vo", txjdSynState);
			return "/duty/satellite/day/tes/tessynstate/audit";
		case "txjdmainstate":
			// 通信基地-TES-TES网管工作站主备状态
			TxjdMainState txjdMainState = txjdMainStateService.findById(id);
			model.addAttribute("vo", txjdMainState);
			return "duty/satellite/day/tes/tesmainstate/audit";
		default:
			// 网管数据库状态
			DataState dataStateFefault = dataService.findById(id);
			model.addAttribute("vo", dataStateFefault);
			return "/duty/satellite/day/tes/audit";
		}
	}

	/**
	 * 审核
	 * 
	 * @author 段衍林
	 * @2017年2月17日 上午9:08:38
	 * @param id
	 *            实体id
	 * @param optType
	 *            tab页
	 * @param auditRemark
	 *            审核
	 * @param request
	 *            请求
	 * @param model
	 *            视图控制
	 * @return String 返回地址
	 * @throws IOException
	 *             异常
	 */
	@RequestMapping(value = "audit.do", method = RequestMethod.POST)
	public String audit(
			@ModelAttribute("pageModel") AuditDataModel auditDataModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 设置当前用户为操作人
			User user = super.getCurrentUser(request);
			dayTesCheckService.audit(auditDataModel, user);
			model.addAttribute("returnStr", new ResultModel(true, "审核记录成功",
					null).toJson());
		} catch (Exception e) {
			logger.error("审核记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(true, "审核记录失败",
					null).toJson());
			return "returnnote";
		}
		return "returnnote";
	}
}
