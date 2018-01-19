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
import cn.com.atnc.ioms.dao.operstat.atm.IAtmPortDao;
import cn.com.atnc.ioms.entity.operstat.atm.Ports;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.model.operstat.atm.AtmPortDBModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * Atm端口Dao接口实现类
 * @author：KuYonggang
 * @date：2014-6-20上午9:59:43
 * @version：1.0
 */
@Repository
public class AtmPortDaoImpl extends MyBaseDao<Ports> implements IAtmPortDao {

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IAtmPortDao#queryListByParam(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * AtmPortDaoImpl.java
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AtmPortDBModel> queryListByParam(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("select new cn.com.atnc.ioms.model.operstat.atm.AtmPortDBModel(node,cardType,count(*)) from Ports where 1=1 ");
		Object obj = null;
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getBureau())){
			hql.append("and node.bureau = ? ");
			obj = Bureau.getBureauByValue(queryModel.getBureau());
		}
		hql.append("group by node,cardType order by node");
		List<AtmPortDBModel> list = new ArrayList<AtmPortDBModel>();
		list = (List<AtmPortDBModel>) this.queryList(hql.toString(), obj);
		return list;
	}

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IAtmPortDao#queryPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * AtmPortDaoImpl.java
	 */
	@Override
	public Pagination queryPageByModel(NetworkStatQueryModel queryModel) {
		
		StringBuffer hql = new StringBuffer();
		StringBuffer countHql = new StringBuffer();
		countHql.append("from Ports where 1=1 ");
		hql.append("select new cn.com.atnc.ioms.model.operstat.atm.AtmPortDBModel(node.bureau,cardType,count(id)) from Ports where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getBureau())){
            hql.append("and node.bureau = ? ");
			countHql.append("and node.bureau = ? ");
			queryParams.add(Bureau.getBureauByValue(queryModel.getBureau()));
		}
		hql.append("group by node.bureau,cardType order by node.bureau");
		countHql.append("group by node.bureau,cardType order by node.bureau");
		String countHqlStr = BaseDaoHibernateImpl.COUNT_ID + countHql.toString();
		return  super.pageQuery(hql.toString(), queryParams.toArray(), countHqlStr,
				queryModel.getPageNo(), queryModel.getPageSize());

	}

}
