package cn.com.atnc.ioms.mng.duty.statellite.day.tes;

import java.lang.reflect.InvocationTargetException;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdProState;
import cn.com.atnc.ioms.enums.duty.satellite.SatelliteCheckContent;
import cn.com.atnc.ioms.model.duty.statellite.day.SatelliteBaseQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TxjdProStateModel;

/**
 * 通信基地-TES-TES网管进程状态service接口
 *
 * @author 段衍林
 * @2017年2月13日 下午4:02:05
 */
public interface ITxjdProStateService {

	/**
	 * 分页查询
	 * 
	 * @author 段衍林
	 * @2017年2月13日 下午4:02:43
	 * @param queryModel
	 *            查询model
	 * @return Pagination 返回分页
	 */
	Pagination queryPage(SatelliteBaseQueryModel queryModel);

	/**
	 * 保存
	 * 
	 * @author 段衍林
	 * @2017年2月13日 下午4:04:45
	 * @param txjdProStateModel
	 *            实体model
	 * @param operator
	 *            操作人
	 * @param content
	 *            操作内容
	 * @return TxjdProState 返回值
	 * @throws IllegalAccessException
	 *             异常
	 * @throws InvocationTargetException
	 *             异常
	 * @throws NoSuchMethodException
	 *             异常
	 * 
	 */
	TxjdProState save(TxjdProStateModel txjdProStateModel, User operator,
			SatelliteCheckContent content) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException;

	/**
	 * 删除
	 * 
	 * @author 段衍林
	 * @2017年2月13日 下午4:05:42
	 * @param id
	 *            巡检内容id void
	 */
	void delete(String id);

	/**
	 * 根据id查找
	 * 
	 * @author 段衍林
	 * @2017年2月13日 下午4:06:00
	 * @param id
	 *            实体id
	 * @return TxjdProState 返回实体
	 */
	TxjdProState findById(String id);

	/**
	 * 实体更新
	 * 
	 * @author 段衍林
	 * @2017年2月13日 下午4:06:46
	 * @param txjdProStateModel
	 *            操作model
	 * @param operator
	 *            操作人
	 * @return TxjdProState 返回实体
	 */
	TxjdProState update(TxjdProStateModel txjdProStateModel, User operator);
}
