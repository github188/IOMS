/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-6-17 下午3:42:31
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.clientnotice.sms;

import org.smslib.Service.ServiceStatus;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.clientnotice.SendLog;
import cn.com.atnc.ioms.enums.clientnotice.NoticeState;

/**
 * @author:HuangYijie
 * @date:2014-6-17 下午3:42:31
 * @version:1.0
 */

public interface ISMSService {

	/**
	 * 发送短信到指定手机号
	 * 
	 * @author:HuangYijie
	 * @Date:2014-6-19 上午9:11:03
	 * 
	 * @param mobile
	 * @param content
	 * @return boolean
	 */
	public boolean sendSMS(String mobile, String content)
			throws ServiceException;

	/**
	 * 批量发送短信给指定角色的用户
	 * 
	 * @author duanyanlin
	 * @date 2016年10月25日上午9:52:42
	 * @param content
	 *            短信内容
	 * @param roleName
	 *            用户角色名称
	 */
	public void sendSMSByRoleName(String roleName, String content);

	/**
	 * 连接短信猫
	 * 
	 * @author:HuangYijie
	 * @Date:2014-6-19 上午9:10:54
	 * 
	 * @throws ServiceException
	 *             void
	 */
	public void startService() throws ServiceException;

	/**
	 * 关闭短信猫连接
	 * 
	 * @author:HuangYijie
	 * @Date:2014-6-19 上午9:11:12
	 * 
	 * @throws ServiceException
	 *             void
	 */
	public void stopService() throws ServiceException;

	/**
	 * 获取当前短信猫连接状态
	 * 
	 * @author:HuangYijie
	 * @Date:2014-6-19 上午9:11:23
	 * 
	 * @return ServiceStatus
	 */
	public ServiceStatus getServiceStatus();

	/**
	 * 记录发送短信的日志
	 * 
	 * @author 段衍林
	 * @2016年11月23日 上午9:56:21
	 * @param sendLog
	 * @param state
	 *            void
	 */
	public void saveOrUpdateClientNoticeLog(SendLog sendLog, NoticeState state);

}
