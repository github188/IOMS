package cn.com.atnc.ioms.mng.duty.statellitemqy.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.TesEquDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.TesEqu;
import cn.com.atnc.ioms.mng.duty.statellitemqy.TesEquService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.TesEquModel;
import cn.com.atnc.ioms.util.DateUtilTools;

@Transactional
@Service("TesEquService")
public class TesEquServiceImpl implements TesEquService {

	@Autowired
	private EnvironmentEquipCheckDao environmentEquipCheckDao;
	@Autowired
	private TesEquDao tesequdao;

	@Override
	public TesEqu save(TesEquModel tesequmodel) {

		// 新建实体
		TesEqu tesequ = new TesEqu();
		tesequ.setOperator(tesequmodel.getOperator());
		tesequ.setCheckDate(DateUtilTools.getNowDate());
		tesequ.setCheckTime(DateUtilTools.getNowDateTime());
		tesequ.setCheckType(tesequmodel.getCheckType());
		tesequ.setOptType(tesequmodel.getOptType());

		tesequ.setN1001(tesequmodel.getN1001());
		tesequ.setN1002(tesequmodel.getN1002());
		tesequ.setN1003(tesequmodel.getN1003());
		tesequ.setN1004(tesequmodel.getN1004());
		tesequ.setN100a(tesequmodel.getN100a());
		tesequ.setN100c(tesequmodel.getN100c());
		tesequ.setN1007(tesequmodel.getN1007());
		tesequ.setN1008(tesequmodel.getN1008());
		tesequ.setN1009(tesequmodel.getN1009());
		tesequ.setN100b(tesequmodel.getN100b());
		tesequ.setN100d(tesequmodel.getN100d());
		tesequ.setN100e(tesequmodel.getN100e());
		tesequ.setN100f(tesequmodel.getN100f());
		tesequ.setN1010(tesequmodel.getN1010());
		tesequ.setN1011(tesequmodel.getN1011());
		tesequ.setN1012(tesequmodel.getN1012());

		tesequ.setS1001(tesequmodel.getS1001());
		tesequ.setS1002(tesequmodel.getS1002());
		tesequ.setS1003(tesequmodel.getS1003());
		tesequ.setS1004(tesequmodel.getS1004());
		tesequ.setS1007(tesequmodel.getS1007());
		tesequ.setS1008(tesequmodel.getS1008());
		tesequ.setS1009(tesequmodel.getS1009());
		tesequ.setS100a(tesequmodel.getS100a());
		tesequ.setS100b(tesequmodel.getS100b());
		tesequ.setS100c(tesequmodel.getS100c());
		tesequ.setS100d(tesequmodel.getS100d());
		tesequ.setS100e(tesequmodel.getS100e());
		tesequ.setS100f(tesequmodel.getS100f());
		tesequ.setS1010(tesequmodel.getS1010());
		tesequ.setS1011(tesequmodel.getS1011());
		tesequ.setS1012(tesequmodel.getS1012());
		tesequdao.save(tesequ);
		// 重新赋值
		return tesequ;
		
	}

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		return tesequdao.queryPageByModel(queryModel);
	}

	@Override
	public TesEqu findById(String id) {
		return tesequdao.findById(id);
	}

	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		return environmentEquipCheckDao.findById(checkid);
	}

	@Override
	public TesEqu update(TesEqu tesequ, TesEquModel tesequmodel) {
		//更新数据
		tesequ.setUpdater(tesequmodel.getOperator());
		tesequ.setUpdateTime(DateUtilTools.getNowDateTime());

		tesequ.setN1001(tesequmodel.getN1001());
		tesequ.setN1002(tesequmodel.getN1002());
		tesequ.setN1003(tesequmodel.getN1003());
		tesequ.setN1004(tesequmodel.getN1004());
		tesequ.setN100a(tesequmodel.getN100a());
		tesequ.setN100c(tesequmodel.getN100c());
		tesequ.setN1007(tesequmodel.getN1007());
		tesequ.setN1008(tesequmodel.getN1008());
		tesequ.setN1009(tesequmodel.getN1009());
		tesequ.setN100b(tesequmodel.getN100b());
		tesequ.setN100d(tesequmodel.getN100d());
		tesequ.setN100e(tesequmodel.getN100e());
		tesequ.setN100f(tesequmodel.getN100f());
		tesequ.setN1010(tesequmodel.getN1010());
		tesequ.setN1011(tesequmodel.getN1011());
		tesequ.setN1012(tesequmodel.getN1012());

		tesequ.setS1001(tesequmodel.getS1001());
		tesequ.setS1002(tesequmodel.getS1002());
		tesequ.setS1003(tesequmodel.getS1003());
		tesequ.setS1004(tesequmodel.getS1004());
		tesequ.setS1007(tesequmodel.getS1007());
		tesequ.setS1008(tesequmodel.getS1008());
		tesequ.setS1009(tesequmodel.getS1009());
		tesequ.setS100a(tesequmodel.getS100a());
		tesequ.setS100b(tesequmodel.getS100b());
		tesequ.setS100c(tesequmodel.getS100c());
		tesequ.setS100d(tesequmodel.getS100d());
		tesequ.setS100e(tesequmodel.getS100e());
		tesequ.setS100f(tesequmodel.getS100f());
		tesequ.setS1010(tesequmodel.getS1010());
		tesequ.setS1011(tesequmodel.getS1011());
		tesequ.setS1012(tesequmodel.getS1012());

		tesequdao.update(tesequ);
		return tesequ;
	}

	@Override
	public void delete(TesEqu tesequ) {
		tesequdao.delete(tesequ);
	}

}
