package cn.com.atnc.ioms.web.systemmng.timecontrol;

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

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.systemmng.deptinfomng.DeptInfomationMng;
import cn.com.atnc.ioms.entity.turndutymng.TimeControl;
import cn.com.atnc.ioms.enums.turndutymng.TimeAmHourEnum;
import cn.com.atnc.ioms.enums.turndutymng.TimePmHourEnum;
import cn.com.atnc.ioms.mng.turndutymng.ITimeControlService;
import cn.com.atnc.ioms.web.MyBaseController;
/**
 * 
 * @author hantianyu
 *
 */
@Controller("TimeControlController")
@RequestMapping("systemmng/timecontrol/")
public class TimeControlController extends MyBaseController{
    
	@Autowired
	private ITimeControlService timeControlService;
	/**
     * 
     * @Author:hantianyu 
     * @Title:manage
     * @Description:TODO
     * @Param:@param pageModel
     * @Param:@param model
     * @Param:@param request
     * @Param:@return
     * @Return:String
     * @Creatime:2016年10月12日 下午12:41:18
     */
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("pageModel")  TimeControl pageModel,
			Model model, HttpServletRequest request) {
		
		List<TimeAmHourEnum> amhours=Arrays.asList(TimeAmHourEnum.values());
		List<TimePmHourEnum> pmhours=Arrays.asList(TimePmHourEnum.values());
		model.addAttribute("amhours", amhours);
		model.addAttribute("pmhours", pmhours);
		model.addAttribute("timeControl", timeControlService.getTimeControl());
    	super.pageInfo(model, request);
		
		
		return "systemmng/timecontrol/manage";
	}
	
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:processAddNews
	 * @Description:TODO
	 * @Param:@param pageModel
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Param:@throws IOException
	 * @Return:String
	 * @Creatime:2016年10月12日 下午12:41:24
	 */
	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
    public String processAddNews(@ModelAttribute("pageModel") TimeControl pageModel,
    		HttpServletRequest request, Model model) throws IOException{
    	User user = getCurrentUser(request);
    	pageModel.setCreater(user);
    	pageModel.setCreatime(new Date());
    	timeControlService.mod(pageModel);
    	
    	model.addAttribute("timeControl", timeControlService.getTimeControl());
    	model.addAttribute("returnStr", "{\"result\":true,\"msg\":\""
				+ "更新成功！" + "\"}");
        super.addLog(request, "更新成功！");
    	return "returnnote";
	}
}
