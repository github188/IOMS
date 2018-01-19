package cn.com.atnc.ioms.dao.duty.satellite.day;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satellite.SlhNetCon;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;

public interface SlhNetConDao extends IBaseDao<SlhNetCon> {

	/**
	 * 
	 * @author shijiyong
	 * @param queryModel
	 * @return Pagination
	 * @throws
	 */
	Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel);

	/**
	 * 連表列表查詢
	 * 
	 * @author 段衍林
	 * @2016年11月18日 下午1:15:53
	 * @param queryModel
	 * @return List<SlhNetCon>
	 */
	List<SlhNetCon> queryList(EnvironmentCheckQueryModel queryModel);
}