package cn.com.atnc.ioms.mng.maintain.alarminfo.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.basedata.satellite.ISatelliteSiteDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultAlarmDao;
import cn.com.atnc.ioms.dao.maintain.alarminfo.IFtpLinkDao;
import cn.com.atnc.ioms.entity.basedata.resource.Proxy;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.faultmng.FaultAlarm;
import cn.com.atnc.ioms.entity.maintain.alarminfo.FtpLink;
import cn.com.atnc.ioms.enums.basedata.AlarmStatusEnum;
import cn.com.atnc.ioms.enums.faultmng.FaultAlarmStatus;
import cn.com.atnc.ioms.mng.basedata.resource.IProxyManager;
import cn.com.atnc.ioms.mng.maintain.alarminfo.IFTPAlarmTimerManager;
import cn.com.atnc.ioms.mng.systemmng.param.ISystemConfigManager;
import cn.com.atnc.ioms.model.faultmng.FaultAlarmQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * FTP站点告警定时器Service实现类
 *
 * @author 段衍林
 * @2017年2月3日 下午3:26:52
 */
@Service("ftpAlarmProcess")
public class FTPAlarmTimerManagerImpl extends AbstractService implements
		IFTPAlarmTimerManager {

	@Autowired
	private IFtpLinkDao ftpLinkDao;
	@Autowired
	private IProxyManager proxyManager;
	@Autowired
	private IFaultAlarmDao faultAlarmDao;
	@Autowired
	private ISatelliteSiteDao satelliteSiteDao;
	@Autowired
	@Qualifier(value = "SystemConfigFileManagerImpl")
	private ISystemConfigManager systemConfigManager;

	@Override
	public void handle() throws ServiceException {
		// 查询节点信息列表
		List<Proxy> proxys = proxyManager.getAll();
		// 遍历节点
		for (Proxy proxy : proxys) {
			// 查询卫星站点
			SatelliteSite satelliteSite = satelliteSiteDao.findById(proxy
					.getSatelliteId());
			// 站点名称
			String siteName = "";
			// 非空验证
			if (!ObjectUtils.equals(satelliteSite, null)) {
				siteName = satelliteSite.getSiteName();
			}
			// 当前节点告警状态验证
			boolean flag = this.check(proxy);

			// 根据节点查询心跳检测记录
			FtpLink ftpLink = ftpLinkDao.findByProxyId(proxy.getId());
			// 判断站点对应的ftp文件是否存在
			if (ftpLink == null) {
				// 如果没有告警记录
				if (flag == false) {
					// 告警信息
					String alarmInfo = "站点：" + siteName + "--未检测到相应信息，请及时检查处理。";
					// 保存ftp告警信息实体
					this.saveFaultAlarm(alarmInfo, proxy);
				}
			} else {
				// 获取系统配置的限制时间（分钟）
				String ftpLinkAlarmMin = systemConfigManager.getModel()
						.getFtpLinkAlarmMin();
				Long min = Long
						.valueOf(StringUtils.isEmpty(ftpLinkAlarmMin) ? "10"
								: ftpLinkAlarmMin);
				// 得到ftp更新或者添加时间
				Date ftpDate = ftpLink.getRecordTime();
				// 计算出ftp更新或者添加时间与系统时间相差（分钟）
				Calendar nowCalender = Calendar.getInstance();
				Calendar ftpCalender = Calendar.getInstance();
				ftpCalender.setTime(ftpDate);
				Long minnum = (nowCalender.getTimeInMillis() - ftpCalender
						.getTimeInMillis()) / (60 * 1000);
				// 根据相差时间判断站点是否正常
				if (minnum > min || minnum < 0 || min < 0) {

					// 如果没有告警记录
					if (flag == false) {
						// 告警信息
						String alarmInfo = "站点："
								+ siteName
								+ "--长时间未检测到文件，请及时检查处理，上次文件发送时间："
								+ DateUtilTools.format(ftpLink.getRecordTime(),
										DateUtilTools.PATTERN_DATE_3);
						// 保存ftp告警信息实体
						this.saveFaultAlarm(alarmInfo, proxy);
					}
					/**
					 * ftp心跳检测状态更新
					 */
					// 更改状态为异常
					ftpLink.setStatus(AlarmStatusEnum.unnormal);
					// 更新数据
					ftpLinkDao.update(ftpLink);
				} else {
					/**
					 * ftp心跳检测状态更新
					 */
					// 更改状态为正常
					ftpLink.setStatus(AlarmStatusEnum.normal);
					// 更新数据
					ftpLinkDao.update(ftpLink);
				}
			}
		}
	}

	/**
	 * 检测站点当前是否告警
	 * 
	 * @author 段衍林
	 * @2017年2月3日 下午4:01:54
	 * @param proxy
	 *            节点
	 * @return boolean 返回值
	 */
	public boolean check(Proxy proxy) {
		// 返回值初始化--未告警
		boolean flag = false;
		// 封装查询条件
		FaultAlarmQueryModel queryModel = new FaultAlarmQueryModel();
		// 状态列表
		List<FaultAlarmStatus> statuses = new ArrayList<FaultAlarmStatus>();
		statuses.add(FaultAlarmStatus.ALARM);
		statuses.add(FaultAlarmStatus.FAULT);
		queryModel.setStatuses(statuses);
		// 节点id
		queryModel.setProxy(proxy);
		// 列表查询
		List<FaultAlarm> alarms = faultAlarmDao.queryList(queryModel);
		// 非空验证
		if (CollectionUtils.isNotEmpty(alarms)) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 保存告警信息
	 * 
	 * @author 段衍林
	 * @2017年2月4日 下午4:28:03
	 * @param alarmInfo
	 *            告警信息
	 * @param proxy
	 *            节点信息 void
	 */
	public void saveFaultAlarm(String alarmInfo, Proxy proxy) {
		// 超时告警
		FaultAlarm faultAlarm = new FaultAlarm();
		// 告警信息
		faultAlarm.setAlarmInfo(alarmInfo);
		// 创建时间
		faultAlarm.setCreateTime(DateUtilTools.getNowDateTime());
		// 告警时间
		faultAlarm.setAlarmTime(DateUtilTools.getNowDateTime());
		// 状态--告警
		faultAlarm.setStatus(FaultAlarmStatus.ALARM);
		// 绑定节点
		faultAlarm.setProxy(proxy);
		// 实体保存
		faultAlarmDao.save(faultAlarm);
	}
}
