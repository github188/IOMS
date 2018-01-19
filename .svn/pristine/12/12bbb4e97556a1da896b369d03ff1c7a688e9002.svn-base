/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-24 上午10:46:39
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.basedata.ku;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.model.FileUploadModel;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.ku.KuService;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;
import cn.com.atnc.ioms.model.chart.ChartIntegerArraySeries;

/**
 * 数据管理--Ku业务管理
 * 
 * @author:HuangYijie
 * @date:2014-3-24 上午10:46:39
 * @version:1.0
 */

public interface IKuServiceManager {
	/**
	 * 添加一个ku业务
	 * 
	 * @author:HuangYijie
	 * @param KuService
	 * @return
	 */
	public KuService add(KuService node) throws ServiceException;

	/**
	 * 更新ku业务信息
	 * 
	 * @author:HuangYijie
	 * @param KuService
	 */
	public KuService update(KuService node) throws ServiceException;

	/**
	 * 根据id查找对应的记录
	 * 
	 * @author:HuangYijie
	 * @param id
	 * @return
	 */
	public KuService findById(String id);

	/**
	 * 删除ku业务信息
	 * 
	 * @author:HuangYijie
	 * @param roleId
	 * @throws ManagerException
	 */
	public String delete(String id) throws ServiceException;

	public int deleteByNodeId(String id);

	/**
	 * 分页查询
	 * 
	 * @author:HuangYijie
	 * 
	 * @param model
	 * @return Pagination
	 */
	public Pagination queryPage(KuStatQueryModel model);

	/**
	 * 查询符合条件的记录数
	 * 
	 * @author:HuangYijie
	 * @Date:2014-3-28 下午2:35:24
	 * 
	 * @param model
	 * @return Long
	 */
	public Long querySize(KuStatQueryModel model);

	public List<KuService> queryList(KuStatQueryModel model);

	/**
	 * 导入Excel文件
	 * 
	 * @author:HuangYijie
	 * @Date:2014-3-28 下午2:35:34
	 * 
	 * @param fileUploadModel
	 * @param user
	 * @return
	 * @throws ServiceException
	 *             Vector<Vector<String>>
	 */
	public List<List<String>> doExcelImport(FileUploadModel fileUploadModel,
			User user) throws ServiceException;

	/**
	 * 导出excel文件
	 * 
	 * @author:HuangYijie
	 * @Date:2014-4-1 下午2:21:12
	 * 
	 * @param template
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException
	 *             Workbook
	 */
	public Workbook exportExcel(File template, KuStatQueryModel queryModel)
			throws IOException, InvalidFormatException;

	/**
	 * 加载载波图的series
	 * 
	 * @author:HuangYijie
	 * @Date:2014-5-29 下午5:26:59
	 * 
	 * @param ids
	 * @return List<ChartIntegerArraySeries>
	 */
	public List<ChartIntegerArraySeries> getChart(String ids);
	
	
	/**
	 * 根据维保设备获取KU相关参数
	 * @param model
	 * @param maintainEquip 
	 * @author WangLingbin
	 * @date  2016年5月3日下午3:05:07
	 * @since 1.0.0
	 */
	public Map<String, Object> getKuParams(MaintainEquip maintainEquip);

}
