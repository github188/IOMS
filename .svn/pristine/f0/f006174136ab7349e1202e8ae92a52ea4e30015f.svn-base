package cn.com.atnc.ioms.mng.duty.statellite.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellite.day.SlhZpjjStateDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.SlhZpjjState;
import cn.com.atnc.ioms.mng.duty.statellite.SlhZpjjStateService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.SlhZpjjStateModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 
 * @author shijiyong
 * @date 2016年10月18日 上午10:02:09
 * @version 1.0, 2016年10月18日 上午10:02:09
 */
@Transactional
@Service("SlhZpjjStateService")
public class SlhZpjjStateServiceImpl implements SlhZpjjStateService {

	@Autowired
	private EnvironmentEquipCheckDao environmentEquipCheckDao;
	@Autowired
	private SlhZpjjStateDao slhzpjjdao;

	@Override
	public SlhZpjjStateModel save(SlhZpjjStateModel shlzpjjmodel) {
		EnvironmentEquipCheck upsCheck = new EnvironmentEquipCheck();
		upsCheck.setOperator(shlzpjjmodel.getOperator());
		upsCheck.setCheckTime(DateUtilTools.getNowDateTime());
		upsCheck.setCheckDate(DateUtilTools.getNowDate());
		environmentEquipCheckDao.save(upsCheck);

		SlhZpjjState jjstate = new SlhZpjjState();
		jjstate.setInr1(shlzpjjmodel.getInr1());
		jjstate.setInr2(shlzpjjmodel.getInr2());
		jjstate.setInr3(shlzpjjmodel.getInr3());
		jjstate.setInr4(shlzpjjmodel.getInr4());
		jjstate.setInr5(shlzpjjmodel.getInr5());
		jjstate.setInr6(shlzpjjmodel.getInr6());
		jjstate.setInr7(shlzpjjmodel.getInr7());
		jjstate.setInrb(shlzpjjmodel.getInrb());
		jjstate.setEbi(shlzpjjmodel.getEbi());
		jjstate.setEbt(shlzpjjmodel.getEbt());
		jjstate.setCheckid(upsCheck);
		slhzpjjdao.save(jjstate);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(jjstate.getId());
		return (SlhZpjjStateModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		// TODO Auto-generated method stub
		return slhzpjjdao.queryPageByModel(queryModel);
	}

	@Override
	public SlhZpjjState findById(String id) {
		// TODO Auto-generated method stub
		return slhzpjjdao.findById(id);
	}

	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		// TODO Auto-generated method stub
		return environmentEquipCheckDao.findById(checkid);
	}

	@Override
	public SlhZpjjStateModel update(SlhZpjjState shlzpjj,
			EnvironmentEquipCheck enviroment, SlhZpjjStateModel shlzpjjmodel) {
		enviroment.setUpdater(shlzpjjmodel.getOperator());
		enviroment.setUpdateTime(DateUtilTools.getNowDateTime());
		environmentEquipCheckDao.update(enviroment);

		shlzpjj.setInr1(shlzpjjmodel.getInr1());
		shlzpjj.setInr2(shlzpjjmodel.getInr2());
		shlzpjj.setInr3(shlzpjjmodel.getInr3());
		shlzpjj.setInr4(shlzpjjmodel.getInr4());
		shlzpjj.setInr5(shlzpjjmodel.getInr5());
		shlzpjj.setInr6(shlzpjjmodel.getInr6());
		shlzpjj.setInr7(shlzpjjmodel.getInr7());
		shlzpjj.setEbi(shlzpjjmodel.getEbi());
		shlzpjj.setEbt(shlzpjjmodel.getEbt());
		slhzpjjdao.update(shlzpjj);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(shlzpjj.getId());
		return (SlhZpjjStateModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public void delete(SlhZpjjState shlzpjj, EnvironmentEquipCheck enviroment) {
		// TODO Auto-generated method stub
		environmentEquipCheckDao.delete(enviroment);
		slhzpjjdao.delete(shlzpjj);
	}

}
