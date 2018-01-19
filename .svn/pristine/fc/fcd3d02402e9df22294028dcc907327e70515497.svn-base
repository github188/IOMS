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
import cn.com.atnc.ioms.dao.operstat.atm.ICardRuninfoDao;
import cn.com.atnc.ioms.entity.operstat.atm.CardRunInfo;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * 板卡运行信息Dao接口实现
 * 
 * @author：KuYonggang
 * @date：2014-5-27下午4:52:40
 * @version：1.0
 */
@Repository
public class CardRuninfoDaoImpl extends MyBaseDao<CardRunInfo> implements ICardRuninfoDao {

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.ICardRuninfoDao#queryPageForCard(java.lang.String)
	 * CardRuninfoDaoImpl.java
	 */
	@Override
	public Pagination queryPageForCard(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from CardRunInfo where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getNodeCode())){
			hql.append("and nodeCode = ? ");
			queryParams.add(queryModel.getNodeCode());
		}
		hql.append("and cardFbState <> 'Empty' ");
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return  super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
		
	}

}
