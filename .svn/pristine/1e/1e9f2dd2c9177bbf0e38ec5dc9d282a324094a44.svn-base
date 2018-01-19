/**
 * 
 */
package cn.com.atnc.ioms.web.techsupport.consult.record;

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
import cn.com.atnc.ioms.enums.techsupport.consult.ConsultStatus;
import cn.com.atnc.ioms.enums.techsupport.fault.AllStatus;
import cn.com.atnc.ioms.enums.techsupport.fault.DeclareType;
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
@Controller("consultRecordController")
@RequestMapping("/techsupport/consult/record/")
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
		model.addAttribute("consultStatus", ConsultStatus.values());
		return "techsupport/consult/record/manage";
	}
	//查询
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(@ModelAttribute("queryModel") FaultDeclareRecordQueryModel queryModel,HttpServletRequest request,Model model) {
		//网控中心人员查看记录时不用查看已新增和已修改的记录
		List<AllStatus> statusList = new ArrayList<AllStatus>();
		statusList.add(AllStatus.REPLIED);//已回复
		statusList.add(AllStatus.CLOSED);//已关闭
		statusList.add(AllStatus.SUBMITTED);//已提交
		statusList.add(AllStatus.ADDED);//已追加
		statusList.add(AllStatus.CHANGED);//已转咨询
		queryModel.setStatusList(statusList);
		queryModel.setDeclareType(DeclareType.TECHCONSULT);
		String optClientLike = queryModel.getOptClientLike();
		if(StringUtils.contains(optClientLike, "%")){
			optClientLike = optClientLike.replace("%", "\\%");
		}
		if (StringUtils.contains(optClientLike, "_")) {
			optClientLike = optClientLike.replace("_", "\\_");
		}
		queryModel.setOptClientLike(optClientLike);
		//System.out.println("optClientLike:"+optClientLike);
		model.addAttribute("pagn",faultDeclareService.queryPageByParam(queryModel));
		return "techsupport/consult/record/queryResult";
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
		return "techsupport/consult/record/detail";
	}
}
