package cn.com.atnc.ioms.dao.faultmng;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.faultmng.FaultEvaluate;
import cn.com.atnc.ioms.model.faultmng.FaultEvaluateModel;

/**
 * 事件单评价
 *
 * @author 段衍林
 * @2016年11月9日 下午4:33:09
 */
public interface IFaultEvaluateDao extends IBaseDao<FaultEvaluate> {

	/**
	 * 事件单评价查询
	 * @author 段衍林
	 * @2016年11月9日 下午4:33:31
	 * @param qm
	 * @return
	 * List<FaultEvaluate>
	 */
	public List<FaultEvaluate> queryList(FaultEvaluateModel qm);
	
}