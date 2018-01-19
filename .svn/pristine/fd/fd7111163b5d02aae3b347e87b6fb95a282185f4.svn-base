package cn.com.atnc.ioms.web.business.roletransfer;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.acl.UserRole;
import cn.com.atnc.ioms.enums.acl.RoleSourceEnum;
import cn.com.atnc.ioms.mng.acl.IRoleManager;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.acl.IUserRoleManager;
import cn.com.atnc.ioms.model.acl.UserQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 
 * @author:HuangYijie
 * @date:2011-8-8 下午01:13:34
 * @version:1.0
 */
@Controller
@RequestMapping("/roletransfer")
public class RoleTransferController extends MyBaseController {
	@Autowired
	private IUserManager userManager;
	@Autowired
	private IRoleManager roleManager;
	@Autowired
	private IUserRoleManager userRoleManager;

	/**
	 * 跳转页面
	 * @author WangLingbin
	 * @date  2015年11月4日上午10:29:48
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") UserQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		return "business/roletransfer/manage";
	}

	/**
	 * 加载数据
	 * @throws IOException 
	 * @author WangLingbin
	 * @date  2015年11月4日上午10:30:10
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(HttpServletRequest request, Model model, 
			@ModelAttribute("queryModel") UserQueryModel queryModel) throws IOException {
		//获取当前用户
		User currentUser = this.getCurrentUser(request);
		model.addAttribute("currentUser", currentUser);
		queryModel.setCurrentUser(currentUser);
		//查找记录
		if(StringUtils.equalsIgnoreCase(currentUser.getId(), "admin")) {
			Pagination pagn = this.userManager.queryIncludeTransfer(queryModel);
			model.addAttribute("pagn", pagn);
		} else{
			List<User> users = this.userManager.queryUsersWithTransfer(currentUser);
			model.addAttribute("users", users);
		}
		return "business/roletransfer/queryResult";
	}

	/**
	 * 新增跳转
	 * @author WangLingbin
	 * @date  2015年11月4日上午10:31:10
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String setupAddForm(Model model, HttpServletRequest request) {
		//当前用户
		User currentUser = this.getCurrentUser(request);
		userRoleManager.reSetRoles(currentUser);
		model.addAttribute("user", currentUser);
		//获取除当前用户和工程师以外的所有用户，按照部门排序
		List<User> users = userManager.getUsersOrderbyDep(currentUser);
		model.addAttribute("users", users);
		return "business/roletransfer/add";
	}

	/**
	 * 新增保存
	 * @author WangLingbin
	 * @date  2015年11月4日上午10:31:20
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String processAddForm(HttpServletRequest request, Model model,
			@RequestParam(value = "transferUser", required = false) String transferUserId,
			@ModelAttribute("queryModel") UserQueryModel queryModel) {
		try {
			//当前用户
			User currentUser = this.getCurrentUser(request);
			User transferUser = userManager.findById(transferUserId);
			//检查是否已经给授权用户赋过角色了
			List<UserRole> userRoles = userRoleManager.findByMulti(transferUser, RoleSourceEnum.TRANSFER, currentUser);
			if(CollectionUtils.isNotEmpty(userRoles)) {
				addError(model,  "已经对" + transferUser.getName() + "进行过授权，请选择其他人");
				return "business/roletransfer/result";
			}
			//检查是否别人已经给授权用户赋过角色了
			userRoles = userRoleManager.findByMulti(transferUser, RoleSourceEnum.TRANSFER, null);
			if(CollectionUtils.isNotEmpty(userRoles)) {
				StringBuilder sb = new StringBuilder();
				for(UserRole userRole : userRoles) {
					sb.append(userRole.getTransfer().getName()).append(",");
				}
				addError(model, "<" + sb.substring(0, sb.length() - 1) + ">已经对" + 
								transferUser.getName() + "进行过授权，请选择其他人");
				return "business/roletransfer/result";
			}
			userRoleManager.saveTransfer(currentUser, transferUser);
			addSuccess(model, "角色授权给(" + transferUser.getName() + ")成功");
			super.addLog(request,  "角色授权给(" + transferUser.getName() + ")成功");
			//返回新增的用户
			userRoles = userRoleManager.findByMulti(transferUser, RoleSourceEnum.TRANSFER, currentUser);
			if(CollectionUtils.isNotEmpty(userRoles)) {
				User user = userRoles.get(0).getUser();
				userRoleManager.reSetRoles(user);
				model.addAttribute("vo", user);
				model.addAttribute("currentUser", currentUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
			addError(model, "角色授权失败:" + e.getMessage());
		}
		return "business/roletransfer/result";
	}
	
	/**
	 * 查看详情
	 * @author WangLingbin
	 * @date  2015年11月4日上午11:19:02
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/view.do")
	public String view(@RequestParam("id") String id, Model model) {
		//用户
		User user = userManager.findById(id);
		model.addAttribute("user", user);
		return "business/roletransfer/view";
	}

	/**
	 * 撤销
	 * @author WangLingbin
	 * @date  2015年11月4日上午11:43:27
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/delete.do")
	public String changeStatus(HttpServletRequest request, Model model,
			@RequestParam("id") String id) {
		try {
			//用户
			User user = userManager.findById(id);
			//当前用户
			User currentUser = this.getCurrentUser(request);
			//撤销用户授权角色
			userRoleManager.revokeTransfers(user, currentUser);
			super.addLog(request,  "撤销用户(" + user.getName() + ")的授权角色成功");
			addSuccess(model, "撤销用户(" + user.getName() + ")的授权角色成功");
		} catch (Exception e) {
			addError(model, "撤销用户授权角色失败:" + e.getMessage());
		}
		return "business/roletransfer/result";
	}

}
