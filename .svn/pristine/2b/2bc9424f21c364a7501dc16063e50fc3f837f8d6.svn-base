package cn.com.atnc.ioms.web.faultmng;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.dao.faultmng.IFaultAreaDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultInformationDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.faultmng.FaultAlarm;
import cn.com.atnc.ioms.entity.faultmng.FaultArea;
import cn.com.atnc.ioms.entity.faultmng.FaultEvaluate;
import cn.com.atnc.ioms.entity.faultmng.FaultHandle;
import cn.com.atnc.ioms.entity.faultmng.FaultInformation;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.enums.faultmng.FaultAlarmStatus;
import cn.com.atnc.ioms.enums.faultmng.FaultEvaluateStatus;
import cn.com.atnc.ioms.enums.faultmng.FaultEventType;
import cn.com.atnc.ioms.enums.faultmng.FaultHandelType;
import cn.com.atnc.ioms.enums.faultmng.FaultLevelType;
import cn.com.atnc.ioms.enums.faultmng.FaultOriginType;
import cn.com.atnc.ioms.enums.faultmng.FaultStatus;
import cn.com.atnc.ioms.enums.faultmng.SubmitType;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyRoleEnum;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.acl.IUserRoleManager;
import cn.com.atnc.ioms.mng.faultmng.IFaultAlarmMngService;
import cn.com.atnc.ioms.mng.faultmng.IFaultEvaluateMngService;
import cn.com.atnc.ioms.mng.faultmng.IFaultHandleMngService;
import cn.com.atnc.ioms.mng.faultmng.IFaultInformationMngService;
import cn.com.atnc.ioms.mng.faultmng.IFaultMQService;
import cn.com.atnc.ioms.mng.systemmng.deptinfomng.IDeptInfoMngService;
import cn.com.atnc.ioms.mng.turndutymng.ISignLeaveService;
import cn.com.atnc.ioms.model.SysFinals;
import cn.com.atnc.ioms.model.faultmng.FaultAlarmQueryModel;
import cn.com.atnc.ioms.model.faultmng.FaultEvaluateModel;
import cn.com.atnc.ioms.model.faultmng.FaultHandleModel;
import cn.com.atnc.ioms.model.faultmng.FaultHandleQueryModel;
import cn.com.atnc.ioms.model.faultmng.FaultInformationModel;
import cn.com.atnc.ioms.model.turndutymng.SignLeaveQueryModel;
import cn.com.atnc.ioms.util.HqlStringTools;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 事件处理控制类
 * 
 * @author duanyanlin
 * @date 2016年8月5日下午3:26:49
 * 
 * 
 *       修改人：段衍林 修改时间：2016年11月9日 下午4:12:40 修改内容：添加事件单评价模块
 */
@Controller("faultHandleController")
@RequestMapping("faultmng/")
public class FaultHandleController extends MyBaseController {

	@Autowired
	private IFaultInformationMngService faultInformationMngService;
	@Autowired
	private ISignLeaveService signLeaveService;
	@Autowired
	private IFaultHandleMngService faultHandleMngService;
	@Autowired
	private IUserRoleManager userRoleManage;
	@Autowired
	private IFaultAreaDao faultAreaDao;
	@Autowired
	private IFaultInformationDao faultInformationDao;
	@Autowired
	private IDeptInfoMngService deptInfoMng;
	@Autowired
	private IFaultMQService faultMQService;
	@Autowired
	private IUserManager userManager;
	@Autowired
	private IFaultEvaluateMngService faultEvaluateMngService;
	@Autowired
	private IFaultAlarmMngService faultAlarmMngService;

	/**
	 * 故障处置页面控制GET
	 * 
	 * @author duanyanlin
	 * @date 2016年7月15日上午10:43:40
	 * @param qm
	 *            故障单查询model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 返回首页
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			Model model, HttpServletRequest request) {
		try {

			// 事件类别
			model.addAttribute("eventTypes", FaultEventType.values());
			// 事件级别
			model.addAttribute("faultLevels", FaultLevelType.values());
			// 事件单来源
			model.addAttribute("sources", FaultOriginType.values());
			User localUser = (User) request.getSession().getAttribute(
					"loginUser");
			// 查询该用户是否为值班经理
			boolean bool1 = this.signLeaveService.isMangerByUser(localUser);
			// 查询该用户是否为部门经理
			boolean bool2 = this.userRoleManage.hasRoleByUser(localUser,
					RoleEnum.atncLeader.name());
			// 查询该用户是否为部门经理(原始角色)
			boolean bool3 = this.userRoleManage.hasRoleByUserOrdinal(localUser,
					RoleEnum.atncLeader.name());
			// 值班经理
			model.addAttribute("isMangerByUser", Boolean.valueOf(bool1));
			// 当前拥有角色
			model.addAttribute("isDeptMangerByUser", Boolean.valueOf(bool2));
			// 当前拥有原始角色
			model.addAttribute("isDeptMangerByUser1", Boolean.valueOf(bool3));
			model.addAttribute("currentHandleUser", localUser.getName());
			if (signLeaveService.isOndutyByUser(localUser)) {
				// 签到
				model.addAttribute("isflag", SysFinals.YES);
			} else {
				// 未签到
				model.addAttribute("isflag", SysFinals.NO);
			}
			super.addLog(request, "(GET)faultmng/fault/manage.do");
			super.pageInfo(model, request);

		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "faultmng/fault/manage";
	}

	/**
	 * 故障管理
	 * 
	 * @author duanyanlin
	 * @date 2016年6月17日下午3:37:00
	 * @param optType
	 *            tab页标志位
	 * @param qm
	 *            故障单查询model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 返回首页
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			@RequestParam("optType") String optType, Model model,
			HttpServletRequest request) {
		try {

			model.addAttribute("optType", qm.getOptType());
			// 通配符转换字符串
			if (!StringUtils.isEmpty(qm.getContactsName())
					&& StringUtils.equalsIgnoreCase(optType, "COMPLETEFAULT")) {
				// 将已完成事件統計中的查詢申告人中的_下划线转换成字符_
				// qm.setContactsName(StringUtils.replace(qm.getContactsName(),
				// "_",
				// "/_"));
				qm.setContactsName(HqlStringTools.replaceSpecialChar(qm
						.getContactsName()));
			}
			// 当前用户
			User user = getCurrentUser(request);
			qm.setCurrentUser(user);
			// 封装故障单状态
			List<FaultStatus> faultStatusList = new ArrayList<FaultStatus>();
			// 判断tab页传值
			if (StringUtils.isEmpty(optType)) {
				optType = "";
			}
			// 分条件查询页面所需内容
			switch (optType) {
			case "DEPTFAULT":
				// 部门经理分配业务(根据部门经理的UserId查询--当前登录用户)
				faultStatusList.add(FaultStatus.ASSIGN);
				break;
			case "ASSIGNFAULT":
				// 封装值班地点
				String dutyPlace = this.signLeaveService
						.getDutyPlaceByUser(user);
				DutyPlaceEnum dutyPlaceEnum = DutyPlaceEnum.valueOf(dutyPlace);
				qm.setDutyPlace(dutyPlaceEnum);
				// 值班经理分配
				faultStatusList.add(FaultStatus.HANGUP);
				break;
			case "HANDLEFAULT":
				// 待处理页面
				faultStatusList.add(FaultStatus.WAIT);
				faultStatusList.add(FaultStatus.HANDLE);
				faultStatusList.add(FaultStatus.CLASSIFY);
				faultStatusList.add(FaultStatus.ASSIGNOK);
				break;
			case "COMPLETEFAULT":
				// 已完成
				faultStatusList.add(FaultStatus.SUCCESS);
				qm.setFaultStatus(faultStatusList);
				qm.setCurrentHandleUser(user.getName());
				Pagination pagns = this.faultInformationMngService
						.queryPage(qm);
				model.addAttribute("pagn", pagns);
				model.addAttribute("currentHandleUser", user.getName());
				// 查询当前登录用户是否已经签到
				if (signLeaveService.isOndutyByUser(user)) {
					// 签到
					model.addAttribute("isflag", SysFinals.YES);
				} else {
					// 未签到
					model.addAttribute("isflag", SysFinals.NO);
				}
				return "faultmng/fault/queryResult";
			case "EVALUATE":
				/**
				 * 段衍林 2016-11-09
				 */
				// 待评价，根据登录用户查询成功但未评价的事件
				faultStatusList.add(FaultStatus.SUCCESS);
				// 封装需查询的事件单状态--完成
				qm.setFaultStatus(faultStatusList);
				// 查询事件单评价状态--未评价
				qm.setFaultEvaluateStatus(FaultEvaluateStatus.UNEVALUATE);
				// 分页查询
				Pagination pagn1 = this.faultInformationMngService
						.queryEvaluatePage(qm);
				// 封装分页数据
				model.addAttribute("pagn", pagn1);
				// 回显当前用户
				model.addAttribute("currentHandleUser", user.getName());
				// 查询当前登录用户是否已经签到
				if (signLeaveService.isOndutyByUser(user)) {
					// 签到
					model.addAttribute("isflag", SysFinals.YES);
				} else {
					// 未签到
					model.addAttribute("isflag", SysFinals.NO);
				}
				return "faultmng/fault/queryResult";
			case "FAULTALARM":
				/**
				 * 段衍林 2017-01-19 告警
				 */
				// 封装查询条件
				FaultAlarmQueryModel queryModel = new FaultAlarmQueryModel();
				// 告警事件单处置状态为告警
				queryModel.setStatus(FaultAlarmStatus.ALARM);
				// 封装分页数据
				model.addAttribute("pagn",
						faultAlarmMngService.queryPage(queryModel));
				// 页面导航
				return "faultmng/fault/queryResultAlarm";
			default:
				// 待处理页面
				faultStatusList.add(FaultStatus.WAIT);
				faultStatusList.add(FaultStatus.HANDLE);
				faultStatusList.add(FaultStatus.CLASSIFY);
				faultStatusList.add(FaultStatus.ASSIGNOK);
			}
			// 封装查询条件
			qm.setFaultStatus(faultStatusList);
			qm.setCurrentHandleUser(user.getName());

			List<FaultInformation> faultInformations = faultInformationMngService
					.queryList(qm);
			model.addAttribute("faultInformations", faultInformations);
			model.addAttribute("currentHandleUser", user.getName());
			// 查询当前登录用户是否已经签到
			if (signLeaveService.isOndutyByUser(user)) {
				// 签到
				model.addAttribute("isflag", SysFinals.YES);
			} else {
				// 未签到
				model.addAttribute("isflag", SysFinals.NO);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "faultmng/fault/queryResult";
	}

	/**
	 * 手动添加故障单页面控制
	 * 
	 * @author duanyanlin
	 * @date 2016年6月21日上午11:26:23
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 添加页面
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String addTab(Model model, HttpServletRequest request) {
		try {

			// 当前用户
			User user = getCurrentUser(request);
			// 事件类别
			model.addAttribute("eventTypes", FaultEventType.values());
			// 事件级别
			model.addAttribute("faultLevels", FaultLevelType.values());
			// 当前处理人
			model.addAttribute("currentHandleUser", user.getName());
			super.addLog(request, "(GET)faultmng/fault/add.do");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "faultmng/fault/add";
	}

	/**
	 * 同步加载地区资源
	 * 
	 * @author duanyanlin
	 * @date 2016年6月28日下午12:19:50
	 * @param model
	 *            模型
	 * @return String 异步请求数据
	 */
	@RequestMapping(value = "getAreaData.dox", method = RequestMethod.GET)
	public String getAreaData(Model model) {
		// 当前用户
		List<FaultArea> areas = this.faultAreaDao.getAll();
		try {
			model.addAttribute("returnStr", JacksonTools.toJsonStr(areas));
		} catch (IOException e) {
			// e.printStackTrace();
			throw new RuntimeException("异步区域查询数据失败");
		}
		return "returnnote";
	}

	/**
	 * 异步查询故障单
	 * 
	 * @author duanyanlin
	 * @date 2016年6月28日下午1:15:34
	 * @param model
	 *            模型
	 * @param qm
	 *            故障单查询model
	 * @return String 异步数据
	 * @throws UnsupportedEncodingException
	 *             异常类型
	 */
	@RequestMapping(value = "getFaultInfo.dox", method = RequestMethod.GET)
	public String getFaultInfo(Model model, FaultHandleQueryModel qm)
			throws UnsupportedEncodingException {
		try {

			// 对故障地区进行转码
			String faultCompany = qm.getFaultCompany();
			if (!StringUtils.isEmpty(faultCompany)) {
				// 地区编码格式
				faultCompany = URLDecoder.decode(faultCompany, "UTF-8");
				qm.setFaultCompany(faultCompany);
			}
			// 查询主故障单
			qm.setFaultChildNumber(0);
			List<FaultInformation> faultInformations = this.faultInformationDao
					.queryList(qm);
			try {
				model.addAttribute("returnStr",
						JacksonTools.toJsonStr(faultInformations));
			} catch (IOException e) {
				// logger.error("数据加载异常！");
				// e.printStackTrace();
				throw new RuntimeException("数据加载异常");
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 手动添加故障单操作
	 * 
	 * @author duanyanlin
	 * @date 2016年6月21日上午11:26:23
	 * @param model
	 *            模型
	 * @param faultInformationModel
	 *            故障单信息model
	 * @param request
	 *            请求
	 * @return String 返回添加回显值
	 * @throws IOException
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String add(Model model, FaultInformationModel faultInformationModel,
			HttpServletRequest request) throws IOException {
		try {

			// 当前用户
			User user = getCurrentUser(request);
			faultInformationModel.setCurrentUser(user);
			try {
				this.faultInformationMngService
						.saveFaultInformation(faultInformationModel);
				model.addAttribute("returnStr", new ResultModel(true,
						"事件单添加成功", null).toJson());
				// 添加日志
				super.addLog(request, "事件处理：事件单添加成功！");
			} catch (ServiceException e) {
				model.addAttribute("returnStr", new ResultModel(false,
						"事件单添加失败", null).toJson());
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 待处理事件暂存功能
	 * 
	 * @param model
	 *            模型
	 * @param qm
	 *            故障处置查询model
	 * @return String 暂存页面
	 */
	@RequestMapping(value = "faultTemporary.do", method = RequestMethod.GET)
	public String faultTemporaryGet(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm, Model model) {

		try {

			// 当前故障单编号
			String id = qm.getFaultId();
			// 当前故障单
			FaultInformation faultInformation = this.faultInformationDao
					.findById(id);
			model.addAttribute("fault", faultInformation);
			// 当前处置记录
			// 暂存处理
			qm.setFaultHandelType(FaultHandelType.FAULTTEMPRARY);
			List<FaultHandle> faultHandles = this.faultHandleMngService
					.queryList(qm);
			// 页面展示事件处置记录（暂存）
			if (CollectionUtils.isNotEmpty(faultHandles)) {
				model.addAttribute("handle", faultHandles.get(0));
			} else {
				model.addAttribute("handle", null);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "faultmng/fault/faultTemporary";
	}

	/**
	 * 待处理事件暂存功能
	 * 
	 * @param model
	 *            模型
	 * @param qm
	 *            故障处置查询model
	 * @param faultHandleModel
	 *            事件处置model
	 * @return String 暂存回显
	 * @throws IOException
	 */
	@RequestMapping(value = "faultTemporary.do", method = RequestMethod.POST)
	public String faultTemporaryPost(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			FaultHandleModel faultHandleModel, Model model) throws IOException {
		try {
			this.faultHandleMngService.savefaultTemporary(faultHandleModel);
			model.addAttribute("returnStr",
					new ResultModel(true, "暂存成功", null).toJson());
		} catch (IOException e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "暂存失败", null).toJson());
		}
		return "returnnote";
	}

	/**
	 * 值班经理分配
	 * 
	 * @author duanyanlin
	 * @date 2016年6月17日下午3:38:39
	 * @param qm
	 *            事件处置查询model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 值班经理分配页面控制
	 */
	@RequestMapping(value = "fault/assign.do", method = RequestMethod.GET)
	public String assignFaultGet(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			Model model, HttpServletRequest request) {
		try {

			FaultInformation faultInformation = this.faultInformationMngService
					.findById(qm);
			List<FaultHandle> faultHandles = this.faultHandleMngService
					.queryList(qm);
			// 根据故障单创建时所属值班地址，查询当前值班工程师
			SignLeaveQueryModel slqm = new SignLeaveQueryModel();
			slqm.setDutyPlace(faultInformation.getDutyPlace());
			slqm.setDutyRole(DutyRoleEnum.DUTYENGINEER); // 值班工程师
			List<User> users = this.signLeaveService
					.getEngineerListByPlace(slqm);
			User user = getCurrentUser(request);
			// 当前处理人
			model.addAttribute("currentHandleUser", user.getName());
			model.addAttribute("users", users);
			model.addAttribute("fault", faultInformation);
			model.addAttribute("faultHandles", faultHandles);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "faultmng/fault/assign";
	}

	/**
	 * 值班经理分配记录保存
	 * 
	 * @author duanyanlin
	 * @date 2016年6月17日下午3:38:39
	 * @param qm
	 *            事件处置查询model
	 * @param faultHandleModel
	 *            事件处置model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 分配回显
	 * @throws IOException
	 */
	@RequestMapping(value = "fault/assign.do", method = RequestMethod.POST)
	public String assignFaultPost(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			FaultHandleModel faultHandleModel, Model model,
			HttpServletRequest request) throws IOException {
		try {
			User localUser = (User) request.getSession().getAttribute(
					"loginUser");
			faultHandleModel.setOperator(localUser); // 添加当前处理人
			faultHandleModel.setFaultHandelType(FaultHandelType.ASSIGN); // 添加分配操作标识
			try {
				this.faultHandleMngService.handle(faultHandleModel);
				model.addAttribute("returnStr", new ResultModel(true, "分配成功",
						null).toJson());
				super.addLog(request, "事件处理：值班经理分配成功！");
			} catch (ServiceException e) {
				model.addAttribute("returnStr", new ResultModel(false, "分配失败",
						null).toJson());
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 部门经理分配页面控制
	 * 
	 * @author duanyanlin
	 * @date 2016年6月27日上午9:22:08
	 * @param qm
	 *            事件处置查询model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 部门经理分配页面控制
	 */
	@RequestMapping(value = "fault/faultdept.do", method = RequestMethod.GET)
	public String getDept(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			Model model, HttpServletRequest request) {
		try {

			// 故障单信息和故障相关处置记录查询
			FaultInformation faultInformation = this.faultInformationMngService
					.findById(qm);
			List<FaultHandle> faultHandles = this.faultHandleMngService
					.queryList(qm);
			// 当前处理人
			User user = getCurrentUser(request);
			// 根据当前登录用户查询所有部门工程师(engineer)
			// List<User> users = this.deptInfoMng.getUserListByDept(user);
			// //部门员工
			// 根据角色查询技术工程师（engineer）
			List<User> users = this.userManager.getSomeUsersByRole(
					RoleEnum.engineer.name(), user);
			// 当前处理人
			model.addAttribute("currentHandleUser", user.getName());
			// 技术工程师列表
			model.addAttribute("users", users);
			// 事件单信息
			model.addAttribute("fault", faultInformation);
			// 事件单处置记录
			model.addAttribute("faultHandles", faultHandles);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "faultmng/fault/faultdept";
	}

	/**
	 * 部门经理分配任务
	 * 
	 * @author duanyanlin
	 * @date 2016年6月27日上午10:15:25
	 * @param faultHandleModel
	 *            事件处置model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 回显
	 * @throws IOException
	 */
	@RequestMapping(value = "fault/faultdept.do", method = RequestMethod.POST)
	public String postDept(FaultHandleModel faultHandleModel, Model model,
			HttpServletRequest request) throws IOException {
		try {

			// 当前用户
			User user = getCurrentUser(request);
			// 封装查询条件
			faultHandleModel.setOperator(user);
			faultHandleModel.setFaultHandelType(FaultHandelType.ASSIGN);
			// 获取下一处理人数组数据
			String[] nextHandleUserIds = request
					.getParameterValues("nextHanleUser");
			faultHandleModel.setNextHandleUserIds(nextHandleUserIds);
			try {
				// 事件处理
				this.faultHandleMngService.handle(faultHandleModel);
				model.addAttribute("returnStr", new ResultModel(true, "分配成功",
						null).toJson());
				super.addLog(request, "事件处理：部门经理分配成功！");
			} catch (ServiceException e) {
				model.addAttribute("returnStr", new ResultModel(false, "分配失败",
						null).toJson());
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 部门经理退回技术工程师
	 * 
	 * @author duanyanlin
	 * @date 2016年6月27日上午10:15:25
	 * @param faultHandleModel
	 *            事件处置model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 部门经理退回
	 * @throws IOException
	 */
	@RequestMapping(value = "fault/backEngineer.do", method = RequestMethod.POST)
	public String backEngineer(FaultHandleModel faultHandleModel, Model model,
			HttpServletRequest request) throws IOException {
		try {

			// 当前用户
			User user = getCurrentUser(request);
			faultHandleModel.setOperator(user);
			// 封装事件处置类型为退回操作
			faultHandleModel.setFaultHandelType(FaultHandelType.BACKENGINEER);
			try {
				// 部门经理退回
				this.faultHandleMngService.backEngineer(faultHandleModel);
				model.addAttribute("returnStr", new ResultModel(true, "退回成功",
						null).toJson());
				super.addLog(request, "事件处理：部门经理退回事件单成功！");
			} catch (IOException e) {
				model.addAttribute("returnStr", new ResultModel(false, "退回失败",
						null).toJson());
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 一般处理页面
	 * 
	 * @author duanyanlin
	 * @date 2016年6月23日上午10:22:33
	 * @param model
	 *            模型
	 * @param qm
	 *            事件处置查询model
	 * @param request
	 *            请求
	 * @return String 处置页面
	 */
	@RequestMapping(value = "fault/handle.do", method = RequestMethod.GET)
	public String handleGet(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			Model model, HttpServletRequest request) {
		try {

			FaultInformation faultInformation = this.faultInformationMngService
					.findById(qm);
			List<FaultHandle> faultHandles = this.faultHandleMngService
					.queryList(qm);
			// 当前用户
			User user = getCurrentUser(request);
			// 判断是否为部门经理
			boolean bool = this.userRoleManage.hasRoleByUser(user,
					RoleEnum.atncLeader.name());
			boolean successEngineer = false;
			if (bool) {
				successEngineer = this.faultHandleMngService
						.boolEngineerSuccess(qm);
			}
			// 查询暂存记录
			FaultHandleQueryModel queryModel = new FaultHandleQueryModel();
			queryModel.setCurrentUser(user);
			queryModel.setFaultHandelType(FaultHandelType.CACHE);
			queryModel.setFaultId(faultInformation.getId());
			List<FaultHandle> faultHandle = this.faultHandleMngService
					.queryList(queryModel);
			if (CollectionUtils.isNotEmpty(faultHandle)) {
				model.addAttribute("handle", faultHandle.get(0));
			}
			// 回显页面数据
			model.addAttribute("successEngineer", successEngineer);
			model.addAttribute("deptBool", bool);
			model.addAttribute("currentHandleUser", user.getName());
			model.addAttribute("fault", faultInformation);
			model.addAttribute("faultHandles", faultHandles);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "faultmng/fault/handle";
	}

	/**
	 * 一般处理处理过程记录
	 * 
	 * @author duanyanlin
	 * @date 2016年6月23日上午10:22:33
	 * @param qm
	 *            事件处置查询model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @param faultHandleModel
	 *            事件处置model
	 * @return String 回显
	 * @throws IOException
	 */
	@RequestMapping(value = "fault/handle.do", method = RequestMethod.POST)
	public String handlePost(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			FaultHandleModel faultHandleModel, Model model,
			HttpServletRequest request) throws IOException {

		try {

			User user = getCurrentUser(request); // 当前用户
			faultHandleModel.setOperator(user);
			try {
				if (StringUtils.equalsIgnoreCase(
						faultHandleModel.getSubmitType(),
						SubmitType.temporary.name())) {
					// 技术工程师暂存处理功能
					faultHandleModel.setFaultHandelType(FaultHandelType.CACHE);
					this.faultHandleMngService.engineerHandle(faultHandleModel);
				} else if (StringUtils.equalsIgnoreCase(
						faultHandleModel.getSubmitType(),
						SubmitType.engineersubmit.name())) {
					// 技术工程师提交处理
					faultHandleModel
							.setFaultHandelType(FaultHandelType.ENGINEER);
					this.faultHandleMngService.engineerHandle(faultHandleModel);
				} else {
					// 一般处理
					faultHandleModel.setFaultHandelType(FaultHandelType.HANDLE);
					this.faultHandleMngService.handle(faultHandleModel);
				}
				model.addAttribute("returnStr", new ResultModel(true, "处理成功",
						null).toJson());
				super.addLog(request, "事件处理：一般处理成功");
			} catch (ServiceException e) {
				model.addAttribute("returnStr", new ResultModel(false, "处理失败",
						null).toJson());
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 故障单详情
	 * 
	 * @author duanyanlin
	 * @date 2016年6月29日下午12:42:35
	 * @param qm
	 *            事件处置查询model
	 * @param model
	 *            模型
	 * @return String 详情页
	 */
	@RequestMapping(value = "fault/view.do", method = RequestMethod.GET)
	public String viewFault(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm, Model model) {
		try {

			// 查询事件单
			FaultInformation faultInformation = this.faultInformationMngService
					.findById(qm);
			// 查询处置记录
			List<FaultHandle> faultHandles = this.faultHandleMngService
					.queryList(qm);
			model.addAttribute("fault", faultInformation);
			model.addAttribute("faultHandles", faultHandles);
			/**
			 * 段衍林 2016-11-09
			 */
			if (ObjectUtils.equals(faultInformation.getFaultEvaluateStatus(),
					FaultEvaluateStatus.EVALUATE)) {
				// 封装查询条件
				FaultEvaluateModel faultEvaluateModel = new FaultEvaluateModel();
				// 事假单id
				faultEvaluateModel.setFaultId(faultInformation.getId());
				// 查询
				List<FaultEvaluate> faultEvaluates = faultEvaluateMngService
						.queryList(faultEvaluateModel);
				// 如果列表不为空，取最新一条
				if (CollectionUtils.isNotEmpty(faultEvaluates)) {
					model.addAttribute("faultEvaluate", faultEvaluates.get(0));
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "faultmng/fault/view";
	}

	/**
	 * 故障单评价页面控制
	 * 
	 * @author 段衍林
	 * @2016年11月9日 下午4:52:35
	 * @param qm
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "fault/evaluate.do", method = RequestMethod.GET)
	public String evaluateFault(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm, Model model) {

		try {
			FaultInformation faultInformation = this.faultInformationMngService
					.findById(qm);
			List<FaultHandle> faultHandles = this.faultHandleMngService
					.queryList(qm);
			model.addAttribute("fault", faultInformation);
			model.addAttribute("faultHandles", faultHandles);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "faultmng/fault/evaluate";
	}

	/**
	 * 故障单评价
	 * 
	 * @author 段衍林
	 * @2016年11月9日 下午4:12:40
	 * @param qm
	 * @param model
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping(value = "fault/evaluate.do", method = RequestMethod.POST)
	public String evaluateFault(
			@ModelAttribute("queryModel") FaultEvaluateModel qm, Model model,
			HttpServletRequest request) throws IOException {
		try {
			// 当前用户
			User user = getCurrentUser(request);
			// 封装评价人
			qm.setUser(user);
			// 评价操作
			this.faultEvaluateMngService.saveEvaluate(qm);
			// 回显
			model.addAttribute("returnStr",
					new ResultModel(true, "评价成功", null).toJson());
			super.addLog(request, "事件处理：评价成功");
		} catch (Exception e) {
			// 失败回显
			model.addAttribute("returnStr",
					new ResultModel(false, "评价失败", null).toJson());
		}
		return "returnnote";
	}

	/**
	 * 故障单退回
	 * 
	 * @author duanyanlin
	 * @date 2016年6月30日上午9:47:20
	 * @param qm
	 *            事件处置查询model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 退回页面
	 */
	@RequestMapping(value = "fault/faultBack.do", method = RequestMethod.GET)
	public String faultBackGet(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			Model model, HttpServletRequest request) {
		try {

			// 故障单基本信息
			FaultInformation faultInformation = this.faultInformationMngService
					.findById(qm);
			// 故障单处置记录
			List<FaultHandle> faultHandles = this.faultHandleMngService
					.queryList(qm);
			// 当前用户
			User user = getCurrentUser(request);
			model.addAttribute("currentHandleUser", user.getName());
			model.addAttribute("fault", faultInformation);
			model.addAttribute("faultHandles", faultHandles);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "faultmng/fault/back";
	}

	/**
	 * 故障单退回
	 * 
	 * @author duanyanlin
	 * @date 2016年6月30日上午9:47:20
	 * @param qm
	 *            事件处置查询model
	 * @param faultHandleModel
	 *            事件处置model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 退回回显
	 * @throws IOException
	 */
	@RequestMapping(value = "fault/faultBack.do", method = RequestMethod.POST)
	public String faultBack(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			FaultHandleModel faultHandleModel, Model model,
			HttpServletRequest request) throws IOException {
		// 当前用户
		try {

			User user = getCurrentUser(request);
			faultHandleModel.setOperator(user);
			// 退回
			faultHandleModel.setFaultHandelType(FaultHandelType.BACK);
			try {
				this.faultHandleMngService.handle(faultHandleModel);
				model.addAttribute("returnStr", new ResultModel(true, "退回成功",
						null).toJson());
				super.addLog(request, "事件处理：事件单退回成功");
			} catch (ServiceException e) {
				model.addAttribute("returnStr", new ResultModel(false, "退回失败",
						null).toJson());
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 故障单修改
	 * 
	 * @author duanyanlin
	 * @date 2016年6月30日上午10:46:21
	 * @param qm
	 *            事件处置查询model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 事件单修改页面
	 */
	@RequestMapping(value = "fault/faultEdit.do", method = RequestMethod.GET)
	public String faultEdit(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			Model model, HttpServletRequest request) {
		try {

			// 当前用户
			User user = getCurrentUser(request);
			FaultInformation faultInformation = this.faultInformationMngService
					.findById(qm);
			model.addAttribute("fault", faultInformation);
			// 事件类别
			model.addAttribute("eventTypes", FaultEventType.values());
			// 事件类别
			model.addAttribute("faultLevels", FaultLevelType.values());
			// 当前处理人
			model.addAttribute("currentHandleUser", user.getName());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "faultmng/fault/edit";
	}

	/**
	 * 故障单修改
	 * 
	 * @author duanyanlin
	 * @date 2016年6月30日上午10:46:21
	 * @param faultInformationModel
	 *            事件处置model
	 * @param qm
	 *            事件处置查询model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 回显
	 * @throws IOException
	 */
	@RequestMapping(value = "fault/faultEdit.do", method = RequestMethod.POST)
	public String faultEditPost(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			FaultInformationModel faultInformationModel, Model model,
			HttpServletRequest request) throws IOException {
		// 当前用户
		try {

			User user = getCurrentUser(request);
			faultInformationModel.setCurrentUser(user);
			try {
				// 编辑事件单
				this.faultInformationMngService
						.editFaultInformation(faultInformationModel);
				model.addAttribute("returnStr", new ResultModel(true, "修改成功",
						null).toJson());
				super.addLog(request, "事件处理：事件单修改成功");
			} catch (ServiceException localException) {
				model.addAttribute("returnStr", new ResultModel(false, "修改失败",
						null).toJson());
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 故障单删除
	 * 
	 * @author duanyanlin
	 * @date 2016年6月30日下午12:56:41
	 * @param qm
	 *            事件处置查询model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 删除
	 * @throws IOException
	 */
	@RequestMapping(value = "fault/faultDel.do", method = RequestMethod.POST)
	public String faultDel(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			@RequestParam("id") String id, Model model,
			HttpServletRequest request) throws IOException {
		try {
			// 操作人
			User user = getCurrentUser(request);
			qm.setCurrentUser(user);
			qm.setFaultId(id);
			// 逻辑删除事件单
			this.faultInformationMngService.deleteFaultInformation(qm);
			// 返回事假单
			// model.addAttribute("vo", faultInformation);
			model.addAttribute("returnStr",
					new ResultModel(true, "删除成功", null).toJson());
			super.addLog(request, "事件处理：事假单删除成功");
		} catch (RuntimeException e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "删除失败", null).toJson());
		}
		return "returnnote";
	}

	/**
	 * 根据id检查故障单是否已经退回
	 * 
	 * @author duanyanlin
	 * @date 2016年7月1日下午1:23:11
	 * @param model
	 *            模型
	 * @param id
	 *            故障单id
	 * @param type
	 *            查询事件单状态属性
	 * @return String 异步查询
	 */
	@RequestMapping(value = "/check.dox")
	public String checkBack(Model model, @RequestParam("id") String id,
			@RequestParam("type") String type) {
		try {

			// 封装查询条件
			FaultHandleQueryModel qm = new FaultHandleQueryModel();
			qm.setFaultId(id);
			// 封装事件单类型
			List<FaultStatus> faultStatus = new ArrayList<FaultStatus>();
			if (StringUtils.equalsIgnoreCase(type, "del")) {
				// 删除
				faultStatus.add(FaultStatus.DELETE);
			} else {
				// 其他
				faultStatus.add(FaultStatus.WAIT);
			}
			qm.setFaultStatus(faultStatus);
			// 查询相应的事件单列表
			List<FaultInformation> faultInformation = faultInformationMngService
					.queryList(qm);
			if (CollectionUtils.isNotEmpty(faultInformation)) {
				model.addAttribute("returnStr", true);
			} else {
				model.addAttribute("returnStr", false);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 任务数量冒泡显示
	 * 
	 * @author duanyanlin
	 * @date 2016年7月11日下午2:38:48
	 * @param qm
	 *            事件处置查询model
	 * @param optType
	 *            tab页标志位
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 异步回显数据
	 */
	@RequestMapping(value = "count.dox", method = RequestMethod.GET)
	public String manageCount(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			@RequestParam("optType") String optType, Model model,
			HttpServletRequest request) {
		try {

			// 当前用户
			User user = getCurrentUser(request);
			qm.setCurrentUser(user);
			// 封装故障单状态
			List<FaultStatus> faultStatusList = new ArrayList<FaultStatus>();
			// 条件处理tab页标识字段
			if (StringUtils.isEmpty(optType)) {
				optType = "";
			}
			// 按tab页进行条件处理
			switch (optType) {
			case "DEPTFAULT":
				// 部门经理分配业务(根据部门经理的UserId查询--当前登录用户)
				faultStatusList.add(FaultStatus.ASSIGN);
				break;
			case "ASSIGNFAULT":
				// 封装值班地点
				String dutyPlace = this.signLeaveService
						.getDutyPlaceByUser(user);
				// 非空验证
				if (StringUtils.isNotEmpty(dutyPlace)) {
					// 值班地点枚举转换
					DutyPlaceEnum dutyPlaceEnum = DutyPlaceEnum
							.valueOf(dutyPlace);
					// 封装查询条件
					qm.setDutyPlace(dutyPlaceEnum);
				}
				// 值班经理分配
				faultStatusList.add(FaultStatus.HANGUP);
				break;
			case "HANDLEFAULT":
				/**
				 * 待处理页面
				 */
				// 待处理
				faultStatusList.add(FaultStatus.WAIT);
				// 一般处理
				faultStatusList.add(FaultStatus.HANDLE);
				// 归类
				faultStatusList.add(FaultStatus.CLASSIFY);
				// 待部门经理确认
				faultStatusList.add(FaultStatus.ASSIGNOK);
				break;
			case "COMPLETEFAULT":
				// 已完成
				faultStatusList.add(FaultStatus.SUCCESS);
				qm.setFaultStatus(faultStatusList);
				qm.setCurrentHandleUser(user.getName());
				// 分页查询
				Pagination pagn = this.faultInformationMngService.queryPage(qm);
				model.addAttribute("returnStr", pagn.getTotalCount());
				return "returnnote";
			case "EVALUATE":
				/**
				 * 段衍林 2016-11-09
				 */
				// 待评价，根据登录用户查询成功但未评价的事件
				faultStatusList.add(FaultStatus.SUCCESS);
				// 封装需查询的事件单状态--完成
				qm.setFaultStatus(faultStatusList);
				// 查询事件单评价状态--未评价
				qm.setFaultEvaluateStatus(FaultEvaluateStatus.UNEVALUATE);
				// 分页查询
				Pagination pagn1 = this.faultInformationMngService
						.queryEvaluatePage(qm);
				// 冒泡数量
				model.addAttribute("returnStr", pagn1.getTotalCount());
				return "returnnote";
			case "FAULTALARM":
				/**
				 * 段衍林 2017-01-19 告警
				 */
				// 封装查询条件
				FaultAlarmQueryModel queryModel = new FaultAlarmQueryModel();
				// 告警事件单处置状态为告警
				queryModel.setStatus(FaultAlarmStatus.ALARM);
				// 封装分页数据
				model.addAttribute("returnStr",
						faultAlarmMngService.queryPage(queryModel)
								.getTotalCount());
				// 页面导航
				return "returnnote";
			default:
				// 待处理页面
				faultStatusList.add(FaultStatus.WAIT);
				faultStatusList.add(FaultStatus.HANDLE);
				faultStatusList.add(FaultStatus.CLASSIFY);
				faultStatusList.add(FaultStatus.ASSIGNOK);
			}
			// 封装条件
			qm.setFaultStatus(faultStatusList);
			qm.setCurrentHandleUser(user.getName());
			// 查询故障单列表
			List<FaultInformation> faultInformations = faultInformationMngService
					.queryList(qm);
			// 返回符合序曲的故障单数量
			model.addAttribute("returnStr", faultInformations.size());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 根据告警信息添加事件单页面控制
	 * 
	 * @author 段衍林
	 * @2017年1月19日 下午3:30:56
	 * @param model
	 *            mdoel
	 * @param request
	 *            请求
	 * @param id
	 *            告警id
	 * @return String 返回地址
	 */
	@RequestMapping(value = "addFaultAlarm.do", method = RequestMethod.GET)
	public String addAlarm(Model model, HttpServletRequest request,
			@RequestParam("id") String id) {
		try {
			// 查询告警信息实体
			FaultAlarm faultAlarm = faultAlarmMngService.findById(id);
			// 将告警实体回传前台
			model.addAttribute("faultAlarm", faultAlarm);
			// 当前用户
			User user = getCurrentUser(request);
			// 当前处理人
			model.addAttribute("currentHandleUser", user.getName());
			super.addLog(request, "(GET)faultmng/addFaultAlarm.do");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "faultmng/fault/addAlarm";
	}

	/**
	 * 根据告警信息添加事件单操作
	 * 
	 * @author 段衍林
	 * @2017年1月19日 下午3:32:14
	 * @param model
	 * @param faultInformationModel
	 *            事假单model
	 * @param request
	 *            请求
	 * @param id
	 *            告警信息id
	 * @return String 返回地址
	 * @throws IOException
	 *             异常
	 * 
	 */
	@RequestMapping(value = "addFaultAlarm.do", method = RequestMethod.POST)
	public String addAlarmPost(Model model,
			FaultInformationModel faultInformationModel,
			HttpServletRequest request, @RequestParam("alarmId") String alarmId)
			throws IOException {
		try {
			// 当前用户
			User user = getCurrentUser(request);
			this.faultInformationMngService.saveAlarmFault(alarmId,
					faultInformationModel, user);
			model.addAttribute("returnStr", new ResultModel(true,
					"告警信息转换为事件单添加成功", null).toJson());
			// 添加日志
			super.addLog(request, "事件处理：告警信息转换为事件单添加成功！");
		} catch (Exception e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "添加失败", null).toJson());
		}
		return "returnnote";
	}
}
