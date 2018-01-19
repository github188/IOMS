package cn.com.atnc.ioms.dao.duty.satellite.day;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satellite.TxjdLinkState;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;

public interface TxjdLinkStateDao extends IBaseDao<TxjdLinkState> {

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
	 * @2016年11月18日 下午1:19:40
	 * @param queryModel
	 * @return List<TxjdLinkState>
	 */
	List<TxjdLinkState> queryList(EnvironmentCheckQueryModel queryModel);
}
