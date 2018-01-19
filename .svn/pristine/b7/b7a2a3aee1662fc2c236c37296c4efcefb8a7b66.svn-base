/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-6-17 下午4:29:12
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package mng.tests.cn.com.atnc.ioms.mng.systemmng.sms;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.mng.clientnotice.sms.ISMSService;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * @author:HuangYijie
 * @date:2014-6-17 下午4:29:12
 * @version:1.0
 */

public class TestSmsService extends MyBaseTransationalTest {
	@Autowired
	private ISMSService smsService;

	@Test
	public void testSend() throws ServiceException {
		try {
			smsService.sendSMS("13811993573",
					"我是一个小小鸟，小呀小小鸟。I am a litte bird,little bird");
		} finally {
			smsService.stopService();

		}
	}

}
