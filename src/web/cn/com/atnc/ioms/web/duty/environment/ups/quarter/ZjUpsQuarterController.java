package cn.com.atnc.ioms.web.duty.environment.ups.quarter;

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

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.enums.duty.environment.ups.KuUpsName;
import cn.com.atnc.ioms.enums.duty.environment.ups.SlhUpsName;
import cn.com.atnc.ioms.enums.duty.environment.ups.TxjdUpsName;
import cn.com.atnc.ioms.enums.duty.environment.ups.ZjUpsName;
import cn.com.atnc.ioms.mng.duty.environment.EnvironmentEquipCheckService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.environment.ups.UpsMonthAddForm;
import cn.com.atnc.ioms.web.MyBaseController;
/**
 * 总局ups设备季检controller
 * @author renyujuan
 * @date 2016年8月3日下午12:43:46
 */
@Controller
@RequestMapping("/duty/upsdutyquarter/zjups/")
public class ZjUpsQuarterController extends MyBaseController {

	@Autowired
	private EnvironmentEquipCheckService upsCheckService;
	@Autowired
	private EnvironmentEquipCheckDao upsCheckDao;
	
	/**
	 * 记录添加跳转
	 * @author renyujuan
	 * @date 2016年8月4日上午9:46:22
	 * @param upsMonthAddForm
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="add.do", method=RequestMethod.GET)
	public String addJump(@ModelAttribute("pageModel") UpsMonthAddForm upsMonthAddForm,
			HttpServletRequest request, Model model){
		//设备名称枚举类
		List<ZjUpsName> zjUpsName=Arrays.asList(ZjUpsName.values());
		model.addAttribute("zjUpsName",zjUpsName);
		//检查结果枚举类
		List<CheckResult> checkResult=Arrays.asList(CheckResult.values());
		model.addAttribute("checkresult",checkResult);
		List<EquipType> equipType=Arrays.asList(EquipType.values());
		model.addAttribute("equipType", equipType);
		List<CheckCatagory> checkType=Arrays.asList(CheckCatagory.values());
		model.addAttribute("checkType", checkType);
		return "duty/upsdutyquarter/zjups/add";
	}
	
	@RequestMapping(value="add.do", method=RequestMethod.POST)
	public String add(@ModelAttribute("pageModel") UpsMonthAddForm upsMonthAddForm,
			@RequestParam("dsTime") List<String> dsTime,
			@RequestParam("batTotalV") List<String> batTotalV,
			@RequestParam("dsCurrent") List<String> dsCurrent,
			@RequestParam("singleMaxV") List<String> singleMaxV,
			@RequestParam("singleMinV") List<String> singleMinV,
			@RequestParam("remark") List<String> remark,
			@RequestParam("equipType") EquipType equipType,
			@RequestParam("checkType") CheckCatagory checkType,
			HttpServletRequest request, Model model) throws IOException{
		try {
			//记录填写人
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
			upsCheckService.saveQuarter(upsMonthAddForm, number, termialV, interR, remarks, dsTime, batTotalV, dsCurrent, singleMaxV, singleMinV, remark);
			model.addAttribute("currentUser", user);
			model.addAttribute("returnStr",
					new ResultModel(true, "添加ups季检记录成功", upsMonthAddForm).toJson());
		} catch (Exception e) {
			logger.error("添加记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(false, "添加ups季检记录失败",
					upsMonthAddForm).toJson());
			return "returnnote";
		}
		return "returnnote";
	}
	
	@RequestMapping(value="delete.do", method=RequestMethod.POST)
	public String delete(@RequestParam("id") String id,
			HttpServletRequest request, Model model){
		try {
			EnvironmentEquipCheck upsCheck=upsCheckService.findById(id);
			upsCheckService.delete(upsCheck);
			addSuccess(model, "删除记录成功");
			super.addLog(request, "删除记录成功");
		} catch (Exception e) {
			addError(model, "删除记录失败：" + e.getMessage());
		}
		return "duty/upsdutyquarter/slhups/result";
	}
	
	@RequestMapping(value="view.do", method=RequestMethod.GET)
	public String view(@RequestParam(value="id", required = true) String id,
			HttpServletRequest request, Model model){
		EnvironmentEquipCheck upsCheck=upsCheckService.findById(id);
		model.addAttribute("upsCheck",upsCheck);
		model.addAttribute("view", true);
		return "duty/upsdutyquarter/zjups/view";
	}
	
	@RequestMapping(value="update.do" , method=RequestMethod.GET)
	public String update(@ModelAttribute("pageModel") UpsMonthAddForm upsMonthAddForm,
			@RequestParam(value="id", required= true) String id,
			HttpServletRequest request, Model model){
		EnvironmentEquipCheck upsCheck=upsCheckService.findById(id);
		List<CheckResult> checkResult=Arrays.asList(CheckResult.values());
		model.addAttribute("checkresult",checkResult);
		model.addAttribute("upsCheck", upsCheck);
		return "duty/upsdutyquarter/zjups/update";
	}
	
	@RequestMapping(value="update.do" , method=RequestMethod.POST)
	public String updateUpsCheck(@ModelAttribute("pageModel") UpsMonthAddForm upsMonthAddForm,
			@RequestParam("dsTime") List<String> dsTime,
			@RequestParam("batTotalV") List<String> batTotalV,
			@RequestParam("dsCurrent") List<String> dsCurrent,
			@RequestParam("singleMaxV") List<String> singleMaxV,
			@RequestParam("singleMinV") List<String> singleMinV,
			@RequestParam("remark") List<String> remark,
			@RequestParam("upsCheckId") String upsCheckId,
			HttpServletRequest request, Model model) throws IOException{
		try {
			List<String> termialV=null;
			List<String> interR=null;
			List<String> remarks=null;
			EnvironmentEquipCheck upsCheck=upsCheckService.findById(upsCheckId);
			upsCheckService.updateQuarter(upsCheck, upsMonthAddForm, termialV, interR, remarks, dsTime, batTotalV, dsCurrent, singleMaxV, singleMinV, remark);
			model.addAttribute("returnStr",
					new ResultModel(true, "更新ups季检记录成功", upsMonthAddForm).toJson());
		} catch (Exception e) {
			logger.error("更新记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(false, "更新ups季检记录失败",
					upsMonthAddForm).toJson());
			return "returnnote";
		}
		return "returnnote";
	}
}
	
	
	
	
	
	
	
	
	
	
