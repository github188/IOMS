package cn.com.atnc.ioms.dao.publicnotice;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.publicnotice.PnNoticeOptLog;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuitOptLog;
import cn.com.atnc.ioms.model.publicnotice.PnNoticeOptLogQueryModel;

/**
 * @author:lizhisheng
 * @date:2014-5-5 下午2:02:48
 * @version:1.0
 */
public interface IPnNoticeOptLogDao extends IBaseDao<PnNoticeOptLog> {
	/**
	 * 按模糊条件过滤获取故障申报的分页查询结果
	 * 
	 * @param：queryModel 模糊查询条件
	 * @return：Pagination 分页结果
	 */
	public Pagination queryPageByParam(PnNoticeOptLogQueryModel queryModel);
	
	/**
	 * 根据指定条件精确查询所有结果。
	 * 
	 * @param：queryModel 精确查询条件
	 */
	public List<PnNoticeOptLog> queryListByParam(PnNoticeOptLogQueryModel queryModel);

	/**
	 * 根据记录ID获取申报记录日志对象集合
	 */
	public List<PnNoticeOptLog> findByPnNoticeOptLogId(String id);
	/**
	 * 
	 * 方法说明：根据申请ID查找最新审批日志
	 * 
	 * @param id
	 * 
	 */
	public PnNoticeOptLog findLatestByPnNoticeOptLogID(String id);
}
