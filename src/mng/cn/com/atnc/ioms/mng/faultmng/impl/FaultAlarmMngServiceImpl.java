package cn.com.atnc.ioms.mng.faultmng.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.basedata.satellite.ISatelliteSiteDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultAlarmDao;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.faultmng.FaultAlarm;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.mng.faultmng.IFaultAlarmMngService;
import cn.com.atnc.ioms.model.faultmng.FaultAlarmQueryModel;

/**
 * 事件单与告警绑定管理service接口实现类
 *
 * @author 段衍林
 * @2017年1月19日 下午1:32:06
 */
@Service("faultAlarmMngService")
public class FaultAlarmMngServiceImpl extends BaseService implements
		IFaultAlarmMngService {

	@Autowired
	private IFaultAlarmDao faultAlarmDao;
	@Autowired
	private ISatelliteSiteDao satelliteSiteDao;

	@SuppressWarnings("unchecked")
	@Override
	public Pagination queryPage(FaultAlarmQueryModel queryModel) {
		// 查询分页数据
		Pagination pagn = faultAlarmDao.queryPage(queryModel);
		// 取出列表结果集
		List<FaultAlarm> faultAlarms = (List<FaultAlarm>) pagn.getResult();
		// 非空验证
		if (CollectionUtils.isNotEmpty(faultAlarms)) {
			// 结果集遍历
			for (FaultAlarm faultAlarm : faultAlarms) {
				// 非空设备验证
				if (ObjectUtils.equals(faultAlarm.getEquip(), null)) {
					// 如果设备字段为空，取节点字段
					if (!ObjectUtils.equals(faultAlarm.getProxy(), null)) {
						// 查询卫星站点
						SatelliteSite satelliteSite = satelliteSiteDao
								.findById(faultAlarm.getProxy()
										.getSatelliteId());
						// 赋值
						faultAlarm.setSatelliteSite(satelliteSite);
					}
				} else if (!ObjectUtils.equals(
						faultAlarm.getEquip().getEquip(), null)) {
					// 如果设备字段不为空，降设备中的卫星站点赋值给告警卫星站点属性
					faultAlarm.setSatelliteSite(faultAlarm.getEquip()
							.getEquip().getSatellite());
				}
			}
		}

		return pagn;
	}

	@Override
	public FaultAlarm findById(String id) {
		// 设备查询
		FaultAlarm faultAlarm = faultAlarmDao.findById(id);
		// 非空设备验证
		if (ObjectUtils.equals(faultAlarm.getEquip(), null)) {
			// 如果设备字段为空，取节点字段
			if (!ObjectUtils.equals(faultAlarm.getProxy(), null)) {
				// 查询卫星站点
				SatelliteSite satelliteSite = satelliteSiteDao
						.findById(faultAlarm.getProxy().getSatelliteId());
				// 赋值
				faultAlarm.setSatelliteSite(satelliteSite);
			}
		} else if (!ObjectUtils.equals(faultAlarm.getEquip().getEquip(), null)) {
			// 如果设备字段不为空，降设备中的卫星站点赋值给告警卫星站点属性
			faultAlarm.setSatelliteSite(faultAlarm.getEquip().getEquip()
					.getSatellite());
		}
		return faultAlarm;
	}

	@Override
	public void update(FaultAlarm faultAlarm) {
		faultAlarmDao.update(faultAlarm);
	}

	@Override
	public FaultAlarm findByFaultId(String faultId) {
		return faultAlarmDao.findByParam("fault.id", faultId);
	}

	@Override
	public List<FaultAlarm> findByEquipAndDate(MaintainEquip maintainEquip,
			Date currentDate) {
		return faultAlarmDao.findByEquipAndDate(maintainEquip, currentDate);
	}
	
	@Override
	public List<FaultAlarm> findByEquipAndDate(
			List<MaintainEquip> maintainEquips, Date currentDate) {
		return faultAlarmDao.findByEquipAndDate(maintainEquips, currentDate);
	}
	
	
	public List<FaultAlarm> findByStatus(FaultAlarmQueryModel queryModel) {
		return faultAlarmDao.findByStatus(queryModel);
	}

}