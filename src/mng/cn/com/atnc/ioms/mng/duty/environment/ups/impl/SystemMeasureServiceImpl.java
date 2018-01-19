package cn.com.atnc.ioms.mng.duty.environment.ups.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.duty.environment.ups.SystemMeasureDao;
import cn.com.atnc.ioms.entity.duty.environment.ups.SystemMeasure;
import cn.com.atnc.ioms.mng.duty.environment.ups.SystemMeasureService;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;

/**
 * 系统检查service实现
 * @author renyujuan
 * @date 2016年7月12日上午8:40:19
 */
@Transactional
@Service
public class SystemMeasureServiceImpl extends BaseService implements
		SystemMeasureService {

	@Autowired
	private SystemMeasureDao systemMeasureDao;
	
	@Override
	public List<SystemMeasure> queryByModel(MeasureQueryModel queryModel) {
		return systemMeasureDao.queryByModel(queryModel);
	}

	@Override
	public List<SystemMeasure> getAll() {
		return systemMeasureDao.getAll();
	}

	@Override
	public void save(SystemMeasure systemMeasure) {
		systemMeasureDao.save(systemMeasure);	
	}

	@Override
	public SystemMeasure update(SystemMeasure systemMeasure) {
		systemMeasureDao.update(systemMeasure);
		return systemMeasureDao.findById(systemMeasure.getId());
	}

	@Override
	public void delete(SystemMeasure systemMeasure) {
		systemMeasureDao.delete(systemMeasure);
	}

	@Override
	public SystemMeasure findById(String id) {
		return systemMeasureDao.findById(id);		
	}

}
