package cn.com.atnc.ioms.mng.duty.statellite;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.TxjdLinkState;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.TxjdLinkStateModel;

public interface TxjdLinkStateService {

	/**
	 * 显示
	 * 
	 * @author shijiyong
	 * @param queryModel
	 *            查询条件
	 * @return Pagination
	 * @throws
	 */
	Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel);

	/**
	 * 保存
	 * 
	 * @author shijiyong
	 * @param queryModel
	 *            查询条件
	 * @return Pagination
	 * @throws
	 */
	TxjdLinkStateModel save(TxjdLinkStateModel txjdmainstate);

	/**
	 * 根据id查找
	 * 
	 * @author shijiyong
	 * @param queryModel
	 *            查询条件
	 * @return Pagination
	 * @throws
	 */
	TxjdLinkState findById(String id);

	/**
	 * 删除
	 * 
	 * @author shijiyong
	 * @param queryModel
	 *            查询条件
	 * @return Pagination
	 * @throws
	 */
	void delete(TxjdLinkState linkstate, EnvironmentEquipCheck equipcheck);

	/**
	 * 更新
	 * 
	 * @author shijiyong
	 * @param queryModel
	 *            查询条件
	 * @return Pagination
	 * @throws
	 */
	TxjdLinkStateModel update(TxjdLinkState linkstate,
			EnvironmentEquipCheck enviroment,
			TxjdLinkStateModel txjdlinkstatemodel);

	/**
	 * 根据id查找
	 * 
	 * @author shijiyong
	 * @param queryModel
	 *            查询条件
	 * @return Pagination
	 * @throws
	 */
	EnvironmentEquipCheck findByIden(String checkid);

}
