package cn.com.atnc.ioms.util.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smslib.Message.MessageEncodings;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;

public class SmsUtils {
	protected static Logger logger = LoggerFactory.getLogger(SmsUtils.class);
	private static String smsName = "modem.atnc";
	private static String simPin = "0000";

	public synchronized static void startService(String comPort, String baudRate,
			String manufacturer, String model) throws Exception {
		logger.info("--------startService----------");
		OutboundNotification outboundNotification = new OutboundNotification();
		SerialModemGateway gateway = new SerialModemGateway(smsName, comPort,
				Integer.parseInt(baudRate), manufacturer, model);
		gateway.setInbound(true);
		gateway.setOutbound(true);
		gateway.setSimPin(simPin);
		Service.getInstance().setOutboundMessageNotification(
				outboundNotification);
		Service.getInstance().addGateway(gateway);
		Service.getInstance().startService();
	}

	public synchronized static boolean sendMessage(String phone, String message)
			throws Exception {
		logger.info("--------sendMessage----------");
		OutboundMessage msg = new OutboundMessage(phone, message);
		msg.setEncoding(MessageEncodings.ENCUCS2);
		return Service.getInstance().sendMessage(msg);
	}

	public synchronized static void stopService() throws Exception {
		logger.info("--------stopService----------");
		Service.getInstance().stopService();
	}

}
