package cn.com.atnc.ioms.dao.faultmng;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.faultmng.FaultInformation;
import cn.com.atnc.ioms.model.faultmng.FaultHandleQueryModel;

/**
 * 事件单管理
 * @author duanyanlin
 * @date 2016年8月5日下午4:10:34
 * 
 * 修改人：段衍林
 * 修改时间：2016年11月9日 下午2:39:18
 * 修改内容：查询待评价事件单列表
 */
public interface IFaultInformationDao extends IBaseDao<FaultInformation> {

	/**
	 * 查询待评价事件单列表
	 * @author 段衍林
	 * @2016年11月9日 下午2:39:18
	 * @param qm 查询model
	 * @return 待评价事件单列表
	 * Pagination 分页
	 */
	public Pagination queryEvaluatePage(FaultHandleQueryModel qm);
	/**
	 * 故障单查询（分页）
	 * @author duanyanlin
	 * @date 2016年6月17日下午3:15:03
	 * @param qm 事件处置查询model 
	 * @return Pagination 分页
	 */
	public Pagination queryPage(FaultHandleQueryModel qm);
	
	/**
	 * 
	 * @author duanyanlin
	 * @date 2016年6月27日下午2:01:46
	 * @param qm 事件处置查询model
	 * @return List 分页
	 */
	public List<FaultInformation> queryList(FaultHandleQueryModel qm);
	
	/**
	 * 根据故障单编号faultNumber降序查询事件单
	 * @author duanyanlin
	 * @date 2016年7月7日下午4:25:08
	 * @return List 列表
	 */
	public List<FaultInformation> queryListOrderByFaultNum();
}