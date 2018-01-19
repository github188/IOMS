package cn.com.atnc.ioms.mng.duty.environment.ups.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.duty.environment.ups.DischargeTestDao;
import cn.com.atnc.ioms.entity.duty.environment.ups.DischargeTest;
import cn.com.atnc.ioms.mng.duty.environment.ups.DischargeTestService;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;
/**
 * 放电测试service
 * @author renyujuan
 * @date 2016年7月11日下午3:38:12
 */
@Transactional
@Service("DischargeTestService")
public class DischargeTestServiceImpl extends BaseService implements
		DischargeTestService {

	@Autowired
	private DischargeTestDao dischargeTestDao;
	
	@Override
	public List<DischargeTest> queryByModel(MeasureQueryModel queryModel) {
		return dischargeTestDao.queryByModel(queryModel);
	}

	@Override
	public List<DischargeTest> getAll() {
		return dischargeTestDao.getAll();
	}

	@Override
	public void save(DischargeTest dischargeTest) {
		dischargeTestDao.save(dischargeTest);
		
	}
	
	@Override
	public DischargeTest update(DischargeTest dischargeTest) {
		dischargeTestDao.update(dischargeTest);
		return dischargeTestDao.findById(dischargeTest.getId());
	}

	@Override
	public void delete(DischargeTest dischargeTest) {
		dischargeTestDao.delete(dischargeTest);
	}

	@Override
	public DischargeTest findById(String id) {
		return dischargeTestDao.findById(id);
	}

}
