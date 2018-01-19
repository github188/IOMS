package cn.com.atnc.ioms.mng.business.formalcircuit;

import java.util.List;

import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitKU;
import cn.com.atnc.ioms.model.business.formalcircuit.FormalCircuitQueryModel;


 /**
 * KU正式电路申请Service接口
 *
 * @author Wang zhicheng
 * @date 2015年5月18日 上午8:52:08
 * @since 1.0.0
 */
public interface IFormalCircuitKUManager {

	/**
	 * 保存
	 *
	 * @param formalCircuitKU2 
	 * @date  2015年5月22日下午2:22:37
	 * @since 1.0.0
	*/
	public void save(FormalCircuitKU formalCircuitKU2);

	/**
	 * 根据FormalCircuit查找出实体FormalCircuitKU的List
	 *
	 * @param formalCircuit
	 * @return 
	 * @date  2015年5月22日下午2:22:47
	 * @since 1.0.0
	*/
	public List<FormalCircuitKU> findByFC(FormalCircuit formalCircuit);

	/**
	 * 更新
	 *
	 * @param formalCircuitKU 
	 * @date  2015年5月22日下午2:23:41
	 * @since 1.0.0
	*/
	public void update(FormalCircuitKU formalCircuitKU);

	/**
	 * 删除
	 *
	 * @param formalCircuitKU 
	 * @date  2015年5月22日下午2:23:50
	 * @since 1.0.0
	*/
	public void delete(FormalCircuitKU formalCircuitKU);

	/**
	 * 处理KU配置信息
	 * @author WangLingbin
	 * @date  2015年7月6日下午3:20:38
	 * @since 1.0.0
	 */
	public void dealKUConf(String id, FormalCircuitQueryModel queryModel,
			List<String> kUConfTxSiteNames, List<String> kUConfTxNodes,
			List<String> kUConfTxSlots, List<String> kUConfTxPlots,
			List<String> kUConfRxSiteNames, List<String> kUConfRxNodes,
			List<String> kUConfRxSlots, List<String> kUConfRxPlots,
			List<String> kUConfSpeeds, List<String> kUConfCommunicateWays,
			List<String> kUConfUsages, List<String> kUConfTxCards,
			List<String> kUConfTxInterfaces, List<String> kUConfRxCards,
			List<String> kUConfRxInterfaces, List<String> kUConfCircuitNames,
			List<String> kUConfNos, String confRemark);

}
