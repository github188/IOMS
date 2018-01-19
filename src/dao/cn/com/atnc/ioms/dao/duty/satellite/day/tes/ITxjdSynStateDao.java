package cn.com.atnc.ioms.dao.duty.satellite.day.tes;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdSynState;
import cn.com.atnc.ioms.model.duty.statellite.day.SatelliteBaseQueryModel;

/**
 * 通信基地-TES-查看网管同步状态父级数据库接口
 *
 * @author 段衍林
 * @2017年2月13日 下午4:00:11
 */
public interface ITxjdSynStateDao extends IBaseDao<TxjdSynState> {

	/**
	 * 分页查询
	 * 
	 * @author 段衍林
	 * @2017年2月13日 下午3:58:08
	 * @param queryModel
	 *            查询model
	 * @return Pagination 返回分页
	 */
	Pagination queryPage(SatelliteBaseQueryModel queryModel);
}
