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
import cn.com.atnc.ioms.dao.operstat.atm.IAtmBandDao;
import cn.com.atnc.ioms.entity.operstat.atm.PnniBandwidth;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.model.operstat.atm.AtmBandDBModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * Atm网带宽统计Dao实现类
 * @author：KuYonggang
 * @date：2014-6-20下午1:25:03
 * @version：1.0
 */
@Repository
public class AtmBandDaoImpl extends MyBaseDao<PnniBandwidth> implements IAtmBandDao {

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IAtmBandDao#queryPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * AtmBandDaoImpl.java
	 */
	@Override
	public Pagination queryPageByModel(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from PnniBandwidth where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getBureau())){
            hql.append("and node.bureau = ? ");
			queryParams.add(Bureau.getBureauByValue(queryModel.getBureau()));
		}
		//本地节点代码查询条件
		if(!StringUtils.isEmpty(queryModel.getLocalNodeCode())){
			hql.append("and pnniLocalNodeName like ? escape '\\' ");
			queryParams.add("%" + queryModel.getLocalNodeCode() + "%");
		}
		//远端节点代码查询条件
		if(!StringUtils.isEmpty(queryModel.getRemoteNodeCode())){
			hql.append("and pnniRemoteNodeName like ? escape '\\' ");
			queryParams.add("%" + queryModel.getRemoteNodeCode() + "%");
		}
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		hql.append(" order by pnniLocalNodeName asc,pnniLocalPortid asc");
		return  super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IAtmBandDao#queryListByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * AtmBandDaoImpl.java
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AtmBandDBModel> queryListByModel(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("select new cn.com.atnc.ioms.model.operstat.atm.AtmBandDBModel(node.bureau,max(pnniMax),sum(pnniAvlCps),sum(pnniAvlKbps)) from PnniBandwidth where 1=1 ");
		hql.append("group by node.bureau");
		List<AtmBandDBModel> list = new ArrayList<AtmBandDBModel>();
		list = (List<AtmBandDBModel>) this.queryList(hql.toString());
		return list;
	}

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IAtmBandDao#queryPageForBandWidth(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * AtmBandDaoImpl.java
	 */
	@Override
	public Pagination queryPageForBandWidth(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from PnniBandwidth where 1=1 ");
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
