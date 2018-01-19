package cn.com.atnc.ioms.mng.maintain.alarminfo;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.maintain.alarminfo.FtpLink;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

 /**
 * FTP站点告警信息Service
 *
 * @author wangzhicheng
 * @date 2015-7-14 下午3:11:23
 * @since 1.0.0
 */
public interface IFTPAlarmManager {

	/**
	 * 查出所有的FtpLink返回List
	 *
	 * @return 
	 * @date  2015-7-15上午9:49:01
	 * @since 1.0.0
	*/
	public List<FtpLink> getAll();

	/**
	 * 查询返回页面值
	 *
	 * @param queryModel
	 * @return
	 * @throws ServiceException 
	 * @date  2015-7-15上午9:49:51
	 * @since 1.0.0
	*/
	public Pagination queryPage(AlarmInfoQueryModel queryModel) throws ServiceException;

	/**
	 * 根据ID查找实体
	 *
	 * @param id
	 * @return 
	 * @date  2015-7-15上午9:50:08
	 * @since 1.0.0
	*/
	public FtpLink findById(String id);
}
