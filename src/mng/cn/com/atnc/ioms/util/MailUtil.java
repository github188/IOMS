package cn.com.atnc.ioms.util;



import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * @author:lizhisheng
 * @date:2014-4-21 上午9:18:37
 * @version:1.0
 */
public class MailUtil {

	/**
	 * 发送单个邮件
	 * @version 1.0
	 * @param from：发送者邮箱地址
	 * @param username：发送者登录邮箱的用户名
	 * @param password：发送者登录邮箱的密码
	 * @param serverHost：发送邮件服务器的地址
	 * @param serverPort：发送邮件服务器的服务端口号
	 * @param to：接收邮件的用户地址
	 * @param subject：邮件主题
	 * @param content：邮件内容
	 * @throws MessagingException 
	 * void
	 */
	public static void sendMail(String from, String username, String password,
			String serverHost, String serverPort, String to,
			String subject, String content) throws MessagingException {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", serverHost);
		prop.put("mail.smtp.port", serverPort);
		prop.put("mail.smtp.auth", "true");
		// 身份认证，创建一个密码验证器
		final String sender_username = username;
		final String sender_password = password;
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender_username, sender_password);
			}
		};
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session
				.getDefaultInstance(prop, authenticator);
		// 根据session创建一个邮件消息
		Message mailMessage = new MimeMessage(sendMailSession);
		// 创建邮件发送者地址
		Address fromAddress = new InternetAddress(from);
		// 设置邮件消息的发送者
		mailMessage.setFrom(fromAddress);
		// 创建邮件的接收者地址，并设置到邮件消息中
		Address toAddress = new InternetAddress(to);
		mailMessage.setRecipient(Message.RecipientType.TO, toAddress);
		// 设置邮件消息的主题
		mailMessage.setSubject(subject);
		// 设置邮件消息发送的时间
		mailMessage.setSentDate(new Date());
		// 设置邮件消息的主要内容
		mailMessage.setText(content);
		// 发送邮件
		Transport.send(mailMessage);
	}

	/**
	 * 邮件群发
	 * @version 1.0
	 * @param from：发送者邮箱地址
	 * @param username：发送者登录邮箱的用户名
	 * @param password：发送者登录邮箱的密码
	 * @param serverHost：发送邮件服务器的地址
	 * @param serverPort：发送邮件服务器的服务端口号
	 * @param tos：接收邮件的用户地址列表
	 * @param subject：邮件主题
	 * @param content：邮件内容
	 * @throws MessagingException 
	 * void
	 */
	public static void sendMails(String from, String username, String password,
			String serverHost, String serverPort, List<String> tos,
			String subject, String content) throws MessagingException {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", serverHost);
		prop.put("mail.smtp.port", serverPort);
		prop.put("mail.smtp.auth", "true");
		// 身份认证，创建一个密码验证器
		final String sender_username = username;
		final String sender_password = password;
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender_username, sender_password);
			}
		};
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session
				.getDefaultInstance(prop, authenticator);
		// 根据session创建一个邮件消息
		Message mailMessage = new MimeMessage(sendMailSession);
		// 创建邮件发送者地址
		Address fromAddress = new InternetAddress(from);
		// 设置邮件消息的发送者
		mailMessage.setFrom(fromAddress);
		// 创建邮件的接收者地址，并设置到邮件消息中
		Address[] to = new InternetAddress[tos.size()];
		for(int i=0;i<tos.size();i++){
			to[i] = new InternetAddress(tos.get(i));
		}
		mailMessage.setRecipients(Message.RecipientType.BCC, to);
		// 设置邮件消息的主题
		mailMessage.setSubject(subject);
		// 设置邮件消息发送的时间
		mailMessage.setSentDate(new Date());
		// 设置邮件消息的主要内容
		mailMessage.setText(content);
		// 发送邮件
		Transport.send(mailMessage);
	}

}
