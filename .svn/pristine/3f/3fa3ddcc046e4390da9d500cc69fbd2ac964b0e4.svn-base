package cn.com.atnc.ioms.mng.duty.fax.day.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.duty.fax.day.IFaxProcessDayDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.fax.day.FaxHardwareDay;
import cn.com.atnc.ioms.entity.duty.fax.day.FaxProcessDay;
import cn.com.atnc.ioms.enums.duty.fax.FaxJudgeState;
import cn.com.atnc.ioms.mng.duty.fax.day.IFaxProcessDayService;
import cn.com.atnc.ioms.model.duty.fax.day.FaxSystemModel;
import cn.com.atnc.ioms.model.duty.fax.day.FaxSystemQueryModel;

/**
 * 转报系统进程检查（自动）日检-Service
 *
 * @author 韩天驭
 * @2017年2月14日 下午12:09:43
 */
@Transactional
@Service("IFaxProcessDayService")
public class FaxProcessDayServiceImpl extends BaseService implements
		IFaxProcessDayService {
	@Autowired
	private IFaxProcessDayDao iFaxProcessDayDao;

	public Pagination queryPage(FaxSystemQueryModel queryModel) {
		return iFaxProcessDayDao.queryPage(queryModel);
	}

	/**
	 * 查看详情
	 */
	public FaxProcessDay findById(String id) {
		return iFaxProcessDayDao.findById(id);
	}

	/**
	 * 删除
	 */
	public void delete(String id) {
		System.err.println("删除记录成功:" + id);
		FaxProcessDay faxProcessDay = this.findById(id);
		iFaxProcessDayDao.delete(faxProcessDay);
	}

	/**
	 * 审核
	 */
	public FaxProcessDay judge(FaxSystemModel model, User user) {
		FaxProcessDay faxProcessDay = this.findById(model.getProId());
		faxProcessDay.setJudgeState(FaxJudgeState.PASS);
		faxProcessDay.setJudgeUser(user);
		faxProcessDay.setJudgeTime(new Date());
		faxProcessDay.setJudgeRemark(model.getJudgeRemark());

		// 修改
		iFaxProcessDayDao.update(faxProcessDay);

		return faxProcessDay;
	}

	/**
	 * 修改
	 */
	public FaxProcessDay mod(FaxSystemModel pageModel, User user) {

		FaxProcessDay faxProcessDay = this.findById(pageModel.getProId());
		// 转报系统主机
		// 查看异步进程（主）
		faxProcessDay.setHostAsynPro(pageModel.getHostAsynPro());
		// 查看数据库进程（主）
		faxProcessDay.setHostDBPro(pageModel.getHostDBPro());
		// 双机进程是否正常（主）
		faxProcessDay.setHostDmhsAfsPro(pageModel.getHostDmhsAfsPro());
		// 库操作进程是否正常
		faxProcessDay.setHostDmhsMonPro(pageModel.getHostDmhsMonPro());
		// 查看帧中继进程（主）
		faxProcessDay.setHostFRPro(pageModel.getHostFRPro());
		// 查看IP进程（主）
		faxProcessDay.setHostIPPro(pageModel.getHostIPPro());
		// 查看R25进程（主）
		faxProcessDay.setHostR25Pro(pageModel.getHostR25Pro());
		// 查看matip进程是否正常（主）
		faxProcessDay.setHostMATIPPro(pageModel.getHostMATIPPro());

		// 转报系统备机
		// 查看数据库进程（备）
		faxProcessDay.setBackupDBPro(pageModel.getBackupDBPro());
		// 双机进程是否正常（备）
		faxProcessDay.setBackupDmhsAfsPro(pageModel.getBackupDmhsAfsPro());
		// 库操作进程是否正常（备）
		faxProcessDay.setBackupDmhsMonPro(pageModel.getBackupDmhsMonPro());

		// 主用-智能集中器A
		// 查看IP连接进程
		faxProcessDay.setHostIProIpA(pageModel.getHostIProIpA());
		// 查看串口通信进程
		faxProcessDay
				.setHostIProSerialPortA(pageModel.getHostIProSerialPortA());
		// 备用-智能集中器A
		// 查看IP连接进程
		faxProcessDay.setBackupIProIpA(pageModel.getBackupIProIpA());
		// 查看串口通信进程
		faxProcessDay.setBackupIProSerialPortA(pageModel
				.getBackupIProSerialPortA());

		// 主用-智能集中器B
		faxProcessDay.setHostIProIpB(pageModel.getHostIProIpB());
		faxProcessDay
				.setHostIProSerialPortB(pageModel.getHostIProSerialPortB());
		faxProcessDay.setBackupIProIpB(pageModel.getBackupIProIpB());
		faxProcessDay.setBackupIProSerialPortB(pageModel
				.getBackupIProSerialPortB());
		// 修改信息

		faxProcessDay.setUpdateTime(new Date());
		faxProcessDay.setUpdter(user);

		iFaxProcessDayDao.update(faxProcessDay);
		return faxProcessDay;
	}
}
