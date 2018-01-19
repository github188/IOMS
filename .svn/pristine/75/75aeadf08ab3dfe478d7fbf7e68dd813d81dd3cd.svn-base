/**
 * @ProjectName IOMS_CIRCUIT
 * @FileName TaskRecordController.java
 * @PackageName:cn.com.atnc.ioms.web.business.taskrecord
 * @author ku
 * @date 2015年5月26日下午1:26:24
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.web.business.taskrecord;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.approveinfo.ApproveInfo;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetwork;
import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetworkAttach;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitAttach;
import cn.com.atnc.ioms.entity.business.satellite.KuSatellite;
import cn.com.atnc.ioms.entity.business.satellite.KuSatelliteAttach;
import cn.com.atnc.ioms.entity.business.signoutnet.SignoutNet;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraph;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphAttach;
import cn.com.atnc.ioms.entity.business.transfernet.TransferNet;
import cn.com.atnc.ioms.entity.business.transfernet.TransferNetAttach;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.business.approveinfo.ApproveStatusEnum;
import cn.com.atnc.ioms.enums.business.baseinfo.ApplyTypeEnum;
import cn.com.atnc.ioms.enums.business.datacomnetwork.NetWorkAttachTypeEnum;
import cn.com.atnc.ioms.enums.business.datacomnetwork.NetWorkStatEnum;
import cn.com.atnc.ioms.enums.business.formalcircuit.FormalCircuitAttachTypeEnum;
import cn.com.atnc.ioms.enums.business.formalcircuit.FormalStatEnum;
import cn.com.atnc.ioms.enums.business.satellite.ApproveStatEnum;
import cn.com.atnc.ioms.enums.business.satellite.KuSatelliteAttachEnum;
import cn.com.atnc.ioms.enums.business.telegraph.TeleAttachTypeEnum;
import cn.com.atnc.ioms.enums.business.telegraph.TeleGraphApproveStatEnum;
import cn.com.atnc.ioms.enums.business.transfernet.TransferAttachTypeEnum;
import cn.com.atnc.ioms.enums.business.transfernet.TransferNetStatEnum;
import cn.com.atnc.ioms.enums.reports.JasperReportsEnum;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.business.approveinfo.IApproveInfoService;
import cn.com.atnc.ioms.mng.business.baseinfo.IApplyBaseInfoService;
import cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkAttachService;
import cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkConfManager;
import cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkManager;
import cn.com.atnc.ioms.mng.business.evaluete.IEvalueteManager;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitAttachService;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitManager;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteAttachService;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteConfigService;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteService;
import cn.com.atnc.ioms.mng.business.signoutnet.ISignoutNetConfigService;
import cn.com.atnc.ioms.mng.business.signoutnet.ISignoutNetManager;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphApplyService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphAttachService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphCircuitService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphConfigService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphService;
import cn.com.atnc.ioms.mng.business.transfernet.ITransferNetAttachService;
import cn.com.atnc.ioms.mng.business.transfernet.ITransferNetManager;
import cn.com.atnc.ioms.mng.reports.JasperReportService;
import cn.com.atnc.ioms.model.business.datacomnetwork.DataComNetworkQueryModel;
import cn.com.atnc.ioms.model.business.formalcircuit.FormalCircuitQueryModel;
import cn.com.atnc.ioms.model.business.taskrecord.TaskRecordQueryModel;
import cn.com.atnc.ioms.model.business.transfernet.TransferNetQueryModel;
import cn.com.atnc.ioms.util.JasperReportUtils;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 申请记录查询控制器
 *
 * @author ku
 * @date 2015年5月26日 下午1:26:24
 * @since 1.0.0
 */
@Controller
@RequestMapping("taskrecord")
public class TaskRecordController extends MyBaseController {

	@Autowired
	private IApplyBaseInfoService applyBaseInfoService;
	@Autowired
	private IKuSatelliteService kuSatelliteService;
	@Autowired
	private IKuSatelliteConfigService kuSatelliteConfigService;
	@Autowired
	private IApproveInfoService approveInfoService;
	@Autowired
	private IFormalCircuitManager formalCircuitManager;
	@Autowired
	private IKuSatelliteAttachService kuSatelliteAttachService;
	@Autowired
	private TeleGraphService teleGraphService;
	@Autowired
	private TeleGraphApplyService teleGraphApplyService;
	@Autowired
	private TeleGraphCircuitService teleGraphCircuitService;
	@Autowired
	private TeleGraphConfigService teleGraphConfigService;
	@Autowired
	private TeleGraphAttachService teleGraphAttachService;
	@Autowired
	private IDataComNetworkManager dataComNetworkManager;
	@Autowired
	private IDataComNetworkConfManager dataComNetworkConfManager;
	@Autowired
	private IDataComNetworkAttachService dataComNetworkAttachService;
	@Autowired
	private ITransferNetManager transferNetManager;
	@Autowired
	private ITransferNetAttachService transferNetAttachService;
	@Autowired
	private IEvalueteManager evaluateManager;
	@Autowired
	private IFormalCircuitAttachService formalCircuitAttachService;
	@Autowired
	private JasperReportService jasperReportService;
	@Autowired
	private IUserManager userManager;
	@Autowired
	private ISignoutNetManager signoutNetManager;
	@Autowired
	private ISignoutNetConfigService signoutNetConfigService;

	private List<TaskRecordQueryModel> applyBaseInfos = null;
	private Pagination returnPagn = null;

	@Value("#{fileProperties.rootFile}")
	private String rootFile;

	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String query(HttpServletRequest request, HttpSession session,
			Model model,
			@ModelAttribute("queryModel") TaskRecordQueryModel queryModel)
			throws IOException {
		super.pageInfo(model, request);
		model.addAttribute("applyTypes", ApplyTypeEnum.values());
		// 获取所有用户
		List<User> users = userManager.getAllOrderByDep();
		model.addAttribute("users", users);
		// 所属区域
		model.addAttribute("bureaus", Bureau.values());
		// 获取所有审批状态
		List<ApproveStatusEnum> approveStatusEnums = Arrays
				.asList(ApproveStatusEnum.values());
		model.addAttribute("approveStatusEnums", approveStatusEnums);
		return "business/taskrecord/manage";
	}

	// 查询
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") TaskRecordQueryModel queryModel,
			HttpServletRequest request, Model model) {

		// 将查询条件输入框中输入的‘%’或‘_’做为内容而不是做为模糊查询字符
		if (!StringUtils.isEmpty(queryModel.getApplyUserLike())) {
			queryModel.setApplyUserLike(queryModel.getApplyUserLike()
					.replace("%", "\\%").replace("_", "\\_"));
		}
		if (!StringUtils.isEmpty(queryModel.getApplyComLike())) {
			queryModel.setApplyComLike(queryModel.getApplyComLike()
					.replace("%", "\\%").replace("_", "\\_"));
		}
		if (!StringUtils.isEmpty(queryModel.getApplyLinkmanLike())) {
			queryModel.setApplyLinkmanLike(queryModel.getApplyLinkmanLike()
					.replace("%", "\\%").replace("_", "\\_"));
		}
		if (!StringUtils.isEmpty(queryModel.getApproveUser())) {
			queryModel.setApproveUser(queryModel.getApproveUser()
					.replace("%", "\\%").replace("_", "\\_"));
		}
		Pagination pagn = applyBaseInfoService.getPageByModel(queryModel);
		// 批量导出时使用
		returnPagn = pagn;
		applyBaseInfos = (List<TaskRecordQueryModel>) pagn.getResult();
		model.addAttribute("pagn", pagn);
		return "business/taskrecord/queryResult";
	}

	/**
	 * 查看详情操作
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-25下午2:00:03
	 * @param：
	 * @return：String
	 */
	@RequestMapping(value = "detail.do", method = RequestMethod.GET)
	public String setupDetailForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		ApplyBaseInfo applyBaseInfo = applyBaseInfoService.findById(id);
		ApplyTypeEnum applyType = applyBaseInfo.getApplyType();
		switch (applyType.name()) {
		case "satellite_ku":
			KuSatellite kuSatellite = (KuSatellite) kuSatelliteService
					.findByApplyBaseInfoId(id);
			model.addAttribute("approveInfos", approveInfoService
					.getApproveInfoByBaseInfoId(applyBaseInfo.getId()));
			model.addAttribute("kuSatellite", kuSatellite);
			if (kuSatellite != null) {
				// 上传附件
				model.addAttribute("kuSatelliteAttachEnums",
						Arrays.asList(KuSatelliteAttachEnum.values()));
				model.addAttribute("attaches", kuSatelliteAttachService
						.queryListByKuSateId(kuSatellite.getId()));
				// 配置信息
				model.addAttribute("kuSatelliteConfig",
						kuSatelliteConfigService.findByKuSateId(kuSatellite
								.getId()));
			}
			model.addAttribute("evaluateInfo", evaluateManager
					.findByApplyBaseInfoId(applyBaseInfo.getId()));
			return "business/taskrecord/kusatelliteDetail";
		case "transfernet":
			TransferNet transferNet = transferNetManager
					.findByApplyBaseInfo(id);
			TransferNetQueryModel pageModelt = new TransferNetQueryModel();
			model.addAttribute("approveInfos", approveInfoService
					.getApproveInfoByBaseInfoId(applyBaseInfo.getId()));
			if (transferNet != null) {
				pageModelt.setTransferNet(transferNet);
				// 上传附件
				model.addAttribute("attaches", transferNetAttachService
						.queryListByTNId(transferNet.getId()));
				model.addAttribute("transferAttachTypeEnums",
						Arrays.asList(TransferAttachTypeEnum.values()));
			}
			model.addAttribute("m", pageModelt);
			model.addAttribute("isVisable", false); // 申请表中，信息是否显示为输入框
			// 获取审批信息集合
			model.addAttribute("evaluateInfo", evaluateManager
					.findByApplyBaseInfoId(applyBaseInfo.getId()));
			return "business/taskrecord/transferNetDetail";
		case "datacomnetwork":
			DataComNetwork dataComNetwork = dataComNetworkManager
					.findByApplyBaseInfo(id);
			DataComNetworkQueryModel pageModeld = new DataComNetworkQueryModel();
			if (dataComNetwork != null) {
				pageModeld.setDataComNetwork(dataComNetwork);
				// 上传附件
				model.addAttribute("attaches", dataComNetworkAttachService
						.queryListByDCNId(dataComNetwork.getId()));
				model.addAttribute("netWorkAttachTypeEnums",
						Arrays.asList(NetWorkAttachTypeEnum.values()));
			}
			model.addAttribute("approveInfos", approveInfoService
					.getApproveInfoByBaseInfoId(applyBaseInfo.getId()));
			model.addAttribute("m", pageModeld);
			model.addAttribute("isVisable", false); // 申请表中，信息是否显示为输入框
			// 获取审批信息集合
			model.addAttribute("approveInfos", approveInfoService
					.getApproveInfoByBaseInfoId(applyBaseInfo.getId()));
			// 获取审批记录信息
			model.addAttribute("evaluateInfo", evaluateManager
					.findByApplyBaseInfoId(applyBaseInfo.getId()));
			// 获取配置信息
			model.addAttribute("dataComNetworkConfig",
					dataComNetwork.getDataComNetworkConfig());
			return "business/taskrecord/dataComNetworkDetail";
		case "telegraph":
			TeleGraph teleGraph = teleGraphService.getTeleGraphByBaseInfo(id);
			// 获取审批信息集合
			List<ApproveInfo> approveInfos = approveInfoService
					.getApproveInfoByBaseInfoId(applyBaseInfo.getId());
			model.addAttribute("approveInfos", approveInfos);
			model.addAttribute("evaluateInfo", evaluateManager
					.findByApplyBaseInfoId(applyBaseInfo.getId()));
			if (teleGraph != null) {
				model.addAttribute("teleGraphApplys", teleGraphApplyService
						.getApplysByParentId(teleGraph.getId()));
				// 获取电报配置实体集合
				model.addAttribute("teleGraphConfigs", teleGraphConfigService
						.getConfigsByTeleGraphId(teleGraph.getId()));
				// 上传附件
				model.addAttribute("teleAttachTypeEnums",
						Arrays.asList(TeleAttachTypeEnum.values()));
				model.addAttribute("attaches", teleGraphAttachService
						.queryListByTeleGraphId(teleGraph.getId()));
			}
			return "business/taskrecord/teleGraphDetail";
		case "telegraph_circuit":
			teleGraph = teleGraphService.getTeleGraphByBaseInfo(id);
			// 获取审批信息集合
			approveInfos = approveInfoService
					.getApproveInfoByBaseInfoId(applyBaseInfo.getId());
			model.addAttribute("approveInfos", approveInfos);
			model.addAttribute("evaluateInfo", evaluateManager
					.findByApplyBaseInfoId(applyBaseInfo.getId()));
			if (teleGraph != null) {
				model.addAttribute("teleGraphCircuits", teleGraphCircuitService
						.getCircuitsByParentId(teleGraph.getId()));
				// 上传附件
				model.addAttribute("attaches", teleGraphAttachService
						.queryListByTeleGraphId(teleGraph.getId()));
				model.addAttribute("teleAttachTypeEnums",
						Arrays.asList(TeleAttachTypeEnum.values()));
			}
			return "business/taskrecord/teleGraphCircuitDetail";
		case "formalcircuit_atm":
			FormalCircuitQueryModel pageModel = formalCircuitManager
					.getViewModel(applyBaseInfo);
			model.addAttribute("approveInfos", approveInfoService
					.getApproveInfoByBaseInfoId(applyBaseInfo.getId()));
			model.addAttribute("evaluateInfo", evaluateManager
					.findByApplyBaseInfoId(applyBaseInfo.getId()));
			model.addAttribute("m", pageModel);
			model.addAttribute("formalCircuitATMs",
					pageModel.getFormalCircuitATMli());
			model.addAttribute("formalCircuitKUs",
					pageModel.getFormalCircuitKUli());
			model.addAttribute("formalCircuitTESs",
					pageModel.getFormalCircuitTESli());
			model.addAttribute("formalCircuitTPESs",
					pageModel.getFormalCircuitPESli());
			FormalCircuit formalCircuit = pageModel.getFormalCircuit();
			if (formalCircuit != null) {
				// 获取配置信息
				model.addAttribute("formalCircuitConfig", pageModel
						.getFormalCircuit().getFormalCircuitConfig());
				// 上传附件
				model.addAttribute("attaches", formalCircuitAttachService
						.queryListByFCId(formalCircuit.getId()));
				model.addAttribute("formalCircuitAttachTypeEnum",
						Arrays.asList(FormalCircuitAttachTypeEnum.values()));
			}
			return "business/taskrecord/formalCircuitDetail";
		case "formalcircuit_ku":
			FormalCircuitQueryModel pageModel2 = formalCircuitManager
					.getViewModel(applyBaseInfo);
			model.addAttribute("approveInfos", approveInfoService
					.getApproveInfoByBaseInfoId(applyBaseInfo.getId()));
			model.addAttribute("evaluateInfo", evaluateManager
					.findByApplyBaseInfoId(applyBaseInfo.getId()));
			model.addAttribute("m", pageModel2);
			model.addAttribute("formalCircuitATMs",
					pageModel2.getFormalCircuitATMli());
			model.addAttribute("formalCircuitKUs",
					pageModel2.getFormalCircuitKUli());
			model.addAttribute("formalCircuitTESs",
					pageModel2.getFormalCircuitTESli());
			model.addAttribute("formalCircuitTPESs",
					pageModel2.getFormalCircuitPESli());
			// 附件
			formalCircuit = pageModel2.getFormalCircuit();
			if (formalCircuit != null) {
				// 获取配置信息
				model.addAttribute("formalCircuitConfig", pageModel2
						.getFormalCircuit().getFormalCircuitConfig());
				// 上传附件
				model.addAttribute("attaches", formalCircuitAttachService
						.queryListByFCId(formalCircuit.getId()));
				model.addAttribute("formalCircuitAttachTypeEnum",
						Arrays.asList(FormalCircuitAttachTypeEnum.values()));
			}
			return "business/taskrecord/formalCircuitDetail";
		case "formalcircuit_tes":
			FormalCircuitQueryModel pageModel3 = formalCircuitManager
					.getViewModel(applyBaseInfo);
			model.addAttribute("approveInfos", approveInfoService
					.getApproveInfoByBaseInfoId(applyBaseInfo.getId()));
			model.addAttribute("evaluateInfo", evaluateManager
					.findByApplyBaseInfoId(applyBaseInfo.getId()));
			model.addAttribute("m", pageModel3);
			model.addAttribute("formalCircuitATMs",
					pageModel3.getFormalCircuitATMli());
			model.addAttribute("formalCircuitKUs",
					pageModel3.getFormalCircuitKUli());
			model.addAttribute("formalCircuitTESs",
					pageModel3.getFormalCircuitTESli());
			model.addAttribute("formalCircuitTPESs",
					pageModel3.getFormalCircuitPESli());
			// 附件
			formalCircuit = pageModel3.getFormalCircuit();
			if (formalCircuit != null) {
				// 获取配置信息
				model.addAttribute("formalCircuitConfig", pageModel3
						.getFormalCircuit().getFormalCircuitConfig());
				// 上传附件
				model.addAttribute("attaches", formalCircuitAttachService
						.queryListByFCId(formalCircuit.getId()));
				model.addAttribute("formalCircuitAttachTypeEnum",
						Arrays.asList(FormalCircuitAttachTypeEnum.values()));
			}
			return "business/taskrecord/formalCircuitDetail";
		case "formalcircuit_pes":
			FormalCircuitQueryModel pageModel4 = formalCircuitManager
					.getViewModel(applyBaseInfo);
			model.addAttribute("approveInfos", approveInfoService
					.getApproveInfoByBaseInfoId(applyBaseInfo.getId()));
			model.addAttribute("evaluateInfo", evaluateManager
					.findByApplyBaseInfoId(applyBaseInfo.getId()));
			model.addAttribute("m", pageModel4);
			model.addAttribute("formalCircuitATMs",
					pageModel4.getFormalCircuitATMli());
			model.addAttribute("formalCircuitKUs",
					pageModel4.getFormalCircuitKUli());
			model.addAttribute("formalCircuitTESs",
					pageModel4.getFormalCircuitTESli());
			model.addAttribute("formalCircuitPESs",
					pageModel4.getFormalCircuitPESli());
			// 附件
			formalCircuit = pageModel4.getFormalCircuit();
			if (formalCircuit != null) {
				// 获取配置信息
				model.addAttribute("formalCircuitConfig", pageModel4
						.getFormalCircuit().getFormalCircuitConfig());
				// 上传附件
				model.addAttribute("attaches", formalCircuitAttachService
						.queryListByFCId(formalCircuit.getId()));
				model.addAttribute("formalCircuitAttachTypeEnum",
						Arrays.asList(FormalCircuitAttachTypeEnum.values()));
			}
			return "business/taskrecord/formalCircuitDetail";
		case "signoutnet_atm":
		case "signoutnet_pes":
		case "signoutnet_tes":
		case "signoutnet_ku":
			/**
			 * 退网申请
			 */
			SignoutNet signOutNet = (SignoutNet) signoutNetManager
					.findByApplyBaseInfoId(id);
			model.addAttribute("approveInfos", approveInfoService
					.getApproveInfoByBaseInfoId(applyBaseInfo.getId()));
			model.addAttribute("signoutNet", signOutNet);
			// 配置信息
			if (signOutNet != null) {
				model.addAttribute("signoutNetConfig", signoutNetConfigService
						.findBySignoutNetId(signOutNet.getId()));
			}
			model.addAttribute("evaluateInfo", evaluateManager
					.findByApplyBaseInfoId(applyBaseInfo.getId()));
			return "business/taskrecord/signoutnetDetail";

		default:
		}
		return null;
	}

	/**
	 * 批量导出
	 * 
	 * @author WangLingbin
	 * @date 2015年11月16日下午3:25:40
	 * @since 1.0.0
	 */
	@RequestMapping(value = "batchExport.dox", method = RequestMethod.POST)
	public String batchExport(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("queryModel") TaskRecordQueryModel queryModel,
			Model model) {
		// 用户帅选记录
		String result = "请选择需要批量导出的记录";
		try {
			List<TaskRecordQueryModel> results = applyBaseInfos;
			if (CollectionUtils.isEmpty(results)) {
				addError(model, result);
				return "business/taskrecord/result";
			}
			result = batchExport(request, response, results);
			/* model.addAttribute("vo", results.get(0)); */
			addSuccess(model, result);
			return "business/taskrecord/result";
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 批量导出
	 * 
	 * @author WangLingbin
	 * @date 2015年11月16日下午3:00:10
	 * @since 1.0.0
	 */
	private String batchExport(HttpServletRequest request,
			HttpServletResponse response, List<TaskRecordQueryModel> results) {
		// 输出文件流
		FileOutputStream out = null;
		// 报表模板
		List<JasperPrint> jasperPrints = new ArrayList<JasperPrint>();
		// 申请对象
		TeleGraph teleGraph = null;
		FormalCircuit formalCircuit = null;
		// 审批状态
		TeleGraphApproveStatEnum teleGraphApproveStatEnum = null;
		FormalStatEnum formalStatEnum = null;
		// 附件
		List<TeleGraphAttach> teleGraphAttachs = null;
		List<FormalCircuitAttach> formalCircuitAttachs = null;
		// 名称
		String fileName = null;
		String destUrl = null;
		String serialNumber = null;
		try {
			// 根据基础信息ID查找对应的申请实体
			for (TaskRecordQueryModel result : results) {
				ApplyBaseInfo applyBaseInfo = result.getApplyBaseInfo();
				serialNumber = applyBaseInfo.getSerialNumber();
				switch (applyBaseInfo.getApplyType()) {
				case satellite_ku:
					KuSatellite kuSatellite = (KuSatellite) kuSatelliteService
							.findByApplyBaseInfoId(applyBaseInfo.getId());
					// 只导出“未评价”和“已评价”的记录
					ApproveStatEnum approveStatEnum = kuSatellite
							.getApproveStat();
					if (!ObjectUtils.equals(approveStatEnum,
							ApproveStatEnum.local_evaluate)
							&& !ObjectUtils.equals(approveStatEnum,
									ApproveStatEnum.evaluated)) {
						continue;
					}
					// 根据基础信息ID查找对应的申请实体,下载附件
					List<KuSatelliteAttach> kuSatelliteAttachs = kuSatelliteAttachService
							.queryListByKuSateId(kuSatellite.getId());
					if (CollectionUtils.isNotEmpty(kuSatelliteAttachs)) {
						for (KuSatelliteAttach kuSatelliteAttach : kuSatelliteAttachs) {
							destUrl = kuSatelliteAttach.getAttachAddress();
							fileName = kuSatelliteAttach.getAttachName();
							downLoadAttaches(destUrl, fileName, serialNumber);
						}
					}
					// 获取报表模板
					jasperPrints = getJasperPrints(request, applyBaseInfo,
							JasperReportsEnum.kusatellite.name(), jasperPrints);
					break;
				case datacomnetwork:
					DataComNetwork dataComNetwork = dataComNetworkManager
							.findByApplyBaseInfo(applyBaseInfo.getId());
					// 只导出“未评价”和“已评价”的记录
					NetWorkStatEnum netWorkStatEnum = dataComNetwork
							.getApproveStat();
					if (!ObjectUtils.equals(netWorkStatEnum,
							NetWorkStatEnum.unevaluate)
							&& !ObjectUtils.equals(netWorkStatEnum,
									NetWorkStatEnum.deal)) {
						continue;
					}
					// 根据基础信息ID查找对应的申请实体,下载附件
					List<DataComNetworkAttach> comNetworkAttachs = dataComNetworkAttachService
							.queryListByDCNId(dataComNetwork.getId());//
					if (CollectionUtils.isNotEmpty(comNetworkAttachs)) {
						for (DataComNetworkAttach comNetworkAttach : comNetworkAttachs) {
							destUrl = comNetworkAttach.getAttachAddress();
							fileName = comNetworkAttach.getAttachName();
							downLoadAttaches(destUrl, fileName, serialNumber);
						}
					}
					// 下载申请表
					jasperPrints = getJasperPrints(request, applyBaseInfo,
							JasperReportsEnum.datacom_apply.name(),
							jasperPrints);
					// 下载配置表
					jasperPrints = getJasperPrints(request, applyBaseInfo,
							JasperReportsEnum.datacom_record.name(),
							jasperPrints);
					break;
				case telegraph:
					teleGraph = teleGraphService
							.getTeleGraphByBaseInfo(applyBaseInfo.getId());
					// 只导出“未评价”和“已评价”的记录
					teleGraphApproveStatEnum = teleGraph.getApproveStat();
					if (!ObjectUtils.equals(teleGraphApproveStatEnum,
							TeleGraphApproveStatEnum.local_evaluate)
							&& !ObjectUtils.equals(teleGraphApproveStatEnum,
									TeleGraphApproveStatEnum.evaluated)) {
						continue;
					}
					// 根据基础信息ID查找对应的申请实体,下载附件
					teleGraphAttachs = teleGraphAttachService
							.queryListByTeleGraphId(teleGraph.getId());//
					if (CollectionUtils.isNotEmpty(teleGraphAttachs)) {
						for (TeleGraphAttach teleGraphAttach : teleGraphAttachs) {
							destUrl = teleGraphAttach.getAttachAddress();
							fileName = teleGraphAttach.getAttachName();
							downLoadAttaches(destUrl, fileName, serialNumber);
						}
					}
					// 下载申请表
					jasperPrints = getJasperPrints(request, applyBaseInfo,
							JasperReportsEnum.apply.name(), jasperPrints);
					// 下载配置表
					jasperPrints = getJasperPrints(request, applyBaseInfo,
							JasperReportsEnum.config.name(), jasperPrints);
					break;
				case telegraph_circuit:
					// 下载申请表
					teleGraph = teleGraphService
							.getTeleGraphByBaseInfo(applyBaseInfo.getId());
					// 只导出“未评价”和“已评价”的记录
					teleGraphApproveStatEnum = teleGraph.getApproveStat();
					if (!ObjectUtils.equals(teleGraphApproveStatEnum,
							TeleGraphApproveStatEnum.local_evaluate)
							&& !ObjectUtils.equals(teleGraphApproveStatEnum,
									TeleGraphApproveStatEnum.evaluated)) {
						continue;
					}
					// 根据基础信息ID查找对应的申请实体,下载附件
					teleGraphAttachs = teleGraphAttachService
							.queryListByTeleGraphId(teleGraph.getId());//
					if (CollectionUtils.isNotEmpty(teleGraphAttachs)) {
						for (TeleGraphAttach teleGraphAttach : teleGraphAttachs) {
							destUrl = teleGraphAttach.getAttachAddress();
							fileName = teleGraphAttach.getAttachName();
							downLoadAttaches(destUrl, fileName, serialNumber);
						}
					}
					// 获取报表模板
					jasperPrints = getJasperPrints(request, applyBaseInfo,
							JasperReportsEnum.telegraph_circuit.name(),
							jasperPrints);
					break;
				case formalcircuit_ku:
					formalCircuit = formalCircuitManager
							.findByApplyBaseInfo(applyBaseInfo.getId());
					// 只导出“未评价”和“已评价”的记录
					formalStatEnum = formalCircuit.getApproveStat();
					if (!ObjectUtils.equals(formalStatEnum,
							FormalStatEnum.unevaluate)
							&& !ObjectUtils.equals(formalStatEnum,
									FormalStatEnum.deal)) {
						continue;
					}
					// 根据基础信息ID查找对应的申请实体,下载附件
					formalCircuitAttachs = formalCircuitAttachService
							.queryListByFCId(formalCircuit.getId());//
					if (CollectionUtils.isNotEmpty(formalCircuitAttachs)) {
						for (FormalCircuitAttach formalCircuitAttach : formalCircuitAttachs) {
							destUrl = formalCircuitAttach.getAttachAddress();
							fileName = formalCircuitAttach.getAttachName();
							downLoadAttaches(destUrl, fileName, serialNumber);
						}
					}
					jasperPrints = getJasperPrints(request, applyBaseInfo,
							JasperReportsEnum.KU.name(), jasperPrints);
					jasperPrints = getJasperPrints(request, applyBaseInfo,
							JasperReportsEnum.KU_config.name(), jasperPrints);
					break;
				case formalcircuit_atm:
					formalCircuit = formalCircuitManager
							.findByApplyBaseInfo(applyBaseInfo.getId());
					// 只导出“未评价”和“已评价”的记录
					formalStatEnum = formalCircuit.getApproveStat();
					if (!ObjectUtils.equals(formalStatEnum,
							FormalStatEnum.unevaluate)
							&& !ObjectUtils.equals(formalStatEnum,
									FormalStatEnum.deal)) {
						continue;
					}
					// 根据基础信息ID查找对应的申请实体,下载附件
					formalCircuitAttachs = formalCircuitAttachService
							.queryListByFCId(formalCircuit.getId());//
					if (CollectionUtils.isNotEmpty(formalCircuitAttachs)) {
						for (FormalCircuitAttach formalCircuitAttach : formalCircuitAttachs) {
							destUrl = formalCircuitAttach.getAttachAddress();
							fileName = formalCircuitAttach.getAttachName();
							downLoadAttaches(destUrl, fileName, serialNumber);
						}
					}
					jasperPrints = getJasperPrints(request, applyBaseInfo,
							JasperReportsEnum.ATM.name(), jasperPrints);
					jasperPrints = getJasperPrints(request, applyBaseInfo,
							JasperReportsEnum.ATM_config.name(), jasperPrints);
					break;
				case formalcircuit_tes:
					formalCircuit = formalCircuitManager
							.findByApplyBaseInfo(applyBaseInfo.getId());
					// 只导出“未评价”和“已评价”的记录
					formalStatEnum = formalCircuit.getApproveStat();
					if (!ObjectUtils.equals(formalStatEnum,
							FormalStatEnum.unevaluate)
							&& !ObjectUtils.equals(formalStatEnum,
									FormalStatEnum.deal)) {
						continue;
					}
					// 根据基础信息ID查找对应的申请实体,下载附件
					formalCircuitAttachs = formalCircuitAttachService
							.queryListByFCId(formalCircuit.getId());//
					if (CollectionUtils.isNotEmpty(formalCircuitAttachs)) {
						for (FormalCircuitAttach formalCircuitAttach : formalCircuitAttachs) {
							destUrl = formalCircuitAttach.getAttachAddress();
							fileName = formalCircuitAttach.getAttachName();
							downLoadAttaches(destUrl, fileName, serialNumber);
						}
					}
					jasperPrints = getJasperPrints(request, applyBaseInfo,
							JasperReportsEnum.TES.name(), jasperPrints);
					jasperPrints = getJasperPrints(request, applyBaseInfo,
							JasperReportsEnum.TES_config.name(), jasperPrints);
					break;
				case formalcircuit_pes:
					formalCircuit = formalCircuitManager
					.findByApplyBaseInfo(applyBaseInfo.getId());
					// 只导出“未评价”和“已评价”的记录
					formalStatEnum = formalCircuit.getApproveStat();
					if (!ObjectUtils.equals(formalStatEnum,
							FormalStatEnum.unevaluate)
							&& !ObjectUtils.equals(formalStatEnum,
									FormalStatEnum.deal)) {
						continue;
					}
					// 根据基础信息ID查找对应的申请实体,下载附件
					formalCircuitAttachs = formalCircuitAttachService
							.queryListByFCId(formalCircuit.getId());//
					if (CollectionUtils.isNotEmpty(formalCircuitAttachs)) {
						for (FormalCircuitAttach formalCircuitAttach : formalCircuitAttachs) {
							destUrl = formalCircuitAttach.getAttachAddress();
							fileName = formalCircuitAttach.getAttachName();
							downLoadAttaches(destUrl, fileName, serialNumber);
						}
					}
					jasperPrints = getJasperPrints(request, applyBaseInfo,
							JasperReportsEnum.PES.name(), jasperPrints);
					jasperPrints = getJasperPrints(request, applyBaseInfo,
							JasperReportsEnum.PES_config.name(), jasperPrints);
					break;
				case transfernet:
					TransferNet transferNet = transferNetManager
							.findByApplyBaseInfo(applyBaseInfo.getId());
					TransferNetStatEnum transferNetStatEnum = transferNet
							.getApproveStat();
					// 只导出“未评价”和“已评价”的记录
					if (!ObjectUtils.equals(transferNetStatEnum,
							TransferNetStatEnum.unevaluate)
							&& !ObjectUtils.equals(transferNetStatEnum,
									TransferNetStatEnum.deal)) {
						continue;
					}
					// 根据基础信息ID查找对应的申请实体,下载附件
					List<TransferNetAttach> transferNetAttachs = transferNetAttachService
							.queryListByTNId(transferNet.getId());//
					if (CollectionUtils.isNotEmpty(transferNetAttachs)) {
						for (TransferNetAttach transferNetAttach : transferNetAttachs) {
							destUrl = transferNetAttach.getAttachAddress();
							fileName = transferNetAttach.getAttachName();
							downLoadAttaches(destUrl, fileName, serialNumber);
						}
					}
					jasperPrints = getJasperPrints(request, applyBaseInfo,
							JasperReportsEnum.autotelegraph.name(),
							jasperPrints);
					break;
				default:
					break;
				}
				byte[] data = JasperReportUtils.exportReport("pdf", request,
						jasperPrints);
				File file = new File(rootFile + applyBaseInfo.getSerialNumber());
				if (!file.exists()) {
					file.mkdirs();
				}
				out = new FileOutputStream(new File(rootFile
						+ applyBaseInfo.getSerialNumber() + "\\"
						+ applyBaseInfo.getSerialNumber() + ".pdf"));
				out.write(data);
				jasperPrints = null;
			}
			return "批量导出附件成功";
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}

	/**
	 * 获取报表模板们
	 * 
	 * @param request
	 * @param teleGraph
	 * @throws JRException
	 * @author WangLingbin
	 * @date 2015年12月1日上午11:13:58
	 * @since 1.0.0
	 */
	private List<JasperPrint> getJasperPrints(HttpServletRequest request,
			ApplyBaseInfo applyBaseInfo, String reportName,
			List<JasperPrint> jasperPrints) throws JRException {
		if (CollectionUtils.isEmpty(jasperPrints)) {
			jasperPrints = new ArrayList<JasperPrint>();
		}
		// 下载报表
		if (StringUtils.equalsIgnoreCase(reportName,
				JasperReportsEnum.kusatellite.name())) {
			KuSatellite kuSatellite = (KuSatellite) kuSatelliteService
					.findByApplyBaseInfoId(applyBaseInfo.getId());
			// 卫星地球站入网
			kuSatelliteService.getReportParams(request, kuSatellite.getId(),
					reportName);
		} else if (StringUtils.equalsIgnoreCase(reportName,
				JasperReportsEnum.datacom_apply.name())) {
			DataComNetwork dataComNetwork = dataComNetworkManager
					.findByApplyBaseInfo(applyBaseInfo.getId());
			// 数据通信网入网申请
			dataComNetworkManager.getReportParams(request,
					dataComNetwork.getId(), reportName);
		} else if (StringUtils.equalsIgnoreCase(reportName,
				JasperReportsEnum.apply.name())
				|| StringUtils.equalsIgnoreCase(reportName,
						JasperReportsEnum.config.name())) {
			TeleGraph teleGraph = teleGraphService
					.getTeleGraphByBaseInfo(applyBaseInfo.getId());
			// 转报地址申请+转报地址配置
			teleGraphService.getReportParams(request, teleGraph.getId(),
					reportName);
		} else if (StringUtils.equalsIgnoreCase(reportName,
				JasperReportsEnum.telegraph_circuit.name())) {
			TeleGraph teleGraph = teleGraphService
					.getTeleGraphByBaseInfo(applyBaseInfo.getId());
			// 转报电路申请
			teleGraphCircuitService.getReportParams(request, teleGraph.getId(),
					reportName);
		} else if (StringUtils.equalsIgnoreCase(reportName,
				JasperReportsEnum.KU.name())
				|| StringUtils.equalsIgnoreCase(reportName,
						JasperReportsEnum.ATM.name())
				|| StringUtils.equalsIgnoreCase(reportName,
						JasperReportsEnum.TES.name())) {
			FormalCircuit formalCircuit = formalCircuitManager
					.findByApplyBaseInfo(applyBaseInfo.getId());
			// ATM/TES/KU数据网正式电路申请
			formalCircuitManager.getReportParams(request,
					formalCircuit.getId(), reportName);
		} else if (StringUtils.equalsIgnoreCase(reportName,
				JasperReportsEnum.autotelegraph.name())) {
			TransferNet transferNet = transferNetManager
					.findByApplyBaseInfo(applyBaseInfo.getId());
			// 自动转报网入网申请
			transferNetManager.getReportParams(request, transferNet.getId(),
					reportName);
		}
		// 获取填充好数据的报表，即.jprint格式
		JasperPrint jasperPrint = JasperReportUtils.getJasperPrint(request,
				reportName);
		jasperPrints.add(jasperPrint);
		return jasperPrints;
	}

	/**
	 * 下载上传的附件
	 * 
	 * @author WangLingbin
	 * @date 2015年12月1日上午9:31:46
	 * @since 1.0.0
	 */
	@SuppressWarnings("resource")
	private void downLoadAttaches(String destUrl, String fileName,
			String serialNumber) throws Exception {
		URL url = new URL(destUrl);
		HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
		// 连接指定的网络资源
		BufferedInputStream bis = null;
		try {
			httpUrl.connect();
			// 获取网络输入流
			InputStream in = httpUrl.getInputStream();
			bis = new BufferedInputStream(in);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		File file = new File(rootFile + serialNumber);
		if (!file.exists()) {
			file.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(new File(rootFile
				+ serialNumber + "\\" + fileName));
		byte[] b = new byte[1024];
		int i = 0;
		while ((i = bis.read(b)) > 0) {
			out.write(b, 0, i);
		}
		out.flush();
	}

}
