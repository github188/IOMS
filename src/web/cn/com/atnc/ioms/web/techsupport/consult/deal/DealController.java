/**
 * 
 */
package cn.com.atnc.ioms.web.techsupport.consult.deal;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.techsupport.fault.FaultDeclare;
import cn.com.atnc.ioms.entity.techsupport.fault.FaultDeclareOptLog;

import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.enums.techsupport.fault.DeclareType;
import cn.com.atnc.ioms.enums.techsupport.fault.AllStatus;
import cn.com.atnc.ioms.enums.techsupport.fault.OptType;
import cn.com.atnc.ioms.mng.techsupport.IFaultDeclareOptLogService;
import cn.com.atnc.ioms.mng.techsupport.IFaultDeclareService;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareDealQueryModel;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * TODO：故障申报跳转控制类
 * 
 * @author KuYonggang
 * @date 2014-4-3下午4:44:07
 * @version 1.0
 */
@Controller("consultDealController")
@RequestMapping("/techsupport/consult/deal/")
public class DealController extends MyBaseController {

	@Autowired
	private IFaultDeclareService faultDeclareService;
	@Autowired
	private IFaultDeclareOptLogService faultDeclareOptLogService;

	// 页面初始化
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(@ModelAttribute("queryModel") FaultDeclareDealQueryModel queryModel,
			HttpServletRequest request, Model model) {
		super.pageInfo(model, request);
		return "techsupport/consult/deal/manage";
	}

	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(@ModelAttribute("queryModel") FaultDeclareDealQueryModel queryModel,
			HttpServletRequest request, Model model) {
		List<AllStatus> statusList = new ArrayList<AllStatus>();
		statusList.add(AllStatus.SUBMITTED);
		statusList.add(AllStatus.ADDED);
		queryModel.setStatusList(statusList);
		queryModel.setDeclareType(DeclareType.TECHCONSULT);
		model.addAttribute("pagn",
				faultDeclareService.queryPageForDeal(queryModel));
		return "techsupport/consult/deal/queryResult";
	}
	/**
	 * 
	 * @throws IOException 
	 * @author：KuYonggang
	 * @date：2014-5-8下午3:41:16
	 * @param：
	 * @return：String
	 */
	@RequestMapping(value = "ajaxLoad.dox", method = RequestMethod.GET)
	public String ajaxLoad(@ModelAttribute("queryModel") FaultDeclareDealQueryModel queryModel,
			HttpServletRequest request, Model model) throws IOException {
		List<AllStatus> statusList = new ArrayList<AllStatus>();
		statusList.add(AllStatus.SUBMITTED);
		statusList.add(AllStatus.ADDED);
		queryModel.setStatusList(statusList);
		queryModel.setDeclareType(DeclareType.TECHCONSULT);
		model.addAttribute("returnStr",
				JacksonTools.toJsonStr(faultDeclareService.queryPageForDeal(queryModel)));
		return "returnnote";
	}
	/**
	 * 查看详情操作
	 * 
	 * @author：KuYonggang
	 * @date：2014-4-25下午2:00:03
	 * @param：
	 * @return：String
	 */
	@RequestMapping(value = "detail.do",method = RequestMethod.GET)
	public String setupDetailForm(HttpServletRequest request, Model model,
			@RequestParam("id")String id) {
		List<FaultDeclareOptLog> faultDeclareOptLogs = faultDeclareOptLogService.findByFaultDeclareId(id);
		model.addAttribute("faultDeclareOptLogs",faultDeclareOptLogs);
		model.addAttribute("pageModel",faultDeclareService.getFaultDeclareByID(id));
		return "techsupport/consult/deal/detail";
	}

	/**
	 *  回复操作
	 *  
	 * @author：KuYonggang
	 * @date：2014-4-25下午1:59:44
	 * @param：
	 * @return：String
	 */
	@RequestMapping(value = "reply.do",method = RequestMethod.GET)
	public String setupTakeForm(@ModelAttribute("pageModel")FaultDeclareQueryModel queryModel,
			HttpServletRequest request, Model model) {
		List<FaultDeclareOptLog> faultDeclareOptLogs = faultDeclareOptLogService.findByFaultDeclareId(queryModel.getId());
		model.addAttribute("faultDeclareOptLogs",faultDeclareOptLogs);
		model.addAttribute("faultDeclare",faultDeclareService.getFaultDeclareByID(queryModel.getId()));
		return "techsupport/consult/deal/reply";
	}

	@RequestMapping(value = "reply.do",method = RequestMethod.POST)
	public String processTakeForm(HttpServletRequest request, Model model,
			@RequestParam("id")String id,
			@RequestParam("descInfo")String descInfo) {

		User user = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
		FaultDeclare faultDeclare = faultDeclareService.getFaultDeclareByID(id);

		//保存操作日志信息
		FaultDeclareOptLog faultDeclareOptLog = new FaultDeclareOptLog();
		faultDeclareOptLog.setFromStatus(faultDeclare.getFaultStatus());
		faultDeclareOptLog.setToStatus(AllStatus.REPLIED);
		faultDeclareOptLog.setFaultDeclare(faultDeclare);
		faultDeclareOptLog.setOptUser(user);
		faultDeclareOptLog.setOptType(OptType.REPLY);
		faultDeclareOptLog.setOptTime(new Date());
		faultDeclareOptLog.setOptUserName(user.getName());
		faultDeclareOptLog.setOptUserDepartment(user.getDept());
		faultDeclareOptLog.setDescInfo(descInfo);
		faultDeclareOptLogService.save(faultDeclareOptLog);

		//更新故障申报处理记录
		faultDeclare.setFaultStatus(AllStatus.REPLIED);
		faultDeclare.setUpdateUser(user.getName());
		faultDeclare.setOperUser(user.getName());
		faultDeclare.setUser(user);
		faultDeclare.setUpdateTime(new Date());
		faultDeclareService.update(faultDeclare);

		addSuccess(model, "回复成功！");
		//添加操作日志
		super.addLog(request, "回复成功(咨询摘要:"+faultDeclare.getFaultKey()+")");
		return "techsupport/consult/deal/result";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdFormat, true));
	}
}
