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

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.ioms.dao.duty.satelliteauto.day.SatTxjdKuDayFlagDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdKuDay;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdKuDayFlag;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatTxjdKuDayService;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatTxjdKuDayModel;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 卫星ku自检
 *
 * @author 段衍林
 * @2016年11月17日 上午10:27:27
 */
@Controller
@RequestMapping("/duty/satellitedayauto/kustate/")
public class KuController extends MyBaseController {

	@Autowired
	private SatTxjdKuDayService satTxjdKuDayService;
	@Autowired
	private SatTxjdKuDayFlagDao satTxjdKuDayFlagDao;

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
		// 查询卫星字段标记
		SatTxjdKuDayFlag satTxjdKuDayFlag = satTxjdKuDayFlagDao.getAll().get(0);
		model.addAttribute("flag", satTxjdKuDayFlag);
		// 检查结果枚举类
		Pagination pagn = satTxjdKuDayService.queryPageByModel(queryModel);
		// 取出列表
		List<SatTxjdKuDay> kus = (List<SatTxjdKuDay>) pagn.getResult();
		// 非空验证
		if (CollectionUtils.isNotEmpty(kus)) {
			// 返回第一条数据
			model.addAttribute("checkData", kus.get(0));
		}
		return "/duty/satellitedayauto/txjdku/update";
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
			@ModelAttribute("pageModel") SatTxjdKuDayModel satTxjdKuDayModel,
			HttpServletRequest request, Model model) throws IOException {
		try {
			// 设置当前用户为操作人
			User user = (User) request.getSession().getAttribute(
					SessionNames.LOGIN_USER);
			satTxjdKuDayModel.setOperator(user);
			// 保存新数据
			satTxjdKuDayService.saveOrUpdate(satTxjdKuDayModel);
			model.addAttribute("returnStr", new ResultModel(true, "修改记录成功",
					null).toJson());
		} catch (Exception e) {
			model.addAttribute("returnStr", new ResultModel(false, "修改记录失败",
					null).toJson());
		}
		return "returnnote";
	}

}
