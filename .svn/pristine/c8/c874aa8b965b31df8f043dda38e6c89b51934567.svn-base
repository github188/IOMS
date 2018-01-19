package cn.com.atnc.ioms.mng.faultmng.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Task;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.acl.IRoleDao;
import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.dao.acl.IUserRoleDao;
import cn.com.atnc.ioms.dao.basedata.satellite.ISatelliteSiteDao;
import cn.com.atnc.ioms.dao.clientnotice.IClientNoticeDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultAreaDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultHandleDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultInformationDao;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.acl.UserRole;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.clientnotice.SendLog;
import cn.com.atnc.ioms.entity.faultmng.FaultAlarm;
import cn.com.atnc.ioms.entity.faultmng.FaultArea;
import cn.com.atnc.ioms.entity.faultmng.FaultHandle;
import cn.com.atnc.ioms.entity.faultmng.FaultInformation;
import cn.com.atnc.ioms.entity.maintain.equipmobile.KuMobile;
import cn.com.atnc.ioms.entity.phonemng.ContactsMng;
import cn.com.atnc.ioms.entity.systemmng.deptinfomng.DeptInfomationMng;
import cn.com.atnc.ioms.enums.acl.RoleSourceEnum;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.enums.clientnotice.NoticeFlag;
import cn.com.atnc.ioms.enums.clientnotice.NoticeState;
import cn.com.atnc.ioms.enums.clientnotice.NoticeType;
import cn.com.atnc.ioms.enums.faultmng.FaultAlarmStatus;
import cn.com.atnc.ioms.enums.faultmng.FaultEventType;
import cn.com.atnc.ioms.enums.faultmng.FaultHandelType;
import cn.com.atnc.ioms.enums.faultmng.FaultLevelType;
import cn.com.atnc.ioms.enums.faultmng.FaultOriginType;
import cn.com.atnc.ioms.enums.faultmng.FaultStatus;
import cn.com.atnc.ioms.enums.phonemng.PhoneTypeEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyRoleEnum;
import cn.com.atnc.ioms.mng.faultmng.IFaultAlarmMngService;
import cn.com.atnc.ioms.mng.faultmng.IFaultInformationMngService;
import cn.com.atnc.ioms.mng.faultmng.IFaultMngWorkflowService;
import cn.com.atnc.ioms.mng.maintain.equipmobile.IKuMobileManager;
import cn.com.atnc.ioms.mng.phonemng.IContactsMngService;
import cn.com.atnc.ioms.mng.turndutymng.ISignLeaveService;
import cn.com.atnc.ioms.model.SysFinals;
import cn.com.atnc.ioms.model.acl.UserRoleQueryModel;
import cn.com.atnc.ioms.model.faultmng.FaultHandleQueryModel;
import cn.com.atnc.ioms.model.faultmng.FaultInformationModel;
import cn.com.atnc.ioms.model.maintain.equipmobile.KuMobileQueryModel;
import cn.com.atnc.ioms.model.phonemng.ContactsMngQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 故障信息管理实现类
 * 
 * @author duanyanlin 2016年6月17日 下午2:30:51
 */
@Service("faultInformationMngService")
public class FaultInformationMngServiceImpl extends BaseService implements
		IFaultInformationMngService {

	@Autowired
	private IFaultMngWorkflowService faultMngWorkflow;
	@Autowired
	private IFaultInformationDao faultInformationDao;
	@Autowired
	private ISignLeaveService signLeaveService;
	@Autowired
	private IFaultHandleDao faultHandleDao;
	@Autowired
	private IFaultAreaDao faultAreaDao;
	@Autowired
	private IUserRoleDao userRoleDao;
	@Autowired
	private IRoleDao roleDao;
	@Autowired
	private IContactsMngService contactsMngService;// hty add 20160808
	@Autowired
	private IUserDao userDao; // dyl add 20161109
	@Autowired
	private IFaultAlarmMngService faultAlarmMngService;
	@Autowired
	private IClientNoticeDao clientNoticeDao;
	@Autowired
	private IKuMobileManager mobileManager;
	@Autowired
	private ISatelliteSiteDao satelliteSiteDao;

	/**
	 * 查询待评价事件单
	 */
	@Override
	public Pagination queryEvaluatePage(FaultHandleQueryModel qm) {
		// 当前登录部门经理的实体
		User deptUser = qm.getCurrentUser();
		// 用户所属部门
		DeptInfomationMng deptinfo = deptUser.getDeptinfo();
		// 根据部门查询员工列表
		List<User> users = userDao.getAllByDept(deptinfo);
		StringBuilder firstUsers = new StringBuilder();
		// 拼接用户
		if (CollectionUtils.isNotEmpty(users)) {
			// 遍历用户
			for (User user : users) {
				// 拼接字符串('','',)
				firstUsers.append("\'").append(user.getId()).append("\',");
			}
			// 查询最后一个‘,’的位置
			int index = firstUsers.toString().lastIndexOf(',');
			// 删除字符
			firstUsers.deleteCharAt(index);
			// 封装查询用户字符串
			qm.setFirstUsers(firstUsers.toString());
			// 查询
			return this.faultInformationDao.queryEvaluatePage(qm);
		} else {
			// 无用户时，返回空
			return null;
		}
	}

	/**
	 * 故障单列表（分页）
	 * 
	 * @author duanyanlin
	 * @date 2016年6月17日下午3:25:24
	 * @param qm
	 * @return Pagination
	 */
	@Override
	public Pagination queryPage(FaultHandleQueryModel qm) {
		return this.faultInformationDao.queryPage(qm);
	}

	/**
	 * 查询故障单列表（查询统计模块使用）
	 * 
	 * @author duanyanlin
	 * @date 2016年6月21日下午1:38:37
	 * @param qm
	 *            事件查询model
	 * @return pagn 分页
	 */
	@Override
	public Pagination queryFaultList(FaultHandleQueryModel qm) {
		// 根据条件查询所有主故障单
		qm.setFaultChildNumber(0);
		Pagination pagn = this.faultInformationDao.queryPage(qm);
		@SuppressWarnings("unchecked")
		List<FaultInformation> faultInformations = (List<FaultInformation>) pagn
				.getResult();
		// 根据主故障单查询所有子故障单
		if (CollectionUtils.isNotEmpty(faultInformations)) {
			for (FaultInformation faultInformation : faultInformations) {
				FaultHandleQueryModel fqm = new FaultHandleQueryModel();
				fqm.setParentId(faultInformation);
				// 包含已删除故障单
				fqm.setIsDelete(true);
				List<FaultInformation> faults = this.faultInformationDao
						.queryList(fqm);
				faultInformation.setFaultInformations(faults);
				// 根据子故障单查询故障处置记录
				if (CollectionUtils.isNotEmpty(faults)) {
					for (FaultInformation faultInfor : faults) {
						FaultHandleQueryModel fhqm = new FaultHandleQueryModel();
						fhqm.setFaultId(faultInfor.getId());
						List<FaultHandle> faultHandles = this.faultHandleDao
								.queryList(fhqm);
						faultInfor.setFaultHandles(faultHandles);
					}
				}
			}
		}
		return pagn;
	}

	/**
	 * 故障单列表List--事件处置模块使用
	 * 
	 * @author duanyanlin
	 * @date 2016年6月17日下午3:25:24
	 * @param qm
	 *            事件查询model
	 * @return List 事件单列表
	 */
	@Override
	public List<FaultInformation> queryList(FaultHandleQueryModel qm) {
		List<FaultInformation> results = new ArrayList<FaultInformation>();
		if (qm.getFaultStatus() != null
				&& qm.getFaultStatus().size() == 1
				&& StringUtils.equalsIgnoreCase(qm.getFaultStatus().get(0)
						.name(), FaultStatus.HANGUP.name())) {
			// 根据值班经理角色查询待处理任务
			List<Task> tasksHangup = this.faultMngWorkflow
					.findTodoTasksHangup(DutyRoleEnum.DUTYMANAGER.name());
			if (CollectionUtils.isNotEmpty(tasksHangup)) {
				for (Task task : tasksHangup) {
					// 根据工作流查询任务
					FaultInformation faultInformation = this.faultMngWorkflow
							.findEntity(task);
					// 条件判断
					if (faultInformation != null
							&& (StringUtils.equalsIgnoreCase(qm
									.getFaultStatus().get(0).name(),
									faultInformation.getFaultStatus().name())
									&& StringUtils.equalsIgnoreCase(qm
											.getDutyPlace().name(),
											faultInformation.getDutyPlace()
													.name())
									&& StringUtils
											.isEmpty(qm.getContactsName()) || (!StringUtils
									.isEmpty(qm.getContactsName()) && StringUtils
									.contains(
											faultInformation.getContactsName(),
											qm.getContactsName()))
									&& (StringUtils.isEmpty(qm
											.getContactsName()) || (!StringUtils
											.isEmpty(qm.getContactsName()) && StringUtils
											.contains(faultInformation
													.getContactsName(), qm
													.getContactsName()))))) {
						// 值班经理分配
						results.add(faultInformation);
					}
				}
			}
		} else {
			// 根据当前登录用户的userId查询所有待处理任务（自身的及部门经理授权人的）
			List<Task> tasks = new ArrayList<Task>();
			// 当前用户及所代理用户的userId列表
			List<String> userIds = new ArrayList<String>();
			if (qm.getCurrentUser() != null) {
				// 为userId列表添加当前用户id
				userIds.add(qm.getCurrentUser().getId());
				// 查询部门经理角色ID
				Role role = this.roleDao.findByParam("name",
						RoleEnum.atncLeader.name());
				// 用户与权限绑定列表
				if (!ObjectUtils.equals(role, null)) {
					/**
					 * 查询该用户的授权人的任务
					 */
					UserRoleQueryModel urqm = new UserRoleQueryModel();
					urqm.setRoleId(role.getId());
					urqm.setRoleSource(RoleSourceEnum.TRANSFER);
					urqm.setUserId(qm.getCurrentUser().getId());
					// 根据角色和角色来源查询用户绑定角色列表
					List<UserRole> userRoles = this.userRoleDao.queryList(urqm);
					// 当前用户有授权人时，添加授权人ID，并且查询授权人是否还有授权人
					if (CollectionUtils.isNotEmpty(userRoles)) {
						for (int i = 0; i < userRoles.size(); i++) {
							// 添加授权人ID
							userIds.add(userRoles.get(i).getTransfer().getId());
						}
					}
					/**
					 * 查询该用户的代理人的任务
					 */
					UserRoleQueryModel urqm1 = new UserRoleQueryModel();
					urqm1.setRoleId(role.getId());
					urqm1.setRoleSource(RoleSourceEnum.TRANSFER);
					urqm1.setTransfer(qm.getCurrentUser().getId());
					// 根据角色和角色来源查询用户绑定角色列表
					List<UserRole> userRoles1 = this.userRoleDao
							.queryList(urqm1);
					// 当前用户有授权人时，添加授权人ID，并且查询授权人是否还有授权人
					if (CollectionUtils.isNotEmpty(userRoles1)) {
						for (int i = 0; i < userRoles1.size(); i++) {
							// 添加授权人ID
							userIds.add(userRoles1.get(i).getUser().getId());
						}
					}
				}
				// 遍历用户id，查询相应的代理人及自身任务
				for (int j = 0; j < userIds.size(); j++) {
					List<Task> newTasks = this.faultMngWorkflow
							.findTodoTasks(userIds.get(j));
					if (CollectionUtils.isNotEmpty(newTasks)) {
						tasks.addAll(newTasks);
					}
				}

			}
			if (CollectionUtils.isNotEmpty(tasks)) {
				for (Task task : tasks) {
					// 根据任务查询故障单
					FaultInformation faultInformation = this.faultMngWorkflow
							.findEntity(task);
					if (faultInformation != null) {
						if (qm.getFaultStatus().size() == 1) {
							// 条件判断
							if (StringUtils.equalsIgnoreCase(qm
									.getFaultStatus().get(0).name(),
									FaultStatus.ASSIGN.name())
									&& StringUtils.equalsIgnoreCase(qm
											.getFaultStatus().get(0).name(),
											faultInformation.getFaultStatus()
													.name())
									&& (StringUtils.isEmpty(qm
											.getContactsName()) || (!StringUtils
											.isEmpty(qm.getContactsName()) && StringUtils
											.contains(faultInformation
													.getContactsName(), qm
													.getContactsName())))) {
								// 部门经理分配
								results.add(faultInformation);
							}
						} else {
							// 待处理
							if (!StringUtils.equalsIgnoreCase(faultInformation
									.getFaultStatus().name(),
									FaultStatus.ASSIGN.name())
									&& !StringUtils.equalsIgnoreCase(
											faultInformation.getFaultStatus()
													.name(), FaultStatus.HANGUP
													.name())
									&& (StringUtils.isEmpty(qm
											.getContactsName()) || (!StringUtils
											.isEmpty(qm.getContactsName()) && StringUtils
											.contains(faultInformation
													.getContactsName(), qm
													.getContactsName())))) {
								// 部门经理处理
								results.add(faultInformation);
							}
						}
					}
				}
			}
			// 查询部门经理已经分配但未处理完成的任务,故障单状态为ASSIGNOK,故障处置记录为CACHE
			FaultHandleQueryModel fqm = new FaultHandleQueryModel();
			List<FaultStatus> stat = new ArrayList<FaultStatus>();
			stat.add(FaultStatus.ASSIGNOK);
			fqm.setFaultStatus(stat);
			// 查询部门经理分配，待技术工程师处理
			List<FaultInformation> toassignOkFaults = this.faultInformationDao
					.queryList(fqm);
			if (CollectionUtils.isNotEmpty(toassignOkFaults)) {
				for (FaultInformation faultInfo : toassignOkFaults) {
					if (!StringUtils.isEmpty(faultInfo.getCurrentHandleUser())) {
						String[] currentHandleUsers = faultInfo
								.getCurrentHandleUser().split(",");
						for (int m = 0; m < currentHandleUsers.length; m++) {
							if (qm.getCurrentUser() != null
									&& StringUtils.equalsIgnoreCase(qm
											.getCurrentUser().getName(),
											currentHandleUsers[m])) {
								// 封装事件处置查询model
								FaultHandleQueryModel faultHandleQueryModel = new FaultHandleQueryModel();
								faultHandleQueryModel.setFaultId(faultInfo
										.getId());
								faultHandleQueryModel.setCurrentUser(qm
										.getCurrentUser());
								List<FaultHandle> handles = this.faultHandleDao
										.queryList(faultHandleQueryModel);
								// 没有事件处置记录的
								if (CollectionUtils.isEmpty(handles)) {
									// 添加新纪录
									results.add(faultInfo);
								} else if (CollectionUtils.isNotEmpty(handles)
										&& (handles.get(0).getHandleType() == FaultHandelType.CACHE || handles
												.get(0).getHandleType() == FaultHandelType.BACKEDENGINEER)) {
									// 有事件处置记录，但为cache或者被退回记录的
									results.add(faultInfo);
								}
								break;
							}
						}
					}
				}
			}
		}
		// 封装当前登录用户是否是当前所需处理人
		return this.judgeHasHandleUser(qm, results);
	}

	/**
	 * 判断是否故障单当前处理人是否包含当前登录用户
	 * 
	 * @author duanyanlin
	 * @date 2016年7月12日下午12:50:23
	 * @param qm
	 *            事件查询model
	 * @param faults
	 *            事件单列表
	 * @return List 事件单列表
	 */
	public List<FaultInformation> judgeHasHandleUser(FaultHandleQueryModel qm,
			List<FaultInformation> faults) {
		if (qm.getCurrentUser() != null && CollectionUtils.isNotEmpty(faults)) {
			String currentUser = qm.getCurrentUser().getName();
			// 需要清除的OA事件单
			List<FaultInformation> toRemoveFaults = new ArrayList<FaultInformation>();
			for (FaultInformation fault : faults) {
				// 需清除的OA事件单列表
				if (ObjectUtils.equals(fault.getFaultStatus(),
						FaultStatus.HANDLEOA)) {
					// 状态为oa处理的事件单
					toRemoveFaults.add(fault);
				}
				// 默认该任务单不是当前处理人的任务
				boolean bool = false;
				if (!StringUtils.isEmpty(fault.getCurrentHandleUser())) {
					// 取出任务单中的当前处理人字段
					String[] handleUsers = fault.getCurrentHandleUser().split(
							",");
					for (int i = 0; i < handleUsers.length; i++) {
						// 字段中存在当前处理人，bool为true
						if (StringUtils.equalsIgnoreCase(handleUsers[i],
								currentUser)) {
							bool = true;
						}
					}
					fault.setHasHandleUser(bool);
				}
			}
			// 清除OA事件单
			faults.removeAll(toRemoveFaults);
		}
		return faults;
	}

	/**
	 * 根据告警信息添加事件单
	 * 
	 * @throws ServiceException
	 */
	@Override
	public FaultInformation saveAlarmFault(String alarmId,
			FaultInformationModel faultInformationModel, User user) {
		// 查询告警信息实体
		FaultAlarm faultAlarm = faultAlarmMngService.findById(alarmId);
		/**
		 * 事件单保存
		 */
		// 事件单操作
		FaultInformation faultInformation = new FaultInformation();
		// 事件级别--告警默认为A级
		faultInformation.setFaultLevel(FaultLevelType.A);
		// 非空验证
		if (!ObjectUtils.equals(faultAlarm.getEquip(), null)
				&& !ObjectUtils.equals(
						faultAlarm.getEquip().getSatelliteSite(), null)) {
			// 事件发生地址--默认为卫星站点名称
			faultInformation.setFaultArea(faultAlarm.getEquip()
					.getSatelliteSite().getSiteName());
		} else if (ObjectUtils.equals(faultAlarm.getEquip(), null)
				&& !ObjectUtils.equals(faultAlarm.getProxy(), null)) {
			// ftp绑定卫星站点
			// 查询卫星站点
			SatelliteSite satelliteSite = satelliteSiteDao.findById(faultAlarm
					.getProxy().getSatelliteId());
			if (!ObjectUtils.equals(satelliteSite, null)) {
				// 赋值
				faultInformation.setFaultArea(satelliteSite.getSiteName());
			}
		}
		// 事件类别--默认为卫星
		faultInformation.setEventType(FaultEventType.SATELLITE);
		// 创建时间--当前时间
		faultInformation.setCreateTime(DateUtilTools.getNowDateTime());
		// 故障时间--告警时间
		faultInformation.setFaultTime(faultAlarm.getAlarmTime());
		// 故障时间--申告时间
		faultInformation.setPickUpPhoneTime(faultAlarm.getCreateTime());
		// 备注--告警信息描述
		faultInformation.setRemark(faultInformationModel.getRemark());
		// 当前处理人--第一处理人
		faultInformation.setCurrentHandleUser(user.getName());
		// 添加创建故障单时处理人所在的地点
		String dutyPlace = this.signLeaveService.getDutyPlaceByUser(user);
		DutyPlaceEnum dutyPlaceEnum = DutyPlaceEnum.valueOf(dutyPlace);
		faultInformation.setDutyPlace(dutyPlaceEnum);
		/**
		 * 故障单编号规则未确定，暂定规则---在当前数据中累加1
		 */
		int num = 0;
		// 查询故障单总数
		List<FaultInformation> faultAll = this.faultInformationDao
				.queryListOrderByFaultNum();
		// 非空验证
		if (CollectionUtils.isNotEmpty(faultAll)) {
			// 编号计算
			num = Integer.parseInt(faultAll.get(0).getFaultNumber()) + 1;
			// 故障单编号
			faultInformation.setFaultNumber(String.valueOf(num));
		} else {
			faultInformation.setFaultNumber(String.valueOf(num));
		}
		// 故障单状态初始化为wait
		faultInformation.setFaultStatus(FaultStatus.WAIT);
		// 当前用户为第一处理人
		faultInformation.setFirstHandelUser(user);
		// 故障单来源--KU维保告警
		faultInformation.setSource(FaultOriginType.KUALARM);
		// 子故障编号初始化为0--本身
		faultInformation.setFaultChildNumber(0);
		// 工作流
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("userId", user.getId());
		// 启动工作流
		this.faultMngWorkflow.startWorkflow(faultInformation, variables);
		/**
		 * 事件处置记录
		 */
		// 添加事件描述
		FaultHandle faultHandle = new FaultHandle();
		// 绑定事件单
		faultHandle.setFaultId(faultInformation.getId());
		faultHandle.setFaultNumber(faultInformation.getFaultNumber());
		// 处理人是第一处理人
		faultHandle.setOperator(faultInformation.getFirstHandelUser());
		// 操作时间
		faultHandle.setOperatTime(DateUtilTools.getNowDateTime());
		// 事件单描述
		faultHandle.setFaultDesc(faultInformation.getRemark());

		/**
		 * 告警数据更新
		 */
		// 绑定事件单
		faultAlarm.setFault(faultInformation);
		// 修改告警事件单处置状态为接单
		faultAlarm.setStatus(FaultAlarmStatus.FAULT);
		// 修改更新操作人
		faultAlarm.setUpdater(user);
		// 修改更新时间
		faultAlarm.setUpdateTime(DateUtilTools.getNowDateTime());

		// 非ftp的告警发送短信
		if (!ObjectUtils.equals(faultAlarm.getEquip(), null)) {
			/**
			 * 发送短信
			 */
			// 告警短信内容
			String msg = "设备：" + faultAlarm.getEquip().getName()
					+ "告警已由天航信工程师开始处理";
			// 封装查询条件
			KuMobileQueryModel queryModel = new KuMobileQueryModel();
			// 设备id--非空验证
			if (!ObjectUtils.equals(faultAlarm.getEquip().getEquip(), null)) {
				queryModel.setEquipId(faultAlarm.getEquip().getEquip().getId());
			}
			// 短信发送标记
			queryModel.setFlag(NoticeFlag.yes);
			// 手机号全部查询
			List<KuMobile> mobiles = mobileManager.queryList(queryModel);
			// 非空验证
			if (CollectionUtils.isNotEmpty(mobiles)) {
				// 遍历手机号
				for (KuMobile kuMobile : mobiles) {
					SendLog sendLog = new SendLog(kuMobile.getMobile(), "",
							NoticeState.SMSFAIL, NoticeType.SMS, msg,
							Calendar.getInstance(), 0, kuMobile.getName(),
							kuMobile.getName(), "");
					clientNoticeDao.saveOrUpdate(sendLog);
				}
			}
		}
		/**
		 * 数据库操作
		 */
		// 保存事件单
		faultInformationDao.save(faultInformation);
		// 保存处置记录
		faultHandleDao.save(faultHandle);
		// 更新数据
		faultAlarmMngService.update(faultAlarm);
		// 返回值
		return faultInformation;
	}

	/**
	 * 添加故障单
	 * 
	 * @author duanyanlin
	 * @date 2016年6月21日下午1:39:11
	 * @param fm
	 *            事件单model
	 * @return FaultInformation 事件单
	 * @throws ServiceException
	 */
	@Override
	public FaultInformation saveFaultInformation(FaultInformationModel fm)
			throws ServiceException {

		String isRight = fm.getIsRight();
		// hty add 20160808
		ContactsMngQueryModel qm = new ContactsMngQueryModel();
		qm.setContactName(fm.getContactsName());
		qm.setTelNumber(fm.getFaultNumber());
		List<ContactsMng> contactsList = contactsMngService
				.getContactsInfoByNumberAndName(qm);
		System.err.println("添加联系人-out" + fm.getIsRight().toUpperCase()
				+ contactsList.size());
		if (contactsList.size() <= 0) {
			// 插入联系人
			ContactsMng contactsMng = new ContactsMng();
			contactsMng.setCompanyInfo(fm.getFaultCompany());
			contactsMng.setContactName(fm.getContactsName());
			contactsMng.setContactPlace(fm.getFaultArea());
			contactsMng.setCreater(fm.getCurrentUser());
			contactsMng.setTelNumber(fm.getTelephoneNumber());
			// dyl添加（区分正常咨询有骚扰电话）
			contactsMng.setPhoneType(PhoneTypeEnum.valueOf(fm.getIsRight()
					.toUpperCase()));
			System.err.println("添加联系人-in" + fm.getIsRight().toUpperCase());
			// dyl添加结束
			contactsMngService.save(contactsMng);
			// System.err.println("添加联系人：--name:"+contactsMng.getContactName()+"--telNumber:"+contactsMng.getTelNumber());
		}

		// hty add 20160808

		// 是否属于正常咨询
		if (StringUtils.equalsIgnoreCase(isRight, SysFinals.YES)) {
			FaultInformation fault = new FaultInformation();
			/** 添加故障单的公共内容部分 */
			// 申告联系人
			fault.setContactsName(fm.getContactsName());
			// 创建时间
			fault.setCreateTime(DateUtilTools.getNowDateTime());
			// 事件发生级别
			fault.setFaultLevel(fm.getFaultLevel());
			// 申告电话
			fault.setTelephoneNumber(fm.getTelephoneNumber());
			try {
				// 添加申告时间
				fault.setPickUpPhoneTime(DateUtils.parseDate(
						fm.getPickUpPhoneTime(), DateUtilTools.PATTERN_DATE_3));
				// 添加故障时间
				fault.setFaultTime(DateUtils.parseDate(fm.getFaultTime(),
						DateUtilTools.PATTERN_DATE_3));
			} catch (ParseException e) {
				throw new ServiceException("时间数据异常");
				// logger.error("时间数据异常！");
			}
			// 备注
			fault.setRemark(fm.getRemark());
			// 坐席电话
			fault.setStationPhone(fm.getStationPhone());
			if (fm.getCurrentUser() != null) {
				// 当前处理人为第一处理人
				fault.setCurrentHandleUser(fm.getCurrentUser().getName());
			}
			// 添加创建故障单时处理人所在的地点
			String dutyPlace = this.signLeaveService.getDutyPlaceByUser(fm
					.getCurrentUser());
			DutyPlaceEnum dutyPlaceEnum = DutyPlaceEnum.valueOf(dutyPlace);
			fault.setDutyPlace(dutyPlaceEnum);
			/**
			 * 故障单编号规则未确定，暂定规则---在当前数据中累加1
			 */
			int num = 0;
			List<FaultInformation> faultAll = this.faultInformationDao
					.queryListOrderByFaultNum();
			if (CollectionUtils.isNotEmpty(faultAll)) {
				num = Integer.parseInt(faultAll.get(0).getFaultNumber()) + 1;
				// 故障单编号
				fault.setFaultNumber(String.valueOf(num));
			} else {
				fault.setFaultNumber(String.valueOf(num));
			}
			// 故障单状态初始化为wait
			fault.setFaultStatus(FaultStatus.WAIT);
			// 当前用户为第一处理人
			fault.setFirstHandelUser(fm.getCurrentUser());
			// 事件类别
			fault.setEventType(fm.getEventType());
			// 事件发生区域
			fault.setFaultArea(fm.getFaultArea());
			// 事件发生单位
			fault.setFaultCompany(fm.getFaultCompany());
			// 故障单来源为手动添加
			fault.setSource(FaultOriginType.MANUALADD);
			// 是否备份
			fault.setBackups(fm.getBackups());
			// 是否立即恢复
			fault.setRenew(fm.getRenew());
			// 业务类型
			fault.setServiceType(fm.getServiceType());
			// 是否首次咨询
			String firstOrNot = fm.getFirstOrNot();
			// 首次咨询，添加主故障单
			if (StringUtils.equalsIgnoreCase(firstOrNot, SysFinals.YES)) {
				// 子故障编号初始化为0--本身
				fault.setFaultChildNumber(0);
			} else {
				// 非首次，添加故障单并绑定主故障单
				FaultInformation faultOld = this.faultInformationDao
						.findById(fm.getFaultParentId());
				// 父级故障单的ID
				fault.setFaultParentId(faultOld);
				FaultHandleQueryModel fqm = new FaultHandleQueryModel();
				fqm.setParentId(faultOld);
				fqm.setIsDelete(true);
				List<FaultInformation> faults = this.faultInformationDao
						.queryList(fqm);
				if (CollectionUtils.isNotEmpty(faults)) {
					// 子故障编号
					fault.setFaultChildNumber(faults.get(0)
							.getFaultChildNumber() + 1);
				} else {
					fault.setFaultChildNumber(1);
				}
			}

			// hty add 20160808
			fault.setCallingId(fm.getCallSheetId());
			if (!StringUtils.isEmpty(fm.getCallSheetId())) {
				// 不为空来源是 呼叫中心
				fault.setSource(FaultOriginType.OFFPOPUP);// 摘机
			}
			// hty add 20160808
			this.faultInformationDao.save(fault);
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("userId", fm.getCurrentUser().getId());
			// 启动工作流
			this.faultMngWorkflow.startWorkflow(fault, variables);
			/**
			 * 存储地区资源--fm.getFaultArea()
			 */
			FaultArea faultArea = this.faultAreaDao.findByParam("areaInfo",
					fm.getFaultArea());
			if (faultArea == null) {
				// 新地址的情况下为故障单地区资源保存新数据
				FaultArea area = new FaultArea();
				area.setAreaInfo(fm.getFaultArea());
				area.setCreater(fm.getCurrentUser().getName());
				area.setCreateTime(DateUtilTools.getNowDateTime());
				this.faultAreaDao.save(area);
			}
			// 添加事件描述
			FaultHandle faultHandle = new FaultHandle();
			// 绑定事件单
			faultHandle.setFaultId(fault.getId());
			faultHandle.setFaultNumber(fault.getFaultNumber());
			// 处理人是第一处理人
			faultHandle.setOperator(fault.getFirstHandelUser());
			// 操作时间
			faultHandle.setOperatTime(DateUtilTools.getNowDateTime());
			// 事件单描述
			faultHandle.setFaultDesc(fault.getRemark());
			faultHandleDao.save(faultHandle);
			return fault;
		} else {
			return null;
		}
	}

	/**
	 * 修改故障单信息
	 * 
	 * @author duanyanlin
	 * @date 2016年6月21日下午1:39:11
	 * @param fm
	 *            事件单model
	 * @return FaultInformation 事件单
	 * @throws ServiceException
	 */
	@Override
	public FaultInformation editFaultInformation(FaultInformationModel fm)
			throws ServiceException {
		FaultInformation faultInformation = this.faultInformationDao
				.findById(fm.getFaultId());
		if (faultInformation != null) {
			faultInformation.setContactsName(fm.getContactsName());
			faultInformation.setTelephoneNumber(fm.getTelephoneNumber());
			try {
				// 添加故障时间
				faultInformation.setFaultTime(DateUtils.parseDate(
						fm.getFaultTime(), DateUtilTools.PATTERN_DATE_3));
			} catch (ParseException e) {
				// logger.error("时间数据异常！");
				throw new ServiceException("时间格式异常");
			}
			// 是否备份
			faultInformation.setBackups(fm.getBackups());
			// 是否立即恢复
			faultInformation.setRenew(fm.getRenew());
			// 业务类型
			faultInformation.setServiceType(fm.getServiceType());
			faultInformation.setFaultCompany(fm.getFaultCompany());
			faultInformation.setFaultLevel(fm.getFaultLevel());
			faultInformation.setFaultArea(fm.getFaultArea());
			faultInformation.setEventType(fm.getEventType());
			if (StringUtils.equalsIgnoreCase(fm.getFirstOrNot(), SysFinals.NO)) {
				FaultInformation faultOld = this.faultInformationDao
						.findById(fm.getFaultParentId());
				// 如果新绑定的故障单与曾经绑定的故障单不同
				if (faultInformation.getFaultParentId() == null
						|| !StringUtils.equalsIgnoreCase(faultInformation
								.getFaultParentId().getId(), faultOld.getId())) {
					// 父级故障单的ID
					faultInformation.setFaultParentId(faultOld);
					FaultHandleQueryModel fqm = new FaultHandleQueryModel();
					fqm.setParentId(faultOld);
					List<FaultInformation> faults = this.faultInformationDao
							.queryList(fqm);
					// 新添加故障单的故障单子级编码在已有子级编码基础上加1
					if (CollectionUtils.isNotEmpty(faults)) {
						// 子故障编号
						faultInformation.setFaultChildNumber(faults.get(0)
								.getFaultChildNumber() + 1);
					} else {
						faultInformation.setFaultChildNumber(1);
					}
				}
			}
			// 故障单更新时间和用户名称
			if (fm.getCurrentUser() != null) {
				faultInformation.setUpdateUser(fm.getCurrentUser().getName());
			}
			faultInformation.setUpdateTime(DateUtilTools.getNowDateTime());
			this.faultInformationDao.update(faultInformation);
			/**
			 * 事件单修改过程记录
			 */
			FaultHandle faultHandle = new FaultHandle();
			faultHandle.setFaultId(faultInformation.getId());
			faultHandle.setFaultNumber(faultInformation.getFaultNumber());
			faultHandle.setFaultChildNumber(faultInformation
					.getFaultChildNumber());
			// 故障单修改
			faultHandle.setHandleType(FaultHandelType.EDIT);
			faultHandle.setOperator(fm.getCurrentUser());
			faultHandle.setOperatTime(DateUtilTools.getNowDateTime());
			faultHandle.setRemark(fm.getRemark());
			this.faultHandleDao.save(faultHandle);
		}
		return faultInformation;
	}

	/**
	 * 删除故障单
	 * 
	 * @author duanyanlin
	 * @date 2016年6月30日下午12:57:51
	 * @param qm
	 *            事件单查询model
	 * @return FaultInformation 事件单
	 */
	@Override
	public FaultInformation deleteFaultInformation(FaultHandleQueryModel qm) {
		FaultInformation faultInformation = this.faultInformationDao
				.findById(qm.getFaultId());
		if (!StringUtils.isEmpty(faultInformation.getProcessInstanceId())) {
			// 删除全部任务
			this.faultMngWorkflow.removeTask(faultInformation
					.getProcessInstanceId());
		}
		// 逻辑删除事件单
		faultInformation.setFaultStatus(FaultStatus.DELETE);
		this.faultInformationDao.update(faultInformation);
		/**
		 * 事件单删除记录记录
		 */
		FaultHandle faultHandle = new FaultHandle();
		faultHandle.setFaultId(faultInformation.getId());
		faultHandle.setFaultNumber(faultInformation.getFaultNumber());
		faultHandle.setFaultChildNumber(faultInformation.getFaultChildNumber());
		// 故障单修改，逻辑删除
		faultHandle.setHandleType(FaultHandelType.DELETE);
		faultHandle.setOperator(qm.getCurrentUser());
		faultHandle.setOperatTime(DateUtilTools.getNowDateTime());
		this.faultHandleDao.save(faultHandle);
		return faultInformation;
	}

	/**
	 * 查询故障单
	 * 
	 * @author duanyanlin
	 * @date 2016年6月21日下午6:23:44
	 * @param qm
	 *            事件单查询model
	 * @return FaultInformation 事件单
	 */
	@Override
	public FaultInformation findById(FaultHandleQueryModel qm) {
		return (FaultInformation) this.faultInformationDao.findById(qm
				.getFaultId());
	}
}