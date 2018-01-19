package cn.com.atnc.ioms.dao.duty.satellite.day;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satellite.SlhDataState;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;

public interface SlhDataStateDao extends IBaseDao<SlhDataState> {

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
	 * @2016年11月18日 下午1:12:24
	 * @param queryModel
	 * @return List<SlhDataState>
	 */
	List<SlhDataState> queryList(EnvironmentCheckQueryModel queryModel);
}