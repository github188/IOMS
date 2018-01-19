package cn.com.atnc.ioms.dao.business.transfernet.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.business.transfernet.ITransferNetAttachDao;
import cn.com.atnc.ioms.entity.business.transfernet.TransferNetAttach;
import cn.com.atnc.ioms.enums.business.transfernet.TransferAttachTypeEnum;

/**
 * 自动转报网申请附件信息Dao接口实现类
 *
 * @author Wang Zhicheng
 * @date 2015年10月15日 上午10:07:59
 * @since 1.0.0
 */
@Repository
public class TransferNetAttachDao extends MyBaseDao<TransferNetAttach> implements ITransferNetAttachDao {

	@Override
	public void delByTransferNetId(String id) {
		this.executeHql("delete from TransferNetAttach where transferNet.id = ?", id);
	}

	@Override
	public List<TransferNetAttach> findByTNId(String id) {
		return  super.findListByParam("transferNet.id", id);
	}

	@Override
	public List<TransferNetAttach> findByTNIdType(String id,
			TransferAttachTypeEnum type) {
		StringBuilder sb = new StringBuilder("from TransferNetAttach where 1=1");
		List<Object> params = new ArrayList<>();
		if(StringUtils.isNotEmpty(id)) {
			sb.append(" and transferNet.id = ?");
			params.add(id);
		}
		if(!ObjectUtils.equals(type, null)) {
			sb.append(" and attachType = ?");
			params.add(type);
		}
		return (List<TransferNetAttach>) this.queryList(sb.toString(), params.toArray());
	}
}
