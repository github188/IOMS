package cn.com.atnc.ioms.dao.techsupport.fault;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.techsupport.fault.FaultDeclareOptLog;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareOptLogQueryModel;

/**
 *类说明： 故障申报操作记录Dao接口
 * 
 * @author：KuYonggang
 * @date：2014-4-3下午7:46:03
 * @version：1.0
 */
public interface IFaultDeclareOptLogDao extends IBaseDao<FaultDeclareOptLog> {
	
	/**
	 * 按模糊条件过滤获取故障申报的分页查询结果
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-3下午7:47:00
	 * @param：queryModel 模糊查询条件
	 * @return：Pagination 分页结果
	 */
	public Pagination queryPageByParam(FaultDeclareOptLogQueryModel queryModel);
	
	/**
	 * 根据指定条件精确查询所有结果。
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-3下午7:47:31
	 * @param：queryModel 精确查询条件
	 * @return：List<FaultDeclareOptLog> 结果集
	 */
	public List<FaultDeclareOptLog> queryListByParam(FaultDeclareOptLogQueryModel queryModel);

	/**
	 * 根据故障申报记录ID获取故障申报记录日志对象集合
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-21下午3:40:42
	 * @param：id 故障申报记录ID
	 * @return：FaultDeclareOptLog
	 */
	public List<FaultDeclareOptLog> findByFaultDeclareId(String id);
}
