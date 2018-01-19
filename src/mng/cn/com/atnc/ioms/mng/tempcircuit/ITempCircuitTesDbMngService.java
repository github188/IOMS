package cn.com.atnc.ioms.mng.tempcircuit;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuitTesDb;

/**
 * 
 * 类说明：TempCircuitTesDb服务接口
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月27日上午9:24:00
 * @version:1.0
 */
public interface ITempCircuitTesDbMngService {
	/**
	 * 
	 * 方法说明：新增临时电路
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年3月27日上午9:35:30
	 * @param obj
	 * @return TempCircuit
	 * 
	 */
	public TempCircuitTesDb add(TempCircuitTesDb obj) throws ServiceException;

	/**
	 * 
	 * 方法说明：更新临时电路
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月1日下午6:25:58
	 * @param obj
	 * @return String
	 * 
	 */
	public TempCircuitTesDb update(TempCircuitTesDb obj)
			throws ServiceException;

	/**
	 * 
	 * 方法说明：根据临时电路申请ID查找临时电路申请
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年3月27日下午7:46:56
	 * @param id
	 * @return String
	 * 
	 */
	public TempCircuitTesDb getTempCircuitTesDbByTempcircuitID(String id)
			throws ServiceException;
}
