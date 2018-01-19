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
import cn.com.atnc.ioms.dao.duty.satelliteauto.day.SatTxjdOverseaCDMDao;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdOverseaCdm;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteDayAutoType;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatTxjdOverseaCDMService;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatTxjdOverseaCdmModel;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 通信基地-境外站-主站CDM570 业务层接口实现类
 *
 * @author 段衍林
 * @2016年11月11日 下午4:05:23
 */
@Transactional
@Service("satTxjdOverseaCdmService")
public class SatTxjdOverseaCDMServiceImpl implements SatTxjdOverseaCDMService {

	@Autowired
	private SatTxjdOverseaCDMDao satTxjdOverseaCDMDao;

	/**
	 * 通信基地-境外站-主站CDM570 卫星日检自检分页查询 实现类
	 * 
	 * @author 段衍林
	 * @2016年11月11日 下午4:05:23
	 * @param queryModel
	 * @return Pagination
	 */
	public Pagination queryPageByModel(SatelliteAutoModel queryModel) {
		return satTxjdOverseaCDMDao.queryPageByModel(queryModel);
	}

	/**
	 * 冒泡查询
	 */
	public int getAjaxLoad() {
		// 获取全部列表
		List<SatTxjdOverseaCdm> cdms = satTxjdOverseaCDMDao.getAll();
		// 返回列表size
		return CollectionUtils.isNotEmpty(cdms) ? cdms.size() : 0;

	}

	/**
	 * 保存或更新
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public SatTxjdOverseaCdm saveOrUpdate(SatTxjdOverseaCdmModel cdm)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		SatTxjdOverseaCdm satTxjdOverseaCdm = satTxjdOverseaCDMDao.findById(cdm
				.getId());
		if (!ObjectUtils.equals(satTxjdOverseaCdm, null)) {
			/**
			 * 原纪录的巡检时间和操作人，设备名称--赋值在model中
			 */
			// 记录时间
			cdm.setCheckTime(satTxjdOverseaCdm.getCheckTime());
			// 记录人
			cdm.setOperator(satTxjdOverseaCdm.getOperator());
			// 设备名称
			cdm.setEquipName(satTxjdOverseaCdm.getEquipName());
		} else {
			satTxjdOverseaCdm = new SatTxjdOverseaCdm();
			// 记录时间
			cdm.setCheckTime(DateUtilTools.getNowDateTime());
			// 设备名称
			cdm.setEquipName(SatelliteDayAutoType.txjdOverseaCDM);
		}
		// 实体赋值
		PropertyUtils.copyProperties(satTxjdOverseaCdm, cdm);
		// 记录时间
		satTxjdOverseaCdm.setUpdateTime(DateUtilTools.getNowDateTime());
		// 保存或更新
		satTxjdOverseaCDMDao.saveOrUpdate(satTxjdOverseaCdm);
		return satTxjdOverseaCdm;
	}

	/**
	 * 删除
	 */
	public void delete(SatTxjdOverseaCdmModel cdm) {
		try {
			// 实体查询
			SatTxjdOverseaCdm satTxjdOverseaCdm = satTxjdOverseaCDMDao
					.findById(cdm.getId());
			// 非空验证
			if (!ObjectUtils.equals(satTxjdOverseaCdm, null)) {
				// 删除
				satTxjdOverseaCDMDao.delete(satTxjdOverseaCdm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
