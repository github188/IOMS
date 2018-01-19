package cn.com.atnc.ioms.mng.techsupport;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.techsupport.fault.FaultDeclareOptLog;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareOptLogQueryModel;
/**
 * 类说明：故障申报操作记录服务接口
 * 
 * @author KuYonggang
 * @date 2014-4-3下午7:30:36
 * @version 1.0
 */
public interface IFaultDeclareOptLogService {

	/**
	 * 保存故障申报操作记录实体
	 * 
	 * @author KuYonggang
	 * @date 2014-4-3下午7:30:52
	 * @param faultDeclare
	 * @return String 主键ID
	 */
	public void save(FaultDeclareOptLog faultDeclareOptLog);
	
	/**
	 * 通过id查询得到故障申报操作记录类对象
	 * @author KuYonggang
	 * @date 2014-4-3下午7:31:06
	 * @param id 主键ID
	 * @return FaultDeclareOptLog
	 */
	public FaultDeclareOptLog findById(String id);

	/**
	 * 通过故障申报记录ID获取该记录日志对象集合
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-22上午8:49:39
	 * @param：id 故障申报记录ID
	 * @return：List<FaultDeclareOptLog>
	 */
	public List<FaultDeclareOptLog> findByFaultDeclareId(String id);

	/**
	 * 多条件模糊分页查询
	 * 
	 * @author KuYonggang
	 * @date 2014-4-3下午7:32:13
	 * @param model 查询条件
	 * @return MyPagination 分页查询结果
	 */
	public Pagination queryPageByParam(FaultDeclareOptLogQueryModel model);

	/**
	 *  多条件精确查询
	 * @author KuYonggang
	 * @date 2014-4-3下午7:32:38
	 * @param model 查询条件
	 * @return List<FaultDeclareOptLog> 查询结果
	 */
	public List<FaultDeclareOptLog> queryListByParam(FaultDeclareOptLogQueryModel model);

	/**
	 * 删除指定id的记录
	 * @author KuYonggang
	 * @date 2014-4-3下午7:33:17
	 * @param id 
	 * @return void
	 */
	public void delete(String id) throws ServiceException;
}
