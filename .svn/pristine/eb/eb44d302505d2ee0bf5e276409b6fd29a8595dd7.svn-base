package cn.com.atnc.ioms.mng.duty.statellite.day.tes.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satellite.day.tes.IDataStateDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.DataState;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.IDataStateService;
import cn.com.atnc.ioms.model.duty.statellite.day.SatelliteBaseQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.DataStateModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 通信基地-TES-TES网管数据库状态
 *
 * @author 段衍林
 * @2017年2月15日 下午12:43:33
 */
@Transactional
@Service("DataStateService")
public class DataStateServiceImpl implements IDataStateService {

	@Autowired
	private IDataStateDao dataStateDao;

	/**
	 * 分页查询
	 */
	@Override
	public Pagination queryPage(SatelliteBaseQueryModel queryModel) {
		return dataStateDao.queryPage(queryModel);
	}

	/**
	 * 根据id查询实体
	 */
	@Override
	public DataState findById(String id) {
		return dataStateDao.findById(id);
	}

	/**
	 * 更新
	 */
	@Override
	public DataState update(DataStateModel dataStateModel, User operator) {
		// 查询实体
		DataState dataState = this.findById(dataStateModel.getId());
		// 需更新字段赋值
		dataState.setDataState(dataStateModel.getDataState());
		// 更新操作人
		dataState.setUpdater(operator);
		// 更新时间
		dataState.setUpdateTime(DateUtilTools.getNowDateTime());
		// 数据更新
		dataStateDao.update(dataState);
		// 返回实体
		return dataState;
	}

	@Override
	public void delete(String id) {
		// 查询实体
		DataState dataState = this.findById(id);
		// 删除操作
		dataStateDao.delete(dataState);
	}
}
