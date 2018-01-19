/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-6-17 下午3:44:10
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.clientnotice.sms;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PreDestroy;

import org.apache.commons.collections.CollectionUtils;
import org.smslib.Service.ServiceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.ioms.dao.clientnotice.IClientNoticeDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.clientnotice.SendLog;
import cn.com.atnc.ioms.enums.clientnotice.NoticeState;
import cn.com.atnc.ioms.enums.clientnotice.NoticeType;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.util.sms.SmsUtils;

/**
 * @author:HuangYijie
 * @date:2014-6-17 下午3:44:10
 * @version:1.0
 */
@Service("SMSService")
public class SMSService extends AbstractService implements ISMSService {

	@Value("#{smsProperties.comPort}")
	private String comPort; // 串口号
	@Value("#{smsProperties.baudRate}")
	private String baudRate;// 波特率
	@Value("#{smsProperties.manufacturer}")
	private String manufacturer;// 制造商
	@Value("#{smsProperties.model}")
	private String model;// 型号
	@Autowired
	private IUserManager userManager;
	@Autowired
	private IClientNoticeDao clientNoticeDao;

	public ServiceStatus getServiceStatus() {
		return org.smslib.Service.getInstance().getServiceStatus();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @throws ServiceException
	 * 
	 * @see cn.com.atnc.ioms.mng.clientnotice.sms.ISMSService#sendSMS(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public boolean sendSMS(String mobile, String content)
			throws ServiceException {
		if (!StringTools.hasText(mobile)) {
			throw new ServiceException("手机号不能为空");
		}
		if (!StringTools.hasText(content)) {
			throw new ServiceException("短信内容不能为空");
		}
		try {
			startService();
			return SmsUtils.sendMessage(mobile, content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			return false;
		}

	}

	@Override
	public void sendSMSByRoleName(String roleName, String content) {
		// 根据角色名称查询用户列表
		List<User> users = userManager.getUserByRole(roleName);
		try {
			if (CollectionUtils.isNotEmpty(users)) {
				for (User user : users) {
					// 发送信息
					boolean flag = this.sendSMS(user.getMobilephone(), content);
					SendLog sendLog = new SendLog(user.getMobilephone(),
							user.getEmail(), NoticeState.SUCCESS,
							NoticeType.SMS, content, Calendar.getInstance(), 0,
							user.getLoginName(), user.getName(), user.getId());
					if (flag) {
						saveOrUpdateClientNoticeLog(sendLog,
								NoticeState.SUCCESS);
					} else {
						saveOrUpdateClientNoticeLog(sendLog,
								NoticeState.SMSFAIL);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.clientnotice.sms.ISMSService#startService()
	 */
	@Override
	public void startService() throws ServiceException {
		// TODO Auto-generated method stub
		switch (org.smslib.Service.getInstance().getServiceStatus()) {
		case STOPPED:
			try {
				SmsUtils.startService(comPort, baudRate, manufacturer, model);
			} catch (Exception e) {
				logger.error("短信猫启动失败：" + e.getMessage());
				throw new ServiceException(e.getMessage());
			}
			break;
		case STARTED:
			break;
		case STARTING:
			break;
		// throw new ServiceException("正在连接短信猫，无法发送短信！");
		default:
			break;
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.clientnotice.sms.ISMSService#stopService()
	 */
	@Override
	@PreDestroy
	public void stopService() throws ServiceException {
		// TODO Auto-generated method stub
		try {
			SmsUtils.stopService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * 记录发送短信的日志
	 * 
	 * @author 段衍林
	 * @2016年11月23日 上午9:50:39
	 * @param sendLog
	 * @param state
	 *            void
	 */
	public void saveOrUpdateClientNoticeLog(SendLog sendLog, NoticeState state) {
		sendLog.setSendTime(Calendar.getInstance());
		sendLog.setNoticeState(state);
		switch (state) {
		case SUCCESS:
			break;
		case SMSFAIL:
		case EMAILFAIL:
		case ALLFAIL:
			sendLog.setFailedTimes(sendLog.getFailedTimes() + 1);
			break;
		default:
			break;
		}
		clientNoticeDao.saveOrUpdate(sendLog);
	}

}
