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
import cn.com.atnc.ioms.dao.duty.satelliteauto.day.SatDsOduDao;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatDsOdu;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteAlarmType;
import cn.com.atnc.ioms.mng.duty.statelliteauto.day.SatDsOduService;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;
import cn.com.atnc.ioms.model.duty.statellite.day.OduStateModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 东四-PES-TES民航局ODU状态 卫星自检日检业务层接口
 *
 * @author 段衍林
 * @2016年11月15日 下午1:51:37
 */
@Transactional
@Service("satDsOduService")
public class SatDsOduServiceImpl implements SatDsOduService {

	@Autowired
	private SatDsOduDao satDsOduDao;

	/**
	 * 东四-PES-TES民航局ODU状态 卫星日检自检分页查询 实现类
	 */
	@SuppressWarnings("unchecked")
	public Pagination queryPageByModel(SatelliteAutoModel queryModel) {
		// 分页查询
		Pagination pagn = satDsOduDao.queryPageByModel(queryModel);
		// 取列表
		List<SatDsOdu> odus = (List<SatDsOdu>) pagn.getResult();
		// 非空验证
		if (CollectionUtils.isNotEmpty(odus)) {
			// 遍历
			for (SatDsOdu odu : odus) {
				// Receive数据解析
				String receiveResultShow = this.evalData(
						odu.getReceiveResult(),
						SatelliteAlarmType.DsRecieve.getValue());
				// Transmit数据解析
				String transmitResultShow = this.evalData(
						odu.getTransmitResult(),
						SatelliteAlarmType.DsTransmit.getValue());
				// 赋值recieveShow
				odu.setReceiveResultShow(receiveResultShow);
				// 赋值transmitShow
				odu.setTransmitResultShow(transmitResultShow);
			}
		}
		// 返回分页数据
		return pagn;
	}

	@SuppressWarnings("unchecked")
	public SatDsOdu findByIdPagn(String id) {
		// f赋值
		SatelliteAutoModel queryModel = new SatelliteAutoModel();
		queryModel.setId(id);
		// 分页查询
		Pagination pagn = this.queryPageByModel(queryModel);
		// 取列表
		List<SatDsOdu> odus = (List<SatDsOdu>) pagn.getResult();
		// 非空验证
		if (CollectionUtils.isNotEmpty(odus)) {
			return odus.get(0);
		} else {
			return null;
		}
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
	public String evalData(String data, String level) {
		// 定义返回值--初始化
		String result = data;
		// 非空验证
		if (StringUtils.isNotEmpty(data)) {
			// 海外主站检验标准
			double levelData = Double.parseDouble(level);
			// 底噪与峰值的差值
			double resultData = Double.parseDouble(data);
			// 验证，相等为正常为正常
			if (resultData != levelData) {
				// 前端显示红色结果
				result = "<font color='red'>" + data + "</font>";
			}
		}
		return result;
	}

	/**
	 * 冒泡查询
	 */
	@SuppressWarnings("unchecked")
	public int getAjaxLoad(SatelliteAutoModel queryModel) {
		// 分页查询
		Pagination pagn = satDsOduDao.queryPageByModel(queryModel);
		// 获取全部列表
		List<SatDsOdu> odus = (List<SatDsOdu>) pagn.getResult();
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
	public SatDsOdu saveOrUpdate(OduStateModel oduStateModel)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {

		SatDsOdu satDsOdu = satDsOduDao.findById(oduStateModel.getId());
		if (!ObjectUtils.equals(satDsOdu, null)) {
			// 记录时间
			oduStateModel.setCheckTime(satDsOdu.getCheckTime());
			// 记录人
			oduStateModel.setOperator(satDsOdu.getOperator());
			// 设备名称
			oduStateModel.setEquipName(satDsOdu.getEquipName());
		} else {
			satDsOdu = new SatDsOdu();
			// 记录时间
			oduStateModel.setCheckTime(DateUtilTools.getNowDateTime());
		}
		// 赋值
		PropertyUtils.copyProperties(satDsOdu, oduStateModel);
		// 更新时间
		satDsOdu.setUpdateTime(DateUtilTools.getNowDateTime());
		// 数据库保存
		satDsOduDao.saveOrUpdate(satDsOdu);
		// 查询
		SatelliteAutoModel queryModel = new SatelliteAutoModel();
		queryModel.setId(satDsOdu.getId());
		return (SatDsOdu) this.queryPageByModel(queryModel).getResult().get(0);
	}

	@Override
	public SatDsOdu findById(String id) {
		// 根据id查询
		return satDsOduDao.findById(id);
	}

	/**
	 * 删除
	 */
	public void delete(OduStateModel oduStateModel) {
		// 非空验证
		if (StringUtils.isNotEmpty(oduStateModel.getId())) {
			// 取实体
			SatDsOdu satDsOdu = satDsOduDao.findById(oduStateModel.getId());
			// 删除实体
			satDsOduDao.delete(satDsOdu);
		}
	}
}
