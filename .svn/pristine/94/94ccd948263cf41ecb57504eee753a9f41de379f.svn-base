/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-17 下午1:10:30
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.systemmng.param;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.file.ProjectFilePath;
import cn.com.atnc.common.util.file.PropertyFileHelper;
import cn.com.atnc.ioms.model.SysFinals;
import cn.com.atnc.ioms.model.systemmng.param.SystemParamsModel;

/**
 * @author:HuangYijie
 * @date:2014-4-17 下午1:10:30
 * @version:1.0
 */
@Service("SystemConfigFileManagerImpl")
public class SystemConfigFileManagerImpl extends AbstractService implements
		ISystemConfigManager {
	private Properties properties;

	@PostConstruct
	public void init() throws ServiceException {
		if (CollectionUtils.isEmpty(properties)) {
			initSysParams();
		}
	}

	private void initSysParams() throws ServiceException {
		properties = PropertyFileHelper
				.getProperty("systemConfigParams.properties");
		if (CollectionUtils.isEmpty(properties)) {
			throw new ServiceException("加载系统配置参数失败!");
		}
	}

	public String update(SystemParamsModel model) throws IOException {
		String configLog = this.getChangeLog(model);
		properties.setProperty(SysFinals.clientNoticeType,
				model.getClientNoticeType());
		properties.setProperty(SysFinals.kuEbNoTopLimit,
				model.getKuEbNoTopLimit());
		properties.setProperty(SysFinals.kuNetworkStatusStandard,
				model.getKuNetworkStatusStandard());
		properties.setProperty(SysFinals.kuRxLevelLowerLimit,
				model.getKuRxLevelLowerLimit());
		properties.setProperty(SysFinals.kuRxLevelTopLimit,
				model.getKuRxLevelTopLimit());
		properties.setProperty(SysFinals.tesTxPowerStandard,
				model.getTesTxPowerStandard());
		properties.setProperty(SysFinals.techConsultClose,
				model.getTechConsultClose());

		properties.setProperty(SysFinals.clientNoticeType,
				model.getClientNoticeType());

		properties.setProperty(SysFinals.tempCircuitNotice,
				model.getTempCircuitNotice());
		properties.setProperty(SysFinals.ftpLinkAlarmMin,
				model.getFtpLinkAlarmMin());

		FileOutputStream out = new FileOutputStream(
				new File(ProjectFilePath.getConfPath()
						+ "systemConfigParams.properties"));
		properties.store(out, null);
		return configLog;
	}

	public void reInit() throws ServiceException {
		properties = null;
		init();
	}

	public String getParam(String key) {
		return properties.getProperty(key);
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
		if (properties == null) {
			throw new ServiceException("未成功加载配置参数！");
		}
		model.setClientNoticeType(properties
				.getProperty(SysFinals.clientNoticeType));
		model.setKuEbNoTopLimit(properties
				.getProperty(SysFinals.kuEbNoTopLimit));
		model.setKuNetworkStatusStandard(properties
				.getProperty(SysFinals.kuNetworkStatusStandard));
		model.setKuRxLevelLowerLimit(properties
				.getProperty(SysFinals.kuRxLevelLowerLimit));
		model.setKuRxLevelTopLimit(properties
				.getProperty(SysFinals.kuRxLevelTopLimit));
		model.setTechConsultClose(properties
				.getProperty(SysFinals.techConsultClose));
		model.setTempCircuitNotice(properties
				.getProperty(SysFinals.tempCircuitNotice));
		model.setTesTxPowerStandard(properties
				.getProperty(SysFinals.tesTxPowerStandard));
		model.setFtpLinkAlarmMin(properties
				.getProperty(SysFinals.ftpLinkAlarmMin));
		return model;
	}

	private String getChangeLog(SystemParamsModel model) {
		StringBuilder configLog = new StringBuilder();

		if (!model.getKuEbNoTopLimit().equals(
				properties.get(SysFinals.kuEbNoTopLimit))) {
			configLog.append("KU Eb/No标准值从"
					+ properties.get(SysFinals.kuEbNoTopLimit) + "改为"
					+ model.getKuEbNoTopLimit());
		}
		if (!model.getKuNetworkStatusStandard().equals(
				properties.get(SysFinals.kuNetworkStatusStandard))) {
			if (configLog.length() > 0) {
				configLog.append(";");
			}
			configLog.append("KU 状态标准值从"
					+ properties.get(SysFinals.kuNetworkStatusStandard) + "改为"
					+ model.getKuNetworkStatusStandard());
		}
		if (!model.getKuRxLevelLowerLimit().equals(
				properties.get(SysFinals.kuRxLevelLowerLimit))) {
			if (configLog.length() > 0) {
				configLog.append(";");
			}
			configLog.append("KU RxLevel下限从"
					+ properties.get(SysFinals.kuRxLevelLowerLimit) + "改为"
					+ model.getKuRxLevelLowerLimit());
		}
		if (!model.getKuRxLevelTopLimit().equals(
				properties.get(SysFinals.kuRxLevelTopLimit))) {
			if (configLog.length() > 0) {
				configLog.append(";");
			}
			configLog.append("KU RxLevel上限从"
					+ properties.get(SysFinals.kuRxLevelTopLimit) + "改为"
					+ model.getKuRxLevelTopLimit());
		}
		if (!model.getTesTxPowerStandard().equals(
				properties.get(SysFinals.tesTxPowerStandard))) {
			if (configLog.length() > 0) {
				configLog.append(";");
			}
			configLog.append("TES Power标准值从"
					+ properties.get(SysFinals.tesTxPowerStandard) + "改为"
					+ model.getTesTxPowerStandard());
		}
		if (!model.getTechConsultClose().equals(
				properties.get(SysFinals.techConsultClose))) {
			if (configLog.length() > 0) {
				configLog.append(";");
			}
			configLog.append("技术支持关闭时间从"
					+ properties.get(SysFinals.techConsultClose) + "改为"
					+ model.getTechConsultClose() + "小时");
		}
		if (!model.getClientNoticeType().equals(
				properties.get(SysFinals.clientNoticeType))) {
			if (configLog.length() > 0) {
				configLog.append(";");
			}
			configLog.append("客户通告时间从"
					+ properties.get(SysFinals.clientNoticeType) + "改为"
					+ model.getClientNoticeType());
		}
		if (!model.getTempCircuitNotice().equals(
				properties.get(SysFinals.tempCircuitNotice))) {
			if (configLog.length() > 0) {
				configLog.append(";");
			}
			configLog.append("临时电路逾期提醒从"
					+ properties.get(SysFinals.tempCircuitNotice) + "改为"
					+ model.getTempCircuitNotice() + "天");
		}
		if (!model.getFtpLinkAlarmMin().equals(
				properties.get(SysFinals.ftpLinkAlarmMin))) {
			if (configLog.length() > 0) {
				configLog.append(";");
			}
			configLog.append("站点告警时间范围从"
					+ properties.get(SysFinals.ftpLinkAlarmMin) + "改为"
					+ model.getFtpLinkAlarmMin() + "分钟");
		}
		if (configLog.length() > 0) {
			configLog.append(".");
		}
		return configLog.toString();
	}

}
