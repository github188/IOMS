package cn.com.atnc.ioms.mng.duty.statellite.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellite.day.SlhProStateDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.SlhProState;
import cn.com.atnc.ioms.mng.duty.statellite.SlhProStateService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.SlhProStateModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 
 * @author shijiyong
 * @date 2016年10月18日 上午10:02:09
 * @version 1.0, 2016年10月18日 上午10:02:09
 */
@Transactional
@Service("SlhProStateService")
public class SlhProStateServiceImpl implements SlhProStateService {

	@Autowired
	private EnvironmentEquipCheckDao environmentEquipCheckDao;
	@Autowired
	private SlhProStateDao slhprostatedao;

	@Override
	public SlhProStateModel save(SlhProStateModel Slhprostatemodel) {

		// 公共
		EnvironmentEquipCheck upsCheck = new EnvironmentEquipCheck();
		upsCheck.setOperator(Slhprostatemodel.getOperator());
		upsCheck.setCheckTime(DateUtilTools.getNowDateTime());
		upsCheck.setCheckDate(DateUtilTools.getNowDate());
		environmentEquipCheckDao.save(upsCheck);

		// 私有
		SlhProState proState = new SlhProState();
		proState.setProcess(Slhprostatemodel.getProcess());
		proState.setCheckid(upsCheck);
		slhprostatedao.save(proState);

		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(proState.getId());
		return (SlhProStateModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		// TODO Auto-generated method stub
		return slhprostatedao.queryPageByModel(queryModel);
	}

	@Override
	public SlhProState findById(String id) {
		// TODO Auto-generated method stub
		return slhprostatedao.findById(id);
	}

	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		// TODO Auto-generated method stub
		return environmentEquipCheckDao.findById(checkid);
	}

	@Override
	public SlhProStateModel update(SlhProState slhprostate,
			EnvironmentEquipCheck enviroment, SlhProStateModel slhprostatemodel) {
		// 公共
		enviroment.setUpdater(slhprostatemodel.getOperator());
		enviroment.setUpdateTime(DateUtilTools.getNowDateTime());
		environmentEquipCheckDao.update(enviroment);

		// 私有
		slhprostate.setProcess(slhprostatemodel.getProcess());
		slhprostatedao.update(slhprostate);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(slhprostate.getId());
		return (SlhProStateModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public void delete(SlhProState Slhprostate, EnvironmentEquipCheck enviroment) {
		// TODO Auto-generated method stub
		environmentEquipCheckDao.delete(enviroment);
		slhprostatedao.delete(Slhprostate);
	}

}
