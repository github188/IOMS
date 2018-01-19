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
import cn.com.atnc.ioms.dao.duty.satelliteauto.day.SatTxjdTesODUDao;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdTesODU;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteAlarmType;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteDayAutoType;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatTxjdTesODUService;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatTxjdTesOduModel;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 通信基地-TES-TES ODU状态 卫星自检日检业务层接口
 *
 * @author 段衍林
 * @2016年11月11日 上午10:05:08
 */
@Transactional
@Service("satTxjdTesODUService")
public class SatTxjdTesODUServiceImpl implements SatTxjdTesODUService {

	@Autowired
	private SatTxjdTesODUDao txjdTesODUDao;

	/**
	 * 通信基地-TES-TES odu状态 卫星日检自检分页查询 实现类
	 * 
	 * @author 段衍林
	 * @2016年11月11日 上午10:05:08
	 * @param queryModel
	 * @return Pagination
	 */
	@SuppressWarnings("unchecked")
	public Pagination queryPageByModel(SatelliteAutoModel queryModel) {
		// 分页查询
		Pagination pagn = txjdTesODUDao.queryPageByModel(queryModel);
		// 去除列表值
		List<SatTxjdTesODU> odus = (List<SatTxjdTesODU>) pagn.getResult();
		// 非空验证
		if (CollectionUtils.isNotEmpty(odus)) {
			// 列表遍历
			for (SatTxjdTesODU odu : odus) {
				// 取值txFreqA
				String txFreqA = this.evalData(
						SatelliteAlarmType.TXFreqATop.getValue(),
						odu.getTxfreqAresult());
				// 赋值
				odu.setTxfreqA(txFreqA);
				// 取值txFreqB
				String txFreqB = this.evalData(
						SatelliteAlarmType.TXFreqBTop.getValue(),
						odu.getTxfreqBresult());
				// 赋值
				odu.setTxfreqB(txFreqB);
				// 取值rxFreqA
				String rxFreqA = this.evalData(
						SatelliteAlarmType.RXFreqATop.getValue(),
						odu.getRxfreqAresult());
				// 赋值
				odu.setRxfreqA(rxFreqA);
				// 取值rxFreqB
				String rxFreqB = this.evalData(
						SatelliteAlarmType.RXFreqBTop.getValue(),
						odu.getRxfreqBresult());
				// 赋值
				odu.setRxfreqB(rxFreqB);
			}
		}
		return pagn;
	}

	/**
	 * 数据解析
	 * 
	 * @author 段衍林
	 * @2016年11月15日 上午9:17:12
	 * @param level
	 * @param data
	 * @return String
	 */
	public String evalData(String level, String data) {
		// 初始化结果变量
		String result = data;
		// 非空验证
		if (StringUtils.isNotEmpty(data)) {
			// double类型转换
			double evalData = Double.parseDouble(data);
			// double类型转换
			double evalLevel = Double.parseDouble(level);
			// 不相等时，标红
			if (evalLevel != evalData) {
				// 前段页面标红
				result = "<font color='red'>" + data + "</font>";
			}
		}
		// 返回
		return result;
	}

	/**
	 * 冒泡查询
	 */
	@SuppressWarnings("unchecked")
	public int getAjaxLoad() {
		SatelliteAutoModel queryModel = new SatelliteAutoModel();
		queryModel.setEquipName(SatelliteDayAutoType.txjdTesODU);
		// 获取全部列表
		List<SatTxjdTesODU> odus = (List<SatTxjdTesODU>) txjdTesODUDao
				.queryPageByModel(queryModel).getResult();
		// 返回列表size
		return CollectionUtils.isNotEmpty(odus) ? odus.size() : 0;
	}

	/**
	 * 保存或更新
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public SatTxjdTesODU saveOrUpdate(SatTxjdTesOduModel odu)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		SatTxjdTesODU satTxjdTesODU = txjdTesODUDao.findById(odu.getId());
		if (!ObjectUtils.equals(satTxjdTesODU, null)) {
			// 记录时间
			odu.setCheckTime(satTxjdTesODU.getCheckTime());
			// 记录人
			odu.setOperator(satTxjdTesODU.getOperator());
			// 设备名称
			odu.setEquipName(satTxjdTesODU.getEquipName());

		} else {
			satTxjdTesODU = new SatTxjdTesODU();
			// 记录时间
			odu.setCheckTime(DateUtilTools.getNowDateTime());
			odu.setEquipName(SatelliteDayAutoType.txjdTesODU);
		}
		// 实体赋值
		PropertyUtils.copyProperties(satTxjdTesODU, odu);
		// 更新时间
		satTxjdTesODU.setUpdateTime(DateUtilTools.getNowDateTime());
		// 保存或更新
		txjdTesODUDao.saveOrUpdate(satTxjdTesODU);
		// 查询
		SatelliteAutoModel queryModel = new SatelliteAutoModel();
		queryModel.setId(satTxjdTesODU.getId());
		return (SatTxjdTesODU) this.queryPageByModel(queryModel).getResult()
				.get(0);
	}

	/**
	 * 删除
	 */
	public void delete(SatTxjdTesOduModel SatTxjdTesOduModel) {
		try {
			// 实体查询
			SatTxjdTesODU odu = txjdTesODUDao.findById(SatTxjdTesOduModel
					.getId());
			// 非空验证
			if (!ObjectUtils.equals(odu, null)) {
				// 删除
				txjdTesODUDao.delete(odu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
