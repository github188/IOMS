/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName IFtpLinkDao.java
 * @PackageName:cn.com.atnc.ioms.dao.maintain.alarminfo
 * @author ku
 * @date 2015年6月17日下午5:37:01
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.alarminfo;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.maintain.alarminfo.FtpLink;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

/**
 * ftp心跳检测Dao接口
 *
 * @author ku
 * @date 2015年6月17日 下午5:37:01
 * @since 1.0.0
 */
public interface IFtpLinkDao extends IBaseDao<FtpLink> {

	/**
	 * 根据代理站点ID获取ftp心跳检测对象
	 *
	 * @param id
	 * @return 
	 * @author ku
	 * @date  2015年6月17日下午5:42:29
	 * @since 1.0.0
	 */
	public FtpLink findByProxyId(String id);

	/**
	 * 查询页面
	 *
	 * @param queryModel
	 * @return 
	 * @date  2015-7-14下午3:16:12
	 * @since 1.0.0
	*/
	public Pagination queryPage(AlarmInfoQueryModel queryModel);

}
