package cn.com.atnc.ioms.dao.duty.satellite.day.tes.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.duty.satellite.day.tes.ITxjdSynResultDao;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdSynResult;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TxjdSynResultQueryModel;

/**
 * 通信基地-TES-查看网管同步状态子级数据库接口实现类
 *
 * @author 段衍林
 * @2017年2月13日 下午3:59:43
 */
@Repository("TxjdSynResultDao")
public class TxjdSynResultDaoImpl extends MyBaseDao<TxjdSynResult> implements
		ITxjdSynResultDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TxjdSynResult> queryList(TxjdSynResultQueryModel queryModel) {

		// 查询语句
		StringBuilder hql = new StringBuilder("from TxjdSynResult a where 1=1 ");
		// 查询条件
		List<Object> params = new ArrayList<Object>();
		// 查询操作人
		if (StringUtils.isNotEmpty(queryModel.getId())) {
			hql.append(" and a.txjdSynState.id = ? ");
			params.add(queryModel.getId());
		}
		// 排序
		hql.append(" order by a.serial ");
		// 查询
		return (List<TxjdSynResult>) super.queryList(hql.toString(),
				params.toArray());
	}
}
