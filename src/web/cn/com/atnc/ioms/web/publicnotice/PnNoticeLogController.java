package cn.com.atnc.ioms.web.publicnotice;

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

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.publicnotice.PnNotice;
import cn.com.atnc.ioms.enums.publicnotice.PnNoticeColumnEnum;
import cn.com.atnc.ioms.enums.publicnotice.PnNoticeStatusEnum;
import cn.com.atnc.ioms.mng.publicnotice.IPnNoticeOptLogManager;
import cn.com.atnc.ioms.mng.publicnotice.IPublicNoticeManager;
import cn.com.atnc.ioms.model.publicnotice.PnNoticeOptLogQueryModel;
import cn.com.atnc.ioms.model.publicnotice.PublicNoticeQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * @author:lizhisheng
 * @date:2014-5-5 下午4:49:11
 * @version:1.0
 */
@Controller
@RequestMapping("/publicnotice/pnlog")
public class PnNoticeLogController extends MyBaseController {
	@Autowired
	private IPublicNoticeManager publicNoticeManager;
	
	@Autowired
	private IPnNoticeOptLogManager pnNoticeOptLogManager;
	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") PublicNoticeQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		model.addAttribute("pnNoticeColumnEnum", PnNoticeColumnEnum.values());
		model.addAttribute("pnNoticeStatusEnum",PnNoticeStatusEnum.values());
		return "publicnotice/pnnoticelog/manage";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(HttpServletRequest request,
			@ModelAttribute("queryModel") PublicNoticeQueryModel queryModel,
			Model model) {
		User user = getCurrentUser(request);
		model.addAttribute("pagn", this.publicNoticeManager.queryPage(queryModel));
		return "publicnotice/pnnoticelog/queryResult";
	}
	@RequestMapping(value = "/detail.dox")
	public String detail(HttpServletRequest request,
			@RequestParam("id") String id,
			@ModelAttribute("queryModel") PnNoticeOptLogQueryModel queryModel,
			Model model) {
		PnNotice pnNotice = publicNoticeManager.findById(id);
		queryModel.setPnNotice(pnNotice);
		model.addAttribute("pagn", this.pnNoticeOptLogManager.findByPnNoticeOptLogId(id));
		return "publicnotice/pnnoticelog/queryResult";
	}
	/**
	 * 
	 * 方法说明：审批日志
	 * 
	 * @param session
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 * 
	 */
	@RequestMapping(value = "log.dox")
	public String log(@RequestParam("id") String id,
			HttpSession session, HttpServletRequest request, Model model)
			throws IOException {
		model.addAttribute("pnnoticeOptLogs",
				pnNoticeOptLogManager.findByPnNoticeOptLogId(id));
		return "publicnotice/log";
	}
}
