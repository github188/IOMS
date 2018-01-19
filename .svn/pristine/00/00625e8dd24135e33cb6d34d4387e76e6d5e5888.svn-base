package cn.com.atnc.ioms.mng.duty.statellite;

import java.lang.reflect.InvocationTargetException;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satellite.DsPesTesLink;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.DsPesTesLinkModel;

/**
 * 东四-PES-TES链路工作状态 业务层接口
 *
 * @author 段衍林
 * @2016年11月16日 下午2:58:48
 */
public interface DsPesTesLinkService {

	/**
	 * 保存或更新
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:18:37
	 * @param dsPesTesLinkModel
	 *            MODEL void
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	DsPesTesLink saveOrUpdate(DsPesTesLinkModel dsPesTesLinkModel)
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
	DsPesTesLink findById(String id);

	/**
	 * 刪除
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:21:02
	 * @param txjdRadarLinkModel
	 *            MODEL void
	 */
	void delete(DsPesTesLinkModel dsPesTesLinkModel);
}
