package cn.com.atnc.ioms.mng.duty.statellitemqy.Impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satellitemqy.OutSideEquipCheckDao;
import cn.com.atnc.ioms.entity.duty.satellite.OutsideEquipCheck;
import cn.com.atnc.ioms.enums.duty.satellite.OutSideEquipType;
import cn.com.atnc.ioms.mng.duty.statellitemqy.OutSideEquipCheckService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.OutSideEquipCheckModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 室外设备巡检 实现类
 *
 * @author 段衍林
 * @2016年11月17日 下午3:27:34
 */
@Transactional
@Service("outSideEquipCheckServiceImpl")
public class OutSideEquipCheckServiceImpl implements OutSideEquipCheckService {

	@Autowired
	private OutSideEquipCheckDao outSideEquipCheckDao;

	public OutsideEquipCheck saveOrUpdate(OutSideEquipCheckModel equipModel)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		// 声明实体
		OutsideEquipCheck outsideEquipCheck = outSideEquipCheckDao
				.findById(equipModel.getId());
		if (!ObjectUtils.equals(outsideEquipCheck, null)) {
			// 记录时间
			equipModel.setCheckTime(outsideEquipCheck.getCheckTime());
			// 记录人
			equipModel.setOperator(outsideEquipCheck.getOperator());
			// 记录人
			equipModel.setUpdater(equipModel.getOperator());
			// 添加创建时间
			equipModel.setUpdateTime(DateUtilTools.getNowDateTime());
		} else {
			outsideEquipCheck = new OutsideEquipCheck();
			// 记录时间
			equipModel.setCheckTime(DateUtilTools.getNowDateTime());
		}
		// 赋值
		PropertyUtils.copyProperties(outsideEquipCheck, equipModel);
		// 数据库保存
		outSideEquipCheckDao.saveOrUpdate(outsideEquipCheck);
		return outsideEquipCheck;
	}

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		// tab页
		String optType = queryModel.getOptType();
		// 获取设备枚举类
		OutSideEquipType checkEquip = OutSideEquipType.valueOf(optType);
		// 封装查询条件
		queryModel.setCheckEquip(checkEquip);
		// 分页查询
		return outSideEquipCheckDao.queryPageByModel(queryModel);
	}

	@Override
	public OutsideEquipCheck findById(String id) {
		return outSideEquipCheckDao.findById(id);
	}

	@Override
	public void delete(String id) {
		// 非空验证
		if (StringUtils.isNotEmpty(id)) {
			// 查询实体
			OutsideEquipCheck outsideEquipCheck = outSideEquipCheckDao
					.findById(id);
			// 删除操作
			outSideEquipCheckDao.delete(outsideEquipCheck);
		}
	}
}
