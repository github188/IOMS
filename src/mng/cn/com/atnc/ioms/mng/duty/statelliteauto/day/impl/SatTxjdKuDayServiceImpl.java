package cn.com.atnc.ioms.mng.duty.statelliteauto.day.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satelliteauto.day.SatTxjdKuDayDao;
import cn.com.atnc.ioms.dao.duty.satelliteauto.day.SatTxjdKuDayFlagDao;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdKuDay;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteAlarmType;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatTxjdKuDayService;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatTxjdKuDayModel;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 通信基地-KU卫星专业日检 卫星自检日检业务层接口实现类
 *
 * @author 段衍林
 * @2016年11月11日 下午1:18:38
 */
@Transactional
@Service("satTxjdKuDayService")
public class SatTxjdKuDayServiceImpl implements SatTxjdKuDayService {

	@Autowired
	private SatTxjdKuDayDao txjdKuDayDao;
	@Autowired
	private SatTxjdKuDayFlagDao txjdKuDayFlagDao;

	/**
	 * 保存或更新
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public SatTxjdKuDay saveOrUpdate(SatTxjdKuDayModel satTxjdKuDayModel)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		// 声明实体
		SatTxjdKuDay satTxjdKuDay = txjdKuDayDao.findById(satTxjdKuDayModel.getId());
		//巡检时间
		satTxjdKuDayModel.setCheckTime(satTxjdKuDay.getCheckTime());
		//操作人
		satTxjdKuDayModel.setOperator(satTxjdKuDay.getOperator());
		// 赋值
		PropertyUtils.copyProperties(satTxjdKuDay, satTxjdKuDayModel);
		// 添加更新时间时间
		satTxjdKuDay.setUpdateTime(DateUtilTools.getNowDateTime());
		// 添加更新时间时间
		satTxjdKuDay.setUpdater(satTxjdKuDayModel.getOperator());
		// 数据库保存
		txjdKuDayDao.saveOrUpdate(satTxjdKuDay);
		// 卫星查询
		SatelliteAutoModel queryModel = new SatelliteAutoModel();
		queryModel.setId(satTxjdKuDay.getId());
		return (SatTxjdKuDay) this.queryPageByModel(queryModel).getResult()
				.get(0);
	}

	/**
	 * 通信基地-KU卫星专业日检
	 * 
	 * @author 段衍林
	 * @2016年11月10日 下午2:02:42
	 * @param queryModel
	 * @return Pagination
	 */
	@SuppressWarnings("unchecked")
	public Pagination queryPageByModel(SatelliteAutoModel queryModel) {

		// 分页查询
		Pagination pagn = txjdKuDayDao.queryPageByModel(queryModel);
		// 取值列表
		List<SatTxjdKuDay> kus = (List<SatTxjdKuDay>) pagn.getResult();
		// 非空验证
		if (CollectionUtils.isNotEmpty(kus)) {
			// 遍历
			for (SatTxjdKuDay ku : kus) {

				/**
				 * 解析温度
				 */
				String uctAtemp = this.evalTemperature(ku.getOdutAuct());
				String dctAtemp = this.evalTemperature(ku.getOdutAdct());
				String mctAtemp = this.evalTemperature(ku.getOdutAmct());
				String uctBtemp = this.evalTemperature(ku.getOdutBuct());
				String dctBtemp = this.evalTemperature(ku.getOdutBdct());
				String mctBtemp = this.evalTemperature(ku.getOdutBmct());

				/**
				 * 赋值温度
				 */
				ku.setUctAtemp(uctAtemp);
				ku.setDctAtemp(dctAtemp);
				ku.setMctAtemp(mctAtemp);
				ku.setUctBtemp(uctBtemp);
				ku.setDctBtemp(dctBtemp);
				ku.setMctBtemp(mctBtemp);

				/**
				 * 解析rx
				 */
				String net10Rx0Show = this.evalRx(ku.getNet10Rx0());
				String net10Rx1Show = this.evalRx(ku.getNet10Rx1());
				String net10Rx130Show = this.evalRx(ku.getNet10Rx130());
				String net1ZrxShow = this.evalRx(ku.getNet1Zrx());
				String net1BrxShow = this.evalRx(ku.getNet1Brx());

				/**
				 * 赋值
				 */
				ku.setNet10Rx0Show(net10Rx0Show);
				ku.setNet10Rx1Show(net10Rx1Show);
				ku.setNet10Rx130Show(net10Rx130Show);
				ku.setNet1ZrxShow(net1ZrxShow);
				ku.setNet1BrxShow(net1BrxShow);

				String net20Rx0Show = this.evalRx(ku.getNet20Rx0());
				String net20Rx1Show = this.evalRx(ku.getNet20Rx1());
				String net2ZrxShow = this.evalRx(ku.getNet2Zrx());
				String net2BrxShow = this.evalRx(ku.getNet2Brx());

				/**
				 * 赋值
				 */
				ku.setNet20Rx0Show(net20Rx0Show);
				ku.setNet20Rx1Show(net20Rx1Show);
				ku.setNet2ZrxShow(net2ZrxShow);
				ku.setNet2BrxShow(net2BrxShow);

				String net30Rx0Show = this.evalRx(ku.getNet30Rx0());
				String net30Rx1Show = this.evalRx(ku.getNet30Rx1());
				String net3ZrxShow = this.evalRx(ku.getNet3Zrx());
				String net3BrxShow = this.evalRx(ku.getNet3Brx());

				/**
				 * 赋值
				 */
				ku.setNet30Rx0Show(net30Rx0Show);
				ku.setNet30Rx1Show(net30Rx1Show);
				ku.setNet3ZrxShow(net3ZrxShow);
				ku.setNet3BrxShow(net3BrxShow);

				String net40Rx0Show = this.evalRx(ku.getNet40Rx0());
				String net40Rx1Show = this.evalRx(ku.getNet40Rx1());
				String net4ZrxShow = this.evalRx(ku.getNet4Zrx());
				String net4BrxShow = this.evalRx(ku.getNet4Brx());

				/**
				 * 赋值
				 */
				ku.setNet40Rx0Show(net40Rx0Show);
				ku.setNet40Rx1Show(net40Rx1Show);
				ku.setNet4ZrxShow(net4ZrxShow);
				ku.setNet4BrxShow(net4BrxShow);

				String frZrxShow = this.evalRx(ku.getNetfrZrx());
				String frBrxShow = this.evalRx(ku.getNetfrBrx());

				/**
				 * 赋值
				 */
				ku.setFrZrxShow(frZrxShow);
				ku.setFrBrxShow(frBrxShow);

				/**
				 * 解析eb
				 */
				String net10Eb0Show = this.evalEb(ku.getNet10Eb0());
				String net10Eb1Show = this.evalEb(ku.getNet10Eb1());
				String net10Eb130Show = this.evalEb(ku.getNet10Eb130());
				String net1ZebShow = this.evalEb(ku.getNet1Zeb());
				String net1BebShow = this.evalEb(ku.getNet1Beb());

				/**
				 * 赋值
				 */
				ku.setNet10Eb0Show(net10Eb0Show);
				ku.setNet10Eb1Show(net10Eb1Show);
				ku.setNet10Eb130Show(net10Eb130Show);
				ku.setNet1ZebShow(net1ZebShow);
				ku.setNet1BebShow(net1BebShow);

				String net20Eb0Show = this.evalEb(ku.getNet20Eb0());
				String net20Eb1Show = this.evalEb(ku.getNet20Eb1());
				String net2ZebShow = this.evalEb(ku.getNet2Zeb());
				String net2BebShow = this.evalEb(ku.getNet2Beb());

				/**
				 * 赋值
				 */
				ku.setNet20Eb0Show(net20Eb0Show);
				ku.setNet20Eb1Show(net20Eb1Show);
				ku.setNet2ZebShow(net2ZebShow);
				ku.setNet2BebShow(net2BebShow);

				String net30Eb0Show = this.evalEb(ku.getNet30Eb0());
				String net30Eb1Show = this.evalEb(ku.getNet30Eb1());
				String net3ZebShow = this.evalEb(ku.getNet3Zeb());
				String net3BebShow = this.evalEb(ku.getNet3Beb());

				/**
				 * 赋值
				 */
				ku.setNet30Eb0Show(net30Eb0Show);
				ku.setNet30Eb1Show(net30Eb1Show);
				ku.setNet3ZebShow(net3ZebShow);
				ku.setNet3BebShow(net3BebShow);

				String net40Eb0Show = this.evalEb(ku.getNet40Eb0());
				String net40Eb1Show = this.evalEb(ku.getNet40Eb1());
				String net4ZebShow = this.evalEb(ku.getNet4Zeb());
				String net4BebShow = this.evalEb(ku.getNet4Beb());

				/**
				 * 赋值
				 */
				ku.setNet40Eb0Show(net40Eb0Show);
				ku.setNet40Eb1Show(net40Eb1Show);
				ku.setNet4ZebShow(net4ZebShow);
				ku.setNet4BebShow(net4BebShow);

				String frZebShow = this.evalEb(ku.getNetfrZeb());
				String frBebShow = this.evalEb(ku.getNetfrBeb());
				/**
				 * 赋值
				 */
				ku.setFrZebShow(frZebShow);
				ku.setFrBebShow(frBebShow);

				/**
				 * 解析noise和peak
				 */
				// 封装峰值和底噪
				String[] peakNoise1 = { ku.getNet10Peak(), ku.getNet10Noise() };
				String[] net10PeakNoise = this.evalNoiseOrPeak(peakNoise1);
				String net10PeakShow = net10PeakNoise[0];
				String net10NoiseShow = net10PeakNoise[1];

				/**
				 * 赋值
				 */
				ku.setNet10PeakShow(net10PeakShow);
				ku.setNet10NoiseShow(net10NoiseShow);
				// 封装峰值和底噪
				String[] peakNoise2 = { ku.getNet20Peak(), ku.getNet20Noise() };
				String[] net20PeakNoise = this.evalNoiseOrPeak(peakNoise2);
				String net20PeakShow = net20PeakNoise[0];
				String net20NoiseShow = net20PeakNoise[1];

				/**
				 * 赋值
				 */
				ku.setNet20PeakShow(net20PeakShow);
				ku.setNet20NoiseShow(net20NoiseShow);

				// 封装峰值和底噪
				String[] peakNoise3 = { ku.getNet30Peak(), ku.getNet30Noise() };
				String[] net30PeakNoise = this.evalNoiseOrPeak(peakNoise3);
				String net30PeakShow = net30PeakNoise[0];
				String net30NoiseShow = net30PeakNoise[1];

				/**
				 * 赋值
				 */
				ku.setNet30PeakShow(net30PeakShow);
				ku.setNet30NoiseShow(net30NoiseShow);

				// 封装峰值和底噪
				String[] peakNoise4 = { ku.getNet40Peak(), ku.getNet40Noise() };
				String[] net40PeakNoise = this.evalNoiseOrPeak(peakNoise4);
				String net40PeakShow = net40PeakNoise[0];
				String net40NoiseShow = net40PeakNoise[1];

				/**
				 * 赋值
				 */
				ku.setNet40PeakShow(net40PeakShow);
				ku.setNet40NoiseShow(net40NoiseShow);

				// 封装峰值和底噪
				String[] peakNoiseFr = { ku.getNetfrPeak(), ku.getNetfrNoise() };
				String[] netFrPeakNoise = this.evalNoiseOrPeak(peakNoiseFr);
				String frPeakShow = netFrPeakNoise[0];
				String frNoiseShow = netFrPeakNoise[1];

				/**
				 * 赋值
				 */
				ku.setFrPeakShow(frPeakShow);
				ku.setFrNoiseShow(frNoiseShow);
			}
		}
		return pagn;
	}

	/**
	 * 校验温度，温度格式化
	 * 
	 * @author 段衍林
	 * @2016年11月14日 下午4:09:36
	 * @param temp
	 *            温度
	 * @return 解析后的温度 String
	 */
	public String evalTemperature(String temp) {
		// 初始化结果为原始温度
		String result = temp;
		// 校验温度标准
		double tempLevel = Double.parseDouble(SatelliteAlarmType.KuOduTempLower
				.getValue());
		if (StringUtils.isNotEmpty(temp)) {
			// 原始温度格式转换--double
			double tempData = Double.parseDouble(temp);
			// 原始温度 > 校验标准 ， 重新封装
			if (tempLevel <= tempData) {
				// 前端显示红色结果
				result = "<font color='red'>" + temp + "</font>";
			}
		}
		return result;
	}

	/**
	 * 解析rx值
	 * 
	 * @author 段衍林
	 * @2016年11月14日 下午5:35:53
	 * @param rx
	 *            原始值
	 * @return 字符串 String
	 */
	public String evalRx(String rx) {
		// 原始值
		String result = rx;
		// 校验Rx标准--最大值
		double rxLevelTop = Double.parseDouble(SatelliteAlarmType.KuRxLevelTop
				.getValue());
		// 校验Rx标准--最小值
		double rxLevelLower = Double
				.parseDouble(SatelliteAlarmType.KuRxLevelLower.getValue());
		// 非空验证
		if (StringUtils.isNotEmpty(rx)) {
			// 原始rx数据格式转换--double
			double rxData = Double.parseDouble(rx);
			// 正常值：rxLevelLower =< rx <= rxLevelLower
			if (rxData < rxLevelLower || rxData > rxLevelTop) {
				// 前端显示红色结果
				result = "<font color='red'>" + rx + "</font>";
			}
		}
		return result;
	}

	/**
	 * 解析eb值
	 * 
	 * @author 段衍林
	 * @2016年11月14日 下午5:35:53
	 * @param eb
	 *            原始值
	 * @return 字符串 String
	 */
	public String evalEb(String eb) {
		// 原始值
		String result = eb;
		// 校验eb标准
		double ebLevel = Double.parseDouble(SatelliteAlarmType.KuEbNoLower
				.getValue());
		// 非空验证
		if (StringUtils.isNotEmpty(eb)) {
			// 原始eb数据格式转换--double
			double ebData = Double.parseDouble(eb);
			// 正常值：eb > ebLevel
			if (ebData <= ebLevel) {
				// 前端显示红色结果
				result = "<font color='red'>" + eb + "</font>";
			}
		}
		return result;
	}

	/**
	 * 解析峰值和底噪 差值大于10的为正常
	 * 
	 * @author 段衍林
	 * @2016年11月14日 下午5:35:53
	 * @param data
	 *            原始值
	 * @return 字符串 String
	 */
	public String[] evalNoiseOrPeak(String[] datas) {
		// 原始值
		String[] result = datas;
		// 校验eb标准
		double noisePeakLevel = Double
				.parseDouble(SatelliteAlarmType.KuNoisePeakLower.getValue());
		// 非空验证
		if (StringUtils.isNotEmpty(datas[0])
				&& StringUtils.isNotEmpty(datas[1])) {
			// 原始data数据格式转换--double 底噪
			double noiseData = Double.parseDouble(datas[0]);
			// 峰值
			double peakData = Double.parseDouble(datas[1]);
			// 差值
			double noise_peak = noiseData - peakData;
			noise_peak = Math.abs(noise_peak);
			// 正常值：eb > ebLevel
			if (noise_peak <= noisePeakLevel) {
				// 前端显示红色结果
				result[0] = "<font color='red'>" + datas[0] + "</font>";
				result[1] = "<font color='red'>" + datas[1] + "</font>";
			}
		}
		return result;
	}

	/**
	 * 冒泡查询
	 */
	public int getAjaxLoad() {
		// 获取全部列表
		List<SatTxjdKuDay> kus = txjdKuDayDao.getAll();
		// 返回列表size
		return CollectionUtils.isNotEmpty(kus) ? kus.size() : 0;

	}
}
