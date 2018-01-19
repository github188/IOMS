package cn.com.atnc.ioms.mng.basedata.tes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

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
import cn.com.atnc.ioms.dao.basedata.equip.IEquipDao;
import cn.com.atnc.ioms.dao.basedata.satellite.ISatelliteSiteDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesNodeDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesSlotDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesTeleDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.basedata.tes.TesNode;
import cn.com.atnc.ioms.entity.basedata.tes.TesSlot;
import cn.com.atnc.ioms.entity.basedata.tes.TesTele;
import cn.com.atnc.ioms.model.basedata.satellite.site.SiteQueryModel;
import cn.com.atnc.ioms.model.basedata.tes.TesNodeQueryModel;
import cn.com.atnc.ioms.model.basedata.tes.TesSlotQueryModel;
import cn.com.atnc.ioms.model.basedata.tes.TesTeleQueryModel;
import cn.com.atnc.ioms.util.ExcelPoiTools;

@Service("TesTeleManager")
public class TesTeleManagerImpl extends AbstractService implements
		ITesTeleManager {

	@Autowired
	private ITesTeleDao tesTeleDao;
	@Autowired
	private IEquipDao equipDao;
	@Autowired
	private ISatelliteSiteDao siteDao;

	@Autowired
	private ITesNodeDao tesNodeDao;
	@Autowired
	private ITesSlotDao tesSlotDao;

	private final String regexTesNodeCode = "^[0-9A-Z]{4}$";// 机箱号正则
	private final String regexCu = "^([1-9]|1[0-4]|14)$";// 1-14 CU正则
	private final String regexPhone = "^[0-9]{1,5}$";// 1～9ABCDE CU正则
	// private String regexSiteName =
	// "^[0-9\u4e00-\u9fa5a-zA-Z()）（]{0,50}$";//站点名称正则表达式
	private final String regexSiteCode = "^[A-Z0-9\\-]{3,10}$";// 站点名称正则表达式//
																// "^[A-Z]{3}$";//
																// 站点名称正则表达式
	private final String regexMemo = "^[0-9\u4e00-\u9fa5a-z_A-Z\\pP‘’“”\\s]{0,50}$";// 备注正则表达式

	private final int columnNum = 5;

	@Override
	@Transactional
	public TesTele add(TesTele tele) throws ServiceException {
		// TODO Auto-generated method stub
		if (!StringTools.hasText(tele.getTesNodeCode())) {
			throw new ServiceException("机箱号不能为空！");
		}
		if (!StringTools.hasText(tele.getCu())) {
			throw new ServiceException("槽位号不能为空！");
		}
		if (!StringTools.hasText(tele.getPhoneNum())) {
			throw new ServiceException("电话号码不能为空！");
		}
		TesTeleQueryModel teleQueryModel = new TesTeleQueryModel();
		teleQueryModel.setExcludeId(tele.getId());
		teleQueryModel.setCu(tele.getCu());
		teleQueryModel.setTesNodeCode(tele.getTesNodeCode());

		if (tesTeleDao.querySize(teleQueryModel) > 0) {
			throw new ServiceException("(机箱号" + tele.getTesNodeCode() + "-槽位号"
					+ tele.getCu() + ")已存在电话号码！");
		}
		checkTeleIsUnique(tele);

		TesNodeQueryModel queryModel = new TesNodeQueryModel();
		queryModel.setTesNodeCode(tele.getTesNodeCode());
		List<TesNode> nodeList = tesNodeDao.queryList(queryModel);
		if (CollectionUtils.isEmpty(nodeList)) {
			throw new ServiceException("机箱号不存在！");
		} else if (nodeList.size() > 1) {
			throw new ServiceException("机箱号" + tele.getTesNodeCode()
					+ "存在多条记录！");
		} else {
			tele.setTesNode(nodeList.get(0));
			tele.setTesNodeId(nodeList.get(0).getId());
		}

		TesSlotQueryModel slotQueryModel = new TesSlotQueryModel();
		slotQueryModel.setTesNodeId(tele.getTesNodeId());
		slotQueryModel.setCu(tele.getCu());
		List<TesSlot> slotList = tesSlotDao.queryList(slotQueryModel);
		if (CollectionUtils.isEmpty(slotList)) {
			throw new ServiceException("槽位号不存在！");
		} else if (slotList.size() > 1) {
			throw new ServiceException("槽位号" + tele.getCu() + "存在多条记录！");
		}

		tesTeleDao.save(tele);
		return tele;
	}

	private void checkTeleIsUnique(TesTele tele) throws ServiceException {
		TesTeleQueryModel teleQueryModel = new TesTeleQueryModel();
		teleQueryModel.setExcludeId(tele.getId());
		teleQueryModel.setCu(tele.getCu());
		teleQueryModel.setTesNodeCode(tele.getTesNodeCode());

		teleQueryModel.setPhoneNum(tele.getPhoneNum());
		if (tesTeleDao.querySize(teleQueryModel) > 0) {
			throw new ServiceException("(电话号码" + tele.getPhoneNum() + "-机箱号"
					+ tele.getTesNodeCode() + "-槽位号" + tele.getCu() + ")已存在！");
		}

	}

	@Override
	@Transactional
	public TesTele update(TesTele tele) throws ServiceException {
		// TODO Auto-generated method stub
		checkTeleIsUnique(tele);
		TesNode node = tele.getTesNode();
		if (node == null) {
			if (!StringTools.hasText(tele.getTesNodeCode())) {
				throw new ServiceException("机箱号不能为空");
			}
			TesNodeQueryModel queryModel = new TesNodeQueryModel();
			queryModel.setTesNodeCode(tele.getTesNodeCode());
			List<TesNode> nodeList = tesNodeDao.queryList(queryModel);
			if (CollectionUtils.isEmpty(nodeList)) {
				throw new ServiceException("机箱号不存在！");
			} else if (nodeList.size() > 1) {
				throw new ServiceException("机箱号" + tele.getTesNodeCode()
						+ "存在多条记录！");
			} else {
				tele.setTesNode(nodeList.get(0));
				tele.setTesNodeId(nodeList.get(0).getId());
			}
		}

		TesSlotQueryModel slotQueryModel = new TesSlotQueryModel();
		slotQueryModel.setTesNodeId(tele.getTesNodeId());
		slotQueryModel.setCu(tele.getCu());
		List<TesSlot> slotList = tesSlotDao.queryList(slotQueryModel);
		if (CollectionUtils.isEmpty(slotList)) {
			throw new ServiceException("槽位号不存在！");
		} else if (slotList.size() > 1) {
			throw new ServiceException("槽位号" + tele.getCu() + "存在多条记录！");
		}

		tesTeleDao.saveOrUpdate(tele);
		return tele;
	}

	@Override
	public TesTele findById(String id) {
		// TODO Auto-generated method stub
		TesTele tele = tesTeleDao.findById(id);
		if (tele.getTesNode() == null) {
			return tele;
		}
		// tele.setTesNodeId(tele.getTesNode().getId());
		tele.setTesNodeCode(tele.getTesNode().getTesNodeCode());

		List<TesSlot> slots = tesSlotDao.queryListByTesNode(tele.getTesNode());
		List<String> cus = new ArrayList<String>();
		for (TesSlot s : slots) {
			cus.add(s.getCu());
		}
		tele.setCus(cus);
		return tele;
	}

	@Override
	public String delete(String id) throws ServiceException {
		// TODO Auto-generated method stub
		TesTele tele = findById(id);
		tesTeleDao.delete(tele);
		return "电话号码" + tele.getPhoneNum() + "-机箱号" + tele.getTesNodeCode()
				+ "-槽位号" + tele.getCu();

		// tele.getPhoneNum()+"-"+tele.getTesNodeCode()+"-"+tele.getCu();
	}

	@Override
	public Pagination queryPage(TesTeleQueryModel model) {
		// TODO Auto-generated method stub
		return tesTeleDao.queryPage(model);
	}

	@Override
	public List<TesTele> queryList(TesTeleQueryModel model) {
		// TODO Auto-generated method stub
		return tesTeleDao.queryList(model);
	}

	@Override
	public Long querySize(TesTeleQueryModel model) {
		// TODO Auto-generated method stub
		return tesTeleDao.querySize(model);
	}

	@Override
	@Transactional
	public Vector<Vector<String>> doExcelImport(FileUploadModel fileModel,
			User user) throws ServiceException {
		// TODO Auto-generated method stub
		String path = ProjectFilePath.getTmpPath();
		String filePath = null;
		Vector<Vector<String>> failData = new Vector<Vector<String>>();
		try {
			// 将用户上传的文件保存至本地tmp文件夹中
			try {
				filePath = FileUpload.saveFile("",
						fileModel.getLocalFilePath(), path);
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
			// 生成bean复制忽略的字段
			List<String> ignoreColumns = new ArrayList<>();
			for (String col : colNum.keySet()) {
				ignoreColumns.add(col);
			}

			ignoreColumns.add("equip");
			ignoreColumns.add("equipId");
			ignoreColumns.add("siteId");
			ignoreColumns.add("optUser");
			ignoreColumns.add("optTime");
			ignoreColumns.add("satelliteSite");

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
				// 将字符串包装成TesTele
				TesTele tele = new TesTele();
				tele.setPhoneNum(value.get("phoneNum"));
				tele.setCu(value.get("slot"));
				tele.setInfo(value.get("info"));
				tele.setOptTime(Calendar.getInstance());
				tele.setOptUser(user);

				// 查找或新建相关的站点代码
				SiteQueryModel siteQueryModel = new SiteQueryModel();
				siteQueryModel.setCode(value.get("siteCode"));
				List<SatelliteSite> siteList = siteDao
						.queryList(siteQueryModel);
				SatelliteSite site = null;
				if (CollectionUtils.isEmpty(siteList)) {
					data.add("站点代码" + value.get("siteCode") + "不存在");
					failData.add(data);
					continue;
				} else if (siteList.size() > 1) {
					data.add("站点代码" + value.get("siteCode") + "存在多条记录");
					failData.add(data);
					continue;
				} else {
					site = siteList.get(0);
					tele.setSatelliteSite(site);
				}

				// 节点信息判断
				TesNodeQueryModel tesNodeQueryModel = new TesNodeQueryModel();
				tesNodeQueryModel.setTesNodeCode(value.get("tesNodeCode"));
				List<TesNode> tesNodeList = tesNodeDao
						.queryList(tesNodeQueryModel);
				if (CollectionUtils.isEmpty(tesNodeList)) {
					data.add("TES机箱号" + value.get("tesNodeCode") + "不存在");
					failData.add(data);
					continue;
				} else if (tesNodeList.size() > 1) {
					data.add("TES机箱号" + value.get("tesNodeCode") + "存在多条记录");
					failData.add(data);
					continue;
				} else {
					// 如果已有一条tesnode记录关联到equip，则更新
					// TesNode nodeInDb = tesNodeList.get(0);
					tele.setTesNode(tesNodeList.get(0));
					tele.setTesNodeCode(tesNodeList.get(0).getTesNodeCode());
				}

				// 卫星站点与机箱号关系判断
				try {

					if (tele.getTesNode().getEquip().getSatellite() == null) {
						throw new ServiceException("卫星站点代码不存在！");
					}

					if (!tele.getTesNode().getEquip().getSatellite()
							.getSiteCode().equals(value.get("siteCode"))) {
						throw new ServiceException("机箱号"
								+ value.get("tesNodeCode") + "与卫星站点代码"
								+ value.get("siteCode") + "的对应关系与数据库中不一致！");
					}

				} catch (ServiceException e) {
					data.add(e.getMessage());
					failData.add(data);
					continue;
				}

				// 槽号信息判断
				TesSlotQueryModel tesSLotQueryModel = new TesSlotQueryModel();
				tesSLotQueryModel.setCu(value.get("slot"));
				tesSLotQueryModel.setTesNodeId(tele.getTesNode().getId());

				List<TesSlot> tesSlotList = tesSlotDao
						.queryList(tesSLotQueryModel);
				if (CollectionUtils.isEmpty(tesSlotList)) {
					data.add("TES槽号" + value.get("slot") + "不存在");
					failData.add(data);
					continue;
				} else if (tesSlotList.size() > 1) {
					data.add("TES槽号" + value.get("slot") + "存在多条记录");
					failData.add(data);
					continue;
				} else {
					tele.setCu(tesSlotList.get(0).getCu());
				}

				// 判断是否已存在记录
				TesTeleQueryModel teleQueryModel = new TesTeleQueryModel();
				teleQueryModel.setCu(value.get("slot"));
				teleQueryModel.setPhoneNum(value.get("phoneNum"));
				teleQueryModel.setTesNodeCode(tele.getTesNode()
						.getTesNodeCode());
				List<TesTele> tesTeleList = tesTeleDao
						.queryList(teleQueryModel);
				if (CollectionUtils.isEmpty(tesTeleList)) {
					// this.addExcel(tele);
					tesTeleDao.save(tele);
				} else if (tesNodeList.size() > 1) {
					data.add("TES卫星电话(电话号码" + value.get("phoneNum") + "-"
							+ "机箱号" + value.get("tesNodeCode") + "-" + "槽号"
							+ value.get("slot") + "存在多条记录");
					failData.add(data);
					continue;
				} else {
					TesTele teleInDb = tesTeleList.get(0);
					BeanUtils.copyProperties(teleInDb, tele,
							ignoreColumns.toArray(new String[0]));
					BeanUtils.copyProperties(tele, teleInDb);
					// update(teleInDb);
					tesTeleDao.save(teleInDb);
				}
			}
		} finally {
			FileUpload.delFile(filePath);
		}
		return failData;
	}

	private Map<String, Integer> getColNum(Vector<String> title)
			throws ServiceException {
		Map<String, Integer> colNum = new HashMap<String, Integer>();
		for (int i = 0; i < title.size(); i++) {
			String name = title.get(i);
			// 电话号码 站点代码 机箱号 槽位号 备注
			if (name.matches(".*电话号码.*")) {
				colNum.put("phoneNum", i);
			}
			if (name.matches(".*站点代码.*")) {
				colNum.put("siteCode", i);
			}
			if (name.matches(".*机箱号.*")) {
				colNum.put("tesNodeCode", i);
			}
			if (name.matches(".*槽位号.*")) {
				colNum.put("slot", i);
			}
			if (name.matches(".*备注.*")) {
				colNum.put("info", i);
			}
		}

		if (CollectionUtils.isEmpty(colNum) || colNum.size() < columnNum) {
			throw new ServiceException("导入的数据文件格式不正确！");
		}

		if (colNum.get("phoneNum") == null) {
			throw new ServiceException("导入数据必须包含电话号码！");
		}
		/*
		 * if (colNum.get("siteName") == null) { throw new
		 * ServiceException("导入数据必须包含所属站点！"); }
		 */

		if (colNum.get("siteCode") == null) {
			throw new ServiceException("导入数据必须包含站点代码！");
		}

		if (colNum.get("tesNodeCode") == null) {
			throw new ServiceException("导入数据必须包含机箱号!");
		}
		if (colNum.get("slot") == null) {
			throw new ServiceException("导入数据必须包含槽位号!");
		}
		if (colNum.get("info") == null) {
			throw new ServiceException("导入数据必须包含有备注数据！");
		}
		return colNum;
	}

	private Map<String, String> getValueAndCheck(Vector<String> data,
			Map<String, Integer> colNum) throws ServiceException,
			UnsupportedEncodingException {
		Map<String, String> value = new HashMap<String, String>();

		String phoneNum = data.get(colNum.get("phoneNum")).trim().toUpperCase();
		if (!StringTools.hasText(phoneNum) || !phoneNum.matches(regexPhone)) {
			throw new ServiceException("电话号码必须为1-5位数字");
		}
		String slot = data.get(colNum.get("slot")).trim().toUpperCase();

		if (!StringTools.hasText(slot) || !slot.matches(regexCu)) {
			throw new ServiceException("槽位号必须为数字1-14");
		}

		String tesNodeCode = data.get(colNum.get("tesNodeCode")).trim()
				.toUpperCase();

		if (!StringTools.hasText(tesNodeCode)
				|| !tesNodeCode.matches(regexTesNodeCode)) {
			throw new ServiceException("TES机箱号必须为4位数字、大写英文");
		}

		String siteCode = data.get(colNum.get("siteCode")).trim().toUpperCase();
		if (!StringTools.hasText(siteCode) || !siteCode.matches(regexSiteCode)) {
			throw new ServiceException("站点代码必须为3到10位数字、大写英文、-");
		}

		String info = "";// 备注
		if (colNum.get("info") != null) {
			info = data.get(colNum.get("info")).trim();
			if (StringTools.hasText(info) && !info.matches(regexMemo)) {
				throw new ServiceException("备注必须为50位以内的数字,中文,英文,标点符号,空白符");
			}
		}

		// 校验通过的记录返回，否则抛出异常，存入failData中
		value.put("phoneNum", phoneNum);
		value.put("slot", slot);
		value.put("tesNodeCode", tesNodeCode);
		value.put("siteCode", siteCode);
		value.put("info", info);
		return value;
	}

	@Override
	public Workbook exportExcel(File template, TesTeleQueryModel queryModel)
			throws IOException, InvalidFormatException {
		// TODO Auto-generated method stub
		List<TesTele> tesTeles = tesTeleDao.queryList(queryModel);
		/*
		 * if (CollectionUtils.isEmpty(tesTeles)) { return null; }
		 */
		Workbook wb = null;
		Sheet sheet = null;
		// 判断模板是否存在
		if (template == null) {
			// 不存在，则自己导出抬头行
			wb = new HSSFWorkbook();
			sheet = wb.createSheet("TES卫星电话统计");// 注意获取sheet的方式不一样
			Row titleRow = sheet.createRow(0);
			// 序号 电话号码 所属站点 站点代码 机箱号 槽位号 备注
			titleRow.createCell(0).setCellValue("序号");
			titleRow.createCell(1).setCellValue("电话号码");
			titleRow.createCell(2).setCellValue("所属站点");
			titleRow.createCell(3).setCellValue("站点代码");
			titleRow.createCell(4).setCellValue("机箱号");
			titleRow.createCell(5).setCellValue("槽位号");
			titleRow.createCell(6).setCellValue("备注");

		} else {
			// 存在，则直接获取模板中的抬头样式
			wb = ExcelPoiTools.create(new FileInputStream(template));
			if (!CollectionUtils.isEmpty(tesTeles)) {
				sheet = wb.getSheetAt(0);
			}
		}
		if (CollectionUtils.isEmpty(tesTeles)) {
			return wb;
		}
		// 将TesService的信息导入
		for (int i = 0; i < tesTeles.size(); i++) {
			int j = 0;
			Row row = sheet.createRow(i + 1);
			// 给这一行的第一列赋值
			row.createCell(j++).setCellValue(i + 1);
			row.createCell(j++).setCellValue(
					tesTeles.get(i).getPhoneNum() == null ? "" : tesTeles
							.get(i).getPhoneNum());

			row.createCell(j++).setCellValue(
					tesTeles.get(i).getTesNode() == null ? "" : (tesTeles
							.get(i).getTesNode().getEquip() == null ? ""
							: (tesTeles.get(i).getTesNode().getEquip()
									.getSatellite() == null ? "" : tesTeles
									.get(i).getTesNode().getEquip()
									.getSatellite().getSiteName())));

			row.createCell(j++).setCellValue(
					tesTeles.get(i).getTesNode() == null ? "" : (tesTeles
							.get(i).getTesNode().getEquip() == null ? ""
							: (tesTeles.get(i).getTesNode().getEquip()
									.getSatellite() == null ? "" : tesTeles
									.get(i).getTesNode().getEquip()
									.getSatellite().getSiteCode())));

			row.createCell(j++).setCellValue(
					tesTeles.get(i).getTesNode() == null ? "" : tesTeles.get(i)
							.getTesNode().getTesNodeCode());

			row.createCell(j++).setCellValue(
					tesTeles.get(i).getCu() == null ? "" : tesTeles.get(i)
							.getCu());

			row.createCell(j++).setCellValue(
					tesTeles.get(i).getInfo() == null ? "" : tesTeles.get(i)
							.getInfo());
		}
		return wb;
	}
}
