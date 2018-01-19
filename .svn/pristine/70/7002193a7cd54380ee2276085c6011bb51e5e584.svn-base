package cn.com.atnc.ioms.mng.duty.statellitemqy;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.QEqu;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.QEquModel;

public interface QEquService {
	/**
	 * 保存
	 * 
	 * @author shijiyong
	 * @param txjddatastate
	 *            保存内容
	 * @return
	 * @throws
	 */
	QEquModel save(QEquModel qequ);

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
	 * 根据id查找TxjdDataState
	 * 
	 * @author shijiyong
	 * @param datastate
	 * @param txjddatastate
	 * @return void
	 * @throws
	 */
	QEqu findById(String id);

	/**
	 * 根据id查找EnvironmentEquipCheck
	 * 
	 * @author shijiyong
	 * @param datastate
	 * @param txjddatastate
	 * @return void
	 * @throws
	 */
	EnvironmentEquipCheck findByIden(String checkid);

	/**
	 * 更新
	 * 
	 * @author shijiyong
	 * @param datastate
	 * @param txjddatastate
	 * @return void
	 * @throws
	 */
	QEquModel update(QEqu qequ, EnvironmentEquipCheck enviroment,
			QEquModel qequmodel);

	/**
	 * 删除-根据网管数据哭内容
	 * 
	 * @author shijiyong 2016年10月21日 上午9:01:08
	 * @param enviroment
	 *            删除内容
	 * @return void
	 * @throws
	 */
	void delete(QEqu qequ, EnvironmentEquipCheck enviroment);

}
