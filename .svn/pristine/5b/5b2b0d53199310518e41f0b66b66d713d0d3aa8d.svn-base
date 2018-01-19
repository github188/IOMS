package cn.com.atnc.ioms.mng.duty.statellite.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellite.day.TxjdLinkStateDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.TxjdLinkState;
import cn.com.atnc.ioms.mng.duty.statellite.TxjdLinkStateService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.TxjdLinkStateModel;
import cn.com.atnc.ioms.util.DateUtilTools;

@Transactional
@Service("TxjdLinkStateService")
public class TxjdLinkStateServiceImpl implements TxjdLinkStateService {

	@Autowired
	private TxjdLinkStateDao linkstatedao;
	@Autowired
	private EnvironmentEquipCheckDao equipcheckdao;

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		return linkstatedao.queryPageByModel(queryModel);
	}

	@Override
	public TxjdLinkStateModel save(TxjdLinkStateModel txjdlinkstate) {

		// 公共
		EnvironmentEquipCheck upsCheck = new EnvironmentEquipCheck();
		upsCheck.setOperator(txjdlinkstate.getOperator());
		upsCheck.setCheckTime(DateUtilTools.getNowDateTime());
		upsCheck.setCheckDate(DateUtilTools.getNowDate());
		equipcheckdao.save(upsCheck);

		// 私有
		TxjdLinkState linkstate = new TxjdLinkState();
		linkstate.setLink10071(txjdlinkstate.getLink10071());
		linkstate.setLink10072(txjdlinkstate.getLink10072());
		linkstate.setLink10073(txjdlinkstate.getLink10073());
		linkstate.setLink10074(txjdlinkstate.getLink10074());

		linkstate.setLink10081(txjdlinkstate.getLink10081());
		linkstate.setLink10082(txjdlinkstate.getLink10082());
		linkstate.setLink10083(txjdlinkstate.getLink10083());
		linkstate.setLink10084(txjdlinkstate.getLink10084());

		linkstate.setLink10091(txjdlinkstate.getLink10091());
		linkstate.setLink10092(txjdlinkstate.getLink10092());
		linkstate.setLink10093(txjdlinkstate.getLink10093());
		linkstate.setLink10094(txjdlinkstate.getLink10094());

		linkstate.setLink100a1(txjdlinkstate.getLink100a1());
		linkstate.setLink100a2(txjdlinkstate.getLink100a2());
		linkstate.setLink100a3(txjdlinkstate.getLink100a3());
		linkstate.setLink100a4(txjdlinkstate.getLink100a4());

		linkstate.setLink100f1(txjdlinkstate.getLink100f1());
		linkstate.setLink100f2(txjdlinkstate.getLink100f2());
		linkstate.setLink100f3(txjdlinkstate.getLink100f3());
		linkstate.setLink100f4(txjdlinkstate.getLink100f4());

		linkstate.setLink100111(txjdlinkstate.getLink100111());
		linkstate.setLink100112(txjdlinkstate.getLink100112());
		linkstate.setLink100113(txjdlinkstate.getLink100113());
		linkstate.setLink100114(txjdlinkstate.getLink100114());
		linkstate.setCheckid(upsCheck);
		linkstatedao.save(linkstate);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(linkstate.getId());
		return (TxjdLinkStateModel) queryPageByModel(qm).getResult().get(0);

	}

	@Override
	public TxjdLinkState findById(String id) {
		return linkstatedao.findById(id);
	}

	@Override
	public void delete(TxjdLinkState linkstate, EnvironmentEquipCheck equipcheck) {
		linkstatedao.delete(linkstate);
		equipcheckdao.delete(equipcheck);
	}

	@Override
	public TxjdLinkStateModel update(TxjdLinkState linkstate,
			EnvironmentEquipCheck enviroment,
			TxjdLinkStateModel txjdlinkstatemodel) {

		linkstate.setLink10071(txjdlinkstatemodel.getLink10071());
		linkstate.setLink10072(txjdlinkstatemodel.getLink10072());
		linkstate.setLink10073(txjdlinkstatemodel.getLink10073());
		linkstate.setLink10074(txjdlinkstatemodel.getLink10074());

		linkstate.setLink10081(txjdlinkstatemodel.getLink10081());
		linkstate.setLink10082(txjdlinkstatemodel.getLink10082());
		linkstate.setLink10083(txjdlinkstatemodel.getLink10083());
		linkstate.setLink10084(txjdlinkstatemodel.getLink10084());

		linkstate.setLink10091(txjdlinkstatemodel.getLink10091());
		linkstate.setLink10092(txjdlinkstatemodel.getLink10092());
		linkstate.setLink10093(txjdlinkstatemodel.getLink10093());
		linkstate.setLink10094(txjdlinkstatemodel.getLink10094());

		linkstate.setLink100a1(txjdlinkstatemodel.getLink100a1());
		linkstate.setLink100a2(txjdlinkstatemodel.getLink100a2());
		linkstate.setLink100a3(txjdlinkstatemodel.getLink100a3());
		linkstate.setLink100a4(txjdlinkstatemodel.getLink100a4());

		linkstate.setLink100f1(txjdlinkstatemodel.getLink100f1());
		linkstate.setLink100f2(txjdlinkstatemodel.getLink100f2());
		linkstate.setLink100f3(txjdlinkstatemodel.getLink100f3());
		linkstate.setLink100f4(txjdlinkstatemodel.getLink100f4());

		linkstate.setLink100111(txjdlinkstatemodel.getLink100111());
		linkstate.setLink100112(txjdlinkstatemodel.getLink100112());
		linkstate.setLink100113(txjdlinkstatemodel.getLink100113());
		linkstate.setLink100114(txjdlinkstatemodel.getLink100114());
		linkstatedao.update(linkstate);

		enviroment.setUpdateTime(DateUtilTools.getNowDateTime());
		enviroment.setUpdater(txjdlinkstatemodel.getOperator());
		equipcheckdao.update(enviroment);

		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(linkstate.getId());
		return (TxjdLinkStateModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		return equipcheckdao.findById(checkid);
	}

}
