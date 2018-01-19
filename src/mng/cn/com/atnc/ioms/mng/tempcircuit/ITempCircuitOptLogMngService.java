package cn.com.atnc.ioms.mng.tempcircuit;

import java.util.List;

import cn.com.atnc.ioms.entity.tempcircuit.TempCircuitOptLog;

/**
 * 
 * 类说明：临时电路审批日志服务接口
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月27日上午9:24:00
 * @version:1.0
 */
public interface ITempCircuitOptLogMngService {
	/**
	 * 
	 * 方法说明：新增临时电路审批日志
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年3月27日上午10:42:05
	 * @param obj
	 * @return TempCircuitOptLog
	 * 
	 */
	public String add(TempCircuitOptLog obj);

	/**
	 * 
	 * 方法说明：根据临时电路申请ID查找相关审批日志
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年3月31日下午6:28:28
	 * @param tempCircuitID
	 * @return List<TempCircuitOptLog>
	 * 
	 */
	public List<TempCircuitOptLog> findByTempcircuitID(String tempCircuitID);

	/**
	 * 
	 * 方法说明：根据临时电路申请ID查找最新审批日志
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月17日下午3:41:01
	 * @param tempCircuitID
	 * @return TempCircuitOptLog
	 * 
	 */
	public TempCircuitOptLog findLatestByTempcircuitID(String tempCircuitID);

}
