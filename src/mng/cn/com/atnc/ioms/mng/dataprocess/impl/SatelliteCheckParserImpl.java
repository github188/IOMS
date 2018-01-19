/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-17 上午9:04:25
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.dataprocess.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.dao.duty.satelliteauto.day.SatDsOduDao;
import cn.com.atnc.ioms.dao.duty.satelliteauto.day.SatSlhPesDao;
import cn.com.atnc.ioms.dao.duty.satelliteauto.day.SatTxjdKuDayDao;
import cn.com.atnc.ioms.dao.duty.satelliteauto.day.SatTxjdOverseaMainDao;
import cn.com.atnc.ioms.dao.duty.satelliteauto.day.SatTxjdTesOCCDao;
import cn.com.atnc.ioms.dao.duty.satelliteauto.day.SatTxjdTesODUDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatDsOdu;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatSlhPes;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdKuDay;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdOverseaMain;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdTesOCC;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdTesODU;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteDayAutoType;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteStatus;
import cn.com.atnc.ioms.mng.dataprocess.ISatelliteCheckParser;
import cn.com.atnc.ioms.mng.systemmng.param.ISystemConfigManager;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;
import cn.com.atnc.ioms.model.duty.satelliteauto.ParseDataModel.DsOduModel;
import cn.com.atnc.ioms.model.duty.satelliteauto.ParseDataModel.KuEfdataRjuModel;
import cn.com.atnc.ioms.model.duty.satelliteauto.ParseDataModel.KuModel;
import cn.com.atnc.ioms.model.duty.satelliteauto.ParseDataModel.TesOccModel;
import cn.com.atnc.ioms.model.duty.satelliteauto.ParseDataModel.TxjdOduModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 卫星自检解析 具体操作
 *
 * @author 段衍林
 * @2016年11月29日 下午2:38:02
 */
@Service("SatelliteCheckParser")
public class SatelliteCheckParserImpl extends AbstractService implements
		ISatelliteCheckParser {

	@Autowired
	private IUserDao userDao;
	@Autowired
	private SatTxjdTesOCCDao satTxjdTesOCCDao;
	@Autowired
	private SatTxjdTesODUDao satTxjdTesODUDao;
	@Autowired
	private SatTxjdOverseaMainDao satTxjdOverseaMainDao;
	@Autowired
	private SatTxjdKuDayDao satTxjdKuDayDao;
	@Autowired
	private SatDsOduDao satDsOduDao;
	@Autowired
	private SatSlhPesDao satSlhPesDao;

	@Autowired
	@Qualifier(value = "SystemConfigDBManagerImpl")
	private ISystemConfigManager sysConfigManager;

	private final String[] times = { "08:00:00", "10:00:00", "13:00:00",
			"15:00:00", "17:00:00", "20:00:00", "22:00:00", "01:00:00",
			"04:00:00", "06:30:00" };

	/**
	 * 通信基地-TES-TES OCC
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void parseTesOcc(String jsonStr, String fileName, Date checkTime)
			throws ServiceException {
		List<TesOccModel> tesOccList = null;
		try {
			tesOccList = (List<TesOccModel>) JacksonTools.jsonToList(jsonStr,
					TesOccModel.class);
		} catch (IOException e) {
			throw new ServiceException("Json转义失败," + e.getMessage());
		}
		if (CollectionUtils.isEmpty(tesOccList)) {
			return;
		}
		System.out.println("tesOccList.size()：" + tesOccList.size());

		// 声明OCC存储实体
		SatTxjdTesOCC satTxjdTesOCC = new SatTxjdTesOCC();
		// 巡检时间
		satTxjdTesOCC.setCheckTime(checkTime);
		// 设备名称
		satTxjdTesOCC.setEquipName(SatelliteDayAutoType.txjdTesOCC);
		// 当前操作人--赋值为管理员
		User admin = userDao.findById("admin");
		satTxjdTesOCC.setOperator(admin);
		// satTxjdTesOCC更新标记
		int flag = 0;

		/**
		 * 遍历保存
		 */
		for (TesOccModel tesOccModel : tesOccList) {
			// 取出解析值
			// 底噪
			String noise = tesOccModel.getNoiseFloor();
			// 峰值
			String peak = tesOccModel.getPeak();
			String desc = tesOccModel.getDesc();
			// 条件判断
			switch (desc) {
			case "TES_OCC1":
				/**
				 * OCC1存储
				 */
				satTxjdTesOCC.setOcc1Noise(noise);
				satTxjdTesOCC.setOcc1Peak(peak);
				// 控制更新
				flag++;
				break;
			case "TES_OCC2":
				/**
				 * OCC2存储
				 */
				satTxjdTesOCC.setOcc2Noise(noise);
				satTxjdTesOCC.setOcc2Peak(peak);
				// 控制更新
				flag++;
				break;
			case "TES_OCC3":
				/**
				 * OCC3存储
				 */
				satTxjdTesOCC.setOcc3Noise(noise);
				satTxjdTesOCC.setOcc3Peak(peak);
				// 控制更新
				flag++;
				break;
			case "TES_OCC4":
				/**
				 * OCC4存储
				 */
				satTxjdTesOCC.setOcc4Noise(noise);
				satTxjdTesOCC.setOcc4Peak(peak);
				// 控制更新
				flag++;
				break;
			case "MASTER_CARRIER":
				/**
				 * 通信基地-境外站-境外站主站载波
				 */
				SatTxjdOverseaMain main = new SatTxjdOverseaMain();
				// 巡检时间
				main.setCheckTime(checkTime);
				// 设备名称
				main.setEquipName(SatelliteDayAutoType.txjdOverseaMain);
				// 当前操作人--赋值为管理员
				main.setOperator(admin);
				// 底噪
				main.setCarrierNoise(noise);
				// 峰值
				main.setCarrierPeak(peak);
				// 保存
				satTxjdOverseaMainDao.save(main);
				break;
			case "OVERSEA_CARRIER":
				/**
				 * 十里河-PES-PES出境载波状态
				 */
				SatSlhPes pes = new SatSlhPes();
				// 巡检时间
				pes.setCheckTime(checkTime);
				// 设备名称
				pes.setEquipName(SatelliteDayAutoType.slhPES);
				// 当前操作人--赋值为管理员
				pes.setOperator(admin);
				// 底噪
				pes.setCarrierNoise(noise);
				// 峰值
				pes.setCarrierPeak(peak);
				// 保存
				satSlhPesDao.save(pes);
				break;
			case "SubNet1":
			case "SubNet2":
			case "SubNet3":
			case "SubNet4":
			case "FrNet":
				/**
				 * 子网添加底噪和峰值
				 */
				// 获取标准数据
				Date formatDate = this.evalFormatTime(checkTime);
				if (ObjectUtils.equals(formatDate, null)) {
					break;
				}
				// 封装开始和结束时间
				Date startTime = DateUtils.addMinutes(formatDate, -15);
				Date endTime = DateUtils.addMinutes(formatDate, 15);
				// 封装查询条件
				SatelliteAutoModel queryModel = new SatelliteAutoModel();
				queryModel.setStartTime(startTime);
				queryModel.setEndTime(endTime);
				// 列表查询
				List<SatTxjdKuDay> kus = (List<SatTxjdKuDay>) satTxjdKuDayDao
						.queryPageByModel(queryModel).getResult();
				// 生成实体
				SatTxjdKuDay ku = null;

				// 实体赋值
				if (!CollectionUtils.isEmpty(kus)) {
					// 取最新一条
					ku = kus.get(0);
				} else {
					// 生成新实体
					ku = new SatTxjdKuDay();
				}
				List<KuModel> kuList = null;
				try {
					kuList = (List<KuModel>) JacksonTools.jsonToList(jsonStr,
							KuModel.class);
				} catch (IOException e) {
					throw new ServiceException("Json转义失败," + e.getMessage());
				}
				if (CollectionUtils.isEmpty(kuList)) {
					return;
				}
				// 巡检时间
				ku.setCheckTime(checkTime);
				// 设备名称
				ku.setEquipName(SatelliteDayAutoType.txjdKu);
				// 当前操作人--赋值为管理员
				ku.setOperator(admin);
				if (StringUtils.equalsIgnoreCase(desc, "SubNet1")) {
					// 子网1--底噪、峰值
					ku.setNet10Noise(noise);
					ku.setNet10Peak(peak);
				} else if (StringUtils.equalsIgnoreCase(desc, "SubNet2")) {
					// 子网2--底噪、峰值
					ku.setNet20Noise(noise);
					ku.setNet20Peak(peak);
				} else if (StringUtils.equalsIgnoreCase(desc, "SubNet3")) {
					// 子网3--底噪、峰值
					ku.setNet30Noise(noise);
					ku.setNet30Peak(peak);
				} else if (StringUtils.equalsIgnoreCase(desc, "SubNet4")) {
					// 子网4--底噪、峰值
					ku.setNet40Noise(noise);
					ku.setNet40Peak(peak);
				} else if (StringUtils.equalsIgnoreCase(desc, "FrNet")) {
					// FR小网--底噪、峰值
					ku.setNetfrNoise(noise);
					ku.setNetfrPeak(peak);
				}
				// 数据更新
				satTxjdKuDayDao.saveOrUpdate(ku);
				break;
			default:
				break;
			}
		}
		// 根据标记更新
		if (flag > 0) {
			// 数据保存
			satTxjdTesOCCDao.saveOrUpdate(satTxjdTesOCC);
		}
	}

	/**
	 * 通信基地-TES-TES ODU
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void parseTxjdOdu(String jsonStr, String fileName, Date checkTime)
			throws ServiceException {
		List<TxjdOduModel> txjdOduList = null;
		try {
			txjdOduList = (List<TxjdOduModel>) JacksonTools.jsonToList(jsonStr,
					TxjdOduModel.class);
		} catch (IOException e) {
			throw new ServiceException("Json转义失败," + e.getMessage());
		}
		if (CollectionUtils.isEmpty(txjdOduList)) {
			return;
		}
		System.out.println("txjdOduList.size()：" + txjdOduList.size());

		// 声明OCC存储实体
		SatTxjdTesODU satTxjdTesODU = new SatTxjdTesODU();
		// 巡检时间
		satTxjdTesODU.setCheckTime(checkTime);
		// 设备名称
		satTxjdTesODU.setEquipName(SatelliteDayAutoType.txjdTesODU);
		// 当前操作人--赋值为管理员
		User admin = userDao.findById("admin");
		satTxjdTesODU.setOperator(admin);
		/**
		 * 遍历保存
		 */
		for (TxjdOduModel txjdOduModel : txjdOduList) {
			// TXA状态
			satTxjdTesODU.setTxaResult(evalTxjdOduStatus(txjdOduModel
					.getTxAPath()));
			// RXA状态
			satTxjdTesODU.setRxaResult(evalTxjdOduStatus(txjdOduModel
					.getRxAPath()));
			// TXB状态
			satTxjdTesODU.setTxbResult(evalTxjdOduStatus(txjdOduModel
					.getTxBPath()));
			// RXB状态
			satTxjdTesODU.setRxbResult(evalTxjdOduStatus(txjdOduModel
					.getRxBPath()));
			// TX Freq（A路）
			satTxjdTesODU.setTxfreqAresult(txjdOduModel.getUpFreqA());
			// RX Freq（A路）
			satTxjdTesODU.setRxfreqAresult(txjdOduModel.getDownFreqA());
			// TX Freq（B路）
			satTxjdTesODU.setTxfreqBresult(txjdOduModel.getUpFreqB());
			// RX Freq（B路）
			satTxjdTesODU.setRxfreqBresult(txjdOduModel.getDownFreqB());
			// UC AT Level(A路)
			satTxjdTesODU.setUsAresult(txjdOduModel.getUpAtteA());
			// DC AT Level(A路)
			satTxjdTesODU.setDcAresult(txjdOduModel.getDownAttA());
			// UC AT Level(B路)
			satTxjdTesODU.setUsBresult(txjdOduModel.getUpAtteB());
			// DC AT Level(B路)
			satTxjdTesODU.setDcBresult(txjdOduModel.getDownAttB());
		}
		// 数据保存
		satTxjdTesODUDao.save(satTxjdTesODU);
	}

	/**
	 * 通信基地odu状态判断
	 * 
	 * @author 段衍林
	 * @2016年11月30日 上午10:48:57
	 * @param str
	 * @return SatelliteStatus
	 */
	public SatelliteStatus evalTxjdOduStatus(String str) {
		// 判断OK？
		if (StringUtils.equalsIgnoreCase(str, SatelliteStatus.OK.name())) {
			// ok
			return SatelliteStatus.OK;
		} else {
			// Alm
			return SatelliteStatus.Alm;
		}
	}

	/**
	 * 通信基地-KU卫星--子网相关数据
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void parseKuData(String jsonStr, String fileName, Date checkTime,
			String equipName) throws ServiceException {
		// 获取标准数据
		Date formatDate = this.evalFormatTime(checkTime);
		if (ObjectUtils.equals(formatDate, null)) {
			return;
		}
		// 封装开始和结束时间
		Date startTime = DateUtils.addMinutes(formatDate, -15);
		Date endTime = DateUtils.addMinutes(formatDate, 15);
		// 封装查询条件
		SatelliteAutoModel queryModel = new SatelliteAutoModel();
		queryModel.setStartTime(startTime);
		queryModel.setEndTime(endTime);
		// 列表查询
		List<SatTxjdKuDay> kus = (List<SatTxjdKuDay>) satTxjdKuDayDao
				.queryPageByModel(queryModel).getResult();
		// 生成实体
		SatTxjdKuDay ku = null;
		// 实体赋值
		if (!CollectionUtils.isEmpty(kus)) {
			// 取最新一条
			ku = kus.get(0);
		} else {
			// 生成新实体
			ku = new SatTxjdKuDay();
		}
		List<KuModel> kuList = null;
		try {
			kuList = (List<KuModel>) JacksonTools.jsonToList(jsonStr,
					KuModel.class);
		} catch (IOException e) {
			throw new ServiceException("Json转义失败," + e.getMessage());
		}
		if (CollectionUtils.isEmpty(kuList)) {
			return;
		}
		System.out.println("kuList.size()：" + kuList.size());

		// 巡检时间
		ku.setCheckTime(checkTime);
		// 设备名称
		ku.setEquipName(SatelliteDayAutoType.txjdKu);
		// 当前操作人--赋值为管理员
		User admin = userDao.findById("admin");
		ku.setOperator(admin);

		/**
		 * 遍历保存
		 */
		for (KuModel kuModel : kuList) {
			switch (equipName) {
			case "SubNet1":
				ku = this.evalNet1(ku, kuModel);
				break;
			case "SubNet2":
				ku = this.evalNet2(ku, kuModel);
				break;
			case "SubNet3":
				ku = this.evalNet3(ku, kuModel);
				break;
			case "SubNet4":
				ku = this.evalNet4(ku, kuModel);
				break;
			case "FrNet":
				ku = this.evalNetFR(ku, kuModel);
				break;
			default:
				break;
			}
		}
		// 数据更新
		satTxjdKuDayDao.saveOrUpdate(ku);
	}

	/**
	 * 通信基地-KU卫星--温度、参数、状态
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void parseKuEfdataRju(String jsonStr, String fileName, Date checkTime)
			throws ServiceException {
		// 获取标准数据
		Date formatDate = this.evalFormatTime(checkTime);
		if (ObjectUtils.equals(formatDate, null)) {
			return;
		}
		// 封装开始和结束时间
		Date startTime = DateUtils.addMinutes(formatDate, -15);
		Date endTime = DateUtils.addMinutes(formatDate, 15);
		// 封装查询条件
		SatelliteAutoModel queryModel = new SatelliteAutoModel();
		queryModel.setStartTime(startTime);
		queryModel.setEndTime(endTime);
		// 列表查询
		List<SatTxjdKuDay> kus = (List<SatTxjdKuDay>) satTxjdKuDayDao
				.queryPageByModel(queryModel).getResult();
		// 生成实体
		SatTxjdKuDay ku = null;
		// 实体赋值
		if (!CollectionUtils.isEmpty(kus)) {
			// 取最新一条
			ku = kus.get(0);
		} else {
			// 生成新实体
			ku = new SatTxjdKuDay();
		}
		List<KuEfdataRjuModel> kuList = null;
		try {
			kuList = (List<KuEfdataRjuModel>) JacksonTools.jsonToList(jsonStr,
					KuEfdataRjuModel.class);
		} catch (IOException e) {
			throw new ServiceException("Json转义失败," + e.getMessage());
		}
		if (CollectionUtils.isEmpty(kuList)) {
			return;
		}
		System.out.println("kuList.size()：" + kuList.size());
		// 巡检时间
		ku.setCheckTime(checkTime);
		// 设备名称
		ku.setEquipName(SatelliteDayAutoType.txjdKu);
		// 当前操作人--赋值为管理员
		User admin = userDao.findById("admin");
		ku.setOperator(admin);
		// 循环遍历
		for (KuEfdataRjuModel KuEfdataRjuModel : kuList) {
			/**
			 * ODU温度解析
			 */
			// ODU_A
			ku.setOdutAuct(KuEfdataRjuModel.getUctA());
			ku.setOdutAdct(KuEfdataRjuModel.getDctA());
			ku.setOdutAmct(KuEfdataRjuModel.getMctA());
			// ODU_B
			ku.setOdutBuct(KuEfdataRjuModel.getUctB());
			ku.setOdutBdct(KuEfdataRjuModel.getDctB());
			ku.setOdutBmct(KuEfdataRjuModel.getMctB());
			/**
			 * ODU参数解析
			 */
			// ODU_A
			ku.setOdutAucf(KuEfdataRjuModel.getUcfA());
			ku.setOdutAuca(KuEfdataRjuModel.getUcaA());
			ku.setOdutAdcf(KuEfdataRjuModel.getDcfA());
			ku.setOdutAdca(KuEfdataRjuModel.getDcaA());
			// ODU_B
			ku.setOdutBucf(KuEfdataRjuModel.getUcfB());
			ku.setOdutBuca(KuEfdataRjuModel.getUcaB());
			ku.setOdutBdcf(KuEfdataRjuModel.getDcfB());
			ku.setOdutBdca(KuEfdataRjuModel.getDcaB());
			/**
			 * ODU状态解析
			 */
			// ODU_A---usA、hsA、dsA、rsA、agsA、lsA、cesA全为OK时，状态为OK
			if (StringUtils.equalsIgnoreCase(KuEfdataRjuModel.getUsA(),
					SatelliteStatus.OK.name())
					&& StringUtils.equalsIgnoreCase(KuEfdataRjuModel.getHsA(),
							SatelliteStatus.OK.name())
					&& StringUtils.equalsIgnoreCase(KuEfdataRjuModel.getDsA(),
							SatelliteStatus.OK.name())
					&& StringUtils.equalsIgnoreCase(KuEfdataRjuModel.getRsA(),
							SatelliteStatus.OK.name())
					&& StringUtils.equalsIgnoreCase(KuEfdataRjuModel.getAgsA(),
							SatelliteStatus.OK.name())
					&& StringUtils.equalsIgnoreCase(KuEfdataRjuModel.getLsA(),
							SatelliteStatus.OK.name())
					&& StringUtils.equalsIgnoreCase(KuEfdataRjuModel.getCesA(),
							SatelliteStatus.OK.name())) {
				// 赋值成功
				ku.setOdusAresult(SatelliteStatus.OK.name());
			} else {
				// 赋值失败
				ku.setOdusAresult(SatelliteStatus.Failed.name());
			}
			// ODU_B---usB、hsB、dsB、rsB、agsB、lsB、cesB全为OK时，状态为OK
			if (StringUtils.equalsIgnoreCase(KuEfdataRjuModel.getUsB(),
					SatelliteStatus.OK.name())
					&& StringUtils.equalsIgnoreCase(KuEfdataRjuModel.getHsB(),
							SatelliteStatus.OK.name())
					&& StringUtils.equalsIgnoreCase(KuEfdataRjuModel.getDsB(),
							SatelliteStatus.OK.name())
					&& StringUtils.equalsIgnoreCase(KuEfdataRjuModel.getRsB(),
							SatelliteStatus.OK.name())
					&& StringUtils.equalsIgnoreCase(KuEfdataRjuModel.getAgsB(),
							SatelliteStatus.OK.name())
					&& StringUtils.equalsIgnoreCase(KuEfdataRjuModel.getLsB(),
							SatelliteStatus.OK.name())
					&& StringUtils.equalsIgnoreCase(KuEfdataRjuModel.getCesB(),
							SatelliteStatus.OK.name())) {
				// 赋值成功
				ku.setOdusBresult(SatelliteStatus.OK.name());
			} else {
				// 赋值失败
				ku.setOdusBresult(SatelliteStatus.Failed.name());
			}
		}
		// 数据库保存
		satTxjdKuDayDao.saveOrUpdate(ku);
	}

	/**
	 * 解析查询时间
	 * 
	 * @author 段衍林
	 * @2016年11月29日 下午5:05:46
	 * @return Date
	 */
	public Date evalFormatTime(Date checkTime) {
		// 返回日期变量
		Date formatDate = null;
		for (String str : times) {
			// 拼接有效数据
			String formatTime = DateUtilTools.getNowDateStr() + " " + str;
			// 格式转换
			Date forDate = DateUtilTools.parseDate(formatTime,
					DateUtilTools.PATTERN_DATE_3);
			// 封装开始和结束时间
			Date start = DateUtils.addMinutes(forDate, -15);
			Date end = DateUtils.addMinutes(forDate, 15);
			// 当前时间晚于开始早于结束
			if (checkTime.before(end) && checkTime.after(start)) {
				// 返回时间标准
				formatDate = forDate;
			}
		}
		// 如果所有规则都不符合，该数据抛弃
		return formatDate;
	}

	/**
	 * 解析子网1相关数据
	 * 
	 * @author 段衍林
	 * @2016年11月29日 下午5:05:46
	 * @return Date
	 */
	public SatTxjdKuDay evalNet1(SatTxjdKuDay ku, KuModel kuModel) {
		// 电平
		String rxLvl = kuModel.getRxLvl();
		// 信噪比
		String ebno = kuModel.getEbno();
		// 条件判断
		String desc = kuModel.getDesc();
		// 主备时钟节点号
		String node = kuModel.getNode();
		switch (desc) {
		case "0":
			/**
			 * 子网1的0号节点收0号节点信噪比和电平
			 */
			ku.setNet10Rx0(rxLvl);
			ku.setNet10Eb0(ebno);
			break;
		case "1":
			/**
			 * 子网1的0号节点收1号节点信噪比和电平
			 */
			ku.setNet10Rx1(rxLvl);
			ku.setNet10Eb1(ebno);
			break;
		case "130":
			/**
			 * 子网1的0号节点收130号节点信噪比和电平
			 */
			ku.setNet10Rx130(rxLvl);
			ku.setNet10Eb130(ebno);
			break;
		case "primaryStation":
			/**
			 * 主时钟参考节点
			 */
			ku.setNet1Zrx(rxLvl);
			ku.setNet1Zeb(ebno);
			ku.setNet1Znum(node);
			break;
		case "secondaryStation":
			/**
			 * 备时钟参考节点
			 */
			ku.setNet1Brx(rxLvl);
			ku.setNet1Beb(ebno);
			ku.setNet1Bnum(node);
			break;
		default:
			break;
		}
		return ku;
	}

	/**
	 * 解析子网2相关数据
	 * 
	 * @author 段衍林
	 * @2016年11月29日 下午5:05:46
	 * @return Date
	 */
	public SatTxjdKuDay evalNet2(SatTxjdKuDay ku, KuModel kuModel) {
		// 电平
		String rxLvl = kuModel.getRxLvl();
		// 信噪比
		String ebno = kuModel.getEbno();
		// 条件判断
		String desc = kuModel.getDesc();
		// 主备时钟节点号
		String node = kuModel.getNode();
		switch (desc) {
		case "0":
			/**
			 * 子网2的0号节点收0号节点信噪比和电平
			 */
			ku.setNet20Rx0(rxLvl);
			ku.setNet20Eb0(ebno);
			break;
		case "1":
			/**
			 * 子网2的0号节点收1号节点信噪比和电平
			 */
			ku.setNet20Rx1(rxLvl);
			ku.setNet20Eb1(ebno);
			break;
		case "primaryStation":
			/**
			 * 主时钟参考节点
			 */
			ku.setNet2Zrx(rxLvl);
			ku.setNet2Zeb(ebno);
			ku.setNet2Znum(node);
			break;
		case "secondaryStation":
			/**
			 * 备时钟参考节点
			 */
			ku.setNet2Brx(rxLvl);
			ku.setNet2Beb(ebno);
			ku.setNet2Bnum(node);
			break;
		default:
			break;
		}
		return ku;
	}

	/**
	 * 解析子网3相关数据
	 * 
	 * @author 段衍林
	 * @2016年11月29日 下午5:05:46
	 * @return Date
	 */
	public SatTxjdKuDay evalNet3(SatTxjdKuDay ku, KuModel kuModel) {
		// 电平
		String rxLvl = kuModel.getRxLvl();
		// 信噪比
		String ebno = kuModel.getEbno();
		// 条件判断
		String desc = kuModel.getDesc();
		// 主备时钟节点号
		String node = kuModel.getNode();
		switch (desc) {
		case "0":
			/**
			 * 子网3的0号节点收0号节点信噪比和电平
			 */
			ku.setNet30Rx0(rxLvl);
			ku.setNet30Eb0(ebno);
			break;
		case "1":
			/**
			 * 子网3的0号节点收1号节点信噪比和电平
			 */
			ku.setNet30Rx1(rxLvl);
			ku.setNet30Eb1(ebno);
			break;
		case "primaryStation":
			/**
			 * 主时钟参考节点
			 */
			ku.setNet3Zrx(rxLvl);
			ku.setNet3Zeb(ebno);
			ku.setNet3Znum(node);
			break;
		case "secondaryStation":
			/**
			 * 备时钟参考节点
			 */
			ku.setNet3Brx(rxLvl);
			ku.setNet3Beb(ebno);
			ku.setNet3Bnum(node);
			break;
		default:
			break;
		}
		return ku;
	}

	/**
	 * 解析子网4相关数据
	 * 
	 * @author 段衍林
	 * @2016年11月29日 下午5:05:46
	 * @return Date
	 */
	public SatTxjdKuDay evalNet4(SatTxjdKuDay ku, KuModel kuModel) {
		// 电平
		String rxLvl = kuModel.getRxLvl();
		// 信噪比
		String ebno = kuModel.getEbno();
		// 条件判断
		String desc = kuModel.getDesc();
		// 主备时钟节点号
		String node = kuModel.getNode();
		switch (desc) {
		case "0":
			/**
			 * 子网4的0号节点收0号节点信噪比和电平
			 */
			ku.setNet40Rx0(rxLvl);
			ku.setNet40Eb0(ebno);
			break;
		case "1":
			/**
			 * 子网4的0号节点收1号节点信噪比和电平
			 */
			ku.setNet40Rx1(rxLvl);
			ku.setNet40Eb1(ebno);
			break;
		case "primaryStation":
			/**
			 * 主时钟参考节点
			 */
			ku.setNet4Zrx(rxLvl);
			ku.setNet4Zeb(ebno);
			ku.setNet4Znum(node);
			break;
		case "secondaryStation":
			/**
			 * 备时钟参考节点
			 */
			ku.setNet4Brx(rxLvl);
			ku.setNet4Beb(ebno);
			ku.setNet4Bnum(node);
			break;
		default:
			break;
		}
		return ku;
	}

	/**
	 * 解析FR小网相关数据
	 * 
	 * @author 段衍林
	 * @2016年11月29日 下午5:05:46
	 * @return Date
	 */
	public SatTxjdKuDay evalNetFR(SatTxjdKuDay ku, KuModel kuModel) {
		// 电平
		String rxLvl = kuModel.getRxLvl();
		// 信噪比
		String ebno = kuModel.getEbno();
		// 条件判断
		String desc = kuModel.getDesc();
		// 主备时钟节点号
		String node = kuModel.getNode();
		switch (desc) {
		case "primaryStation":
			/**
			 * 主时钟参考节点
			 */
			ku.setNetfrZrx(rxLvl);
			ku.setNetfrZeb(ebno);
			ku.setNetfrZnum(node);
			break;
		case "secondaryStation":
			/**
			 * 备时钟参考节点
			 */
			ku.setNetfrBrx(rxLvl);
			ku.setNetfrBeb(ebno);
			ku.setNetfrBnum(node);
			break;
		default:
			break;
		}
		return ku;
	}

	/**
	 * 东四--odu
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void parseDsOdu(String jsonStr, String fileName, Date checkTime)
			throws ServiceException {
		List<DsOduModel> dsOdus = null;
		try {
			dsOdus = (List<DsOduModel>) JacksonTools.jsonToList(jsonStr,
					DsOduModel.class);
		} catch (IOException e) {
			throw new ServiceException("Json转义失败," + e.getMessage());
		}
		if (CollectionUtils.isEmpty(dsOdus)) {
			return;
		}
		System.out.println("dsOdus.size()：" + dsOdus.size());

		// 声明OCC存储实体
		SatDsOdu satDsOdu = new SatDsOdu();
		// 巡检时间
		satDsOdu.setCheckTime(checkTime);
		// 设备名称
		satDsOdu.setEquipName(SatelliteDayAutoType.dsODU);
		// 当前操作人--赋值为管理员
		User admin = userDao.findById("admin");
		satDsOdu.setOperator(admin);
		/**
		 * 遍历保存
		 */
		for (DsOduModel oduModel : dsOdus) {
			// 主用侧
			String masterAbResult = oduModel.getSiteName();
			if (masterAbResult.contains("A")) {
				// 主侧A
				satDsOdu.setMasterAbResult("A");
			} else {
				// 主侧B
				satDsOdu.setMasterAbResult("B");
			}
			// Receive Freq
			satDsOdu.setReceiveResult(oduModel.getReceiveFreq());
			// Transmit Freq
			satDsOdu.setTransmitResult(oduModel.getTransmitFreq());
			// Atten Down
			satDsOdu.setAttendownResult(oduModel.getAttenDown());
			// Atten UP
			satDsOdu.setAttenupResult(oduModel.getAttenUp());
			// Fixed Freq.PLL
			satDsOdu.setFixedResult(evalOduStatus(oduModel
					.getFixedFreqPllStatus()));
			// Var.Freq.pll
			satDsOdu.setVarResult(evalOduStatus(oduModel.getVarFreqPllStatus()));
			// Ext PA Power
			satDsOdu.setExtpowerResult(evalOduStatus(oduModel
					.getPaPowerStatus()));
			// Ext PA Temp
			satDsOdu.setExttempResult(evalOduStatus(oduModel
					.getPaTemperatureStatus()));
			// LNA Current
			satDsOdu.setLanResult(evalOduStatus(oduModel.getLnaCurrentStatus()));
			// Summary Current
			satDsOdu.setSummaryResult(evalOduStatus(oduModel
					.getSummaryCurrentStatus()));
			// Ext 11V Supply
			satDsOdu.setExtResult(evalOduStatus(oduModel.getFanCurrentStatus()));
			// Redundant Status
			satDsOdu.setRedundantResult(evalOduStatus(oduModel
					.getRedundantStatus()));
		}
		// 数据保存
		satDsOduDao.save(satDsOdu);
	}

	/**
	 * odu状态判断
	 * 
	 * @author 段衍林
	 * @2016年11月30日 上午10:48:57
	 * @param str
	 * @return SatelliteStatus
	 */
	public SatelliteStatus evalOduStatus(String str) {
		// 判断GOOD？
		if (StringUtils.equalsIgnoreCase(str, SatelliteStatus.GOOD.name())) {
			// good
			return SatelliteStatus.GOOD;
		} else {
			// fault
			return SatelliteStatus.FAULT;
		}
	}
}
