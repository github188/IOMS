package cn.com.atnc.ioms.mng.duty.statellitemqy;

import java.lang.reflect.InvocationTargetException;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satellite.ToolLib;
import cn.com.atnc.ioms.model.duty.satellitetool.SatelliteToolModel;
import cn.com.atnc.ioms.model.duty.satellitetool.SatelliteToolQueryModel;

/**
 * 卫星工具库业务层接口
 *
 * @author 段衍林
 * @2016年11月29日 上午11:15:11
 */
public interface ToolLibService {

	/**
	 * 卫工具信息库状态 卫星日检自检分页查询
	 * 
	 * @author 段衍林
	 * @2016年11月15日 下午1:50:02
	 * @param queryModel
	 *            卫星自检model
	 * @return 分页 Pagination
	 */
	Pagination queryPageByModel(SatelliteToolQueryModel queryModel);

	/**
	 * 卫星备件信息库状态 冒泡查询
	 * 
	 * @author 段衍林
	 * @2016年11月15日 下午1:50:02
	 * @param queryModel
	 * @return Pagination
	 */
	int getAjaxLoad(SatelliteToolQueryModel queryModel);

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
	ToolLib saveOrUpdate(SatelliteToolModel tool)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException;

	/**
	 * 根据id查询实体
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:19:30
	 * @param id
	 *            实体id
	 * @return SatDsOdu
	 */
	ToolLib findById(String id);

	/**
	 * 根据id查询实体
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:19:30
	 * @param id
	 *            实体id
	 * @return SatDsOdu
	 */
	ToolLib findByIdPagn(String id);

	/**
	 * 刪除
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:21:02
	 * @param txjdRadarLinkModel
	 *            MODEL void
	 */
	void delete(SatelliteToolModel tool);
}
