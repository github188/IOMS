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
import cn.com.atnc.ioms.dao.operstat.atm.IPortAXSMDao;
import cn.com.atnc.ioms.entity.operstat.atm.PortAXSM;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.operstat.atm.EnumCollections.CardType;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * Atm端口详情Dao接口实现
 * @author：KuYonggang
 * @date：2014-6-20下午3:07:47
 * @version：1.0
 */
@Service
public class PortAXSMDaoImpl extends MyBaseDao<PortAXSM> implements IPortAXSMDao {

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IPortAXSMDao#queryPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * PortAXSMDaoImpl.java
	 */
	@Override
	public Pagination queryAXSMPageByModel(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from PortAXSM where 1=1 ");
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

}
