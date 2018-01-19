package cn.com.atnc.ioms.web.faultmng;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.faultmng.FaultHandle;
import cn.com.atnc.ioms.entity.faultmng.FaultInformation;
import cn.com.atnc.ioms.enums.faultmng.FaultEventType;
import cn.com.atnc.ioms.enums.faultmng.FaultLevelType;
import cn.com.atnc.ioms.enums.faultmng.FaultOriginType;
import cn.com.atnc.ioms.mng.faultmng.IFaultHandleMngService;
import cn.com.atnc.ioms.mng.faultmng.IFaultInformationMngService;
import cn.com.atnc.ioms.model.faultmng.FaultHandleQueryModel;
import cn.com.atnc.ioms.util.HqlStringTools;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 事件处置模块数据统计查询控制类
 * 
 * @author duanyanlin
 * @date 2016年8月5日下午3:27:05
 */
@Controller("faultQueryController")
@RequestMapping("faultmng/")
public class FaultQueryController extends MyBaseController {

	@Autowired
	private IFaultInformationMngService faultInformationMng;
	@Autowired
	private IFaultHandleMngService faultHandleMngService;

	/**
	 * 故障单查询
	 * 
	 * @author duanyanlin
	 * @date 2016年6月30日下午3:39:38
	 * @param queryModel
	 *            事件处置查询model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 统计页面
	 */
	@RequestMapping(value = "count/manage.do", method = RequestMethod.GET)
	public String getCount(
			@ModelAttribute("queryModel") FaultHandleQueryModel queryModel,
			Model model, HttpServletRequest request) {
		try {

			super.pageInfo(model, request);
			// 事件类别
			model.addAttribute("eventTypes", FaultEventType.values());
			// 事件类别
			model.addAttribute("sources", FaultOriginType.values());
			// 事件级别
			model.addAttribute("faultLevels", FaultLevelType.values());

		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "faultmng/count/manage";
	}

	/**
	 * 故障单查询
	 * 
	 * @author duanyanlin
	 * @date 2016年6月30日下午3:39:38
	 * @param queryModel
	 *            事件处置查询model
	 * @param model
	 *            模型
	 * @param request
	 *            请求
	 * @return String 条件查询回显
	 */
	@RequestMapping(value = "count/manage.do", method = RequestMethod.POST)
	public String postCount(
			@ModelAttribute("queryModel") FaultHandleQueryModel queryModel,
			Model model, HttpServletRequest request) {
		try {

			// 通配符转换字符串
			if (!StringUtils.isEmpty(queryModel.getContactsName())) {
				// 将申告人中的_下划线转换成字符_
				queryModel.setContactsName(HqlStringTools
						.replaceSpecialChar(queryModel.getContactsName()));
			}
			// 通配符转换字符串
			if (!StringUtils.isEmpty(queryModel.getCurrentHandleUser())) {
				// 将当前处理人中的_下划线转换成字符_
				queryModel.setCurrentHandleUser(HqlStringTools
						.replaceSpecialChar(queryModel.getCurrentHandleUser()));
			}
			// 当前用户
			User currentUser = getCurrentUser(request);
			model.addAttribute("currentUser", currentUser);
			// 包含已逻辑删除故障单
			queryModel.setIsDelete(true);
			// 分页查询
			Pagination pagn = this.faultInformationMng
					.queryFaultList(queryModel);
			model.addAttribute("pagn", pagn);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "faultmng/count/queryResult";
	}

	/**
	 * 查看详情
	 * 
	 * @author duanyanlin
	 * @date 2016年7月1日上午9:43:30
	 * @param qm
	 *            事件处置查询model
	 * @param model
	 *            模型
	 * @return String 详情页
	 */
	@RequestMapping(value = "fault/viewfault.do", method = RequestMethod.GET)
	public String viewFault(
			@ModelAttribute("queryModel") FaultHandleQueryModel qm, Model model) {
		try {

			// 查询事件单和处置记录
			FaultInformation faultInformation = this.faultInformationMng
					.findById(qm);
			List<FaultHandle> faultHandles = this.faultHandleMngService
					.queryList(qm);
			model.addAttribute("fault", faultInformation);
			model.addAttribute("faultHandles", faultHandles);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "faultmng/fault/viewfault";
	}
}
