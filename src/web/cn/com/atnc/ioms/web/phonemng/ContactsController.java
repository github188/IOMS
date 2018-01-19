package cn.com.atnc.ioms.web.phonemng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.phonemng.ContactsMng;
import cn.com.atnc.ioms.entity.turndutymng.ShiftDutyRecord;
import cn.com.atnc.ioms.enums.phonemng.ContactStatusEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;
import cn.com.atnc.ioms.mng.phonemng.IContactsMngService;
import cn.com.atnc.ioms.model.phonemng.ContactsMngQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

@Controller("ContactsController")
@RequestMapping("phonemng/contactsmng")
public class ContactsController extends MyBaseController {
	@Autowired
	private IContactsMngService contactsMngService;

	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-18下午3:03:28
	 * @param queryModel
	 * @param model
	 * @param request
	 * @return String TODO 联系人管理
	 */
	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String getLinkmanList(
			@ModelAttribute("queryModel") ContactsMngQueryModel queryModel,
			Model model, HttpServletRequest request) {
		try {

			User user = getCurrentUser(request);
			super.pageInfo(model, request);
			model.addAttribute("username", user.getName());
			// 获取联系人状态
			List<ContactStatusEnum> statusList = Arrays
					.asList(ContactStatusEnum.values());
			model.addAttribute("statusList", statusList);

			System.err.println("post-manage");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/contactsmng/manage";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:manageList
	 * @Description:
	 * @Param:@param qm
	 * @Param:@param model
	 * @Param:@param request
	 * @Param:@return
	 * @Param:@throws IOException
	 * @Return:String
	 * @Creatime:2016年7月28日 下午2:11:49
	 */
	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") ContactsMngQueryModel qm,
			Model model, HttpServletRequest request) throws IOException {
		try {

			Pagination pagn = null;
			// 当前用户
			User user = getCurrentUser(request);
			pagn = contactsMngService.queryPage(qm);
			model.addAttribute("pagn", pagn);
			model.addAttribute("username", user.getName());
			System.err.println("post-manage");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/contactsmng/queryResult";
	}

	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-18下午3:03:51
	 * @param queryModel
	 * @param model
	 * @param request
	 * @return String TODO 添加联系人
	 */
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String getAddLinkman(
			@ModelAttribute("pageModel") ContactsMng pageModel, Model model,
			HttpServletRequest request) {
		try {

			super.pageInfo(model, request);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return "phonemng/contactsmng/add";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:processAddNews
	 * @Description:TODO
	 * @Param:@param pageModel
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Param:@throws IOException
	 * @Return:String
	 * @Creatime:2016年7月26日 下午1:44:33
	 */
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String processAddNews(
			@ModelAttribute("pageModel") ContactsMng pageModel,
			HttpServletRequest request, Model model) throws IOException {
		try {

			User user = getCurrentUser(request);

			try {
				pageModel.setCreater(user);
				contactsMngService.save(pageModel);
				model.addAttribute("vo", pageModel);
				addSuccess(model, "提交成功");
			} catch (Exception e) {
				addError(model, "提交失败");
				e.printStackTrace();
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/contactsmng/result";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:setupModForm
	 * @Description:修改get
	 * @Param:@param id
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年7月27日 上午8:45:44
	 */
	@RequestMapping(value = "/mod.do", method = RequestMethod.GET)
	public String setupModForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		try {

			ContactsMng contactsMng = contactsMngService.findViewById(id);

			model.addAttribute("pageModel", contactsMng);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/contactsmng/mod";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:processModifyShift
	 * @Description:修改post
	 * @Param:@param id
	 * @Param:@param contactsMng
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Param:@throws IOException
	 * @Return:String
	 * @Creatime:2016年7月28日 下午2:12:06
	 */
	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	public String processModifyShift(@RequestParam("id") String id,
			@ModelAttribute("pageModel") ContactsMng contactsMng,
			HttpServletRequest request, Model model) throws IOException {
		try {

			User user = getCurrentUser(request);
			try {
				contactsMng.setOperator(user);
				model.addAttribute("vo",
						contactsMngService.Update(id, contactsMng));

				addSuccess(model, "修改联系人成功！");
				super.addLog(request, "修改联系人成功！");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "phonemng/contactsmng/result";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:contactsBlack
	 * @Description:黑名单
	 * @Param:@param idlist
	 * @Param:@param queryModel
	 * @Param:@param contactsMng
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Param:@throws IOException
	 * @Return:String
	 * @Creatime:2016年8月29日 下午3:44:00
	 */
	@RequestMapping(value = "/black.do")
	public String contactsBlack(@RequestParam("idlist") String idlist,
			@ModelAttribute("queryModel") ContactsMngQueryModel queryModel,
			ContactsMng contactsMng, HttpServletRequest request, Model model)
			throws IOException {
		try {

			if (StringUtils.isEmpty(idlist)) {
				model.addAttribute("returnStr", "{\"result\":false,\"msg\":\""
						+ "请选择要拉黑的联系人！" + "\"}");

				return "returnnote";
			}

			contactsMngService.contactsUpdateStatus(idlist.split(","), "黑名单");
			// addSuccess(model, "拉黑联系人成功！");
			try {
				model.addAttribute("returnStr", JacksonTools
						.toJsonStr(contactsMngService.getTelNumberList(idlist
								.split(","))));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				model.addAttribute("returnStr", "[]");
				e.printStackTrace();
			}
			// model.addAttribute("returnStr",JacksonTools.toJsonStr("拉黑联系人成功"));

			super.addLog(request, "拉黑联系人成功！");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "returnnote";

	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:processDeleteShift
	 * @Description:删除
	 * @Param:@param id
	 * @Param:@param session
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年8月15日 上午11:03:43
	 */
	@RequestMapping(value = "/del.do", method = RequestMethod.POST)
	public String postDel(@RequestParam("id") String id, HttpSession session,
			HttpServletRequest request, Model model) {
		try {
			ContactsMng contactsMng = contactsMngService.findViewById(id);

			model.addAttribute("vo", contactsMngService.Del(contactsMng));
			model.addAttribute("returnStr", "{\"result\":true,\"msg\":\""
					+ "冻结成功！" + "\"}");
			super.addLog(request, "冻结成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-8-21下午4:53:00
	 * @param id
	 * @param session
	 * @param request
	 * @param model
	 * @return String TODO 解冻
	 */
	@RequestMapping(value = "/notdel.do", method = RequestMethod.POST)
	public String notDel(@RequestParam("id") String id, HttpSession session,
			HttpServletRequest request, Model model) {
		try {
			ContactsMng contactsMng = contactsMngService.findViewById(id);

			model.addAttribute("vo", contactsMngService.notDel(contactsMng));
			model.addAttribute("returnStr", "{\"result\":true,\"msg\":\""
					+ "解冻成功！" + "\"}");
			super.addLog(request, "解冻成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:whitePost
	 * @Description:撤销黑名单
	 * @Param:@param id
	 * @Param:@param session
	 * @Param:@param request
	 * @Param:@param model
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年8月15日 下午1:11:14
	 */
	@RequestMapping(value = "/white.do", method = RequestMethod.POST)
	public String whitePost(@RequestParam("id") String id, HttpSession session,
			HttpServletRequest request, Model model) {
		try {
			ContactsMng contactsMng = contactsMngService.findViewById(id);
			model.addAttribute("vo",
					contactsMngService.contactsWhite(contactsMng));
			model.addAttribute("returnStr", "{\"result\":true,\"msg\":\""
					+ "撤销黑名单成功！" + "\"}");
			super.addLog(request, "撤销黑名单成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return "returnnote";
	}

}
