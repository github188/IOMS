package cn.com.atnc.ioms.mng.duty.statellite.day.tes.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satellite.day.tes.ITxjdDecConDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdDecCon;
import cn.com.atnc.ioms.enums.duty.satellite.SatelliteCheckContent;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.ITxjdDecConService;
import cn.com.atnc.ioms.model.duty.statellite.day.SatelliteBaseQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TxjdDecConModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 通信基地-TES-DecServer 连通性service接口实现类
 *
 * @author 段衍林
 * @2017年2月15日 上午9:57:00
 */
@Transactional
@Service("TxjdDecConService")
public class TxjdDecConServiceImpl implements ITxjdDecConService {

	@Autowired
	private ITxjdDecConDao txjdDecConDao;

	/**
	 * 分页查询
	 */
	@Override
	public Pagination queryPage(SatelliteBaseQueryModel queryModel) {
		return txjdDecConDao.queryPage(queryModel);
	}

	/**
	 * 保存
	 */
	@Override
	public TxjdDecCon save(TxjdDecConModel txjdDecConModel, User operator,
			SatelliteCheckContent content) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {

		TxjdDecCon txjdDecCon = new TxjdDecCon();
		// 实体赋值
		PropertyUtils.copyProperties(txjdDecCon, txjdDecConModel);
		// 巡检内容赋值
		txjdDecCon.setCheckContent(content);
		// 操作人
		txjdDecCon.setCreater(operator);
		// 创建日期
		txjdDecCon.setCreateDate(DateUtilTools.getNowDate());
		// 创建时间
		txjdDecCon.setCreateTime(DateUtilTools.getNowDateTime());
		// 保存数据
		txjdDecConDao.save(txjdDecCon);
		// 返回实体
		return txjdDecCon;

	}

	/**
	 * 查询
	 */
	@Override
	public TxjdDecCon findById(String id) {
		return txjdDecConDao.findById(id);
	}

	@Override
	public void delete(String id) {
		TxjdDecCon txjdDecCon = this.findById(id);
		txjdDecConDao.delete(txjdDecCon);
	}

	@Override
	public TxjdDecCon update(TxjdDecConModel txjdDecConModel, User operator) {

		// 查询实体
		TxjdDecCon txjdDecCon = this.findById(txjdDecConModel.getId());
		// DECServer工作状态连通性08A
		txjdDecCon.setDecServerCon08A(txjdDecConModel.getDecServerCon08A());
		// DECServer工作状态连通性08B
		txjdDecCon.setDecServerCon08B(txjdDecConModel.getDecServerCon08B());
		// DECServer工作状态连通性08C
		txjdDecCon.setDecServerCon08C(txjdDecConModel.getDecServerCon08C());
		// 更新操作人
		txjdDecCon.setUpdater(operator);
		// 更新时间
		txjdDecCon.setUpdateTime(DateUtilTools.getNowDateTime());
		// 数据更新
		txjdDecConDao.update(txjdDecCon);
		// 返回实体
		return txjdDecCon;
	}
}
