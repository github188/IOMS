/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-24 上午10:50:11
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.basedata.ku;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.util.ObjectUtils;

import org.apache.commons.lang.StringUtils;
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
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuServiceDao;
import cn.com.atnc.ioms.dao.basedata.satellite.ISatelliteSiteDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.ku.KuNode;
import cn.com.atnc.ioms.entity.basedata.ku.KuService;
import cn.com.atnc.ioms.entity.maintain.equip.EquipNode;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.CircuitTypeDetail;
import cn.com.atnc.ioms.enums.basedata.KuServiceRateType;
import cn.com.atnc.ioms.enums.basedata.SubnetType;
import cn.com.atnc.ioms.mng.maintain.equip.IEquipNodeManager;
import cn.com.atnc.ioms.model.SysFinals;
import cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;
import cn.com.atnc.ioms.model.chart.ChartIntegerArraySeries;
import cn.com.atnc.ioms.util.ExcelPoiTools;

/**
 * @author:HuangYijie
 * @date:2014-3-24 上午10:50:11
 * @version:1.0
 */
@Service("KuServiceManager")
public class KuServiceManagerImpl extends AbstractService implements
		IKuServiceManager {

	@Autowired
	private IKuNodeDao kuNodeDao;
	@Autowired
	private IEquipDao equipDao;
	@Autowired
	private ISatelliteSiteDao siteDao;

	@Autowired
	private IKuServiceDao kuServiceDao;
	@Autowired
	private IEquipNodeManager equipNodeManager;
	@Autowired
	private IKuNodeManager kuNodeManager;

	private final String regexCode = "^[0-9A-Z-]{1,20}$";// 电路名正则
	private final String regexNodeId = "^[0-9A-Za-z]{1,20}$";// 节点代码正则
	private final String regexNodeNo = "^[0-9]{1,3}$";// 节点号正则
	// private String regexConfigTime = "^[0-9]{6}$";// 时间正则
	private final String regexGib = "^[1-9][0-9]?$";// 槽位正则
	private final String regexChan = "^[0-9]{1,2}$";// 端口号正则
	private final String regexmemo = "^[0-9\u4e00-\u9fa5a-z_A-Z\\pP‘’“”\\s]{0,500}$"; // memo正则

	private final String[] titleColumns = { "所属地区", "电路名", "配置时间", "电路类型",
			"电路速率描述", "电路速率", "发端节点ID", "发端站名", "发端子网类型", "发端节点号", "发端槽位号",
			"发端端口号", "收端节点ID", "收端站名", "收端子网类型", "收端节点号", "收端槽位号", "收端端口号",
			"收端信息", "电路情况", "业务类型", "CRM情况", "电路使用情况", "备注" };

	@Override
	@Transactional
	public KuService add(KuService service) throws ServiceException {
		if (!StringTools.hasText(service.getRxNodeNo())) {
			throw new ServiceException("收端节点不能为空！");
		}
		if (!StringTools.hasText(service.getTxNodeNo())) {
			throw new ServiceException("发端节点不能为空！");
		}
		checkServiceIsUnique(service);
		// checkCodeIsUnique(service);
		KuNodeQueryModel queryModel = new KuNodeQueryModel();
		queryModel.setKuNodeNo(service.getRxNodeNo());
		// dyl add 子网类型添加
		queryModel.setSubnetType(service.getSubnetTypeRx());
		List<KuNode> nodeList = kuNodeDao.queryList(queryModel);
		if (CollectionUtils.isEmpty(nodeList)) {
			throw new ServiceException("收端节点不存在！");
		} else if (nodeList.size() > 1) {
			throw new ServiceException("节点号" + service.getRxNodeNo()
					+ "存在多条记录！");
		} else {
			service.setRxNode(nodeList.get(0));
		}

		queryModel = new KuNodeQueryModel();
		queryModel.setKuNodeNo(service.getTxNodeNo());
		// dyl add 子网类型添加
		queryModel.setSubnetType(service.getSubnetTypeTx());
		nodeList = kuNodeDao.queryList(queryModel);
		if (CollectionUtils.isEmpty(nodeList)) {
			throw new ServiceException("发端节点不存在！");
		} else if (nodeList.size() > 1) {
			throw new ServiceException("节点号" + service.getTxNodeNo()
					+ "存在多条记录！");
		} else {
			service.setTxNode(nodeList.get(0));
		}
		service.setOptTime(Calendar.getInstance());
		service.setRecordTime(service.getOptTime());
		kuServiceDao.save(service);
		return service;

	}

	/**
	 * 检查收发端节点号+槽号+端口号是否唯一
	 * 
	 * @author:HuangYijie
	 * @Date:2014-4-29 下午4:40:55
	 * 
	 * @param service
	 * @throws ServiceException
	 *             void
	 */
	private void checkServiceIsUnique(KuService service)
			throws ServiceException {
		KuStatQueryModel serviceQueryModel = new KuStatQueryModel();
		serviceQueryModel.setRxNodeNo(service.getRxNodeNo());
		// dyl add 验证子网
		serviceQueryModel.setSubnetTypeRx(service.getSubnetTypeRx());
		serviceQueryModel.setRxGib(service.getRxGib());
		serviceQueryModel.setRxChan(service.getRxChan());
		// dyl add 验证子网
		serviceQueryModel.setSubnetTypeTx(service.getSubnetTypeTx());
		serviceQueryModel.setTxNodeNo(service.getTxNodeNo());
		serviceQueryModel.setTxGib(service.getTxGib());
		serviceQueryModel.setTxChan(service.getTxChan());
		serviceQueryModel.setExcludeId(service.getId());
		if (kuServiceDao.querySize(serviceQueryModel) > 0) {
			throw new ServiceException("发端(" + service.getTxNodeNo() + "-"
					+ service.getTxGib() + "-" + service.getTxChan() + ")至收端("
					+ service.getRxNodeNo() + "-" + service.getRxGib() + "-"
					+ service.getRxChan() + ")已存在！");
		}
	}

	/**
	 * 检查电路名是否唯一
	 * 
	 * @author:HuangYijie
	 * @Date:2014-4-29 下午4:41:32
	 * 
	 * @param service
	 * @throws ServiceException
	 *             void
	 */
	private void checkCodeIsUnique(KuService service) throws ServiceException {
		KuStatQueryModel serviceQueryModel = new KuStatQueryModel();
		serviceQueryModel.setCode(service.getCode());
		serviceQueryModel.setExcludeId(service.getId());
		if (kuServiceDao.querySize(serviceQueryModel) > 0) {
			throw new ServiceException("电路名(" + service.getCode() + ")已存在！");
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuServiceManager#update(cn.com.atnc.ioms.entity.basedata.ku.KuService)
	 */
	@Override
	@Transactional
	public KuService update(KuService service) throws ServiceException {

		checkServiceIsUnique(service);
		// checkCodeIsUnique(service);
		KuNode rxNode = service.getRxNode();
		if (rxNode == null) {
			if (!StringTools.hasText(service.getRxNodeNo())) {
				throw new ServiceException("收端节点不能为空！");
			}
			KuNodeQueryModel queryModel = new KuNodeQueryModel();
			queryModel.setKuNodeNo(service.getRxNodeNo());
			queryModel.setSubnetType(service.getSubnetTypeRx());
			List<KuNode> nodeList = kuNodeDao.queryList(queryModel);
			if (CollectionUtils.isEmpty(nodeList)) {
				throw new ServiceException("收端节点不存在！");
			} else if (nodeList.size() > 1) {
				throw new ServiceException("节点号" + service.getRxNodeNo()
						+ "存在多条记录！");
			} else {
				service.setRxNode(nodeList.get(0));
			}
		}

		KuNode txNode = service.getTxNode();
		if (txNode == null) {
			if (!StringTools.hasText(service.getTxNodeNo())) {
				throw new ServiceException("发端节点不能为空！");
			}
			KuNodeQueryModel queryModel = new KuNodeQueryModel();
			queryModel.setKuNodeNo(service.getTxNodeNo());
			queryModel.setSubnetType(service.getSubnetTypeTx());
			List<KuNode> nodeList = kuNodeDao.queryList(queryModel);
			if (CollectionUtils.isEmpty(nodeList)) {
				throw new ServiceException("发端节点不存在！");
			} else if (nodeList.size() > 1) {
				throw new ServiceException("节点号" + service.getTxNodeNo()
						+ "存在多条记录！");
			} else {
				service.setTxNode(nodeList.get(0));
			}
		}
		service.setOptTime(Calendar.getInstance());
		service.setRecordTime(service.getOptTime());
		kuServiceDao.saveOrUpdate(service);
		return service;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuServiceManager#findById(java.lang.String)
	 */
	@Override
	public KuService findById(String id) {
		// TODO Auto-generated method stub
		KuService service = kuServiceDao.findById(id);
		service.setTxNodeNo(service.getTxNode().getKuNodeNo());
		service.setRxNodeNo(service.getRxNode().getKuNodeNo());
		// 封装子网类型
		service.setSubnetTypeTx(service.getTxNode().getSubnetType());
		service.setSubnetTypeRx(service.getRxNode().getSubnetType());

		return service;
	}

	@Override
	public int deleteByNodeId(String id) {
		return kuServiceDao.deleteByNodeId(id);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuServiceManager#delete(java.lang.String)
	 */
	@Override
	@Transactional
	public String delete(String id) throws ServiceException {
		// TODO Auto-generated method stub
		KuService service = findById(id);
		kuServiceDao.delete(service);
		return service.getCode();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuServiceManager#queryPage(cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel)
	 */
	@Override
	public Pagination queryPage(KuStatQueryModel model) {
		// TODO Auto-generated method stub
		return kuServiceDao.queryPage(model);
	}

	@Override
	public Long querySize(KuStatQueryModel model) {
		return kuServiceDao.querySize(model);
	}

	@Override
	public List<KuService> queryList(KuStatQueryModel model) {
		return kuServiceDao.queryList(model);
	}

	@Override
	@Transactional
	public List<List<String>> doExcelImport(FileUploadModel fileModel, User user)
			throws ServiceException {
		String path = ProjectFilePath.getTmpPath();
		String filePath = null;
		List<List<String>> failData = new ArrayList<>();
		try {
			// 将用户上传的文件保存至本地tmp文件夹中
			try {
				filePath = FileUpload.saveFile("",
						fileModel.getLocalFilePath(), path);
			} catch (IOException e1) {
				throw new ServiceException("文件上传异常：" + e1.getMessage());
			}
			List<List<String>> productData;
			// 获取excel中的所有string字段
			try {
				productData = ExcelPoiTools.readFile2List(filePath,
						titleColumns.length);
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
			List<String> title = productData.get(0);
			System.err.println(title.size());
			Map<String, Integer> colNum = getColNum(title);
			// 导入失败的行及原因
			title.add("错误信息");
			failData.add(title);
			// 生成bean复制是忽略的字段
			List<String> ignoreColumns = new ArrayList<>();
			for (String col : colNum.keySet()) {
				ignoreColumns.add(col);
			}
			/* 数据包装导入 */
			for (int i = 1; i < productData.size(); i++) {

				List<String> data = productData.get(i);
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
				// 将字符串包装成KuService
				KuService kuService = new KuService();
				// 取值
				String subnetTx = value.get("subnetTypeTx");
				// 非空验证
				if (StringUtils.isNotEmpty(subnetTx)) {
					//赋值
					kuService.setSubnetTypeTx(SubnetType.string2Enum(subnetTx));
				}
				kuService.setTxNodeNo(value.get("txNodeNo"));
				kuService.setTxNodeId(value.get("txNodeId"));
				kuService.setTxGib(value.get("txGib"));
				kuService.setTxChan(value.get("txChan"));
				// 取值
				String subnetRx = value.get("subnetTypeRx");
				// 非空验证
				if (StringUtils.isNotEmpty(subnetRx)) {
					//赋值
					kuService.setSubnetTypeRx(SubnetType.string2Enum(subnetRx));
				}
				kuService.setRxNodeNo(value.get("rxNodeNo"));
				kuService.setRxNodeId(value.get("rxNodeId"));
				kuService.setRxGib(value.get("rxGib"));
				kuService.setRxChan(value.get("rxChan"));
				kuService.setMemo(value.get("memo"));
				kuService.setCode(value.get("code"));
				kuService.setCrm(value.get("crm"));
				try {
					// 判断导入Excel表中节点号和节点ID与数据库中是否一致，不一致的错误提醒不导入
					kuService.setTxNode(checkKuNode(kuService.getTxNodeNo(),
							kuService.getTxNodeId()));
					kuService.setRxNode(checkKuNode(kuService.getRxNodeNo(),
							kuService.getRxNodeId()));
				} catch (ServiceException e) {
					data.add(e.getMessage());
					failData.add(data);
					continue;
				}
				try {
					// 确认数据库中是否有相应的记录
					boolean isNew = false;
					KuService kuServiceInDB = getService(kuService);
					if (kuServiceInDB == null) {
						kuServiceInDB = kuService;
						System.out.println("kuServiceInDB : " + kuServiceInDB);
						isNew = true;
					} else {
						if (kuServiceInDB.getCode() == null) {
							continue;
						}
						if (!kuServiceInDB.getCode()
								.equals(kuService.getCode())) {
							data.add("Ku当前电路名为" + kuServiceInDB.getCode()
									+ ",与Excel导入数据不一致");
							failData.add(data);
							continue;
						}
					}

					kuServiceInDB.setCode(value.get("code"));
					kuServiceInDB.setBureau(Bureau.string2Enum(value.get(
							"bureau").trim()));
					kuServiceInDB.setConfigTime(value.get("configTime"));
					kuServiceInDB.setCircuitInfo(value.get("circuitInfo"));
					kuServiceInDB.setCircuitType("PAMA");
					kuServiceInDB.setCircuitTypeDetail(value
							.get("circuitTypeDetail"));
					kuServiceInDB.setOptTime(Calendar.getInstance());
					kuServiceInDB.setOptUser(user);
					kuServiceInDB.setRateType(KuServiceRateType
							.ordinalToEnum(Integer.parseInt(value
									.get("rateType"))));
					kuServiceInDB.setServiceType(value.get("serviceType"));
					kuServiceInDB.setUsage(value.get("usage"));
					kuServiceInDB.setMemo(value.get("memo"));
					kuServiceInDB.setInfo(value.get("info"));
					kuServiceInDB.setCrm(value.get("crm"));
					if (isNew) {
						add(kuServiceInDB);
					} else {
						kuServiceInDB.setTxNodeNo(kuServiceInDB.getTxNode()
								.getKuNodeCode());
						kuServiceInDB.setRxNodeNo(kuServiceInDB.getRxNode()
								.getKuNodeCode());
						update(kuServiceInDB);
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

	private KuNode checkKuNode(String nodeNo, String nodeCode)
			throws ServiceException {
		KuNodeQueryModel qm = new KuNodeQueryModel();
		qm.setKuNodeNo(nodeNo);

		List<KuNode> nodes = kuNodeDao.queryList(qm);
		if (CollectionUtils.isEmpty(nodes)) {
			throw new ServiceException("节点号" + nodeNo + "不存在！");
		} else if (nodes.size() > 1) {
			throw new ServiceException("节点号存在" + nodes.size() + "条记录！");
		} else {
			if (!nodes.get(0).getKuNodeCode().equals(nodeCode)) {
				throw new ServiceException("节点ID不一致，库中记录为"
						+ nodes.get(0).getKuNodeNo() + "--"
						+ nodes.get(0).getKuNodeCode());
			}
			return nodes.get(0);
		}

	}

	private KuService getService(KuService service) throws ServiceException {
		KuStatQueryModel serviceQueryModel = new KuStatQueryModel();
		serviceQueryModel.setRxNodeNo(service.getRxNodeNo());
		serviceQueryModel.setRxGib(service.getRxGib());
		serviceQueryModel.setRxChan(service.getRxChan());
		serviceQueryModel.setTxNodeNo(service.getTxNodeNo());
		serviceQueryModel.setTxGib(service.getTxGib());
		serviceQueryModel.setTxChan(service.getTxChan());
		serviceQueryModel.setExcludeId(service.getId());
		List<KuService> result = kuServiceDao.queryList(serviceQueryModel);
		if (CollectionUtils.isEmpty(result)) {
			return null;
		} else if (result.size() > 1) {
			throw new ServiceException("发端(" + service.getTxNodeNo() + "-"
					+ service.getTxGib() + "-" + service.getTxChan() + ")至收端("
					+ service.getRxNodeNo() + "-" + service.getRxGib() + "-"
					+ service.getRxChan() + ")存在多条记录！");
		} else {
			return result.get(0);
		}
	}

	/**
	 * 获取导入记录的抬头，判断是否包含非空列 除非空列，其他列可不存在，不存在的列数据库中的记录不被覆盖，保留原有数据
	 * 
	 * @author:HuangYijie
	 * @Date:2014-4-1 下午2:16:56
	 * 
	 * @param title
	 * @return
	 * @throws ServiceException
	 *             Map<String,Integer>
	 */
	private Map<String, Integer> getColNum(List<String> title)
			throws ServiceException {
		Map<String, Integer> colNum = new HashMap<String, Integer>();
		for (int i = 0; i < title.size(); i++) {
			String name = title.get(i);
			if (!StringTools.hasText(name)) {
				continue;
			}
			for (String titleColumnsName : titleColumns) {
				if (name.trim().equalsIgnoreCase(titleColumnsName)) {
					colNum.put(titleColumnsName, i);
					break;
				}
			}

		}
		if (CollectionUtils.isEmpty(colNum)
				|| colNum.size() < titleColumns.length) {
			throw new ServiceException("导入的数据文件格式不正确！");
		}
		for (String titleColumnsName : titleColumns) {
			if (colNum.get(titleColumnsName) == null) {
				throw new ServiceException("导入数据必须包含" + titleColumnsName + "!");

			}
		}
		return colNum;
	}

	/**
	 * 获取一行数据的校验结果 { "所属地区", "电路名", "配置时间", "电路类型", "电路速率", "发端节点ID", "发端节点号",
	 * "发端槽位号", "发端端口号", "收端节点ID", "收端节点号", "收端槽位号", "收端端口号", "电路情况", "业务类型",
	 * "电路使用情况", "备注" }
	 * 
	 * @author:HuangYijie
	 * @Date:2014-4-1 下午2:17:57
	 * 
	 * @param data
	 * @param colNum
	 * @return
	 * @throws ServiceException
	 * @throws UnsupportedEncodingException
	 *             Map<String,String>
	 * 
	 */
	private Map<String, String> getValueAndCheck(List<String> data,
			Map<String, Integer> colNum) throws ServiceException,
			UnsupportedEncodingException {
		Map<String, String> value = new HashMap<String, String>();

		String code = data.get(colNum.get("电路名")).trim();
		if (!StringTools.hasText(code) || !code.matches(regexCode)) {
			throw new ServiceException("电路名不能为空，限定为20位以内数字、大写英文、-");
		}
		String bureau = data.get(colNum.get("所属地区")).trim();
		if (!StringTools.hasText(bureau)) {
			throw new ServiceException("所属区域不能为空");
		}
		boolean exist = false;
		for (Bureau b : Bureau.values()) {
			if (b.getValue().equals(bureau)) {
				exist = true;
				break;
			}
		}
		if (!exist) {
			throw new ServiceException("所属区域不存在");
		}
		String configTime = data.get(colNum.get("配置时间")).trim();
		if (!StringTools.hasText(configTime)) {
			throw new ServiceException("配置时间不能为空，限定yyMMdd");
		} else {
			try {
				DateFormat configTimeFormat = new SimpleDateFormat("yyMMdd");
				Date date = configTimeFormat.parse(configTime);
				// configTime= configTimeFormat.format(date);
				if (!configTimeFormat.format(date).equals(configTime)) {
					throw new ServiceException("配置时间格式错误，限定yyMMdd,如140101");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				throw new ServiceException("配置时间格式错误，限定yyMMdd,如140101");
			}
		}
		String circuitTypeDetail = data.get(colNum.get("电路类型")).trim();
		if (!StringTools.hasText(circuitTypeDetail)) {
			throw new ServiceException("电路类型不能为空");
		}
		boolean circuitTypeDetailExist = false;
		for (CircuitTypeDetail b : CircuitTypeDetail.values()) {
			if (b.name().toUpperCase().equals(circuitTypeDetail.toUpperCase())) {
				circuitTypeDetailExist = true;
				circuitTypeDetail = b.name();
				break;
			}
		}
		if (!circuitTypeDetailExist) {
			throw new ServiceException("电路类型不存在");
		}
		String rateType = data.get(colNum.get("电路速率")).trim();
		if (!StringTools.hasText(rateType) || rateType.length() > 2) {
			throw new ServiceException("电路速率不能为空，限定为[0,31]整数");
		}
		boolean rateTypeExist = false;
		for (KuServiceRateType rateTypeEnum : KuServiceRateType.values()) {
			if (String.valueOf(rateTypeEnum.ordinal()).equals(rateType)) {
				rateTypeExist = true;
				rateType = String.valueOf(rateTypeEnum.ordinal());
				break;
			}
		}
		if (!rateTypeExist) {
			throw new ServiceException("电路速率不存在");
		}
		String txNodeId = data.get(colNum.get("发端节点ID")).trim();
		if (!StringTools.hasText(txNodeId) || !txNodeId.matches(regexNodeId)) {
			throw new ServiceException("发端节点ID不能为空,必须为20位以内数字、英文");
		} else {
			txNodeId = txNodeId.toUpperCase();
		}
		String subnetTypeTx = data.get(colNum.get("发端发端子网类型")).trim();
		String txNodeNo = data.get(colNum.get("发端节点号")).trim();
		if (!StringTools.hasText(txNodeNo) || !txNodeNo.matches(regexNodeNo)) {
			throw new ServiceException("发端节点号不能为空,必须为[0,999]整数");
		}
		String txGib = data.get(colNum.get("发端槽位号")).trim();
		if (!StringTools.hasText(txGib) || !txGib.matches(regexGib)) {
			throw new ServiceException("发端槽位号不能为空,必须为[1,99]整数");
		}
		String txChan = data.get(colNum.get("发端端口号")).trim();
		if (!StringTools.hasText(txChan) || !txChan.matches(regexChan)) {
			throw new ServiceException("发端端口号不能为空,必须为[0,99]整数");
		}
		String rxNodeId = data.get(colNum.get("收端节点ID")).trim();
		if (!StringTools.hasText(rxNodeId) || !rxNodeId.matches(regexNodeId)) {
			throw new ServiceException("收端节点ID不能为空,必须为20位以内数字、英文");
		} else {
			rxNodeId = rxNodeId.toUpperCase();
		}
		String subnetTypeRx = data.get(colNum.get("收端发端子网类型")).trim();
		String rxNodeNo = data.get(colNum.get("收端节点号")).trim();
		if (!StringTools.hasText(rxNodeNo) || !rxNodeNo.matches(regexNodeNo)) {
			throw new ServiceException("收端节点号不能为空,必须为[0,999]整数");
		}
		String rxGib = data.get(colNum.get("收端槽位号")).trim();
		if (!StringTools.hasText(rxGib) || !rxGib.matches(regexGib)) {
			throw new ServiceException("收端槽位号不能为空,必须为[1,99]整数");
		}
		String rxChan = data.get(colNum.get("收端端口号")).trim();
		if (!StringTools.hasText(rxChan) || !rxChan.matches(regexChan)) {
			throw new ServiceException("收端端口号不能为空,必须为[0,99]整数");
		}
		String serviceType = data.get(colNum.get("业务类型")).trim();
		if (StringTools.hasText(serviceType) && serviceType.length() > 10) {
			throw new ServiceException("业务类型可为空，必须为10位以内字符");
		}
		String circuitInfo = data.get(colNum.get("电路情况"));
		if (StringTools.hasText(circuitInfo) && circuitInfo.length() > 50) {
			throw new ServiceException("电路情况可为空，必须为50位以内字符");
		}
		String usage = data.get(colNum.get("电路使用情况")).trim();
		if (StringTools.hasText(usage) && usage.length() > 50) {
			throw new ServiceException("电路使用情况可为空，必须为50位以内字符");
		}
		String info = data.get(colNum.get("备注")).trim();
		if (StringTools.hasText(info) && info.length() > 50) {
			throw new ServiceException("备注可为空，必须为50位以内字符");
		}
		String crm = data.get(colNum.get("CRM情况")).trim();
		if (StringTools.hasText(crm) && crm.length() > 50) {
			throw new ServiceException("CRM情况可为空，必须为50位以内字符");
		}
		String memo = data.get(colNum.get("收端信息")).trim();
		if (StringTools.hasText(memo) && !memo.matches(regexmemo)
				&& memo.length() > 500) {
			throw new ServiceException("收端信息可为空，必须为500位以内字符");
		}
		value.put("code", code);
		value.put("bureau", bureau);
		value.put("configTime", configTime);
		value.put("circuitTypeDetail", circuitTypeDetail);
		value.put("rateType", rateType);
		value.put("txNodeId", txNodeId);
		value.put("txNodeNo", txNodeNo);
		value.put("subnetTypeTx", subnetTypeTx);
		value.put("txGib", txGib);
		value.put("txChan", txChan);
		value.put("rxNodeId", rxNodeId);
		value.put("rxNodeNo", rxNodeNo);
		value.put("subnetTypeRx", subnetTypeRx);
		value.put("rxGib", rxGib);
		value.put("rxChan", rxChan);
		value.put("memo", memo);
		value.put("circuitInfo", circuitInfo);
		value.put("serviceType", serviceType);
		value.put("usage", usage);
		value.put("info", info);
		value.put("crm", crm);
		return value;
	}

	@Override
	public Workbook exportExcel(File template, KuStatQueryModel queryModel)
			throws IOException, InvalidFormatException {
		//
		List<KuService> kuServices = kuServiceDao
				.queryList(queryModel == null ? new KuStatQueryModel()
						: queryModel);
		Workbook wb = null;
		Sheet sheet = null;
		// 判断模板是否存在
		if (template == null) {
			// 不存在，则自己到处抬头行
			wb = new HSSFWorkbook();
			sheet = wb.createSheet("Ku正式电路");// 注意获取sheet的方式不一样
			Row titleRow = sheet.createRow(0);
			int columnNo = 0;
			titleRow.createCell(columnNo++).setCellValue("所属地区");
			titleRow.createCell(columnNo++).setCellValue("电路名");
			titleRow.createCell(columnNo++).setCellValue("配置时间");
			titleRow.createCell(columnNo++).setCellValue("电路类型");
			titleRow.createCell(columnNo++).setCellValue("电路速率描述");
			titleRow.createCell(columnNo++).setCellValue("电路速率");
			titleRow.createCell(columnNo++).setCellValue("发端节点ID");
			titleRow.createCell(columnNo++).setCellValue("发端站名");
			titleRow.createCell(columnNo++).setCellValue("发端子网类型");
			titleRow.createCell(columnNo++).setCellValue("发端节点号");
			titleRow.createCell(columnNo++).setCellValue("发端槽位号");
			titleRow.createCell(columnNo++).setCellValue("发端端口号");
			titleRow.createCell(columnNo++).setCellValue("收端节点ID");
			titleRow.createCell(columnNo++).setCellValue("收端站名");
			titleRow.createCell(columnNo++).setCellValue("收端子网类型");
			titleRow.createCell(columnNo++).setCellValue("收端节点号");
			titleRow.createCell(columnNo++).setCellValue("收端槽位号");
			titleRow.createCell(columnNo++).setCellValue("收端端口号");
			titleRow.createCell(columnNo++).setCellValue("收端信息");
			titleRow.createCell(columnNo++).setCellValue("电路情况");
			titleRow.createCell(columnNo++).setCellValue("业务类型");
			titleRow.createCell(columnNo++).setCellValue("CRM情况");
			titleRow.createCell(columnNo++).setCellValue("电路使用情况");
			titleRow.createCell(columnNo++).setCellValue("备注");
		} else {
			// 存在，则直接获取模板中的抬头样式
			wb = ExcelPoiTools.create(new FileInputStream(template));
			if (!CollectionUtils.isEmpty(kuServices)) {
				sheet = wb.getSheetAt(0);
			}
		}
		if (CollectionUtils.isEmpty(kuServices)) {
			return wb;
		}
		// 将KuService的信息导入
		for (int i = 0; i < kuServices.size(); i++) {
			Row row = sheet.createRow(i + 1);
			if (kuServices.get(i) == null) {
				continue;
			}
			// 给这一行的第一列赋值
			int columnNo = 0;
			row.createCell(columnNo++).setCellValue(
					kuServices.get(i).getBureau() == null ? "" : kuServices
							.get(i).getBureau().getValue());
			row.createCell(columnNo++)
					.setCellValue(kuServices.get(i).getCode());
			row.createCell(columnNo++).setCellValue(
					kuServices.get(i).getConfigTime());
			row.createCell(columnNo++).setCellValue(
					kuServices.get(i).getCircuitTypeDetail());
			row.createCell(columnNo++).setCellValue(
					kuServices.get(i).getRateType() == null ? "" : kuServices
							.get(i).getRateType().getValue());
			row.createCell(columnNo++).setCellValue(
					kuServices.get(i).getRateType() == null ? "" : kuServices
							.get(i).getRateType().ordinal()
							+ "");
			row.createCell(columnNo++).setCellValue(
					kuServices.get(i).getTxNode().getKuNodeCode());
			row.createCell(columnNo++).setCellValue(
					kuServices.get(i).getTxNode().getEquip().getSatellite()
							.getSiteName());
			// dyl add 子网类型
			if (!org.apache.commons.lang.ObjectUtils.equals(kuServices.get(i)
					.getTxNode().getSubnetType(), null)) {
				row.createCell(columnNo++).setCellValue(
						kuServices.get(i).getTxNode().getSubnetType()
								.getValue());
			} else {
				row.createCell(columnNo++).setCellValue("");
			}
			row.createCell(columnNo++).setCellValue(
					kuServices.get(i).getTxNode().getKuNodeNo());
			row.createCell(columnNo++).setCellValue(
					kuServices.get(i).getTxGib());
			row.createCell(columnNo++).setCellValue(
					kuServices.get(i).getTxChan());
			row.createCell(columnNo++).setCellValue(
					kuServices.get(i).getRxNode().getKuNodeCode());
			row.createCell(columnNo++).setCellValue(
					kuServices.get(i).getRxNode().getEquip().getSatellite()
							.getSiteName());
			// dyl add 子网类型
			// 非空验证
			if (!org.apache.commons.lang.ObjectUtils.equals(kuServices.get(i)
					.getRxNode().getSubnetType(), null)) {
				row.createCell(columnNo++).setCellValue(
						kuServices.get(i).getRxNode().getSubnetType()
								.getValue());
			} else {
				row.createCell(columnNo++).setCellValue("");
			}
			row.createCell(columnNo++).setCellValue(
					kuServices.get(i).getRxNode().getKuNodeNo());
			row.createCell(columnNo++).setCellValue(
					kuServices.get(i).getRxGib());
			row.createCell(columnNo++).setCellValue(
					kuServices.get(i).getRxChan());
			row.createCell(columnNo++)
					.setCellValue(kuServices.get(i).getMemo());
			row.createCell(columnNo++).setCellValue(
					kuServices.get(i).getCircuitInfo());
			row.createCell(columnNo++).setCellValue(
					kuServices.get(i).getServiceType());
			row.createCell(columnNo++).setCellValue(kuServices.get(i).getCrm());
			row.createCell(columnNo++).setCellValue(
					kuServices.get(i).getUsage());
			row.createCell(columnNo++)
					.setCellValue(kuServices.get(i).getInfo());
		}
		return wb;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.mng.basedata.ku.IKuServiceManager#getChart(java.lang.String)
	 */
	@Override
	public List<ChartIntegerArraySeries> getChart(String ids) {
		// TODO Auto-generated method stub
		String[] idArray = ids.split(SysFinals.COMMA);
		KuStatQueryModel queryModel = new KuStatQueryModel();
		queryModel.setIds(idArray);
		List<KuService> serviceList = kuServiceDao.queryList(queryModel);
		List<ChartIntegerArraySeries> series = new ArrayList<>();
		for (KuService service : serviceList) {
			ChartIntegerArraySeries chartSeries = new ChartIntegerArraySeries();
			chartSeries.setName(service.getCode());
			List<Integer[]> data = new ArrayList<Integer[]>();
			data.add(new Integer[] {
					(service.getStart() == null ? 0 : service.getStart()),
					(service.getCxr() == null ? -1 : service.getCxr()) });
			data.add(new Integer[] {
					(service.getStart() == null ? 0 : service.getStart())
							+ (service.getRateType() == null ? 0 : service
									.getRateType().getSize()),
					(service.getCxr() == null ? -1 : service.getCxr()) });
			chartSeries.setData(data);
			series.add(chartSeries);
		}
		return series;
	}

	@Override
	public Map<String, Object> getKuParams(MaintainEquip maintainEquip) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> txGibs = new ArrayList<String>();
		List<String> txChans = new ArrayList<String>();
		List<String> rxNodes = new ArrayList<String>();
		List<String> rxGibs = new ArrayList<String>();
		List<String> rxChans = new ArrayList<String>();
		// 根据设备ID，获取配置的节点
		EquipNode equipNode = equipNodeManager
				.findByMaintainEquip(maintainEquip);
		// 发端节点号
		String txNodeNo = null;
		if (!ObjectUtils.equals(equipNode, null)) {
			txNodeNo = equipNode.getEquip().getName();
			map.put("txNodeNo", txNodeNo);
			//子网类型查询条件封装
			KuNodeQueryModel queryModel = new KuNodeQueryModel();
			queryModel.setEquipId(equipNode.getEquip().getId());
			//根据发端设备id去KuNode中查找对应实体
			List<KuNode> kuNodes = kuNodeManager.queryList(queryModel);
			
			// 根据发端节点号去KuNode中查找对应实体
			//KuNodeQueryModel kuNodeQueryModel = new KuNodeQueryModel();
			//kuNodeQueryModel.setKuNodeNo(txNodeNo);
			//List<KuNode> kuNodes = kuNodeManager.queryList(kuNodeQueryModel);
			if (!CollectionUtils.isEmpty(kuNodes)) {
				// 根据KuNode去KuService中查找信息
				KuNode kuNode = kuNodes.get(0);
				//发端子网类型
				SubnetType subnetTypeTx = kuNode.getSubnetType();
				map.put("subnetTypeTx", subnetTypeTx);
				KuStatQueryModel kuStatQueryModel = new KuStatQueryModel();
				//子网类型
				kuStatQueryModel.setSubnetTypeTx(subnetTypeTx);
				//节点号
				kuStatQueryModel.setTxNodeNo(txNodeNo);
				//kuStatQueryModel.setTxNodeId(kuNode.getId());
				List<KuService> kuServices = kuServiceDao
						.queryList(kuStatQueryModel);
				if (!CollectionUtils.isEmpty(kuServices)) {
					// 获取本端和对端相关参数
					for (KuService kuService : kuServices) {
						if (!txGibs.contains(kuService.getTxGib())) {
							txGibs.add(kuService.getTxGib()); // 发端槽号
						}
						if (!txChans.contains(kuService.getTxChan())) {
							txChans.add(kuService.getTxChan()); // 发端端口号
						}
						if (!rxNodes.contains(kuService.getRxNode()
								.getKuNodeNo())) {
							rxNodes.add(kuService.getRxNode().getKuNodeNo()); // 收端节点号
						}
						if (!rxGibs.contains(kuService.getRxGib())) {
							rxGibs.add(kuService.getRxGib()); // 收端槽号
						}
						if (!rxChans.contains(kuService.getRxChan())) {
							rxChans.add(kuService.getRxChan()); // 收端端口号
						}
					}
					map.put("txGibs", txGibs);
					map.put("txChans", txChans);
					map.put("rxNodes", rxNodes);
					map.put("rxGibs", rxGibs);
					map.put("rxChans", rxChans);
				}
			}
		}
		return map;
	}

}
