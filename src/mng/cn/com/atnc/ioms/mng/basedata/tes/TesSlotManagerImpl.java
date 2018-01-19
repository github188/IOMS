/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-24 上午10:50:11
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.basedata.tes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.tes.TesNode;
import cn.com.atnc.ioms.entity.basedata.tes.TesSlot;
import cn.com.atnc.ioms.model.basedata.tes.TesNodeQueryModel;
import cn.com.atnc.ioms.model.basedata.tes.TesSlotQueryModel;
import cn.com.atnc.ioms.util.ExcelPoiTools;

@Service("TesSlotManager")
public class TesSlotManagerImpl extends AbstractService implements
		ITesSlotManager {

	@Autowired
	private ITesSlotDao tesSlotDao;
	@Autowired
	private IEquipDao equipDao;
	@Autowired
	private ISatelliteSiteDao siteDao;

	@Autowired
	private ITesNodeDao tesNodeDao;

	private final String regexMemo = "^[0-9\u4e00-\u9fa5a-z_A-Z\\pP‘’“”\\s]{0,50}$";// 备注正则表达式

	private final String regexTesNodeCode = "^[0-9A-Z]{4}$";// 机箱号正则
	private final String regexCu = "^([1-9]|1[0-4]|14)$";// 1～14//
	// CU正则
	private final String regexOcc = "^[1-9]{1}(\\d)?$";// CU正则

	private final int columnNum = 4;

	@Override
	@Transactional
	public TesSlot add(TesSlot node) throws ServiceException {
		// TODO Auto-generated method stub

		// Equip equip = new Equip();
		// equip.setBureau(node.getBureau());
		// equip.setCode(node.getTesNodeCode());// 节点号是唯一的
		// equip.setSatellite(siteDao.findById(node.getSiteId()));
		// equipDao.save(equip);
		// node.setEquip(equip);

		tesSlotDao.save(node);
		return node;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager#update(cn.com.atnc.ioms.entity.basedata.ku.KuNode)
	 */
	@Override
	@Transactional
	public TesSlot update(TesSlot slot) throws ServiceException {
		// TODO Auto-generated method stub
		// 获取关联的TES节点
		TesNode node = slot.getTesNode();
		if (node == null) {
			if (!StringTools.hasText(slot.getTesNodeId())) {
				throw new ServiceException("无关联的TES节点");
			}
			node = tesNodeDao.findById(slot.getTesNodeId());
			if (node == null) {
				throw new ServiceException("数据库中无关联的TES节点信息");
			}
		}

		slot.setTesNode(node);
		tesSlotDao.saveOrUpdate(slot);
		return slot;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager#findById(java.lang.String)
	 */
	@Override
	public TesSlot findById(String id) {
		// TODO Auto-generated method stub
		TesSlot slot = tesSlotDao.findById(id);
		if (slot.getTesNode() == null) {
			return slot;
		}
		slot.setTesNodeId(slot.getTesNode().getId());

		// if (node.getEquip() == null) {
		// return node;
		// }
		// node.setEquipId(node.getEquip().getId());
		// if (node.getEquip().getSatellite() == null) {
		// return node;
		// }
		// node.setSiteCode(node.getEquip().getSatellite().getSiteCode());
		// node.setSiteId(node.getEquip().getSatellite().getId());
		// node.setBureau(node.getEquip().getBureau());
		return slot;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager#delete(java.lang.String)
	 */
	@Override
	public String delete(String id) throws ServiceException {
		// TODO Auto-generated method stub
		TesSlot slot = findById(id);
		tesSlotDao.delete(slot);
		return slot.getId();// node .getTesNodeCode();
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
			// 机箱号 CU OCC 备注
			if (name.matches(".*机箱号.*")) {
				colNum.put("tesNodeCode", i);
			}

			if (name.matches(".*槽位号.*")) {
				colNum.put("cu", i);
			}

			if (name.matches(".*OCC.*")) {
				colNum.put("occ", i);
			}

			if (name.matches(".*备注.*")) {
				colNum.put("info", i);
			}
		}
		if (CollectionUtils.isEmpty(colNum) || colNum.size() < columnNum) {
			throw new ServiceException("导入的数据文件格式不正确！");
		}

		if (colNum.get("tesNodeCode") == null) {
			throw new ServiceException("导入数据必须包含机箱号!");
		}

		if (colNum.get("cu") == null) {
			throw new ServiceException("导入数据必须包含有CU数据！");
		}
		if (colNum.get("occ") == null) {
			throw new ServiceException("导入数据必须包含OCC数据！");
		}
		if (colNum.get("info") == null) {
			throw new ServiceException("导入数据必须包含备注数据！");
		}

		return colNum;
	}

	private Map<String, String> getValueAndCheck(Vector<String> data,
			Map<String, Integer> colNum) throws ServiceException,
			UnsupportedEncodingException {
		Map<String, String> value = new HashMap<String, String>();

		String tesNodeCode = data.get(colNum.get("tesNodeCode")).trim()
				.toUpperCase();
		if (!StringTools.hasText(tesNodeCode)
				|| !tesNodeCode.matches(regexTesNodeCode)) {
			throw new ServiceException("TES机箱号必须为4位数字，大写英文");
		}
		String info = "";// 备注
		String cu = "";
		String occ = "";
		if (colNum.get("info") != null) {
			info = data.get(colNum.get("info")).trim();
			if (StringTools.hasText(info) && !info.matches(regexMemo)) {
				throw new ServiceException("备注必须为50位以内的数字,中文,英文,标点符号,空白符");
			}
		}
		if (colNum.get("cu") != null) {

			cu = data.get(colNum.get("cu")).trim();
			if (StringTools.hasText(cu)) {
				if (!cu.matches(regexCu)) {
					throw new ServiceException("槽位号必须为数字1-14");
				} else if (Integer.parseInt(cu) > 14) {
					throw new ServiceException("槽位号必须为数字1-14");
				}
			}
		}
		if (colNum.get("occ") != null) {
			occ = data.get(colNum.get("occ")).trim();
			if (StringTools.hasText(occ) && !occ.matches(regexOcc)) {
				throw new ServiceException("OCC必须为[1,99]正整数");
			}
		}
		value.put("tesNodeCode", tesNodeCode);
		value.put("cu", cu);
		value.put("occ", occ);
		value.put("info", info);
		return value;
	}

	@Override
	public Pagination queryPage(TesSlotQueryModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TesSlot> queryList(TesSlotQueryModel model) {
		// TODO Auto-generated method stub
		return tesSlotDao.queryList(model);
	}

	@Override
	public Long querySize(TesSlotQueryModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TesSlot> queryListByTesNode(TesNode tesnode) {
		// TODO Auto-generated method stub
		return tesSlotDao.queryListByTesNode(tesnode);
	}

	@Override
	public String deleteByTesNode(TesNode node) throws ServiceException {
		// TODO Auto-generated method stub
		List<TesSlot> tesSlotList = tesSlotDao.queryListByTesNode(node);
		tesSlotDao.deleteList(tesSlotList);
		return node.getId();
	}

	@Override
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

				// 将字符串包装成TesSlot
				TesSlot slot = new TesSlot();
				slot.setCu(value.get("cu"));
				if (value.get("occ") != null
						&& value.get("occ").trim().length() > 0) {
					slot.setOcc(Integer.parseInt(value.get("occ")));
				}
				slot.setInfo(value.get("info"));
				slot.setOptTime(Calendar.getInstance());
				slot.setOptUser(user);

				TesNodeQueryModel nodeQueryModel = new TesNodeQueryModel();
				nodeQueryModel.setTesNodeCode(value.get("tesNodeCode"));
				List<TesNode> nodeList = tesNodeDao.queryList(nodeQueryModel);
				TesNode node = null;
				if (CollectionUtils.isEmpty(nodeList)) {
					data.add("TES机箱号" + value.get("tesNodeCode") + "不存在");
					failData.add(data);
					continue;
				} else if (nodeList.size() > 1) {
					data.add("TES机箱号" + value.get("tesNodeCode") + "存在多条记录");
					failData.add(data);
					continue;
				} else {
					node = nodeList.get(0);
					slot.setTesNode(node);
					TesSlotQueryModel slotQueryModel = new TesSlotQueryModel();
					slotQueryModel.setTesNodeId(node.getId());

					slotQueryModel.setCu(value.get("cu"));

					List<TesSlot> slotList = tesSlotDao
							.queryList(slotQueryModel);
					if (CollectionUtils.isEmpty(slotList)) {
						// 如果为空，则新增一条slot记录
						this.add(slot);
					} else if (slotList.size() > 1) {
						// 如果 nodeid_cu不唯一
						data.add("TES机箱号（" + value.get("tesNodeCode") + "）_"
								+ "槽位号（" + value.get("cu") + "）存在多条记录");// +
																		// slotList.size()
						failData.add(data);
						continue;
					} else {
						// 如果已有一条tesnode+cu则更新
						TesSlot slotInDb = slotList.get(0);
						// 将导入Excel中的记录内容更新至数据库中
						BeanUtils.copyProperties(slotInDb, slot,
								ignoreColumns.toArray(new String[0]));
						BeanUtils.copyProperties(slot, slotInDb);
						update(slotInDb);
					}
				}
				// this.add(slot);
			}
		} finally {
			FileUpload.delFile(filePath);
		}
		return failData;
	}

	@Override
	public List<TesSlot> queryListByParam(TesSlotQueryModel queryModel) {
		// TODO Auto-generated method stub
		return tesSlotDao.queryList(queryModel);
	}
}
