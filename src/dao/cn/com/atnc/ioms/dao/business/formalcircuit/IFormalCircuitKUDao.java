package cn.com.atnc.ioms.dao.business.formalcircuit;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitKU;

 /**
 * KU正式电路申请表Dao接口
 *
 * @author Wang zhicheng
 * @date 2015年5月18日 上午8:45:00
 * @since 1.0.0
 */
public interface IFormalCircuitKUDao extends IBaseDao<FormalCircuitKU> {

	public List<FormalCircuitKU> findByFC(FormalCircuit formalCircuit);

}
