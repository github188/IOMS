package cn.com.atnc.ioms.web.duty.statellite.mqy;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.dao.duty.satellitemqy.CheckDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.CirDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.ForwardDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.InfoDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.KuEquDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.KuSysDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.QEquDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.SpDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.TesCheckDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.TesEquDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.ToolDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.ToolLibDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.WhDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.KuEqu;
import cn.com.atnc.ioms.entity.duty.satellite.OutsideEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.TesEqu;
import cn.com.atnc.ioms.entity.duty.satellite.Tool;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.mng.duty.statellitemqy.CheckService;
import cn.com.atnc.ioms.mng.duty.statellitemqy.CirService;
import cn.com.atnc.ioms.mng.duty.statellitemqy.ForwardService;
import cn.com.atnc.ioms.mng.duty.statellitemqy.InfoService;
import cn.com.atnc.ioms.mng.duty.statellitemqy.KuEquService;
import cn.com.atnc.ioms.mng.duty.statellitemqy.KuSysService;
import cn.com.atnc.ioms.mng.duty.statellitemqy.OutSideEquipCheckService;
import cn.com.atnc.ioms.mng.duty.statellitemqy.QEquService;
import cn.com.atnc.ioms.mng.duty.statellitemqy.SpService;
import cn.com.atnc.ioms.mng.duty.statellitemqy.TesCheckService;
import cn.com.atnc.ioms.mng.duty.statellitemqy.TesEquService;
import cn.com.atnc.ioms.mng.duty.statellitemqy.ToolLibService;
import cn.com.atnc.ioms.mng.duty.statellitemqy.ToolService;
import cn.com.atnc.ioms.mng.duty.statellitemqy.WhService;
import cn.com.atnc.ioms.mng.turndutymng.ISignLeaveService;
import cn.com.atnc.ioms.model.SysFinals;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.ToolModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 
 * @author shijiyong
 * @date 2016年11月3日 上午9:11:02
 * @version 1.0, 2016年11月3日 上午9:11:02
 * 
 * 
 */
@Controller
@RequestMapping("/duty/statellite/tool/")
public class ToolController extends MyBaseController {
	@Autowired
	private ToolService toolservice;
	@Autowired
	private CirService cirservice;
	@Autowired
	private ForwardService forwardservice;
	@Autowired
	private KuEquService kuequservice;
	@Autowired
	private KuSysService kusysservice;
	@Autowired
	private QEquService qequservice;
	@Autowired
	private SpService spservice;
	@Autowired
	private TesCheckService tescheckservice;
	@Autowired
	private TesEquService tesequservice;

	@Autowired
	private CheckService checkservice;
	@Autowired
	private ToolLibService toollibservice;
	@Autowired
	private InfoService infoservice;
	@Autowired
	private WhService whservice;

	@Autowired
	private ToolDao tooldao;
	@Autowired
	private CirDao cirdao;
	@Autowired
	private ForwardDao forwarddao;
	@Autowired
	private KuEquDao kuequdao;
	@Autowired
	private KuSysDao kusysdao;
	@Autowired
	private QEquDao qequdao;
	@Autowired
	private SpDao spdao;
	@Autowired
	private TesCheckDao tescheckdao;
	@Autowired
	private TesEquDao tesequdao;
	@Autowired
	private CheckDao checkdao;
	@Autowired
	private InfoDao infoao;
	@Autowired
	private WhDao whdao;
	@Autowired
	private ToolLibDao toollibdao;
	/**
	 * dyl添加
	 */
	@Autowired
	private OutSideEquipCheckService equipCheckService;
	@Autowired
	private ISignLeaveService signLeaveService;

	/**
	 * 页面初始化
	 * 
	 * @author shijiyong
	 * @time:2016年11月3日
	 * @param queryModel
	 *            查询条件
	 * @param checkType
	 *            巡检类型
	 * @param request
	 *            HttpServletRequest
	 * @param model
	 *            Model
	 * @return String
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") EnvironmentCheckQueryModel queryModel,
			@RequestParam("checkType") CheckCatagory checkType,
			HttpServletRequest request, Model model) {
		model.addAttribute("checkType", checkType);
		// 设置当前用户为操作人
		User user = (User) request.getSession().getAttribute(
				SessionNames.LOGIN_USER);
		model.addAttribute("currentUser", user);
		// 是否签到
		if (signLeaveService.isOndutyByUser(user)) {
			// 签到
			model.addAttribute("isflag", SysFinals.YES);
		} else {
			// 未签到
			model.addAttribute("isflag", SysFinals.NO);
		}
		super.pageInfo(model, request);
		return "duty/statellite/tool/manage";
	}

	/**
	 * 加载数据
	 * 
	 * @author shijiyong
	 * @time:2016年11月3日
	 * @param queryModel
	 *            查询条件
	 * @param optType
	 *            tab窗口名称
	 * @param request
	 *            HttpServletRequest
	 * @param model
	 *            Model
	 * @return
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") EnvironmentCheckQueryModel queryModel,
			HttpServletRequest request, Model model) {
		// 记录填写人
		User currentUser = (User) request.getSession().getAttribute(
				SessionNames.LOGIN_USER);
		String optType = queryModel.getOptType();
		CheckCatagory checkType = queryModel.getCheckType();
		// 是否签到
		if (signLeaveService.isOndutyByUser(currentUser)) {
			// 签到
			model.addAttribute("isflag", SysFinals.YES);
		} else {
			// 未签到
			model.addAttribute("isflag", SysFinals.NO);
		}
		model.addAttribute("optType", optType);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("checkType", checkType);
		switch (optType == null ? "" : optType) {
		case "tool":
			model.addAttribute("pagn", toolservice.queryPageByModel(queryModel));
			return "duty/statellite/tool/queryResult";
		case "forward":
			model.addAttribute("pagn",
					forwardservice.queryPageByModel(queryModel));
			return "duty/statellite/forward/queryResult";
		case "kuequ":
			model.addAttribute("pagn",
					kuequservice.queryPageByModel(queryModel));
			return "duty/statellite/ku/queryResult";
		case "kusys":
			model.addAttribute("pagn",
					kusysservice.queryPageByModel(queryModel));
			return "duty/statellite/kusys/queryResult";
		case "qequ":
			model.addAttribute("pagn", qequservice.queryPageByModel(queryModel));
			return "duty/statellite/qequ/queryResult";
		case "sp":
			model.addAttribute("pagn", spservice.queryPageByModel(queryModel));
			return "duty/statellite/sp/queryResult";
		case "tescheck":
			model.addAttribute("pagn",
					tescheckservice.queryPageByModel(queryModel));
			return "duty/statellite/tescheck/queryResult";
		case "tesequ":
			model.addAttribute("pagn",
					tesequservice.queryPageByModel(queryModel));
			return "duty/statellite/tesequ/queryResult";
		case "cir":
			model.addAttribute("pagn", cirservice.queryPageByModel(queryModel));
			return "duty/statellite/cir/queryResult";
		case "mhjtesequ":
			model.addAttribute("pagn",
					tesequservice.queryPageByModel(queryModel));
			return "duty/statellite/tesequ/queryResult";
		case "mhjkucheck":
			model.addAttribute("pagn",
					kuequservice.queryPageByModel(queryModel));
			return "duty/statellite/ku/queryResult";
		case "slhkucheck":
			model.addAttribute("pagn",
					kuequservice.queryPageByModel(queryModel));
			return "duty/statellite/ku/queryResult";
		case "wh":
			model.addAttribute("pagn", whservice.queryPageByModel(queryModel));
			return "duty/statellite/wh/queryResult";
		case "check":
			model.addAttribute("pagn", checkdao.queryPageByModel(queryModel));
			return "duty/statellite/check/queryResult";
		case "TxjdOutTesEquip":
		case "TxjdOutKuEquip":
		case "SlhOutKuEquip":
		case "MhjOutTesEquip":
			/**
			 * 室外设备检查
			 */
			model.addAttribute("pagn",
					equipCheckService.queryPageByModel(queryModel));
			return "duty/statellite/outsideequip/queryResult";

		default:
			model.addAttribute("pagn", toolservice.queryPageByModel(queryModel));
			return "duty/statellite/tool/queryResult";
		}

	}

	/**
	 * 添加记录跳转
	 * 
	 * @author shijiyong
	 * @time:2016年11月3日
	 * @param queryModel
	 *            查询条件
	 * @param optType
	 *            tab窗口名称
	 * @param checkType
	 *            巡检类型
	 * @param model
	 *            Model
	 * @return
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String addJump(@ModelAttribute("pageModel") Tool queryModel,
			@RequestParam("checkType") CheckCatagory checkType, Model model) {
		// 检查结果枚举类
		List<CheckResult> checkResult = Arrays.asList(CheckResult.values());
		model.addAttribute("checkresult", checkResult);
		model.addAttribute("checkType", checkType);
		return "duty/statellite/tool/add";
	}

	/**
	 * 添加巡检记录
	 * 
	 * @author shijiyong
	 * @time:2016年11月3日
	 * @param toolmodel
	 *            pageModel
	 * @param request
	 *            HttpServletRequest
	 * @param model
	 *            查询条件
	 * @param optType
	 *            tab窗口名称
	 * @param checkType
	 *            巡检类型
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String add(@ModelAttribute("pageModel") ToolModel toolmodel,
			HttpServletRequest request,
			@RequestParam("checkType") CheckCatagory checkType, Model model)
			throws IOException {
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			toolmodel.setOperator(user);
			// 设置当前卫星【月检】【季检】【年检】类型
			toolmodel.setCheckType(checkType);
			model.addAttribute("currentUser", user);
			// 将记录保存至数据库
			toolservice.save(toolmodel);
			model.addAttribute("returnStr",
					new ResultModel(true, "操作成功", null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "操作失败", null).toJson());
		}
		return "returnnote";
	}

	/**
	 * 显示
	 * 
	 * @author shijiyong
	 * @time:2016年11月3日
	 * @param id
	 *            ID
	 * @param request
	 *            HttpServletRequest
	 * @param model
	 *            Model
	 * @return String
	 */
	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public String view(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		Tool tool = toolservice.findById(id);
		model.addAttribute("vo", tool);
		return "/duty/statellite/tool/view";
	}

	/**
	 * 更新跳转
	 * 
	 * @author shijiyong
	 * @time:2016年11月3日
	 * @param id
	 *            ID
	 * @param request
	 *            HttpServletRequest
	 * @param model
	 *            查询条件
	 * @param txjddatestate
	 *            pageModel
	 * @return String
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	public String updateJump(
			@RequestParam(value = "id", required = true) String id,
			@ModelAttribute("pageModel") Tool pagemodel,
			HttpServletRequest request, Model model) {

		Tool tool = toolservice.findById(id);
		model.addAttribute("tool", tool);
		return "/duty/statellite/tool/update";
	}

	/**
	 * 更新
	 * 
	 * @author shijiyong
	 * @time:2016年11月3日
	 * @param id
	 *            ID
	 * @param request
	 *            HttpServletRequest
	 * @param model
	 *            查询条件
	 * @param txjddatestate
	 *            pageModel
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(@ModelAttribute("pageModel") ToolModel toolmodel,
			HttpServletRequest request, Model model,
			@RequestParam("id") String id) throws IOException {
		try {
			Tool tool = toolservice.findById(id);
			String checkid = tool.getCheckid().getId();
			EnvironmentEquipCheck enviroment = toolservice.findByIden(checkid);
			System.err.println("enviroment---->" + enviroment);
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			toolmodel.setOperator(user);
			toolservice.update(tool, enviroment, toolmodel);
			model.addAttribute("returnStr",
					new ResultModel(true, "操作成功", null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "操作失败", null).toJson());
		}
		return "returnnote";
	}

	/**
	 * 删除
	 * 
	 * @author shijiyong
	 * @time:2016年10月21日
	 * @param id
	 *            ID
	 * @param request
	 *            HttpServletRequest
	 * @param model
	 *            查询条件
	 * @param txjddatestate
	 *            pageModel
	 * @return String
	 */

	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String delete(@ModelAttribute("pageModel") ToolModel toolmodel,
			HttpServletRequest request, Model model,
			@RequestParam("id") String id) {
		try {
			// 删除
			Tool tool = toolservice.findById(id);
			String checkid = tool.getCheckid().getId();
			EnvironmentEquipCheck enviroment = toolservice.findByIden(checkid);
			toolservice.delete(tool, enviroment);
			// 返回
			addSuccess(model, "删除记录成功");
			// 记录操作日志
			super.addLog(request, "删除记录成功");
		} catch (RuntimeException e) {
			addError(model, "删除记录失败");
			super.addLog(request, "删除记录失败");
		}

		return "duty/statellite/tool/result";
	}

	/**
	 * 冒泡显示
	 * 
	 * @author shijiyong
	 * @time:2016年10月21日
	 * @param id
	 *            ID
	 * @param request
	 *            HttpServletRequest
	 * @param model
	 *            查询条件
	 * @param txjddatestate
	 *            pageModel
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "ajaxLoad.dox", method = RequestMethod.GET)
	public String ajaxLodad(
			@ModelAttribute("pageModel") EnvironmentCheckQueryModel queryModel,
			@RequestParam("optType") String optType,
			HttpServletRequest request, Model model) throws IOException {
		EnvironmentCheckQueryModel txjddatestatemodel = new EnvironmentCheckQueryModel();
		txjddatestatemodel.setCheckType(queryModel.getCheckType());
		txjddatestatemodel.setOptType(optType);
		switch (optType == null ? "" : optType) {
		case "tool":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(tooldao
					.queryList(txjddatestatemodel)));
			break;
		case "cir":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(cirdao
					.queryList(txjddatestatemodel)));
			break;
		case "forward":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(forwarddao
					.queryList(txjddatestatemodel)));
			break;
		case "kuequ":

			// 分页查询
			Pagination pagn1 = kuequdao.queryPageByModel(txjddatestatemodel);
			// 取列表数据
			List<KuEqu> pagnList1 = (List<KuEqu>) pagn1.getResult();
			// 传递list
			model.addAttribute("returnStr", JacksonTools.toJsonStr(pagnList1));
			break;
		case "kusys":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(kusysdao
					.queryList(txjddatestatemodel)));
			break;
		case "qequ":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(qequdao
					.queryList(txjddatestatemodel)));
			break;
		case "sp":
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(spdao.queryList(txjddatestatemodel)));
			break;
		case "tescheck":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(tescheckdao
					.queryList(txjddatestatemodel)));
			break;
		case "tesequ":

			// 分页查询
			Pagination pagn2 = tesequdao.queryPageByModel(txjddatestatemodel);
			// 取列表数据
			List<TesEqu> pagnList2 = (List<TesEqu>) pagn2.getResult();
			// 传递list
			model.addAttribute("returnStr", JacksonTools.toJsonStr(pagnList2));
			break;
		case "mhjtesequ":

			// 分页查询
			Pagination pagn3 = tesequdao.queryPageByModel(txjddatestatemodel);
			// 取列表数据
			List<TesEqu> pagnList3 = (List<TesEqu>) pagn3.getResult();
			model.addAttribute("returnStr", JacksonTools.toJsonStr(pagnList3));
			break;
		case "mhjkucheck":
			// 分页查询
			Pagination pagn4 = kuequdao.queryPageByModel(txjddatestatemodel);
			// 取列表数据
			List<KuEqu> pagnList4 = (List<KuEqu>) pagn4.getResult();
			model.addAttribute("returnStr", JacksonTools.toJsonStr(pagnList4));
			break;
		case "slhkucheck":
			// 分页查询
			Pagination pagn5 = kuequdao.queryPageByModel(txjddatestatemodel);
			// 取列表数据
			List<KuEqu> pagnList5 = (List<KuEqu>) pagn5.getResult();
			model.addAttribute("returnStr", JacksonTools.toJsonStr(pagnList5));
			break;

		case "wh":
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(whdao.queryList(txjddatestatemodel)));
			break;
		case "check":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(checkdao
					.queryList(txjddatestatemodel)));
			break;
		/**
		 * 段衍林添加
		 */
		case "TxjdOutTesEquip":
		case "TxjdOutKuEquip":
		case "SlhOutKuEquip":
		case "MhjOutTesEquip":
			/**
			 * 室外设备检查
			 */
			// 查询
			// 分页查询
			Pagination pagn6 = equipCheckService
					.queryPageByModel(txjddatestatemodel);
			// 取列表数据
			List<OutsideEquipCheck> pagnList6 = (List<OutsideEquipCheck>) pagn6
					.getResult();
			model.addAttribute("returnStr", JacksonTools.toJsonStr(pagnList6));
			break;
		}
		return "returnnote";
	}

}
