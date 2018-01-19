package cn.com.atnc.ioms.mng.duty.statellite.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellite.day.SlhjdjjDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.SlhJdjj;
import cn.com.atnc.ioms.mng.duty.statellite.SlhjdjjService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.SlhjdjjModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 
 * @author shijiyong
 * @date 2016年10月18日 上午10:02:09
 * @version 1.0, 2016年10月18日 上午10:02:09
 */
@Transactional
@Service("SlhjdjjService")
public class SlhjdjjServiceImpl implements SlhjdjjService {

	@Autowired
	private EnvironmentEquipCheckDao environmentEquipCheckDao;
	@Autowired
	private SlhjdjjDao slhjdjjdao;

	@Override
	public SlhjdjjModel save(SlhjdjjModel jdjjmodel) {
		EnvironmentEquipCheck upsCheck = new EnvironmentEquipCheck();
		upsCheck.setOperator(jdjjmodel.getOperator());
		upsCheck.setCheckTime(DateUtilTools.getNowDateTime());
		upsCheck.setCheckDate(DateUtilTools.getNowDate());
		environmentEquipCheckDao.save(upsCheck);

		SlhJdjj jdjj = new SlhJdjj();
		jdjj.setDpc1(jdjjmodel.getDpc1());
		jdjj.setDpc2(jdjjmodel.getDpc2());
		jdjj.setDpc3(jdjjmodel.getDpc3());
		jdjj.setDpcb(jdjjmodel.getDpcb());
		jdjj.setNcc(jdjjmodel.getNcc());
		jdjj.setNccb(jdjjmodel.getNccb());
		jdjj.setSic(jdjjmodel.getSic());
		jdjj.setSicb(jdjjmodel.getSicb());
		jdjj.setSuplim1(jdjjmodel.getSuplim1());
		jdjj.setSuplim2(jdjjmodel.getSuplim2());
		jdjj.setSuplim3(jdjjmodel.getSuplim3());
		jdjj.setSuplim4(jdjjmodel.getSuplim4());
		jdjj.setSuplim5(jdjjmodel.getSuplim5());
		jdjj.setSuplim6(jdjjmodel.getSuplim6());
		jdjj.setSuplimb(jdjjmodel.getSuplimb());

		jdjj.setCheckid(upsCheck);
		slhjdjjdao.save(jdjj);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(jdjj.getId());
		return (SlhjdjjModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		// TODO Auto-generated method stub
		return slhjdjjdao.queryPageByModel(queryModel);
	}

	@Override
	public SlhJdjj findById(String id) {
		// TODO Auto-generated method stub
		return slhjdjjdao.findById(id);
	}

	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		// TODO Auto-generated method stub
		return environmentEquipCheckDao.findById(checkid);
	}

	@Override
	public SlhjdjjModel update(SlhJdjj jdjj, EnvironmentEquipCheck enviroment,
			SlhjdjjModel Slhjdjjmodel) {
		enviroment.setUpdater(Slhjdjjmodel.getOperator());
		enviroment.setUpdateTime(DateUtilTools.getNowDateTime());
		environmentEquipCheckDao.update(enviroment);

		jdjj.setDpc1(Slhjdjjmodel.getDpc1());
		jdjj.setDpc2(Slhjdjjmodel.getDpc2());
		jdjj.setDpc3(Slhjdjjmodel.getDpc3());
		jdjj.setDpcb(Slhjdjjmodel.getDpcb());
		jdjj.setNcc(Slhjdjjmodel.getNcc());
		jdjj.setNccb(Slhjdjjmodel.getNccb());
		jdjj.setSic(Slhjdjjmodel.getSic());
		jdjj.setSicb(Slhjdjjmodel.getSicb());
		jdjj.setSuplim1(Slhjdjjmodel.getSuplim1());
		jdjj.setSuplim2(Slhjdjjmodel.getSuplim2());
		jdjj.setSuplim3(Slhjdjjmodel.getSuplim3());
		jdjj.setSuplim4(Slhjdjjmodel.getSuplim4());
		jdjj.setSuplim5(Slhjdjjmodel.getSuplim5());
		jdjj.setSuplim6(Slhjdjjmodel.getSuplim6());
		jdjj.setSuplimb(Slhjdjjmodel.getSuplimb());
		slhjdjjdao.update(jdjj);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(jdjj.getId());
		return (SlhjdjjModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public void delete(SlhJdjj jdjj, EnvironmentEquipCheck enviroment) {
		environmentEquipCheckDao.delete(enviroment);
		slhjdjjdao.delete(jdjj);
	}

}
