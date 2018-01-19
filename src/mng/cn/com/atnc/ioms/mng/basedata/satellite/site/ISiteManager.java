/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-24 下午1:08:01
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.basedata.satellite.site;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.model.FileUploadModel;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.model.basedata.satellite.site.SiteQueryModel;

/**
 * @author:HuangYijie
 * @date:2014-3-24 下午1:08:01
 * @version:1.0
 */

public interface ISiteManager {
	/**
	 * 删除卫星站点信息
	 * 
	 * @author:lizhisheng
	 */
	public String delete(String id) throws ServiceException;

	/**
	 * 根据id查找对应的记录
	 * 
	 * @author:lizhisheng
	 */
	public SatelliteSite findById(String id);

	/**
	 * 添加一个卫星站点
	 * 
	 * @author:lizhisheng
	 */
	public SatelliteSite add(SatelliteSite node) throws ServiceException;

	/**
	 * 更新卫星站点信息
	 * 
	 * @author:lizhisheng
	 */
	public SatelliteSite update(SatelliteSite node) throws ServiceException;

	// 导出
	public Workbook exportExcel(SiteQueryModel queryModel, File template)
			throws IOException, InvalidFormatException;

	/**
	 * 导入Excel文件
	 * 
	 * @author:lizhisheng
	 * @Date:2014-4-14 上午10:08:34
	 * 
	 * @param fileUploadModel
	 * @param user
	 * @return
	 * @throws ServiceException
	 *             Vector<Vector<String>>
	 */
	public Vector<Vector<String>> doExcelImport(
			FileUploadModel fileUploadModel, User user) throws ServiceException;

	public Pagination queryPage(SiteQueryModel queryModel);

	public Long querySize(SiteQueryModel model);

	/**
	 * 
	 * 查询卫星站点代码是否唯一
	 * 
	 * @return
	 */
	public Long querySizeCodeCheck(SiteQueryModel model);

	public List<SatelliteSite> queryListByParam(SiteQueryModel queryModel);

	/**
	 * 获取报表数据源参数
	 * 
	 * @author 王凌斌
	 * @2017年1月23日 上午10:41:30
	 * @param request
	 * @param id
	 * @param string
	 * @return Map<String,Object>
	 */
	public Map<String, Object> getReportParams(HttpServletRequest request,
			String id, String string);
}
