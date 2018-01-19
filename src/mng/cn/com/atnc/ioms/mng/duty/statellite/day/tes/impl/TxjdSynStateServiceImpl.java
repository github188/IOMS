package cn.com.atnc.ioms.mng.duty.statellite.day.tes.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satellite.day.tes.ITxjdSynResultDao;
import cn.com.atnc.ioms.dao.duty.satellite.day.tes.ITxjdSynStateDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdSynResult;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdSynState;
import cn.com.atnc.ioms.enums.duty.satellite.SatelliteCheckContent;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.ITxjdSynStateService;
import cn.com.atnc.ioms.model.duty.statellite.day.SatelliteBaseQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TxjdSynResultQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TxjdSynStateModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 通信基地-TES-查看网管同步状态service接口实现类
 *
 * @author 段衍林
 * @2017年2月16日 上午10:03:51
 */
@Transactional
@Service("TxjdSynStateService")
public class TxjdSynStateServiceImpl implements ITxjdSynStateService {

	@Autowired
	private ITxjdSynStateDao txjdSynStateDao;
	@Autowired
	private ITxjdSynResultDao txjdSynResultDao;

	@SuppressWarnings("unchecked")
	@Override
	public Pagination queryPage(SatelliteBaseQueryModel queryModel) {
		// 分页查询
		Pagination pagn = txjdSynStateDao.queryPage(queryModel);
		// 取出列表数据
		List<TxjdSynState> txjdSynStates = (List<TxjdSynState>) pagn
				.getResult();
		// 非空验证
		if (CollectionUtils.isNotEmpty(txjdSynStates)) {
			// 遍历数据
			for (TxjdSynState txjdSynState : txjdSynStates) {
				// 新建查询条件
				TxjdSynResultQueryModel qm = new TxjdSynResultQueryModel();
				// 封装父级id
				qm.setId(txjdSynState.getId());
				// 列表查询
				List<TxjdSynResult> txjdSynResults = txjdSynResultDao
						.queryList(qm);
				// 封装数据
				txjdSynState.setTxjdSynResults(txjdSynResults);
			}
		}
		// 返回值
		return pagn;
	}

	@Override
	public TxjdSynState save(TxjdSynStateModel txjdSynResultModel,
			User operator, SatelliteCheckContent content) {
		// 新建主数据
		TxjdSynState txjdSynState = new TxjdSynState();
		// 巡检内容
		txjdSynState.setCheckContent(content);
		// 巡检日期
		txjdSynState.setCreateDate(DateUtilTools.getNowDate());
		// 巡检时间
		txjdSynState.setCreateTime(DateUtilTools.getNowDateTime());
		// 巡检人
		txjdSynState.setCreater(operator);
		// 非空验证
		if (CollectionUtils.isNotEmpty(txjdSynResultModel.getSerial())) {
			// 添加子级数据
			for (int i = 0; i < txjdSynResultModel.getSerial().size(); i++) {
				// 新的子数据
				TxjdSynResult txjdSynResult = new TxjdSynResult();
				// 封装父级实体
				txjdSynResult.setTxjdSynState(txjdSynState);
				// 封装巡检内容
				txjdSynResult.setEquipName(txjdSynResultModel.getEquipName()
						.get(i));
				// CU
				txjdSynResult.setCu(txjdSynResultModel.getCu().get(i));
				// CKT
				txjdSynResult.setCkt(txjdSynResultModel.getCkt().get(i));
				// DD
				txjdSynResult.setDd(txjdSynResultModel.getDd().get(i));
				// HG
				txjdSynResult.setHg(txjdSynResultModel.getHg().get(i));
				// HG
				txjdSynResult.setRoute(txjdSynResultModel.getRoute().get(i));
				// 添加数据
				txjdSynResultDao.save(txjdSynResult);
			}
		}

		return txjdSynState;
	}

	@Override
	public TxjdSynState findById(String id) {
		// 实体查询
		TxjdSynState txjdSynState = txjdSynStateDao.findById(id);
		// 非空验证
		if (!ObjectUtils.equals(txjdSynState, null)) {
			// 新建查询条件
			TxjdSynResultQueryModel qm = new TxjdSynResultQueryModel();
			// 封装父级id
			qm.setId(txjdSynState.getId());
			// 列表查询
			List<TxjdSynResult> txjdSynResults = txjdSynResultDao.queryList(qm);
			// 封装数据
			txjdSynState.setTxjdSynResults(txjdSynResults);
		}
		return txjdSynState;
	}

	@Override
	public void delete(String id) {
		// 实体查询
		TxjdSynState txjdSynState = txjdSynStateDao.findById(id);
		// 非空验证
		if (!ObjectUtils.equals(txjdSynState, null)) {
			// 新建查询条件
			TxjdSynResultQueryModel qm = new TxjdSynResultQueryModel();
			// 封装父级id
			qm.setId(txjdSynState.getId());
			// 列表查询
			List<TxjdSynResult> txjdSynResults = txjdSynResultDao.queryList(qm);
			// 删除列表
			txjdSynResultDao.deleteList(txjdSynResults);
		}
		// 删除实体
		txjdSynStateDao.delete(txjdSynState);

	}

	@Override
	public TxjdSynState update(TxjdSynStateModel txjdSynResultModel,
			User operator) {
		// 实体查询
		TxjdSynState txjdSynState = txjdSynStateDao.findById(txjdSynResultModel
				.getId());
		// 巡检时间
		txjdSynState.setUpdateTime(DateUtilTools.getNowDateTime());
		// 巡检人
		txjdSynState.setUpdater(operator);
		// 非空验证
		if (CollectionUtils.isNotEmpty(txjdSynResultModel.getSerial())) {
			/**
			 * 先删除原数据
			 */
			// 新建查询条件
			TxjdSynResultQueryModel qm = new TxjdSynResultQueryModel();
			// 封装父级id
			qm.setId(txjdSynState.getId());
			// 列表查询
			List<TxjdSynResult> txjdSynResults = txjdSynResultDao.queryList(qm);
			// 删除列表
			txjdSynResultDao.deleteList(txjdSynResults);
			/**
			 * 添加子级新数据
			 */
			for (int i = 0; i < txjdSynResultModel.getSerial().size(); i++) {
				// 新的子数据
				TxjdSynResult txjdSynResult = new TxjdSynResult();
				// 封装父级实体
				txjdSynResult.setTxjdSynState(txjdSynState);
				// 封装巡检内容
				txjdSynResult.setEquipName(txjdSynResultModel.getEquipName()
						.get(i));
				// CU
				txjdSynResult.setCu(txjdSynResultModel.getCu().get(i));
				// CKT
				txjdSynResult.setCkt(txjdSynResultModel.getCkt().get(i));
				// DD
				txjdSynResult.setDd(txjdSynResultModel.getDd().get(i));
				// HG
				txjdSynResult.setHg(txjdSynResultModel.getHg().get(i));
				// HG
				txjdSynResult.setRoute(txjdSynResultModel.getRoute().get(i));
				// 添加数据
				txjdSynResultDao.save(txjdSynResult);
			}
		}
		return txjdSynState;
	}
}
