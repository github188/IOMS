package cn.com.atnc.ioms.dao.duty.satellite.day;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satellite.SlhZpjjState;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;

public interface SlhZpjjStateDao extends IBaseDao<SlhZpjjState> {

	/**
	 * 
	 * @author shijiyong
	 * @param queryModel
	 * @return Pagination
	 * @throws
	 */
	Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel);

	/**
	 * 连表列表查询
	 * 
	 * @author 段衍林
	 * @2016年11月18日 下午1:17:27
	 * @param queryModel
	 * @return List<SlhZpjjState>
	 */
	List<SlhZpjjState> queryList(EnvironmentCheckQueryModel queryModel);
}
