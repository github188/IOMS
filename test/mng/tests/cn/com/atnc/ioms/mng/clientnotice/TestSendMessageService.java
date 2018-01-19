/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-5-22 下午1:31:05
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package mng.tests.cn.com.atnc.ioms.mng.clientnotice;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.ioms.mng.clientnotice.impl.SendMessageServiceImpl;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;


/**
 * @author:HuangYijie
 * @date:2014-5-22 下午1:31:05
 * @version:1.0
 */

public class TestSendMessageService extends MyBaseTransationalTest {

	@Autowired
	private SendMessageServiceImpl smsService;

	@Test
	public void testSendSMS() {
		smsService.send("fsfsd", "18600574757");
	}
}
