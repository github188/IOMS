package cn.com.atnc.ioms.web.systemmng.client;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.util.StringUtil;
import net.sf.json.JSONArray;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.SecurityUtil;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.entity.clientmng.ClientCompany;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.NetworkType;
import cn.com.atnc.ioms.enums.clientmng.ClientOptEnum;
import cn.com.atnc.ioms.enums.clientmng.CsRoleType;
import cn.com.atnc.ioms.enums.clientmng.CsUserStatusEnum;
import cn.com.atnc.ioms.enums.clientmng.SexEnum;
import cn.com.atnc.ioms.mng.acl.IDiscuzUserService;
import cn.com.atnc.ioms.mng.basedata.equip.IEquipService;
import cn.com.atnc.ioms.mng.clientmng.IClientEquipService;
import cn.com.atnc.ioms.mng.clientmng.IClientManager;
import cn.com.atnc.ioms.mng.systemmng.deptinfomng.IDeptInfoMngService;
import cn.com.atnc.ioms.model.basedata.EquipQueryModel;
import cn.com.atnc.ioms.model.clientmng.ClientForm;
import cn.com.atnc.ioms.model.clientmng.query.ClientQueryModel;
import cn.com.atnc.ioms.model.systemmng.deptinfomng.DeptInfoQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

@Controller
@RequestMapping("/systemmng/client/")
public class ClientController extends MyBaseController {
	@Autowired
	private IClientManager clientManager;
	@Autowired
	private IEquipService equipService;
	@Autowired
	private IClientEquipService clientEquipService;
	@Autowired
	private IDiscuzUserService discuzUserService;

	

	/**
	 * 客户管理引导页面
	 * @param queryModel
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") ClientQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		model.addAttribute("bureauList", Bureau.values());
		model.addAttribute("roleNames", CsRoleType.values());
		return "systemmng/client/manage";
	}

	/**
	 * 客户管理查询
	 * @param request
	 * @param queryModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "manage.do", method = RequestMethod.POST)
	public String manageList(HttpServletRequest request,
			@ModelAttribute("queryModel") ClientQueryModel queryModel,
			Model model) {
		model.addAttribute("pagn", this.clientManager.queryPage(queryModel));
		return "systemmng/client/queryResult";
	}

	/**
	 * 客户添加引导界面
	 * @param client
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String setupAddForm(@ModelAttribute("pageModel") ClientForm client,
			Model model) {
		model.addAttribute("bureaus", Bureau.values());
		model.addAttribute("roles", CsRoleType.values());
	
		return "systemmng/client/add";
	}

	/**
	 * 客户添加操作-集成论坛同步添加方法
	 * @param client
	 * @param request
	 * @param model
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String processAddForm(
			@ModelAttribute("pageModel") ClientForm client,
			HttpServletRequest request, Model model)
			throws IllegalAccessException, InvocationTargetException {
		try {
			this.clientManager.add(client);
			model.addAttribute("vo", client);
			super.addSuccess(model, "添加客户成功");
			super.addLog(request, "添加客户(" + client.getName() + ")成功");
			super.addClientOptLog(client, ClientOptEnum.REGISTER, null,
					CsUserStatusEnum.REGISTED, getCurrentUser(request)
							.getName());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			super.addError(model, "添加客户失败," + e.getMessage());
		}

		return "systemmng/client/result";
	}

	/**
	 * 更改客户信息引导
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "mod.do", method = RequestMethod.GET)
	public String mod(HttpServletRequest request,
			@RequestParam("id") String id,
			@ModelAttribute("pageModel") ClientForm client, 
			Model model) {
		model.addAttribute("bureaus", Bureau.values());
		model.addAttribute("roles", CsRoleType.values());
		model.addAttribute("pageModel", clientManager.findByID(id));
		
		return "systemmng/client/mod";
	}
	
	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	public String clientMod(Model model, HttpServletRequest request,
			@RequestParam("id")String id,
			@RequestParam("name")String name,
			@RequestParam("sex")String sex,
			@RequestParam("age")String age,
			@RequestParam("bureau")String bureau,
			//@RequestParam("role")String role,
			//@RequestParam("pClient")String pClient,
			@RequestParam("company")String company,
			//@RequestParam("address")String address,
			//@RequestParam("postcode")String postcode,
			@RequestParam("mobilephone")String mobilephone,
			@RequestParam("phone")String phone,
			@RequestParam("email")String email,
			@RequestParam("job")String job,
			@RequestParam("fax")String fax,
			@RequestParam("branch")String branch,
			@RequestParam("info")String info) throws IllegalAccessException, InvocationTargetException {
		Client client = clientManager.findByID(id);
		//CsRole cRole = new CsRole();
		//cRole.setName(role);
		Client pClient1 = new Client();
		//pClient1.setId(pClient);
		client.setName(name);
		if(age != "" && age != null){
			client.setAge(Integer.parseInt(age));
		}
		ClientCompany newCompany1 = new ClientCompany();
		newCompany1.setId(company);
		//client.setRole(cRole);
		client.setBureau(Bureau.valueOf(bureau));
		//client.setpClient(pClient1);
		client.setNewCompany(newCompany1);
		client.setSex(SexEnum.getSexEnumByValue(sex));
		//client.setAddress(address);
		//client.setPostcode(postcode);
		client.setMobilephone(mobilephone);
		client.setPhone(phone);
		client.setEmail(email);
		client.setFax(fax);
		client.setJob(job);
		client.setBranch(branch);
		client.setInfo(info);
		try{
			model.addAttribute("vo", clientManager.update(client));
			//添加操作日志
			super.addLog(request, "更新用户成功");
			addSuccess(model, "更新成功！");
		}catch (Exception e) {
			super.addError(model, "更新客户失败," + e.getMessage());
		}
		
		return "systemmng/client/result";
	}
	
	/**
	 * 审批界面引导
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "audit.do", method = RequestMethod.GET)
	public String setupModForm(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		model.addAttribute("pageModel", clientManager.findByID(id));
		//添加注册回答问题信息查询
		model.addAttribute("questionModel", this.clientManager.findByClientID(id));
		
		return "systemmng/client/audit";
	}

	/**
	 * 审批审核处理
	 * @param client
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "audit.do", method = RequestMethod.POST)
	public String porcessModForm(@ModelAttribute("pageModel") ClientForm client,
			HttpServletRequest request,HttpServletResponse response, Model model) throws IOException{
		try {
			Client c = this.clientManager.audit(client);
			if(StringUtils.equalsIgnoreCase(client.getStatus().toString(), CsUserStatusEnum.DENIED.name())){
				//临时用户注册直接删除
				processDelSubmit(c.getId(), request, model);
			}else{
				model.addAttribute("vo", c);
				super.addSuccess(model, "审核完成");
				super.addLog(request, "审核信息(" + client.getName() + ")成功");
				super.addClientOptLog(c, ClientOptEnum.AUDIT,
						CsUserStatusEnum.PASSED, c.getStatus(),
						getCurrentUser(request).getName());
			}
		} catch (ServiceException e) {
			super.addError(model, e.getMessage());
		}
		return "systemmng/client/result";
	}

	/**
	 * 客户删除操作
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "del.do", method = RequestMethod.POST)
	public String processDelSubmit(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		Client client = this.clientManager.findByID(id);
		String name = client.getName();
		try {
			//删除（临时用户）答题
			if(StringUtils.equalsIgnoreCase(client.getRole().getName(),CsRoleType.aaTempUser.name())){
				clientManager.deleteAnswer(client.getId());
			}
			clientManager.delete(client);
			addSuccess(model, "删除客户(" + name + ")成功");
			super.addLog(request, "删除客户(" + name + ")成功");
		} catch (ServiceException e) {
			super.addLog(request, "删除客户(" + name + ")失败");
			addError(model, "删除客户(" + name + ")失败：" + e.getMessage());
		}
		return "systemmng/client/result";
	}

	/**
	 * 重置密码操作
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "resetpwd.do", method = RequestMethod.POST)
	public String resetpwd(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		Client client = this.clientManager.findByID(id);
		String clientName = client.getName();
		try {
			client.setPswOrigin("123456");
			client.setPassword(SecurityUtil.encryptByMD5("123456"));
			discuzUserService.updateDiscuzMember(client);
			clientManager.update(client);
			model.addAttribute("vo", client);
			addSuccess(model, "密码重置客户(" + clientName + ")成功");
			super.addLog(request, "密码重置客户(" + clientName + ")成功");
		} catch (Exception e) {
			super.addLog(request, "密码重置客户(" + clientName + ")失败");
			addError(model, "密码重置客户(" + clientName + ")失败：" + e.getMessage());
		}
		return "systemmng/client/result";
	}

	/**
	 * 查看客户信息引导
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public String view(HttpServletRequest request,
			@RequestParam("id") String id, Model model) {
		Client c = clientManager.findByID(id);
		model.addAttribute("pageModel", c);
		//添加注册回答问题信息查询
		model.addAttribute("questionModel", this.clientManager.findByClientID(id));
		return "systemmng/client/view";
	}

	/**
	 * 检查用户名是否重名
	 * @param model
	 * @param loginName
	 * @return
	 */
	@RequestMapping(value = "checkClient.dox")
	public String checkClient(Model model,
			@RequestParam("loginName") String loginName) {
		ClientQueryModel qm = new ClientQueryModel();
		qm.setLoginName(loginName.trim());
		List<Client> clientList = this.clientManager.queryList(qm);

		if (CollectionUtils.isEmpty(clientList)) {
			model.addAttribute(super.RETURNSTR, true);
		} else {
			model.addAttribute(super.RETURNSTR, false);
		}
		return super.RETURNNOTE;
	}

	/**
	 * 检查邮箱是否重复
	 * @param model
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "checkEmail.dox")
	public String checkEmail(Model model,
			@RequestParam("email") String email) {
		//Client client = clientManager.findByID(id);
		//System.out.println(id);
		//System.out.println(client.getEmail());
		ClientQueryModel qm = new ClientQueryModel();
		qm.setEmail(email);
		
		List<Client> clientList = this.clientManager.queryList(qm);
		//if (client.getEmail() != qm.getEmail()){//修改的邮箱与本人邮箱不同
			if (CollectionUtils.isEmpty(clientList)) {
				model.addAttribute(super.RETURNSTR, true);
			} else {
				model.addAttribute(super.RETURNSTR, false);
			}
		/*}else{
			model.addAttribute(super.RETURNSTR, true);
		}*/
		
		return super.RETURNNOTE;
	}
	
	/**
	 * 获得所属管局下拉列表
	 * @param model
	 * @param qm
	 * @return
	 */
	@RequestMapping(value = "getLeader.dox")
	public String getLeader(Model model, ClientQueryModel qm) {
		if (qm.getRoleName().equals(CsRoleType.user.name())) {
			qm.setRoleNames(new String[] { CsRoleType.localManager.name() });
		}
		if (qm.getRoleName().equals(CsRoleType.localManager.name())) {
			qm.setRoleNames(new String[] { CsRoleType.areaManager.name() });
		}

		qm.setStatus(CsUserStatusEnum.PASSED);
		List<Client> list = this.clientManager.queryList(qm);
		model.addAttribute(super.RETURNSTR, JSONArray.fromObject(list));
		return super.RETURNNOTE;
	}

	/**
	 * 获得所属区域单位下拉列表
	 * @param model
	 * @param qm
	 * @return
	 */
	@RequestMapping(value = "getCompany.dox")
	public String getCompany(Model model, ClientQueryModel qm) {
		List<ClientCompany> list = this.clientManager.queryCompanyList(qm);
		model.addAttribute(super.RETURNSTR, JSONArray.fromObject(list));
		return super.RETURNNOTE;
	}
	
	/**
	 * 查询所有客户卫星信息
	 * @param model
	 * @param queryModel
	 * @return
	 */
	@RequestMapping(value = "querySatellite.dox", method = RequestMethod.POST)
	public String querySatellite(Model model, EquipQueryModel qm) {
		
		model.addAttribute("equipList", this.equipService.queryList(qm));
		return "systemmng/client/satellite/queryResult";
	}

	/**
	 * 查询客户配置卫星信息
	 * @param queryModel
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "satelliteConfig.do", method = RequestMethod.GET)
	public String setupConfigSatelliteForm(
			@ModelAttribute("queryModel") EquipQueryModel queryModel,
			Model model) {
		/** 设备查询 **/
		model.addAttribute("bureauList", Bureau.values());
		model.addAttribute("networkList", NetworkType.values());
		model.addAttribute("userID", queryModel.getId());
		model.addAttribute("equips",
				this.clientEquipService.queryEquipByClientID(queryModel));
		return "systemmng/client/satellite/configSatellite";
	}
/*	*//**
	 * 审批查询客户配置卫星信息
	 * @param queryModel
	 * @param id
	 * @param model
	 * @return
	 *//*
	@RequestMapping(value = "auditSatelliteConfig.do", method = RequestMethod.GET)
	public String auditSetupConfigSatelliteForm(
			@ModelAttribute("queryModel") EquipQueryModel queryModel,
			Model model) {
		*//** 设备查询 **//*
		model.addAttribute("bureauList", Bureau.values());
		model.addAttribute("networkList", NetwordType.values());
		model.addAttribute("userID", queryModel.getId());
		model.addAttribute("equips",
				this.clientEquipService.queryEquipByClientID(queryModel));
		return "systemmng/client/auditConfigSatellite";
	}*/

	/**
	 * 查询所有客户ATM信息
	 * @param model
	 * @param queryModel
	 * @return
	 */
	@RequestMapping(value = "queryAtm.dox", method = RequestMethod.POST)
	public String queryAtm(Model model, EquipQueryModel queryModel) {
		model.addAttribute("equipList", this.equipService.queryList(queryModel));
		return "systemmng/client/atm/queryResult";
	}
	
	/**
	 * 查询客户配置ATM信息
	 * @param queryModel
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "atmConfig.do", method = RequestMethod.GET)
	public String setupConfigAtmForm(
			@ModelAttribute("queryModel") EquipQueryModel queryModel,
			Model model) {
		
		/** 设备查询 **/
		model.addAttribute("bureauList", Bureau.values());
		model.addAttribute("networkList", NetworkType.values());
		model.addAttribute("userID", queryModel.getId());
		model.addAttribute("equips",
				this.clientEquipService.queryEquipByClientID(queryModel));
		return "systemmng/client/atm/configAtm";
	}
	
/*	*//**
	 * 审批查询客户配置ATM信息
	 * @param queryModel
	 * @param id
	 * @param model
	 * @return
	 *//*
	@RequestMapping(value = "auditAtmConfig.do", method = RequestMethod.GET)
	public String auditSetupConfigAtmForm(
			@ModelAttribute("queryModel") EquipQueryModel queryModel,
			Model model) {
		
		*//** 设备查询 **//*
		model.addAttribute("bureauList", Bureau.values());
		model.addAttribute("networkList", NetwordType.values());
		model.addAttribute("userID", queryModel.getId());
		model.addAttribute("equips",
				this.clientEquipService.queryEquipByClientID(queryModel));
		return "systemmng/client/auditConfigAtm";
	}*/
	
	/**
	 * 获得客户相关设备list
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getEquip.dox", method = RequestMethod.GET)
	public String queryEquip(
			@ModelAttribute("queryModel") EquipQueryModel queryModel,
			Model model, HttpServletRequest request
			) {
		List<Equip> list = this.clientEquipService.queryEquipByClientID(
				queryModel);
		model.addAttribute(super.RETURNSTR, JSONArray.fromObject(list));
		return super.RETURNNOTE;
	}

	/**
	 * 设备配置操作
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "equipConfig.do", method = RequestMethod.POST)
	public String submitConfigEquipForm(HttpServletRequest request, Model model) {
		String clientID = request.getParameter("clientID");
		String[] equipIDs = request.getParameterValues("equipID");
		this.clientEquipService.save(clientID, equipIDs);
		// model.addAttribute(super.RETURNSTR, "success");
		// return super.RETURNNOTE;
		addSuccess(model, "配置设备成功");
		Client returnOBJ = this.clientManager.findByID(clientID);
		super.addLog(request, returnOBJ.getName() + "配置设备成功");
		model.addAttribute("vo", returnOBJ);
		return "systemmng/client/result";

	}
	/**
	 * 审批设备配置操作
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "auditEquipConfig.do", method = RequestMethod.POST)
	public String auditConfigEquipForm(HttpServletRequest request, Model model) {
		String clientID = request.getParameter("clientID");
		String[] equipIDs = request.getParameterValues("equipID");

		this.clientEquipService.save(clientID, equipIDs);
		// model.addAttribute(super.RETURNSTR, "success");
		// return super.RETURNNOTE;
		addSuccess(model, "配置设备成功");
		Client returnOBJ = this.clientManager.findByID(clientID);
		super.addLog(request, returnOBJ.getName() + "配置设备成功");
		model.addAttribute("vo", returnOBJ);
		return "systemmng/client/result";

	}
	
	
	
	/**
	 * 注销客户操作
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "disableAgree.do", method = RequestMethod.POST)
	public String disableAgree(HttpServletRequest request, Model model,
			@RequestParam("id") String id) {
		Client client = this.clientManager.findByID(id);
		CsUserStatusEnum cur = client.getStatus();
		client.setStatus(CsUserStatusEnum.DISABLED);
		model.addAttribute("vo", client);
		try {
			clientManager.audit(client);
			addSuccess(model, "同意注销客户(" + client.getName() + ")");
			super.addLog(request, "同意注销客户(" + client.getName() + ")");

			super.addClientOptLog(client, ClientOptEnum.ANNUL, cur,
					CsUserStatusEnum.DISABLED, getCurrentUser(request)
							.getName());
		} catch (ServiceException e) {
			addError(model, "注销客户(" + client.getName() + ")失败");
		}

		return "systemmng/client/result";
	}

	/**
	 * 冻结客户操作
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "block.do", method = RequestMethod.POST)
	public String blockAgree(HttpServletRequest request, Model model,
			@RequestParam("id") String id) {
		Client client = this.clientManager.findByID(id);
		//client.setBlocking(true);
		//model.addAttribute("vo", client);
		try{
			clientManager.block(client);
			addSuccess(model, "冻结客户(" + client.getName() + ")成功");
			super.addLog(request, "冻结客户(" + client.getName() + ")成功");
		}catch(ServiceException e){
			super.addLog(request, "冻结客户(" + client.getName() + ")失败");
			addError(model, "冻结客户(" + client.getName() + ")失败：" + e.getMessage());
		}
		
		return "systemmng/client/result";
		
	}
	
	/**
	 * 解锁客户操作
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "unBlock.do", method = RequestMethod.POST)
	public String unBlockAgree(HttpServletRequest request, Model model,
			@RequestParam("id") String id) {
		Client client = this.clientManager.findByID(id);
		client.setBlocking(false);
		model.addAttribute("vo", client);
		try{
			clientManager.update(client);
			addSuccess(model, "解锁客户(" + client.getName() + ")成功");
			super.addLog(request, "解锁客户(" + client.getName() + ")成功");
		}catch (Exception e) {
			super.addLog(request, "解锁客户(" + client.getName() + ")失败");
			addError(model, "解锁客户(" + client.getName() + ")失败：" + e.getMessage());
		}
		
		return "systemmng/client/result";
	}
}
