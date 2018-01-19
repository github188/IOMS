package cn.com.atnc.ioms.mng.duty.statellite.day.tes;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdMainState;
import cn.com.atnc.ioms.model.duty.statellite.day.SatelliteBaseQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TxjdMainStateModel;

/**
 * 通信基地-TES-TES网管工作站主备状态service接口
 *
 * @author 段衍林
 * @2017年2月17日 上午11:09:26
 */
public interface ITxjdMainStateService {

	/**
	 * 分页查询
	 * 
	 * @author 段衍林
	 * @2017年2月13日 下午1:03:34
	 * @param queryModel
	 *            查询model
	 * @return Pagination 分页
	 */
	Pagination queryPage(SatelliteBaseQueryModel queryModel);

	/**
	 * 根据id查询实体
	 * 
	 * @author 段衍林
	 * @2017年2月13日 下午1:04:07
	 * @param id
	 *            实体id
	 * @return TxjdMainState 返回值
	 */
	TxjdMainState findById(String id);

	/**
	 * 实体更新
	 * 
	 * @author 段衍林
	 * @2017年2月13日 下午1:04:41
	 * @param dataStateModel
	 *            实体
	 * @param operator
	 *            更新操作人
	 * @return DataState 返回值
	 */
	TxjdMainState update(TxjdMainStateModel dataStateModel, User operator);

	/**
	 * 实体删除
	 * 
	 * @author 段衍林
	 * @2017年2月13日 下午1:05:06
	 * @param id
	 *            实体id void
	 */
	void delete(String id);

}
