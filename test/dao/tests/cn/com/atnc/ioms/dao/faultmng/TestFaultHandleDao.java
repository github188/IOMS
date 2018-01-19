/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:43:52
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package dao.tests.cn.com.atnc.ioms.dao.faultmng;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;
import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultHandleDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.faultmng.FaultHandle;
import cn.com.atnc.ioms.enums.faultmng.FaultHandelType;
import cn.com.atnc.ioms.model.faultmng.FaultHandleQueryModel;

/**
 * 测试故障处置记录数据库管理
 * @author duanyanlin
 * 2016年7月6日 下午4:29:09
 */

public class TestFaultHandleDao extends MyBaseTransationalTest {
	@Autowired
	private IFaultHandleDao faultHandleDao;
	@Autowired
	private IUserDao userDao;

	/**
	 * 增删改查
	 * @author duanyanlin
	 * @date 2016年7月6日下午4:29:50
	 */
	@Test
	public void testADUQ() {
		// 增加
		FaultHandle faultHandle = new FaultHandle();
		faultHandle.setId("1");
		faultHandle.setFaultId("1");
		faultHandle.setFaultNumber("FM00001");
		
		faultHandleDao.saveOrUpdate(faultHandle);
		faultHandleDao.findById("user");
		// 修改
		faultHandleDao.findById("user");
		// 删除
		faultHandleDao.delete(faultHandle);
		faultHandleDao.findById("user");
	}
	@Test
	public void testQueryList(){
		User user = userDao.findById("admin");
		
		//根据操作人和故障单id查询故障处置记录
		FaultHandleQueryModel qm0 = new FaultHandleQueryModel();
		qm0.setFaultId("1");
		qm0.setCurrentUser(user);
		faultHandleDao.queryList(qm0);
		
		//根据faultId和操作类型（ASSIGN）查询处置记录(最新的记录为部门经理分配记录)
		FaultHandleQueryModel qm1 = new FaultHandleQueryModel();
		qm1.setFaultId("1");
		qm1.setFaultHandelType(FaultHandelType.ASSIGN);
		faultHandleDao.queryList(qm1);
	}
}
