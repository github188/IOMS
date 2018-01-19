package cn.com.atnc.ioms.mng.duty.statellitemqy.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.ForwardDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.Forward;
import cn.com.atnc.ioms.mng.duty.statellitemqy.ForwardService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.ForwardModel;
import cn.com.atnc.ioms.util.DateUtilTools;

@Transactional
@Service("ForwardService")
public class ForwardServiceImpl implements ForwardService {

	@Autowired
	private EnvironmentEquipCheckDao environmentEquipCheckDao;
	@Autowired
	private ForwardDao forwarddao;

	@Override
	public ForwardModel save(ForwardModel forwardmodel) {

		EnvironmentEquipCheck upsCheck = new EnvironmentEquipCheck();
		upsCheck.setOperator(forwardmodel.getOperator());
		upsCheck.setCheckTime(DateUtilTools.getNowDateTime());
		upsCheck.setCheckDate(DateUtilTools.getNowDate());
		upsCheck.setCheckType(forwardmodel.getCheckType());
		environmentEquipCheckDao.save(upsCheck);

		Forward forward = new Forward();
		forward.setTesSum(forwardmodel.getTesSum());
		forward.setTesUse(forwardmodel.getTesUse());
		forward.setTesSur(forwardmodel.getTesSur());
		forward.setTesDbm(forwardmodel.getTesDbm());
		forward.setTesDb(forwardmodel.getTesDb());

		forward.setPesSum(forwardmodel.getPesSum());
		forward.setPesUse(forwardmodel.getPesUse());
		forward.setPesSur(forwardmodel.getPesSur());
		forward.setPesDbm(forwardmodel.getPesDbm());
		forward.setPesDb(forwardmodel.getPesDb());

		forward.setVsatSum(forwardmodel.getVsatSum());
		forward.setVsatUse(forwardmodel.getVsatUse());
		forward.setVsatSur(forwardmodel.getVsatSur());
		forward.setVsatDbm(forwardmodel.getVsatDbm());
		forward.setVsatDb(forwardmodel.getVsatDb());

		forward.setComSum(forwardmodel.getComSum());
		forward.setComUse(forwardmodel.getComUse());
		forward.setComSur(forwardmodel.getComSur());
		forward.setComDbm(forwardmodel.getComDbm());
		forward.setComDb(forwardmodel.getComDb());

		forward.setCheckid(upsCheck);
		forwarddao.save(forward);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(forward.getId());
		return (ForwardModel) queryPageByModel(qm).getResult().get(0);

	}

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		return forwarddao.queryPageByModel(queryModel);
	}

	@Override
	public Forward findById(String id) {
		return forwarddao.findById(id);
	}

	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		return environmentEquipCheckDao.findById(checkid);
	}

	@Override
	public ForwardModel update(Forward forward,
			EnvironmentEquipCheck enviroment, ForwardModel forwardmodel) {
		enviroment.setUpdater(forwardmodel.getOperator());
		enviroment.setUpdateTime(DateUtilTools.getNowDate());
		environmentEquipCheckDao.update(enviroment);

		forward.setTesSum(forwardmodel.getTesSum());
		forward.setTesUse(forwardmodel.getTesUse());
		forward.setTesSur(forwardmodel.getTesSur());
		forward.setTesDbm(forwardmodel.getTesDbm());
		forward.setTesDb(forwardmodel.getTesDb());

		forward.setPesSum(forwardmodel.getPesSum());
		forward.setPesUse(forwardmodel.getPesUse());
		forward.setPesSur(forwardmodel.getPesSur());
		forward.setPesDbm(forwardmodel.getPesDbm());
		forward.setPesDb(forwardmodel.getPesDb());

		forward.setVsatSum(forwardmodel.getVsatSum());
		forward.setVsatUse(forwardmodel.getVsatUse());
		forward.setVsatSur(forwardmodel.getVsatSur());
		forward.setVsatDbm(forwardmodel.getVsatDbm());
		forward.setVsatDb(forwardmodel.getVsatDb());

		forward.setComSum(forwardmodel.getComSum());
		forward.setComUse(forwardmodel.getComUse());
		forward.setComSur(forwardmodel.getComSur());
		forward.setComDbm(forwardmodel.getComDbm());
		forward.setComDb(forwardmodel.getComDb());
		forwarddao.update(forward);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(forward.getId());
		return (ForwardModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public void delete(Forward forward, EnvironmentEquipCheck enviroment) {
		environmentEquipCheckDao.delete(enviroment);
		forwarddao.delete(forward);
	}

}
