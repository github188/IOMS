package cn.com.atnc.ioms.mng.duty.statelliteauto.day;

import java.lang.reflect.InvocationTargetException;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdOverseaMain;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatTxjdOverseaMainModel;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;

/**
 * 通信基地-境外站-境外站主站载波
 * 业务层接口
 *
 * @author 段衍林
 * @2016年11月11日 下午4:04:32
 */
public interface SatTxjdOverseaMainService  {
	
	/**
	 * 通信基地-境外站-境外站主站载波
	 * 卫星日检自检分页查询 
	 * @author 段衍林
	 * @2016年11月11日 下午4:04:32
	 * @param queryModel 卫星自检model
	 * @return
	 * Pagination
	 */
	Pagination queryPageByModel(SatelliteAutoModel queryModel);
	
	/**
	 * 通信基地-境外站-境外站主站载波
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
	 * @param main
	 *            void
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	SatTxjdOverseaMain saveOrUpdate(SatTxjdOverseaMainModel satTxjdOverseaMainModel) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException;
	
	/**
	 * 删除
	 * @author 段衍林
	 * @2016年11月21日 下午2:12:07
	 * @param satTxjdOverseaMainModel
	 * void
	 */
	void delete(SatTxjdOverseaMainModel satTxjdOverseaMainModel);
}
