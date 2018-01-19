package cn.com.atnc.ioms.mng.duty.statelliteauto.day.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satelliteauto.day.SatTxjdOverseaHWDao;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdOverseaHW;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteDayAutoType;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatTxjdOverseaHWService;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatTxjdOverseaHwModel;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 通信基地-境外站-主站华为路由器状态 业务层接口实现类
 *
 * @author 段衍林
 * @2016年11月11日 下午4:05:23
 */
@Transactional
@Service("satTxjdOverseaHWService")
public class SatTxjdOverseaHWServiceImpl implements SatTxjdOverseaHWService {

	@Autowired
	private SatTxjdOverseaHWDao satTxjdOverseaHWDao;

	/**
	 * 通信基地-境外站-主站华为路由器状态 卫星日检自检分页查询 实现类
	 * 
	 * @author 段衍林
	 * @2016年11月11日 下午4:05:23
	 * @param queryModel
	 * @return Pagination
	 */
	public Pagination queryPageByModel(SatelliteAutoModel queryModel) {
		return satTxjdOverseaHWDao.queryPageByModel(queryModel);
	}

	/**
	 * 冒泡查询
	 */
	public int getAjaxLoad() {
		// 获取全部列表
		List<SatTxjdOverseaHW> hws = satTxjdOverseaHWDao.getAll();
		// 返回列表size
		return CollectionUtils.isNotEmpty(hws) ? hws.size() : 0;
	}

	/**
	 * 保存或更新
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public SatTxjdOverseaHW saveOrUpdate(SatTxjdOverseaHwModel hw)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {

		SatTxjdOverseaHW satTxjdOverseaHw = satTxjdOverseaHWDao.findById(hw
				.getId());
		if (!ObjectUtils.equals(satTxjdOverseaHw, null)) {
			/**
			 * 原纪录的巡检时间和操作人，设备名称--赋值在model中
			 */
			// 记录时间
			hw.setCheckTime(satTxjdOverseaHw.getCheckTime());
			// 记录人
			hw.setOperator(satTxjdOverseaHw.getOperator());
			// 设备名称
			hw.setEquipName(satTxjdOverseaHw.getEquipName());
		} else {
			satTxjdOverseaHw = new SatTxjdOverseaHW();
			// 记录时间
			hw.setCheckTime(DateUtilTools.getNowDateTime());
			// 设备名称
			hw.setEquipName(SatelliteDayAutoType.txjdOverseaHW);
		}
		// 实体赋值
		PropertyUtils.copyProperties(satTxjdOverseaHw, hw);
		// 记录时间
		satTxjdOverseaHw.setUpdateTime(DateUtilTools.getNowDateTime());
		// 保存或更新
		satTxjdOverseaHWDao.saveOrUpdate(satTxjdOverseaHw);
		return satTxjdOverseaHw;
	}

	/**
	 * 删除
	 */
	public void delete(SatTxjdOverseaHwModel hw) {
		try {
			// 实体查询
			SatTxjdOverseaHW satTxjdOverseaHw = satTxjdOverseaHWDao.findById(hw
					.getId());
			// 非空验证
			if (!ObjectUtils.equals(satTxjdOverseaHw, null)) {
				// 删除
				satTxjdOverseaHWDao.delete(satTxjdOverseaHw);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
