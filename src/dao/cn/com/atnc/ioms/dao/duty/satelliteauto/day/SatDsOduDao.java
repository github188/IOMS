package cn.com.atnc.ioms.dao.duty.satelliteauto.day;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatDsOdu;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;

/**
 * 东四-PES-TES民航局ODU状态
 * 数据库接口
 *
 * @author 段衍林
 * @2016年11月15日 下午1:47:22
 */
public interface SatDsOduDao extends IBaseDao<SatDsOdu> {

	/**
	 * 东四-PES-TES民航局ODU状态
	 * 分页查询卫星自检数据  
	 * @author 段衍林
	 * @2016年11月15日 下午1:47:22
	 * @param queryModel 卫星自检model
	 * @return 分页
	 * Pagination 
	 */
	Pagination queryPageByModel(SatelliteAutoModel queryModel);
}
