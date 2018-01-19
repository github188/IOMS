/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-23 下午5:23:05
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.web.basedata.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.enums.clientnotice.NoticeType;
import cn.com.atnc.ioms.mng.systemmng.param.ISystemConfigManager;
import cn.com.atnc.ioms.model.systemmng.param.SystemParamsModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * @author:HuangYijie
 * @date:2014-4-23 下午5:23:05
 * @version:1.0
 */
@Controller
@RequestMapping("/basedata/param")
public class SatelliteParamsConfigController extends MyBaseController {
	@Autowired
	@Qualifier(value = "SystemConfigDBManagerImpl")
	private ISystemConfigManager systemConfigManager;

	@RequestMapping(value = "/config.do", method = RequestMethod.GET)
	public String config(Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		try {
			model.addAttribute("pageModel", systemConfigManager.getModel());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			super.addError(model, e.getMessage());
		}
		return "basedata/param/config";
	}

	@RequestMapping(value = "/config.do", method = RequestMethod.POST)
	public String doConfig(
			@ModelAttribute("pageModel") SystemParamsModel paramsModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		try {

			model.addAttribute("pageModel", paramsModel);
			super.addLog(request, systemConfigManager.update(paramsModel));
			super.addSuccess(model, "配置卫星采集参数成功！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			super.addError(model, e.getMessage());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			super.addError(model, e.getMessage());
		}
		return "basedata/param/config";
	}
}
