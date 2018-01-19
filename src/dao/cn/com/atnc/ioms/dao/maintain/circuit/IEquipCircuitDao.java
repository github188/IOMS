/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName IEquipCircuitDao.java
 * @PackageName:cn.com.atnc.ioms.dao.maintain.circuit
 * @author ku
 * @date 2015年4月30日下午1:50:58
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.circuit;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.maintain.circuit.EquipCircuit;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;

/**
 * 设备电路配置Dao接口
 *
 * @author ku
 * @date 2015年4月30日 下午1:50:58
 * @since 1.0.0
 */
public interface IEquipCircuitDao extends IBaseDao<EquipCircuit> {

	public Pagination queryPage(KuStatQueryModel queryModel);

}
