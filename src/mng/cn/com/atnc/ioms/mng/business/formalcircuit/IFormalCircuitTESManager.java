package cn.com.atnc.ioms.mng.business.formalcircuit;

import java.util.List;

import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitTES;
import cn.com.atnc.ioms.model.business.formalcircuit.FormalCircuitQueryModel;

 /**
 * TES正式电路申请Service接口
 *
 * @author Wang zhicheng
 * @date 2015年5月18日 上午8:52:08
 * @since 1.0.0
 */
public interface IFormalCircuitTESManager {

	/**
	 * 保存
	 *
	 * @param formalCircuitTES 
	 * @date  2015年5月22日下午2:24:57
	 * @since 1.0.0
	*/
	public void save(FormalCircuitTES formalCircuitTES);

	/**
	 * 根据FormalCircuit查找出实体FormalCircuitTES的List
	 *
	 * @param formalCircuit
	 * @return 
	 * @date  2015年5月22日下午2:25:27
	 * @since 1.0.0
	*/
	public List<FormalCircuitTES> findByFC(FormalCircuit formalCircuit);

	/**
	 * 更新
	 *
	 * @param formalCircuitTES 
	 * @date  2015年5月22日下午2:25:07
	 * @since 1.0.0
	*/
	public void update(FormalCircuitTES formalCircuitTES);

	/**
	 * 删除
	 *
	 * @param formalCircuitTES 
	 * @date  2015年5月22日下午2:25:20
	 * @since 1.0.0
	*/
	public void delete(FormalCircuitTES formalCircuitTES);

	/**
	 * 处理TES配置信息
	 * @author WangLingbin
	 * @date  2015年7月6日下午3:32:16
	 * @since 1.0.0
	 */
	public void dealTESConf(String id, FormalCircuitQueryModel queryModel,
			List<String> tESConfTxSiteNames, List<String> tESConfTxCaseNums,
			List<String> tESConfTxSlotNums, List<String> tESConfRxSiteNames,
			List<String> tESConfRxCaseNums, List<String> tESConfRxSlotNums,
			List<String> tESConfSpeeds, List<String> tESConfCommunicateWays,
			List<String> tESConfUsages, List<String> tESConfTxInterfaces,
			List<String> tESConfRxInterfaces, List<String> tESConfClocks,
			List<String> tESConfCircuitNames, List<String> tESConfNos,
			String confRemark);

}
