/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:41:34
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package dao.tests.cn.com.atnc.ioms.dao.faultmng;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultInformationDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.faultmng.FaultInformation;
import cn.com.atnc.ioms.enums.faultmng.FaultEventType;
import cn.com.atnc.ioms.enums.faultmng.FaultStatus;
import cn.com.atnc.ioms.model.faultmng.FaultHandleQueryModel;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * 测试故障单信息数据库操作
 * @author duanyanlin
 * 2016年7月6日 下午3:57:59
 */
public class TestFaultInformationDao extends MyBaseTransationalTest {
	
	@Autowired
	private IFaultInformationDao faultInformationDao;
	@Autowired
	private IUserDao userDao;

	/**
	 * 测试增删改查
	 * @author duanyanlin
	 * @date 2016年7月6日下午3:57:54
	 */
	@Test
	public void testADUQ() {
		User user = this.userDao.findById("admin");
		//增加
		FaultInformation faultInformation = new FaultInformation();
		faultInformation.setId("1");
		faultInformation.setFirstHandelUser(user);
		faultInformation.setFaultNumber("1");
		faultInformation.setFaultChildNumber(0);
		faultInformation.setTelephoneNumber("010-00000001");
		faultInformation.setContactsName("测试联系人");
		faultInformation.setPickUpPhoneTime(new Date());
		faultInformation.setEventType(FaultEventType.ENVIRONMENT);
		faultInformationDao.save(faultInformation);
		//修改
		faultInformation.setFaultNumber("2");
		faultInformationDao.update(faultInformation);
		//删除
		faultInformationDao.delete(faultInformation);
	}
	
	/**
	 * 测试列表查询
	 * @author duanyanlin
	 * @date 2016年7月6日下午4:25:52
	 */
	@Test
	public void testQueryList(){
		FaultHandleQueryModel qm = new FaultHandleQueryModel();
		qm.setFaultId("1");
		qm.setContactsName("测试");
		qm.setEventType(FaultEventType.ENVIRONMENT);
		List<FaultStatus> faultStatus = new ArrayList<FaultStatus>();
		faultStatus.add(FaultStatus.ASSIGN);
		qm.setFaultStatus(faultStatus);
		faultInformationDao.queryList(qm);
	}
}
