package cn.com.atnc.ioms.dao.duty.satellite.day;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satellite.TxjdRadarLink;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;

/**
 * 通信基地雷达广播TES-TES链路工作状态
 * 数据库接口
 *
 * @author 段衍林
 * @2016年11月16日 上午9:54:27
 */
public interface TxjdRadarLinkDao  extends IBaseDao<TxjdRadarLink> {

	/** 
	 * 通信基地雷达广播TES-TES链路工作状态
	 * 分页查询
	 * @author 段衍林
	 * @2016年11月16日 上午9:54:08
	 * @param queryModel 查询model
	 * @return 返回分页
	 * Pagination
	 */
	Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel);
}