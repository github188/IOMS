package cn.com.atnc.ioms.mng.duty.environment.ups.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.duty.environment.ups.SystemConnMeasureDao;
import cn.com.atnc.ioms.entity.duty.environment.ups.SystemConnMeasure;
import cn.com.atnc.ioms.mng.duty.environment.ups.SystemConnMeasureService;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;

/**
 * 系统连接检查service实现
 * @author renyujuan
 * @date 2016年7月11日下午4:08:04
 */
@Transactional
@Service("SystemConnMeasureService")

public class SystemConnMeasureServiceImpl extends BaseService implements
		SystemConnMeasureService {
	@Autowired
	private SystemConnMeasureDao systemConnMeasureDao;

	@Override
	public List<SystemConnMeasure> queryByModel(MeasureQueryModel queryModel) {
		return systemConnMeasureDao.queryByModel(queryModel);
	}

	@Override
	public List<SystemConnMeasure> getAll() {
		return systemConnMeasureDao.getAll();
	}

	@Override
	public void save(SystemConnMeasure systemConnMeasure) {
		systemConnMeasureDao.save(systemConnMeasure);
	}

	@Override
	public SystemConnMeasure update(SystemConnMeasure systemConnMeasure) {
		systemConnMeasureDao.update(systemConnMeasure);
		return systemConnMeasureDao.findById(systemConnMeasure.getId());
	}

	@Override
	public void delete(SystemConnMeasure systemConnMeasure) {
		systemConnMeasureDao.delete(systemConnMeasure);	
	}

	@Override
	public SystemConnMeasure findById(String id) {
		return systemConnMeasureDao.findById(id);
		
	}

}
