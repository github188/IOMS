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
import cn.com.atnc.ioms.dao.duty.satelliteauto.day.SatSlhPesDao;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatSlhPes;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteAlarmType;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteDayAutoType;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatSlhPesService;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;
import cn.com.atnc.ioms.model.duty.satelliteauto.SlhPesModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 十里河-PES-PES出境载波状态 卫星自检日检业务层接口
 *
 * @author 段衍林
 * @2016年11月14日 上午11:24:43
 */
@Transactional
@Service("satSlhPesService")
public class SatSlhPesServiceImpl implements SatSlhPesService {

	@Autowired
	private SatSlhPesDao satSlhPesDao;

	/**
	 * 通信基地-TES-TES OCC状态 卫星日检自检分页查询 实现类
	 */
	@SuppressWarnings("unchecked")
	public Pagination queryPageByModel(SatelliteAutoModel queryModel) {
		// 分页查询
		Pagination pagn = satSlhPesDao.queryPageByModel(queryModel);
		// 取列表
		List<SatSlhPes> pess = (List<SatSlhPes>) pagn.getResult();
		// 非空验证
		if (CollectionUtils.isNotEmpty(pess)) {
			// 遍历
			for (SatSlhPes pes : pess) {
				// 封装原始值
				String[] datas = { pes.getCarrierNoise(), pes.getCarrierPeak() };
				// 数据解析
				String[] result = this.evalData(datas);
				// 赋值 result[0] -- noise ; result[1] -- peak
				pes.setCarrierNoiseShow(result[0]);
				pes.setCarrierPeakShow(result[1]);
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
			double level = Double.parseDouble(SatelliteAlarmType.SlhPesLower
					.getValue());
			// 底噪与峰值的差值
			double data = Double.parseDouble(datas[0])
					- Double.parseDouble(datas[1]);
			// 取绝对值
			data = Math.abs(data);
			// 验证，差值大于15为正常
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
		List<SatSlhPes> slhPes = satSlhPesDao.getAll();
		// 返回列表size
		return CollectionUtils.isNotEmpty(slhPes) ? slhPes.size() : 0;
	}

	/**
	 * 保存或更新
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public SatSlhPes saveOrUpdate(SlhPesModel slhPes)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		SatSlhPes satSlhPes = satSlhPesDao.findById(slhPes.getId());;
		if (!ObjectUtils.equals(satSlhPes, null)) {
			/**
			 * 原纪录的巡检时间和操作人，设备名称--赋值在model中
			 */
			// 记录时间
			slhPes.setCheckTime(satSlhPes.getCheckTime());
			// 记录人
			slhPes.setOperator(satSlhPes.getOperator());
			// 设备名称
			slhPes.setEquipName(satSlhPes.getEquipName());
		} else {
			satSlhPes = new SatSlhPes();
			// 记录时间
			slhPes.setCheckTime(DateUtilTools.getNowDateTime());
			// 设备名称
			slhPes.setEquipName(SatelliteDayAutoType.slhPES);
		}
		// 实体赋值
		PropertyUtils.copyProperties(satSlhPes, slhPes);
		// 更新时间
		satSlhPes.setUpdateTime(DateUtilTools.getNowDateTime());
		// 保存或更新
		satSlhPesDao.saveOrUpdate(satSlhPes);
		// 查询
		SatelliteAutoModel queryModel = new SatelliteAutoModel();
		queryModel.setId(satSlhPes.getId());
		return (SatSlhPes) this.queryPageByModel(queryModel).getResult().get(0);
	}

	/**
	 * 删除
	 */
	public void delete(SlhPesModel slhPes) {
		try {
			// 实体查询
			SatSlhPes satSlhPes = satSlhPesDao.findById(slhPes.getId());
			// 非空验证
			if (!ObjectUtils.equals(satSlhPes, null)) {
				// 删除
				satSlhPesDao.delete(satSlhPes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
