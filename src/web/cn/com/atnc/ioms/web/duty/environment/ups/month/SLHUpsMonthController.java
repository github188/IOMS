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
import cn.com.atnc.ioms.mng.duty.environment.ups.BatteryMeasureService;
import cn.com.atnc.ioms.mng.duty.environment.ups.SystemConnMeasureService;
import cn.com.atnc.ioms.mng.duty.environment.ups.SystemMeasureService;
import cn.com.atnc.ioms.mng.duty.environment.ups.UpsContentCheckService;
import cn.com.atnc.ioms.mng.duty.environment.ups.ZgvZlcMeasureService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.environment.ups.UpsMonthAddForm;
import cn.com.atnc.ioms.util.DateUtilTools;
import cn.com.atnc.ioms.web.MyBaseController;
/**
 * 十里河一号机，二号机，军航controller
 * @author renyujuan
 * @date 2016年7月12日上午9:37:45
 */
@Controller
@RequestMapping("/duty/upsdutymonth/slhups/")
public class SLHUpsMonthController extends MyBaseController {
	@Autowired
	private EnvironmentEquipCheckDao upsCheckDao;
	@Autowired
	private EnvironmentEquipCheckService upsCheckService;
	@Autowired
	private UpsContentCheckService upsContentCheckService;
	@Autowired
	private SystemMeasureService systemMeasureService;
	@Autowired
	private ZgvZlcMeasureService zgvZlcmeasureService;
	@Autowired
	private BatteryMeasureService batteryMeasureService;
	@Autowired
	private SystemConnMeasureService systemConnMeasureService;
	/**
	 * 页面初始化
	 * @author renyujuan
	 * @date 2016年7月12日下午12:51:51
	 * @return
	 */
	@RequestMapping(value="manage.do", method=RequestMethod.GET)
	public String manage(@ModelAttribute("queryModel") EnvironmentCheckQueryModel queryModel, 
			HttpServletRequest request, Model model){
		List<SlhUpsName> slhUpsName=Arrays.asList(SlhUpsName.values());
		model.addAttribute("slhUpsName",slhUpsName);
		List<EquipType> equipType=Arrays.asList(EquipType.values());
		model.addAttribute("equipType", equipType);
		List<CheckCatagory> checkType=Arrays.asList(CheckCatagory.values());
		model.addAttribute("checkType", checkType);
		super.pageInfo(model, request);
		return "duty/upsdutymonth/slhups/manage";
	}
	
	
	/**
	 * 加载数据
	 * @author renyujuan
	 * @date 2016年7月13日上午9:53:31
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="manage.do", method=RequestMethod.POST)
	public String manageList(@ModelAttribute("queryModel") EnvironmentCheckQueryModel queryModel, 
			HttpServletRequest request, Model model,
			@RequestParam("equipType") EquipType equipType,
			@RequestParam("checkType") CheckCatagory checkType,
			@RequestParam("optType") String optType){
		//记录填写人
		User currentUser = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
		queryModel.setEquipType(equipType);
		queryModel.setCheckType(checkType);
		model.addAttribute("optType",optType);
		model.addAttribute("currentUser", currentUser);
		switch(optType == null ? "" : optType) {
		case "slhUpsCheck":
			model.addAttribute("pagn", upsCheckService.queryPageByModel(queryModel) );
			return "duty/upsdutymonth/slhups/queryResult";
		case "kuUpsCheck":
			model.addAttribute("pagn",upsCheckService.queryPageByModel(queryModel));
			return "duty/upsdutymonth/kuups/queryResult";
		case "txjdUpsCheck":
			model.addAttribute("pagn",upsCheckService.queryPageByModel(queryModel));
			return "duty/upsdutymonth/txjdups/queryResult";
		case "zjUpsCheck":
			model.addAttribute("pagn",upsCheckService.queryPageByModel(queryModel));
			return "duty/upsdutymonth/zjups/queryResult";
		default:
			model.addAttribute("pagn", upsCheckService.queryPageByModel(queryModel));
			return "duty/upsdutymonth/slhups/queryResult";
		}
	}
	
	
	/**
	 * 新增记录跳转
	 * @author renyujuan
	 * @date 2016年7月13日上午11:15:46
	 * @param queryModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value="add.do", method=RequestMethod.GET)
	public String addJump(@ModelAttribute("pageModel") UpsMonthAddForm sLHUpsMonthAddForm, 
			Model model){
		//设备名称枚举类
		List<SlhUpsName> slhUpsName=Arrays.asList(SlhUpsName.values());
		model.addAttribute("slhUpsName",slhUpsName);
		//检查结果枚举类
		List<CheckResult> checkResult=Arrays.asList(CheckResult.values());
		model.addAttribute("checkresult",checkResult);
		List<EquipType> equipType=Arrays.asList(EquipType.values());
		model.addAttribute("equipType", equipType);
		List<CheckCatagory> checkType=Arrays.asList(CheckCatagory.values());
		model.addAttribute("checkType", checkType);
		return "duty/upsdutymonth/slhups/add";
	}
	
	/**
	 * 新增ups巡检记录
	 * @author renyujuan
	 * @date 2016年7月13日上午11:22:53
	 * @param upsCheck
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value="add.do", method=RequestMethod.POST)
	public String add(@ModelAttribute("pageModel") UpsMonthAddForm sLHUpsMonthAddForm,
			@RequestParam("number") List<Integer> number,
			@RequestParam("termialV") List<String> termialV,
			@RequestParam("interR") List<String> interR,
			@RequestParam("remarks") List<String> remarks,
			@RequestParam("equipType") EquipType equipType,
			@RequestParam("checkType") CheckCatagory checkType,
			HttpServletRequest request, Model model ) throws IOException{
		try {
			//记录填写人
			User user = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
			sLHUpsMonthAddForm.setOperator(user);
			//System.err.println(termialV.size());
			//记录填写时间（系统时间）
			sLHUpsMonthAddForm.setCheckTime(new Date().toLocaleString());
			sLHUpsMonthAddForm.setCheckDate(sLHUpsMonthAddForm.getCheckTime());
			sLHUpsMonthAddForm.setEquipType(equipType);
			sLHUpsMonthAddForm.setCheckType(checkType);
			upsCheckService.save(sLHUpsMonthAddForm, number, termialV, interR, remarks);
			//model.addAttribute("vo", upsCheckService.save(sLHUpsMonthAddForm,termialV,interR,remarks));
			model.addAttribute("currentUser", user);
			model.addAttribute("returnStr",
					new ResultModel(true, "添加ups月检记录成功", sLHUpsMonthAddForm).toJson());
			//addSuccess(model, "添加\"ups设备检查\"记录成功");
		    //super.addLog(request, "添加\"ups设备检查\"记录成功");
		} catch (Exception e) {
			logger.error("添加记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(false, "添加ups月检记录失败",
					sLHUpsMonthAddForm).toJson());
			return "returnnote";
			//addError(model, "添加\"ups设备检查\"记录失败：" + e.getMessage());
		}
		return "returnnote";
	}
	
	/**
	 * 冒泡显示记录条数
	 * @author renyujuan
	 * @date 2016年7月21日上午8:58:20
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "ajaxLoad.dox", method = RequestMethod.GET)
	public String ajaxLoad(@ModelAttribute("queryModel") EnvironmentCheckQueryModel queryModel, 
			@RequestParam("optType") String optType,
			HttpServletRequest request, Model model) throws IOException {
		//设置设备类别和巡检类型
		CheckCatagory checkType = CheckCatagory.getInstance("月检");
		EquipType equipType = EquipType.getInstance("ups设备");
		queryModel.setCheckType(checkType);
		queryModel.setEquipType(equipType);
		switch(optType == null ? "" : optType) {
		case "slhUpsCheck":
			Pagination pagn=upsCheckDao.queryPageByModel(queryModel);
			model.addAttribute("returnStr", JacksonTools.toJsonStr(pagn));
			break;
		case "kuUpsCheck":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(upsCheckDao.queryPageByModel(queryModel)));
			break;
		case "txjdUpsCheck":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(upsCheckDao.queryPageByModel(queryModel)));
			break;
		case "zjUpsCheck":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(upsCheckDao.queryPageByModel(queryModel)));
			break;
		default:
			model.addAttribute("returnStr", JacksonTools.toJsonStr(upsCheckService.
					queryPageByModel(queryModel)));
			break;
		}
		return "returnnote";
	}
	
	/**
	 * 删除记录
	 * @author renyujuan
	 * @date 2016年7月22日下午2:03:40
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="delete.do", method=RequestMethod.POST)
	public String deleteUpsCheckMonth(@RequestParam("id") String id,
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
	 * @date 2016年7月22日下午2:11:44
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
		return "duty/upsdutymonth/slhups/view";
	}
	
	/**
	 * 更新记录跳转
	 * @author renyujuan
	 * @date 2016年7月25日下午2:59:34
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="update.do" , method=RequestMethod.GET)
	public String update(@ModelAttribute("pageModel") UpsMonthAddForm sLHUpsMonthAddForm,
			@RequestParam(value="id", required= true) String id,
			HttpServletRequest request, Model model){
		EnvironmentEquipCheck upsCheck=upsCheckService.findById(id);
		List<CheckResult> checkResult=Arrays.asList(CheckResult.values());
		model.addAttribute("checkresult",checkResult);
		model.addAttribute("upsCheck", upsCheck);
		return "duty/upsdutymonth/slhups/update";
	}
	
	/**
	 * 更新记录
	 * @author renyujuan
	 * @date 2016年7月26日下午4:13:58
	 * @param sLHUpsMonthAddForm
	 * @param id
	 * @param termialV
	 * @param interR
	 * @param remarks
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="update.do" , method=RequestMethod.POST)
	public String updateUpsCheck(@ModelAttribute("pageModel") UpsMonthAddForm sLHUpsMonthAddForm,
			@RequestParam("termialV") List<String> termialV,
			@RequestParam("interR") List<String> interR,
			@RequestParam("remarks") List<String> remarks,
			@RequestParam("upsCheckId") String upsCheckId,
			HttpServletRequest request, Model model) throws IOException{
		try {
			EnvironmentEquipCheck upsCheck=upsCheckService.findById(upsCheckId);
			//System.err.println(upsCheck.getId());
			upsCheckService.update(upsCheck,sLHUpsMonthAddForm,termialV,interR,remarks);
			//addSuccess(model, "更新\"ups设备检查\"记录成功");
		    //super.addLog(request, "更新\"ups设备检查\"记录成功");
			model.addAttribute("returnStr",
					new ResultModel(true, "更新ups月检记录成功", sLHUpsMonthAddForm).toJson());
		} catch (Exception e) {
			//addError(model, "更新\"ups设备检查\"记录失败：" + e.getMessage());
			logger.error("添加记录失败!", e);
			model.addAttribute("returnStr", new ResultModel(false, "添加ups月检记录失败",
					sLHUpsMonthAddForm).toJson());
			return "returnnote";
		}
		return "returnnote";
	}
	
	/**
	 * 获取设备名称枚举类并返回
	 * @author renyujuan
	 * @date 2016年8月1日下午2:34:08
	 * @param queryModel
	 * @param optType
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "ajaxEquip.dox", method = RequestMethod.GET)
	public String ajaxEquip(@ModelAttribute("queryModel") EnvironmentCheckQueryModel queryModel, 
			@RequestParam("optType") String optType,
			HttpServletRequest request, Model model) throws IOException {
		switch(optType == null ? "" : optType) {
		case "slhUpsCheck":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(SlhUpsName.values()));
			break;
		case "kuUpsCheck":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(KuUpsName.values()));
			break;
		case "txjdUpsCheck":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(TxjdUpsName.values()));
			break;
		case "zjUpsCheck":
			model.addAttribute("returnStr", JacksonTools.toJsonStr(ZjUpsName.values()));
			break;
		default:
			model.addAttribute("returnStr", JacksonTools.toJsonStr(SlhUpsName.values()));
			break;
		}
		return "returnnote";
	}
	
	
}
