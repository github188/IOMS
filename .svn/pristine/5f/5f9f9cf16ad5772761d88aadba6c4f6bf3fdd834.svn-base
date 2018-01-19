package cn.com.atnc.ioms.mng.duty.environment.ups.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.duty.environment.ups.UpsContentCheckDao;
import cn.com.atnc.ioms.entity.duty.environment.ups.UpsContentCheck;
import cn.com.atnc.ioms.mng.duty.environment.ups.UpsContentCheckService;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;
/**
 * ups内容巡检service实现
 * @author renyujuan
 * @date 2016年7月12日上午9:03:02
 */
@Transactional
@Service
public class UpsContentCheckServiceImpl extends BaseService implements
		UpsContentCheckService {
	@Autowired
	private UpsContentCheckDao upsContentCheckDao;

	@Override
	public List<UpsContentCheck> queryByModel(MeasureQueryModel queryModel) {
		return upsContentCheckDao.queryByModel(queryModel);
	}

	@Override
	public List<UpsContentCheck> getAll() {
		return upsContentCheckDao.getAll();
	}

	@Override
	public void save(UpsContentCheck upsContentCheck) {
		upsContentCheckDao.save(upsContentCheck);
	}

	@Override
	public UpsContentCheck update(UpsContentCheck upsContentCheck) {
		upsContentCheckDao.update(upsContentCheck);
		return upsContentCheckDao.findById(upsContentCheck.getId());
	}

	@Override
	public void delete(UpsContentCheck upsContentCheck) {
		upsContentCheckDao.delete(upsContentCheck);
	}

	@Override
	public UpsContentCheck findById(String id) {
		return upsContentCheckDao.findById(id);
	}

}
