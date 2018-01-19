package cn.com.atnc.ioms.dao.duty.satellitemqy;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satellite.OutsideEquipCheck;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;

/**
 * 室外设备巡检
 * 数据库接口
 *
 * @author 段衍林
 * @2016年11月17日 下午3:11:17
 */
public interface OutSideEquipCheckDao extends IBaseDao<OutsideEquipCheck>{

	
	/** 
	 * 分页查询
	 * @author 段衍林
	 * @2016年11月17日 下午3:12:02
	 * @param queryModel 查询model
	 * @return 
	 * Pagination
	 */
	Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel);
}
