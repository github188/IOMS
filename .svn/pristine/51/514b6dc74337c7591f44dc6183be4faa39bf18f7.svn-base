package cn.com.atnc.ioms.mng.clientnotice.impl;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.com.atnc.ioms.mng.clientnotice.IEmailService;
import cn.com.atnc.ioms.util.MailUtil;

/**
 * @author:lizhisheng
 * @date:2014-4-22 下午1:43:26
 * @version:1.0
 */
@Service("emailService")
public class EmailServiceImpl implements IEmailService {

	@Value("#{noticeProperties.from}")
	private String from;
	@Value("#{noticeProperties.port}")
	private String serverPort;
	@Value("#{noticeProperties.server}")
	private String serverHost;
	@Value("#{noticeProperties.username}")
	private String username;
	@Value("#{noticeProperties.password}")
	private String password;

	private volatile Boolean status=true;

	@Override
	public boolean sendEMail(String mail, String subject, String content) {
		// TODO Auto-generated method stub

		try {
			MailUtil.sendMail(from, username, password, serverHost, serverPort,
					mail, subject, content);
			this.setStatus(true);
			return true;
		} catch (MessagingException e) {
			this.setStatus(false);
			return false;
		}
	}

	public boolean getEMailStatus() {
		return status;
	}

	public synchronized void setStatus(Boolean status) {
		this.status = status;
	}
}
