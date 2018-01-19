package cn.com.atnc.ioms.mng.clientnotice.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.ioms.dao.clientnotice.IClientNoticeDao;
import cn.com.atnc.ioms.entity.BaseUserInfo;
import cn.com.atnc.ioms.entity.clientnotice.SendLog;
import cn.com.atnc.ioms.enums.clientnotice.NoticeState;
import cn.com.atnc.ioms.enums.clientnotice.NoticeType;
import cn.com.atnc.ioms.mng.clientnotice.IClientNoticeManager;
import cn.com.atnc.ioms.mng.clientnotice.IEmailService;
import cn.com.atnc.ioms.mng.clientnotice.sms.ISMSService;
import cn.com.atnc.ioms.mng.systemmng.param.ISystemConfigManager;
import cn.com.atnc.ioms.model.SysFinals;
import cn.com.atnc.ioms.model.clientnotice.ClientNoticeQueryModel;
import cn.com.atnc.ioms.model.clientnotice.Message;

/**
 * @author:lizhisheng
 * @date:2014-4-22 上午10:41:14
 * @version:1.0
 */
@Service("clientNoticeManager")
public class ClientNoticeManagerImpl extends AbstractService implements
		IClientNoticeManager {
	private Queue<Message> queue;

	@Autowired
	private IClientNoticeDao clientNoticeDao;

	@Autowired
	private IEmailService emailService;

	@Autowired
	private ISMSService smsService;

	@Autowired
	@Qualifier(value = "SystemConfigDBManagerImpl")
	private ISystemConfigManager systemConfigManager;

	@PostConstruct
	public void init() {
		if (queue == null) {
			queue = new ConcurrentLinkedQueue<>();
		}
	}

	@Override
	public Pagination queryPage(ClientNoticeQueryModel queryModel) {
		// TODO Auto-generated method stub
		return clientNoticeDao.queryPage(queryModel);
	}

	@Override
	public void sendMessage(final BaseUserInfo client, final String msg) {
		logger.info("-----------------Add to Message Queue -----------------------"
				+ msg);
		queue.add(new Message(client, msg));
		/*System.err.println("开始发送sendLog日志");
		SendLog sendLog = new SendLog(
				client.getMobilephone(), 
				client.getEmail(), 
				NoticeState.SUCCESS, 
				NoticeType.SMS, 
				msg, 
				Calendar.getInstance(), 
				0,
				client.getLoginName(), 
				client.getName(), 
				client.getId());
		clientNoticeDao.saveOrUpdate(sendLog);
		System.err.println("发送sendLog日志结束");*/
	}

	@Scheduled(cron = "0/30 * * * * ?")
	public void sendMessages() {
		// NoticeState noticeState = null;
		// NoticeType noticeType = null;
		// 取出queue的message、
		logger.info("-----------------Message Queue check -----------------------");
		while (true) {
			if (queue.isEmpty()) {
				logger.info("-----------------Message Queue is empty -----------------------");
				break;
			}
			Message message = queue.poll();
			NoticeType type;
			try {
				type = NoticeType.valueOf(systemConfigManager
						.getParam(SysFinals.clientNoticeType));

			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
				type = NoticeType.ALL;
			}
			doSendOnce(getSendLog(message, type));
			logger.info("-----------------SendLog Success -----------------------");
		}
	}

	@Scheduled(cron = "0 * * * * ?")
	public void sendFaildMessage() {
		logger.info("--------------sendFaildMessage check------------------");
		// 从数据库查找发送失败的记录
		List<SendLog> list = findByExcludeNoticeState(NoticeState.SUCCESS);
		for (SendLog sendLog : list) {
			doSendOnce(sendLog);
		}
	}

	private void doSendOnce(SendLog sendLog) {
		switch (sendLog.getNoticeType()) {
		case SMS:
			if (!StringTools.hasText(sendLog.getPhoneNo())) {
				return;
			}
			sendSMS(sendLog);
			break;
		case MAIL:
			if (!StringTools.hasText(sendLog.getEmail())) {
				return;
			}
			sendEmail(sendLog);
			break;
		case ALL:
			if (sendLog.getNoticeState() == null) {
				if (StringTools.hasText(sendLog.getPhoneNo())) {
					if (StringTools.hasText(sendLog.getEmail())) {
						sendAll(sendLog);
					} else {
						sendSMS(sendLog);
					}

				} else {
					if (StringTools.hasText(sendLog.getEmail())) {
						sendEmail(sendLog);
					} else {
						return;
					}
				}
			} else {
				switch (sendLog.getNoticeState()) {
				case SMSFAIL:
					sendSMS(sendLog);
					break;
				case EMAILFAIL:
					sendEmail(sendLog);
					break;
				case ALLFAIL:
					sendAll(sendLog);
					break;
				case SUCCESS:
					break;
				default:
					break;
				}
			}
			break;
		default:
			break;
		}
	}

	private void sendSMS(SendLog sendLog) {
		try {
			if (smsService.sendSMS(sendLog.getPhoneNo(), sendLog.getInfo())) {
				saveOrUpdateClientNoticeLog(sendLog, NoticeState.SUCCESS);
			} else {
				saveOrUpdateClientNoticeLog(sendLog, NoticeState.SMSFAIL);
			}
		} catch (ServiceException e) {
			logger.error(e.getMessage());
			saveOrUpdateClientNoticeLog(sendLog, NoticeState.SMSFAIL);
		}
	}

	private void sendEmail(SendLog sendLog) {
		boolean flag = false;
		try {
			flag = emailService.sendEMail(sendLog.getEmail(), "提醒通知",
					sendLog.getInfo());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			flag = false;
		}
		if (flag) {
			saveOrUpdateClientNoticeLog(sendLog, NoticeState.SUCCESS);
		} else {
			saveOrUpdateClientNoticeLog(sendLog, NoticeState.EMAILFAIL);
		}

	}

	private void sendAll(SendLog sendLog) {
		Boolean emailState = false;
		Boolean smsState = false;
		try {
			smsState = smsService.sendSMS(sendLog.getPhoneNo(),
					sendLog.getInfo());
		} catch (ServiceException e1) {
			e1.printStackTrace();
			smsState = false;
		}
		try {
			emailState = emailService.sendEMail(sendLog.getEmail(), "提醒通知",
					sendLog.getInfo());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			emailState = false;
		}
		if (smsState && emailState) {
			// ALL发送失败记录本次短信邮件均发送成功，则原日志记录更新状态
			saveOrUpdateClientNoticeLog(sendLog, NoticeState.SUCCESS);
		} else if (!smsState && !emailState) {
			// ALL发送失败记录本次短信邮件均发送失败，则原日志记录更新失败次数
			saveOrUpdateClientNoticeLog(sendLog, NoticeState.ALLFAIL);
		} else {
			// 如果本次有一个发送成功，则删除原
			if (!smsState) {
				saveOrUpdateClientNoticeLog(sendLog, NoticeState.SMSFAIL);
			}
			if (!emailState) {
				saveOrUpdateClientNoticeLog(sendLog, NoticeState.EMAILFAIL);
			}
		}
	}

	private SendLog getSendLog(Message message, NoticeType type) {
		SendLog sendLog = new SendLog();
		BaseUserInfo client = message.getUser();
		sendLog.setPhoneNo(client.getMobilephone());
		sendLog.setEmail(client.getEmail());
		sendLog.setInfo(message.getMsg());
		sendLog.setNoticeType(type);
		sendLog.setSendTime(Calendar.getInstance());
		sendLog.setName(client.getName());
		sendLog.setLoginName(client.getLoginName());
		sendLog.setUserId(client.getId());
		return sendLog;
	}

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

	public List<SendLog> findByExcludeNoticeState(NoticeState noticeState) {
		// TODO Auto-generated method stub
		return clientNoticeDao.findByExcludeNoticeState(noticeState);
	}

}
