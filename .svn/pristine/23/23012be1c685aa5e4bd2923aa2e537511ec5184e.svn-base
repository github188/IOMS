package mng.tests.cn.com.atnc.ioms.mng.faultmng;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultHandleDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultInformationDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.faultmng.FaultInformation;
import cn.com.atnc.ioms.enums.faultmng.FaultEventType;
import cn.com.atnc.ioms.enums.faultmng.FaultLevelType;
import cn.com.atnc.ioms.enums.faultmng.FaultStatus;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;
import cn.com.atnc.ioms.mng.faultmng.IFaultInformationMngService;
import cn.com.atnc.ioms.mng.faultmng.IFaultMngWorkflowService;
import cn.com.atnc.ioms.model.SysFinals;
import cn.com.atnc.ioms.model.faultmng.FaultHandleQueryModel;
import cn.com.atnc.ioms.model.faultmng.FaultInformationModel;

/**
 * 故障单service测试类
 * @author duanyanlin
 * 2016年7月6日 下午3:54:11
 */
public class TestFaultInformationMngService extends MyBaseTransationalTest {
	@Autowired
	private IFaultInformationDao faultInformationDao;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IFaultInformationMngService faultInformationService;
	@Autowired
	private IFaultMngWorkflowService faultMngWorkflow;
	@Autowired
	private IFaultHandleDao faultHandleDao;
	
	/**
	 * 添加新故障单备用
	 * @author duanyanlin
	 * @date 2016年7月14日下午1:34:01
	 * @return
	 * @throws ServiceException 
	 */
	public FaultInformation addTestFault() throws ServiceException{
		User user = userDao.findById("admin");
		FaultInformationModel faultModel = new FaultInformationModel();
		faultModel.setFaultCompany("北京网控中心");
		faultModel.setContactsName("测试申告人");
		faultModel.setTelephoneNumber("010-00000001");
		faultModel.setStationPhone("18800001111");
		faultModel.setFaultTime("2016-07-06 08:44:20");
		faultModel.setPickUpPhoneTime("2016-07-07 08:44:20");
		faultModel.setFaultArea("北京网控中心");
		faultModel.setEventType(FaultEventType.ENVIRONMENT);
		faultModel.setCurrentUser(user);					//当前处理人，添加故障单时，把其设置为第一处理人，当前处理人两类
		faultModel.setFaultLevel(FaultLevelType.B);
		faultModel.setFirstOrNot(SysFinals.YES);
		faultModel.setIsRight(SysFinals.YES);
		FaultInformation fault = faultInformationService.saveFaultInformation(faultModel);
		System.err.println(fault);
		return fault;
	}
	
	/**
	 * 分页查询单元测试
	 * @author duanyanlin
	 * @date 2016年7月8日下午4:19:00
	 */
	@Test
	public void testQueryPage(){
		FaultHandleQueryModel qm = new FaultHandleQueryModel();
		faultInformationService.queryPage(qm);
	}
	
	/**
	 * 测试故障单列表(统计模块使用)
	 * @author duanyanlin
	 * @date 2016年7月7日上午9:11:56
	 */
	@Test
	public void testFaultList(){
		User user = userDao.findById("admin");
		//查询全部故障单
		FaultHandleQueryModel qm = new FaultHandleQueryModel();
		//由于故障单过多，只查询部分故障单
		qm.setFaultArea("北京网控中心");
		qm.setFirstHandleUser(user);
		qm.setContactsName("测试申告");
		faultInformationService.queryFaultList(qm);
	}
	/**
	 * 测试故障单列表
	 * @author duanyanlin
	 * @date 2016年7月7日上午9:11:56
	 */
	@Test
	public void testQueryList(){
		FaultHandleQueryModel qm = new FaultHandleQueryModel();
		User user = userDao.findById("admin");
		qm.setCurrentUser(user);
		List<FaultStatus> faultStatus = new ArrayList<FaultStatus>();
		faultStatus.add(FaultStatus.ASSIGN);
		qm.setDutyPlace(DutyPlaceEnum.COMMUNICATION);
		qm.setFaultStatus(faultStatus);
		faultInformationService.queryList(qm);
		
		FaultHandleQueryModel qm1 = new FaultHandleQueryModel();
		qm1.setCurrentUser(user);
		List<FaultStatus> faultStatus1 = new ArrayList<FaultStatus>();
		faultStatus1.add(FaultStatus.HANGUP);
		qm1.setFaultStatus(faultStatus1);
		qm1.setDutyPlace(DutyPlaceEnum.COMMUNICATION);
		faultInformationService.queryList(qm1);
	}
	
	/**
	 * 测试添加故障单
	 * @author duanyanlin
	 * @throws ServiceException 
	 * @date 2016年7月6日下午4:25:52
	 */
	@Test
	public void testAddFault() throws ServiceException{
		User user = userDao.findById("admin");
		FaultInformationModel faultModel = new FaultInformationModel();
		faultModel.setFaultCompany("北京网控中心");
		faultModel.setContactsName("测试申告人");
		faultModel.setTelephoneNumber("010-00000001");
		faultModel.setStationPhone("18800001111");
		faultModel.setFaultTime("2016-07-06 08:44:20");
		faultModel.setPickUpPhoneTime("2016-07-07 08:44:20");
		faultModel.setFaultArea("北京网控中心");
		faultModel.setEventType(FaultEventType.ENVIRONMENT);
		faultModel.setCurrentUser(user);					//当前处理人，添加故障单时，把其设置为第一处理人，当前处理人两类
		faultModel.setFaultLevel(FaultLevelType.B);
		faultModel.setFirstOrNot(SysFinals.YES);
		faultModel.setIsRight(SysFinals.YES);
		faultInformationService.saveFaultInformation(faultModel);
	}
	/**
	 * 测试故障单删除
	 * @author duanyanlin
	 * @throws ServiceException 
	 * @date 2016年7月7日上午9:11:56
	 */
	@Test
	public void testEditFaultInformation() throws ServiceException{
		User user = userDao.findById("admin");
		FaultInformation fault = this.addTestFault();
		FaultInformationModel faultModel = new FaultInformationModel();
		faultModel.setFaultId(fault.getId());
		faultModel.setFaultCompany("北京网控中心修改");
		faultModel.setContactsName("测试申告人");
		faultModel.setTelephoneNumber("010-00000001");
		faultModel.setStationPhone("18800001111");
		faultModel.setFaultTime("2016-07-06 08:44:20");
		faultModel.setPickUpPhoneTime("2016-07-07 08:44:20");
		faultModel.setFaultArea("北京网控中心");
		faultModel.setRemark("测试修改");
		faultModel.setEventType(FaultEventType.ENVIRONMENT);
		faultModel.setFaultLevel(FaultLevelType.B);
		faultModel.setFirstOrNot(SysFinals.YES);
		faultModel.setCurrentUser(user);
		faultInformationService.editFaultInformation(faultModel);
	}
	/**
	 * 测试故障单删除
	 * @author duanyanlin
	 * @throws ServiceException 
	 * @date 2016年7月7日上午9:11:56
	 */
	@Test
	public void testDeleteFaultInformation() throws ServiceException{
		FaultInformation fault = this.addTestFault();
		FaultHandleQueryModel qm = new FaultHandleQueryModel();
		qm.setFaultId(fault.getId());
		faultInformationService.deleteFaultInformation(qm);
	}
	
	/**
	 * 测试生成故障单编号
	 * @author duanyanlin
	 * @date 2016年7月8日下午4:20:57
	 */
	@Test
	public void testCreatFaultNumber(){
		int num = 0;
		List<FaultInformation> faultAll = this.faultInformationDao.queryListOrderByFaultNum();
		if(faultAll.size() > 0){
			num = Integer.parseInt(faultAll.get(0).getFaultNumber()) + 1;
		}
		System.err.println(String.valueOf(num));
	}
}
