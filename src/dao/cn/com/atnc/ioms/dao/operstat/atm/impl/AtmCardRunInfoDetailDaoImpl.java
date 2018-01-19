/**
 * 
 */
package cn.com.atnc.ioms.dao.operstat.atm.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.operstat.atm.IAtmCardRunInfoDetailDao;
import cn.com.atnc.ioms.entity.operstat.atm.CardRunInfoDetail;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * ATM板卡运行信息详情Dao接口实现
 * @author：KuYonggang
 * @date：2014-8-23下午5:16:34
 * @version：1.0
 */
@Repository("atmCardRunInfoDetail")
public class AtmCardRunInfoDetailDaoImpl extends MyBaseDao<CardRunInfoDetail>
		implements IAtmCardRunInfoDetailDao {

	/**
	 * @see cn.com.atnc.pcsp.dao.operstat.atm.IAtmCardRunInfoDetailDao#queryPage(cn.com.atnc.pcsp.model.operstat.atm.CardRunInfoQueryModel)
	 * AtmCardRunInfoDetailDaoImpl.java
	 */
	@Override
	public Pagination queryPage(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from CardRunInfoDetail where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		if(!StringUtils.isEmpty(queryModel.getCardId())){
			hql.append(" and card.id = ?");
			queryParams.add(queryModel.getCardId());
		}
		if(BooleanUtils.isTrue(queryModel.getAlarmFlag())){
			hql.append(" and isAlarm = ?");
			queryParams.add(queryModel.getAlarmFlag());
		}
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return  super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

}
