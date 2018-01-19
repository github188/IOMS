package cn.com.atnc.ioms.mng.duty.statelliteauto.day;

import java.lang.reflect.InvocationTargetException;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdKuDay;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatTxjdKuDayModel;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;

/**
 * 通信基地-KU卫星专业日检 卫星自检日检业务层接口
 *
 * @author 段衍林
 * @2016年11月11日 下午1:17:16
 */
public interface SatTxjdKuDayService {

	/**
	 * 通信基地-KU卫星专业日检 卫星日检自检分页查询
	 * 
	 * @author 段衍林
	 * @2016年11月11日 下午1:17:37
	 * @param queryModel
	 * @return Pagination
	 */
	Pagination queryPageByModel(SatelliteAutoModel queryModel);

	/**
	 * 通信基地-KU卫星专业日检 冒泡查询
	 * 
	 * @author 段衍林
	 * @2016年11月11日 上午10:04:16
	 * @param queryModel
	 * @return Pagination
	 */
	int getAjaxLoad();

	/**
	 * 保存或更新
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:18:37
	 * @param satTxjdKuDayModel
	 *            MODEL void
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	SatTxjdKuDay saveOrUpdate(SatTxjdKuDayModel satTxjdKuDayModel)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException;
}
