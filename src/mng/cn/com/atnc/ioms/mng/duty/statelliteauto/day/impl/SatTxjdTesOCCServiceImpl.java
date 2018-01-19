package cn.com.atnc.ioms.mng.duty.statelliteauto.day.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satelliteauto.day.SatTxjdTesOCCDao;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdTesOCC;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteAlarmType;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteDayAutoType;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatTxjdTesOCCService;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatTxjdTesOccModel;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 通信基地-TES-TES OCC状态 卫星自检日检业务层接口
 *
 * @author 段衍林
 * @2016年11月10日 下午2:03:27
 */
@Transactional
@Service("satTxjdTesOCCService")
public class SatTxjdTesOCCServiceImpl implements SatTxjdTesOCCService {

	@Autowired
	private SatTxjdTesOCCDao txjdTesOCCDao;

	/**
	 * 通信基地-TES-TES OCC状态 卫星日检自检分页查询 实现类
	 * 
	 * @author 段衍林
	 * @2016年11月10日 下午2:02:42
	 * @param queryModel
	 * @return Pagination
	 */
	@SuppressWarnings("unchecked")
	public Pagination queryPageByModel(SatelliteAutoModel queryModel) {
		// 分页查询
		Pagination pagn = txjdTesOCCDao.queryPageByModel(queryModel);
		// 去除列表值
		List<SatTxjdTesOCC> occs = (List<SatTxjdTesOCC>) pagn.getResult();
		// 空值验证
		if (CollectionUtils.isNotEmpty(occs)) {
			// 循环封装页面显示值
			for (SatTxjdTesOCC occ : occs) {
				// 峰值底噪一
				String[] noisePeak1 = this.evalData(occ.getOcc1Noise(),
						occ.getOcc1Peak());
				// 页面底噪1
				occ.setNoise1(noisePeak1[0]);
				// 封装显示字段
				occ.setPeak1(noisePeak1[1]);

				// 峰值底噪二
				String[] noisePeak2 = this.evalData(occ.getOcc2Noise(),
						occ.getOcc2Peak());
				// 页面底噪1
				occ.setNoise2(noisePeak2[0]);
				// 封装显示字段
				occ.setPeak2(noisePeak2[1]);

				// 峰值底噪三
				String[] noisePeak3 = this.evalData(occ.getOcc3Noise(),
						occ.getOcc3Peak());
				// 页面底噪1
				occ.setNoise3(noisePeak3[0]);
				// 封装显示字段
				occ.setPeak3(noisePeak3[1]);

				// 峰值底噪三
				String[] noisePeak4 = this.evalData(occ.getOcc4Noise(),
						occ.getOcc4Peak());
				// 页面底噪1
				occ.setNoise4(noisePeak4[0]);
				// 封装显示字段
				occ.setPeak4(noisePeak4[1]);
			}
		}
		return pagn;
	}

	/**
	 * 底噪和峰值解析
	 * 
	 * @author 段衍林
	 * @2016年11月14日 下午4:09:36
	 * @param temp
	 *            原始数据
	 * @return 解析后的数据 String
	 */
	public String[] evalData(String noise, String peak) {
		// 初始化结果为原始温度
		String[] result = { noise, peak };
		// 校验标准
		double level = Double.parseDouble(SatelliteAlarmType.TesOccTop
				.getValue());
		// 非空验证
		if (StringUtils.isNotEmpty(noise) && StringUtils.isNotEmpty(peak)) {
			// 原始data数据格式转换--double 底噪
			double noiseData = Double.parseDouble(noise);
			// 峰值
			double peakData = Double.parseDouble(peak);
			// 差值
			double noise_peak = noiseData - peakData;
			noise_peak = Math.abs(noise_peak);
			// 正常值：eb > ebLevel
			if (noise_peak <= level) {
				// 前端显示红色结果
				result[0] = "<font color='red'>" + noise + "</font>";
				result[1] = "<font color='red'>" + peak + "</font>";
			}
		}
		return result;
	}

	/**
	 * 冒泡查询
	 */
	public int getAjaxLoad() {
		// 获取全部列表
		List<SatTxjdTesOCC> occs = txjdTesOCCDao.getAll();
		// 返回列表size
		return CollectionUtils.isNotEmpty(occs) ? occs.size() : 0;

	}

	/**
	 * 保存或更新
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public SatTxjdTesOCC saveOrUpdate(SatTxjdTesOccModel occ)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		SatTxjdTesOCC satTxjdTesOcc = txjdTesOCCDao.findById(occ.getId());
		;
		if (!ObjectUtils.equals(satTxjdTesOcc, null)) {
			// 记录时间
			occ.setCheckTime(satTxjdTesOcc.getCheckTime());
			// 记录人
			occ.setOperator(satTxjdTesOcc.getOperator());
			// 设备名称
			occ.setEquipName(satTxjdTesOcc.getEquipName());

		} else {
			satTxjdTesOcc = new SatTxjdTesOCC();
			// 记录时间
			occ.setCheckTime(DateUtilTools.getNowDateTime());
			// 设备名称
			occ.setEquipName(SatelliteDayAutoType.txjdTesOCC);
		}
		// 实体赋值
		PropertyUtils.copyProperties(satTxjdTesOcc, occ);
		// 更新时间
		satTxjdTesOcc.setUpdateTime(DateUtilTools.getNowDateTime());
		/**
		 * 底噪
		 */
		satTxjdTesOcc.setOcc1Noise(evalNumber(occ.getOcc1Noise()));
		satTxjdTesOcc.setOcc2Noise(evalNumber(occ.getOcc2Noise()));
		satTxjdTesOcc.setOcc3Noise(evalNumber(occ.getOcc3Noise()));
		satTxjdTesOcc.setOcc4Noise(evalNumber(occ.getOcc4Noise()));
		/**
		 * 峰值
		 */
		satTxjdTesOcc.setOcc1Peak(evalNumber(occ.getOcc1Peak()));
		satTxjdTesOcc.setOcc2Peak(evalNumber(occ.getOcc2Peak()));
		satTxjdTesOcc.setOcc3Peak(evalNumber(occ.getOcc3Peak()));
		satTxjdTesOcc.setOcc4Peak(evalNumber(occ.getOcc4Peak()));

		// 保存或更新
		txjdTesOCCDao.saveOrUpdate(satTxjdTesOcc);
		// 查询
		SatelliteAutoModel queryModel = new SatelliteAutoModel();
		queryModel.setId(satTxjdTesOcc.getId());
		return (SatTxjdTesOCC) queryPageByModel(queryModel).getResult().get(0);
	}

	/**
	 * 解析数字等(去0)
	 * 
	 * @author 段衍林
	 * @2016年12月1日 下午5:58:00
	 * @param str
	 * @return String
	 */
	public String evalNumber(String str) {
		// 非空验证
		if (StringUtils.isNotEmpty(str)) {
			// 类型转换
			double number = Double.parseDouble(str);
			// 重新赋值
			str = String.valueOf(number);
		}
		// 返回值
		return str;
	}

	/**
	 * 删除
	 */
	public void delete(SatTxjdTesOccModel satTxjdTesOccModel) {
		try {
			// 实体查询
			SatTxjdTesOCC occ = txjdTesOCCDao.findById(satTxjdTesOccModel
					.getId());
			// 非空验证
			if (!ObjectUtils.equals(occ, null)) {
				// 删除
				txjdTesOCCDao.delete(occ);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
