/**
 * 
 */
package cn.com.atnc.ioms.mng.techsupport;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.techsupport.fault.FaultDeclare;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareDealQueryModel;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareRecordQueryModel;

/**
 * 故障申报服务接口
 * @author KuYonggang
 * @date 2014-4-3下午7:30:36
 * @version 1.0
 */
public interface IFaultDeclareService {

	/**
	 * 保存故障申报实体对象
	 * @author KuYonggang
	 * @date 2014-4-3下午7:30:52
	 * @param faultDeclare
	 * @return String 主键ID
	 */
	public String save(FaultDeclare faultDeclare);
	
	/**
	 * 更新故障申报类实体
	 * @author KuYonggang
	 * @date 2014-4-3下午7:29:43
	 * @param faultDeclare 故障申报类实体对象
	 * @return String 主键ID
	 */
	public String update(FaultDeclare faultDeclare);

	/**
	 * 通过id查询得到故障申报类对象
	 * @author KuYonggang
	 * @date 2014-4-3下午7:31:06
	 * @param id 主键ID
	 * @return FaultDeclare
	 */
	public FaultDeclare getFaultDeclareByID(String id);

	/**
	 * 多条件模糊分页查询
	 * 用于故障申报记录查询
	 * @author KuYonggang
	 * @date 2014-4-3下午7:32:13
	 * @param model 查询条件
	 * @return Pagination 分页查询结果
	 */
	public Pagination queryPageByParam(FaultDeclareRecordQueryModel model);
	
	/**
	 * 多条件模糊分页查询    
	 * 用于故障申报处理查询
	 * @author KuYonggang
	 * @date 2014-4-3下午7:32:13
	 * @param model 查询条件
	 * @return Pagination 分页查询结果
	 */
	public Pagination queryPageForDeal(FaultDeclareDealQueryModel model);

	/**
	 *  多条件精确查询
	 * @author KuYonggang
	 * @date 2014-4-3下午7:32:38
	 * @param model 查询条件
	 * @return List<FaultDeclare> 查询结果
	 */
	public List<FaultDeclare> queryListByParam(FaultDeclareDealQueryModel model);

	/**
	 * 删除指定id的记录
	 * @author KuYonggang
	 * @date 2014-4-3下午7:33:17
	 * @param id
	 * @return String 中文名称
	 */
	public String delete(String id);

	/**
	 * 获取待接单的故障申报数量
	 * @author：KuYonggang
	 * @date：2014-6-4上午10:27:50
	 * @param：userId
	 * @return：int
	 */
	public int getFaultDeclareNum(String userId);
	
	/**
	 * 获取待回复的技术咨询数量
	 * @author：KuYonggang
	 * @date：2014-6-4上午10:27:50
	 * @param：
	 * @return：int
	 */
	public int getTechConsultNum();

}
