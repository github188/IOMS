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
import cn.com.atnc.ioms.dao.operstat.atm.IAtmEquipDao;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.model.operstat.atm.AtmEquipDBModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * ATM设备统计Dao接口实现
 * @author：KuYonggang
 * @date：2014-6-17下午3:55:28
 * @version：1.0
 */
@Repository
public class AtmEquipDaoImpl extends MyBaseDao<AtmNode> implements IAtmEquipDao {

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IAtmEquipDao#queryListByParam(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * AtmEquipDaoImpl.java
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AtmEquipDBModel> queryListByParam(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("select new cn.com.atnc.ioms.model.operstat.atm.AtmEquipDBModel(bureau,count(*)) from AtmNode where 1=1 ");
		Object obj = null;
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getBureau())){
			hql.append("and localNode.bureau = ? ");
			obj = Bureau.getBureauByValue(queryModel.getBureau());
		}
		hql.append("group by bureau order by bureau");
		List<AtmEquipDBModel> list = new ArrayList<AtmEquipDBModel>();
		if(obj!=null){
			list = (List<AtmEquipDBModel>) this.queryList(hql.toString(), obj);
		}else {
			list = (List<AtmEquipDBModel>) this.queryList(hql.toString());
		}
		return list;
	}

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IAtmEquipDao#queryPageByParam(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * AtmEquipDaoImpl.java
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AtmNode> querylistByModel(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from AtmNode where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getBureau())){
			hql.append("and bureau = ? ");
			queryParams.add(Bureau.getBureauByValue(queryModel.getBureau()));
		}
		return  (List<AtmNode>)this.queryList(hql.toString(), queryParams.toArray());
	}

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IAtmEquipDao#queryDetailPageByParam(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * AtmEquipDaoImpl.java
	 */
	@Override
	public Pagination queryDetailPageByParam(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from CardRunInfo c where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		if(!StringUtils.isEmpty(queryModel.getNodeCode())){
			hql.append("and c.nodeCode = ? ");
			queryParams.add(queryModel.getNodeCode());
		}
		hql.append("and c.cardFbState <> 'Empty' ");
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return  super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

}
