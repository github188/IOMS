/**
 * @ProjectName IOMS
 * @FileName ILinkAlarmManager.java
 * @PackageName:cn.com.atnc.ioms.mng.basedata.alarm
 * @author KuYonggang
 * @date 2015年3月27日下午5:17:04
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.maintain.pollinginfo;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.KuCarrierFreq;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;
 /**
 * KU载波频率
 *
 * @author wangzhicheng
 * @date 2015-4-27 下午2:41:08
 * @since 1.0.0
 */
public interface KuCarrierFreqManager {

	/**
	 * 查询所有的数据返回页面
	 *
	 * @param queryModel
	 * @return
	 * @throws ServiceException 
	 * @date  2015-5-4下午2:54:34
	 * @since 1.0.0
	*/
	public Pagination queryPage(PollingInfoQueryModel queryModel) throws ServiceException;
	
	/**
	 * 产寻符合条件的数据返回页面
	 *
	 * @param queryModel
	 * @return
	 * @throws ServiceException 
	 * @date  2015-5-4下午2:54:54
	 * @since 1.0.0
	*/
	public Pagination queryViewPage(PollingInfoQueryModel queryModel) throws ServiceException;

	/**
	 * 查询所有数据返回实体List
	 *
	 * @return
	 * @throws ServiceException 
	 * @date  2015-5-4下午2:55:24
	 * @since 1.0.0
	*/
	public List<KuCarrierFreq> findAll() throws ServiceException;

	/**
	 * 更新数据
	 *
	 * @param kuCarrierFreq
	 * @throws ServiceException 
	 * @date  2015-5-4下午2:56:14
	 * @since 1.0.0
	*/
	public void update(KuCarrierFreq kuCarrierFreq) throws ServiceException;

	/**
	 * 查询Equip返回数据分档List
	 *
	 * @return
	 * @throws ServiceException 
	 * @date  2015-5-4下午2:56:37
	 * @since 1.0.0
	*/
	public List<Long> queryEquip()  throws ServiceException;

	/**
	 * 得到需要的数据返回List
	 *
	 * @param kcfli
	 * @return 
	 * @date  2015-5-7上午11:46:17
	 * @since 1.0.0
	*/
	public List<KuCarrierFreq> getKCFList(List<KuCarrierFreq> kcfli);

}
