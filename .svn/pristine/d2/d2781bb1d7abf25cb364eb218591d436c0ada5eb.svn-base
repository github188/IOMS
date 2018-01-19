package cn.com.atnc.ioms.mng.duty.statelliteauto.day;

import java.lang.reflect.InvocationTargetException;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdTesODU;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatTxjdTesOduModel;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;

/**
 * 通信基地-TES-TES ODU状态
 * 卫星自检日检业务层接口
 *
 * @author 段衍林
 * @2016年11月11日 上午10:04:09
 */
public interface SatTxjdTesODUService  {
	
	/**
	 * 通信基地-TES-TES ODU状态
	 * 分页查询
	 * @author 段衍林
	 * @2016年11月11日 上午10:04:16
	 * @param queryModel
	 * @return
	 * Pagination
	 */
	Pagination queryPageByModel(SatelliteAutoModel queryModel);
	
	/**
	 * 通信基地-TES-TES ODU状态
	 * 冒泡查询
	 * @author 段衍林
	 * @2016年11月11日 上午10:04:16
	 * @param queryModel
	 * @return
	 * Pagination
	 */
	int getAjaxLoad();
	
	/**
	 * 保存或更新
	 * 
	 * @author 段衍林
	 * @2016年11月21日 下午1:27:55
	 * @param occ
	 *            void
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	SatTxjdTesODU saveOrUpdate(SatTxjdTesOduModel satTxjdTesOduModel) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException;
	
	/**
	 * 删除
	 * @author 段衍林
	 * @2016年11月21日 下午2:12:07
	 * @param satTxjdTesOccModel
	 * void
	 */
	void delete(SatTxjdTesOduModel satTxjdTesOduModel);
}
