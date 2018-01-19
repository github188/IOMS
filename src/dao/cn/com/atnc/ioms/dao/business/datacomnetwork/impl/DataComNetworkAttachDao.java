package cn.com.atnc.ioms.dao.business.datacomnetwork.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.business.datacomnetwork.IDataComNetworkAttachDao;
import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetworkAttach;
import cn.com.atnc.ioms.enums.business.datacomnetwork.NetWorkAttachTypeEnum;


/**
 * 数据通信网申请附件信息Dao接口实现类
 *
 * @author Wang Zhicheng
 * @date 2015年10月15日 上午10:07:59
 * @since 1.0.0
 */
@Repository
public class DataComNetworkAttachDao extends MyBaseDao<DataComNetworkAttach> implements IDataComNetworkAttachDao {

	@Override
	public void delByDataComNetworkId(String id) {
		this.executeHql("delete from DataComNetworkAttach where dataComNetwork = ?", id);
	}

	@Override
	public List<DataComNetworkAttach> findByDCNId(String id) {
		return  super.findListByParam("dataComNetwork.id", id);
	}

	@Override
	public List<DataComNetworkAttach> findByDCNIdType(String id,
			NetWorkAttachTypeEnum type) {
		StringBuilder sb = new StringBuilder("from DataComNetworkAttach where 1=1");
		List<Object> params = new ArrayList<>();
		if(StringUtils.isNotEmpty(id)) {
			sb.append(" and dataComNetwork.id = ?");
			params.add(id);
		}
		if(!ObjectUtils.equals(type, null)) {
			sb.append(" and attachType = ?");
			params.add(type);
		}
		return (List<DataComNetworkAttach>) this.queryList(sb.toString(), params.toArray());
	}
}
