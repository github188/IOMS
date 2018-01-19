/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-17 下午1:10:30
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.systemmng.param;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.ioms.dao.systemmng.param.ISystemConfigDao;
import cn.com.atnc.ioms.entity.systemmng.param.SystemConfig;
import cn.com.atnc.ioms.enums.clientnotice.NoticeType;
import cn.com.atnc.ioms.model.SysFinals;
import cn.com.atnc.ioms.model.systemmng.param.SystemParamsModel;

/**
 * @author:HuangYijie
 * @date:2014-4-17 下午1:10:30
 * @version:1.0
 */
@Service("SystemConfigDBManagerImpl")
public class SystemConfigDBManagerImpl extends AbstractService implements
		ISystemConfigManager {
	private volatile Map<String, String> properties = new ConcurrentHashMap<String, String>();

	@Autowired
	private ISystemConfigDao dao;

	public void init() throws ServiceException {
		if (CollectionUtils.isEmpty(properties)) {
			initSysParams(dao.getAll());
		}
	}

	private void initSysParams(List<SystemConfig> list) throws ServiceException {

		for (SystemConfig systemConfig : list) {
			properties.put(systemConfig.getKey(), systemConfig.getValue());
		}
		if (CollectionUtils.isEmpty(properties)) {
			throw new ServiceException("加载系统配置参数失败!");
		}
	}

	private String getChangeLog(SystemParamsModel model) {
		StringBuilder configLog = new StringBuilder();
		if (StringTools.hasText(model.getTesTxPowerStandard())
				&& !model.getTesTxPowerStandard().equals(
						properties.get(SysFinals.tesTxPowerStandard))) {

			configLog.append("TES 功率标准值从"
					+ properties.get(SysFinals.tesTxPowerStandard) + "改为"
					+ model.getTesTxPowerStandard());
		}
		if (StringTools.hasText(model.getKuRxLevelTopLimit())
				&& !model.getKuRxLevelTopLimit().equals(
				properties.get(SysFinals.kuRxLevelTopLimit))) {
			if (configLog.length() > 0) {
				configLog.append(";");
			}
			configLog.append("KU RxLevel上限从"
					+ properties.get(SysFinals.kuRxLevelTopLimit) + "改为"
					+ model.getKuRxLevelTopLimit());
		}
		if (StringTools.hasText(model.getKuRxLevelLowerLimit())
				&& !model.getKuRxLevelLowerLimit().equals(
				properties.get(SysFinals.kuRxLevelLowerLimit))) {
			if (configLog.length() > 0) {
				configLog.append(";");
			}
			configLog.append("KU RxLevel下限从"
					+ properties.get(SysFinals.kuRxLevelLowerLimit) + "改为"
					+ model.getKuRxLevelLowerLimit());
		}

		if (StringTools.hasText(model.getKuEbNoTopLimit())
				&&!model.getKuEbNoTopLimit().equals(
				properties.get(SysFinals.kuEbNoTopLimit))) {
			if (configLog.length() > 0) {
				configLog.append(";");
			}
			configLog.append("KU Eb/No标准值从"
					+ properties.get(SysFinals.kuEbNoTopLimit) + "改为"
					+ model.getKuEbNoTopLimit());
		}
		if (StringTools.hasText(model.getKuNetworkStatusStandard())
				&&!model.getKuNetworkStatusStandard().equals(
				properties.get(SysFinals.kuNetworkStatusStandard))) {
			if (configLog.length() > 0) {
				configLog.append(";");
			}
			configLog.append("KU 状态标准值从"
					+ properties.get(SysFinals.kuNetworkStatusStandard) + "改为"
					+ model.getKuNetworkStatusStandard());
		}
		if (StringTools.hasText(model.getClientNoticeType())
				&&!model.getClientNoticeType().equals(
				properties.get(SysFinals.clientNoticeType))) {
			if (configLog.length() > 0) {
				configLog.append(";");
			}
			configLog.append("客户通告类型从"
					+ NoticeType.valueOf(
							properties.get(SysFinals.clientNoticeType))
							.getValue()
					+ "改为"
					+ NoticeType.valueOf(model.getClientNoticeType())
							.getValue());
		}
		if (StringTools.hasText(model.getTempCircuitNotice())
				&&!model.getTempCircuitNotice().equals(
				properties.get(SysFinals.tempCircuitNotice))) {
			if (configLog.length() > 0) {
				configLog.append(";");
			}
			configLog.append("临时电路逾期提醒(天)从"
					+ properties.get(SysFinals.tempCircuitNotice) + "改为"
					+ model.getTempCircuitNotice());
		}
		if (StringTools.hasText(model.getTechConsultClose())
				&&!model.getTechConsultClose().equals(
				properties.get(SysFinals.techConsultClose))) {
			if (configLog.length() > 0) {
				configLog.append(";");
			}
			configLog.append("技术咨询关闭时间(小时)从"
					+ properties.get(SysFinals.techConsultClose) + "改为"
					+ model.getTechConsultClose());
		}
		//
		if (StringTools.hasText(model.getBusiStatTopLimit())
				&&!model.getBusiStatTopLimit().equals(
				properties.get(SysFinals.busiStatTopLimit))) {
			if (configLog.length() > 0) {
				configLog.append(";");
			}
			configLog.append("业务通段上限从"
					+ properties.get(SysFinals.busiStatTopLimit) + "改为"
					+ model.getBusiStatTopLimit().toString());
		}
		if (StringTools.hasText(model.getBusiStatLowerLimit())
				&&!model.getBusiStatLowerLimit().equals(
				properties.get(SysFinals.busiStatLowerLimit))) {
			if (configLog.length() > 0) {
				configLog.append(";");
			}
			configLog.append("业务通段下限从"
					+ properties.get(SysFinals.busiStatLowerLimit) + "改为"
					+ model.getBusiStatLowerLimit().toString());
		}
		if (StringTools.hasText(model.getFtpLinkAlarmMin())
				&&!model.getFtpLinkAlarmMin().equals(
				properties.get(SysFinals.ftpLinkAlarmMin))) {
			if (configLog.length() > 0) {
				configLog.append(";");
			}
			configLog.append("站点告警时间(分钟)从"
					+ properties.get(SysFinals.ftpLinkAlarmMin) + "改为"
					+ model.getFtpLinkAlarmMin());
		}

		if (configLog.length() > 0) {
			configLog.append("。");
		}
		return configLog.toString();
	}

	@Transactional
	public String update(SystemParamsModel model) throws IOException,
			ServiceException {
		String configLog = this.getChangeLog(model);
		List<SystemConfig> list = new ArrayList<>();
		if (StringTools.hasText(model.getKuEbNoTopLimit())) {
			list.add(new SystemConfig(SysFinals.kuEbNoTopLimit, model
					.getKuEbNoTopLimit()));
		}
		if (StringTools.hasText(model.getKuNetworkStatusStandard())) {
			list.add(new SystemConfig(SysFinals.kuNetworkStatusStandard, model
					.getKuNetworkStatusStandard()));
		}
		if (StringTools.hasText(model.getKuRxLevelLowerLimit())) {
			list.add(new SystemConfig(SysFinals.kuRxLevelLowerLimit, model
					.getKuRxLevelLowerLimit()));
		}
		if (StringTools.hasText(model.getKuRxLevelTopLimit())) {
			list.add(new SystemConfig(SysFinals.kuRxLevelTopLimit, model
					.getKuRxLevelTopLimit()));
		}
		if (StringTools.hasText(model.getTesTxPowerStandard())) {
			list.add(new SystemConfig(SysFinals.tesTxPowerStandard, model
					.getTesTxPowerStandard()));
		}
		if (StringTools.hasText(model.getTechConsultClose())) {
			list.add(new SystemConfig(SysFinals.techConsultClose, model
					.getTechConsultClose()));
		}
		if (StringTools.hasText(model.getClientNoticeType())) {
			list.add(new SystemConfig(SysFinals.clientNoticeType, model
					.getClientNoticeType()));
		}
		if (StringTools.hasText(model.getTempCircuitNotice())) {
			list.add(new SystemConfig(SysFinals.tempCircuitNotice, model
					.getTempCircuitNotice()));
		}
		if (StringTools.hasText(model.getBusiStatTopLimit())) {
			list.add(new SystemConfig(SysFinals.busiStatTopLimit, model
					.getBusiStatTopLimit()));
		}
		if (StringTools.hasText(model.getBusiStatLowerLimit())) {
			list.add(new SystemConfig(SysFinals.busiStatLowerLimit, model
					.getBusiStatLowerLimit()));
		}
		if (StringTools.hasText(model.getFtpLinkAlarmMin())) {
			list.add(new SystemConfig(SysFinals.ftpLinkAlarmMin, model
					.getFtpLinkAlarmMin()));
		}
		initSysParams(list);
		dao.saveOrUpdateList(list);

		return configLog;

	}

	public void reInit() throws ServiceException {
		properties = null;
		properties = new ConcurrentHashMap<String, String>();
		init();
	}

	public String getParam(String key) throws ServiceException {
		if (CollectionUtils.isEmpty(properties)) {
			reInit();
		}
		return properties.get(key);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.systemmng.param.ISystemConfigManager#getModel()
	 */
	@Override
	public SystemParamsModel getModel() throws ServiceException {
		// TODO Auto-generated method stub
		SystemParamsModel model = new SystemParamsModel();
		if (CollectionUtils.isEmpty(properties)) {
			init();
		}
		model.setClientNoticeType(properties.get(SysFinals.clientNoticeType));
		model.setKuEbNoTopLimit(properties.get(SysFinals.kuEbNoTopLimit));
		model.setKuNetworkStatusStandard(properties
				.get(SysFinals.kuNetworkStatusStandard));
		model.setKuRxLevelLowerLimit(properties
				.get(SysFinals.kuRxLevelLowerLimit));
		model.setKuRxLevelTopLimit(properties.get(SysFinals.kuRxLevelTopLimit));
		model.setTechConsultClose(properties.get(SysFinals.techConsultClose));
		model.setTempCircuitNotice(properties.get(SysFinals.tempCircuitNotice));
		model.setTesTxPowerStandard(properties
				.get(SysFinals.tesTxPowerStandard));
		model.setBusiStatLowerLimit(properties.get(SysFinals.busiStatLowerLimit));
		model.setBusiStatTopLimit(properties.get(SysFinals.busiStatTopLimit));
		model.setFtpLinkAlarmMin(properties.get(SysFinals.ftpLinkAlarmMin));
		return model;
	}
}
