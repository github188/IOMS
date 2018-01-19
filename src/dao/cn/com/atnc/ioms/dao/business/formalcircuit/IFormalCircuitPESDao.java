package cn.com.atnc.ioms.dao.business.formalcircuit;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitPES;

/**
 * PES正式电路申请表Dao接口
 *
 * @author 段衍林
 * @2017年1月5日 上午10:40:43
 */
public interface IFormalCircuitPESDao extends IBaseDao<FormalCircuitPES> {

	public List<FormalCircuitPES> findByFC(FormalCircuit formalCircuit);

	public List<FormalCircuitPES> findBySiteAndCaseNum(
			List<String> PEStxSiteNames, List<String> PEStxCaseNums,
			List<String> PESrxSiteNames, List<String> PESrxCaseNums);
}
