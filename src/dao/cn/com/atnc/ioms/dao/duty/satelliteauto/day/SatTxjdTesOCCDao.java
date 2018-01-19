package cn.com.atnc.ioms.dao.duty.satelliteauto.day;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdTesOCC;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;

/**
 * 通信基地-TES-TES OCC状态日检自检
 * 数据库接口
 *
 * @author 段衍林
 * @2016年11月10日 下午1:32:03
 */
public interface SatTxjdTesOCCDao extends IBaseDao<SatTxjdTesOCC> {

	/**
	 * 分页查询occ自检数据  
	 * @author 段衍林
	 * @2016年11月10日 下午1:32:29
	 * @param queryModel 卫星自检model
	 * @return
	 * Pagination
	 */
	Pagination queryPageByModel(SatelliteAutoModel queryModel);
}
