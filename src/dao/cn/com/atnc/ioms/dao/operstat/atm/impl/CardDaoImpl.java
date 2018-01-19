/**
 * 
 */
package cn.com.atnc.ioms.dao.operstat.atm.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.operstat.atm.ICardDao;
import cn.com.atnc.ioms.entity.operstat.atm.Card;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * 板卡dao接口实现类
 * @author：KuYonggang
 * @date：2014-7-21下午1:39:17
 * @version：1.0
 */
@Repository
public class CardDaoImpl extends MyBaseDao<Card> implements ICardDao {

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.ICardDao#queryPageForCardDetail(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * CardDaoImpl.java
	 */
	@Override
	public Pagination queryPageForCardDetail(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from Card where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getId())){
			hql.append("and id = ? ");
			queryParams.add(queryModel.getId());
		}
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return  super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
		
	}

}
