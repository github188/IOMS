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

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.KuNodeParameter;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;
 /**
 * odu
 *
 * @author wangzhicheng
 * @date 2015-4-27 下午2:41:08
 * @since 1.0.0
 */
public interface KuNodeParameterManager {

	/**
	 * 查询符合条件的数据返回页面
	 *
	 * @param queryModel
	 * @return
	 * @throws ServiceException 
	 * @date  2015-5-4下午3:01:37
	 * @since 1.0.0
	*/
	public Pagination queryPage(PollingInfoQueryModel queryModel) throws ServiceException;

	/**
	 * 通过ID查找实体
	 *
	 * @param id
	 * @return 
	 * @date  2015-5-4下午3:02:52
	 * @since 1.0.0
	*/
	public KuNodeParameter findById(String id);

	/**
	 * 查询指定实体返回view页面
	 *
	 * @param queryModel
	 * @return
	 * @throws ServiceException 
	 * @date  2015-5-4下午3:02:26
	 * @since 1.0.0
	*/
	public Pagination queryViewPage(PollingInfoQueryModel queryModel) throws ServiceException;

}
