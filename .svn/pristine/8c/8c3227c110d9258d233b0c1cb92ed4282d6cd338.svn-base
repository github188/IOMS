package cn.com.atnc.ioms.mng.duty.statellitemqy;

import java.lang.reflect.InvocationTargetException;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.Check;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.CheckModel;

/**
 * 仪器仪表服务层接口
 *
 * @author 段衍林
 * @2016年11月21日 上午11:24:29
 */
public interface CheckService {

	/**
	 * 保存
	 * 
	 * @author 段衍林
	 * @2016年11月21日 上午11:24:16
	 * @param checkmodel
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 *             void
	 */
	CheckModel save(CheckModel checkmodel) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException;

	/**
	 * 更新
	 * 
	 * @author 段衍林
	 * @2016年11月21日 上午11:24:08
	 * @param checkmodel
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 *             void
	 */
	CheckModel update(CheckModel checkmodel) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException;

	/**
	 * 显示 分页查询
	 * 
	 * @author 段衍林
	 * @2016年11月21日 上午11:23:56
	 * @param queryModel
	 * @return Pagination
	 */
	Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel);

	/**
	 * 根据id查找TxjdDataState
	 * 
	 * @author shijiyong
	 * @param datastate
	 * @param txjddatastate
	 * @return void
	 * @throws
	 */
	Check findById(String id);

	/**
	 * 根据id查找EnvironmentEquipCheck
	 * 
	 * @author shijiyong
	 * @param datastate
	 * @param txjddatastate
	 * @return void
	 * @throws
	 */
	EnvironmentEquipCheck findByIden(String checkid);

	/**
	 * 删除-仪器仪表数据
	 * 
	 * @author 段衍林
	 * @2016年11月21日 上午11:23:36
	 * @param id
	 *            void
	 */
	void delete(String id);

}
