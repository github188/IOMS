package cn.com.atnc.ioms.mng.duty.statellitemqy.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.TesCheckDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.TesCheck;
import cn.com.atnc.ioms.mng.duty.statellitemqy.TesCheckService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.TesCheckModel;
import cn.com.atnc.ioms.util.DateUtilTools;

@Transactional
@Service("TesCheckService")
public class TesCheckServiceImpl implements TesCheckService {

	@Autowired
	private EnvironmentEquipCheckDao environmentEquipCheckDao;
	@Autowired
	private TesCheckDao tescheckdao;

	@Override
	public TesCheckModel save(TesCheckModel tescheckmodel) {

		EnvironmentEquipCheck upsCheck = new EnvironmentEquipCheck();
		upsCheck.setOperator(tescheckmodel.getOperator());
		upsCheck.setCheckTime(DateUtilTools.getNowDateTime());
		upsCheck.setCheckDate(DateUtilTools.getNowDate());
		upsCheck.setCheckType(tescheckmodel.getCheckType());
		environmentEquipCheckDao.save(upsCheck);

		TesCheck tescheck = new TesCheck();
		tescheck.setCheckid(upsCheck);
		tescheck.setRecordGz(tescheckmodel.getRecordGz());
		tescheck.setRecordManual(tescheckmodel.getRecordManual());
		tescheck.setRecordBj(tescheckmodel.getRecordBj());
		tescheck.setRecordBf(tescheckmodel.getRecordBf());

		tescheck.setRecordGzBz(tescheckmodel.getRecordGzBz());
		tescheck.setRecordManualBz(tescheckmodel.getRecordManualBz());
		tescheck.setRecordBjBz(tescheckmodel.getRecordBjBz());
		tescheck.setRecordBfBz(tescheckmodel.getRecordBfBz());

		tescheckdao.save(tescheck);

		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(tescheck.getId());
		return (TesCheckModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		return tescheckdao.queryPageByModel(queryModel);
	}

	@Override
	public TesCheck findById(String id) {
		return tescheckdao.findById(id);
	}

	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		return environmentEquipCheckDao.findById(checkid);
	}

	@Override
	public TesCheckModel update(TesCheck tescheck,
			EnvironmentEquipCheck enviroment, TesCheckModel tescheckmodel) {

		enviroment.setUpdater(tescheckmodel.getOperator());
		enviroment.setUpdateTime(DateUtilTools.getNowDateTime());
		environmentEquipCheckDao.update(enviroment);

		tescheck.setRecordGz(tescheckmodel.getRecordGz());
		tescheck.setRecordManual(tescheckmodel.getRecordManual());
		tescheck.setRecordBj(tescheckmodel.getRecordBj());
		tescheck.setRecordBf(tescheckmodel.getRecordBf());

		tescheck.setRecordGzBz(tescheckmodel.getRecordGzBz());
		tescheck.setRecordManualBz(tescheckmodel.getRecordManualBz());
		tescheck.setRecordBjBz(tescheckmodel.getRecordBjBz());
		tescheck.setRecordBfBz(tescheckmodel.getRecordBfBz());

		tescheckdao.update(tescheck);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(tescheck.getId());
		return (TesCheckModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public void delete(TesCheck tescheck, EnvironmentEquipCheck enviroment) {
		environmentEquipCheckDao.delete(enviroment);
		tescheckdao.delete(tescheck);
	}

}
