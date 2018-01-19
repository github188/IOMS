package cn.com.atnc.ioms.dao.duty.satelliteauto.day;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatSlhPes;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;

/**
 * 十里河-PES-PES出境载波状态
 * 数据库接口
 *
 * @author 段衍林
 * @2016年11月14日 上午11:16:47
 */
public interface SatSlhPesDao extends IBaseDao<SatSlhPes> {

	/**
	 * 十里河-PES-PES出境载波状态
	 * 分页查询卫星自检数据  
	 * @author 段衍林
	 * @2016年11月14日 上午11:16:54
	 * @param queryModel 卫星自检model
	 * @return 分页
	 * Pagination 
	 */
	Pagination queryPageByModel(SatelliteAutoModel queryModel);
}
