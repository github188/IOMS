package cn.com.atnc.ioms.mng.business.formalcircuit;

import java.util.List;

import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitATM;
import cn.com.atnc.ioms.model.business.formalcircuit.FormalCircuitQueryModel;


 /**
 * ATM正式电路申请Service接口
 *
 * @author Wang zhicheng
 * @date 2015年5月18日 上午8:52:08
 * @since 1.0.0
 */
public interface IFormalCircuitATMManager {

	/**
	 * 保存
	 *
	 * @param formalCircuitATM 
	 * @date  2015年5月22日下午2:24:07
	 * @since 1.0.0
	*/
	public void save(FormalCircuitATM formalCircuitATM);

	/**
	 * 根据FormalCircuit查找出实体FormalCircuitATM的List
	 *
	 * @param formalCircuit
	 * @return 
	 * @date  2015年5月22日下午2:24:19
	 * @since 1.0.0
	*/
	public List<FormalCircuitATM> findByFC(FormalCircuit formalCircuit);

	/**
	 * 更新
	 *
	 * @param formalCircuitATM 
	 * @date  2015年5月22日下午2:24:33
	 * @since 1.0.0
	*/
	public void update(FormalCircuitATM formalCircuitATM);

	/**
	 * 删除
	 *
	 * @param formalCircuitATM 
	 * @date  2015年5月22日下午2:24:46
	 * @since 1.0.0
	*/
	public void delete(FormalCircuitATM formalCircuitATM);

	/**
	 * 处理ATM配置信息
	 * @author WangLingbin
	 * @param queryModel 
	 * @date  2015年7月6日下午2:26:49
	 * @since 1.0.0
	 */
	public void dealATMConf(String id, FormalCircuitQueryModel queryModel,
			List<String> aTMConfTxNodeNames, List<String> aTMConfTxSlodNums,
			List<String> aTMConfTxLines, List<String> aTMConfTxPorts,
			List<String> aTMConfTxVpiDlcis, List<String> aTMConfRxNodeNames,
			List<String> aTMConfRxSlodNums, List<String> aTMConfRxLines,
			List<String> aTMConfRxPorts, List<String> aTMConfRxVpiDlcis,
			List<String> aTMConfSpeeds, List<String> aTMConfServiceTypes,
			List<String> aTMConfUsages, List<String> aTMConfTxSignals,
			List<String> aTMConfRxSignals, List<String> aTMConfNos,
			String confRemark);
	
}
