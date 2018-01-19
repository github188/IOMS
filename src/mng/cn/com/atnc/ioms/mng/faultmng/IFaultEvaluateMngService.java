package cn.com.atnc.ioms.mng.faultmng;

import java.util.List;

import cn.com.atnc.ioms.entity.faultmng.FaultEvaluate;
import cn.com.atnc.ioms.model.faultmng.FaultEvaluateModel;

/**
 * 事件单评价接口
 *
 * @author 段衍林
 * @2016年11月9日 下午4:37:12
 */
public interface IFaultEvaluateMngService {
	
	/**
	 * 事件单评价查询model
	 * @author 段衍林
	 * @2016年11月9日 下午4:38:15
	 * @param qm
	 * @return
	 * List<FaultEvaluate>
	 */
	public List<FaultEvaluate> queryList(FaultEvaluateModel qm);
	
	/**
	 * 事件单评价保存
	 * @author 段衍林
	 * @2016年11月9日 下午4:39:18
	 * @param faultEvaluateModel
	 * void
	 * @throws Exception 
	 */
	public void saveEvaluate(FaultEvaluateModel faultEvaluateModel) throws Exception;
}