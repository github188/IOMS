package cn.com.atnc.ioms.dao.duty.satelliteauto.day;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdOverseaHW;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;

/**
 * 通信基地-境外站-主站华为路由器状态
 * dao层接口
 *
 * @author 段衍林
 * @2016年11月11日 下午4:01:45
 */
public interface SatTxjdOverseaHWDao extends IBaseDao<SatTxjdOverseaHW> {

	/**
	 * 通信基地-境外站-主站华为路由器状态
	 * 分页查询
	 * @author 段衍林
	 * @2016年11月11日 下午4:01:45
	 * @param queryModel 卫星自检model
	 * @return
	 * Pagination
	 */
	Pagination queryPageByModel(SatelliteAutoModel queryModel);
}
