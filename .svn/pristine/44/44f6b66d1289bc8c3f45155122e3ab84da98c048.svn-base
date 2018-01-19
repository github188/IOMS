package cn.com.atnc.ioms.mng.faultmng;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.faultmng.FaultHandle;
import cn.com.atnc.ioms.entity.faultmng.FaultInformation;
import cn.com.atnc.ioms.model.faultmng.FaultHandleModel;
import cn.com.atnc.ioms.model.faultmng.FaultHandleQueryModel;

import java.util.List;

/**
 * 故障处置记录管理接口
 * @author duanyanlin 
 * 2016年6月17日 下午2:29:19
 */
public interface IFaultHandleMngService {
	
	/**
	 * 查询故障单处置记录
	 * @author duanyanlin
	 * @date 2016年6月23日上午9:06:35
	 * @param qm 事件查询model
	 * @return List 处置记录列表 
	 */
	public List<FaultHandle> queryList(FaultHandleQueryModel qm);
	
	/**
	 * 故障处置记录保存公共部分
	 * @author duanyanlin
	 * @date 2016年6月17日下午3:22:35
	 * @param faultHandleModel 事件处置model
	 * @return FaultHandle 处置记录
	 */
	public FaultHandle addCommon(FaultHandleModel faultHandleModel);

	/**
	 * 根据处理类别实现事件处置
	 * @author duanyanlin
	 * @date 2016年6月23日上午9:07:09
	 * @param qm 事件处置model
	 * @return FaultInformation 事件单
	 * @throws ServiceException 
	 */
	public FaultInformation handle(FaultHandleModel qm) throws ServiceException;
	
	/**
	 * 部门经理退回事件单
	 * @author duanyanlin
	 * @date 2016年7月27日下午2:03:36
	 * @param faultHandleModel 事件处置model
	 */
	public void backEngineer(FaultHandleModel faultHandleModel);
	
	/**
	 * 技术工程师处理
	 * @author duanyanlin
	 * @date 2016年6月27日下午3:24:55
	 * @param qm 事件处置model
	 * @return FaultInformation 事件单
	 */
	public FaultInformation engineerHandle(FaultHandleModel qm);
	
	/**
	 * 判断技术工程师是否已经全部完成部门经理分配的任务
	 * @author duanyanlin
	 * @date 2016年6月28日上午9:22:12
	 * @param qm 事件查询model
	 * @return boolean
	 */
	public boolean boolEngineerSuccess(FaultHandleQueryModel qm);
	
	/**
	 * 短信发送功能
	 * @author duanyanlin
	 * @date 2016年7月6日下午1:04:34
	 * @param faultHandleModel 事件处置model
	 */
	public void sendMessage(FaultHandleModel faultHandleModel);
	
	/**
	 * 第一处理人暂存
	 * @author duanyanlin
	 * @param faultHandleModel 事件处置model
	 * @return FaultHandle 事件处置记录
	 */
	public FaultHandle savefaultTemporary(FaultHandleModel faultHandleModel);
}