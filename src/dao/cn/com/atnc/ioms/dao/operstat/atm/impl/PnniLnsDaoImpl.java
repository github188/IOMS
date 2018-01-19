/**
 * 
 */
package cn.com.atnc.ioms.dao.operstat.atm.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.operstat.atm.IPnniLnsDao;
import cn.com.atnc.ioms.entity.operstat.atm.PnniLns;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.operstat.atm.EnumCollections.CardType;
import cn.com.atnc.ioms.model.operstat.atm.AtmPnniDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmPnniDetailDBModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * Atm端口详情Dao接口实现
 * @author：KuYonggang
 * @date：2014-6-20下午3:07:47
 * @version：1.0
 */
@Service
public class PnniLnsDaoImpl extends MyBaseDao<PnniLns> implements IPnniLnsDao {

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IPnniLnsDao#queryPnniLnsPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * PnniLnsDaoImpl.java
	 */
	@Override
	public Pagination queryPnniLnsPageByModel(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from PnniLns where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getBureau())){
            hql.append("and port.node.bureau = ? ");
			queryParams.add(Bureau.getBureauByValue(queryModel.getBureau()));
		}
		//节点代码查询条件
		if(!StringUtils.isEmpty(queryModel.getNodeCode())){
            hql.append("and port.node.atmNodeCode = ? ");
			queryParams.add(queryModel.getNodeCode());
		}
		//端口类型
		if(!StringUtils.isEmpty(queryModel.getPortType())){
            hql.append("and port.cardType = ? ");
			queryParams.add(CardType.getCardTypeByValue(queryModel.getPortType()));
		}
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return  super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IPnniLnsDao#queryPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * PnniLnsDaoImpl.java
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AtmPnniDBModel> queryPageByModel(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("select new cn.com.atnc.ioms.model.operstat.atm.AtmPnniDBModel(node.bureau,type,count(id)) from PnniLns where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getBureau())){
            hql.append("and node.bureau = ? ");
			queryParams.add(Bureau.getBureauByValue(queryModel.getBureau()));
		}
		hql.append("group by node.bureau,type order by node.bureau");
		
		return (List<AtmPnniDBModel>) this.queryList(hql.toString(), queryParams.toArray());
	}

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IPnniLnsDao#queryAtmPnniDetailListByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * PnniLnsDaoImpl.java
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AtmPnniDetailDBModel> queryAtmPnniDetailListByModel(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("select new cn.com.atnc.ioms.model.operstat.atm.AtmPnniDetailDBModel(t.node.bureau,t.typeDetail,count(id),(select count(id) from PnniLns h where h.node.bureau=t.node.bureau and h.typeDetail=t.typeDetail and h.use=true group by h.node.bureau,h.typeDetail)) " +
				"from PnniLns t where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getBureau())){
            hql.append("and t.node.bureau = ? ");
			queryParams.add(Bureau.getBureauByValue(queryModel.getBureau()));
		}
		//节点代码查询条件
		if(!StringUtils.isEmpty(queryModel.getNodeCode())){
            hql.append("and pnniLns.node.atmNodeCode = ? ");
			queryParams.add(queryModel.getNodeCode());
		}
		hql.append("group by t.node.bureau,t.typeDetail order by t.node.bureau");
		
		return (List<AtmPnniDetailDBModel>) this.queryList(hql.toString(), queryParams.toArray());
	}
}
