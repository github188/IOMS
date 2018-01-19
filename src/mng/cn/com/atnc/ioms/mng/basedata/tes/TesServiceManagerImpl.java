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
import cn.com.atnc.ioms.dao.basedata.tes.ITesServiceDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesSlotDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.basedata.tes.TesNode;
import cn.com.atnc.ioms.entity.basedata.tes.TesService;
import cn.com.atnc.ioms.entity.basedata.tes.TesSlot;
import cn.com.atnc.ioms.model.basedata.satellite.site.SiteQueryModel;
import cn.com.atnc.ioms.model.basedata.tes.TesNodeQueryModel;
import cn.com.atnc.ioms.model.basedata.tes.TesServiceQueryModel;
import cn.com.atnc.ioms.model.basedata.tes.TesSlotQueryModel;
import cn.com.atnc.ioms.model.operstat.tes.TesStatQueryModel;
import cn.com.atnc.ioms.util.ExcelPoiTools;

@Service("TesServiceManager")
public class TesServiceManagerImpl extends AbstractService implements
		ITesServiceManager {

	@Autowired
	private ITesNodeDao tesNodeDao;
	@Autowired
	private IEquipDao equipDao;
	@Autowired
	private ISatelliteSiteDao siteDao;

	@Autowired
	private ITesServiceDao tesServiceDao;
	@Autowired
	private ITesSlotDao tesSlotDao;

	private final String regexMemo = "^[0-9\u4e00-\u9fa5a-z_A-Z\\pP‘’“”\\s]{0,50}$";// 备注正则表达式

	/*
	 * private String regexNodeId = "^[0-9A-Za-z]{1,20}$";// 节点代码正则 // private
	 * String regexNodeNo = "^[0-9]{1,3}$";// 节点号正则 private String NodeNo =
	 * "^[0-9]{5,8}$";// 时间正则 private String regexChan = "^[0-9]{1,2}$";// 端口号正则
	 */// private String regexNodeNo = "^[A-Z0-9]{4}$";// 机箱号

	private final String regexThreeCode = "^[A-Z0-9\\-]{3,10}$";// 站点名称正则表达式
	// //"^[A-Z]{3}$";//
	// 站点代码代码正则
	private final String regexSlot = "^[1-9][0-4]?$";// 槽位正则//1～14
	private final String regexRateType = "^([1-9]\\d*|0)(\\.\\d+)?$";// 速率正则
	// 界面限制10位^\\d+(\\.\\d+)?$
	// exp =
	// /^([1-9]\d*|0)(\.\d+)?$/;
	private final String regexBandWidthPool = "^[0-9A-Z-_]{1,20}$";// 频带池正则
	private final String regexSync = "^A?SYNC$";// 同异步正则
	private final String regexCircuteName = "^[0-9A-Z-]{1,20}$";// 电路名 正则
	// private String regexSiteName = "^[0-9\u4e00-\u9fa5a-zA-Z()）（]{0,50}$";//
	// 站点名称正则表达式
	private final String regexTesNodeCode = "^[0-9A-Z]{4}$";// 机箱号正则
	private final int columnNum = 12;
	private final String zserviceMemo = "^[0-9\u4e00-\u9fa5a-z_A-Z\\pP‘’“”\\s]{0,500}$"; //memo正则

	/*
	 * private String[] titleColumns = { "电路名", "主叫端站点", "主叫站点代码", "主叫机箱号",
	 * "主叫槽位号", "被叫端站点", "被叫站点代码", "被叫机箱号", "被叫槽位号", "电路速率", "频带池", "同异步", "备注"
	 * };
	 */
	@Override
	public List<TesService> queryList(TesServiceQueryModel qm) {
		return tesServiceDao.queryList(qm);
	}

	// 所属区域 电路名 主叫端站点 主叫站点代码 主叫机箱号 主叫槽位号
	// 被叫端站名 被叫站点代码 被叫机箱号 被叫槽位号 电路速率（kbps） 频带池 同异步

	@Override
	@Transactional
	public TesService add(TesService service) throws ServiceException {

		if (!StringTools.hasText(service.getActiveNodeCode())) {
			throw new ServiceException("主叫节点不能为空！");
		}
		if (!StringTools.hasText(service.getPassiveNodeCode())) {
			throw new ServiceException("被叫节点不能为空！");
		}

		checkServiceIsUnique(service);
		checkCircuteNameIsUnique(service);
		TesNodeQueryModel queryModel = new TesNodeQueryModel();

		// queryModel.setTesNodeCode(service.getActiveNode().getTesNodeCode());
		queryModel.setTesNodeCode(service.getActiveNodeCode());

		List<TesNode> nodeList = tesNodeDao.queryList(queryModel);
		if (CollectionUtils.isEmpty(nodeList)) {
			throw new ServiceException("主叫节点不存在！");
		} else if (nodeList.size() > 1) {
			throw new ServiceException("节点号"
					+ service.getActiveNode().getTesNodeCode() + "存在多条记录！");
		} else {
			service.setActiveNode(nodeList.get(0));
			// service.setRxNode(nodeList.get(0));
		}

		TesNodeQueryModel pqueryModel = new TesNodeQueryModel();
		pqueryModel.setTesNodeCode(service.getPassiveNodeCode());
		List<TesNode> pnodeList = tesNodeDao.queryList(pqueryModel);
		if (CollectionUtils.isEmpty(pnodeList)) {
			throw new ServiceException("被叫节点不存在！");
		} else if (pnodeList.size() > 1) {
			throw new ServiceException("节点号"
					+ service.getPassiveNode().getTesNodeCode() + "存在多条记录！");
		} else {
			service.setPassiveNode(pnodeList.get(0));
		}

		TesSlotQueryModel tesSlotQueryModel = new TesSlotQueryModel();
		tesSlotQueryModel.setCu(service.getActiveSlot());
		tesSlotQueryModel.setTesNodeId(service.getActiveNodeId());
		List<TesSlot> activeSlotList = tesSlotDao.queryList(tesSlotQueryModel);
		if (CollectionUtils.isEmpty(activeSlotList)) {
			throw new ServiceException("主叫槽位号不存在！");
		} else {
			service.setActiveSlot(activeSlotList.get(0).getCu());
		}
		TesSlotQueryModel tesPSlotQueryModel = new TesSlotQueryModel();
		tesPSlotQueryModel.setCu(service.getPassiveSlot());
		tesPSlotQueryModel.setTesNodeId(service.getPassiveNodeId());
		List<TesSlot> passiveSlotList = tesSlotDao
				.queryList(tesPSlotQueryModel);
		if (CollectionUtils.isEmpty(passiveSlotList)) {
			throw new ServiceException("被叫槽位号不存在！");
		} else {
			service.setPassiveSlot(passiveSlotList.get(0).getCu());
		}

		tesServiceDao.save(service);
		return service;

	}

	private void checkServiceIsUnique(TesService service)
			throws ServiceException {
		TesServiceQueryModel serviceQueryModel = new TesServiceQueryModel();
		// serviceQueryModel.setActiveNodeCode(service.getActiveNode().getTesNodeCode());
		serviceQueryModel.setExcludeId(service.getId());
		serviceQueryModel.setActiveNodeCode(service.getActiveNodeCode());
		serviceQueryModel.setActiveNodeSlot(service.getActiveSlot());

		serviceQueryModel.setPassiveNodeCode(service.getPassiveNodeCode());
		serviceQueryModel.setPassiveNodeSlot(service.getPassiveSlot());

		if (tesServiceDao.querySize(serviceQueryModel) > 0) {
			throw new ServiceException("主叫端(" + service.getActiveNodeCode()
					+ "-" + service.getActiveSlot() + ")至被叫端("
					+ service.getPassiveNodeCode() + "-"
					+ service.getPassiveSlot() + ")已存在！");
		}
	}

	@Override
	@Transactional
	public TesService update(TesService service) throws ServiceException {
		checkServiceIsUnique(service);
		checkCircuteNameIsUnique(service);
		TesNode txNode = service.getActiveNode();
		if (txNode == null) {
			if (!StringTools.hasText(service.getActiveNodeCode())) {
				throw new ServiceException("主叫端节点不能为空！");
			}
			TesNodeQueryModel queryModel = new TesNodeQueryModel();
			queryModel.setTesNodeCode(service.getActiveNodeCode());

			List<TesNode> nodeList = tesNodeDao.queryList(queryModel);
			if (CollectionUtils.isEmpty(nodeList)) {
				throw new ServiceException("主叫端节点不存在！");
			} else if (nodeList.size() > 1) {
				throw new ServiceException("节点号" + service.getActiveNodeCode()
						+ "存在多条记录！");
			} else {
				service.setActiveNode(nodeList.get(0));
			}
		}

		TesNode rxNode = service.getPassiveNode();
		if (rxNode == null) {
			if (!StringTools.hasText(service.getPassiveNodeCode())) {
				throw new ServiceException("被叫端节点不能为空！");
			}
			TesNodeQueryModel queryModel = new TesNodeQueryModel();
			queryModel.setTesNodeCode(service.getPassiveNodeCode());

			List<TesNode> nodeList = tesNodeDao.queryList(queryModel);
			if (CollectionUtils.isEmpty(nodeList)) {
				throw new ServiceException("被叫端节点不存在！");
			} else if (nodeList.size() > 1) {
				throw new ServiceException("节点号" + service.getPassiveNodeCode()
						+ "存在多条记录！");
			} else {
				service.setPassiveNode(nodeList.get(0));
			}
		}

		TesSlotQueryModel tesSlotQueryModel = new TesSlotQueryModel();
		tesSlotQueryModel.setCu(service.getActiveSlot());
		tesSlotQueryModel.setTesNodeId(service.getActiveNodeId());
		List<TesSlot> activeSlotList = tesSlotDao.queryList(tesSlotQueryModel);
		if (CollectionUtils.isEmpty(activeSlotList)) {
			throw new ServiceException("主叫槽位号不存在！");
		} else {
			service.setActiveSlot(activeSlotList.get(0).getCu());
		}
		tesSlotQueryModel.setCu(service.getPassiveSlot());
		List<TesSlot> passiveSlotList = tesSlotDao.queryList(tesSlotQueryModel);
		if (CollectionUtils.isEmpty(passiveSlotList)) {
			throw new ServiceException("被叫槽位号不存在！");
		} else {
			service.setPassiveSlot(passiveSlotList.get(0).getCu());
		}

		tesServiceDao.saveOrUpdate(service);
		return service;
	}

	@Override
	@Transactional
	public TesService updateRemark(TesService service) throws ServiceException {

		TesService bean = tesServiceDao.findById(service.getId());
		bean.setInfo(service.getInfo());
		tesServiceDao.saveOrUpdate(bean);
		return bean;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuServiceManager#findById(java.lang.String)
	 */
	@Override
	public TesService findById(String id) {
		// TODO Auto-generated method stub
		TesService service = tesServiceDao.findById(id);
		if (service == null) {
			return null;
		}
		if (service.getActiveNode() == null) {
			return service;
		}
		if (service.getPassiveNode() == null) {
			return service;
		}
		service.setActiveNodeCode(service.getActiveNode().getTesNodeCode());
		service.setPassiveNodeCode(service.getPassiveNode().getTesNodeCode());

		List<TesSlot> activeSlots = tesSlotDao.queryListByTesNode(service
				.getActiveNode());
		List<TesSlot> passiveSlots = tesSlotDao.queryListByTesNode(service
				.getPassiveNode()); // service.getPassiveNode().getTesSlotList();
		List<String> activeSlotCu = new ArrayList<String>();
		List<String> passiveSlotCu = new ArrayList<String>();
		for (TesSlot s : activeSlots) {
			activeSlotCu.add(s.getCu());
		}

		for (TesSlot s : passiveSlots) {
			passiveSlotCu.add(s.getCu());
		}

		service.setActiveSlots(activeSlotCu);
		service.setPassiveSlots(passiveSlotCu);

		return service;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuServiceManager#delete(java.lang.String)
	 */
	@Override
	public String delete(String id) throws ServiceException {
		// TODO Auto-generated method stub
		TesService service = findById(id);
		tesServiceDao.delete(service);
		return service.getCircuitName();

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuServiceManager#queryPage(cn.com.atnc.ioms.model.basedata.ku.KuServiceQueryModel)
	 */
	@Override
	public Pagination queryPage(TesServiceQueryModel model) {
		// TODO Auto-generated method stub
		return tesServiceDao.queryPage(model);
	}

	/*
	 * @Override public Pagination queryPage(TesServiceQueryModel model) { //
	 * TODO Auto-generated method stub return tesServiceDao.queryPage(model); }
	 */

	@Override
	public Long querySize(TesServiceQueryModel model) {
		return tesServiceDao.querySize(model);
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

			// 生成bean复制 忽略的字段
			List<String> ignoreColumns = new ArrayList<>();
			for (String col : colNum.keySet()) {
				ignoreColumns.add(col);
				// System.out.println("column:"+colNum);
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
				int last = colNum.size() - data.size();
				while (last > 0) {
					data.add("");
					last--;
				}
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

				// 将字符串包装成TesService
				TesService service = new TesService();
				service.setActiveNodeCode(value.get("activeNodeCode"));
				service.setActiveSlot(value.get("activeNodeSlot"));
				service.setPassiveNodeCode(value.get("passiveNodeCode"));
				service.setPassiveSlot(value.get("passiveNodeSlot"));
				service.setSync(value.get("syncFlag"));
				service.setRate(value.get("rateType"));
				service.setBandWidthPool(value.get("bandWidthPool"));
				service.setServiceMemo(value.get("serviceMemo"));
				service.setInfo(value.get("info"));
				service.setCircuitName(value.get("circuteName"));
				// service.setBureau(Bureau.string2Enum(value.get("bureau").trim()));
				service.setOptTime(Calendar.getInstance());
				service.setOptUser(user);

				// 查找卫星站点
				/*
				 * value.put("activeNodeSiteCode", activeNodeSiteCode);
				 * value.put("activeNodeCode", activeNodeCode);
				 * value.put("activeNodeSlot", activeNodeSlot);
				 * //value.put("passiveNodeSiteName", passiveNodeSiteName);
				 * value.put("passiveNodeSiteCode", passiveNodeSiteCode);
				 */

				SiteQueryModel siteQueryModel = new SiteQueryModel();
				siteQueryModel.setCode(value.get("activeNodeSiteCode"));
				List<SatelliteSite> siteList = siteDao
						.queryList(siteQueryModel);
				if (CollectionUtils.isEmpty(siteList)) {
					data.add("主叫卫星站点" + value.get("activeNodeSiteCode")
							+ "不存在！");
					failData.add(data);
					continue;
				} else if (siteList.size() > 1) {
					data.add("主叫卫星站点" + value.get("activeNodeSiteCode")
							+ "存在多条记录！");
					failData.add(data);
					continue;
				} else {
					service.setActiveSatelliteSite(siteList.get(0));
				}

				// 被叫卫星站点判断
				siteQueryModel.setCode(value.get("passiveNodeSiteCode"));
				siteList = siteDao.queryList(siteQueryModel);
				if (CollectionUtils.isEmpty(siteList)) {
					data.add("被叫卫星站点" + value.get("passiveNodeSiteCode")
							+ "不存在！");
					failData.add(data);
					continue;
				} else if (siteList.size() > 1) {
					data.add("被叫卫星站点" + value.get("passiveNodeSiteCode")
							+ "存在多条记录！");
					failData.add(data);
					continue;
				} else {
					service.setPassiveSatelliteSite(siteList.get(0));
				}

				// 查找或更新TES节点信息
				try {
					TesNode activeTesNode = checkTesNode(value
							.get("activeNodeCode"));
					service.setActiveNode(activeTesNode);
					service.setActiveNodeId(activeTesNode.getId());

					TesNode passiveTesNode = checkTesNode(value
							.get("passiveNodeCode"));
					service.setPassiveNode(passiveTesNode);
					service.setPassiveNodeId(passiveTesNode.getId());

					if (activeTesNode.getEquip().getSatellite() == null) {
						throw new ServiceException("卫星站点代码不存在！");
					}
					if (passiveTesNode.getEquip().getSatellite() == null) {
						throw new ServiceException("卫星站点代码不存在！");
					}
					if (!activeTesNode.getEquip().getSatellite().getSiteCode()
							.equals(value.get("activeNodeSiteCode"))) {
						throw new ServiceException("机箱号"
								+ value.get("activeNodeCode") + "与卫星站点代码"
								+ value.get("activeNodeSiteCode")
								+ "的对应关系与数据库中不一致！");
					}

					if (!passiveTesNode.getEquip().getSatellite().getSiteCode()
							.equals(value.get("passiveNodeSiteCode"))) {
						throw new ServiceException("机箱号"
								+ value.get("passiveNodeCode") + "与卫星站点代码"
								+ value.get("passiveNodeSiteCode")
								+ "的对应关系与数据库中不一致！");
					}
				} catch (ServiceException e) {
					data.add(e.getMessage());
					failData.add(data);
					continue;
				}
				// 更新或者修改TES业务
				// 主叫机箱号+主叫槽号+被叫机箱号+被叫槽号判断
				try {
					// 确认数据库中是否有相应的记录
					boolean isNew = false;
					TesService tesServiceInDB = getService(service);
					if (tesServiceInDB == null) {
						tesServiceInDB = service;
						isNew = true;
					} else {
						if (!tesServiceInDB.getCircuitName().equals(
								service.getCircuitName())) {
							data.add("Tes当前电路名为"
									+ tesServiceInDB.getCircuitName()
									+ ",与Excel导入数据不一致");
							failData.add(data);
							continue;
						}
					}
					tesServiceInDB.setActiveNodeCode(value
							.get("activeNodeCode"));
					tesServiceInDB.setActiveSlot(value.get("activeNodeSlot"));
					tesServiceInDB.setPassiveNodeCode(value
							.get("passiveNodeCode"));
					tesServiceInDB.setPassiveSlot(value.get("passiveNodeSlot"));
					tesServiceInDB.setSync(value.get("syncFlag"));
					tesServiceInDB.setRate(value.get("rateType"));
					tesServiceInDB.setBandWidthPool(value.get("bandWidthPool"));
					tesServiceInDB.setServiceMemo(value.get("serviceMemo"));
					tesServiceInDB.setInfo(value.get("info"));
					tesServiceInDB.setCircuitName(value.get("circuteName"));
					/*
					 * tesServiceInDB.setBureau(Bureau.string2Enum(value.get(
					 * "bureau" ) .trim()));
					 */
					tesServiceInDB.setOptTime(Calendar.getInstance());
					tesServiceInDB.setOptUser(user);
					if (isNew) {
						add(tesServiceInDB);
					} else {
						tesServiceInDB.setActiveNodeCode(tesServiceInDB
								.getActiveNode().getTesNodeCode());
						tesServiceInDB.setPassiveNodeCode(tesServiceInDB
								.getPassiveNode().getTesNodeCode());
						update(tesServiceInDB);
					}
				} catch (ServiceException se) {
					data.add(se.getMessage());
					failData.add(data);
					continue;
				}
			}
		} finally {
			FileUpload.delFile(filePath);
		}
		return failData;
	}

	private void checkCircuteNameIsUnique(TesService service)
			throws ServiceException {
		TesServiceQueryModel serviceQueryModel = new TesServiceQueryModel();
		serviceQueryModel.setCircuitName(service.getCircuitName());
		serviceQueryModel.setExcludeId(service.getId());
		if (tesServiceDao.querySize(serviceQueryModel) > 0) {
			throw new ServiceException("电路名(" + service.getCircuitName()
					+ ")已存在！");
		}
	}

	private TesService getService(TesService service) throws ServiceException {
		TesServiceQueryModel serviceQueryModel = new TesServiceQueryModel();
		serviceQueryModel.setActiveNodeCode(service.getActiveNodeCode());
		serviceQueryModel.setActiveNodeSlot(service.getActiveSlot());
		serviceQueryModel.setPassiveNodeCode(service.getPassiveNodeCode());
		serviceQueryModel.setPassiveNodeSlot(service.getPassiveSlot());
		serviceQueryModel.setExcludeId(service.getId());

		List<TesService> result = tesServiceDao.queryList(serviceQueryModel);
		if (CollectionUtils.isEmpty(result)) {
			return null;
		} else if (result.size() > 1) {
			throw new ServiceException("主叫端(" + service.getActiveNodeCode()
					+ "-" + service.getActiveSlot() + ")至被叫端("
					+ service.getPassiveNodeCode() + "-"
					+ service.getPassiveSlot() + ")存在多条记录！");
		} else {
			return result.get(0);
		}
	}

	private TesNode checkTesNode(String nodeCode) throws ServiceException {

		TesNodeQueryModel nodeQueryModel = new TesNodeQueryModel();
		nodeQueryModel.setTesNodeCode(nodeCode);
		List<TesNode> activeTesNodeList = tesNodeDao.queryList(nodeQueryModel);

		if (CollectionUtils.isEmpty(activeTesNodeList)) {
			throw new ServiceException("TES节点代码" + nodeCode + "不存在！");
		} else if (activeTesNodeList.size() > 1) {
			throw new ServiceException("TES节点代码" + nodeCode + "存在多条记录！");

		} else {
			return activeTesNodeList.get(0);

		}

	}

	private Map<String, Integer> getColNum(Vector<String> title)
			throws ServiceException {

		Map<String, Integer> colNum = new HashMap<String, Integer>();
		for (int i = 0; i < title.size(); i++) {
			System.out.println(title.size());

			String name = title.get(i);
			// if (!StringTools.hasText(name)) {
			// continue;
			// }
			/*
			 * if (name.matches(".*所属区域.*")) { colNum.put("bureau", i); }
			 */
			if (name.matches(".*电路名.*")) {
				colNum.put("circuteName", i);
			}
			// if (name.matches(".*主叫端站点.*")) {
			// colNum.put("activeNodeSiteName", i);
			// }
			if (name.matches(".*主叫站点代码.*")) {
				colNum.put("activeNodeSiteCode", i);
			}
			if (name.matches(".*主叫机箱号.*")) {
				colNum.put("activeNodeCode", i);
			}
			if (name.matches(".*主叫槽位号.*")) {
				colNum.put("activeNodeSlot", i);
			}
			// if (name.matches(".*被叫端站点.*")) {
			// colNum.put("passiveNodeSiteName", i);
			// }
			if (name.matches(".*被叫站点代码.*")) {
				colNum.put("passiveNodeSiteCode", i);
			}
			if (name.matches(".*被叫机箱号.*")) {
				colNum.put("passiveNodeCode", i);
			}
			if (name.matches(".*被叫槽位号.*")) {
				colNum.put("passiveNodeSlot", i);
			}
			if (name.matches(".*速率.*")) {
				colNum.put("rateType", i);
			}
			if (name.matches(".*频带池.*")) {
				colNum.put("bandWidthPool", i);
			}
			if (name.matches(".*收端信息.*")) {
				colNum.put("serviceMemo", i);
			}
			if (name.matches(".*同异步.*")) {
				colNum.put("syncFlag", i);
			}
			if (name.matches(".*备注.*")) {
				colNum.put("info", i);
			}
			/*
			 * for (String titleColumnsName : titleColumns) { if
			 * (name.trim().equalsIgnoreCase(titleColumnsName)) {
			 * colNum.put(titleColumnsName, i); break; } }
			 */
		}
		if (CollectionUtils.isEmpty(colNum) || colNum.size() < columnNum) {
			throw new ServiceException("导入的数据文件格式不正确！");
		}

		/*
		 * if (colNum.get("bureau") == null) { throw new
		 * ServiceException("导入数据必须包含所属区域!"); }
		 */

		if (colNum.get("circuteName") == null) {
			throw new ServiceException("导入数据必须包含电路名!");
		}

		/*
		 * if (colNum.get("activeNodeSiteName") == null) { throw new
		 * ServiceException("导入数据必须包含主叫端站点!"); }
		 */
		if (colNum.get("activeNodeSiteCode") == null) {
			throw new ServiceException("导入数据必须包含主叫站点代码!");
		}
		if (colNum.get("activeNodeCode") == null) {
			throw new ServiceException("导入数据必须包含主叫机箱号!");
		}
		if (colNum.get("activeNodeSlot") == null) {
			throw new ServiceException("导入数据必须包含主叫槽位号!");
		}
		/*
		 * if (colNum.get("passiveNodeSiteName") == null) { throw new
		 * ServiceException("导入数据必须包含被叫端站点!"); }
		 */
		if (colNum.get("passiveNodeSiteCode") == null) {
			throw new ServiceException("导入数据必须包含被叫端站点代码!");
		}
		if (colNum.get("passiveNodeCode") == null) {
			throw new ServiceException("导入数据必须包含被叫机箱号!");
		}
		if (colNum.get("passiveNodeSlot") == null) {
			throw new ServiceException("导入数据必须包含被叫槽位号!");
		}
		if (colNum.get("rateType") == null) {
			throw new ServiceException("导入数据必须包含速率!");
		}
		if (colNum.get("bandWidthPool") == null) {
			throw new ServiceException("导入数据必须包含频带池!");
		}
		if (colNum.get("serviceMemo") == null) {
			throw new ServiceException("导入数据必须包含收端信息!");
		}
		if (colNum.get("syncFlag") == null) {
			throw new ServiceException("导入数据必须包含同异步数据!");
		}

		if (colNum.get("info") == null) {
			throw new ServiceException("导入数据必须包含备注信息!");
		}

		/*
		 * for (String titleColumnsName : titleColumns) { if
		 * (colNum.get(titleColumnsName) == null) { throw new
		 * ServiceException("导入数据必须包含" + titleColumnsName + "!"); } }
		 */
		return colNum;
	}

	/**
	 * 获取一行数据的校验结果 { 所属区域 电路名 主叫站点代码 主叫机箱号 主叫槽位号 被叫站点代码 被叫机箱号 被叫槽位号 电路速率 频带池 同异步
	 * 备注 }
	 * 
	 * 
	 * 
	 */

	private Map<String, String> getValueAndCheck(Vector<String> data,
			Map<String, Integer> colNum) throws ServiceException,
			UnsupportedEncodingException {
		Map<String, String> value = new HashMap<String, String>();
		/*
		 * String bureau = (String) data.get(colNum.get("bureau")).trim(); if
		 * (!StringTools.hasText(bureau)) { throw new
		 * ServiceException("所属区域不能为空"); }
		 * 
		 * boolean exist = false; for (Bureau b : Bureau.values()) { if
		 * (b.getValue().equals(bureau)) { exist = true; break; } } if (!exist)
		 * { throw new ServiceException("所属区域不存在"); }
		 */
		String circuteName = data.get(colNum.get("circuteName")).trim();
		if (!StringTools.hasText(circuteName)
				|| !circuteName.matches(regexCircuteName)) {
			throw new ServiceException("电路名必须为20位以内数字、大写英文、-");
		}

		/*
		 * String activeNodeSiteName = (String) data.get(
		 * colNum.get("activeNodeSiteName")).trim(); if
		 * (StringTools.hasText(activeNodeSiteName) &&
		 * !activeNodeSiteName.matches(regexSiteName)) { throw new
		 * ServiceException("主叫端站点名称必须为50位以内的数字、中文、大小写英文 、中英文括号。"); }
		 */

		String activeNodeSiteCode = data.get(colNum.get("activeNodeSiteCode"))
				.trim();
		if (StringTools.hasText(activeNodeSiteCode)
				&& !activeNodeSiteCode.matches(regexThreeCode)) {
			throw new ServiceException("主叫站点代码必须为3到10位数字、大写英文、-");
		}

		String activeNodeCode = data.get(colNum.get("activeNodeCode")).trim();
		if (StringTools.hasText(activeNodeCode)
				&& !activeNodeCode.matches(regexTesNodeCode)) {
			throw new ServiceException("主叫机箱号必须为4位数字、大写英文");
		}

		String activeNodeSlot = data.get(colNum.get("activeNodeSlot")).trim();
		if (StringTools.hasText(activeNodeSlot)
				&& !activeNodeSlot.matches(regexSlot)) {
			throw new ServiceException("主叫槽位号必须为数字1-9、英文ABCDE");
		}

		/*
		 * String passiveNodeSiteName = (String) data.get(
		 * colNum.get("passiveNodeSiteName")).trim(); if
		 * (StringTools.hasText(passiveNodeSiteName) &&
		 * !passiveNodeSiteName.matches(regexSiteName)) { throw new
		 * ServiceException("被叫端站名必须为50位以内的数字、中文、大小写英文 、中英文括号。"); }
		 */

		String passiveNodeSiteCode = data
				.get(colNum.get("passiveNodeSiteCode")).trim();
		if (StringTools.hasText(passiveNodeSiteCode)
				&& !passiveNodeSiteCode.matches(regexThreeCode)) {
			throw new ServiceException("被叫站点代码必须为3-10位大写英文、数字、-");
		}

		String passiveNodeCode = data.get(colNum.get("passiveNodeCode")).trim();
		if (StringTools.hasText(passiveNodeCode)
				&& !passiveNodeCode.matches(regexTesNodeCode)) {
			throw new ServiceException("被叫机箱号必须为4位数字、大写英文");
		}

		String passiveNodeSlot = data.get(colNum.get("passiveNodeSlot")).trim();
		if (StringTools.hasText(passiveNodeSlot)
				&& !passiveNodeSlot.matches(regexSlot)) {
			throw new ServiceException("被叫槽位号必须为数字1-9、英文ABCDE");
		}

		String rateType = data.get(colNum.get("rateType")).trim();
		if (StringTools.hasText(rateType) && !rateType.matches(regexRateType)
				&& rateType.length() > 10) {
			throw new ServiceException("电路速率应为10位以内整数、浮点数");
		}
		String bandWidthPool = data.get(colNum.get("bandWidthPool")).trim();
		if (StringTools.hasText(bandWidthPool)
				&& !bandWidthPool.matches(regexBandWidthPool)) {
			throw new ServiceException("频带池必须为20位以内数字、-、_、大写英文");
		}
		String serviceMemo = data.get(colNum.get("serviceMemo")).trim();
		if (StringTools.hasText(serviceMemo) && !serviceMemo.matches(zserviceMemo)
				&&  serviceMemo.length() > 500) {
			throw new ServiceException("收端信息必须为500位以内数字、-、_、字符串");
		}

		String syncFlag = "";// 备注
		String info = "";
		if (colNum.get("syncFlag") != null) {
			syncFlag = data.get(colNum.get("syncFlag")).trim();
			if (StringTools.hasText(syncFlag) && !syncFlag.matches(regexSync)) {

				throw new ServiceException("同异步必须为SYNC、ASYNC");
			}
		}

		if (colNum.get("info") != null) {
			info = data.get(colNum.get("info")).trim();
			if (StringTools.hasText(info) && !info.matches(regexMemo)) {
				throw new ServiceException("备注必须为50位以内的数字,中文,英文,标点符号,空白符");
			}
		}

		value.put("circuteName", circuteName);
		// value.put("bureau", bureau);
		// value.put("activeNodeSiteName", activeNodeSiteName);
		value.put("activeNodeSiteCode", activeNodeSiteCode);
		value.put("activeNodeCode", activeNodeCode);
		value.put("activeNodeSlot", activeNodeSlot);
		// value.put("passiveNodeSiteName", passiveNodeSiteName);
		value.put("passiveNodeSiteCode", passiveNodeSiteCode);
		value.put("passiveNodeCode", passiveNodeCode);
		value.put("passiveNodeSlot", passiveNodeSlot);
		value.put("rateType", rateType);
		value.put("bandWidthPool", bandWidthPool);
		value.put("serviceMemo", serviceMemo);
		value.put("syncFlag", syncFlag);
		value.put("info", info);
		return value;
	}

	@Override
	public Workbook exportExcel(File template, TesServiceQueryModel queryModel)
			throws IOException, InvalidFormatException {
		List<TesService> tesServices = tesServiceDao.queryList(queryModel);
		/*
		 * if (CollectionUtils.isEmpty(tesServices)) { return null; }
		 */
		Workbook wb = null;
		Sheet sheet = null;
		// 判断模板是否存在
		if (template == null) {

			// 不存在，则自己导出抬头行
			wb = new HSSFWorkbook();
			sheet = wb.createSheet("TES数据电路统计");// 注意获取sheet的方式不一样
			Row titleRow = sheet.createRow(0);
			// 序号 所属区域 电路名 主叫端站点 主叫站点代码 主叫机箱号 主叫槽位号
			// 被叫端站点 被叫站点代码 被叫机箱号 被叫槽位号 电路速率（kbps） 频带池 同异步 备注
			int j = 0;
			titleRow.createCell(j++).setCellValue("序号");
			/* titleRow.createCell(1).setCellValue("所属地区"); */
			titleRow.createCell(j++).setCellValue("电路名");
			titleRow.createCell(j++).setCellValue("主叫端站点");
			titleRow.createCell(j++).setCellValue("主叫站点代码");
			titleRow.createCell(j++).setCellValue("主叫机箱号");
			titleRow.createCell(j++).setCellValue("主叫槽位号");
			titleRow.createCell(j++).setCellValue("被叫端站点");
			titleRow.createCell(j++).setCellValue("被叫站点代码");
			titleRow.createCell(j++).setCellValue("被叫机箱号");
			titleRow.createCell(j++).setCellValue("被叫槽位号");
			titleRow.createCell(j++).setCellValue("电路速率（kbps）");
			titleRow.createCell(j++).setCellValue("频带池");
			titleRow.createCell(j++).setCellValue("收端信息");
			titleRow.createCell(j++).setCellValue("同异步");
			titleRow.createCell(j++).setCellValue("备注");
		} else {
			// 存在，则直接获取模板中的抬头样式
			wb = ExcelPoiTools.create(new FileInputStream(template));
			if (!CollectionUtils.isEmpty(tesServices)) {
				sheet = wb.getSheetAt(0);
			}
		}
		if (CollectionUtils.isEmpty(tesServices)) {
			return wb;
		}
		// 将TesService的信息导入
		for (int i = 0; i < tesServices.size(); i++) {
			Row row = sheet.createRow(i + 1);
			// 给这一行的第一列赋值
			int j = 0;
			row.createCell(j++).setCellValue(i + 1);

			/*
			 * row.createCell(1).setCellValue( tesServices.get(i).getBureau() ==
			 * null ? "" : tesServices .get(i).getBureau().getValue());
			 */
			row.createCell(j++).setCellValue(
					tesServices.get(i).getCircuitName() == null ? ""
							: tesServices.get(i).getCircuitName());

			row.createCell(j++)
					.setCellValue(
							tesServices.get(i).getActiveNode() == null ? ""
									: (tesServices.get(i).getActiveNode()
											.getEquip() == null ? ""
											: (tesServices.get(i)
													.getActiveNode().getEquip()
													.getSatellite() == null ? ""
													: tesServices.get(i)
															.getActiveNode()
															.getEquip()
															.getSatellite()
															.getSiteName())));

			row.createCell(j++)
					.setCellValue(
							tesServices.get(i).getActiveNode() == null ? ""
									: (tesServices.get(i).getActiveNode()
											.getEquip() == null ? ""
											: (tesServices.get(i)
													.getActiveNode().getEquip()
													.getSatellite() == null ? ""
													: tesServices.get(i)
															.getActiveNode()
															.getEquip()
															.getSatellite()
															.getSiteCode())));

			row.createCell(j++).setCellValue(
					tesServices.get(i).getActiveNode() == null ? ""
							: tesServices.get(i).getActiveNode()
									.getTesNodeCode());
			row.createCell(j++).setCellValue(
					tesServices.get(i).getActiveSlot() == null ? ""
							: tesServices.get(i).getActiveSlot());

			row.createCell(j++)
					.setCellValue(
							tesServices.get(i).getPassiveNode() == null ? ""
									: (tesServices.get(i).getPassiveNode()
											.getEquip() == null ? ""
											: (tesServices.get(i)
													.getPassiveNode()
													.getEquip().getSatellite() == null ? ""
													: tesServices.get(i)
															.getPassiveNode()
															.getEquip()
															.getSatellite()
															.getSiteName())));

			row.createCell(j++)
					.setCellValue(
							tesServices.get(i).getPassiveNode() == null ? ""
									: (tesServices.get(i).getPassiveNode()
											.getEquip() == null ? ""
											: (tesServices.get(i)
													.getPassiveNode()
													.getEquip().getSatellite() == null ? ""
													: tesServices.get(i)
															.getPassiveNode()
															.getEquip()
															.getSatellite()
															.getSiteCode())));

			row.createCell(j++).setCellValue(
					tesServices.get(i).getPassiveNode() == null ? ""
							: tesServices.get(i).getPassiveNode()
									.getTesNodeCode());

			row.createCell(j++).setCellValue(
					tesServices.get(i).getPassiveSlot() == null ? ""
							: tesServices.get(i).getPassiveSlot());

			row.createCell(j++).setCellValue(
					tesServices.get(i).getRate() == null ? "" : tesServices
							.get(i).getRate());

			row.createCell(j++).setCellValue(
					tesServices.get(i).getBandWidthPool() == null ? ""
							: tesServices.get(i).getBandWidthPool());
			row.createCell(j++).setCellValue(
					tesServices.get(i).getServiceMemo() == null ? ""
							: tesServices.get(i).getServiceMemo());

			row.createCell(j++).setCellValue(
					tesServices.get(i).getSync() == null ? "" : tesServices
							.get(i).getSync());

			row.createCell(j++).setCellValue(
					tesServices.get(i).getInfo() == null ? "" : tesServices
							.get(i).getInfo());
		}
		return wb;
	}

	@Override
	public Pagination queryPage(TesStatQueryModel model) {
		// TODO Auto-generated method stub
		return tesServiceDao.queryPage(model);
	}

}
