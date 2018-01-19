package cn.com.atnc.ioms.mng.faultmng.message.impl;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.mng.faultmng.message.ISendMessageManager;


/**
 * 
 * @author hantianyu
 *
 */
@Service("SendMessageManagerImpl")
public class SendMessageManagerImpl extends BaseService implements
ISendMessageManager{
	
	@Autowired
	@Qualifier("jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	@Autowired
	@Qualifier("jmsTemplateNonPersistent")
	private JmsTemplate  jmsTemplateNonPersistent;
	
	@Autowired
	@Qualifier("iomsQueue")
	private Destination iomsQueue;
	

	/**
	 * 发送信息
	 */
	@Override
	public void sendMessage(String msg) {
		// TODO Auto-generated method stub
		this.jmsTemplate.convertAndSend(iomsQueue, msg);
	}

}
