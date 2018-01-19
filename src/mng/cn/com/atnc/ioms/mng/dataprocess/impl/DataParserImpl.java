/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-17 上午9:04:25
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.dataprocess.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.dao.basedata.resource.IProxyDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultAlarmDao;
import cn.com.atnc.ioms.dao.maintain.alarminfo.IFtpLinkDao;
import cn.com.atnc.ioms.dao.maintain.alarminfo.ILinkAlarmDao;
import cn.com.atnc.ioms.dao.maintain.alarminfo.ILinkAlarmHistoryDao;
import cn.com.atnc.ioms.dao.maintain.alarminfo.IStatusAlarmDao;
import cn.com.atnc.ioms.dao.maintain.alarminfo.IStatusAlarmHistoryDao;
import cn.com.atnc.ioms.dao.maintain.alarminfo.IStatusAlarmMonitorDao;
import cn.com.atnc.ioms.dao.maintain.pollinginfo.IKuCarrierFreqDao;
import cn.com.atnc.ioms.dao.maintain.pollinginfo.IKuNodeInfoDao;
import cn.com.atnc.ioms.dao.maintain.pollinginfo.IKuNodeParameterDao;
import cn.com.atnc.ioms.dao.maintain.pollinginfo.IOduPollingDao;
import cn.com.atnc.ioms.dao.maintain.pollinginfo.IWafr08Port0StatDao;
import cn.com.atnc.ioms.entity.basedata.resource.Proxy;
import cn.com.atnc.ioms.entity.faultmng.FaultAlarm;
import cn.com.atnc.ioms.entity.maintain.alarminfo.EquipAlarm;
import cn.com.atnc.ioms.entity.maintain.alarminfo.FtpLink;
import cn.com.atnc.ioms.entity.maintain.alarminfo.LinkAlarm;
import cn.com.atnc.ioms.entity.maintain.alarminfo.LinkAlarmHistory;
import cn.com.atnc.ioms.entity.maintain.alarminfo.StatusAlarm;
import cn.com.atnc.ioms.entity.maintain.alarminfo.StatusAlarmHistory;
import cn.com.atnc.ioms.entity.maintain.alarminfo.StatusAlarmMonitor;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.KuCarrierFreq;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.KuNodeInfo;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.KuNodeParameter;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.OduPolling;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.Wafr08Port0Stat;
import cn.com.atnc.ioms.enums.basedata.AlarmSeverity;
import cn.com.atnc.ioms.enums.basedata.AlarmStatusEnum;
import cn.com.atnc.ioms.enums.basedata.EquipAlarmType;
import cn.com.atnc.ioms.enums.faultmng.FaultAlarmStatus;
import cn.com.atnc.ioms.mng.dataprocess.IDataParser;
import cn.com.atnc.ioms.mng.maintain.alarminfo.IEquipAlarmManager;
import cn.com.atnc.ioms.mng.maintain.equip.IMaintainEquipManager;
import cn.com.atnc.ioms.mng.systemmng.param.ISystemConfigManager;
import cn.com.atnc.ioms.model.SysFinals;
import cn.com.atnc.ioms.model.faultmng.FaultAlarmQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * json数据解析
 * 
 * @author KuYonggang
 * @date 2015年4月1日 下午2:29:00
 * @since 1.0.0
 */
@Service
public class DataParserImpl extends AbstractService implements IDataParser {

	@Autowired
	private IKuNodeInfoDao kuNodeInfoDao;
	@Autowired
	private IOduPollingDao oduPollingDao;
	@Autowired
	private IWafr08Port0StatDao wafr08Port0StatDao;
	@Autowired
	private IKuCarrierFreqDao kuCarrierFreqDao;
	@Autowired
	private IKuNodeParameterDao kuNodeParameterDao;
	@Autowired
	private ILinkAlarmDao linkAlarmDao;
	@Autowired
	private ILinkAlarmHistoryDao LinkAlarmHistoryDao;
	@Autowired
	private IStatusAlarmDao statusAlarmDao;
	@Autowired
	private IStatusAlarmHistoryDao statusAlarmHistoryDao;
	@Autowired
	private IFaultAlarmDao faultAlarmDao;
	@Autowired
	private IProxyDao proxyDao;
	@Autowired
	private IFtpLinkDao ftpLinkDao;
	@Autowired
	private IMaintainEquipManager maintainEquipService;
	@Autowired
	private IEquipAlarmManager equipAlarmManager;
	@Autowired
	private IStatusAlarmMonitorDao statusAlarmMonitorDao;
	@Autowired
	@Qualifier(value = "SystemConfigFileManagerImpl")
	private ISystemConfigManager sysConfig;

	@Override
	public void parseLinkedWarn(String jsonStr, String fileName)
			throws ServiceException {
		LinkAlarm linkAlarm = null;
		try {
			linkAlarm = (LinkAlarm) JacksonTools.jsonToObject(jsonStr,
					LinkAlarm.class);
		} catch (IOException e) {
			throw new ServiceException("Json转义失败," + e.getMessage());
		}
		if (ObjectUtils.equals(linkAlarm, null)) {
			return;
		}
		// 判断运维设备表中是否有对应解析出的设备ID信息，如果没有就不做处理
		MaintainEquip equip = linkAlarm.getEquipId();
		equip = maintainEquipService.findById(equip.getId());
		if (ObjectUtils.equals(equip, null)) {
			return;
		}
		// 节点下各设备的告警
		EquipAlarm equipAlarm = equipAlarmManager.findEquipAlarmByEquipId(equip
				.getId());
		if (ObjectUtils.equals(equipAlarm, null)) {
			EquipAlarm temp = new EquipAlarm();
			temp.setEquipId(equip);
			temp.setLastFileTime(linkAlarm.getRecordTime());
			equipAlarmManager.saveEquipAlarm(temp);
		} else {
			Date curCal = linkAlarm.getRecordTime();
			Date preCal = equipAlarm.getLastFileTime();
			if (curCal.after(preCal)) {
				equipAlarm.setLastFileTime(curCal);
				equipAlarmManager.updateEquipAlarm(equipAlarm);
			}
		}

		/** duanyanlin 添加 */
		// 封装查询条件
		FaultAlarmQueryModel queryModel = new FaultAlarmQueryModel();
		// 封装设备
		queryModel.setEquip(linkAlarm.getEquipId());
		// 封装状态
		List<FaultAlarmStatus> statuses = new ArrayList<FaultAlarmStatus>();
		// 生成事件单
		statuses.add(FaultAlarmStatus.FAULT);
		// 告警
		statuses.add(FaultAlarmStatus.ALARM);
		queryModel.setStatuses(statuses);
		// KU告警事件单信息查询
		List<FaultAlarm> faultAlarms = faultAlarmDao.queryList(queryModel);
		// 非空验证，添加告警数据
		if (!CollectionUtils.isEmpty(faultAlarms)) {
			// 非空取最新一条
			linkAlarm.setFaultAlarm(faultAlarms.get(0));
		}
		/** duanyanlin 添加结束 */

		// 根据从ftp文件中解析出的EquipId从对应数据库中查询链路告警对象
		LinkAlarm tempLinkAlarm = linkAlarmDao.findByParam("equipId.id",
				linkAlarm.getEquipId().getId());
		if (ObjectUtils.equals(tempLinkAlarm, null)) {
			linkAlarmDao.save(linkAlarm);
		} else {
			AlarmSeverity alarmSeverity = linkAlarm.getSeverity();
			// 如果告警等级为“清除”，则删除该条记录，同时保存历史数据
			if (ObjectUtils.equals(alarmSeverity, AlarmSeverity.CLEAR)) {
				LinkAlarmHistory linkAlarmHistory = new LinkAlarmHistory(
						linkAlarm);
				// 非空验证，添加告警数据
				if (!CollectionUtils.isEmpty(faultAlarms)) {
					// 去告警实体
					FaultAlarm faultAlarm = faultAlarms.get(0);
					// 告警信息
					String updateInfo = "设备："
							+ tempLinkAlarm.getEquipId().getName()
							+ "--告警信息自动修复,修复时间："
							+ DateUtilTools.getNowDateTime();
					// 封装告警更新信息
					faultAlarm.setUpdateInfo(updateInfo);
					// 封装告警更新时间
					faultAlarm.setUpdateAlarmDate(DateUtilTools
							.getNowDateTime());
					// 更新信息
					faultAlarmDao.update(faultAlarm);
				}
				LinkAlarmHistoryDao.save(linkAlarmHistory);
				linkAlarmDao.delete(tempLinkAlarm);
			} else {
				// 更新当前链路告警记录
				BeanUtils.copyProperties(linkAlarm, tempLinkAlarm);
				linkAlarmDao.update(tempLinkAlarm);
			}
		}
	}

	@Override
	public void parseStatusWarn(String jsonStr, String fileName)
			throws ServiceException {
		StatusAlarm statusAlarm = null;
		try {
			statusAlarm = (StatusAlarm) JacksonTools.jsonToObject(jsonStr,
					StatusAlarm.class);
		} catch (IOException e) {
			throw new ServiceException("Json转义失败," + e.getMessage());
		}
		if (ObjectUtils.equals(statusAlarm, null)) {
			return;
		}
		// 判断运维设备表中是否有对应解析出的设备ID信息，如果没有就不做处理
		MaintainEquip equip = statusAlarm.getEquipId();
		equip = maintainEquipService.findById(equip.getId());
		if (ObjectUtils.equals(equip, null)) {
			return;
		}
		// 节点下各设备的告警
		EquipAlarm equipAlarm = equipAlarmManager.findEquipAlarmByEquipId(equip
				.getId());
		if (ObjectUtils.equals(equipAlarm, null)) {
			EquipAlarm temp = new EquipAlarm();
			temp.setEquipId(equip);
			temp.setLastFileTime(statusAlarm.getRecordTime());
			equipAlarmManager.saveEquipAlarm(temp);
		} else {
			Date curCal = statusAlarm.getRecordTime();
			Date preCal = equipAlarm.getLastFileTime();
			if (curCal.after(preCal)) {
				equipAlarm.setLastFileTime(curCal);
				equipAlarmManager.updateEquipAlarm(equipAlarm);
			}
		}

		/** duanyanlin 添加 */
		// 封装查询条件
		FaultAlarmQueryModel queryModel = new FaultAlarmQueryModel();
		// 封装设备
		queryModel.setEquip(statusAlarm.getEquipId());
		// 封装状态
		List<FaultAlarmStatus> statuses = new ArrayList<FaultAlarmStatus>();
		// 生成事件单
		statuses.add(FaultAlarmStatus.FAULT);
		// 告警
		statuses.add(FaultAlarmStatus.ALARM);
		queryModel.setStatuses(statuses);
		// KU告警事件单信息查询
		List<FaultAlarm> faultAlarms = faultAlarmDao.queryList(queryModel);
		// 非空验证，添加告警数据
		if (!CollectionUtils.isEmpty(faultAlarms)) {
			// 非空取最新一条
			statusAlarm.setFaultAlarm(faultAlarms.get(0));
		}
		/** duanyanlin 添加结束 */

		// 根据从ftp文件中解析出的EquipId从对应数据库中查询状态告警对象
		StatusAlarm tempStatusAlarm = statusAlarmDao.findByParam("equipId.id",
				statusAlarm.getEquipId().getId());
		if (ObjectUtils.equals(tempStatusAlarm, null)) {
			statusAlarmDao.save(statusAlarm);
		} else {
			AlarmSeverity alarmSeverity = statusAlarm.getSeverity();
			// 如果告警等级为“清除”，则删除该条记录，同时保存历史数据
			if (ObjectUtils.equals(alarmSeverity, AlarmSeverity.CLEAR)) {
				StatusAlarmHistory statusAlarmHistory = new StatusAlarmHistory(
						statusAlarm);
				// 非空验证，添加告警数据
				if (!CollectionUtils.isEmpty(faultAlarms)) {
					// 去告警实体
					FaultAlarm faultAlarm = faultAlarms.get(0);
					// 告警信息
					String updateInfo = "设备："
							+ tempStatusAlarm.getEquipId().getName()
							+ "--告警信息自动修复,修复时间："
							+ DateUtilTools.getNowDateTime();
					// 封装告警更新信息
					faultAlarm.setUpdateInfo(updateInfo);
					// 封装告警更新时间
					faultAlarm.setUpdateAlarmDate(DateUtilTools
							.getNowDateTime());
					// 更新信息
					faultAlarmDao.update(faultAlarm);
				}
				statusAlarmHistoryDao.save(statusAlarmHistory);
				statusAlarmDao.delete(tempStatusAlarm);
			} else {
				// 更新数据
				BeanUtils.copyProperties(statusAlarm, tempStatusAlarm);
				tempStatusAlarm.setRecordTime(statusAlarm.getRecordTime());
				statusAlarmDao.update(tempStatusAlarm);
			}
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.dataprocess.ISatelliteDataParser#parseKuStatus(java.lang.String)
	 */
	@Override
	@Transactional
	public void parseKuNodeParameter(String jsonStr, String fileName)
			throws ServiceException {
		KuNodeParameter kuNodeParameter = null;
		try {
			kuNodeParameter = (KuNodeParameter) JacksonTools.jsonToObject(
					jsonStr, KuNodeParameter.class);
		} catch (IOException e) {
			throw new ServiceException("Json转义失败," + e.getMessage());
		}
		if (ObjectUtils.equals(kuNodeParameter, null)) {
			return;
		}
		// 判断运维设备表中是否有对应解析出的设备ID信息，如果没有就不做处理
		MaintainEquip equip = kuNodeParameter.getEquipId();
		equip = maintainEquipService.findById(equip.getId());
		if (ObjectUtils.equals(equip, null)) {
			return;
		}
		// 状态告警修改记录时间
		StatusAlarmMonitor statusAlarmMonitor = statusAlarmMonitorDao
				.findByParam("equipId", equip);
		if (!ObjectUtils.equals(statusAlarmMonitor, null)) {
			statusAlarmMonitor.setRecordTime(kuNodeParameter.getRecordTime());
			statusAlarmMonitorDao.update(statusAlarmMonitor);
		}
		// 节点下各设备的告警
		EquipAlarm equipAlarm = equipAlarmManager
				.findEquipAlarmByEquipId(kuNodeParameter.getEquipId().getId());
		if (ObjectUtils.equals(equipAlarm, null)) {
			EquipAlarm temp = new EquipAlarm();
			temp.setEquipId(equip);
			temp.setLastFileTime(kuNodeParameter.getRecordTime());
			equipAlarmManager.saveEquipAlarm(temp);
		} else {
			Date curCal = kuNodeParameter.getRecordTime();
			Date preCal = equipAlarm.getLastFileTime();
			if (curCal.after(preCal)) {
				equipAlarm.setLastFileTime(curCal);
				equipAlarmManager.updateEquipAlarm(equipAlarm);
			}
		}
		kuNodeParameterDao.save(kuNodeParameter);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.dataprocess.IKuCarrierFreqDataParser#parseKuCarrierFreq(java.lang.String,
	 *      java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void parseKuCarrierFreq(String jsonStr, String fileName)
			throws ServiceException {
		List<KuCarrierFreq> kuCarrierFreqs = null;
		try {
			kuCarrierFreqs = (List<KuCarrierFreq>) JacksonTools.jsonToList(
					jsonStr, KuCarrierFreq.class);
		} catch (IOException e) {
			throw new ServiceException("Json转义失败," + e.getMessage());
		}
		if (CollectionUtils.isEmpty(kuCarrierFreqs)) {
			return;
		}
		for (KuCarrierFreq kuCarrierFreq : kuCarrierFreqs) {
			// 判断运维设备表中是否有对应解析出的设备ID信息，如果没有处理下一个kuCarrierFreq
			MaintainEquip equip = kuCarrierFreq.getEquipId();
			equip = maintainEquipService.findById(equip.getId());
			if (ObjectUtils.equals(equip, null)) {
				continue;
			}
			// 节点下各设备的告警
			EquipAlarm equipAlarm = equipAlarmManager
					.findEquipAlarmByEquipId(kuCarrierFreq.getEquipId().getId

					());
			if (ObjectUtils.equals(equipAlarm, null)) {
				EquipAlarm temp = new EquipAlarm();
				temp.setEquipId(equip);
				temp.setLastFileTime(kuCarrierFreq.getRecordTime());
				equipAlarmManager.saveEquipAlarm(temp);
			} else {
				Date curCal = kuCarrierFreq.getRecordTime();
				Date preCal = equipAlarm.getLastFileTime();
				if (curCal.after(preCal)) {
					equipAlarm.setLastFileTime(curCal);
					equipAlarmManager.updateEquipAlarm(equipAlarm);
				}
			}
			kuCarrierFreqDao.save(kuCarrierFreq);
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.dataprocess.IKuCarrierFreqDataParser#parseKuCarrierFreq(java.lang.String,
	 *      java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void parseKuNodeInfo(String jsonStr, String fileName)
			throws ServiceException {
		List<KuNodeInfo> kuNodeInfos = null;
		try {
			kuNodeInfos = (List<KuNodeInfo>) JacksonTools.jsonToList(jsonStr,
					KuNodeInfo.class);
		} catch (IOException e) {
			throw new ServiceException("Json转义失败," + e.getMessage());
		}
		if (CollectionUtils.isEmpty(kuNodeInfos)) {
			return;
		}
		for (KuNodeInfo kuNodeInfo : kuNodeInfos) {
			// 判断运维设备表中是否有对应解析出的设备ID信息，如果没有处理下一个kunodeinfo
			MaintainEquip equip = kuNodeInfo.getEquipId();
			equip = maintainEquipService.findById(equip.getId());
			if (ObjectUtils.equals(equip, null)) {
				continue;
			}
			// 节点下各设备的告警
			EquipAlarm equipAlarm = equipAlarmManager
					.findEquipAlarmByEquipId(kuNodeInfo.getEquipId().getId());
			if (ObjectUtils.equals(equipAlarm, null)) {
				EquipAlarm temp = new EquipAlarm();
				temp.setEquipId(equip);
				temp.setLastFileTime(kuNodeInfo.getRecordTime());
				equipAlarmManager.saveEquipAlarm(temp);
			} else {
				Date curCal = kuNodeInfo.getRecordTime();
				Date preCal = equipAlarm.getLastFileTime();
				if (curCal.after(preCal)) {
					equipAlarm.setLastFileTime(curCal);
					equipAlarmManager.updateEquipAlarm(equipAlarm);
				}
			}
			// 根据解析出的equipId从状态告警表中查询当前告警记录
			StatusAlarm tempStatusAlarm = statusAlarmDao.getStatusAlarm(
					equip.getId

					(), EquipAlarmType.ThresholdWarning);
			// 分别获取系统设置的rxlevel上下限和ebNo上限
			double kuRxLevelTop = Double.parseDouble(sysConfig
					.getParam(SysFinals.kuRxLevelTopLimit));
			double kuRxLevelLower = Double.parseDouble(sysConfig
					.getParam(SysFinals.kuRxLevelLowerLimit));
			double kuEbNoTop = Double.parseDouble(sysConfig
					.getParam(SysFinals.kuEbNoTopLimit));
			// 从ftp文件中解析的rxlevel和ebNo的值
			double ebNo = Double.parseDouble(kuNodeInfo.getEbno());
			double rxLevel = Double.parseDouble(kuNodeInfo.getRxLevel());
			if (ObjectUtils.equals(tempStatusAlarm, null)) {
				// 如果状态告警记录非空，且rxLevel或ebNo字段超出阀值，则需要构造状态告警记录
				if (rxLevel > kuRxLevelTop || rxLevel < kuRxLevelLower
						|| ebNo < kuEbNoTop) {
					StatusAlarm statusAlarm = new StatusAlarm();
					statusAlarm.setId(kuNodeInfo.getId());
					statusAlarm.setEquipId(kuNodeInfo.getEquipId());
					statusAlarm.setSeverity(AlarmSeverity.CRITICAL);
					statusAlarm.setType(EquipAlarmType.ThresholdWarning);
					statusAlarm.setStartTime(Calendar.getInstance());
					statusAlarm.setRecordTime(kuNodeInfo.getRecordTime());
					StringBuffer sb = new StringBuffer();
					if (ebNo < kuEbNoTop && rxLevel > kuRxLevelTop) {
						sb.append("低于ebNo标准值(标准值：" + sysConfig.getParam

						(SysFinals.kuEbNoTopLimit) + " 实际值："
								+ kuNodeInfo.getEbno() + ")"
								+ "超出rxLevel上限(上限：" + sysConfig.getParam

								(SysFinals.kuRxLevelTopLimit) + " 实际值："
								+ kuNodeInfo.getRxLevel() + ")");
					} else if (ebNo < kuEbNoTop && rxLevel < kuRxLevelLower) {
						sb.append("低于ebNo标准值(标准值：" + sysConfig.getParam

						(SysFinals.kuEbNoTopLimit) + " 实际值："
								+ kuNodeInfo.getEbno() + ")"
								+ "低于rxLevel下限(下限：" + sysConfig.getParam

								(SysFinals.kuRxLevelLowerLimit) + " 实际值："
								+ kuNodeInfo.getRxLevel() + ")");
					} else if (ebNo < kuEbNoTop) {
						sb.append("低于ebNo标准值(标准值：" + sysConfig.getParam

						(SysFinals.kuEbNoTopLimit) + " 实际值："
								+ kuNodeInfo.getEbno() + ")");
					} else if (rxLevel > kuRxLevelTop) {
						sb.append("超出rxLevel上限(上限：" + sysConfig.getParam

						(SysFinals.kuRxLevelTopLimit) + " 实际值："
								+ kuNodeInfo.getRxLevel() + ")");
					} else if (rxLevel < kuRxLevelLower) {
						sb.append("低于rxLevel下限(下限：" + sysConfig.getParam

						(SysFinals.kuRxLevelLowerLimit) + " 实际值："
								+ kuNodeInfo.getRxLevel() + ")");
					}
					statusAlarm.setInfo(sb.toString());
					statusAlarmDao.save(statusAlarm);
				}
			} else {
				if (rxLevel > kuRxLevelTop || rxLevel < kuRxLevelLower
						|| ebNo < kuEbNoTop) {
					tempStatusAlarm.setRecordTime(kuNodeInfo.getRecordTime());
					StringBuffer sb = new StringBuffer();
					if (ebNo < kuEbNoTop && rxLevel > kuRxLevelTop) {
						sb.append("低于ebNo标准值(标准值：" + sysConfig.getParam

						(SysFinals.kuEbNoTopLimit) + " 实际值："
								+ kuNodeInfo.getEbno() + ")"
								+ "超出rxLevel上限(上限：" + sysConfig.getParam

								(SysFinals.kuRxLevelTopLimit) + " 实际值："
								+ kuNodeInfo.getRxLevel() + ")");
					} else if (ebNo < kuEbNoTop && rxLevel < kuRxLevelLower) {
						sb.append("低于ebNo标准值(标准值：" + sysConfig.getParam

						(SysFinals.kuEbNoTopLimit) + " 实际值："
								+ kuNodeInfo.getEbno() + ")"
								+ "低于rxLevel下限(下限：" + sysConfig.getParam

								(SysFinals.kuRxLevelLowerLimit) + " 实际值："
								+ kuNodeInfo.getRxLevel() + ")");
					} else if (ebNo < kuEbNoTop) {
						sb.append("低于ebNo标准值(标准值：" + sysConfig.getParam

						(SysFinals.kuEbNoTopLimit) + " 实际值："
								+ kuNodeInfo.getEbno() + ")");
					} else if (rxLevel > kuRxLevelTop) {
						sb.append("超出rxLevel上限(上限：" + sysConfig.getParam

						(SysFinals.kuRxLevelTopLimit) + " 实际值："
								+ kuNodeInfo.getRxLevel() + ")");
					} else if (rxLevel < kuRxLevelLower) {
						sb.append("低于rxLevel下限(下限：" + sysConfig.getParam

						(SysFinals.kuRxLevelLowerLimit) + " 实际值："
								+ kuNodeInfo.getRxLevel() + ")");
					}
					tempStatusAlarm.setInfo(sb.toString());
					statusAlarmDao.update(tempStatusAlarm);
				} else {
					// 保存历史记录，同时删除当前告警记录
					StatusAlarmMonitor monitor = statusAlarmMonitorDao
							.findByParam("equipId",

							tempStatusAlarm.getEquipId());
					monitor.setAlarmStatus(AlarmStatusEnum.normal);
					monitor.setRecordTime(tempStatusAlarm.getRecordTime());
					tempStatusAlarm.setEndTime(Calendar.getInstance());
					StatusAlarmHistory statusAlarmHistory = new StatusAlarmHistory(
							tempStatusAlarm);
					statusAlarmHistoryDao.save(statusAlarmHistory);
					statusAlarmDao.delete(tempStatusAlarm);
					statusAlarmMonitorDao.update(monitor);
				}
			}
			kuNodeInfoDao.save(kuNodeInfo);
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.dataprocess.IDataParser#parseOduPolling(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void parseOduPolling(String jsonStr, String fileName)
			throws ServiceException {
		OduPolling oduPolling = null;
		try {
			oduPolling = (OduPolling) JacksonTools.jsonToObject(jsonStr,
					OduPolling.class);
		} catch (IOException e) {
			throw new ServiceException("Json转义失败," + e.getMessage());
		}
		if (ObjectUtils.equals(oduPolling, null)) {
			return;
		}
		// 判断运维设备表中是否有对应解析出的设备ID信息，如果没有就不做处理
		MaintainEquip equip = oduPolling.getEquipId();
		equip = maintainEquipService.findById(equip.getId());
		if (ObjectUtils.equals(equip, null)) {
			return;
		}
		// 节点下各设备的告警
		EquipAlarm equipAlarm = equipAlarmManager
				.findEquipAlarmByEquipId(oduPolling.getEquipId().getId());
		if (ObjectUtils.equals(equipAlarm, null)) {
			EquipAlarm temp = new EquipAlarm();
			temp.setEquipId(equip);
			temp.setLastFileTime(oduPolling.getRecordTime());
			equipAlarmManager.saveEquipAlarm(temp);
		} else {
			Date curCal = oduPolling.getRecordTime();
			Date preCal = equipAlarm.getLastFileTime();
			if (curCal.after(preCal)) {
				equipAlarm.setLastFileTime(curCal);
				equipAlarmManager.updateEquipAlarm(equipAlarm);
			}
		}
		oduPollingDao.save(oduPolling);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.dataprocess.IDataParser#parseWafr08Port0Stat(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void parseWafr08Port0Stat(String jsonStr, String fileName)
			throws ServiceException {
		Wafr08Port0Stat wafr08Port0Stat = null;
		try {
			wafr08Port0Stat = (Wafr08Port0Stat) JacksonTools.jsonToObject(
					jsonStr, Wafr08Port0Stat.class);
		} catch (IOException e) {
			throw new ServiceException("Json转义失败," + e.getMessage());
		}
		if (ObjectUtils.equals(wafr08Port0Stat, null)) {
			return;
		}
		// 判断运维设备表中是否有对应解析出的设备ID信息，如果没有就不做处理
		MaintainEquip equip = wafr08Port0Stat.getEquipId();
		equip = maintainEquipService.findById(equip.getId());
		if (ObjectUtils.equals(equip, null)) {
			return;
		}
		// 状态告警修改记录时间
		StatusAlarmMonitor statusAlarmMonitor = statusAlarmMonitorDao
				.findByParam("equipId", equip);
		if (!ObjectUtils.equals(statusAlarmMonitor, null)) {
			statusAlarmMonitor.setRecordTime(wafr08Port0Stat.getRecordTime());
			statusAlarmMonitorDao.update(statusAlarmMonitor);
		}
		// 根据业务通断值与系统设置的对应上下限的对比来判断是否产生告警
		String charactersRatio = wafr08Port0Stat.getCharactersRatio();
		double ratio = Double.parseDouble(charactersRatio); // 从ftp文件中解析出的业务通断值
		double busiTop = Double.parseDouble(sysConfig
				.getParam(SysFinals.busiStatTopLimit));// 业务通断上限
		double busiLower = Double.parseDouble(sysConfig
				.getParam(SysFinals.busiStatLowerLimit));// 业务通断下限
		// 根据解析出的equipId从状态告警表中查询当前告警记录
		StatusAlarm tempStatusAlarm = statusAlarmDao.findByParam("equipId.id",
				wafr08Port0Stat.getEquipId().getId());
		if ("0.00".equals(charactersRatio)) { // 告警
			if (ObjectUtils.equals(tempStatusAlarm, null)) {
				StatusAlarm statusAlarm = new StatusAlarm();
				statusAlarm.setId(wafr08Port0Stat.getId());
				statusAlarm.setEquipId(wafr08Port0Stat.getEquipId());
				statusAlarm.setSeverity(AlarmSeverity.CRITICAL);
				statusAlarm.setType(EquipAlarmType.ThresholdWarning);
				statusAlarm.setStartTime(Calendar.getInstance());
				statusAlarm.setRecordTime(wafr08Port0Stat.getRecordTime());
				statusAlarm.setInfo("无业务数据");
				statusAlarmDao.save(statusAlarm);
			} else {
				// 更新告警数据
				tempStatusAlarm.setRecordTime(wafr08Port0Stat.getRecordTime());
				tempStatusAlarm.setInfo("无业务数据");
				statusAlarmDao.update(tempStatusAlarm);
			}
			wafr08Port0Stat.setCharactersRatio("告警");
		} else if (ratio >= busiLower && ratio <= busiTop) { // 在业务通断上限和下限之间为正常；
			if (!ObjectUtils.equals(tempStatusAlarm, null)) {
				// 状态告警记录不为空，保存历史记录，同时删除当前告警记录
				tempStatusAlarm.setEndTime(Calendar.getInstance());
				StatusAlarmHistory statusAlarmHistory = new StatusAlarmHistory(
						tempStatusAlarm);
				statusAlarmHistoryDao.save(statusAlarmHistory);
				statusAlarmDao.delete(tempStatusAlarm);
			}
			wafr08Port0Stat.setCharactersRatio("正常");
		} else { // 告警
			if (ObjectUtils.equals(tempStatusAlarm, null)) {
				StatusAlarm statusAlarm = new StatusAlarm();
				statusAlarm.setId(wafr08Port0Stat.getId());
				statusAlarm.setEquipId(wafr08Port0Stat.getEquipId());
				statusAlarm.setSeverity(AlarmSeverity.CRITICAL);
				statusAlarm.setType(EquipAlarmType.ThresholdWarning);
				statusAlarm.setStartTime(Calendar.getInstance());
				statusAlarm.setRecordTime(wafr08Port0Stat.getRecordTime());
				statusAlarm.setInfo("超出业务通断上下限(上限：" + sysConfig.getParam

				(SysFinals.busiStatTopLimit) + " 下限："
						+ sysConfig.getParam(SysFinals.busiStatLowerLimit)
						+ " 实际值：" + wafr08Port0Stat.getCharactersRatio() + ")");
				statusAlarmDao.save(statusAlarm);
			} else {
				// 更新告警数据
				tempStatusAlarm.setRecordTime(wafr08Port0Stat.getRecordTime());
				tempStatusAlarm.setInfo("超出业务通断上下限(上限：" + sysConfig.getParam

				(SysFinals.busiStatTopLimit) + " 下限："
						+ sysConfig.getParam(SysFinals.busiStatLowerLimit)
						+ " 实际值：" + wafr08Port0Stat.getCharactersRatio() + ")");
				statusAlarmDao.update(tempStatusAlarm);
			}
			wafr08Port0Stat.setCharactersRatio("告警");
		}

		// 节点下各设备的告警
		EquipAlarm equipAlarm = equipAlarmManager
				.findEquipAlarmByEquipId(wafr08Port0Stat.getEquipId().getId());
		if (ObjectUtils.equals(equipAlarm, null)) {
			EquipAlarm temp = new EquipAlarm();
			temp.setEquipId(equip);
			temp.setLastFileTime(wafr08Port0Stat.getRecordTime());
			equipAlarmManager.saveEquipAlarm(temp);
		} else {
			Date curCal = wafr08Port0Stat.getRecordTime();
			Date preCal = equipAlarm.getLastFileTime();
			if (curCal.after(preCal)) {
				equipAlarm.setLastFileTime(curCal);
				equipAlarmManager.updateEquipAlarm(equipAlarm);
			}
		}
		wafr08Port0StatDao.save(wafr08Port0Stat);
	}

	public static void main(String[] args) {
		String s = "0.00";
		String ss = "1.00";
		String sss = "2.32";
		double ds = Double.parseDouble(s);
		double dss = Double.parseDouble(ss);
		double dsss = Double.parseDouble(sss);
		System.out.println(ds > dsss);
		System.out.println(ds);
		System.out.println(dss);
		System.out.println(dsss);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.dataprocess.IDataParser#parseFtpLink(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void parseFtpLink(String jsonStr, String fileName)
			throws ServiceException {
		FtpLink ftpLink = null;
		try {
			ftpLink = (FtpLink) JacksonTools.jsonToObject(jsonStr,
					FtpLink.class);
		} catch (IOException e) {
			throw new ServiceException("Json转义失败," + e.getMessage());
		}
		// 如果解析出的FtpLink为null,则不做任何处理
		if (ObjectUtils.equals(ftpLink, null)) {
			return;
		}
		Proxy proxy = proxyDao.findById(ftpLink.getProxyId().getId());
		if (ObjectUtils.equals(proxy, null)) {// 如果ftp文件内容中对应的proxyId在数据库中不存在则不做处理
			return;
		}
		// 根据ProxyId查询FtpLink
		FtpLink tempFtpLink = ftpLinkDao.findByProxyId(ftpLink.getProxyId()
				.getId());
		if (ObjectUtils.equals(tempFtpLink, null)) {
			// 初始化为正常
			ftpLink.setStatus(AlarmStatusEnum.normal);
			// 新增FtpLink
			ftpLinkDao.save(ftpLink);
		} else {
			// 初始化为正常
			tempFtpLink.setStatus(AlarmStatusEnum.normal);
			// 更新FtpLink
			tempFtpLink.setRecordTime(ftpLink.getRecordTime());
			ftpLinkDao.update(tempFtpLink);
		}
	}
}
