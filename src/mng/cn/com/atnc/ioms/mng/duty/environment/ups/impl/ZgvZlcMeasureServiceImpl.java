package cn.com.atnc.ioms.mng.duty.environment.ups.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.duty.environment.ups.ZgvZlcMeasureDao;
import cn.com.atnc.ioms.entity.duty.environment.ups.ZgvZlcMeasure;
import cn.com.atnc.ioms.mng.duty.environment.ups.ZgvZlcMeasureService;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;
/**
 * 零地电压和零线电流测量service实现
 * @author renyujuan
 * @date 2016年7月12日上午9:18:17
 */
@Transactional
@Service
public class ZgvZlcMeasureServiceImpl extends BaseService implements
		ZgvZlcMeasureService {
	
	@Autowired
	private ZgvZlcMeasureDao zgvZlcMeasureDao;
	@Override
	public List<ZgvZlcMeasure> queryByModel(MeasureQueryModel queryModel) {
		return zgvZlcMeasureDao.queryByModel(queryModel);
	}

	@Override
	public List<ZgvZlcMeasure> getAll() {
		return zgvZlcMeasureDao.getAll();
	}

	@Override
	public void save(ZgvZlcMeasure zgvZlcMeasure) {
		zgvZlcMeasureDao.save(zgvZlcMeasure);
	}

	@Override
	public ZgvZlcMeasure update(ZgvZlcMeasure zgvZlcMeasure) {
		zgvZlcMeasureDao.update(zgvZlcMeasure);
		return zgvZlcMeasureDao.findById(zgvZlcMeasure.getId());
	}

	@Override
	public void delete(ZgvZlcMeasure zgvZlcMeasure) {
		zgvZlcMeasureDao.delete(zgvZlcMeasure);
	}

	@Override
	public ZgvZlcMeasure findById(String id) {
		return zgvZlcMeasureDao.findById(id);
	}

}
