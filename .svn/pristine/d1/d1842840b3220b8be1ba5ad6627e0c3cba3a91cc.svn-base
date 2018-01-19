package cn.com.atnc.ioms.mng.duty.statellite.day.tes.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satellite.day.tes.ITxjdProStateDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdProState;
import cn.com.atnc.ioms.enums.duty.satellite.SatelliteCheckContent;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.ITxjdProStateService;
import cn.com.atnc.ioms.model.duty.statellite.day.SatelliteBaseQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TxjdProStateModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 通信基地-TES-TES网管进程状态service接口实现类
 *
 * @author 段衍林
 * @2017年2月13日 下午4:02:30
 */
@Transactional
@Service("TxjdProStateService")
public class TxjdProStateServiceImpl implements ITxjdProStateService {

	@Autowired
	private ITxjdProStateDao proStateDao;

	/**
	 * 分页
	 */
	@Override
	public Pagination queryPage(SatelliteBaseQueryModel queryModel) {
		return proStateDao.queryPage(queryModel);

	}

	/**
	 * 保存
	 */
	public TxjdProState save(TxjdProStateModel txjdProStateModel,
			User operator, SatelliteCheckContent content)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		// 生成新实体
		TxjdProState txjdProState = new TxjdProState();
		// 实体赋值
		PropertyUtils.copyProperties(txjdProState, txjdProStateModel);
		// 操作人
		txjdProState.setCreater(operator);
		// 创建日期
		txjdProState.setCreateDate(DateUtilTools.getNowDate());
		// 创建时间
		txjdProState.setCreateTime(DateUtilTools.getNowDateTime());
		// 巡检内容
		txjdProState.setCheckContent(content);
		// 保存数据
		proStateDao.save(txjdProState);
		// 返回实体
		return txjdProState;
	}

	/**
	 * 删除
	 */
	public void delete(String id) {
		// 实体查询
		TxjdProState txjdProState = this.findById(id);
		// 删除操作
		proStateDao.delete(txjdProState);
	}

	/**
	 * 实体查询
	 */
	public TxjdProState findById(String id) {
		return proStateDao.findById(id);
	}

	/**
	 * 更新
	 */
	@Override
	public TxjdProState update(TxjdProStateModel txjdProStateModel,
			User operator) {
		// 查询实体
		TxjdProState txjdProState = this.findById(txjdProStateModel.getId());
		// 网管工作站进程081
		txjdProState.setPROCESS_STATE081(txjdProStateModel.getPROCESS_STATE081());
		// 网管工作站进程281
		txjdProState.setPROCESS_STATE281(txjdProStateModel.getPROCESS_STATE281());
		// 网管工作站进程381
		txjdProState.setPROCESS_STATE381(txjdProStateModel.getPROCESS_STATE381());
		// 网管工作站进程481
		txjdProState.setPROCESS_STATE481(txjdProStateModel.getPROCESS_STATE481());
		// 更新操作人
		txjdProState.setUpdater(operator);
		// 更新时间
		txjdProState.setUpdateTime(DateUtilTools.getNowDateTime());
		// 数据更新
		proStateDao.update(txjdProState);
		// 返回实体
		return txjdProState;
	}
}
