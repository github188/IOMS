package cn.com.atnc.ioms.web.systemmng.clientnotice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.atnc.ioms.enums.clientnotice.NoticeState;
import cn.com.atnc.ioms.enums.clientnotice.NoticeType;
import cn.com.atnc.ioms.mng.clientnotice.IClientNoticeManager;
import cn.com.atnc.ioms.model.clientnotice.ClientNoticeQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * @author lizhisheng
 * @date:2014-4-21上午10:55:34
 */
@Controller
 @RequestMapping("/systemmng/clientnotice")
public class ClientNoticeController extends MyBaseController {
	@Autowired
	private IClientNoticeManager clientNoticeManager;

	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") ClientNoticeQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		model.addAttribute("noticeState", NoticeState.values());
		model.addAttribute("noticeType", NoticeType.values());
		return "systemmng/clientnotice/manage";
	}

	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") ClientNoticeQueryModel queryModel,
			Model model) {
		model.addAttribute("pagn", this.clientNoticeManager.queryPage(queryModel));
		return "systemmng/clientnotice/queryResult";
	}
}
