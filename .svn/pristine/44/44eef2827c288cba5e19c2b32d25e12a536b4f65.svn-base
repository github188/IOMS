package cn.com.atnc.ioms.web.phonemng;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
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
import cn.com.atnc.ioms.dao.faultmng.IFaultTypeParentDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultTypeSonDao;
import cn.com.atnc.ioms.dao.systemmng.deptinfomng.IDeptInfoMngDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.acl.UserRole;
import cn.com.atnc.ioms.entity.faultmng.FaultArea;
import cn.com.atnc.ioms.entity.faultmng.FaultHandle;
import cn.com.atnc.ioms.entity.faultmng.FaultInformation;
import cn.com.atnc.ioms.entity.faultmng.FaultTypeParent;
import cn.com.atnc.ioms.entity.faultmng.FaultTypeSon;
import cn.com.atnc.ioms.entity.phonemng.AgentInformation;
import cn.com.atnc.ioms.entity.phonemng.ContactsMng;
import cn.com.atnc.ioms.entity.systemmng.deptinfomng.DeptInfomationMng;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.enums.faultmng.FaultAlarmStatus;
import cn.com.atnc.ioms.enums.faultmng.FaultEventType;
import cn.com.atnc.ioms.enums.faultmng.FaultHandelType;
import cn.com.atnc.ioms.enums.faultmng.FaultLevelType;
import cn.com.atnc.ioms.enums.faultmng.FaultStatus;
import cn.com.atnc.ioms.enums.faultmng.TransferType;
import cn.com.atnc.ioms.enums.faultmng.UNBJFaultType;
import cn.com.atnc.ioms.enums.phonemng.CallIsDel;
import cn.com.atnc.ioms.enums.phonemng.CallStateEnum;
import cn.com.atnc.ioms.enums.phonemng.CallTypeEnum;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.acl.IUserRoleManager;
import cn.com.atnc.ioms.mng.faultmng.IFaultAlarmMngService;
import cn.com.atnc.ioms.mng.faultmng.IFaultHandleMngService;
import cn.com.atnc.ioms.mng.faultmng.IFaultInformationMngService;
import cn.com.atnc.ioms.mng.phonemng.IAgentInfoService;
import cn.com.atnc.ioms.mng.phonemng.ICallAgentMngService;
import cn.com.atnc.ioms.mng.phonemng.ICallInfoService;
import cn.com.atnc.ioms.mng.phonemng.IContactsMngService;
import cn.com.atnc.ioms.mng.turndutymng.ISignLeaveService;
import cn.com.atnc.ioms.model.SysFinals;
import cn.com.atnc.ioms.model.faultmng.FaultAlarmQueryModel;
import cn.com.atnc.ioms.model.faultmng.FaultHandleModel;
import cn.com.atnc.ioms.model.faultmng.FaultHandleQueryModel;
import cn.com.atnc.ioms.model.faultmng.FaultInformationModel;
import cn.com.atnc.ioms.model.phonemng.CallAgentMngQueryModel;
import cn.com.atnc.ioms.model.phonemng.CallInformationQueryModel;
import cn.com.atnc.ioms.model.phonemng.ContactsMngQueryModel;
import cn.com.atnc.ioms.model.systemmng.deptinfomng.DeptInfoQueryModel;
import cn.com.atnc.ioms.model.turndutymng.SignLeaveQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 
 * @author hantianyu
 * @creatime 2016-5-18下午1:49:33 TODO 呼叫中心首页
 */
@Controller("callCenterController")
@RequestMapping("phonemng/")
public class CallCenterController extends MyBaseController {

	@Autowired
	private IFaultInformationMngService faultInformationMngService;
	@Autowired
	private IFaultHandleMngService faultHandleMngService;
	@Autowired
	private IFaultTypeParentDao faultTypeParentDao;
	@Autowired
	private IFaultTypeSonDao faultTypeSonDao;
	@Autowired
	private ISignLeaveService signLeaveService;
	@Autowired
	private IUserRoleManager userRole;
	@Autowired
	private IUserManager userManage;
	@Autowired
	private IDeptInfoMngDao deptInfoDao;
	@Autowired
	private IFaultAreaDao faultAreaDao;

	@Autowired
	private IContactsMngService contactsMngService;
	@Autowired
	private ICallInfoService callInfoService;
	@Autowired
	private IAgentInfoService agentInfoService;
	@Autowired
	private ICallAgentMngService callAgentMngService;
	@Autowired
	private IFaultInformationDao faultInformationDao;
	
	@Autowired
	private IFaultAlarmMngService faultAlarmMngService;


	/**
	 * 
	 * @Auther Administrator
	 * @creatime 2016-5-18下午2:24:58
	 * @param model
	 * @param request
	 * @return String TODO 呼叫中心首页
	 */
	@RequestMapping(value = "callcenter/manage.do", method = RequestMethod.GET)
	public String manage(Model model,
			@RequestParam("beginTime") String beginTime,
			@RequestParam("endTime") String endTime,
			@RequestParam("ringTime") String ringTime,
			@RequestParam("callType") String callType,
			@RequestParam("callsheetId") String callsheetId,
			@RequestParam("agent") String agent,
			@RequestParam("callNo") String callNo,
			@RequestParam("calledNo") String calledNo,
			@RequestParam("callerCity") String callerCity,
			@RequestParam("callerProvince") String callerProvince,
			HttpServletRequest request,
			@ModelAttribute("queryModel") FaultHandleQueryModel qm

	) {
		try {

			User user = getCurrentUser(request);
			super.pageInfo(model, request);

			model.addAttribute("beginTime", beginTime);
			model.addAttribute("endTime", endTime);
			model.addAttribute("ringTime", ringTime);
			model.addAttribute("callType", callType);
			model.addAttribute("callsheetId", callsheetId);

			model.addAttribute("agent", agent);
			model.addAttribute("callNo", callNo);
			model.addAttribute("calledNo", calledNo);

			try {
				String cityStr = new String(request.getParameter("callerCity")
						.getBytes("ISO-8859-1"), "utf-8");
				String provinceStr = new String(request.getParameter(
						"callerProvince").getBytes("ISO-8859-1"), "utf-8");
				// 判断
				if (cityStr.equals(provinceStr)) {
					if (cityStr.equals("undefined")) {
						cityStr = "";
						provinceStr = "";
					}
				}
				model.addAttribute("callerCity", cityStr);
				model.addAttribute("callerProvince", provinceStr);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 获取登录账户 和 密码 start
			String loginname = "";
			String pwd = "";
			String logintype = "";
			String agentNo = "";
			AgentInformation agentInfo = agentInfoService
					.viewAgentInfoByName(user.getName());
			if (agentInfo != null) {
				// 登录账号
				loginname = agentInfo.getAgentAccount();
				// 登录密码
				pwd = agentInfo.getAgentPwd();
				// 电话类型
				logintype = agentInfo.getLoginType();
				// 坐席号
				agentNo = agentInfo.getAgentinfo();

			}
			// 传到前台页面
			model.addAttribute("loginname", loginname);
			model.addAttribute("pwd", pwd);
			model.addAttribute("logintype", logintype);
			model.addAttribute("agent", agentNo);

			// model.addAttribute("agentlist",agentInfoService.getAgentListByAgent(agentNo));
			model.addAttribute("agent", agentNo);
			// 获取登录账户 和 密码 end

			// 未接电话页面弹对话框提示
			model.addAttribute("missCount",
					callInfoService.missedCallCount(user.getName()));
			model.addAttribute("missList",
					callInfoService.getMissedCallList(user.getName()));

			// model.addAttribute("type",type);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/callcenter/manage";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:manageList
	 * @Description:manage.jsp post函数
	 * @Param:@param qm
	 * @Param:@param model
	 * @Param:@param request
	 * @Param:@return
	 * @Param:@throws IOException
	 * @Return:String
	 * @Creatime:2016年7月19日 上午10:01:12
	 */
	@RequestMapping(value = "callcenter/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			Model model, HttpServletRequest request) throws IOException {
		try {

			// 当前用户
			User user = getCurrentUser(request);
			qm.setCurrentUser(user);
			// 封装故障单状态
			List<FaultStatus> faultStatusList = new ArrayList<FaultStatus>();
			faultStatusList.add(FaultStatus.WAIT);
			faultStatusList.add(FaultStatus.HANDLE);
			faultStatusList.add(FaultStatus.CLASSIFY);
			faultStatusList.add(FaultStatus.ASSIGNOK);

			qm.setFaultStatus(faultStatusList);
			qm.setCurrentHandleUser(user.getName());

			List<FaultInformation> faultInformations = faultInformationMngService
					.queryList(qm);
			model.addAttribute("faultInformations", faultInformations);
			model.addAttribute("currentHandleUser", user.getName());
			if (signLeaveService.isOndutyByUser(user)) {
				// 签到
				model.addAttribute("isflag", SysFinals.YES);
			} else {
				// 未签到
				model.addAttribute("isflag", SysFinals.NO);
			}
			
			//读取阈值告警信息 2017-2-3 hty
			FaultAlarmQueryModel queryModel = new FaultAlarmQueryModel();
			// 告警事件单处置状态为告警
			queryModel.setStatus(FaultAlarmStatus.ALARM);
			model.addAttribute("alarmsCount",
					faultAlarmMngService.findByStatus(queryModel).size());
			model.addAttribute("faultAlarms",
					faultAlarmMngService.findByStatus(queryModel));
			
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/callcenter/queryResult";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getFaultInfo
	 * @Description:TODO
	 * @Param:@param model
	 * @Param:@param qm
	 * @Param:@return
	 * @Param:@throws UnsupportedEncodingException
	 * @Return:String
	 * @Creatime:2016年9月7日 下午2:12:10
	 */
	@RequestMapping(value = "getFaultInfo.dox", method = RequestMethod.GET)
	public String getFaultInfo(Model model, FaultHandleQueryModel qm)
			throws UnsupportedEncodingException {
		try {

			// 对故障地区进行转码
			String faultArea = qm.getFaultArea();
			if (!StringUtils.isEmpty(faultArea)) {
				// 地区编码格式
				faultArea = URLDecoder.decode(faultArea, "UTF-8");
				qm.setFaultArea(faultArea);
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
	 * 第一处理人处理
	 * 
	 * @author duanyanlin
	 * @date 2016年6月17日下午3:46:57
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @param qm
	 *            事件处置查询model
	 * @return String 第一处理人处理页面
	 */
	@RequestMapping(value = "callcenter/faulthandle.do", method = RequestMethod.GET)
	public String writeeventUrl(Model model, HttpServletRequest request,
			@ModelAttribute("queryModel") FaultHandleQueryModel qm) {

		try {

			// 查询故障单详情
			FaultInformation faultInformation = this.faultInformationMngService
					.findById(qm);
			model.addAttribute("fault", faultInformation);
			// 当前处置记录
			List<FaultHandle> faultHandles = this.faultHandleMngService
					.queryList(qm);
			model.addAttribute("faultHandles", faultHandles);
			// 页面展示事件处置记录（暂存）,条件：存在记录且第一条为暂存状态
			if (CollectionUtils.isNotEmpty(faultHandles)
					&& ObjectUtils.equals(faultHandles.get(0).getHandleType(),
							FaultHandelType.FAULTTEMPRARY)) {
				model.addAttribute("handle", faultHandles.get(0));
			} else {
				model.addAttribute("handle", null);
			}
			// 移交方式
			model.addAttribute("transferTypes", TransferType.values());
			// 查询当前登录用户
			User currentUser = getCurrentUser(request);
			model.addAttribute("currentUser", currentUser);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/callcenter/faulthandle";
	}

	/**
	 * 第一处理人处理操作
	 * 
	 * @author duanyanlin
	 * @date 2016年6月24日下午2:22:59
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
	@RequestMapping(value = "callcenter/faulthandle.do", method = RequestMethod.POST)
	public String writeeventUrlPost(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			Model model, HttpServletRequest request,
			FaultHandleModel faultHandleModel) throws IOException {
		try {

			// 当前用户
			User user = getCurrentUser(request);
			faultHandleModel.setOperator(user);
			try {
				faultHandleModel.setFaultHandelType(FaultHandelType.TRANSFER);
				// 第一处理人处理
				this.faultHandleMngService.handle(faultHandleModel);
				model.addAttribute("returnStr", new ResultModel(true, "处理成功",
						null).toJson());
				super.addLog(request, "事件处理：第一处理人处理成功");
			} catch (Exception localException) {
				model.addAttribute("returnStr", new ResultModel(false, "处理失败",
						null).toJson());
			}
			// 查询当前登录用户
			User currentUser = getCurrentUser(request);
			model.addAttribute("currentUser", currentUser);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 异步查询移交相关数据列表
	 * 
	 * @author duanyanlin
	 * @date 2016年6月23日下午1:33:17
	 * @param type
	 *            移交类别
	 * @param qm
	 *            事件查询model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 异步查询
	 */
	@RequestMapping(value = "ajaxFaultTransfer.dox", method = RequestMethod.GET)
	public String ajaxFaultTransfer(@RequestParam("type") String type,
			FaultHandleQueryModel qm, Model model, HttpServletRequest request) {
		try {

			if (!StringUtils.isEmpty(qm.getFaultId())) {

				// 根据faultId查询相应故障单
				FaultInformation faultInformation = this.faultInformationMngService
						.findById(qm);
				if (!StringUtils.equalsIgnoreCase(type,
						TransferType.DEPT.name())) {
					/**
					 * 坐席间移交或者移交部门经理
					 */
					List<User> users = new ArrayList<User>();
					if (StringUtils.equalsIgnoreCase(type,
							TransferType.STATION.name())) {
						// 移交其他坐席
						SignLeaveQueryModel slqm = new SignLeaveQueryModel();
						slqm.setDutyPlace(faultInformation.getDutyPlace());
						users = this.signLeaveService
								.getEngineerListByPlace(slqm);
					} else if (StringUtils.equalsIgnoreCase(type,
							TransferType.CTO.name())) {
						// 网控部门经理（atncLeader）
						List<UserRole> userRoles = this.userRole
								.findByRoleName(RoleEnum.atncLeader.name());
						for (UserRole userRole : userRoles) {
							users.add(userRole.getUser());
						}
					}
					try {
						model.addAttribute("returnStr",
								JacksonTools.toJsonStr(users));
					} catch (IOException e) {
						// logger.error("数据异常！");
						e.printStackTrace();
						throw new RuntimeException(e);
					}
				} else if (StringUtils.equalsIgnoreCase(type,
						TransferType.DEPT.name())) {
					// 查询父级部门
					DeptInfoQueryModel queryModel = new DeptInfoQueryModel();
					queryModel.setParentInfo("0");
					List<DeptInfomationMng> depts = this.deptInfoDao
							.getDeptByParentInfo(queryModel);
					try {
						model.addAttribute("returnStr",
								JacksonTools.toJsonStr(depts));
					} catch (IOException e) {
						// logger.error("数据异常！");
						e.printStackTrace();
						throw new RuntimeException(e);
					}
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 异步查询部门人员名单
	 * 
	 * @author duanyanlin
	 * @date 2016年6月24日下午1:07:55
	 * @param deptId
	 *            部门id
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 异步查询部门员工
	 */
	@RequestMapping(value = "ajaxDeptUser.dox", method = RequestMethod.GET)
	public String ajaxDeptUser(@RequestParam("deptId") String deptId,
			Model model, HttpServletRequest request) {
		try {

			if (!StringUtils.isEmpty(deptId)) {
				DeptInfomationMng dept = this.deptInfoDao.findById(deptId); // 部门信息
				if (dept != null) {
					// 部门经理
					List<User> users = this.userManage
							.getFirstLeaderByDept(dept);
					try {
						model.addAttribute("returnStr",
								JacksonTools.toJsonStr(users));
					} catch (IOException e) {
						// logger.error("数据异常！");
						e.printStackTrace();
						throw new RuntimeException(e);
					}
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 异步加载二级部门菜单
	 * 
	 * @author duanyanlin
	 * @date 2016年6月29日上午9:16:02
	 * @param queryModel
	 *            部门查询model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 异步加载二级部门数据
	 */
	@RequestMapping(value = "ajaxSecondDept.dox", method = RequestMethod.GET)
	public String ajaxSecondDept(DeptInfoQueryModel queryModel, Model model,
			HttpServletRequest request) {
		try {

			List<DeptInfomationMng> depts = this.deptInfoDao
					.getDeptByParentInfo(queryModel);
			try {
				model.addAttribute("returnStr", JacksonTools.toJsonStr(depts));
			} catch (IOException e) {
				// logger.error("数据异常！");
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 事件归类
	 * 
	 * @author duanyanlin
	 * @date 2016年6月23日下午12:27:48
	 * @param qm
	 *            事件查询model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 事件单归类页面
	 */
	@RequestMapping(value = "callcenter/faultclassify.do", method = RequestMethod.GET)
	public String classifyeventUrlGet(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			Model model, HttpServletRequest request) {
		try {

			// 故障单信息
			FaultInformation faultInformation = this.faultInformationMngService
					.findById(qm);
			// 处理记录
			List<FaultHandle> faultHandles = this.faultHandleMngService
					.queryList(qm);
			// 查询故障父级类型
			List<FaultTypeParent> faultTypeParents = this.faultTypeParentDao
					.getAll();
			// 当前用户
			User user = getCurrentUser(request);
			// 故障发生区域
			FaultArea faultArea = this.faultAreaDao.findByParam("areaInfo",
					faultInformation.getFaultArea());
			// 向前台抛数据
			model.addAttribute("faultArea", faultArea);
			model.addAttribute("currentHandleUser", user.getName());
			model.addAttribute("faultTypeUnBeijing", UNBJFaultType.values());
			model.addAttribute("faultTypeParents", faultTypeParents);
			model.addAttribute("fault", faultInformation);
			model.addAttribute("faultHandles", faultHandles);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/callcenter/faultclassify";
	}

	/**
	 * 异步查询子级事件类型列表
	 * 
	 * @author duanyanlin
	 * @date 2016年6月23日下午1:33:17
	 * @param faultTypeParentId
	 *            父级类型ID
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 异步返回值
	 */
	@RequestMapping(value = "ajaxFaultTypeSon.dox", method = RequestMethod.GET)
	public String ajaxFaultTypeSon(
			@RequestParam("faultTypeParentId") String faultTypeParentId,
			Model model, HttpServletRequest request) {
		try {

			// 查询故障子级类型
			List<FaultTypeSon> faultTypeSons = this.faultTypeSonDao
					.findByParentId(faultTypeParentId);
			try {
				model.addAttribute("returnStr",
						JacksonTools.toJsonStr(faultTypeSons));
			} catch (IOException e) {
				// logger.error("数据异常！");
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 事件归类
	 * 
	 * @author duanyanlin
	 * @date 2016年6月23日下午1:34:19
	 * @param qm
	 *            事件处置查询model
	 * @param faultHandleModel
	 *            事件处置model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 归类结果回显
	 * @throws IOException
	 */
	@RequestMapping(value = "callcenter/faultclassify.do", method = RequestMethod.POST)
	public String classifyeventUrlPost(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			FaultHandleModel faultHandleModel, Model model,
			HttpServletRequest request) throws IOException {
		try {

			User localUser = (User) request.getSession().getAttribute(
					"loginUser");
			faultHandleModel.setOperator(localUser);
			// 事件处置类型为归类
			faultHandleModel.setFaultHandelType(FaultHandelType.CLASSIFY);
			try {
				this.faultHandleMngService.handle(faultHandleModel);
				model.addAttribute("returnStr", new ResultModel(true, "归类成功",
						null).toJson());
				super.addLog(request, "事件处理：事件单归类成功");
			} catch (Exception localException) {
				model.addAttribute("returnStr", new ResultModel(false, "归类失败",
						null).toJson());
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 挂起弹出页面
	 * 
	 * @author duanyanlin
	 * @date 2016年6月17日下午3:49:24
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @param qm
	 *            事件处置查询model
	 * @return String 挂起页面
	 */
	@RequestMapping(value = "callcenter/faulthangup.do", method = RequestMethod.GET)
	public String hangupeventUrl(Model model, HttpServletRequest request,
			@ModelAttribute("queryModel") FaultHandleQueryModel qm) {
		try {

			// 挂起事件详情
			FaultInformation faultInformation = this.faultInformationMngService
					.findById(qm);
			model.addAttribute("fault", faultInformation);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/callcenter/faulthangup";
	}

	/**
	 * 添加挂起处置记录
	 * 
	 * @author duanyanlin
	 * @date 2016年6月17日下午3:51:50
	 * @param qm
	 *            事件查询model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @param faultHandleModel
	 *            事件处置model
	 * @return String 挂起结果回显
	 * @throws IOException
	 */
	@RequestMapping(value = "callcenter/faulthangupAdd.do", method = RequestMethod.POST)
	public String hangupAdd(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm,
			Model model, HttpServletRequest request,
			FaultHandleModel faultHandleModel) throws IOException {
		try {

			User localUser = (User) request.getSession().getAttribute(
					"loginUser");
			faultHandleModel.setOperator(localUser);
			// 挂起操作
			faultHandleModel.setFaultHandelType(FaultHandelType.HANGUP);
			try {
				this.faultHandleMngService.handle(faultHandleModel);
				model.addAttribute("returnStr", new ResultModel(true, "挂起成功",
						null).toJson());
				super.addLog(request, "事件处理：事假单挂起成功");
			} catch (Exception localException) {
				model.addAttribute("returnStr", new ResultModel(false, "挂起失败",
						null).toJson());
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:addTab
	 * @Description:TODO
	 * @Param:@param model
	 * @Param:@param request
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年8月2日 上午9:43:37
	 */
	@RequestMapping(value = "callcenter/faultmng/add.do", method = RequestMethod.GET)
	public String addTab(@RequestParam("callNo") String callNo,
			@RequestParam("calledNo") String calledNo,
			@RequestParam("callType") String callType,
			@RequestParam("ringTime") String ringTime,
			@RequestParam("agent") String agent,
			@RequestParam("callsheetId") String callsheetId,
			@RequestParam("callerplace") String callerplace, Model model,
			HttpServletRequest request) {
		try {

			String contacts_name = "";
			String contacts_companyinfo = "";
			String placename = "";
			try {
				placename = new String(request.getParameter("callerplace")
						.getBytes("ISO-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 联系人查询实体
			ContactsMngQueryModel qm = new ContactsMngQueryModel();
			// 当前用户
			User user = getCurrentUser(request);

			// 事件类别
			model.addAttribute("eventTypes", FaultEventType.values());
			// 事件级别
			model.addAttribute("faultLevels", FaultLevelType.values());
			// 当前处理人
			model.addAttribute("currentHandleUser", user.getName());

			// 呼叫信息
			String telephoneNumber = callNo;
			String agentTelNumber = calledNo;
			model.addAttribute("callId", callsheetId);
			// System.err.println(callType);
			if (callType.equals("dialout,dialout")) {
				// 如果是外呼，被叫号码是 申告电话
				telephoneNumber = calledNo;
				agentTelNumber = callNo;

				System.err.println("agentTelNumber:" + agentTelNumber);
			}
			model.addAttribute("callNo", telephoneNumber);
			model.addAttribute("calledNo", agentTelNumber);
			qm.setTelNumber(telephoneNumber);

			ContactsMng contactsMng = contactsMngService
					.getContactsInfoByTel(qm);
			if (contactsMng != null) {
				// 查询出 联系人存在
				contacts_name = contactsMng.getContactName();
				contacts_companyinfo = contactsMng.getCompanyInfo();
				callerplace = contactsMng.getContactPlace();
			}

			model.addAttribute("callerplace", placename);

			model.addAttribute("contactsName", contacts_name);
			model.addAttribute("companyInfo", contacts_companyinfo);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/callcenter/faultmng/add";
	}

	/**
	 * 
	 * @throws IOException
	 * @Author:hantianyu
	 * @Title:getADD
	 * @Description:添加
	 * @Param:@param model
	 * @Param:@param request
	 * @Param:@param qm
	 * @Param:@return
	 * @Param:@throws UnsupportedEncodingException
	 * @Return:String
	 * @Creatime:2016年8月4日 下午5:32:29
	 */
	@RequestMapping(value = "add.dox", method = RequestMethod.GET)
	public String getADD(Model model, HttpServletRequest request,
			FaultInformationModel qm) throws IOException {
		try {

			// 当前用户
			System.err.println("-------post-add-fault-phone");
			User user = getCurrentUser(request);
			qm.setCurrentUser(user);
			// 中文转码
			String contacts_name = qm.getContactsName();
			String contacts_company = qm.getFaultCompany();
			String contacts_area = qm.getFaultArea();
			String remarkStr = qm.getRemark();

			contacts_name = new String(contacts_name.getBytes("ISO-8859-1"),
					"utf-8");
			contacts_company = new String(
					contacts_company.getBytes("ISO-8859-1"), "utf-8");
			contacts_area = new String(contacts_area.getBytes("ISO-8859-1"),
					"utf-8");
			remarkStr = new String(remarkStr.getBytes("ISO-8859-1"), "utf-8");

			qm.setRemark(remarkStr);
			qm.setContactsName(contacts_name);
			qm.setFaultCompany(contacts_company);
			qm.setFaultArea(contacts_area);

			// User user = getCurrentUser(request);

			try {
				this.faultInformationMngService.saveFaultInformation(qm);
				model.addAttribute("returnStr", "{\"result\":true,\"msg\":\""
						+ "事件添加成功！" + "\"}");
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
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-8-19下午4:16:39
	 * @param model
	 * @param request
	 * @param qm
	 * @return String TODO
	 */
	@RequestMapping(value = "/callcenter/viewagent.do", method = RequestMethod.GET)
	public String getAgent(Model model, HttpServletRequest request,
			@ModelAttribute("queryModel") CallAgentMngQueryModel qm) {
		try {

			User user = getCurrentUser(request);

			// 获取登录账户 和 密码 start
			String loginname = "";
			String pwd = "";
			String logintype = "";
			String agentNo = "";
			AgentInformation agentInfo = agentInfoService
					.viewAgentInfoByName(user.getName());
			if (agentInfo != null) {
				// 登录账号
				loginname = agentInfo.getAgentAccount();
				// 登录密码
				pwd = agentInfo.getAgentPwd();
				// 电话类型
				logintype = agentInfo.getLoginType();
				// 坐席号
				agentNo = agentInfo.getAgentinfo();

			}
			// 传到前台页面
			model.addAttribute("loginname", loginname);
			model.addAttribute("pwd", pwd);
			model.addAttribute("logintype", logintype);
			model.addAttribute("agent", agentNo);
			super.pageInfo(model, request);

			model.addAttribute("agentMap",
					callAgentMngService.getStatueByAgent(agentNo));
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/callcenter/agent";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:ajaxSignOut
	 * @Description:TODO
	 * @Param:@param agent
	 * @Param:@param model
	 * @Param:@param request
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年9月6日 上午11:12:12
	 */
	@RequestMapping(value = "/callcenter/signout.dox", method = RequestMethod.GET)
	public String ajaxSignOut(@RequestParam("agent") String agent, Model model,
			HttpServletRequest request) throws IOException {
		try {

			System.err.println("signout--get");
			// 查询故障子级类型
			User user = getCurrentUser(request);
			String str = callInfoService.modDutyStatus(user, "signout");
			if (str.equals("SUCCESS")) {
				model.addAttribute("returnStr", "{\"result\":true,\"msg\":\""
						+ "签出成功！" + "\"}");
			} else {
				model.addAttribute("returnStr", "{\"result\":false,\"msg\":\""
						+ "签出失败！" + "\"}");
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/*
	 * @RequestMapping(value = "/export.do", method = RequestMethod.GET) public
	 * void Export(Model model, HttpServletRequest request, HttpServletResponse
	 * response,
	 * 
	 * @ModelAttribute("queryModel") CallInformationQueryModel qm) {
	 * 
	 * 
	 * User user = getCurrentUser(request); super.pageInfo(model, request);
	 * 
	 * Workbook wb = null; OutputStream os = null; try{
	 * 
	 * wb = callInfoService.exportCallRecord(qm);
	 * 
	 * response.setContentType("application/vnd.ms-excel;charset=GBK");
	 * response.setHeader("Content-Disposition","attachment; filename=" +
	 * URLEncoder.encode("电话记录", "UTF-8") + ".xls"); os =
	 * response.getOutputStream(); wb.write(os); os.flush(); }catch(Exception
	 * e){ e.printStackTrace(); }finally{ try{ os.close(); }catch(Exception ex){
	 * ex.printStackTrace(); } } }
	 */

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getExport
	 * @Description:导出通话记录
	 * @Param:@param model
	 * @Param:@param request
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年9月6日 上午11:14:12
	 */
	@RequestMapping(value = "/exportcall.do", method = RequestMethod.GET)
	public String getExport(Model model, HttpServletRequest request,
			@ModelAttribute("queryModel") CallInformationQueryModel qm) {
		try {

			User user = getCurrentUser(request);
			super.pageInfo(model, request);

			List<CallIsDel> dels = Arrays.asList(CallIsDel.values());
			model.addAttribute("isdel", dels);
			List<CallStateEnum> stateList = Arrays.asList(CallStateEnum
					.values());
			model.addAttribute("states", stateList);
			List<CallTypeEnum> typeList = Arrays.asList(CallTypeEnum.values());
			model.addAttribute("types", typeList);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "systemmng/exportcallrecord/manage";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:postExport
	 * @Description:TODO
	 * @Param:@param qm
	 * @Param:@param model
	 * @Param:@param request
	 * @Param:@return
	 * @Param:@throws IOException
	 * @Return:String
	 * @Creatime:2016年9月6日 上午11:29:49
	 */
	@RequestMapping(value = "/exportcall.do", method = RequestMethod.POST)
	public String postExport(
			@ModelAttribute("queryModel") CallInformationQueryModel qm,
			Model model, HttpServletRequest request) throws IOException {
		try {

			List<CallIsDel> dels = Arrays.asList(CallIsDel.values());
			model.addAttribute("isdel", dels);
			List<CallStateEnum> stateList = Arrays.asList(CallStateEnum
					.values());
			model.addAttribute("states", stateList);
			List<CallTypeEnum> typeList = Arrays.asList(CallTypeEnum.values());
			model.addAttribute("types", typeList);

			User user = getCurrentUser(request);
			super.pageInfo(model, request);
			Pagination pagn = null;
			pagn = callInfoService.queryPageExport(qm);
			model.addAttribute("pagn", pagn);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "systemmng/exportcallrecord/queryResult";

	}
}
