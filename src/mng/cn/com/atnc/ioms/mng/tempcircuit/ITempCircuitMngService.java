package cn.com.atnc.ioms.mng.tempcircuit;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuit;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitType;
import cn.com.atnc.ioms.model.tempcircuit.TempCircuitQueryModel;

/**
 * 
 * 类说明：临时电路服务接口
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月27日上午9:24:00
 * @version:1.0
 */
public interface ITempCircuitMngService {
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
	public String add(TempCircuit obj);

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
	public void update(TempCircuit obj);

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
	public TempCircuit getTempCircuitByID(String id);

	/**
	 * 
	 * 方法说明：根据临时电路申请用户ID查找临时电路申请
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年3月27日下午7:46:56
	 * @param id
	 * @return String
	 * 
	 */
	public List<TempCircuit> getTempCircuitByApplyUserID(String id);

	/**
	 * 
	 * 方法说明：根据临时电路ID强制撤销临时电路
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月17日下午3:20:56
	 * @param id
	 * @return TempCircuit
	 * 
	 */
	public void forceCancleTempCircuitByID(String id);

	/**
	 * 
	 * 方法说明：确认删除临时电路
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年5月15日下午6:02:47
	 * @param id
	 *            void
	 * 
	 */
	public void ackDeleteTempCircuitByID(String id);

	/**
	 * 
	 * 方法说明：根据临时电路ID延期该临时电路
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月17日下午6:53:17
	 * @param id
	 *            void
	 * 
	 */
	public void applyTempCircuitDelayByID(String id);

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
	 * @date：2014年5月21日上午9:40:18
	 * @param qm
	 * @return MyPagination
	 * 
	 */
	public Pagination queryPageAudit(TempCircuitQueryModel qm);

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
	 * 方法说明：获取指定类型的电路申请的唯一编号，编号规则：FRATM-20140515-1
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年5月15日下午1:17:54
	 * @param circuitType
	 * @return String
	 * 
	 */
	public String getCircuitNumByType(CircuitType circuitType);

	/**
	 * 
	 * 方法说明：根据临时电路ID撤销临时电路
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月17日下午3:20:56
	 * @param id
	 * @return TempCircuit
	 * 
	 */
	public void cancleTempCircuitByID(String id);

	/**
	 * 
	 * 方法说明：根据当前用户ID获得未处理任务数量
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年6月4日上午9:08:10
	 * @param userID
	 *            用户ID
	 * @return int
	 * 
	 */
	public int getCurrentUserUndoTaskNum(String userID);

	/**
	 * 查询需要发送短信的TempCircuit的List
	 *
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2016年2月2日下午2:25:08
	 * @since 1.0.0
	 */
	public List<TempCircuit> getTempCircuitSend();
}
