package cn.com.atnc.ioms.web.duty.environment.dg;

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
import cn.com.atnc.ioms.enums.duty.environment.dg.DgName;
import cn.com.atnc.ioms.enums.duty.environment.ups.SlhUpsName;
import cn.com.atnc.ioms.mng.duty.environment.EnvironmentEquipCheckService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.environment.dg.DgAddForm;
import cn.com.atnc.ioms.model.duty.environment.ups.UpsMonthAddForm;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 柴油发电机月检controller
 * @author renyujuan
 * @date 2016年8月9日下午1:39:31
 */
@Controller
@RequestMapping("/duty/dgdutyquarter/")
public class DgQuarterController extends MyBaseController {
	@Autowired
	private EnvironmentEquipCheckService envirEquipCheckService;
	@Autowired
	private EnvironmentEquipCheckDao envirEquipCheckDao;

	@RequestMapping(value="manage.do", method=RequestMethod.GET)
	public String manageJump(@ModelAttribute("queryModel") EnvironmentCheckQueryModel queryModel, 
			HttpServletRequest request, Model model){
		/*柴油发电机设备名称*/
		List<DgName> dgName = Arrays.asList(DgName.values());
		model.addAttribute("dgName",dgName);
		/*设备类型枚举类*/
		List<EquipType> equipType=Arrays.asList(EquipType.values());
		model.addAttribute("equipType", equipType);
		/*检查类别枚举类*/
		List<CheckCatagory> checkType=Arrays.asList(CheckCatagory.values());
		model.addAttribute("checkType", checkType);
		super.pageInfo(model, request);
		return "duty/dgdutyquarter/manage";	
	}
	
	/**
	 * 加载数据
	 * @author renyujuan
	 * @date 2016年8月9日下午2:50:10
	 * @param queryModel
	 * @param optType
	 * @param checkType
	 * @param equipType
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="manage.do", method=RequestMethod.POST)
	public String manageList(@ModelAttribute("queryModel") EnvironmentCheckQueryModel queryModel,
			@RequestParam("optType") String optType,
			@RequestParam("checkType") CheckCatagory checkType,
			@RequestParam("equipType") EquipType equipType,
			HttpServletRequest request, Model model){
		//记录填写人
		User currentUser = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
		queryModel.setEquipType(equipType);
		queryModel.setCheckType(checkType);
		model.addAttribute("optType",optType);
		model.addAttribute("currentUser", currentUser);
		switch(optType == null ? "" : optType){
		case "dgCheck":
			model.addAttribute("pagn", envirEquipCheckService.queryPageByModel(queryModel) );
			return "duty/dgdutyquarter/queryResult";
		default:
			model.addAttribute("pagn", envirEquipCheckService.queryPageByModel(queryModel) );
			return "duty/dgdutyquarter/queryResult";
		}
	}
	
	/**
	 * 冒泡显示记录条数
	 * @author renyujuan
	 * @date 2016年8月9日下午3:39:48
	 * @param queryModel
	 * @param optType
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="ajaxLoad.dox", method=RequestMethod.GET)
	public String ajaxLoad(@ModelAttribute("queryModel") EnvironmentCheckQueryModel queryModel, 
			@RequestParam("optType") String optType,
			HttpServletRequest request, Model model) throws IOException{
		//设置设备类别和巡检类型
		CheckCatagory checkType = CheckCatagory.getInstance("季检");
		EquipType equipType = EquipType.getInstance("柴油发电机");
		queryModel.setCheckType(checkType);
		queryModel.setEquipType(equipType);
		switch(optType == null ? "" : optType){
		case "dgCheck":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(envirEquipCheckDao.queryPageByModel(queryModel)));
			break;
		default:
			model.addAttribute("returnStr", JacksonTools.toJsonStr(envirEquipCheckDao.queryPageByModel(queryModel)));
			break;
		}
		return "returnnote";
	}
	
	/**
	 * 新增柴油发电机巡检记录跳转
	 * @author renyujuan
	 * @date 2016年8月9日下午3:42:36
	 * @param dgAddForm
	 * @param model
	 * @return
	 */
	@RequestMapping(value="add.do", method=RequestMethod.GET)
	public String addJump(@ModelAttribute("pageModel") DgAddForm dgAddForm, 
			Model model){
		//设备名称枚举类
		List<DgName> dgName=Arrays.asList(DgName.values());
		model.addAttribute("dgName",dgName);
		//检查结果枚举类
		List<CheckResult> checkResult=Arrays.asList(CheckResult.values());
		model.addAttribute("checkresult",checkResult);
		/*设备类型枚举类*/
		List<EquipType> equipType=Arrays.asList(EquipType.values());
		model.addAttribute("equipType", equipType);
		/*检查类型枚举类*/
		List<CheckCatagory> checkType=Arrays.asList(CheckCatagory.values());
		model.addAttribute("checkType", checkType);
		return "duty/dgdutyquarter/add";
	}
	
	/**
	 * 添加柴油发电机月检记录
	 * @author renyujuan
	 * @date 2016年8月10日上午8:43:29
	 * @param dgAddForm
	 * @param checkType
	 * @param equipType
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="add.do" , method=RequestMethod.POST)
	public String addDgCheck(@ModelAttribute("pageModel") DgAddForm dgAddForm,
			@RequestParam("checkType") CheckCatagory checkType,
			@RequestParam("equipType") EquipType equipType,
			HttpServletRequest request, Model model) throws IOException{
		try {
			/*设置当前用户为操作人*/
			User user = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
			dgAddForm.setOperator(user);
			/*设置当前系统时间为巡检时间*/
			dgAddForm.setCheckTime(new Date().toLocaleString());
			dgAddForm.setCheckDate(dgAddForm.getCheckTime());
			/*设置设备类型和检查类型*/
			dgAddForm.setCheckType(checkType);
			dgAddForm.setEquipType(equipType);
			/*将记录保存至数据库*/
			envirEquipCheckService.saveDgCheck(dgAddForm);
			model.addAttribute("currentUser", user);
			model.addAttribute("returnStr", new ResultModel(true, "添加柴油发电机季检记录成功", dgAddForm).toJson());
		} catch (Exception e) {
			logger.error("添加记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(false, "添加柴油发电机季检记录成功",
					dgAddForm).toJson());
			return "returnnote";
		}
		return "returnnote";
	}
	
}
