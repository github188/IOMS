/**
 * 
 */
package cn.com.atnc.ioms.web.techsupport.fault.record;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.ioms.entity.techsupport.fault.FaultDeclareOptLog;
import cn.com.atnc.ioms.enums.techsupport.fault.AllStatus;
import cn.com.atnc.ioms.enums.techsupport.fault.DeclareType;
import cn.com.atnc.ioms.enums.techsupport.fault.FaultStatus;
import cn.com.atnc.ioms.enums.techsupport.fault.FaultType;
import cn.com.atnc.ioms.mng.techsupport.IFaultDeclareOptLogService;
import cn.com.atnc.ioms.mng.techsupport.IFaultDeclareService;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareRecordQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * TODO：故障申报跳转控制类
 * 
 * @author KuYonggang
 * @date 2014-4-3下午4:44:07
 * @version 1.0
 */
@Controller("recordController")
@RequestMapping("/techsupport/fault/record/")
public class RecordController extends MyBaseController {
	
	@Autowired
	private IFaultDeclareService faultDeclareService;
	@Autowired
	private IFaultDeclareOptLogService faultDeclareOptLogService;
	
	//页面初始化
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(@ModelAttribute("queryModel") FaultDeclareRecordQueryModel queryModel,HttpServletRequest request,Model model) {
		super.pageInfo(model, request);
		model.addAttribute("faultType",FaultType.values());
		model.addAttribute("faultStatus", FaultStatus.values());
		return "techsupport/fault/record/manage";
	}
	//查询
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(@ModelAttribute("queryModel") FaultDeclareRecordQueryModel queryModel,HttpServletRequest request,Model model) {
		//网控中心人员查看记录时不用查看已新增和已修改的记录
		List<AllStatus> statusList = new ArrayList<AllStatus>();
		statusList.add(AllStatus.OPEN);
		statusList.add(AllStatus.ASSIGNED);
		statusList.add(AllStatus.FINISHED);
		statusList.add(AllStatus.RESOLVED);
		statusList.add(AllStatus.RESOLVED_OPEN);
		statusList.add(AllStatus.SOLVED);
		statusList.add(AllStatus.SOLVED_OPEN);
		statusList.add(AllStatus.TRANSFERRED);
		queryModel.setStatusList(statusList);
		queryModel.setDeclareType(DeclareType.FAULTDECLARE);
		String optClientLike = queryModel.getOptClientLike();
		if(StringUtils.contains(optClientLike, "%")){
			optClientLike = optClientLike.replace("%", "\\%");
		}
		if (StringUtils.contains(optClientLike, "_")) {
			optClientLike = optClientLike.replace("_", "\\_");
		}
		queryModel.setOptClientLike(optClientLike);
		model.addAttribute("pagn",faultDeclareService.queryPageByParam(queryModel));
		return "techsupport/fault/record/queryResult";
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
	public String setupDetailForm(@RequestParam("id")String id,HttpServletRequest request, Model model) {
		List<FaultDeclareOptLog> faultDeclareOptLogs = faultDeclareOptLogService.findByFaultDeclareId(id);
		model.addAttribute("faultDeclareOptLogs",faultDeclareOptLogs);
		model.addAttribute("pageModel",faultDeclareService.getFaultDeclareByID(id));
		return "techsupport/fault/record/detail";
	}
	
}
