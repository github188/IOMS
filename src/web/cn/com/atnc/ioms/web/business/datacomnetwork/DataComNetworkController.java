package cn.com.atnc.ioms.web.business.datacomnetwork;

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
import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetwork;
import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetworkAttach;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveTypeEnum;
import cn.com.atnc.ioms.enums.business.datacomnetwork.NetWorkAttachTypeEnum;
import cn.com.atnc.ioms.enums.business.datacomnetwork.NetWorkStatEnum;
import cn.com.atnc.ioms.enums.reports.JasperReportsEnum;
import cn.com.atnc.ioms.enums.reports.ReturnedReportsEnum;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.business.approveinfo.IApproveInfoService;
import cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkAttachService;
import cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkManager;
import cn.com.atnc.ioms.mng.reports.JasperReportService;
import cn.com.atnc.ioms.model.business.datacomnetwork.DataComNetworkQueryModel;
import cn.com.atnc.ioms.util.JasperReportUtils;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 数据通信网Controller控制器
 *
 * @author Wang Zhicheng
 * @date 2015年10月19日 下午2:09:31
 * @since 1.0.0
 */
@Controller
@RequestMapping("/datacomnetwork/")
public class DataComNetworkController extends MyBaseController {
	
	@Autowired
	private IDataComNetworkManager dataComNetworkManager;
	@Autowired
	private IDataComNetworkAttachService dataComNetworkAttachService;
	@Autowired
	private IApproveInfoService approveInfoService;
	@Autowired
	private IUserManager userManager;
	@Autowired
	private JasperReportService jasperReportService;
	
	// 页面初始化
	@RequestMapping(value = "tasklist.do", method = RequestMethod.GET)
	public String manage(HttpServletRequest request, Model model) {
		super.pageInfo(model, request);
		return "business/datacomnetwork/manage";
	}

	@RequestMapping(value = "tasklist.do", method = RequestMethod.POST)
	public String manageList(@ModelAttribute("queryModel") DataComNetworkQueryModel queryModel,
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
		logger.info("当前de用户名："+user.getName() + " 拥有的角色名称：" + roleNames);
		//根据不同角色获取不同的数据
		List<NetWorkStatEnum> approveStatList = new ArrayList<NetWorkStatEnum>();
		if(roleNames.toString().contains("|" + RoleEnum.csLeader.name() + "|")){ // 客服领导
			approveStatList.add(NetWorkStatEnum.csleader_approve);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					dataComNetworkManager.queryPage(queryModel));
		}
		if(roleNames.toString().contains("|" + RoleEnum.csStaff.name() + "|")){ // 客服专员
			approveStatList.add(NetWorkStatEnum.csstaff_firstdeal);
			approveStatList.add(NetWorkStatEnum.csstaff_deal);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("role", RoleEnum.csStaff.name());
			model.addAttribute("pagn",
					dataComNetworkManager.queryPage(queryModel));
		}
		if(roleNames.toString().contains("|" + RoleEnum.atncLeader.name() + "|")){// 网控领导
			approveStatList.add(NetWorkStatEnum.atncleader_approve);
			approveStatList.add(NetWorkStatEnum.atncleader_seconddeal);
			approveStatList.add(NetWorkStatEnum.atncleader_firstdeal);
			//网控领导分配审核工程师
			approveStatList.add(NetWorkStatEnum.atncleader_thirddeal);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					dataComNetworkManager.queryPage(queryModel));
		}
		if(roleNames.toString().contains("|" + RoleEnum.engineer.name() + "|")){ // 工程师
			approveStatList.add(NetWorkStatEnum.engineer_config);
			approveStatList.add(NetWorkStatEnum.engineer_firstaudit);
			approveStatList.add(NetWorkStatEnum.engineer_secondaudit);
			approveStatList.add(NetWorkStatEnum.engineer_transfer);
			queryModel.setStatusList(approveStatList);
			queryModel.setNextUser(user.getId()); //该查询条件查询上一步移交给自己的记录
			model.addAttribute("role", RoleEnum.engineer.name());
			model.addAttribute("pagn",
					dataComNetworkManager.queryPage(queryModel));
		}
		if(roleNames.toString().contains("|" + RoleEnum.manager.name() + "|")){ //事业部领导
			approveStatList.add(NetWorkStatEnum.generalmanager_approve);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					dataComNetworkManager.queryPage(queryModel));
		}
		if(roleNames.toString().contains("|" + RoleEnum.netmanager.name() + "|")){ //网控事业部经理
			approveStatList.add(NetWorkStatEnum.netmanager_approve);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					dataComNetworkManager.queryPage(queryModel));
		}
		if(roleNames.toString().contains("|" + RoleEnum.leader.name() + "|")){ //公司领导
			approveStatList.add(NetWorkStatEnum.compenyleader_approve);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					dataComNetworkManager.queryPage(queryModel));
		}
		if(roleNames.toString().contains("|" + RoleEnum.fundmanager.name() + "|")){ //财务部经理
			approveStatList.add(NetWorkStatEnum.fundmanager_approve);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					dataComNetworkManager.queryPage(queryModel));
		}
		model.addAttribute("role", roleNames);
		return "business/datacomnetwork/queryResult";
	}
	
	/**
	 * 页面气泡
	 *
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException 
	 * @author Wang Zhicheng
	 * @date  2015年10月26日上午9:07:19
	 * @since 1.0.0
	 */
	@RequestMapping(value = "ajaxLoad.dox", method = RequestMethod.GET)
	public String ajaxLoad(@ModelAttribute("queryModel") DataComNetworkQueryModel queryModel,
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
		List<NetWorkStatEnum> approveStatList = new ArrayList<NetWorkStatEnum>();
		if(roleNames.toString().contains("|" + RoleEnum.csLeader.name() + "|")){ // 客服领导
			approveStatList.add(NetWorkStatEnum.csleader_approve);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					dataComNetworkManager.queryPage(queryModel));
		}
		if(roleNames.toString().contains("|" + RoleEnum.csStaff.name() + "|")){ // 客服专员
			approveStatList.add(NetWorkStatEnum.csstaff_firstdeal);
			approveStatList.add(NetWorkStatEnum.csstaff_deal);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("role", RoleEnum.csStaff.name());
			model.addAttribute("pagn",
					dataComNetworkManager.queryPage(queryModel));
		}
		if(roleNames.toString().contains("|" + RoleEnum.atncLeader.name() + "|")){// 网控领导
			approveStatList.add(NetWorkStatEnum.atncleader_approve);
			approveStatList.add(NetWorkStatEnum.atncleader_seconddeal);
			approveStatList.add(NetWorkStatEnum.atncleader_firstdeal);
			//网控领导分配审核工程师
			approveStatList.add(NetWorkStatEnum.atncleader_thirddeal);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					dataComNetworkManager.queryPage(queryModel));
		}
		if(roleNames.toString().contains("|" + RoleEnum.engineer.name() + "|")){ // 工程师
			approveStatList.add(NetWorkStatEnum.engineer_config);
			approveStatList.add(NetWorkStatEnum.engineer_firstaudit);
			approveStatList.add(NetWorkStatEnum.engineer_secondaudit);
			approveStatList.add(NetWorkStatEnum.engineer_transfer);
			queryModel.setStatusList(approveStatList);
			queryModel.setNextUser(user.getId()); //该查询条件查询上一步移交给自己的记录
			model.addAttribute("role", RoleEnum.engineer.name());
			model.addAttribute("pagn",
					dataComNetworkManager.queryPage(queryModel));
		}
		if(roleNames.toString().contains("|" + RoleEnum.manager.name() + "|")){ //事业部领导
			approveStatList.add(NetWorkStatEnum.generalmanager_approve);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					dataComNetworkManager.queryPage(queryModel));
		}
		if(roleNames.toString().contains("|" + RoleEnum.netmanager.name() + "|")){ //网控事业部经理
			approveStatList.add(NetWorkStatEnum.netmanager_approve);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					dataComNetworkManager.queryPage(queryModel));
		}
		if(roleNames.toString().contains("|" + RoleEnum.leader.name() + "|")){ //公司领导
			approveStatList.add(NetWorkStatEnum.compenyleader_approve);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					dataComNetworkManager.queryPage(queryModel));
		}
		if(roleNames.toString().contains("|" + RoleEnum.fundmanager.name() + "|")){ //财务部经理
			approveStatList.add(NetWorkStatEnum.fundmanager_approve);
			queryModel.setStatusList(approveStatList);
			model.addAttribute("pagn",
					dataComNetworkManager.queryPage(queryModel));
		}
		model.addAttribute("role", roleNames);
		model.addAttribute("returnStr",
				JacksonTools.toJsonStr(dataComNetworkManager.queryPage(queryModel)));
		return "returnnote";
	}
	
	/**
	 * 查看详情
	 *
	 * @param id
	 * @param request
	 * @param model
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月26日上午9:07:02
	 * @since 1.0.0
	 */
	@RequestMapping(value = "detail.do",method = RequestMethod.GET)
	public String setupDetailForm(@RequestParam("id")String id,HttpServletRequest request, Model model) {
		DataComNetwork dataComNetwork = dataComNetworkManager.findById(id);
		ApplyBaseInfo applyBaseInfo = dataComNetwork.getApplyBaseInfo();
		DataComNetworkQueryModel pageModel = dataComNetworkManager.getCheckModel(id);
		model.addAttribute("approveInfos",approveInfoService.getApproveInfoByBaseInfoId(applyBaseInfo.getId()));
		model.addAttribute("m",pageModel);
		model.addAttribute("dataComNetwork",dataComNetwork);
		//获取配置信息
		model.addAttribute("dataComNetworkConfig", dataComNetwork.getDataComNetworkConfig());
		model.addAttribute("isVisable", false);			//申请表中，信息是否显示为输入框
		//上传附件
		List<DataComNetworkAttach> attaches = dataComNetworkAttachService.queryListByDCNId(dataComNetwork.getId());
		List<NetWorkAttachTypeEnum> netWorkAttachTypeEnums = Arrays.asList(NetWorkAttachTypeEnum.values());
		model.addAttribute("attaches", attaches);
		model.addAttribute("netWorkAttachTypeEnums", netWorkAttachTypeEnums);
		//添加操作日志
		super.addLog(request, "查看申请数据详情");
		return "business/datacomnetwork/detail";
	}
	
	/**
	 * 客服专员暂存操作
	 *
	 * @param id
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月26日上午9:06:49
	 * @since 1.0.0
	 */
	@RequestMapping(value = "draft.do",method = RequestMethod.GET)
	public String draftGet(@RequestParam("id") String id,@ModelAttribute("pageModel") DataComNetworkQueryModel queryModel,
			HttpServletRequest request, Model model) {
		//根据ID获取正式电路实体
		DataComNetwork dataComNetwork = dataComNetworkManager.findById(id);
		model.addAttribute("dataComNetwork", dataComNetwork);
		//获取基础信息
		ApplyBaseInfo applyBaseInfo = dataComNetwork.getApplyBaseInfo();
		//获取审批信息集合
		List<ApproveInfo> approveInfos = approveInfoService.getApproveInfoByBaseInfoId(applyBaseInfo.getId());
		model.addAttribute("approveInfos", approveInfos);
		//上传附件
		List<DataComNetworkAttach> attaches = dataComNetworkAttachService.queryListByDCNId(dataComNetwork.getId());
		List<NetWorkAttachTypeEnum> netWorkAttachTypeEnums = Arrays.asList(NetWorkAttachTypeEnum.values());
		model.addAttribute("attaches", attaches);
		model.addAttribute("netWorkAttachTypeEnums", netWorkAttachTypeEnums);
		//获取配置信息
		model.addAttribute("dataComNetworkConfig", dataComNetwork.getDataComNetworkConfig());
		//获取正式电路申请实体集合
		DataComNetworkQueryModel pageModel = dataComNetworkManager.getCheckModel(id);
		model.addAttribute("m",pageModel);
		return "business/datacomnetwork/draft";
	}
	
	/**
	 * 客服专员暂存操作
	 *
	 * @param id
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月26日上午9:06:23
	 * @since 1.0.0
	 */
	@RequestMapping(value = "draft.do",method = RequestMethod.POST)
	public String draftPost(@RequestParam("id") String id,@ModelAttribute("pageModel") DataComNetworkQueryModel queryModel,
			HttpServletRequest request, Model model) {
		//当前登录用户
		User user =  this.getCurrentUser(request);
		//根据ID获取正式电路实体
		DataComNetwork dataComNetwork = dataComNetworkManager.findById(id);
		//获取基础信息
		ApplyBaseInfo applyBaseInfo = dataComNetwork.getApplyBaseInfo();
		//添加审批记录
		ApproveInfo approveInfo = new ApproveInfo(user, applyBaseInfo, queryModel.getApproveRemark(), ApproveTypeEnum.draft);
		approveInfoService.save(approveInfo);
		//添加操作日志
		super.addLog(request, "执行暂存操作");
		return "business/datacomnetwork/result";
	}
	
	/**
	 * 审核处理
	 *
	 * @param id
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月26日上午9:06:37
	 * @since 1.0.0
	 */
	@RequestMapping(value = "deal.do",method = RequestMethod.GET)
	public String setupDealForm(@RequestParam("id")String id,
			@ModelAttribute("pageModel") DataComNetworkQueryModel queryModel,
			HttpServletRequest request, Model model) {
		//解决上方展示详情内容
		DataComNetwork dataComNetwork = dataComNetworkManager.findById(id);
		ApplyBaseInfo applyBaseInfo = dataComNetwork.getApplyBaseInfo();
		DataComNetworkQueryModel pageModel = dataComNetworkManager.getCheckModel(id);
		model.addAttribute("dataComNetwork",dataComNetwork);
		//获取配置信息
		model.addAttribute("dataComNetworkConfig", dataComNetwork.getDataComNetworkConfig());
		model.addAttribute("approveInfos",approveInfoService.getApproveInfoByBaseInfoId(applyBaseInfo.getId()));
		model.addAttribute("m",pageModel);
		//上传附件
		List<DataComNetworkAttach> attaches = dataComNetworkAttachService.queryListByDCNId(dataComNetwork.getId());
		List<NetWorkAttachTypeEnum> netWorkAttachTypeEnums = Arrays.asList(NetWorkAttachTypeEnum.values());
		model.addAttribute("attaches", attaches);
		model.addAttribute("netWorkAttachTypeEnums", netWorkAttachTypeEnums);
		//当前登录用户
		User user =  this.getCurrentUser(request);
		model.addAttribute("user", user);
		//获取角色为"工程师"的用户集合
		List<User> engineers = userManager.getUserByRole("engineer");
		//获取角色为"客服专员"的用户集合
		List<User> csStaffs = userManager.getUserByRole("csStaff");
		//获取用户角色
		StringBuffer roleNames = new StringBuffer("|");
		List<Role> roles = user.getRoles();
		queryModel.setDataComNetwork(dataComNetwork);
		if(!CollectionUtils.isEmpty(roles)){
			for (Role role : roles) {
				roleNames.append(role.getName());
				roleNames.append("|");
			}
		}
		logger.info("当前用户名："+user.getName() + " 拥有的角色名称：" + roleNames);
		if(roleNames.toString().contains(RoleEnum.csStaff.name())) { // 客服专员
			model.addAttribute("role", "csStaff");
			List<Bureau> bureaus = new ArrayList<Bureau>();
			Bureau[] sevenBureaus = Bureau.getSevenBureaus();
			//申请人所在管局
			Bureau bureau = queryModel.getDataComNetwork().getApplyBaseInfo().getApplyUser().getBureau();
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
		} else if(roleNames.toString().contains(RoleEnum.csLeader.name())) {	//客服领导
			model.addAttribute("csStaffs",csStaffs);
			model.addAttribute("role", "csLeader");
		} else if(roleNames.toString().contains(RoleEnum.engineer.name())) {    // 工程师
			model.addAttribute("engineers",engineers);
			model.addAttribute("role", "engineer");
			model.addAttribute("isVisable", true);			//申请表中，信息是否显示为输入框
		} else if(roleNames.toString().contains(RoleEnum.atncLeader.name())) {	//网控领导
			model.addAttribute("engineers",engineers);
			model.addAttribute("role", "atncLeader");
		} else if(roleNames.toString().contains(RoleEnum.netmanager.name())) {	//网控经理
			model.addAttribute("engineers",engineers);
			model.addAttribute("role", "netmanager");
		} else if(roleNames.toString().contains(RoleEnum.fundmanager.name())) {	//财务经理
			model.addAttribute("engineers",engineers);
			model.addAttribute("role", "fundmanager");
		} else if(roleNames.toString().contains(RoleEnum.leader.name())) {	//公司领导
			model.addAttribute("engineers",engineers);
			model.addAttribute("role", "leader");
		} else if(roleNames.toString().contains(RoleEnum.manager.name())) {	//事业部经理
			model.addAttribute("engineers",engineers);
			model.addAttribute("role", "manager");
		}
		model.addAttribute("role", roleNames);
		return "business/datacomnetwork/deal";
	}
	
	
	/**
	 * 审批处理
	 *
	 * @param request
	 * @param model
	 * @param id
	 * @param queryModel
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月26日上午9:06:00
	 * @since 1.0.0
	 */
	@RequestMapping(value = "deal.do",method = RequestMethod.POST)
	public String peocessDealForm(HttpServletRequest request, Model model,
			@RequestParam("fid")String id,
			@RequestParam(value = "placeATM", required = false) String placeATM,
			@RequestParam(value = "placeATMO", required = false) String placeATMO,
			@RequestParam(value = "connectivity", required = false) String connectivity,
			@RequestParam(value = "nodemng", required = false) String nodemng,
			@RequestParam(value = "confRemark", required = false) String confRemark,
			DataComNetworkQueryModel queryModel) {
		try{
			//当前登陆用户
			User user =  this.getCurrentUser(request);
			//获取配置信息
			dataComNetworkManager.getDCNConfig(id, placeATM, placeATMO, connectivity, nodemng, confRemark);
			//处理审批请求
			DataComNetwork dataComNetwork = dataComNetworkManager.doCheck(request, id, queryModel, user);
			addSuccess(model, "处理成功！");
			//添加操作日志
			super.addLog(request, "客服专员处理成功(联系人:" + dataComNetwork.getApplyBaseInfo().getApplyLinkman()+")");
		}catch (Exception e) {
			e.printStackTrace();
			addSuccess(model, "处理失败！原因是："+e.getMessage());
		}
		return "business/datacomnetwork/result";
	}

	/**
	 * 申请表报表预览
	 *
	 * @param request
	 * @param mav
	 * @param response
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月27日上午9:53:13
	 * @since 1.0.0
	 */
	@RequestMapping(value = "previewApply.dox")
	public ModelAndView previewApply(HttpServletRequest request,
			ModelAndView mav,
			HttpServletResponse response, @RequestParam("id") String id) {
		Map<String, Object> param = dataComNetworkManager.getReportParams(request, id, JasperReportsEnum.datacom_apply.toString());
		param.put("format", "pdf");
		mav = new ModelAndView(JasperReportsEnum.datacom_apply.toString(),param);
		//添加操作日志
		super.addLog(request, "申请表报表预览");
		return mav;
	 }
	
	/**
	 * 配置表报表预览
	 *
	 * @param request
	 * @param mav
	 * @param response
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月27日上午9:53:02
	 * @since 1.0.0
	 */
	@RequestMapping(value = "previewConfig.dox")
	public ModelAndView previewConfig(HttpServletRequest request,
			ModelAndView mav,
			HttpServletResponse response, @RequestParam("id") String id) {
		Map<String, Object> param = dataComNetworkManager.getReportParams(request, id, JasperReportsEnum.datacom_record.toString());
		param.put("format", "pdf");
		mav = new ModelAndView(JasperReportsEnum.datacom_record.toString(),param);
		//添加操作日志
		super.addLog(request, "配置表报表预览");
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
	 * @date  2015年10月21日下午2:35:08
	 * @since 1.0.0
	 */
	@RequestMapping(value = "download.do",method = RequestMethod.GET)
	public void download(@RequestParam("id")String id,
			HttpServletRequest request,HttpServletResponse response, Model model) {
		try {
			DataComNetworkAttach dataComNetworkAttach = dataComNetworkAttachService.findById(id);
			String destUrl = dataComNetworkAttach.getAttachAddress();
			URL url = new URL(destUrl);
			HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
			//连接指定的网络资源
			httpUrl.connect();
			//获取网络输入流
			BufferedInputStream bis = new BufferedInputStream(httpUrl.getInputStream());
			this.doDownLoad(request, response, bis, dataComNetworkAttach.getAttachName());
			//添加操作日志
			super.addLog(request, "附件下载");
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
				this.doDownLoad(request, response, data, ReturnedReportsEnum.datacom_apply.getValue());
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
}