package cn.com.atnc.ioms.mng.duty.statellite;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.TxjdConWork;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.TxjdConWorkModel;

public interface TxjdConWorkService {
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
	TxjdConWorkModel save(TxjdConWorkModel workcon);

	/**
	 * 根据id查找
	 * 
	 * @author shijiyong
	 * @param queryModel
	 *            查询条件
	 * @return Pagination
	 * @throws
	 */
	TxjdConWork findById(String id);

	/**
	 * 删除
	 * 
	 * @author shijiyong
	 * @param queryModel
	 *            查询条件
	 * @return Pagination
	 * @throws
	 */
	void delete(TxjdConWork conwork, EnvironmentEquipCheck equipcheck);

	/**
	 * 更新
	 * 
	 * @author shijiyong
	 * @param queryModel
	 *            查询条件
	 * @return Pagination
	 * @throws
	 */
	TxjdConWorkModel update(TxjdConWork conwork,
			EnvironmentEquipCheck enviroment, TxjdConWorkModel conworkmodel);

	EnvironmentEquipCheck findByIden(String checkid);

}
