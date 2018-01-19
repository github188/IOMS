package cn.com.atnc.ioms.mng.duty.fax.day.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.duty.fax.day.IFaxHardwareDayDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.fax.day.FaxHardwareDay;
import cn.com.atnc.ioms.enums.duty.fax.FaxJudgeState;
import cn.com.atnc.ioms.mng.duty.fax.day.IFaxHardwareDayService;
import cn.com.atnc.ioms.model.duty.fax.day.FaxSystemModel;
import cn.com.atnc.ioms.model.duty.fax.day.FaxSystemQueryModel;

/**
 * 转报系统硬件检查（自动）日检-Service
 *
 * @author 韩天驭
 * @2017年2月14日 下午12:08:24
 */
@Transactional
@Service("FaxHardwareDayService")
public class FaxHardwareDayServiceImpl extends BaseService implements
		IFaxHardwareDayService {

	@Autowired
	private IFaxHardwareDayDao iFaxHardwareDayDao;

	/**
	 * 分页 查询
	 */
	public Pagination queryPage(FaxSystemQueryModel queryModel) {
		return iFaxHardwareDayDao.queryPage(queryModel);
	}

	/**
	 * 查看详情
	 */
	public FaxHardwareDay findById(String id) {
		return iFaxHardwareDayDao.findById(id);
	}

	/**
	 * 删除
	 */
	public void delete(String id) {
		System.err.println("删除记录成功:" + id);
		FaxHardwareDay faxHardwareDay = this.findById(id);
		iFaxHardwareDayDao.delete(faxHardwareDay);
	}

	/**
	 * 审核
	 */
	public FaxHardwareDay judge(FaxSystemModel model,User user) {
		FaxHardwareDay faxHardwareDay = this.findById(model.getHardwareId());
		faxHardwareDay.setJudgeState(FaxJudgeState.PASS);
		faxHardwareDay.setJudgeUser(user);
		faxHardwareDay.setJudgeTime(new Date());
		faxHardwareDay.setJudgeRemark(model.getJudgeRemark());
		
		//修改
		iFaxHardwareDayDao.update(faxHardwareDay);
		
		return faxHardwareDay;
	}

	/**
	 * 修改
	 */
	public FaxHardwareDay mod(FaxSystemModel pageModel, User user) {

		FaxHardwareDay faxHardwareDay = this.findById(pageModel
				.getHardwareId());
		// 异步接入器状态1-6
		faxHardwareDay.setAsynAccess1(pageModel.getAsynAccess1());
		faxHardwareDay.setAsynAccess2(pageModel.getAsynAccess2());
		faxHardwareDay.setAsynAccess3(pageModel.getAsynAccess3());
		faxHardwareDay.setAsynAccess4(pageModel.getAsynAccess4());
		faxHardwareDay.setAsynAccess5(pageModel.getAsynAccess5());
		faxHardwareDay.setAsynAccess6(pageModel.getAsynAccess6());
		// 智能集中器A-D
		// 智能集中器A 冗余状态
		faxHardwareDay.setiReduncdancyStatusA(pageModel
				.getiReduncdancyStatusA());
		// 智能集中器A 工作状态
		faxHardwareDay.setiWorkStatusA(pageModel.getiWorkStatusA());

		faxHardwareDay.setiReduncdancyStatusB(pageModel
				.getiReduncdancyStatusB());
		faxHardwareDay.setiWorkStatusB(pageModel.getiWorkStatusB());
		faxHardwareDay.setiReduncdancyStatusC(pageModel
				.getiReduncdancyStatusC());
		faxHardwareDay.setiWorkStatusC(pageModel.getiWorkStatusC());
		faxHardwareDay.setiReduncdancyStatusD(pageModel
				.getiReduncdancyStatusD());
		faxHardwareDay.setiWorkStatusD(pageModel.getiWorkStatusD());

		// 主机A
		faxHardwareDay.setHostReduncdancyStatusA(pageModel
				.getHostReduncdancyStatusA());
		faxHardwareDay.setHostWorkStatusA(pageModel.getHostWorkStatusA());
		// 主机B
		faxHardwareDay.setHostReduncdancyStatusB(pageModel
				.getHostReduncdancyStatusB());
		faxHardwareDay.setHostWorkStatusB(pageModel.getHostWorkStatusB());

		// 同步接入器A
		faxHardwareDay.setSynReduncdancyStatusA(pageModel
				.getSynReduncdancyStatusA());
		faxHardwareDay.setSynWorkStatusA(pageModel.getSynWorkStatusA());
		// 同步接入器B
		faxHardwareDay.setSynReduncdancyStatusB(pageModel
				.getSynReduncdancyStatusB());
		faxHardwareDay.setSynWorkStatusB(pageModel.getSynWorkStatusB());
        //修改信息
		
		faxHardwareDay.setUpdateTime(new Date());
		faxHardwareDay.setUpdter(user);
		
		iFaxHardwareDayDao.update(faxHardwareDay);
		return faxHardwareDay;
	}
}
