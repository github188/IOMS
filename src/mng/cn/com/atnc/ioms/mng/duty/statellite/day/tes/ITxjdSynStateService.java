package cn.com.atnc.ioms.mng.duty.statellite.day.tes;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdSynState;
import cn.com.atnc.ioms.enums.duty.satellite.SatelliteCheckContent;
import cn.com.atnc.ioms.model.duty.statellite.day.SatelliteBaseQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TxjdSynStateModel;

/**
 * 通信基地-TES-查看网管同步状态service接口
 *
 * @author 段衍林
 * @2017年2月16日 上午10:03:51
 */
public interface ITxjdSynStateService {

	/**
	 * 分页查询
	 * 
	 * @author 段衍林
	 * @2017年2月16日 上午9:40:18
	 * @param queryModel
	 *            查询model
	 * @return Pagination 分页
	 */
	Pagination queryPage(SatelliteBaseQueryModel queryModel);

	/**
	 * 保存
	 * 
	 * @author 段衍林
	 * @2017年2月16日 上午9:46:07
	 * @param txjdSynResultModel
	 *            数据集合
	 * @param operator
	 *            操作人
	 * @param content
	 *            巡检内容
	 * @return TxjdSynState 返回实体
	 */
	TxjdSynState save(TxjdSynStateModel txjdSynResultModel, User operator,
			SatelliteCheckContent content);

	/**
	 * 根据id查找实体
	 * 
	 * @author 段衍林
	 * @2017年2月16日 上午9:46:43
	 * @param id
	 *            实体id
	 * @return TxjdSynState 返回值
	 */
	TxjdSynState findById(String id);

	/**
	 * 删除
	 * 
	 * @author 段衍林
	 * @2017年2月16日 上午9:48:07
	 * @param id
	 *            实体id void
	 */
	void delete(String id);

	/**
	 * 更新
	 * 
	 * @author 段衍林
	 * @2017年2月16日 上午9:48:38
	 * @param txjdSynResultModel
	 *            数据model
	 * @param operator
	 *            操作人
	 * @return TxjdSynState 返回值
	 */
	TxjdSynState update(TxjdSynStateModel txjdSynResultModel, User operator);
}
