package cn.com.atnc.ioms.dao.faultmng;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.faultmng.FaultHandle;
import cn.com.atnc.ioms.model.faultmng.FaultHandleQueryModel;
import java.util.List;

/**
 * 故障处置记录管理
 * 
 * @author duanyanlin 
 * @date 2016年6月17日 下午3:13:39
 */
public interface IFaultHandleDao extends IBaseDao<FaultHandle> {

	/**
	 * 故障单处置记录查询列表
	 * 
	 * @author duanyanlin
	 * @date 2016年6月17日下午3:14:05
	 * @param qm 事件处置查询model
	 * @return List 事件处置记录列表
	 */
	public List<FaultHandle> queryList(FaultHandleQueryModel qm);
	
}