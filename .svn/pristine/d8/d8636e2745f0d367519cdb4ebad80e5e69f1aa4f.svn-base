package cn.com.atnc.ioms.mng.duty.statellite.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellite.day.TxjdConWorkDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.TxjdConWork;
import cn.com.atnc.ioms.mng.duty.statellite.TxjdConWorkService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.TxjdConWorkModel;
import cn.com.atnc.ioms.util.DateUtilTools;

@Transactional
@Service("TxjdConWorkService")
public class TxjdConWorkServiceImpl implements TxjdConWorkService {

	@Autowired
	private TxjdConWorkDao conworkdao;
	@Autowired
	private EnvironmentEquipCheckDao equipcheckdao;

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		return conworkdao.queryPageByModel(queryModel);
	}

	@Override
	public TxjdConWorkModel save(TxjdConWorkModel conwork) {
		// 公共类保存
		EnvironmentEquipCheck upsCheck = new EnvironmentEquipCheck();
		upsCheck.setOperator(conwork.getOperator());
		upsCheck.setCheckTime(DateUtilTools.getNowDateTime());
		upsCheck.setCheckDate(DateUtilTools.getNowDate());
		equipcheckdao.save(upsCheck);

		// 私有数据保存
		TxjdConWork txjdconwork = new TxjdConWork();
		txjdconwork.setControl100101(conwork.getControl100101());
		txjdconwork.setControl100102(conwork.getControl100102());
		txjdconwork.setControl100103(conwork.getControl100103());
		txjdconwork.setControl100104(conwork.getControl100104());

		txjdconwork.setControl100201(conwork.getControl100201());
		txjdconwork.setControl100202(conwork.getControl100202());
		txjdconwork.setControl100203(conwork.getControl100203());
		txjdconwork.setControl100204(conwork.getControl100204());

		txjdconwork.setControl100301(conwork.getControl100301());
		txjdconwork.setControl100302(conwork.getControl100302());
		txjdconwork.setControl100303(conwork.getControl100303());
		txjdconwork.setControl100304(conwork.getControl100304());

		txjdconwork.setControl100401(conwork.getControl100401());
		txjdconwork.setControl100402(conwork.getControl100402());
		txjdconwork.setControl100403(conwork.getControl100403());
		txjdconwork.setControl100404(conwork.getControl100404());
		txjdconwork.setCheckid(upsCheck);
		conworkdao.save(txjdconwork);

		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(txjdconwork.getId());
		return (TxjdConWorkModel) queryPageByModel(qm).getResult().get(0);

	}

	@Override
	public TxjdConWork findById(String id) {

		return conworkdao.findById(id);
	}

	@Override
	public void delete(TxjdConWork conwork, EnvironmentEquipCheck equipcheck) {
		equipcheckdao.delete(equipcheck);
		conworkdao.delete(conwork);

	}

	@Override
	public TxjdConWorkModel update(TxjdConWork conwork,
			EnvironmentEquipCheck enviroment, TxjdConWorkModel conworkmodel) {
		//公共类部分更新
		enviroment.setUpdater(conworkmodel.getOperator());
		enviroment.setUpdateTime(DateUtilTools.getNowDateTime());
		equipcheckdao.update(enviroment);

		//私有部分赋值更新
		conwork.setControl100101(conworkmodel.getControl100101());
		conwork.setControl100102(conworkmodel.getControl100102());
		conwork.setControl100103(conworkmodel.getControl100103());
		conwork.setControl100104(conworkmodel.getControl100104());

		conwork.setControl100201(conworkmodel.getControl100201());
		conwork.setControl100202(conworkmodel.getControl100202());
		conwork.setControl100203(conworkmodel.getControl100203());
		conwork.setControl100204(conworkmodel.getControl100204());

		conwork.setControl100301(conworkmodel.getControl100301());
		conwork.setControl100302(conworkmodel.getControl100302());
		conwork.setControl100303(conworkmodel.getControl100303());
		conwork.setControl100304(conworkmodel.getControl100304());

		conwork.setControl100401(conworkmodel.getControl100401());
		conwork.setControl100402(conworkmodel.getControl100402());
		conwork.setControl100403(conworkmodel.getControl100403());
		conwork.setControl100404(conworkmodel.getControl100404());
		conworkdao.update(conwork);

		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(conwork.getId());
		return (TxjdConWorkModel) queryPageByModel(qm).getResult().get(0);

	}

	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		return equipcheckdao.findById(checkid);
	}

}
