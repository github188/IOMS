package cn.com.atnc.ioms.mng.duty.statellite.day.tes;

import java.lang.reflect.InvocationTargetException;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdDecCon;
import cn.com.atnc.ioms.enums.duty.satellite.SatelliteCheckContent;
import cn.com.atnc.ioms.model.duty.statellite.day.SatelliteBaseQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TxjdDecConModel;

/**
 * 通信基地-TES-DecServer 连通性service接口
 *
 * @author 段衍林
 * @2017年2月15日 上午9:52:18
 */
public interface ITxjdDecConService {

	/**
	 * 分页查询
	 * 
	 * @author 段衍林
	 * @2017年2月15日 上午9:52:02
	 * @param queryModel
	 *            查询model
	 * @return Pagination 分页
	 */
	Pagination queryPage(SatelliteBaseQueryModel queryModel);

	/**
	 * 保存
	 * 
	 * @author 段衍林
	 * @2017年2月15日 上午9:54:48
	 * @param txjdDecConModel
	 *            实体model
	 * @param operator
	 *            操作人
	 * @param content
	 *            巡检内容
	 * @return TxjdDecCon 返回值
	 * @throws NoSuchMethodException
	 *             异常
	 * @throws InvocationTargetException
	 *             异常
	 * @throws IllegalAccessException
	 *             异常
	 */
	TxjdDecCon save(TxjdDecConModel txjdDecConModel, User operator,
			SatelliteCheckContent content) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException;

	/**
	 * 根据id查找
	 * 
	 * @author 段衍林
	 * @2017年2月15日 上午9:55:20
	 * @param id
	 *            实体id
	 * @return TxjdDecCon 返回值
	 */
	TxjdDecCon findById(String id);

	/**
	 * 根据id删除
	 * 
	 * @author 段衍林
	 * @2017年2月15日 上午10:01:14
	 * @param id
	 *            实体id void
	 */
	void delete(String id);

	/**
	 * 更新操作
	 * 
	 * @author 段衍林
	 * @2017年2月15日 上午9:56:21
	 * @param txjdDecConModel
	 *            实体model
	 * @param user
	 *            操作人
	 * @return TxjdDecCon 返回实体
	 */
	TxjdDecCon update(TxjdDecConModel txjdDecConModel, User user);
}
