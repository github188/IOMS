package cn.com.atnc.ioms.web.phonemng;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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

import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.phonemng.CallIsDel;
import cn.com.atnc.ioms.mng.phonemng.ICallInfoService;
import cn.com.atnc.ioms.model.phonemng.CallInformationQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 
 * @author hantianyu
 *
 */
@Controller("CallControlController")
@RequestMapping("phonemng/callcontrol")
public class CallControlController extends MyBaseController {
	@Autowired
	private ICallInfoService callInfoService;

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getMissedList
	 * @Description:TODO
	 * @Param:@param queryModel
	 * @Param:@param model
	 * @Param:@param request
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年8月25日 上午10:29:43
	 */
	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String getManage(
			@ModelAttribute("queryModel") CallInformationQueryModel queryModel,
			Model model, HttpServletRequest request) {
		try {

			User user = getCurrentUser(request);
			super.pageInfo(model, request);

			model.addAttribute("names", callInfoService.getNameList(queryModel));
			String username = user.getName();
			model.addAttribute("username", username);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "systemmng/callcontrol/manage";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:postManage
	 * @Description:TODO
	 * @Param:@param queryModel
	 * @Param:@param model
	 * @Param:@param request
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年8月25日 下午5:26:04
	 */
	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String postManage(
			@ModelAttribute("queryModel") CallInformationQueryModel queryModel,
			Model model, HttpServletRequest request) {
		try {

			User user = getCurrentUser(request);
			super.pageInfo(model, request);

			String username = user.getName();
			model.addAttribute("username", username);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "systemmng/callcontrol/manage";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:initAtmAlarm
	 * @Description:加载堆叠图图表
	 * @Param:@param model
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年8月25日 下午5:25:29
	 */
	@RequestMapping(value = "/initCallCount.dox")
	public String initAtmAlarm(Model model,
			@RequestParam("stime") String stime,
			@RequestParam("etime") String etime,
			CallInformationQueryModel queryModel) {
		try {

			queryModel.setRingingTime(stime);
			queryModel.setPickupTime(etime);

			try {
				model.addAttribute("returnStr", JacksonTools
						.toJsonStr(callInfoService.getCountList(queryModel)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				model.addAttribute("returnStr", "[]");
				e.printStackTrace();
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";

	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:initPie
	 * @Description:饼图
	 * @Param:@param model
	 * @Param:@param name
	 * @Param:@param type
	 * @Param:@param date
	 * @Param:@param queryModel
	 * @Param:@param request
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年8月26日 下午3:30:14
	 */
	@RequestMapping(value = "/pie.dox")
	public String initPie(Model model, @RequestParam("name") String name,
			@RequestParam("type") String type,
			@RequestParam("date") String date,
			CallInformationQueryModel queryModel, HttpServletRequest request) {
		try {

			String engname = "";
			try {
				engname = new String(request.getParameter("name").getBytes(
						"ISO-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.err.println(engname + "---" + type + "---" + date);
			queryModel.setUserName(engname);
			if (!StringUtils.isEmpty(date)) {
				// 不为空
				queryModel.setCallendTime(date);
			} else {
				// 为空
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date date1 = new Date();
				queryModel.setCallendTime(format.format(date1));
			}
			try {
				model.addAttribute("returnStr", JacksonTools
						.toJsonStr(callInfoService
								.getCountPieByName(queryModel)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				model.addAttribute("returnStr", "[]");
				e.printStackTrace();
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";

	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:initLineCount
	 * @Description:线图
	 * @Param:@param model
	 * @Param:@param stime
	 * @Param:@param etime
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年8月26日 下午3:31:41
	 */
	@RequestMapping(value = "/initLineCount.dox")
	public String initLineCount(Model model,
			@RequestParam("stime") String stime,
			@RequestParam("etime") String etime,
			CallInformationQueryModel queryModel) {
		try {

			queryModel.setRingingTime(stime);
			queryModel.setPickupTime(etime);

			try {
				model.addAttribute("returnStr", JacksonTools
						.toJsonStr(callInfoService
								.getLineChartByName(queryModel)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				model.addAttribute("returnStr", "[]");
				e.printStackTrace();
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";

	}
}
