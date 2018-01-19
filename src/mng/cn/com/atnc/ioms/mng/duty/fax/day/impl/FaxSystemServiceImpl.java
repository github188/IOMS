package cn.com.atnc.ioms.mng.duty.fax.day.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.duty.fax.day.IFaxHardwareDayDao;
import cn.com.atnc.ioms.dao.duty.fax.day.IFaxProcessDayDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.fax.day.FaxHardwareDay;
import cn.com.atnc.ioms.entity.duty.fax.day.FaxProcessDay;
import cn.com.atnc.ioms.enums.duty.fax.FaxJudgeState;
import cn.com.atnc.ioms.mng.duty.fax.day.IFaxSystemService;
import cn.com.atnc.ioms.model.duty.fax.day.FaxSystemModel;

/**
 * 转报系统日检（系统进程检查、系统硬件检查）Service
 *
 * @author 韩天驭
 * @2017年2月14日 下午12:12:11
 */
@Transactional
@Service("FaxSystemService")
public class FaxSystemServiceImpl extends BaseService implements
		IFaxSystemService {

	// 声明两个设备的接口
	@Autowired
	private IFaxHardwareDayDao faxHardwareDayDao;
	@Autowired
	private IFaxProcessDayDao faxProcessDayDao;

	/**
	 * 转报系统巡检添加（两个设备）
	 * 
	 * @author 韩天驭
	 * @2017年2月14日 下午12:17:15
	 * @param user
	 * @param pageModel
	 * @return FaxSystemModel
	 */
	public FaxSystemModel save(User user, FaxSystemModel pageModel) {

		// 声明两个设备的实体
		FaxHardwareDay faxHardwareDay = new FaxHardwareDay();
		FaxProcessDay faxProcessDay = new FaxProcessDay();
        /********转报系统硬盘 日检*****************/
		//巡检人、巡检时间、添加时间
		faxHardwareDay.setCheckTime(new Date());
		faxHardwareDay.setCreater(user);
		faxHardwareDay.setCreateTime(new Date());
		//异步接入器状态1-6
		faxHardwareDay.setAsynAccess1(pageModel.getAsynAccess1());
		faxHardwareDay.setAsynAccess2(pageModel.getAsynAccess2());
		faxHardwareDay.setAsynAccess3(pageModel.getAsynAccess3());
		faxHardwareDay.setAsynAccess4(pageModel.getAsynAccess4());
		faxHardwareDay.setAsynAccess5(pageModel.getAsynAccess5());
		faxHardwareDay.setAsynAccess6(pageModel.getAsynAccess6());
		//智能集中器A-D
		//智能集中器A 冗余状态
		faxHardwareDay.setiReduncdancyStatusA(pageModel.getiReduncdancyStatusA());
		//智能集中器A 工作状态
		faxHardwareDay.setiWorkStatusA(pageModel.getiWorkStatusA());
		
		faxHardwareDay.setiReduncdancyStatusB(pageModel.getiReduncdancyStatusB());
		faxHardwareDay.setiWorkStatusB(pageModel.getiWorkStatusB());
		faxHardwareDay.setiReduncdancyStatusC(pageModel.getiReduncdancyStatusC());
		faxHardwareDay.setiWorkStatusC(pageModel.getiWorkStatusC());
		faxHardwareDay.setiReduncdancyStatusD(pageModel.getiReduncdancyStatusD());
		faxHardwareDay.setiWorkStatusD(pageModel.getiWorkStatusD());
		
	    //主机A
		faxHardwareDay.setHostReduncdancyStatusA(pageModel.getHostReduncdancyStatusA());
		faxHardwareDay.setHostWorkStatusA(pageModel.getHostWorkStatusA());
		//主机B
		faxHardwareDay.setHostReduncdancyStatusB(pageModel.getHostReduncdancyStatusB());
		faxHardwareDay.setHostWorkStatusB(pageModel.getHostWorkStatusB());
		
		//同步接入器A
		faxHardwareDay.setSynReduncdancyStatusA(pageModel.getSynReduncdancyStatusA());
		faxHardwareDay.setSynWorkStatusA(pageModel.getSynWorkStatusA());
		//同步接入器B
		faxHardwareDay.setSynReduncdancyStatusB(pageModel.getSynReduncdancyStatusB());
		faxHardwareDay.setSynWorkStatusB(pageModel.getSynWorkStatusB());
		//待审核
		faxHardwareDay.setJudgeState(FaxJudgeState.WAIT);
		
		faxHardwareDayDao.save(faxHardwareDay);
		
		/********转报系统进程 日检*****************/
		//巡检人、巡检时间、添加时间
		faxProcessDay.setCheckTime(new Date());
		faxProcessDay.setCreater(user);
		faxProcessDay.setCreateTime(new Date());
		
		//转报系统主机
		//查看异步进程（主）
		faxProcessDay.setHostAsynPro(pageModel.getHostAsynPro());
		//查看数据库进程（主）
		faxProcessDay.setHostDBPro(pageModel.getHostDBPro());
		//双机进程是否正常（主）
		faxProcessDay.setHostDmhsAfsPro(pageModel.getHostDmhsAfsPro());
		//库操作进程是否正常
		faxProcessDay.setHostDmhsMonPro(pageModel.getHostDmhsMonPro());
		//查看帧中继进程（主）
		faxProcessDay.setHostFRPro(pageModel.getHostFRPro());
		//查看IP进程（主）
		faxProcessDay.setHostIPPro(pageModel.getHostIPPro());
		//查看R25进程（主）
		faxProcessDay.setHostR25Pro(pageModel.getHostR25Pro());
		//查看matip进程是否正常（主）
		faxProcessDay.setHostMATIPPro(pageModel.getHostMATIPPro());
		
		//转报系统备机
		//查看数据库进程（备）
		faxProcessDay.setBackupDBPro(pageModel.getBackupDBPro());
		//双机进程是否正常（备）
		faxProcessDay.setBackupDmhsAfsPro(pageModel.getBackupDmhsAfsPro());
		//库操作进程是否正常（备）
		faxProcessDay.setBackupDmhsMonPro(pageModel.getBackupDmhsMonPro());
		
		//主用-智能集中器A
		//查看IP连接进程
		faxProcessDay.setHostIProIpA(pageModel.getHostIProIpA());
		//查看串口通信进程
		faxProcessDay.setHostIProSerialPortA(pageModel.getHostIProSerialPortA());
		//备用-智能集中器A
		//查看IP连接进程
		faxProcessDay.setBackupIProIpA(pageModel.getBackupIProIpA());
	    //查看串口通信进程
		faxProcessDay.setBackupIProSerialPortA(pageModel.getBackupIProSerialPortA());
		
		//主用-智能集中器B
		faxProcessDay.setHostIProIpB(pageModel.getHostIProIpB());
		faxProcessDay.setHostIProSerialPortB(pageModel.getHostIProSerialPortB());
		faxProcessDay.setBackupIProIpB(pageModel.getBackupIProIpB());
		faxProcessDay.setBackupIProSerialPortB(pageModel.getBackupIProSerialPortB());
		//待审核
		faxProcessDay.setJudgeState(FaxJudgeState.WAIT);
		faxProcessDayDao.save(faxProcessDay);
		
		return pageModel;
	}

}
