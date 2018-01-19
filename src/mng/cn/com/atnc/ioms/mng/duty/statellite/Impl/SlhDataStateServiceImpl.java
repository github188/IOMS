package cn.com.atnc.ioms.mng.duty.statellite.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellite.day.SlhDataStateDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.SlhDataState;
import cn.com.atnc.ioms.mng.duty.statellite.SlhDataStateService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.SlhDataStateModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 
 * @author shijiyong
 * @date 2016年10月18日 上午10:02:09
 * @version 1.0, 2016年10月18日 上午10:02:09
 */
@Transactional
@Service("SlhDataStateService")
public class SlhDataStateServiceImpl implements SlhDataStateService {

	@Autowired
	private EnvironmentEquipCheckDao environmentEquipCheckDao;
	@Autowired
	private SlhDataStateDao slhdatastatedao;

	@Override
	public SlhDataStateModel save(SlhDataStateModel Slhdatastate) {
		// 公共
		EnvironmentEquipCheck upsCheck = new EnvironmentEquipCheck();
		upsCheck.setOperator(Slhdatastate.getOperator());
		upsCheck.setCheckTime(DateUtilTools.getNowDateTime());
		upsCheck.setCheckDate(DateUtilTools.getNowDate());
		environmentEquipCheckDao.save(upsCheck);

		// 私有
		SlhDataState datastate = new SlhDataState();
		datastate.setAtmb(Slhdatastate.getAtmb());
		datastate.setCheckid(upsCheck);
		slhdatastatedao.save(datastate);

		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(datastate.getId());
		return (SlhDataStateModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		return slhdatastatedao.queryPageByModel(queryModel);
	}

	@Override
	public SlhDataState findById(String id) {
		return slhdatastatedao.findById(id);
	}

	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		return environmentEquipCheckDao.findById(checkid);
	}

	@Override
	public SlhDataStateModel update(SlhDataState datastate,
			EnvironmentEquipCheck enviroment,
			SlhDataStateModel Slhdatastatemodel) {

		enviroment.setUpdater(Slhdatastatemodel.getOperator());
		enviroment.setUpdateTime(DateUtilTools.getNowDateTime());
		environmentEquipCheckDao.update(enviroment);

		datastate.setAtmb(Slhdatastatemodel.getAtmb());
		slhdatastatedao.update(datastate);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(datastate.getId());
		return (SlhDataStateModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public void delete(SlhDataState datastate, EnvironmentEquipCheck enviroment) {
		environmentEquipCheckDao.delete(enviroment);
		slhdatastatedao.delete(datastate);
	}

}
