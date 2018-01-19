/**
 * @ProjectName IOMS
 * @FileName LinkAlarmManagerImpl.java
 * @PackageName:cn.com.atnc.ioms.mng.basedata.alarm
 * @author KuYonggang
 * @date 2015年3月27日下午5:17:45
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.maintain.month.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.maintain.month.IKuMonthReportDao;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.faultmng.FaultAlarm;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.entity.maintain.month.KuMonthReport;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.KuNodeInfo;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.Wafr08Port0Stat;
import cn.com.atnc.ioms.enums.basedata.NetworkType;
import cn.com.atnc.ioms.enums.maintain.month.KuMonthReportLegendEnum;
import cn.com.atnc.ioms.mng.faultmng.IFaultAlarmMngService;
import cn.com.atnc.ioms.mng.maintain.equip.IMaintainEquipManager;
import cn.com.atnc.ioms.mng.maintain.month.KuMonthReportManager;
import cn.com.atnc.ioms.mng.maintain.pollinginfo.KuNodeInfoManager;
import cn.com.atnc.ioms.mng.maintain.pollinginfo.Wafr08Port0StatManager;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * KU月度报告业务实现类
 * 
 * @author 王凌斌
 * @2017年1月24日 上午10:48:21
 */
@Service("kuMonthReportManager")
public class KuMonthReportManagerImpl extends AbstractService implements
		KuMonthReportManager {

	@Autowired
	private IKuMonthReportDao kuMonthReportDao;
	@Autowired
	private KuNodeInfoManager kuNodeInfoManager;
	@Autowired
	private IMaintainEquipManager maintainEquipManager;
	@Autowired
	private IFaultAlarmMngService faultAlarmMngService;
	@Autowired
	private Wafr08Port0StatManager wafr08Port0StatManager;

	@Override
	public List<KuMonthReport> findByDateAndLegend(String currentDate,
			List<KuMonthReportLegendEnum> legends, SatelliteSite satelliteSite) {
		return kuMonthReportDao.findByDateAndLegend(currentDate, legends,
				satelliteSite);
	}

	@Override
	public void calLegendValueByDay() {
		logger.info(DateUtilTools.getNowDateTime() + "：开始计算ku维保月度报告数据");
		// 根据站点和节点排序查询信息
		List<MaintainEquip> maintainEquips = maintainEquipManager
				.findAllOrderBy();
		// 按照equipId和satelliteId进行去重
		if (CollectionUtils.isEmpty(maintainEquips)) {
			return;
		}
		// maintainEquips = this.removeRepeatedRecords(maintainEquips);
		System.err.println(maintainEquips);
		// 保存结果集
		List<KuMonthReport> results = new ArrayList<KuMonthReport>();
		// 获取当前日期
		/*Date currentDate = DateUtilTools.parseDate("2017-01-19",
				DateUtilTools.PATTERN_DATE_1);*/
		Date currentDate = DateUtilTools.getNowDate();
		// 根据日期和节点查找符合条件的kuNodeInfo
		for (MaintainEquip maintainEquip : maintainEquips) {
			// 卫星链路参数
			List<KuNodeInfo> kuNodeInfos = kuNodeInfoManager
					.findByMaintainEquip(maintainEquip, currentDate);
			// 如果节点信息不为空，则计算平均值
			if (!CollectionUtils.isEmpty(kuNodeInfos)) {
				// eb/no
				Double ebno = 0.0;
				// 接收电平
				Double rxLevel = 0.0;
				for (KuNodeInfo kuNodeInfo : kuNodeInfos) {
					ebno += Double.valueOf(kuNodeInfo.getEbno());
					rxLevel += Double.valueOf(kuNodeInfo.getRxLevel());
				}
				// 平均值
				ebno = ebno / kuNodeInfos.size();
				rxLevel = rxLevel / kuNodeInfos.size();
				results.add(new KuMonthReport(KuMonthReportLegendEnum.EBNO,
						String.valueOf(ebno), currentDate, DateUtilTools
								.format(currentDate,
										DateUtilTools.PATTERN_DATE_4),
						maintainEquip.getEquip(), maintainEquip
								.getSatelliteSite()));
				results.add(new KuMonthReport(KuMonthReportLegendEnum.RXLEVEL,
						String.valueOf(rxLevel), currentDate, DateUtilTools
								.format(currentDate,
										DateUtilTools.PATTERN_DATE_4),
						maintainEquip.getEquip(), maintainEquip
								.getSatelliteSite()));
			}
			// 误码率参数
			Wafr08Port0Stat stat = wafr08Port0StatManager.findByEquipAndDate(
					maintainEquip, currentDate);
			if (!ObjectUtils.equals(stat, null)) {
				String totalBitErr = stat.getTotalBitErr();
				// 电路运行情况
				results.add(new KuMonthReport(
						KuMonthReportLegendEnum.ERRORRATE, totalBitErr,
						currentDate, DateUtilTools.format(currentDate,
								DateUtilTools.PATTERN_DATE_4), maintainEquip
								.getEquip(), maintainEquip.getSatelliteSite()));
			}
		}
		// 设备故障情况，通过查看事件单来确认
		List<FaultAlarm> faultAlarms = faultAlarmMngService
				.findByEquipAndDate(maintainEquips, currentDate);
		if (!CollectionUtils.isEmpty(faultAlarms)) {
			// fr08故障次数
			Integer fr08Num = 0;
			// modem故障次数
			Integer modemNum = 0;
			for (FaultAlarm faultAlarm : faultAlarms) {
				NetworkType type = faultAlarm.getEquip().getType();
				if (ObjectUtils.equals(type, NetworkType.wafr08)) {
					fr08Num++;
				} else if (ObjectUtils
						.equals(type, NetworkType.kumodemcard)) {
					modemNum++;
				}
			}
			for (FaultAlarm faultAlarm : faultAlarms) {
				MaintainEquip maintainEquip = faultAlarm.getEquip();
				// fr08
				results.add(new KuMonthReport(KuMonthReportLegendEnum.WAFR08,
						String.valueOf(fr08Num), currentDate, DateUtilTools
								.format(currentDate,
										DateUtilTools.PATTERN_DATE_4),
						maintainEquip.getEquip(), maintainEquip
								.getSatelliteSite()));
				// modem
				results.add(new KuMonthReport(KuMonthReportLegendEnum.MODEM,
						String.valueOf(modemNum), currentDate, DateUtilTools
								.format(currentDate,
										DateUtilTools.PATTERN_DATE_4),
						maintainEquip.getEquip(), maintainEquip
								.getSatelliteSite()));
			}
			
		}
		// 保存记录
		if (!CollectionUtils.isEmpty(results)) {
			for (KuMonthReport result : results) {
				KuMonthReport kuMonthReport = kuMonthReportDao.findExist(
						result.getLegend(), result.getRecordDate(),
						result.getEquip(), result.getSatellite());
				// 如果为空，则代表数据库里无记录，则新增；否则更新
				if (ObjectUtils.equals(kuMonthReport, null)) {
					kuMonthReportDao.save(result);
				} else {
					kuMonthReport.setData(result.getData());
					kuMonthReportDao.update(kuMonthReport);
				}
			}
		}
		logger.info(DateUtilTools.getNowDateTime() + "：结束计算ku维保月度报告数据");
	}

	/**
	 * 按照equipId和satelliteId进行去重
	 * 
	 * @author 王凌斌
	 * @2017年1月24日 下午3:01:40
	 * @param maintainEquips
	 * @return List<MaintainEquip>
	 */
	@SuppressWarnings("unused")
	private List<MaintainEquip> removeRepeatedRecords(
			List<MaintainEquip> maintainEquips) {
		if (maintainEquips.size() == 1) {
			return maintainEquips;
		} else {
			List<MaintainEquip> results = new ArrayList<MaintainEquip>();
			// 记录相同信息的最后一个的位置
			int index = 0;
			for (int i = 0; i < maintainEquips.size(); i++) {
				// 判断如果index==i的话，则跳过，继续比较下一个
				if (index > i && i != 0) {
					continue;
				}
				// 比较最后一个和前一个是否相同，如果相同则跳过，不同则添加到result中
				if (i == maintainEquips.size() - 1) {
					if (StringUtils.equalsIgnoreCase(maintainEquips.get(i - 1)
							.getEquip().getId(), maintainEquips.get(i)
							.getEquip().getId())
							&& StringUtils.equalsIgnoreCase(
									maintainEquips.get(i - 1)
											.getSatelliteSite().getId(),
									maintainEquips.get(i).getSatelliteSite()
											.getId())) {
						break;
					} else {
						results.add(maintainEquips.get(i));
					}
				}
				MaintainEquip info1 = maintainEquips.get(i);
				// 节点ID
				String euipId1 = info1.getEquip().getId();
				// 站点ID
				String satelliteId1 = info1.getSatelliteSite().getId();
				for (int j = i + 1; j < maintainEquips.size(); j++) {
					MaintainEquip info2 = maintainEquips.get(j);
					// 节点ID
					String euipId2 = info2.getEquip().getId();
					// 站点ID
					String satelliteId2 = info2.getSatelliteSite().getId();
					// 如果相同，则继续比较下一个
					if (StringUtils.equalsIgnoreCase(euipId1, euipId2)
							&& StringUtils.equalsIgnoreCase(satelliteId1,
									satelliteId2)) {
						if (j == maintainEquips.size() - 1) {
							index = j;
						}
						continue;
					}
					// 如果不同，则记录角标位置
					index = j;
					break;
				}
				results.add(maintainEquips.get(i));
			}
			return results;
		}
	}

}
