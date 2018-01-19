package cn.com.atnc.ioms.dao.duty.satelliteauto.day;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdKuDay;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;

/**
 * 通信基地-KU卫星专业日检
 * 数据库接口
 *
 * @author 段衍林
 * @2016年11月11日 下午1:14:03
 */
public interface SatTxjdKuDayDao extends IBaseDao<SatTxjdKuDay> {

	/**
	 * 通信基地-KU卫星专业日检
	 * 分页查询
	 * @author 段衍林
	 * @2016年11月10日 下午1:32:29
	 * @param queryModel 卫星自检model
	 * @return
	 * Pagination
	 */
	Pagination queryPageByModel(SatelliteAutoModel queryModel);
}
