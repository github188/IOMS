package cn.com.atnc.ioms.web.phonemng;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.phonemng.CallInformation;
import cn.com.atnc.ioms.entity.phonemng.ContactsMng;
import cn.com.atnc.ioms.enums.phonemng.CallIsDel;
import cn.com.atnc.ioms.enums.phonemng.CallStateEnum;
import cn.com.atnc.ioms.enums.phonemng.CallTypeEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyRoleEnum;
import cn.com.atnc.ioms.mng.phonemng.ICallInfoService;
import cn.com.atnc.ioms.model.phonemng.CallInformationQueryModel;
import cn.com.atnc.ioms.model.phonemng.ContactsMngQueryModel;
import cn.com.atnc.ioms.model.tempcircuit.TempCircuitQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

@Controller("MissedCallController")
@RequestMapping("phonemng/")
public class MissedCallController extends MyBaseController {
	@Autowired
	private ICallInfoService callInfoService;

	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-18下午2:26:37
	 * @param queryModel
	 * @param model
	 * @param request
	 * @return String TODO 未接来电管理
	 */
	@RequestMapping(value = "missedcallmng/manage.do", method = RequestMethod.GET)
	public String getMissedList(
			@ModelAttribute("queryModel") CallInformationQueryModel queryModel,
			Model model, HttpServletRequest request) {
		try {

			User user = getCurrentUser(request);
			super.pageInfo(model, request);

			List<CallIsDel> dels = Arrays.asList(CallIsDel.values());
			model.addAttribute("isdel", dels);
			String username = user.getName();
			model.addAttribute("username", username);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/missedcallmng/manage";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:postMissedList
	 * @Description:未接
	 * @Param:@param queryModel
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Param:@throws IOException
	 * @Return:String
	 * @Creatime:2016年8月11日 下午2:04:25
	 */
	@RequestMapping(value = "missedcallmng/manage.do", method = RequestMethod.POST)
	public String postMissedList(
			@ModelAttribute("queryModel") CallInformationQueryModel queryModel,
			HttpServletRequest request, Model model) throws IOException {
		try {

			Pagination pagn = null;
			User user = getCurrentUser(request);

			queryModel.setCallState(CallStateEnum.NOTDEAL);
			pagn = callInfoService.queryPageMissedCall(queryModel);
			model.addAttribute("pagn", pagn);
			List<CallIsDel> dels = Arrays.asList(CallIsDel.values());
			model.addAttribute("isdel", dels);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/missedcallmng/queryResult";
	}

	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-18下午2:52:58
	 * @param queryModel
	 * @param model
	 * @param request
	 * @return String TODO 回拨
	 */
	@RequestMapping(value = "missedcallmng/popwindow.do", method = RequestMethod.GET)
	public String getAddFault(
			@ModelAttribute("queryModel") CallInformationQueryModel queryModel,
			Model model, HttpServletRequest request) {
		try {

			super.pageInfo(model, request);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/missedcallmng/popwindow";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:dellist
	 * @Description:批量删除
	 * @Param:@param idlist
	 * @Param:@param queryModel
	 * @Param:@param contactsMng
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年8月15日 下午2:42:27
	 */
	@RequestMapping(value = "missedcallmng/dellist.do")
	public String dellist(@RequestParam("idlist") String idlist,
			@ModelAttribute("queryModel") ContactsMngQueryModel queryModel,
			ContactsMng contactsMng, HttpServletRequest request, Model model) {
		try {

			System.err.println("dellist");

			if (StringUtils.isEmpty(idlist)) {
				model.addAttribute("returnStr", "{\"result\":false,\"msg\":\""
						+ "请选择要删除的通话记录！" + "\"}");

				return "returnnote";
			}
			callInfoService.callDelByIds(idlist.split(","));
			// contactsMngService.contactsUpdateStatus(idlist.split(","),"黑名单");
			model.addAttribute("returnStr", "{\"result\":true,\"msg\":\""
					+ "删除成功！" + "\"}");
			super.addLog(request, "删除通话记录成功！");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";

	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:processDeleteShift
	 * @Description:TODO
	 * @Param:@param id
	 * @Param:@param session
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年8月16日 上午9:34:44
	 */
	@RequestMapping(value = "missedcallmng/del.do", method = RequestMethod.POST)
	public String processDeleteShift(@RequestParam("id") String id,
			HttpSession session, HttpServletRequest request, Model model) {
		try {
			CallInformation callInfo = callInfoService.findViewById(id);

			model.addAttribute("vo", callInfoService.callDelById(callInfo));
			model.addAttribute("returnStr", "{\"result\":true,\"msg\":\""
					+ "删除成功！" + "\"}");
			super.addLog(request, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

}
