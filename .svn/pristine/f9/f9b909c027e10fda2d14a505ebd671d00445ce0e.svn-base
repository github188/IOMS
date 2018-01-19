package cn.com.atnc.ioms.mng.duty.statellitemqy.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.KuSysDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.KuSys;
import cn.com.atnc.ioms.mng.duty.statellitemqy.KuSysService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.KuSysModel;
import cn.com.atnc.ioms.util.DateUtilTools;

@Transactional
@Service("KuSysService")
public class KuSysServiceImpl implements KuSysService {

	@Autowired
	private EnvironmentEquipCheckDao environmentEquipCheckDao;
	@Autowired
	private KuSysDao kusysdao;

	@Override
	public KuSysModel save(KuSysModel kusysmodel) {
		EnvironmentEquipCheck upsCheck = new EnvironmentEquipCheck();
		upsCheck.setOperator(kusysmodel.getOperator());
		upsCheck.setCheckTime(DateUtilTools.getNowDateTime());
		upsCheck.setCheckDate(DateUtilTools.getNowDate());
		upsCheck.setCheckType(kusysmodel.getCheckType());
		environmentEquipCheckDao.save(upsCheck);

		KuSys kusys = new KuSys();
		kusys.setNet1Workstate(kusysmodel.getNet1Workstate());
		kusys.setNet2Workstate(kusysmodel.getNet2Workstate());
		kusys.setNet3Workstate(kusysmodel.getNet3Workstate());
		kusys.setNet4Workstate(kusysmodel.getNet4Workstate());
		kusys.setNetzWorkstate(kusysmodel.getNetzWorkstate());
		kusys.setNet3WorkstateBf(kusysmodel.getNet3WorkstateBf());
		kusys.setNet1WorkstateBf(kusysmodel.getNet1WorkstateBf());
		kusys.setNet2WorkstateBf(kusysmodel.getNet2WorkstateBf());
		kusys.setNet4WorkstateBf(kusysmodel.getNet4WorkstateBf());
		kusys.setNetzWorkstateBf(kusysmodel.getNetzWorkstateBf());
		kusys.setTapeLocate(kusysmodel.getTapeLocate());
		kusys.setWorkDust(kusysmodel.getWorkDust());
		kusys.setForward(kusysmodel.getForward());
		kusys.setSubnetWorkRemark(kusysmodel.getSubnetWorkRemark());
		kusys.setSubnetDataRemark(kusysmodel.getSubnetDataRemark());
		kusys.setTapeLocateRemark(kusysmodel.getTapeLocateRemark());
		kusys.setWorkDustRemark(kusysmodel.getWorkDustRemark());
		kusys.setForwardRemark(kusysmodel.getForwardRemark());

		kusys.setCheckid(upsCheck);
		kusysdao.save(kusys);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(kusys.getId());
		return (KuSysModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		return kusysdao.queryPageByModel(queryModel);
	}

	@Override
	public KuSys findById(String id) {
		return kusysdao.findById(id);
	}

	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		return environmentEquipCheckDao.findById(checkid);
	}

	@Override
	public KuSysModel update(KuSys kusys, EnvironmentEquipCheck enviroment,
			KuSysModel kusysmodel) {

		enviroment.setUpdater(kusysmodel.getOperator());
		enviroment.setUpdateTime(DateUtilTools.getNowDateTime());
		environmentEquipCheckDao.update(enviroment);

		kusys.setNet1Workstate(kusysmodel.getNet1Workstate());
		kusys.setNet2Workstate(kusysmodel.getNet2Workstate());
		kusys.setNet3Workstate(kusysmodel.getNet3Workstate());
		kusys.setNet4Workstate(kusysmodel.getNet4Workstate());
		kusys.setNetzWorkstate(kusysmodel.getNetzWorkstate());
		kusys.setNet3WorkstateBf(kusysmodel.getNet3WorkstateBf());
		kusys.setNet1WorkstateBf(kusysmodel.getNet1WorkstateBf());
		kusys.setNet2WorkstateBf(kusysmodel.getNet2WorkstateBf());
		kusys.setNet4WorkstateBf(kusysmodel.getNet4WorkstateBf());
		kusys.setNetzWorkstateBf(kusysmodel.getNetzWorkstateBf());
		kusys.setTapeLocate(kusysmodel.getTapeLocate());
		kusys.setWorkDust(kusysmodel.getWorkDust());
		kusys.setForward(kusysmodel.getForward());
		kusys.setSubnetWorkRemark(kusysmodel.getSubnetWorkRemark());
		kusys.setSubnetDataRemark(kusysmodel.getSubnetDataRemark());
		kusys.setTapeLocateRemark(kusysmodel.getTapeLocateRemark());
		kusys.setWorkDustRemark(kusysmodel.getWorkDustRemark());
		kusys.setForwardRemark(kusysmodel.getForwardRemark());

		kusysdao.update(kusys);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(kusys.getId());
		return (KuSysModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public void delete(KuSys sp, EnvironmentEquipCheck enviroment) {
		kusysdao.delete(sp);
		environmentEquipCheckDao.delete(enviroment);

	}
}
