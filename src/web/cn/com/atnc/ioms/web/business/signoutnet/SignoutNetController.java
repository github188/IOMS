package cn.com.atnc.ioms.web.business.signoutnet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.acl.UserRole;
import cn.com.atnc.ioms.entity.business.approveinfo.ApproveInfo;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.signoutnet.SignoutNet;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveTypeEnum;
import cn.com.atnc.ioms.enums.business.satellite.ApproveStatEnum;
import cn.com.atnc.ioms.enums.business.signoutnet.SignoutNetTypeEnum;
import cn.com.atnc.ioms.enums.reports.ImageNameEnum;
import cn.com.atnc.ioms.enums.reports.JasperReportsEnum;
import cn.com.atnc.ioms.mng.business.approveinfo.IApproveInfoService;
import cn.com.atnc.ioms.mng.business.baseinfo.IApplyBaseInfoService;
import cn.com.atnc.ioms.mng.business.evaluete.IEvalueteManager;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteAttachService;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteConfigService;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteService;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteWorkflowService;
import cn.com.atnc.ioms.mng.business.signoutnet.ISignoutNetConfigService;
import cn.com.atnc.ioms.mng.business.signoutnet.ISignoutNetManager;
import cn.com.atnc.ioms.mng.reports.JasperReportService;
import cn.com.atnc.ioms.model.business.signoutnet.SignoutNetQueryModel;
import cn.com.atnc.ioms.model.business.signoutnet.SignoutNetReortModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 通信网退网
 *
 * @author 段衍林
 * @2017年1月13日 上午11:20:54
 */
@Controller
@RequestMapping("/signoutnet/")
public class SignoutNetController extends MyBaseController {

	@Autowired
	private ISignoutNetManager signoutNetManager;

	@Autowired
	private IKuSatelliteService kuSatelliteService;
	@Autowired
	private IKuSatelliteConfigService kuSatelliteConfigService;
	@Autowired
	private IApplyBaseInfoService applyBaseInfoService;
	@Autowired
	private IApproveInfoService approveInfoService;
	@Autowired
	private IEvalueteManager evaluateManager;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IKuSatelliteAttachService kuSatelliteAttachService;
	@Autowired
	private IKuSatelliteWorkflowService workflowService;
	@Autowired
	private JasperReportService jasperReportService;
	@Autowired
	private ISignoutNetConfigService signoutNetConfigService;

	/**
	 * 页面初始化
	 * 
	 * @author 段衍林
	 * @2017年1月13日 上午11:27:16
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "tasklist.do", method = RequestMethod.GET)
	public String manage(HttpServletRequest request, Model model) {
		super.pageInfo(model, request);
		return "business/signoutnet/manage";
	}

	/**
	 * 页面数据加载
	 * 
	 * @author 段衍林
	 * @2017年1月13日 上午11:27:23
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "tasklist.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") SignoutNetQueryModel queryModel,
			HttpServletRequest request, Model model) {
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
		List<ApproveStatEnum> approveStatList = new ArrayList<ApproveStatEnum>();
		if (roleNames.toString().contains("|" + RoleEnum.csLeader.name() + "|")) { // 客服领导
			approveStatList.add(ApproveStatEnum.csleader_review);
		}
		if (roleNames.toString().contains("|" + RoleEnum.csStaff.name() + "|")) { // 客服专员
			approveStatList.add(ApproveStatEnum.csstaff_audit);
			approveStatList.add(ApproveStatEnum.csstaff_deal);
			// queryModel.setNextUser(user.getId()); //该查询条件查询上一步分配给自己的记录
			model.addAttribute("role", RoleEnum.csStaff.name());
		}
		if (roleNames.toString().contains(
				"|" + RoleEnum.atncLeader.name() + "|")) {// 网控领导
			approveStatList.add(ApproveStatEnum.atncleader_firstdeal);
			approveStatList.add(ApproveStatEnum.atncleader_review);
			approveStatList.add(ApproveStatEnum.atncleader_approve);
			// 网控领导分配审核工程师
			approveStatList.add(ApproveStatEnum.atncleader_audit);
		}
		if (roleNames.toString().contains("|" + RoleEnum.engineer.name() + "|")) { // 工程师
			approveStatList.add(ApproveStatEnum.engineer_firstaudit);
			approveStatList.add(ApproveStatEnum.engineer_config);
			approveStatList.add(ApproveStatEnum.assist_config);
			approveStatList.add(ApproveStatEnum.engineer_audit);
			queryModel.setNextUser(user.getId()); // 该查询条件查询上一步移交给自己的记录
			model.addAttribute("role", RoleEnum.engineer.name());
		}
		if (roleNames.toString().contains("|" + RoleEnum.manager.name() + "|")) { // 营销事业部总经理
			approveStatList.add(ApproveStatEnum.marketmanager_approve);
		}
		if (roleNames.toString().contains(
				"|" + RoleEnum.netmanager.name() + "|")) {
			approveStatList.add(ApproveStatEnum.netmanager_approve);
		}
		if (roleNames.toString().contains("|" + RoleEnum.leader.name() + "|")) {
			approveStatList.add(ApproveStatEnum.leader_approve);
		}
		if (roleNames.toString().contains(
				"|" + RoleEnum.fundmanager.name() + "|")) {
			approveStatList.add(ApproveStatEnum.fundmanager_confirm);
		}
		model.addAttribute("role", roleNames);
		queryModel.setStatusList(approveStatList);
		model.addAttribute("pagn", signoutNetManager.queryPage(queryModel));
		return "business/signoutnet/queryResult";
	}

	/**
	 * 异步加载数据，显示数据条数 冒泡查询
	 * 
	 * @author 段衍林
	 * @2017年1月13日 上午11:37:19
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 */
	@RequestMapping(value = "ajaxLoad.dox", method = RequestMethod.GET)
	public String ajaxLoad(
			@ModelAttribute("queryModel") SignoutNetQueryModel queryModel,
			HttpServletRequest request, Model model) throws IOException {
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
		List<ApproveStatEnum> approveStatList = new ArrayList<ApproveStatEnum>();
		if (roleNames.toString().contains("|" + RoleEnum.csLeader.name() + "|")) { // 客服领导
			approveStatList.add(ApproveStatEnum.csleader_review);
		}
		if (roleNames.toString().contains("|" + RoleEnum.csStaff.name() + "|")) { // 客服专员
			approveStatList.add(ApproveStatEnum.csstaff_audit);
			approveStatList.add(ApproveStatEnum.csstaff_deal);
			// queryModel.setNextUser(user.getId()); //该查询条件查询上一步分配给自己的记录
			model.addAttribute("role", RoleEnum.csStaff.name());
		}
		if (roleNames.toString().contains(
				"|" + RoleEnum.atncLeader.name() + "|")) {// 网控领导
			approveStatList.add(ApproveStatEnum.atncleader_firstdeal);
			approveStatList.add(ApproveStatEnum.atncleader_review);
			approveStatList.add(ApproveStatEnum.atncleader_approve);
			// 网控领导分配审核工程师
			approveStatList.add(ApproveStatEnum.atncleader_audit);
		}
		if (roleNames.toString().contains("|" + RoleEnum.engineer.name() + "|")) { // 工程师
			approveStatList.add(ApproveStatEnum.engineer_firstaudit);
			approveStatList.add(ApproveStatEnum.engineer_config);
			approveStatList.add(ApproveStatEnum.assist_config);
			approveStatList.add(ApproveStatEnum.engineer_audit);
			queryModel.setNextUser(user.getId()); // 该查询条件查询上一步移交给自己的记录
			model.addAttribute("role", RoleEnum.engineer.name());
		}
		if (roleNames.toString().contains("|" + RoleEnum.manager.name() + "|")) { // 营销事业部总经理
			approveStatList.add(ApproveStatEnum.marketmanager_approve);
		}
		if (roleNames.toString().contains(
				"|" + RoleEnum.netmanager.name() + "|")) {
			approveStatList.add(ApproveStatEnum.netmanager_approve);
		}
		if (roleNames.toString().contains("|" + RoleEnum.leader.name() + "|")) {
			approveStatList.add(ApproveStatEnum.leader_approve);
		}
		if (roleNames.toString().contains(
				"|" + RoleEnum.fundmanager.name() + "|")) {
			approveStatList.add(ApproveStatEnum.fundmanager_confirm);
		}
		model.addAttribute("role", roleNames);
		queryModel.setStatusList(approveStatList);
		model.addAttribute("returnStr",
				JacksonTools.toJsonStr(signoutNetManager.queryPage(queryModel)));
		return "returnnote";
	}

	/**
	 * 查看详情
	 * 
	 * @author 段衍林
	 * @2017年1月13日 上午11:37:34
	 * @param id
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "detail.do", method = RequestMethod.GET)
	public String setupDetailForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		SignoutNet signOutNet = (SignoutNet) signoutNetManager.findById(id);
		ApplyBaseInfo applyBaseInfo = signOutNet.getApplyBaseInfo();
		model.addAttribute("approveInfos", approveInfoService
				.getApproveInfoByBaseInfoId(applyBaseInfo.getId()));
		model.addAttribute("signoutNet", signOutNet);
		// 配置信息
		model.addAttribute("signoutNetConfig",
				signoutNetConfigService.findBySignoutNetId(id));
		// 评价信息
		model.addAttribute("evaluateInfo",
				evaluateManager.findByApplyBaseInfoId(applyBaseInfo.getId()));
		// 添加操作日志
		super.addLog(request, "查看退网申请数据详情");
		return "business/signoutnet/detail";
	}

	/**
	 * 暂存
	 *
	 * @author 段衍林
	 * @2017年1月16日 上午9:39:16
	 * @param id
	 *            退网记录id
	 * @param queryModel
	 *            查询model
	 * @param request
	 *            请求
	 * @param model
	 *            model
	 * @return String 返回地址
	 */
	@RequestMapping(value = "draft.do", method = RequestMethod.GET)
	public String draftGet(@RequestParam("id") String id,
			@ModelAttribute("pageModel") SignoutNetQueryModel queryModel,
			HttpServletRequest request, Model model) {
		// 根据ID获取退网申请实体
		SignoutNet signoutNet = (SignoutNet) signoutNetManager.findById(id);
		model.addAttribute("signoutNet", signoutNet);
		// 获取基础信息
		ApplyBaseInfo applyBaseInfo = signoutNet.getApplyBaseInfo();
		// 获取审批信息集合
		List<ApproveInfo> approveInfos = approveInfoService
				.getApproveInfoByBaseInfoId(applyBaseInfo.getId());
		model.addAttribute("approveInfos", approveInfos);
		// 获取正式电路申请实体集合
		return "business/signoutnet/draft";
	}

	/**
	 * 客服专员暂存操作 操作
	 * 
	 * @author 段衍林
	 * @2017年1月16日 上午9:40:45
	 * @param id
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "draft.do", method = RequestMethod.POST)
	public String draftPost(@RequestParam("id") String id,
			@ModelAttribute("pageModel") SignoutNetQueryModel queryModel,
			HttpServletRequest request, Model model) {
		// 当前登录用户
		User user = this.getCurrentUser(request);
		// 根据ID获取退网申请实体
		SignoutNet signoutNet = (SignoutNet) signoutNetManager.findById(id);
		// 获取基础信息
		ApplyBaseInfo applyBaseInfo = signoutNet.getApplyBaseInfo();
		// 添加审批记录
		ApproveInfo approveInfo = new ApproveInfo(user, applyBaseInfo,
				queryModel.getApproveRemark(), ApproveTypeEnum.draft);
		approveInfoService.save(approveInfo);
		// 添加操作日志
		super.addLog(request, "执行暂存操作");
		return "business/signoutnet/result";
	}

	/**
	 * 处理操作
	 * 
	 * @author 段衍林
	 * @2017年1月13日 下午3:10:14
	 * @param id
	 *            退网申请id
	 * @param queryModel
	 *            查询model
	 * @param request
	 *            请求
	 * @param model
	 *            model
	 * @return String 返回值
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "deal.do", method = RequestMethod.GET)
	public String setupDealForm(@RequestParam("id") String id,
			@ModelAttribute("pageModel") SignoutNetQueryModel queryModel,
			HttpServletRequest request, Model model) {

		// 解决上方展示详情内容
		SignoutNet signOutNet = (SignoutNet) signoutNetManager.findById(id);
		ApplyBaseInfo applyBaseInfo = signOutNet.getApplyBaseInfo();
		model.addAttribute("approveInfos", approveInfoService
				.getApproveInfoByBaseInfoId(applyBaseInfo.getId()));
		model.addAttribute("signoutNet", signOutNet);
		model.addAttribute("signoutNetConf",
				signoutNetConfigService.findBySignoutNetId(id));
		// 当前登录用户
		User user = this.getCurrentUser(request);
		// 获取角色为"工程师"的用户集合
		List<UserRole> userRoles = new ArrayList<UserRole>();
		userRoles = (List<UserRole>) userDao.queryList(
				"from UserRole where role.name=?", "engineer");
		List<User> engineers = new ArrayList<User>();
		for (UserRole userRole : userRoles) {
			if (!StringUtils.equals(userRole.getUser().getName(),
					user.getName())) {
				engineers.add(userRole.getUser());
			}
		}
		// 获取角色为"客服专员"的用户集合
		userRoles = (List<UserRole>) userDao.queryList(
				"from UserRole where role.name=?", "csStaff");
		List<User> csStaffs = new ArrayList<User>();
		for (UserRole userRole : userRoles) {
			if (!StringUtils.equals(userRole.getUser().getName(),
					user.getName())) {
				csStaffs.add(userRole.getUser());
			}
		}
		StringBuffer roleNames = new StringBuffer("|");
		List<Role> roles = user.getRoles();
		if (!CollectionUtils.isEmpty(roles)) {
			for (Role role : roles) {
				roleNames.append(role.getName());
				roleNames.append("|");
			}
		}
		logger.info("当前用户名：" + user.getName() + " 拥有的角色名称：" + roleNames);
		if (roleNames.toString().contains("|csStaff|")) { // 客服专员
			model.addAttribute("role", "csStaff");
		} else if (roleNames.toString().contains("|csLeader|")) { // 客服领导
			model.addAttribute("csStaffs", csStaffs);
			model.addAttribute("role", "csLeader");
		} else if (roleNames.toString().contains("|engineer|")) { // 工程师
			model.addAttribute("engineers", engineers);
			model.addAttribute("role", "engineer");
		} else if (roleNames.toString().contains("|atncLeader|")) {// 网控领导
			model.addAttribute("engineers", engineers);
			model.addAttribute("role", "atncLeader");
		} else if (roleNames.toString().contains("|manager|")) {
			model.addAttribute("role", "manager");
		} else if (roleNames.toString().contains("|netmanager|")) {
			model.addAttribute("role", "netmanager");
		} else if (roleNames.toString().contains("|leader|")) {
			model.addAttribute("role", "leader");
		} else if (roleNames.toString().contains("|fundmanager|")) {
			model.addAttribute("role", "fundmanager");
		}
		model.addAttribute("role", roleNames);
		return "business/signoutnet/deal";
	}

	/**
	 * 处理操作
	 * 
	 * @author 段衍林
	 * @2017年1月13日 下午3:15:49
	 * @param request
	 * @param model
	 * @param queryModel
	 * @param node
	 * @param mediumFrequency
	 * @param emissionFrequency
	 * @param receiveFrequency
	 * @return String
	 */
	@RequestMapping(value = "deal.do", method = RequestMethod.POST)
	public String peocessDealForm(
			HttpServletRequest request,
			Model model,
			SignoutNetQueryModel queryModel,
			@RequestParam(value = "node", required = false) String node,
			@RequestParam(value = "mediumFrequency", required = false) String mediumFrequency,
			@RequestParam(value = "emissionFrequency", required = false) String emissionFrequency,
			@RequestParam(value = "receiveFrequency", required = false) String receiveFrequency,
			@RequestParam(value = "placeATM", required = false) String placeATM,
			@RequestParam(value = "placeATMO", required = false) String placeATMO,
			@RequestParam(value = "connectivity", required = false) String connectivity,
			@RequestParam(value = "nodemng", required = false) String nodemng,
			@RequestParam(value = "confRemark", required = false) String confRemark) {
		try {
			// 当前登录用户
			User user = this.getCurrentUser(request);
			SignoutNet signOutNet = signoutNetManager
					.dealForm(queryModel, user);
			// 如果为配置阶段，则保存配置信息
			if (queryModel.isApproveStat()) { // 操作类别（true：配置/false:移交）
				// 退网配置
				if (ObjectUtils.equals(signOutNet.getDealType(),
						SignoutNetTypeEnum.signoutnet_atm)) {
					if (StringUtils.isNotEmpty(confRemark)) {
						// ATM配置
						signoutNetConfigService.configATM(queryModel, user,
								placeATM, placeATMO, connectivity, nodemng,
								confRemark);
					}
				} else {
					if (StringUtils.isNotEmpty(node)
							&& StringUtils.isNotEmpty(mediumFrequency)) {
						// KU配置
						signoutNetConfigService.configKU(queryModel, user,
								node, mediumFrequency, emissionFrequency,
								receiveFrequency);
					}
				}
			}
			addSuccess(model, "处理成功！");
			// 添加操作日志
			super.addLog(request, "客服专员处理成功(联系人:"
					+ signOutNet.getApplyBaseInfo().getApplyLinkman() + ")");
		} catch (Exception e) {
			e.printStackTrace();
			addSuccess(model, "处理失败！原因是：" + e.getMessage());
		}
		return "business/signoutnet/result";
	}

	/**
	 * 下载退网申请表
	 * 
	 * @author 段衍林
	 * @2017年1月12日 上午11:04:34
	 * @param request
	 * @param mav
	 * @param id
	 * @return ModelAndView
	 */
	@RequestMapping(value = "previewApply.dox")
	public ModelAndView previewConfig(HttpServletRequest request,
			ModelAndView mav, @RequestParam("id") String id) {
		// 1.主报表数据源
		List<SignoutNetReortModel> datasource = signoutNetManager
				.getReportDateSource(id);
		// 3.获取报表相关参数，供预览使用
		Map<String, Object> param = null;
		// 根据ID获取通信网站点退网申请记录对象
		SignoutNet signOutNet = signoutNetManager.findById(id);
		// 判断用印审批为是否为true，如果是，则显示公章，否则不显示。
		if (ObjectUtils.equals(signOutNet.getDealType(),
				SignoutNetTypeEnum.signoutnet_atm)) {
			/**
			 * 民航ATM数据通信网节点退网
			 */
			if (signOutNet.getCachetApprove() == 0) {
				param = jasperReportService.preView(request, datasource,
						JasperReportsEnum.signoutnet_atm.toString());
			} else {
				param = jasperReportService.preView(request, datasource,
						ImageNameEnum.atncCachet.getValue(),
						JasperReportsEnum.signoutnet_atm.toString());
			}
			param.put("format", "pdf");
			mav = new ModelAndView(JasperReportsEnum.signoutnet_atm.toString(),
					param);
		} else {
			/**
			 * 民航卫星通信网站点退网
			 */
			if (signOutNet.getCachetApprove() == 0) {
				param = jasperReportService.preView(request, datasource,
						JasperReportsEnum.signoutnet_ku.toString());
			} else {
				param = jasperReportService.preView(request, datasource,
						ImageNameEnum.atncCachet.getValue(),
						JasperReportsEnum.signoutnet_ku.toString());
			}
			param.put("format", "pdf");
			mav = new ModelAndView(JasperReportsEnum.signoutnet_ku.toString(),
					param);
		}
		return mav;
	}

}