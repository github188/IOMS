/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:43:52
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package dao.tests.cn.com.atnc.ioms.dao.basedata.ku.service;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.cn.com.atnc.common.MyBaseTransationalTest;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.common.util.json.JsonTools;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuServiceDao;
import cn.com.atnc.ioms.entity.basedata.ku.KuService;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;

/**
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:43:52
 */

public class TestKuServiceDao extends MyBaseTransationalTest {

	@Autowired
	private IKuNodeDao kuNodeDao;
	@Autowired
	private IKuServiceDao kuServiceDao;

	@Test
	public void testADMS() throws IOException {
		// 增加
		KuStatQueryModel qm = new KuStatQueryModel();
		qm.setRxNodeNo("35");
		List<KuService> kuServices = kuServiceDao.queryList(qm);
		System.out.println(JacksonTools.toJsonStr(kuServices));

		System.out.println(new KuService().toJson());
	}

	public static void main(String[] args) throws IOException {
		String sss = "{\"rxNodeNo\":\"1\",\"rxChan\":\"1\",\"rxGib\":\"1\",\"txNodeNo\":\"0\",\"txChan\":\"1\",\"txGib\":\"1\",\"start\":233,\"recordTime\":\"2014-12-12 12:12:12\",\"rateTypeSize\":644,\"circuitType\":\"PAMA\",\"circuitTypeDetail\":\"Multi\",\"complete\":false,\"rateType\":\"192.0Kbps Data\",\"cxr\":\"1\",\"fec\":\"1/2\",\"id\":\"da0c909d4b384884b6b5e8e125d390b7\"}";
		KuService service = JacksonTools.json2Object(sss, KuService.class);
		System.out.println(JacksonTools.toJsonStr(service));
		System.out.println(JsonTools.fromObject(service));

	}
}
