package cn.com.atnc.ioms.web.duty.telegraphduty;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.telegraphduty.TeleGraphSystem;

import cn.com.atnc.ioms.enums.duty.ReduncdancyStatus;
import cn.com.atnc.ioms.enums.duty.WorkStatus;
import cn.com.atnc.ioms.mng.duty.telegraphduty.TeleGraphSystemService;
import cn.com.atnc.ioms.mng.duty.vgduty.VGSystemService;
import cn.com.atnc.ioms.model.duty.telegraphduty.TeleGraphSystemQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 转报巡检
 * @author WangLingbin
 * @date 2016年1月8日 上午9:34:32
 * @since 1.0.0
 */
@Controller
@RequestMapping("/duty/telegraphduty/")
public class TeleGraphDutyController extends MyBaseController {
	
	@Autowired
	private TeleGraphSystemService teleGraphSystemService;
	
	@Autowired
	private VGSystemService vgSystemService;
	/**
	 * 页面初始化
	 * @author WangLingbin
	 * @date  2016年1月8日下午2:24:50
	 * @since 1.0.0
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(@ModelAttribute("queryModel") TeleGraphSystemQueryModel queryModel,
			HttpServletRequest request, Model model) {
		super.pageInfo(model, request);
		return "duty/telegraphduty/manage";
	}
	
	/**
	 * 加载数据
	 * @author WangLingbin
	 * @date  2016年1月8日下午2:24:57
	 * @since 1.0.0
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(@ModelAttribute("queryModel") TeleGraphSystemQueryModel queryModel,
			HttpServletRequest request, Model model,
			@RequestParam("optType") String optType) {
		//记录填写人
		User currentUser = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
		model.addAttribute("currentUser", currentUser);
		switch(optType == null ? "" : optType) {
		case "teleGraphCheck":
			model.addAttribute("pagn", teleGraphSystemService.
					queryPageByModel(queryModel));
			return "duty/telegraphduty/queryResult";
		case "vgCheck":
			model.addAttribute("pagn", vgSystemService.
					queryPageByModel(queryModel));
			return "duty/vgduty/queryResult";
		default:
			model.addAttribute("pagn", teleGraphSystemService.
					queryPageByModel(queryModel));
			return "duty/telegraphduty/queryResult";
		}
	}
	
	/**
	 * 冒泡显示记录条数
	 * @throws IOException 
	 * @author WangLingbin
	 * @date  2016年1月8日下午2:27:17
	 * @since 1.0.0
	 */
	@RequestMapping(value = "ajaxLoad.dox",method = RequestMethod.GET)
	public String ajaxLoad(@ModelAttribute("queryModel") TeleGraphSystemQueryModel queryModel,
			HttpServletRequest request, Model model, 
			@RequestParam("optType") String optType) throws IOException {
		//User user = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
		switch(optType == null ? "" : optType) {
		case "teleGraphCheck":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(teleGraphSystemService.
					queryPageByModel(queryModel)));
			break;
		case "vgCheck":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(vgSystemService.
					queryPageByModel(queryModel)));
			break;
		default:
			model.addAttribute("returnStr", JacksonTools.toJsonStr(teleGraphSystemService.
					queryPageByModel(queryModel)));
			break;
		}
		return "returnnote";
	}
	
	
	/**
	 * 新增记录页面跳转
	 * @author WangLingbin
	 * @date  2016年1月8日下午2:36:22
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String addJump(@ModelAttribute("pageModel") TeleGraphSystem teleGraphSystem,
			Model model) {
			//冗余状态枚举类
			List<ReduncdancyStatus> reduncdancyStatus = Arrays.asList(ReduncdancyStatus.values());
			model.addAttribute("reduncdancyStatus", reduncdancyStatus);
			//工作状态枚举类
			List<WorkStatus> teleGraphWorkStatus = Arrays.asList(WorkStatus.values());
			model.addAttribute("workStatus", teleGraphWorkStatus);
			return "duty/telegraphduty/add";
	}
	
	/**
	 * 新增转报系统检查记录
	 * @author WangLingbin
	 * @date  2016年1月8日下午3:46:29
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String add(@ModelAttribute("pageModel") TeleGraphSystem teleGraphSystem,
			HttpServletRequest request, Model model) {
		try {
			User user = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
			//记录填写人
			teleGraphSystem.setCreater(user);
			//记录填写时间（系统时间）
			teleGraphSystem.setCreateTime(Calendar.getInstance());
			model.addAttribute("vo", teleGraphSystemService.save(teleGraphSystem));
			model.addAttribute("currentUser", user);
			addSuccess(model, "添加\"转报系统检查\"记录成功");
			super.addLog(request, "添加\"转报系统检查\"记录成功");
			return "duty/telegraphduty/result";
		} catch (Exception e) {
			addError(model, "添加\"转报系统检查\"记录失败：" + e.getMessage());
			return "duty/telegraphduty/result";
		}
	}
	
	/**
	 * 审核跳转页面
	 * @author WangLingbin
	 * @date  2016年1月11日上午9:20:25
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/audit.do", method = RequestMethod.GET)
	public String auditJump(Model model, HttpServletRequest request,
			@RequestParam(value = "id", required = true) String id) {
		//根据ID查找转报系统记录
		TeleGraphSystem teleGraphSystem = teleGraphSystemService.findById(id);
		model.addAttribute("teleGraphSystem", teleGraphSystem);
		return "duty/telegraphduty/audit";
	}
	
	/**
	 * 审核
	 * @author WangLingbin
	 * @date  2016年1月11日上午9:20:25
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/audit.do", method = RequestMethod.POST)
	public String audit(Model model, HttpServletRequest request,
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "remark", required = true) String remark) {
		try {
			//记录审核人
			User user = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
			//根据ID查找原记录
			TeleGraphSystem teleGraphSystem = teleGraphSystemService.findById(id);
			//对新字段赋值
			teleGraphSystem.setAuditer(user);
			teleGraphSystem.setAuditTime(Calendar.getInstance());
			teleGraphSystem.setRemark(remark);
			//保存更改
			model.addAttribute("vo", teleGraphSystemService.update(teleGraphSystem));
			addSuccess(model, "审核\"转报系统检查\"记录成功");
		    super.addLog(request, "审核\"转报系统检查\"记录成功");
		} catch (Exception e) {
			addError(model, "审核\"转报系统检查\"记录失败：" + e.getMessage());
		}
		return "duty/telegraphduty/result";
	}
	
	/**
	 * 查看详情
	 * @author WangLingbin
	 * @date  2016年1月11日下午1:58:24
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/view.do", method = RequestMethod.GET)
	public String view(Model model, HttpServletRequest request,
			@RequestParam(value = "id", required = true) String id) {
		//根据ID查找转报系统记录
		TeleGraphSystem teleGraphSystem = teleGraphSystemService.findById(id);
		model.addAttribute("teleGraphSystem", teleGraphSystem);
		model.addAttribute("view", true);
		return "duty/telegraphduty/audit";
	}
}