package cn.com.atnc.ioms.dao.duty.satelliteauto.day.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.duty.satelliteauto.day.SatTxjdOverseaCDMDao;
import cn.com.atnc.ioms.entity.duty.satelliteauto.day.SatTxjdOverseaCdm;
import cn.com.atnc.ioms.model.duty.satelliteauto.SatelliteAutoModel;
/**
 * 通信基地-境外站-主站CDM570
 * 数据库接口实现类
 *
 * @author 段衍林
 * @2016年11月11日 下午4:03:48
 */
@Repository("satTxjdOverseaCdmDao")
public class SatTxjdOverseaCDMDaoImpl extends MyBaseDao<SatTxjdOverseaCdm> implements SatTxjdOverseaCDMDao{

	
	@Override
	public Pagination queryPageByModel(SatelliteAutoModel queryModel) {
		
		//封装数据查询语句
		StringBuilder hql = new StringBuilder(" from SatTxjdOverseaCdm a where 1=1 ");
		//封装查询条件
		Map<String, Object> params = new HashMap<String, Object>();
		//查询开始时间
	    if (!ObjectUtils.equals(queryModel.getStartTime(),null)) {
	    	hql.append(" and a.checkTime>=:beginTime");
	        params.put("beginTime",queryModel.getStartTime());
	    }
	    //查询结束时间
	    if (!ObjectUtils.equals(queryModel.getEndTime(),null)) {
	    	hql.append(" and a.checkTime<=:endTime");
	        params.put("endTime",queryModel.getEndTime());
	    }
	    //查询id
	    if (StringUtils.isNotEmpty(queryModel.getId())) {
	    	hql.append(" and a.id=:dataId");
	    	params.put("dataId",queryModel.getId());
	    }
	    //按巡检时间倒序排序
	    hql.append(" order by a.checkTime desc ");
		//分页数据
		String countHql = COUNT_ID + hql.toString();
		//查询
		return super.pageQuery(hql.toString(), params, countHql, queryModel.getPageNo(),
				queryModel.getPageSize());
	}
}
