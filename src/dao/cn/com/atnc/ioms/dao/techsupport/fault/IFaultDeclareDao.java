/**
 * 
 */
package cn.com.atnc.ioms.dao.techsupport.fault;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.techsupport.fault.FaultDeclare;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareDealQueryModel;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareRecordQueryModel;

/**
 * 故障申报Dao接口
 * 
 * @author：KuYonggang
 * @date：2014-4-3下午7:46:03
 * @version：1.0
 */
public interface IFaultDeclareDao extends IBaseDao<FaultDeclare> {
	
	/**
	 * 按模糊条件过滤获取故障申报的分页查询结果
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-3下午7:47:00
	 * @param：queryModel 模糊查询条件
	 * @return：Pagination 分页结果
	 */
	public Pagination queryPageByParam(FaultDeclareRecordQueryModel queryModel);
	
	/**
	 * 按模糊条件过滤获取故障申报的分页查询结果
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-3下午7:47:00
	 * @param：queryModel 模糊查询条件
	 * @return：Pagination 分页结果
	 */
	public Pagination queryPageForDeal(FaultDeclareDealQueryModel queryModel);
	
	/**
	 * 根据指定条件精确查询所有结果。
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-3下午7:47:31
	 * @param： 条件
	 * @return：List<FaultDeclare> 结果集
	 */
	public List<FaultDeclare> queryListByParam(FaultDeclareDealQueryModel queryModel);
}
