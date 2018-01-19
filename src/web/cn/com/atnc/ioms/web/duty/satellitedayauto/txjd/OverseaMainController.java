package cn.com.atnc.ioms.web.duty.satellitedayauto.txjd;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdOverseaMain;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatTxjdOverseaMainService;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatTxjdOverseaMainModel;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 通信基地-境外站-境外站主站 控制类
 *
 * @author 段衍林
 * @2016年11月21日 下午1:20:32
 */
@Controller
@RequestMapping("/duty/satellitedayauto/main/")
public class OverseaMainController extends MyBaseController {

	@Autowired
	private SatTxjdOverseaMainService satTxjdOverseaMainService;

	/**
	 * 添加新数据
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:33:12
	 * @param txjdRadarLink
	 *            实体
	 * @param optType
	 *            tab页
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String addJump(
			@ModelAttribute("pageModel") SatTxjdOverseaMainModel satTxjdOverseaMainModel,
			@RequestParam("optType") String optType, Model model) {
		// 检查结果枚举类
		model.addAttribute("optType", optType);
		// 跳转添加页面
		return "duty/satellitedayauto/txjdoverseamain/add";
	}

	/**
	 * 添加记录
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:55:09
	 * @param txjdRadarLink
	 *            实体
	 * @param request
	 *            请求
	 * @param model
	 *            model
	 * @return
	 * @throws IOException
	 *             String
	 */
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String add(
			@ModelAttribute("pageModel") SatTxjdOverseaMainModel satTxjdOverseaMainModel,
			HttpServletRequest request, Model model) throws IOException {
		// 设置当前用户为操作人
		User user = (User) request.getSession().getAttribute(
				SessionNames.LOGIN_USER);
		// 前端展示
		model.addAttribute("currentUser", user);
		try {
			// 存储创建人
			satTxjdOverseaMainModel.setOperator(user);
			// 保存新数据
			satTxjdOverseaMainService
					.saveOrUpdate(satTxjdOverseaMainModel);
			model.addAttribute("returnStr", new ResultModel(true, "添加记录成功",
					null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr", new ResultModel(false, "添加记录失败",
					null).toJson());
		}
		return "returnnote";
	}

	/**
	 * 删除
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午10:59:47
	 * @param txjdRadarLink
	 * @param id
	 * @param request
	 * @param model
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String delete(
			@ModelAttribute("pageModel") SatTxjdOverseaMainModel satTxjdOverseaMainModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 删除
			satTxjdOverseaMainService.delete(satTxjdOverseaMainModel);
			// 返回
			// 返回
			addSuccess(model, "删除记录成功");
			// 记录操作日志
			super.addLog(request, "删除记录成功");
		} catch (RuntimeException e) {
			addError(model, "删除记录失败");
			super.addLog(request, "删除记录失败");
		}
		return "duty/satellitedayauto/txjdoverseamain/result";
	}

	/**
	 * 更新跳转
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午11:08:58
	 * @param id
	 * @param slhequstate
	 * @param request
	 * @param model
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	public String updateJump(
			@ModelAttribute("pageModel") SatelliteAutoModel queryModel,
			HttpServletRequest request, Model model) {
		// 检查结果枚举类
		Pagination pagn = satTxjdOverseaMainService
				.queryPageByModel(queryModel);
		// 取出列表
		List<SatTxjdOverseaMain> mains = (List<SatTxjdOverseaMain>) pagn
				.getResult();
		// 非空验证
		if (CollectionUtils.isNotEmpty(mains)) {
			// 返回第一条数据
			model.addAttribute("vo", mains.get(0));
		}
		return "duty/satellitedayauto/txjdoverseamain/update";
	}

	/**
	 * 更新
	 * 
	 * @author 段衍林
	 * @2016年11月16日 上午11:19:56
	 * @param txjdRadarLinkModel
	 * @param request
	 * @param model
	 * @param id
	 * @return String
	 * @throws IOException 
	 */
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(
			@ModelAttribute("pageModel") SatTxjdOverseaMainModel satTxjdOverseaMainModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			satTxjdOverseaMainModel.setOperator(user);
			// 保存新数据
			satTxjdOverseaMainService
					.saveOrUpdate(satTxjdOverseaMainModel);
			model.addAttribute("returnStr", new ResultModel(true, "修改记录成功",
					null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr", new ResultModel(false, "修改记录失败",
					null).toJson());
		}
		return "returnnote";
	}

}
