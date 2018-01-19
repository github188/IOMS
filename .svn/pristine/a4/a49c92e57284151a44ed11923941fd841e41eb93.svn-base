package cn.com.atnc.ioms.mng.duty.statellite.Impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satellite.day.TxjdRadarLinkDao;
import cn.com.atnc.ioms.entity.duty.satellite.TxjdRadarLink;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteDayAutoType;
import cn.com.atnc.ioms.mng.duty.statellite.TxjdRadarLinkService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.TxjdRadarLinkModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 通信基地雷达广播TES-TES链路工作状态
 *
 * @author 段衍林
 * @2016年11月16日 上午10:21:56
 */
@Transactional
@Service("txjdRadarLinkService")
public class TxjdRadarLinkServiceImpl implements TxjdRadarLinkService {

	@Autowired
	private TxjdRadarLinkDao txjdRadarLinkDao;

	/**
	 * 保存或更新
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public TxjdRadarLink saveOrUpdate(TxjdRadarLinkModel txjdRadarLinkModel)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		// 声明实体
		TxjdRadarLink txjdRadarLink = txjdRadarLinkDao
				.findById(txjdRadarLinkModel.getId());
		if (!ObjectUtils.equals(txjdRadarLink, null)) {
			/**
			 * 原纪录的巡检时间和操作人，设备名称--赋值在model中
			 */
			// 记录时间
			txjdRadarLinkModel.setCheckTime(txjdRadarLink.getCheckTime());
			// 记录人
			txjdRadarLinkModel.setOperator(txjdRadarLink.getOperator());
			// 设备名称
			txjdRadarLinkModel.setEquipName(txjdRadarLink.getEquipName());
			// 更新人
			txjdRadarLinkModel.setUpdater(txjdRadarLinkModel.getOperator());
		} else {
			txjdRadarLink = new TxjdRadarLink();
			// 记录时间
			txjdRadarLinkModel.setCheckTime(DateUtilTools.getNowDateTime());
			// 设备名称
			txjdRadarLinkModel.setEquipName(SatelliteDayAutoType.txjdRadarLink);
		}
		// 赋值
		PropertyUtils.copyProperties(txjdRadarLink, txjdRadarLinkModel);
		// 添加更新时间
		txjdRadarLink.setUpdateTime(DateUtilTools.getNowDateTime());
		// 数据库保存
		txjdRadarLinkDao.saveOrUpdate(txjdRadarLink);
		return txjdRadarLink;
	}

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		// 分页查询
		return txjdRadarLinkDao.queryPageByModel(queryModel);
	}

	@Override
	public TxjdRadarLink findById(String id) {
		// 根据id查询
		return txjdRadarLinkDao.findById(id);
	}

	/**
	 * 删除
	 */
	public void delete(TxjdRadarLinkModel txjdRadarLinkModel) {
		// 非空验证
		if (StringUtils.isNotEmpty(txjdRadarLinkModel.getId())) {
			// 取实体
			TxjdRadarLink txjdRadarLink = txjdRadarLinkDao
					.findById(txjdRadarLinkModel.getId());
			// 删除实体
			txjdRadarLinkDao.delete(txjdRadarLink);
		}
	}
}
