/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:26:26
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.tempcircuit;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuitOptLog;

/**
 * 
 * 类说明：临时电路审批日志DAO
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月27日上午10:38:15
 * @version:1.0
 */
public interface ITempCircuitOptLogDao extends IBaseDao<TempCircuitOptLog> {
	/**
	 * 
	 * 方法说明：根据临时电路申请ID查找相关审批日志
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月1日上午10:10:15
	 * @param id
	 * @return List<TempCircuitOptLog>
	 * 
	 */
	public List<TempCircuitOptLog> findByTempCircuitID(String id);

	/**
	 * 
	 * 方法说明：根据临时电路申请ID查找最新审批日志
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月17日下午6:37:00
	 * @param id
	 * @return List<TempCircuitOptLog>
	 * 
	 */
	public TempCircuitOptLog findLatestByTempcircuitID(String id);
}
