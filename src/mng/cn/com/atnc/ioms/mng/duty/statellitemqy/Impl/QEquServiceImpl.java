package cn.com.atnc.ioms.mng.duty.statellitemqy.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.QEquDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.QEqu;
import cn.com.atnc.ioms.mng.duty.statellitemqy.QEquService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.QEquModel;
import cn.com.atnc.ioms.util.DateUtilTools;

@Transactional
@Service("QEquService")
public class QEquServiceImpl implements QEquService {

	@Autowired
	private EnvironmentEquipCheckDao environmentEquipCheckDao;
	@Autowired
	private QEquDao qequdao;

	@Override
	public QEquModel save(QEquModel qequmodel) {

		EnvironmentEquipCheck upsCheck = new EnvironmentEquipCheck();
		upsCheck.setOperator(qequmodel.getOperator());
		upsCheck.setCheckTime(DateUtilTools.getNowDateTime());
		upsCheck.setCheckDate(DateUtilTools.getNowDate());
		upsCheck.setCheckType(qequmodel.getCheckType());
		environmentEquipCheckDao.save(upsCheck);

		QEqu qequ = new QEqu();
		qequ.setIndoorTesJx(qequmodel.getIndoorTesJx());
		qequ.setIndoorTesNormal(qequmodel.getIndoorTesNormal());
		qequ.setIndoorTesInnormal(qequmodel.getIndoorTesInnormal());
		qequ.setIndoorPesJx(qequmodel.getIndoorPesJx());
		qequ.setIndoorPesNormal(qequmodel.getIndoorPesNormal());
		qequ.setIndoorPesInnormal(qequmodel.getIndoorPesInnormal());
		qequ.setIndoorKu1Jx(qequmodel.getIndoorKu1Jx());
		qequ.setIndoorKu1Normal(qequmodel.getIndoorKu1Normal());
		qequ.setIndoorKu1Innormal(qequmodel.getIndoorKu1Innormal());
		qequ.setIndoorKu2Jx(qequmodel.getIndoorKu2Jx());
		qequ.setIndoorKu2Normal(qequmodel.getIndoorKu2Normal());
		qequ.setIndoorKu2Innormal(qequmodel.getIndoorKu2Innormal());
		qequ.setIndoorKu3Jx(qequmodel.getIndoorKu3Jx());
		qequ.setIndoorKu3Normal(qequmodel.getIndoorKu3Normal());
		qequ.setIndoorKu3Innormal(qequmodel.getIndoorKu3Innormal());
		qequ.setIndoorKu4Jx(qequmodel.getIndoorKu4Jx());
		qequ.setIndoorKu4Normal(qequmodel.getIndoorKu4Normal());
		qequ.setIndoorKu4Innormal(qequmodel.getIndoorKu4Innormal());
		qequ.setIndoorKuJx(qequmodel.getIndoorKuJx());
		qequ.setIndoorKuNormal(qequmodel.getIndoorKuNormal());
		qequ.setIndoorKuInnormal(qequmodel.getIndoorKuInnormal());
		qequ.setIndoorComJx(qequmodel.getIndoorComJx());
		qequ.setIndoorComNormal(qequmodel.getIndoorComNormal());
		qequ.setIndoorComInnormal(qequmodel.getIndoorComInnormal());
		qequ.setSlhTesJx(qequmodel.getSlhTesJx());
		qequ.setSlhTesNormal(qequmodel.getSlhTesNormal());
		qequ.setSlhTesInnormal(qequmodel.getSlhTesInnormal());
		qequ.setMhjTesJx(qequmodel.getMhjTesJx());
		qequ.setMhjTesNormal(qequmodel.getMhjTesNormal());
		qequ.setMhjTesInnormal(qequmodel.getMhjTesInnormal());
		qequ.setSlhKuJx(qequmodel.getSlhKuJx());
		qequ.setSlhKuNormal(qequmodel.getSlhKuNormal());
		qequ.setSlhKuInnormal(qequmodel.getSlhKuInnormal());
		qequ.setMhjKuJx(qequmodel.getMhjKuJx());
		qequ.setMhjKuNormal(qequmodel.getMhjKuNormal());
		qequ.setMhjKuInnormal(qequmodel.getMhjKuInnormal());
		qequ.setKuTestJx(qequmodel.getKuTestJx());
		qequ.setKuTestNormal(qequmodel.getKuTestNormal());
		qequ.setKuTestInnormal(qequmodel.getKuTestInnormal());

		qequ.setOutdoorTesJx(qequmodel.getOutdoorTesJx());
		qequ.setOutdoorTesNormal(qequmodel.getOutdoorTesNormal());
		qequ.setOutdoorTesInnormal(qequmodel.getOutdoorTesInnormal());
		qequ.setOutdoorPesJx(qequmodel.getOutdoorPesJx());
		qequ.setOutdoorPesNormal(qequmodel.getOutdoorPesNormal());
		qequ.setOutdoorPesInnormal(qequmodel.getOutdoorPesInnormal());
		qequ.setOutdoorKuJx(qequmodel.getOutdoorKuJx());
		qequ.setOutdoorKuNormal(qequmodel.getOutdoorKuNormal());
		qequ.setOutdoorKuInnormal(qequmodel.getOutdoorKuInnormal());
		qequ.setOutdoorComJx(qequmodel.getOutdoorComJx());
		qequ.setOutdoorComNormal(qequmodel.getOutdoorComNormal());
		qequ.setOutdoorComInnormal(qequmodel.getOutdoorComInnormal());
		qequ.setOutdoorSlhtesJx(qequmodel.getOutdoorSlhtesJx());
		qequ.setOutdoorSlhtesNormal(qequmodel.getOutdoorSlhtesNormal());
		qequ.setOutdoorSlhtesInnormal(qequmodel.getOutdoorSlhtesInnormal());
		qequ.setOutdoorMhjtesJx(qequmodel.getOutdoorMhjtesJx());
		qequ.setOutdoorMhjtesNormal(qequmodel.getOutdoorMhjtesNormal());
		qequ.setOutdoorMhjtesInnormal(qequmodel.getOutdoorMhjtesInnormal());
		qequ.setOutdoorSlhkuJx(qequmodel.getOutdoorSlhkuJx());
		qequ.setOutdoorSlhkuNormal(qequmodel.getOutdoorSlhkuNormal());
		qequ.setOutdoorSlhkuInnormal(qequmodel.getOutdoorSlhkuInnormal());
		qequ.setOutdoorMhjkuJx(qequmodel.getOutdoorMhjkuJx());
		qequ.setOutdoorMhjkuNormal(qequmodel.getOutdoorMhjkuNormal());
		qequ.setOutdoorMhjkuInnormal(qequmodel.getOutdoorMhjkuInnormal());
		qequ.setOutdoorKucsJx(qequmodel.getOutdoorKucsJx());
		qequ.setOutdoorKucsNormal(qequmodel.getOutdoorKucsNormal());
		qequ.setOutdoorKucsInnormal(qequmodel.getOutdoorKucsInnormal());

		qequ.setWgTesJx(qequmodel.getWgTesJx());
		qequ.setWgTesNormal(qequmodel.getWgTesNormal());
		qequ.setWgTesInnormal(qequmodel.getWgTesInnormal());
		qequ.setWgPesJx(qequmodel.getWgPesJx());
		qequ.setWgPesNormal(qequmodel.getWgPesNormal());
		qequ.setWgPesInnormal(qequmodel.getWgPesInnormal());
		qequ.setWgKu1Jx(qequmodel.getWgKu1Jx());
		qequ.setWgKu1Normal(qequmodel.getWgKu1Normal());
		qequ.setWgKu1Innormal(qequmodel.getWgKu1Innormal());
		qequ.setWgKu2Jx(qequmodel.getWgKu2Jx());
		qequ.setWgKu2Normal(qequmodel.getWgKu2Normal());
		qequ.setWgKu2Innormal(qequmodel.getWgKu2Innormal());
		qequ.setWgKu3Jx(qequmodel.getWgKu3Jx());
		qequ.setWgKu3Normal(qequmodel.getWgKu3Normal());
		qequ.setWgKu3Innormal(qequmodel.getWgKu3Innormal());
		qequ.setWgKu4Jx(qequmodel.getWgKu4Jx());
		qequ.setWgKu4Normal(qequmodel.getWgKu4Normal());
		qequ.setWgKu4Innormal(qequmodel.getWgKu4Innormal());
		qequ.setWgKuJx(qequmodel.getWgKuJx());
		qequ.setWgKuNormal(qequmodel.getWgKuNormal());
		qequ.setWgKuInnormal(qequmodel.getWgKuInnormal());

		qequ.setIndoorTesRemark(qequmodel.getIndoorTesRemark());
		qequ.setIndoorPesRemark(qequmodel.getIndoorPesRemark());
		qequ.setIndoorKu1Remark(qequmodel.getIndoorKu1Remark());
		qequ.setIndoorKu2Remark(qequmodel.getIndoorKu2Remark());
		qequ.setIndoorKu3Remark(qequmodel.getIndoorKu3Remark());
		qequ.setIndoorKu4Remark(qequmodel.getIndoorKu4Remark());
		qequ.setIndoorRelayRemark(qequmodel.getIndoorRelayRemark());
		qequ.setIndoorOutRemark(qequmodel.getIndoorOutRemark());
		qequ.setIndoorSlhTes(qequmodel.getIndoorSlhTes());
		qequ.setIndoorMhjTes(qequmodel.getIndoorMhjTes());
		qequ.setIndoorSlhKu(qequmodel.getIndoorSlhKu());
		qequ.setIndoorMhjKu(qequmodel.getIndoorMhjKu());
		qequ.setIndoorKuTest(qequmodel.getIndoorKuTest());
		qequ.setOutdoorTesRemark(qequmodel.getOutdoorTesRemark());
		qequ.setOutdoorPesRemark(qequmodel.getOutdoorPesRemark());
		qequ.setOutdoorKuRemark(qequmodel.getOutdoorKuRemark());
		qequ.setOutdoorSlhTes(qequmodel.getOutdoorSlhTes());
		qequ.setOutdoorMhjTes(qequmodel.getOutdoorMhjTes());
		qequ.setOutdoorSlhKu(qequmodel.getOutdoorSlhKu());
		qequ.setOutdoorMhjKu(qequmodel.getOutdoorMhjKu());
		qequ.setOutdoorKuTest(qequmodel.getOutdoorKuTest());
		qequ.setOutdoorOutRemark(qequmodel.getOutdoorOutRemark());
		qequ.setWgTesRemark(qequmodel.getWgTesRemark());
		qequ.setWgPesRemark(qequmodel.getWgPesRemark());
		qequ.setWgKu1Remark(qequmodel.getWgKu1Remark());
		qequ.setWgKu2Remark(qequmodel.getWgKu2Remark());
		qequ.setWgKu3Remark(qequmodel.getWgKu3Remark());
		qequ.setWgKu4Remark(qequmodel.getWgKu4Remark());
		qequ.setWgRelayKu(qequmodel.getWgRelayKu());

		qequ.setCheckid(upsCheck);
		qequdao.save(qequ);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(qequ.getId());
		return (QEquModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		return qequdao.queryPageByModel(queryModel);
	}

	@Override
	public QEqu findById(String id) {
		return qequdao.findById(id);
	}

	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		return environmentEquipCheckDao.findById(checkid);
	}

	@Override
	public QEquModel update(QEqu qequ, EnvironmentEquipCheck enviroment,
			QEquModel qequmodel) {

		enviroment.setUpdater(qequmodel.getOperator());
		enviroment.setUpdateTime(DateUtilTools.getNowDateTime());
		environmentEquipCheckDao.update(enviroment);

		qequ.setIndoorTesJx(qequmodel.getIndoorTesJx());
		qequ.setIndoorTesNormal(qequmodel.getIndoorTesNormal());
		qequ.setIndoorTesInnormal(qequmodel.getIndoorTesInnormal());
		qequ.setIndoorPesJx(qequmodel.getIndoorPesJx());
		qequ.setIndoorPesNormal(qequmodel.getIndoorPesNormal());
		qequ.setIndoorPesInnormal(qequmodel.getIndoorPesInnormal());
		qequ.setIndoorKu1Jx(qequmodel.getIndoorKu1Jx());
		qequ.setIndoorKu1Normal(qequmodel.getIndoorKu1Normal());
		qequ.setIndoorKu1Innormal(qequmodel.getIndoorKu1Innormal());
		qequ.setIndoorKu2Jx(qequmodel.getIndoorKu2Jx());
		qequ.setIndoorKu2Normal(qequmodel.getIndoorKu2Normal());
		qequ.setIndoorKu2Innormal(qequmodel.getIndoorKu2Innormal());
		qequ.setIndoorKu3Jx(qequmodel.getIndoorKu3Jx());
		qequ.setIndoorKu3Normal(qequmodel.getIndoorKu3Normal());
		qequ.setIndoorKu3Innormal(qequmodel.getIndoorKu3Innormal());
		qequ.setIndoorKu4Jx(qequmodel.getIndoorKu4Jx());
		qequ.setIndoorKu4Normal(qequmodel.getIndoorKu4Normal());
		qequ.setIndoorKu4Innormal(qequmodel.getIndoorKu4Innormal());
		qequ.setIndoorKuJx(qequmodel.getIndoorKuJx());
		qequ.setIndoorKuNormal(qequmodel.getIndoorKuNormal());
		qequ.setIndoorKuInnormal(qequmodel.getIndoorKuInnormal());
		qequ.setIndoorComJx(qequmodel.getIndoorComJx());
		qequ.setIndoorComNormal(qequmodel.getIndoorComNormal());
		qequ.setIndoorComInnormal(qequmodel.getIndoorComInnormal());
		qequ.setSlhTesJx(qequmodel.getSlhTesJx());
		qequ.setSlhTesNormal(qequmodel.getSlhTesNormal());
		qequ.setSlhTesInnormal(qequmodel.getSlhTesInnormal());
		qequ.setMhjTesJx(qequmodel.getMhjTesJx());
		qequ.setMhjTesNormal(qequmodel.getMhjTesNormal());
		qequ.setMhjTesInnormal(qequmodel.getMhjTesInnormal());
		qequ.setSlhKuJx(qequmodel.getSlhKuJx());
		qequ.setSlhKuNormal(qequmodel.getSlhKuNormal());
		qequ.setSlhKuInnormal(qequmodel.getSlhKuInnormal());
		qequ.setMhjKuJx(qequmodel.getMhjKuJx());
		qequ.setMhjKuNormal(qequmodel.getMhjKuNormal());
		qequ.setMhjKuInnormal(qequmodel.getMhjKuInnormal());
		qequ.setKuTestJx(qequmodel.getKuTestJx());
		qequ.setKuTestNormal(qequmodel.getKuTestNormal());
		qequ.setKuTestInnormal(qequmodel.getKuTestInnormal());

		qequ.setOutdoorTesJx(qequmodel.getOutdoorTesJx());
		qequ.setOutdoorTesNormal(qequmodel.getOutdoorTesNormal());
		qequ.setOutdoorTesInnormal(qequmodel.getOutdoorTesInnormal());
		qequ.setOutdoorPesJx(qequmodel.getOutdoorPesJx());
		qequ.setOutdoorPesNormal(qequmodel.getOutdoorPesNormal());
		qequ.setOutdoorPesInnormal(qequmodel.getOutdoorPesInnormal());
		qequ.setOutdoorKuJx(qequmodel.getOutdoorKuJx());
		qequ.setOutdoorKuNormal(qequmodel.getOutdoorKuNormal());
		qequ.setOutdoorKuInnormal(qequmodel.getOutdoorKuInnormal());
		qequ.setOutdoorComJx(qequmodel.getOutdoorComJx());
		qequ.setOutdoorComNormal(qequmodel.getOutdoorComNormal());
		qequ.setOutdoorComInnormal(qequmodel.getOutdoorComInnormal());
		qequ.setOutdoorSlhtesJx(qequmodel.getOutdoorSlhtesJx());
		qequ.setOutdoorSlhtesNormal(qequmodel.getOutdoorSlhtesNormal());
		qequ.setOutdoorSlhtesInnormal(qequmodel.getOutdoorSlhtesInnormal());
		qequ.setOutdoorMhjtesJx(qequmodel.getOutdoorMhjtesJx());
		qequ.setOutdoorMhjtesNormal(qequmodel.getOutdoorMhjtesNormal());
		qequ.setOutdoorMhjtesInnormal(qequmodel.getOutdoorMhjtesInnormal());
		qequ.setOutdoorSlhkuJx(qequmodel.getOutdoorSlhkuJx());
		qequ.setOutdoorSlhkuNormal(qequmodel.getOutdoorSlhkuNormal());
		qequ.setOutdoorSlhkuInnormal(qequmodel.getOutdoorSlhkuInnormal());
		qequ.setOutdoorMhjkuJx(qequmodel.getOutdoorMhjkuJx());
		qequ.setOutdoorMhjkuNormal(qequmodel.getOutdoorMhjkuNormal());
		qequ.setOutdoorMhjkuInnormal(qequmodel.getOutdoorMhjkuInnormal());
		qequ.setOutdoorKucsJx(qequmodel.getOutdoorKucsJx());
		qequ.setOutdoorKucsNormal(qequmodel.getOutdoorKucsNormal());
		qequ.setOutdoorKucsInnormal(qequmodel.getOutdoorKucsInnormal());

		qequ.setWgTesJx(qequmodel.getWgTesJx());
		qequ.setWgTesNormal(qequmodel.getWgTesNormal());
		qequ.setWgTesInnormal(qequmodel.getWgTesInnormal());
		qequ.setWgPesJx(qequmodel.getWgPesJx());
		qequ.setWgPesNormal(qequmodel.getWgPesNormal());
		qequ.setWgPesInnormal(qequmodel.getWgPesInnormal());
		qequ.setWgKu1Jx(qequmodel.getWgKu1Jx());
		qequ.setWgKu1Normal(qequmodel.getWgKu1Normal());
		qequ.setWgKu1Innormal(qequmodel.getWgKu1Innormal());
		qequ.setWgKu2Jx(qequmodel.getWgKu2Jx());
		qequ.setWgKu2Normal(qequmodel.getWgKu2Normal());
		qequ.setWgKu2Innormal(qequmodel.getWgKu2Innormal());
		qequ.setWgKu3Jx(qequmodel.getWgKu3Jx());
		qequ.setWgKu3Normal(qequmodel.getWgKu3Normal());
		qequ.setWgKu3Innormal(qequmodel.getWgKu3Innormal());
		qequ.setWgKu4Jx(qequmodel.getWgKu4Jx());
		qequ.setWgKu4Normal(qequmodel.getWgKu4Normal());
		qequ.setWgKu4Innormal(qequmodel.getWgKu4Innormal());
		qequ.setWgKuJx(qequmodel.getWgKuJx());
		qequ.setWgKuNormal(qequmodel.getWgKuNormal());
		qequ.setWgKuInnormal(qequmodel.getWgKuInnormal());

		qequ.setIndoorTesRemark(qequmodel.getIndoorTesRemark());
		qequ.setIndoorPesRemark(qequmodel.getIndoorPesRemark());
		qequ.setIndoorKu1Remark(qequmodel.getIndoorKu1Remark());
		qequ.setIndoorKu2Remark(qequmodel.getIndoorKu2Remark());
		qequ.setIndoorKu3Remark(qequmodel.getIndoorKu3Remark());
		qequ.setIndoorKu4Remark(qequmodel.getIndoorKu4Remark());
		qequ.setIndoorRelayRemark(qequmodel.getIndoorRelayRemark());
		qequ.setIndoorOutRemark(qequmodel.getIndoorOutRemark());
		qequ.setIndoorSlhTes(qequmodel.getIndoorSlhTes());
		qequ.setIndoorMhjTes(qequmodel.getIndoorMhjTes());
		qequ.setIndoorSlhKu(qequmodel.getIndoorSlhKu());
		qequ.setIndoorMhjKu(qequmodel.getIndoorMhjKu());
		qequ.setIndoorKuTest(qequmodel.getIndoorKuTest());
		qequ.setOutdoorTesRemark(qequmodel.getOutdoorTesRemark());
		qequ.setOutdoorPesRemark(qequmodel.getOutdoorPesRemark());
		qequ.setOutdoorKuRemark(qequmodel.getOutdoorKuRemark());
		qequ.setOutdoorSlhTes(qequmodel.getOutdoorSlhTes());
		qequ.setOutdoorMhjTes(qequmodel.getOutdoorMhjTes());
		qequ.setOutdoorSlhKu(qequmodel.getOutdoorSlhKu());
		qequ.setOutdoorMhjKu(qequmodel.getOutdoorMhjKu());
		qequ.setOutdoorKuTest(qequmodel.getOutdoorKuTest());
		qequ.setOutdoorOutRemark(qequmodel.getOutdoorOutRemark());
		qequ.setWgTesRemark(qequmodel.getWgTesRemark());
		qequ.setWgPesRemark(qequmodel.getWgPesRemark());
		qequ.setWgKu1Remark(qequmodel.getWgKu1Remark());
		qequ.setWgKu2Remark(qequmodel.getWgKu2Remark());
		qequ.setWgKu3Remark(qequmodel.getWgKu3Remark());
		qequ.setWgKu4Remark(qequmodel.getWgKu4Remark());
		qequ.setWgRelayKu(qequmodel.getWgRelayKu());

		qequdao.update(qequ);

		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(qequ.getId());
		return (QEquModel) queryPageByModel(qm).getResult().get(0);

	}

	@Override
	public void delete(QEqu qequ, EnvironmentEquipCheck enviroment) {
		environmentEquipCheckDao.delete(enviroment);
		qequdao.delete(qequ);
	}

}
