package cn.com.atnc.ioms.web.maintain.satellite;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.ioms.entity.maintain.month.KuReportData;
import cn.com.atnc.ioms.enums.reports.JasperReportsEnum;
import cn.com.atnc.ioms.mng.basedata.satellite.site.ISiteManager;
import cn.com.atnc.ioms.mng.maintain.equip.IMaintainEquipManager;
import cn.com.atnc.ioms.mng.maintain.month.KuReportDataManager;
import cn.com.atnc.ioms.mng.reports.JasperReportService;
import cn.com.atnc.ioms.model.maintain.satellite.SatelliteQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 卫星站点
 * 
 * @author 王凌斌
 * @2017年1月22日 下午2:02:08
 */
@Controller
@RequestMapping("/maintain/satellite")
public class SatelliteController extends MyBaseController {

	@Autowired
	private IMaintainEquipManager maintainEquipManager;
	@Autowired
	private JasperReportService jasperReportService;
	@Autowired
	private ISiteManager siteManager;
	@Autowired
	private KuReportDataManager kuReportDataManager;

	/**
	 * 主页面
	 * 
	 * @author 王凌斌
	 * @2017年1月22日 下午2:30:04
	 * @param queryModel
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/manage.do", method = RequestMethod.GET)
	public String manage(
			@ModelAttribute("queryModel") SatelliteQueryModel queryModel,
			Model model, HttpServletRequest request) {
		super.pageInfo(model, request);
		return "maintain/satellite/manage";
	}

	/**
	 * 列表
	 * 
	 * @author 王凌斌
	 * @2017年1月22日 下午2:30:17
	 * @param queryModel
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/manage.do", method = RequestMethod.POST)
	public String manageList(
			@ModelAttribute("queryModel") SatelliteQueryModel queryModel,
			Model model) {
		// 分页查询
		Pagination page = kuReportDataManager.queryPage(queryModel);
		model.addAttribute("pagn", page);
		return "maintain/satellite/queryResult";
	}

	/**
	 * 补全报表数据跳转
	 * 
	 * @author 王凌斌
	 * @2017年2月23日 下午3:08:47
	 * @param request
	 * @param model
	 * @param queryModel
	 * @param id
	 * @return String
	 */
	@RequestMapping(value = "write.do", method = RequestMethod.GET)
	public String writeList(HttpServletRequest request, Model model,
			@ModelAttribute("queryModel") SatelliteQueryModel queryModel,
			@RequestParam("id") String id) {
		// 根据主键ID获取报表数据实体
		KuReportData kuReportData = kuReportDataManager.findById(id);
		model.addAttribute("kuReportData", kuReportData);
		model.addAttribute("id", id);
		// 获取数据
		/*Map<String, Object> param = siteManager.getReportParams(request, id,
				JasperReportsEnum.ku_maintence.toString());
		// 获取报表基础数据
		@SuppressWarnings("unchecked")
		List<KuMaintenceEntity> dataSources = (List<KuMaintenceEntity>) param
				.get("datasource");
		model.addAttribute("dataSource", dataSources.get(0));*/
		return "maintain/satellite/write";
	}

	/**
	 * 补全报表数据跳转
	 * 
	 * @author 王凌斌
	 * @2017年2月23日 下午3:18:16
	 * @param model
	 * @param queryModel
	 * @param id
	 * @return
	 * @throws IOException
	 *             String
	 */
	@RequestMapping(value = "write.do", method = RequestMethod.POST)
	public String write(Model model,
			@ModelAttribute("queryModel") SatelliteQueryModel queryModel,
			@RequestParam("id") String id) throws IOException {
		// 根据主键ID获取报表数据实体
		KuReportData kuReportData = kuReportDataManager.findById(id);
		try {
			kuReportDataManager.write(kuReportData, queryModel);
			model.addAttribute("returnStr", new ResultModel(true, "填写信息成功",
					kuReportData).toJson());
		} catch (Exception e) {
			logger.error("填写信息失败!", e);
			model.addAttribute("returnStr", new ResultModel(true, "填写信息失败",
					kuReportData).toJson());
			return "returnnote";
		}
		return "returnnote";
	}

	/**
	 * 月度报表预览
	 * 
	 * @author 王凌斌
	 * @2017年1月22日 下午2:33:48
	 * @param request
	 * @param mav
	 * @param response
	 * @param id
	 * @return ModelAndView
	 */
	@RequestMapping(value = "preview.do")
	public ModelAndView preview(HttpServletRequest request, ModelAndView mav,
			HttpServletResponse response, @RequestParam("id") String id) {
		System.err.println(id);
		// 获取报表数据源参数
		Map<String, Object> param = siteManager.getReportParams(request, id,
				JasperReportsEnum.ku_maintence.toString());
		// 以PDF格式显示
		param.put("format", "pdf");
		// 返回封装好的数据对象
		mav = new ModelAndView(JasperReportsEnum.ku_maintence.toString(), param);
		// 添加操作日志
		super.addLog(request, "申请表报表预览");
		return mav;
	}

}
