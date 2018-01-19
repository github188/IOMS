package cn.com.atnc.ioms.mng.duty.statellitemqy;

import java.lang.reflect.InvocationTargetException;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satellite.Info;
import cn.com.atnc.ioms.model.duty.satelliteinfo.SatelliteInfoModel;
import cn.com.atnc.ioms.model.duty.satelliteinfo.SatelliteInfoQueryModel;

public interface InfoService {

	/**
	 * 卫星备件信息库状态 卫星日检自检分页查询
	 * 
	 * @author 段衍林
	 * @2016年11月15日 下午1:50:02
	 * @param queryModel
	 *            卫星自检model
	 * @return 分页 Pagination
	 */
	Pagination queryPageByModel(SatelliteInfoQueryModel queryModel);

	/**
	 * 卫星备件信息库状态 冒泡查询
	 * 
	 * @author 段衍林
	 * @2016年11月15日 下午1:50:02
	 * @param queryModel
	 * @return Pagination
	 */
	int getAjaxLoad(SatelliteInfoQueryModel queryModel);

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
	Info saveOrUpdate(SatelliteInfoModel info) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException;

	/**
	 * 根据id查询实体
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:19:30
	 * @param id
	 *            实体id
	 * @return SatDsOdu
	 */
	Info findById(String id);

	/**
	 * 根据id查询实体
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:19:30
	 * @param id
	 *            实体id
	 * @return SatDsOdu
	 */
	Info findByIdPagn(String id);

	/**
	 * 刪除
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:21:02
	 * @param txjdRadarLinkModel
	 *            MODEL void
	 */
	void delete(SatelliteInfoModel info);

	/**
	 * 检测sn
	 * 
	 * @author 段衍林
	 * @2016年12月16日 上午10:28:12
	 * @param queryModel
	 *            查询model
	 * @return Boolean
	 */
	Boolean checkSn(SatelliteInfoQueryModel queryModel);

}
