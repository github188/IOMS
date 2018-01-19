/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-5-22 下午1:37:45
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package mng.tests.cn.com.atnc.ioms.mng.clientnotice;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.mng.clientnotice.sms.ISMSService;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * @author:HuangYijie
 * @date:2014-5-22 下午1:37:45
 * @version:1.0
 */

public class TestModen extends MyBaseTransationalTest {
	@Autowired
	private ISMSService smsService;

	@Test
	public void testSend() throws ServiceException {
		smsService.sendSMS("18600574757", "fdsafdsaffjosa");
	}
}
