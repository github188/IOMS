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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.lang.ObjectUtils;
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
import cn.com.atnc.ioms.dao.basedata.antenna.IAntennaDao;
import cn.com.atnc.ioms.dao.basedata.attenuator.IAttenuatorDao;
import cn.com.atnc.ioms.dao.basedata.equip.IEquipDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeStatusDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeStatusLogDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeStatusStatDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuServiceDao;
import cn.com.atnc.ioms.dao.basedata.odu.IOduDao;
import cn.com.atnc.ioms.dao.basedata.satellite.ISatelliteSiteDao;
import cn.com.atnc.ioms.dao.clientmng.IClientEquipDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.basedata.antenna.Antenna;
import cn.com.atnc.ioms.entity.basedata.attenuator.Attenuator;
import cn.com.atnc.ioms.entity.basedata.ku.KuNode;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatus;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatusLog;
import cn.com.atnc.ioms.entity.basedata.odu.Odu;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.EquipType;
import cn.com.atnc.ioms.enums.basedata.NetworkType;
import cn.com.atnc.ioms.enums.basedata.SubnetType;
import cn.com.atnc.ioms.mng.operstat.ku.IKuStatusStatManager;
import cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel;
import cn.com.atnc.ioms.model.basedata.satellite.AntennaQueryModel;
import cn.com.atnc.ioms.model.basedata.satellite.AttenuatorQueryModel;
import cn.com.atnc.ioms.model.basedata.satellite.OduQueryModel;
import cn.com.atnc.ioms.model.basedata.satellite.site.SiteQueryModel;
import cn.com.atnc.ioms.model.operstat.ku.KuStatusLogQueryModel;
import cn.com.atnc.ioms.model.operstat.ku.KuStatusQueryModel;
import cn.com.atnc.ioms.util.ExcelPoiTools;

/**
 * @author:HuangYijie
 * @date:2014-3-24 上午10:50:11
 * @version:1.0
 */
@Service("KuNodeManager")
public class KuNodeManagerImpl extends AbstractService implements
		IKuNodeManager {

	@Autowired
	private IKuNodeDao kuNodeDao;
	@Autowired
	private IKuNodeStatusDao kuNodeStatusDao;
	@Autowired
	private IKuNodeStatusLogDao kuNodeStatusLogDao;
	@Autowired
	private IKuNodeStatusStatDao kuNodeStatusStatDao;
	@Autowired
	private IEquipDao equipDao;
	@Autowired
	private ISatelliteSiteDao siteDao;
	@Autowired
	private IOduDao oduDao;
	@Autowired
	private IAntennaDao antennaDao;
	@Autowired
	private IAttenuatorDao attenuatorDao;

	@Autowired
	private IClientEquipDao clientEquipDao;

	@Autowired
	private IKuStatusStatManager kuStatusStatManager;

	@Autowired
	private IKuServiceDao kuServiceDao;
	// [\\pP‘’“”]标点符号
	private final String regexName = "^[\u4e00-\u9fa5A-Z0-9\\s]{0,50}$";// 备名称正则表达式
	private final String regexStatus = "^[a-zA-Z]{0,50}$";// 状态正则
	private final String regexCardCount = "^[0-9]{1,2}$";// 板卡数量正则
	private final String regexCode = "^[A-Z0-9\\-]{3,10}$";// "^[0-9A-Z]{1,20}$";//
															// 代码正则

	private final String regexKuNodeNo = "^[0-9]{1,3}$";// 节点号正则
	private final String[] titleColumns = { "子网类型", "节点号", "节点ID", "所属区域",
			"站点名称", "站点代码", "是否空管局", "机箱类型", "板卡总数", "板卡配置", "有无频谱仪", "上线状态",
			"未上线原因", "备注" };

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager#add(cn.com.atnc.ioms.entity.basedata.ku.KuNode)
	 */
	@Override
	@Transactional
	public KuNode add(KuNode node) throws ServiceException {
		// TODO Auto-generated method stub
		checkKuCodeIsUnique(node);
		checkKuNoIsUnique(node);
		SatelliteSite site = siteDao.findById(node.getSiteId());
		if (site == null) {
			throw new ServiceException("卫星站不存在!");
		}
		node.setKuNodeNo("" + Integer.parseInt(node.getKuNodeNo()));
		node.setOptTime(Calendar.getInstance());
		Equip equip = new Equip();
		if (node.getType() != null) {
			equip.setModel(node.getType().getValue());
		}
		equip.setType(NetworkType.KU);
		equip.setName(node.getKuNodeNo());//
		equip.setBureau(site.getBureau());
		equip.setCode(node.getKuNodeCode());// 节点号是唯一的，因此存储在编码字段。
		equip.setSatellite(site);

		equipDao.save(equip);
		node.setEquip(equip);
		kuNodeDao.save(node);
		return node;
	}

	/**
	 * 检查节点号是否唯一
	 * 
	 * @author:HuangYijie
	 * @Date:2014-4-29 下午4:31:54
	 * 
	 * @param node
	 * @throws ServiceException
	 *             void
	 */
	private void checkKuNoIsUnique(KuNode node) throws ServiceException {
		KuNodeQueryModel equipQueryModel = new KuNodeQueryModel();
		equipQueryModel.setKuNodeNo(node.getKuNodeNo());
		// 添加子网验证
		equipQueryModel.setSubnetType(node.getSubnetType());
		equipQueryModel.setExcludeId(node.getId());
		if (kuNodeDao.querySize(equipQueryModel) > 0) {
			throw new ServiceException("Ku节点号(" + node.getKuNodeNo() + ")已存在！");
		}
	}

	/**
	 * 检查节点ID （KuNodeCode）是否唯一
	 * 
	 * @author:HuangYijie
	 * @Date:2014-4-29 下午4:40:17
	 * 
	 * @param node
	 * @throws ServiceException
	 *             void
	 */
	private void checkKuCodeIsUnique(KuNode node) throws ServiceException {
		KuNodeQueryModel equipQueryModel = new KuNodeQueryModel();
		equipQueryModel.setKuNodeCode(node.getKuNodeCode());
		equipQueryModel.setExcludeId(node.getId());
		if (kuNodeDao.querySize(equipQueryModel) > 0) {
			throw new ServiceException("Ku节点ID(" + node.getKuNodeCode()
					+ ")已存在！");
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager#update(cn.com.atnc.ioms.entity.basedata.ku.KuNode)
	 */
	@Override
	@Transactional
	public KuNode update(KuNode node) throws ServiceException {
		// TODO Auto-generated method stub
		// 获取关联的设备
		checkKuCodeIsUnique(node);
		checkKuNoIsUnique(node);
		node.setKuNodeNo("" + Integer.parseInt(node.getKuNodeNo()));
		node.setOptTime(Calendar.getInstance());
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
		if (node.getType() != null) {
			equip.setModel(node.getType().getValue());
		}
		equip.setType(NetworkType.KU);
		equip.setName(node.getKuNodeNo());//
		equip.setBureau(site.getBureau());
		equip.setCode(node.getKuNodeCode());// 节点号是唯一的，因此存储在编码字段。
		equip.setSatellite(site);
		equipDao.update(equip);
		// 更新节点
		node.setEquip(equip);
		kuNodeDao.update(node);
		return node;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager#findById(java.lang.String)
	 */
	@Override
	public KuNode findById(String id) {
		// TODO Auto-generated method stub
		KuNode node = kuNodeDao.findById(id);
		if (node.getEquip() == null) {
			return node;
		}
		node.setEquipId(node.getEquip().getId());
		if (node.getEquip().getSatellite() == null) {
			return node;
		}
		node.setSatelliteSite(node.getEquip().getSatellite());
		node.setSiteCode(node.getEquip().getSatellite().getSiteCode());
		node.setSiteId(node.getEquip().getSatellite().getId());
		node.setBureau(node.getEquip().getBureau());
		return node;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager#delete(java.lang.String)
	 */
	@Override
	@Transactional
	public String delete(String id) throws ServiceException {
		// TODO Auto-generated method stub
		KuNode node = findById(id);
		kuServiceDao.deleteByNodeId(id);
		// 删除关联service;
		clientEquipDao.deleteEquip(node.getEquip().getId());
		// 删除用户定制

		KuStatusLogQueryModel qm2 = new KuStatusLogQueryModel();
		qm2.setKuNodeId(id);
		List<KuNodeStatusLog> lisug = kuStatusStatManager
				.findKlogByKuNodeId(qm2);
		for (int i = 0; i < lisug.size(); i++) {
			KuNodeStatusLog kuNodeStatusLog = lisug.get(i);
			kuNodeStatusLogDao.delete(kuNodeStatusLog);
			// 删除kuNodeStatusLog
		}

		KuStatusQueryModel qm = new KuStatusQueryModel();
		qm.setKuNodeId(id);
		List<KuNodeStatus> lisu = kuStatusStatManager.findByKuNodeId(qm);
		for (int i = 0; i < lisu.size(); i++) {
			KuNodeStatus kuNodeStatus = lisu.get(i);
			kuNodeStatusDao.delete(kuNodeStatus);

			// 删除kuNodeStatus

		}

		kuNodeDao.delete(node); // 删除KU节点
		equipDao.delete(node.getEquip()); // 删除Equip
		siteDao.delete(node.getEquip().getSatellite());// 删除卫星
		OduQueryModel qm3 = new OduQueryModel();

		qm3.setSiteId(node.getEquip().getSatellite().getId());
		List<Odu> lisODU = kuStatusStatManager.findODUBySite(qm3);
		// System.out.println(lisODU.size());
		for (int i = 0; i < lisODU.size(); i++) {
			Odu odu = lisODU.get(i);
			oduDao.delete(odu);
			// 删除odu
		}
		AntennaQueryModel qm4 = new AntennaQueryModel();
		qm4.setSiteId(node.getEquip().getSatellite().getId());
		List<Antenna> lisAnt = antennaDao.queryList(qm4);
		// System.out.println(lisAnt.size());
		for (int i = 0; i < lisAnt.size(); i++) {
			Antenna antenna = lisAnt.get(i);
			antennaDao.delete(antenna);
			// 删除Antenna
		}

		AttenuatorQueryModel qm5 = new AttenuatorQueryModel();
		qm5.setSiteId(node.getEquip().getSatellite().getId());
		List<Attenuator> lisAtt = attenuatorDao.queryList(qm5);
		// System.out.println(lisAnt.size());
		for (int i = 0; i < lisAtt.size(); i++) {
			Attenuator attenuator = lisAtt.get(i);
			attenuatorDao.delete(attenuator);
			// 删除Antenna
		}

		System.out.println("删除成功！");

		return node.getKuNodeNo();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager#queryPage(cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel)
	 */
	@Override
	public Pagination queryPage(KuNodeQueryModel model) {
		// TODO Auto-generated method stub
		return kuNodeDao.queryPage(model);
	}

	@Override
	public Long querySize(KuNodeQueryModel model) {
		return kuNodeDao.querySize(model);
	}

	@Override
	public List<KuNode> queryList(KuNodeQueryModel model) {
		return kuNodeDao.queryList(model);
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
				productData = ExcelPoiTools.readFile(filePath,
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

					// 将字符串包装成kuNode
					KuNode kuNode = new KuNode();
					kuNode.setBureau(Bureau.string2Enum(value.get("bureau")
							.trim()));
					kuNode.setCaac(Boolean.valueOf(value.get("caac").trim()));
					kuNode.setCardConfig(value.get("cardConfig"));
					kuNode.setCardCount(value.get("cardCount"));
					kuNode.setInfo(value.get("info"));
					kuNode.setInstrument(Boolean.valueOf(value
							.get("instrument").trim()));
					kuNode.setKuNodeCode(value.get("kuNodeCode"));
					kuNode.setKuNodeNo(value.get("kuNodeNo"));

					// 封装子网类型
					String subnetType = value.get("subnetType");
					// 非空验证
					if (StringUtils.isNotEmpty(subnetType)) {
						// 取枚举类
						kuNode.setSubnetType(SubnetType.string2Enum(subnetType
								.trim()));
					}
					kuNode.setSiteCode(value.get("siteCode"));
					kuNode.setStatus(value.get("status"));
					kuNode.setStatusInfo(value.get("statusInfo"));
					kuNode.setOptTime(Calendar.getInstance());
					kuNode.setOptUser(user);
					if (StringTools.hasText(value.get("type"))) {
						kuNode.setType(EquipType.valueOf(value.get("type")
								.trim()));
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
						if (!site.getBureau().equals(kuNode.getBureau())) {
							data.add("所属区域冲突，卫星站所属区域为"
									+ site.getBureau().getValue()
									+ "，导入记录所属区域为"
									+ kuNode.getBureau().getValue());
							failData.add(data);
							continue;
						}
						kuNode.setSiteId(site.getId());
						kuNode.setSatelliteSite(site);
					}
					// 查找是否已有相关抽象Equip记录
					KuNodeQueryModel equipQueryModel = new KuNodeQueryModel();
					equipQueryModel.setKuNodeNo(value.get("kuNodeNo"));
					//添加子网类型验证
					if(StringUtils.isNotEmpty(subnetType)){
						equipQueryModel.setSubnetType(SubnetType.string2Enum(subnetType
								.trim()));
					}
					List<KuNode> kuNodeList = kuNodeDao
							.queryList(equipQueryModel);
					if (CollectionUtils.isEmpty(kuNodeList)) {
						// 如果为空，则新增一条equip及kunode记录
						this.add(kuNode);
					} else if (kuNodeList.size() > 1) {
						// 如果代码不唯一，则导入失败。
						data.add("Ku节点" + value.get("kuNodeNo") + "存在"
								+ kuNodeList.size() + "条记录");
						failData.add(data);
						continue;
					} else {
						// 更新
						KuNode nodeInDb = kuNodeList.get(0);
						// 判断节点ID与节点号是否与数据库中的冲突
						if (!nodeInDb.getKuNodeCode().equals(
								kuNode.getKuNodeCode())) {
							data.add("Ku节点" + value.get("kuNodeNo")
									+ "的当前节点ID为" + nodeInDb.getKuNodeCode()
									+ ",与Excel导入数据不一致");
							failData.add(data);
							continue;
						}

						Equip equipIndb = nodeInDb.getEquip();
						kuNode.setId(nodeInDb.getId());
						// 将导入Excel中的记录内容更新至数据库中
						// BeanUtils.copyProperties(nodeInDb, kuNode,
						// ignoreColumns.toArray(new String[0]));
						BeanUtils.copyProperties(kuNode, nodeInDb);
						nodeInDb.setEquip(equipIndb);
						update(nodeInDb);
					}
				} catch (ServiceException e) {
					data.add(e.getMessage());
					failData.add(data);
					continue;
				} catch (UnsupportedEncodingException e) {
					data.add(e.getMessage());
					failData.add(data);
					continue;
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
	 * @author:HuangYijie
	 * @Date:2014-4-1 下午2:16:56
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
	 * 获取一行数据的校验结果
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
	 */
	private Map<String, String> getValueAndCheck(Vector<String> data,
			Map<String, Integer> colNum) throws ServiceException,
			UnsupportedEncodingException {
		Map<String, String> value = new HashMap<String, String>();

		String subnetType = data.get(colNum.get("子网类型")).trim();
		if (StringTools.hasText(subnetType) && subnetType.indexOf(".") >= 0) {
			throw new ServiceException("子网类型不能为空");
		}
		String kuNodeNo = data.get(colNum.get("节点号")).trim();
		if (StringTools.hasText(kuNodeNo) && kuNodeNo.indexOf(".") >= 0) {
			kuNodeNo = kuNodeNo.split("\\.")[0];
		}
		if (!StringTools.hasText(kuNodeNo) || !kuNodeNo.matches(regexKuNodeNo)) {
			throw new ServiceException("KU节点号不能为空，必须为[0,999]整数");
		}
		String kuNodeCode = data.get(colNum.get("节点ID")).trim().toUpperCase();
		if (!StringTools.hasText(kuNodeCode) || !kuNodeCode.matches(regexCode)) {
			throw new ServiceException("KU节点ID不能为空，必须为3到10位数字、大写英文、-");
		}
		String bureau = data.get(colNum.get("所属区域")).trim();
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
		String siteCode = data.get(colNum.get("站点代码")).trim().toUpperCase();
		if (!StringTools.hasText(siteCode) || !siteCode.matches(regexCode)) {
			throw new ServiceException("站点代码不能为空，必须为3-10位大写英文、数字、-");
		}
		String caac = "";// 是否空管局资产
		String type = "";// 机箱类型
		String cardCount = "";// 板卡总数
		String cardConfig = "";// 板卡配置
		String instrument = "";// 频谱仪
		String status = "";// 上星状态
		String statusInfo = "";// 未上线原因
		String info = "";// 备注
		String siteName = "";
		if (colNum.get("是否空管局") != null
				&& StringTools.hasText(data.get(colNum.get("是否空管局")))) {
			caac = data.get(colNum.get("是否空管局")).trim();
			if (caac.equalsIgnoreCase("是")
					|| caac.toUpperCase().equalsIgnoreCase("TRUE")) {
				caac = "true";
			} else if (caac.equalsIgnoreCase("否")
					|| caac.toUpperCase().equalsIgnoreCase("false")) {
				caac = "false";
			} else {
				throw new ServiceException("是否空管局不可识别");
			}
		} else {
			throw new ServiceException("是否空管局不能为空");
		}
		if (colNum.get("机箱类型") != null
				&& StringTools.hasText(data.get(colNum.get("机箱类型")))) {
			type = data.get(colNum.get("机箱类型")).trim().toUpperCase();
			if (StringTools.hasText(type)) {
				boolean typeExist = false;
				for (EquipType et : EquipType.values()) {
					if (et.getValue().toUpperCase().equals(type)) {
						typeExist = true;
						type = et.getValue();
						break;
					}
				}
				if (!typeExist) {
					throw new ServiceException("机箱类型不存在");
				}
			}
		} else {
			throw new ServiceException("机箱类型不能为空");
		}
		if (colNum.get("板卡总数") != null) {
			cardCount = data.get(colNum.get("板卡总数")).trim();
			if (StringTools.hasText(cardCount) && cardCount.indexOf(".") >= 0) {
				cardCount = cardCount.split("\\.")[0];
			}
			if (StringTools.hasText(cardCount)
					&& !cardCount.matches(regexCardCount)) {
				throw new ServiceException("板卡总数可为空，限定为[0,99]整数");
			}
		}
		if (colNum.get("板卡配置") != null) {
			cardConfig = data.get(colNum.get("板卡配置")).trim();
			if (StringTools.hasText(cardConfig)
					&& !cardConfig.matches(regexStatus)) {
				throw new ServiceException("板卡配置可为空，限定为50位以内的英文");
			}
		}
		if (colNum.get("有无频谱仪") != null
				&& StringTools.hasText(data.get(colNum.get("有无频谱仪")))) {
			instrument = data.get(colNum.get("有无频谱仪")).trim();
			if (instrument.toUpperCase().equalsIgnoreCase("TRUE")
					|| instrument.toUpperCase().equalsIgnoreCase("有")) {
				instrument = "true";
			} else if (instrument.toUpperCase().equalsIgnoreCase("FALSE")
					|| instrument.toUpperCase().equalsIgnoreCase("无")) {
				instrument = "false";
			} else {
				throw new ServiceException("有无频谱仪值不可识别");
			}
		} else {
			throw new ServiceException("有无频谱仪值不能为空");
		}
		if (colNum.get("上线状态") != null) {
			status = data.get(colNum.get("上线状态"));
			if (StringTools.hasText(status) && status.length() > 50) {
				throw new ServiceException("上线状态可为空，限定50位以内字符");
			}
		}
		if (colNum.get("未上线原因") != null) {
			statusInfo = data.get(colNum.get("未上线原因"));
			if (StringTools.hasText(statusInfo) && statusInfo.length() > 50) {
				throw new ServiceException("未上线原因可为空，限定50位以内字符");
			}
		}
		if (colNum.get("备注") != null) {
			info = data.get(colNum.get("备注")).trim();
			if (StringTools.hasText(info) && info.length() > 50) {
				throw new ServiceException("备注可为空，限定50位以内字符");
			}
		}
		if (colNum.get("站点名称") != null) {
			siteName = data.get(colNum.get("站点名称")).trim();
			if (StringTools.hasText(siteName) && !siteName.matches(regexName)) {
				throw new ServiceException("站点名称可为空，限定为50位以内的数字、中文、大小写英文和空格");
			}
		}
		// 校验通过的记录返回，否则抛出异常，存入failData中
		value.put("subnetType", subnetType);
		value.put("kuNodeNo", kuNodeNo);
		value.put("kuNodeCode", kuNodeCode);
		value.put("bureau", bureau);
		value.put("siteCode", siteCode);
		value.put("caac", caac);
		value.put("type", type);
		value.put("cardCount", cardCount);
		value.put("cardConfig", cardConfig);
		value.put("instrument", instrument);
		value.put("status", status);
		value.put("statusInfo", statusInfo);
		value.put("info", info);
		value.put("siteName", siteName);
		return value;
	}

	@Override
	public Workbook exportExcel(File template, KuNodeQueryModel queryModel)
			throws IOException, InvalidFormatException {
		//
		List<KuNode> kuNodes = kuNodeDao
				.queryList(queryModel == null ? new KuNodeQueryModel()
						: queryModel);
		System.err.println(kuNodes.size());
		Workbook wb = null;
		Sheet sheet = null;
		// 判断模板是否存在
		if (template == null) {
			// 不存在，则自己到处抬头行
			wb = new HSSFWorkbook();
			sheet = wb.createSheet("Ku全网节点(or机箱)统计表");// 注意获取sheet的方式不一样
			Row titleRow = sheet.createRow(0);
			titleRow.createCell(0).setCellValue("子网类型");
			titleRow.createCell(1).setCellValue("节点号");
			titleRow.createCell(2).setCellValue("节点ID");
			titleRow.createCell(3).setCellValue("所属区域");
			titleRow.createCell(4).setCellValue("站点名称");
			titleRow.createCell(5).setCellValue("节点代码");
			titleRow.createCell(6).setCellValue("是否空管局");
			titleRow.createCell(7).setCellValue("机箱类型");
			titleRow.createCell(8).setCellValue("板卡总数");
			titleRow.createCell(9).setCellValue("板卡配置");
			titleRow.createCell(10).setCellValue("有无频谱仪");
			titleRow.createCell(11).setCellValue("上线状态");
			titleRow.createCell(12).setCellValue("未上线原因");
			titleRow.createCell(13).setCellValue("备注");
		} else {
			// 存在，则直接获取模板中的抬头样式
			wb = ExcelPoiTools.create(new FileInputStream(template));
			if (!CollectionUtils.isEmpty(kuNodes)) {
				sheet = wb.getSheetAt(0);
			}
		}
		if (CollectionUtils.isEmpty(kuNodes)) {
			return wb;
		}
		// 将kuNode的信息导入
		for (int i = 0; i < kuNodes.size(); i++) {
			Row row = sheet.createRow(i + 1);
			// 给这一行的第一列赋值
			// 子网类型
			SubnetType subnetType = kuNodes.get(i).getSubnetType();
			// 非空验证
			if (!ObjectUtils.equals(subnetType, null)) {
				row.createCell(0).setCellValue(subnetType.getValue());
			} else {
				row.createCell(0).setCellValue("");
			}
			// 节点号
			row.createCell(1).setCellValue(kuNodes.get(i).getKuNodeNo());
			// 节点代码
			row.createCell(2).setCellValue(kuNodes.get(i).getKuNodeCode());
			// 地区
			row.createCell(3).setCellValue(
					kuNodes.get(i).getEquip() == null ? "" : (kuNodes.get(i)
							.getEquip().getBureau() == null ? "" : kuNodes
							.get(i).getEquip().getBureau().getValue()));
			// 站名
			row.createCell(4).setCellValue(
					kuNodes.get(i).getEquip() == null ? "" : (kuNodes.get(i)
							.getEquip().getSatellite() == null ? "" : kuNodes
							.get(i).getEquip().getSatellite().getSiteName()));
			// 站点代码
			row.createCell(5).setCellValue(
					kuNodes.get(i).getEquip() == null ? "" : (kuNodes.get(i)
							.getEquip().getSatellite() == null ? "" : kuNodes
							.get(i).getEquip().getSatellite().getSiteCode()));
			row.createCell(6).setCellValue(
					kuNodes.get(i).getCaac() == null ? "" : (kuNodes.get(i)
							.getCaac() == true ? "是" : "否"));
			row.createCell(7).setCellValue(
					kuNodes.get(i).getType() == null ? "" : kuNodes.get(i)
							.getType().getValue());
			row.createCell(8).setCellValue(kuNodes.get(i).getCardCount());
			row.createCell(9).setCellValue(kuNodes.get(i).getCardConfig());
			row.createCell(10).setCellValue(
					kuNodes.get(i).getInstrument() == null ? "" : (kuNodes.get(
							i).getInstrument() == true ? "有" : "无"));
			row.createCell(11).setCellValue(kuNodes.get(i).getStatus());
			row.createCell(12).setCellValue(kuNodes.get(i).getStatusInfo());
			row.createCell(13).setCellValue(kuNodes.get(i).getInfo());
		}
		return wb;
	}

}
