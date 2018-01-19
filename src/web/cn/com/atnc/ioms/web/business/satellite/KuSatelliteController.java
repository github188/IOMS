package cn.com.atnc.ioms.web.business.satellite;

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
import cn.com.atnc.ioms.entity.business.satellite.KuSatellite;
import cn.com.atnc.ioms.entity.business.satellite.KuSatelliteAttach;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveTypeEnum;
import cn.com.atnc.ioms.enums.business.satellite.ApproveStatEnum;
import cn.com.atnc.ioms.enums.business.satellite.KuSatelliteAttachEnum;
import cn.com.atnc.ioms.enums.reports.JasperReportsEnum;
import cn.com.atnc.ioms.enums.reports.ReturnedReportsEnum;
import cn.com.atnc.ioms.mng.business.approveinfo.IApproveInfoService;
import cn.com.atnc.ioms.mng.business.baseinfo.IApplyBaseInfoService;
import cn.com.atnc.ioms.mng.business.evaluete.IEvalueteManager;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteAttachService;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteConfigService;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteService;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteWorkflowService;
import cn.com.atnc.ioms.mng.reports.JasperReportService;
import cn.com.atnc.ioms.model.business.satellite.KuSatelliteQueryModel;
import cn.com.atnc.ioms.util.JasperReportUtils;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 民航卫星网申请
 * @author WangLingbin
 * @date 2015年10月21日 下午4:46:56
 * @since 1.0.0
 */
@Controller
@RequestMapping("/kusatellite/")
public class KuSatelliteController extends MyBaseController {

	@Autowired
	private IKuSatelliteService kuSatelliteService;
	@Autowired
	private IKuSatelliteConfigService kuSatelliteConfigService;
	@Autowired
	private IApplyBaseInfoService applyBaseInfoService;
	@Autowired
	private IApproveInfoService approveInfoService;
	@Autowired
	private  IEvalueteManager evaluateManager;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IKuSatelliteAttachService kuSatelliteAttachService;
	@Autowired
	private IKuSatelliteWorkflowService workflowService;
	@Autowired
	private JasperReportService jasperReportService;
	
	/**
	 * 页面初始化
	 * @author WangLingbin
	 * @date  2015年10月21日下午4:47:18
	 * @since 1.0.0
	 */
	@RequestMapping(value = "tasklist.do", method = RequestMethod.GET)
	public String manage(HttpServletRequest request, Model model) {
		super.pageInfo(model, request);
		return "business/satellite/manage";
	}

	/**
	 * 加载数据
	 * @author WangLingbin
	 * @date  2015年10月21日下午4:47:27
	 * @since 1.0.0
	 */
	@RequestMapping(value = "tasklist.do", method = RequestMethod.POST)
	public String manageList(@ModelAttribute("queryModel") KuSatelliteQueryModel queryModel,
			HttpServletRequest request, Model model) {
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
		List<ApproveStatEnum> approveStatList = new ArrayList<ApproveStatEnum>();
		if (roleNames.toString().contains("|" + RoleEnum.csLeader.name() + "|")){ // 客服领导
			approveStatList.add(ApproveStatEnum.csleader_review);
		}
		if(roleNames.toString().contains("|" + RoleEnum.csStaff.name() + "|")){ // 客服专员
			approveStatList.add(ApproveStatEnum.csstaff_audit);
			approveStatList.add(ApproveStatEnum.csstaff_deal);
			//queryModel.setNextUser(user.getId()); //该查询条件查询上一步分配给自己的记录
			model.addAttribute("role", RoleEnum.csStaff.name());
		}
		if(roleNames.toString().contains("|" + RoleEnum.atncLeader.name() + "|")){// 网控领导
			approveStatList.add(ApproveStatEnum.atncleader_firstdeal);
			approveStatList.add(ApproveStatEnum.atncleader_review);
			approveStatList.add(ApproveStatEnum.atncleader_approve);
			//网控领导分配审核工程师
			approveStatList.add(ApproveStatEnum.atncleader_audit);
		}
		if(roleNames.toString().contains("|" + RoleEnum.engineer.name() + "|")){ // 工程师
			approveStatList.add(ApproveStatEnum.engineer_firstaudit);
			approveStatList.add(ApproveStatEnum.engineer_config);
			approveStatList.add(ApproveStatEnum.assist_config);
			approveStatList.add(ApproveStatEnum.engineer_audit);
			queryModel.setNextUser(user.getId()); //该查询条件查询上一步移交给自己的记录
			model.addAttribute("role", RoleEnum.engineer.name());
		} 
		if(roleNames.toString().contains("|" + RoleEnum.manager.name() + "|")) {	//营销事业部总经理
			approveStatList.add(ApproveStatEnum.marketmanager_approve);
		} 
		if(roleNames.toString().contains("|" + RoleEnum.netmanager.name() + "|")) {
			approveStatList.add(ApproveStatEnum.netmanager_approve);
		} 
		if(roleNames.toString().contains("|" + RoleEnum.leader.name() + "|")) {
			approveStatList.add(ApproveStatEnum.leader_approve);
		} 
		if(roleNames.toString().contains("|" + RoleEnum.fundmanager.name() + "|")) {
			approveStatList.add(ApproveStatEnum.fundmanager_confirm);
		}
		model.addAttribute("role", roleNames);
		queryModel.setStatusList(approveStatList);
		model.addAttribute("pagn", kuSatelliteService.queryPageByModel(queryModel));
		return "business/satellite/queryResult";
	}

	/**
	 * 异步加载数据，显示数据条数
	 * @throws IOException 
	 * @author WangLingbin
	 * @date  2015年10月21日下午4:59:19
	 * @since 1.0.0
	 */
	@RequestMapping(value = "ajaxLoad.dox", method = RequestMethod.GET)
	public String ajaxLoad(@ModelAttribute("queryModel") KuSatelliteQueryModel queryModel,
			HttpServletRequest request, Model model) throws IOException {
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
		List<ApproveStatEnum> approveStatList = new ArrayList<ApproveStatEnum>();
		if (roleNames.toString().contains("|" + RoleEnum.csLeader.name() + "|")){ // 客服领导
			approveStatList.add(ApproveStatEnum.csleader_review);
		}
		if(roleNames.toString().contains("|" + RoleEnum.csStaff.name() + "|")){ // 客服专员
			approveStatList.add(ApproveStatEnum.csstaff_audit);
			approveStatList.add(ApproveStatEnum.csstaff_deal);
			//queryModel.setNextUser(user.getId()); //该查询条件查询上一步分配给自己的记录
			model.addAttribute("role", RoleEnum.csStaff.name());
		}
		if(roleNames.toString().contains("|" + RoleEnum.atncLeader.name() + "|")){// 网控领导
			approveStatList.add(ApproveStatEnum.atncleader_firstdeal);
			approveStatList.add(ApproveStatEnum.atncleader_review);
			approveStatList.add(ApproveStatEnum.atncleader_approve);
			//网控领导分配审核工程师
			approveStatList.add(ApproveStatEnum.atncleader_audit);
		}
		if(roleNames.toString().contains("|" + RoleEnum.engineer.name() + "|")){ // 工程师
			approveStatList.add(ApproveStatEnum.engineer_firstaudit);
			approveStatList.add(ApproveStatEnum.engineer_config);
			approveStatList.add(ApproveStatEnum.assist_config);
			approveStatList.add(ApproveStatEnum.engineer_audit);
			queryModel.setNextUser(user.getId()); //该查询条件查询上一步移交给自己的记录
			model.addAttribute("role", RoleEnum.engineer.name());
		} 
		if(roleNames.toString().contains("|" + RoleEnum.manager.name() + "|")) {	//营销事业部总经理
			approveStatList.add(ApproveStatEnum.marketmanager_approve);
		} 
		if(roleNames.toString().contains("|" + RoleEnum.netmanager.name() + "|")) {
			approveStatList.add(ApproveStatEnum.netmanager_approve);
		} 
		if(roleNames.toString().contains("|" + RoleEnum.leader.name() + "|")) {
			approveStatList.add(ApproveStatEnum.leader_approve);
		} 
		if(roleNames.toString().contains("|" + RoleEnum.fundmanager.name() + "|")) {
			approveStatList.add(ApproveStatEnum.fundmanager_confirm);
		}
		model.addAttribute("role", roleNames);
		queryModel.setStatusList(approveStatList);
		model.addAttribute("returnStr",
				JacksonTools.toJsonStr(kuSatelliteService.queryPageByModel(queryModel)));
		return "returnnote";
	}
	
	/**
	 * 查看详情操作
	 * @author WangLingbin
	 * @date  2015年10月21日下午4:59:33
	 * @since 1.0.0
	 */
	@RequestMapping(value = "detail.do",method = RequestMethod.GET)
	public String setupDetailForm(@RequestParam("id")String id,HttpServletRequest request, Model model) {
		KuSatellite kuSatellite = (KuSatellite) kuSatelliteService.findById(id);
		ApplyBaseInfo applyBaseInfo = kuSatellite.getApplyBaseInfo();
		model.addAttribute("approveInfos",approveInfoService.getApproveInfoByBaseInfoId(applyBaseInfo.getId()));
		model.addAttribute("kuSatellite",kuSatelliteService.findById(id));
		//上传附件
		List<KuSatelliteAttach> attaches = kuSatelliteAttachService.queryListByKuSateId(id);
		List<KuSatelliteAttachEnum> kuSatelliteAttachEnums = Arrays.asList(KuSatelliteAttachEnum.values());
		model.addAttribute("attaches", attaches);
		model.addAttribute("kuSatelliteAttachEnums", kuSatelliteAttachEnums);
		model.addAttribute("kuSatelliteConfig", kuSatelliteConfigService.findByKuSateId(id));
		model.addAttribute("evaluateInfo", evaluateManager.findByApplyBaseInfoId(applyBaseInfo.getId()));
		//添加操作日志
		super.addLog(request, "查看申请数据详情");
		return "business/satellite/detail";
	}

	/**
	 * 客服专员暂存操作
	 * @author WangLingbin
	 * @date  2015年10月21日下午4:59:44
	 * @since 1.0.0
	 */
	@RequestMapping(value = "draft.do",method = RequestMethod.GET)
	public String draftGet(@RequestParam("id") String id,@ModelAttribute("pageModel") KuSatelliteQueryModel queryModel,
			HttpServletRequest request, Model model) {
		//根据ID获取KU入网实体
		KuSatellite kuSatellite = (KuSatellite) kuSatelliteService.findById(id);
		model.addAttribute("kuSatellite", kuSatellite);
		//获取基础信息
		ApplyBaseInfo applyBaseInfo = kuSatellite.getApplyBaseInfo();
		//获取审批信息集合
		List<ApproveInfo> approveInfos = approveInfoService.getApproveInfoByBaseInfoId(applyBaseInfo.getId());
		model.addAttribute("approveInfos", approveInfos);
		//上传附件
		List<KuSatelliteAttach> attaches = kuSatelliteAttachService.queryListByKuSateId(id);
		List<KuSatelliteAttachEnum> kuSatelliteAttachEnums = Arrays.asList(KuSatelliteAttachEnum.values());
		model.addAttribute("attaches", attaches);
		model.addAttribute("kuSatelliteAttachEnums", kuSatelliteAttachEnums);
		//获取正式电路申请实体集合
		return "business/satellite/draft";
	}
	
	/**
	 * 客服专员暂存操作
	 * @author WangLingbin
	 * @date  2015年10月21日下午4:59:44
	 * @since 1.0.0
	 */
	@RequestMapping(value = "draft.do",method = RequestMethod.POST)
	public String draftPost(@RequestParam("id") String id,@ModelAttribute("pageModel") KuSatelliteQueryModel queryModel,
			HttpServletRequest request, Model model) {
		//当前登录用户
		User user =  this.getCurrentUser(request);
		//根据ID获取KU入网实体
		KuSatellite kuSatellite = (KuSatellite) kuSatelliteService.findById(id);
		//获取基础信息
		ApplyBaseInfo applyBaseInfo = kuSatellite.getApplyBaseInfo();
		//添加审批记录
		ApproveInfo approveInfo = new ApproveInfo(user, applyBaseInfo, queryModel.getApproveRemark(), ApproveTypeEnum.draft);
		approveInfoService.save(approveInfo);
		//添加操作日志
		super.addLog(request, "执行暂存操作");
		return "business/satellite/result";
	}
	
	
	/**
	 * 处理操作
	 * @author WangLingbin
	 * @date  2015年10月21日下午5:01:06
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "deal.do",method = RequestMethod.GET)
	public String setupDealForm(@RequestParam("id")String id,
			@ModelAttribute("pageModel")KuSatelliteQueryModel queryModel,
			HttpServletRequest request, Model model) {

		//解决上方展示详情内容
		KuSatellite kuSatellite = (KuSatellite) kuSatelliteService.findById(id);
		ApplyBaseInfo applyBaseInfo = kuSatellite.getApplyBaseInfo();
		model.addAttribute("approveInfos",approveInfoService.getApproveInfoByBaseInfoId(applyBaseInfo.getId()));
		model.addAttribute("kuSatellite",kuSatelliteService.findById(id));
		//上传附件
		List<KuSatelliteAttach> attaches = kuSatelliteAttachService.queryListByKuSateId(id);
		List<KuSatelliteAttachEnum> kuSatelliteAttachEnums = Arrays.asList(KuSatelliteAttachEnum.values());
		model.addAttribute("attaches", attaches);
		model.addAttribute("kuSatelliteAttachEnums", kuSatelliteAttachEnums);
		model.addAttribute("kuSatelliteConfig", kuSatelliteConfigService.findByKuSateId(id));
		//当前登录用户
		User user =  this.getCurrentUser(request);
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
		StringBuffer roleNames = new StringBuffer("|");
		List<Role> roles = user.getRoles();
		if(!CollectionUtils.isEmpty(roles)){
			for (Role role : roles) {
				roleNames.append(role.getName());
				roleNames.append("|");
			}
		}
		logger.info("当前用户名："+user.getName() + " 拥有的角色名称：" + roleNames);
		if(roleNames.toString().contains("|csStaff|")){ // 客服专员
			model.addAttribute("role", "csStaff");
		}else if(roleNames.toString().contains("|csLeader|")){ // 客服领导
			model.addAttribute("csStaffs",csStaffs);
			model.addAttribute("role", "csLeader");
		}else if(roleNames.toString().contains("|engineer|")){ // 工程师
			model.addAttribute("engineers",engineers);
			model.addAttribute("role", "engineer");
		}else if(roleNames.toString().contains("|atncLeader|")){// 网控领导
			model.addAttribute("engineers",engineers);
			model.addAttribute("role", "atncLeader");
		}else if(roleNames.toString().contains("|manager|")) {
			model.addAttribute("role", "manager");
		}else if(roleNames.toString().contains("|netmanager|")) {
			model.addAttribute("role", "netmanager");
		}else if(roleNames.toString().contains("|leader|")) {
			model.addAttribute("role", "leader");
		}else if(roleNames.toString().contains("|fundmanager|")) {
			model.addAttribute("role", "fundmanager");
		}
		model.addAttribute("role", roleNames);
		return "business/satellite/deal";
	}
	
	
	/**
	 * 处理操作
	 * @author WangLingbin
	 * @date  2015年10月21日下午5:01:18
	 * @since 1.0.0
	 */
	@RequestMapping(value = "deal.do",method = RequestMethod.POST)
	public String peocessDealForm(HttpServletRequest request, Model model,
			KuSatelliteQueryModel queryModel,
			@RequestParam(value = "node", required = false) String node,
			@RequestParam(value = "mediumFrequency", required = false) String mediumFrequency,
			@RequestParam(value = "emissionFrequency", required = false) String emissionFrequency,
			@RequestParam(value = "receiveFrequency", required = false) String receiveFrequency) {
		try{
			//当前登录用户
			User user =  this.getCurrentUser(request);
			KuSatellite kuSatellite = kuSatelliteService.dealForm(request,queryModel,user);
			//如果为配置阶段，则保存配置信息
			if(queryModel.isApproveStat()){		//操作类别（true：配置/false:移交）
				if(StringUtils.isNotEmpty(node) && StringUtils.isNotEmpty(mediumFrequency)) {
					kuSatelliteConfigService.config(queryModel, user, node, mediumFrequency, emissionFrequency, receiveFrequency);
				}
			}
			addSuccess(model, "处理成功！");
			//添加操作日志
			super.addLog(request, "客服专员处理成功(联系人:"+kuSatellite.getApplyBaseInfo().getApplyLinkman()+")");
		}catch (Exception e) {
			e.printStackTrace();
			addSuccess(model, "处理失败！原因是："+e.getMessage());
		}
		return "business/satellite/result";
	}


	/**
	 * 下载KU入网附件
	 * @author ku
	 * @date  2015年5月29日下午3:05:27
	 * @since 1.0.0
	 */
	@RequestMapping(value = "download.do",method = RequestMethod.GET)
	public void download(@RequestParam("id")String id,
			HttpServletRequest request,HttpServletResponse response, Model model) {
		try {
			KuSatelliteAttach kuSatelliteAttach = kuSatelliteAttachService.findById(id);
			String destUrl = kuSatelliteAttach.getAttachAddress();
			URL url = new URL(destUrl);
			HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
			//连接指定的网络资源
			httpUrl.connect();
			//获取网络输入流
			BufferedInputStream bis = new BufferedInputStream(httpUrl.getInputStream());
			this.doDownLoad(request, response, bis, kuSatelliteAttach.getAttachName());
			//添加操作日志
			super.addLog(request, "下载附件");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
				this.doDownLoad(request, response, data, ReturnedReportsEnum.kusatellite.getValue());
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
	 * 报表
	 * @author WangLingbin
	 * @date  2015年10月21日下午5:02:21
	 * @since 1.0.0
	 */
	@RequestMapping(value = "previewApply.dox")
	public ModelAndView previewApply(HttpServletRequest request,
			ModelAndView mav, @RequestParam("id") String id) {
		Map<String, Object> param = kuSatelliteService.getReportParams(request, id, JasperReportsEnum.kusatellite.toString());
		param.put("format", "pdf");
		mav = new ModelAndView(JasperReportsEnum.kusatellite.toString(),param);
		//添加操作日志
		super.addLog(request, "申请表报表预览");
		return mav;
	 }

}