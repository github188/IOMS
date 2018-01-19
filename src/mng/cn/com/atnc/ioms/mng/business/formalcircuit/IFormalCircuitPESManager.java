package cn.com.atnc.ioms.mng.business.formalcircuit;

import java.util.List;

import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitPES;
import cn.com.atnc.ioms.model.business.formalcircuit.FormalCircuitQueryModel;

/**
 * PES正式电路申请Service接口
 *
 * @author 段衍林
 * @2017年1月5日 上午10:37:46
 */
public interface IFormalCircuitPESManager {

	/**
	 * 保存
	 *
	 * @param formalCircuitPES
	 * @date 2015年5月22日下午2:24:57
	 * @since 1.0.0
	 */
	public void save(FormalCircuitPES formalCircuitPES);

	/**
	 * 根据FormalCircuit查找出实体FormalCircuitTES的List
	 *
	 * @param formalCircuit
	 * @return
	 * @date 2015年5月22日下午2:25:27
	 * @since 1.0.0
	 */
	public List<FormalCircuitPES> findByFC(FormalCircuit formalCircuit);

	/**
	 * 更新
	 *
	 * @param formalCircuitPES
	 * @date 2015年5月22日下午2:25:07
	 * @since 1.0.0
	 */
	public void update(FormalCircuitPES formalCircuitPES);

	/**
	 * 删除
	 *
	 * @param formalCircuitPES
	 * @date 2015年5月22日下午2:25:20
	 * @since 1.0.0
	 */
	public void delete(FormalCircuitPES formalCircuitPES);

	/**
	 * 检查PES站点号和机箱号是否符合要求
	 *
	 * @param PESBusinessNames
	 * @param PESrxSlotNums
	 * @param PEStxSlotNums
	 * @param PEStxSiteNames
	 * @param PEStxCaseNums
	 * @param PESrxSiteNames
	 * @param PESrxCaseNums
	 * @return
	 * @author Wang Zhicheng
	 * @date 2015年10月22日上午10:52:28
	 * @since 1.0.0
	 */
	public String checkPES(List<String> PESBusinessNames,
			List<String> PESrxSlotNums, List<String> PEStxSlotNums,
			List<String> PEStxSiteNames, List<String> PEStxCaseNums,
			List<String> PESrxSiteNames, List<String> PESrxCaseNums);

	/**
	 * 根据节点号和机箱号查找实体
	 * 
	 * @author WangLingbin
	 * @date 2015年7月29日下午2:51:04
	 * @since 1.0.0
	 */
	public List<FormalCircuitPES> findBySiteAndCaseNum(
			List<String> PEStxSiteNames, List<String> PEStxCaseNums,
			List<String> PESrxSiteNames, List<String> PESrxCaseNums);

	/**
	 * 处理PES配置信息
	 * 
	 * @author WangLingbin
	 * @date 2015年7月6日下午3:32:16
	 * @since 1.0.0
	 */
	public void dealPESConf(String id, FormalCircuitQueryModel queryModel,
			List<String> PESConfTxSiteNames, List<String> PESConfTxCaseNums,
			List<String> PESConfTxSlotNums, List<String> PESConfTxPortNums,
			List<String> PESConfRxSiteNames, List<String> PESConfRxCaseNums,
			List<String> PESConfRxSlotNums, List<String> PESConfRxPortNums,
			List<String> PESConfSpeeds, List<String> PESConfCommunicateWays,
			List<String> PESConfUsages, List<String> PESConfTxInterfaces,
			List<String> PESConfRxInterfaces, List<String> PESConfCircuitNames,
			List<String> PESConfNos, String confRemark);
}
