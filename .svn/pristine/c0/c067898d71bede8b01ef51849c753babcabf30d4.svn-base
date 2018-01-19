package cn.com.atnc.ioms.mng.faultmng;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.faultmng.FaultInformation;
import cn.com.atnc.ioms.model.faultmng.FaultHandleQueryModel;
import cn.com.atnc.ioms.model.faultmng.FaultInformationModel;

/**
 * 故障信息管理接口
 * 
 * @author duanyanlin 2016年6月17日 下午2:29:57
 * 
 *         修改人：段衍林 修改时间：2016年11月9日 下午2:36:04 修改内容：查询待评价事件单
 */
public interface IFaultInformationMngService {

	/**
	 * 查询待评价事件单
	 * 
	 * @author 段衍林
	 * @2016年11月9日 下午2:36:04
	 * @param qm
	 *            查询model
	 * @return 分页事件单 Pagination
	 */
	public Pagination queryEvaluatePage(FaultHandleQueryModel qm);

	/**
	 * 查询故障单列表（分页）
	 * 
	 * @author duanyanlin
	 * @date 2016年6月21日下午1:38:37
	 * @param qm
	 *            事件查询model
	 * @return Pagination 分页
	 */
	public Pagination queryPage(FaultHandleQueryModel qm);

	/**
	 * 查询故障单列表（查询统计模块使用）
	 * 
	 * @author duanyanlin
	 * @date 2016年6月21日下午1:38:37
	 * @param qm
	 *            事件查询model
	 * @return Pagination 分页
	 */
	public Pagination queryFaultList(FaultHandleQueryModel qm);

	/**
	 * 查询故障单列表
	 * 
	 * @author duanyanlin
	 * @date 2016年6月21日下午1:38:21
	 * @param qm
	 *            事件查询model
	 * @return List 事件单列表
	 */
	public List<FaultInformation> queryList(FaultHandleQueryModel qm);

	/**
	 * 手动添加故障单
	 * 
	 * @author duanyanlin
	 * @date 2016年6月21日下午1:38:10
	 * @param faultInformationModel
	 *            事件单model
	 * @return FaultInformation 事件单
	 * @throws ServiceException
	 */
	public FaultInformation saveFaultInformation(
			FaultInformationModel faultInformationModel)
			throws ServiceException;

	/**
	 * 根据告警信息添加事件单
	 * 
	 * @author duanyanlin
	 * @date 2016年6月21日下午1:38:10
	 * @param faultInformationModel
	 *            事件单model
	 * @return FaultInformation 事件单
	 */
	public FaultInformation saveAlarmFault(String alarmId,
			FaultInformationModel faultInformationModel, User user);

	/**
	 * 修改故障单信息
	 * 
	 * @author duanyanlin
	 * @date 2016年6月21日下午1:38:10
	 * @param faultInformationModel
	 *            事件单model
	 * @return FaultInformation 事件单
	 * @throws ServiceException
	 */
	public FaultInformation editFaultInformation(
			FaultInformationModel faultInformationModel)
			throws ServiceException;

	/**
	 * 删除故障单
	 * 
	 * @author duanyanlin
	 * @date 2016年6月30日下午12:57:51
	 * @param qm
	 *            事件查询model
	 * @return FaultInformation 事件单
	 */
	public FaultInformation deleteFaultInformation(FaultHandleQueryModel qm);

	/**
	 * 查询故障单
	 * 
	 * @author duanyanlin
	 * @date 2016年6月21日下午6:23:44
	 * @param qm
	 *            事件查询model
	 * @return FaultInformation 事件单
	 */
	public FaultInformation findById(FaultHandleQueryModel qm);
}