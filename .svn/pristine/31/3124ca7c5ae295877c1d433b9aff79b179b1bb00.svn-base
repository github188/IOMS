/**
 * @ProjectName IOMS
 * @FileName StatusAlarmMonitorManagerImpl.java
 * @PackageName:cn.com.atnc.ioms.mng.basedata.alarm.impl
 * @author KuYonggang
 * @date 2015年4月22日下午5:05:19
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.maintain.alarminfo.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.clientnotice.IClientNoticeDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultAlarmDao;
import cn.com.atnc.ioms.dao.maintain.alarminfo.ILinkAlarmMonitorDao;
import cn.com.atnc.ioms.dao.maintain.alarminfo.IStatusAlarmDao;
import cn.com.atnc.ioms.dao.maintain.alarminfo.IStatusAlarmMonitorDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.clientnotice.SendLog;
import cn.com.atnc.ioms.entity.faultmng.FaultAlarm;
import cn.com.atnc.ioms.entity.maintain.alarminfo.LinkAlarmMonitor;
import cn.com.atnc.ioms.entity.maintain.alarminfo.StatusAlarm;
import cn.com.atnc.ioms.entity.maintain.alarminfo.StatusAlarmMonitor;
import cn.com.atnc.ioms.entity.maintain.equipmobile.KuMobile;
import cn.com.atnc.ioms.enums.basedata.AlarmStatusEnum;
import cn.com.atnc.ioms.enums.clientnotice.NoticeFlag;
import cn.com.atnc.ioms.enums.clientnotice.NoticeState;
import cn.com.atnc.ioms.enums.clientnotice.NoticeType;
import cn.com.atnc.ioms.enums.faultmng.FaultAlarmStatus;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyRoleEnum;
import cn.com.atnc.ioms.mng.maintain.alarminfo.IStatusAlarmManager;
import cn.com.atnc.ioms.mng.maintain.alarminfo.IStatusAlarmMonitorManager;
import cn.com.atnc.ioms.mng.maintain.equipmobile.IKuMobileManager;
import cn.com.atnc.ioms.mng.turndutymng.ISignLeaveService;
import cn.com.atnc.ioms.model.faultmng.FaultAlarmQueryModel;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;
import cn.com.atnc.ioms.model.maintain.equipmobile.KuMobileQueryModel;
import cn.com.atnc.ioms.model.turndutymng.SignLeaveQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 状态告警监控服务类接口实现
 *
 * @author KuYonggang
 * @date 2015年4月22日 下午5:05:19
 * @since 1.0.0
 */
@Service
@Transactional
public class StatusAlarmMonitorManagerImpl extends AbstractService implements
		IStatusAlarmMonitorManager {

	@Autowired
	private IStatusAlarmManager statusAlarmManager;
	@Autowired
	private IStatusAlarmDao statusAlarmDao;
	@Autowired
	private IStatusAlarmMonitorDao statusAlarmMonitorDao;
	@Autowired
	private ILinkAlarmMonitorDao linkAlarmMonitorDao;
	@Autowired
	private IFaultAlarmDao faultAlarmDao;
	@Autowired
	private IClientNoticeDao clientNoticeDao;
	@Autowired
	private IKuMobileManager mobileManager;
	@Autowired
	private ISignLeaveService signLeaveService;

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.maintain.alarminfo.IStatusAlarmMonitorManager#updateStatusAlarmState()
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void updateStatusAlarmState() {
		List<StatusAlarm> statusAlarms = statusAlarmManager.getAll();
		List<StatusAlarmMonitor> statusAlarmMonitors = this.getAll();
		boolean flag = false;
		for (StatusAlarmMonitor statusAlarmMonitor : statusAlarmMonitors) {
			for (StatusAlarm statusAlarm : statusAlarms) {
				if (StringUtils.equals(statusAlarmMonitor.getEquipId().getId(),
						statusAlarm.getEquipId().getId())) {

					/**
					 * 判断当前设备是否已经为告警状态--开始--duanyanlin添加
					 */
					// 原告警状态--初始为false
					boolean alarmFlag = false;
					// 判断该设备状态告警是否为首次增加
					if (ObjectUtils.equals(statusAlarmMonitor.getAlarmStatus(),
							AlarmStatusEnum.unnormal)) {
						alarmFlag = true;
					}
					// 查询该设备的链路告警
					LinkAlarmMonitor linkAlarmMonitor = linkAlarmMonitorDao
							.findByParam("equipId",
									statusAlarmMonitor.getEquipId());
					// 判断该设备链路告警是否为首次增加
					if (!ObjectUtils.equals(linkAlarmMonitor, null)
							&& ObjectUtils.equals(
									linkAlarmMonitor.getAlarmStatus(),
									AlarmStatusEnum.unnormal)) {
						alarmFlag = true;
					}
					/**
					 * 根据设备判断当前告警处置是否为（SUCCESS--解除告警）
					 */
					FaultAlarmQueryModel qm = new FaultAlarmQueryModel();
					// 设备
					qm.setEquip(statusAlarmMonitor.getEquipId());
					// 状态列表
					List<FaultAlarmStatus> statuses = new ArrayList<FaultAlarmStatus>();
					// 封装状态
					statuses.add(FaultAlarmStatus.ALARM);
					statuses.add(FaultAlarmStatus.FAULT);
					// 封装状态查询条件
					qm.setStatuses(statuses);
					// 列表查询
					List<FaultAlarm> oldAlarms = faultAlarmDao.queryList(qm);
					// 1、不存在旧的告警；2、存在告警且第一条告警状态为success
					if (CollectionUtils.isEmpty(oldAlarms)) {
						alarmFlag = false;
					} else {
						alarmFlag = true;
						// 更新告警任务实体中的告警信息更新字段和更新时间
						FaultAlarm faultAlarmOld = oldAlarms.get(0);
						// 告警信息
						String updateInfo = "设备："
								+ statusAlarmMonitor.getEquipId().getName()
								+ "发生告警！告警信息：" + statusAlarm.getInfo();
						// 告警更新信息
						faultAlarmOld.setUpdateInfo(updateInfo);
						// 告警更新时间
						faultAlarmOld.setUpdateAlarmDate(DateUtilTools
								.getNowDateTime());
						// 实体更新
						faultAlarmDao.update(faultAlarmOld);
					}

					// 判断当前设备是否已经为告警状态--结束--duanyanlin添加
					statusAlarmMonitor.setAlarmStatus(AlarmStatusEnum.unnormal);
					statusAlarmMonitor.setRecordTime(statusAlarm
							.getRecordTime());
					statusAlarmMonitorDao.update(statusAlarmMonitor);
					flag = true;
					/**
					 * 生成事件单与告警绑定关系
					 */
					// 现在不包含告警信息
					if (alarmFlag == false) {
						/**
						 * 生成新的事件单告警实体
						 */
						FaultAlarm faultAlarm = new FaultAlarm();
						// 告警信息
						String alarmInfo = "设备："
								+ statusAlarmMonitor.getEquipId().getName()
								+ "发生告警！告警信息：" + statusAlarm.getInfo();
						// 告警信息
						faultAlarm.setAlarmInfo(alarmInfo);
						// 绑定设备
						faultAlarm.setEquip(statusAlarmMonitor.getEquipId());
						// 创建时间
						faultAlarm
								.setCreateTime(DateUtilTools.getNowDateTime());
						// 告警事件单处理状态--生成告警
						faultAlarm.setStatus(FaultAlarmStatus.ALARM);
						// 告警时间
						faultAlarm.setAlarmTime(statusAlarm.getRecordTime());
						// 保存
						faultAlarmDao.save(faultAlarm);
						/**
						 * 添加需发送的短信log
						 */
						// 封装查询条件
						KuMobileQueryModel queryModel = new KuMobileQueryModel();
						// 设备id--非空验证
						if (!ObjectUtils.equals(statusAlarmMonitor.getEquipId()
								.getEquip(), null)) {
							queryModel.setEquipId(statusAlarmMonitor
									.getEquipId().getEquip().getId());
						}
						// 短信发送标记
						queryModel.setFlag(NoticeFlag.yes);
						// 手机号全部查询
						List<KuMobile> mobiles = mobileManager
								.queryList(queryModel);
						// 非空验证
						if (CollectionUtils.isNotEmpty(mobiles)) {
							// 遍历手机号
							for (KuMobile kuMobile : mobiles) {
								SendLog sendLog = new SendLog(
										kuMobile.getMobile(), "",
										NoticeState.SMSFAIL, NoticeType.SMS,
										alarmInfo, Calendar.getInstance(), 0,
										kuMobile.getName(), kuMobile.getName(),
										"");
								clientNoticeDao.saveOrUpdate(sendLog);
							}
						}
						/**
						 * 发送值班值班工程师
						 */
						// 查询model
						SignLeaveQueryModel signLeaveQueryModel = new SignLeaveQueryModel();
						// 值班地点--通信基地
						signLeaveQueryModel
								.setDutyPlace(DutyPlaceEnum.COMMUNICATION);
						// 值班角色--值班工程师
						signLeaveQueryModel
								.setDutyRole(DutyRoleEnum.DUTYENGINEER);
						// 用户查询
						List<User> users = signLeaveService
								.getEngineerListByPlaceDuty(signLeaveQueryModel);
						// 非空验证
						if (CollectionUtils.isNotEmpty(users)) {
							// 遍历手机号
							for (User user : users) {
								// 手机号非空验证
								if (StringUtils.isNotEmpty(user
										.getMobilephone())) {
									// 保存日志
									SendLog sendLog = new SendLog(
											user.getMobilephone(), "",
											NoticeState.SMSFAIL,
											NoticeType.SMS, alarmInfo,
											Calendar.getInstance(), 0,
											user.getLoginName(),
											user.getName(), "");
									clientNoticeDao.saveOrUpdate(sendLog);
								}
							}
						}

						// 如果这条实时告警记录里边告警事件单信息为空-更新告警的实时信息
						if (ObjectUtils.equals(statusAlarm.getFaultAlarm(),
								null)) {
							// 添加告警数据库数据
							statusAlarm.setFaultAlarm(faultAlarm);
							// 更新数据库
							statusAlarmDao.update(statusAlarm);
						}
					}
					break;
				}
			}
			if (!flag) {
				// 更新告警信息
				if (ObjectUtils.equals(AlarmStatusEnum.unnormal,
						statusAlarmMonitor.getAlarmStatus())) {
					statusAlarmMonitor.setAlarmStatus(AlarmStatusEnum.normal);
				}
				// 记录时间
				statusAlarmMonitor
						.setRecordTime(DateUtilTools.getNowDateTime());
				// 更新
				statusAlarmMonitorDao.update(statusAlarmMonitor);
			}
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<StatusAlarmMonitor> getAll() {
		return statusAlarmMonitorDao.getAll();
	}

	@Override
	public Pagination queryPage(AlarmInfoQueryModel queryModel) {
		String eqname = queryModel.getEqname();
		if (StringUtils.contains(eqname, "%")) {
			eqname = eqname.replace("%", "\\%");
		}
		if (StringUtils.contains(eqname, "_")) {
			eqname = eqname.replace("_", "\\_");
		}
		queryModel.setEqname(eqname);
		String stname = queryModel.getStname();
		if (StringUtils.contains(stname, "%")) {
			stname = stname.replace("%", "\\%");
		}
		if (StringUtils.contains(stname, "_")) {
			stname = stname.replace("_", "\\_");
		}
		queryModel.setStname(stname);
		return statusAlarmMonitorDao.queryPage(queryModel);
	}
}
