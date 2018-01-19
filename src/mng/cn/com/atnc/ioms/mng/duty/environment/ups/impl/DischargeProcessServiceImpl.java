package cn.com.atnc.ioms.mng.duty.environment.ups.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.duty.environment.ups.DischargeProcessDao;
import cn.com.atnc.ioms.entity.duty.environment.ups.DischargeProcess;
import cn.com.atnc.ioms.mng.duty.environment.ups.DischargeProcessService;
import cn.com.atnc.ioms.model.duty.environment.ups.DischargeProcessQueryModel;
/**
 * 放电过程service实现
 * @author renyujuan
 * @date 2016年7月12日上午9:31:03
 */
@Transactional
@Service
public class DischargeProcessServiceImpl extends BaseService implements
		DischargeProcessService {
	@Autowired
	private DischargeProcessDao dischargeProcessDao;
	@Override
	public List<DischargeProcess> queryByModel(DischargeProcessQueryModel queryModel) {
		return dischargeProcessDao.queryByModel(queryModel);
	}

	@Override
	public List<DischargeProcess> getAll() {
		return dischargeProcessDao.getAll();
	}

	@Override
	public void save(DischargeProcess dischargeProcess) {
		dischargeProcessDao.save(dischargeProcess);
	}

	@Override
	public DischargeProcess update(DischargeProcess dischargeProcess) {
		dischargeProcessDao.delete(dischargeProcess);
		return dischargeProcessDao.findById(dischargeProcess.getId());
	}

	@Override
	public void delete(DischargeProcess dischargeProcess) {
		dischargeProcessDao.delete(dischargeProcess);
	}

	@Override
	public DischargeProcess findById(String id) {
		return dischargeProcessDao.findById(id);
	}

}
