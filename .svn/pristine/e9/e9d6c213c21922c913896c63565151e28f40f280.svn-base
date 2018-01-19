package cn.com.atnc.ioms.web.duty.statellite.mqy;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.KuSys;
import cn.com.atnc.ioms.entity.duty.satellite.OutsideEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.satellite.OutSideEquipType;
import cn.com.atnc.ioms.mng.duty.statellitemqy.OutSideEquipCheckService;
import cn.com.atnc.ioms.model.duty.statellite.mqy.CheckModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.OutSideEquipCheckModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 室外设备巡检控制类
 *
 * @author 段衍林
 * @2016年11月17日 下午4:54:59
 */
@Controller
@RequestMapping("/duty/statellite/outsideequip/")
public class OutSideEquipCheckController extends MyBaseController {

	@Autowired
	private OutSideEquipCheckService checkrvice;

	/**
	 * 添加记录跳转
	 * 
	 * @author 段衍林
	 * @2016年11月17日 下午5:18:30
	 * @param queryModel
	 * @param checkType
	 *            巡检类型
	 * @param optType
	 *            tab页
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String addJump(
			@ModelAttribute("pageModel") OutSideEquipCheckModel queryModel,
			@RequestParam("checkType") CheckCatagory checkType,
			@RequestParam("optType") String optType, Model model) {
		// tab页
		model.addAttribute("optType", optType);
		// 设备名称
		OutSideEquipType checkEquip = OutSideEquipType.valueOf(optType);
		model.addAttribute("checkEquip", checkEquip);
		// 巡检类型
		model.addAttribute("checkType", checkType);
		return "duty/statellite/outsideequip/add";
	}

	/**
	 * 添加记录操作
	 * 
	 * @author 段衍林
	 * @2016年11月17日 下午5:19:08
	 * @param equipModel
	 * @param request
	 * @param optType
	 * @param model
	 * @return
	 * @throws IOException
	 *             String
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String add(
			@ModelAttribute("pageModel") OutSideEquipCheckModel equipModel,
			HttpServletRequest request,
			@RequestParam("optType") String optType, Model model)
			throws IOException {
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			// 操作人
			equipModel.setOperator(user);
			// 巡检设备
			OutSideEquipType checkEquip = OutSideEquipType.valueOf(optType);
			equipModel.setCheckEquip(checkEquip);
			// 将记录保存至数据库
			checkrvice.saveOrUpdate(equipModel);
			model.addAttribute("returnStr",
					new ResultModel(true, "操作成功", null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "操作失败", null).toJson());
		}
		return "returnnote";
	}

	/**
	 * 显示
	 * 
	 * @author shijiyong
	 * @time:2016年11月3日
	 * @param id
	 *            ID
	 * @param request
	 *            HttpServletRequest
	 * @param model
	 *            Model
	 * @return String
	 */
	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public String view(@RequestParam("id") String id,
			HttpServletRequest request, Model model) {
		// 查询实体
		OutsideEquipCheck outsideEquipCheck = checkrvice.findById(id);
		// 前端展示
		model.addAttribute("vo", outsideEquipCheck);
		return "/duty/statellite/outsideequip/view";
	}

	/**
	 * 更新跳转
	 * 
	 * @author shijiyong
	 * @time:2016年11月3日
	 * @param id
	 *            ID
	 * @param request
	 *            HttpServletRequest
	 * @param model
	 *            查询条件
	 * @param txjddatestate
	 *            pageModel
	 * @return String
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	public String updateJump(
			@RequestParam(value = "id", required = true) String id,
			@ModelAttribute("pageModel") KuSys pagemodel,
			HttpServletRequest request, Model model) {

		// 实体查询
		OutsideEquipCheck outsideEquipCheck = checkrvice.findById(id);
		// 前台控制
		model.addAttribute("vo", outsideEquipCheck);
		return "/duty/statellite/outsideequip/update";
	}

	/**
	 * 更新
	 * 
	 * @author shijiyong
	 * @time:2016年11月3日
	 * @param id
	 *            ID
	 * @param request
	 *            HttpServletRequest
	 * @param model
	 *            查询条件
	 * @param txjddatestate
	 *            pageModel
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(
			@ModelAttribute("pageModel") OutSideEquipCheckModel equipModel,
			HttpServletRequest request, Model model,
			@RequestParam("id") String id) throws IOException {
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			equipModel.setOperator(user);
			// 将记录保存至数据库
			checkrvice.saveOrUpdate(equipModel);
			model.addAttribute("returnStr",
					new ResultModel(true, "操作成功", null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr",
					new ResultModel(false, "操作失败", null).toJson());
		}
		return "returnnote";
	}

	/**
	 * 删除
	 * 
	 * @author shijiyong
	 * @time:2016年10月21日
	 * @param id
	 *            ID
	 * @param request
	 *            HttpServletRequest
	 * @param model
	 *            查询条件
	 * @param txjddatestate
	 *            pageModel
	 * @return String
	 * @throws IOException
	 */

	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String delete(@ModelAttribute("pageModel") CheckModel toolmodel,
			HttpServletRequest request, Model model,
			@RequestParam("id") String id) throws IOException {
		try {
			// 删除
			checkrvice.delete(id);
			// 返回
			addSuccess(model, "删除记录成功");
			// 记录操作日志
			super.addLog(request, "删除记录成功");
		} catch (RuntimeException e) {
			addError(model, "删除记录失败");
			super.addLog(request, "删除记录失败");
		}
		return "duty/statellite/outsideequip/result";
	}
}