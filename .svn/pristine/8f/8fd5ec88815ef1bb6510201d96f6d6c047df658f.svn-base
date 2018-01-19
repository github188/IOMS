package cn.com.atnc.ioms.web.phonemng;

import java.io.IOException;
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
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.phonemng.AtncCallTypeEnum;
import cn.com.atnc.ioms.enums.phonemng.CallTypeEnum;
import cn.com.atnc.ioms.mng.phonemng.ICallInfoService;
import cn.com.atnc.ioms.model.phonemng.CallInformationQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 呼叫中心统计
 *
 * @author 韩天驭
 * @2017年1月10日 下午3:59:39
 */
@Controller("CallCountController")
@RequestMapping("phonemng/countmng/")
public class CallCountController extends MyBaseController {

	@Autowired
	private ICallInfoService callInfoService;

	/**
	 * 
	 * @author 韩天驭
	 * @2017年1月10日 下午3:59:36
	 * @param queryModel
	 * @param model
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String getEventCount(
			@ModelAttribute("queryModel") CallInformationQueryModel queryModel,
			Model model, HttpServletRequest request) {
		try {

			super.pageInfo(model, request);

			model.addAttribute("names", callInfoService
					.getNameList(new CallInformationQueryModel()));
			List<AtncCallTypeEnum> typeList = Arrays.asList(AtncCallTypeEnum
					.values());
			model.addAttribute("typeList", typeList);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/countmng/manage";
	}

	/**
	 * 
	 * @author 韩天驭
	 * @2017年1月10日 下午3:59:32
	 * @param queryModel
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String postEventCount(
			@ModelAttribute("queryModel") CallInformationQueryModel queryModel,
			HttpServletRequest request, Model model) throws IOException {
		try {

			Pagination pagn = null;
			User user = getCurrentUser(request);
			// 获取查询结果
			Map<String, List<String>> callMap = callInfoService
					.CountTimes(queryModel);
			model.addAttribute("callMap", callMap);
			// 获取总和
			model.addAttribute("listAll",
					callInfoService.getCountAllTimes(callMap));
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/countmng/queryResult";

	}

}
