package cn.com.atnc.ioms.web.business.formalcircuit;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.approveinfo.ApproveInfo;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitAttach;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveTypeEnum;
import cn.com.atnc.ioms.enums.business.formalcircuit.FormalCircuitAttachTypeEnum;
import cn.com.atnc.ioms.enums.business.formalcircuit.FormalStatEnum;
import cn.com.atnc.ioms.enums.reports.JasperReportsEnum;
import cn.com.atnc.ioms.enums.reports.ReturnedReportsEnum;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.business.approveinfo.IApproveInfoService;
import cn.com.atnc.ioms.mng.business.baseinfo.IApplyBaseInfoService;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitATMManager;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitAttachService;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitKUManager;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitManager;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitPESManager;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitTESManager;
import cn.com.atnc.ioms.mng.reports.JasperReportService;
import cn.com.atnc.ioms.model.business.formalcircuit.FormalCircuitQueryModel;
import cn.com.atnc.ioms.util.JasperReportUtils;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 正式电路处理控制器
 *
 * @author WangLingbin
 * @date 2015年7月28日 上午11:37:04
 * @since 1.0.0
 */
@Controller
@RequestMapping("/formalcircuit/")
public class FormalCircuitController extends MyBaseController {

	@Autowired
	private IApplyBaseInfoService applyBaseInfoService;
	@Autowired
	private IApproveInfoService approveInfoService;
	@Autowired
	private IFormalCircuitManager formalCircuitManager;
	@Autowired
	private IFormalCircuitATMManager formalCircuitATMManager;
	@Autowired
	private IFormalCircuitKUManager formalCircuitKUManager;
	@Autowired
	private IFormalCircuitTESManager formalCircuitTESManager;
	@Autowired
	private IFormalCircuitPESManager formalCircuitPESManager;
	@Autowired
	private IUserManager userManager;
	@Autowired
	private JasperReportService jasperReportService;
	@Autowired
	private IFormalCircuitAttachService formalCircuitAttachService;

	// 页面初始化
	@RequestMapping(value = "tasklist.do", method = RequestMethod.GET)
	public String manage(HttpServletRequest request, Model model) {
		super.pageInfo(model, request);
		return "business/formalcircuit/manage";
	}

	@RequestMapping(value = "tasklist.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") FormalCircuitQueryModel queryModel,
			HttpServletRequest request, Model model) {
		// 当前用户
		User user = this.getCurrentUser(request);
		StringBuffer roleNames = new StringBuffer("|");
		List<Role> roles = user.getRoles();
		if (!CollectionUtils.isEmpty(roles)) {
			for (Role role : roles) {
				roleNames.append(role.getName());
				roleNames.append("|");
			}
		}
		logger.info("当前用户名：" + user.getName() + " 拥有的角色名称：" + roleNames);
		// 根据不同角色获取不同的数据
		List<FormalStatEnum> approveStatList = new ArrayList<FormalStatEnum>();
		if (roleNames.toString().contains("|" + RoleEnum.csLeader.name() + "|")) { // 客服领导
			approveStatList.add(FormalStatEnum.csleader_approve);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					formalCircuitManager.queryPage(queryModel));
		}
		if (roleNames.toString().contains("|" + RoleEnum.csStaff.name() + "|")) { // 客服专员
			approveStatList.add(FormalStatEnum.csstaff_firstdeal);
			approveStatList.add(FormalStatEnum.csstaff_deal);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("role", RoleEnum.csStaff.name());
			model.addAttribute("pagn",
					formalCircuitManager.queryPage(queryModel));
		}
		if (roleNames.toString().contains(
				"|" + RoleEnum.atncLeader.name() + "|")) {// 网控领导
			approveStatList.add(FormalStatEnum.atncleader_approve);
			approveStatList.add(FormalStatEnum.atncleader_seconddeal);
			approveStatList.add(FormalStatEnum.atncleader_firstdeal);
			// 网控领导分配审核工程师
			approveStatList.add(FormalStatEnum.atncleader_thirddeal);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					formalCircuitManager.queryPage(queryModel));
		}
		if (roleNames.toString().contains("|" + RoleEnum.engineer.name() + "|")) { // 工程师
			approveStatList.add(FormalStatEnum.engineer_config);
			approveStatList.add(FormalStatEnum.engineer_firstaudit);
			approveStatList.add(FormalStatEnum.engineer_secondaudit);
			approveStatList.add(FormalStatEnum.engineer_transfer);
			queryModel.setStatusList(approveStatList);
			queryModel.setNextUser(user.getId()); // 该查询条件查询上一步移交给自己的记录
			model.addAttribute("role", RoleEnum.engineer.name());
			model.addAttribute("pagn",
					formalCircuitManager.queryPage(queryModel));
		}
		if (roleNames.toString().contains("|" + RoleEnum.manager.name() + "|")) { // 事业部领导
			approveStatList.add(FormalStatEnum.generalmanager_approve);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					formalCircuitManager.queryPage(queryModel));
		}
		if (roleNames.toString().contains(
				"|" + RoleEnum.fundmanager.name() + "|")) { // 财务部经理
			approveStatList.add(FormalStatEnum.fundmanager_approve);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					formalCircuitManager.queryPage(queryModel));
		}
		model.addAttribute("role", roleNames);
		return "business/formalcircuit/queryResult";
	}

	/**
	 * 页面气泡
	 * 
	 * @throws IOException
	 * @date 2015年5月26日下午3:53:27
	 * @since 1.0.0
	 */
	@RequestMapping(value = "ajaxLoad.dox", method = RequestMethod.GET)
	public String ajaxLoad(
			@ModelAttribute("queryModel") FormalCircuitQueryModel queryModel,
			HttpServletRequest request, Model model) throws IOException {
		// 当前用户
		User user = this.getCurrentUser(request);
		StringBuffer roleNames = new StringBuffer("|");
		List<Role> roles = user.getRoles();
		if (!CollectionUtils.isEmpty(roles)) {
			for (Role role : roles) {
				roleNames.append(role.getName());
				roleNames.append("|");
			}
		}
		// 根据不同角色获取不同的数据
		List<FormalStatEnum> approveStatList = new ArrayList<FormalStatEnum>();
		if (roleNames.toString().contains("|" + RoleEnum.csLeader.name() + "|")) { // 客服领导
			approveStatList.add(FormalStatEnum.csleader_approve);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					formalCircuitManager.queryPage(queryModel));
		}
		if (roleNames.toString().contains("|" + RoleEnum.csStaff.name() + "|")) { // 客服专员
			approveStatList.add(FormalStatEnum.csstaff_firstdeal);
			approveStatList.add(FormalStatEnum.csstaff_deal);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("role", RoleEnum.csStaff.name());
			model.addAttribute("pagn",
					formalCircuitManager.queryPage(queryModel));
		}
		if (roleNames.toString().contains(
				"|" + RoleEnum.atncLeader.name() + "|")) {// 网控领导
			approveStatList.add(FormalStatEnum.atncleader_approve);
			approveStatList.add(FormalStatEnum.atncleader_seconddeal);
			approveStatList.add(FormalStatEnum.atncleader_firstdeal);
			// 网控领导分配审核工程师
			approveStatList.add(FormalStatEnum.atncleader_thirddeal);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					formalCircuitManager.queryPage(queryModel));
		}
		if (roleNames.toString().contains("|" + RoleEnum.engineer.name() + "|")) { // 工程师
			approveStatList.add(FormalStatEnum.engineer_config);
			approveStatList.add(FormalStatEnum.engineer_firstaudit);
			approveStatList.add(FormalStatEnum.engineer_secondaudit);
			approveStatList.add(FormalStatEnum.engineer_transfer);
			queryModel.setStatusList(approveStatList);
			queryModel.setNextUser(user.getId()); // 该查询条件查询上一步移交给自己的记录
			model.addAttribute("role", RoleEnum.engineer.name());
			model.addAttribute("pagn",
					formalCircuitManager.queryPage(queryModel));
		}
		if (roleNames.toString().contains("|" + RoleEnum.manager.name() + "|")) { // 事业部领导
			approveStatList.add(FormalStatEnum.generalmanager_approve);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					formalCircuitManager.queryPage(queryModel));
		}
		if (roleNames.toString().contains(
				"|" + RoleEnum.fundmanager.name() + "|")) { // 财务部经理
			approveStatList.add(FormalStatEnum.fundmanager_approve);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					formalCircuitManager.queryPage(queryModel));
		}
		model.addAttribute("role", roleNames);
		model.addAttribute("returnStr", JacksonTools
				.toJsonStr(formalCircuitManager.queryPage(queryModel)));
		return "returnnote";
	}

	/**
	 * 查看详情
	 *
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 * @date 2015年5月26日下午2:24:46
	 * @since 1.0.0
	 */
	@RequestMapping(value = "detail.do", method = RequestMethod.GET)
	public String setupDetailForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		FormalCircuit formalCircuit = formalCircuitManager.findById(id);
		ApplyBaseInfo applyBaseInfo = formalCircuit.getApplyBaseInfo();
		FormalCircuitQueryModel pageModel = formalCircuitManager
				.getCheckModel(id);
		model.addAttribute("approveInfos", approveInfoService
				.getApproveInfoByBaseInfoId(applyBaseInfo.getId()));
		model.addAttribute("m", pageModel);
		model.addAttribute("formalCircuit", formalCircuit);
		model.addAttribute("formalCircuitATMs",
				pageModel.getFormalCircuitATMli());
		model.addAttribute("formalCircuitKUs", pageModel.getFormalCircuitKUli());
		model.addAttribute("formalCircuitTESs",
				pageModel.getFormalCircuitTESli());
		model.addAttribute("formalCircuitPESs",
				pageModel.getFormalCircuitPESli());
		model.addAttribute("isVisable", false); // 申请表中，信息是否显示为输入框
		// 上传附件
		List<FormalCircuitAttach> attaches = formalCircuitAttachService
				.queryListByFCId(formalCircuit.getId());
		List<FormalCircuitAttachTypeEnum> formalCircuitAttachTypeEnum = Arrays
				.asList(FormalCircuitAttachTypeEnum.values());
		model.addAttribute("attaches", attaches);
		model.addAttribute("formalCircuitAttachTypeEnum",
				formalCircuitAttachTypeEnum);
		// 获取配置信息
		model.addAttribute("formalCircuitConfig",
				formalCircuit.getFormalCircuitConfig());
		// 添加操作日志
		super.addLog(request, "查看申请数据详情");
		return "business/formalcircuit/detail";
	}

	/**
	 * 客服专员暂存操作
	 * 
	 * @author WangLingbin
	 * @date 2015年7月23日下午3:20:33
	 * @since 1.0.0
	 */
	@RequestMapping(value = "draft.do", method = RequestMethod.GET)
	public String draftGet(@RequestParam("id") String id,
			@ModelAttribute("pageModel") FormalCircuitQueryModel queryModel,
			HttpServletRequest request, Model model) {
		// 根据ID获取正式电路实体
		FormalCircuit formalCircuit = formalCircuitManager.findById(id);
		model.addAttribute("formalCircuit", formalCircuit);
		// 获取基础信息
		ApplyBaseInfo applyBaseInfo = formalCircuit.getApplyBaseInfo();
		// 获取审批信息集合
		List<ApproveInfo> approveInfos = approveInfoService
				.getApproveInfoByBaseInfoId(applyBaseInfo.getId());
		model.addAttribute("approveInfos", approveInfos);
		// 获取正式电路申请实体集合
		FormalCircuitQueryModel pageModel = formalCircuitManager
				.getCheckModel(id);
		model.addAttribute("m", pageModel);
		model.addAttribute("formalCircuitATMs",
				pageModel.getFormalCircuitATMli());
		model.addAttribute("formalCircuitKUs", pageModel.getFormalCircuitKUli());
		model.addAttribute("formalCircuitTESs",
				pageModel.getFormalCircuitTESli());
		model.addAttribute("formalCircuitPESs",
				pageModel.getFormalCircuitPESli());
		// 上传附件
		List<FormalCircuitAttach> attaches = formalCircuitAttachService
				.queryListByFCId(formalCircuit.getId());
		List<FormalCircuitAttachTypeEnum> formalCircuitAttachTypeEnum = Arrays
				.asList(FormalCircuitAttachTypeEnum.values());
		model.addAttribute("attaches", attaches);
		model.addAttribute("formalCircuitAttachTypeEnum",
				formalCircuitAttachTypeEnum);
		// 获取配置信息
		model.addAttribute("formalCircuitConfig",
				formalCircuit.getFormalCircuitConfig());
		return "business/formalcircuit/draft";
	}

	/**
	 * 客服专员暂存操作
	 * 
	 * @author WangLingbin
	 * @date 2015年7月23日下午3:20:33
	 * @since 1.0.0
	 */
	@RequestMapping(value = "draft.do", method = RequestMethod.POST)
	public String draftPost(@RequestParam("id") String id,
			@ModelAttribute("pageModel") FormalCircuitQueryModel queryModel,
			HttpServletRequest request, Model model) {
		// 当前登录用户
		User user = this.getCurrentUser(request);
		// 根据ID获取正式电路实体
		FormalCircuit formalCircuit = formalCircuitManager.findById(id);
		// 获取基础信息
		ApplyBaseInfo applyBaseInfo = formalCircuit.getApplyBaseInfo();
		// 添加审批记录
		ApproveInfo approveInfo = new ApproveInfo(user, applyBaseInfo,
				queryModel.getApproveRemark(), ApproveTypeEnum.draft);
		approveInfoService.save(approveInfo);
		// 添加操作日志
		super.addLog(request, "执行暂存操作");
		return "business/formalcircuit/result";
	}

	/**
	 * 审核处理
	 * 
	 * @param id
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return
	 * @date 2015年5月26日下午2:26:51
	 * @since 1.0.0
	 */
	@RequestMapping(value = "deal.do", method = RequestMethod.GET)
	public String setupDealForm(@RequestParam("id") String id,
			@ModelAttribute("pageModel") FormalCircuitQueryModel queryModel,
			HttpServletRequest request, Model model) {
		// 解决上方展示详情内容
		FormalCircuit formalCircuit = formalCircuitManager.findById(id);
		ApplyBaseInfo applyBaseInfo = formalCircuit.getApplyBaseInfo();
		FormalCircuitQueryModel pageModel = formalCircuitManager
				.getCheckModel(id);
		model.addAttribute("formalCircuit", formalCircuit);
		model.addAttribute("approveInfos", approveInfoService
				.getApproveInfoByBaseInfoId(applyBaseInfo.getId()));
		model.addAttribute("m", pageModel);
		model.addAttribute("formalCircuitATMs",
				pageModel.getFormalCircuitATMli());
		model.addAttribute("formalCircuitKUs", pageModel.getFormalCircuitKUli());
		model.addAttribute("formalCircuitTESs",
				pageModel.getFormalCircuitTESli());
		model.addAttribute("formalCircuitPESs",
				pageModel.getFormalCircuitPESli());
		// 上传附件
		List<FormalCircuitAttach> attaches = formalCircuitAttachService
				.queryListByFCId(formalCircuit.getId());
		List<FormalCircuitAttachTypeEnum> formalCircuitAttachTypeEnum = Arrays
				.asList(FormalCircuitAttachTypeEnum.values());
		model.addAttribute("attaches", attaches);
		model.addAttribute("formalCircuitAttachTypeEnum",
				formalCircuitAttachTypeEnum);
		// 获取配置信息
		model.addAttribute("formalCircuitConfig",
				formalCircuit.getFormalCircuitConfig());
		// 当前登录用户
		User user = this.getCurrentUser(request);
		model.addAttribute("user", user);
		// 获取角色为"工程师"的用户集合
		List<User> engineers = userManager.getUserByRole("engineer");
		// 获取角色为"客服专员"的用户集合
		List<User> csStaffs = userManager.getUserByRole("csStaff");
		// 获取用户角色
		StringBuffer roleNames = new StringBuffer("|");
		List<Role> roles = user.getRoles();
		queryModel.setFormalCircuit(formalCircuit);
		if (!CollectionUtils.isEmpty(roles)) {
			for (Role role : roles) {
				roleNames.append(role.getName());
				roleNames.append("|");
			}
		}
		logger.info("当前用户名：" + user.getName() + " 拥有的角色名称：" + roleNames);
		if (roleNames.toString().contains(RoleEnum.csStaff.name())) { // 客服专员
			model.addAttribute("role", "csStaff");
			List<Bureau> bureaus = new ArrayList<Bureau>();
			Bureau[] sevenBureaus = Bureau.getSevenBureaus();
			// 申请人所在管局
			Bureau bureau = queryModel.getFormalCircuit().getApplyBaseInfo()
					.getApplyUser().getBureau();
			if (!ObjectUtils.equals(bureau, null)) {
				bureau = Bureau.isBelong7Bureau(bureau.getValue());
				if (!ObjectUtils.equals(bureau, null)) { // 申请人属于7大管局
					// 剔除该用户所在管局
					for (Bureau sevenBureau : sevenBureaus) {
						if (ObjectUtils.equals(bureau, sevenBureau)) {
							continue;
						}
						bureaus.add(sevenBureau);
					}
					model.addAttribute("bureaus", bureaus);
				} else { // 申请人不属于7大管局，显示7大管局
					bureaus = Arrays.asList(sevenBureaus);
					model.addAttribute("bureaus", bureaus);
				}
			}
		} else if (roleNames.toString().contains(RoleEnum.csLeader.name())) { // 客服领导
			model.addAttribute("csStaffs", csStaffs);
			model.addAttribute("role", "csLeader");
		} else if (roleNames.toString().contains(RoleEnum.engineer.name())) { // 工程师
			model.addAttribute("engineers", engineers);
			model.addAttribute("role", "engineer");
			model.addAttribute("isVisable", true); // 申请表中，信息是否显示为输入框
		} else if (roleNames.toString().contains(RoleEnum.atncLeader.name())) { // 网控领导
			model.addAttribute("engineers", engineers);
			model.addAttribute("role", "atncLeader");
		} else if (roleNames.toString().contains(RoleEnum.fundmanager.name())) { // 财务部经理
			model.addAttribute("engineers", engineers);
			model.addAttribute("role", "fundmanager");
		}
		model.addAttribute("role", roleNames);
		return "business/formalcircuit/deal";
	}

	/**
	 * 审批处理
	 * 
	 * @author WangLingbin
	 * @date 2015年6月15日上午11:15:19
	 * @since 1.0.0
	 */
	@RequestMapping(value = "deal.do", method = RequestMethod.POST)
	public String peocessDealForm(
			HttpServletRequest request,
			Model model,
			@RequestParam("fid") String id,
			FormalCircuitQueryModel queryModel,
			// ATM
			@RequestParam(value = "ATMConfTxNodeName", required = false) List<String> ATMConfTxNodeNames,
			@RequestParam(value = "ATMConfTxSlodNum", required = false) List<String> ATMConfTxSlodNums,
			@RequestParam(value = "ATMConfTxLine", required = false) List<String> ATMConfTxLines,
			@RequestParam(value = "ATMConfTxPort", required = false) List<String> ATMConfTxPorts,
			@RequestParam(value = "ATMConfTxVpiDlci", required = false) List<String> ATMConfTxVpiDlcis,
			@RequestParam(value = "ATMConfRxNodeName", required = false) List<String> ATMConfRxNodeNames,
			@RequestParam(value = "ATMConfRxSlodNum", required = false) List<String> ATMConfRxSlodNums,
			@RequestParam(value = "ATMConfRxLine", required = false) List<String> ATMConfRxLines,
			@RequestParam(value = "ATMConfRxPort", required = false) List<String> ATMConfRxPorts,
			@RequestParam(value = "ATMConfRxVpiDlci", required = false) List<String> ATMConfRxVpiDlcis,
			@RequestParam(value = "ATMConfSpeed", required = false) List<String> ATMConfSpeeds,
			@RequestParam(value = "ATMConfServiceType", required = false) List<String> ATMConfServiceTypes,
			@RequestParam(value = "ATMConfUsage", required = false) List<String> ATMConfUsages,
			@RequestParam(value = "ATMConfTxSignal", required = false) List<String> ATMConfTxSignals,
			@RequestParam(value = "ATMConfRxSignal", required = false) List<String> ATMConfRxSignals,
			@RequestParam(value = "ATMConfNo", required = false) List<String> ATMConfNos,
			// KU
			@RequestParam(value = "KUConfTxSiteName", required = false) List<String> KUConfTxSiteNames,
			@RequestParam(value = "KUConfTxNode", required = false) List<String> KUConfTxNodes,
			@RequestParam(value = "KUConfTxSlot", required = false) List<String> KUConfTxSlots,
			@RequestParam(value = "KUConfTxPlot", required = false) List<String> KUConfTxPlots,
			@RequestParam(value = "KUConfRxSiteName", required = false) List<String> KUConfRxSiteNames,
			@RequestParam(value = "KUConfRxNode", required = false) List<String> KUConfRxNodes,
			@RequestParam(value = "KUConfRxSlot", required = false) List<String> KUConfRxSlots,
			@RequestParam(value = "KUConfRxPlot", required = false) List<String> KUConfRxPlots,
			@RequestParam(value = "KUConfSpeed", required = false) List<String> KUConfSpeeds,
			@RequestParam(value = "KUConfCommunicateWay", required = false) List<String> KUConfCommunicateWays,
			@RequestParam(value = "KUConfUsage", required = false) List<String> KUConfUsages,
			@RequestParam(value = "KUConfTxCard", required = false) List<String> KUConfTxCards,
			@RequestParam(value = "KUConfTxInterface", required = false) List<String> KUConfTxInterfaces,
			@RequestParam(value = "KUConfRxCard", required = false) List<String> KUConfRxCards,
			@RequestParam(value = "KUConfRxInterface", required = false) List<String> KUConfRxInterfaces,
			@RequestParam(value = "KUConfCircuitName", required = false) List<String> KUConfCircuitNames,
			@RequestParam(value = "KUConfNo", required = false) List<String> KUConfNos,
			// TES
			@RequestParam(value = "TESConfTxSiteName", required = false) List<String> TESConfTxSiteNames,
			@RequestParam(value = "TESConfTxCaseNum", required = false) List<String> TESConfTxCaseNums,
			@RequestParam(value = "TESConfTxSlotNum", required = false) List<String> TESConfTxSlotNums,
			@RequestParam(value = "TESConfRxSiteName", required = false) List<String> TESConfRxSiteNames,
			@RequestParam(value = "TESConfRxCaseNum", required = false) List<String> TESConfRxCaseNums,
			@RequestParam(value = "TESConfRxSlotNum", required = false) List<String> TESConfRxSlotNums,
			@RequestParam(value = "TESConfSpeed", required = false) List<String> TESConfSpeeds,
			@RequestParam(value = "TESConfCommunicateWay", required = false) List<String> TESConfCommunicateWays,
			@RequestParam(value = "TESConfUsage", required = false) List<String> TESConfUsages,
			@RequestParam(value = "TESConfTxInterface", required = false) List<String> TESConfTxInterfaces,
			@RequestParam(value = "TESConfRxInterface", required = false) List<String> TESConfRxInterfaces,
			@RequestParam(value = "TESConfClock", required = false) List<String> TESConfClocks,
			@RequestParam(value = "TESConfCircuitName", required = false) List<String> TESConfCircuitNames,
			@RequestParam(value = "TESConfNo", required = false) List<String> TESConfNos,
			// PES
			@RequestParam(value = "PESConfTxSiteName", required = false) List<String> PESConfTxSiteNames,
			@RequestParam(value = "PESConfTxCaseNum", required = false) List<String> PESConfTxCaseNums,
			@RequestParam(value = "PESConfTxSlotNum", required = false) List<String> PESConfTxSlotNums,
			@RequestParam(value = "PESConfTxPortNum", required = false) List<String> PESConfTxPortNums,
			@RequestParam(value = "PESConfRxSiteName", required = false) List<String> PESConfRxSiteNames,
			@RequestParam(value = "PESConfRxCaseNum", required = false) List<String> PESConfRxCaseNums,
			@RequestParam(value = "PESConfRxSlotNum", required = false) List<String> PESConfRxSlotNums,
			@RequestParam(value = "PESConfRxPortNum", required = false) List<String> PESConfRxPortNums,
			@RequestParam(value = "PESConfSpeed", required = false) List<String> PESConfSpeeds,
			@RequestParam(value = "PESConfCommunicateWay", required = false) List<String> PESConfCommunicateWays,
			@RequestParam(value = "PESConfUsage", required = false) List<String> PESConfUsages,
			@RequestParam(value = "PESConfTxInterface", required = false) List<String> PESConfTxInterfaces,
			@RequestParam(value = "PESConfRxInterface", required = false) List<String> PESConfRxInterfaces,
			@RequestParam(value = "PESConfCircuitName", required = false) List<String> PESConfCircuitNames,
			@RequestParam(value = "PESConfNo", required = false) List<String> PESConfNos,
			// 备注信息
			@RequestParam(value = "confRemark", required = false) String confRemark) {
		try{
			//当前登陆用户
			User user =  this.getCurrentUser(request);
			//处理审批请求
			FormalCircuit formalCircuit = formalCircuitManager.doCheck(request, id, queryModel, user);
			if(!ObjectUtils.equals(formalCircuit.getApproveStat(),FormalStatEnum.engineer_transfer)){
				//处理配置信息
				if(CollectionUtils.isNotEmpty(ATMConfTxNodeNames)) {
					formalCircuitATMManager.dealATMConf(id, queryModel,
							ATMConfTxNodeNames, ATMConfTxSlodNums,
							ATMConfTxLines, ATMConfTxPorts, ATMConfTxVpiDlcis,
							ATMConfRxNodeNames, ATMConfRxSlodNums,
							ATMConfRxLines, ATMConfRxPorts, ATMConfRxVpiDlcis,
							ATMConfSpeeds, ATMConfServiceTypes, ATMConfUsages,
							ATMConfTxSignals, ATMConfRxSignals, ATMConfNos,
							confRemark);
				}
				if (CollectionUtils.isNotEmpty(KUConfTxSiteNames)) {
					formalCircuitKUManager.dealKUConf(id, queryModel,
							KUConfTxSiteNames, KUConfTxNodes, KUConfTxSlots,
							KUConfTxPlots, KUConfRxSiteNames, KUConfRxNodes,
							KUConfRxSlots, KUConfRxPlots, KUConfSpeeds,
							KUConfCommunicateWays, KUConfUsages, KUConfTxCards,
							KUConfTxInterfaces, KUConfRxCards,
							KUConfRxInterfaces, KUConfCircuitNames, KUConfNos,
							confRemark);
				}
				if (CollectionUtils.isNotEmpty(TESConfTxSiteNames)) {
					formalCircuitTESManager.dealTESConf(id, queryModel,
							TESConfTxSiteNames, TESConfTxCaseNums,
							TESConfTxSlotNums, TESConfRxSiteNames,
							TESConfRxCaseNums, TESConfRxSlotNums,
							TESConfSpeeds, TESConfCommunicateWays,
							TESConfUsages, TESConfTxInterfaces,
							TESConfRxInterfaces, TESConfClocks,
							TESConfCircuitNames, TESConfNos, confRemark);
				}
				if (CollectionUtils.isNotEmpty(PESConfTxSiteNames)) {
					formalCircuitPESManager.dealPESConf(id, queryModel,
							PESConfTxSiteNames, PESConfTxCaseNums,
							PESConfTxSlotNums, PESConfTxPortNums,
							PESConfRxSiteNames, PESConfRxCaseNums,
							PESConfRxSlotNums, PESConfRxPortNums,
							PESConfSpeeds, PESConfCommunicateWays,
							PESConfUsages, PESConfTxInterfaces,
							PESConfRxInterfaces, PESConfCircuitNames,
							PESConfNos, confRemark);
				}
			}
			// formalCircuitManager.doCheck(id,
			// queryModel.getFlag(),queryModel.getApproveRemark(),user);
			addSuccess(model, "处理成功！");
			// 添加操作日志
			super.addLog(request, "客服专员处理成功(联系人:"
					+ formalCircuit.getApplyBaseInfo().getApplyLinkman() + ")");
		} catch (Exception e) {
			e.printStackTrace();
			addSuccess(model, "处理失败！原因是：" + e.getMessage());
		}
		return "business/formalcircuit/result";
	}

	/**
	 * ATM报表
	 *
	 * @param request
	 * @param mav
	 * @param response
	 * @param id
	 * @return
	 * @date 2015年7月10日上午8:30:47
	 * @since 1.0.0
	 */
	@RequestMapping(value = "previewATM.dox")
	public ModelAndView previewATM(HttpServletRequest request,
			ModelAndView mav, HttpServletResponse response,
			@RequestParam("id") String id) {
		Map<String, Object> param = formalCircuitManager.getReportParams(
				request, id, JasperReportsEnum.ATM.toString());
		param.put("format", "pdf");
		mav = new ModelAndView(JasperReportsEnum.ATM.toString(), param);
		// 添加操作日志
		super.addLog(request, "申请表预览");
		return mav;
	}

	/**
	 * TES报表
	 *
	 * @param request
	 * @param mav
	 * @param response
	 * @param id
	 * @return
	 * @date 2015年7月10日上午8:30:37
	 * @since 1.0.0
	 */
	@RequestMapping(value = "previewTES.dox")
	public ModelAndView previewTES(HttpServletRequest request,
			ModelAndView mav, HttpServletResponse response,
			@RequestParam("id") String id) {
		Map<String, Object> param = formalCircuitManager.getReportParams(
				request, id, JasperReportsEnum.TES.toString());
		param.put("format", "pdf");
		mav = new ModelAndView(JasperReportsEnum.TES.toString(), param);
		// 添加操作日志
		super.addLog(request, "申请表预览");
		return mav;
	}

	/**
	 * PES报表
	 * 
	 * @author 段衍林
	 * @2017年1月9日 上午9:01:16
	 * @param request
	 * @param mav
	 * @param response
	 * @param id
	 * @return ModelAndView
	 */
	@RequestMapping(value = "previewPES.dox")
	public ModelAndView previewPES(HttpServletRequest request,
			ModelAndView mav, HttpServletResponse response,
			@RequestParam("id") String id) {
		Map<String, Object> param = formalCircuitManager.getReportParams(
				request, id, JasperReportsEnum.PES.toString());
		param.put("format", "pdf");
		mav = new ModelAndView(JasperReportsEnum.PES.toString(), param);
		// 添加操作日志
		super.addLog(request, "申请表预览");
		return mav;
	}

	/**
	 * KU报表
	 *
	 * @param request
	 * @param mav
	 * @param response
	 * @param id
	 * @return
	 * @date 2015年7月10日上午8:30:25
	 * @since 1.0.0
	 */
	@RequestMapping(value = "previewKU.dox")
	public ModelAndView previewKU(HttpServletRequest request, ModelAndView mav,
			HttpServletResponse response, @RequestParam("id") String id) {
		Map<String, Object> param = formalCircuitManager.getReportParams(
				request, id, JasperReportsEnum.KU.toString());
		param.put("format", "pdf");
		mav = new ModelAndView(JasperReportsEnum.KU.toString(), param);
		// 添加操作日志
		super.addLog(request, "申请表预览");
		return mav;
	}

	/**
	 * 正式电路ATM配置表预览
	 * 
	 * @author WangLingbin
	 * @date 2015年11月9日下午3:13:01
	 * @since 1.0.0
	 */
	@RequestMapping(value = "previewATMConfig.dox")
	public ModelAndView previewATMConfig(HttpServletRequest request,
			ModelAndView mav, HttpServletResponse response,
			@RequestParam("id") String id) {
		Map<String, Object> param = formalCircuitManager.getReportParams(
				request, id, JasperReportsEnum.ATM_config.toString());
		param.put("format", "pdf");
		mav = new ModelAndView(JasperReportsEnum.ATM_config.toString(), param);
		// 添加操作日志
		super.addLog(request, "配置表预览");
		return mav;
	}

	/**
	 * 正式电路KU配置表预览
	 * 
	 * @author WangLingbin
	 * @date 2015年11月9日下午3:13:01
	 * @since 1.0.0
	 */
	@RequestMapping(value = "previewKUConfig.dox")
	public ModelAndView previewKUConfig(HttpServletRequest request,
			ModelAndView mav, HttpServletResponse response,
			@RequestParam("id") String id) {
		Map<String, Object> param = formalCircuitManager.getReportParams(
				request, id, JasperReportsEnum.KU_config.toString());
		param.put("format", "pdf");
		mav = new ModelAndView(JasperReportsEnum.KU_config.toString(), param);
		// 添加操作日志
		super.addLog(request, "配置表预览");
		return mav;
	}

	/**
	 * 正式电路TES配置表预览
	 * 
	 * @author WangLingbin
	 * @date 2015年11月9日下午3:13:01
	 * @since 1.0.0
	 */
	@RequestMapping(value = "previewTESConfig.dox")
	public ModelAndView previewTESConfig(HttpServletRequest request,
			ModelAndView mav, HttpServletResponse response,
			@RequestParam("id") String id) {
		Map<String, Object> param = formalCircuitManager.getReportParams(
				request, id, JasperReportsEnum.TES_config.toString());
		param.put("format", "pdf");
		mav = new ModelAndView(JasperReportsEnum.TES_config.toString(), param);
		// 添加操作日志
		super.addLog(request, "配置表预览");
		return mav;
	}

	/**
	 * 正式电路TES配置表预览
	 * 
	 * @author 段衍林
	 * @2017年1月9日 上午11:19:27
	 * @param request
	 * @param mav
	 * @param response
	 * @param id
	 * @return ModelAndView
	 */
	@RequestMapping(value = "previewPESConfig.dox")
	public ModelAndView previewPESConfig(HttpServletRequest request,
			ModelAndView mav, HttpServletResponse response,
			@RequestParam("id") String id) {
		Map<String, Object> param = formalCircuitManager.getReportParams(
				request, id, JasperReportsEnum.PES_config.toString());
		param.put("format", "pdf");
		mav = new ModelAndView(JasperReportsEnum.PES_config.toString(), param);
		// 添加操作日志
		super.addLog(request, "配置表预览");
		return mav;
	}

	/**
	 * 附件下载
	 *
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @author Wang Zhicheng
	 * @date 2015年10月21日下午2:35:08
	 * @since 1.0.0
	 */
	@RequestMapping(value = "download.do", method = RequestMethod.GET)
	public void download(@RequestParam("id") String id,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		try {
			FormalCircuitAttach formalCircuitAttach = formalCircuitAttachService
					.findById(id);
			String destUrl = formalCircuitAttach.getAttachAddress();
			URL url = new URL(destUrl);
			HttpURLConnection httpUrl = (HttpURLConnection) url
					.openConnection();
			// 连接指定的网络资源
			httpUrl.connect();
			// 获取网络输入流
			BufferedInputStream bis = new BufferedInputStream(
					httpUrl.getInputStream());
			this.doDownLoad(request, response, bis,
					formalCircuitAttach.getAttachName());
			// 添加操作日志
			super.addLog(request, "附件下载");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 下载退回的申请表信息留存
	 * 
	 * @param request
	 * @param response
	 * @param filePath
	 * @throws IOException
	 * @author WangLingbin
	 * @date 2015年11月10日下午3:41:52
	 * @since 1.0.0
	 */
	@RequestMapping(value = "downloadReturnedReport.do")
	public void downloadReturnedReport(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "reportAddress", required = false) String reportAddress,
			@RequestParam(value = "outlineAddress", required = false) String outlineAddress)
			throws IOException {
		try {
			// 检查文件后缀名
			String fileExt = JasperReportUtils.getFileExt(reportAddress);
			// 若为报表附件
			if (StringUtils.equalsIgnoreCase(fileExt,
					JasperReportUtils.getReportExt())) {
				JasperPrint jasperPrint = (JasperPrint) JRLoader
						.loadObject(new File(reportAddress));
				byte[] data = JasperReportUtils.exportReport("pdf", request,
						jasperPrint);
				this.doDownLoad(request, response, data,
						ReturnedReportsEnum.formalcircuit.getValue());
			} else {
				URL url = new URL(outlineAddress);
				HttpURLConnection httpUrl = (HttpURLConnection) url
						.openConnection();
				// 连接指定的网络资源
				httpUrl.connect();
				// 获取网络输入流
				BufferedInputStream bis = new BufferedInputStream(
						httpUrl.getInputStream());
				this.doDownLoad(request, response, bis,
						ReturnedReportsEnum.auditFile.getValue() + "."
								+ fileExt);
			}
		} catch (JRException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}