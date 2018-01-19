/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-24 下午1:31:15
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.basedata.satellite.site;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.model.FileUploadModel;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.FileUpload;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.common.util.file.ProjectFilePath;
import cn.com.atnc.ioms.dao.basedata.satellite.ISatelliteSiteDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraph;
import cn.com.atnc.ioms.entity.reports.KuMaintenceEntity;
import cn.com.atnc.ioms.entity.reports.TeleGraphApplyEntity;
import cn.com.atnc.ioms.entity.reports.TeleGraphBaseInfoEntity;
import cn.com.atnc.ioms.entity.reports.TeleGraphConfigEntity;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.reports.ImageNameEnum;
import cn.com.atnc.ioms.enums.reports.JasperReportsEnum;
import cn.com.atnc.ioms.mng.reports.JasperReportService;
import cn.com.atnc.ioms.model.basedata.satellite.site.SiteQueryModel;
import cn.com.atnc.ioms.util.DataSourceFactory;
import cn.com.atnc.ioms.util.ExcelPoiTools;

/**
 * @author:HuangYijie
 * @date:2014-3-24 下午1:31:15
 * @version:1.0
 */
@Service("SiteManager")
public class SiteManagerImpl extends AbstractService implements ISiteManager {

	@Autowired
	private ISatelliteSiteDao siteDao;
	@Autowired
	private JasperReportService jasperReportService;

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.satellite.site.ISiteManager#queryListByParam(cn.com.atnc.ioms.model.basedata.satellite.site.SiteQueryModel)
	 */
	private final String regexName = "^[\u4e00-\u9fa5A-Z0-9\\s]{0,50}$";// 站点中文名称正则表达式
	private final String regexCode = "^[A-Z0-9\\-]{3,10}$";// 站点代码正则

	private final int columnNum = 5;

	@Override
	public List<SatelliteSite> queryListByParam(SiteQueryModel queryModel) {
		return siteDao.queryList(queryModel);
	}

	@Override
	public Pagination queryPage(SiteQueryModel queryModel) {
		// TODO Auto-generated method stub
		return siteDao.queryPage(queryModel);
	}

	@Override
	public Long querySize(SiteQueryModel model) {
		// TODO Auto-generated method stub
		return siteDao.querySize(model);
	}

	@Override
	public Long querySizeCodeCheck(SiteQueryModel model) {
		// TODO Auto-generated method stub
		return siteDao.querySizeCodeCheck(model);
	}

	@Override
	@Transactional
	public String delete(String id) throws ServiceException {
		// TODO Auto-generated method stub
		SiteQueryModel siteQueryModel = new SiteQueryModel();
		// siteQueryModel.setSiteId(id);
		siteQueryModel.setEquipId(id);
		if (siteDao.querySize(siteQueryModel) > 0) {
			// System.out.println("大小为："+siteDao.querySize(siteQueryModel));
			throw new ServiceException("该站点存在关联的设备，不可删除！");
		}
		SatelliteSite satelliteSite = findById(id);
		siteDao.delete(satelliteSite);
		return satelliteSite.getSiteName();
	}

	@Override
	public SatelliteSite findById(String id) {
		// TODO Auto-generated method stub
		SatelliteSite satelliteSite = siteDao.findById(id);
		// satelliteSite.setEquipId(satelliteSite.getId());
		return satelliteSite;
	}

	@Override
	@Transactional
	public SatelliteSite add(SatelliteSite node) throws ServiceException {
		// TODO Auto-generated method stub
		siteDao.save(node);
		return node;
	}

	@Override
	@Transactional
	public SatelliteSite update(SatelliteSite node) throws ServiceException {
		// TODO Auto-generated method stub
		siteDao.saveOrUpdate(node);
		return node;
	}

	@Override
	public Workbook exportExcel(SiteQueryModel queryModel, File template)
			throws IOException, InvalidFormatException {
		//
		List<SatelliteSite> satelliteSites = siteDao.queryList(queryModel);
		if (CollectionUtils.isEmpty(satelliteSites)) {
			return null;
		}
		Workbook wb = null;
		Sheet sheet = null;
		// 判断模板是否存在
		if (template == null) {
			// 不存在，则自己到处抬头行
			wb = new HSSFWorkbook();
			sheet = wb.createSheet("卫星站点");// 注意获取sheet的方式不一样
			Row titleRow = sheet.createRow(0);
			titleRow.createCell(0).setCellValue("所属管局");
			titleRow.createCell(1).setCellValue("站点中文名称");
			titleRow.createCell(2).setCellValue("站点代码");
			titleRow.createCell(3).setCellValue("备注信息");
		} else {
			// 存在，则直接获取模板中的抬头样式
			wb = ExcelPoiTools.create(new FileInputStream(template));
			if (!CollectionUtils.isEmpty(satelliteSites)) {
				sheet = wb.getSheetAt(0);
			}
		}
		if (CollectionUtils.isEmpty(satelliteSites)) {
			return wb;
		}
		// 将信息导入
		for (int i = 0; i < satelliteSites.size(); i++) {
			Row row = sheet.createRow(i + 1);
			// 给这一行的第一列赋值
			// 地区
			row.createCell(0).setCellValue(
					satelliteSites.get(i).getBureau().getValue());
			// name
			row.createCell(1).setCellValue(satelliteSites.get(i).getSiteName());

			row.createCell(2).setCellValue(satelliteSites.get(i).getSiteCode());
			row.createCell(3).setCellValue(satelliteSites.get(i).getType());
			row.createCell(4).setCellValue(satelliteSites.get(i).getInfo());
		}
		return wb;
	}

	@Override
	public Vector<Vector<String>> doExcelImport(
			FileUploadModel fileUploadModel, User user) throws ServiceException {
		// TODO Auto-generated method stub
		String path = ProjectFilePath.getTmpPath();
		String filePath = null;
		Vector<Vector<String>> failData = new Vector<Vector<String>>();
		try {
			// 将用户上传的文件保存至本地tmp文件夹中
			try {
				filePath = FileUpload.saveFile("",
						fileUploadModel.getLocalFilePath(), path);
			} catch (IOException e1) {
				throw new ServiceException("文件上传异常：" + e1.getMessage());
			}
			Vector<Vector<String>> productData;
			// 获取excel中的所有string字段
			try {
				productData = ExcelPoiTools.readFile(filePath, columnNum);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				throw new ServiceException("Excle文件读取异常：" + e1.getMessage());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				throw new ServiceException("Excle文件读取异常：" + e1.getMessage());
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				throw new ServiceException("Excle文件读取异常：" + e.getMessage());
			}

			if (CollectionUtils.isEmpty(productData)) {
				throw new ServiceException("数据文件中不包含导入数据！");
			}
			// 获取抬头，检验是否包含非空字段列
			Vector<String> title = productData.get(0);
			Map<String, Integer> colNum = getColNum(title);
			// 导入失败的行及原因
			title.add("错误信息");
			failData.add(title);
			// 生成bean复制是忽略的字段
			List<String> ignoreColumns = new ArrayList<>();
			for (String col : colNum.keySet()) {
				ignoreColumns.add(col);
			}
			ignoreColumns.add("equip");
			ignoreColumns.add("equipId");
			/* 数据包装导入 */
			for (int i = 1; i < productData.size(); i++) {

				Vector<String> data = productData.get(i);
				// 根据列的数目，补足一行数据的个数，如列有10个，一行数据仅有9个，则补足1个空白字段；
				int last = colNum.size() - data.size();
				while (last > 0) {
					data.add("");
					last--;
				}
				// 获得各字段对应的字符串 ，校验字符串是否符合标准，
				// 不符合标准的放到failData集合中，不影响后续记录的导入。
				Map<String, String> value = new HashMap<String, String>();

				try {
					value = getValueAndCheck(data, colNum);
				} catch (ServiceException e) {
					data.add(e.getMessage());
					failData.add(data);
					continue;
				} catch (UnsupportedEncodingException e) {
					data.add(e.getMessage());
					failData.add(data);
					continue;
				}
				// 将字符串包装成SatelliteSite
				SatelliteSite satelliteSite = new SatelliteSite();
				satelliteSite.setBureau(Bureau.string2Enum(value.get("bureau")
						.trim()));
				satelliteSite.setInfo(value.get("info"));
				satelliteSite.setSiteCode(value.get("siteCode"));
				satelliteSite.setSiteName(value.get("siteName"));
				satelliteSite.setType(value.get("type"));
				// 查找或新建相关的站点代码
				SiteQueryModel siteQueryModel = new SiteQueryModel();
				siteQueryModel.setCode(value.get("siteCode"));
				List<SatelliteSite> siteList = siteDao
						.queryList(siteQueryModel);

				if (siteList.size() > 1) {
					data.add("站点代码" + value.get("siteCode") + "存在多条记录");
					failData.add(data);
					continue;
				} else if (CollectionUtils.isEmpty(siteList)) {
					// 如果为空，则新增一条equip及kunode记录
					this.add(satelliteSite);
				} else // 只有一条记录，更新
				{
					SatelliteSite siteInDb = siteList.get(0);
					// 将导入Excel中的记录内容更新至数据库中
					BeanUtils.copyProperties(siteInDb, satelliteSite,
							ignoreColumns.toArray(new String[0]));
					BeanUtils.copyProperties(satelliteSite, siteInDb);
					update(siteInDb);
				}
			}
		} finally {
			FileUpload.delFile(filePath);
		}
		return failData;
	}

	/**
	 * 获取导入记录的抬头，判断是否包含非空列 除非空列，其他列可不存在，不存在的列数据库中的记录不被覆盖，保留原有数据
	 * 
	 * @author:lizhisheng
	 * @Date:2014-4-14 下午1:23:56
	 * 
	 * @param title
	 * @return
	 * @throws ServiceException
	 *             Map<String,Integer>
	 */
	private Map<String, Integer> getColNum(Vector<String> title)
			throws ServiceException {
		Map<String, Integer> colNum = new HashMap<String, Integer>();
		for (int i = 0; i < title.size(); i++) {
			String name = title.get(i);

			if (name.matches(".*区域.*")) {
				colNum.put("bureau", i);
			}
			if (name.matches(".*站点中文名称.*")) {
				colNum.put("siteName", i);
			}
			if (name.matches(".*站点代码.*")) {
				colNum.put("siteCode", i);
			}
			if (name.matches(".*备注.*")) {
				colNum.put("info", i);
			}
			if (name.matches(".*类型.*")) {
				colNum.put("type", i);
			}
		}
		if (CollectionUtils.isEmpty(colNum) || colNum.size() < columnNum) {
			throw new ServiceException("导入的数据文件格式不正确！");
		}
		if (colNum.get("bureau") == null) {
			throw new ServiceException("导入数据必须包含所属区域！");
		}
		if (colNum.get("siteCode") == null) {
			throw new ServiceException("导入数据必须包含站点代码！");
		}
		if (colNum.get("siteName") == null) {
			throw new ServiceException("导入数据必须包含站点名称！");
		}
		if (colNum.get("type") == null) {
			throw new ServiceException("导入数据必须包含类型！");
		}
		return colNum;
	}

	/**
	 * 获取一行数据的校验结果
	 * 
	 * @author:lizhisheng
	 * @Date:2014-4-14上午11:34:57
	 * 
	 * @param data
	 * @param colNum
	 * @return
	 * @throws ServiceException
	 * @throws UnsupportedEncodingException
	 *             Map<String,String>
	 */
	private Map<String, String> getValueAndCheck(Vector<String> data,
			Map<String, Integer> colNum) throws ServiceException,
			UnsupportedEncodingException {
		Map<String, String> value = new HashMap<String, String>();

		String bureau = data.get(colNum.get("bureau")).trim();
		if (!StringTools.hasText(bureau)) {
			throw new ServiceException("所属区域不能为空");
		}
		boolean exist = false;
		for (Bureau b : Bureau.values()) {
			if (b.getValue().trim().equals(bureau)) {
				exist = true;
				break;
			}
		}
		if (!exist) {
			throw new ServiceException("所属区域不存在");
		}
		String siteCode = data.get(colNum.get("siteCode")).trim().toUpperCase();
		if (!StringTools.hasText(siteCode) || !siteCode.matches(regexCode)) {
			throw new ServiceException("站点代码必须为3到10位数字，大写英文，-");
		}
		String info = "";// 备注
		String siteName = "";
		if (colNum.get("info") != null) {
			info = data.get(colNum.get("info")).trim();
			if (StringTools.hasText(info) && info.length() > 50) {
				throw new ServiceException("备注必须为50位以内字符");
			}
		}
		if (colNum.get("siteName") != null) {
			siteName = data.get(colNum.get("siteName")).trim().toUpperCase();
			if (StringTools.hasText(siteName) && !siteName.matches(regexName)) {
				throw new ServiceException("站点名称必须为50位以内的数字、中文、大写英文,空格");
			}
		}
		String type = "";
		if (colNum.get("type") != null) {
			type = data.get(colNum.get("type")).trim().toUpperCase();
			if (!StringTools.hasText(type)
					|| (!type.equals("TES") && !type.equals("KU"))) {
				throw new ServiceException("类型只能为TES或者KU");
			} else {
				type = type.toUpperCase();
			}
		}
		// 校验通过的记录返回，否则抛出异常，存入failData中
		value.put("bureau", bureau);
		value.put("siteCode", siteCode);
		value.put("info", info);
		value.put("siteName", siteName);
		value.put("type", type);
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getReportParams(HttpServletRequest request,
			String id, String reportName) {
		// 1.主报表数据源
		List<KuMaintenceEntity> entity = null;
		List<KuMaintenceEntity> datasource = null;
		// 2.子报表数据源
		List subreportDatasource = null;
		// 申请表
		entity = jasperReportService.getKuMeintenceDatasource(id);
		datasource = (List<KuMaintenceEntity>) DataSourceFactory
				.getBeanCollection(entity);//
		subreportDatasource = entity.get(0).getNodeInfos();
		// 3.获取报表相关参数，供预览使用
		Map<String, Object> param = jasperReportService.preView(request,
				datasource, subreportDatasource, reportName);
		return param;
	}

}
