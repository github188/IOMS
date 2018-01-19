/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-6-5 下午4:39:16
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package dao.tests.cn.com.atnc.ioms.dao.operstat.cu;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.ioms.dao.operstat.tes.ITesStatDao;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * @author:HuangYijie
 * @date:2014-6-5 下午4:39:16
 * @version:1.0
 */

public class TestTesStatDao extends MyBaseTransationalTest {

	@Autowired
	private ITesStatDao dao;

	@Test
	public void test() {
		Map<String, Integer> map = dao.tesSlotWarningList();
		for (String key : map.keySet()) {
			System.out.println(key + map.get(key));
		}
	}
}
