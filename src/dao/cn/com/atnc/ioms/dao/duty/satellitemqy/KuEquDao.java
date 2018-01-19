package cn.com.atnc.ioms.dao.duty.satellitemqy;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satellite.KuEqu;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;

public interface KuEquDao extends IBaseDao<KuEqu> {

	/**
	 * 分页查询
	 * 
	 * @author 段衍林
	 * @2016年12月5日 上午11:16:51
	 * @param queryModel
	 * @return Pagination
	 */
	Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel);
}
