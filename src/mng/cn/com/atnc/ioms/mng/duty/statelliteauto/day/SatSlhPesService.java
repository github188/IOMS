package cn.com.atnc.ioms.mng.duty.statelliteauto.day;

import java.lang.reflect.InvocationTargetException;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatSlhPes;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;
import cn.com.atnc.ioms.model.duty.satelliteauto.SlhPesModel;

/**
 * 十里河-PES-PES出境载波状态
 * 卫星自检日检业务层接口
 *
 * @author 段衍林
 * @2016年11月14日 上午11:22:29
 */
public interface SatSlhPesService  {
	
	/**
	 * 十里河-PES-PES出境载波状态
	 * 卫星日检自检分页查询 
	 * @author 段衍林
	 * @2016年11月14日 上午11:22:41
	 * @param queryModel 卫星自检model
	 * @return 分页
	 * Pagination
	 */
	Pagination queryPageByModel(SatelliteAutoModel queryModel);
	
	/**
	 * 十里河-PES-PES出境载波状态
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
	 * @param satTxjdOverseaCdmModel
	 *            void
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	SatSlhPes saveOrUpdate(SlhPesModel slhPesModel) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException;
	
	/**
	 * 删除
	 * @author 段衍林
	 * @2016年11月21日 下午2:12:07
	 * @param satTxjdOverseaCdmModel
	 * void
	 */
	void delete(SlhPesModel slhPesModel);
}
