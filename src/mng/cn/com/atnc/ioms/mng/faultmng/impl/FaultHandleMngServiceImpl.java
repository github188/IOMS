package cn.com.atnc.ioms.mng.faultmng.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Task;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.dao.clientnotice.IClientNoticeDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultHandleDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultInformationDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultTypeParentDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultTypeSonDao;
import cn.com.atnc.ioms.dao.systemmng.deptinfomng.IDeptInfoMngDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.clientnotice.SendLog;
import cn.com.atnc.ioms.entity.faultmng.FaultAlarm;
import cn.com.atnc.ioms.entity.faultmng.FaultHandle;
import cn.com.atnc.ioms.entity.faultmng.FaultInformation;
import cn.com.atnc.ioms.entity.faultmng.FaultTypeParent;
import cn.com.atnc.ioms.entity.faultmng.FaultTypeSon;
import cn.com.atnc.ioms.entity.maintain.equipmobile.KuMobile;
import cn.com.atnc.ioms.entity.systemmng.deptinfomng.DeptInfomationMng;
import cn.com.atnc.ioms.enums.clientnotice.NoticeFlag;
import cn.com.atnc.ioms.enums.clientnotice.NoticeState;
import cn.com.atnc.ioms.enums.clientnotice.NoticeType;
import cn.com.atnc.ioms.enums.faultmng.FaultAlarmStatus;
import cn.com.atnc.ioms.enums.faultmng.FaultHandelType;
import cn.com.atnc.ioms.enums.faultmng.FaultOriginType;
import cn.com.atnc.ioms.enums.faultmng.FaultStatus;
import cn.com.atnc.ioms.enums.faultmng.FaultWorkflowType;
import cn.com.atnc.ioms.enums.faultmng.TransferType;
import cn.com.atnc.ioms.enums.turndutymng.DutyRoleEnum;
import cn.com.atnc.ioms.mng.clientnotice.IClientNoticeManager;
import cn.com.atnc.ioms.mng.faultmng.IFaultAlarmMngService;
import cn.com.atnc.ioms.mng.faultmng.IFaultHandleMngService;
import cn.com.atnc.ioms.mng.faultmng.IFaultMQService;
import cn.com.atnc.ioms.mng.faultmng.IFaultMngWorkflowService;
import cn.com.atnc.ioms.mng.maintain.equipmobile.IKuMobileManager;
import cn.com.atnc.ioms.mng.turndutymng.ISignLeaveService;
import cn.com.atnc.ioms.model.faultmng.FaultHandleModel;
import cn.com.atnc.ioms.model.faultmng.FaultHandleQueryModel;
import cn.com.atnc.ioms.model.faultmng.FaultSendJsonModel;
import cn.com.atnc.ioms.model.maintain.equipmobile.KuMobileQueryModel;
import cn.com.atnc.ioms.model.turndutymng.SignLeaveQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 故障处置记录管理实现类
 * 
 * @author duanyanlin
 * @date 2016年6月17日 下午2:28:28
 */
@Service("faultHandleMngService")
public class FaultHandleMngServiceImpl extends BaseService implements
		IFaultHandleMngService {

	@Autowired
	private IFaultHandleDao faultHandleDao;
	@Autowired
	private IFaultInformationDao faultInformationDao;
	@Autowired
	private IFaultMngWorkflowService faultMngWorkflow;
	@Autowired
	private IFaultTypeParentDao faultTypeParentDao;
	@Autowired
	private IFaultTypeSonDao faultTypeSonDao;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IDeptInfoMngDao deptDao;
	@Autowired
	private IFaultMQService mqService;
	@Autowired
	private IClientNoticeManager clientNoticeManager;
	@Autowired
	private ISignLeaveService signLeaveService;
	@Autowired
	private IFaultAlarmMngService faultAlarmMngService;
	@Autowired
	private IClientNoticeDao clientNoticeDao;
	@Autowired
	private IKuMobileManager mobileManager;

	/**
	 * 故障处置记录保存公共部分
	 * 
	 * @author duanyanlin
	 * @date 2016年6月17日下午3:22:35
	 * @param faultHandleModel
	 *            事件处置model
	 * @return faultHandle 事件处置记录
	 */
	@Override
	public FaultHandle addCommon(FaultHandleModel faultHandleModel) {
		FaultHandle faultHandle = new FaultHandle();
		// 故障描述
		faultHandle.setFaultDesc(faultHandleModel.getFaultDesc());
		// 处置过程描述
		faultHandle.setHandleDesc(faultHandleModel.getHandleDesc());
		// 备注
		faultHandle.setRemark(faultHandleModel.getRemark());
		// 故障单id
		faultHandle.setFaultId(faultHandleModel.getFaultId());
		// 处置类别
		faultHandle.setHandleType(faultHandleModel.getFaultHandelType());
		// 操作人
		faultHandle.setOperator(faultHandleModel.getOperator());
		// 故障处理时间
		faultHandle.setOperatTime(DateUtilTools.getNowDateTime());
		return faultHandle;
	}

	/**
	 * 技术工程师处理
	 * 
	 * @author duanyanlin
	 * @date 2016年6月27日下午3:26:00
	 * @param faultHandleModel
	 *            事件处置model
	 * @return faultInformation 事件单
	 */
	@Override
	public FaultInformation engineerHandle(FaultHandleModel faultHandleModel) {
		FaultInformation faultInformation = (FaultInformation) this.faultInformationDao
				.findById(faultHandleModel.getFaultId());
		// 根据操作人和故障单id查询故障处置记录
		FaultHandleQueryModel qm = new FaultHandleQueryModel();
		qm.setFaultId(faultHandleModel.getFaultId());
		qm.setCurrentUser(faultHandleModel.getOperator());
		List<FaultHandle> handles = this.faultHandleDao.queryList(qm);
		// 根据faultId和操作类型（ASSIGN）查询处置记录(最新的记录为部门经理分配记录)
		FaultHandleQueryModel fhqm = new FaultHandleQueryModel();
		fhqm.setFaultId(faultInformation.getId());
		fhqm.setFaultHandelType(FaultHandelType.ASSIGN);
		List<FaultHandle> handles1 = this.faultHandleDao.queryList(fhqm);
		User nextUser = null;
		if (CollectionUtils.isNotEmpty(handles1)) {
			// 部门经理
			nextUser = handles1.get(0).getOperator();
		}
		if (CollectionUtils.isEmpty(handles)
				|| (CollectionUtils.isNotEmpty(handles) && !ObjectUtils.equals(
						handles.get(0).getHandleType(), FaultHandelType.CACHE))) {
			/**
			 * 添加新处置记录
			 */
			// 故障单当前状态
			faultHandleModel.setFaultStatus(faultInformation.getFaultStatus());
			FaultHandle faultHandle = addCommon(faultHandleModel);
			// 读取故障单的编号并赋给处置记录中
			faultHandle.setFaultNumber(faultInformation.getFaultNumber());
			// 读取子故障单的编号并赋给处置记录中
			faultHandle.setFaultChildNumber(faultInformation
					.getFaultChildNumber());
			if (nextUser != null) {
				faultHandle.setNextHanleUser(nextUser.getName());
			}
			this.faultHandleDao.save(faultHandle);
		} else if (CollectionUtils.isNotEmpty(handles)
				&& ObjectUtils.equals(handles.get(0).getHandleType(),
						FaultHandelType.CACHE)) {
			// 更新处置记录
			FaultHandle faultHandle = handles.get(0);
			if (nextUser != null) {
				faultHandle.setNextHanleUser(nextUser.getName());
			}
			faultHandle.setFaultDesc(faultHandleModel.getFaultDesc());
			faultHandle.setHandleDesc(faultHandleModel.getHandleDesc());
			faultHandle.setRemark(faultHandleModel.getRemark());
			faultHandle.setOperatTime(DateUtilTools.getNowDateTime());
			faultHandle.setHandleType(faultHandleModel.getFaultHandelType());
			this.faultHandleDao.update(faultHandle);
		}
		// 技术工程师提交后，为部门经理发送短信
		if (nextUser != null
				&& ObjectUtils.equals(faultHandleModel.getFaultHandelType(),
						FaultHandelType.ENGINEER)
				&& faultHandleModel.getOperator() != null) {
			clientNoticeManager.sendMessage(nextUser, "您好！任务单（编号："
					+ faultInformation.getFaultNumber() + "，描述："
					+ faultHandleModel.getFaultDesc() + "，处理过程记录："
					+ faultHandleModel.getHandleDesc() + "）已经由技术工程师["
					+ faultHandleModel.getOperator().getName()
					+ "]处理完成，并提交给您，请及时处理！---[北京天航信网络公司]");
		}
		/**
		 * 如果技术工程师全部处理完
		 */
		// 部门经理分配的人员列表
		if (!StringUtils.isEmpty(faultInformation.getCurrentHandleUser())) {
			String[] engineers = faultInformation.getCurrentHandleUser().split(
					",");
			FaultHandleQueryModel fqm = new FaultHandleQueryModel();
			// 封装查询条件--故障单id
			fqm.setFaultId(qm.getFaultId());
			// 封装查询条件--技术工程师处理
			fqm.setFaultHandelType(FaultHandelType.ENGINEER);
			List<FaultHandle> faultHandles = this.faultHandleDao.queryList(fqm);
			if (nextUser != null && engineers.length != 0
					&& CollectionUtils.isNotEmpty(faultHandles)
					&& engineers.length == faultHandles.size()) {
				faultInformation.setFaultStatus(FaultStatus.HANDLE);
				if (!StringUtils.isEmpty(faultInformation
						.getProcessInstanceId())) {
					Task task = faultMngWorkflow
							.getTaskByProcessInstaceId(faultInformation
									.getProcessInstanceId());
					if (task != null) {
						String assignee = task.getAssignee();
						User assigneeUser = this.userDao.findById(assignee);
						System.err.println(assigneeUser.getName());
						faultInformation.setCurrentHandleUser(assigneeUser
								.getName());
					}
				}
				this.faultInformationDao.update(faultInformation);
			}
		}
		return faultInformation;
	}

	/**
	 * 故障处置
	 * 
	 * @author duanyanlin
	 * @date 2016年6月17日下午3:23:14
	 * @param faultHandleModel
	 *            事件处置model
	 * @return faultInformation 事件单
	 * @throws ServiceException
	 */
	@Override
	public FaultInformation handle(FaultHandleModel faultHandleModel)
			throws ServiceException {
		// System.out.println(faultHandleModel.getTransferType()+"---------handle----------"+TransferType.DEPT.name());
		FaultInformation faultInformation = (FaultInformation) this.faultInformationDao
				.findById(faultHandleModel.getFaultId());
		/**
		 * 故障处置记录操作（公共部分）
		 */
		// 故障单当前状态
		faultHandleModel.setFaultStatus(faultInformation.getFaultStatus());
		FaultHandle faultHandle = addCommon(faultHandleModel);
		// 读取故障单的编号并赋给处置记录中
		faultHandle.setFaultNumber(faultInformation.getFaultNumber());
		// 读取子故障单的编号并赋给处置记录中
		faultHandle.setFaultChildNumber(faultInformation.getFaultChildNumber());
		// 工作流实例id
		String processInstanceId = faultInformation.getProcessInstanceId();
		// 新建任务实体
		Task task = null;
		if (!StringUtils.isEmpty(processInstanceId)) {
			task = this.faultMngWorkflow
					.getTaskByProcessInstaceId(processInstanceId);
		}
		// 工作流赋值变量
		Map<String, Object> taskVariables = new HashMap<>();
		/**
		 * 根据不同事件处理的操作进行相应的故障处理
		 */
		if (StringUtils.equalsIgnoreCase(faultHandleModel.getFaultHandelType()
				.name(), FaultHandelType.HANGUP.name())) {
			/**
			 * 挂起操作
			 */
			// 修改当前处理人为待值班经理分配
			faultInformation
					.setCurrentHandleUser(FaultStatus.HANGUP.getValue());
			// 修改故障单状态---挂起
			faultInformation.setFaultStatus(FaultStatus.HANGUP);
			// 故障单挂起，faultHangup设置为true
			taskVariables.put(FaultWorkflowType.faultHangup.name(), true);
			// 故障单挂起，角色设置为值班经理
			taskVariables.put("userRole", DutyRoleEnum.DUTYMANAGER.name());
		} else if (StringUtils.equalsIgnoreCase(faultHandleModel
				.getFaultHandelType().name(), FaultHandelType.ASSIGN.name())) {
			/**
			 * 分配操作中，故障单状态为hangup的为值班经理分配,故障单状态为assign的为部门经理分配
			 */
			if (StringUtils.equalsIgnoreCase(faultInformation.getFaultStatus()
					.name(), FaultStatus.HANGUP.name())) {
				/**
				 * 值班经理分配
				 */
				// 修改故障单状态---一般处理
				faultInformation.setFaultStatus(FaultStatus.HANDLE);
				if (!StringUtils.isEmpty(faultHandleModel.getNextHanleUser())) {
					User nextHandleUser = this.userDao
							.findById(faultHandleModel.getNextHanleUser());
					if (nextHandleUser != null
							&& !StringUtils.isEmpty(nextHandleUser.getName())) {
						faultHandle.setNextHanleUser(nextHandleUser.getName());
						// 设置当前处理人（name）
						faultInformation.setCurrentHandleUser(nextHandleUser
								.getName());
					}
					// 业务处理工作流为其添加下一个处理人ID
					taskVariables.put("userId",
							faultHandleModel.getNextHanleUser());
				}
			} else if (StringUtils.equalsIgnoreCase(faultInformation
					.getFaultStatus().name(), FaultStatus.ASSIGN.name())) {
				/**
				 * 部门经理分配
				 */
				// 修改故障单状态---待部门经理确认
				faultInformation.setFaultStatus(FaultStatus.ASSIGNOK);
				if (!ArrayUtils
						.isEmpty(faultHandleModel.getNextHandleUserIds())) {
					StringBuilder nextHandleUsers = new StringBuilder("");
					for (int m = 0; m < faultHandleModel.getNextHandleUserIds().length; m++) {
						if (m != faultHandleModel.getNextHandleUserIds().length - 1) {
							nextHandleUsers.append(faultHandleModel
									.getNextHandleUserIds()[m] + ",");
						} else {
							nextHandleUsers.append(faultHandleModel
									.getNextHandleUserIds()[m]);
						}
					}
					// 设置当前处理人（name）
					faultInformation.setCurrentHandleUser(nextHandleUsers
							.toString());
					if (!StringUtils.isEmpty(faultInformation
							.getProcessInstanceId())) {
						// 查询当前任务
						Task assigneeTask = faultMngWorkflow
								.getTaskByProcessInstaceId(faultInformation
										.getProcessInstanceId());
						// 当前任务不为空且处理人id不为空
						if (assigneeTask != null
								&& !StringUtils.isEmpty(assigneeTask
										.getAssignee())) {
							// 下一处理人仍为当前任务的处理人
							taskVariables.put("userId",
									assigneeTask.getAssignee());
						}
					}
					// 业务处理工作流为其添加下一个处理人ID
					taskVariables
							.put(FaultWorkflowType.faultBack.name(), false);
					faultHandle.setNextHanleUser(nextHandleUsers.toString());
				}
			}
		} else if (faultInformation.getFirstHandelUser() != null
				&& StringUtils.equalsIgnoreCase(faultHandleModel
						.getFaultHandelType().name(), FaultHandelType.HANDLE
						.name())) {
			/**
			 * 一般处理，处理完成后为其添加第一处理人作为下一阶段的任务人（第一次处理人）
			 */
			faultHandle.setNextHanleUser(faultInformation.getFirstHandelUser()
					.getName());
			// 修改故障单状态---一般处理
			faultInformation.setFaultStatus(FaultStatus.CLASSIFY);
			// 修改故障单下一步所需处理人---第一处理人
			faultInformation.setCurrentHandleUser(faultInformation
					.getFirstHandelUser().getName());
			// 普通处理工作流为其添加第一处理人
			taskVariables.put("userId", faultInformation.getFirstHandelUser()
					.getId());
			// 添加公用部分，不退回
			taskVariables.put(FaultWorkflowType.faultBack.name(), false);
		} else if (StringUtils.equalsIgnoreCase(faultHandleModel
				.getFaultHandelType().name(), FaultHandelType.CLASSIFY.name())) {
			/**
			 * 事件归类，第一处理人处理
			 */
			// 更新故障单状态为success
			faultInformation.setFaultStatus(FaultStatus.SUCCESS);
			// 工作流中的完成SUCCESS线路为true
			taskVariables.put(FaultWorkflowType.success.name(), true);
			FaultTypeParent faultTypeParent = this.faultTypeParentDao
					.findById(faultHandleModel.getFaultTypeParent());
			if (faultTypeParent != null) {
				// 子级事件类型编号
				faultInformation.setFaultTypeId(faultTypeParent);
			}
			if (!StringUtils.isEmpty(faultHandleModel.getFaultTypeSon())) {
				FaultTypeSon faultTypeSon = this.faultTypeSonDao
						.findById(faultHandleModel.getFaultTypeSon());
				if (faultTypeSon != null) {
					// 子级事件类型编号
					faultInformation.setFaultTypeChildId(faultTypeSon);
				}
				// 影响业务数量
				faultInformation.setEffectProfessionNumber(faultHandleModel
						.getEffectProfessionNumber());
				// 故障的设备数量
				faultInformation.setFaultDeviceNumber(faultHandleModel
						.getFaultDeviceNumber());
			}

			// ----------------段衍林添加（2017-01-20）开始--------------
			/**
			 * 如果是KU告警事件单，修改告警事件单绑定实体信息
			 */
			if (ObjectUtils.equals(faultInformation.getSource(),
					FaultOriginType.KUALARM)) {
				// 根据事件单id查询ku告警绑定事件单的实体
				FaultAlarm faultAlarm = faultAlarmMngService
						.findByFaultId(faultInformation.getId());
				// 条件验证--非空且当前状态为工程师接单
				if (!ObjectUtils.equals(faultAlarm, null)
						&& ObjectUtils.equals(faultAlarm.getStatus(),
								FaultAlarmStatus.FAULT)) {
					// 更改实体状态
					faultAlarm.setStatus(FaultAlarmStatus.SUCCESS);
					// 更新操作人
					faultAlarm.setUpdater(faultHandleModel.getOperator());
					// 更新时间
					faultAlarm.setUpdateTime(DateUtilTools.getNowDateTime());
					// 实体更新
					faultAlarmMngService.update(faultAlarm);
					// 非ftp的告警发送短信
					if (!ObjectUtils.equals(faultAlarm.getEquip(), null)) {
						/**
						 * 发送短信
						 */
						// 短信信息
						String msg = "设备：" + faultAlarm.getEquip().getName()
								+ "--告警解除。";
						// 封装查询条件
						KuMobileQueryModel queryModel = new KuMobileQueryModel();
						// 设备id--非空验证
						if (!ObjectUtils.equals(faultAlarm.getEquip()
								.getEquip(), null)) {
							queryModel.setEquipId(faultAlarm.getEquip()
									.getEquip().getId());
						}
						// 短信发送标记
						queryModel.setFlag(NoticeFlag.yes);
						// 手机号全部查询
						List<KuMobile> mobiles = mobileManager
								.queryList(queryModel);
						// 非空验证
						if (CollectionUtils.isNotEmpty(mobiles)) {
							// 遍历手机号
							for (KuMobile kuMobile : mobiles) {
								SendLog sendLog = new SendLog(
										kuMobile.getMobile(), "",
										NoticeState.SMSFAIL, NoticeType.SMS,
										msg, Calendar.getInstance(), 0,
										kuMobile.getName(), kuMobile.getName(),
										"");
								clientNoticeDao.saveOrUpdate(sendLog);
							}
						}
					}

				}
			}
			// ----------------段衍林添加（2017-01-20）结束--------------

		} else if (StringUtils.equalsIgnoreCase(faultHandleModel
				.getFaultHandelType().name(), FaultHandelType.TRANSFER.name())) {
			/**
			 * 第一处理人任务移交(NOT--DEPT--STATION--CTO)(无移交--跨部门移交--其他坐席--移交部门经理)
			 */
			// 是否移交设定为否
			taskVariables.put(FaultWorkflowType.faultHangup.name(), false);
			// 故障处置记录添加移交方式
			faultHandle.setTransferType(TransferType.valueOf(faultHandleModel
					.getTransferType()));
			// 无移交，直接提交给第一处理人
			if (StringUtils
					.equalsIgnoreCase(faultHandleModel.getTransferType(),
							TransferType.NOT.name())) {
				// 无需移交时设置为一般处理
				faultHandle.setHandleType(FaultHandelType.HANDLE);
				/**
				 * 无需移交
				 */
				if (faultInformation.getFirstHandelUser() != null) {
					faultHandle.setNextHanleUser(faultInformation
							.getFirstHandelUser().getName());
					// 修改故障单下一步所需处理人---第一处理人
					faultInformation.setCurrentHandleUser(faultInformation
							.getFirstHandelUser().getName());
					// 无移交处理工作流为其添加第一处理人
					taskVariables.put("userId", faultInformation
							.getFirstHandelUser().getId());
				}
				// 修改故障单状态---一般处理
				faultInformation.setFaultStatus(FaultStatus.CLASSIFY);
				taskVariables.put(FaultWorkflowType.transferStation.name(),
						false);
				taskVariables.put(FaultWorkflowType.transferCTO.name(), false);
				taskVariables.put(FaultWorkflowType.transferDept.name(), false);
			} else if (StringUtils.equalsIgnoreCase(
					faultHandleModel.getTransferType(),
					TransferType.STATION.name())) {
				/**
				 * 坐席间移交 移交其他值班员
				 */
				faultInformation.setFaultStatus(FaultStatus.HANDLE);
				if (!StringUtils.isEmpty(faultHandleModel.getNextHanleUser())) {
					User nextHandleUser = this.userDao
							.findById(faultHandleModel.getNextHanleUser());
					faultHandle.setNextHanleUser(nextHandleUser.getName());
					if (nextHandleUser != null
							&& !StringUtils.isEmpty(nextHandleUser.getName())) {
						// 设置当前处理人（name）
						faultInformation.setCurrentHandleUser(nextHandleUser
								.getName());
					}
					taskVariables.put("userId",
							faultHandleModel.getNextHanleUser());
				}
				taskVariables.put(FaultWorkflowType.transferStation.name(),
						true);
			} else if (StringUtils
					.equalsIgnoreCase(faultHandleModel.getTransferType(),
							TransferType.CTO.name())) {
				/**
				 * 移交部门经理
				 */
				faultInformation.setFaultStatus(FaultStatus.ASSIGN);
				if (!StringUtils.isEmpty(faultHandleModel.getNextHanleUser())) {
					User nextHandleUser = this.userDao
							.findById(faultHandleModel.getNextHanleUser());
					faultHandle.setNextHanleUser(nextHandleUser.getName());
					if (nextHandleUser != null
							&& !StringUtils.isEmpty(nextHandleUser.getName())) {
						// 设置当前处理人（name）
						faultInformation.setCurrentHandleUser(nextHandleUser
								.getName());
					}
					taskVariables.put("userId",
							faultHandleModel.getNextHanleUser());
				}
				taskVariables.put(FaultWorkflowType.transferStation.name(),
						false);
				taskVariables.put(FaultWorkflowType.transferCTO.name(), true);
			} else if (StringUtils.equalsIgnoreCase(
					faultHandleModel.getTransferType(),
					TransferType.DEPT.name())) {
				/**
				 * 跨部门移交
				 */
				// hantianyu
				SimpleDateFormat datef = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				FaultSendJsonModel jsonqm = new FaultSendJsonModel();
				jsonqm.setContactsCompany(faultInformation.getFaultCompany());
				jsonqm.setContactsName(faultInformation.getContactsName());

				jsonqm.setFaultArea(faultInformation.getFaultArea());
				jsonqm.setFaultDesc(faultHandleModel.getFaultDesc());
				jsonqm.setFaultId(faultInformation.getId());
				jsonqm.setFaultLevel(faultInformation.getFaultLevel()
						.getValue());
				String datefault = datef
						.format(faultInformation.getFaultTime());

				jsonqm.setFaultTime(datefault);
				String faultPar = faultInformation.getEventType().getValue();

				jsonqm.setFaultTypePar(faultPar);
				jsonqm.setFaultTypeSon("");
				String handleDesc = faultHandleModel.getHandleDesc();

				jsonqm.setHandleDesc(handleDesc);
				String oaTime = faultHandleModel.getOaEndTime();

				jsonqm.setSuccessTime(oaTime);
				String tel = faultInformation.getTelephoneNumber();

				jsonqm.setTelephoneNumber(tel);

				User nextHandleUser = new User();
				// hty
				faultInformation.setFaultStatus(FaultStatus.HANDLEOA);
				if (!StringUtils.isEmpty(faultHandleModel.getNextHanleUser())) {
					nextHandleUser = this.userDao.findById(faultHandleModel
							.getNextHanleUser());
					faultHandle.setNextHanleUser(nextHandleUser.getName());
					if (nextHandleUser != null
							&& !StringUtils.isEmpty(nextHandleUser.getName())) {
						// 设置当前处理人（name）
						faultInformation.setCurrentHandleUser(nextHandleUser
								.getName());
					}
					taskVariables.put("userId",
							faultHandleModel.getNextHanleUser());
				}
				if (StringUtils.isEmpty(faultHandleModel.getOaDeptSecondId())) {
					faultHandle.setTransferDept(faultHandleModel.getOaDeptId());
				} else {
					faultHandle.setTransferDept(faultHandleModel
							.getOaDeptSecondId());
				}
				try {
					// 添加需求时间
					faultHandle.setOaEndTime(DateUtils.parseDate(
							faultHandleModel.getOaEndTime(),
							DateUtilTools.PATTERN_DATE_1));
				} catch (ParseException e) {
					// logger.error("时间数据异常！");
					throw new ServiceException("需求时间格式错误");
				}
				// hty

				// System.out.println(nextHandleUser.getName()+"---name---"+nextHandleUser.getId()+"---id---");
				DeptInfomationMng tdept = deptDao.findById(nextHandleUser
						.getDeptinfo().getId());

				jsonqm.setTransferDept(tdept.getDeptName());// 移交人部门
				jsonqm.setTransferName("-");// 移交人
				jsonqm.setTransferDeptNum(tdept.getDeptNumberOa());// 移交部门编号
				System.err.println("---SendMessage--");
				mqService.SendMessage(jsonqm,
						faultInformation.getFirstHandelUser());
				// hty
				taskVariables.put(FaultWorkflowType.transferStation.name(),
						false);
				taskVariables.put(FaultWorkflowType.transferCTO.name(), false);
				taskVariables.put(FaultWorkflowType.transferDept.name(), true);
			}
		} else if (StringUtils.equalsIgnoreCase(faultHandleModel
				.getFaultHandelType().name(), FaultHandelType.BACK.name())) {
			/**
			 * 退回操作
			 */
			// 退回给第一处理人重新处理
			faultInformation.setFaultStatus(FaultStatus.WAIT);
			if (faultInformation.getFirstHandelUser() != null) {
				// 修改故障单下一步所需处理人---第一处理人
				faultInformation.setCurrentHandleUser(faultInformation
						.getFirstHandelUser().getName());
				faultHandle.setNextHanleUser(faultInformation
						.getFirstHandelUser().getName());
				// 普通处理工作流为其添加第一处理人
				taskVariables.put("userId", faultInformation
						.getFirstHandelUser().getId());
			}
			taskVariables.put(FaultWorkflowType.faultBack.name(), true);
		}
		if (task != null) {
			// 执行工作流
			this.faultMngWorkflow.complete(task.getId(), taskVariables);
			if (!StringUtils.equalsIgnoreCase(faultHandleModel
					.getFaultHandelType().name(), FaultHandelType.CLASSIFY
					.name())) {
				Task taskAfter = this.faultMngWorkflow
						.getTaskByProcessInstaceId(processInstanceId);
				if (taskAfter != null) {
					// 随着工作流的进行，修改故障单中的当前业务名称
					faultInformation.setTaskName(taskAfter.getName());
				}
			} else {
				// 随着工作流的进行，修改故障单中的当前业务名称
				faultInformation.setTaskName(FaultStatus.SUCCESS.getValue());
			}
		}
		// 保存处置记录
		this.faultHandleDao.save(faultHandle);
		// 故障单更新时间
		faultInformation.setUpdateTime(DateUtilTools.getNowDateTime());
		// 更新故障单信息
		this.faultInformationDao.update(faultInformation);
		// 归类操作不用发送短信
		if (!ObjectUtils.equals(faultHandleModel.getFaultHandelType(),
				FaultHandelType.CLASSIFY)) {
			// 发送短信
			this.sendMessage(faultHandleModel);
		}
		return faultInformation;
	}

	/**
	 * 短信发送功能
	 * 
	 * @author duanyanlin
	 * @date 2016年7月6日下午1:04:34
	 * @param faultHandleModel
	 *            事件处置model
	 */
	@Override
	public void sendMessage(FaultHandleModel faultHandleModel) {
		// 查询故障单
		FaultInformation fault = this.faultInformationDao
				.findById(faultHandleModel.getFaultId());
		// 短信接收人
		String nextHandleUser = fault.getCurrentHandleUser();
		// 当前处理人--短信发送人
		User operator = faultHandleModel.getOperator();
		// 事件操作类型
		String handleType = "";
		if (StringUtils.equalsIgnoreCase(faultHandleModel.getFaultHandelType()
				.name(), FaultHandelType.HANDLE.name())) {
			// 一般处理的短信提示信息
			handleType = "处理完成，并提交";
		} else {
			// 其他操作的短信提示信息
			handleType = faultHandleModel.getFaultHandelType().getValue();
		}
		// 挂起状态的当前处理人（当前任务负责人）设置为挂起的标记---HANGUP，不用发送短信
		if (!StringUtils.equalsIgnoreCase(faultHandleModel.getFaultHandelType()
				.name(), FaultStatus.HANGUP.name())
				&& !StringUtils.isEmpty(nextHandleUser)) {
			// 针对部门经理分配技术工程师情形，需要对技术工程师全部发送短信
			String[] nextHandleUsers = nextHandleUser.split(",");
			for (int i = 0; i < nextHandleUsers.length; i++) {
				// 查询短信接收人
				User nextUser = this.userDao.findByParam("name",
						nextHandleUsers[i]);
				if (!ObjectUtils.equals(operator, null)
						&& !ObjectUtils.equals(operator, nextUser)) {
					clientNoticeManager.sendMessage(nextUser, "您好！任务单（编号："
							+ fault.getFaultNumber() + "，描述："
							+ faultHandleModel.getFaultDesc() + "，处理过程记录："
							+ faultHandleModel.getHandleDesc() + "）已经由["
							+ operator.getName() + "]" + handleType
							+ "给您，请及时处理！---[北京天航信网络公司]");
				}
			}
		} else if (StringUtils.equalsIgnoreCase(faultHandleModel
				.getFaultHandelType().name(), FaultStatus.HANGUP.name())) {
			// 根据故障单创建时所属值班地址，查询当前值班经理
			SignLeaveQueryModel slqm = new SignLeaveQueryModel();
			slqm.setDutyPlace(fault.getDutyPlace());
			// 值班工程师
			slqm.setDutyRole(DutyRoleEnum.DUTYENGINEER);
			List<User> users = this.signLeaveService
					.getEngineerListByPlace(slqm);
			if (CollectionUtils.isNotEmpty(users)
					&& ObjectUtils.equals(users.get(0), operator)
					&& !ObjectUtils.equals(operator, null)) {
				clientNoticeManager.sendMessage(users.get(0),
						"您好！任务单（编号：" + fault.getFaultNumber() + "，描述："
								+ faultHandleModel.getFaultDesc() + "，处理过程记录："
								+ faultHandleModel.getHandleDesc() + "）已经由["
								+ operator.getName() + "]" + handleType
								+ "，并分配给您，请及时处理！---[北京天航信网络公司]");
			}
		}
	}

	/**
	 * 查询故障处置记录列表
	 * 
	 * @author duanyanlin
	 * @date 2016年6月17日下午3:22:07
	 * @param qm
	 *            事件查询model
	 * @return List 事件处置记录
	 */
	@Override
	public List<FaultHandle> queryList(FaultHandleQueryModel qm) {
		return this.faultHandleDao.queryList(qm);
	}

	/**
	 * 判断技术工程师是否已经全部完成部门经理分配的任务
	 * 
	 * @author duanyanlin
	 * @date 2016年6月28日上午9:22:12
	 * @param qm
	 *            事件查询model
	 * @return bool boolean
	 */
	@Override
	public boolean boolEngineerSuccess(FaultHandleQueryModel qm) {
		boolean bool = false;
		// 根据faultId查询故障单和处置记录中技术工程师提交的记录数量
		FaultInformation faultInformation = this.faultInformationDao
				.findById(qm.getFaultId());
		if (StringUtils.equalsIgnoreCase(faultInformation.getFaultStatus()
				.name(), FaultStatus.ASSIGNOK.name())
				&& !StringUtils
						.isEmpty(faultInformation.getCurrentHandleUser())) {
			// 部门经理分配的人员列表
			String[] engineers = faultInformation.getCurrentHandleUser().split(
					",");
			FaultHandleQueryModel fqm = new FaultHandleQueryModel();
			// 封装查询条件--故障单id
			fqm.setFaultId(qm.getFaultId());
			// 封装查询条件--技术工程师处理
			fqm.setFaultHandelType(FaultHandelType.ENGINEER);
			List<FaultHandle> handles = this.faultHandleDao.queryList(fqm);
			if (CollectionUtils.isNotEmpty(handles) && engineers.length != 0
					&& engineers.length == handles.size()) {
				bool = true;
			}
		}
		return bool;
	}

	/**
	 * 暂存技术工程师处置记录
	 * 
	 * @author duanyanlin
	 * @date 2016年7月28日上午9:22:12
	 * @param faultHandleModel
	 *            事件处置model
	 * @return FaultHandle 事件处置记录
	 */
	@Override
	public FaultHandle savefaultTemporary(FaultHandleModel faultHandleModel) {

		// 查询已有故障处置记录
		FaultHandleQueryModel qm = new FaultHandleQueryModel();
		qm.setFaultId(faultHandleModel.getFaultId());
		// 查询暂存记录
		qm.setFaultHandelType(FaultHandelType.FAULTTEMPRARY);
		List<FaultHandle> faultHandles = this.queryList(qm);
		// 事件单
		FaultInformation fault = this.faultInformationDao
				.findById(faultHandleModel.getFaultId());
		// 页面展示事件处置记录（暂存）
		if (CollectionUtils.isNotEmpty(faultHandles)) {
			// 暂存记录只能有一条
			FaultHandle handle = faultHandles.get(0);
			handle.setFaultDesc(faultHandleModel.getFaultDesc());
			handle.setHandleDesc(faultHandleModel.getHandleDesc());
			handle.setRemark(faultHandleModel.getRemark());
			// 存在的情况下更新
			this.faultHandleDao.update(handle);
			return handle;
		} else {
			// 不存在的情况下保存新数据
			FaultHandle handle = new FaultHandle();
			handle.setFaultId(faultHandleModel.getFaultId());
			handle.setFaultDesc(faultHandleModel.getFaultDesc());
			handle.setHandleDesc(faultHandleModel.getHandleDesc());
			handle.setRemark(faultHandleModel.getRemark());
			handle.setOperatTime(DateUtilTools.getNowDateTime());
			handle.setOperator(fault.getFirstHandelUser());
			// 存储为第一处理人暂存状态
			handle.setHandleType(FaultHandelType.FAULTTEMPRARY);
			this.faultHandleDao.save(handle);
			return handle;
		}
	}

	/**
	 * 部门经理退回技术工程师
	 * 
	 * @author duanyanlin
	 * @date 2016年7月28日上午9:22:12
	 * @param faultHandleModel
	 *            事件处置model
	 */
	@Override
	public void backEngineer(FaultHandleModel faultHandleModel) {
		String[] handleIds = faultHandleModel.getHandlesIds().split(",");
		// 存在故障处置记录ID
		if (handleIds.length > 0
				&& !StringUtils.isEmpty(faultHandleModel.getFaultId())) {
			// 修改事件单信息
			FaultInformation faultInformation = this.faultInformationDao
					.findById(faultHandleModel.getFaultId());
			// 修改事件单状态为待部门经理确认
			faultInformation.setFaultStatus(FaultStatus.ASSIGNOK);
			// 修改事件单当前处理人为原分配人，查询部门经理分配记录
			FaultHandleQueryModel qm = new FaultHandleQueryModel();
			// 查询条件，faultId,分配时的部门经理，操作类型
			// qm.setCurrentUser(faultHandleModel.getOperator());
			qm.setFaultId(faultHandleModel.getFaultId());
			qm.setFaultHandelType(FaultHandelType.ASSIGN);
			List<FaultHandle> faultHandles = this.faultHandleDao.queryList(qm);
			// 封装处理人
			if (CollectionUtils.isNotEmpty(faultHandles)) {
				faultInformation.setCurrentHandleUser(faultHandles.get(0)
						.getNextHanleUser());
			}
			this.faultInformationDao.update(faultInformation);
			for (int i = 0; i < handleIds.length; i++) {
				// 事件处置记录ID
				String handleId = handleIds[i];
				FaultHandle faultHandle = this.faultHandleDao
						.findById(handleId);
				// 退回的事件单处置记录更新部门经理退回的处置记录
				faultHandle.setHandleType(FaultHandelType.BACKEDENGINEER);
				this.faultHandleDao.update(faultHandle);
				// 添加新的处置记录
				FaultHandle faultHandle1 = new FaultHandle();
				faultHandle1.setFaultId(faultHandleModel.getFaultId());
				faultHandle1.setFaultNumber(faultInformation.getFaultNumber());
				faultHandle1.setFaultChildNumber(faultInformation
						.getFaultChildNumber());
				faultHandle1.setFaultDesc(faultHandleModel.getFaultDesc());
				faultHandle1.setHandleDesc(faultHandleModel.getHandleDesc());
				faultHandle1.setRemark(faultHandleModel.getRemark());
				// 被退回事件单处置记录的处理人为下一个处理人
				faultHandle1.setNextHanleUser(faultHandle.getOperator()
						.getName());
				// 设置事件处置记录为部门经理退回事件单
				faultHandle1.setHandleType(FaultHandelType.BACKENGINEER);
				faultHandle1.setOperator(faultHandleModel.getOperator());
				faultHandle1.setOperatTime(DateUtilTools.getNowDateTime());
				this.faultHandleDao.save(faultHandle1);
			}
		}
	}
}