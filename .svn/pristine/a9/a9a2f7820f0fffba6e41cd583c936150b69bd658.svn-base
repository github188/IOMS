/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-5-29 下午1:42:58
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.web.operstat.ku;

import java.io.IOException;

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
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.enums.basedata.KuServiceRateType;
import cn.com.atnc.ioms.mng.basedata.ku.IKuServiceManager;
import cn.com.atnc.ioms.mng.operstat.ku.IKuStatusStatManager;
import cn.com.atnc.ioms.model.MyPaginModel;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;
import cn.com.atnc.ioms.model.operstat.ku.KuStatusLogQueryModel;
import cn.com.atnc.ioms.model.operstat.ku.KuStatusQueryModel;
import cn.com.atnc.ioms.model.operstat.ku.KuStatusStatQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * @author:HuangYijie
 * @date:2014-5-29 下午1:42:58
 * @version:1.0
 */
@RequestMapping(value = "/operstat/ku")
@Controller
public class KuOperStatController extends MyBaseController {
	@Autowired
	private IKuStatusStatManager statManager;
	@Autowired
	private IKuServiceManager kuServiceManager;

	@RequestMapping(value = "/stat/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") KuStatQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		model.addAttribute("kuStatType", "STAT");
		return "operstat/ku/stat/manage";
	}

	@RequestMapping(value = "/stat/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") KuStatQueryModel queryModel,
			Model model) throws IOException {
		Pagination pagn = statManager.queryStatPage(queryModel);
		model.addAttribute("pagn", pagn);
		model.addAttribute("kuStatType", "STAT");
		return "operstat/ku/stat/queryResult";
	}

	@RequestMapping(value = "/node/manage.do", method = RequestMethod.GET)
	public String nodeManager(
			@ModelAttribute("queryModel") KuStatusQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		//
		if (!StringTools.hasText(queryModel.getKuNodeStatusStatId())) {
			queryModel.setKuNodeStatusStatId(statManager.getLastStatId());

		}
		model.addAttribute("kuNodeStatusStat",
				statManager.findStatById(queryModel.getKuNodeStatusStatId()));
		model.addAttribute("kuNodeStatusStatId",
				queryModel.getKuNodeStatusStatId());
		return "operstat/ku/node/manage";
	}

	@RequestMapping(value = "/node/chart.dox")
	public String nodeStatChart(Model model, HttpServletRequest request,
			@RequestParam("id") String id) {
		try {
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(statManager.findStatById(id)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			model.addAttribute("returnStr", "");
		}
		return "returnnote";
	}

	@RequestMapping(value = "/node/manage.do", method = RequestMethod.POST)
	public String nodeManagerList(
			@ModelAttribute("queryModel") KuStatusQueryModel queryModel,
			Model model) throws IOException {
		Pagination pagn;
		try {
			pagn = statManager.queryDetailPage(queryModel);
			model.addAttribute("pagn", pagn);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			super.addError(model, e.getMessage());
			model.addAttribute("pagn", new Pagination());
		}
		return "operstat/ku/node/queryResult";
	}

	@RequestMapping(value = "/service/manage.do", method = RequestMethod.GET)
	public String serviceManager(
			@ModelAttribute("queryModel") KuStatQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		model.addAttribute("kuStatType", "SERVICE");
		model.addAttribute("kuServiceRateTypes", KuServiceRateType.values());
		return "operstat/ku/service/manage";
	}

	@RequestMapping(value = "/service/manage.do", method = RequestMethod.POST)
	public String serviceManageList(
			@ModelAttribute("queryModel") KuStatQueryModel queryModel,
			Model model, HttpSession session) {
		model.addAttribute("pagn", this.kuServiceManager.queryPage(queryModel));
		session.setAttribute("kuServiceQueryModel", queryModel);
		model.addAttribute("kuStatType", "SERVICE");
		return "operstat/ku/service/queryResult";
	}

	@RequestMapping(value = "/service/chart.do", method = RequestMethod.GET)
	public String chart(Model model, @RequestParam("ids") String ids) {
		model.addAttribute("ids", ids);
		return "operstat/ku/service/chart";
	}

	@RequestMapping(value = "/service/chart.do", method = RequestMethod.POST)
	public String getchart(Model model, @RequestParam("ids") String ids)
			throws IOException {
		model.addAttribute("returnStr",
				JacksonTools.toJsonStr(kuServiceManager.getChart(ids)));
		return "returnnote";
	}

	@RequestMapping(value = "/log/manage.do", method = RequestMethod.GET)
	public String nodeLog(HttpServletRequest request, HttpSession session,
			Model model, @ModelAttribute("queryModel") KuStatusLogQueryModel qm)
			throws IOException {
		model.addAttribute("kuNodeId", qm.getKuNodeId());
		return "operstat/ku/log/manage";
	}

	@RequestMapping(value = "/log/manage.do", method = RequestMethod.POST)
	public String getNodeLog(HttpServletRequest request, HttpSession session,
			Model model, @ModelAttribute("queryModel") KuStatusLogQueryModel qm) {
		model.addAttribute("pagn", statManager.queryLogPage(qm));
		return "operstat/ku/log/queryResult";
	}
}
