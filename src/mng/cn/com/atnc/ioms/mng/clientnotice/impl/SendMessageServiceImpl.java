package cn.com.atnc.ioms.mng.clientnotice.impl;

import org.springframework.stereotype.Service;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.mng.clientnotice.ISendMessageService;
import cn.com.atnc.ioms.mng.clientnotice.SendSMSService;

/**
 * @author:lizhisheng
 * @date:2014-4-21 上午9:16:17
 * @version:1.0
 */
@Service("sendMessageService")
public class SendMessageServiceImpl extends AbstractService implements
		ISendMessageService {

	// public Queue<String> queue = new ConcurrentLinkedQueue<String>();
	public int send(String str, String phoneNo) {
		int send_result = 0;

		try {
			// 建立发送短信的连接，指定端口号为COM3，成功则返回1，失败则返回0
			int tmp2 = SendSMSService.INSTANCE.LinkModem(3);
			if (tmp2 == 1) {
				// 将短信字符串用GBK编码格式进行编译，以防止出现乱码
				String tmp = new String(str.getBytes(), "GBK");
				String pno = phoneNo;
				// message.setContent(tmp);
				// 获取短信的长度
				int len = tmp.length();
				// 分成短信的条数
				int size = len / 70 + 1;
				// 新建一个短信的字符数组，存放分块之后的短信内容
				String[] tmps = new String[size];
				for (int i = 0; i < size; i++) {
					// 将短信分成若干条字数至多为70。
					if ((i + 1) * 70 > tmp.length()) {
						tmps[i] = tmp.substring(i * 70, len);
					} else {
						tmps[i] = tmp.substring(i * 70, (i + 1) * 70);
					}
					// 调用短信猫发送短信
					for (int j = 0; j < 3; j++) {
						if (send_result == 0) {
							send_result = SendSMSService.INSTANCE.SendSMS(
									SendSMSService.INSTANCE.GetService(), pno,
									tmps[i]);
						}

					}
					// 短信发送之间的等待时间。
					if (size > 1)
						Thread.sleep(2000);

				}
				// 关闭连接
				SendSMSService.INSTANCE.CloseModem(3);
			} else {
				throw new ServiceException("未能正常使用短信猫发送短信，请检查短信猫设置问题");
			}
		} catch (Exception e) {
			return 0;
		}
		return send_result;
	}

}
