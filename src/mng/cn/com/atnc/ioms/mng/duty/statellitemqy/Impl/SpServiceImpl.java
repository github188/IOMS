package cn.com.atnc.ioms.mng.duty.statellitemqy.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.SpDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.Sp;
import cn.com.atnc.ioms.mng.duty.statellitemqy.SpService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.SpModel;
import cn.com.atnc.ioms.util.DateUtilTools;

@Transactional
@Service("SpService")
public class SpServiceImpl implements SpService {

	@Autowired
	private EnvironmentEquipCheckDao environmentEquipCheckDao;
	@Autowired
	private SpDao spdao;

	@Override
	public SpModel save(SpModel spmodel) {
		EnvironmentEquipCheck upsCheck = new EnvironmentEquipCheck();
		upsCheck.setOperator(spmodel.getOperator());
		upsCheck.setCheckTime(DateUtilTools.getNowDateTime());
		upsCheck.setCheckDate(DateUtilTools.getNowDate());
		upsCheck.setCheckType(spmodel.getCheckType());
		environmentEquipCheckDao.save(upsCheck);

		Sp sp = new Sp();
		sp.setSys(spmodel.getSys());
		sp.setName(spmodel.getName());
		sp.setSn(spmodel.getSn());
		sp.setAddress(spmodel.getAddress());
		sp.setCheckid(upsCheck);
		spdao.save(sp);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(sp.getId());
		return (SpModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		return spdao.queryPageByModel(queryModel);
	}

	@Override
	public Sp findById(String id) {
		return spdao.findById(id);
	}

	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		return environmentEquipCheckDao.findById(checkid);
	}

	@Override
	public SpModel update(Sp sp, EnvironmentEquipCheck enviroment,
			SpModel spmodel) {
		enviroment.setUpdater(spmodel.getOperator());
		enviroment.setUpdateTime(DateUtilTools.getNowDateTime());
		enviroment.setCheckDate(spmodel.getCheckDate());
		environmentEquipCheckDao.update(enviroment);

		sp.setSys(spmodel.getSys());
		sp.setName(spmodel.getName());
		sp.setSn(spmodel.getSn());
		sp.setAddress(spmodel.getAddress());
		spdao.update(sp);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(sp.getId());
		return (SpModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public void delete(Sp sp, EnvironmentEquipCheck enviroment) {
		environmentEquipCheckDao.delete(enviroment);
		spdao.delete(sp);
	}
}
