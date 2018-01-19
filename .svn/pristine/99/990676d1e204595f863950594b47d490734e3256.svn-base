package cn.com.atnc.ioms.mng.duty.environment.ups.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.duty.environment.ups.BatteryMeasureDao;
import cn.com.atnc.ioms.entity.duty.environment.ups.BatteryMeasure;
import cn.com.atnc.ioms.mng.duty.environment.ups.BatteryMeasureService;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;
/**
 * 电池测量service实现类
 * @author renyujuan
 * @date 2016年7月11日下午2:59:50
 */
@Transactional
@Service("BatteryMeasureService")
public class BatteryMeasureServiceImpl extends BaseService implements
		BatteryMeasureService {

	@Autowired
	private BatteryMeasureDao batteryMeasureDao;
	
	@Override
	public List<BatteryMeasure> queryByModel(MeasureQueryModel queryModel) {
		return batteryMeasureDao.queryByModel(queryModel);
	}

	@Override
	public List<BatteryMeasure> getAll() {
		return batteryMeasureDao.getAll();
	}

	@Override
	public void save(BatteryMeasure batteryMeasure) {
		batteryMeasureDao.save(batteryMeasure);
	}

	@Override
	public BatteryMeasure update(BatteryMeasure batteryMeasure) {
		batteryMeasureDao.update(batteryMeasure);
		return batteryMeasureDao.findById(batteryMeasure.getId());
	}

	@Override
	public void delete(BatteryMeasure batteryMeasure) {
		batteryMeasureDao.delete(batteryMeasure);
	}

	@Override
	public BatteryMeasure findById(String id) {
		return batteryMeasureDao.findById(id);
		
	}

}
