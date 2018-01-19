package cn.com.atnc.ioms.dao.duty.satellite.day.tes;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdSynResult;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TxjdSynResultQueryModel;

/**
 * 通信基地-TES-查看网管同步状态子级数据库接口
 *
 * @author 段衍林
 * @2017年2月13日 下午4:00:11
 */
public interface ITxjdSynResultDao extends IBaseDao<TxjdSynResult> {

	/**
	 * 列表查询
	 * 
	 * @author 段衍林
	 * @2017年2月16日 上午9:58:47
	 * @param queryModel
	 *            查询model
	 * @return List<TxjdSynResult> 返回列表
	 */
	List<TxjdSynResult> queryList(TxjdSynResultQueryModel queryModel);
}
