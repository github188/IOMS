package cn.com.atnc.ioms.mng.duty.statellitemqy;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.TesCheck;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.TesCheckModel;

public interface TesCheckService {
	/**
	 * 保存
	 * 
	 * @author shijiyong
	 * @param txjddatastate
	 *            保存内容
	 * @return
	 * @throws
	 */
	TesCheckModel save(TesCheckModel tescheckmodel);

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
	TesCheck findById(String id);

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
	TesCheckModel update(TesCheck tescheck, EnvironmentEquipCheck enviroment,
			TesCheckModel tescheckmodel);

	/**
	 * 删除-根据网管数据哭内容
	 * 
	 * @author shijiyong 2016年10月21日 上午9:01:08
	 * @param enviroment
	 *            删除内容
	 * @return void
	 * @throws
	 */
	void delete(TesCheck tescheck, EnvironmentEquipCheck enviroment);

}
