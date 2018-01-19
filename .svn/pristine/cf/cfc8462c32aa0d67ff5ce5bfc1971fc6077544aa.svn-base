/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName FtpLinkDaoImpl.java
 * @PackageName:cn.com.atnc.ioms.dao.maintain.alarminfo.hibernate
 * @author ku
 * @date 2015年6月17日下午5:37:47
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.alarminfo.hibernate;

import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.maintain.alarminfo.IFtpLinkDao;
import cn.com.atnc.ioms.entity.maintain.alarminfo.FtpLink;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

/**
 * ftp心跳检测Dao接口实现类
 *
 * @author ku
 * @date 2015年6月17日 下午5:37:47
 * @since 1.0.0
 */
@Repository
public class FtpLinkDaoImpl extends MyBaseDao<FtpLink> implements IFtpLinkDao {

	@Override
	public FtpLink findByProxyId(String id) {
		return this.findByParam("proxyId.id", id);
	}

	@Override
	public Pagination queryPage(AlarmInfoQueryModel queryModel) {
		return null;
	}
}
