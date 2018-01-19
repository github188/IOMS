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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.maintain.equip.IMaintainEquipDao;
import cn.com.atnc.ioms.dao.maintain.month.IKuReportDataDao;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.maintain.month.KuReportData;
import cn.com.atnc.ioms.mng.maintain.month.KuReportDataManager;
import cn.com.atnc.ioms.model.maintain.satellite.SatelliteQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * KU报表数据业务实现类
 * 
 * @author 王凌斌
 * @2017年2月23日 下午1:24:36
 */
@Service("KuReportDataManager")
public class KuReportDataManagerImpl extends AbstractService implements
		KuReportDataManager {

	@Autowired
	private IKuReportDataDao kuReportDataDao;
	@Autowired
	private IMaintainEquipDao maintainEquipDao;

	@Override
	public Pagination queryPage(SatelliteQueryModel queryModel) {
		// 日期
		String reportDate = DateUtilTools.getNowYearMonthStr();
		Pagination pagination = maintainEquipDao.findBySatellite(queryModel);
		@SuppressWarnings("unchecked")
		List<SatelliteQueryModel> satelliteQueryModels = (List<SatelliteQueryModel>) pagination
				.getResult();
		// 如果站点下有记录，则新增
		if (!CollectionUtils.isEmpty(satelliteQueryModels)) {
			for (SatelliteQueryModel satelliteQueryModel : satelliteQueryModels) {
				// 站点
				SatelliteSite satelliteSite = satelliteQueryModel
						.getSatelliteSite();
				// 根据日期和站点查找记录
				Boolean isExist = this.findByDateAndSatellite(reportDate,
						satelliteSite);
				// 如果不存在，到维保设备中根据站点查找记录
				if (!isExist) {
					KuReportData kuReportData = new KuReportData();
					kuReportData.setReportDate(reportDate);
					kuReportData.setSatelliteSite(satelliteSite);
					kuReportDataDao.save(kuReportData);
				}
			}
		}
		return kuReportDataDao.queryPage(queryModel);
	}

	@Override
	public Boolean findByDateAndSatellite(String date,
			SatelliteSite satelliteSite) {
		return kuReportDataDao.findByDateAndSatellite(date, satelliteSite);
	}

	@Override
	public KuReportData findById(String id) {
		return kuReportDataDao.findById(id);
	}

	@Override
	public KuReportData write(KuReportData kuReportData, SatelliteQueryModel queryModel) {
		// 基本情况
		kuReportData.setBaseInfo(queryModel.getBaseInfo());
		// 故障处理情况
		kuReportData.setFaultInfo(queryModel.getFaultInfo());
		// 运行情况总结
		kuReportData.setOperSummary(queryModel.getOperSummary());
		// 运行维护建议
		kuReportData.setOperAdvice(queryModel.getOperAdvice());
		kuReportDataDao.update(kuReportData);
		return kuReportData;
	}

}
