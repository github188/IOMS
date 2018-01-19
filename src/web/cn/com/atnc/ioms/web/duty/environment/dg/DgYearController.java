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
@RequestMapping("/duty/dgdutyyear/")
public class DgYearController extends MyBaseController {
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
		return "duty/dgdutyyear/manage";	
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
		CheckCatagory checkType = CheckCatagory.getInstance("年检");
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
		return "duty/dgdutyyear/add";
	}
}
