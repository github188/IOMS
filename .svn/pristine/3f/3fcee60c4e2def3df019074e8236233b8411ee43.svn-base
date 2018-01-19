package cn.com.atnc.ioms.web.maintain.alarminfo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.maintain.alarminfo.IStatusAlarmHistoryDao;
import cn.com.atnc.ioms.entity.maintain.alarminfo.LinkAlarm;
import cn.com.atnc.ioms.entity.maintain.alarminfo.StatusAlarm;
import cn.com.atnc.ioms.entity.maintain.alarminfo.StatusAlarmHistory;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.mng.maintain.alarminfo.IFTPAlarmManager;
import cn.com.atnc.ioms.mng.maintain.alarminfo.ILinkAlarmHistoryManager;
import cn.com.atnc.ioms.mng.maintain.alarminfo.ILinkAlarmManager;
import cn.com.atnc.ioms.mng.maintain.alarminfo.ILinkAlarmMonitorManager;
import cn.com.atnc.ioms.mng.maintain.alarminfo.IStatusAlarmHistoryManager;
import cn.com.atnc.ioms.mng.maintain.alarminfo.IStatusAlarmManager;
import cn.com.atnc.ioms.mng.maintain.alarminfo.IStatusAlarmMonitorManager;
import cn.com.atnc.ioms.mng.maintain.equip.IMaintainEquipManager;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

 /**
 * 告警信息控制器
 *
 * @author wangzhicheng
 * @date 2015-4-27 下午2:30:48
 * @since 1.0.0
 */
@Controller("alarmInfoController")
@RequestMapping("/maintain/alarminfo/")
public class AlarmInfoController extends MyBaseController{
	
	@Autowired
	private ILinkAlarmManager linkAlarmManager;
	@Autowired
	private ILinkAlarmMonitorManager alarmMonitorManager;
	@Autowired
	private ILinkAlarmHistoryManager linkAlarmHistoryManager;
	@Autowired
	private IStatusAlarmManager statusAlarmManager;
	@Autowired
	private IStatusAlarmMonitorManager statusAlarmMonitorManager;
	@Autowired
	private IStatusAlarmHistoryDao dao;
	@Autowired
	private IStatusAlarmHistoryManager statusAlarmManagerHistory;
	@Autowired
	private IMaintainEquipManager maintainEquipManager;
	@Autowired
	private IFTPAlarmManager ftpAlarmManager;
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") AlarmInfoQueryModel queryModel,
			HttpServletRequest request, Model model) {
		model.addAttribute("bureauList", Bureau.values());
		super.pageInfo(model, request);
		return "maintain/alarminfo/manage";
	}

	/**
	 * 对tab页进行操作
	 *
	 * @param queryModel
	 * @param optType
	 * @param request
	 * @param model
	 * @param session
	 * @return
	 * @throws ServiceException 
	 * @date  2015-5-4下午2:59:01
	 * @since 1.0.0
	*/
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(@ModelAttribute("queryModel") AlarmInfoQueryModel queryModel,
			@RequestParam("optType")String optType,HttpServletRequest request, Model model, HttpSession session) throws ServiceException {

		switch (optType==null?"":optType) {
			
		case "LKAM":
			//链路告警
			model.addAttribute("message","LKAM");
			model.addAttribute("pagn", alarmMonitorManager.queryPage(queryModel));
			/*session.setAttribute("alarmInfoQueryModel", queryModel);*/
			return "maintain/alarminfo/linkalarm/queryResult";

		case "STAM":
			//状态告警
			model.addAttribute("message","STAM");
			/*List<StatusAlarm> sali = (List<StatusAlarm>) statusAlarmManager.queryPage(queryModel).getResult();
			List<AlarmInfoQueryModel> amlqm = statusAlarmManager.dealAIQList(sali,queryModel);
			Pagination page3 = statusAlarmManager.queryPage(queryModel);
			page3.setResult(amlqm);*/
			model.addAttribute("pagn", statusAlarmMonitorManager.queryPage(queryModel));
			
			session.setAttribute("alarmInfoQueryModel", queryModel);
			return "maintain/alarminfo/statusalarm/queryResult";
			
		case "FTPAM":
			//站点告警
			model.addAttribute("message","FTPAM");
			model.addAttribute("pagn", ftpAlarmManager.queryPage(queryModel));
			return "maintain/alarminfo/ftpalarm/queryResult";

		default:
			//链路告警
			model.addAttribute("message","LKAM");
			model.addAttribute("pagn", alarmMonitorManager.queryPage(queryModel));
			session.setAttribute("alarmInfoQueryModel", queryModel);
			return "maintain/alarminfo/linkalarm/queryResult";
		}
	}
	
	/**
	 * 链路告警详情
	 *
	 * @param id
	 * @param model
	 * @param session
	 * @return
	 * @throws ServiceException 
	 * @date  2015-5-5下午3:58:59
	 * @since 1.0.0
	*/
	@RequestMapping(value = "/linkalarmview.do")
	public String linkAlarmView(@RequestParam("id") String id, Model model, HttpSession session) throws ServiceException {
		
		model.addAttribute("pageModel", linkAlarmManager.findByMaintainEquipId(id));
		
		return "maintain/alarminfo/linkalarm/view";
	}
	
	/**
	 * 状态告警详情
	 *
	 * @param id
	 * @param model
	 * @param session
	 * @return
	 * @throws ServiceException 
	 * @date  2015-5-5下午3:58:59
	 * @since 1.0.0
	*/
	@RequestMapping(value = "/statusalarmview.do")
	public String statusAlarmView(@RequestParam("id") String id, Model model, HttpSession session) throws ServiceException {
		
		List<StatusAlarm> list = statusAlarmManager.findListByMaintainEquipId(id);
		if(list.size()>0){
			model.addAttribute("pageModel", list.get(0));
		}
		
		return "maintain/alarminfo/statusalarm/view";
	}
	
	/**
	 * 链路告警历史
	 *
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return 
	 * @date  2015-4-30上午11:35:56
	 * @since 1.0.0
	*/
	@RequestMapping(value = "/linkalarmhistory.do", method = RequestMethod.GET)
	public String linkAlarmHistory(
			@ModelAttribute("queryModel") AlarmInfoQueryModel queryModel,
			HttpServletRequest request, Model model) {
		return "maintain/alarminfo/linkalarm/history";
	}
	
	@RequestMapping(value = "/linkalarmhistory.do",method=RequestMethod.POST)
	public String linkAlarmHistory2(
			@ModelAttribute("queryModel") AlarmInfoQueryModel queryModel,
			HttpServletRequest request, Model model) throws ServiceException {
		model.addAttribute("pagn", linkAlarmHistoryManager.queryPage(queryModel));
		return "maintain/alarminfo/linkalarm/historyResult";
	}
	
	/**
	 * 状态告警历史
	 *
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return 
	 * @date  2015-4-30上午11:35:56
	 * @since 1.0.0
	*/
	@RequestMapping(value = "/statusalarmhistory.do", method = RequestMethod.GET)
	public String statusAlarmHistory(
			@ModelAttribute("queryModel") AlarmInfoQueryModel queryModel,
			HttpServletRequest request, Model model) {
	    return "maintain/alarminfo/statusalarm/history";
	}
	
	@RequestMapping(value = "/statusalarmhistory.do",method=RequestMethod.POST)
	public String statusAlarmHistory2(
			@ModelAttribute("queryModel") AlarmInfoQueryModel queryModel,
			HttpServletRequest request, Model model) throws ServiceException {
		//根据ID查找对应设备实体
		MaintainEquip maintainEquip = maintainEquipManager.findById(queryModel.getEquipId().getId());
		queryModel.setEquipId(maintainEquip);
		model.addAttribute("pagn", statusAlarmManagerHistory.queryPage(queryModel));
		return "maintain/alarminfo/statusalarm/historyResult";
	}
	
}
