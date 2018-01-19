package cn.com.atnc.ioms.mng.duty.statellite.Impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satellite.day.DsPesTesLinkDao;
import cn.com.atnc.ioms.entity.duty.satellite.DsPesTesLink;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteDayAutoType;
import cn.com.atnc.ioms.mng.duty.statellite.DsPesTesLinkService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.DsPesTesLinkModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 东四-PES-TES链路工作状态 业务层接口实现类
 *
 * @author 段衍林
 * @2016年11月16日 下午3:00:58
 */
@Transactional
@Service("dsPesTesLinkService")
public class DsPesTesLinkServiceImpl implements DsPesTesLinkService {

	@Autowired
	private DsPesTesLinkDao dsPesTesLinkDao;

	/**
	 * 保存或更新
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public DsPesTesLink saveOrUpdate(DsPesTesLinkModel dsPesTesLinkModel)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		// 声明实体
		DsPesTesLink dsPesTesLink = dsPesTesLinkDao.findById(dsPesTesLinkModel
				.getId());
		if (!ObjectUtils.equals(dsPesTesLink, null)) {
			// 记录时间
			dsPesTesLinkModel.setCheckTime(dsPesTesLink.getCheckTime());
			// 记录人
			dsPesTesLinkModel.setOperator(dsPesTesLink.getOperator());
			// 设备名称
			dsPesTesLinkModel.setEquipName(dsPesTesLink.getEquipName());
			// 更新操作人
			dsPesTesLinkModel.setUpdater(dsPesTesLinkModel.getOperator());
		} else {
			dsPesTesLink = new DsPesTesLink();
			// 记录时间
			dsPesTesLinkModel.setCheckTime(DateUtilTools.getNowDateTime());
			dsPesTesLinkModel.setEquipName(SatelliteDayAutoType.dsPES);
		}
		// 赋值
		PropertyUtils.copyProperties(dsPesTesLink, dsPesTesLinkModel);
		// 添加创建时间
		dsPesTesLink.setUpdateTime(DateUtilTools.getNowDateTime());
		// 数据库保存
		dsPesTesLinkDao.saveOrUpdate(dsPesTesLink);
		return dsPesTesLink;
	}

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		// 分页查询
		return dsPesTesLinkDao.queryPageByModel(queryModel);
	}

	@Override
	public DsPesTesLink findById(String id) {
		// 根据id查询
		return dsPesTesLinkDao.findById(id);
	}

	/**
	 * 删除
	 */
	public void delete(DsPesTesLinkModel dsPesTesLinkModel) {
		// 非空验证
		if (StringUtils.isNotEmpty(dsPesTesLinkModel.getId())) {
			// 取实体
			DsPesTesLink dsPesTesLink = dsPesTesLinkDao
					.findById(dsPesTesLinkModel.getId());
			// 删除实体
			dsPesTesLinkDao.delete(dsPesTesLink);
		}
	}
}
