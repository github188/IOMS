package cn.com.atnc.ioms.web.duty.environment.ups.year;
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
import cn.com.atnc.ioms.enums.duty.environment.ContentCheckResult;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.enums.duty.environment.ups.KuUpsName;
import cn.com.atnc.ioms.mng.duty.environment.EnvironmentEquipCheckService;
import cn.com.atnc.ioms.model.duty.environment.ups.UpsMonthAddForm;
import cn.com.atnc.ioms.web.MyBaseController;
/**
 * kuups设备年检controller
 * @author renyujuan
 * @date 2016年8月5日下午3:21:22
 */
@Controller
@RequestMapping("/duty/upsdutyyear/kuups/")
public class KuUpsYearController extends MyBaseController {

	@Autowired
	private EnvironmentEquipCheckService upsCheckService;
	
	/**
	 * 添加记录跳转
	 * @author renyujuan
	 * @date 2016年8月2日上午9:54:00
	 * @param kuUpsMonthAddForm
	 * @param model
	 * @return
	 */
	@RequestMapping(value="add.do", method=RequestMethod.GET)
	public String addJump(@ModelAttribute("pageModel") UpsMonthAddForm kuUpsMonthAddForm,
			Model model){
		//设备名称枚举类
		List<KuUpsName> kuUpsName=Arrays.asList(KuUpsName.values());
		model.addAttribute("kuUpsName", kuUpsName);
		//检查结果枚举类
		List<CheckResult> checkResult=Arrays.asList(CheckResult.values());
		model.addAttribute("checkResult", checkResult);
		List<EquipType> equipType=Arrays.asList(EquipType.values());
		model.addAttribute("equipType", equipType);
		List<CheckCatagory> checkType=Arrays.asList(CheckCatagory.values());
		model.addAttribute("checkType", checkType);
		//内容检查结果枚举类
		List<ContentCheckResult> contentCheckResult=Arrays.asList(ContentCheckResult.values());
		model.addAttribute("contentCheckResult", contentCheckResult);
		return "/duty/upsdutyyear/kuups/add";
	}
	
	/**
	 * 添加记录
	 * @author renyujuan
	 * @date 2016年8月2日上午9:53:47
	 * @param kuUpsMonthAddForm
	 * @param termialV
	 * @param interR
	 * @param remarks
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping( value="add.do", method=RequestMethod.POST)
	public String add(@ModelAttribute("pageModel") UpsMonthAddForm kuUpsMonthAddForm,
			@RequestParam("number") List<Integer> number,
			@RequestParam("termialV") List<String> termialV,
			@RequestParam("interR") List<String> interR,
			@RequestParam("remarks") List<String> remarks,
			@RequestParam("equipType") EquipType equipType,
			@RequestParam("checkType") CheckCatagory checkType,
			HttpServletRequest request, Model model) throws IOException{
		try {
			//记录填写人
			User user = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
			kuUpsMonthAddForm.setOperator(user);
			kuUpsMonthAddForm.setEquipType(equipType);
			kuUpsMonthAddForm.setCheckType(checkType);
			//记录填写时间（系统时间）
			kuUpsMonthAddForm.setCheckTime(new Date().toLocaleString());
			kuUpsMonthAddForm.setCheckDate(kuUpsMonthAddForm.getCheckTime());
			upsCheckService.save(kuUpsMonthAddForm,number,termialV,interR,remarks);
			model.addAttribute("currentUser", user);
			model.addAttribute("returnStr",
					new ResultModel(true, "添加ups季检记录成功", kuUpsMonthAddForm).toJson());
		} catch (Exception e) {
			logger.error("添加记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(false, "添加ups季检记录失败",
					kuUpsMonthAddForm).toJson());
			return "returnnote";
		}
		return "returnnote";
	}
	
	/**
	 * 查看记录详情
	 * @author renyujuan
	 * @date 2016年8月2日上午10:22:25
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="view.do", method=RequestMethod.GET)
	public String view(@RequestParam(value="id", required = true) String id,
			HttpServletRequest request, Model model){
		EnvironmentEquipCheck upsCheck=upsCheckService.findById(id);
		model.addAttribute("upsCheck",upsCheck);
		model.addAttribute("view", true);
		return "duty/upsdutyyear/kuups/view";
	}
	
	/**
	 * 删除记录
	 * @author renyujuan
	 * @date 2016年8月2日上午10:26:19
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="delete.do", method=RequestMethod.POST)
	public String delete(@RequestParam(value="id", required= true) String id,
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
	
	/**
	 * 更新记录页面跳转
	 * @author renyujuan
	 * @date 2016年8月2日上午10:58:16
	 * @param sLHUpsMonthAddForm
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="update.do", method=RequestMethod.GET)
	public String updateJump(@ModelAttribute("pageModel") UpsMonthAddForm kuUpsMonthAddForm,
			@RequestParam(value="id", required= true) String id,
			HttpServletRequest request, Model model){
		EnvironmentEquipCheck upsCheck=upsCheckService.findById(id);
		List<CheckResult> checkResult=Arrays.asList(CheckResult.values());
		model.addAttribute("checkresult",checkResult);
		//内容检查结果枚举类
		List<ContentCheckResult> contentCheckResult=Arrays.asList(ContentCheckResult.values());
		model.addAttribute("contentCheckResult", contentCheckResult);
		model.addAttribute("upsCheck", upsCheck);
		return "duty/upsdutyyear/kuups/update";
	}
	
	/**
	 * 更新记录
	 * @author renyujuan
	 * @date 2016年8月2日上午11:03:34
	 * @param kuUpsMonthAddForm
	 * @param termialV
	 * @param interR
	 * @param remarks
	 * @param upsCheckId
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="update.do", method=RequestMethod.POST)
	public String update(@ModelAttribute("pageModel") UpsMonthAddForm kuUpsMonthAddForm,
			@RequestParam("termialV") List<String> termialV,
			@RequestParam("interR") List<String> interR,
			@RequestParam("remarks") List<String> remarks,
			@RequestParam("upsCheckId") String upsCheckId,
			HttpServletRequest request, Model model) throws IOException{
		try {
			EnvironmentEquipCheck upsCheck=upsCheckService.findById(upsCheckId);
			upsCheckService.update(upsCheck,kuUpsMonthAddForm,termialV,interR,remarks);
			model.addAttribute("returnStr",
					new ResultModel(true, "更新ups季检记录成功", kuUpsMonthAddForm).toJson());
		} catch (Exception e) {
			logger.error("添加记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(false, "添加ups季检记录失败",
					kuUpsMonthAddForm).toJson());
			return "returnnote";
		}
		return "returnnote";
		
	}
}
