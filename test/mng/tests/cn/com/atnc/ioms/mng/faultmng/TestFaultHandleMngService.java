package mng.tests.cn.com.atnc.ioms.mng.faultmng;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultHandleDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultInformationDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.faultmng.FaultHandle;
import cn.com.atnc.ioms.entity.faultmng.FaultInformation;
import cn.com.atnc.ioms.enums.faultmng.FaultEventType;
import cn.com.atnc.ioms.enums.faultmng.FaultHandelType;
import cn.com.atnc.ioms.enums.faultmng.FaultLevelType;
import cn.com.atnc.ioms.enums.faultmng.FaultStatus;
import cn.com.atnc.ioms.enums.faultmng.TransferType;
import cn.com.atnc.ioms.mng.faultmng.IFaultHandleMngService;
import cn.com.atnc.ioms.mng.faultmng.IFaultInformationMngService;
import cn.com.atnc.ioms.model.SysFinals;
import cn.com.atnc.ioms.model.faultmng.FaultHandleModel;
import cn.com.atnc.ioms.model.faultmng.FaultHandleQueryModel;
import cn.com.atnc.ioms.model.faultmng.FaultInformationModel;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * 故障处置service操作类
 * @author duanyanlin
 * 2016年7月6日 下午3:41:49
 */
public class TestFaultHandleMngService extends MyBaseTransationalTest {
	@Autowired
	private IFaultHandleMngService handleService;
	@Autowired
	private IFaultInformationDao faultInformationDao;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IFaultHandleDao faultHandleDao;
	@Autowired
	private IFaultInformationMngService faultInformationService;
	
	private final static String atncleaderUserId = "4b056fc55f5f4e1a9170c896cb948054" ;			//网控领导ID
	private final static String hexuebaoUserId = "e9e8af41fb874d9c86cd989276b47c88" ;			//值班工程师何雪宝

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
	 * 添加故障处置公共部分公共部分
	 * @author duanyanlin
	 * @date 2016年7月7日上午8:23:49
	 */
	@Test
	public void testAddCommon(){
		User user = userDao.findById("admin");
		FaultHandleModel faultHandleModel = new FaultHandleModel();
		faultHandleModel.setFaultDesc("故障单描述");
		faultHandleModel.setHandleDesc("处理过程描述");
		faultHandleModel.setRemark("备注");
		faultHandleModel.setFaultId("1");
		faultHandleModel.setFaultHandelType(FaultHandelType.HANDLE);
		faultHandleModel.setOperator(user);
		handleService.addCommon(faultHandleModel);
	}
	
	/**
	 * 测试部门经理分配工程师处理的任务完成时，自动修改状态
	 * @author duanyanlin
	 * @date 2016年7月8日下午4:29:44
	 */
	@Test
	public void testEngineerHandle(){
		User user = userDao.findById("admin");
		FaultInformation faultInformation = new FaultInformation();
		faultInformation.setId("1");
		faultInformation.setCurrentHandleUser("engineer1,engineer2");
		faultInformation.setFaultStatus(FaultStatus.ASSIGNOK);
		faultInformation.setFirstHandelUser(user);
		this.faultInformationDao.save(faultInformation);
		String[] engineers = faultInformation.getCurrentHandleUser().split(",");		//部门经理分配的人员列表
		
		User user1 = userDao.findByParam("loginName", "engineer1");
		FaultHandle faultHandle1 = new FaultHandle();
		faultHandle1.setFaultId("1");
		faultHandle1.setOperator(user1);
		faultHandle1.setHandleType(FaultHandelType.ENGINEER);
		User user2 = userDao.findByParam("loginName", "engineer2");
		FaultHandle faultHandle2 = new FaultHandle();
		faultHandle2.setFaultId("1");
		faultHandle2.setOperator(user2);
		faultHandle2.setHandleType(FaultHandelType.ENGINEER);
		
		FaultHandleQueryModel fqm = new FaultHandleQueryModel();
		fqm.setFaultId("1");								//封装查询条件--故障单id
		fqm.setFaultHandelType(FaultHandelType.ENGINEER);				//封装查询条件--技术工程师处理
		List<FaultHandle> faultHandles = this.faultHandleDao.queryList(fqm);
		if(engineers.length != 0 && faultHandles.size() != 0 && engineers.length == faultHandles.size() ){
			faultInformation.setFaultStatus(FaultStatus.HANDLE);
			this.faultInformationDao.update(faultInformation);
		}
		System.err.println(faultInformation.toString());
	}
	
	/**
	 * 测试任务移交--移交部门经理全过程
	 * @author duanyanlin
	 * @throws ServiceException 
	 * @date 2016年7月7日上午9:25:15
	 */
	@Test
	public void testHandle() throws ServiceException{
		User user = userDao.findById("admin");
		//模拟添加新事件单
		FaultInformation fault = this.addTestFault();
		//移交部门经理
		FaultHandleModel faultHandleModel = new FaultHandleModel();
		faultHandleModel.setFaultHandelType(FaultHandelType.TRANSFER);
		faultHandleModel.setFaultDesc("测试移交部门经理过程");
		faultHandleModel.setHandleDesc("移交部门经理");
		faultHandleModel.setRemark("默认移交给网控领导");
		faultHandleModel.setFaultId(fault.getId());
		faultHandleModel.setTransferType(TransferType.CTO.name());
		faultHandleModel.setNextHanleUser(atncleaderUserId);
		faultHandleModel.setOperator(user);
		handleService.handle(faultHandleModel);
		//部门经理分配 :engineer1和engineer2
		User atncleaderUser = userDao.findById(atncleaderUserId);
		FaultHandleModel faultHandleModel1 = new FaultHandleModel();
		faultHandleModel1.setFaultHandelType(FaultHandelType.ASSIGN);
		faultHandleModel1.setFaultDesc("测试部门经理分配过程");
		faultHandleModel1.setHandleDesc("部门经理分配工程师");
		faultHandleModel1.setRemark("分配给engineer1和engineer2");
		faultHandleModel1.setFaultId(fault.getId());
		String[] nextUserNames = {"engineer1","engineer2"};
		faultHandleModel1.setNextHandleUserIds(nextUserNames);
		faultHandleModel1.setOperator(atncleaderUser);
		handleService.handle(faultHandleModel1);
		//技术工程师1处理
		User engineer1 = this.userDao.findByLoginName("engineer1");
		FaultHandleModel faultHandleModel2 = new FaultHandleModel();
		faultHandleModel2.setFaultHandelType(FaultHandelType.ASSIGN);
		faultHandleModel2.setFaultDesc("技术工程师1处理");
		faultHandleModel2.setHandleDesc("技术工程师1处理");
		faultHandleModel2.setRemark("技术工程师1处理");
		faultHandleModel2.setFaultId(fault.getId());
		faultHandleModel2.setOperator(engineer1);
		handleService.engineerHandle(faultHandleModel2);
		//技术工程师2处理
		User engineer2 = this.userDao.findByLoginName("engineer2");
		FaultHandleModel faultHandleModel3 = new FaultHandleModel();
		faultHandleModel3.setFaultHandelType(FaultHandelType.ASSIGN);
		faultHandleModel3.setFaultDesc("技术工程师2处理");
		faultHandleModel3.setHandleDesc("技术工程师2处理");
		faultHandleModel3.setRemark("技术工程师2处理");
		faultHandleModel3.setFaultId(fault.getId());
		faultHandleModel3.setOperator(engineer2);
		handleService.engineerHandle(faultHandleModel3);
		//一般处理
		FaultHandleModel faultHandleModel4 = new FaultHandleModel();
		faultHandleModel4.setFaultHandelType(FaultHandelType.HANDLE);
		faultHandleModel4.setFaultDesc("部门经理处理");
		faultHandleModel4.setHandleDesc("部门经理处理");
		faultHandleModel4.setRemark("部门经理处理");
		faultHandleModel4.setFaultId(fault.getId());
		faultHandleModel4.setOperator(atncleaderUser);
		faultHandleModel4.setNextHanleUser(fault.getFirstHandelUser().getName());
		handleService.handle(faultHandleModel4);
		//归类
		FaultHandleModel faultHandleModel5 = new FaultHandleModel();
		faultHandleModel5.setFaultHandelType(FaultHandelType.CLASSIFY);
		faultHandleModel5.setFaultDesc("第一处理人归类");
		faultHandleModel5.setHandleDesc("第一处理人归类");
		faultHandleModel5.setRemark("第一处理人归类");
		faultHandleModel5.setFaultId(fault.getId());
		faultHandleModel5.setOperator(fault.getFirstHandelUser());
		faultHandleModel5.setFaultTypeSon("11");
		handleService.handle(faultHandleModel5);
	}
	
	/**
	 * 测试事件挂起过程
	 * @author duanyanlin
	 * @throws ServiceException 
	 * @date 2016年7月14日下午3:30:48
	 */
	@Test
	public void testFaultHangup() throws ServiceException{
		User user = userDao.findById("admin");
		//模拟添加新事件单
		FaultInformation fault = this.addTestFault();
		//挂起操作
		FaultHandleModel faultHandleModel = new FaultHandleModel();
		faultHandleModel.setFaultHandelType(FaultHandelType.HANGUP);
		faultHandleModel.setFaultDesc("测试挂起操作");
		faultHandleModel.setHandleDesc("测试挂起操作");
		faultHandleModel.setRemark("测试挂起操作");
		faultHandleModel.setFaultId(fault.getId());
		faultHandleModel.setOperator(user);
		handleService.handle(faultHandleModel);
		//值班经理分配
		FaultHandleModel faultHandleModel1 = new FaultHandleModel();
		faultHandleModel1.setFaultHandelType(FaultHandelType.ASSIGN);
		faultHandleModel1.setFaultDesc("测试值班经理分配挂起事件");
		faultHandleModel1.setHandleDesc("测试值班经理分配挂起事件");
		faultHandleModel1.setRemark("测试值班经理分配挂起事件");
		faultHandleModel1.setFaultId(fault.getId());
		faultHandleModel1.setNextHanleUser(hexuebaoUserId);
		faultHandleModel1.setOperator(user);
		handleService.handle(faultHandleModel1);
	}
	
	/**
	 * 测试事件坐席间移交和退回
	 * @author duanyanlin
	 * @throws ServiceException 
	 * @date 2016年7月14日下午3:30:48
	 */
	@Test
	public void testFaultStation() throws ServiceException{
		User user = userDao.findById("admin");
		//模拟添加新事件单
		FaultInformation fault = this.addTestFault();
		//坐席间移交
		FaultHandleModel faultHandleModel = new FaultHandleModel();
		faultHandleModel.setFaultHandelType(FaultHandelType.TRANSFER);
		faultHandleModel.setFaultDesc("坐席间移交");
		faultHandleModel.setHandleDesc("坐席间移交");
		faultHandleModel.setRemark("坐席间移交");
		faultHandleModel.setFaultId(fault.getId());
		faultHandleModel.setTransferType(TransferType.STATION.name());
		faultHandleModel.setNextHanleUser(hexuebaoUserId);
		faultHandleModel.setOperator(user);
		handleService.handle(faultHandleModel);
		//退回
		User operator = userDao.findById(hexuebaoUserId);
		FaultHandleModel faultHandleModel1 = new FaultHandleModel();
		faultHandleModel1.setFaultHandelType(FaultHandelType.BACK);
		faultHandleModel1.setFaultId(fault.getId());
		faultHandleModel1.setNextHanleUser(user.getId());
		faultHandleModel1.setOperator(operator);
		handleService.handle(faultHandleModel1);
	}
	/**
	 * 测试不移交
	 * @author duanyanlin
	 * @throws ServiceException 
	 * @date 2016年7月14日下午3:30:48
	 */
	@Test
	public void testFaultNotTransfer() throws ServiceException{
		User user = userDao.findById("admin");
		//模拟添加新事件单
		FaultInformation fault = this.addTestFault();
		//坐席间移交
		FaultHandleModel faultHandleModel = new FaultHandleModel();
		faultHandleModel.setFaultHandelType(FaultHandelType.TRANSFER);
		faultHandleModel.setFaultDesc("测试无需移交");
		faultHandleModel.setHandleDesc("测试无需移交");
		faultHandleModel.setRemark("测试无需移交");
		faultHandleModel.setFaultId(fault.getId());
		faultHandleModel.setTransferType(TransferType.NOT.name());
		faultHandleModel.setOperator(user);
		handleService.handle(faultHandleModel);
	}
}
