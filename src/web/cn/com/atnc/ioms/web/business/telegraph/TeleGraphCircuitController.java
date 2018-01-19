package cn.com.atnc.ioms.web.business.telegraph;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
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
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraph;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphAttach;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphCircuit;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveTypeEnum;
import cn.com.atnc.ioms.enums.business.telegraph.TeleAttachTypeEnum;
import cn.com.atnc.ioms.enums.business.telegraph.TeleGraphApproveStatEnum;
import cn.com.atnc.ioms.enums.reports.JasperReportsEnum;
import cn.com.atnc.ioms.enums.reports.ReturnedReportsEnum;
import cn.com.atnc.ioms.mng.business.approveinfo.IApproveInfoService;
import cn.com.atnc.ioms.mng.business.baseinfo.IApplyBaseInfoService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphAttachService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphCircuitService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphService;
import cn.com.atnc.ioms.mng.reports.JasperReportService;
import cn.com.atnc.ioms.model.business.telegraph.TeleGraphQueryModel;
import cn.com.atnc.ioms.util.JasperReportUtils;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 转报地址申请Controller
 *
 * @author WangLingbin
 * @date 2015年5月28日 下午2:40:27
 * @since 1.0.0
 */
@Controller
@RequestMapping("/telegraphcircuit/")
public class TeleGraphCircuitController extends MyBaseController {
	
	@Autowired
	private TeleGraphService teleGraphService;
	@Autowired
	private TeleGraphCircuitService teleGraphCircuitService;
	@Autowired
	private IApplyBaseInfoService applyBaseInfoService;
	@Autowired
	private IApproveInfoService approveInfoService;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private JasperReportService jasperReportService;
	@Autowired
	private TeleGraphAttachService teleGraphAttachService;
	
	/**
	 * 页面初始化
	 * @author WangLingbin
	 * @date  2015年10月20日下午1:57:41
	 * @since 1.0.0
	 */
	@RequestMapping(value = "tasklist.do", method = RequestMethod.GET)
	public String manage(HttpServletRequest request, Model model) {
		super.pageInfo(model, request);
		return "business/telegraphcircuit/manage";
	}

	/**
	 * 加载数据，返回前台显示
	 * @author WangLingbin
	 * @date  2015年10月20日下午1:57:51
	 * @since 1.0.0
	 */
	@RequestMapping(value = "tasklist.do", method = RequestMethod.POST)
	public String manageList(@ModelAttribute("queryModel") TeleGraphQueryModel queryModel,
			HttpServletRequest request, Model model) {
		//当前用户
		User user = this.getCurrentUser(request);
		StringBuffer roleNames = new StringBuffer("|");
		List<Role> roles = user.getRoles();
		if(!CollectionUtils.isEmpty(roles)){
			for (Role role : roles) {
				roleNames.append(role.getName());
				roleNames.append("|");
			}
		}
		logger.info("当前用户名："+user.getName() + " 拥有的角色名称：" + roleNames);
		//获取审批记录
		//根据不同角色获取不同的数据
		List<TeleGraphApproveStatEnum> approveStatList = new ArrayList<TeleGraphApproveStatEnum>();
		//筛选转报电路申请信息，与转报地址分开
		List<TeleGraphCircuit> teleGraphCircuits = teleGraphCircuitService.getAll();
		queryModel.setTeleGraphCircuits(teleGraphCircuits);
		if (roleNames.toString().contains("|"+RoleEnum.csLeader.name()+"|")){ // 客服领导
			approveStatList.add(TeleGraphApproveStatEnum.csleader_review);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn", teleGraphCircuitService.queryPageByModel(queryModel));
		}
		if(roleNames.toString().contains("|" + RoleEnum.csStaff.name() + "|")){ // 客服专员
			approveStatList.add(TeleGraphApproveStatEnum.csstaff_audit);
			approveStatList.add(TeleGraphApproveStatEnum.csstaff_deal);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("role", RoleEnum.csStaff.name());
			model.addAttribute("pagn", teleGraphCircuitService.queryPageByModel(queryModel));
		}
		if(roleNames.toString().contains("|"+RoleEnum.atncLeader.name()+"|")){// 网控领导
			approveStatList.add(TeleGraphApproveStatEnum.atncleader_firstdeal);
			approveStatList.add(TeleGraphApproveStatEnum.atncleader_review);
			approveStatList.add(TeleGraphApproveStatEnum.atncleader_approve);
			//网控领导分配审核工程师
			approveStatList.add(TeleGraphApproveStatEnum.atncleader_audit);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn", teleGraphCircuitService.queryPageByModel(queryModel));
		}
		if(roleNames.toString().contains("|" + RoleEnum.manager.name() + "|")) {		//事业部总经理
			approveStatList.add(TeleGraphApproveStatEnum.generalmanager_approve);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn", teleGraphCircuitService.queryPageByModel(queryModel));
		}
		if(roleNames.toString().contains("|" + RoleEnum.fundmanager.name() + "|")) {		//事业部总经理
			approveStatList.add(TeleGraphApproveStatEnum.fundmanager_confirm);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn", teleGraphCircuitService.queryPageByModel(queryModel));
		}
		if(roleNames.toString().contains("|" + RoleEnum.engineer.name() + "|")){ // 工程师
			approveStatList.add(TeleGraphApproveStatEnum.engineer_firstaudit);
			approveStatList.add(TeleGraphApproveStatEnum.engineer_audit);
			approveStatList.add(TeleGraphApproveStatEnum.engineer_config);
			approveStatList.add(TeleGraphApproveStatEnum.assist_config);
			approveStatList.add(TeleGraphApproveStatEnum.atnc_test);
			queryModel.setStatusList(approveStatList);
			queryModel.setNextUser(user.getId()); //该查询条件查询上一步移交给自己的记录
			model.addAttribute("role", RoleEnum.engineer.name());
			model.addAttribute("pagn", teleGraphCircuitService.queryPageByModel(queryModel));
		}
		model.addAttribute("role", roleNames);
		return "business/telegraphcircuit/queryResult";
	}

	/**
	 * 异步加载数据，显示数据条数
	 * @throws IOException 
	 * @author WangLingbin
	 * @date  2015年10月20日下午1:59:33
	 * @since 1.0.0
	 */
	@RequestMapping(value = "ajaxLoad.dox", method = RequestMethod.GET)
	public String ajaxLoad(@ModelAttribute("queryModel") TeleGraphQueryModel queryModel,
			HttpServletRequest request, Model model) throws IOException {
		//当前用户
		User user = this.getCurrentUser(request);
		StringBuffer roleNames = new StringBuffer("|");
		List<Role> roles = user.getRoles();
		if(!CollectionUtils.isEmpty(roles)){
			for (Role role : roles) {
				roleNames.append(role.getName());
				roleNames.append("|");
			}
		}
		//根据不同角色获取不同的数据
		List<TeleGraphApproveStatEnum> statusList = new ArrayList<TeleGraphApproveStatEnum>();
		//筛选转报电路申请信息，与转报地址分开
		List<TeleGraphCircuit> teleGraphCircuits = teleGraphCircuitService.getAll();
		queryModel.setTeleGraphCircuits(teleGraphCircuits);
		if (roleNames.toString().contains("|"+RoleEnum.csLeader.name()+"|")){ // 客服领导
			statusList.add(TeleGraphApproveStatEnum.csleader_review);
			queryModel.setStatusList(statusList);
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(teleGraphCircuitService.queryPageByModel(queryModel)));
		}
		if(roleNames.toString().contains("|"+RoleEnum.csStaff.name()+"|")){ // 客服专员
			statusList.add(TeleGraphApproveStatEnum.csstaff_audit);
			statusList.add(TeleGraphApproveStatEnum.csstaff_deal);
			queryModel.setStatusList(statusList);
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(teleGraphCircuitService.queryPageByModel(queryModel)));
		}
		if(roleNames.toString().contains("|"+RoleEnum.atncLeader.name()+"|")){// 网控领导
			statusList.add(TeleGraphApproveStatEnum.atncleader_firstdeal);
			statusList.add(TeleGraphApproveStatEnum.atncleader_review);
			statusList.add(TeleGraphApproveStatEnum.atncleader_approve);
			//网控领导分配审核工程师
			statusList.add(TeleGraphApproveStatEnum.atncleader_audit);
			queryModel.setStatusList(statusList);
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(teleGraphCircuitService.queryPageByModel(queryModel)));
		}
		if(roleNames.toString().contains("|"+RoleEnum.manager.name()+"|")) {		//事业部总经理
			statusList.add(TeleGraphApproveStatEnum.generalmanager_approve);
			queryModel.setStatusList(statusList);
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(teleGraphCircuitService.queryPageByModel(queryModel)));
		}
		if(roleNames.toString().contains("|"+RoleEnum.fundmanager.name()+"|")) {		//事业部总经理
			statusList.add(TeleGraphApproveStatEnum.fundmanager_confirm);
			queryModel.setStatusList(statusList);
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(teleGraphCircuitService.queryPageByModel(queryModel)));
		}
		if(roleNames.toString().contains("|"+RoleEnum.engineer.name()+"|")){ // 工程师
			statusList.add(TeleGraphApproveStatEnum.engineer_firstaudit);
			statusList.add(TeleGraphApproveStatEnum.engineer_audit);
			statusList.add(TeleGraphApproveStatEnum.engineer_config);
			statusList.add(TeleGraphApproveStatEnum.assist_config);
			statusList.add(TeleGraphApproveStatEnum.atnc_test);
			queryModel.setNextUser(user.getId()); //该查询条件查询上一步移交给自己的记录
			queryModel.setStatusList(statusList);
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(teleGraphCircuitService.queryPageByModel(queryModel)));
		}
		return "returnnote";
	}
	
	/**
	 * 查看详情操作
	 * @author WangLingbin
	 * @date  2015年10月20日下午2:00:21
	 * @since 1.0.0
	 */
	@RequestMapping(value = "detail.do",method = RequestMethod.GET)
	public String setupDetailForm(@RequestParam("id")String id,HttpServletRequest request, Model model) {
		//根据id值获取TeleGraph实体
		TeleGraph teleGraph = teleGraphService.getTeleGraphById(id);
		//获取基础信息
		ApplyBaseInfo applyBaseInfo = teleGraph.getApplyBaseInfo();
		//获取审批信息集合
		List<ApproveInfo> approveInfos = approveInfoService.getApproveInfoByBaseInfoId(applyBaseInfo.getId());
		model.addAttribute("approveInfos", approveInfos);
		//根据父类ID获取TeleGraphCircuit实体集合
		List<TeleGraphCircuit> teleGraphCircuits = teleGraphCircuitService.getCircuitsByParentId(id);
		model.addAttribute("teleGraphCircuits",teleGraphCircuits);
		//上传附件
		List<TeleGraphAttach> attaches = teleGraphAttachService.queryListByTeleGraphId(id);
		List<TeleAttachTypeEnum> teleAttachTypeEnums = Arrays.asList(TeleAttachTypeEnum.values());
		model.addAttribute("attaches", attaches);
		model.addAttribute("teleAttachTypeEnums", teleAttachTypeEnums);
		//添加操作日志
		super.addLog(request, "查看申请数据详情");
		return "business/telegraphcircuit/detail";
	}

	/**
	 * 客服专员暂存操作
	 * @author WangLingbin
	 * @date  2015年10月20日下午2:01:13
	 * @since 1.0.0
	 */
	@RequestMapping(value = "draft.do",method = RequestMethod.GET)
	public String draftGet(@RequestParam("id") String id,@ModelAttribute("pageModel") TeleGraphQueryModel queryModel,
			HttpServletRequest request, Model model) {
		//解决上方展示详情内容
		//根据ID获取转报地址入网申请记录对象
		TeleGraph teleGraph = teleGraphService.getTeleGraphById(id);
		model.addAttribute("teleGraph", teleGraph);
		//获取基础信息
		ApplyBaseInfo applyBaseInfo = teleGraph.getApplyBaseInfo();
		//获取审批信息集合
		List<ApproveInfo> approveInfos = approveInfoService.getApproveInfoByBaseInfoId(applyBaseInfo.getId());
		model.addAttribute("approveInfos", approveInfos);
		//根据父类ID获取TeleGraphCircuit实体集合
		List<TeleGraphCircuit> teleGraphCircuits = teleGraphCircuitService.getCircuitsByParentId(id);
		model.addAttribute("teleGraphCircuits",teleGraphCircuits);
		//上传附件
		List<TeleGraphAttach> attaches = teleGraphAttachService.queryListByTeleGraphId(id);
		List<TeleAttachTypeEnum> teleAttachTypeEnums = Arrays.asList(TeleAttachTypeEnum.values());
		model.addAttribute("attaches", attaches);
		model.addAttribute("teleAttachTypeEnums", teleAttachTypeEnums);
		return "business/telegraphcircuit/draft";
	}
	
	/**
	 * 客服专员暂存操作
	 * @author WangLingbin
	 * @date  2015年10月20日下午2:01:26
	 * @since 1.0.0
	 */
	@RequestMapping(value = "draft.do",method = RequestMethod.POST)
	public String draftPost(@RequestParam("id") String id,@ModelAttribute("pageModel") TeleGraphQueryModel queryModel,
			HttpServletRequest request, Model model) {
		//当前登录用户
		User user =  this.getCurrentUser(request);
		//根据ID获取转报地址入网申请记录对象
		TeleGraph teleGraph = teleGraphService.getTeleGraphById(id);
		//获取基础信息
		ApplyBaseInfo applyBaseInfo = teleGraph.getApplyBaseInfo();
		//添加审批记录
		ApproveInfo approveInfo = new ApproveInfo(user, applyBaseInfo, queryModel.getApproveRemark(), ApproveTypeEnum.draft);
		approveInfoService.save(approveInfo);
		//添加操作日志
		super.addLog(request, "执行暂存操作");
		return "business/telegraphcircuit/result";
	}
	
	/**
	 * 处理操作跳转
	 * @author WangLingbin
	 * @date  2015年5月28日下午3:28:36
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "deal.do",method = RequestMethod.GET)
	public String setupDealForm(@RequestParam("id")String id,
			@ModelAttribute("pageModel") TeleGraphQueryModel queryModel,
			HttpServletRequest request, Model model) {

		//解决上方展示详情内容
		//根据ID获取转报地址入网申请记录对象
		TeleGraph teleGraph = teleGraphService.getTeleGraphById(id);
		model.addAttribute("teleGraph", teleGraph);
		//获取基础信息
		ApplyBaseInfo applyBaseInfo = teleGraph.getApplyBaseInfo();
		//获取审批信息集合
		List<ApproveInfo> approveInfos = approveInfoService.getApproveInfoByBaseInfoId(applyBaseInfo.getId());
		model.addAttribute("approveInfos", approveInfos);
		//根据父类ID获取TeleGraphCircuit实体集合
		List<TeleGraphCircuit> teleGraphCircuits = teleGraphCircuitService.getCircuitsByParentId(id);
		model.addAttribute("teleGraphCircuits",teleGraphCircuits);
		//上传附件
		List<TeleGraphAttach> attaches = teleGraphAttachService.queryListByTeleGraphId(id);
		List<TeleAttachTypeEnum> teleAttachTypeEnums = Arrays.asList(TeleAttachTypeEnum.values());
		model.addAttribute("attaches", attaches);
		model.addAttribute("teleAttachTypeEnums", teleAttachTypeEnums);
		//当前登录用户
		User user =  this.getCurrentUser(request);
		model.addAttribute("user", user);
		//获取角色为"工程师"的用户集合
		List<UserRole> userRoles = new ArrayList<UserRole>();
		userRoles = (List<UserRole>) userDao.queryList("from UserRole where role.name=?", "engineer");
		List<User> engineers = new ArrayList<User>();
		for (UserRole userRole : userRoles) {
			if(!StringUtils.equals(userRole.getUser().getName(), user.getName())){
				engineers.add(userRole.getUser());
			}
		}
		//获取角色为"客服专员"的用户集合
		userRoles = (List<UserRole>) userDao.queryList("from UserRole where role.name=?", "csStaff");
		List<User> csStaffs = new ArrayList<User>();
		for (UserRole userRole : userRoles) {
			if(!StringUtils.equals(userRole.getUser().getName(), user.getName())){
				csStaffs.add(userRole.getUser());
			}
		}
		//获取用户角色
		StringBuffer roleNames = new StringBuffer("|");
		List<Role> roles = user.getRoles();
		if(!CollectionUtils.isEmpty(roles)){
			for (Role role : roles) {
				roleNames.append(role.getName());
				roleNames.append("|");
			}
		}
		logger.info("当前用户名："+user.getName() + " 拥有的角色名称：" + roleNames);
		if(roleNames.toString().contains("|"+RoleEnum.csStaff.name()+"|")) { // 客服专员
			//model.addAttribute("role", "csStaff");
			List<Bureau> bureaus = new ArrayList<Bureau>();
			Bureau[] sevenBureaus = Bureau.getSevenBureaus();
			//申请人所在管局
			Bureau bureau = teleGraph.getApplyBaseInfo().getApplyUser().getBureau();
			if(!ObjectUtils.equals(bureau, null)){
				bureau = Bureau.isBelong7Bureau(bureau.getValue());
				if(!ObjectUtils.equals(bureau, null)){ //申请人属于7大管局
					//剔除该用户所在管局
					for(Bureau sevenBureau : sevenBureaus) {
						if(ObjectUtils.equals(bureau, sevenBureau)) {
							continue;
						}
						bureaus.add(sevenBureau);
					}
					model.addAttribute("bureaus", bureaus);
				} else {	//申请人不属于7大管局，显示7大管局
					bureaus = Arrays.asList(sevenBureaus);
					model.addAttribute("bureaus", bureaus);
				}
			}
		} 
		if(roleNames.toString().contains("|"+RoleEnum.csLeader.name()+"|")) {	//客服领导
			model.addAttribute("csStaffs",csStaffs);
			//model.addAttribute("role", "csLeader");
		} 
		if(roleNames.toString().contains("|"+RoleEnum.engineer.name()+"|")) {    // 工程师
			model.addAttribute("engineers",engineers);
			//model.addAttribute("role", "engineer");
		} 
		if(roleNames.toString().contains("|"+RoleEnum.atncLeader.name()+"|")) {	//网控领导
			model.addAttribute("engineers",engineers);
			//model.addAttribute("role", "atncLeader");
		} 
		/*if(roleNames.toString().contains("|manager|")) {
			model.addAttribute("role", "manager");
		} 
		if(roleNames.toString().contains("|fundmanager|")) {
			model.addAttribute("role", "fundmanager");
		}*/
		model.addAttribute("role", roleNames);
		return "business/telegraphcircuit/deal";
	}
	
	
	@RequestMapping(value = "deal.do",method = RequestMethod.POST)
	public String peocessDealForm(HttpServletRequest request, Model model,
			TeleGraphQueryModel queryModel) {
		try{
			//当前登录用户
			User user =  this.getCurrentUser(request);
			//处理审批操作
			TeleGraph teleGraph = teleGraphCircuitService.dealForm(request, queryModel,user);
			//如果为配置阶段，则保存配置信息
			/*if(queryModel.isApproveStat()){		//操作类别（true：配置/false:移交）
				if(!CollectionUtils.isEmpty(atncRountAddrs) && !CollectionUtils.isEmpty(atncConfigTimes)) {
					teleGraphConfigService.config(queryModel, identifiers,
							atncRountAddrs, atncConfigTimes, atncConfigPeoples,
							atncConnectionConditions);
				}
			}*/
			addSuccess(model, "处理成功！");
			//添加操作日志
			super.addLog(request, "处理成功(联系人:" + teleGraph.getApplyBaseInfo().getApplyLinkman()+")");
		}catch (Exception e) {
			e.printStackTrace();
			addSuccess(model, "处理失败！原因是："+e.getMessage());
		}
		return "business/telegraphcircuit/result";
	}
	
	/**
	 * 下载附件
	 * @throws IOException 
	 * @author WangLingbin
	 * @date  2015年10月14日下午5:04:00
	 * @since 1.0.0
	 */
	@RequestMapping(value = "download.do")
	public void downloadDoc(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, Model model,
			@RequestParam("id") String id) throws IOException {
		TeleGraphAttach teleGraphAttach = teleGraphAttachService.findById(id);
		String destUrl = teleGraphAttach.getAttachAddress();
		URL url = new URL(destUrl);
		HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
		//连接指定的网络资源
		httpUrl.connect();
		//获取网络输入流
		BufferedInputStream bis = new BufferedInputStream(httpUrl.getInputStream());
		this.doDownLoad(request, response, bis, teleGraphAttach.getAttachName());
		//添加操作日志
		super.addLog(request, "下载附件");
	}
	
	/**
	 * 下载退回的申请表信息留存
	 * @param request
	 * @param response
	 * @param filePath
	 * @throws IOException 
	 * @author WangLingbin
	 * @date  2015年11月10日下午3:41:52
	 * @since 1.0.0
	 */
	@RequestMapping(value = "downloadReturnedReport.do")
	public void downloadReturnedReport(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "reportAddress", required = false) String reportAddress,
			@RequestParam(value = "outlineAddress", required = false) String outlineAddress) throws IOException {
		try {
			//检查文件后缀名
			String fileExt = JasperReportUtils.getFileExt(reportAddress);
			//若为报表附件
			if(StringUtils.equalsIgnoreCase(fileExt, JasperReportUtils.getReportExt())) {
				JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(new File(reportAddress));
				byte[] data = JasperReportUtils.exportReport("pdf", request, jasperPrint);
				this.doDownLoad(request, response, data, ReturnedReportsEnum.telegraph_circuit.getValue());
			} else {
				URL url = new URL(outlineAddress);
				HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
				//连接指定的网络资源
				httpUrl.connect();
				//获取网络输入流
				BufferedInputStream bis = new BufferedInputStream(httpUrl.getInputStream());
				this.doDownLoad(request, response, bis, ReturnedReportsEnum.auditFile.getValue() + "." + fileExt);
			}
		} catch (JRException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 申请表报表预览
	 * @param request
	 * @param response
	 * @return 
	 * @author WangLingbin
	 * @date  2015年6月2日上午11:29:51
	 * @since 1.0.0
	 */
	@RequestMapping(value = "previewApply.dox")
	public ModelAndView previewApply(HttpServletRequest request,
			ModelAndView mav,
			HttpServletResponse response, @RequestParam("id") String id) {
		Map<String, Object> param = teleGraphCircuitService.getReportParams(request, id, JasperReportsEnum.telegraph_circuit.toString());
		param.put("format", "pdf");
		mav = new ModelAndView(JasperReportsEnum.telegraph_circuit.toString(),param);
		//添加操作日志
		super.addLog(request, "申请表报表预览");
		return mav;
	 }
	
}