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
import cn.com.atnc.ioms.dao.operstat.atm.IPnniLnsPxm155Dao;
import cn.com.atnc.ioms.entity.operstat.atm.PnniLnsPxm155;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.operstat.atm.EnumCollections.LnsType;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * Atm端口详情Dao接口实现
 * @author：KuYonggang
 * @date：2014-6-20下午3:07:47
 * @version：1.0
 */
@Service
public class PnniLnsPxm155DaoImpl extends MyBaseDao<PnniLnsPxm155> implements IPnniLnsPxm155Dao {

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IPnniLnsDao#queryPnniLnsPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * PnniLnsDaoImpl.java
	 */
	@Override
	public Pagination queryPnniLnsPxm155PageByModel(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from PnniLnsPxm155 where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getBureau())){
            hql.append("and pnniLns.node.bureau = ? ");
			queryParams.add(Bureau.getBureauByValue(queryModel.getBureau()));
		}
		//节点代码查询条件
		if(!StringUtils.isEmpty(queryModel.getNodeCode())){
            hql.append("and pnniLns.node.atmNodeCode like ? escape '\\' ");
			queryParams.add("%"+queryModel.getNodeCode()+"%");
		}
		//端口详细类型
		if(!StringUtils.isEmpty(queryModel.getPortType())){
            hql.append("and pnniLns.typeDetail = ? ");
			queryParams.add(queryModel.getPortType());
		}
		//端口类型
		if(!StringUtils.isEmpty(queryModel.getPnniLnsType())){
            hql.append("and pnniLns.type = ? ");
			queryParams.add(LnsType.getLnsTypeByValue(queryModel.getPnniLnsType()));
		}
		hql.append("order by use desc");
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return  super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

}
