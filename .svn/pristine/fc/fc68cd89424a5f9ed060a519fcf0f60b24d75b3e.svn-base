/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:26:26
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.tempcircuit;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuit;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitType;
import cn.com.atnc.ioms.model.tempcircuit.TempCircuitQueryModel;

/**
 * 
 * 类说明：临时电路DAO
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月26日下午7:01:45
 * @version:1.0
 */
public interface ITempCircuitDao extends IBaseDao<TempCircuit> {
	/**
	 * 
	 * 方法说明：根据临时电路申请用户ID查找临时电路申请
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月17日下午1:38:41
	 * @param id
	 * @return List<TempCircuit>
	 * 
	 */
	public List<TempCircuit> getTempCircuitByApplyUserID(String id);

	/**
	 * 
	 * 方法说明：查询分页对象
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月18日下午12:53:50
	 * @param qm
	 * @return Pagination
	 * 
	 */
	public Pagination queryPage(TempCircuitQueryModel qm);

	/**
	 * 
	 * 方法说明：查询正在审批中的分页对象
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年5月21日上午9:02:10
	 * @param qm
	 * @return Pagination
	 * 
	 */
	public Pagination queryPageAudit(TempCircuitQueryModel qm);

	/**
	 * 
	 * 方法说明：查询临时电路
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月18日下午12:54:23
	 * @param qm
	 * @return List<Client>
	 * 
	 */
	public List<TempCircuit> queryList(TempCircuitQueryModel qm);

	/**
	 * 
	 * 方法说明：查询所有未到期临时电路
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年5月20日下午12:53:32
	 * @return List<TempCircuit>
	 * 
	 */
	public List<TempCircuit> getAllValidTempCircuit();

	/**
	 * 
	 * 方法说明：根据类型查找recordtime最近的临时电路
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年6月24日下午1:05:38
	 * @param circuitType
	 * @return TempCiruit
	 * 
	 */
	public TempCircuit findTempCircuitByRecordTime(CircuitType circuitType);

	/**
	 * 
	 * 方法说明：查询已到期电路（工程师确认删除和强制删除的除外）的分页对象
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年5月21日上午9:40:18
	 * @param qm
	 * @return MyPagination
	 * 
	 */
	public Pagination queryPageExpire(TempCircuitQueryModel qm);

	/**
	 * 
	 * 方法说明：查询已经完结电路（工程师确认删除和强制删除）的分页对象
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年5月21日上午9:40:18
	 * @param qm
	 * @return MyPagination
	 * 
	 */
	public Pagination queryPageOver(TempCircuitQueryModel qm);
}
