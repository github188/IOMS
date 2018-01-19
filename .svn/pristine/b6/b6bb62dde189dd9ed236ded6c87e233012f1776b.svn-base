package cn.com.atnc.ioms.dao.duty.satellitemqy.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satellitemqy.InfoDao;
import cn.com.atnc.ioms.entity.duty.satellite.Info;
import cn.com.atnc.ioms.model.duty.satelliteinfo.SatelliteInfoQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;

/**
 * 卫星备件信息库 数据库接口实现类
 *
 * @author 段衍林
 * @2016年11月29日 上午8:35:27
 */
@Repository("InfoDao")
public class InfoDaoImpl extends MyBaseDao<Info> implements InfoDao {
	@Override
	public Pagination queryPageByModel(SatelliteInfoQueryModel queryModel) {

		// 封装数据查询语句
		StringBuilder hql = new StringBuilder(" from Info a where 1=1 ");
		// 封装查询条件
		Map<String, Object> params = new HashMap<String, Object>();
		// 查询开始时间
		if (!ObjectUtils.equals(queryModel.getStartTime(), null)) {
			hql.append(" and a.checkTime>=:beginTime");
			params.put("beginTime", queryModel.getStartTime());
		}
		// 查询结束时间
		if (!ObjectUtils.equals(queryModel.getEndTime(), null)) {
			hql.append(" and a.checkTime<=:endTime");
			params.put("endTime", queryModel.getEndTime());
		}
		// 查询id
		if (StringUtils.isNotEmpty(queryModel.getId())) {
			hql.append(" and a.id=:dataId");
			params.put("dataId", queryModel.getId());
		}
		// sn编号
		if (StringUtils.isNotEmpty(queryModel.getSn())) {
			hql.append(" and a.sn=:sn");
			params.put("sn", queryModel.getSn());
		}
		// 查询设备名称
		if (StringUtils.isNotEmpty(queryModel.getEquipName())) {
			hql.append(" and a.equipName like:equipName");
			params.put("equipName", "%" + queryModel.getEquipName() + "%");
		}
		// 查询操作人
		if (StringUtils.isNotEmpty(queryModel.getOperator())) {
			hql.append(" and a.operator.name like:operator");
			params.put("operator", "%" + queryModel.getOperator() + "%");
		}
		// 按巡检时间倒序排序
		hql.append(" order by a.checkTime desc ");
		// 分页数据
		String countHql = COUNT_ID + hql.toString();
		// 查询
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}
}
