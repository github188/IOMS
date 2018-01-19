package cn.com.atnc.ioms.web.systemmng.deptinfomng;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;













import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.systemmng.deptinfomng.DeptInfomationMng;
import cn.com.atnc.ioms.entity.turndutymng.ShiftDutyRecord;
import cn.com.atnc.ioms.entity.turndutymng.SignLeaveRecord;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.systemmng.deptinfomng.DeptTypeEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyRoleEnum;
import cn.com.atnc.ioms.mng.systemmng.deptinfomng.IDeptInfoMngService;
import cn.com.atnc.ioms.model.acl.UserQueryModel;
import cn.com.atnc.ioms.model.systemmng.clientcompany.ClientCompanyQueryModel;
import cn.com.atnc.ioms.model.systemmng.deptinfomng.DeptInfoQueryModel;
import cn.com.atnc.ioms.model.turndutymng.ShiftDutyQueryModel;
import cn.com.atnc.ioms.model.turndutymng.SignLeaveQueryModel;
import cn.com.atnc.ioms.model.turndutymng.TurnDutyQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;
/**
 * 
 * @author hantianyu
 *
 */
@Controller("DeptInfoMngController")
@RequestMapping("systemmng/deptinfomng/")
public class DeptInfoMngController extends MyBaseController{

	@Autowired
	private IDeptInfoMngService deptInfoMngService;
	
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") DeptInfoQueryModel queryModel,
			Model model, HttpServletRequest request) {
		
    	super.pageInfo(model, request);
		
		
		return "systemmng/deptinfomng/manage";
	}
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") DeptInfoQueryModel queryModel,
			Model model,HttpServletRequest request) throws IOException {
		
		Pagination pagn = null;
		pagn = deptInfoMngService.queryPage(queryModel);
		model.addAttribute("pagn", pagn);
    	
		return "systemmng/deptinfomng/queryResult";
	}
	
	
	 @RequestMapping(value = "add.do", method = RequestMethod.GET)
    public String addUrl( @ModelAttribute("pageModel") DeptInfomationMng pageModel,
    		Model model, HttpServletRequest request) {
		DeptInfoQueryModel qm=new DeptInfoQueryModel();
    	User user = getCurrentUser(request);
    	List<DeptTypeEnum> deptTypes=Arrays.asList(DeptTypeEnum.values());
    	List<DeptInfomationMng> deptLists=deptInfoMngService.getDeptByType(qm);
    	model.addAttribute("types", deptTypes);
    	model.addAttribute("parents", deptLists);
    	
    	return "systemmng/deptinfomng/add";
    }
	 
	 @RequestMapping(value = "/add.do", method = RequestMethod.POST)
	    public String processAddNews(@ModelAttribute("pageModel") DeptInfomationMng pageModel,
	    		HttpServletRequest request, Model model) throws IOException{
	    	User user = getCurrentUser(request);
	    	System.out.println("------------add  post---------");
	    	
	    	try{
	    	  pageModel.setCreater(user);
	    	  pageModel.setCreatime(new Date());
	    	  deptInfoMngService.save(pageModel);
	    	  addSuccess(model, "提交成功");
	    	}catch (Exception e) {
	    		addError(model, "提交失败");
	    		e.printStackTrace();
	    		
	    	}
	        return "systemmng/deptinfomng/result";
	    }
	 
	 @RequestMapping("getDept.dox")
		public String getCompany(@RequestParam("id") String id,
				Model model) {
			DeptInfoQueryModel queryModel = new DeptInfoQueryModel();
			queryModel.setParentInfo(id);
			System.out.println(id+"============================");
			try {
				//System.out.println("xxL");
				
					model.addAttribute("returnStr", JacksonTools
							.toJsonStr(deptInfoMngService.getDeptByParentInfo(queryModel)));

			} catch (IOException e) {
				model.addAttribute("returnStr", "[]");
				//System.out.println("xxx");
			}
			return "returnnote";
		}
}
