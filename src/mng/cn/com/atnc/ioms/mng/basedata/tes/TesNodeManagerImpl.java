/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-24 上午10:50:11
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

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
import cn.com.atnc.ioms.dao.basedata.antenna.IAntennaDao;
import cn.com.atnc.ioms.dao.basedata.attenuator.IAttenuatorDao;
import cn.com.atnc.ioms.dao.basedata.equip.IEquipDao;
import cn.com.atnc.ioms.dao.basedata.odu.IOduDao;
import cn.com.atnc.ioms.dao.basedata.satellite.ISatelliteSiteDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesNodeDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesServiceDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesSlotDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesTeleDao;
import cn.com.atnc.ioms.dao.clientmng.IClientEquipDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.basedata.antenna.Antenna;
import cn.com.atnc.ioms.entity.basedata.attenuator.Attenuator;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatusLog;
import cn.com.atnc.ioms.entity.basedata.odu.Odu;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.basedata.tes.TesNode;
import cn.com.atnc.ioms.entity.basedata.tes.TesSlot;
import cn.com.atnc.ioms.entity.basedata.tes.TesTele;
import cn.com.atnc.ioms.enums.basedata.NetworkType;
import cn.com.atnc.ioms.model.basedata.EquipQueryModel;
import cn.com.atnc.ioms.model.basedata.satellite.AntennaQueryModel;
import cn.com.atnc.ioms.model.basedata.satellite.AttenuatorQueryModel;
import cn.com.atnc.ioms.model.basedata.satellite.OduQueryModel;
import cn.com.atnc.ioms.model.basedata.satellite.site.SiteQueryModel;
import cn.com.atnc.ioms.model.basedata.tes.TesNodeQueryModel;
import cn.com.atnc.ioms.model.basedata.tes.TesServiceQueryModel;
import cn.com.atnc.ioms.model.basedata.tes.TesTeleQueryModel;
import cn.com.atnc.ioms.model.operstat.ku.KuStatusLogQueryModel;
import cn.com.atnc.ioms.util.ExcelPoiTools;

@Service("TesNodeManager")
public class TesNodeManagerImpl extends AbstractService implements
		ITesNodeManager {

	@Autowired
	private ITesNodeDao tesNodeDao;
	@Autowired
	private IEquipDao equipDao;
	@Autowired
	private ISatelliteSiteDao siteDao;
	@Autowired
	private ITesSlotDao tesSlotDao;
	@Autowired
	private ITesServiceDao tesServiceDao;
	@Autowired
	private IOduDao oduDao;
	@Autowired
	private IAntennaDao antennaDao;
	@Autowired
	private IAttenuatorDao attenuatorDao;

	@Autowired
	private ITesTeleDao tesTeleDao;

	@Autowired
	private IClientEquipDao clientEquipDao;

	private final String regexMemo = "^[0-9\u4e00-\u9fa5a-z_A-Z\\pP‘’“”\\s]{0,50}$";// 备注正则表达式
	// private String regexSiteName = "^[0-9\u4e00-\u9fa5a-zA-Z()）（]{0,50}$";//
	// 站点名称正则表达式
	// private String regexStatus = "^[a-zA-Z]{0,50}$";// 状态正则
	// private String regexCardCount = "^[0-9]{1,2}$";// 板卡数量正则
	private final String regexTesNodeCode = "^[0-9A-Z]{4}$";// 机箱号正则
	private final String regexSiteCode = "^[A-Z0-9\\-]{3,10}$";// 站点名称正则表达式
	// private String regexTesNodeCode = "^[0-9]{2,4}$";// 节点号正则
	private final int columnNum = 3;

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager#add(cn.com.atnc.ioms.entity.basedata.ku.KuNode)
	 */
	@Override
	@Transactional
	public TesNode add(TesNode node) throws ServiceException {
		// TODO Auto-generated method stub

		SatelliteSite site = siteDao.findById(node.getSiteId());
		if (site == null) {
			throw new ServiceException("卫星站不存在!");
		}

		Equip equip = new Equip();
		equip.setBureau(site.getBureau());
		equip.setCode(node.getTesNodeCode());// 节点号是唯一的
		equip.setName(node.getTesNodeCode());
		equip.setType(NetworkType.TES);
		equip.setSatellite(siteDao.findById(node.getSiteId()));

		equipDao.save(equip);
		node.setEquip(equip);
		tesNodeDao.save(node);

		tesSlotDao.saveOrUpdateList(node.getTesSlotList());
		return node;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager#update(cn.com.atnc.ioms.entity.basedata.ku.KuNode)
	 */
	@Override
	@Transactional
	public TesNode update(TesNode node) throws ServiceException {
		// TODO Auto-generated method stub
		// 获取关联的设备
		Equip equip = node.getEquip();
		if (equip == null) {
			if (!StringTools.hasText(node.getEquipId())) {
				throw new ServiceException("无关联的设备");
			}
			equip = equipDao.findById(node.getEquipId());
			if (equip == null) {
				throw new ServiceException("数据库中无关联的设备信息");
			}
		}
		// 获取关联的卫星站点
		SatelliteSite site = node.getSatelliteSite();
		if (site == null) {
			if (!StringTools.hasText(node.getSiteId())) {
				throw new ServiceException("无关联的卫星站");
			}
			site = siteDao.findById(node.getSiteId());
			if (site == null) {
				throw new ServiceException("无关联的卫星站信息");
			}
		}
		// 更新设备信息
		equip.setBureau(site.getBureau());
		equip.setName(node.getTesNodeCode());
		equip.setCode(node.getTesNodeCode());// 节点号是唯一的，因此存储在编码字段。
		equip.setType(NetworkType.TES);
		equip.setSatellite(site);
		equipDao.saveOrUpdate(equip);

		// 更新节点
		node.setEquip(equip);
		tesNodeDao.saveOrUpdate(node);
		return node;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager#findById(java.lang.String)
	 */
	@Override
	public TesNode findById(String id) {
		// TODO Auto-generated method stub
		TesNode node = tesNodeDao.findById(id);
		if (node.getEquip() == null) {
			return node;
		}
		node.setEquipId(node.getEquip().getId());
		if (node.getEquip().getSatellite() == null) {
			return node;
		}
		node.setSiteCode(node.getEquip().getSatellite().getSiteCode());
		node.setSiteId(node.getEquip().getSatellite().getId());
		node.setBureau(node.getEquip().getBureau());
		// TesSlotListslot
		node.setTesSlotList(tesSlotDao.queryListByTesNode(node));
		return node;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager#delete(java.lang.String)
	 */
	@Transactional
	@Override
	public String delete(String id) throws ServiceException {
		
		TesNode node = findById(id);
		
		for (TesSlot tesSlot : node.getTesSlotList()) {
			tesSlotDao.delete(tesSlot);
		}
		if (node.getEquip() != null) {
			clientEquipDao.deleteEquip(node.getEquip().getId());
		}
		
		TesTeleQueryModel qm2 = new TesTeleQueryModel();
		qm2.setTesNodeIdLike(id);
		List<TesTele> lisuTele = tesTeleDao.queryList(qm2);
		for(int i = 0;i<lisuTele.size();i++){
			TesTele tesTele = lisuTele.get(i);
			tesTeleDao.delete(tesTele);
//			删除TesTele
		}
		
		tesServiceDao.deleteByNodeId(id);
		tesNodeDao.delete(node);
		equipDao.delete(node.getEquip());
		
		
		OduQueryModel qm3 = new OduQueryModel();
		qm3.setSiteId(node.getEquip().getSatellite().getId());
		List<Odu> lisODU = oduDao.findODUBySite(qm3);
//		System.out.println(lisODU.size());
		for(int i = 0;i<lisODU.size();i++){
			Odu odu = lisODU.get(i);
			oduDao.delete(odu);
			//删除odu	
		}
		AntennaQueryModel qm4 = new AntennaQueryModel();
		qm4.setSiteId(node.getEquip().getSatellite().getId());
		List<Antenna> lisAnt = antennaDao.queryList(qm4);
//		System.out.println(lisAnt.size());
		for(int i = 0;i<lisAnt.size();i++){
			Antenna antenna = lisAnt.get(i);
			antennaDao.delete(antenna);
			//删除Antenna	
		}
		
		AttenuatorQueryModel qm5 = new 	AttenuatorQueryModel();
		qm5.setSiteId(node.getEquip().getSatellite().getId());
		List<Attenuator> lisAtt = attenuatorDao.queryList(qm5);
//		System.out.println(lisAnt.size());
		for(int i = 0;i<lisAtt.size();i++){
			Attenuator attenuator = lisAtt.get(i);
			attenuatorDao.delete(attenuator);
			//删除Antenna	
		}
		System.out.println("删除成功");
		return node.getTesNodeCode();

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager#queryPage(cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel)
	 */
	@Override
	public Pagination queryPage(TesNodeQueryModel model) {
		// TODO Auto-generated method stub
		return tesNodeDao.queryPage(model);
	}

	@Override
	public Long querySize(TesNodeQueryModel model) {
		return tesNodeDao.querySize(model);
	}

	@Override
	public List<TesNode> queryList(TesNodeQueryModel model) {
		return tesNodeDao.queryList(model);
	}

	@Override
	@Transactional
	public Vector<Vector<String>> doExcelImport(FileUploadModel fileModel,
			User user) throws ServiceException {
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

				// 将字符串包装成TesNode
				TesNode node = new TesNode();
				// node.setBureau(Bureau.string2Enum(value.get("bureau").trim()));
				node.setInfo(value.get("info"));
				node.setTesNodeCode(value.get("tesNodeCode"));
				node.setSiteCode(value.get("siteCode"));
				node.setOptTime(Calendar.getInstance());
				node.setOptUser(user);

				// 判断TesNode是否已存在
				TesNodeQueryModel nodeQueryModel = new TesNodeQueryModel();
				nodeQueryModel.setTesNodeCode(value.get("tesNodeCode"));
				List<TesNode> nodeList = tesNodeDao.queryList(nodeQueryModel);
				if (nodeList.size() > 1) {
					data.add("机箱代码" + value.get("tesNodeCode") + "存在多条记录");
					failData.add(data);
					continue;
				}

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
					node.setSatelliteSite(site);
					node.setSiteId(site.getId());
				}

				// 查找是否已有相关抽象Equip记录
				EquipQueryModel equipQueryModel = new EquipQueryModel();
				equipQueryModel.setCode(value.get("tesNodeCode"));
				List<Equip> equipList = equipDao.queryList(equipQueryModel);
				if (CollectionUtils.isEmpty(equipList)) {
					// 如果为空，则新增一条
					this.add(node);
				} else if (equipList.size() > 1) {
					// 如果代码不唯一，则导入失败。
					data.add("设备" + value.get("tesNodeCode") + "存在多条记录"
							+ equipList.size());
					failData.add(data);
					continue;
				} else {

					node.setEquipId(equipList.get(0).getId());
					node.setEquip(equipList.get(0));
					// 查找tesnode表中 关联equipid 的记录
					TesNodeQueryModel tesNodeQueryModel = new TesNodeQueryModel();
					tesNodeQueryModel.setEquipId(node.getEquipId());
					List<TesNode> tesNodeList = tesNodeDao
							.queryList(tesNodeQueryModel);
					if (CollectionUtils.isEmpty(tesNodeList)) {
						// 如果tesnode表中没有关联到该equip的记录，则增加一条tesnode记录
						tesNodeDao.save(node);
					} else if (tesNodeList.size() > 1) {
						// 如果存在多条tesnode关联到一条equip上，则导入失败
						data.add("TES节点" + value.get("tesNodeCode") + "存在多条记录");
						failData.add(data);
						continue;
					} else {
						// 如果已有一条tesnode记录关联到equip，则更新
						TesNode nodeInDb = tesNodeList.get(0);
						// 将导入Excel中的记录内容更新至数据库中
						BeanUtils.copyProperties(nodeInDb, node,
								ignoreColumns.toArray(new String[0]));
						BeanUtils.copyProperties(node, nodeInDb);
						update(nodeInDb);
					}
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

			// 区域 站名 站点代码 机箱号 备注

			/*
			 * if (name.matches(".*区域.*")) { colNum.put("bureau", i); }
			 */
			/*
			 * if (name.matches(".*站名.*")) { colNum.put("siteName", i); }
			 */
			if (name.matches(".*站点代码.*")) {
				colNum.put("siteCode", i);
			}
			if (name.matches(".*机箱号.*")) {
				colNum.put("tesNodeCode", i);
			}

			if (name.matches(".*备注.*")) {
				colNum.put("info", i);
			}
		}

		if (CollectionUtils.isEmpty(colNum) || colNum.size() < columnNum) {
			throw new ServiceException("导入的数据文件格式不正确！");
		}

		/*
		 * if (colNum.get("bureau") == null) { throw new
		 * ServiceException("导入数据必须包含所属区域！"); }
		 */
		if (colNum.get("siteCode") == null) {
			throw new ServiceException("导入数据必须包含三字代码！");
		}

		/*
		 * if (colNum.get("siteName") == null) { throw new
		 * ServiceException("导入数据必须包含站点名称！"); }
		 */

		if (colNum.get("tesNodeCode") == null) {
			throw new ServiceException("导入数据必须包含机箱号!");
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

		String tesNodeCode = data.get(colNum.get("tesNodeCode")).trim();// .toUpperCase();

		if (!StringTools.hasText(tesNodeCode)
				|| !tesNodeCode.matches(regexTesNodeCode)) {
			throw new ServiceException("TES机箱号必须为4位数字、大写英文");
		}

		/*
		 * String bureau = (String) data.get(colNum.get("bureau")).trim(); if
		 * (!StringTools.hasText(bureau)) { throw new
		 * ServiceException("所属区域不能为空"); }
		 * 
		 * boolean exist = false; for (Bureau b : Bureau.values()) { if
		 * (b.getValue().trim().equals(bureau)) { exist = true; break; } } if
		 * (!exist) { throw new ServiceException("所属区域不存在"); }
		 */
		String siteCode = data.get(colNum.get("siteCode")).trim();
		// .toUpperCase();

		if (!StringTools.hasText(siteCode) || !siteCode.matches(regexSiteCode)) {
			throw new ServiceException("站点代码必须为3到10位数字、大写英文、-");
		}

		/*
		 * String siteCode = (String) data.get(colNum.get("siteCode")).trim()
		 * .toUpperCase(); if (!StringTools.hasText(siteCode)) { throw new
		 * ServiceException("站点代码不能为空"); }
		 * 
		 * if (!StringTools.hasText(siteCode) ||
		 * !siteCode.matches(regexSiteCode)) { throw new
		 * ServiceException("站点代码必须为3位大写英文"); }
		 */

		String info = "";// 备注
		// String siteName = "";

		if (colNum.get("info") != null) {
			info = data.get(colNum.get("info")).trim();
			if (StringTools.hasText(info) && !info.matches(regexMemo)) {
				throw new ServiceException("备注必须为50位以内的数字,中文,英文,标点符号,空白符");
			}
		}
		/*
		 * if (colNum.get("siteName") != null) { siteName = (String)
		 * data.get(colNum.get("siteName")).trim(); if
		 * (StringTools.hasText(siteName) && !siteName.matches(regexSiteName)) {
		 * throw new ServiceException("站点名称必须为50位以内的数字、中文、大小写英文 、中英文括号。"); } }
		 */
		// 校验通过的记录返回，否则抛出异常，存入failData中

		value.put("tesNodeCode", tesNodeCode);
		// value.put("bureau", bureau);
		value.put("siteCode", siteCode);
		/*
		 * value.put("cu", "cutest"); value.put("occ", "occtest");
		 */
		value.put("info", info);
		/* value.put("siteName", siteName); */
		return value;
	}

	@Override
	public Workbook exportExcel(File template, TesNodeQueryModel queryModel)
			throws IOException, InvalidFormatException {

		List<TesNode> tesNodes = tesNodeDao.queryList(queryModel);

		List<TesSlot> tesSlots = new ArrayList<TesSlot>();

		/*
		 * if (CollectionUtils.isEmpty(tesNodes)) { return null; }
		 */
		/*
		 * if (CollectionUtils.isEmpty(tesSlots)) { return null; }
		 */

		Workbook wb = null;
		Sheet sheet = null;
		Sheet sheetSlot = null;
		// 判断模板是否存在
		if (template == null) {
			// 不存在，则自己到处抬头行
			wb = new HSSFWorkbook();
			sheet = wb.createSheet("TES全网机箱统计表");// 注意获取sheet的方式不一样
			// ID 区域 站名 站点代码 机箱号 备注
			Row titleRow = sheet.createRow(0);
			titleRow.createCell(0).setCellValue("序号");
			titleRow.createCell(1).setCellValue("所属区域");
			titleRow.createCell(2).setCellValue("站名");
			titleRow.createCell(3).setCellValue("站点代码");
			titleRow.createCell(4).setCellValue("机箱号");
			titleRow.createCell(5).setCellValue("备注");

			sheetSlot = wb.createSheet("TES SLOT统计表");// 注意获取sheet的方式不一样
			Row titleRowSlot = sheetSlot.createRow(0);
			titleRowSlot.createCell(0).setCellValue("序号");
			titleRowSlot.createCell(1).setCellValue("机箱号");
			titleRowSlot.createCell(2).setCellValue("槽位号");
			titleRowSlot.createCell(3).setCellValue("OCC");
			titleRowSlot.createCell(4).setCellValue("备注");

		} else {
			// 存在，则直接获取模板中的抬头样式
			wb = ExcelPoiTools.create(new FileInputStream(template));
			if (!CollectionUtils.isEmpty(tesNodes)) {
				sheet = wb.getSheetAt(0);
				sheetSlot = wb.getSheetAt(1);
			}
		}
		if (CollectionUtils.isEmpty(tesNodes)) {
			return wb;
		}

		for (int i = 0; i < tesNodes.size(); i++) {
			Row row = sheet.createRow(i + 1);
			// 地区
			row.createCell(0).setCellValue(i + 1);
			row.createCell(1).setCellValue(
					tesNodes.get(i).getEquip() == null ? "" : (tesNodes.get(i)
							.getEquip().getBureau() == null ? "" : tesNodes
							.get(i).getEquip().getBureau().getValue()));
			// 站名
			row.createCell(2).setCellValue(
					tesNodes.get(i).getEquip() == null ? "" : (tesNodes.get(i)
							.getEquip().getSatellite() == null ? "" : tesNodes
							.get(i).getEquip().getSatellite().getSiteName()));
			// 三字代码
			row.createCell(3).setCellValue(
					tesNodes.get(i).getEquip() == null ? "" : (tesNodes.get(i)
							.getEquip().getSatellite() == null ? "" : tesNodes
							.get(i).getEquip().getSatellite().getSiteCode()));
			// 机箱号
			row.createCell(4).setCellValue(
					tesNodes.get(i).getTesNodeCode() == null ? "" : tesNodes
							.get(i).getTesNodeCode().toString());
			row.createCell(5).setCellValue(
					tesNodes.get(i).getInfo() == null ? "" : tesNodes.get(i)
							.getInfo());
			// 添加slot信息

			tesSlots.addAll(tesSlotDao.queryListByTesNode(tesNodes.get(i)));
		}

		// Slot 信息

		for (int i = 0; i < tesSlots.size(); i++) {
			Row row = sheetSlot.createRow(i + 1);
			row.createCell(0).setCellValue(i + 1);

			// 机箱号
			row.createCell(1).setCellValue(
					tesSlots.get(i).getTesNode() == null ? "" : tesSlots.get(i)
							.getTesNode().getTesNodeCode());
			// CU
			row.createCell(2).setCellValue(
					tesSlots.get(i).getCu() == null ? "" : tesSlots.get(i)
							.getCu());
			// OCC
			row.createCell(3).setCellValue(
					tesSlots.get(i).getOcc() == null ? "" : tesSlots.get(i)
							.getOcc().toString());
			row.createCell(4).setCellValue(
					tesSlots.get(i).getInfo() == null ? "" : tesSlots.get(i)
							.getInfo());
		}
		return wb;
	}

	@Override
	public List<TesNode> queryListByParam(TesNodeQueryModel queryModel) {
		// TODO Auto-generated method stub
		return tesNodeDao.queryList(queryModel);

	}

}
