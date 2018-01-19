/**
 * @ProjectName PCSP
 * @FileName JasperReportServiceImpl.java
 * @PackageName:cn.com.atnc.pcsp.mng.reports.impl
 * @author WangLingbin
 * @date 2015年5月28日下午2:58:49
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.reports.impl;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetwork;
import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetworkConfig;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitATM;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitConfig;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitKU;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitPES;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitTES;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraph;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphApply;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphCircuit;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphConfig;
import cn.com.atnc.ioms.entity.business.transfernet.TransferNet;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.entity.maintain.month.KuMonthReport;
import cn.com.atnc.ioms.entity.maintain.month.KuReportData;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.KuNodeInfo;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.OduPolling;
import cn.com.atnc.ioms.entity.reports.ATMFormalCircuitEntity;
import cn.com.atnc.ioms.entity.reports.AutoTelegraphEntity;
import cn.com.atnc.ioms.entity.reports.DataComNetworkEntity;
import cn.com.atnc.ioms.entity.reports.FormalCircuitBaseInfoEntity;
import cn.com.atnc.ioms.entity.reports.KUFormalCircuitEntity;
import cn.com.atnc.ioms.entity.reports.KuMaintenceAlarmEntity;
import cn.com.atnc.ioms.entity.reports.KuMaintenceEntity;
import cn.com.atnc.ioms.entity.reports.KuMaintenceNodeInfoEntity;
import cn.com.atnc.ioms.entity.reports.KuMaintenceODUEntity;
import cn.com.atnc.ioms.entity.reports.KuMaintenceOperEntity;
import cn.com.atnc.ioms.entity.reports.PESFormalCircuitEntity;
import cn.com.atnc.ioms.entity.reports.TESFormalCircuitEntity;
import cn.com.atnc.ioms.entity.reports.TeleGraphApplyEntity;
import cn.com.atnc.ioms.entity.reports.TeleGraphBaseInfoEntity;
import cn.com.atnc.ioms.entity.reports.TeleGraphCircuitEntity;
import cn.com.atnc.ioms.entity.reports.TeleGraphConfigEntity;
import cn.com.atnc.ioms.enums.basedata.NetworkType;
import cn.com.atnc.ioms.enums.maintain.month.KuMonthReportLegendEnum;
import cn.com.atnc.ioms.mng.basedata.satellite.site.ISiteManager;
import cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkManager;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitATMManager;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitKUManager;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitManager;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitPESManager;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitTESManager;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphApplyService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphCircuitService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphConfigService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphService;
import cn.com.atnc.ioms.mng.business.transfernet.ITransferNetManager;
import cn.com.atnc.ioms.mng.maintain.equip.IMaintainEquipManager;
import cn.com.atnc.ioms.mng.maintain.month.KuMonthReportManager;
import cn.com.atnc.ioms.mng.maintain.month.KuReportDataManager;
import cn.com.atnc.ioms.mng.maintain.pollinginfo.KuNodeInfoManager;
import cn.com.atnc.ioms.mng.maintain.pollinginfo.OduPollingInfoManager;
import cn.com.atnc.ioms.mng.reports.JasperReportService;
import cn.com.atnc.ioms.util.DateUtilTools;
import cn.com.atnc.ioms.util.JasperReportUtils;

/**
 * 报表实现类
 * 
 * @author WangLingbin
 * @date 2015年5月28日 下午2:58:49
 * @since 1.0.0
 */
@Service
@Transactional
@SuppressWarnings("rawtypes")
public class JasperReportServiceImpl extends BaseService implements
		JasperReportService {

	@Autowired
	private TeleGraphService teleGraphService;
	@Autowired
	private TeleGraphApplyService teleGraphApplyService;
	@Autowired
	private TeleGraphCircuitService teleGraphCircuitService;
	@Autowired
	private TeleGraphConfigService teleGraphConfigService;
	@Autowired
	private IFormalCircuitManager formalCircuitManager;
	@Autowired
	private IFormalCircuitATMManager formalCircuitATMManager;
	@Autowired
	private IFormalCircuitTESManager formalCircuitTESManager;
	@Autowired
	private IFormalCircuitPESManager formalCircuitPESManager;
	@Autowired
	private IFormalCircuitKUManager formalCircuitKUManager;
	@Autowired
	private IDataComNetworkManager dataComNetworkManager;
	@Autowired
	private ITransferNetManager transferNetManager;
	@Autowired
	private KuNodeInfoManager kuNodeInfoManager;
	@Autowired
	private ISiteManager siteManager;
	@Autowired
	private IMaintainEquipManager maintainEquipManager;
	@Autowired
	private OduPollingInfoManager oduPollingInfoManager;
	@Autowired
	private KuMonthReportManager kuMonthReportManager;
	@Autowired
	private KuReportDataManager kuReportDataManager;

	/**
	 * 报表预览
	 * 
	 * @see cn.com.atnc.pcsp.mng.reports.JasperReportService#preView(javax.servlet.http.HttpServletRequest,
	 *      java.util.List, java.util.List, java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> preView(HttpServletRequest request,
			List datasource, List subreportDatasource, String imageName,
			String reportName) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("datasource", datasource);
		try {
			if (CollectionUtils.isEmpty(subreportDatasource)) {
				JasperReportUtils.fillData(param, request, reportName,
						imageName, datasource, false);
			} else {
				param.put("subreportDatasource", subreportDatasource);
				JasperReportUtils.fillData(param, request, reportName,
						imageName, datasource, true);
			}
		} catch (JRException e) {
			throw new RuntimeException();
		}
		return param;
	}

	/**
	 * 报表导出
	 * 
	 * @see cn.com.atnc.pcsp.mng.reports.JasperReportService#export(java.lang.String,
	 *      java.lang.String, javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void export(String type, String reportName,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			// 获取报表在服务器的绝对路径
			String path = JasperReportUtils.getJrprintPath(request, reportName);
			path = path.substring(0, path.lastIndexOf(".") + 1) + type;
			// 获取下载文件名
			String filename = path.substring(path.lastIndexOf("\\") + 1,
					path.length());
			// 获取填充好数据的报表，即.jprint格式
			JasperPrint jasperPrint = JasperReportUtils.getJasperPrint(request,
					reportName);
			byte[] data = JasperReportUtils.exportReport(type, request,
					jasperPrint);
			int length = data.length;
			response.setContentType("application/octet-stream");
			response.setHeader("content-disposition", "attachment;filename="
					+ URLEncoder.encode(filename, "utf-8"));
			response.setContentLength(length);
			ServletOutputStream outputStream = response.getOutputStream();
			outputStream.write(data, 0, length);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 预览方法重载（不包含图像）
	 * 
	 * @see cn.com.atnc.pcsp.mng.reports.JasperReportService#preView(javax.servlet.http.HttpServletRequest,
	 *      java.util.List, java.util.List, java.lang.String)
	 */
	@Override
	public Map<String, Object> preView(HttpServletRequest request,
			List datasource, List subreportDatasource, String reportName) {
		return preView(request, datasource, subreportDatasource, null,
				reportName);
	}

	/**
	 * 预览方法重载（不包含子报表）
	 * 
	 * @see cn.com.atnc.pcsp.mng.reports.JasperReportService#preView(javax.servlet.http.HttpServletRequest,
	 *      java.util.List, java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> preView(HttpServletRequest request,
			List datasource, String imageName, String reportName) {
		return preView(request, datasource, null, imageName, reportName);
	}

	/**
	 * 预览方法重载（不包含子报表和图像）
	 * 
	 * @see cn.com.atnc.pcsp.mng.reports.JasperReportService#preView(javax.servlet.http.HttpServletRequest,
	 *      java.util.List, java.lang.String)
	 */
	@Override
	public Map<String, Object> preView(HttpServletRequest request,
			List datasource, String reportName) {
		return preView(request, datasource, null, null, reportName);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.mng.reports.JasperReportService#getApplyDatasource(java.lang.String)
	 */
	@Override
	public List<TeleGraphBaseInfoEntity> getApplyDatasource(String id) {
		List<TeleGraphApply> teleGraphApplys = teleGraphApplyService
				.getApplysByParentId(id);
		TeleGraph teleGraph = teleGraphService.getTeleGraphById(id);
		// 获得子报表数据源
		List<TeleGraphApplyEntity> sub = new ArrayList<TeleGraphApplyEntity>();
		for (TeleGraphApply teleGraphApply : teleGraphApplys) {
			TeleGraphApplyEntity applyEntity = new TeleGraphApplyEntity(
					teleGraphApply.getIdentify(), teleGraphApply.getUserArea(),
					teleGraphApply.getUsage() == null ? null : teleGraphApply
							.getUsage().getValue(),
					teleGraphApply.getApplyTime(), teleGraphApply.getUseTime(),
					teleGraphApply.getConnection() == null ? null
							: teleGraphApply.getConnection().getValue(),
					teleGraphApply.getOriginalAddr(),
					teleGraphApply.getAllocatedAddr(),
					teleGraphApply.getOperPeople(),
					teleGraphApply.getOperTime());
			sub.add(applyEntity);
		}
		// 获得主报表数据源
		List<TeleGraphBaseInfoEntity> main = new ArrayList<TeleGraphBaseInfoEntity>();
		TeleGraphBaseInfoEntity baseInfo = new TeleGraphBaseInfoEntity(
				teleGraph.getApplyBaseInfo().getApplyCom(), teleGraph
						.getApplyBaseInfo().getSerialNumber(), teleGraph
						.getApplyBaseInfo().getApplyLinkman(), teleGraph
						.getApplyBaseInfo().getApplyPhone(),
				teleGraph.getTeleApplyType() == null ? null : teleGraph
						.getTeleApplyType().getValue(),
				teleGraph.getApplyComSign(),
				teleGraph.getUsingPeriod() == null ? null : teleGraph
						.getUsingPeriod().getValue(),
				teleGraph.getUsingArea() == null ? null : teleGraph
						.getUsingArea().getValue(), teleGraph.getRemark(),
				teleGraph.getAreaOpition(), teleGraph.getAreaSign(),
				teleGraph.getAtncOpition(), teleGraph.getApplyBaseInfo()
						.getFinalLinkman() == null ? null : (teleGraph
						.getApplyBaseInfo().getFinalLinkman() + "/" + teleGraph
						.getApplyBaseInfo().getFinalLinkphone()),
				DateUtilTools.format(teleGraph.getApplyBaseInfo()
						.getApplyDate().getTime()),
				teleGraph.getAddressType() == null ? null : teleGraph
						.getAddressType().getValue(), sub, null, null);
		main.add(baseInfo);
		return main;
	}

	@Override
	public List<TeleGraphBaseInfoEntity> getCircuitsDatasource(String id) {
		List<TeleGraphCircuit> teleGraphCircuits = teleGraphCircuitService
				.getCircuitsByParentId(id);
		int count = 0;
		// 获得子报表数据源
		List<TeleGraphCircuitEntity> sub = new ArrayList<TeleGraphCircuitEntity>();
		for (TeleGraphCircuit teleGraphCircuit : teleGraphCircuits) {
			TeleGraphCircuitEntity circuitEntity = new TeleGraphCircuitEntity(
					++count + "", teleGraphCircuit.getUserArea(),
					teleGraphCircuit.getChannelName(),
					teleGraphCircuit.getInWord(),
					teleGraphCircuit.getOutWord(),
					teleGraphCircuit.getAlarmAddress(),
					teleGraphCircuit.getMasthead(),
					teleGraphCircuit.getTrailer(), teleGraphCircuit.getSpeed(),
					teleGraphCircuit.getCode(), teleGraphCircuit.getQueue());
			sub.add(circuitEntity);
		}
		// 获得主报表数据源
		List<TeleGraphBaseInfoEntity> main = new ArrayList<TeleGraphBaseInfoEntity>();
		TeleGraph teleGraph = teleGraphService.getTeleGraphById(id);
		TeleGraphBaseInfoEntity baseInfo = new TeleGraphBaseInfoEntity(
				teleGraph.getApplyBaseInfo().getApplyCom(), teleGraph
						.getApplyBaseInfo().getSerialNumber(), teleGraph
						.getApplyBaseInfo().getApplyLinkman(), teleGraph
						.getApplyBaseInfo().getApplyPhone(),
				teleGraph.getTeleApplyType() == null ? null : teleGraph
						.getTeleApplyType().getValue(),
				teleGraph.getApplyComSign(),
				teleGraph.getUsingPeriod() == null ? null : teleGraph
						.getUsingPeriod().getValue(),
				teleGraph.getUsingArea() == null ? null : teleGraph
						.getUsingArea().getValue(), teleGraph.getRemark(),
				teleGraph.getAreaOpition(), teleGraph.getAreaSign(),
				teleGraph.getAtncOpition(), teleGraph.getApplyBaseInfo()
						.getFinalLinkman() == null ? null : (teleGraph
						.getApplyBaseInfo().getFinalLinkman() + "/" + teleGraph
						.getApplyBaseInfo().getFinalLinkphone()),
				DateUtilTools.format(teleGraph.getApplyBaseInfo()
						.getApplyDate().getTime()),
				teleGraph.getAddressType() == null ? null : teleGraph
						.getAddressType().getValue(), null, null, sub);
		main.add(baseInfo);
		return main;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.mng.reports.JasperReportService#getConfigDatasource(java.lang.String)
	 */
	@Override
	public List<TeleGraphBaseInfoEntity> getConfigDatasource(String id) {
		List<TeleGraphConfig> teleGraphConfigs = teleGraphConfigService
				.getConfigsByTeleGraphId(id);
		// 获得子报表数据源
		List<TeleGraphConfigEntity> sub = new ArrayList<TeleGraphConfigEntity>();
		for (TeleGraphConfig teleGraphConfig : teleGraphConfigs) {
			TeleGraphConfigEntity configEntity = new TeleGraphConfigEntity(
					teleGraphConfig.getIdentifier(),
					teleGraphConfig.getAreaUseAddr(),
					teleGraphConfig.getAreaRouteAddr(),
					teleGraphConfig.getAreaConfigTime(),
					teleGraphConfig.getAreaConfigPeople(),
					teleGraphConfig.getAreaConnectionCondition() == null ? null
							: teleGraphConfig.getAreaConnectionCondition()
									.getValue(),
					teleGraphConfig.getAtncRountAddr(),
					teleGraphConfig.getAtncConfigTime(),
					teleGraphConfig.getAtncConfigPeople(),
					teleGraphConfig.getAtncConnectionCondition() == null ? null
							: teleGraphConfig.getAtncConnectionCondition()
									.getValue());
			sub.add(configEntity);
		}
		// 获得主报表数据源
		List<TeleGraphBaseInfoEntity> main = new ArrayList<TeleGraphBaseInfoEntity>();
		TeleGraph teleGraph = teleGraphService.getTeleGraphById(id);
		TeleGraphBaseInfoEntity baseInfo = new TeleGraphBaseInfoEntity(
				teleGraph.getApplyBaseInfo().getApplyCom(), teleGraph
						.getApplyBaseInfo().getApplyLinkman(), teleGraph
						.getApplyBaseInfo().getApplyPhone(),
				teleGraph.getTeleApplyType() == null ? null : teleGraph
						.getTeleApplyType().getValue(),
				teleGraph.getApplyComSign(),
				teleGraph.getUsingPeriod() == null ? null : teleGraph
						.getUsingPeriod().getValue(),
				teleGraph.getUsingArea() == null ? null : teleGraph
						.getUsingArea().getValue(), teleGraph.getRemark(),
				teleGraph.getAreaOpition(), teleGraph.getAreaSign(),
				teleGraph.getAtncOpition(), teleGraph.getApplyBaseInfo()
						.getFinalLinkman() == null ? null : (teleGraph
						.getApplyBaseInfo().getFinalLinkman() + "/" + teleGraph
						.getApplyBaseInfo().getFinalLinkphone()),
				DateUtilTools.format(teleGraph.getApplyBaseInfo()
						.getApplyDate().getTime()),
				teleGraph.getAddressType() == null ? null : teleGraph
						.getAddressType().getValue(), null, sub);
		main.add(baseInfo);
		return main;
	}

	@Override
	public List<FormalCircuitBaseInfoEntity> getATMDatasource(String id) {

		FormalCircuit formalCircuit = formalCircuitManager.findById(id);
		List<FormalCircuitATM> atms = formalCircuitATMManager
				.findByFC(formalCircuit);
		// 获得子报表数据源
		List<ATMFormalCircuitEntity> sub = new ArrayList<ATMFormalCircuitEntity>();
		for (FormalCircuitATM atm : atms) {
			ATMFormalCircuitEntity atmEntity = new ATMFormalCircuitEntity(
					atm.getIdentifier(), atm.getBusinessName(),
					atm.getTxNodeName(), atm.getTxSlot(), atm.getTxLine(),
					atm.getTxPort(), atm.getTxPortSpeed(), atm.getTxVpiDlci(),
					atm.getRxNodeName(), atm.getRxSlot(), atm.getRxLine(),
					atm.getRxPort(), atm.getRxPortSpeed(), atm.getRxVpiDlci(),
					atm.getCircuitSpeed(), atm.getServiceType() == null ? ""
							: atm.getServiceType().getValue(), atm
							.getOpenTime().getTime());
			sub.add(atmEntity);
		}
		// 获得主报表数据源
		List<FormalCircuitBaseInfoEntity> main = new ArrayList<FormalCircuitBaseInfoEntity>();
		FormalCircuitBaseInfoEntity baseInfo = new FormalCircuitBaseInfoEntity(
				formalCircuit.getApplyBaseInfo().getApplyCom(), formalCircuit
						.getApplyBaseInfo().getSerialNumber(), formalCircuit
						.getApplyBaseInfo().getApplyLinkman(), formalCircuit
						.getApplyBaseInfo().getApplyPhone(), formalCircuit
						.getApplyBaseInfo().getApplyTelephone(), formalCircuit
						.getApplyBaseInfo().getApplyFax(), formalCircuit
						.getApplyBaseInfo().getApplyEmail(),
				formalCircuit.getApplyOpttype() == null ? null : formalCircuit
						.getApplyOpttype().getValue(),
				formalCircuit.getApplySign(), formalCircuit.getApplyRemark(),
				formalCircuit.getAreaOpinion(), formalCircuit.getAreaSign(),
				formalCircuit.getAtncOpinion(), formalCircuit
						.getApplyBaseInfo().getFinalLinkman() == null ? null
						: (formalCircuit.getApplyBaseInfo().getFinalLinkman()
								+ "/" + formalCircuit.getApplyBaseInfo()
								.getFinalLinkphone()),
				DateUtilTools.format(formalCircuit.getApplyBaseInfo()
						.getApplyDate().getTime()), sub, null, null, null);
		main.add(baseInfo);
		return main;
	}

	@Override
	public List<FormalCircuitBaseInfoEntity> getTESDatasource(String id) {
		FormalCircuit formalCircuit = formalCircuitManager.findById(id);
		List<FormalCircuitTES> tess = formalCircuitTESManager
				.findByFC(formalCircuit);
		// 获得子报表数据源
		List<TESFormalCircuitEntity> sub = new ArrayList<TESFormalCircuitEntity>();
		for (FormalCircuitTES tes : tess) {
			TESFormalCircuitEntity tesEntity = new TESFormalCircuitEntity(
					tes.getIdentifier(), tes.getBusinessName(),
					tes.getTxSiteName(), tes.getTxCaseNum(),
					tes.getTxSlotNum(), tes.getRxSiteName(),
					tes.getRxCaseNum(), tes.getRxSlotNum(),
					tes.getCircuitSpeed(),
					tes.getCommunicateWay() == null ? null : tes
							.getCommunicateWay().getValue(), tes.getOpenTime()
							.getTime());
			sub.add(tesEntity);
		}
		// 获得主报表数据源
		List<FormalCircuitBaseInfoEntity> main = new ArrayList<FormalCircuitBaseInfoEntity>();
		FormalCircuitBaseInfoEntity baseInfo = new FormalCircuitBaseInfoEntity(
				formalCircuit.getApplyBaseInfo().getApplyCom(), formalCircuit
						.getApplyBaseInfo().getSerialNumber(), formalCircuit
						.getApplyBaseInfo().getApplyLinkman(), formalCircuit
						.getApplyBaseInfo().getApplyPhone(), formalCircuit
						.getApplyBaseInfo().getApplyTelephone(), formalCircuit
						.getApplyBaseInfo().getApplyFax(), formalCircuit
						.getApplyBaseInfo().getApplyEmail(),
				formalCircuit.getApplyOpttype() == null ? null : formalCircuit
						.getApplyOpttype().getValue(),
				formalCircuit.getApplySign(), formalCircuit.getApplyRemark(),
				formalCircuit.getAreaOpinion(), formalCircuit.getAreaSign(),
				formalCircuit.getAtncOpinion(), formalCircuit
						.getApplyBaseInfo().getFinalLinkman() == null ? null
						: (formalCircuit.getApplyBaseInfo().getFinalLinkman()
								+ "/" + formalCircuit.getApplyBaseInfo()
								.getFinalLinkphone()),
				DateUtilTools.format(formalCircuit.getApplyBaseInfo()
						.getApplyDate().getTime()), null, null, sub, null);
		main.add(baseInfo);
		return main;
	}

	@Override
	public List<FormalCircuitBaseInfoEntity> getPESDatasource(String id) {
		FormalCircuit formalCircuit = formalCircuitManager.findById(id);
		List<FormalCircuitPES> pess = formalCircuitPESManager
				.findByFC(formalCircuit);
		// 获得子报表数据源
		List<PESFormalCircuitEntity> sub = new ArrayList<PESFormalCircuitEntity>();
		for (FormalCircuitPES pes : pess) {
			PESFormalCircuitEntity pesEntity = new PESFormalCircuitEntity(
					pes.getIdentifier(), pes.getBusinessName(),
					pes.getTxSiteName(), pes.getTxCaseNum(),
					pes.getTxSlotNum(), pes.getTxPortNum(),
					pes.getRxSiteName(), pes.getRxCaseNum(),
					pes.getRxSlotNum(), pes.getRxPortNum(),
					pes.getCircuitSpeed(),
					pes.getCommunicateWay() == null ? null : pes
							.getCommunicateWay().getValue(), pes.getUsage(),
					pes.getOpenTime().getTime());
			sub.add(pesEntity);
		}
		// 获得主报表数据源
		List<FormalCircuitBaseInfoEntity> main = new ArrayList<FormalCircuitBaseInfoEntity>();
		FormalCircuitBaseInfoEntity baseInfo = new FormalCircuitBaseInfoEntity(
				formalCircuit.getApplyBaseInfo().getApplyCom(), formalCircuit
						.getApplyBaseInfo().getSerialNumber(), formalCircuit
						.getApplyBaseInfo().getApplyLinkman(), formalCircuit
						.getApplyBaseInfo().getApplyPhone(), formalCircuit
						.getApplyBaseInfo().getApplyTelephone(), formalCircuit
						.getApplyBaseInfo().getApplyFax(), formalCircuit
						.getApplyBaseInfo().getApplyEmail(),
				formalCircuit.getApplyOpttype() == null ? null : formalCircuit
						.getApplyOpttype().getValue(),
				formalCircuit.getApplySign(), formalCircuit.getApplyRemark(),
				formalCircuit.getAreaOpinion(), formalCircuit.getAreaSign(),
				formalCircuit.getAtncOpinion(), formalCircuit
						.getApplyBaseInfo().getFinalLinkman() == null ? null
						: (formalCircuit.getApplyBaseInfo().getFinalLinkman()
								+ "/" + formalCircuit.getApplyBaseInfo()
								.getFinalLinkphone()),
				DateUtilTools.format(formalCircuit.getApplyBaseInfo()
						.getApplyDate().getTime()), null, null, null, sub);
		main.add(baseInfo);
		return main;
	}

	@Override
	public List<FormalCircuitBaseInfoEntity> getKUDatasource(String id) {
		FormalCircuit formalCircuit = formalCircuitManager.findById(id);
		List<FormalCircuitKU> kus = formalCircuitKUManager
				.findByFC(formalCircuit);
		// 获得子报表数据源
		List<KUFormalCircuitEntity> sub = new ArrayList<KUFormalCircuitEntity>();
		for (FormalCircuitKU ku : kus) {
			KUFormalCircuitEntity kuEntity = new KUFormalCircuitEntity(
					ku.getIdentifier(), ku.getBusinessName(),
					ku.getTxSiteName(), ku.getTxNodeNum(), ku.getTxSlotNum(),
					ku.getTxPortNum(), ku.getRxSiteName(), ku.getRxNodeNum(),
					ku.getRxSlotNum(), ku.getRxPortNum(), ku.getCircuitSpeed(),
					ku.getCommunicateWay() == null ? null : ku
							.getCommunicateWay().getValue(), ku.getUsage(), ku
							.getOpenTime().getTime());
			sub.add(kuEntity);
		}
		// 获得主报表数据源
		List<FormalCircuitBaseInfoEntity> main = new ArrayList<FormalCircuitBaseInfoEntity>();
		FormalCircuitBaseInfoEntity baseInfo = new FormalCircuitBaseInfoEntity(
				formalCircuit.getApplyBaseInfo().getApplyCom(), formalCircuit
						.getApplyBaseInfo().getSerialNumber(), formalCircuit
						.getApplyBaseInfo().getApplyLinkman(), formalCircuit
						.getApplyBaseInfo().getApplyPhone(), formalCircuit
						.getApplyBaseInfo().getApplyTelephone(), formalCircuit
						.getApplyBaseInfo().getApplyFax(), formalCircuit
						.getApplyBaseInfo().getApplyEmail(),
				formalCircuit.getApplyOpttype() == null ? null : formalCircuit
						.getApplyOpttype().getValue(),
				formalCircuit.getApplySign(), formalCircuit.getApplyRemark(),
				formalCircuit.getAreaOpinion(), formalCircuit.getAreaSign(),
				formalCircuit.getAtncOpinion(), formalCircuit
						.getApplyBaseInfo().getFinalLinkman() == null ? null
						: (formalCircuit.getApplyBaseInfo().getFinalLinkman()
								+ "/" + formalCircuit.getApplyBaseInfo()
								.getFinalLinkphone()),
				DateUtilTools.format(formalCircuit.getApplyBaseInfo()
						.getApplyDate().getTime()), null, sub, null, null);
		main.add(baseInfo);
		return main;
	}

	@Override
	public List<FormalCircuitBaseInfoEntity> getATMConfigDatasource(String id) {
		FormalCircuit formalCircuit = formalCircuitManager.findById(id);
		List<FormalCircuitATM> atms = formalCircuitATMManager
				.findByFC(formalCircuit);
		// 获得子报表数据源
		List<ATMFormalCircuitEntity> sub = new ArrayList<ATMFormalCircuitEntity>();
		for (FormalCircuitATM atm : atms) {
			ATMFormalCircuitEntity atmEntity = new ATMFormalCircuitEntity(
					atm.getIdentifier(), atm.getConfTxNodeName(),
					atm.getConfTxSlodNum(), atm.getConfTxLine(),
					atm.getConfTxPort(), atm.getConfTxSignal() == null ? null
							: atm.getConfTxSignal().getValue(),
					atm.getConfTxVpiDlci(), atm.getConfRxNodeName(),
					atm.getConfRxSlodNum(), atm.getConfRxLine(),
					atm.getConfRxPort(), atm.getConfRxSignal() == null ? null
							: atm.getConfRxSignal().getValue(),
					atm.getConfRxVpiDlci(), atm.getConfUsage(),
					atm.getConfServiceType() == null ? null : atm
							.getConfServiceType().getValue(),
					atm.getConfSpeed(), atm.getConfRemark(), atm.getConfNo());
			sub.add(atmEntity);
		}
		// 获得主报表数据源
		List<FormalCircuitBaseInfoEntity> main = new ArrayList<FormalCircuitBaseInfoEntity>();
		// 获得配置实体
		FormalCircuitConfig formalCircuitConfig = formalCircuit
				.getFormalCircuitConfig();
		FormalCircuitBaseInfoEntity baseInfo = new FormalCircuitBaseInfoEntity(
				formalCircuitConfig.getConfigTime() == null ? null
						: formalCircuitConfig.getConfigTime().getTime(),
				formalCircuitConfig.getPurpose(),
				formalCircuitConfig.getAtncLeader(),
				formalCircuitConfig.getOperateUser() == null ? null
						: (formalCircuitConfig.getOperateUser() + "/010-58729911/12/14/15"),
				formalCircuitConfig.getAuditUser(), formalCircuitConfig
						.getRemark(), sub, null, null, null);
		main.add(baseInfo);
		return main;
	}

	@Override
	public List<FormalCircuitBaseInfoEntity> getTESConfigDatasource(String id) {
		FormalCircuit formalCircuit = formalCircuitManager.findById(id);
		List<FormalCircuitTES> tess = formalCircuitTESManager
				.findByFC(formalCircuit);
		// 获得子报表数据源
		List<TESFormalCircuitEntity> sub = new ArrayList<TESFormalCircuitEntity>();
		for (FormalCircuitTES tes : tess) {
			TESFormalCircuitEntity tesEntity = new TESFormalCircuitEntity(
					tes.getIdentifier(), tes.getConfTxSiteName(),
					tes.getConfTxCaseNum(), tes.getConfTxSlotNum(),
					tes.getConfTxInterface(), tes.getConfRxSiteName(),
					tes.getConfRxCaseNum(), tes.getConfRxSlotNum(),
					tes.getConfRxInterface(), tes.getConfCircuitName(),
					tes.getConfSpeed(),
					tes.getConfCommunicateWay() == null ? null : tes
							.getConfCommunicateWay().getValue(),
					tes.getConfClock(), tes.getConfNo(), tes.getConfUsage());
			sub.add(tesEntity);
		}
		// 获得主报表数据源
		List<FormalCircuitBaseInfoEntity> main = new ArrayList<FormalCircuitBaseInfoEntity>();
		// 获得配置实体
		FormalCircuitConfig formalCircuitConfig = formalCircuit
				.getFormalCircuitConfig();
		FormalCircuitBaseInfoEntity baseInfo = new FormalCircuitBaseInfoEntity(
				formalCircuitConfig.getConfigTime() == null ? null
						: formalCircuitConfig.getConfigTime().getTime(),
				formalCircuitConfig.getPurpose(),
				formalCircuitConfig.getAtncLeader(),
				formalCircuitConfig.getOperateUser() == null ? null
						: (formalCircuitConfig.getOperateUser() + "/010-58729911/12/14/15"),
				formalCircuitConfig.getAuditUser(), formalCircuitConfig
						.getRemark(), null, null, sub, null);
		main.add(baseInfo);
		return main;
	}

	@Override
	public List<FormalCircuitBaseInfoEntity> getPESConfigDatasource(String id) {
		FormalCircuit formalCircuit = formalCircuitManager.findById(id);
		List<FormalCircuitPES> pess = formalCircuitPESManager
				.findByFC(formalCircuit);
		// 获得子报表数据源
		List<PESFormalCircuitEntity> sub = new ArrayList<PESFormalCircuitEntity>();
		for (FormalCircuitPES pes : pess) {
			PESFormalCircuitEntity pesEntity = new PESFormalCircuitEntity(
					pes.getIdentifier(), pes.getConfTxSiteName(),
					pes.getConfTxCaseNum(), pes.getConfTxSlotNum(),
					pes.getConfTxPortNum(), pes.getConfTxInterface(),
					pes.getConfRxSiteName(), pes.getConfRxCaseNum(),
					pes.getConfRxSlotNum(), pes.getConfRxPortNum(),
					pes.getConfRxInterface(), pes.getConfCircuitName(),
					pes.getConfSpeed(),
					pes.getConfCommunicateWay() == null ? null : pes
							.getConfCommunicateWay().getValue(),
					pes.getConfNo(), pes.getConfUsage());
			sub.add(pesEntity);
		}
		// 获得主报表数据源
		List<FormalCircuitBaseInfoEntity> main = new ArrayList<FormalCircuitBaseInfoEntity>();
		// 获得配置实体
		FormalCircuitConfig formalCircuitConfig = formalCircuit
				.getFormalCircuitConfig();
		FormalCircuitBaseInfoEntity baseInfo = new FormalCircuitBaseInfoEntity(
				formalCircuitConfig.getConfigTime() == null ? null
						: formalCircuitConfig.getConfigTime().getTime(),
				formalCircuitConfig.getPurpose(),
				formalCircuitConfig.getAtncLeader(),
				formalCircuitConfig.getOperateUser() == null ? null
						: (formalCircuitConfig.getOperateUser() + "/010-58729911/12/14/15"),
				formalCircuitConfig.getAuditUser(), formalCircuitConfig
						.getRemark(), null, null, null, sub);
		main.add(baseInfo);
		return main;
	}

	@Override
	public List<FormalCircuitBaseInfoEntity> getKUConfigDatasource(String id) {
		FormalCircuit formalCircuit = formalCircuitManager.findById(id);
		List<FormalCircuitKU> kus = formalCircuitKUManager
				.findByFC(formalCircuit);
		// 获得子报表数据源
		List<KUFormalCircuitEntity> sub = new ArrayList<KUFormalCircuitEntity>();
		for (FormalCircuitKU ku : kus) {
			KUFormalCircuitEntity kuEntity = new KUFormalCircuitEntity(
					ku.getIdentifier(), ku.getConfTxSiteName(),
					ku.getConfTxNode(), ku.getConfTxCard() == null ? null : ku
							.getConfTxCard().getValue(), ku.getConfTxSlot(),
					ku.getConfTxPlot(), ku.getConfTxInterface(),
					ku.getConfRxSiteName(), ku.getConfRxNode(),
					ku.getConfRxCard() == null ? null : ku.getConfRxCard()
							.getValue(), ku.getConfRxSlot(),
					ku.getConfRxPlot(), ku.getConfRxInterface(),
					ku.getConfCircuitName(), ku.getConfSpeed(),
					ku.getConfCommunicateWay() == null ? null : ku
							.getConfCommunicateWay().getValue(),
					ku.getConfUsage(), ku.getConfNo());
			sub.add(kuEntity);
		}
		// 获得主报表数据源
		List<FormalCircuitBaseInfoEntity> main = new ArrayList<FormalCircuitBaseInfoEntity>();
		// 获得配置实体
		FormalCircuitConfig formalCircuitConfig = formalCircuit
				.getFormalCircuitConfig();
		FormalCircuitBaseInfoEntity baseInfo = new FormalCircuitBaseInfoEntity(
				formalCircuitConfig.getConfigTime() == null ? null
						: formalCircuitConfig.getConfigTime().getTime(),
				formalCircuitConfig.getPurpose(),
				formalCircuitConfig.getAtncLeader(),
				formalCircuitConfig.getOperateUser() == null ? null
						: (formalCircuitConfig.getOperateUser() + "/010-58729911/12/14/15"),
				formalCircuitConfig.getAuditUser(), formalCircuitConfig
						.getRemark(), null, sub, null, null);
		main.add(baseInfo);

		return main;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.mng.reports.JasperReportService#getDataComNetworkDatasource(java.lang.String)
	 */
	@Override
	public List<DataComNetworkEntity> getDataComNetworkDatasource(String id) {
		DataComNetwork dataComNetwork = dataComNetworkManager.findById(id);
		DataComNetworkConfig dataComNetworkConfig = dataComNetwork
				.getDataComNetworkConfig();
		// 获得主报表数据源
		List<DataComNetworkEntity> main = new ArrayList<DataComNetworkEntity>();
		// 获得配置实体
		DataComNetworkEntity baseInfo = new DataComNetworkEntity(dataComNetwork
				.getApplyBaseInfo().getApplyCom(), dataComNetwork
				.getApplyBaseInfo().getSerialNumber(), dataComNetwork
				.getApplyBaseInfo().getApplyLinkman(), dataComNetwork
				.getApplyBaseInfo().getApplyPhone(), dataComNetwork
				.getApplyBaseInfo().getApplyFax(),
				dataComNetwork.getApplySign(),
				DateUtilTools.format(dataComNetwork.getApplyBaseInfo()
						.getApplyDate().getTime()), dataComNetwork.getNode(),
				dataComNetwork.getPlaceName(),
				dataComNetwork.getEquipfactory1(),
				dataComNetwork.getEquipfactory2(),
				dataComNetwork.getEquipfactory3(),
				dataComNetwork.getEquipType1(), dataComNetwork.getEquipType2(),
				dataComNetwork.getEquipType3(), dataComNetwork.getEquipNum1(),
				dataComNetwork.getEquipNum2(), dataComNetwork.getEquipNum3(),
				dataComNetwork.getInitApproveCom(),
				dataComNetwork.getInitApproveSign(),
				dataComNetwork.getInitApproveOpinion(), dataComNetwork
						.getApplyBaseInfo().getInitLinkman(), dataComNetwork
						.getApplyBaseInfo().getInitLinkphone(),
				dataComNetwork.getFinalApproveCom(), null,
				dataComNetwork.getFinalApproveOpinion(), dataComNetwork
						.getApplyBaseInfo().getFinalLinkman(), dataComNetwork
						.getApplyBaseInfo().getFinalLinkphone(),
				dataComNetworkConfig.getPlaceATM(),
				dataComNetworkConfig.getPlaceATMO());

		main.add(baseInfo);

		return main;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.mng.reports.JasperReportService#getDataComNetworkConfigsource(java.lang.String)
	 */
	@Override
	public List<DataComNetworkEntity> getDataComNetworkConfigsource(String id) {
		DataComNetwork dataComNetwork = dataComNetworkManager.findById(id);
		DataComNetworkConfig dataComNetworkConfig = dataComNetwork
				.getDataComNetworkConfig();
		// 获得主报表数据源
		List<DataComNetworkEntity> main = new ArrayList<DataComNetworkEntity>();
		String flag1 = "";
		String flag2 = "";
		if (dataComNetworkConfig.getConnectivity()) {
			flag1 = "正常";
		} else {
			flag1 = "异常";
		}
		if (dataComNetworkConfig.getNodemng()) {
			flag2 = "正常";
		} else {
			flag2 = "异常";
		}
		// 获得配置实体
		DataComNetworkEntity baseInfo = new DataComNetworkEntity(dataComNetwork
				.getApplyBaseInfo().getApplyLinkman(), dataComNetwork
				.getApplyBaseInfo().getSerialNumber(), dataComNetwork
				.getApplyBaseInfo().getApplyPhone(), dataComNetwork
				.getApplyBaseInfo().getApplyFax(), dataComNetwork.getNode(),
				dataComNetwork.getPlaceName(),
				dataComNetworkConfig.getPlaceATM(),
				dataComNetworkConfig.getPlaceATMO(), flag1, flag2,
				dataComNetworkConfig.getOperateUser(),
				dataComNetworkConfig.getOperateTime() == null ? null
						: dataComNetworkConfig.getOperateTime().getTime(),
				dataComNetworkConfig.getRemark(),
				dataComNetworkConfig.getAtncLeader());

		main.add(baseInfo);

		return main;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.mng.reports.JasperReportService#getTransferNetDatasource(java.lang.String)
	 */
	@Override
	public List<AutoTelegraphEntity> getTransferNetDatasource(String id) {
		TransferNet transferNet = transferNetManager.findById(id);
		// 获得主报表数据源
		List<AutoTelegraphEntity> main = new ArrayList<AutoTelegraphEntity>();
		// 获得配置实体
		AutoTelegraphEntity baseInfo = new AutoTelegraphEntity(transferNet
				.getApplyBaseInfo().getApplyCom(), transferNet
				.getApplyBaseInfo().getSerialNumber(), transferNet
				.getApplyBaseInfo().getApplyLinkman(), transferNet
				.getApplyBaseInfo().getApplyPhone(), transferNet
				.getApplyBaseInfo().getApplyFax(), transferNet.getApplySign(),
				DateUtilTools.format(transferNet.getApplyBaseInfo()
						.getApplyDate().getTime()), transferNet.getNode(),
				transferNet.getPlaceName(), transferNet.getEquipfactory1(),
				transferNet.getEquipfactory2(), transferNet.getEquipfactory3(),
				transferNet.getEquipType1(), transferNet.getEquipType2(),
				transferNet.getEquipType3(), transferNet.getInitApproveCom(),
				transferNet.getInitApproveSign(),
				transferNet.getInitApproveOpinion(), transferNet
						.getApplyBaseInfo().getInitLinkman(), transferNet
						.getApplyBaseInfo().getInitLinkphone(),
				transferNet.getFinalApproveCom(), null,
				transferNet.getFinalApproveOpinion(), transferNet
						.getApplyBaseInfo().getFinalLinkman(), transferNet
						.getApplyBaseInfo().getFinalLinkphone());

		main.add(baseInfo);

		return main;
	}

	@Override
	public List<KuMaintenceEntity> getKuMeintenceDatasource(String id) {
		// 获取报表数据实体
		KuReportData kuReportData = kuReportDataManager.findById(id);
		// 获得主报表数据源
		List<KuMaintenceEntity> main = new ArrayList<KuMaintenceEntity>();
		// 获取当前卫星站点实体
		SatelliteSite satelliteSite = kuReportData.getSatelliteSite();
		// 根据站点和名称查找维保设备集合
		List<MaintainEquip> modems = maintainEquipManager.findBySiteAndType(
				NetworkType.kumodemcard, satelliteSite);
		List<KuMaintenceNodeInfoEntity> nodeInfos = new ArrayList<KuMaintenceNodeInfoEntity>();
		if (!CollectionUtils.isEmpty(modems)) {
			List<KuNodeInfo> kuNodeInfos = kuNodeInfoManager
					.findByMaintainEquip(modems);
			if (!CollectionUtils.isEmpty(kuNodeInfos)) {
				for (KuNodeInfo kuNodeInfo : kuNodeInfos) {
					nodeInfos.add(new KuMaintenceNodeInfoEntity(kuNodeInfo
							.getKuNodeNo(), kuNodeInfo.getRxLevel(), kuNodeInfo
							.getEbno()));
				}
			}
		}
		List<MaintainEquip> kuOdus = maintainEquipManager.findBySiteAndType(
				NetworkType.kuanacomodu, satelliteSite);
		List<KuMaintenceODUEntity> odus = new ArrayList<KuMaintenceODUEntity>();
		if (!CollectionUtils.isEmpty(kuOdus)) {
			List<OduPolling> oduPollings = oduPollingInfoManager
					.findByMaintainEquip(kuOdus);
			if (!CollectionUtils.isEmpty(oduPollings)) {
				for (OduPolling oduPolling : oduPollings) {
					odus.add(new KuMaintenceODUEntity(oduPolling
							.getTxChannelMhz(), oduPolling.getRxChannelMhz(),
							oduPolling.getTxGain(), oduPolling.getRxGain()));
				}
			}
		}
		// 获取当前日期
		String currentDate = DateUtilTools.format(DateUtilTools.getNowDate(),
				DateUtilTools.PATTERN_DATE_4);
		// 卫星链路参数
		List<KuMaintenceOperEntity> links = new ArrayList<KuMaintenceOperEntity>();
		// 获取统计纬度：接收电平和EB/NO
		List<KuMonthReportLegendEnum> legends = new ArrayList<KuMonthReportLegendEnum>(
				Arrays.asList(KuMonthReportLegendEnum.RXLEVEL,
						KuMonthReportLegendEnum.EBNO));
		List<KuMonthReport> linkParams = kuMonthReportManager
				.findByDateAndLegend(currentDate, legends, satelliteSite);
		if (!CollectionUtils.isEmpty(linkParams)) {
			for (KuMonthReport linkParam : linkParams) {
				links.add(new KuMaintenceOperEntity(linkParam.getLegend()
						.getValue()
						+ "("
						+ linkParam.getEquip().getName()
						+ ")", linkParam.getRecordDate(), Double
						.valueOf(linkParam.getData())));
			}
		}
		// 设备故障情况
		List<KuMaintenceOperEntity> faults = new ArrayList<KuMaintenceOperEntity>();
		// 获取统计纬度：WAFR08和MODEM故障
		legends = new ArrayList<KuMonthReportLegendEnum>(Arrays.asList(
				KuMonthReportLegendEnum.WAFR08, KuMonthReportLegendEnum.MODEM));
		List<KuMonthReport> faultParams = kuMonthReportManager
				.findByDateAndLegend(currentDate, legends, satelliteSite);
		// 告警情况
		List<KuMaintenceAlarmEntity> alarms = new ArrayList<KuMaintenceAlarmEntity>();
		// 告警总次数
		String alarmTime = "0";
		if (!CollectionUtils.isEmpty(faultParams)) {
			// 总次数
			Double totalAlarm = 0.0;
			// FR08告警次数
			Double fr08Alarm = 0.0;
			// MODEM告警次数
			Double modemAlarm = 0.0;
			// 记录不同类型的告警情况
			Map<String, KuMaintenceAlarmEntity> map = new HashMap<String, KuMaintenceAlarmEntity>();
			for (KuMonthReport faultParam : faultParams) {
				// ------------------故障情况-------------------//
				faults.add(new KuMaintenceOperEntity(faultParam.getLegend()
						.getValue()
						+ "("
						+ faultParam.getEquip().getName()
						+ ")", faultParam.getRecordDate(), Double
						.valueOf(faultParam.getData())));
				// ------------------告警情况-------------------//
				// 计算总次数
				totalAlarm += Double.valueOf(faultParam.getData());
				System.err.println(totalAlarm);
			}
			for (KuMonthReport faultParam : faultParams) {
				// pie图所占百分比
				String percent = "0%";
				// 计算不同告警类型总次数
				switch (faultParam.getLegend()) {
				case WAFR08:
					fr08Alarm += Double.valueOf(faultParam.getData());
					System.err.println(fr08Alarm);
					if (totalAlarm != 0.0) {
						// 保留两位小数
						percent = new BigDecimal(fr08Alarm / totalAlarm * 100)
								.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue()
								+ "%";
					}
					// 如果为第一次，则创建对象，否则更新对象信息
					KuMaintenceAlarmEntity fr08 = map
							.get(KuMonthReportLegendEnum.WAFR08.name());
					if (ObjectUtils.equals(fr08, null)) {
						fr08 = new KuMaintenceAlarmEntity(faultParam
								.getLegend().getValue()
								+ "("
								+ faultParam.getEquip().getName() + ")",
								percent, fr08Alarm);
						map.put(KuMonthReportLegendEnum.WAFR08.name(), fr08);
						alarms.add(fr08);
					} else {
						fr08.setValue(fr08Alarm);
						fr08.setPercent(percent);
					}
					break;
				case MODEM:
					modemAlarm += Double.valueOf(faultParam.getData());
					System.err.println(modemAlarm);
					if (totalAlarm != 0.0) {
						// 保留两位小数
						percent = new BigDecimal(modemAlarm / totalAlarm * 100)
								.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue()
								+ "%";
					}
					// 如果为第一次，则创建对象，否则更新对象信息
					KuMaintenceAlarmEntity modem = map
							.get(KuMonthReportLegendEnum.MODEM.name());
					if (ObjectUtils.equals(modem, null)) {
						modem = new KuMaintenceAlarmEntity(faultParam
								.getLegend().getValue()
								+ "("
								+ faultParam.getEquip().getName() + ")",
								percent, modemAlarm);
						map.put(KuMonthReportLegendEnum.MODEM.name(), modem);
						alarms.add(modem);
					} else {
						modem.setValue(modemAlarm);
						modem.setPercent(percent);
					}
					break;
				default:
					break;
				}
			}
			alarmTime = String.valueOf(totalAlarm.intValue());
		}
		// 电路运行情况
		List<KuMaintenceOperEntity> opers = new ArrayList<KuMaintenceOperEntity>();
		// 获取统计纬度：误码率（按照累积误码率计算）
		legends = new ArrayList<KuMonthReportLegendEnum>(
				Arrays.asList(KuMonthReportLegendEnum.ERRORRATE));
		List<KuMonthReport> bitErrorParams = kuMonthReportManager
				.findByDateAndLegend(currentDate, legends, satelliteSite);
		if (!CollectionUtils.isEmpty(bitErrorParams)) {
			for (KuMonthReport bitErrorParam : bitErrorParams) {
				opers.add(new KuMaintenceOperEntity(bitErrorParam.getLegend()
						.getValue()
						+ "("
						+ bitErrorParam.getEquip().getName()
						+ ")", bitErrorParam.getRecordDate(), Double
						.valueOf(bitErrorParam.getData())));
			}
		}
		KuMaintenceEntity kme = new KuMaintenceEntity(
				kuReportData.getReportDate()
						+ satelliteSite.getSiteName(),
				kuReportData.getBaseInfo(), kuReportData.getFaultInfo(),
				kuReportData.getOperSummary(), kuReportData.getOperAdvice(),
				satelliteSite.getSiteName(), nodeInfos, odus, alarmTime, links,
				faults, opers, alarms);
		main.add(kme);
		return main;
	}
}
