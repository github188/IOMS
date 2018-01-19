/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-6-17 下午4:10:21
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.web.systemmng.sms;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.ioms.mng.clientnotice.sms.ISMSService;
import cn.com.atnc.ioms.model.systemmng.sms.SmsModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * @author:HuangYijie
 * @date:2014-6-17 下午4:10:21
 * @version:1.0
 */
@Controller
@RequestMapping("/systemmng/sms")
public class SmsController extends MyBaseController {

	@Autowired
	private ISMSService smsService;

	@RequestMapping(value = "/send.do", method = RequestMethod.GET)
	public String send(@ModelAttribute("pageModel") SmsModel smsModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		return "systemmng/sms/send";
	}

	@RequestMapping(value = "/send.do", method = RequestMethod.POST)
	public String doSend(@ModelAttribute("pageModel") SmsModel smsModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		try {
			if (smsService.sendSMS(smsModel.getMobile(), smsModel.getContent())) {
				super.addSuccess(model, "发送成功！");
			} else {
				super.addError(model, "发送失败");
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			super.addSuccess(model, "发送失败！" + e.getMessage());
		}
		return "systemmng/sms/send";
	}

	@RequestMapping(value = "/connect.dox")
	public String connect(Model model, HttpServletRequest request) {
		try {
			smsService.startService();
			model.addAttribute("returnStr", "启动成功！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			model.addAttribute("returnStr", "启动失败！" + e.getMessage());
		}
		return "returnnote";
	}

	@RequestMapping(value = "/close.dox")
	public String close(Model model, HttpServletRequest request) {
		try {
			
			smsService.stopService();
			model.addAttribute("returnStr", "停止成功！");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			model.addAttribute("returnStr", "停止失败！" + e.getMessage());
		}
		return "returnnote";
	}

	@RequestMapping(value = "/status.dox")
	public String status(Model model, HttpServletRequest request) {
		model.addAttribute("returnStr", smsService.getServiceStatus().name());
		return "returnnote";
	}

}
