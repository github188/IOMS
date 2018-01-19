package cn.com.atnc.ioms.web.duty.environment.ups.month;
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
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.enums.duty.environment.ups.ZjUpsName;
import cn.com.atnc.ioms.mng.duty.environment.EnvironmentEquipCheckService;
import cn.com.atnc.ioms.model.duty.environment.ups.UpsMonthAddForm;
import cn.com.atnc.ioms.web.MyBaseController;
@Controller
@RequestMapping("/duty/upsdutymonth/zjups/")
public class ZjUpsMonthController extends MyBaseController {
	
	@Autowired
	private EnvironmentEquipCheckService upsCheckService;
	
	/**
	 * 添加记录跳转
	 * @author renyujuan
	 * @date 2016年8月2日下午3:32:58
	 * @param upsMonthAddForm
	 * @param model
	 * @return
	 */
	@RequestMapping(value="add.do", method=RequestMethod.GET)
	public String addJump(@ModelAttribute("pageModel") UpsMonthAddForm upsMonthAddForm,
			Model model){
		List<ZjUpsName> zjUpsName=Arrays.asList(ZjUpsName.values());
		model.addAttribute("zjUpsName", zjUpsName);
		List<CheckResult> checkresult=Arrays.asList(CheckResult.values());
		model.addAttribute("checkresult", checkresult);
		List<EquipType> equipType=Arrays.asList(EquipType.values());
		model.addAttribute("equipType", equipType);
		List<CheckCatagory> checkType=Arrays.asList(CheckCatagory.values());
		model.addAttribute("checkType", checkType);
		return "duty/upsdutymonth/zjups/add";
	}
	
	/**
	 * 添加记录
	 * @author renyujuan
	 * @date 2016年8月3日上午8:21:43
	 * @param upsMonthAddForm
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="add.do", method=RequestMethod.POST)
	public String add(@ModelAttribute("pageModel") UpsMonthAddForm upsMonthAddForm,
			@RequestParam("equipType") EquipType equipType,
			@RequestParam("checkType") CheckCatagory checkType,
			HttpServletRequest request, Model model) throws IOException{
		try {
			List<String> termialV=null;
			List<String> interR=null;
			List<String> remarks=null;
			List<Integer> number=null;
			User user = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
			upsMonthAddForm.setOperator(user);
			//记录填写时间（系统时间）
			upsMonthAddForm.setCheckTime(new Date().toLocaleString());
			upsMonthAddForm.setCheckDate(upsMonthAddForm.getCheckTime());
			upsMonthAddForm.setEquipType(equipType);
			upsMonthAddForm.setCheckType(checkType);
			upsCheckService.save(upsMonthAddForm, number, termialV, interR, remarks);
			model.addAttribute("currentUser", user);
			model.addAttribute("returnStr",
					new ResultModel(true, "添加ups月检记录成功", upsMonthAddForm).toJson());
		} catch (Exception e) {
			logger.error("添加记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(false, "添加ups月检记录失败",
					upsMonthAddForm).toJson());
			return "returnnote";
		}
		return "returnnote";
	}
	
	
	/**
	 * 删除记录
	 * @author renyujuan
	 * @date 2016年8月3日上午8:26:55
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="delete.do", method=RequestMethod.POST)
	public String delete(@RequestParam(value="id", required=true) String id,
			HttpServletRequest request, Model model){
		try {
			EnvironmentEquipCheck upsCheck=upsCheckService.findById(id);
			upsCheckService.delete(upsCheck);
			addSuccess(model, "删除记录成功");
			super.addLog(request, "删除记录成功");
		} catch (Exception e) {
			addError(model, "删除记录失败：" + e.getMessage());
		}
		return "duty/upsdutymonth/slhups/result";
	}

	/**
	 * 查看详情
	 * @author renyujuan
	 * @date 2016年8月3日上午8:36:00
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="view.do", method=RequestMethod.GET)
	public String view(@RequestParam(value="id",required=true) String id,
			HttpServletRequest request, Model model){
		EnvironmentEquipCheck upsCheck=upsCheckService.findById(id);
		model.addAttribute("upsCheck",upsCheck);
		model.addAttribute("view", true);
		return "duty/upsdutymonth/zjups/view";
	}
	
	/**
	 * 更新记录跳转
	 * @author renyujuan
	 * @date 2016年8月3日上午8:56:31
	 * @param upsMonthAddForm
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="update.do", method=RequestMethod.GET)
	public String updateJump(@ModelAttribute("pageModel") UpsMonthAddForm upsMonthAddForm,
			@RequestParam(value="id", required= true) String id,
			HttpServletRequest request, Model model){
		EnvironmentEquipCheck upsCheck=upsCheckService.findById(id);
		List<CheckResult> checkResult=Arrays.asList(CheckResult.values());
		model.addAttribute("checkresult",checkResult);
		model.addAttribute("upsCheck", upsCheck);
		return "duty/upsdutymonth/zjups/update";
	}
	
	@RequestMapping(value="update.do", method=RequestMethod.POST)
	public String update(@ModelAttribute("pageModel") UpsMonthAddForm upsMonthAddForm,
			@RequestParam("upsCheckId") String upsCheckId,
			HttpServletRequest request, Model model) throws IOException{
		try {
			List<String> termialV=null;
			List<String> interR=null;
			List<String> remarks=null;
			EnvironmentEquipCheck upsCheck=upsCheckService.findById(upsCheckId);
			upsCheckService.update(upsCheck,upsMonthAddForm,termialV,interR,remarks);
			model.addAttribute("returnStr",
					new ResultModel(true, "更新ups月检记录成功", upsMonthAddForm).toJson());
		} catch (Exception e) {
			logger.error("添加记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(false, "添加ups月检记录失败",
					upsMonthAddForm).toJson());
			return "returnnote";
		}
		return "returnnote";
		
	}
		
}
	
	
	
	
