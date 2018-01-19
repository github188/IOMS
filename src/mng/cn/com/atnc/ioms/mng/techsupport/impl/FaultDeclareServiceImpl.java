/**
 * 
 */
package cn.com.atnc.ioms.mng.techsupport.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.techsupport.fault.IFaultDeclareDao;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.techsupport.fault.FaultDeclare;
import cn.com.atnc.ioms.enums.techsupport.fault.AllStatus;
import cn.com.atnc.ioms.enums.techsupport.fault.DeclareType;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.techsupport.IFaultDeclareService;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareDealQueryModel;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareRecordQueryModel;

/**
 * 故障申报服务接口实现类
 * 
 * @author KuYonggang
 * @date 2014-4-3下午7:35:44
 * @version 1.0
 */
@Transactional
@Service("faultDeclareService")
public class FaultDeclareServiceImpl extends AbstractService implements
		IFaultDeclareService {
	
	@Autowired
	private IFaultDeclareDao faultDeclareDao;
	@Autowired
	private IUserManager userManager;
	/**
	 * @see cn.com.atnc.pcsp.mng.techsupport.fault.IFaultDeclareService#save(cn.com.atnc.pcsp.entity.techsupport.fault.FaultDeclare)
	 * FaultDeclareServiceImpl.java
	 */
	@Override
	public String save(FaultDeclare faultDeclare) {
		return faultDeclareDao.save(faultDeclare).toString();
	}

	/**
	 * @see cn.com.atnc.pcsp.mng.techsupport.fault.IFaultDeclareService#update(cn.com.atnc.pcsp.entity.techsupport.fault.FaultDeclare)
	 * FaultDeclareServiceImpl.java
	 */
	@Override
	public String update(FaultDeclare faultDeclare) {
		faultDeclareDao.update(faultDeclare);
		return faultDeclare.getId();
	}

	/**
	 * @see cn.com.atnc.pcsp.mng.techsupport.fault.IFaultDeclareService#findStatById(java.lang.String)
	 * FaultDeclareServiceImpl.java
	 */
	@Override
	public FaultDeclare getFaultDeclareByID(String id) {
		return faultDeclareDao.findById(id);
	}

	/**
	 * @see cn.com.atnc.pcsp.mng.techsupport.fault.IFaultDeclareService#queryPageByParam(cn.com.atnc.pcsp.model.techsupport.fault.FaultDeclareQueryModel)
	 * FaultDeclareServiceImpl.java
	 */
	@Override
	public Pagination queryPageByParam(FaultDeclareRecordQueryModel model) {
		return faultDeclareDao.queryPageByParam(model);
	}

	/**
	 * @see cn.com.atnc.pcsp.mng.techsupport.fault.IFaultDeclareService#queryListByParam(cn.com.atnc.pcsp.model.techsupport.fault.FaultDeclareQueryModel)
	 * FaultDeclareServiceImpl.java
	 */
	@Override
	public List<FaultDeclare> queryListByParam(FaultDeclareDealQueryModel model) {
		return faultDeclareDao.queryListByParam(model);
	}

	/**
	 * @see cn.com.atnc.pcsp.mng.techsupport.fault.IFaultDeclareService#delete(java.lang.String)
	 * FaultDeclareServiceImpl.java
	 */
	@Override
	public String delete(String id) {
		FaultDeclare faultDeclare = faultDeclareDao.findById(id);
		if (faultDeclare == null) {
			return "";
		}
		faultDeclareDao.delete(faultDeclare);
		return faultDeclare.getDeclareType() + ":" + faultDeclare.getFaultStatus();
	}

	/**
	 * @see cn.com.atnc.ioms.mng.techsupport.IFaultDeclareService#queryPageForDeal(cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareDealQueryModel)
	 * FaultDeclareServiceImpl.java
	 */
	@Override
	public Pagination queryPageForDeal(FaultDeclareDealQueryModel model) {
		return faultDeclareDao.queryPageForDeal(model);
	}

	/**
	 * @see cn.com.atnc.ioms.mng.techsupport.IFaultDeclareService#getUnTakeNum()
	 * FaultDeclareServiceImpl.java
	 */
	@Override
	public int getFaultDeclareNum(String userId) {
		
		FaultDeclareDealQueryModel queryModel = new FaultDeclareDealQueryModel();
		List<AllStatus> statusList = new ArrayList<AllStatus>();
		Pagination pagination = null;
		User user = userManager.findById(userId);
		StringBuffer roleNames = new StringBuffer("|");
		List<Role> roles = user.getRoles();
		//logger.info("当前用户拥有角色个数：" + roles.size());
		if(roles!=null && roles.size()>0){
			for (Role role : roles) {
				roleNames.append(role.getName());
				roleNames.append("|");
			}
		}
		logger.info("当前用户名："+user.getName() + " 拥有的角色名称：" + roleNames.toString());
		
		if (roleNames.toString().contains("|admin|") || roleNames.toString().contains("|atncLeader|")){
			
			//所拥有的角色中包含admin角色或atncLeader角色
			queryModel.setDeclareType(DeclareType.FAULTDECLARE);
			//接单tab页中待处理条数
			statusList.add(AllStatus.SUBMITTED);
			queryModel.setStatusList(statusList);
			pagination = this.queryPageForDeal(queryModel);
			int takeNum = (int) pagination.getTotalCount();
			//值班员解决tab页中待处理条数
			statusList.clear();
			statusList.add(AllStatus.OPEN);
			statusList.add(AllStatus.SOLVED_OPEN);
			queryModel.setUpdateUser(user.getName());
			queryModel.setStatusList(statusList);
			pagination = this.queryPageForDeal(queryModel);
			int zhibanyunNum = (int) pagination.getTotalCount();
			//值班经理解决tab页中待处理条数
			statusList.clear();
			statusList.add(AllStatus.OPEN);
			statusList.add(AllStatus.SOLVED_OPEN);
			statusList.add(AllStatus.TRANSFERRED);
			queryModel.setUpdateUser(user.getName());
			queryModel.setStatusList(statusList);
			pagination = this.queryPageForDeal(queryModel);
			int zhibanjingliNum = (int) pagination.getTotalCount();
			//工程师解决tab页中待处理条数
			statusList.clear();
			statusList.add(AllStatus.ASSIGNED);
			statusList.add(AllStatus.RESOLVED_OPEN);
			queryModel.setUpdateUser(user.getName());
			queryModel.setStatusList(statusList);
			pagination = this.queryPageForDeal(queryModel);
			int engineerNum = (int) pagination.getTotalCount();
			//确认提醒tab页中待处理条数
			statusList.clear();
			statusList.add(AllStatus.SOLVED);
			statusList.add(AllStatus.RESOLVED);
			FaultDeclareDealQueryModel tempQueryModel = new FaultDeclareDealQueryModel();
			tempQueryModel.setDeclareType(DeclareType.FAULTDECLARE);
			tempQueryModel.setNowDate(new Date());
			tempQueryModel.setStatusList(statusList);
			pagination = this.queryPageForDeal(tempQueryModel);
			int confirmWarnNum = (int) pagination.getTotalCount();
			
			//待接单数据条数+值班员待解决条数+值班经理带解决条数+工程师待解决条数+确认提醒条数
			return takeNum+zhibanyunNum+zhibanjingliNum+engineerNum+confirmWarnNum;
			
		}else if(roleNames.toString().contains("|zhibanzuzhang|")){
			
			if(roleNames.toString().contains("|zhibanyuan|")){
				//同时拥有值班员角色和值班经理角色
				queryModel.setDeclareType(DeclareType.FAULTDECLARE);
				//接单tab页中待处理条数
				statusList.add(AllStatus.SUBMITTED);
				queryModel.setStatusList(statusList);
				pagination = this.queryPageForDeal(queryModel);
				int takeNum = (int) pagination.getTotalCount();
				//值班员解决tab页中待处理条数
				statusList.clear();
				statusList.add(AllStatus.OPEN);
				statusList.add(AllStatus.SOLVED_OPEN);
				queryModel.setUpdateUser(user.getName());
				queryModel.setStatusList(statusList);
				pagination = this.queryPageForDeal(queryModel);
				int zhibanyunNum = (int) pagination.getTotalCount();
				//值班经理解决tab页中待处理条数
				statusList.clear();
				statusList.add(AllStatus.OPEN);
				statusList.add(AllStatus.SOLVED_OPEN);
				statusList.add(AllStatus.TRANSFERRED);
				queryModel.setUpdateUser(user.getName());
				queryModel.setStatusList(statusList);
				pagination = this.queryPageForDeal(queryModel);
				int zhibanjingliNum = (int) pagination.getTotalCount();
				//确认提醒tab页中待处理条数
				statusList.clear();
				statusList.add(AllStatus.SOLVED);
				statusList.add(AllStatus.RESOLVED);
				FaultDeclareDealQueryModel tempQueryModel = new FaultDeclareDealQueryModel();
				tempQueryModel.setDeclareType(DeclareType.FAULTDECLARE);
				tempQueryModel.setNowDate(new Date());
				tempQueryModel.setStatusList(statusList);
				pagination = this.queryPageForDeal(tempQueryModel);
				int confirmWarnNum = (int) pagination.getTotalCount();
				
				//待接单数据条数+值班员待解决条数+值班经理带解决条数+确认提醒条数
				return takeNum+zhibanyunNum+zhibanjingliNum+confirmWarnNum;
			}else {
				//仅拥有值班经理角色
				queryModel.setDeclareType(DeclareType.FAULTDECLARE);
				
				//接单tab页中待处理条数
				statusList.add(AllStatus.SUBMITTED);
				queryModel.setStatusList(statusList);
				pagination = this.queryPageForDeal(queryModel);
				int takeNum = (int) pagination.getTotalCount();
				
				//值班经理解决tab页中待处理条数
				statusList.clear();
				statusList.add(AllStatus.OPEN);
				statusList.add(AllStatus.SOLVED_OPEN);
				statusList.add(AllStatus.TRANSFERRED);
				queryModel.setUpdateUser(user.getName());
				queryModel.setStatusList(statusList);
				pagination = this.queryPageForDeal(queryModel);
				int zhibanjingliNum = (int) pagination.getTotalCount();
				
				//确认提醒tab页中待处理条数
				statusList.clear();
				statusList.add(AllStatus.SOLVED);
				statusList.add(AllStatus.RESOLVED);
				FaultDeclareDealQueryModel tempQueryModel = new FaultDeclareDealQueryModel();
				tempQueryModel.setDeclareType(DeclareType.FAULTDECLARE);
				tempQueryModel.setNowDate(new Date());
				tempQueryModel.setStatusList(statusList);
				pagination = this.queryPageForDeal(tempQueryModel);
				int confirmWarnNum = (int) pagination.getTotalCount();
				
				return takeNum+zhibanjingliNum+confirmWarnNum;
			}
		}else if (roleNames.toString().contains("|zhibanyuan|")) {
			
			//仅拥有值班员角色
			queryModel.setDeclareType(DeclareType.FAULTDECLARE);
			//接单tab页中待处理条数
			statusList.add(AllStatus.SUBMITTED);
			queryModel.setStatusList(statusList);
			pagination = this.queryPageForDeal(queryModel);
			int takeNum = (int) pagination.getTotalCount();
			//值班员解决tab页中待处理条数
			statusList.clear();
			statusList.add(AllStatus.OPEN);
			statusList.add(AllStatus.SOLVED_OPEN);
			queryModel.setUpdateUser(user.getName());
			queryModel.setStatusList(statusList);
			pagination = this.queryPageForDeal(queryModel);
			int zhibanyunNum = (int) pagination.getTotalCount();
			//确认提醒tab页中待处理条数
			statusList.clear();
			statusList.add(AllStatus.SOLVED);
			statusList.add(AllStatus.RESOLVED);
			FaultDeclareDealQueryModel tempQueryModel = new FaultDeclareDealQueryModel();
			tempQueryModel.setDeclareType(DeclareType.FAULTDECLARE);
			tempQueryModel.setNowDate(new Date());
			tempQueryModel.setStatusList(statusList);
			pagination = this.queryPageForDeal(tempQueryModel);
			int confirmWarnNum = (int) pagination.getTotalCount();
			
			//System.out.println(user.getName()+"-------------------------"+takeNum+confirmWarnNum+zhibanyunNum1*2+zhibanyunNum2*2+zhibanjingliNum*2+engineerNum);
			return takeNum+confirmWarnNum+zhibanyunNum;
			
		}else if (roleNames.toString().contains("|engineer|")) {
			
			//仅拥有工程师角色
			queryModel.setDeclareType(DeclareType.FAULTDECLARE);
			//工程师解决tab页中待处理条数
			statusList.clear();
			statusList.add(AllStatus.ASSIGNED);
			statusList.add(AllStatus.RESOLVED_OPEN);
			queryModel.setUpdateUser(user.getName());
			queryModel.setStatusList(statusList);
			pagination = this.queryPageForDeal(queryModel);
			int engineerNum = (int) pagination.getTotalCount();
			return engineerNum;
			
		}
		return  0;
	}

	/**
	 * @see cn.com.atnc.ioms.mng.techsupport.IFaultDeclareService#getTechSupportNum()
	 * FaultDeclareServiceImpl.java
	 */
	@Override
	public int getTechConsultNum() {
		FaultDeclareDealQueryModel queryModel = new FaultDeclareDealQueryModel();
		List<AllStatus> statusList = new ArrayList<AllStatus>();
		statusList.add(AllStatus.SUBMITTED);
		statusList.add(AllStatus.ADDED);
		queryModel.setStatusList(statusList);
		queryModel.setDeclareType(DeclareType.TECHCONSULT);
		Pagination pagination = this.queryPageForDeal(queryModel);
		return (int) pagination.getTotalCount();
	}

}
