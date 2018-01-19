package cn.com.atnc.ioms.mng.duty.statellite;

import java.lang.reflect.InvocationTargetException;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satellite.TxjdRadarLink;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.TxjdRadarLinkModel;

/**
 * 通信基地雷达广播TES-TES链路工作状态
 *
 * @author 段衍林
 * @2016年11月16日 上午10:17:31
 */
public interface TxjdRadarLinkService {

	/**
	 * 保存或更新
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:18:37
	 * @param txjdRadarLinkModel
	 *            MODEL void
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	TxjdRadarLink saveOrUpdate(TxjdRadarLinkModel txjdRadarLinkModel)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException;

	/**
	 * 分页查询
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:18:51
	 * @param queryModel
	 *            查询model
	 * @return 返回分页 Pagination
	 */
	Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel);

	/**
	 * 根据id查询实体
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:19:30
	 * @param id
	 *            实体id
	 * @return SlhDataState
	 */
	TxjdRadarLink findById(String id);

	/**
	 * 刪除
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:21:02
	 * @param txjdRadarLinkModel
	 *            MODEL void
	 */
	void delete(TxjdRadarLinkModel txjdRadarLinkModel);
}
