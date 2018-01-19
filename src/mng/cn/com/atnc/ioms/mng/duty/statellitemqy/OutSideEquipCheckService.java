package cn.com.atnc.ioms.mng.duty.statellitemqy;

import java.lang.reflect.InvocationTargetException;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satellite.OutsideEquipCheck;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.OutSideEquipCheckModel;

/**
 * 室外设备巡检 业务层接口
 *
 * @author 段衍林
 * @2016年11月17日 下午3:20:56
 */
public interface OutSideEquipCheckService {

	/**
	 * 保存或更新
	 * 
	 * @author 段衍林
	 * @2016年11月17日 下午3:20:51
	 * @param equipModel
	 *            model void
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	OutsideEquipCheck saveOrUpdate(OutSideEquipCheckModel equipModel)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException;

	/**
	 * 分页查询
	 * 
	 * @author 段衍林
	 * @2016年11月17日 下午3:21:37
	 * @param queryModel
	 *            model
	 * @return Pagination 返回类型
	 */
	Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel);

	/**
	 * 根据id查询实体
	 * 
	 * @author 段衍林
	 * @2016年11月17日 下午3:21:48
	 * @param id
	 *            实体id
	 * @return OutsideEquipCheck
	 */
	OutsideEquipCheck findById(String id);

	/**
	 * 根据id删除实体
	 * 
	 * @author 段衍林
	 * @2016年11月17日 下午3:22:53
	 * @param id
	 *            实体id void
	 */
	void delete(String id);
}
