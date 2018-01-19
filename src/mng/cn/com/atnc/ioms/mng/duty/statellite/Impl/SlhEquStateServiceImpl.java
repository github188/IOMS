package cn.com.atnc.ioms.mng.duty.statellite.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellite.day.SlhEquStateDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.SlhEquState;
import cn.com.atnc.ioms.mng.duty.statellite.SlhEquStateService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.SlhEquStateModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 
 * @author shijiyong
 * @date 2016年10月18日 上午10:02:09
 * @version 1.0, 2016年10月18日 上午10:02:09
 */
@Transactional
@Service("SlhEquStateService")
public class SlhEquStateServiceImpl implements SlhEquStateService {

	@Autowired
	private EnvironmentEquipCheckDao environmentEquipCheckDao;
	@Autowired
	private SlhEquStateDao slhequstatedao;

	public SlhEquStateModel save(SlhEquStateModel Slhdatastate) {
		EnvironmentEquipCheck upsCheck = new EnvironmentEquipCheck();
		upsCheck.setOperator(Slhdatastate.getOperator());
		upsCheck.setCheckTime(DateUtilTools.getNowDateTime());
		upsCheck.setCheckDate(DateUtilTools.getNowDate());
		environmentEquipCheckDao.save(upsCheck);

		SlhEquState equstate = new SlhEquState();
		equstate.setDpc38(Slhdatastate.getDpc38());
		equstate.setDpc58(Slhdatastate.getDpc58());
		equstate.setNCC62(Slhdatastate.getNCC62());
		equstate.setNCC63(Slhdatastate.getNCC63());
		equstate.setUmoddown(Slhdatastate.getUmoddown());
		equstate.setUmodup(Slhdatastate.getUmodup());
		equstate.setCheckid(upsCheck);
		slhequstatedao.save(equstate);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(equstate.getId());
		return (SlhEquStateModel) queryPageByModel(qm).getResult().get(0);
	}

	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		return slhequstatedao.queryPageByModel(queryModel);
	}

	@Override
	public SlhEquState findById(String id) {
		return slhequstatedao.findById(id);
	}

	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		return environmentEquipCheckDao.findById(checkid);
	}

	@Override
	public SlhEquStateModel update(SlhEquState equstate,
			EnvironmentEquipCheck enviroment, SlhEquStateModel Slhdatastatemodel) {
		enviroment.setUpdater(Slhdatastatemodel.getOperator());
		enviroment.setUpdateTime(DateUtilTools.getNowDateTime());
		environmentEquipCheckDao.update(enviroment);

		equstate.setDpc38(Slhdatastatemodel.getDpc38());
		equstate.setDpc58(Slhdatastatemodel.getDpc58());
		equstate.setNCC62(Slhdatastatemodel.getNCC62());
		equstate.setNCC63(Slhdatastatemodel.getNCC63());
		equstate.setUmoddown(Slhdatastatemodel.getUmoddown());
		equstate.setUmodup(Slhdatastatemodel.getUmodup());
		slhequstatedao.update(equstate);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(equstate.getId());
		return (SlhEquStateModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public void delete(SlhEquState datastate, EnvironmentEquipCheck enviroment) {
		slhequstatedao.delete(datastate);
		environmentEquipCheckDao.delete(enviroment);
	}

}
