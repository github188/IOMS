package cn.com.atnc.ioms.dao.duty.environment;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.environment.ups.UpsContentCheck;
import cn.com.atnc.ioms.model.clientmng.query.ClientQueryModel;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;

/**
 * 环境设备巡检Dao
 * @author renyujuan
 * @date 2016年7月7日上午9:18:50
 */
public interface EnvironmentEquipCheckDao extends IBaseDao<EnvironmentEquipCheck> {
	
	/**
	 * 根据条件model查询ups设备巡检记录,并封装为分页对象
	 * @author renyujuan
	 * @date 2016年7月7日上午9:22:47
	 * @param queryModel
	 * @return
	 */
	
	Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel);

	List<EnvironmentEquipCheck> queryListByModel(EnvironmentCheckQueryModel queryModel);

	List<UpsContentCheck> upsContentCheckList(EnvironmentCheckQueryModel queryModel);
}
