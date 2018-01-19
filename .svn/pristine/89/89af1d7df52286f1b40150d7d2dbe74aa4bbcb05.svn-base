package cn.com.atnc.ioms.mng.duty.statellitemqy.Impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.CheckDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.Check;
import cn.com.atnc.ioms.enums.duty.environment.SatelliteEquip;
import cn.com.atnc.ioms.mng.duty.statellitemqy.CheckService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.CheckModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 仪器仪表接口实现类
 *
 * @author 段衍林
 * @2016年11月21日 上午11:24:57
 */
@Transactional
@Service("CheckService")
public class CheckServiceImpl implements CheckService {

	@Autowired
	private EnvironmentEquipCheckDao environmentEquipCheckDao;
	@Autowired
	private CheckDao checkDao;

	@Override
	public CheckModel save(CheckModel checkmodel)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {

		// 保存公用类
		EnvironmentEquipCheck upsCheck = new EnvironmentEquipCheck();
		// 设备名称
		upsCheck.setName(SatelliteEquip.SateInstruments.getValue());
		// 保存操作人
		upsCheck.setOperator(checkmodel.getOperator());
		// 保存操作时间
		upsCheck.setCheckTime(DateUtilTools.getNowDateTime());
		// 保存操作日期
		upsCheck.setCheckDate(DateUtilTools.getNowDate());
		// 保存操作类型
		upsCheck.setCheckType(checkmodel.getCheckType());
		// 保存实体
		environmentEquipCheckDao.save(upsCheck);
		// 生成实体
		Check check = new Check();
		// 实体赋值
		PropertyUtils.copyProperties(check, checkmodel);
		// 取计算total的集合
		List<String> nums = checkmodel.getNums();
		// 全局变量，total
		Long total = 0L;
		// 计算
		for (int i = 0; i < nums.size(); i++) {
			// 非空验证
			if (StringUtils.isNotEmpty(nums.get(i))) {
				// 格式转换
				Long num = Long.parseLong(nums.get(i));
				total += num;
			}
		}
		// 赋值
		check.setTotal(String.valueOf(total));
		// 绑定公共存储类
		check.setCheckid(upsCheck);
		// 保存或更新
		checkDao.saveOrUpdate(check);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(check.getId());
		return (CheckModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public CheckModel update(CheckModel checkmodel)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		// 生成实体
		Check check = checkDao.findById(checkmodel.getId());
		// 获取绑定实体
		EnvironmentEquipCheck upsCheck = check.getCheckid();
		// 保存操作人
		upsCheck.setUpdater(checkmodel.getOperator());
		// 保存操作时间
		upsCheck.setUpdateTime(DateUtilTools.getNowDateTime());
		// 更新实体
		environmentEquipCheckDao.update(upsCheck);

		// 实体赋值
		PropertyUtils.copyProperties(check, checkmodel);
		// 取计算total的集合
		List<String> nums = checkmodel.getNums();
		// 全局变量，total
		Long total = 0L;
		// 计算
		for (int i = 0; i < nums.size(); i++) {
			// 非空验证
			if (StringUtils.isNotEmpty(nums.get(i))) {
				// 格式转换
				Long num = Long.parseLong(nums.get(i));
				total += num;
			}
		}
		// 赋值
		check.setTotal(String.valueOf(total));
		// 绑定设备统计表
		check.setCheckid(upsCheck);
		// 保存或更新
		checkDao.update(check);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(check.getId());
		return (CheckModel) queryPageByModel(qm).getResult().get(0);
	}

	/**
	 * 分页查询
	 */
	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		return checkDao.queryPageByModel(queryModel);
	}

	/**
	 * 根据id查询
	 */
	@Override
	public Check findById(String id) {
		return checkDao.findById(id);
	}

	/**
	 * 查询公共存储类
	 */
	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		return environmentEquipCheckDao.findById(checkid);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(String id) {
		// 根据id查询check实体
		Check check = this.findById(id);
		// 取绑定实体
		EnvironmentEquipCheck upsCheck = check.getCheckid();
		environmentEquipCheckDao.delete(upsCheck);
		checkDao.delete(check);
	}

}
