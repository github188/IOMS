package cn.com.atnc.ioms.web.phonemng;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.phonemng.CallInformation;
import cn.com.atnc.ioms.entity.phonemng.ContactsMng;
import cn.com.atnc.ioms.enums.phonemng.AtncCallTypeEnum;
import cn.com.atnc.ioms.enums.phonemng.CallStateEnum;
import cn.com.atnc.ioms.enums.phonemng.CallTypeEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;
import cn.com.atnc.ioms.mng.phonemng.ICallInfoService;
import cn.com.atnc.ioms.mng.phonemng.impl.CallInfoServiceImpl;
import cn.com.atnc.ioms.mng.turndutymng.ISignLeaveService;
import cn.com.atnc.ioms.model.phonemng.CallInformationQueryModel;
import cn.com.atnc.ioms.model.tempcircuit.TempCircuitQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

@Controller("QuerymngController")
@RequestMapping("phonemng/")
public class QuerymngController extends MyBaseController {
	@Autowired
	private ICallInfoService callInfoService;
	@Autowired
	private ISignLeaveService signLeaveService;

	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-18下午3:31:18
	 * @param queryModel
	 * @param model
	 * @param request
	 * @return String TODO 呼叫中心查询统计 get
	 */
	@RequestMapping(value = "querymng/manage.do", method = RequestMethod.GET)
	public String getEventCount(
			@ModelAttribute("queryModel") CallInformationQueryModel queryModel,
			Model model, HttpServletRequest request) {
		try {

			super.pageInfo(model, request);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/querymng/manage";
	}

	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-18下午3:31:44
	 * @param queryModel
	 * @param optType
	 * @param model
	 * @return
	 * @throws IOException
	 *             String TODO 呼叫中心查询统计 post
	 */
	@RequestMapping(value = "querymng/manage.do", method = RequestMethod.POST)
	public String postEventCount(
			@ModelAttribute("queryModel") CallInformationQueryModel queryModel,
			@RequestParam("optType") String optType,
			HttpServletRequest request, Model model) throws IOException {

		Pagination pagn = null;
		User user = getCurrentUser(request);
		model.addAttribute("username", user.getName());
		// 判断当前用户是否是值班经理
		if (signLeaveService.isMangerByUser(user)) {
			// 是
			model.addAttribute("isManager", "yes");
		} else {
			model.addAttribute("isManager", "no");
		}
		switch (optType == null ? "" : optType) {
		case "CALL":
			try {

				// 普通来电
				queryModel.setCallType(CallTypeEnum.NORMAL);

				pagn = callInfoService.queryPage(queryModel);
				model.addAttribute("pagn", pagn);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			return "phonemng/querymng/normalcall/queryResult";
		case "OUTBOUND":
			// 外呼
			try {

				queryModel.setCallType(CallTypeEnum.DIALOUT);
				pagn = callInfoService.queryPage(queryModel);
				model.addAttribute("pagn", pagn);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			return "phonemng/querymng/dialoutcall/queryResult";
		case "TRANSFER":
			// 转接
			try {

				queryModel.setCallType(CallTypeEnum.TRANSFER);
				pagn = callInfoService.queryPage(queryModel);
				model.addAttribute("pagn", pagn);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			return "phonemng/querymng/transfercall/queryResult";
		case "OTHER":
			try {

				queryModel.setSpare2("其他");
				pagn = callInfoService.queryPage(queryModel);
				model.addAttribute("pagn", pagn);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			return "phonemng/querymng/other/queryResult";

		default:
			try {

				queryModel.setCallType(CallTypeEnum.NORMAL);
				pagn = callInfoService.queryPage(queryModel);
				model.addAttribute("pagn", pagn);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
			return "phonemng/querymng/normalcall/queryResult";
		}
	}

	/**
	 * 电话记录归类
	 * 
	 * @author 韩天驭
	 * @2017年1月5日 下午3:26:10
	 * @param ids
	 *            电话id
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "querymng/classify.do", method = RequestMethod.GET)
	public String getDoClassify(@RequestParam("ids") String ids,
			@ModelAttribute("pageModel") CallInformation pageModel,
			HttpServletRequest request, Model model) {
		try {

			super.pageInfo(model, request);
			model.addAttribute("ids", ids);

			List<AtncCallTypeEnum> typeList = Arrays.asList(AtncCallTypeEnum
					.values());
			model.addAttribute("typeList", typeList);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/querymng/normalcall/classify";
	}

	/**
	 * 归类
	 * 
	 * @author 韩天驭
	 * @2017年1月5日 下午5:34:25
	 * @param ids
	 *            选中id
	 * @param callInformation
	 *            通话记录实体
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "querymng/classify.do", method = RequestMethod.POST)
	public String DoClassify(@RequestParam("ids") String ids,
			@ModelAttribute("pageModel") CallInformation callInformation,
			HttpServletRequest request, Model model) {
		try {

			User user = getCurrentUser(request);

			try {
				callInfoService.callClassify(callInformation, ids.split(","),
						user);
				super.addLog(request, "归类成功！");
				model.addAttribute("returnStr", new ResultModel(true, "归类成功",
						null).toJson());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";
	}
	/**
	 * 
	 * @author 韩天驭
	 * @2017年1月9日 下午2:56:18
	 * @param starttime
	 * @param endtime
	 * @param username
	 * @param type
	 * @param request
	 * @param model
	 * @return String
	 * @throws UnsupportedEncodingException
	 */
	/*
	 * @RequestMapping(value = "querymng/counttimes.do", method =
	 * RequestMethod.GET) public String DoCount(@RequestParam("starttime")
	 * String starttime,
	 * 
	 * @RequestParam("endtime") String endtime,
	 * 
	 * @RequestParam("username") String username,
	 * 
	 * @RequestParam("type") String type, HttpServletRequest request, Model
	 * model) throws UnsupportedEncodingException {
	 * System.err.println("phonemng/querymng/counttimes.do"); String name="";
	 * name = new String(username .getBytes("ISO-8859-1"), "utf-8");
	 * Map<Integer,List<String>> callMap=callInfoService.CountTimes(name,
	 * starttime, endtime, type); model.addAttribute("callMap", callMap); return
	 * "phonemng/querymng/count/queryResult1";
	 * 
	 * }
	 */
}
