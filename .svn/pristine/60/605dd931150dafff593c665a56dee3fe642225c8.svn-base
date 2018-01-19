package cn.com.atnc.ioms.mng.duty.statelliteauto.day;

import java.lang.reflect.InvocationTargetException;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatDsOdu;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;
import cn.com.atnc.ioms.model.duty.statellite.day.OduStateModel;

/**
 * 东四-PES-TES民航局ODU状态 卫星自检日检业务层接口
 *
 * @author 段衍林
 * @2016年11月15日 下午1:50:02
 */
public interface SatDsOduService {

	/**
	 * 东四-PES-TES民航局ODU状态 卫星日检自检分页查询
	 * 
	 * @author 段衍林
	 * @2016年11月15日 下午1:50:02
	 * @param queryModel
	 *            卫星自检model
	 * @return 分页 Pagination
	 */
	Pagination queryPageByModel(SatelliteAutoModel queryModel);

	/**
	 * 东四-PES-TES民航局ODU状态 冒泡查询
	 * 
	 * @author 段衍林
	 * @2016年11月15日 下午1:50:02
	 * @param queryModel
	 * @return Pagination
	 */
	int getAjaxLoad(SatelliteAutoModel queryModel);

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
	SatDsOdu saveOrUpdate(OduStateModel oduStateModel)
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
	SatDsOdu findById(String id);

	/**
	 * 根据id查询实体
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:19:30
	 * @param id
	 *            实体id
	 * @return SatDsOdu
	 */
	SatDsOdu findByIdPagn(String id);

	/**
	 * 刪除
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:21:02
	 * @param txjdRadarLinkModel
	 *            MODEL void
	 */
	void delete(OduStateModel oduStateModel);
}
