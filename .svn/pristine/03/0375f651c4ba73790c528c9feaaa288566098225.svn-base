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
import cn.com.atnc.ioms.dao.operstat.atm.IEnvRuninfoDao;
import cn.com.atnc.ioms.entity.operstat.atm.NodeEnvRunInfo;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * 节点环境运行信息Dao接口实现
 * @author：KuYonggang
 * @date：2014-6-26上午11:49:25
 * @version：1.0
 */
@Repository
public class EnvRuninfoDaoImpl extends MyBaseDao<NodeEnvRunInfo> implements IEnvRuninfoDao {
	
	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IEnvRuninfoDao#queryPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * EnvRuninfoDaoImpl.java
	 */
	@Override
	public Pagination queryPageByModel(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from NodeEnvRunInfo where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//节点代码查询条件
		if(!StringUtils.isEmpty(queryModel.getNodeCode())){
            hql.append("and nodeCode = ? ");
			queryParams.add(queryModel.getNodeCode());
		}
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return  super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IEnvRuninfoDao#queryListByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * EnvRuninfoDaoImpl.java
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NodeEnvRunInfo> queryListByModel(
			NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from NodeEnvRunInfo where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//节点代码查询条件
		if(!StringUtils.isEmpty(queryModel.getNodeCode())){
            hql.append("and nodeCode = ? ");
			queryParams.add(queryModel.getNodeCode());
		}
		List<NodeEnvRunInfo> list = new ArrayList<NodeEnvRunInfo>();
		list = (List<NodeEnvRunInfo>) this.queryList(hql.toString(), queryParams.toArray());
		return list;
	}

}
