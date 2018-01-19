package cn.com.atnc.ioms.web.systemmng.clientcompany;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.entity.clientmng.ClientCompany;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.clientmng.CsRoleType;
import cn.com.atnc.ioms.enums.clientmng.SexEnum;
import cn.com.atnc.ioms.mng.clientmng.IClientCompanyManager;
import cn.com.atnc.ioms.model.clientmng.ClientForm;
import cn.com.atnc.ioms.model.systemmng.clientcompany.ClientCompanyQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

@Controller
@RequestMapping("/systemmng/clientcompany/")
public class ClientCompanyController extends MyBaseController {
	
	@Autowired
	private IClientCompanyManager clientCompanyManager;
	
	/**
	 * 客户单位管理引导页面
	 * @param queryModel
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") ClientCompanyQueryModel queryModel,
			Model model, HttpServletRequest request) {
		//System.out.println("1");
		super.pageInfo(model, request);
		return "systemmng/clientcompany/manage";
	}

	/**
	 * 客户单位管理查询
	 * @param request
	 * @param queryModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(HttpServletRequest request,
			@ModelAttribute("queryModel") ClientCompanyQueryModel queryModel,
			Model model) {
		//System.out.println("2");
		model.addAttribute("pagn", this.clientCompanyManager.queryPage(queryModel));
		return "systemmng/clientcompany/queryResult";
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String setupAddForm(@ModelAttribute("pageModel") ClientCompany clientCompany,
			Model model) {
		//System.out.println("1");
		model.addAttribute("bureaus", Bureau.values());
		return "systemmng/clientcompany/add";
	}

	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String processAddForm(@ModelAttribute("pageModel") ClientCompany clientCompany,
			HttpServletRequest request, Model model){
			try {
				clientCompanyManager.add(clientCompany);
				model.addAttribute("vo", clientCompany);
			    addSuccess(model, "添加单位成功");
			} catch (ServiceException e) {
				addError(model, "添加单位(" + clientCompany.getCompany() + ")失败：" + e.getMessage());
			}
			
		System.out.println("2");
		return "systemmng/clientcompany/result";
	}
	
	@RequestMapping(value = "mod.do", method = RequestMethod.GET)
	public String mod(HttpServletRequest request,
			@RequestParam("id") String id,
			@ModelAttribute("pageModel") ClientCompany clientCompany, 
			Model model) {
		//System.out.println("w");
		model.addAttribute("pageModel", clientCompanyManager.findByID(id));
		return "systemmng/clientcompany/mod";
	}
	
	@RequestMapping(value = "mod.do", method = RequestMethod.POST)
	public String clientMod(Model model	, HttpServletRequest request,
			@RequestParam("id")String id,
			@RequestParam("bureau")String bureau,
			@RequestParam("company")String company,
			@RequestParam("address")String address,
			@RequestParam("postcode")String postcode){
		ClientCompany clientCompany = clientCompanyManager.findByID(id);
		if(clientCompany.getCompany().equals(company)){
			clientCompany.setBureau(Bureau.valueOf(bureau));
			clientCompany.setAddress(address);
			clientCompany.setPostcode(postcode);
			try {
				model.addAttribute("vo", clientCompanyManager.updatem(clientCompany));
				addSuccess(model, "修改成功！");
			} catch (ServiceException e) {
				addError(model, "修改单位(" + clientCompany.getCompany() + ")失败：" + e.getMessage());
			}
		}else{
		      clientCompany.setBureau(Bureau.valueOf(bureau));
		      clientCompany.setCompany(company);
		      clientCompany.setAddress(address);
		      clientCompany.setPostcode(postcode);
		      //System.out.println("e");
		      try {
			     model.addAttribute("vo", clientCompanyManager.update(clientCompany));
			     addSuccess(model, "修改成功！");
		    } catch (ServiceException e) {
			     addError(model, "修改单位(" + clientCompany.getCompany() + ")失败：" + e.getMessage());
		    }  
		}
		return "systemmng/clientcompany/result";
	}
	
	@RequestMapping(value = "del.do", method = RequestMethod.POST)
	public String processDelSubmit(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		ClientCompany clientCompany = clientCompanyManager.findByID(id);
		String company = clientCompany.getCompany();
		try {
			clientCompanyManager.delete(clientCompany);
			addSuccess(model, "删除单位(" + company + ")成功");
		} catch (ServiceException e) {
			addError(model, "删除单位(" + clientCompany.getCompany() + ")失败：" + e.getMessage());
		}
		
		return "systemmng/clientcompany/result";
	}
	
	@RequestMapping("getCompany.dox")
	public String getCompany(@RequestParam("bureau") Bureau bureau,
			Model model) {
		ClientCompanyQueryModel queryModel = new ClientCompanyQueryModel();
		queryModel.setBureau(bureau);
		try {
			//System.out.println("xxL");
			switch (bureau) {
			case ZWWW:
			case ZLXY:
				model.addAttribute("returnStr", JacksonTools
						.toJsonStr(clientCompanyManager.queryList(queryModel)));
				break;
			case ZUUU:
			case ZBAA:
			case ZSSS:
				model.addAttribute("returnStr", JacksonTools
						.toJsonStr(clientCompanyManager.queryList(queryModel)));
				break;
			case ZGGG:
			case ZYTX:
			case ZBBB:
				model.addAttribute("returnStr", JacksonTools
						.toJsonStr(clientCompanyManager.queryList(queryModel)));
				break;
			case ZSPD:
			case ZBHQ:
			case ZBKG:
			case VHMT:
			case OVERSEAS:
				model.addAttribute("returnStr", JacksonTools
						.toJsonStr(clientCompanyManager.queryList(queryModel)));
				break;
			}
		} catch (IOException e) {
			model.addAttribute("returnStr", "[]");
			//System.out.println("xxx");
		}
		return "returnnote";
	}
}


