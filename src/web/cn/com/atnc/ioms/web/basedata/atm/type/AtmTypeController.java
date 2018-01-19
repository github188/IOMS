package cn.com.atnc.ioms.web.basedata.atm.type;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.entity.basedata.atm.type.AtmType;
import cn.com.atnc.ioms.mng.basedata.atm.type.IAtmTypeManager;
import cn.com.atnc.ioms.model.basedata.atm.type.AtmTypeQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 *类说明
 *@author 徐彤阳
 *@date 2014-8-27	上午9:22:05
 *@version:1.0
 */

@Controller
@RequestMapping("/basedata/atm/type")
public class AtmTypeController extends MyBaseController{
	@Autowired
	private IAtmTypeManager atmTypeManager;
	
	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") AtmTypeQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		return "basedata/atm/type/manage";
	}
	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") AtmTypeQueryModel queryModel,
			Model model, HttpSession session) {
		model.addAttribute("pagn", this.atmTypeManager.queryPage(queryModel));
		session.setAttribute("atmTypeQueryModel", queryModel);
		return "basedata/atm/type/queryResult";
	}
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String setupAddForm(@ModelAttribute("pageModel") AtmType atmType,
			Model model) {
		
		return "basedata/atm/type/add";
	}
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String processAddForm(@ModelAttribute("pageModel") AtmType atmType,
			HttpServletRequest request, Model model,AtmTypeQueryModel queryModel) {
		try {
			model.addAttribute("vo", atmTypeManager.add(atmType));
			addSuccess(model, "添加ATM业务类型(" + atmType.getServiceType() + ")成功");
			 super.addLog(request, "添加ATM业务类型(" + atmType.getServiceType() + ")成功");
		} catch (ServiceException e) {
			addError(model, "添加ATM业务类型:" + e.getMessage());
		}
		return "basedata/atm/type/result";
	}
	@RequestMapping(value = "/del.do", method = RequestMethod.POST)
	public String processDelSubmit(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		try {
			
			String name = atmTypeManager.delete(id);
			addSuccess(model, "删除业务类型(" + name + ")成功");
			 super.addLog(request,"删除业务类型(" + name + ")成功");
		} catch (ServiceException e) {
			addError(model, "删除业务类型失败:" + e.getMessage());
		}
		return "basedata/atm/type/result";
	}
	@RequestMapping(value = "/mod.do", method = RequestMethod.GET)
	public String setupModForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		model.addAttribute("pageModel", atmTypeManager.findById(id));
		return "basedata/atm/type/mod";
	}
	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	public String porcessModForm(@ModelAttribute("pageModel") AtmType atmType,
			HttpServletRequest request, Model model) {
		try {
			model.addAttribute("vo", atmTypeManager.update(atmType));
			addSuccess(model, "修改业务类型(" + atmType.getServiceType() + ")成功");
			 super.addLog(request,  "修改业务类型(" + atmType.getServiceType() + ")成功");
		} catch (Exception e) {
			e.printStackTrace();
			addError(model, "修改业务类型失败:" + e.getMessage());
		}
		return "basedata/atm/type/result";
	}
	/**
	 * 检查类型是否存在
	 * @param model
	 * @param qm
	 * @param response
	 * @return 
	 */
	@RequestMapping(value = "/checkExist.dox")
	public String checkExist(Model model, AtmTypeQueryModel qm) {
		List<AtmType> atmList = this.atmTypeManager.queryList(qm);
		if(CollectionUtils.isEmpty(atmList)){
			model.addAttribute(super.RETURNSTR, true);
		}else{
			model.addAttribute(super.RETURNSTR, false);
		}
		return super.RETURNNOTE;
	}
	@RequestMapping(value = "/check.dox")
	public String check(Model model,@RequestParam("id") String id) {
		model.addAttribute("returnStr", atmTypeManager.check(id));
		return "returnnote";
	}
}
