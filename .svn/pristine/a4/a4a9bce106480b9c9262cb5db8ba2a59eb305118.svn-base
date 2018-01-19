package cn.com.atnc.ioms.dao.duty.satellite.day.tes.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.duty.satellite.day.tes.ITxjdMainStateDao;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdMainState;
import cn.com.atnc.ioms.model.duty.statellite.day.SatelliteBaseQueryModel;

/**
 * 通信基地-TES-TES网管工作站主备状态DAO接口实现类
 *
 * @author 段衍林
 * @2017年2月17日 上午11:06:57
 */
@Repository("TxjdMainStateDao")
public class TxjdMainStateDaoImpl extends MyBaseDao<TxjdMainState> implements
		ITxjdMainStateDao {

	@Override
	public Pagination queryPage(SatelliteBaseQueryModel queryModel) {

		// 查询语句
		StringBuilder hql = new StringBuilder("from TxjdMainState a where 1=1 ");
		// 查询条件
		List<Object> params = new ArrayList<Object>();
		// 巡检内容
		if (!ObjectUtils.equals(queryModel.getContent(), null)) {
			hql.append(" and a.checkContent = ? ");
			params.add(queryModel.getContent());
		}
		// 查询操作人
		if (StringUtils.isNotEmpty(queryModel.getOperator())) {
			hql.append(" and a.creater.name like ? ");
			// 模糊查询
			params.add("%" + queryModel.getOperator() + "%");
		}
		// 查询审核人
		if (StringUtils.isNotEmpty(queryModel.getAuditer())) {
			hql.append(" and a.auditer.name like ? ");
			// 模糊查询
			params.add("%" + queryModel.getAuditer() + "%");
		}
		// 起始时间
		if (!ObjectUtils.equals(queryModel.getStartTime(), null)) {
			hql.append(" and a.createTime >= ? ");
			params.add(queryModel.getStartTime());
		}
		// 结束时间
		if (!ObjectUtils.equals(queryModel.getEndTime(), null)) {
			hql.append(" and a.createTime <= ? ");
			params.add(queryModel.getEndTime());
		}
		// 排序
		hql.append(" order by a.createTime desc ");
		// 分页数据
		String countHql = COUNT_ID + hql.toString();
		// 查询
		return super.pageQuery(hql.toString(), params.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

}
