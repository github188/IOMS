package cn.com.atnc.ioms.web.duty.environment.acc;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.enums.duty.environment.acc.SlhImosen;
import cn.com.atnc.ioms.enums.duty.environment.acc.SlhLbote;
import cn.com.atnc.ioms.enums.duty.environment.acc.TxjdAcc;
import cn.com.atnc.ioms.enums.duty.environment.ups.KuUpsName;
import cn.com.atnc.ioms.enums.duty.environment.ups.SlhUpsName;
import cn.com.atnc.ioms.enums.duty.environment.ups.TxjdUpsName;
import cn.com.atnc.ioms.enums.duty.environment.ups.ZjUpsName;
import cn.com.atnc.ioms.mng.duty.environment.EnvironmentEquipCheckService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.environment.acc.AccAddForm;
import cn.com.atnc.ioms.model.duty.environment.dg.DgAddForm;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 空调设备十里河巡检controller
 * 
 * @author renyujuan
 * @time:2016年8月16日 上午8:46:13
 */
@Controller
@RequestMapping("/duty/accduty/slh/")
public class SlhAccCheckController extends MyBaseController {

	@Autowired
	private EnvironmentEquipCheckService envirEquipCheckService;
	@Autowired
	private EnvironmentEquipCheckDao envirEquipCheckDao;

	/**
	 * 页面初始化
	 * 
	 * @author renyujuan
	 * @time:2016年8月12日 上午11:26:56
	 * @param queryModel
	 * @param checkType
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(@ModelAttribute("queryModel") EnvironmentCheckQueryModel queryModel,
			@RequestParam("checkType") CheckCatagory checkType, HttpServletRequest request, Model model) {
		List<SlhImosen> slhImosen = Arrays.asList(SlhImosen.values());
		model.addAttribute("slhImosen", slhImosen);
		List<SlhLbote> slhLbote = Arrays.asList(SlhLbote.values());
		model.addAttribute("slhLbote", slhLbote);
		List<EquipType> equipType = Arrays.asList(EquipType.values());
		model.addAttribute("equipType", equipType);
		model.addAttribute("checkType", checkType);
		/* System.err.println(checkType.toString()); */
		super.pageInfo(model, request);
		return "duty/accduty/slh/manage";
	}

	/**
	 * 加载数据
	 * 
	 * @author renyujuan
	 * @time:2016年8月12日 下午12:35:24
	 * @param queryModel
	 * @param checkType
	 * @param equipType
	 * @param optType
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(@ModelAttribute("queryModel") EnvironmentCheckQueryModel queryModel,
			@RequestParam("checkType") CheckCatagory checkType, @RequestParam("equipType") EquipType equipType,
			@RequestParam("optType") String optType, HttpServletRequest request, Model model) {
		// 记录填写人
		User currentUser = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
		System.err.println(checkType.toString());
		if (checkType.toString().equals("季检") && !(optType.equalsIgnoreCase("txjdAccCheck"))) {
			queryModel.setOptType("slhLbtAccCheck");
		}
		queryModel.setEquipType(equipType);
		queryModel.setCheckType(checkType);
		/* System.err.println(checkType); */
		model.addAttribute("optType", optType);
		model.addAttribute("checkType", checkType);
		model.addAttribute("currentUser", currentUser);
		switch (optType == null ? "" : optType) {
		case "slhAccCheck":
			model.addAttribute("pagn", envirEquipCheckService.queryPageByModel(queryModel));
			return "duty/accduty/slh/queryResult";
		case "slhLbtAccCheck":
			model.addAttribute("pagn", envirEquipCheckService.queryPageByModel(queryModel));
			return "duty/accduty/slh/queryResult";
		case "txjdAccCheck":
			model.addAttribute("pagn", envirEquipCheckService.queryPageByModel(queryModel));
			return "duty/accduty/txjd/queryResult";
		default:
			model.addAttribute("pagn", envirEquipCheckService.queryPageByModel(queryModel));
			return "duty/accduty/slh/queryResult";
		}
	}

	/**
	 * 获取设备名称枚举类并返回
	 * 
	 * @author renyujuan
	 * @time:2016年8月12日 下午12:41:30
	 * @param queryModel
	 * @param optType
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "ajaxEquip.dox", method = RequestMethod.GET)
	public String ajaxEquip(@ModelAttribute("queryModel") EnvironmentCheckQueryModel queryModel,
			@RequestParam("optType") String optType, HttpServletRequest request, Model model) throws IOException {
		switch (optType == null ? "" : optType) {
		case "slhAccCheck":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(SlhImosen.values()));
			break;
		case "slhLbtAccCheck":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(SlhLbote.values()));
			break;
		case "txjdAccCheck":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(TxjdAcc.values()));
			break;
		default:
			model.addAttribute("returnStr", JacksonTools.toJsonStr(SlhImosen.values()));
			break;
		}
		return "returnnote";
	}

	/**
	 * 冒泡显示记录条数
	 * 
	 * @author renyujuan
	 * @time:2016年8月12日 下午12:45:32
	 * @param queryModel
	 * @param optType
	 * @param checkType
	 * @param equipType
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "ajaxLoad.dox", method = RequestMethod.GET)
	public String ajaxLoad(@ModelAttribute("queryModel") EnvironmentCheckQueryModel queryModel,
			@RequestParam("optType") String optType, @RequestParam("checkType") CheckCatagory checkType,
			@RequestParam("equipType") EquipType equipType, HttpServletRequest request, Model model)
					throws IOException {
		// 设置设备类别和巡检类型
		queryModel.setCheckType(checkType);
		queryModel.setEquipType(equipType);
		switch (optType == null ? "" : optType) {
		case "slhAccCheck":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(envirEquipCheckDao.queryPageByModel(queryModel)));
			break;
		case "slhLbtAccCheck":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(envirEquipCheckDao.queryPageByModel(queryModel)));
			break;
		case "txjdAccCheck":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(envirEquipCheckDao.queryPageByModel(queryModel)));
			break;
		default:
			model.addAttribute("returnStr", JacksonTools.toJsonStr(envirEquipCheckDao.queryPageByModel(queryModel)));
			break;
		}
		return "returnnote";
	}

	/**
	 * 添加记录跳转
	 * 
	 * @author renyujuan
	 * @time:2016年8月12日 下午4:08:43
	 * @param accAddForm
	 * @param checkType
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String addJump(@ModelAttribute("pageModel") AccAddForm accAddForm,
			@RequestParam("checkType") CheckCatagory checkType, Model model) {
		// 检查结果枚举类
		List<CheckResult> checkResult = Arrays.asList(CheckResult.values());
		model.addAttribute("checkresult", checkResult);
		/* 设备类型枚举类 */
		List<EquipType> equipType = Arrays.asList(EquipType.values());
		model.addAttribute("equipType", equipType);
		// 设备名称枚举类
		List<SlhImosen> slhImosen = Arrays.asList(SlhImosen.values());
		model.addAttribute("slhImosen", slhImosen);
		List<SlhLbote> slhLbote = Arrays.asList(SlhLbote.values());
		model.addAttribute("slhLbote", slhLbote);
		model.addAttribute("checkType", checkType);
		return "/duty/accduty/slh/add";
	}

	/**
	 * 添加空调设备巡检记录
	 * 
	 * @author renyujuan
	 * @time:2016年8月15日 上午11:10:49
	 * @param accAddForm
	 * @param equipType
	 * @param checkType
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String add(@ModelAttribute("pageModel") AccAddForm accAddForm,
			@RequestParam("equipType") EquipType equipType, @RequestParam("checkType") CheckCatagory checkType,
			HttpServletRequest request, Model model) throws IOException {
		try {
			/* 设置当前用户为操作人 */
			User user = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
			accAddForm.setOperator(user);
			System.err.println(user);
			/* 设置当前系统时间为巡检时间 */
			accAddForm.setCheckTime(new Date().toLocaleString());
			accAddForm.setCheckDate(accAddForm.getCheckTime());
			/* 设置设备类型和检查类型 */
			accAddForm.setCheckType(checkType);
			accAddForm.setEquipType(equipType);
			/* 将记录保存至数据库 */
			envirEquipCheckService.saveAccCheck(accAddForm);
			model.addAttribute("currentUser", user);
			model.addAttribute("returnStr", new ResultModel(true, "添加空调设备巡检记录成功", accAddForm).toJson());
		} catch (Exception e) {
			logger.error("添加记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(false, "添加空调设备巡检记录成功", accAddForm).toJson());
			return "returnnote";
		}
		return "returnnote";
	}

	/**
	 * 查看记录详情
	 * 
	 * @author renyujuan
	 * @time:2016年8月15日 下午2:28:10
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public String view(@RequestParam("id") String id, HttpServletRequest request, Model model) {
		EnvironmentEquipCheck accCheck = envirEquipCheckService.findById(id);
		model.addAttribute("accCheck", accCheck);
		/* model.addAttribute("view", true); */
		return "/duty/accduty/slh/view";
	}

	/**
	 * 删除记录
	 * 
	 * @author renyujuan
	 * @time:2016年8月15日 下午2:29:09
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String delete(@RequestParam(value = "id", required = true) String id, HttpServletRequest request,
			Model model) {
		try {
			EnvironmentEquipCheck accCheck = envirEquipCheckService.findById(id);
			envirEquipCheckService.delete(accCheck);
			addSuccess(model, "删除记录成功");
			super.addLog(request, "删除记录成功");
		} catch (Exception e) {
			addError(model, "删除记录失败：" + e.getMessage());
		}
		return "duty/accduty/slh/result";
	}

	/**
	 * 跟新记录跳转
	 * 
	 * @author renyujuan
	 * @time:2016年8月15日 下午2:59:33
	 * @param accAddForm
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	public String updateJump(@ModelAttribute("pageModel") AccAddForm accAddForm,
			@RequestParam(value = "id", required = true) String id, HttpServletRequest request, Model model) {
		/* 检查结果枚举类 */
		List<CheckResult> checkResult = Arrays.asList(CheckResult.values());
		model.addAttribute("checkresult", checkResult);
		EnvironmentEquipCheck accCheck = envirEquipCheckService.findById(id);
		model.addAttribute("accCheck", accCheck);
		return "duty/accduty/slh/update";

	}

	/**
	 * 更新记录
	 * 
	 * @author renyujuan
	 * @time:2016年8月15日 下午3:00:03
	 * @param dgAddForm
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(@ModelAttribute("pageModel") AccAddForm accAddForm, @RequestParam("id") String id,
			HttpServletRequest request, Model model) throws IOException {
		try {
			/* 根据id查找相应的柴油发电机巡检记录 */
			System.err.println("ID" + id);
			EnvironmentEquipCheck accCheck = envirEquipCheckService.findById(id);
			envirEquipCheckService.updateAccCheck(accCheck, accAddForm);
			model.addAttribute("returnStr", new ResultModel(true, "更新记录成功", accAddForm).toJson());
		} catch (Exception e) {
			logger.error("添加记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(true, "更新记录失败", accAddForm).toJson());
			return "returnnote";
		}
		return "returnnote";
	}
}
