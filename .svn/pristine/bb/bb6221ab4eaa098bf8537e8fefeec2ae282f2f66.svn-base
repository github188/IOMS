package cn.com.atnc.ioms.mng.duty.statellitemqy.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.CirDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.Cir;
import cn.com.atnc.ioms.mng.duty.statellitemqy.CirService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.CirModel;
import cn.com.atnc.ioms.util.DateUtilTools;

@Transactional
@Service("CirService")
public class CirServiceImpl implements CirService {

	@Autowired
	private EnvironmentEquipCheckDao environmentEquipCheckDao;
	@Autowired
	private CirDao cirdao;

	@Override
	public CirModel save(CirModel cirmodel) {

		EnvironmentEquipCheck upsCheck = new EnvironmentEquipCheck();
		upsCheck.setOperator(cirmodel.getOperator());
		upsCheck.setCheckTime(DateUtilTools.getNowDateTime());
		upsCheck.setCheckDate(DateUtilTools.getNowDate());
		upsCheck.setCheckType(cirmodel.getCheckType());
		environmentEquipCheckDao.save(upsCheck);

		Cir cir = new Cir();
		cir.setTesBusiness(cirmodel.getTesBusiness());
		cir.setTesFault(cirmodel.getTesFault());
		cir.setPesBusiness(cirmodel.getPesBusiness());
		cir.setPesFault(cirmodel.getPesFault());
		cir.setKu1Business(cirmodel.getKu1Business());
		cir.setKu1Fault(cirmodel.getKu1Fault());
		cir.setKu2Business(cirmodel.getKu2Business());
		cir.setKu2Fault(cirmodel.getKu2Fault());
		cir.setKu3Business(cirmodel.getKu3Business());
		cir.setKu3Fault(cirmodel.getKu3Fault());
		cir.setKuBusiness(cirmodel.getKuBusiness());
		cir.setKuFault(cirmodel.getKuFault());
		cir.setComBusiness(cirmodel.getComBusiness());
		cir.setComFault(cirmodel.getComFault());
		cir.setSlhKuBusiness(cirmodel.getSlhKuBusiness());
		cir.setSlhKuFault(cirmodel.getSlhKuFault());
		cir.setMhjTesBusiness(cirmodel.getMhjTesBusiness());
		cir.setMhjTesFault(cirmodel.getMhjTesFault());
		cir.setMhjKuBusiness(cirmodel.getMhjKuBusiness());
		cir.setMhjKuFault(cirmodel.getMhjKuFault());
		cir.setSumBusiness(cirmodel.getSumBusiness());
		cir.setSumFault(cirmodel.getSumFault());
		cir.setKuNet1Remark(cirmodel.getKuNet1Remark());
		cir.setKuNet2Remark(cirmodel.getKuNet2Remark());
		cir.setKuNet3Remark(cirmodel.getKuNet3Remark());
		cir.setPesRemark(cirmodel.getPesRemark());
		cir.setKuRemark(cirmodel.getKuRemark());
		cir.setComRemark(cirmodel.getComRemark());
		cir.setSlhKuRemark(cirmodel.getSlhKuRemark());
		cir.setMhjTesReamrk(cirmodel.getMhjTesReamrk());
		cir.setMhjKuRemark(cirmodel.getMhjKuRemark());
		cir.setSumRemark(cirmodel.getSumRemark());
		cir.setTesRemark(cirmodel.getTesRemark());

		cir.setCheckid(upsCheck);
		cirdao.save(cir);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(cir.getId());
		return (CirModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		return cirdao.queryPageByModel(queryModel);
	}

	@Override
	public Cir findById(String id) {
		return cirdao.findById(id);
	}

	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		return environmentEquipCheckDao.findById(checkid);
	}

	@Override
	public CirModel update(Cir cir, EnvironmentEquipCheck enviroment,
			CirModel cirmodel) {
		enviroment.setUpdater(cirmodel.getOperator());
		enviroment.setUpdateTime(DateUtilTools.getNowDateTime());
		environmentEquipCheckDao.update(enviroment);

		cir.setTesBusiness(cirmodel.getTesBusiness());
		cir.setTesFault(cirmodel.getTesFault());
		cir.setPesBusiness(cirmodel.getPesBusiness());
		cir.setPesFault(cirmodel.getPesFault());
		cir.setKu1Business(cirmodel.getKu1Business());
		cir.setKu1Fault(cirmodel.getKu1Fault());
		cir.setKu2Business(cirmodel.getKu2Business());
		cir.setKu2Fault(cirmodel.getKu2Fault());
		cir.setKu3Business(cirmodel.getKu3Business());
		cir.setKu3Fault(cirmodel.getKu3Fault());
		cir.setKuBusiness(cirmodel.getKuBusiness());
		cir.setKuFault(cirmodel.getKuFault());
		cir.setComBusiness(cirmodel.getComBusiness());
		cir.setComFault(cirmodel.getComFault());
		cir.setSlhKuBusiness(cirmodel.getSlhKuBusiness());
		cir.setSlhKuFault(cirmodel.getSlhKuFault());
		cir.setMhjTesBusiness(cirmodel.getMhjTesBusiness());
		cir.setMhjTesFault(cirmodel.getMhjTesFault());
		cir.setMhjKuBusiness(cirmodel.getMhjKuBusiness());
		cir.setMhjKuFault(cirmodel.getMhjKuFault());
		cir.setSumBusiness(cirmodel.getSumBusiness());
		cir.setSumFault(cirmodel.getSumFault());
		cir.setKuNet1Remark(cirmodel.getKuNet1Remark());
		cir.setKuNet2Remark(cirmodel.getKuNet2Remark());
		cir.setKuNet3Remark(cirmodel.getKuNet3Remark());
		cir.setPesRemark(cirmodel.getPesRemark());
		cir.setKuRemark(cirmodel.getKuRemark());
		cir.setComRemark(cirmodel.getComRemark());
		cir.setSlhKuRemark(cirmodel.getSlhKuRemark());
		cir.setMhjTesReamrk(cirmodel.getMhjTesReamrk());
		cir.setMhjKuRemark(cirmodel.getMhjKuRemark());
		cir.setSumRemark(cirmodel.getSumRemark());
		cir.setTesRemark(cirmodel.getTesRemark());

		cirdao.update(cir);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(cir.getId());
		return (CirModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public void delete(Cir cir, EnvironmentEquipCheck enviroment) {
		environmentEquipCheckDao.delete(enviroment);
		cirdao.delete(cir);
	}

}
