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
import cn.com.atnc.ioms.dao.operstat.atm.IPnniLinkDao;
import cn.com.atnc.ioms.entity.operstat.atm.PnniLink;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 *  中继线路“连通性”Dao接口实现
 * @author：KuYonggang
 * @date：2014-6-23下午1:31:14
 * @version：1.0
 */
@Repository
public class PnniLinkDaoImpl extends MyBaseDao<PnniLink> implements IPnniLinkDao {

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IPnniLinkDao#queryPageForRelay(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * PnniLinkDaoImpl.java
	 */
	@Override
	public Pagination queryPageForRelay(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from PnniLink where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getNodeCode())){
            hql.append("and node.atmNodeCode = ? ");
			queryParams.add(queryModel.getNodeCode());
		}
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return  super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

}
