package cn.com.atnc.ioms.web.duty.vgduty;

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
import cn.com.atnc.ioms.entity.duty.vgduty.VGSystem;
import cn.com.atnc.ioms.enums.duty.WorkStatus;
import cn.com.atnc.ioms.mng.duty.vgduty.VGSystemService;
import cn.com.atnc.ioms.model.duty.telegraphduty.TeleGraphSystemQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * VG系统检查
 * @author 
 * @date 
 * @since 
 */
@Controller
@RequestMapping("/duty/vgduty/")
public class VGDutyController extends MyBaseController {
	
	@Autowired
	private VGSystemService vgSystemService;
	
	/**
	 * 新增记录页面跳转
	 * @author 
	 * @date  
	 * @since 
	 */
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String addJump(@ModelAttribute("pageModel") VGSystem vgSystem,
			Model model) {
		//工作状态枚举类
		List<WorkStatus> workStatus = Arrays.asList(WorkStatus.values());
		model.addAttribute("workStatus", workStatus);
		return "duty/vgduty/add";
	}
	
	/**
	 * 新增VG系统检查记录
	 * @author 
	 * @date  
	 * @since 
	 */
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String add(@ModelAttribute("pageModel") VGSystem vgSystem,
			HttpServletRequest request, Model model) {
		try {
			//记录填写人
			User user = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
			vgSystem.setCreater(user);
			//记录填写时间（系统时间）
			vgSystem.setCreateTime(Calendar.getInstance());
			model.addAttribute("vo", vgSystemService.save(vgSystem));
			model.addAttribute("currentUser", user);
			addSuccess(model, "添加\"VG系统检查\"记录成功");
		    super.addLog(request, "添加\"VG系统检查\"记录成功");
		} catch (Exception e) {
			addError(model, "添加\"VG系统检查\"记录失败：" + e.getMessage());
		}
		return "duty/vgduty/result";
	}
	
	/**
	 * 审核跳转页面
	 * @author 
	 * @date  
	 * @since 
	 */
	@RequestMapping(value = "/audit.do", method = RequestMethod.GET)
	public String auditJump(Model model, HttpServletRequest request,
			@RequestParam(value = "id", required = true) String id) {
		//根据ID查找VG系统记录
		VGSystem vgSystem = vgSystemService.findById(id);
		model.addAttribute("vgSystem", vgSystem);
		return "duty/vgduty/audit";
	}
	
	/**
	 * 审核
	 * @author 
	 * @date  
	 * @since 
	 */
	@RequestMapping(value = "/audit.do", method = RequestMethod.POST)
	public String audit(Model model, HttpServletRequest request,
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "remark", required = true) String remark) {
		try {
			//记录审核人
			User user = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
			//根据ID查找原记录
			VGSystem vgSystem = vgSystemService.findById(id);
			//对新字段赋值
			vgSystem.setAuditer(user);
			vgSystem.setAuditTime(Calendar.getInstance());
			vgSystem.setRemark(remark);
			//保存更改
			model.addAttribute("vo", vgSystemService.update(vgSystem));
			addSuccess(model, "审核\"VG系统检查\"记录成功");
		    super.addLog(request, "审核\"VG系统检查\"记录成功");
		} catch (Exception e) {
			addError(model, "审核\"VG系统检查\"记录失败：" + e.getMessage());
		}
		return "duty/vgduty/result";
	}
	
	/**
	 * 查看详情
	 * @author 
	 * @date  
	 * @since 
	 */
	@RequestMapping(value = "/view.do", method = RequestMethod.GET)
	public String view(Model model, HttpServletRequest request,
			@RequestParam(value = "id", required = true) String id) {
		//根据ID查找VG系统记录
		VGSystem vgSystem = vgSystemService.findById(id);
		model.addAttribute("vgSystem", vgSystem);
		model.addAttribute("view", true);
		return "duty/vgduty/audit";
	}
}
