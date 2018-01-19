package cn.com.atnc.ioms.mng.duty.statellite.day.tes.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satellite.day.tes.ITxjdWorkConDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdWorkCon;
import cn.com.atnc.ioms.enums.duty.satellite.SatelliteCheckContent;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.ITxjdWorkConService;
import cn.com.atnc.ioms.model.duty.statellite.day.SatelliteBaseQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TxjdWorkConModel;
import cn.com.atnc.ioms.util.DateUtilTools;

@Transactional
@Service("TxjdWorkConService")
public class TxjdWorkConServiceImpl implements ITxjdWorkConService {
	@Autowired
	private ITxjdWorkConDao workConDao;

	/**
	 * 分页查询
	 */
	@Override
	public Pagination queryPage(SatelliteBaseQueryModel queryModel) {
		return workConDao.queryPage(queryModel);
	}

	/**
	 * 保存
	 */
	@Override
	public TxjdWorkCon save(TxjdWorkConModel txjdWorkConModel, User operator,
			SatelliteCheckContent content) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {

		// 数据保存
		TxjdWorkCon txjdWorkCon = new TxjdWorkCon();
		// 实体赋值
		PropertyUtils.copyProperties(txjdWorkCon, txjdWorkConModel);
		// 巡检内容赋值
		txjdWorkCon.setCheckContent(content);
		// 081丢包率格式处理
		txjdWorkCon.setPacketLoss081(this.dealDouble(txjdWorkConModel
				.getPacketLoss081()));
		// 281丢包率格式处理
		txjdWorkCon.setPacketLoss281(this.dealDouble(txjdWorkConModel
				.getPacketLoss281()));
		// 381丢包率格式处理
		txjdWorkCon.setPacketLoss381(this.dealDouble(txjdWorkConModel
				.getPacketLoss381()));
		// 481丢包率格式处理
		txjdWorkCon.setPacketLoss481(this.dealDouble(txjdWorkConModel
				.getPacketLoss481()));
		// 操作人
		txjdWorkCon.setCreater(operator);
		// 创建日期
		txjdWorkCon.setCreateDate(DateUtilTools.getNowDate());
		// 创建时间
		txjdWorkCon.setCreateTime(DateUtilTools.getNowDateTime());
		// 保存数据
		workConDao.save(txjdWorkCon);
		// 返回实体
		return txjdWorkCon;
	}

	/**
	 * 字符处理
	 * 
	 * @author 段衍林
	 * @2017年2月14日 下午12:52:15
	 * @param value
	 *            参数
	 * @return String 返回值
	 */
	public String dealDouble(String value) {
		// 非空验证
		if (StringUtils.isNotEmpty(value)) {
			// 保留标准Double数字格式
			Double num = Double.parseDouble(value);
			// 转换成String类型
			value = String.valueOf(num);
		}
		return value;
	}

	/**
	 * 实体查询
	 */
	@Override
	public TxjdWorkCon findById(String id) {
		return workConDao.findById(id);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(String id) {
		// 实体查询
		TxjdWorkCon txjdWorkCon = this.findById(id);
		// 删除操作
		workConDao.delete(txjdWorkCon);
	}

	/**
	 * 更新
	 */
	@Override
	public TxjdWorkCon update(TxjdWorkConModel txjdWorkConModel, User operator) {
		TxjdWorkCon txjdWorkCon = this.findById(txjdWorkConModel.getId());
		// 081丢包率
		txjdWorkCon.setPacketLoss081(this.dealDouble(txjdWorkConModel
				.getPacketLoss081()));
		// 281丢包率
		txjdWorkCon.setPacketLoss281(this.dealDouble(txjdWorkConModel
				.getPacketLoss281()));
		// 381丢包率
		txjdWorkCon.setPacketLoss381(this.dealDouble(txjdWorkConModel
				.getPacketLoss381()));
		// 481丢包率
		txjdWorkCon.setPacketLoss481(this.dealDouble(txjdWorkConModel
				.getPacketLoss481()));
		// 更新操作人
		txjdWorkCon.setUpdater(operator);
		// 更新时间
		txjdWorkCon.setUpdateTime(DateUtilTools.getNowDateTime());
		// 数据更新
		workConDao.update(txjdWorkCon);
		// 返回实体
		return txjdWorkCon;
	}
}
