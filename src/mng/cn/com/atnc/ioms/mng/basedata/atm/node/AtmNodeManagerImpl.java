package cn.com.atnc.ioms.mng.basedata.atm.node;

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
import cn.com.atnc.ioms.dao.basedata.atm.node.IAtmNodeDao;
import cn.com.atnc.ioms.dao.basedata.atm.service.IAtmServiceDao;
import cn.com.atnc.ioms.dao.basedata.equip.IEquipDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.NetworkType;
import cn.com.atnc.ioms.model.basedata.EquipQueryModel;
import cn.com.atnc.ioms.model.basedata.atm.node.AtmNodeQueryModel;
import cn.com.atnc.ioms.model.basedata.atm.service.AtmServiceQueryModel;
import cn.com.atnc.ioms.util.ExcelPoiTools;

/**
 * 
 * @author:xiongzhikang
 * @date:2014-4-22 上午10:08:08
 * @version:1.0
 */
@Service("AtmNodeManager")
public class AtmNodeManagerImpl extends AbstractService implements
		IAtmNodeManager {

	@Autowired
	private IAtmNodeDao atmNodeDao;
	@Autowired
	private IEquipDao equipDao;
	@Autowired
	private IAtmServiceDao atmServiceDao;

	/*
	 * @Autowired private IKuServiceDao kuServiceDao;
	 */
	// [\\pP‘’“”]标点符号
	private final String regexAtmNodeSeq = "^[0-9]*[1-9][0-9]*$";// 区内序号正则
	private final String regexAtmNodeNameCn = "^[\u4e00-\u9fa5]+$";// 节点地点正则
	private final String regexAtmNodeCode = "^[A-Z]{4}-[A-Z]{3}[0-9]{4}-[0-9]{2}$";// 节点名称正则
	private final String regexAtmNodeIp = "^((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)$";// ATM0地址正则
	private final int columnNum = 5;

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager#add(cn.com.atnc.ioms.entity.basedata.ku.KuNode)
	 */
	@Override
	@Transactional
	public AtmNode add(AtmNode node) throws ServiceException {
		// TODO Auto-generated method stub

		Equip equip = new Equip();
		equip.setBureau(node.getBureau());// 区域
		equip.setName(node.getAtmNodeNameCn());// 节点名称
		equip.setCode(node.getAtmNodeCode());
		equip.setType(NetworkType.ATM);
		equip.setModel(node.getAtmNodeCode().substring(5, 12));// ZBAA-MGX8850-02,取中间部分
		equipDao.save(equip);
		node.setEquip(equip);
		atmNodeDao.save(node);
		return node;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager#update(cn.com.atnc.ioms.entity.basedata.ku.KuNode)
	 */
	@Override
	@Transactional
	public AtmNode update(AtmNode node) throws ServiceException {
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

		// 更新设备信息
		equip.setBureau(node.getBureau());// 区域
		equip.setName(node.getAtmNodeNameCn());// 节点名称
		equip.setCode(node.getAtmNodeCode());
		equipDao.saveOrUpdate(equip);
		// 更新节点
		node.setEquip(equip);
		atmNodeDao.saveOrUpdate(node);
		return node;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager#findById(java.lang.String)
	 */
	@Override
	public AtmNode findById(String id) {
		// TODO Auto-generated method stub
		AtmNode node = atmNodeDao.findById(id);
		if (node.getEquip() == null) {
			return node;
		}
		node.setEquipId(node.getEquip().getId());
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

		AtmServiceQueryModel atmServiceQueryModel = new AtmServiceQueryModel();
		atmServiceQueryModel.setLocalNodeId(id);
		atmServiceQueryModel.setRemoteNodeId(id);
		if (atmServiceDao.queryDeleteNodeSize(atmServiceQueryModel) > 0) {
			throw new ServiceException("该节点存在关联的业务，不可删除！");
		}
		AtmNode node = findById(id);
		atmNodeDao.delete(node);
		equipDao.delete(node.getEquip());
		return node.getAtmNodeCode();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager#queryPage(cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel)
	 */
	@Override
	public Pagination queryPage(AtmNodeQueryModel model) {
		// TODO Auto-generated method stub
		return atmNodeDao.queryPage(model);
	}

	@Override
	public Long querySize(AtmNodeQueryModel model)
			throws UnsupportedEncodingException {
		return atmNodeDao.querySize(model);
	}

	@Override
	public List<AtmNode> queryList(AtmNodeQueryModel model) {
		return atmNodeDao.queryList(model);
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
			// 生成bean复制是忽略的字段
			List<String> ignoreColumns = new ArrayList<>();
			for (String col : colNum.keySet()) {
				ignoreColumns.add(col);
			}
			ignoreColumns.add("equip");
			ignoreColumns.add("equipId");
			// 数据包装导入
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
				// 将字符串包装成atmNode
				AtmNode atmNode = new AtmNode();
				atmNode.setBureau(Bureau
						.string2Enum(value.get("bureau").trim()));// 区域
				atmNode.setAtmNodeSeq(value.get("atmNodeSeq"));// 区内序号
				atmNode.setAtmNodeNameCn(value.get("atmNodeNameCn"));// 节点地点
				atmNode.setAtmNodeCode(value.get("atmNodeCode"));// 节点名称
				atmNode.setAtmNodeIp(value.get("atmNodeIp"));// ATM0地址

				// 查找是否已有相关抽象Equip记录
				EquipQueryModel equipQueryModel = new EquipQueryModel();
				equipQueryModel.setName(value.get("atmNodeCode"));// 节点名称
				List<Equip> equipList = equipDao.queryList(equipQueryModel);
				if (CollectionUtils.isEmpty(equipList)) {
					// 如果为空，则新增一条equip及atmnode记录
					this.add(atmNode);
				} else if (equipList.size() > 1) {
					// 如果节点名称不唯一，则导入失败。
					data.add("设备" + value.get("atmNodeCode") + "存在多条记录"
							+ equipList.size());
					failData.add(data);
					continue;
				} else {
					// 如果有唯一记录，初始化atmnode节点关联的equip
					atmNode.setEquipId(equipList.get(0).getId());
					atmNode.setEquip(equipList.get(0));
					// 查找atmnode表中 关联equipid 的记录
					AtmNodeQueryModel atmNodeQueryModel = new AtmNodeQueryModel();
					atmNodeQueryModel.setEquipId(atmNode.getEquipId());
					List<AtmNode> atmNodeList = atmNodeDao
							.queryList(atmNodeQueryModel);
					if (CollectionUtils.isEmpty(atmNodeList)) {
						// 如果atmnode表中没有关联到该equip的记录，则增加一条atmnode记录
						atmNodeDao.save(atmNode);
					} else if (atmNodeList.size() > 1) {
						// 如果存在多条atmnode关联到一条equip上，则导入失败
						data.add("ATM节点" + value.get("atmNodeCode") + "存在多条记录");
						failData.add(data);
						continue;
					} else {
						// 如果已有一条atmnode记录关联到equip，则更新
						AtmNode nodeInDb = atmNodeList.get(0);
						// 将导入Excel中的记录内容更新至数据库中
						BeanUtils.copyProperties(nodeInDb, atmNode,
								ignoreColumns.toArray(new String[0]));
						BeanUtils.copyProperties(atmNode, nodeInDb);
						update(nodeInDb);
					}

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
	 * @author:xiongzhikang
	 * @Date:2014-4-14 下午2:16:56
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
			if (name.toUpperCase().matches(".*区内序号.*")) {
				colNum.put("atmNodeSeq", i);
			}
			if (name.matches(".*节点地点.*")) {
				colNum.put("atmNodeNameCn", i);
			}
			if (name.matches(".*节点名称.*")) {
				colNum.put("atmNodeCode", i);
			}
			if (name.matches(".*ATM0地址.*")) {
				colNum.put("atmNodeIp", i);
			}
		}
		if (CollectionUtils.isEmpty(colNum) || colNum.size() < 5) {
			throw new ServiceException("导入的数据文件格式不正确！");
		}
		if (colNum.get("bureau") == null) {
			throw new ServiceException("导入数据必须包含区域！");
		}
		if (colNum.get("atmNodeSeq") == null) {
			throw new ServiceException("导入数据必须包含区内序号！");
		}
		if (colNum.get("atmNodeNameCn") == null) {
			throw new ServiceException("导入数据必须包含节点地点！");
		}
		if (colNum.get("atmNodeCode") == null) {
			throw new ServiceException("导入数据必须包含节点名称！");
		}
		if (colNum.get("atmNodeIp") == null) {
			throw new ServiceException("导入数据必须包含ATM0地址！");
		}
		return colNum;
	}

	/**
	 * 获取一行数据的校验结果
	 * 
	 * @author:xiongzhikang
	 * @Date:2014-4-14 下午2:17:57
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

		// 区域
		String bureau = data.get(colNum.get("bureau")).trim();
		if (!StringTools.hasText(bureau)) {
			throw new ServiceException("区域不能为空");
		}
		boolean exist = false;
		for (Bureau b : Bureau.values()) {
			if (b.getValue().trim().equals(bureau)) {
				exist = true;
				break;
			}
		}
		if (!exist) {
			throw new ServiceException("区域不存在");
		}

		// 区内序号
		String atmNodeSeq = data.get(colNum.get("atmNodeSeq")).trim();
		if (!StringTools.hasText(atmNodeSeq)
				|| !atmNodeSeq.matches(regexAtmNodeSeq)) {
			throw new ServiceException("区内序号必须为正整数");
		}

		// 节点地点
		String atmNodeNameCn = data.get(colNum.get("atmNodeNameCn")).trim();
		if (!StringTools.hasText(atmNodeNameCn)
				|| !atmNodeNameCn.matches(regexAtmNodeNameCn)) {
			throw new ServiceException("节点地点必须为中文");
		}

		// 节点名称
		String atmNodeCode = data.get(colNum.get("atmNodeCode")).trim();
		if (!StringTools.hasText(atmNodeCode)
				|| !atmNodeCode.matches(regexAtmNodeCode)) {
			throw new ServiceException("节点名称格式必须为XXXX-XXXSSSS-SS，X表示大写英文，S表示数字");
		}

		// ATM0地址
		String atmNodeIp = data.get(colNum.get("atmNodeIp")).trim();
		if (!StringTools.hasText(atmNodeIp)
				|| !atmNodeIp.matches(regexAtmNodeIp)) {
			throw new ServiceException("请检查IP格式");
		}

		// 校验通过的记录返回，否则抛出异常，存入failData中
		value.put("bureau", bureau);
		value.put("atmNodeSeq", atmNodeSeq);
		value.put("atmNodeNameCn", atmNodeNameCn);
		value.put("atmNodeCode", atmNodeCode);
		value.put("atmNodeIp", atmNodeIp);
		return value;
	}

	@Override
	public Workbook exportExcel(AtmNodeQueryModel queryModel, File template)
			throws IOException, InvalidFormatException {
		List<AtmNode> atmNodes = atmNodeDao.queryList(queryModel);
		if (CollectionUtils.isEmpty(atmNodes)) {
			return null;
		}
		Workbook wb = null;
		Sheet sheet = null;
		// 判断模板是否存在
		if (template == null) {
			// 不存在，则自己到处抬头行
			wb = new HSSFWorkbook();
			sheet = wb.createSheet("ATM全网节点统计表");// 注意获取sheet的方式不一样
			Row titleRow = sheet.createRow(0);
			titleRow.createCell(0).setCellValue("区域");
			titleRow.createCell(1).setCellValue("区内序号");
			titleRow.createCell(2).setCellValue("节点地点");
			titleRow.createCell(3).setCellValue("节点名称");
			titleRow.createCell(4).setCellValue("ATM0地址");
		} else {
			// 存在，则直接获取模板中的抬头样式
			wb = ExcelPoiTools.create(new FileInputStream(template));
			if (!CollectionUtils.isEmpty(atmNodes)) {
				sheet = wb.getSheetAt(0);
			}
		}
		if (CollectionUtils.isEmpty(atmNodes)) {
			return wb;
		}
		// 将atmNode的信息导出
		for (int i = 0; i < atmNodes.size(); i++) {
			Row row = sheet.createRow(i + 1);
			// 给这一行的第一列赋值
			// 区域
			row.createCell(0).setCellValue(
					atmNodes.get(i).getBureau() == null ? "" : atmNodes.get(i)
							.getBureau().getValue());
			// 区内序号
			row.createCell(1).setCellValue(
					atmNodes.get(i).getAtmNodeSeq() == null ? "" : atmNodes
							.get(i).getAtmNodeSeq().toString());
			// 节点地点
			row.createCell(2).setCellValue(
					atmNodes.get(i).getAtmNodeNameCn() == null ? "" : atmNodes
							.get(i).getAtmNodeNameCn());
			// 节点名称
			row.createCell(3).setCellValue(
					atmNodes.get(i).getAtmNodeCode() == null ? "" : atmNodes
							.get(i).getAtmNodeCode());
			// ATM0地址
			row.createCell(4).setCellValue(
					atmNodes.get(i).getAtmNodeIp() == null ? "" : atmNodes.get(
							i).getAtmNodeIp());
		}
		return wb;
	}
}
