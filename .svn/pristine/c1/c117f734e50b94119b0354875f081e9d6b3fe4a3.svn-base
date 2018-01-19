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
import cn.com.atnc.ioms.dao.duty.satelliteauto.day.SatTxjdOverseaMainDao;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdOverseaMain;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteAlarmType;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteDayAutoType;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatTxjdOverseaMainService;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatTxjdOverseaMainModel;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 通信基地-境外站-境外站主站载波 业务层接口实现类
 *
 * @author 段衍林
 * @2016年11月11日 下午4:05:23
 */
@Transactional
@Service("satTxjdOverseaMainService")
public class SatTxjdOverseaMainServiceImpl implements SatTxjdOverseaMainService {

	@Autowired
	private SatTxjdOverseaMainDao satTxjdOverseaMainDao;

	/**
	 * 通信基地-境外站-境外站主站载波 卫星日检自检分页查询 实现类
	 * 
	 * @author 段衍林
	 * @2016年11月11日 下午4:05:23
	 * @param queryModel
	 * @return Pagination
	 */
	@SuppressWarnings("unchecked")
	public Pagination queryPageByModel(SatelliteAutoModel queryModel) {
		// 分页查询
		Pagination pagn = satTxjdOverseaMainDao.queryPageByModel(queryModel);
		// 取列表
		List<SatTxjdOverseaMain> mains = (List<SatTxjdOverseaMain>) pagn
				.getResult();
		// 非空验证
		if (CollectionUtils.isNotEmpty(mains)) {
			// 遍历
			for (SatTxjdOverseaMain main : mains) {
				// 封装原始值
				String[] datas = { main.getCarrierNoise(),
						main.getCarrierPeak() };
				// 数据解析
				String[] result = this.evalData(datas);
				// 赋值 result[0] -- noise ; result[1] -- peak
				main.setCarrierNoiseShow(result[0]);
				main.setCarrierPeakShow(result[1]);
			}
		}
		// 返回分页数据
		return pagn;
	}

	/**
	 * 数据解析
	 * 
	 * @author 段衍林
	 * @2016年11月15日 上午11:05:16
	 * @param datas
	 *            原始值
	 * @return 返回值 String[]
	 */
	public String[] evalData(String[] datas) {
		// 定义返回值--初始化
		String[] result = datas;
		// 非空验证
		if (StringUtils.isNotEmpty(datas[0])
				&& StringUtils.isNotEmpty(datas[1])) {
			// 海外主站检验标准
			double level = Double
					.parseDouble(SatelliteAlarmType.OverSeaMainLower.getValue());
			// 底噪与峰值的差值
			double data = Double.parseDouble(datas[0])
					- Double.parseDouble(datas[1]);
			// 取绝对值
			data = Math.abs(data);
			// 验证，差值大于10为正常
			if (data <= level) {
				// 前端显示红色结果
				// noise
				result[0] = "<font color='red'>" + datas[0] + "</font>";
				// peak
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
		List<SatTxjdOverseaMain> mains = satTxjdOverseaMainDao.getAll();
		// 返回列表size
		return CollectionUtils.isNotEmpty(mains) ? mains.size() : 0;

	}

	/**
	 * 保存或更新
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public SatTxjdOverseaMain saveOrUpdate(SatTxjdOverseaMainModel main)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		SatTxjdOverseaMain satTxjdOverseaMain = satTxjdOverseaMainDao
				.findById(main.getId());
		if (!ObjectUtils.equals(satTxjdOverseaMain, null)) {
			// 记录时间
			main.setCheckTime(satTxjdOverseaMain.getCheckTime());
			// 记录人
			main.setOperator(satTxjdOverseaMain.getOperator());
			// 设备名称
			main.setEquipName(satTxjdOverseaMain.getEquipName());
		} else {
			satTxjdOverseaMain = new SatTxjdOverseaMain();
			// 记录时间
			main.setCheckTime(DateUtilTools.getNowDateTime());
			// 设备名称
			main.setEquipName(SatelliteDayAutoType.txjdOverseaMain);
		}
		// 实体赋值
		PropertyUtils.copyProperties(satTxjdOverseaMain, main);
		// 更新时间
		satTxjdOverseaMain.setUpdateTime(DateUtilTools.getNowDateTime());
		// 保存或更新
		satTxjdOverseaMainDao.saveOrUpdate(satTxjdOverseaMain);
		// 查询数据
		SatelliteAutoModel queryModel = new SatelliteAutoModel();
		queryModel.setId(satTxjdOverseaMain.getId());
		return (SatTxjdOverseaMain) this.queryPageByModel(queryModel)
				.getResult().get(0);
	}

	/**
	 * 删除
	 */
	public void delete(SatTxjdOverseaMainModel main) {
		try {
			// 实体查询
			SatTxjdOverseaMain satTxjdOverseaMain = satTxjdOverseaMainDao
					.findById(main.getId());
			// 非空验证
			if (!ObjectUtils.equals(satTxjdOverseaMain, null)) {
				// 删除
				satTxjdOverseaMainDao.delete(satTxjdOverseaMain);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
