package cn.com.atnc.ioms.mng.duty.statellite.day.tes;

import java.lang.reflect.InvocationTargetException;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdWorkCon;
import cn.com.atnc.ioms.enums.duty.satellite.SatelliteCheckContent;
import cn.com.atnc.ioms.model.duty.statellite.day.SatelliteBaseQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TxjdWorkConModel;

public interface ITxjdWorkConService {
	/**
	 * 分页查询
	 * 
	 * @author 段衍林
	 * @2017年2月14日 上午9:55:36
	 * @param queryModel
	 *            查询model
	 * @return Pagination 分页
	 */
	Pagination queryPage(SatelliteBaseQueryModel queryModel);

	/**
	 * 保存
	 * 
	 * @author 段衍林
	 * @2017年2月14日 上午9:57:09
	 * @param txjdWorkConModel
	 *            数据modle
	 * @param operator
	 *            操作人
	 * @param checkContent
	 *            巡检内容
	 * @return TxjdWorkCon 返回实体
	 * @throws NoSuchMethodException
	 *             异常
	 * @throws InvocationTargetException
	 *             异常
	 * @throws IllegalAccessException
	 *             异常
	 */
	TxjdWorkCon save(TxjdWorkConModel txjdWorkConModel, User operator,
			SatelliteCheckContent checkContent) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException;

	/**
	 * 根据id查找
	 * 
	 * @author 段衍林
	 * @2017年2月14日 上午9:57:53
	 * @param id
	 *            实体id
	 * @return TxjdWorkCon 返回值
	 */
	TxjdWorkCon findById(String id);

	/**
	 * 根据id删除
	 * 
	 * @author 段衍林
	 * @2017年2月14日 上午9:58:16
	 * @param id
	 *            实体id void
	 */
	void delete(String id);

	/**
	 * 更新
	 * 
	 * @author 段衍林
	 * @2017年2月14日 上午9:58:46
	 * @param txjdWorkConModel
	 *            数据存储model
	 * @param operator
	 *            操作人
	 * @return TxjdWorkCon 返回实体
	 */
	TxjdWorkCon update(TxjdWorkConModel txjdWorkConModel, User operator);
}
