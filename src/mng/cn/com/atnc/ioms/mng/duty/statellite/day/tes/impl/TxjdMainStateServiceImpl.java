package cn.com.atnc.ioms.mng.duty.statellite.day.tes.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satellite.day.tes.ITxjdMainStateDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdMainState;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.ITxjdMainStateService;
import cn.com.atnc.ioms.model.duty.statellite.day.SatelliteBaseQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TxjdMainStateModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 通信基地-TES-TES网管工作站主备状态service接口实现类
 *
 * @author 段衍林
 * @2017年2月17日 上午11:12:00
 */
@Transactional
@Service("TxjdMainsStateService")
public class TxjdMainStateServiceImpl implements ITxjdMainStateService {

	@Autowired
	private ITxjdMainStateDao txjdMainStateDao;

	/**
	 * 分页查询
	 */
	@Override
	public Pagination queryPage(SatelliteBaseQueryModel queryModel) {
		return txjdMainStateDao.queryPage(queryModel);
	}

	/**
	 * 根据id查询实体
	 */
	@Override
	public TxjdMainState findById(String id) {
		return txjdMainStateDao.findById(id);
	}

	/**
	 * 更新
	 */
	@Override
	public TxjdMainState update(TxjdMainStateModel txjdMainStateModel,
			User operator) {
		// 查询实体
		TxjdMainState txjdMainState = this.findById(txjdMainStateModel.getId());
		// 需更新字段赋值TES081
		txjdMainState.setTes081(txjdMainStateModel.getTes081());
		// 需更新字段赋值TES281
		txjdMainState.setTes281(txjdMainStateModel.getTes281());
		// 需更新字段赋值TES381
		txjdMainState.setTes381(txjdMainStateModel.getTes381());
		// 需更新字段赋值TES081
		txjdMainState.setTes481(txjdMainStateModel.getTes481());
		// 更新操作人
		txjdMainState.setUpdater(operator);
		// 更新时间
		txjdMainState.setUpdateTime(DateUtilTools.getNowDateTime());
		// 数据更新
		txjdMainStateDao.update(txjdMainState);
		// 返回实体
		return txjdMainState;
	}

	@Override
	public void delete(String id) {
		// 查询实体
		TxjdMainState txjdMainState = this.findById(id);
		// 删除操作
		txjdMainStateDao.delete(txjdMainState);
	}
}
