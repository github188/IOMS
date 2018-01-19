package cn.com.atnc.ioms.mng.duty.statellitemqy.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.WhDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.Wh;
import cn.com.atnc.ioms.mng.duty.statellitemqy.WhService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.WhModel;
import cn.com.atnc.ioms.util.DateUtilTools;

@Transactional
@Service("WhService")
public class WhServiceImpl implements WhService {

	@Autowired
	private EnvironmentEquipCheckDao environmentEquipCheckDao;
	@Autowired
	private WhDao whdao;

	@Override
	public WhModel save(WhModel Whmodel) {

		EnvironmentEquipCheck upsCheck = new EnvironmentEquipCheck();
		upsCheck.setOperator(Whmodel.getOperator());
		upsCheck.setCheckTime(DateUtilTools.getNowDateTime());
		upsCheck.setCheckDate(DateUtilTools.getNowDate());
		upsCheck.setCheckType(Whmodel.getCheckType());
		environmentEquipCheckDao.save(upsCheck);

		Wh wh = new Wh();
		wh.setOpinion(Whmodel.getOpinion());
		wh.setResult(Whmodel.getResult());
		wh.setCheckid(upsCheck);
		whdao.save(wh);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(wh.getId());
		return (WhModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		// TODO Auto-generated method stub
		return whdao.queryPageByModel(queryModel);
	}

	@Override
	public Wh findById(String id) {
		return whdao.findById(id);
	}

	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		return environmentEquipCheckDao.findById(checkid);
	}

	@Override
	public WhModel update(Wh wh, EnvironmentEquipCheck enviroment,
			WhModel Whmodel) {
		enviroment.setUpdater(Whmodel.getOperator());
		enviroment.setUpdateTime(DateUtilTools.getNowDateTime());
		environmentEquipCheckDao.update(enviroment);

		wh.setOpinion(Whmodel.getOpinion());
		wh.setResult(Whmodel.getResult());
		whdao.update(wh);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(wh.getId());
		return (WhModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public void delete(Wh wh, EnvironmentEquipCheck enviroment) {
		environmentEquipCheckDao.delete(enviroment);
		whdao.delete(wh);
	}

}
